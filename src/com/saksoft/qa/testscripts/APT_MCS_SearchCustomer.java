package com.saksoft.qa.testscript;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.saksoft.qa.driverlibrary.DriverHelper;
import com.saksoft.qa.driverlibrary.DriverTestcase;
import com.saksoft.qa.driverlibrary.Log;
import com.saksoft.qa.excellibrary.APT_DataReader;

public class APT_MCS_SearchCustomer extends DriverTestcase {


	
	@Test(description = "TC-01", priority = 11)
	public void verifySearchCustomerFields() throws Exception {
		Log.startTestCase("Manage Customer's Service- Verify search Customer fields Test Started");
		Reporter.log("Manage Customer's Service- Verify search Customer fields Test Started");
		Thread.sleep(2000);
		searchCustomerHelper.get().verifySearchCustomerFields("SearchCustomer");
		Log.endTestCase("Manage Customer's Service- Verify search Customer fields Test Started");
		Reporter.log("Manage Customer's Service- Verify search Customer fields Test Started");
		
	}
	
	@Test(description = "TC-02", dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader3_PK", priority = 12)
	public void verifySearchCustomerFunctionality(Map<String, String> map) throws Exception {
		Log.startTestCase("Manage Customer's Service- Verify search Customer fields Test Completed");
		Reporter.log("Manage Customer's Service- Verify search Customer fields Test Completed");
		Thread.sleep(2000);
		searchCustomerHelper.get().verifySearchCustomerFunctionality("SearchCustomer", map.get("Name").toString(), map.get("OCN").toString(), map.get("MainDomain").toString(), map.get("Reference").toString(), map.get("CountryToBeSelected").toString(), map.get("TypeToBeSelected").toString());	
		Log.endTestCase("Manage Customer's Service- Verify search Customer Functionality Test Completed");
		Reporter.log("Manage Customer's Service- Verify search Customer Functionality Test Completed");
		
	}
	
	
}
