package com.saksoft.qa.testscript;

import java.io.IOException;
import java.util.Map;

import org.dom4j.DocumentException;
import org.testng.annotations.Test;

import com.saksoft.qa.driverlibrary.DriverTestcase;
import com.saksoft.qa.excellibrary.APT_DataReader;

public class Interface_ATM_WAN_PEedit extends DriverTestcase {
	
	//APT_Login login = new APT_Login();
	
	
	@Test(dataProviderClass = APT_DataReader.class, dataProvider = "DataProviderMethod_SI")
	public void InterfaceWANedit(Map map) throws Exception {
		APTLogin.get().Login("APT_login_1");
		System.out.println("=== APT loggedin successfully ===");
		Thread.sleep(2000);

				System.out.println("Entered perfectly");
				
		   //Starts performing the actions	
				
				WANedit.get().leftPaneOperations("InterfaceMultiLinkEdit");

//				WANedit.get().EnterValuesInsideTheFields("InterfaceMultiLinkEdit", map.get("Interface name").toString(),
//						map.get("Network for IPv4").toString(), map.get("Interface Address Range for IPv4_left").toString());
	}
	
	
	
	@Test(dataProviderClass = APT_DataReader.class, dataProvider = "DataProviderMethod_SI")
	public void ZConfiguration(Map map) throws InterruptedException, DocumentException, IOException {
		
		
		WANedit.get().GenerateConfiguration("Configuration");
		
		WANedit.get().SaveConfigurationToFile("Configuration");
		
		WANedit.get().EnterConfiguration("Configuration", map.get("Interface name").toString());
		
		
	}

}
