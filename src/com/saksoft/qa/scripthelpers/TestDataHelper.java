package com.saksoft.qa.scripthelpers;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.saksoft.qa.driverlibrary.Log;
import com.saksoft.qa.excellibrary.APT_DataReader;

public class TestDataHelper {
	/*
	 * 
	 * 
	 * 
	 * @Test(description = "TC-09", dataProviderClass = APT_DataReader.class,
	 * dataProvider = "FinalDataReader_EditCustomer1", priority = 9) public void
	 * setEditedOrModifiedCustomerDetailsIntoExcelSheet(Map<String, String> map)
	 * throws Exception { Log.
	 * startTestCase("Manage Customer's Service- set Edited Or Modified Customer Details Into ExcelSheet Test Started"
	 * ); Reporter.
	 * log("Manage Customer's Service- set Edited Or Modified Customer Details Into ExcelSheet Test Started"
	 * ); Thread.sleep(2000);
	 * createCustomerHelper.get().createCustomerFunctionality("CreateCustomer",
	 * map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"),
	 * map.get("TypeToBeSelected"), map.get("OCN"),map.get("Reference"),
	 * map.get("TechnicalContactName"),
	 * map.get("Email"),map.get("Phone"),map.get("Fax"),
	 * map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
	 * createCustomerHelper.get().
	 * verifyCreatedCustomer("Customer successfully created."); Thread.sleep(2000);
	 * createCustomerHelper.get().getCustomerData("CreateCustomer", "created Data");
	 * }
	 * 
	 * //@Test(description = "TC-10", dataProviderClass = APT_DataReader.class,
	 * dataProvider = "FinalDataReader11_PK", priority =10)//For Data Entry in to
	 * Excelsheet public void EditCustomerdatas(Map<String, String> map) throws
	 * Exception { System.out.println("the values going to be entered are: " +
	 * map.get("Name"));
	 * createCustomerHelper.get().EditCustomerdetails_SIT("CreateCustomer",
	 * map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"),
	 * map.get("OCN"), map.get("Reference"), map.get("TechnicalContactName"),
	 * map.get("TypeToBeSelected"), map.get("Email"), map.get("Phone"),
	 * map.get("Fax")); createCustomerHelper.get().getCustomerData("CreateCustomer",
	 * "updated Data");
	 * 
	 * Log.
	 * endTestCase("Manage Customer's Service- set Edited Or Modified Customer Details Into ExcelSheet Test completed"
	 * ); Reporter.
	 * log("Manage Customer's Service- set Edited Or Modified Customer Details Into ExcelSheet Test completed"
	 * ); }
	 * 
	 * 
	 * 
	 * //@Test(description = "TC-11", dataProviderClass = APT_DataReader.class,
	 * dataProvider = "FinalDataReader_EditCustomer1", priority = 11) public void
	 * setEditedOrModifiedUserDetailsIntoExcelSheet(Map<String, String> map) throws
	 * Exception { Log.
	 * startTestCase("Manage Customer's Service- set Edited Or Modified User Details Into ExcelSheet Test Started"
	 * ); Reporter.
	 * log("Manage Customer's Service- set Edited Or Modified User Details Into ExcelSheet Test Started"
	 * ); Thread.sleep(2000);
	 * createCustomerHelper.get().createCustomerFunctionality("CreateCustomer",
	 * map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"),
	 * map.get("TypeToBeSelected"), map.get("OCN"),map.get("Reference"),
	 * map.get("TechnicalContactName"),
	 * map.get("Email"),map.get("Phone"),map.get("Fax"),
	 * map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
	 * createCustomerHelper.get().
	 * verifyCreatedCustomer("Customer successfully created."); Thread.sleep(2000);
	 * createCustomerHelper.get().getUserData("CreateCustomer", "created Data");
	 * 
	 * }
	 * 
	 * 
	 * //@Test(description = "TC-12", dataProviderClass = APT_DataReader.class,
	 * dataProvider = "FinalDataReader13_PK", priority =12)//For Data Entry in to
	 * Excelsheet public void EditUserdatas(Map<String, String> map) throws
	 * Exception { System.out.println("the values going to be entered are: " +
	 * map.get("UserName"));
	 * createCustomerHelper.get().EditUserDetails("CreateCustomer",map.get(
	 * "UserName"), map.get("FirstName"),
	 * map.get("SurName"),map.get("PostalAddress"), map.get("Email_AddUser"),
	 * map.get("Phone_AddUser"),map.get("IPGuardianAccountGroup"),map.get(
	 * "ColtOnlineUser"), map.get("GeneratePassword"),map.get("RolesToBeSelected"),
	 * map.get("HideRouterToolsIPv6CommandsCisco_ToBeSelected"),map.get(
	 * "HideRouterToolsIPv4CommandsHuiwai_ToBeSelected"),
	 * map.get("HideRouterToolsIPv4CommandsCisco_ToBeSelected"),
	 * map.get("HideServicesToBeSelected"),map.get("HideSiteOrderToBeSelected"));
	 * Thread.sleep(2000); createCustomerHelper.get().getUserData("CreateCustomer",
	 * "updated Data"); Log.
	 * endTestCase("Manage Customer's Service- set Edited Or Modified User Details Into ExcelSheet Test completed"
	 * ); Reporter.
	 * log("Manage Customer's Service- set Edited Or Modified User Details Into ExcelSheet Test completed"
	 * ); }
	 * 
	 * 
	 * 
	 * 
	 * //@Test(description = "TC-13", priority = 13) public void
	 * verifyCreateCustomerMandatoryFields() throws Exception {
	 * 
	 * Log.
	 * startTestCase("Manage Customer's Service- Verify Mandatory Customer fields Test Started"
	 * ); Reporter.
	 * log("Manage Customer's Service- Verify Mandatory Customer fields Test Started"
	 * ); Thread.sleep(2000);
	 * createCustomerHelper.get().verifyCreateCustomerMandatoryFields(
	 * "CreateCustomer"); driver.navigate().refresh(); Log.
	 * endTestCase("Manage Customer's Service- Verify Mandatory Customer fields Test Completed"
	 * ); Reporter.
	 * log("Manage Customer's Service- Verify Mandatory Customer fields Test Completed"
	 * );
	 * 
	 * }
	 * 
	 * 
	 */}
