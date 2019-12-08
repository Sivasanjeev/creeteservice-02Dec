package com.saksoft.qa.testscripts;


import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;
import com.saksoft.qa.driverlibrary.DriverTestcase;
import com.saksoft.qa.excellibrary.APT_DataReader_SS;

public class APT_MCS_CreateOrderService extends DriverTestcase{
	
   APT_Login login = new APT_Login();

   
	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=1)
	public void chooseCustomer(Map<String, String> map) throws Exception {

		DriverTestcase.logger = DriverTestcase.extent.startTest("chooseCustomer");
		login.APT_Login_1();
		
	
		DriverTestcase.logger.log(LogStatus.INFO,"The service type to be created is: "+map.get("Servicesubtype"));

		 createOrderServiceHelper.get().selectCustomertocreateOrder("CreateOrderService",map.get("ChooseCustomerToBeSelected"),map.get("Customername"));
		
//	
//	System.out.println("--------delete site order -----------10");
//		createOrderServiceHelper.get().clickondeletewithoutselectingrow("LANLINK");		
//		createOrderServiceHelper.get().selectRowForsiteorder("LANLINK", map.get("Siteordernumber"));
//		createOrderServiceHelper.get().deletesiteorderdetails("LANLINK");
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
	
	
	
	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=2)
	public void verifyListofFieldsForOrderandServicetype(Map<String, String> map) throws Exception {
		
		DriverTestcase.logger = DriverTestcase.extent.startTest("verifyListofFieldsForOrderandServicetype");
		
		System.out.println("-------Verify the fields for Service type and select the service sub type------------1");	
		createOrderServiceHelper.get().Verifyfields(("CreateOrderService"),map.get("ServiceType"), map.get("Modularmsp"), map.get("AutocreateService"));
		createOrderServiceHelper.get().selectCustomertocreateOrderfromleftpane("CreateOrderService",map.get("ChooseCustomerToBeSelected"),map.get("Customername"));
		createOrderServiceHelper.get().SelectServiceType("CreateOrderService", map.get("Order/ContractNumber"),map.get("ServiceType"), map.get("Ordertype"), map.get("valuetobeselectedinorderdropdown"));

	}
	
	
	
	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=3)
	public void selectTheServiceType(Map<String, String> map) throws Exception {
		
		DriverTestcase.logger = DriverTestcase.extent.startTest("selectTheServiceType");
		
		
		System.out.println("------After selecting service type------2");
		createOrderServiceHelper.get().selectsubtypeunderServiceTypeSelected("LANLINK",map.get("Servicesubtype"),map.get("Interfacespeed"),map.get("Modularmsp"),
				map.get("AutocreateService"), map.get("A_Endtechnology"), map.get("B_Endtechnology"));
		
	}
	
	
	
	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=4)
	public void verifyFieldsFortheSubServicetypeselelctedunderLANLINK(Map<String, String> map) throws Exception {
		
		DriverTestcase.logger = DriverTestcase.extent.startTest("verifyFieldsFortheSubServicetypeselelctedunderLANLINK");
		
		System.out.println("----Verify the fields for Service sub type selected----------3");
		createOrderServiceHelper.get().VerifyFieldsForServiceSubTypeSelected("LANLINK",map.get("ServiceType"),map.get("Servicesubtype"), map.get("Interfacespeed"),
				map.get("Notification management"), map.get("vpnTopology"), map.get("AggregateTraffic"), map.get("Modularmsp"));	
	
	}
	
	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=5)
	public void enterdatafortheServiceSubtypeSelectedunderLANLINK(Map<String, String> map) throws Exception {
		
		DriverTestcase.logger = DriverTestcase.extent.startTest("enterdatafortheServiceSubtypeSelectedunderLANLINK");
		
		System.out.println("------Enter data for the service sub type selected-------4");	
		createOrderServiceHelper.get().SelectServiceType("CreateOrderService", map.get("Order/ContractNumber"),map.get("ServiceType"), map.get("Ordertype"), map.get("valuetobeselectedinorderdropdown"));
		createOrderServiceHelper.get().selectsubtypeunderServiceTypeSelected("LANLINK",map.get("Servicesubtype"),map.get("Interfacespeed"),map.get("Modularmsp"),
					map.get("AutocreateService"), map.get("A_Endtechnology"), map.get("B_Endtechnology"));
		createOrderServiceHelper.get().dataToBeEnteredOncesubservicesselected("LANLINK",map.get("Servicesubtype"),map.get("Interfacespeed"),map.get("serviceNumber"),map.get("endpointCPE"),map.get("email"), map.get("phone"), map.get("remark"), 
				map.get("PerformMonitor"),map.get("proactiveMonitor"), map.get("deliveryChannel"), map.get("ManagementOrder"), map.get("vpnTopology"), map.get("intermediateTechnology"),
				map.get("CircuitReference"), map.get("CircuitType"), map.get("AggregateTraffic"), map.get("Delivery channel for select tag"),map.get("Modularmsp"),
				map.get("AutocreateService"), map.get("ENNI checkbox"), map.get("manageConnectiondropdown"), map.get("A_Endtechnology"), map.get("B_Endtechnology"), map.get("Notification management"), map.get("performanceReportngForServices"));
	   
	}
	
	
	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=6)
	public void successmessageforServicecreation(Map<String, String> map) throws Exception {
		
		DriverTestcase.logger = DriverTestcase.extent.startTest("successmessageforServicecreation");
		Thread.sleep(2000);
		
		 createOrderServiceHelper.get().verifysuccessmessageforCreateService();		
		
	}
	
