package testClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import BaseClass.baseTestClass;
import BaseClass.pageBaseClass;
import pageClass.carNumber;
import pageClass.landingPage;
import pageClass.travelFillDetails;

public class SmoketTest extends baseTestClass {
	landingPage LPage;
    carNumber carNum;
    travelFillDetails TravelPage;
	@Test(groups= "Smoke")
   public void HealthInsuranceTestCase() {
  	 logger= report.createTest("HealthInsuranceReport");
  	 
  	 invokeBrowser("chrome");
    	
  	 pageBaseClass pageBase = new pageBaseClass(driver, logger);
  	 PageFactory.initElements(driver, pageBase);
		 
  	 driver.manage().deleteAllCookies();
		 LPage= pageBase.callUrl("https://www.policybazaar.com/");
		 LPage.invokeProperty();
		 
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 
		 LPage.invokeProperty();
		 LPage.clickHealthInsurance("HealthInsuranceSheetName" , "selectHealthIns_xpath" , "LeftList_xpath" , "RightList_xpath");
		 driver.manage().deleteAllCookies();
		 
   }
	 
	 @Test(groups="Smoke")
	 public void Navigation() {
		 logger= report.createTest("Navigation");
	   	 
	   	 invokeBrowser("chrome");
	     	
	   	 pageBaseClass pageBase = new pageBaseClass(driver, logger);
	   	 PageFactory.initElements(driver, pageBase);
			 
	   	 driver.manage().deleteAllCookies();
			 LPage= pageBase.callUrl("https://www.policybazaar.com/");
			 LPage.invokeProperty();
			 //Move to car Insurance Page
			 driver.manage().deleteAllCookies();
			 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			 
			 TravelPage=LPage.clickTravelInsurance("insurance_linkText" , "click_TravelInsurance_Xpath");
			 TravelPage.invokeProperty();
			 
			 driver.manage().deleteAllCookies();
			 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			 //Move to logo Insurance Page
			 LPage= TravelPage.Logo();
			 LPage.invokeProperty();
			 driver.manage().deleteAllCookies();
			 carNum= LPage.getCarInsurance("motor_xpath" , "ClickCarInsurance");
			 driver.manage().deleteAllCookies();
			 carNum.Logo1();
			 
			 
	 }
	 @Test(groups="Smoke")
	 public void checkIconAndMenuItem() {
         logger= report.createTest("Check icon and menuItem landed on same page");
	   	 
	   	 invokeBrowser("chrome");
	     	
	   	 pageBaseClass pageBase = new pageBaseClass(driver, logger);
	   	 PageFactory.initElements(driver, pageBase);
			 
	   	 driver.manage().deleteAllCookies();
		 LPage= pageBase.callUrl("https://www.policybazaar.com/");
		 LPage.invokeProperty();
		 //Move to car Insurance Page
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 
		 carNum= LPage.getCarInsurance("motor_xpath" , "ClickCarInsurance");
		 carNum.invokeProperty();
		String carTitle1= carNum.pageTitle();
		System.out.print(carTitle1);
		 Assert.assertEquals(carTitle1 ,"Car Insurance Online: Buy/Renew Car Insurance Policy, Get 80%* Off"  , "Both the pages are different");
		 LPage.invokeProperty();
		 
		 driver.manage().deleteAllCookies();
		 
		 //Move to logo Insurance Page
		 carNum.Logo1();
		 
		 LPage.carIcon();
		 String carTitle2= LPage.pageTitle();
		 System.out.print(carTitle2);
		 Assert.assertEquals( carTitle2 , "PolicyBazaar Car Insurance: Insure Your Car Today", "Both the pages are different");
	 }
	 @AfterTest
     public void close() {
    	 
    	 driver.close();
     }
}
