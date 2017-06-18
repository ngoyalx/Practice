package Xebia.SampleMavenProject;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Retry implements IRetryAnalyzer{
	private int retryCount = 0;
    private int maxRetryCount = 4;
  

@Override
public boolean retry(ITestResult result) {
	if (retryCount < maxRetryCount) {
        System.out.println("Retrying test " + result.getName() + " with status "
                + (result.getStatus()) + " for the " + (retryCount+1) + " time(s).");
        retryCount++;
        return true;
    }
    return false;
}
}
