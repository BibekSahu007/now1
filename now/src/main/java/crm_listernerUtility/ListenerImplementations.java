package crm_listernerUtility;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import crm_Generic_baseUtility.BaseClass;
import crm_generic_WebdriverUtility.UtilityClassObject;

public class ListenerImplementations implements ITestListener, ISuiteListener{
	public ExtentSparkReporter sp;
	public ExtentReports report;
	public ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-------Started");
		test=report.createTest(methodName);
		UtilityClassObject.setTest(test);//parallel execution
		test.log(Status.INFO,methodName+"==Started");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-------Passed");
		test.log(Status.PASS,methodName+"==Completed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-------Failed");
		TakesScreenshot ts= (TakesScreenshot) BaseClass.sDriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		String time= new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath,methodName+"-"+time);
		test.log(Status.FAIL,methodName+"==Failed");
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-------Skipped");
	}
	@Override
	public void onStart(ISuite Suite) {
		System.out.println("----Suite Execution Started");
		String time= new Date().toString().replace(" ", "_").replace(":", "_");
		sp=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		sp.config().setDocumentTitle("CRM Test Suite Result");
		sp.config().setReportName("CRM Report");
		sp.config().setTheme(Theme.DARK);
		//add evn info and create test
		report=new ExtentReports();
		report.attachReporter(sp);
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("os", "Window-11");
	}
	@Override
	public void onFinish(ISuite Suite) {
		System.out.println("----Suite Execution Finished");
		report.flush();
	}
	
}
