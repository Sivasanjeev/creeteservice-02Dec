package com.saksoft.qa.scripthelpers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;
import com.saksoft.qa.driverlibrary.DriverHelper;
import com.saksoft.qa.driverlibrary.Log;
import com.saksoft.qa.driverlibrary.XMLReader;
import com.saksoft.qa.excellibrary.APT_DataWriter;
import com.saksoft.qa.reporter.ExtentTestManager;
import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.java_cup.internal.runtime.Symbol;


public class APT_MCS_CreateCustomerHelper extends DriverHelper {
	WebDriver driver;
	public APT_MCS_CreateCustomerHelper(WebDriver dr) {
		super(dr);
		driver=dr;
	}
	
	WebElement Name_Textfield, MainDomain_Textfield, countryDropdown, OCN_Textfield, Reference_Textfield, TechnicalContactName_Textfield, Type_Textfield, Email_Textfield, Phone_Textfield, Fax_Textfield, EnableDedicatedPortal_TextField, OkButton_CreateCustomer, CancelButton_CreateCustomer, typeDropdown ;
	SoftAssert sa=new SoftAssert();
	XMLReader xml=new XMLReader("src\\com\\saksoft\\qa\\pagerepository\\APT_MCS_CreateCustomer.xml");
	
	public void navigateToManageCustomerServicePage(String application) throws InterruptedException, DocumentException {
		
		driver.navigate().refresh();
		Thread.sleep(2000);
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/ManageCustomerServiceLink")));						Thread.sleep(2000);
		Log.info("=== MCS page navigated ===");
		Thread.sleep(2000);
	}
	
	
	public void navigateToCreateCustomerPage(String application) throws InterruptedException, DocumentException {
		navigateToManageCustomerServicePage(application);
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/CreateCustomerLink"))); 	
		Thread.sleep(2000);
		Log.info("=== Create customer navigated ===");	
	}
	
	
	public void verifyCreateCustomerFields(String application) throws InterruptedException, DocumentException, IOException {
		
		
		navigateToCreateCustomerPage("CreateCustomer");
		
		Name_Textfield = getwebelement(xml.getlocator("//locators/" + application + "/Name_Textfield"));
		sa.assertTrue(Name_Textfield.isDisplayed(),"name field is not displayed");
//		sa.assertTrue(Name_Textfield.isEnabled(), "name field is not disabled");
		
		MainDomain_Textfield = getwebelement(xml.getlocator("//locators/" + application + "/MainDomain_Textfield"));
		sa.assertTrue(MainDomain_Textfield.isDisplayed(),"MainDomain_Textfield is not displayed");
//		sa.assertTrue(MainDomain_Textfield.isEnabled(), "MainDomain_Textfield is not disabled");
		
		countryDropdown = getwebelement(xml.getlocator("//locators/" + application + "/Country_Textfield"));
		sa.assertTrue(countryDropdown.isDisplayed(),"countrydropdown  is not displayed");
//		sa.assertTrue(countryDropdown.isEnabled(), "countryropdown is not disabled");
		
		OCN_Textfield = getwebelement(xml.getlocator("//locators/" + application + "/OCN_Textfield"));
		sa.assertTrue(OCN_Textfield.isDisplayed(),"OCN_Textfield is not displayed");
//		sa.assertTrue(OCN_Textfield.isEnabled(), "OCN_Textfield is not disabled");
		
		Reference_Textfield = getwebelement(xml.getlocator("//locators/" + application + "/Reference_Textfield"));
		sa.assertTrue(Reference_Textfield.isDisplayed(),"Reference_Textfield is not displayed");
//		sa.assertTrue(Reference_Textfield.isEnabled(), "Reference_Textfield is not disabled");
		
		TechnicalContactName_Textfield = getwebelement(xml.getlocator("//locators/" + application + "/TechnicalContactName_Textfield"));
		sa.assertTrue(TechnicalContactName_Textfield.isDisplayed(),"TechnicalContactName_Textfield is not displayed");
//		sa.assertTrue(TechnicalContactName_Textfield.isEnabled(), "TechnicalContactName_Textfield is not disabled");
		
		Type_Textfield = getwebelement(xml.getlocator("//locators/" + application + "/Type_Textfield"));
		sa.assertTrue(Type_Textfield.isDisplayed(),"Type_Textfield is not displayed");
//		sa.assertTrue(Type_Textfield.isEnabled(), "Type_Textfield is not disabled");
		
		Email_Textfield = getwebelement(xml.getlocator("//locators/" + application + "/Email_Textfield"));
		sa.assertTrue(Email_Textfield.isDisplayed(),"Email_Textfield is not displayed");
//		sa.assertTrue(Email_Textfield.isEnabled(), "Email_Textfield is not disabled");
		
		Phone_Textfield = getwebelement(xml.getlocator("//locators/" + application + "/Phone_Textfield"));
		sa.assertTrue(Phone_Textfield.isDisplayed(),"name field is not displayed");
//		sa.assertTrue(Phone_Textfield.isEnabled(), "name field is not disabled");
		
		Fax_Textfield = getwebelement(xml.getlocator("//locators/" + application + "/Fax_Textfield"));
		sa.assertTrue(Fax_Textfield.isDisplayed(),"Fax_Textfield is not displayed");
//		sa.assertTrue(Fax_Textfield.isEnabled(), "Fax_Textfield is not disabled");
		
		EnableDedicatedPortal_TextField = getwebelement(xml.getlocator("//locators/" + application + "/EnableDedicatedPortal_TextField"));
		sa.assertTrue(EnableDedicatedPortal_TextField.isDisplayed(),"EnableDedicatedPortal_TextField is not displayed");
//		sa.assertTrue(EnableDedicatedPortal_TextField.isEnabled(), "EnableDedicatedPortal_TextField is not disabled");
		
		OkButton_CreateCustomer = getwebelement(xml.getlocator("//locators/" + application + "/OkButton_CreateCustomer"));
		sa.assertTrue(OkButton_CreateCustomer.isDisplayed(),"OkButton_CreateCustomer  is not displayed");
//		sa.assertTrue(OkButton_CreateCustomer.isEnabled(), "OkButton_CreateCustomer is not disabled");
	
		CancelButton_CreateCustomer = getwebelement(xml.getlocator("//locators/" + application + "/CancelButton_CreateCustomer"));
		sa.assertTrue(CancelButton_CreateCustomer.isDisplayed(),"CancelButton_CreateCustomer  is not displayed");
//		sa.assertTrue(CancelButton_CreateCustomer.isEnabled(), "CancelButton_CreateCustomer is not disabled");
		
		//<CustomerCreatedSuccessfullyMessage_Text>//div[text()='Customer Created successfully']</CustomerCreatedSuccessfullyMessage_Text>
		
		Log.info("=== Create customer all fields Verified ===");
		sa.assertAll();
	}
	
