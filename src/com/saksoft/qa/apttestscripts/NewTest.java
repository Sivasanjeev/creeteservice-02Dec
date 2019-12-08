//package com.saksoft.qa.testscripts;
//
//import java.util.Map;
//
//import org.testng.annotations.Test;
//
//import com.saksoft.qa.driverlibrary.DriverHelper;
//import com.saksoft.qa.driverlibrary.DriverTestcase;
//import com.saksoft.qa.excellibrary.APT_DataReader;
//
//public class NewTest extends DriverTestcase {
//	@Test(description = "TC-09", priority = 0)
//	public void verifyCreateCustomerFields() throws Exception {
//		Thread.sleep(2000);
//		createCustomerHelper.get().verifyCreateCustomerFields("CreateCustomer");
//	}
//	
//	@Test(description = "TC-01",dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_PK", priority = 1)
//	public void createCustomer_verifyFunctionality(Map<String, String> map) throws Exception {	   //or public void createCustomer_verifyFunctionality(Map map) throws Exception {
//		APTLogin.get().Login("APT_login_1");
//		Thread.sleep(2000);
//		createCustomerHelper.get().createCustomerFunctionality("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("TypeToBeSelected"),  map.get("OCN"),map.get("Reference"), map.get("TechnicalContactName"), map.get("Email"),map.get("Phone"),map.get("Fax"), map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
//		createCustomerHelper.get().verifyCreatedCustomer("Customer Created successfully");
//		
//	}
//	
//	
//	@Test(description = "TC-02",dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_PK", priority = 2)
//	public void verifyCreatedCustomerDetailsInCustomerDetailsPage(Map<String, String> map) throws Exception {
//		createCustomerHelper.get().createCustomerFunctionality("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("TypeToBeSelected"),  map.get("OCN"),map.get("Reference"), map.get("TechnicalContactName"), map.get("Email"),map.get("Phone"),map.get("Fax"), map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
//		createCustomerHelper.get().verifyCreatedCustomer("Customer Created successfully");		Thread.sleep(2000);
//		createCustomerHelper.get().verifyCreatedCustomerValuesInCustomerDetailsPage("CreateCustomer", map.get("Name").toString(), map.get("MainDomain").toString(), map.get("CountryToBeSelected").toString(), map.get("TypeToBeSelected").toString(),  map.get("OCN").toString(),map.get("Reference").toString(), map.get("TechnicalContactName").toString(), map.get("Email").toString(),map.get("Phone").toString(),map.get("Fax").toString());
//	}
//	
//	
////	
////	@Test(description = "TC-08",dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_PK")
////	public void setEditedModifiedCustomerDetailsIntoExcelSheet1(Map<String, String> map) throws Exception {
////		createCustomerHelper.get().createCustomerFunctionality("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("TypeToBeSelected"),  map.get("OCN"),map.get("Reference"), map.get("TechnicalContactName"), map.get("Email"),map.get("Phone"),map.get("Fax"), map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
////		createCustomerHelper.get().verifyCreatedCustomer("Customer Created successfully");		Thread.sleep(2000);
////		System.out.println("Working till here 11");
////		
////		createCustomerHelper.get().getCreatedCustomerData("CreateCustomer");
////		System.out.println("Working till here 22");
////	
////		APT_DataReader.FinalDataReader_PK();
////		System.out.println("Working till here 11");
////		Thread.sleep(2000);
//////		APT_DataWriter.DataWriter2_CreatedCustomer_PK(dataToWrite);
////		System.out.println("Working till here 22");						Thread.sleep(2000);
////		APT_DataWriter.DataWriter3_UpdatedCustomer_PK();
////		System.out.println("Working till here 33");
////	}
//		
//	@Test(description = "TC-03",dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_PK", priority = 3)
//	public void verifyDeleteCustomerFunctionality(Map<String, String> map) throws Exception {
//		createCustomerHelper.get().createCustomerFunctionality("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("TypeToBeSelected"),  map.get("OCN"),map.get("Reference"), map.get("TechnicalContactName"), map.get("Email"),map.get("Phone"),map.get("Fax"), map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
//		createCustomerHelper.get().verifyCreatedCustomer("Customer Created successfully");		Thread.sleep(2000);
//		createCustomerHelper.get().deleteCustomer("CreateCustomer");
//	}
//	
//
//	
//	@Test(description = "TC-04", dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_PK", priority = 4)
//	public void verifyAddUserFieldsUnderCreateCustomer(Map<String, String> map) throws Exception {	  
//		Thread.sleep(2000);
//		createCustomerHelper.get().createCustomerFunctionality("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("TypeToBeSelected"),  map.get("OCN"),map.get("Reference"), map.get("TechnicalContactName"), map.get("Email"),map.get("Phone"),map.get("Fax"), map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
//		createCustomerHelper.get().verifyCreatedCustomer("Customer Created successfully");		Thread.sleep(2000);
//		createCustomerHelper.get().verifyAddUserFields("CreateCustomer");
//	}
//	
//	
//	@Test(description = "TC-05", dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_PK", priority = 5)
//	public void verifyAddUserFunctionalityUnderCreateCustomer(Map<String, String> map) throws Exception {	 
//		Thread.sleep(2000);
//		createCustomerHelper.get().createCustomerFunctionality("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("TypeToBeSelected"), map.get("OCN"),map.get("Reference"), map.get("TechnicalContactName"), map.get("Email"),map.get("Phone"),map.get("Fax"), map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
//		createCustomerHelper.get().addUserFunctionality("CreateCustomer",map.get("UserName"), map.get("FirstName"), map.get("SurName"),map.get("PostalAddress"), map.get("Email_AddUser"), map.get("Phone_AddUser"),map.get("IPGuardianAccountGroup"),map.get("ColtOnlineUser"), map.get("GeneratePassword"),map.get("RolesToBeSelected"), map.get("HideRouterToolsIPv6CommandsCisco_ToBeSelected"),map.get("HideRouterToolsIPv4CommandsHuiwai_ToBeSelected"), map.get("HideRouterToolsIPv4CommandsCisco_ToBeSelected"), map.get("HideServicesToBeSelected"),map.get("HideSiteOrderToBeSelected"));
//		createCustomerHelper.get().verifyAddedUser("Customer Created successfully");
//	  }
//	
//	
//	
//	
//	@Test(description = "TC-06",dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_PK", priority = 6)
//	public void verifyAddedUserDetailsInViewUserPage(Map<String, String> map) throws Exception {
//		createCustomerHelper.get().createCustomerFunctionality("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("TypeToBeSelected"),  map.get("OCN"),map.get("Reference"), map.get("TechnicalContactName"), map.get("Email"),map.get("Phone"),map.get("Fax"), map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
//		createCustomerHelper.get().verifyCreatedCustomer("Customer Created successfully");		Thread.sleep(2000);
//		
//		createCustomerHelper.get().verifyAddedUserValuesInViewUserPage("CreateCustomer", map.get("UserName"), map.get("FirstName"), map.get("SurName"),map.get("PostalAddress"),  map.get("Email_AddUser"),map.get("Phone_AddUser"), map.get("IPGuardianAccountGroup"),map.get("ColtOnlineUser"),map.get("RolesToBeSelected"),map.get("HideRouterToolsIPv6CommandsCisco_ToBeSelected"), map.get("HideRouterToolsIPv4CommandsHuiwai_ToBeSelected"),map.get("HideRouterToolsIPv4CommandsCisco_ToBeSelected"), map.get("HideServicesToBeSelected"), map.get("HideSiteOrderToBeSelected"));
//	}
//	
//	
//	@Test(description = "TC-07",dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_PK", priority = 7)
//	public void verifyEditCustomerFields(Map<String, String> map) throws Exception {
//		createCustomerHelper.get().createCustomerFunctionality("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("TypeToBeSelected"),  map.get("OCN"),map.get("Reference"), map.get("TechnicalContactName"), map.get("Email"),map.get("Phone"),map.get("Fax"), map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
//		createCustomerHelper.get().verifyCreatedCustomer("Customer Created successfully");		Thread.sleep(2000);
//		createCustomerHelper.get().editCustomer("CreateCustomer");
//	}
//	
//	
//	@Test(description = "TC-08", priority = 8)
//	public void verifyCreateCustomerMandatoryFields() throws Exception {
//		Thread.sleep(2000);
//		createCustomerHelper.get().verifyCreateCustomerMandatoryFields("CreateCustomer");	
//		
//	}
//
//}
