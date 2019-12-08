package com.saksoft.qa.apttestscripts;
//import java.io.IOException;
//import java.util.Map;
//
//import org.dom4j.DocumentException;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.Test;
//
//import com.saksoft.qa.driverlibrary.Log;
//import com.saksoft.qa.excellibrary.APT_DataReader;
//
////package com.saksoft.qa.testscripts2;
////
////import java.util.Map;
////
////import org.testng.annotations.Test;
////
////import com.saksoft.qa.driverlibrary.DriverHelper;
////import com.saksoft.qa.driverlibrary.DriverTestcase;
////import com.saksoft.qa.excellibrary.APT_DataReader;
////import com.saksoft.qa.excellibrary.APT_DataWriter;
////
////public class DataWriterTest extends DriverTestcase{
////	
////	@Test(description = "TC-08",dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_PK", priority = 1)
////	public void setEditedModifiedCustomerDetailsIntoExcelSheet(Map<String, String> map) throws Exception {
////		
////		APTLogin.get().Login("APT_login_1");
////		
////		//createCustomerHelper.get().verifyCreateCustomerFunctionality("CreateCustomer", map.get("Name").toString(), map.get("MainDomain").toString(), map.get("CountryToBeSelected").toString(), map.get("TypeToBeSelected").toString(),  map.get("OCN").toString(),map.get("Reference").toString(), map.get("TechnicalContactName").toString(), map.get("Email").toString(),map.get("Phone").toString(),map.get("Fax").toString());
////		
////		APT_DataReader.FinalDataReader_PK();
////		System.out.println("Working till here 11");
////		Thread.sleep(2000);
////		APT_DataWriter.DataWriter2_CreatedCustomer_PK();
////		System.out.println("Working till here 22");						Thread.sleep(2000);
////		
////		APT_DataWriter.DataWriter3_UpdatedCustomer_PK();
////		System.out.println("Working till here 33");
////		
////		
////	}
////}
//
//
//
//
//
//
//
//
//
//
//
//
//@Test(description = "TC-12", dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_PK")
//	public void verifyAddUserFunctionality_CreateCustomer(Map<String, String> map) throws Exception {	 
//		APTLogin.get().Login("APT_login_1");
//		Thread.sleep(2000);
//		createCustomerHelper.get().createCustomerFunctionality("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("TypeToBeSelected"),  
//				map.get("OCN"),map.get("Reference"), map.get("TechnicalContactName"), map.get("Email"),map.get("Phone"),map.get("Fax"), map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
////		createCustomerHelper.get().verifyCreatedCustomer("Customer Created successfully");
////	@Test(dataProviderClass = APT_DataReader.class, dataProvider ="FinalDataReader2_PK", priority = 4)
////	public void verifyAddUserFunctionality(Map<String, String> map) throws Exception {
//		
//		
//		System.out.println("==========Issue facing area==========");
//		createCustomerHelper.get().addUserFunctionality2("CreateCustomer",map.get("UserName").toString(), map.get("FirstName").toString(), map.get("SurName").toString(),
//				map.get("PostalAddress").toString(), map.get("Email_AddUser").toString(), map.get("Phone_AddUser").toString(),map.get("IPGuardianAccountGroup").toString(),
//				map.get("ColtOnlineUser").toString(), map.get("GeneratePasswordPk").toString(),map.get("RolesToBeSelected").toString(), map.get("HideRouterToolsIPv6CommandsCisco_ToBeSelected").toString(),
//				map.get("HideRouterToolsIPv4CommandsHuiwai_ToBeSelected").toString(), map.get("HideRouterToolsIPv4CommandsCisco_ToBeSelected").toString(), map.get("HideServicesToBeSelected").toString(),
//				map.get("HideSiteOrderToBeSelected").toString());
//		createCustomerHelper.get().verifyAddedUser("Customer Created successfully");
//	  }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//public void addUserFunctionality2(String application, String UserName, String FirstName, String SurName,String PostalAddress, String Email_AddUser, String Phone_AddUser, String IPGuardianAccountGroup,String ColtOnlineUser, String GeneratePasswordPk, String RolesToBeSelected,String	HideRouterToolsIPv6CommandsCisco_ToBeSelected,String HideRouterToolsIPv4CommandsHuiwai_ToBeSelected,String	HideRouterToolsIPv4CommandsCisco_ToBeSelected,String HideServicesToBeSelected,String HideSiteOrderToBeSelected) throws InterruptedException, DocumentException, IOException {
//	System.out.println("================It entered inside==========");
//	
//	Thread.sleep(1000);
//	Clickon(getwebelement(xml.getlocator("//locators/"+application+"/Users_Action")));					Thread.sleep(1000);
//	Clickon(getwebelement(xml.getlocator("//locators/"+application+"/AddUserLink")));					Thread.sleep(1000);
//	
//	SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/UserName")), UserName);			Thread.sleep(1000);
//	Log.info("===UserName Entered ===");
//	SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/FirstName")), FirstName);			Thread.sleep(1000);
//	Log.info("===FirstName Entered ===");
//	SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/SurName")), SurName);				Thread.sleep(1000);
//	Log.info("===SurName Entered ===");
//	SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/PostalAddress")), PostalAddress);		Thread.sleep(1000);
//	Log.info("===PostalAddress Entered ===");
//	SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/Email")), Email_AddUser);					Thread.sleep(1000);
//	Log.info("===Email Entered ===");
//	SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/Phone")), Phone_AddUser);					Thread.sleep(1000);
//	Log.info("===Phone Entered ===");
//	SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/IPGuardianAccountGroup")), IPGuardianAccountGroup);	Thread.sleep(1000);
//	Log.info("===IPGuardianAccountGroup Entered ===");
//	SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/ColtOnlineUser")), ColtOnlineUser);	Thread.sleep(1000);
//	Log.info("===ColtOnlineUser Entered ===");
//	
//	
//	
//		//Clickon(getwebelement(xml.getlocator("//locators/"+application+"/GeneratePasswordLink")));					Thread.sleep(2000);
//	SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/Password_Textfield")), GeneratePasswordPk);	Thread.sleep(1000);
//	Log.info("===Password Entered ===");
//    
//	
//	Clickon(getwebelement(xml.getlocator("//locators/"+application+"/RolesSelect")));										Thread.sleep(1000);
//	WebElement el1 = driver.findElement(By.xpath("//div[div[contains(text(),'"+RolesToBeSelected+"')]]/input"));
//	el1.click();						
//	Log.info("=== Roles selected===");
//	
//	Clickon(getwebelement(xml.getlocator("//locators/"+application+"/HideRouterToolsIPv6Commands_CiscoSelect")));					Thread.sleep(2000);
//	WebElement el2 = driver.findElement(By.xpath("//div[contains(text(),'"+HideRouterToolsIPv6CommandsCisco_ToBeSelected+"')]"));
//	el2.click();						
//	Log.info("=== HideRouterToolsIPv6CommandsCisco selected===");
//	
//	Clickon(getwebelement(xml.getlocator("//locators/"+application+"/HideRouterToolsIPv4Commands_HuiwaiSelect")));					Thread.sleep(2000);
//	WebElement el3 = driver.findElement(By.xpath("//div[contains(text(),'"+HideRouterToolsIPv4CommandsHuiwai_ToBeSelected+"')]"));
//	el3.click();						
//	Log.info("=== HideRouterToolsIPv4CommandsHuiwai selected===");
//	
//	Clickon(getwebelement(xml.getlocator("//locators/"+application+"/HideRouterToolsIPv4Commands_CiscoSelect")));					Thread.sleep(2000);
//	WebElement el4 = driver.findElement(By.xpath("//div[contains(text(),'"+HideRouterToolsIPv4CommandsCisco_ToBeSelected+"')]"));
//	el4.click();						
//	Log.info("=== HideRouterToolsIPv4CommandsCisco selected===");
//	
//	Clickon(getwebelement(xml.getlocator("//locators/"+application+"/HideServicesSelect")));			Thread.sleep(2000);
//	WebElement el5 = driver.findElement(By.xpath("//div[contains(text(),'"+HideServicesToBeSelected+"')]"));
//	el5.click();						
//	Log.info("=== Hide Services selected===");
//	
//	Clickon(getwebelement(xml.getlocator("//locators/"+application+"/HideSiteOrderSelect")));			Thread.sleep(2000);
//	WebElement el6 = driver.findElement(By.xpath("//div[contains(text(),'"+HideSiteOrderToBeSelected+"')]"));
//	el6.click();						
//	Log.info("=== Hide Site Order selected===");
//	
//	
////    String CustomerAdmin=getwebelement(xml.getlocator("//locators/"+application+"/CustomerAdmin_RoleSelect")).getText();		Thread.sleep(2000);
////    Select(getwebelement(xml.getlocator("//locators/"+application+"/CustomerAdmin_RoleSelect")), "Customer Admin");		
//    
////	WebElement rolesWb=getwebelement(xml.getlocator("//locators/"+application+"/RolesSelect"));
////	Select(rolesWb, "Customer Admin");
////	Log.info("=== Customer Admin Selected ===");
////	  // To get list of values in dropdown
////	  List<String> TotalValues1 = getAllValuesInsideDropDown(rolesWb);
////	  for (int i = 0; i < TotalValues1.size(); i++) {
////	 System.out.println("The list of values in dropdown are: " +
////	  TotalValues1.get(i)); 
////	  }
//    
//
//	Clickon(getwebelement(xml.getlocator("//locators/"+application+"/OutSideOfDropdown")));				Thread.sleep(2000);
//	Clickon(getwebelement(xml.getlocator("//locators/"+application+"/OkButton_AddUser")));				Thread.sleep(2000);
//	//Clickon(getwebelement(xml.getlocator("//locators/"+application+"/CancelButton_AddUser")));		Thread.sleep(2000);
//	
//			//VerifyText("Customer Created successfully");
//	
//}