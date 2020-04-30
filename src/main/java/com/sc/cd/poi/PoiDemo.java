package com.sc.cd.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PoiDemo {

    public static void main(String[] args) {
        try {
            String filePath = "/Users/junxchen/Downloads/任务导入模板.xlsx";
            String picStorePath = "D:\\excel\\";

            File file = new File(filePath);
            String fileName = file.getName();
            FileInputStream fileInputStream = new FileInputStream(file);
            importExcelWithImage(fileInputStream, fileName, picStorePath);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    public static void importExcelWithImage(InputStream in, String fileName, String picStorePath) throws IOException {
        Workbook wookbook;
        Sheet sheet;
        //图片数据
        Map<String, PictureData> pictureDataMap = null;

        //得到工作簿
        try {
            if (fileName.endsWith(".xls")) {
                //2003版本的excel，用.xls结尾
                wookbook = new HSSFWorkbook(in);
            } else {
                //2007版本的excel，用.xlsx结尾
                wookbook = new XSSFWorkbook(in);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // ----- 获取图片数据 -----
        sheet = wookbook.getSheetAt(0);
        // 判断用07还是03的方法获取图片
        if (fileName.endsWith(".xls")) {
            pictureDataMap = getXlsPictures((HSSFSheet) sheet);
        } else {
            pictureDataMap = getXlsxPictures((XSSFSheet) sheet);
        }

        // ----- 获得标题 -----
        Row rowHead = sheet.getRow(0);
        int rowHeadPhysicalNumberOfCells = rowHead.getPhysicalNumberOfCells();
        for (int i = 0; i < rowHeadPhysicalNumberOfCells; i++) {
            Cell cell = rowHead.getCell(i);
            System.out.println(cell.getStringCellValue());
        }

        // ----- 获取其他数据 -----
        int totalRowNum = sheet.getLastRowNum();
        for (int i = 1; i <= totalRowNum; i++) {
            Row row = sheet.getRow(i);
            int physicalNumberOfCells = row.getPhysicalNumberOfCells();
            for (int j = 0; j < physicalNumberOfCells; j++) {
                Cell cell = row.getCell(j);
                System.out.println(cell.getStringCellValue());
            }
        }

        // ----- 输出图片 -----
        try {
            printImg(pictureDataMap, picStorePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取图片和位置 (xls)
     *
     * @param sheet
     * @return
     * @throws IOException
     */
    public static Map<String, PictureData> getXlsPictures(HSSFSheet sheet) throws IOException {
        Map<String, PictureData> map = new HashMap<>();
        List<HSSFShape> list = sheet.getDrawingPatriarch().getChildren();
        for (HSSFShape shape : list) {
            if (shape instanceof HSSFPicture) {
                HSSFPicture picture = (HSSFPicture) shape;
                HSSFClientAnchor cAnchor = (HSSFClientAnchor) picture.getAnchor();
                PictureData pdata = picture.getPictureData();
                // 行号-列号
                String key = cAnchor.getRow1() + "-" + cAnchor.getCol1();
                map.put(key, pdata);
            }
        }
        return map;
    }

    /**
     * 获取图片和位置 (xlsx)
     *
     * @param sheet
     * @return
     * @throws IOException
     */
    public static Map<String, PictureData> getXlsxPictures(XSSFSheet sheet) throws IOException {
        Map<String, PictureData> map = new HashMap<>();
        List<POIXMLDocumentPart> list = sheet.getRelations();
        for (POIXMLDocumentPart part : list) {
            if (part instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) part;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    XSSFPicture picture = (XSSFPicture) shape;
                    XSSFClientAnchor anchor = picture.getPreferredSize();
                    CTMarker marker = anchor.getFrom();
                    String key = marker.getRow() + "-" + marker.getCol();
                    log.error("point:{}",key);
                    map.put(key, picture.getPictureData());
                }
            }
        }
        return map;
    }

    public static void printImg(Map<String, PictureData> sheetList, String path) throws IOException {
        Object[] key = sheetList.keySet().toArray();
        for (int i = 0; i < sheetList.size(); i++) {
            // 获取图片流
            PictureData pic = sheetList.get(key[i]);
            // 获取图片索引
            String picName = key[i].toString();
            // 获取图片格式
            String ext = pic.suggestFileExtension();

            byte[] data = pic.getData();

            //图片保存路径
            String imgPath = path + picName + "." + ext;
            FileOutputStream out = new FileOutputStream(imgPath);
            System.out.println(imgPath);
            out.write(data);
            out.close();
        }
    }
}
