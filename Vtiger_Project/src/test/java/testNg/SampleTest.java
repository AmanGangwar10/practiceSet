package testNg;

import org.testng.annotations.Test;

public class SampleTest {

	@Test(priority = 0)
	public void createProduct()
	{
	  	System.out.println("product created");
	}
	
	@Test(invocationCount = 2)
	public void modifyProduct()
	{
	  		System.out.println("product modified");
	}
	
	@Test(dependsOnMethods = "createProduct" )
	public void deleteProduct()
	{
	  		System.out.println("product deleted");
	}
}