	WebElement Nameisrequired_Text, MainDomainisrequired_Text, Countryisrequired_Text, OCNisrequired_Text, Typeisrequired_Text, Emailisrequired_Text;
	public void verifyCreateCustomerMandatoryFields(String application) throws InterruptedException, DocumentException, IOException {
		navigateToCreateCustomerPage("CreateCustomer");
		
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/OkButton_CreateCustomer")));  						Thread.sleep(2000);
		Log.info("=== OK button clicked ===");	
		
		Nameisrequired_Text = getwebelement(xml.getlocator("//locators/" + application + "/Nameisrequired_Text"));
		sa.assertTrue(Nameisrequired_Text.isDisplayed(),"Nameisrequired_Text is not displayed");
		sa.assertTrue(Nameisrequired_Text.isEnabled(), "Nameisrequired_Text is not disabled");
		
		MainDomainisrequired_Text = getwebelement(xml.getlocator("//locators/" + application + "/MainDomainisrequired_Text"));
		sa.assertTrue(MainDomainisrequired_Text.isDisplayed(),"MainDomainisrequired_Text is not displayed");
		sa.assertTrue(MainDomainisrequired_Text.isEnabled(), "MainDomainisrequired_Text is not disabled");
		
//		Countryisrequired_Text = getwebelement(xml.getlocator("//locators/" + application + "/Countryisrequired_Text"));
//		sa.assertTrue(Countryisrequired_Text.isDisplayed(),"Countryisrequired_Text  is not displayed");
//		sa.assertTrue(Countryisrequired_Text.isEnabled(), "Countryisrequired_Text is not disabled");
		
		OCNisrequired_Text = getwebelement(xml.getlocator("//locators/" + application + "/OCNisrequired_Text"));
		sa.assertTrue(OCNisrequired_Text.isDisplayed(),"OCNisrequired_Text is not displayed");
		sa.assertTrue(OCNisrequired_Text.isEnabled(), "OCNisrequired_Text is not disabled");
		
		Typeisrequired_Text = getwebelement(xml.getlocator("//locators/" + application + "/Typeisrequired_Text"));
		sa.assertTrue(Typeisrequired_Text.isDisplayed(),"Typeisrequired_Text is not displayed");
		sa.assertTrue(Typeisrequired_Text.isEnabled(), "Typeisrequired_Text is not disabled");
		
		Emailisrequired_Text = getwebelement(xml.getlocator("//locators/" + application + "/Emailisrequired_Text"));
		sa.assertTrue(Emailisrequired_Text.isDisplayed(),"Emailisrequired_Text is not displayed");
		sa.assertTrue(Emailisrequired_Text.isEnabled(), "Emailisrequired_Text is not disabled");
				
		Log.info("=== Create customer all mandatory fields Verified ===");
		
		sa.assertAll();	
	}
	
	
	public void verifyCreateCustomerFields2(String application) throws InterruptedException, DocumentException, IOException {
		navigateToCreateCustomerPage("CreateCustomer");
		
		// verify name fields
				//getwebelement(xml.getlocator("//locators/" + application + "/name")).clear();
				String s1 = getwebelement(xml.getlocator("//locators/"+application+"/name")).getAttribute("value");
				if (s1.isEmpty()) {

					sa.fail("name value is empty");
				} else {

					Log.info("name value is : " + s1);
				}

				//verify Phone
				String s2 = getwebelement(xml.getlocator("//locators/"+application+"/Phone")).getAttribute("value");
				if (s2.isEmpty()) {

					sa.fail("phone value is empty");
				} else {

					Log.info("phone value is : " + s2);
				}

				//verify Email
				String s3 = getwebelement(xml.getlocator("//locators/"+application+"/email")).getAttribute("value");
				if (s3.isEmpty()) {

					sa.fail("email value is Empty");
				} else {

					Log.info("email value is : " + s3);
				}

				sa.assertAll();
		
	}
	
	WebElement DedicatePortal_Text;
	public void verifyDedicatedPortalDisplayedOrNot(String application) throws InterruptedException, DocumentException, IOException {
		navigateToCreateCustomerPage("CreateCustomer");
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/EnableDedicatedPortalCheckbox")));			Thread.sleep(1000);
		
		DedicatePortal_Text = getwebelement(xml.getlocator("//locators/" + application + "/DedicatePortal_Text"));
		sa.assertTrue(DedicatePortal_Text.isDisplayed(),"DedicatePortal_Text is not displayed");
		sa.assertTrue(DedicatePortal_Text.isEnabled(), "DedicatePortal_Text is not disabled");
		
		Log.info("Dedicate Portal Text is Displayed");
		
	}
	
	
		
	public void SelectDedicatedPortal_IfDedicatedPortalStatus_Yes2(String application, String DedicatedPortalStatus, String DedicatedPortal) throws InterruptedException, DocumentException, IOException {
		navigateToCreateCustomerPage("CreateCustomer");
		if(DedicatedPortalStatus.equalsIgnoreCase("Yes")) {
			Clickon(getwebelement(xml.getlocator("//locators/"+application+"/EnableDedicatedPortalCheckbox")));									Thread.sleep(1000);
			Select(getwebelement(xml.getlocator("//locators/"+application+"/DedicatePortal_Select")), DedicatedPortal);							Thread.sleep(1000);
			Log.info("=== Dedicate Portal checkbox Selected ===");
		}else if (DedicatedPortalStatus.equalsIgnoreCase("No")) {
			Log.info("=== Dedicate Portal checkbox Not Selected SInce DedicatedPortalStatus is No ===");			
		}else if (DedicatedPortalStatus.equalsIgnoreCase("")) {
			Log.info("=== Dedicate Portal checkbox Not Selected Since DedicatedPortalStatus is Empty ===");			
		}else {
			Log.info("=== Found invalid input for DedicatedPortalStatus ===");
			}
	}
	
	
	
	public void SelectDedicatedPortalCheckbox_IfDedicatedPortalStatus_Yes(String application, String DedicatedPortalStatus, String DedicatedPortal) throws InterruptedException, DocumentException, IOException {
		if(DedicatedPortalStatus.equalsIgnoreCase("Yes")) {
			Clickon(getwebelement(xml.getlocator("//locators/"+application+"/EnableDedicatedPortalCheckbox")));									Thread.sleep(1000);
			Clickon(getwebelement(xml.getlocator("//locators/"+application+"/DedicatePortal_Select_Build4")));	
			
			WebElement el3 = driver.findElement(By.xpath("//div[div[contains(text(),'"+DedicatedPortal+"')]]/input"));
			el3.click();
			
			Thread.sleep(1000);
			Log.info("=== Dedicate Portal checkbox Selected ===");
		}else if (DedicatedPortalStatus.equalsIgnoreCase("No")) {
			Log.info("=== Dedicate Portal checkbox Not Selected SInce DedicatedPortalStatus is No ===");			
		}else if (DedicatedPortalStatus.equalsIgnoreCase("")) {
			Log.info("=== Dedicate Portal checkbox Not Selected Since DedicatedPortalStatus is Empty ===");			
		}else {
			Log.info("=== Found invalid input for DedicatedPortalStatus ===");
			}
	}
	
	
		
		 

	
	
	
	
	
	
