package utilities;

import java.util.Date;

public class checkDate {
	  
		 public  static String getDate(){
	         Date d= new Date();
	        return  d.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}
}
