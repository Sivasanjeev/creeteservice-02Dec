package com.saksoft.qa.apttestscripts;


import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.saksoft.qa.driverlibrary.DriverTestcase;
import com.saksoft.qa.excellibrary.APT_DataReader_SS;

public class APT_MCS_CreateOrderService extends DriverTestcase{
	
   APT_Login login = new APT_Login();

   
	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService")
	public void verifyCreateNewOrderServiceFunctionality(Map<String, String> map) throws Exception {

		DriverTestcase.logger = DriverTestcase.extent.startTest("verifyCreateNewOrderServiceFunctionality");
		login.APT_Login_1();
		
		
		 createOrderServiceHelper.get().selectCustomertocreateOrder("CreateOrderService",map.get("ChooseCustomerToBeSelected"),map.get("Customername"));
		
		
	System.out.println("-------Verify the fields for Service type and select the service sub type------------1");	
		createOrderServiceHelper.get().Verifyfields(("CreateOrderService"),map.get("ServiceType"), map.get("Modularmsp"), map.get("AutocreateService"));
		createOrderServiceHelper.get().selectCustomertocreateOrderfromleftpane("CreateOrderService",map.get("ChooseCustomerToBeSelected"),map.get("Customername"));
		createOrderServiceHelper.get().SelectServiceType("CreateOrderService", map.get("Order/ContractNumber"),map.get("ServiceType"), map.get("Ordertype"), map.get("valuetobeselectedinorderdropdown"));
		 
	System.out.println("------After selecting service type------2");
		createOrderServiceHelper.get().selectsubtypeunderServiceTypeSelected("LANLINK",map.get("Servicesubtype"),map.get("Interfacespeed"),map.get("Modularmsp"),
				map.get("AutocreateService"), map.get("A_Endtechnology"), map.get("B_Endtechnology"));
		

	System.out.println("----Verify the fields for Service sub type selected----------3");
		createOrderServiceHelper.get().VerifyFieldsForServiceSubTypeSelected("LANLINK",map.get("ServiceType"),map.get("Servicesubtype"), map.get("Interfacespeed"),
				map.get("Notification management"), map.get("vpnTopology"), map.get("AggregateTraffic"), map.get("Modularmsp"));	
	
	System.out.println("------Enter data for the service sub type selected-------4");	
		createOrderServiceHelper.get().SelectServiceType("CreateOrderService", map.get("Order/ContractNumber"),map.get("ServiceType"), map.get("Ordertype"), map.get("valuetobeselectedinorderdropdown"));
		createOrderServiceHelper.get().selectsubtypeunderServiceTypeSelected("LANLINK",map.get("Servicesubtype"),map.get("Interfacespeed"),map.get("Modularmsp"),
					map.get("AutocreateService"), map.get("A_Endtechnology"), map.get("B_Endtechnology"));
		createOrderServiceHelper.get().dataToBeEnteredOncesubservicesselected("LANLINK",map.get("Servicesubtype"),map.get("Interfacespeed"),map.get("serviceNumber"),map.get("endpointCPE"),map.get("email"), map.get("phone"), map.get("remark"), 
				map.get("PerformMonitor"),map.get("proactiveMonitor"), map.get("deliveryChannel"), map.get("ManagementOrder"), map.get("vpnTopology"), map.get("intermediateTechnology"),
				map.get("CircuitReference"), map.get("CircuitType"), map.get("AggregateTraffic"), map.get("Delivery channel for select tag"),map.get("Modularmsp"),
				map.get("AutocreateService"), map.get("ENNI checkbox"), map.get("manageConnectiondropdown"), map.get("A_Endtechnology"), map.get("B_Endtechnology"), map.get("Notification management"));
	    createOrderServiceHelper.get().verifysuccessmessageforCreateService();
		
	System.out.println("-------- Verify data entered under service sub types---------5");		
		createOrderServiceHelper.get().VerifydatenteredForServiceSubTypeSelected("LANLINK",map.get("servicetypeforverification"),map.get("Servicesubtype"),map.get("Interfacespeed"),map.get("serviceNumber"),map.get("endpointCPE"),map.get("email"), map.get("phone"), map.get("remark"), 
				map.get("PerformMonitor"),map.get("proactiveMonitor"), map.get("deliveryChannel"), map.get("ManagementOrder"), map.get("vpnTopology"), map.get("intermediateTechnology"),
				map.get("CircuitReference"), map.get("CircuitType"), map.get("AggregateTraffic"), map.get("Delivery channel for select tag"),map.get("Modularmsp"),
				map.get("AutocreateService"), map.get("ENNI checkbox"), map.get("manageConnectiondropdown"), map.get("A_Endtechnology"), map.get("B_Endtechnology"));
	

		
//	System.out.println("------Verify fields for add site order-------- 6");
//		createOrderServiceHelper.get().Enteraddsiteorder("LANLINK");
//		createOrderServiceHelper.get().verifyaddsiteorderfields("LANLINK");
//		
//		
//	System.out.println("---- add and verifying the details under view site order page-------7");
//		createOrderServiceHelper.get().Enteraddsiteorder("LANLINK");
//		createOrderServiceHelper.get().addsiteorder( "LANLINK" ,map.get("country"),map.get("city"),map.get("CSR_Name"), 
//				 map.get("site"), map.get("performReport"), map.get("Proactivemonitor"),map.get("smartmonitor"),
//				   map.get("technology"),map.get("siteallias"), map.get("VLANid"), map.get("DCAenabledsite"), map.get("cloudserviceprovider"), map.get("sitevalue"), map.get("siteorder_Remark"));
//		createOrderServiceHelper.get().VerifyDataEnteredForSiteOrder( "LANLINK" ,map.get("country"),map.get("city"),map.get("CSR_Name"), 
//				 map.get("site"), map.get("performReport"), map.get("ProactiveMonitor"),map.get("smartmonitor"),
//				 map.get("technology"),map.get("siteallias"), map.get("VLANid"), map.get("DCAenabledsite"), map.get("cloudserviceprovider"), map.get("sitevalue"), map.get("siteorder_Remark"));
//
//	System.out.println("----verify details inside the siteorder table under view service page-----------");
//		createOrderServiceHelper.get().VerifySiteOrderdetailsInTable("LANLINK", map.get("Siteordernumber"));
//
//	
//	System.out.println("-------verify Edit site order fields--------8");
//		createOrderServiceHelper.get().clickonEditwithoutselectingrow("LANLINK");
//		createOrderServiceHelper.get().selectRowForsiteorder("LANLINK", map.get("Siteordernumber"));
//		createOrderServiceHelper.get().verifyEditSiteOrder("LANLINK" ,map.get("country"),map.get("city"),map.get("CSR_Name"), 
//			 map.get("site"), map.get("performReport"), map.get("Proactivemonitor"),map.get("smartmonitor"),
//			 map.get("technology"),map.get("siteallias"), map.get("VLANid"), map.get("DCAenabledsite"), map.get("cloudserviceprovider"), map.get("sitevalue"));
//		
//		
//	System.out.println("----- edit site order page-----------9");
//		createOrderServiceHelper.get().selectRowForsiteorder("LANLINK", map.get("Siteordernumber"));		  
//		createOrderServiceHelper.get().editSiteOrder( "LANLINK" , map.get("performReport"), map.get("ProactiveMonitor"),map.get("smartmonitor"),
//		     map.get("siteallias"), map.get("VLANid"), map.get("DCAenabledsite"), map.get("cloudserviceprovider"));
//		
//		
//	System.out.println("--------delete site order -----------10");
//		createOrderServiceHelper.get().clickondeletewithoutselectingrow("LANLINK");		
//		createOrderServiceHelper.get().selectRowForsiteorder("LANLINK", map.get("Siteordernumber"));
//		createOrderServiceHelper.get().deletesiteorderdetails("LANLINK");
//		
//		
//	System.out.println("--------- view site order page--------11");
//		createOrderServiceHelper.get().clickonviewewithoutselectingrow("LANLINK");		
//		createOrderServiceHelper.get().selectRowForsiteorder("LANLINK", map.get("Siteordernumber"));
//		createOrderServiceHelper.get().viewsiteorderdetails("LANLINK");	
//		
//		
//	System.out.println("------For Equipment ..........Entering add cpe device, Verify CPE device, Edit CPE device----------");
//		String servicesubtype=map.get("Servicesubtype");
//	
//		if(servicesubtype.equals("Direct Fibre") || servicesubtype.equalsIgnoreCase("LANLink International") || servicesubtype.equalsIgnoreCase("LANLink Metro") || servicesubtype.equalsIgnoreCase("OLO - (GCR/EU)"))
//		{
//		createOrderServiceHelper.get().AddCPEdevicefortheserviceselected( "LANLINK",  map.get("cpename"), map.get("cpe_vender"),  map.get("cpe_snmpro"),  map.get("cpe_managementAddress"), map.get("cpe_Mepid"),
//			 map.get("cpe_poweralarm"), map.get("cpe_Mediaselection"),  map.get("cpe_Macaddress"),  map.get("cpe_serialNumber"),
//			 map.get("cpe_hexaSerialnumber"),  map.get("cpe_linkLostForwarding"));
//		createOrderServiceHelper.get().verifydetailsenteredforCPEdevice( "LANLINK",  map.get("cpename"), map.get("cpe_vender"),  map.get("cpe_snmpro"),  map.get("cpe_managementAddress"), map.get("cpe_Mepid"),
//			 map.get("cpe_poweralarm"), map.get("cpe_Mediaselection"),  map.get("cpe_Macaddress"),  map.get("cpe_serialNumber"),
//			 map.get("cpe_hexaSerialnumber"),  map.get("cpe_linkLostForwarding"));
//		createOrderServiceHelper.get().eDITCPEdevicedetailsentered( "LANLINK",  map.get("EDIT_cpename"), map.get("EDIT_cpe_vender"),  map.get("EDIT_cpe_snmpro"),  map.get("EDIT_cpe_managementAddress"), map.get("EDIT_cpe_Mepid"),
//			 map.get("EDIT_cpe_poweralarm"), map.get("EDIT_cpe_Mediaselection"),  map.get("EDIT_cpe_Macaddress"),  map.get("EDIT_cpe_serialNumber"),
//			 map.get("EDIT_cpe_hexaSerialnumber"),  map.get("EDIT_cpe_linkLostForwarding"));
//	     
//		createOrderServiceHelper.get().returnbacktoviewsiteorderpage("LANLINK");
//		
//	System.out.println("--------SELECTINTERFACE link for Equipment--------13");
//		createOrderServiceHelper.get().selectInterfacelinkforEqipment("LANLINK");
//		createOrderServiceHelper.get().SelectInterfacetoaddwithservcie("LANLINK", map.get("Interfacetoselect_Interfacenumber"));
//		createOrderServiceHelper.get().verifyInterfaceaddedToService("LANLINK", map.get("Interfacetoselect_Interfacenumber"));
//		createOrderServiceHelper.get().SelectInterfacetoremovefromservice("LANLINK", map.get("Interfaceinservice_Interfacenumber"));
//		createOrderServiceHelper.get().verifyInterfaceremovedFromService("LANLINK", map.get("Interfaceinservice_Interfacenumber"));
//
//		createOrderServiceHelper.get().returnbacktoviewsiteorderpage("LANLINK");
//		
//	System.out.println("-----------Show Interface link for Equipment----------14");
//			createOrderServiceHelper.get().SelectShowInterfacelinkAndVerifyEditInterfacePage("LANLINK", map.get("Interfacename_forEditInterface"));
//			createOrderServiceHelper.get().EnterdataForEditInterfaceforShowInterfacelinkunderEquipment("LANLINK",  map.get("Interfacename_forEditInterface"), map.get("editInterfacepage_circuitId"), map.get("editInterfacepage_BearerType"),
//					map.get("editInterfacepage_BearerSpeed"), map.get("editInterfacepage_bandwidth"), map.get("editInterfacepage_Vlanid"), map.get("editInterfacepage_vlantype"));
//		
//	System.out.println("------------CONFIGURE link for Equipment--------------15");
//	    createOrderServiceHelper.get().selectconfigurelinkAndverifyEditInterfacefield("LANLINK", map.get("Interfacename_forEditInterface"));
//	    createOrderServiceHelper.get().EnterdataForEditInterfaceforConfigurelinkunderEquipment("LANLINK",  map.get("Interfacename_forEditInterface"), map.get("editInterfacepage_circuitId"), map.get("editInterfacepage_BearerType"),
//				map.get("editInterfacepage_BearerSpeed"), map.get("editInterfacepage_bandwidth"), map.get("editInterfacepage_Vlanid"), map.get("editInterfacepage_vlantype"));
//	    
//	    createOrderServiceHelper.get().returnbacktoviewsiteorderpage("LANLINK");
//			
//	System.out.println("----------------Delete device from service------------------ ");
//		createOrderServiceHelper.get().deleteDeviceFromServiceForequipment("LANLINK", map.get("deleteDeviceforequipment"));
//		
//		
//	System.out.println("--------For intermediate Equipment-------------");	
//		createOrderServiceHelper.get().addCPEdeviceforIntermediateequipment( "LANLINK",  map.get("cpeintEquip_name"), map.get("cpeintequip_vender"),  map.get("cpeintequip_snmpro"), 
//				map.get("cpeintequip_managementAddress"), map.get("cpeintequip_Mepid"),
//				map.get("cpeintequip_poweralarm"), map.get("cpeintequip_Mediaselection"),  map.get("cpeintequip_Macaddress"),  map.get("cpeintequip_serialNumber"),
//				map.get("cpeintequip_hexaSerialnumber"),  map.get("cpeintequip_linkLostForwarding"), map.get("cpeintequip_country"), map.get("cpeintequip_city"),
//				map.get("cpeintequip_site"), map.get("cpeintequip_premise"));	
//	   createOrderServiceHelper.get().verifyCPEdevicedataenteredForIntermediateEquipment( "LANLINK",  map.get("cpeintEquip_name"), map.get("cpeintequip_vender"),  map.get("cpeintequip_snmpro"), 
//				map.get("cpeintequip_managementAddress"), map.get("cpeintequip_Mepid"),
//				map.get("cpeintequip_poweralarm"), map.get("cpeintequip_Mediaselection"),  map.get("cpeintequip_Macaddress"),  map.get("cpeintequip_serialNumber"),
//				map.get("cpeintequip_hexaSerialnumber"),  map.get("cpeintequip_linkLostForwarding"), map.get("cpeintequip_country"), map.get("cpeintequip_city"),
//				map.get("cpeintequip_site"), map.get("cpeintequip_premise"));	
//	   createOrderServiceHelper.get().EDITCPEdevicedforIntermediateEquipment( "LANLINK",  map.get("cpeintEquip_name"), map.get("cpeintequip_vender"),  map.get("cpeintequip_snmpro"), 
//				map.get("cpeintequip_managementAddress"), map.get("cpeintequip_Mepid"),
//				map.get("cpeintequip_poweralarm"), map.get("cpeintequip_Mediaselection"),  map.get("cpeintequip_Macaddress"),  map.get("cpeintequip_serialNumber"),
//				map.get("cpeintequip_hexaSerialnumber"),  map.get("cpeintequip_linkLostForwarding"), map.get("cpeintequip_country"), map.get("cpeintequip_city"),
//				map.get("cpeintequip_site"), map.get("cpeintequip_premise"));
//		
//	   createOrderServiceHelper.get().returnbacktoviewsiteorderpage("LANLINK");
//	   
//    System.out.println("------"+ "SELECTINTERFACE"+ "link for Intermediate Equipment--------16");
//		createOrderServiceHelper.get().selectInterfacelinkforIntermediateEqipment("LANLINK");	
//		createOrderServiceHelper.get().SelectInterfacetoaddwithservcie("LANLINK", map.get("Interfacetoselect_Interfacenumber"));  
//		createOrderServiceHelper.get().verifyInterfaceaddedToService("LANLINK", map.get("Interfacetoselect_Interfacenumber"));
//		createOrderServiceHelper.get().SelectInterfacetoremovefromservice("LANLINK", map.get("Interfaceinservice_Interfacenumber"));
//		createOrderServiceHelper.get().verifyInterfaceremovedFromService("LANLINK", map.get("Interfaceinservice_Interfacenumber"));
//		
//		createOrderServiceHelper.get().returnbacktoviewsiteorderpage("LANLINK");
//	
//    System.out.println("--------------Select Configure link under Intermediate Equipment------------------");	
//		createOrderServiceHelper.get().selectconfigurelinkunderIntermediateEquipmentAndverifyEditInterfacefield("LANLINK", map.get("Interfacename_forEditInterface"));
//		createOrderServiceHelper.get().EnterdataForEditInterfaceforConfigurelinkunderIntermediateEquipment("LANLINK",  map.get("Interfacename_forEditInterface"), map.get("editInterfacepage_circuitId"), map.get("editInterfacepage_BearerType"),
//				map.get("editInterfacepage_BearerSpeed"), map.get("editInterfacepage_bandwidth"), map.get("editInterfacepage_Vlanid"), map.get("editInterfacepage_vlantype"));
//	    
//	
//		createOrderServiceHelper.get().returnbacktoviewsiteorderpage("LANLINK");
//		
//	 System.out.println("-----------Show Interface link for Equipment----------14");
//		createOrderServiceHelper.get().SelectShowInterfacelink_IntermediateequipmentAndVerifyEditInterfacePage("LANLINK", map.get("Interfacename_forEditInterface"));
//		createOrderServiceHelper.get().EnterdataForEditInterfaceforShowInterfacelinkunderIntermediateEquipment("LANLINK",  map.get("Interfacename_forEditInterface"), map.get("editInterfacepage_circuitId"), map.get("editInterfacepage_BearerType"),
//				map.get("editInterfacepage_BearerSpeed"), map.get("editInterfacepage_bandwidth"), map.get("editInterfacepage_Vlanid"), map.get("editInterfacepage_vlantype"));
//	
//
//    System.out.println("-------------Delete device from service for intermediate equipment---------");
//		createOrderServiceHelper.get().deleteDeviceFromServiceForIntermediateequipment("LANLINK", map.get("deleteDeviceforIntermediateequipment"));
//
//		
//		
//		}
//		
//
//
//	else if (servicesubtype.equalsIgnoreCase("LANLink National")) {
//
//			createOrderServiceHelper.get().AddDSLAMandHSL("LANLINK", map.get("DSLMdevice"));
//			createOrderServiceHelper.get().AddCPEdevicefortheserviceselected( "LANLINK",  map.get("cpename"), map.get("cpe_vender"),  map.get("cpe_snmpro"),  map.get("cpe_managementAddress"), map.get("cpe_Mepid"),
//					 map.get("cpe_poweralarm"), map.get("cpe_Mediaselection"),  map.get("cpe_Macaddress"),  map.get("cpe_serialNumber"),
//					   map.get("cpe_hexaSerialnumber"),  map.get("cpe_linkLostForwarding"));
//			createOrderServiceHelper.get().verifydetailsenteredforCPEdevice( "LANLINK",  map.get("cpename"), map.get("cpe_vender"),  map.get("cpe_snmpro"),  map.get("cpe_managementAddress"), map.get("cpe_Mepid"),
//					map.get("cpe_poweralarm"), map.get("cpe_Mediaselection"),  map.get("cpe_Macaddress"),  map.get("cpe_serialNumber"),
//					   map.get("cpe_hexaSerialnumber"),  map.get("cpe_linkLostForwarding"));
//			createOrderServiceHelper.get().eDITCPEdevicedetailsentered( "LANLINK",  map.get("EDIT_cpename"), map.get("EDIT_cpe_vender"),  map.get("EDIT_cpe_snmpro"),  map.get("EDIT_cpe_managementAddress"), map.get("EDIT_cpe_Mepid"),
//					 map.get("EDIT_cpe_poweralarm"), map.get("EDIT_cpe_Mediaselection"),  map.get("EDIT_cpe_Macaddress"),  map.get("EDIT_cpe_serialNumber"),
//					   map.get("EDIT_cpe_hexaSerialnumber"),  map.get("EDIT_cpe_linkLostForwarding"));
//		
//			
//			
//			
//			
//			createOrderServiceHelper.get().addCPEdeviceforIntermediateequipment( "LANLINK",  map.get("cpeintEquip_name"), map.get("cpeintequip_vender"),  map.get("cpeintequip_snmpro"), 
//					map.get("cpeintequip_managementAddress"), map.get("cpeintequip_Mepid"),
//					map.get("cpeintequip_poweralarm"), map.get("cpeintequip_Mediaselection"),  map.get("cpeintequip_Macaddress"),  map.get("cpeintequip_serialNumber"),
//					map.get("cpeintequip_hexaSerialnumber"),  map.get("cpeintequip_linkLostForwarding"), map.get("cpeintequip_country"), map.get("cpeintequip_city"),
//					map.get("cpeintequip_site"), map.get("cpeintequip_premise"));	
//		   createOrderServiceHelper.get().verifyCPEdevicedataenteredForIntermediateEquipment( "LANLINK",  map.get("cpeintEquip_name"), map.get("cpeintequip_vender"),  map.get("cpeintequip_snmpro"), 
//					map.get("cpeintequip_managementAddress"), map.get("cpeintequip_Mepid"),
//					map.get("cpeintequip_poweralarm"), map.get("cpeintequip_Mediaselection"),  map.get("cpeintequip_Macaddress"),  map.get("cpeintequip_serialNumber"),
//					map.get("cpeintequip_hexaSerialnumber"),  map.get("cpeintequip_linkLostForwarding"), map.get("cpeintequip_country"), map.get("cpeintequip_city"),
//					map.get("cpeintequip_site"), map.get("cpeintequip_premise"));	
//		   createOrderServiceHelper.get().EDITCPEdevicedforIntermediateEquipment( "LANLINK",  map.get("cpeintEquip_name"), map.get("cpeintequip_vender"),  map.get("cpeintequip_snmpro"), 
//					map.get("cpeintequip_managementAddress"), map.get("cpeintequip_Mepid"),
//					map.get("cpeintequip_poweralarm"), map.get("cpeintequip_Mediaselection"),  map.get("cpeintequip_Macaddress"),  map.get("cpeintequip_serialNumber"),
//					map.get("cpeintequip_hexaSerialnumber"),  map.get("cpeintequip_linkLostForwarding"), map.get("cpeintequip_country"), map.get("cpeintequip_city"),
//					map.get("cpeintequip_site"), map.get("cpeintequip_premise"));
//			
//		   createOrderServiceHelper.get().returnbacktoviewsiteorderpage("LANLINK");
//		   
//	     System.out.println("------"+ "SELECTINTERFACE"+ "link for Intermediate Equipment--------16");
//			createOrderServiceHelper.get().selectInterfacelinkforIntermediateEqipment("LANLINK");	
//			createOrderServiceHelper.get().SelectInterfacetoaddwithservcie("LANLINK", map.get("Interfacetoselect_Interfacenumber"));  
//			createOrderServiceHelper.get().verifyInterfaceaddedToService("LANLINK", map.get("Interfacetoselect_Interfacenumber"));
//			createOrderServiceHelper.get().SelectInterfacetoremovefromservice("LANLINK", map.get("Interfaceinservice_Interfacenumber"));
//			createOrderServiceHelper.get().verifyInterfaceremovedFromService("LANLINK", map.get("Interfaceinservice_Interfacenumber"));
//			
//			createOrderServiceHelper.get().returnbacktoviewsiteorderpage("LANLINK");
//		
//	     System.out.println("--------------Select Configure link under Intermediate Equipment------------------");	
//			createOrderServiceHelper.get().selectconfigurelinkunderIntermediateEquipmentAndverifyEditInterfacefield("LANLINK", map.get("Interfacename_forEditInterface"));
//			createOrderServiceHelper.get().EnterdataForEditInterfaceforConfigurelinkunderIntermediateEquipment("LANLINK",  map.get("Interfacename_forEditInterface"), map.get("editInterfacepage_circuitId"), map.get("editInterfacepage_BearerType"),
//					map.get("editInterfacepage_BearerSpeed"), map.get("editInterfacepage_bandwidth"), map.get("editInterfacepage_Vlanid"), map.get("editInterfacepage_vlantype"));
//		    
//		
//			createOrderServiceHelper.get().returnbacktoviewsiteorderpage("LANLINK");
//			
//		 System.out.println("-----------Show Interface link for Equipment----------14");
//			createOrderServiceHelper.get().SelectShowInterfacelink_IntermediateequipmentAndVerifyEditInterfacePage("LANLINK", map.get("Interfacename_forEditInterface"));
//			createOrderServiceHelper.get().EnterdataForEditInterfaceforShowInterfacelinkunderIntermediateEquipment("LANLINK",  map.get("Interfacename_forEditInterface"), map.get("editInterfacepage_circuitId"), map.get("editInterfacepage_BearerType"),
//					map.get("editInterfacepage_BearerSpeed"), map.get("editInterfacepage_bandwidth"), map.get("editInterfacepage_Vlanid"), map.get("editInterfacepage_vlantype"));
//		
//
//	     System.out.println("-------------Delete device from service for intermediate equipment---------");
//			createOrderServiceHelper.get().deleteDeviceFromServiceForIntermediateequipment("LANLINK", map.get("deleteDeviceforIntermediateequipment"));
//
//			
//			
//		}
//
//		else if (servicesubtype.equalsIgnoreCase("LANLink outbandmanagement")) {
//			
//			createOrderServiceHelper.get().VerifythefieldsforProviderEquipment("LANLINK");
//			createOrderServiceHelper.get().providerEquipment("LANLINK", map.get("IMS pop locations_MAS_PE"),
//						map.get("Select/Create device_PE"), map.get("Name_Mas_PE"), map.get("VendorModel_PE"),
//						map.get("Address_PE"), map.get("Snmpro_PE"), map.get("country_PE"), map.get("city_PE"),
//						map.get("site_PE"), map.get("premise_PE"));
//			createOrderServiceHelper.get().verifyPEdeviceEnteredvalue("LANLINK", map.get("Name_Mas_PE"),
//						map.get("VendorModel_PE"), map.get("Address_PE"), map.get("Snmpro_PE"), map.get("country_PE"),
//						map.get("city_PE"), map.get("site_PE"), map.get("premise_PE"));
//			createOrderServiceHelper.get().EditProviderEquipment("LANLINK", map.get("IMS pop locations_MAS_PE"),
//						map.get("Select/Create device_PE"), map.get("Name_Mas_PE"), map.get("VendorModel_PE"),
//						map.get("Address_PE"), map.get("Snmpro_PE"), map.get("country_PE"), map.get("city_PE"),
//						map.get("site_PE"), map.get("premise_PE"));
//				
//							
//			createOrderServiceHelper.get().returnbacktoviewsiteorderpage("LANLINK");
//				
//				System.out.println("--------SELECTINTERFACE link for Provider Equipment--------");
//			createOrderServiceHelper.get().selectInterfacelinkforProviderEqipment("LANLINK");
//			createOrderServiceHelper.get().AddInterfaceToserviceforProviderEquipment("LANLINK", map.get("Interfacetoselect_Interfacenumber"));
//			createOrderServiceHelper.get().verifyInterfaceaddedToServiceForProviderEquipment("LANLINK", map.get("Interfacetoselect_Interfacenumber"));
//			createOrderServiceHelper.get().ProviderEquipmentInterfaceInService("LANLINK", map.get("Interfaceinservice_Interfacenumber"));
//			createOrderServiceHelper.get().verifyInterfaceremovedFromServiceforProviderEquipment("LANLINK", map.get("Interfaceinservice_Interfacenumber"));
//
//			createOrderServiceHelper.get().returnbacktoviewsiteorderpage("LANLINK");
//					
//				System.out.println("-----------Show Interface link for Provider Equipment----------14");
//						createOrderServiceHelper.get().SelectShowInterfacelinkAndVerifyEditInterfacePageforProviderEquipment("LANLINK", map.get("Interfacename_forEditInterface"));
//						
//						createOrderServiceHelper.get().EnterdataForEditInterfaceforShowInterfacelinkunderProviderEquipment("LANLINK",  map.get("Interfacename_forEditInterface"), map.get("editInterfacepage_circuitId"), map.get("editInterfacepage_BearerType"),
//								map.get("editInterfacepage_BearerSpeed"), map.get("editInterfacepage_bandwidth"), map.get("editInterfacepage_Vlanid"), map.get("editInterfacepage_vlantype"));
//					
//		System.out.println("------------CONFIGURE link for Provider Equipment--------------15");
//			createOrderServiceHelper.get().selectconfigurelinkAndverifyForProviderEquipment("LANLINK", map.get("Interfacename_forEditInterface"));
//				   
//			createOrderServiceHelper.get().returnbacktoviewsiteorderpage("LANLINK");
//				    
//		System.out.println("----------------Delete device from service------------------ ");
//			createOrderServiceHelper.get().deleteDeviceFromServiceForProviderequipment("LANLINK", map.get("deleteDeviceforequipment"));
//					
//					
//		System.out.println("-----------PE to CPE link-----------");		
//		    createOrderServiceHelper.get().verifyAddnewlinkunderPE2CPEtable("LANLINK");
//		    createOrderServiceHelper.get().enterdataforAddNewlinkunderPEtoCPEtable("LANLINK", map.get("Addnewlink_Circuitid"), map.get("Addnewlink_sourcedevice"), 
//		    		                       map.get("Addnewlink_sourceInterface"), map.get("Addnewlink_targetdevice"), map.get("enterdataforAddNewlinkunderPEtoCPEtable"), map.get("Addnewlink_interfacename"));
//		    
//
//		    
//		    
//				
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
//				
//				
//			createOrderServiceHelper.get().CustomerPremiseEquipment("serviceSelected",
//						map.get("IMS pop locations_MAS_PE"), map.get("Select/Create device_PE"), map.get("Name_Mas_PE"),
//						map.get("VendorModel_PE"), map.get("Address_PE"), map.get("Snmpro_PE"), map.get("country_PE"),
//						map.get("city_PE"), map.get("site_PE"), map.get("premise_PE"));
//			
//			
//			createOrderServiceHelper.get().selectInterfacelinkforCustomerpremiseequipment("LANLINK");
//			createOrderServiceHelper.get().AddInterfaceToserviceforProviderEquipment("LANLINK", map.get("Interfacetoselect_Interfacenumber"));
//			createOrderServiceHelper.get().verifyInterfaceaddedToServiceForProviderEquipment("LANLINK", map.get("Interfacetoselect_Interfacenumber"));
//			createOrderServiceHelper.get().ProviderEquipmentInterfaceInService("LANLINK", map.get("Interfaceinservice_Interfacenumber"));
//			createOrderServiceHelper.get().verifyInterfaceremovedFromServiceforProviderEquipment("LANLINK", map.get("Interfaceinservice_Interfacenumber"));
//
//
//		System.out.println("-----------Show Interface link for Provider Equipment----------14");
//			createOrderServiceHelper.get().SelectShowInterfacelinkAndVerifyEditInterfacePageforCustomerPremiseEquipment("LANLINK", map.get("Interfacename_forEditInterface"));
//			
//			createOrderServiceHelper.get().EnterdataForEditInterfaceforShowInterfacelinkunderProviderEquipment("LANLINK",  map.get("Interfacename_forEditInterface"), map.get("editInterfacepage_circuitId"), map.get("editInterfacepage_BearerType"),
//					map.get("editInterfacepage_BearerSpeed"), map.get("editInterfacepage_bandwidth"), map.get("editInterfacepage_Vlanid"), map.get("editInterfacepage_vlantype"));
//		
//		System.out.println("------------CONFIGURE link for Provider Equipment--------------15");
//			createOrderServiceHelper.get().selectconfigurelinkAndverifyForProviderEquipment("LANLINK", map.get("Interfacename_forEditInterface"));
//	   
//			createOrderServiceHelper.get().returnbacktoviewsiteorderpage("LANLINK");
//	    
//		System.out.println("----------------Delete device from service------------------ ");
//			createOrderServiceHelper.get().deleteDeviceFromServiceForProviderequipment("LANLINK", map.get("deleteDeviceforequipment"));
//	
//		}
//	
//		
//	
//		
//	}
//	
//	
//	
//	@Test(dataProviderClass = APT_DataReader_sanjeev.class, dataProvider = "DataReader_createService")
//	public void sanjeev(Map<String, String> map) throws InterruptedException, DocumentException, IOException {
//	
//
//		
//		
//	}
}
}		
	
	
	
