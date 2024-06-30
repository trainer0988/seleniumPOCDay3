package seleniumpoc.testcases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

public class Retry implements IRetryAnalyzer {

	int count = 0;
	int maxTry = 2;
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxTry)
		{
			count= count +1;
			return true;
		}
		else
		{
		return false;
		}
		
	}

}
