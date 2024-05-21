package ConfigReader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

    public String personname;
    public String mailid;
    public String Gender;

    int RowCount;
    int i;

    public ExcelReader() {


        try (FileInputStream file = new FileInputStream("C:\\Users\\DELL\\Sai\\FormsTesting\\src\\test\\resources\\Excel\\datatablevalues.xlsx")) {
            Workbook workbook = new XSSFWorkbook(file); // Load Excel file
            Sheet sheet = workbook.getSheet("UserDetails"); // Access the sheet containing data

            RowCount = sheet.getLastRowNum() + 1;


            Iterator<Row> iterator = sheet.iterator();
            iterator.next(); // Skip header row

            for (i = 1; i < RowCount; i++) {

                Row currentRow = iterator.next();

                personname = currentRow.getCell(0).getStringCellValue(); // Assuming username is in column 0
                mailid = currentRow.getCell(1).getStringCellValue(); // Assuming password is in column 1
                Gender = currentRow.getCell(2).getStringCellValue();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static int totalRow;

    public List<Map<String, String>> getData(String excelFilePath, String sheetName)
            throws InvalidFormatException, IOException {

        Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
        Sheet sheet = workbook.getSheet(sheetName);
        workbook.close();
        return readSheet(sheet);
    }

    private List<Map<String, String>> readSheet(Sheet sheet) {

        Row row;
        Cell cell;

        totalRow = sheet.getLastRowNum();

        List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();

        for (int currentRow = 1; currentRow <= totalRow; currentRow++) {

            row = sheet.getRow(currentRow);

            int totalColumn = row.getLastCellNum();

            LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();

            for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {

                cell = row.getCell(currentColumn);

                String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
                        .getStringCellValue();

                columnMapdata.put(columnHeaderName, cell.getStringCellValue());
            }

            excelRows.add(columnMapdata);
        }

        return excelRows;
    }

    public int countRow() {

        return totalRow;
    }

}
