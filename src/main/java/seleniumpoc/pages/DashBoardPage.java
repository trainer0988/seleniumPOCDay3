package seleniumpoc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.Page;

public class DashBoardPage  extends Page{
	WebDriver driver;
	LeftMenu leftmenu;

	public DashBoardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public LeftMenu getleftMenu() {
		leftmenu = new LeftMenu(driver);
		return leftmenu;

	}


}
