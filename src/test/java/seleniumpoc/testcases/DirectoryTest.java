package seleniumpoc.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumpoc.pages.DashBoardPage;
import seleniumpoc.pages.DirectoryPage;

public class DirectoryTest  extends BaseTest{
	
	@Test(retryAnalyzer = Retry.class)
	public void verifySearchInDirectory()
	{
		System.out.println("Start executing............");
		DashBoardPage dashboardPage =loginPage.doLogin("Admin", "admin123");
		
		DirectoryPage directoryPage = dashboardPage.getleftMenu().goToDirectoryPage();
		
		directoryPage.selectJobTitle("Chief Financial Officer");
		
		String serachResult = directoryPage.getSearchResult();
		
		Assert.assertTrue(serachResult.contains("Record Found"));
		
	}

}
