package com.sc.cd.poi;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIClac {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("/Users/junxchen/Desktop/demo.xlsx");
        Workbook wb = new XSSFWorkbook(fis);

        //FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
        //FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell0 = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
        cell0.setCellValue(1);
        Cell cell1 = row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
        cell1.setCellValue(2);
        Cell cell2 = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
        //evaluator.evaluateFormulaCell(cell2);
        ///ellValue cellValue = evaluator.evaluate(cell2);
        //System.out.println(cellValue.getNumberValue());
        //XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
        wb.getCreationHelper().createFormulaEvaluator().evaluateAll();
        System.out.println(cell2.getNumericCellValue());
    }
}
