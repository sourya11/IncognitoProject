package pageClass;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import BaseClass.pageBaseClass;

public class travelInsurance  extends pageBaseClass{
      
      public travelInsurance(WebDriver driver , ExtentTest logger) {
    	  super(driver , logger);
     }
      
      public void clickPriceDropDown(String name , String xpath) {
  		//to sort according to price
    	  try {
  		driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
  		WebElement Type =driver.findElement(By.name(prop.getProperty(name)));
  		new WebDriverWait(driver, 15).until(
  		            ExpectedConditions.elementToBeClickable(Type));
  		Type.click();
  		System.out.println("Click dropdown meanu2");
  		Select option = new Select(driver.findElement(By.name(prop.getProperty(name))));
  		 option.selectByVisibleText(prop.getProperty(xpath));
  		 testCasePass("The low to high price is selected from drop Down menu");
    	  }
    	  catch(Exception e) {
    		  testCaseFail(e.getMessage());
    	  }
  		 
  	}
    //*****display three lowest international  travel insurance plan with amount and insurance provider company**//
  	
      public landingPage getInsuranceDetails() {
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		 List<String> name=new ArrayList<String>();
	     List<String> price=new ArrayList<String>();
		
	
		int y=0;
		 System.out.println("Three lowest travel Insurance:" );
		for(int i=1;i<=3;i++) {
			String	n=  driver.findElements(By.xpath("//p//img")).get(y).getAttribute("alt");
			String pri= driver.findElements(By.xpath("//span[@class='ng-binding ng-scope']")).get(i).getText();
			name.add(n);
		    price.add(pri);
			System.out.println("Name: "+n+" price: "+pri );
			y++;
		}
		//*******Create a excel sheet*********//
		 XSSFWorkbook workbook1=new XSSFWorkbook();
		  XSSFSheet sheet=workbook1.createSheet("Details");
		  Row row;
 	   row= sheet.createRow(0);
 	   row.createCell(0).setCellValue("Insurance Provider");
 	   row.createCell(1).setCellValue("Price");
		 //To input the headings in excel sheet
		 
 	 
		  for(int v=1;v<=name.size(); v++)
 	   {
 		   row=sheet.createRow(v);
 		    row.createCell(0).setCellValue(name.get(v-1));
 		    row.createCell(1).setCellValue(price.get(v-1));
 		   
 	   }
		 
		  
		  FileOutputStream writeFile;
		try {
			writeFile = new FileOutputStream( System.getProperty("user.dir") + "/ExcelFiles/Travel_Insurance.xlsx");
			 try {
				workbook1.write(writeFile);
				testCasePass("The Travel Insurnce Details is written in excel file successfully");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				testCaseFail(e.getMessage());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			testCaseFail(e.getMessage());
		}
		landingPage landing= new landingPage(driver , logger);
		
		 PageFactory.initElements(driver, landing);
		 return landing;
	}
	
}
