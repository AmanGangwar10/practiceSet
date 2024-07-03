package Generric_Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {

	public void dataBaseConnection(WebDriver driver) throws Throwable
	{
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
	}
	
	public void dataBaseClose() throws Throwable
	{
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders", "root", "root");
		con.close();
	}
}