//	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=7)
	public void verifydataenteredwhilecreatingServiceSubtypeunderLANLINKinviewservicepage(Map<String, String> map) throws Exception {
		
		DriverTestcase.logger = DriverTestcase.extent.startTest("verifydataenteredwhilecreatingServiceSubtypeunderLANLINKinviewservicepage");
		
		System.out.println("-------- Verify data entered under service sub types---------5");		
			createOrderServiceHelper.get().VerifydatenteredForServiceSubTypeSelected("LANLINK",map.get("servicetypeforverification"),map.get("Servicesubtype"),map.get("Interfacespeed"),map.get("serviceNumber"),map.get("endpointCPE"),map.get("email"), map.get("phone"), map.get("remark"), 
					map.get("PerformMonitor"),map.get("proactiveMonitor"), map.get("deliveryChannel"), map.get("ManagementOrder"), map.get("vpnTopology"), map.get("intermediateTechnology"),
					map.get("CircuitReference"), map.get("CircuitType"), map.get("AggregateTraffic"), map.get("Delivery channel for select tag"),map.get("Modularmsp"),
					map.get("AutocreateService"), map.get("ENNI checkbox"), map.get("manageConnectiondropdown"), map.get("A_Endtechnology"), map.get("B_Endtechnology"),  map.get("performanceReportngForServices"));
		
		
	}
	
	
	
	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=8)
	public void editServiceSubtypesunderLANLINKservice(Map<String, String> map) throws Exception {
		
		DriverTestcase.logger = DriverTestcase.extent.startTest("editServiceSubtypesunderLANLINKservice");
		
		System.out.println("----------- Edit the service type -----------------");	
		createOrderServiceHelper.get().EditTheservicesselected("LANLINK",map.get("Servicesubtype"),map.get("Interfacespeed"),map.get("Edit_serviceNumber"),map.get("Edit_endpointCPE"),map.get("Edit_email"), map.get("Edit_phone"), map.get("Edit_remark"), 
				map.get("Edit_PerformMonitor"),map.get("Edit_proactiveMonitor"), map.get("Edit_deliveryChannel"), map.get("Edit_ManagementOrder"), map.get("Edit_vpnTopology"), map.get("Edit_intermediateTechnology"),
				map.get("Edit_CircuitReference"), map.get("Edit_CircuitType"), map.get("Edit_AggregateTraffic"), map.get("Delivery channel for select tag"),map.get("Modularmsp"),
				map.get("AutocreateService"), map.get("Edit_ENNI checkbox"), map.get("Edit_manageConnectiondropdown"), map.get("Edit_A_Endtechnology"), map.get("Edit_B_Endtechnology"), map.get("Edit_Notification management"),  map.get("performanceReportngForServices"));
	    

	}
	
	
	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=9)
	public void synchronizeServiceSubtypeforLANLINKserviceunderviewservicepage(Map<String, String> map) throws Exception {
		
		DriverTestcase.logger = DriverTestcase.extent.startTest("synchronizeServiceSubtypeforLANLINKserviceunderviewservicepage");
		Thread.sleep(3000);

		System.out.println("Entered sync service");
		createOrderServiceHelper.get().syncservices("LANLINK");
		
	}
	
	

	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=10)
	public void showNewInfovistaReportunderviewservicepage(Map<String, String> map) throws Exception {
		
		DriverTestcase.logger = DriverTestcase.extent.startTest("showNewInfovistaReportunderviewservicepage");
		Thread.sleep(3000);
		
		System.out.println("Entered show info vista");
		createOrderServiceHelper.get().shownewInfovista("LANLINK");
		
	}

	
	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=11)
	public void manageServiceunderviewservicepage(Map<String, String> map) throws Exception {
		
		DriverTestcase.logger = DriverTestcase.extent.startTest("manageServiceunderviewservicepage");
		Thread.sleep(3000);
		
		System.out.println("Enetred manage service");
		createOrderServiceHelper.get().manageService("LANLINK");
		
	}
	
	

	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=12)
	public void ManageSubnetsForlanlinkServiceunderviewservicepage(Map<String, String> map) throws Exception {
		
		DriverTestcase.logger = DriverTestcase.extent.startTest("ManageSubnetsForlanlinkServiceunderviewservicepage");
		Thread.sleep(3000);
		
		System.out.println("Entered manage sub nets");
		createOrderServiceHelper.get().manageSubnets("LANLINK");
		
	}
		
	
	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=13)
	public void verifyAddSiteOrderFieldsfortheServiceSubtypeSelectedunderLANLINK(Map<String, String> map) throws Exception {
		
		DriverTestcase.logger = DriverTestcase.extent.startTest("verifyAddSiteOrderFieldsfortheServiceSubtypeSelectedunderLANLINK");
		Thread.sleep(3000);
		
		System.out.println("------Verify fields for add site order-------- 6");
		
		createOrderServiceHelper.get().Enteraddsiteorder("LANLINK");
		createOrderServiceHelper.get().verifyaddsiteorderfields("LANLINK");
		
	}
	
	

	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=14)
	public void AddSiteOrderfortheServiceSubtypeSelectedunderLANLINK(Map<String, String> map) throws Exception {
		
		System.out.println("---- add site order page-------7");
		
		DriverTestcase.logger = DriverTestcase.extent.startTest("AddSiteOrderfortheServiceSubtypeSelectedunderLANLINK");
		Thread.sleep(3000);
		
		createOrderServiceHelper.get().Enteraddsiteorder("LANLINK");
		
		createOrderServiceHelper.get().addsiteorder( "LANLINK" ,map.get("country"),map.get("city"),map.get("CSR_Name"), 
				 map.get("site"), map.get("performReport"), map.get("Proactivemonitor"),map.get("smartmonitor"),
				   map.get("technology"),map.get("siteallias"), map.get("VLANid"), map.get("DCAenabledsite"), map.get("cloudserviceprovider"), map.get("sitevalue"),
				   map.get("siteorder_Remark"), map.get("xng city name"), map.get("xng ciy code"), map.get("devicenameForaddsiteorder"),
				   map.get("nonterminationpoint"), map.get("protectforaddsiteorder"));
		
		
	}
	
	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=15)
	public void SuccessmessageforCreationofSiteOrder(Map<String, String> map) throws Exception {
		
   System.out.println("---- verify success messgae for adding site order-------7");
		
		DriverTestcase.logger = DriverTestcase.extent.startTest("SuccessmessageforCreationofSiteOrder");
		Thread.sleep(3000);
	
		createOrderServiceHelper.get().verifysuccessmessageforSiteOrder();
	}
	
	

	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=16)
	public void verifytheDataEnteredforAddSiteOrderfortheServiceSubtypeSelectedunderLANLINK(Map<String, String> map) throws Exception {
		
		DriverTestcase.logger = DriverTestcase.extent.startTest("verifytheDataEnteredforAddSiteOrderfortheServiceSubtypeSelectedunderLANLINK");
		Thread.sleep(3000);
		
		
		createOrderServiceHelper.get().VerifyDataEnteredForSiteOrder( "LANLINK" ,map.get("country"),map.get("city"),map.get("CSR_Name"), 
				 map.get("site"), map.get("performReport"), map.get("ProactiveMonitor"),map.get("smartmonitor"),
				 map.get("technology"),map.get("siteallias"), map.get("VLANid"), map.get("DCAenabledsite"), map.get("cloudserviceprovider"), map.get("sitevalue"), map.get("siteorder_Remark"));

		
		System.out.println("----verify details inside the siteorder table under view service page-----------");
//			createOrderServiceHelper.get().VerifySiteOrderdetailsInTable("LANLINK", map.get("Siteordernumber"));
	
	}
	
