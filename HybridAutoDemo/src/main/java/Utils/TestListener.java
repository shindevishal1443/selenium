package Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Base.BaseClass;

public class TestListener implements ITestListener {
	ExtentSparkReporter sparkReporter;
    ExtentReports extent;
    ExtentTest test;

    @Override
    public void onTestFailure(ITestResult result) {
        BaseClass base = (BaseClass) result.getInstance();
        String path = base.tScreenshot(result.getName());
        if(path != null) {
            System.out.println("Screenshot saved at: " + path);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
    	 test = extent.createTest(result.getMethod().getMethodName());
    	
    }
    @Override
    public void onTestSuccess(ITestResult result) {
    	 test.pass("Test Passed");
    }
    @Override
    public void onTestSkipped(ITestResult result) {
    	 test.skip(result.getThrowable());
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override
    public void onStart(ITestContext context) {
    	sparkReporter = new ExtentSparkReporter("C:\\Users\\visha\\eclipse-workspace\\Practice\\Reports\\");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }
    @Override
    public void onFinish(ITestContext context) {
    	extent.flush();
    }
}
