package Xebia.SampleMavenProject;

import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class CustomeListner implements ITestListener {
 

@Override
public void onTestStart(ITestResult result) {
	System.out.println("Test case is starting as per listner");
	
}

@Override
public void onTestSuccess(ITestResult result) {
	System.out.println("Test listner is also saying test case :" + result.getName() + " is passed");
	
}

@Override
public void onTestFailure(ITestResult result) {
	System.out.println("Test listner is also saying test case is failed");
	
}

@Override
public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	
}

@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	
}

@Override
public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	
}

@Override
public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	
}
}
