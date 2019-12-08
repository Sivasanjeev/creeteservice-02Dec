package com.saksoft.qa.apttestscripts;

import java.util.Map;

import org.testng.annotations.Test;

import com.saksoft.qa.driverlibrary.DriverTestcase;
import com.saksoft.qa.excellibrary.APT_DataReader;

public class Interface_MLPPP_Edit extends DriverTestcase{
	
	@Test(dataProviderClass = APT_DataReader.class, dataProvider = "DataProviderMethod_SI")
	public void InterfaceMLPPPedit(Map map) throws Exception {
		APTLogin.get().Login("APT_login_1");
		System.out.println("=== APT loggedin successfully ===");
		Thread.sleep(2000);
		
		MLPPPedit.get().leftPaneOperations("InterfaceMLPPPedit");
		
		MLPPPedit.get().AddingValuesInsideTheFields("InterfaceMLPPPedit", map.get("Network for IPv4").toString());
		
//		MLPPPedit.get().RadioButtonForMultiBearer("MultilinkBearer", 1);
		
//		MLPPPedit.get().VerifyHeaderNames("MultilinkBearer");
		
		MLPPPedit.get().rowIndex("MultilinkBearer");
		
		
	}

}
