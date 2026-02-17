package Utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ExcelUtils(String excelPath) {
        try {
            FileInputStream fis = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet("Sheet1"); // correct usage
        } catch (Exception e) {
            System.out.println("❌ ERROR Opening Excel: " + excelPath);
            e.printStackTrace();
        }
    }

    public String getCellData(int rowNum, int colNum) {
        try {
            XSSFRow row = sheet.getRow(rowNum);
            if (row == null) return "";

            XSSFCell cell = row.getCell(colNum);
            if (cell == null) return "";

            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
