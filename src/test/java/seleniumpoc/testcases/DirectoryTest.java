package seleniumpoc.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumpoc.pages.DashBoardPage;
import seleniumpoc.pages.DirectoryPage;

public class DirectoryTest  extends BaseTest{
	//retryAnalyzer = Retry.class
	@Test
	public void verifySearchInDirectory()
	{
		System.out.println("Start executing............");
		DashBoardPage dashboardPage =loginPage.doLogin("Admin", "admin123");
		
		DirectoryPage directoryPage = dashboardPage.getleftMenu().goToDirectoryPage();
		
		directoryPage.selectJobTitle("Chief Financial Officer");
		
		String serachResult = directoryPage.getSearchResult();
		System.out.println(serachResult);
		
		Assert.assertTrue(serachResult.contains("Found"));
		
	}

}
