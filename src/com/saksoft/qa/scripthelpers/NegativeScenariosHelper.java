package com.saksoft.qa.scripthelpers;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.saksoft.qa.driverlibrary.DriverHelper;
import com.saksoft.qa.driverlibrary.Log;
import com.saksoft.qa.driverlibrary.XMLReader;

public class NegativeScenariosHelper  extends DriverHelper{
	
	public NegativeScenariosHelper(WebDriver dr) {
		super(dr);
	}
	
	public static String phoneEnteredValue;
	SoftAssert sa=new SoftAssert();
	XMLReader xml=new XMLReader("src\\com\\saksoft\\qa\\pagerepository\\APT_MCS_CreateCustomer.xml");
	
	public void navigateToManageCustomerServicePage() throws InterruptedException, DocumentException {
		Thread.sleep(2000);
		Clickon(getwebelement(xml.getlocator("//locators/ManageCustomerServiceLink")));						Thread.sleep(2000);
		Log.info("=== MCS page navigated ===");
		Thread.sleep(2000);
	}
	
	
	public void navigateToCreateCustomerPage(String application) throws InterruptedException, DocumentException {
		navigateToManageCustomerServicePage();

		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/CreateCustomerLink"))); 			Thread.sleep(2000);
		Log.info("=== Create customer navigated ===");	
	}
	
	
	
	public void createCustomerFunctionality(String application,  String Phone, String Fax) throws InterruptedException, DocumentException, IOException {
		navigateToCreateCustomerPage("CreateCustomer");
		
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/Phone")), Phone);									Thread.sleep(1000);
		Log.info("=== Phone Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/Fax")), Fax);										Thread.sleep(1000);
		Log.info("=== Fax Entered ===");
		//String phoneEnteredValue=getwebelement(xml.getlocator("//locators/"+application+"/Phone")).getAttribute("value");
		
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/OkButton_CreateCustomer")));
		Log.info("=== OK button clicked ===");	Thread.sleep(2000);	
	}
	
	
	public void checkWetherTextFieldIsAcceptingCharOrNumericOrSpecialCharacter(String inputData) {
		java.util.Scanner scn=new java.util.Scanner(System.in);
		char ch=scn.next().charAt(0);
		
		if((ch>='a' && ch<='z')|| (ch>='A' && ch<='Z')) {
			System.out.println("==  Given character is Alphabet ==");
		}else {
			System.out.println("==  Given character is AlphaNumeric ==");
		}
	}
	
	
	
	public void checkWetherTextFieldIsEmptyOrNot(String application, String GeneratePassword) throws InterruptedException, DocumentException, IOException {
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/GeneratePasswordLink")));					Thread.sleep(2000);
		String  password=getwebelement(xml.getlocator("//locators/"+application+"/Password_Textfield")).getAttribute("value");
		if(password.isEmpty()) {
			Reporter.log("== Password text is empty after clicked on 'Generate password link' ==");
			SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/Password_Textfield")), GeneratePassword);	Thread.sleep(1000);
			Log.info("===Password Entered ===");
			sa.fail("== Password text is empty after clicked on 'Generate password link' ==");
		}else {
			Log.info("Password value is : "+ password);
		}
	
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}