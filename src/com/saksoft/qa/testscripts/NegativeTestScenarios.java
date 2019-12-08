package com.saksoft.qa.testscript;

import java.io.IOException;
import java.util.Map;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.saksoft.qa.driverlibrary.DriverHelper;
import com.saksoft.qa.driverlibrary.DriverTestcase;
import com.saksoft.qa.driverlibrary.XMLReader;
import com.saksoft.qa.excellibrary.APT_DataReader;
import com.saksoft.qa.scripthelpers.NegativeScenariosHelper;

public class NegativeTestScenarios extends DriverTestcase{

	
	@Test(description ="TC-01", dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_negative")
	public void checkPhoneTextInputField_CreateCustomer(Map<String, String>map) throws InterruptedException, DocumentException, IOException {
	
	
	negativeScenariosHelper.get().createCustomerFunctionality("CreateCustomer",  map.get("Phone"), map.get("Fax"));
	negativeScenariosHelper.get().checkWetherTextFieldIsAcceptingCharOrNumericOrSpecialCharacter(map.get("Phone"));
  }
	
	@Test(description ="TC-02", dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_negative")
	public void checkFaxTextInputField_CreateCustomer(Map<String, String>map) throws InterruptedException, DocumentException, IOException {
	
	negativeScenariosHelper.get().createCustomerFunctionality("CreateCustomer",  map.get("Phone"), map.get("Fax"));
	negativeScenariosHelper.get().checkWetherTextFieldIsAcceptingCharOrNumericOrSpecialCharacter(map.get("Fax"));
  }
	
	@Test(description = "TC-03",dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader_PK")
	public void test1(Map<String, String>map) throws InterruptedException, DocumentException, IOException {
		createCustomerHelper.get().createCustomerFunctionality("CreateCustomer", map.get("Name"), map.get("MainDomain"), map.get("CountryToBeSelected"), map.get("TypeToBeSelected"),  map.get("OCN"),map.get("Reference"), map.get("TechnicalContactName"), map.get("Email"),map.get("Phone"),map.get("Fax"), map.get("DedicatedPortalStatus"), map.get("DedicatedPortal"));
		negativeScenariosHelper.get().checkWetherTextFieldIsAcceptingCharOrNumericOrSpecialCharacter(map.get("Phone"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
