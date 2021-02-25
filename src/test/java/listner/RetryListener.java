package listner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer {
	
	int count = 4;
	int retry = 0;
	
	@Override
	public boolean retry(ITestResult result) {
		if(retry<count) {
			retry++;
			return true;
		}
		return false;
	}
	
}
