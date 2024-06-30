package seleniumpoc.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import abstractComponent.ExtentReportNg;

public class Listners extends BaseTest implements ITestListener {
	ExtentTest extentTest;
	ExtentReports extentReports = ExtentReportNg.getreporterObject();
	
	
	 public void onTestStart(ITestResult result) {
		 
		 extentTest =  extentReports.createTest(result.getMethod().getMethodName());
		  }
	 
	 public void onTestSuccess(ITestResult result) {
		 String testcaseName = result.getMethod().getMethodName(); 
		 extentTest.log(Status.PASS, "Test Pass");
		 String capturedScreenShootFilePath = getScreenShoot(testcaseName);
		  extentTest.addScreenCaptureFromPath(capturedScreenShootFilePath, testcaseName);
			 
		    
		  }
	 
	 public void onTestFailure(ITestResult result) {
		   String testcaseName = result.getMethod().getMethodName(); 
		 extentTest.log(Status.FAIL, "Test fail");
		 extentTest.fail(result.getThrowable());
		 // attach screen shoot
			/*
			 * try { result.getTestClass().getRealClass().getFields();
			 * result.getTestClass().getRealClass().getSuperclass().getFields(); driver =
			 * (WebDriver)
			 * result.getTestClass().getRealClass().getField("WebDriver").get(result.
			 * getInstance()); } catch (Exception e) { System.out.
			 * println("exception will creating driver object in on test failure method");
			 * e.printStackTrace();
			 * 
			 * }
			 */
			  String capturedScreenShootFilePath = getScreenShoot(testcaseName);
			  extentTest.addScreenCaptureFromPath(capturedScreenShootFilePath, testcaseName);
			 
		 
		  }
	 
	 public void onFinish(ITestContext context) {
		 
		 extentReports.flush();
	  }
}
