package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
public class readExcelData {
       
    	   public String path;
    		public FileInputStream fis = null;
    		public FileOutputStream fileOut = null;
    		private XSSFWorkbook workbook = null;
    		private XSSFSheet sheet = null;
    		private XSSFRow row = null;
    		private XSSFCell cell = null;

    		
    		
    		/****************** Constructor ***********************/
    		public readExcelData(String path) {

    			this.path = path;
    			try {
    				fis = new FileInputStream(path);
    				workbook = new XSSFWorkbook(fis);
    				sheet = workbook.getSheetAt(0);
    				fis.close();
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    		}
    		}
    		
    		
    		/****************** Returns the data from a cell ***********************/
    		public String getCellData(String sheetName, int colNum, int rowNum) {
    			
    				if (rowNum <= 0)
    					return "";

    				int index = workbook.getSheetIndex(sheetName);

    				if (index == -1)
    					return "";

    				sheet = workbook.getSheetAt(index);
    				row = sheet.getRow(rowNum - 1);
    				if (row == null)
    					return "";
    				cell = row.getCell(colNum);
    				if (cell == null)
    					return "";

    			        return cell.toString();
    				
    				
    			
    		
    		
    
    		
    		
    		}
}
