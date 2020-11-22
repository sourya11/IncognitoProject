package testClass;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.baseTestClass;
import BaseClass.pageBaseClass;
import pageClass.TravellerPersonalDetails;
import pageClass.carNumber;
import pageClass.fillCarInsuranceForm;
import pageClass.landingPage;
import pageClass.otherCarDetails;
import pageClass.travelFillDetails;
import pageClass.travelInsurance;
import utilities.testDataProvider;

public class RegressionTest extends baseTestClass{
                    
	landingPage LPage;
    carNumber carNum;
    travelFillDetails fillDetail;
    TravellerPersonalDetails personalDetail;
    travelInsurance insurnace;
    fillCarInsuranceForm InsuranceForm;
    otherCarDetails otherDetail;
    pageBaseClass baseClass;
	 travelFillDetails TravelPage;
	
	@Test(dataProvider="getTravelInsuranceTestCase" , groups="Regression")
    public void travelInsuranceTestCase(Hashtable <String , String> data) {
    	 logger= report.createTest("TravelInsuranceReport:" + data.get("Remarks"));
    	 invokeBrowser("chrome");
      	
    	 pageBaseClass pageBase = new pageBaseClass(driver, logger);
    	 PageFactory.initElements(driver, pageBase);
		 
    	 driver.manage().deleteAllCookies();
		 LPage= pageBase.callUrl("https://www.policybazaar.com/");
		 LPage.invokeProperty();
		 
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 fillDetail= LPage.clickTravelInsurance("insurance_linkText" , "click_TravelInsurance_Xpath");
		 fillDetail.invokeProperty();
		 
		 driver.manage().deleteAllCookies();
		 
		 personalDetail= fillDetail.fillDetails(data.get("Country") , data.get("Age1") ,  data.get("Age2") );
		 personalDetail.invokeProperty();
		 
		 driver.manage().deleteAllCookies();
		
    	 insurnace= personalDetail.personalDetails(data.get("name") , data.get("PhoneNumber") , data.get("email") );
	     insurnace.invokeProperty();
		 insurnace.clickPriceDropDown("selectPrice_name" , "selectByVT");
		LPage=insurnace.getInsuranceDetails();
		 driver.manage().deleteAllCookies();
		 
     }
     
    
     
    @Test(dataProvider="carInsuranceTestCase"  ,  priority=2 , groups="Regression")
     public void CarInsuranceTestCase(Hashtable <String , String> data) {
    	 logger= report.createTest("CarInsuranceReport:" + data.get("Remark"));
    	 invokeBrowser("chrome");
    	 pageBaseClass pageBase = new pageBaseClass(driver, logger);
    	 PageFactory.initElements(driver, pageBase);
    	 driver.manage().deleteAllCookies();
    	 
		 LPage= pageBase.callUrl("https://www.policybazaar.com/");
		 LPage.invokeProperty();
		 driver.manage().deleteAllCookies();
		
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 carNum= LPage.getCarInsurance("motor_xpath" , "ClickCarInsurance");
		 carNum.invokeProperty();
		 driver.manage().deleteAllCookies();
		 InsuranceForm=carNum.proceedWithoutCarNumber("ProceedWitotCarNum_xpath");
		 InsuranceForm.invokeProperty();
		 driver.manage().deleteAllCookies();
		 InsuranceForm.fillForm(data.get("Name") , data.get("PhoneNumber") , data.get("Email"));
		
		 
	  }
     
     @AfterMethod
     public void close() {
    	 
    	 driver.close();
     }
     
     @DataProvider 
    public Object[][] carInsuranceTestCase(){
    	return testDataProvider.testCase1("carInsuranceSheet" , "personalDetails") ;
    }
	
    @DataProvider
    public Object[][] getTravelInsuranceTestCase(){
    	return testDataProvider.testCase1("travelInsuranceSheet" , "travelDetails") ;
    }

}
