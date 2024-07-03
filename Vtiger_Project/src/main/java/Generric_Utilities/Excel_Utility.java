package Generric_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.record.chart.DataFormatRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	/**
	 * this method is used to read data from excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author hp
	 */
	
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable {
		
	 // Step 1 : Path Connection	
		FileInputStream fis2 = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Vtiger_Project\\src\\test\\resources\\ExcelSheet01.xlsx");
		
	 // Step 2 : Open Workbook in read mode
		Workbook book = WorkbookFactory.create(fis2);
		
	 // Step 3 : get the control of the sheet
		Sheet sheet = book.getSheet(sheetName);
		
	 // Step 4 : get the control of the row
		Row row1 = sheet.getRow(rowNum);
		
	 // Step 5 : get the control of the cell	
		Cell cell1 = row1.getCell(cellNum);
		
		String ExcelData = cell1.getStringCellValue();
		return ExcelData;		
	}
	
	/**
	 * this method is used to read data from excel using DataFormatter approach
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author hp
	 */
	
	
	public String readExcelDataUsingDataFormatter(String sheetName,int rowNum,int cellNum) throws Throwable {
		
	 // Step 1 : Path Connection	
		FileInputStream fis2 = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Vtiger_Project\\src\\test\\resources\\ExcelSheet01.xlsx");
		
	 // Step 2 : Open Workbook in read mode
		Workbook book = WorkbookFactory.create(fis2);
		
	 // Step 3 : get the control of the sheet
		Sheet sheet = book.getSheet(sheetName);
		
	 // Step 4 : get the control of the row
		Row row1 = sheet.getRow(rowNum);
		
	 // Step 5 : get the control of the cell	
		Cell cell1 = row1.getCell(cellNum);
		
		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cell1);
		return ExcelData;
				
    }

	/**
	 * This method is used to write data to excel
	 * @param sheet1
	 * @param rowNum
	 * @param cellNum
	 * @throws Throwable
	 * @author hp
	 */
	
	public String insertDataToExcel(String sheetName,int rowNum,int cellNum,String data) throws Throwable {
		
    // Step 1 : Path Connection		
	   FileInputStream fis = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Vtiger_Project\\src\\test\\resources\\ExcelSheet01.xlsx");
		
    // Step 2 : Open Workbook in read mode 
	   Workbook book = WorkbookFactory.create(fis);
			
    // Step 3 : get the control of the sheet
	   Sheet sheet = book.getSheet(sheetName);
		
    // Step 4 : get the control of the row   
	    Row row = sheet.createRow(rowNum);
	
     // Step 5 : get the control of the cell
	    Cell cell = row.createCell(cellNum);
	    
	    cell.setCellValue(data);
	
    	FileOutputStream fos = new FileOutputStream("C:\\Users\\hp\\eclipse-workspace\\Vtiger_Project\\src\\test\\resources\\ExcelSheet01.xlsx");
        book.write(fos);
        book.close();
		return data;
         
}	
	
	public Object[][] readDataUsingDataProvider(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Vtiger_Project\\src\\test\\resources\\ExcelSheet01.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum()+1;
		int lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] objArr = new Object[lastRow][lastCell];
		
		for (int i = 0; i <lastRow ; i++)
		{
			for (int j = 0; j < lastCell; j++) 
			{
				objArr[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return objArr;
		
	}
}