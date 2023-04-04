package genericUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ExcelFile {
	public String getExcelData(String sheetName,int rowNum,int cellNum)throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		//String data = cell.getStringCellValue();
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(cell);
		return data;
	}

}
