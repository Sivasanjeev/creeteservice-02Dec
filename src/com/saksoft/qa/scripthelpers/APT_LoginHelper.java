package com.saksoft.qa.scripthelpers;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;
import com.saksoft.qa.driverlibrary.DriverHelper;
import com.saksoft.qa.driverlibrary.XMLReader;
import com.saksoft.qa.reporter.ExtentTestManager;

public class APT_LoginHelper extends DriverHelper {

	XMLReader xml = new XMLReader("src\\com\\saksoft\\qa\\pagerepository\\APT_LoginPage.xml");

	public APT_LoginHelper(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}

	/**
	 * APT Page Login
	 * 
	 * @param Application
	 * @throws Exception
	 */
	public void LoginHeader(String Application) throws Exception {

		if (Application.equals("APT_headerlogin")) {

			openurl(Application);

			Thread.sleep(3000);

			SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/Username")),
					Getkeyvalue(Application + "_Username"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter User Name");

			SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/Password")),
					Getkeyvalue(Application + "_Password"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Password");

			Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/Loginbutton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Login Button");
			
			
		}

		else if (Application.equals("APT_invalidHeaderLogin")) {

			openurl(Application);

			Thread.sleep(3000);

			SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/Username")),
					Getkeyvalue(Application + "_Username"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter User Name");

			SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/Password")),
					Getkeyvalue(Application + "_Password"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Password");

			Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/Loginbutton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Login Button");

		}

	}

	public void Login(String Application) throws Exception {
		
		
		
		
		if (Application.equals("APT_login_1")) {

			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			
//			String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
//			driver.findElement(By.linkText("urlLink")).sendKeys(selectLinkOpeninNewTab);
			
			openurl(Application);

			Thread.sleep(2000);
			
			SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/Username")),
					Getkeyvalue(Application + "_Username"));
			//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter User Name");

			SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/Password")),
					Getkeyvalue(Application + "_Password"));
			//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Password");

			Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/Loginbutton")));
			//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Login Button");

			
			com.saksoft.qa.driverlibrary.Log.info("=== APT logged in successfully ===");
		}

		else if (Application.equals("APT_login")) {

			openurl(Application);

			Thread.sleep(3000);

			SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/Username")),
					Getkeyvalue(Application + "_Username"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter User Name");

			SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/Password")),
					Getkeyvalue(Application + "_Password"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Password");

			Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/Loginbutton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Login Button");
			
			com.saksoft.qa.driverlibrary.Log.info("=== APT logged in successfully ===");

		}

		else if (Application.equals("APT_invalidLogin")) {

			openurl(Application);

			Thread.sleep(3000);

			SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/Username")),
					Getkeyvalue(Application + "_Username"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter User Name");

			SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/Password")),
					Getkeyvalue(Application + "_Password"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Password");

			Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/Loginbutton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Login Button");
			
			com.saksoft.qa.driverlibrary.Log.info("=== APT failed to logged In ===");
		}
		

	}

}
