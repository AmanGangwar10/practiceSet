package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerification {


    //initialization

	public ValidationAndVerification(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Business logics
	
	/**
	 * this method is used to validation the organization data
	 * @param driver
	 * @param organizationData
	 * @author hp
	 */
	
	public void orgData(WebDriver driver,String organizationData)
	{
		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Organization Name\"]")).getText();
	 	if(organizationData.contains(actData))
	 	{
	 		System.out.println("organizationData is matched");
	 	}
	 	else
	 	{
	 		System.out.println("organizationData is not matched");
	 	}
	}
	
	/**
	 * this method is used to validation the product data
	 * @param driver
	 * @param organizationData
	 * @author hp
	 */
	
	public void prodData(WebDriver driver,String productData)
	{
		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Product Name\"]")).getText();
	 	if(productData.contains(actData))
	 	{
	 		System.out.println("productData is matched");
	 	}
	 	else
	 	{
	 		System.out.println("productData is not matched");
	 	}
	}
	
	/**
	 * this method is used to validation the campaign data
	 * @param driver
	 * @param campaignData
	 * @author hp
	 */
	
	public void campData(WebDriver driver,String campaignData)
	{
		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
	 	if(campaignData.contains(actData))
	 	{
	 		System.out.println("CampaignData is matched");
	 	}
	 	else
	 	{
	 		System.out.println("CampaignData is not matched");
	 	}

	}
	
	/**
	 * this method is used to validation the product data in a campaign
     * @param driver
	 * @param campaignData
	 * @author hp
	 */
	
	public void productInCamp(WebDriver driver,String productData)
	{
		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Product\"]")).getText();
	 	if(productData.contains(actData))
	 	{
	 		System.out.println("productData is matched");
	 	}
	 	else
	 	{
	 		System.out.println("productData is not matched");
	 	}
	}
		
}