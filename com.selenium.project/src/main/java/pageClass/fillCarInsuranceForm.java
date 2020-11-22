package pageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import BaseClass.pageBaseClass;

public class fillCarInsuranceForm extends  pageBaseClass {
	
	public fillCarInsuranceForm(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
public void fillForm(String name,String mobileno ,String email) {
			 //city
	         try {
			driver.findElement(By.xpath(prop.getProperty("city"))).click();
			testCasePass("The delhi city is selected successfully");
	         }
	         catch(Exception e) {
	        	 testCaseFail(e.getMessage());
	         }
			
			//RTO
	         try {
			driver.findElement(By.xpath(prop.getProperty("RTO"))).click();
	         testCasePass("The RTO is selected successfully");
              }
				catch(Exception e) {
					 testCaseFail(e.getMessage());
				}
	         //Brand
	         try {
			 driver.findElement(By.xpath(prop.getProperty("BRAND"))).click();
			 testCasePass("The Honda Brand is selected successfully");
             }
				catch(Exception e) {
					 testCaseFail(e.getMessage());
				}
	         //Model
	         try {
			driver.findElement(By.xpath(prop.getProperty("model"))).click();
			testCasePass("The car model is selected successfully");
             }
				catch(Exception e) {
					 testCaseFail(e.getMessage());
				}
	         //fuel
	         try {
			driver.findElement(By.xpath(prop.getProperty("fuel"))).click();
			testCasePass("The car fuel is selected successfully");
             }
				catch(Exception e) {
					 testCaseFail(e.getMessage());
				}
	         
	         //Variant
	         try {
			driver.findElement(By.xpath(prop.getProperty("VARIANT"))).click();
			testCasePass("The car variant is selected successfully");
	         }
	         catch(Exception e) {
	        	 testCaseFail(e.getMessage());
	         }
	         //year
	         try {
			driver.findElement(By.xpath(prop.getProperty("year"))).click();
			testCasePass("The car variant is selected successfully");
	         }
	         catch(Exception e) {
	        	 testCaseFail(e.getMessage());
	         }
	         //name
	        
			driver.findElement(By.xpath(prop.getProperty("name_xpath"))).sendKeys(name);
			
	         //email
	         
	        		 driver.findElement(By.xpath(prop.getProperty("email_xpath"))).sendKeys(email);
	     			
	        	
	         //mobile
	        
			driver.findElement(By.xpath(prop.getProperty("mobile_xpath"))).sendKeys(mobileno);
			
	         //submit
	     
			driver.findElement(By.xpath(prop.getProperty("detail_xpath"))).click();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(name=="")
			{
				String nameError= driver.findElement(By.xpath(prop.getProperty("name_xpath"))).getText();
				testCaseFail(nameError);
			}
			else if(mobileno=="") {
				String phoneError=driver.findElement(By.xpath(prop.getProperty("mobileno_xpath"))).getText();
			     testCaseFail(phoneError);
			}
			else if(email=="") {
				String emailError=driver.findElement(By.xpath(prop.getProperty("emailerror1_xpath"))).getText();
				testCaseFail(emailError);
			}
			else if(email=="preetsaini097@gmail") {
				String emailError=driver.findElement(By.xpath(prop.getProperty("emailerror2_xpath"))).getText();
				testCaseFail(emailError);
			}
			else {
			testCasePass("The Car Insurance form  is entered/selected and submitted successfully");
	         }
	         
			
		
}
public landingPage Logo() {
	try {
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
