package com.saksoft.qa.testscript;

import java.util.Map;

import org.testng.annotations.Test;

import com.saksoft.qa.driverlibrary.DriverTestcase;
import com.saksoft.qa.excellibrary.APT_DataReader;

public class APT_MCS_SearchOrderService extends DriverTestcase{
	
	
	
//	@Test(description = "TC-01")
//	public void verifySearchOrderServiceFields() throws Exception {
//		APTLogin.get().Login("APT_login_1");
//		Thread.sleep(2000);
//		searchOrderServiceHelper.get().verifySearchOrderServiceFields("SearchOrderService");
//	}
	
	@Test(description = "TC-02",dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader4_PK")
	public void verifyCreateOrderServiceFunctionality(Map<String, String> map) throws Exception {
		APTLogin.get().Login("APT_login_1");
		
		Thread.sleep(2000);
		searchOrderServiceHelper.get().verifySearchOrderServiceFunctionality("SearchOrderService", map.get("OrderContactNumberPresentSID").toString(), map.get("RFI_RFQ_IPVoiceLineNumber").toString(), map.get("Service").toString(),map.get("VPN_SiteOrdNo_TrunkGroupOrdNo").toString(), map.get("DeviceName").toString(), map.get("InterfaceName").toString(),map.get("ServiceTypeToBeSelected").toString(),map.get("ServiceSubTypeToBeSelected").toString(), map.get("CountryToBeSelected").toString() , map.get("CityToBeSelected").toString() , map.get("TrunkName").toString() , map.get("DomainName").toString() , map.get("VPN_PropositionID").toString() , map.get("IP_Address").toString(), map.get("VoiceLineReference").toString(), map.get("Remark").toString());
		
		
		
		
	}
	
//	@Test(description = "TC-03",dataProviderClass = APT_DataReader.class, dataProvider = "FinalDataReader4_PK")
//	public void downloadSearchResult_validation(Map<String, String> map) throws Exception {
//		APTLogin.get().Login("APT_login_1");
//		Thread.sleep(2000);
//		searchOrderServiceHelper.get().verifySearchOrderServiceFunctionality("SearchOrderService", map.get("OrderContactNumberPresentSID").toString(), map.get("RFI_RFQ_IPVoiceLineNumber").toString(), map.get("Service").toString(),map.get("VPN_SiteOrdNo_TrunkGroupOrdNo").toString(), map.get("DeviceName").toString(), map.get("InterfaceName").toString(),map.get("ServiceTypeToBeSelected").toString(),map.get("ServiceSubTypeToBeSelected").toString(), map.get("CountryToBeSelected").toString() , map.get("CityToBeSelected").toString() , map.get("TrunkName").toString() , map.get("DomainName").toString() , map.get("VPN_PropositionID").toString() , map.get("IP_Address").toString(), map.get("VoiceLineReference").toString(), map.get("Remark").toString());
//		
//		Thread.sleep(2000);
//		searchOrderServiceHelper.get().verifydownloadSearchResultFunctionality("SearchOrderService");
//	}
	
	
	
}
