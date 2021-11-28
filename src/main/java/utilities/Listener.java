package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends CommonOps implements ITestListener {
    public void onStart(ITestContext execution) {
        // TODO Auto-generated method stub
    }

    public void onFinish(ITestContext execution) {
        // TODO Auto-generated method stub
    }

    public void onTestStart(ITestResult test) {
        // TODO Auto-generated method stub
    }

    public void onTestSuccess(ITestResult test) {
        // TODO Auto-generated method stub
    }

    public void onTestFailure(ITestResult test) {
        System.out.println("test failed");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult test) {
        // TODO Auto-generated method stub
    }

    public void onTestSkipped(ITestResult test) {
        // TODO Auto-generated method stub
    }
}

