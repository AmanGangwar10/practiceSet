package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import Generric_Utilities.BaseClass;

public class Insert_Data_To_DataBase extends BaseClass{

	@Test
	public void Insert_Data_To_DataBaseTest() throws Throwable {
		
//		Driver driverRef = new Driver();
//		DriverManager.registerDriver(driverRef);
		
		  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders", "root", "root");
		  Statement state = con.createStatement();
		  
		  String query = "insert into student(first_name,last_name,address)values('ram','sita','Goa'),('mohan','priya','Bangalore')";
		
		 int result = state.executeUpdate(query);
		 
		 if(result==1)
		 {
			 System.out.println("data updated");
		 }
		 else
		 {
			 System.out.println("data not updated");
		 }
//		 con.close();

	}
}