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

public class Fetching_Data_From_Excel_Using_Map {

	public static void main(String[] args) throws Throwable 
	{
		  FileInputStream fis = new FileInputStream("C:\\Users\\hp\\OneDrive\\Documents\\Book2.xlsx");
		   Workbook book = WorkbookFactory.create(fis);
		   Sheet sheet = book.getSheet("Sheet4");
		   int rows = sheet.getLastRowNum();
		   System.out.println(rows);
		    
		   LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		   
		 for(int i=0;i<=rows;i++) {
			 
			 String key = sheet.getRow(i).getCell(0).toString();
			 String value = sheet.getRow(i).getCell(1).toString();
			 map.put(key, value);
		 }
		   
		   for(Entry<String,String> m:map.entrySet())
		   {
			   
			  System.out.println(m.getKey()+" "+m.getValue());

		   }
	}
}