package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Insert_Data_To_Excel_Using_Map {

	public static void main(String[] args) throws Throwable {
		
	   FileInputStream fis = new FileInputStream("C:\\Users\\hp\\OneDrive\\Documents\\Book2.xlsx");
	   Workbook book = WorkbookFactory.create(fis);
	   Sheet sheet = book.getSheet("Sheet4");
	    
	   LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
	    
	   map.put("10", "Bareilly");
	   map.put("20", "Bangalore");
	   map.put("30", "Goa");
	   map.put("40", "Pune");
	   
	   int rowNo=0;
	   for(Entry<String,String> m:map.entrySet())
	   {
		  Row row = sheet.createRow(rowNo++);
		  row.createCell(0).setCellValue((String)m.getKey());
      	  row.createCell(1).setCellValue((String)m.getValue());

	   }
	   
	   FileOutputStream fos = new FileOutputStream("C:\\Users\\hp\\OneDrive\\Documents\\Book2.xlsx");
	   book.write(fos);
	   book.close();
	   
//	   LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
//	    
//	   map.put(10, "Bareilly");
//	   map.put(20, "Bangalore");
//	   map.put(30, "Goa");
//	   map.put(40, "Pune");
//	   
//	   int rowNo=0;
//	   for(Entry<Integer,String> m:map.entrySet())
//	   {
//		  Row row = sheet.createRow(rowNo++);
//		  row.createCell(0).setCellValue((Integer)m.getKey());
//      	  row.createCell(1).setCellValue((String)m.getValue());
//
//	   }
//	   
//	   FileOutputStream fout = new FileOutputStream("C:\\Users\\hp\\OneDrive\\Documents\\Book2.xlsx");
//	   book.write(fout);
//	   book.close();
//	   System.out.println("data added successfully");
		   
	  
		
	
	   }
	}