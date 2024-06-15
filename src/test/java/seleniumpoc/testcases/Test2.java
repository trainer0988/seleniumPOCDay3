package seleniumpoc.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import seleniumpoc.pages.LoginPage;

public class Test2 {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text() = ' Login ']")).click();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin("Admin", "admin123");
		
		driver.findElement(By.xpath("//span[text() = 'PIM']")).click();
		
		driver.findElement(By.xpath("//nav[@aria-label = 'Topbar Menu' ]/ul/li[3]/a")).click();
		
		driver.findElement(By.xpath("//img[@class = 'employee-image']")).click();
		
		driver.findElement(By.xpath("//*[@type = 'file']")).sendKeys("C:\\Users\\WIN 10.DESKTOP-VBBJ1UA\\OneDrive\\Desktop\\status.png");
		
		//Runtime.getRuntime().exec("C:\\Users\\WIN 10.DESKTOP-VBBJ1UA\\OneDrive\\Desktop\\script2.exe");
		
		Thread.sleep(8000);
		
		driver.findElement(By.name("firstName")).sendKeys("Ashutosh");
		
		driver.findElement(By.name("lastName")).sendKeys("Singh");
		
		driver.findElement(By.xpath("//label[text() = 'Employee Id']/parent::div/parent::div/div[2]/input")).sendKeys("988");
		
		driver.findElement(By.xpath("//*[@type = 'checkbox']/parent::label/span")).click();
		
		driver.findElement(By.xpath("//div[@class = 'orangehrm-employee-form']/div[3]/div/div[1]/div/div[2]/input")).sendKeys("user123");
		
		driver.findElement(By.xpath("//div[@class = 'orangehrm-employee-form']/div[4]/div/div[1]/div/div[2]/input")).sendKeys("User123");
		
		
		driver.findElement(By.xpath("//div[@class = 'orangehrm-employee-form']/div[4]/div/div[2]/div/div[2]/input")).sendKeys("User123");
		
		
		driver.findElement(By.xpath("//button[text()= ' Save ']")).click();
		
		
		
		
		
		
	}

}
