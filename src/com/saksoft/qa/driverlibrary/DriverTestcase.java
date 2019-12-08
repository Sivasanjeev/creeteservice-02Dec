package com.saksoft.qa.driverlibrary;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.saksoft.qa.scripthelpers.APT_LoginHelper;
import com.saksoft.qa.scripthelpers.APT_MCS_AddMultilinkHelper;
import com.saksoft.qa.scripthelpers.APT_MCS_CreateCustomerHelper;
import com.saksoft.qa.scripthelpers.APT_MCS_CreateOrderServiceHelper;
import com.saksoft.qa.scripthelpers.APT_MCS_SearchCustomerHelper;
import com.saksoft.qa.scripthelpers.APT_MCS_SearchOrderServiceHelper;
import com.saksoft.qa.scripthelpers.APT_ManageCustomerServiceHelper;
import com.saksoft.qa.scripthelpers.InterfaceATM_WAN_PEeditHelper;
import com.saksoft.qa.scripthelpers.InterfaceLANeditHelper;
import com.saksoft.qa.scripthelpers.InterfaceMLPPPeditHelper;
import com.saksoft.qa.scripthelpers.InterfaceMultiLlinkEditHelper;
import com.saksoft.qa.scripthelpers.NegativeScenariosHelper;
import com.saksoft.qa.scripthelpers.VOIP_StatisticsHelper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import com.saksoft.qa.apttestscripts.APT_Login;



public class DriverTestcase {
	
	public static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new InheritableThreadLocal<>();
	//public static final ThreadLocal<RemoteWebDriver> WEB_DRIVER_THREAD_LOCAL = new InheritableThreadLocal<>();
		
		
	public static final ThreadLocal<APT_LoginHelper> APTLogin = new InheritableThreadLocal<>();

	public static final ThreadLocal<InterfaceMultiLlinkEditHelper> MultilinkEdit = new InheritableThreadLocal<>(); 
	
	public static final ThreadLocal<InterfaceLANeditHelper> LANedit = new InheritableThreadLocal<>();
	
	public static final ThreadLocal<InterfaceATM_WAN_PEeditHelper> WANedit = new InheritableThreadLocal<>();
	
	public static final ThreadLocal<InterfaceMLPPPeditHelper> MLPPPedit = new InheritableThreadLocal<>();
	
	public static final ThreadLocal<VOIP_StatisticsHelper> VOIPstatistics = new InheritableThreadLocal<>();
	
	public static final ThreadLocal<APT_MCS_CreateOrderServiceHelper> createOrderServiceHelper = new InheritableThreadLocal<>();
			
		
		
		
		
		public static com.saksoft.qa.listeners.TestListener Testlistener;
		public ThreadLocal<String> TestName=new ThreadLocal(); 
		public static SessionId session_id;
		public static ChromeDriver driver;
		public static int  itr;
		
		public static ExtentReports extent;
		public static ExtentTest logger;
		
		@org.testng.annotations.BeforeSuite
		public void BeforeSuite(){
		itr=0;
		DOMConfigurator.configure("log4j.xml");	//For log
		Log.clearFile("C:\\Users\\SKathiresan-ADM\\eclipse-workspace\\latest\\APTprojectdemo-master\\Logs\\logfile.log");
		}
		
   @org.testng.annotations.Parameters({ "test-name" })	
	@BeforeTest
	//@org.testng.annotations.Parameters("browser")
	 public void startReport(){
		
		String dateName1 = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
	 		//extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/PK_ExtentReport2.html", true);
			// extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/PK_ExtentReport/"+dateName1+".html", true);
		
		extent = new ExtentReports (System.getProperty("user.dir") +"/ExtentReports/"+"PK_ExtentReport-"+dateName1+".html", true);
		
	 extent.addSystemInfo("Host Name", "DO").addSystemInfo("Environment", "QA").addSystemInfo("User Name", "PramodKumar12345");
	                //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
	                //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
	               // extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	 }
	 
	        //This method is to capture the screenshot and return the path of the screenshot.
	 
	 public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		 
     
				 
				 
	 String dateName2 = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	 TakesScreenshot ts = (TakesScreenshot) driver;
	 File source = ts.getScreenshotAs(OutputType.FILE);
	                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
	  
	 String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+"-"+dateName2+".png";
	 
	 File finalDestination = new File(destination);
	 FileUtils.copyFile(source, finalDestination);
	 return destination;
	 }
	
   public WebDriver dr = null;
	@BeforeClass
	public void setup() throws Exception
	{
		// Open Browser
	  
		
		PropertyReader pr=new PropertyReader();
		String targatedbrowser=pr.readproperty("browser");	
		String url=pr.readproperty("URL");
		Log.info("URL");
		
		if(targatedbrowser.equalsIgnoreCase("chrome"))
		{ 
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			Map<String, Object> prefs = new HashMap<String, Object>();
			 // Set the notification setting it will override the default setting
			prefs.put("profile.default_content_setting_values.notifications", 2);

            // Create object of ChromeOption class
			ChromeOptions options1 = new ChromeOptions();
			options1.setExperimentalOption("prefs", prefs);
			capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options1);
			System.setProperty("webdriver.chrome.driver",".\\lib\\chromedriver.exe");
			dr= new ChromeDriver(capabilities);
		}
		
		
		
