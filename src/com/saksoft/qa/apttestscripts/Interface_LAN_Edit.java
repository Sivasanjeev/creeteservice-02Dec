package com.saksoft.qa.apttestscripts;

import java.util.Map;

import org.testng.annotations.Test;

import com.saksoft.qa.driverlibrary.DriverTestcase;
import com.saksoft.qa.excellibrary.APT_DataReader;

public class Interface_LAN_Edit extends DriverTestcase {

	@Test(dataProviderClass = APT_DataReader.class, dataProvider = "DataProviderMethod_SI")
	public void InterfaceLANedit(Map map) throws Exception {

		APTLogin.get().Login("APT_login_1");
		System.out.println("=== APT loggedin successfully ===");
		Thread.sleep(2000);

		LANedit.get().leftPaneOperations("InterfaceLANedit");
		
		LANedit.get().SelectNetwork("InterfaceLANedit", map.get("Network for IPv4").toString());
		
		LANedit.get().GetAddress("InterfaceLANedit");
		
		LANedit.get().EIPAllocation("InterfaceLANedit");
		
		LANedit.get().SelectSpeed("InterfaceLANedit", map.get("Speed").toString());
		
		LANedit.get().SelectDuplex("InterfaceLANedit", map.get("Duplex").toString());
		
		LANedit.get().SelectIncapsulation("InterfaceLANedit", map.get("Incapsulation").toString());
		
		
		LANedit.get().RadioButtonForsecondaryIps("SecondaryIps", 1);
		
		LANedit.get().HeaderForSecondaryIps("SecondaryIps");
		
		LANedit.get().PageNavigationForSecondaryIps("SecondaryIps", "Next");
		
		
		
		

		LANedit.get().EnterValuesInsideTheFields("InterfaceLANedit", map.get("Interface name").toString(),
				map.get("Network for IPv4").toString(), map.get("Interface Address Range for IPv4_left").toString(),
				map.get("Speed").toString(), map.get("Duplex").toString(), map.get("Incapsulation").toString());
		
		LANedit.get().SecondaryIpsTable("InterfaceLANedit", 1);
		
//		LANedit.get().NavigationLink1("InterfaceLANedit", map.get("BreadcrumbForInterfaceLANEditPage").toString());
		
		LANedit.get().VerifyingThevAluesInsideTheFields("InterfaceLANedit", map.get("Interface name").toString(),
				map.get("Network for IPv4").toString(), map.get("Interface Address Range for IPv4_left").toString(),map.get("Interface Address Range for IPv4_right").toString(),
				map.get("Speed").toString(), map.get("Duplex").toString(), map.get("Incapsulation").toString());

	}

}