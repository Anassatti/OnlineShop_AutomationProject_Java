package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	static ExtentReports extent;
	public static ExtentReports getReport()
	{
		String path= System.getProperty("user.dir")+"\\reports\\OnlineShop1.html";
		ExtentSparkReporter  reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("OnlineShoppingResults");
		reporter.config().setDocumentTitle("Test Results");
		
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Anas");
		
		return extent;
	}

}
