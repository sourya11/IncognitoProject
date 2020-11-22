package pageClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import BaseClass.pageBaseClass;

public class TravellerPersonalDetails extends pageBaseClass {
      
      public TravellerPersonalDetails(WebDriver driver , ExtentTest logger) {
    	  super(driver , logger);
      }
      
    //*************************PERSONAL DETAILS******************************************//
  	public travelInsurance personalDetails(String name , String phone, String email ) {
  		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
  		
//designate  		
  		
  		driver.findElement(By.xpath(prop.getProperty("selectTravel_xpath"))).click();
  		testCasePass("The title is selected successfully");
  		
//Name
  		
  		driver.findElement(By.id(prop.getProperty("name_id"))).sendKeys(name);
  		
  	
  		
 //code 	
  		
  			driver.findElement(By.xpath(prop.getProperty("SelectIndiaNumber_xpath"))).click();
  			
//PhoneNumber
  		
  		driver.findElement(By.id(prop.getProperty("number_id"))).sendKeys(phone);
  		
  		
//email
  		
  		       driver.findElement(By.id(prop.getProperty("email_id"))).sendKeys(email);
  		     
//submit
  		
  		driver.findElement(By.xpath(prop.getProperty("clickGetFreeQuote_xpath"))).click();
  		
  		if(name=="") {
  			String nameError=driver.findElement(By.xpath(prop.getProperty("nameError_xpath"))).getText();
  		     testCaseFail(nameError);
  		     }
  		else if(phone=="") {
  			String phoneError=driver.findElement(By.xpath(prop.getProperty("mobileNoError_xpath"))).getText();
  			testCaseFail(phoneError);
  		}
  		else if(email=="") {
  			String emailError=driver.findElement(By.xpath(prop.getProperty("email_xpath"))).getText();
  			testCaseFail(emailError);
  		}
  		else if(email=="rajsingh@gmail") {
  			String emailError1=driver.findElement(By.xpath(prop.getProperty("email_xpath"))).getText();
  			testCaseFail(emailError1);
  		}
  		else {
  		testCasePass("The personal details is  entered and submitted successfully");
  		}
  		
  		travelInsurance travel= new travelInsurance(driver , logger);
  		 PageFactory.initElements(driver, travel);
  		 return travel;
  	}
}
