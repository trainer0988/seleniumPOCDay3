package abstractComponent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNg {
	
	public static ExtentReports getreporterObject()
	{
		String reportPath = System.getProperty("user.dir")+ "//report//index.html";
		
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportPath);
		extentSparkReporter.config().setReportName("OrangeHRM Automation Test Report");
		extentSparkReporter.config().setDocumentTitle("OrangeHRM Test Report");
		
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Tester", "Ashutosh Upadhyay");
		return extentReports;
	}
		

}
