package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



import org.apache.commons.io.FileUtils;
import pageClass.landingPage;
import utilities.checkDate;
import utilities.extentReport;

public class pageBaseClass extends baseTestClass {
	 
public  Properties prop ; 


public pageBaseClass(WebDriver driver, ExtentTest logger) {
	this.driver = driver;
	this.logger = logger;
}

//**********************PropertyFile*****************************************//
public  void invokeProperty() {
    if(prop==null) {
		 prop = new Properties();
		  System.out.println("Property");
		 try {
			FileInputStream read = new FileInputStream(System.getProperty("user.dir") + "\\object Repository\\PropertyFile.properties");
		      try {
				prop.load(read);}
		      catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
		      } 
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		 }
	 }
	   
	   
	   
	  
		
//**********************CallUrl*****************************************//
	  public landingPage callUrl(String Url) {
		  driver.get(Url);
		  System.out.println("WebsiteOpen");
		  landingPage page=new landingPage(driver , logger);
		   PageFactory.initElements(driver, page);
		   return page;
	  }
//****************************TAKE SCREEN SHORT*************************//
	    public  void TakeScreenShot(){
	    	
	    	TakesScreenshot photo= (TakesScreenshot)driver;
	    	File source= photo.getScreenshotAs(OutputType.FILE);
	    	File desFile=new File(System.getProperty("user.dir") + "/screenShot/" + checkDate.getDate() + ".png");
	    	try {
				FileUtils.copyFile(source, desFile);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	try {
				logger.addScreenCaptureFromPath(System.getProperty("user.dir") + "/screenShot/" + checkDate.getDate() + ".png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		 
	  
}
	    //**************************TEST CASE PASS***************************//
	    public void testCasePass(String pass){
	    	logger.log(Status.PASS, pass);
	    }
	    //********************TEST CASE FAIL*********************************//
	    @SuppressWarnings("deprecation")
		public void testCaseFail(String fail){
	    	logger.log(Status.FAIL, fail);
	    	TakeScreenShot();
	    	Assert.fail(fail);
	    
	    }
	    
	    public String pageTitle() {
			   return driver.getTitle();
		  }
}