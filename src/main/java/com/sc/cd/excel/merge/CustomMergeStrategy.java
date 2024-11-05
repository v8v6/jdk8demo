package com.sc.cd.excel.merge;

import com.alibaba.excel.write.handler.RowWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.List;

public class CustomMergeStrategy implements RowWriteHandler {

    private List<FeedRecord> feedRecords;

    public CustomMergeStrategy() {

    }

    public CustomMergeStrategy(List<FeedRecord> feedRecords) {
        this.feedRecords = feedRecords;
    }

    @Override
    public void afterRowDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Integer relativeRowIndex, Boolean isHead) {
        Sheet sheet = writeSheetHolder.getSheet();

        // 1、当前行 是head,skip
        if (row.getRowNum() < 1) {
            return;
        }

        // 2、当前行的前一行 字段都相同,则跳过
        FeedRecord rowFeedRecord = feedRecords.get(row.getRowNum() - 1);
        String rowUniqueKey = rowFeedRecord.getCompany()
                + "&" + rowFeedRecord.getLine()
                + "&" + rowFeedRecord.getFeedingDate()
                + "&" + rowFeedRecord.getBatch();

        if (row.getRowNum() >= 2) {
            FeedRecord previousRowFeedRecord = feedRecords.get(row.getRowNum() - 2);
            String previousRowUniqueKey = previousRowFeedRecord.getCompany()
                    + "&" + previousRowFeedRecord.getLine()
                    + "&" + previousRowFeedRecord.getFeedingDate()
                    + "&" + previousRowFeedRecord.getBatch();
            if (previousRowUniqueKey.equals(rowUniqueKey)) {
                return;
            }
        }

        // 3、找到跟当前行相同的所有行
        int sameRowIndex = row.getRowNum();
        for (int i = row.getRowNum(); i < feedRecords.size(); i++) {
            // 获取当前行对象
            FeedRecord currentRowFeedRecord = feedRecords.get(i);
            String currentRowUniqueKey = currentRowFeedRecord.getCompany()
                    + "&" + currentRowFeedRecord.getLine()
                    + "&" + currentRowFeedRecord.getFeedingDate()
                    + "&" + currentRowFeedRecord.getBatch();
            if (!currentRowUniqueKey.equals(rowUniqueKey)) {
                break;
            }

            sameRowIndex++;
        }

        // 4、合并实际投料量、投料偏差
        if (row.getRowNum() != sameRowIndex) {
            CellRangeAddress actualFeedingAmountCellRangeAddress = new CellRangeAddress(row.getRowNum(), sameRowIndex, 10, 10);
            CellRangeAddress feedingDeviationCellRangeAddress = new CellRangeAddress(row.getRowNum(), sameRowIndex, 11, 11);
            sheet.addMergedRegionUnsafe(actualFeedingAmountCellRangeAddress);
            sheet.addMergedRegionUnsafe(feedingDeviationCellRangeAddress);

            // 5、设置合并后单元格的样式
            // 实际投料量
            row.getCell(10).getCellStyle()
                    .setVerticalAlignment(VerticalAlignment.CENTER);
            // 投料偏差
            row.getCell(11).getCellStyle()
                    .setVerticalAlignment(VerticalAlignment.CENTER);
        }
    }
}
