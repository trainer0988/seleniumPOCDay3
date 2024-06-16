package seleniumpoc.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.Page;

public class LoginPage extends Page{
	

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[@name = 'username']")
	WebElement userNameField;
	
	
	@FindBy(xpath = "//input[@name = 'password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement loginButton;
	
	
	@FindBy(xpath = "//div[@class = 'orangehrm-login-forgot']")
	WebElement forgotPassword;
	
	
	@FindBy(xpath = "//button[text() = ' Cancel ']")
	WebElement cancel;
	
	@FindBy(xpath = "//div[@class = 'orangehrm-login-footer-sm']/a[2]")
	WebElement facebooklink;
	
	public DashBoardPage doLogin(String userName, String password)
	{
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		loginButton.click();
		return new DashBoardPage(driver);
		
	}
	
	
	public String getForgetOasswordUrl()
	{
		forgotPassword.click();
		String new_url = driver.getCurrentUrl();
		cancel.click();
		return new_url;
		
	}
	
	
	public String navigateToFacebook()
	{
		String url =null;
		String primaryWindow =  driver.getWindowHandle();
		facebooklink.click();
		Set<String> listOfWindow = driver.getWindowHandles();
		Iterator<String> itr = listOfWindow.iterator();
		while(itr.hasNext())
		{
			String window = itr.next();
			if(!(window.equalsIgnoreCase(primaryWindow)))
			{
				driver.switchTo().window(window);
				url = driver.getCurrentUrl();
				driver.close();
				driver.switchTo().window(primaryWindow);
			}
		}
		return url;

		
	}
	
	
	

}
