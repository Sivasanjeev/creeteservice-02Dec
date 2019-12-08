package com.saksoft.qa.apttestscripts;

import java.util.Map;

import org.testng.annotations.Test;

import com.saksoft.qa.driverlibrary.DriverTestcase;
import com.saksoft.qa.excellibrary.APT_DataReader;

public class VOIP_Statistics extends DriverTestcase {
	
	
	
	@Test(dataProviderClass = APT_DataReader.class, dataProvider = "DataProviderMethod_SI")
	public void VoipStatistics(Map map) throws Exception {
		
		APTLogin.get().Login("APT_login_1");
		System.out.println("=== APT loggedin successfully ===");
		Thread.sleep(2000);
		
		VOIPstatistics.get().leftPaneOperations("VOIPstatistics");
		
		VOIPstatistics.get().VOIPenablingdate("VOIPstatistics");
	}
	

}
