package com.saksoft.qa.testscript;

import java.io.IOException;
import java.util.Map;

import org.dom4j.DocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.saksoft.qa.driverlibrary.DriverHelper;
import com.saksoft.qa.driverlibrary.DriverTestcase;
import com.saksoft.qa.driverlibrary.Log;
import com.saksoft.qa.excellibrary.APT_DataReader;
import com.saksoft.qa.excellibrary.APT_DataWriter;

public class APT_MCS_CreateCustomer extends DriverTestcase {
	
	
	@Test(description = "TC-01", priority = 1)
	public void verifyCreateCustomerFields() throws Exception {
		Log.startTestCase("Manage Customer's Service- Verifying Create Customer's Fields Started");
		Reporter.log("Manage Customer's Service- Verify Create Customer's Fields Test Started");
		Thread.sleep(2000);
		createCustomerHelper.get().verifyCreateCustomerFields("CreateCustomer");
		Log.endTestCase("Manage Customer's Service- Verifying Create Customer's Fields Completed");
		Reporter.log("Manage Customer's Service- Verify Create Customer's Fields Test Completed");
	}
	
	
	
	@Test(description = "TC-02",dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_PK", priority = 2)
	public void createCustomer_verifyFunctionality(Map<String, String> map) throws Exception {	   
		Log.startTestCase("Manage Customer's Service- Verifying Create Customer's Functionality Started");
		Reporter.log("Manage Customer's Service- Verify Create Customer's Functionality Test Started");
		APTLogin.get().Login("APT_login_1");
		Thread.sleep(2000);
		createCustomerHelper.get().createCustomerFunctionality("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("TypeToBeSelected"),  map.get("OCN"),map.get("Reference"), map.get("TechnicalContactName"), map.get("Email"),map.get("Phone"),map.get("Fax"), map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
		createCustomerHelper.get().verifyCreatedCustomer("Customer Created successfully");
		Log.endTestCase("Manage Customer's Service- Verifying Create Customer's Functionality Test Completed");
		Reporter.log("Manage Customer's Service- Verify Create Customer's Test Completed");
	}
	
	
	
	
	@Test(description = "TC-03",dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_PK", priority = 3)
	public void verifyCreatedCustomerDetailsInCustomerDetailsPage(Map<String, String> map) throws Exception {
		Log.startTestCase("Manage Customer's Service- Verify created customer values on GUI Test Started");
		Reporter.log("Manage Customer's Service- Verify created customer values on GUI Test Started");
		createCustomerHelper.get().createCustomerFunctionality("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("TypeToBeSelected"),  map.get("OCN"),map.get("Reference"), map.get("TechnicalContactName"), map.get("Email"),map.get("Phone"),map.get("Fax"), map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
		createCustomerHelper.get().verifyCreatedCustomer("Customer Created successfully");		Thread.sleep(2000);
		createCustomerHelper.get().verifyCreatedCustomerValuesInCustomerDetailsPage("CreateCustomer", map.get("Name").toString(), map.get("MainDomain").toString(), map.get("CountryToBeSelected").toString(), map.get("TypeToBeSelected").toString(),  map.get("OCN").toString(),map.get("Reference").toString(), map.get("TechnicalContactName").toString(), map.get("Email").toString(),map.get("Phone").toString(),map.get("Fax").toString());
		Log.endTestCase("Manage Customer's Service- Verify created customer values on GUI  Test Completed");
		Reporter.log("Manage Customer's Service- Verify created customer values on GUI  Test Completed");
	}
	
	
	
		
	@Test(description = "TC-04",dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_PK", priority = 4)
	public void verifyDeleteCustomerFunctionality(Map<String, String> map) throws Exception {
		
		Log.startTestCase("Manage Customer's Service- Verify delete customer Test Started");
		Reporter.log("Manage Customer's Service- Verifying delete customer functionality Started");
		createCustomerHelper.get().createCustomerFunctionality("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("TypeToBeSelected"),  map.get("OCN"),map.get("Reference"), map.get("TechnicalContactName"), map.get("Email"),map.get("Phone"),map.get("Fax"), map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
		createCustomerHelper.get().verifyCreatedCustomer("Customer Created successfully");		Thread.sleep(2000);
		createCustomerHelper.get().deleteCustomer("CreateCustomer");
		Log.endTestCase("Manage Customer's Service- Verifying delete customer functionality Completed");
		Reporter.log("Manage Customer's Service- Verify delete customer Test Completed");
	}
	

	
	@Test(description = "TC-05", dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_PK", priority = 5)
	public void verifyAddUserFieldsUnderCreateCustomer(Map<String, String> map) throws Exception {	  
		Thread.sleep(2000);
		Log.startTestCase("Manage Customer's Service- Verify Add User Fields Test Started");
		Reporter.log("Manage Customer's Service- Verify Add User Fields Test Started");
		createCustomerHelper.get().createCustomerFunctionality("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("TypeToBeSelected"),  map.get("OCN"),map.get("Reference"), map.get("TechnicalContactName"), map.get("Email"),map.get("Phone"),map.get("Fax"), map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
		createCustomerHelper.get().verifyCreatedCustomer("Customer Created successfully");		Thread.sleep(2000);
		createCustomerHelper.get().verifyAddUserFields("CreateCustomer");
		Log.endTestCase("Manage Customer's Service- Verify Add User Fields Test Completed");
		Reporter.log("Manage Customer's Service- Verify Add User Fields Test Completed");
	}
	
	
	
	@Test(description = "TC-06", dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_PK", priority = 6)
	public void verifyAddUserFunctionalityUnderCreateCustomer(Map<String, String> map) throws Exception {	 
		Thread.sleep(2000);
		Log.startTestCase("Manage Customer's Service- Verify Add User Test Started");
		Reporter.log("Manage Customer's Service- Verify Add User Test Started");
		createCustomerHelper.get().createCustomerFunctionality("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("TypeToBeSelected"), map.get("OCN"),map.get("Reference"), map.get("TechnicalContactName"), map.get("Email"),map.get("Phone"),map.get("Fax"), map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
		createCustomerHelper.get().addUserFunctionality("CreateCustomer",map.get("UserName"), map.get("FirstName"), map.get("SurName"),map.get("PostalAddress"), map.get("Email_AddUser"), map.get("Phone_AddUser"),map.get("IPGuardianAccountGroup"),map.get("ColtOnlineUser"), map.get("GeneratePassword"),map.get("RolesToBeSelected"), map.get("HideRouterToolsIPv6CommandsCisco_ToBeSelected"),map.get("HideRouterToolsIPv4CommandsHuiwai_ToBeSelected"), map.get("HideRouterToolsIPv4CommandsCisco_ToBeSelected"), map.get("HideServicesToBeSelected"),map.get("HideSiteOrderToBeSelected"));
		createCustomerHelper.get().verifyAddedUser("Customer Created successfully");
		Log.endTestCase("Manage Customer's Service- Verify Add User Test Completed");
		Reporter.log("Manage Customer's Service- Verify Add User Test Completed");
	  }
	
	
	
	
	@Test(description = "TC-07",dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_PK", priority = 7)
	public void verifyAddedUserDetailsInViewUserPage(Map<String, String> map) throws Exception {
		Log.startTestCase("Manage Customer's Service- Verify created User details Test Started");
		Reporter.log("Manage Customer's Service- Verify created User details Test Started");
		createCustomerHelper.get().createCustomerFunctionality("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("TypeToBeSelected"),  map.get("OCN"),map.get("Reference"), map.get("TechnicalContactName"), map.get("Email"),map.get("Phone"),map.get("Fax"), map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
		createCustomerHelper.get().verifyCreatedCustomer("Customer Created successfully");		
		Thread.sleep(2000);
		createCustomerHelper.get().verifyAddedUserValuesInViewUserPage("CreateCustomer", map.get("UserName"), map.get("FirstName"), map.get("SurName"),map.get("PostalAddress"),  map.get("Email_AddUser"),map.get("Phone_AddUser"), map.get("IPGuardianAccountGroup"),map.get("ColtOnlineUser"),map.get("RolesToBeSelected"),map.get("HideRouterToolsIPv6CommandsCisco_ToBeSelected"), map.get("HideRouterToolsIPv4CommandsHuiwai_ToBeSelected"),map.get("HideRouterToolsIPv4CommandsCisco_ToBeSelected"), map.get("HideServicesToBeSelected"), map.get("HideSiteOrderToBeSelected"));
	    Log.endTestCase("Manage Customer's Service- Verify created User details Test Completed");
	    Reporter.log("Manage Customer's Service- Verify created User details Test Completed");
	}
	
	
	
	@Test(description = "TC-08",dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_PK", priority = 8)
	public void verifyEditCustomerFields(Map<String, String> map) throws Exception {
		Log.startTestCase("Manage Customer's Service- Verify Edit Customer details Test Started");
		Reporter.log("Manage Customer's Service- Verify Edit Customer details Test Started");
		createCustomerHelper.get().createCustomerFunctionality("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("TypeToBeSelected"),  map.get("OCN"),map.get("Reference"), map.get("TechnicalContactName"), map.get("Email"),map.get("Phone"),map.get("Fax"), map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
		createCustomerHelper.get().verifyCreatedCustomer("Customer Created successfully");		Thread.sleep(2000);
		createCustomerHelper.get().editCustomer("CreateCustomer");
		Log.endTestCase("Manage Customer's Service- Verify Edit Customer details Test Completed");
	    Reporter.log("Manage Customer's Service- Verify Edit Customer details Test Completed");
	}
	
	
	
	
	@Test(description = "TC-09", dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader10_PK", priority = 9)
	public void setEditedOrModifiedCustomerDetailsIntoExcelSheet(Map<String, String> map) throws Exception {
		Log.startTestCase("Manage Customer's Service- set Edited Or Modified Customer Details Into ExcelSheet Test Started");
		Reporter.log("Manage Customer's Service- set Edited Or Modified Customer Details Into ExcelSheet Test Started");
		Thread.sleep(2000);
		createCustomerHelper.get().createCustomerFunctionality("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("TypeToBeSelected"),  map.get("OCN"),map.get("Reference"), map.get("TechnicalContactName"), map.get("Email"),map.get("Phone"),map.get("Fax"), map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
		createCustomerHelper.get().verifyCreatedCustomer("Customer Created successfully");
		Thread.sleep(2000);
		createCustomerHelper.get().getCustomerData("CreateCustomer", "created Data");
	}
	@Test(description = "TC-10", dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader11_PK", priority =10)//For Data Entry in to Excelsheet
	public void EditCustomerdatas(Map<String, String> map) throws Exception {
		System.out.println("the values going to be entered are: " + map.get("Name"));
		createCustomerHelper.get().EditCustomerdetails_SIT("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("OCN"), map.get("Reference"), map.get("TechnicalContactName"), map.get("TypeToBeSelected"), map.get("Email"), map.get("Phone"), map.get("Fax"));
		createCustomerHelper.get().getCustomerData("CreateCustomer", "updated Data");
		
		Log.endTestCase("Manage Customer's Service- set Edited Or Modified Customer Details Into ExcelSheet Test completed");
	    Reporter.log("Manage Customer's Service- set Edited Or Modified Customer Details Into ExcelSheet Test completed");
	}
	
	

	@Test(description = "TC-11", dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader10_PK", priority = 11)
	public void setEditedOrModifiedUserDetailsIntoExcelSheet(Map<String, String> map) throws Exception {
		Log.startTestCase("Manage Customer's Service- set Edited Or Modified User Details Into ExcelSheet Test Started");
		Reporter.log("Manage Customer's Service- set Edited Or Modified User Details Into ExcelSheet Test Started");
		Thread.sleep(2000);
		createCustomerHelper.get().createCustomerFunctionality("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("TypeToBeSelected"),  map.get("OCN"),map.get("Reference"), map.get("TechnicalContactName"), map.get("Email"),map.get("Phone"),map.get("Fax"), map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
		createCustomerHelper.get().verifyCreatedCustomer("Customer Created successfully");
		Thread.sleep(2000);
		createCustomerHelper.get().getUserData("CreateCustomer", "created Data");
		
	}
	@Test(description = "TC-12", dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader13_PK", priority =12)//For Data Entry in to Excelsheet
	public void EditUserdatas(Map<String, String> map) throws Exception {
		System.out.println("the values going to be entered are: " + map.get("UserName"));
		createCustomerHelper.get().EditUserDetails("CreateCustomer",map.get("UserName"), map.get("FirstName"), map.get("SurName"),map.get("PostalAddress"), map.get("Email_AddUser"), map.get("Phone_AddUser"),map.get("IPGuardianAccountGroup"),map.get("ColtOnlineUser"), map.get("GeneratePassword"),map.get("RolesToBeSelected"), map.get("HideRouterToolsIPv6CommandsCisco_ToBeSelected"),map.get("HideRouterToolsIPv4CommandsHuiwai_ToBeSelected"), map.get("HideRouterToolsIPv4CommandsCisco_ToBeSelected"), map.get("HideServicesToBeSelected"),map.get("HideSiteOrderToBeSelected"));		
		Thread.sleep(2000);
		createCustomerHelper.get().getUserData("CreateCustomer", "updated Data");
		Log.endTestCase("Manage Customer's Service- set Edited Or Modified User Details Into ExcelSheet Test completed");
	    Reporter.log("Manage Customer's Service- set Edited Or Modified User Details Into ExcelSheet Test completed");
	}
	
	
	
	
	@Test(description = "TC-13", priority = 13)
	public void verifyCreateCustomerMandatoryFields() throws Exception {
		
		Log.startTestCase("Manage Customer's Service- Verify Mandatory Customer fields Test Started");
		Reporter.log("Manage Customer's Service- Verify Mandatory Customer fields Test Started");
		Thread.sleep(2000);
		createCustomerHelper.get().verifyCreateCustomerMandatoryFields("CreateCustomer");	
		driver.navigate().refresh();
		Log.endTestCase("Manage Customer's Service- Verify Mandatory Customer fields Test Completed");
	    Reporter.log("Manage Customer's Service- Verify Mandatory Customer fields Test Completed");
		
	}

	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	}
