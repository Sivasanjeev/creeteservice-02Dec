package com.saksoft.qa.testscript;

import org.testng.annotations.Test;

import com.saksoft.qa.driverlibrary.DriverTestcase;

public class APT_MCS_AddMultilink extends DriverTestcase{
	
	@Test(description = "TC-01")
	public void verifyAddMultilinkPageFields() throws Exception {
		APTLogin.get().Login("APT_login_1");
		Thread.sleep(2000);
		addMultilinkHelper.get().verifyAddMultilinkPageFields("AddMultilink");
	}
	
	
	
	
	
	

}
