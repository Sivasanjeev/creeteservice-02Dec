package com.saksoft.qa.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.saksoft.qa.driverlibrary.DriverTestcase;
import com.saksoft.qa.driverlibrary.Log;
import com.saksoft.qa.reporter.ExtentManager;
import com.saksoft.qa.reporter.ExtentTestManager;

public class TestListener extends DriverTestcase implements ITestListener { 
	
	  private static String getTestMethodName(ITestResult iTestResult) {
	        return iTestResult.getMethod().getConstructorOrMethod().getName();
	    }
	    
	    public void onStart(ITestContext iTestContext) {
	        Log.info("I am on Start method " + iTestContext.getName());
	        
	        iTestContext.setAttribute("WebDriver", this.getwebdriver());
	        
	        System.out.println("Driver instance in Listener"+this.getwebdriver());
	    }
	 
	    public void onFinish(ITestContext iTestContext) {
	        Log.info("I am on Finish method " + iTestContext.getName());
	    }
	 
	    public void onTestStart(ITestResult iTestResult) {
	        Log.info("I am on TestStart method " +  getTestMethodName(iTestResult) + " start");
	        Log.info("I am in onStart method " + iTestResult.getTestContext().getAttribute("testname"));
	    }
	 
	    public void onTestSuccess(ITestResult iTestResult) {
	        Log.info("I am on TestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
	    }
	 
	    public void onTestFailure(ITestResult iTestResult) {
	        Object testClass = iTestResult.getInstance();
	        WebDriver webDriver = ((DriverTestcase) testClass).getwebdriver();
	       
	        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)getwebdriver()).
	                getScreenshotAs(OutputType.BASE64);
	        System.out.println("Result Messages"+iTestResult.getThrowable().getCause().toString());
	    }
	 
	    public void onTestError(ITestResult iTestResult) {
	        Log.info("I am on TestSuccess method " +  getTestMethodName(iTestResult) + " errored");
	            Object testClass = iTestResult.getInstance();
	            WebDriver webDriver = ((DriverTestcase) testClass).getwebdriver();
	     
	            String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)getwebdriver()).
	                    getScreenshotAs(OutputType.BASE64);
	     
	    }

	    public void onTestSkipped(ITestResult iTestResult) {
	        Log.info("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
	    }
	 
	    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	        Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	    }
	 
	}
	
