package DDT;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Fetching_Data_From_Excel_Using_Data_Formatter {

	public static void main(String[] args) throws Throwable {
		
	 // Step 1 : Path Connection	
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\OneDrive\\Documents\\Book2.xlsx");
		
     // Step 2 : Open Workbook in read mode
		Workbook book = WorkbookFactory.create(fis);
		
     // Step 3 : get the control of the sheet
		Sheet sheet = book.getSheet("Sheet1");
		
     // Step 4 : get the control of the row
		Row row = sheet.getRow(3);
		
     // Step 5 : get the control of the cell	
		Cell cell = row.getCell(3);
		
	//	String ExcelData = cell.getStringCellValue();
	//	System.out.println(ExcelData);
		
		DataFormatter format = new DataFormatter();
        String ExcelData = format.formatCellValue(cell);
        System.out.println(ExcelData);
	}

}