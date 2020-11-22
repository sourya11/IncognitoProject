package utilities;

import java.util.Hashtable;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testDataProvider {
	
	
	@DataProvider
	public static Object[][] testCase1(String sheetName , String  testCase){
		
		
		readExcelData readFile=new readExcelData(System.getProperty("user.dir") + "\\src\\main\\java\\TestData\\Book1.xlsx");
		 
		 
		 int StartRow=0;
		
		 while(!readFile.getCellData(sheetName, 0 , StartRow).equalsIgnoreCase(testCase)) {
			 StartRow++;
		 }
		
		int startTestColumn1=StartRow+1;
		int startTestRow=StartRow+2;
		int startTestColumn=0;
		 //Get No.of TestCase
		 int row=0;
		while(!readFile.getCellData( sheetName, 0 , startTestRow + row ).equals("")){
			row++;
			
		}
		
		
		//Get No.of Column
		int column=0;
		while(!readFile.getCellData(sheetName, startTestColumn+column , startTestRow-1 ).equals("")){
			column++;
		 }
		
		int StartDataProvider=0;
		Object[][] dataSet = new Object[row][1];
		 Map<String , String> data= null;
		
		
		for(int k=startTestRow ; k< (startTestRow + row) ; k++) {
			data= new Hashtable<String , String>();
			for(int j=0  ; j<column ; j++) {
				String key=readFile.getCellData(sheetName , j , startTestColumn1 );
				String value=readFile.getCellData(sheetName, j , k );
				data.put(key, value);
				
			}
			dataSet[StartDataProvider][0]=data;
			
			StartDataProvider++;
			
		}
		return dataSet;
	}
}
