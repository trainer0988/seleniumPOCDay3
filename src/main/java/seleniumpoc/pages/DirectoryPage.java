package seleniumpoc.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.Page;

public class DirectoryPage extends Page {
	WebDriver driver;
	LeftMenu leftmenu;

	public DirectoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//div[@class = 'oxd-grid-3']/div[2]/div/div[2]/div/div/div")
	WebElement jobTitle;
	
	@FindBy(xpath = "//div[@role = 'listbox']")
	WebElement jobTitlelist;
	
	@FindBy(xpath = "//*[text() = ' Search ']")
	WebElement searchButton;
	
	
	@FindBy(xpath = "//div[@class = 'orangehrm-paper-container']/div[1]/div/span")
	WebElement searchResult;
	
	
	public void selectJobTitle(String jobTitleToBeSelected)
	{
		jobTitle.click();
		
		  List<WebElement> listOfWebElementElemenet = jobTitlelist.findElements(By.tagName("span"));
		  
		Iterator<WebElement> iterator =   listOfWebElementElemenet.iterator();
		while(iterator.hasNext())
		{
			WebElement webElement = iterator.next();
			System.out.println(webElement.getText());
			if(webElement.getText().equalsIgnoreCase(jobTitleToBeSelected))
			{
				System.out.println(webElement.getText());
				webElement.click();
			}
		}
		
		searchButton.click();
  
		  
	}
	
	public String getSearchResult()
	{
		return searchResult.getText();
	}
	
	

}