		else if (targatedbrowser.equalsIgnoreCase("firefox"))
		{
			Log.info("For FF inprogress");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			Map<String, Object> prefs = new HashMap<String, Object>();
			 // Set the notification setting it will override the default setting
			prefs.put("profile.default_content_setting_values.notifications", 2);

            // Create object of FirefoxOptions class
			FirefoxOptions options2 = new FirefoxOptions();
//			options2.setExperimentalOption("prefs", prefs);
			
			capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
//			capabilities.setCapability(FirefoxOptions.CAPABILITY, options2);
			System.setProperty("webdriver.gecko.driver",".\\lib\\geckodriver.exe");
			dr= new FirefoxDriver(capabilities);
			
			
			Log.info("firefox launching");
		}
		
		
		
		else if (targatedbrowser.equalsIgnoreCase("ie"))
		{
			Log.info("For ie inprogress");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			Map<String, Object> prefs = new HashMap<String, Object>();
			 // Set the notification setting it will override the default setting
			prefs.put("profile.default_content_setting_values.notifications", 2);

            // Create object of ieOptions class
			InternetExplorerOptions options3 = new InternetExplorerOptions();
			//options3.ignoreZoomSettings();
			
			capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
			//capabilities.setCapability(InternetExplorerOptions.CAPABILITY, options3);

			System.setProperty("webdriver.ie.driver",".\\lib\\IEDriverServer.exe");
			dr= new InternetExplorerDriver(capabilities);
			
			
			Log.info("IE launching");
		}
		
		else
		{
			Log.info("For MS Edge is inprogress");
		}
		

		
		dr.manage().window().maximize();
		WEB_DRIVER_THREAD_LOCAL.set(dr);
		Thread.sleep(3000);

		
		/**
		 * For APT projects
		 */
		APT_LoginHelper apt = new APT_LoginHelper(getwebdriver());
		APTLogin.set(apt);
		
		InterfaceMultiLlinkEditHelper intfaceEdit1 = new InterfaceMultiLlinkEditHelper(getwebdriver());
		MultilinkEdit.set(intfaceEdit1);
		
		InterfaceLANeditHelper LanEdit = new InterfaceLANeditHelper(getwebdriver());
		LANedit.set(LanEdit);
				
		InterfaceATM_WAN_PEeditHelper WanEdit = new InterfaceATM_WAN_PEeditHelper(getwebdriver());
		WANedit.set(WanEdit);
		
		InterfaceMLPPPeditHelper PPPEdit = new InterfaceMLPPPeditHelper(getwebdriver());
		MLPPPedit.set(PPPEdit);
		
		VOIP_StatisticsHelper voip = new VOIP_StatisticsHelper(getwebdriver());
		VOIPstatistics.set(voip);
		
		
		APT_MCS_CreateOrderServiceHelper createServiceOrder = new APT_MCS_CreateOrderServiceHelper(getwebdriver());
		createOrderServiceHelper.set(createServiceOrder);

		
//		DriverHelper driverHelper= new DriverHelper(getwebdriver());
//		driverHelper.Pagerefresh();
		
	}


	
	
	 @AfterMethod
	 public void getResult(ITestResult result) throws Exception{
		 if(result.getStatus() == ITestResult.FAILURE){
		 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
		 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		 String base64ScreenshotPath = "data:image/png;base64,"+((TakesScreenshot)getwebdriver()).getScreenshotAs(OutputType.BASE64);		 
		 logger.log(LogStatus.FAIL, logger.addScreenCapture(base64ScreenshotPath));
		 }else if(result.getStatus() == ITestResult.SKIP){
		 logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		 												}

	 
	 }
	
	 
	 @AfterClass
		public void Teardown()
		{
//			dr.close();
		}
		public static WebDriver getwebdriver() {
			WebDriver dr = WEB_DRIVER_THREAD_LOCAL.get();
			return dr;
		}
		
		
	 @AfterTest
	 public void endReport(){

		 			extent.flush();
	                extent.endTest(logger); //It ends the current test and prepares to create HTML report
	                
	//                extent.close();
		 
	    }
	 
	 
	 
	
	
	@BeforeMethod
	 public void BeforeMethod(Method method,ITestContext ctx, Object[] data) throws IOException, Exception{
			//	setup();
				Object[] st = null;
				
				try 
				
				{
			 	st=(Object[]) data[0];
				}
				catch(Exception e)
				{
					st=new Object[][] {{""}};
				}
			 
				
			
				
				
				
	}	
	
	
	
	
	
	
	
}
