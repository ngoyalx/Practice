package Xebia.SampleMavenProject;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Iterator;

@Listeners(SampleTestClass.Listener.class)
public class SampleTestClass implements IHookable {
    @Test(dataProvider = "dp")
    public void testMethod(String name) {
        System.err.println("Incoming parameter was " + name);
    }

    @DataProvider(name = "dp")
    public Object[][] getData() {
        return new Object[][] {
            {"junit"},
            {"testng"}
        };
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        String parameter = (String) callBack.getParameters()[0];
        if (! "junit".equalsIgnoreCase(parameter)) {
            callBack.runTestMethod(testResult);
        } else {
            testResult.setAttribute("disabled", true);
            throw new SkipException("Skipping ");
        }
    }

    public static class Listener implements ITestListener {

        @Override
        public void onTestStart(ITestResult result) {

        }

        @Override
        public void onTestSuccess(ITestResult result) {

        }

        @Override
        public void onTestFailure(ITestResult result) {

        }

        @Override
        public void onTestSkipped(ITestResult result) {

        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        }

        @Override
        public void onStart(ITestContext context) {

        }

        @Override
        public void onFinish(ITestContext context) {
            Iterator<ITestResult> iterator = context.getSkippedTests().getAllResults().iterator();
            while (iterator.hasNext()) {
                ITestResult result = iterator.next();
                if (Boolean.parseBoolean(result.getAttribute("disabled").toString())) {
                    iterator.remove();
                }
            }
        }
    }
}