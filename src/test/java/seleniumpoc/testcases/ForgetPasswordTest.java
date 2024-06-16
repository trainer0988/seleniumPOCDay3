package seleniumpoc.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumpoc.pages.LoginPage;

public class ForgetPasswordTest extends BaseTest{
	
	@Test(priority = 1)
	public void forgetpasswordFlowTest()
	{
		String expecetd_url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";
		String new_url = loginPage.getForgetOasswordUrl();
		Assert.assertEquals(new_url, expecetd_url);	
	}
	

}
