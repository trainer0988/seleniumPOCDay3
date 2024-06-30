package seleniumpoc.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import seleniumpoc.pages.LoginPage;

public class BaseTest {

	public static WebDriver driver;
	LoginPage loginPage;
	public void initalizeDriver() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\globalData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			 driver = new ChromeDriver(options);
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		}
	

	@BeforeMethod
	public void  launchApplication()
	{
		try {
			initalizeDriver();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		loginPage =  new LoginPage(driver);
	}
	
	
	@AfterMethod
	public void closeApplication()
	{
		// driver.close();//->this will throw org.openqa.selenium.remote.http.WebSocket$Listener onError WARNING: Connection reset
	driver.quit();
	}
	
	
	public String getScreenShoot(String TestCaseName) 
	{
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String destinationFilePath = System.getProperty("user.dir")+"//screenShoot//"+TestCaseName + ".png";
		File destinaton = new File(destinationFilePath);
		try {
			FileUtils.copyFile(source, destinaton);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return destinationFilePath;
		
	}

	
	
	
}
