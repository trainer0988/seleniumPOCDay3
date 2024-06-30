package seleniumpoc.testcases;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {
	WebDriver driver = new ChromeDriver();
	
	public void captureScreenshoot()
	{
		
		
		//type caste WebDriver reference into ChromeDriver 
		File f =  ((ChromeDriver)driver).getScreenshotAs(OutputType.FILE);
		
	}

}
