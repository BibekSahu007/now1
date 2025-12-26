package crm_listernerUtility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class DummyListeners implements ITestListener, ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		System.out.println("-------On Suite Start--------");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("-------On Suite Finish--------");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("-------On Test Start--------");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("-------On Test Sucess--------");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("-------On Test Failure--------");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("-------On Test Skipped--------");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("-------On Test Failed But With in Success Percentage--------");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("-------On Test Failed With Timeout--------");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("-------On Start Context--------");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("-------On Finish Context--------");
	}
	
}
