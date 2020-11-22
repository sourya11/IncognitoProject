package pageClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentTest;

import BaseClass.pageBaseClass;

public class travelFillDetails extends pageBaseClass{
	
	public travelFillDetails(WebDriver driver , ExtentTest logger) {
		super(driver, logger);
	}
	
    
	public TravellerPersonalDetails fillDetails( String country  , String Age1  , String Age2) {
		System.out.println("inside TravellerPersonalDetails");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		try {
		driver.findElement(By.xpath(prop.getProperty("clickStudent_xpath"))).click();
		testCasePass("The student travel is selected successfully");
		}
		catch(Exception e) {
			testCaseFail(e.getMessage());
		}
		if(country!="") {
		//country
		driver.findElement(By.xpath(prop.getProperty("chooseCountry_xpath"))).sendKeys(country); 
		driver.findElement(By.xpath(prop.getProperty("clickCountry_xpath"))).click();
			
		}
		//Age
		 
			
		driver.findElement(By.xpath(prop.getProperty("ageOfTravel1_xpath"))).sendKeys(Age1);
		driver.findElement(By.xpath(prop.getProperty("ageofTravel2_xpath"))).sendKeys(Age2);
		
		
		
		
		//to choose start date
		 JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,150)");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath(prop.getProperty("StartDate_input_xpath"))).click();
			System.out.println("correct1");
		
			
			
			
			driver.findElement(By.xpath(prop.getProperty("startDate_date_xpath"))).click();
			System.out.println("correct1");
			
			//to choose end date
			
			driver.findElement(By.xpath(prop.getProperty("endDate_input_xpath"))).click();
			
		    driver.findElement(By.id("proceedStepOne")).click();
		    if(Age1=="") {
		    	String ageerror=driver.findElement(By.xpath(prop.getProperty("endDate_date_xpath"))).getText();
		    	testCaseFail(ageerror);
		    }
		    else if(country=="") {
		    	testCaseFail("Country field is empty");
		    }
		    TravellerPersonalDetails details = new TravellerPersonalDetails(driver , logger);  
	    PageFactory.initElements(driver, details);
	    return details;
	}
     
	public landingPage Logo() {
		try{
		driver.findElement(By.xpath(prop.getProperty("logo_xpath"))).click();
		testCasePass("Move to policyBazaar Main page");
	}
	catch (Exception e) {
		testCaseFail("Doesn't move to policyBazaar Main page");
	}
		landingPage page = new landingPage(driver , logger);  
	    PageFactory.initElements(driver, page);
	    return page;
	}
     
    
}
