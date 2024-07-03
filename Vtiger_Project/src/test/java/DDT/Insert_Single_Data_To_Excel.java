	package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Insert_Single_Data_To_Excel {

	public static void main(String[] args) throws Throwable {
		
	 // Step 1 : Path Connection	
		FileInputStream fis = new FileInputStream("./src/test/resources/Book2.xlsx");
		
	 // Step 2 : Open Workbook in read mode
		Workbook book = WorkbookFactory.create(fis);
			
     // Step 3 : get the control of the sheet
		Sheet sheet = book.getSheet("Sheet1");
			
   	 // Step 4 : get the control of the row		
	    Row row = sheet.createRow(6);
	
	 // Step 5 : get the control of the cell  
	    Cell cell = row.createCell(6);
	    
	    cell.setCellValue("Welcome");
	
    	FileOutputStream fos = new FileOutputStream("./src/test/resources/Book2.xlsx");
        book.write(fos);
        book.close();
	}

}
