package pageClass;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import BaseClass.pageBaseClass;

public class landingPage extends pageBaseClass {
	
	
	public landingPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	
    //****************CLICK TO TRAVEL INSURANCE MENU ITEM*********************************//
      public travelFillDetails clickTravelInsurance(String xpath1 ,String xpath2) {
    	  try {
  		Actions action=new Actions(driver);
  		WebElement insurance=driver.findElement(By.linkText(prop.getProperty(xpath1)));
  		 
  		action.moveToElement(insurance).perform();
  		driver.findElement(By.xpath(prop.getProperty(xpath2))).click();
  		testCasePass("The travelInsurance menu item clicked succesfully");
    	  }
    	  catch(Exception  e) {
    		 testCaseFail(e.getMessage());
    	  }
    	travelFillDetails details = new travelFillDetails(driver, logger);
    	  
  		PageFactory.initElements(driver, details);
  		return details;
       
  	}
      
      
  	//******************************HEALTH INSURANCE****************************************//
      public void clickHealthInsurance( String sheets , String xpath2 ,String Lxpath , String Rxpath ) {
    	  
  		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
  		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
  		ArrayList<String> value= new ArrayList<String>();
  		
  		XSSFWorkbook workbook= new XSSFWorkbook();
  		XSSFSheet sheet= workbook.createSheet(prop.getProperty(sheets));
  		XSSFRow row=sheet.createRow(0);
  		row.createCell(0).setCellValue("MenuItems");
  		try {
  		Actions actions = new Actions(driver);
  		WebElement target = driver.findElement(By.xpath(prop.getProperty(xpath2)));
  		 try {
  			Thread.sleep(4000);
  		} catch (InterruptedException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		actions.moveToElement(target).perform();
  		
  		testCasePass("The Health Insurance menu item is clicked");
  		}
  		catch(Exception e) {
  			 testCaseFail(e.getMessage());
  		}
  		try {
  			Thread.sleep(1000);
  		} catch (InterruptedException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		for(int i=1 ; i<=10 ; i++) {
  			
  		String	 ls = driver.findElement(By.xpath(prop.getProperty(Lxpath)+i+prop.getProperty(Rxpath))).getText();
  		     
  		value.add(ls);
  		testCasePass(ls);
  			
  		}
  		System.out.println("The Health Insurance Menu Items:");
  		for(int j=1;j<value.size();j++){
  			
  			sheet.createRow(j).createCell(0).setCellValue(value.get(j-1));
  			System.out.println( value.get(j-1));
  		}
  		
  		try {
  			FileOutputStream wr=new FileOutputStream(System.getProperty("user.dir") + "/ExcelFiles/MenuItems.xlsx");
  			testCasePass("The file is opened successfully");
  			try {
  				workbook.write(wr);
  				testCasePass("The data is written successfully in excel file");
  				
  			} catch (IOException e) {
  				// TODO Auto-generated catch block
  				testCaseFail(e.getMessage());
  				
  			}
  		} catch (FileNotFoundException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  			testCaseFail(e.getMessage());
  		}
  	}

     
    //*****************************click car insurance**************************//
    		public carNumber getCarInsurance(String selectCar_xpath , String xpath1 ) {          
    			try {
    				
    				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    			WebElement car=driver.findElement(By.xpath(prop.getProperty(selectCar_xpath)));
    			Actions action= new Actions(driver);
    			action.moveToElement(car).perform();
    			try {
    				Thread.sleep(1000);
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
    			driver.findElement(By.xpath(prop.getProperty(xpath1))).click();
    			testCasePass("The car Insurance menu item selected successfully");
    			}
    			catch(Exception e) {
    				testCaseFail(e.getMessage());
    			}
    			carNumber number = new carNumber(driver, logger);
    	  		PageFactory.initElements(driver, number);
    	  		return number;
    		 
    		}
    		
    /****************************************ICON CAR INSURANCE ***********************************/
    		
    		public void carIcon() {
    			driver.findElement(By.xpath("/html/body/section[1]/div[1]/div/div/div[1]/div[3]/a[4]")).click();
    		}
    		
    		
    		
}
