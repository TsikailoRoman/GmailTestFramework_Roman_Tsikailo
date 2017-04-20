package com.epam.util;


import com.epam.model.Message;
import com.epam.model.User;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;


public class ExcelManager {

    private static XSSFSheet excelSheet;

    /**
     * Defines Excel file to be read. Sets the file path and opens the
     * Excel file. Not thread safe.
     *
     * @param sheetNo number of the specific sheet in Excel file.
     * @param path    pth to the file(your Cap).
     */
    public static void setExcelReading(String path, int sheetNo) {
        try {
            FileInputStream excelFile = new FileInputStream(new File(path));

            XSSFWorkbook excelWBook = new XSSFWorkbook(excelFile);
            excelSheet = excelWBook.getSheetAt(sheetNo);
        } catch (IOException e) {
            LoggerManager.log(e.getMessage());
        }
    }

    /**
     * Returns a two dimensioned array of Objects ({@code User} class in this
     * particular case) from pre-defined Excel document.
     *
     * @return resulting array.
     */
    public static Object[][] getTableData() {
        Object[][] tabArray = new Object[excelSheet.getPhysicalNumberOfRows() - 1][1];

        for (int i = 0; i < tabArray.length; i++)
            tabArray[i][0] = createUser(i + 1);
        return tabArray;
    }

    /**
     * Returns data from the specific cell in Excel  document.
     *
     * @param rowNum row number to be looked up.
     * @param colNum column number to be looked up.
     * @return {@code String} string data
     */
    private static String getCellData(int rowNum, int colNum, XSSFSheet sheet) {
        XSSFCell cell = sheet.getRow(rowNum).getCell(colNum);
        return cell.getStringCellValue();
    }

    /**
     * Instantiates and returns a {@code User} object from Excel document.
     *
     * @param rowNo row number to be looked up.
     * @return {@code User} user instance.
     */
    private static User createUser(int rowNo) {
        return new User(getCellData(rowNo, 0, excelSheet)
                , getCellData(rowNo, 1, excelSheet),
                new Message(getCellData(rowNo, 2, excelSheet),
                        getCellData(rowNo, 3, excelSheet)));
    }
}
