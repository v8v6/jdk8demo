package com.sc.cd.excel.merge;

import com.alibaba.excel.EasyExcel;
import com.sc.cd.excel.util.TestFileUtil;

import java.util.ArrayList;
import java.util.List;

public class FeedRecordTestData {

    public static void main(String[] args) {
        List<FeedRecord> testDatas = getTestData();

        // 方法1 注解
        String fileName = TestFileUtil.getPath() + "饲喂记录" + System.currentTimeMillis() + ".xlsx";
        // 在DemoStyleData里面加上ContentLoopMerge注解
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, FeedRecord.class)
                .registerWriteHandler(new CustomMergeStrategy(testDatas))
                .sheet("模板").doWrite(testDatas);

    }


    public static List<FeedRecord> getTestData() {
        List<FeedRecord> testData = new ArrayList<>();

        // 添加示例数据
        testData.add(new FeedRecord("华北纵队", "鲁东战区", "烟台新好农牧有限公司", "H崖地十二线",
                "F2314崖地十二线323040303H", "2024-03-21", 1205, 373, "006", 150, 150, 0,
                "2024-03-20 15:15~2024-03-21 15:15", "自动饲喂成功", "-"));
        testData.add(new FeedRecord("华北纵队", "鲁东战区", "烟台新好农牧有限公司", "H崖地十二线",
                "F2314崖地十二线323040303H", "2024-03-20", 1205, 372, "005", 182, 40, -360,
                "2024-03-19 15:15~2024-03-20 15:15", "自动饲喂成功", "-"));
        testData.add(new FeedRecord("华北纵队", "鲁东战区", "烟台新好农牧有限公司", "H崖地十二线",
                "F2314崖地十二线323040303H", "2024-03-20", 1205, 372, "006", 218, 40, -360,
                "2024-03-19 15:15~2024-03-20 15:15", "自动饲喂成功", "-"));
        testData.add(new FeedRecord("华北纵队", "鲁东战区", "烟台新好农牧有限公司", "H崖地十二线",
                "F2314崖地十二线323040303H", "2024-03-29", 1205, 371, "006", 150, 8, -142,
                "2024-03-18 14:10~2024-03-19 14:10", "自动饲喂成功", "-"));

        return testData;
    }
}
