package com.saksoft.qa.apttestscripts;

import java.util.Hashtable;
import java.util.Map;

import org.testng.annotations.Test;
import com.saksoft.qa.driverlibrary.DriverTestcase;
import com.saksoft.qa.excellibrary.APT_DataReader;

public class Interface_MultiLink_Edit extends DriverTestcase {
	

	@Test(dataProviderClass = APT_DataReader.class, dataProvider = "DataProviderMethod_SI")
	public void InterfaceMultiLinkEdit(Map map) throws Exception {
		
		
   //TO login into the application	
		APTLogin.get().Login("APT_login_1");
		System.out.println("=== APT loggedin successfully ===");
		Thread.sleep(2000);
		

   //Starts performing the actions	

		MultilinkEdit.get().leftPaneOperations("InterfaceMultiLinkEdit");
		
		
		MultilinkEdit.get().SelectNetworkForIpv4("InterfaceMultiLinkEdit", map.get("Network for IPv4").toString());
		
		MultilinkEdit.get().GetAddress("InterfaceMultiLinkEdit");
		
		MultilinkEdit.get().EIPAllocation("InterfaceMultiLinkEdit");
		
		MultilinkEdit.get().SelectNetworkForIpv6("InterfaceMultiLinkEdit", map.get("Network for IPv6").toString());
		
		MultilinkEdit.get().GetAddressForIpv6("InterfaceMultiLinkEdit");
		
		MultilinkEdit.get().EIPAllocationForIpv6("InterfaceMultiLinkEdit");
		
		MultilinkEdit.get().RadioButtonForSecondaryIps("SecondaryIPs", 1);
		
		MultilinkEdit.get().RadioButtonForMultiBearer("MultilinkBearer", 1);
		
		MultilinkEdit.get().HeaderForSecondaryIps("SecondaryIPs", 3);
		
		MultilinkEdit.get().HeaderForMultilinkBearer("MultilinkBearer", 5);
		
		
		MultilinkEdit.get().PageNavigationForSecondaryIps("SecondaryIPs", "Next");
		
		MultilinkEdit.get().PageNavigationForMultilinkBearer("MultilinkBearer", "Next");
		

		MultilinkEdit.get().AddingvaluesTotheFields("InterfaceMultiLinkEdit", map.get("Interface name").toString(),
				map.get("Network for IPv4").toString(), map.get("Interface Address Range for IPv4_left").toString(),
				map.get("Interface name for Ipv6").toString(), map.get("Network for IPv6").toString(),
				map.get("Interface Address Range for IPv6").toString());
		
		
	    MultilinkEdit.get().FetchingValuesInsideTheFields("InterfaceMultiLinkEdit");
		
		MultilinkEdit.get().VerifyingThevAluesInsideTheFields("InterfaceMultiLinkEdit",map.get("Interface name").toString(),
				map.get("Network for IPv4").toString(), map.get("Interface Address Range for IPv4_left").toString(),
				map.get("Interface Address Range for IPv4_right").toString(), map.get("Network for IPv6").toString(),
				map.get("Interface Address Range for IPv6").toString());
	
		

		

		/*
		 * MultilinkEdit.get().SecondaryIpsTable("InterfaceMultiLinkEdit", 1);
		 * 
		 * MultilinkEdit.get().MultiBearertable("InterfaceMultiLinkEdit", 2);
		 * 
		 * // MultilinkEdit.get().NavigationLink("InterfaceMultiLinkEdit",
		 * map.get("BreadcrumbForMultilinkEditPage").toString());
		 * 
		 * MultilinkEdit.get().FetchingValuesInsideTheFields("InterfaceMultiLinkEdit");
		 * 
		 * MultilinkEdit.get().VerifyingThevAluesInsideTheFields(
		 * "InterfaceMultiLinkEdit",map.get("Interface name").toString(),
		 * map.get("Network for IPv4").toString(),
		 * map.get("Interface Address Range for IPv4_left").toString(),
		 * map.get("Interface Address Range for IPv4_right").toString(),
		 * map.get("Network for IPv6").toString(),
		 * map.get("Interface Address Range for IPv6").toString());
		 * 
		 * 
		 */	}

}
