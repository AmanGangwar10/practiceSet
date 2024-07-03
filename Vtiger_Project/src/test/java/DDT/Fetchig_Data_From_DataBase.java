package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import Generric_Utilities.BaseClass;

public class Fetchig_Data_From_DataBase extends BaseClass{

	@Test
	public void Fetchig_Data_From_DataBaseTest () throws Throwable {
		 
	// Step 1 : register / load	the mysql database
//		Driver driverRef = new Driver();
//		DriverManager.registerDriver(driverRef);
		
	// Step 2 : get connect to database
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders", "root", "root");
		
	// Step 3 : create sql statement
		Statement state = con.createStatement();
		String query = "select * from student";
		
	// Step 4 : Execute Statement / Query
		ResultSet result = state.executeQuery(query);
		
	while (result.next()) 
	{
	System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t" + result.getString(4));	
	}
	
    // Step 5 : close database
	//     con.close();
	
	}
}