	public void createCustomerFunctionality(String application, String Name, String MainDomain, String CountryToBeSelected,String TypeToBeSelected, String OCN,String Reference, String TechnicalContactName, String Email, String Phone, String Fax, String DedicatedPortalStatus, String DedicatedPortal) throws InterruptedException, DocumentException, IOException {

		Log.info("=== Create customer navigated ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+ "/Name")), Name);									
		Log.info("=== Name Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+ "/MainDomain")), MainDomain);						
		Log.info("=== DomainName Entered ===");
		

		  
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/CountrySelect"))); 				
		Log.info("=== Country dropdown clicked ===");
		
		WebElement el1 = driver.findElement(By.xpath("//span[contains(text(),'"+CountryToBeSelected+"')]"));
		el1.click();						
		Log.info("=== Country has been edited==="); 
		
		
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/OCN")), OCN);	Thread.sleep(1000);					
		Log.info("===OCN Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/Referance_Build4")), Reference);							
		Log.info("=== Reference Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/TechinicalContactName_Build4")), TechnicalContactName);	
		Log.info("=== TechnicalContactName Entered ===");
		

		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/TypeSelect_Build4"))); 						
		Thread.sleep(1000);
		
		
		WebElement el2 = driver.findElement(By.xpath("//span[text()='"+TypeToBeSelected+"']"));
		el2.click();						
		Log.info("=== Country has been edited==="); 
		
		Log.info("=== Type selected===");
		
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/Email")), Email);									
		Thread.sleep(1000);
		Log.info("=== Email Entered ===");
		
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/Phone")), Phone);									
		Thread.sleep(1000);
		Log.info("=== Phone Entered ===");
		
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/Fax")), Fax);										
		Thread.sleep(1000);
		Log.info("=== Fax Entered ===");
		
		SelectDedicatedPortalCheckbox_IfDedicatedPortalStatus_Yes(application, DedicatedPortalStatus, DedicatedPortal);
		
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/OkButton_CreateCustomer")));
		Log.info("=== OK button clicked ===");	Thread.sleep(2000);	
		
				//VerifyText2("Customer Created successfully", "Customer Created successfully", "actual and expected both are unmatched and Customer Created Successfully not Verified");	
				//VerifyText("Customer Created successfully");
	}
	
	
	
	public void verifyCreatedCustomer(String expectedcustomercreationtext) throws IOException {
		WebElement ele = driver.findElement(By.xpath("//div[@role='alert']"));
	    String actualcustomercreationtext = ele.getText();
	    if(!(actualcustomercreationtext.equalsIgnoreCase(expectedcustomercreationtext))) {
	    	
	    	sa.fail("confirmation message is not as expected");
	    }
	}
	
	
	
	public void deleteCustomer(String application) throws InterruptedException, DocumentException {
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/CustomerDetails_Action")));		Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/DeleteCustomerLink")));			Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/DeleteButton_DeleteCustomer")));	Thread.sleep(1000);
		Log.info("=== Customer deleted succssfully ===");
	}
	
	
	
	
	WebElement Name_we, MainDomain_we, SelectedCountry_we, SelectedType_we, OCN_we, Reference_we, TechnicalContactName_we, Email_we, Phone_we, Fax_we;
	public void verifyCreatedCustomerValuesInCustomerDetailsPage(String application, String Name, String MainDomain, String CountryToBeSelected,String TypeToBeSelected, String OCN, String Reference,
			String TechnicalContactName, String Email, String Phone,String Fax ) throws InterruptedException, DocumentException {
		
		// Verify all fields in Customer details page Once customer created successfully
		WebElement Name_we = driver.findElement(By.xpath("//div[contains(text(),'"+Name+"')]"));
		String actualName=Name_we.getText();
		sa.assertEquals(actualName, Name, " Actual and Expected both are not same");
		
		WebElement MainDomain_we = driver.findElement(By.xpath("//div[contains(text(),'"+MainDomain+"')]"));
		String actualMainDomain=MainDomain_we.getText();
		sa.assertEquals(actualMainDomain, MainDomain, " Actual and Expected both are not same");
		
//		WebElement SelectedCountry_we = driver.findElement(By.xpath("//div[contains(text(),'"+CountryToBeSelected+"')]"));
//		String actualSelectedCountry=SelectedCountry_we.getText();
//		sa.assertEquals(actualSelectedCountry, CountryToBeSelected, " Actual and Expected both are not same");
//		
//		WebElement SelectedType_we = driver.findElement(By.xpath("//div[contains(text(),'"+TypeToBeSelected+"')]"));
//		String actualSelectedType=SelectedType_we.getText();
//		sa.assertEquals(actualSelectedType, TypeToBeSelected, " Actual and Expected both are not same");
		
		WebElement OCN_we = driver.findElement(By.xpath("//div[contains(text(),'"+OCN+"')]"));
		String actualOCN=OCN_we.getText();
		sa.assertEquals(actualOCN, OCN, " Actual and Expected both are not same");
		
		WebElement Reference_we = driver.findElement(By.xpath("//div[contains(text(),'"+Reference+"')]"));
		String actualReference=Reference_we.getText();
		sa.assertEquals(actualReference, Reference, " Actual and Expected both are not same");
		
		WebElement TechnicalContactName_we = driver.findElement(By.xpath("//div[contains(text(),'"+TechnicalContactName+"')]"));
		String actualechnicalContactName=TechnicalContactName_we.getText();
		sa.assertEquals(actualechnicalContactName, TechnicalContactName, " Actual and Expected both are not same");
		
		WebElement Email_we = driver.findElement(By.xpath("//div[contains(text(),'"+Email+"')]"));
		String actualEmail=Email_we.getText();
		sa.assertEquals(actualEmail, Email, " Actual and Expected both are not same");
		
		WebElement Phone_we = driver.findElement(By.xpath("//div[contains(text(),'"+Phone+"')]"));
		String actualPhone=Phone_we.getText();
		sa.assertEquals(actualPhone, Phone, " Actual and Expected both are not same");
		
		WebElement Fax_we = driver.findElement(By.xpath("//div[contains(text(),'"+Fax+"')]"));
		String actualFax=Fax_we.getText();
		sa.assertEquals(actualFax, Fax, " Actual and Expected both are not same");				

		sa.assertAll();		
		}
	
	
	
	APT_DataWriter dg=new APT_DataWriter();
	public void getCreatedCustomerData(String application) throws InterruptedException, DocumentException, IOException {
			
		// Get all created customer details in Customer details page Once customer created successfully
			String legalCustomerName_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_LegalCustomerName_Value")).getText();
			String mainDomain_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_MainDomain_Value")).getText();
			//String country_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_Country_Value")).getText();		
			String OCN_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_OCN_Value")).getText();
			String reference_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_Reference_Value")).getText();	
			//String type_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_Type_Value")).getText();			
			String technicalContactName_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_TechnicalContactName_Value")).getText();
			String email_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_Email_Value")).getText();
			String phone_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_Phone_Value")).getText();
			String fax_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_Fax_Value")).getText();
			
			String [] allColumnsValues=new String [] {legalCustomerName_Value, mainDomain_Value, OCN_Value, reference_Value, technicalContactName_Value, email_Value, phone_Value, fax_Value};
			
			for(int i=0; i<allColumnsValues.length-1; i++) {
				
				System.out.print("Created customer Values are : "+allColumnsValues[i]+ " , ");
				
			}
			
			dg.DataWriter2_CreatedCustomer_PK(allColumnsValues);
	
		
	}
	
	
	
	
	public void editCustomer(String application) throws InterruptedException, DocumentException {
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/CustomerDetails_Action")));		Thread.sleep(2000);
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/EditCustomerLink")));				Thread.sleep(2000);
		Log.info("=== Edit Customer Link Clicked ===");
		
		// verify name fields
		String s1 = getwebelement(xml.getlocator("//locators/"+application+"/Name_EditCustomer")).getAttribute("value");		//getwebelement(xml.getlocator("//locators/" + application + "/Name")).clear();
		if (s1.isEmpty()) {
			sa.fail("name value is empty");
		} else {
			Log.info("name value is : " + s1);
		}

		//verify MainDomain
		String s2 = getwebelement(xml.getlocator("//locators/"+application+"/domain_EditCustomer")).getAttribute("value");
		if (s2.isEmpty()) {
			sa.fail("MainDomain value is empty");
		} else {
			Log.info("MainDomain value is : " + s2);
		}

		//verify CountrySelect
		boolean s3 = getwebelement(xml.getlocator("//locators/"+application+"/country_EditCustomer")).isSelected();
		if (s3) {
			//sa.fail("CountrySelect value is Empty");
			sa.assertTrue(true, "Country selected value is :"+s3);
		} else {
			Log.info("CountrySelect value is : " + s3);
		}

		
		// verify OCN fields
				String s4 = getwebelement(xml.getlocator("//locators/"+application+"/ocn_EditCustomer")).getAttribute("value");
				if (s4.isEmpty()) {
					sa.fail("OCN value is empty");
				} else {
					Log.info("OCN value is : " + s4);
				}

				//verify Reference
				String s5 = getwebelement(xml.getlocator("//locators/"+application+"/reference_EditCustomer")).getAttribute("value");
				if (s5.isEmpty()) {
					sa.fail("Reference value is empty");
				} else {
					Log.info("Reference value is : " + s5);
				}
				
				// verify TechnicalContactName fields
				String s6 = getwebelement(xml.getlocator("//locators/"+application+"/Technicalname_EditCustomer>")).getAttribute("value");
				if (s6.isEmpty()) {
					sa.fail("TechnicalContactName value is empty");
				} else {
					Log.info("TechnicalContactName value is : " + s6);
				}

				//verify TypeSelect
				boolean s7 = getwebelement(xml.getlocator("//locators/"+application+"/type_EditCustomer")).isDisplayed();
				if (s7) {
					sa.fail("TypeSelect value is empty");
				} else {
					Log.info("TypeSelect value is : " + s7);
				}
				//verify Email
				String s8 = getwebelement(xml.getlocator("//locators/"+application+"/Email_EditCustomer")).getAttribute("value");
				if (s8.isEmpty()) {
					sa.fail("Email value is empty");
				} else {
					Log.info("Email value is : " + s8);
				}

				//verify Phone
				String s9 = getwebelement(xml.getlocator("//locators/"+application+"/phone_EditCustomer")).getAttribute("value");
				if (s9.isEmpty()) {
					sa.fail("Phone value is empty");
				} else {
					Log.info("Phone value is : " + s9);
				}
				

				//verify Fax
				String s10 = getwebelement(xml.getlocator("//locators/"+application+"/fax_EditCustomer")).getAttribute("value");
				if (s10.isEmpty()) {
					sa.fail("Fax value is empty");
				} else {
					Log.info("Fax value is : " + s10);
				}

				//verify OkButton_CreateCustomer
				WebElement s11 = getwebelement(xml.getlocator("//locators/"+application+"/OkButton_CreateCustomer"));
				if (s11.isDisplayed()) {
					sa.fail("OkButton_CreateCustomer is displayed");
				} else {
					Log.info("OkButton_CreateCustomer is displayed : " + s11);
				}
				
				//verify CancelButton_CreateCustomer
				WebElement s12 = getwebelement(xml.getlocator("//locators/"+application+"/CancelButton_CreateCustomer"));
				if (s12.isDisplayed()) {
					sa.fail("CancelButton_CreateCustomer  is displayed");
				} else {
					Log.info("CancelButton_CreateCustomer is displayed  : " + s12);
				}
				

				
				Thread.sleep(2000);	
				Clickon(getwebelement(xml.getlocator("//locators/"+application+"/CancelButton_EditCustomer")));				Thread.sleep(2000);	
				

				//sa.assertAll();		
	}
	
	
	
	WebElement UserName_Text, FirstName_Text, SurName_Text, PostalAddress_Text, IPGuardianAccountGroup_Text, ColtOnlineUser_Text, Password_Text, GeneratePasswordLink_Text, Roles_Text, HideRouterToolsIPv6CommandsCisco_Text, HideRouterToolsIPv4CommandsHuiwai_Text, HideRouterToolsIPv4CommandsCisco_Text, HideService_Text, HideSiteOrder_Text, OkButton_AddUser, CancelButton_AddUser ;
	public void verifyAddUserFields(String application) throws InterruptedException, DocumentException, IOException {
		Thread.sleep(2000);	
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/Users_Action")));					Thread.sleep(2000);
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/AddUserLink")));					Thread.sleep(2000);

		UserName_Text = getwebelement(xml.getlocator("//locators/" + application + "/UserName_Text"));
		sa.assertTrue(UserName_Text.isDisplayed(),"UserName_Text field is not displayed");
		sa.assertTrue(UserName_Text.isEnabled(), "UserName_Text field is not disabled");
		
		FirstName_Text = getwebelement(xml.getlocator("//locators/" + application + "/FirstName_Text"));
		sa.assertTrue(FirstName_Text.isDisplayed(),"FirstName_Text field is not displayed");
		sa.assertTrue(FirstName_Text.isEnabled(), "FirstName_Text field is not disabled");

		SurName_Text = getwebelement(xml.getlocator("//locators/" + application + "/SurName_Text"));
		sa.assertTrue(SurName_Text.isDisplayed(),"SurName_Text field is not displayed");
		sa.assertTrue(SurName_Text.isEnabled(), "SurName_Text field is not disabled");

		PostalAddress_Text = getwebelement(xml.getlocator("//locators/" + application + "/PostalAddress_Text"));
		sa.assertTrue(PostalAddress_Text.isDisplayed(),"PostalAddress_Text field is not displayed");
		sa.assertTrue(PostalAddress_Text.isEnabled(), "PostalAddress_Text field is not disabled");
		
		Email_Textfield = getwebelement(xml.getlocator("//locators/" + application + "/Email_Textfield"));
		sa.assertTrue(Email_Textfield.isDisplayed(),"Email_Textfield is not displayed");
		sa.assertTrue(UserName_Text.isEnabled(), "Email_Textfield is not disabled");
		
		Phone_Textfield = getwebelement(xml.getlocator("//locators/" + application + "/Phone_Textfield"));
		sa.assertTrue(Phone_Textfield.isDisplayed(),"Phone_Textfield is not displayed");
		sa.assertTrue(Phone_Textfield.isEnabled(), "Phone_Textfield is not disabled");
		
		IPGuardianAccountGroup_Text = getwebelement(xml.getlocator("//locators/" + application + "/IPGuardianAccountGroup_Text"));
		sa.assertTrue(IPGuardianAccountGroup_Text.isDisplayed(),"IPGuardianAccountGroup_Text field is not displayed");
		sa.assertTrue(IPGuardianAccountGroup_Text.isEnabled(), "IPGuardianAccountGroup_Text field is not disabled");
		
		ColtOnlineUser_Text = getwebelement(xml.getlocator("//locators/" + application + "/ColtOnlineUser_Text"));
		sa.assertTrue(ColtOnlineUser_Text.isDisplayed(),"ColtOnlineUser_Text field is not displayed");
		sa.assertTrue(ColtOnlineUser_Text.isEnabled(), "ColtOnlineUser_Text field is not disabled");

		Password_Text = getwebelement(xml.getlocator("//locators/" + application + "/Password_Text"));
		sa.assertTrue(Password_Text.isDisplayed(),"Password_Text field is not displayed");
		sa.assertTrue(Password_Text.isEnabled(), "Password_Text field is not disabled");

		GeneratePasswordLink_Text = getwebelement(xml.getlocator("//locators/" + application + "/GeneratePasswordLink_Text"));
		sa.assertTrue(GeneratePasswordLink_Text.isDisplayed(),"GeneratePasswordLink_Text field is not displayed");
		sa.assertTrue(GeneratePasswordLink_Text.isEnabled(), "GeneratePasswordLink_Text field is not disabled");

		Roles_Text = getwebelement(xml.getlocator("//locators/" + application + "/Roles_Text"));
		sa.assertTrue(Roles_Text.isDisplayed(),"Roles_Text field is not displayed");
		sa.assertTrue(Roles_Text.isEnabled(), "Roles_Text field is not disabled");

		HideRouterToolsIPv6CommandsCisco_Text = getwebelement(xml.getlocator("//locators/" + application + "/HideRouterToolsIPv6CommandsCisco_Text"));
		sa.assertTrue(HideRouterToolsIPv6CommandsCisco_Text.isDisplayed(),"HideRouterToolsIPv6CommandsCisco_Text field is not displayed");
		sa.assertTrue(HideRouterToolsIPv6CommandsCisco_Text.isEnabled(), "HideRouterToolsIPv6CommandsCisco_Text field is not disabled");

		HideRouterToolsIPv4CommandsHuiwai_Text = getwebelement(xml.getlocator("//locators/" + application + "/HideRouterToolsIPv4CommandsHuiwai_Text"));
		sa.assertTrue(HideRouterToolsIPv4CommandsHuiwai_Text.isDisplayed(),"HideRouterToolsIPv4CommandsHuiwai_Text field is not displayed");
		sa.assertTrue(HideRouterToolsIPv4CommandsHuiwai_Text.isEnabled(), "HideRouterToolsIPv4CommandsHuiwai_Text field is not disabled");

		HideRouterToolsIPv4CommandsCisco_Text = getwebelement(xml.getlocator("//locators/" + application + "/HideRouterToolsIPv4CommandsCisco_Text"));
		sa.assertTrue(HideRouterToolsIPv4CommandsCisco_Text.isDisplayed(),"HideRouterToolsIPv4CommandsCisco_Text field is not displayed");
		sa.assertTrue(HideRouterToolsIPv4CommandsCisco_Text.isEnabled(), "HideRouterToolsIPv4CommandsCisco_Text field is not disabled");

		HideService_Text = getwebelement(xml.getlocator("//locators/" + application + "/HideService_Text"));
		sa.assertTrue(HideService_Text.isDisplayed(),"HideService_Text field is not displayed");
		sa.assertTrue(HideService_Text.isEnabled(), "HideService_Text field is not disabled");

		HideSiteOrder_Text = getwebelement(xml.getlocator("//locators/" + application + "/HideSiteOrder_Text"));
		sa.assertTrue(HideSiteOrder_Text.isDisplayed(),"HideSiteOrder_Text field is not displayed");
		sa.assertTrue(HideSiteOrder_Text.isEnabled(), "HideSiteOrder_Text field is not disabled");

		OkButton_AddUser = getwebelement(xml.getlocator("//locators/" + application + "/OkButton_AddUser"));
		sa.assertTrue(OkButton_AddUser.isDisplayed(),"OkButton_AddUser field is not displayed");
		sa.assertTrue(OkButton_AddUser.isEnabled(), "OkButton_AddUser field is not disabled");

		CancelButton_AddUser = getwebelement(xml.getlocator("//locators/" + application + "/CancelButton_AddUser"));
		sa.assertTrue(CancelButton_AddUser.isDisplayed(),"CancelButton_AddUser field is not displayed");
		//sa.assertTrue(CancelButton_AddUser.isEnabled(), "CancelButton_AddUser field is not disabled");		
		
		Log.info("=== Add User all fields Verified ===");
		sa.assertAll();
	}
	
	
	
	
	public void addUserFunctionality(String application, String UserName, String FirstName, String SurName,String PostalAddress, String Email_AddUser, String Phone_AddUser,
			String IPGuardianAccountGroup,String ColtOnlineUser, String GeneratePassword, String RolesToBeSelected,String	HideRouterToolsIPv6CommandsCisco_ToBeSelected, String HideRouterToolsIPv4CommandsHuiwai_ToBeSelected,String	HideRouterToolsIPv4CommandsCisco_ToBeSelected,String HideServicesToBeSelected,String HideSiteOrderToBeSelected) throws InterruptedException, DocumentException, IOException { 
		Thread.sleep(1000);
		//Clickon(getwebelement(xml.getlocator("//locators/"+application+"/Users_Action")));					Thread.sleep(1000);
		//Clickon(getwebelement(xml.getlocator("//locators/"+application+"/AddUserLink")));					Thread.sleep(1000);
		
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/UserName")), UserName);			Thread.sleep(1000);
		Log.info("===UserName Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/FirstName")), FirstName);			Thread.sleep(1000);
		Log.info("===FirstName Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/SurName")), SurName);				Thread.sleep(1000);
		Log.info("===SurName Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/PostalAddress")), PostalAddress);		Thread.sleep(1000);
		Log.info("===PostalAddress Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/Email")), Email_AddUser);					Thread.sleep(1000);
		Log.info("===Email Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/Phone")), Phone_AddUser);					Thread.sleep(1000);
		Log.info("===Phone Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/IPGuardianAccountGroup")), IPGuardianAccountGroup);	Thread.sleep(1000);
		Log.info("===IPGuardianAccountGroup Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/ColtOnlineUser")), ColtOnlineUser);	Thread.sleep(1000);
		Log.info("===ColtOnlineUser Entered ===");

	
		
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/GeneratePasswordLink")));					Thread.sleep(2000);
		String  password=getwebelement(xml.getlocator("//locators/"+application+"/Password_Textfield")).getAttribute("value");
		if(password.isEmpty()) {
			Reporter.log("== Password text is empty after clicked on 'Generate password link' ==");
			sa.fail("== Password text is empty after clicked on 'Generate password link' ==");
		}else {
			Log.info("Password value is : "+ password);
		}
		
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/Password_Textfield")), GeneratePassword);	Thread.sleep(1000);
		Log.info("===Password Entered ===");
        
		
		//Clickon(getwebelement(xml.getlocator("//locators/"+application+"/RolesSelect")));										Thread.sleep(1000);
		//WebElement el1 = driver.findElement(By.xpath("//div[div[contains(text(),'"+RolesToBeSelected+"')]]/input"));
		//el1.click();						
		//Log.info("=== Roles selected===");
		
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/HideRouterToolsIPv6Commands_CiscoSelect")));					
		Thread.sleep(2000);
		WebElement el2 = driver.findElement(By.xpath("//span[text()='"+HideRouterToolsIPv6CommandsCisco_ToBeSelected+"']"));
		el2.click();						
		Log.info("=== HideRouterToolsIPv6CommandsCisco selected===");
		
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/HideRouterToolsIPv4Commands_HuiwaiSelect")));					
		Thread.sleep(2000);
		WebElement el3 = driver.findElement(By.xpath("//span[text()='"+HideRouterToolsIPv4CommandsHuiwai_ToBeSelected+"']"));
		el3.click();						
		Log.info("=== HideRouterToolsIPv4CommandsHuiwai selected===");
		
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/HideRouterToolsIPv4Commands_CiscoSelect")));					
		Thread.sleep(2000);
		WebElement el4 = driver.findElement(By.xpath("//span[text()='"+HideRouterToolsIPv4CommandsCisco_ToBeSelected+"']"));
		el4.click();						
		Log.info("=== HideRouterToolsIPv4CommandsCisco selected===");
		
		//Clickon(getwebelement(xml.getlocator("//locators/"+application+"/HideServicesSelect")));			Thread.sleep(2000);
		//WebElement el5 = driver.findElement(By.xpath("//div[contains(text(),'"+HideServicesToBeSelected+"')]"));
		//el5.click();						
		//Log.info("=== Hide Services selected===");
		
		//Clickon(getwebelement(xml.getlocator("//locators/"+application+"/HideSiteOrderSelect")));			Thread.sleep(2000);
		//WebElement el6 = driver.findElement(By.xpath("//div[contains(text(),'"+HideSiteOrderToBeSelected+"')]"));
		//el6.click();						
		//Log.info("=== Hide Site Order selected===");
	
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/OutSideOfDropdown")));				Thread.sleep(2000);
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/OkButton_AddUser")));				Thread.sleep(2000);
		//Clickon(getwebelement(xml.getlocator("//locators/"+application+"/CancelButton_AddUser")));		Thread.sleep(2000);
		
				//VerifyText("Customer Created successfully");
		
	}
	
	
	
		public void verifyAddedUser(String userAddedSuccssfully_Text) throws IOException {
			VerifyText(userAddedSuccssfully_Text);
			Log.info("=== Customer Created successfully ===");
			
		}
	
	
	
	
		public void verifyAddedUserValuesInViewUserPage(String application, String UserName, String FirstName, String SurName,String PostalAddress, 
				String Email_AddUser, String Phone_AddUser, String IPGuardianAccountGroup,String ColtOnlineUser, String RolesToBeSelected,
				String	HideRouterToolsIPv6CommandsCisco_ToBeSelected, String HideRouterToolsIPv4CommandsHuiwai_ToBeSelected,
				String	HideRouterToolsIPv4CommandsCisco_ToBeSelected, String HideServicesToBeSelected,String HideSiteOrderToBeSelected ) 
				throws InterruptedException, DocumentException {
			
			try {
				// Verify all fields in View User page Once user created successfully
				
				Thread.sleep(5000);
				
				WebElement radiobutton = driver.findElement(By.xpath("//div[div[text()='"+UserName+"']]//input"));
				radiobutton.click();
				Thread.sleep(1000);
				Clickon(getwebelement(xml.getlocator("//locators/"+application+"/Users_Action")));					
				Thread.sleep(1000);
				Clickon(getwebelement(xml.getlocator("//locators/"+application+"/ViewuserLink")));					
				Thread.sleep(10000);

				WebElement UserName_we = driver.findElement(By.xpath("//div[text()='"+UserName+"']"));
				String actualUserName=UserName_we.getText();
				sa.assertEquals(actualUserName, UserName, " Actual and Expected both are not same");
				
				WebElement FirstName_we = driver.findElement(By.xpath("//div[text()='"+FirstName+"']"));
				String actualFirstName=FirstName_we.getText();
				sa.assertEquals(actualFirstName, FirstName, " Actual and Expected both are not same");
				
				WebElement SurName_we = driver.findElement(By.xpath("//div[text()='"+SurName+"']"));
				String actualSurName=SurName_we.getText();
				sa.assertEquals(actualSurName, SurName, " Actual and Expected both are not same");
				
				WebElement PostalAddress_we = driver.findElement(By.xpath("//div[text()='"+PostalAddress+"']"));
				String actualPostalAddress=PostalAddress_we.getText();
				sa.assertEquals(actualPostalAddress, PostalAddress, " Actual and Expected both are not same");
				
				WebElement EmailViewUser_we = driver.findElement(By.xpath("//div[text()='"+Email_AddUser+"']"));
				String actualOCN=EmailViewUser_we.getText();
				sa.assertEquals(actualOCN, Email_AddUser, " Actual and Expected both are not same");
				
				WebElement PhoneViewUser_we = driver.findElement(By.xpath("//div[text()='"+Phone_AddUser+"']"));
				String actualPhone_AddUser=PhoneViewUser_we.getText();
				sa.assertEquals(actualPhone_AddUser, Phone_AddUser, " Actual and Expected both are not same");
				
				WebElement IPGuardianAccountGroup_we = driver.findElement(By.xpath("//div[text()='"+IPGuardianAccountGroup+"']"));
				String actualIPGuardianAccountGroup=IPGuardianAccountGroup_we.getText();
				sa.assertEquals(actualIPGuardianAccountGroup, IPGuardianAccountGroup, " Actual and Expected both are not same");
				
				WebElement ColtOnlineUser_we = driver.findElement(By.xpath("//div[text()='"+ColtOnlineUser+"']"));
				String actualColtOnlineUser=ColtOnlineUser_we.getText();
				sa.assertEquals(actualColtOnlineUser, ColtOnlineUser, " Actual and Expected both are not same");
				
				
				
//			WebElement SelectedRoles_we = driver.findElement(By.xpath("//div[text()='"+RolesToBeSelected+"']"));
//			String actualSelectedRoles=SelectedRoles_we.getText();
//			sa.assertEquals(actualSelectedRoles, RolesToBeSelected, " Actual and Expected both are not same");
//			
//			WebElement SelectedHideServices_we = driver.findElement(By.xpath("//div[text()='"+HideServicesToBeSelected+"']"));
//			String actualFax=SelectedHideServices_we.getText();
//			sa.assertEquals(actualFax, HideServicesToBeSelected, " Actual and Expected both are not same");		
//			
//			WebElement AvailableServices_we = driver.findElement(By.xpath("//div[text()='"+HideRouterToolsIPv4CommandsHuiwai_ToBeSelected+"']"));
//			String actualSelectedHideRouterToolsIPv4CommandsHuiwai=AvailableServices_we.getText();
//			sa.assertEquals(actualSelectedHideRouterToolsIPv4CommandsHuiwai, HideRouterToolsIPv4CommandsHuiwai_ToBeSelected, " Actual and Expected both are not same");
//			
//			WebElement SelectedHideSiteOrder_we = driver.findElement(By.xpath("//div[text()='"+HideSiteOrderToBeSelected+"']"));
//			String actualSelectedHideSiteOrder=SelectedHideSiteOrder_we.getText();
//			sa.assertEquals(actualSelectedHideSiteOrder, HideSiteOrderToBeSelected, " Actual and Expected both are not same");
//			
//			WebElement SelectedHideRouterToolsIPv4CommandsHuiwai_we = driver.findElement(By.xpath("//div[text()='"+HideRouterToolsIPv4CommandsHuiwai_ToBeSelected+"']"));
//			String actualSelectedHideRouterToolsIPv4Commands=SelectedHideRouterToolsIPv4CommandsHuiwai_we.getText();
//			sa.assertEquals(actualSelectedHideRouterToolsIPv4Commands, HideRouterToolsIPv4CommandsHuiwai_ToBeSelected, " Actual and Expected both are not same");
//			
//			WebElement AvailableHideRouterToolsIPv4CommandsCisco_we = driver.findElement(By.xpath("//div[text()='"+HideRouterToolsIPv4CommandsCisco_ToBeSelected+"']"));
//			String actualEmail=AvailableHideRouterToolsIPv4CommandsCisco_we.getText();
//			sa.assertEquals(actualEmail, HideRouterToolsIPv4CommandsCisco_ToBeSelected, " Actual and Expected both are not same");
//			
//			WebElement SelectedHideRouterToolsIPv6Commands = driver.findElement(By.xpath("//div[text()='"+HideRouterToolsIPv6CommandsCisco_ToBeSelected+"']"));
//			String actualSelectedHideRouterToolsIPv6Commands=SelectedHideRouterToolsIPv6Commands.getText();
//			sa.assertEquals(actualSelectedHideRouterToolsIPv6Commands, HideRouterToolsIPv6CommandsCisco_ToBeSelected, " Actual and Expected both are not same");
//			
//			WebElement AvailableHideRouterToolsIPv6Commands = driver.findElement(By.xpath("//div[text()='"+HideRouterToolsIPv6CommandsCisco_ToBeSelected+"']"));
//			String actualAvailableHideRouterToolsIPv6Commands=AvailableHideRouterToolsIPv6Commands.getText();
//			sa.assertEquals(actualAvailableHideRouterToolsIPv6Commands, HideRouterToolsIPv6CommandsCisco_ToBeSelected, " Actual and Expected both are not same");	

				sa.assertAll();
				
				javascriptexecutor(getwebelement(xml.getlocator("//locators/"+application+"/backbutton")));
				Clickon(getwebelement(xml.getlocator("//locators/"+application+"/backbutton")));					
				Thread.sleep(8000);
				
				
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				
				Reporter.log("value is not displayed in view user page " + e);
				e.printStackTrace();
			}		
			
		
		
		
		
		
		
		}
	
	
		
	
		
		
		public void EditCustomerdetails_SIT(String application, String name, String domain, String Country, String OCN, String reference, String TechnicalContactName,
				String typetoselect, String email, String phone, String fax ) throws InterruptedException, DocumentException, IOException {
			
			//, String DedicatedPortalStatus , String DedicatedPortal
			Log.info("Click on Action dropdown for Edit customer");
			Clickon(getwebelement(xml.getlocator("//locators/"+application+"/CustomerDetails_Action")));
			
			Clickon(getwebelement(xml.getlocator("//locators/"+application+"/EditCustomerLink")));
			Log.info("Edit customer link is clicked");
			
			WebElement EditCustomerPageVerify=getwebelement(xml.getlocator("//locators/"+application+"/EditCustomerTabname_EditCustomer"));
			if(EditCustomerPageVerify.isDisplayed()) {
				Log.info("got directed to Edit Customer page");
				
				Log.info("Editing actions to be performed");
				
				SendKeys(getwebelement(xml.getlocator("//locators/"+application+ "/Name_EditCustomer")), name);
				Log.info("name has been edited");
				
				
				SendKeys(getwebelement(xml.getlocator("//locators/"+application+ "/domain_EditCustomer")), domain);
				Log.info("Domain has been edited");

				Select(getwebelement(xml.getlocator("//locators/"+application+ "/country_EditCustomer")), Country);
				Log.info("Country as been changed");
				
				SendKeys(getwebelement(xml.getlocator("//locators/"+application+ "/ocn_EditCustomer")), OCN);
				Log.info("OCN has been edited");
				
				SendKeys(getwebelement(xml.getlocator("//locators/"+application+ "/reference_EditCustomer")), reference);
				Log.info("Reference name has been edited");
				
				SendKeys(getwebelement(xml.getlocator("//locators/"+application+ "/Technicalname_EditCustomer")), TechnicalContactName);
				Log.info("Technical contact name has been edited");
				
				Select(getwebelement(xml.getlocator("//locators/"+application+ "/type_EditCustomer")), typetoselect);
				Log.info("customer type has been edited");
				
				SendKeys(getwebelement(xml.getlocator("//locators/"+application+ "/Email_EditCustomer")), email);
				Log.info("Email has been edited");
				
				SendKeys(getwebelement(xml.getlocator("//locators/"+application+ "/phone_EditCustomer")), phone);
				Log.info("Phone number has been edited");
				
				SendKeys(getwebelement(xml.getlocator("//locators/"+application+ "/fax_EditCustomer")), fax);
				Log.info("fax details has been edited");
				
				Clickon(getwebelement(xml.getlocator("//locators/"+application+ "/enablededicatedPortal_EditCustomer")));
				Log.info("dedicated portal has been disabled");
				
				Clickon(getwebelement(xml.getlocator("//locators/"+application+"/OkButton_CreateCustomer")));
				Log.info("=== OK button clicked ===");	Thread.sleep(2000);	
			
				
		} else {
			Log.info("Edit customer page is not directed");
				}
		}
		
		
		
		public void EditUserDetails(String application, String UserName, String FirstName, String SurName,String PostalAddress, String Email_AddUser, String Phone_AddUser,
				String IPGuardianAccountGroup,String ColtOnlineUser, String GeneratePassword, String RolesToBeSelected,String	HideRouterToolsIPv6CommandsCisco_ToBeSelected,
				String HideRouterToolsIPv4CommandsHuiwai_ToBeSelected,String	HideRouterToolsIPv4CommandsCisco_ToBeSelected,String HideServicesToBeSelected,String HideSiteOrderToBeSelected ) throws InterruptedException, DocumentException, IOException {
			
			Log.info("Click on Radio button for Edit User");												Thread.sleep(1000);
			Clickon(getwebelement(xml.getlocator("//locators/"+application+"/FirstRowRadioButtonInUsers")));
			
			Log.info("Click on Action dropdown for Edit customer");											Thread.sleep(1000);
			Clickon(getwebelement(xml.getlocator("//locators/"+application+"/Users_Action")));
			
			Clickon(getwebelement(xml.getlocator("//locators/"+application+"/EditUserLink")));
			
			Log.info("Edit User link is clicked");
			
			WebElement EditUserPageVerify=getwebelement(xml.getlocator("//locators/"+application+"/EdituserTabname_EditUser"));
			if(EditUserPageVerify.isDisplayed()) {
				Log.info("got directed to Edit User page");
				
				Log.info("Editing actions to be performed");

				SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/UserName")), UserName);			Thread.sleep(1000);
				Log.info("=== UserName has been edited ===");
				SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/FirstName")), FirstName);			Thread.sleep(1000);
				Log.info("===FirstName has been edited ===");
				SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/SurName")), SurName);				Thread.sleep(1000);
				Log.info("===SurName has been edited ===");
				SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/PostalAddress")), PostalAddress);		Thread.sleep(1000);
				Log.info("===PostalAddress  has been edited ===");
				SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/Email")), Email_AddUser);					Thread.sleep(1000);
				Log.info("===Email has been edited ===");
				SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/Phone")), Phone_AddUser);					Thread.sleep(1000);
				Log.info("===Phone has been edited ===");
				SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/IPGuardianAccountGroup")), IPGuardianAccountGroup);	Thread.sleep(1000);
				Log.info("===IPGuardianAccountGroup has been edited ===");
				SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/ColtOnlineUser")), ColtOnlineUser);	Thread.sleep(1000);
				Log.info("===ColtOnlineUser has been edited ===");
			
					//Clickon(getwebelement(xml.getlocator("//locators/"+application+"/GeneratePasswordLink")));					Thread.sleep(2000);
				SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/Password_Textfield")), GeneratePassword);	Thread.sleep(1000);
				Log.info("===Password has been edited ===");
		        
				Clickon(getwebelement(xml.getlocator("//locators/"+application+"/RolesSelect")));										Thread.sleep(1000);
				WebElement el1 = driver.findElement(By.xpath("//div[div[contains(text(),'"+RolesToBeSelected+"')]]/input"));
				el1.click();						
				Log.info("=== Roles has been edited===");
				
				Clickon(getwebelement(xml.getlocator("//locators/"+application+"/HideRouterToolsIPv6Commands_CiscoSelect")));					Thread.sleep(2000);
				WebElement el2 = driver.findElement(By.xpath("//div[contains(text(),'"+HideRouterToolsIPv6CommandsCisco_ToBeSelected+"')]"));
				el2.click();						
				Log.info("=== HideRouterToolsIPv6CommandsCisco has been edited===");
				
				Clickon(getwebelement(xml.getlocator("//locators/"+application+"/HideRouterToolsIPv4Commands_HuiwaiSelect")));					Thread.sleep(2000);
				WebElement el3 = driver.findElement(By.xpath("//div[contains(text(),'"+HideRouterToolsIPv4CommandsHuiwai_ToBeSelected+"')]"));
				el3.click();						
				Log.info("=== HideRouterToolsIPv4CommandsHuiwai has been edited===");
				
				Clickon(getwebelement(xml.getlocator("//locators/"+application+"/HideRouterToolsIPv4Commands_CiscoSelect")));					Thread.sleep(2000);
				WebElement el4 = driver.findElement(By.xpath("//div[contains(text(),'"+HideRouterToolsIPv4CommandsCisco_ToBeSelected+"')]"));
				el4.click();						
				Log.info("=== HideRouterToolsIPv4CommandsCisco has been edited===");
				
				Clickon(getwebelement(xml.getlocator("//locators/"+application+"/HideServicesSelect")));			Thread.sleep(2000);
				WebElement el5 = driver.findElement(By.xpath("//div[contains(text(),'"+HideServicesToBeSelected+"')]"));
				el5.click();						
				Log.info("=== Hide Services has been edited===");
				
				Clickon(getwebelement(xml.getlocator("//locators/"+application+"/HideSiteOrderSelect")));			Thread.sleep(2000);
				WebElement el6 = driver.findElement(By.xpath("//div[contains(text(),'"+HideSiteOrderToBeSelected+"')]"));
				el6.click();						
				Log.info("=== Hide Site Order has been edited===");	        
			
				Clickon(getwebelement(xml.getlocator("//locators/"+application+"/OutSideOfDropdown")));				Thread.sleep(2000);
				Clickon(getwebelement(xml.getlocator("//locators/"+application+"/OkButton_AddUser")));				Thread.sleep(2000);
				Log.info("=== OK button clicked ===");	Thread.sleep(2000);	

				//Clickon(getwebelement(xml.getlocator("//locators/"+application+"/CancelButton_AddUser")));		Thread.sleep(2000);
				
						//VerifyText("Customer Created successfully");
			
				
		} else {
			Log.info("Edit User page is not directed");
				}

		}
		
		
		

	public void getCustomerData(String application, String created) throws InterruptedException, DocumentException, IOException {
			// Get all created customer details in Customer details page Once customer created successfully
			
			String legalCustomerName_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_LegalCustomerName_Value")).getText();
			String mainDomain_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_MainDomain_Value")).getText();
//			String country_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_Country_Value")).getText();	
			String country_Value="India";
			String OCN_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_OCN_Value")).getText();
			String reference_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_Reference_Value")).getText();	
			String type_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_Type_Value")).getText();			
			String technicalContactName_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_TechnicalContactName_Value")).getText();
			String email_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_Email_Value")).getText();
			String phone_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_Phone_Value")).getText();
			String fax_Value=getwebelement(xml.getlocator("//locators/"+application+"/CreatedCustomer_Fax_Value")).getText();
			
			
			String CurrentDate=getCurrentDate();
			String [] allColumnsValues=new String [] {legalCustomerName_Value,mainDomain_Value,country_Value, OCN_Value, reference_Value, technicalContactName_Value, type_Value, email_Value, phone_Value, fax_Value, created, CurrentDate   };
			System.out.println("Total number of values to be passed in excel: "+allColumnsValues.length);
			dg.CreateCustomerDataWriter(allColumnsValues);
	}
	
	
	
	public void getUserData(String application, String created) throws InterruptedException, DocumentException, IOException {
		// Get all created user details in User details page Once user added successfully
		String AddedUser_LoginUserName_Value=getwebelement(xml.getlocator("//locators/"+application+"/AddedUser_LoginUserName_Value")).getText();
		String AddedUser_Name_Value=getwebelement(xml.getlocator("//locators/"+application+"/AddedUser_Name_Value")).getText();
		String AddedUser_Email_Value=getwebelement(xml.getlocator("//locators/"+application+"/AddedUser_Email_Value")).getText();
		String AddedUser_Roles_Value=getwebelement(xml.getlocator("//locators/"+application+"/AddedUser_Roles_Value")).getText();	
		//String AddedUser_Resources_Value=getwebelement(xml.getlocator("//locators/"+application+"/AddedUser_Resources_Value")).getText();
		String AddedUser_Address_Value=getwebelement(xml.getlocator("//locators/"+application+"/AddedUser_Address_Value")).getText();			
		
		String CurrentDate=getCurrentDate();
		String [] allColumnsValues=new String [] {AddedUser_LoginUserName_Value,AddedUser_Name_Value,AddedUser_Email_Value, AddedUser_Roles_Value, AddedUser_Address_Value,  created, CurrentDate   };
		System.out.println("Total number of values to be passed in excel: "+allColumnsValues.length);
		dg.CreateUserDataWriter(allColumnsValues);

}

	
	
	
	/*
	 * 
	 * 				Negative Scenarios for Create Customer
	 * 
	 */
	
	public void checkWetherTextFieldIsAcceptingCharOrNumericOrSpecialCharacter(String application, String inputData) {
		
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
