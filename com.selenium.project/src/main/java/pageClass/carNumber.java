package pageClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import BaseClass.pageBaseClass;

public class carNumber extends pageBaseClass {
   
    public carNumber(WebDriver driver , ExtentTest logger) {
    	super(driver , logger);
    	
    }
    public fillCarInsuranceForm proceedWithoutCarNumber(String xpath2) {
    	try {
    		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
    	driver.findElement(By.xpath(prop.getProperty(xpath2))).click();
    	 testCasePass("The proceed Without Car Number selected successfully");
    	}
    	catch(Exception e) {
    		testCaseFail(e.getMessage());
    	}
    	fillCarInsuranceForm form= new fillCarInsuranceForm(driver , logger);
    	 PageFactory.initElements(driver, form);
    	  return form;
    }
    
    
    public void Logo1() {
		try{
		driver.findElement(By.xpath("//*[@id=\"navigatorType\"]/body/div[1]/nav/div/div[2]/div/div[1]/a[2]")).click();
		testCasePass("Move to policyBazaar Main page");
	}
	catch (Exception e) {
		testCaseFail("Doesn't move to policyBazaar Main page");
	}
		
	}
}
