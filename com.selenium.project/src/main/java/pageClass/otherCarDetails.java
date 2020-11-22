package pageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import BaseClass.pageBaseClass;

public class otherCarDetails extends pageBaseClass {
	
	public otherCarDetails(WebDriver driver , ExtentTest logger) {
		  super(driver , logger);
	}
	
	public void otherDetails() {
		try {
		driver.findElement(By.xpath(prop.getProperty("clicklabel_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("clickDate"))).click();
		driver.findElement(By.xpath(prop.getProperty("radioButton"))).click();
		testCasePass("The Car Insurance complete detail is filled and accepted");
        }
        catch(Exception e) {
       	 testCaseFail(e.getMessage());
        }
		
	}
}
