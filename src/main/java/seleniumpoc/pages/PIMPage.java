package seleniumpoc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.Page;

public class PIMPage extends Page {

	WebDriver driver;
	

	public PIMPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	By presenceOfName = By.xpath("//div[@class = 'orangehrm-edit-employee-name']/h6");
	
	@FindBy(xpath = "//*[@class = 'oxd-toast-start']/div[2]/p[2]")
	WebElement toastMessage;
	
	@FindBy(className = "orangehrm-edit-employee-navigation")
	WebElement empNavigation;

	@FindBy(xpath = "//div[@class = 'orangehrm-edit-employee-name']/h6")
	WebElement Savedname;
	
	@FindBy(xpath = "//nav[@aria-label = 'Topbar Menu' ]/ul/li[3]/a")
	WebElement addEmployee;
	
	@FindBy(xpath = "//nav[@aria-label = 'Topbar Menu' ]/ul/li[2]/a")
	WebElement employeeList;

	@FindBy(xpath = "//img[@class = 'employee-image']")
	WebElement profilePicAddLink;

	@FindBy(name = "firstName")
	WebElement firstNameField;

	@FindBy(name = "lastName")
	WebElement lastNameField;

	@FindBy(xpath = "//label[text() = 'Employee Id']/parent::div/parent::div/div[2]/input")
	WebElement empIdField;

	@FindBy(xpath = "//*[@type = 'checkbox']/parent::label/span")
	WebElement createLoginDetails;

	@FindBy(xpath = "//div[@class = 'orangehrm-employee-form']/div[3]/div/div[1]/div/div[2]/input")
	WebElement userNameFiled;

	@FindBy(xpath = "//div[@class = 'orangehrm-employee-form']/div[4]/div/div[1]/div/div[2]/input")
	WebElement passwordField;

	@FindBy(xpath = "//div[@class = 'orangehrm-employee-form']/div[4]/div/div[2]/div/div[2]/input")
	WebElement confirmPasswordField;

	@FindBy(xpath = "//button[text()= ' Save ']")
	WebElement saveButton;
	
	@FindBy(xpath = "//*[@type = 'file']")
	WebElement profilePic;
	
	public void navigateToAddEmployee() {
		addEmployee.click();
	}
	
	//Emplist elements 
	@FindBy(xpath = "//div[@class = 'oxd-form-row']/div/div[1]/div/div[2]//input")
	WebElement firtName;
	
	public void navigateToEmployeeList() {
		employeeList.click();
	}
	
	public void uploadProfilePic(String path) {
		
		profilePic.sendKeys("C:\\Users\\WIN 10.DESKTOP-VBBJ1UA\\OneDrive\\Desktop\\status.png");

	}
	
	public void addEmployeeDetails(String firstName,String lastname, String empid)
	{
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastname);
		empIdField.clear();
		empIdField.sendKeys(empid);
	}
	
	public void addLoginDetails(String userName, String password)
	{
		createLoginDetails.click();
		userNameFiled.sendKeys(userName);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(password);
		saveButton.click();
		
		
	}
	
	
	public String getToastMessage()
	{
		return toastMessage.getText();
	}
	
	
	public String getFirstName() throws InterruptedException
	{
		
		waitForSpinerToDisappear();
		waitForVisibilityOfElement(Savedname, "localAdmin");		
		return Savedname.getText();
	}
	
	
}
