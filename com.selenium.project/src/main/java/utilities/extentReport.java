package utilities;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReport {
	public static ExtentReports report;
    
    
    @BeforeTest 
	public static ExtentReports getReport() {
		 String date=checkDate.getDate() + ".html";
		    if(report==null){
		 	  
		 ExtentHtmlReporter extentReporter= new ExtentHtmlReporter(System.getProperty("user.dir") + "//testReport//" + date);
		 	   report = new ExtentReports();
		 	   report.attachReporter(extentReporter);
		 	   
		 	   report.setSystemInfo("OS", "Windows 10");
		 	   report.setSystemInfo("Enviroment", "UAT");
		 	   report.setSystemInfo("Browser", "Chrome");
		 	   report.setSystemInfo("Build Number", "10.8.1");
		 	   
		 	   extentReporter.config().setDocumentTitle("UI Automation Results");
		 	   extentReporter.config().setReportName("AutomateInsuranceWebsite-PolicyBazaar");
		 	   extentReporter.config().setChartVisibilityOnOpen(true);
		 	   extentReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		 	   extentReporter.config().setTheme(Theme.DARK);
		 	   
		    }
		    
		    return report;
	}
}
