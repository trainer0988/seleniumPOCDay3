package seleniumpoc.pages;

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
	
	
	

}
