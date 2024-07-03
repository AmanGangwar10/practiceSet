package Generric_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
	
	/**
	 * its used return the value from property file based on key
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author hp
	 */
	
	public String getkeyAndValueData(String key) throws Throwable
	{
		
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Vtiger_Project\\src\\test\\resources\\FileCommonDataVtiger.properties");
        Properties pro = new Properties();
        pro.load(fis);
        return pro.getProperty(key);
		
	}

}
