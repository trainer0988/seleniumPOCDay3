package seleniumpoc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftMenu {
	
	WebDriver driver ;
	public LeftMenu(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text() = 'PIM']")
	WebElement pim;
	
	@FindBy(xpath = "//span[text() = 'Leave']")
	WebElement leave;
	
	
	public PIMPage goToPIMPage()
	{
		pim.click();
		return new PIMPage(driver);
	}
	

	
	
	

}
