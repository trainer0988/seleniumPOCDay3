package seleniumpoc.testcases;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumpoc.pages.DashBoardPage;
import seleniumpoc.pages.LoginPage;
import seleniumpoc.pages.PIMPage;

public class UserCreationTest extends BaseTest {

	 Random random=new Random();
		int a = random.nextInt(1000);

	String firstName = "localAdmin";
	String LastName = "localAdmin";
	String empid = "44" + a;
	String userName = "localAdmin1" + a;
	String password = "localAdmin1" + a;

	@Test(priority = 1)
	public void verifyUserCreationFlow() throws InterruptedException {

		DashBoardPage dashboardPage = loginPage.doLogin("Admin", "admin123");

		PIMPage pimPage = dashboardPage.getleftMenu().goToPIMPage();
		pimPage.navigateToAddEmployee();;
		pimPage.addEmployeeDetails(firstName, LastName, empid);
		pimPage.addLoginDetails(userName, password);

		System.out.println(pimPage.getToastMessage());
		Assert.assertEquals(pimPage.getToastMessage(), "Successfully Saved");

		Assert.assertEquals(pimPage.getFirstName().split(" ")[0], firstName);

	}

}