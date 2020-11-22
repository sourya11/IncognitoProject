package utilities;

public class readTestData {

	public static void main(String[] args) {
		readExcelData readFile=new readExcelData(System.getProperty("user.dir") + "\\src\\main\\java\\TestData\\Book1.xlsx");
	 String travelSheet="travelInsuranceSheet";
	 String carSheet="carInsuranceSheet";
	 
	 String testCase1="personalDetails";
	 String testCase2="travelDetails";
	 
	 int StartRow=0;
	 try {
	 while(!readFile.getCellData(travelSheet, 0 , StartRow).equals(testCase2)) {
		 StartRow++;
	 }}
	 catch(Exception e) {
		 System.out.print(e.getMessage());
	 }
	System.out.print(StartRow);
	
	int startTestRow=StartRow+2;
	int startTestColumn=0;
	 //Get No.of TestCase
	 int row=0;
	while(!readFile.getCellData( travelSheet, 0 , startTestRow +row ).equals("")){
		row++;
		
	}
	System.out.println("NO. OF TESTCase:" +  row);
	
	//Get No.of Column
	int column=0;
	while(!readFile.getCellData( travelSheet, startTestColumn+column , startTestRow ).equals("")){
		column++;
	 }
	System.out.println("NO. OF column:" +  column);
	
	for(int i=startTestRow ; i <= startTestRow + row ; i++) {
		for(int j=startTestColumn  ; j<=startTestColumn+column ; j++) {
			System.out.print(readFile.getCellData( travelSheet, j , i ));
		}
	}
	} 
	
}
