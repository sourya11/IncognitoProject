package BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageClass.landingPage;
import utilities.extentReport;

public class baseTestClass{
	
	  public WebDriver driver; 
	
	  public ExtentReports report= extentReport.getReport();
	  public ExtentTest logger;
	  
	  public void invokeBrowser(String bro) {
		     
		   if(bro.equalsIgnoreCase("chrome")) {
			   System.out.println("yes");
			   System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\selenium\\chromedriver.exe");
			  //System.setProperty("webdriver.gecko.driver" , System.getProperty("user.dir")  + "\\driver\\chromedriver.exe");
			   driver= new ChromeDriver();
		   }
		   else if(bro.equalsIgnoreCase("firefox")) {
			   System.setProperty("webdriver.gecko.driver" , System.getProperty("user.dir")  + "\\driver\\geckodriver.exe");
		       driver=new FirefoxDriver();
		   }
		   else {
			   driver=new SafariDriver();
		   }
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		   driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  }
	   
	 //FlushReport//
	 @AfterMethod
		public void flushReports() {
			report.flush();
			
		}
	   
	  
		
	 
	  //********************CloseDriver*************************************//
	  public void closeDriver() {
		  driver.close();
	  }
	  
	  
	  
}