//	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=17)
	public void verifyFieldsforEditSiteOrderfortheServiceSubtypeSelectedunderLANLINK(Map<String, String> map) throws Exception {
		
		System.out.println("-------verify Edit site order fields--------8");
		DriverTestcase.logger = DriverTestcase.extent.startTest("verifyFieldsforEditSiteOrderfortheServiceSubtypeSelectedunderLANLINK");
		Thread.sleep(3000);
		
		createOrderServiceHelper.get().clickonEditwithoutselectingrow("LANLINK");
		createOrderServiceHelper.get().selectRowForsiteorder("LANLINK", map.get("Siteordernumber"));
		createOrderServiceHelper.get().verifyEditSiteOrder("LANLINK" ,map.get("country"),map.get("city"),map.get("CSR_Name"), 
			 map.get("site"), map.get("performReport"), map.get("Proactivemonitor"),map.get("smartmonitor"),
			 map.get("technology"),map.get("siteallias"), map.get("VLANid"), map.get("DCAenabledsite"), map.get("cloudserviceprovider"), map.get("sitevalue"));
		
		
	}
	
	
//	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=17)
	public void EditSiteOrderfortheServiceSubtypeSelectedunderLANLINK(Map<String, String> map) throws Exception {
		
		DriverTestcase.logger = DriverTestcase.extent.startTest("EditSiteOrderfortheServiceSubtypeSelectedunderLANLINK");
		Thread.sleep(3000);
		
		System.out.println("----- edit site order page-----------9");
		createOrderServiceHelper.get().selectRowForsiteorder("LANLINK", map.get("Siteordernumber"));		  
		createOrderServiceHelper.get().editSiteOrder( "LANLINK" , map.get("performReport"), map.get("ProactiveMonitor"),map.get("smartmonitor"),
		     map.get("siteallias"), map.get("VLANid"), map.get("DCAenabledsite"), map.get("cloudserviceprovider"));
		
	}
	
	
	

	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=18)
	public void ViewSiteOrderfortheServiceSubtypeSelectedunderLANLINK(Map<String, String> map) throws Exception {
		
	System.out.println("--------- view site order page--------11");

	DriverTestcase.logger = DriverTestcase.extent.startTest("ViewSiteOrderfortheServiceSubtypeSelectedunderLANLINK");
	Thread.sleep(3000);
	
		createOrderServiceHelper.get().clickonviewewithoutselectingrow("LANLINK");		
		createOrderServiceHelper.get().selectRowForsiteorder("LANLINK", map.get("Siteordernumber"));
		createOrderServiceHelper.get().viewsiteorderdetails("LANLINK");	
	
	}
	
	
	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=19)
	public void AdddeviceforEquipment(Map<String, String> map) throws Exception {
		
		DriverTestcase.logger = DriverTestcase.extent.startTest("AdddeviceforEquipment");
		Thread.sleep(3000);
		
		DriverTestcase.logger.log(LogStatus.INFO, "Under Equipement, list of actions to be performed are: "
				+ "Verify fields for Add device"
				+ "Add device"
				+ "Verify entered values for device"
				+ "Edit device"
				+ "Select Interface"
				+ "Configure Interface -- Edit Inteface"
				+ "show/Hide Interface -- Edit Interface"
				+ "Select Interface -- Add Interface to service , Remove Interface from Service"
				+ "Delete device ");
		
		System.out.println("------For Equipment ..........Entering add cpe device, Verify CPE device, Edit CPE device----------");
			String servicesubtype=map.get("Servicesubtype");
		
			if(servicesubtype.equals("Direct Fiber") || servicesubtype.equalsIgnoreCase("LANLink International") || servicesubtype.equalsIgnoreCase("LANLink Metro") || servicesubtype.equalsIgnoreCase("OLO - (GCR/EU)"))
			{
				
			createOrderServiceHelper.get().verifyFieldsforAddCPEdevicefortheserviceselected("LANLINK");	
			createOrderServiceHelper.get().AddCPEdevicefortheserviceselected( "LANLINK",  map.get("cpename"), map.get("cpe_vender"),  map.get("cpe_snmpro"),  map.get("cpe_managementAddress"), map.get("cpe_Mepid"),
				 map.get("cpe_poweralarm"), map.get("cpe_Mediaselection"),  map.get("cpe_Macaddress"),  map.get("cpe_serialNumber"),
				 map.get("cpe_hexaSerialnumber"),  map.get("cpe_linkLostForwarding"));
			createOrderServiceHelper.get().verifydetailsenteredforCPEdevice( "LANLINK",  map.get("cpename"), map.get("cpe_vender"),  map.get("cpe_snmpro"),  map.get("cpe_managementAddress"), map.get("cpe_Mepid"),
				 map.get("cpe_poweralarm"), map.get("cpe_Mediaselection"),  map.get("cpe_Macaddress"),  map.get("cpe_serialNumber"),
				 map.get("cpe_hexaSerialnumber"),  map.get("cpe_linkLostForwarding"));
			createOrderServiceHelper.get().eDITCPEdevicedetailsentered( "LANLINK",  map.get("EDIT_cpename"), map.get("EDIT_cpe_vender"),  map.get("EDIT_cpe_snmpro"),  map.get("EDIT_cpe_managementAddress"), map.get("EDIT_cpe_Mepid"),
				 map.get("EDIT_cpe_poweralarm"), map.get("EDIT_cpe_Mediaselection"),  map.get("EDIT_cpe_Macaddress"),  map.get("EDIT_cpe_serialNumber"),
				 map.get("EDIT_cpe_hexaSerialnumber"),  map.get("EDIT_cpe_linkLostForwarding"));
		     
			createOrderServiceHelper.get().returnbacktoviewsiteorderpage("LANLINK");
			
		System.out.println("--------SELECTINTERFACE link for Equipment--------13");
			createOrderServiceHelper.get().selectInterfacelinkforEqipment("LANLINK");
			createOrderServiceHelper.get().SelectInterfacetoaddwithservcie("LANLINK", map.get("Interfacetoselect_Interfacenumber"));
			createOrderServiceHelper.get().verifyInterfaceaddedToService("LANLINK", map.get("Interfacetoselect_Interfacenumber"));
			createOrderServiceHelper.get().SelectInterfacetoremovefromservice("LANLINK", map.get("Interfaceinservice_Interfacenumber"));
			createOrderServiceHelper.get().verifyInterfaceremovedFromService("LANLINK", map.get("Interfaceinservice_Interfacenumber"));
	
			createOrderServiceHelper.get().returnbacktoviewsiteorderpage("LANLINK");
			
		System.out.println("-----------Show Interface link for Equipment----------14");
				createOrderServiceHelper.get().SelectShowInterfacelinkAndVerifyEditInterfacePage("LANLINK", map.get("Interfacename_forEditInterface"));
				createOrderServiceHelper.get().EnterdataForEditInterfaceforShowInterfacelinkunderEquipment("LANLINK",  map.get("Interfacename_forEditInterface"), map.get("editInterfacepage_circuitId"), map.get("editInterfacepage_BearerType"),
						map.get("editInterfacepage_BearerSpeed"), map.get("editInterfacepage_bandwidth"), map.get("editInterfacepage_Vlanid"), map.get("editInterfacepage_vlantype"));
			
		System.out.println("------------CONFIGURE link for Equipment--------------15");
		    createOrderServiceHelper.get().selectconfigurelinkAndverifyEditInterfacefield("LANLINK", map.get("Interfacename_forConfigurelink"));
		    createOrderServiceHelper.get().EnterdataForEditInterfaceforConfigurelinkunderEquipment("LANLINK",  map.get("Interfacename_forConfigurelink"), map.get("editInterfacepage_circuitId"), map.get("editInterfacepage_BearerType"),
					map.get("editInterfacepage_BearerSpeed"), map.get("editInterfacepage_bandwidth"), map.get("editInterfacepage_Vlanid"), map.get("editInterfacepage_vlantype"));
		    
		    createOrderServiceHelper.get().returnbacktoviewsiteorderpage("LANLINK");
				
		System.out.println("----------------Delete device from service------------------ ");
			createOrderServiceHelper.get().deleteDeviceFromServiceForequipment("LANLINK", map.get("deleteDeviceforequipment"));
	
	}
	
	}	
	
	@Test(dataProviderClass = APT_DataReader_SS.class, dataProvider = "DataReader_createService", priority=20)
	public void IntermediateEquipment(Map<String, String> map) throws Exception {
		
		DriverTestcase.logger = DriverTestcase.extent.startTest("IntermediateEquipment");
		Thread.sleep(3000);
		
		DriverTestcase.logger.log(LogStatus.INFO, "Under Intermediate Equipement, list of actions to be performed are: "
				+ "Verify fields for Add device"
				+ "Add device"
				+ "Verify entered values for device"
				+ "Edit device"
				+ "Select Interface"
				+ "Configure Interface -- Edit Inteface"
				+ "show/Hide Interface -- Edit Interface"
				+ "Select Interface -- Add Interface to service , Remove Interface from Service"
				+ "Delete device ");
	
		String servicesubtype=map.get("Servicesubtype");	
		
		if(servicesubtype.equals("Direct Fiber") || servicesubtype.equalsIgnoreCase("LANLink International") || servicesubtype.equalsIgnoreCase("LANLink Metro") || servicesubtype.equalsIgnoreCase("OLO - (GCR/EU)"))
		{
	
	System.out.println("--------For intermediate Equipment-------------");	
	createOrderServiceHelper.get().addCPEdeviceforIntermediateequipment( "LANLINK",  map.get("cpeintEquip_name"), map.get("cpeintequip_vender"),  map.get("cpeintequip_snmpro"), 
			map.get("cpeintequip_managementAddress"), map.get("cpeintequip_Mepid"),
			map.get("cpeintequip_poweralarm"), map.get("cpeintequip_Mediaselection"),  map.get("cpeintequip_Macaddress"),  map.get("cpeintequip_serialNumber"),
			map.get("cpeintequip_hexaSerialnumber"),  map.get("cpeintequip_linkLostForwarding"), map.get("cpeintequip_country"), map.get("cpeintequip_city"),
			map.get("cpeintequip_site"), map.get("cpeintequip_premise"));	
   createOrderServiceHelper.get().verifyCPEdevicedataenteredForIntermediateEquipment( "LANLINK",  map.get("cpeintEquip_name"), map.get("cpeintequip_vender"),  map.get("cpeintequip_snmpro"), 
			map.get("cpeintequip_managementAddress"), map.get("cpeintequip_Mepid"),
			map.get("cpeintequip_poweralarm"), map.get("cpeintequip_Mediaselection"),  map.get("cpeintequip_Macaddress"),  map.get("cpeintequip_serialNumber"),
			map.get("cpeintequip_hexaSerialnumber"),  map.get("cpeintequip_linkLostForwarding"), map.get("cpeintequip_country"), map.get("cpeintequip_city"),
			map.get("cpeintequip_site"), map.get("cpeintequip_premise"));	
   createOrderServiceHelper.get().EDITCPEdevicedforIntermediateEquipment( "LANLINK",  map.get("cpeintEquip_name"), map.get("cpeintequip_vender"),  map.get("cpeintequip_snmpro"), 
			map.get("cpeintequip_managementAddress"), map.get("cpeintequip_Mepid"),
			map.get("cpeintequip_poweralarm"), map.get("cpeintequip_Mediaselection"),  map.get("cpeintequip_Macaddress"),  map.get("cpeintequip_serialNumber"),
			map.get("cpeintequip_hexaSerialnumber"),  map.get("cpeintequip_linkLostForwarding"), map.get("cpeintequip_country"), map.get("cpeintequip_city"),
			map.get("cpeintequip_site"), map.get("cpeintequip_premise"));
	
   createOrderServiceHelper.get().returnbacktoviewsiteorderpage("LANLINK");
   
System.out.println("------"+ "SELECTINTERFACE"+ "link for Intermediate Equipment--------16");
	createOrderServiceHelper.get().selectInterfacelinkforIntermediateEqipment("LANLINK");	
	createOrderServiceHelper.get().SelectInterfacetoaddwithservcie("LANLINK", map.get("Interfacetoselect_Interfacenumber"));  
	createOrderServiceHelper.get().verifyInterfaceaddedToService("LANLINK", map.get("Interfacetoselect_Interfacenumber"));
	createOrderServiceHelper.get().SelectInterfacetoremovefromservice("LANLINK", map.get("Interfaceinservice_Interfacenumber"));
	createOrderServiceHelper.get().verifyInterfaceremovedFromService("LANLINK", map.get("Interfaceinservice_Interfacenumber"));
	
	createOrderServiceHelper.get().returnbacktoviewsiteorderpage("LANLINK");

System.out.println("--------------Select Configure link under Intermediate Equipment------------------");	
	createOrderServiceHelper.get().selectconfigurelinkunderIntermediateEquipmentAndverifyEditInterfacefield("LANLINK", map.get("Interfacename_forConfigurelink"));
	createOrderServiceHelper.get().EnterdataForEditInterfaceforConfigurelinkunderIntermediateEquipment("LANLINK",  map.get("Interfacename_forConfigurelink"), map.get("editInterfacepage_circuitId"), map.get("editInterfacepage_BearerType"),
			map.get("editInterfacepage_BearerSpeed"), map.get("editInterfacepage_bandwidth"), map.get("editInterfacepage_Vlanid"), map.get("editInterfacepage_vlantype"));
    

	createOrderServiceHelper.get().returnbacktoviewsiteorderpage("LANLINK");
	
 System.out.println("-----------Show Interface link for Equipment----------14");
	createOrderServiceHelper.get().SelectShowInterfacelink_IntermediateequipmentAndVerifyEditInterfacePage("LANLINK", map.get("Interfacename_forEditInterface"));
	createOrderServiceHelper.get().EnterdataForEditInterfaceforShowInterfacelinkunderIntermediateEquipment("LANLINK",  map.get("Interfacename_forEditInterface"), map.get("editInterfacepage_circuitId"), map.get("editInterfacepage_BearerType"),
			map.get("editInterfacepage_BearerSpeed"), map.get("editInterfacepage_bandwidth"), map.get("editInterfacepage_Vlanid"), map.get("editInterfacepage_vlantype"));


System.out.println("-------------Delete device from service for intermediate equipment---------");
	createOrderServiceHelper.get().deleteDeviceFromServiceForIntermediateequipment("LANLINK", map.get("deleteDeviceforIntermediateequipment"));
		}
	
	}	
	
	
		
	

}		
	
	
	



