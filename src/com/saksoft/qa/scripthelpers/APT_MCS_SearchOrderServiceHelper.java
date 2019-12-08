package com.saksoft.qa.scripthelpers;

import java.io.IOException;
import java.util.List;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.saksoft.qa.driverlibrary.DriverHelper;
import com.saksoft.qa.driverlibrary.Log;
import com.saksoft.qa.driverlibrary.XMLReader;

public class APT_MCS_SearchOrderServiceHelper extends DriverHelper {

	WebDriver driver;
	
	public APT_MCS_SearchOrderServiceHelper(WebDriver dr) {
		super(dr);
		
		driver=dr;
	}
	
	
	
	SoftAssert sa=new SoftAssert();
	XMLReader xml=new XMLReader("src\\com\\saksoft\\qa\\pagerepository\\APT_MCS_SearchOrderService.xml");
	
	public void navigateToManageCustomerServicePage() throws InterruptedException, DocumentException {
		Clickon(getwebelement(xml.getlocator("//locators/ManageCustomerServiceLink")));					Thread.sleep(2000);
		Log.info("=== MCS page navigated ===");
		Thread.sleep(2000);
		
	}
	
	
	public void navigateToSearchOrderServicePage(String application) throws InterruptedException, DocumentException {
		navigateToManageCustomerServicePage();
		
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/SearchOrderServiceLink")));		Thread.sleep(2000);
		Log.info("=== Search Order/Service navigated ===");	
	}
	
	
	WebElement SearchForOrder_Text, OrderContactNumberPresentSID_Text,RFI_RFQ_IPVoiceLineNumber_Text, Service_Text,VPN_SiteOrdNo_TrunkGroupOrdNo_Text,DeviceName_Text, InterfaceName_Text, ServiceType_Text, ServiceSubType_Text, Country_Text, City_Text, TrunkName_Text, DomainName_Text, VPN_PropositionID_Text, IP_Address_Text, VoiceLineReference_Text, Remark_Text, ListTestCircuits_Text, ListTestCircuits_Checkbox, Search_Button ;
	public void verifySearchOrderServiceFields(String application) throws InterruptedException, DocumentException, IOException {
		navigateToSearchOrderServicePage("SearchOrderService");	
		
		SearchForOrder_Text = getwebelement(xml.getlocator("//locators/" + application + "/SearchForOrder_Text"));
		sa.assertTrue(SearchForOrder_Text.isDisplayed(),"SearchForOrder_Text  is not displayed");
		sa.assertTrue(SearchForOrder_Text.isEnabled(), "SearchForOrder_Text is not disabled");
		Log.info("=== SearchForOrder_Text is displayed ===");	
		
		OrderContactNumberPresentSID_Text = getwebelement(xml.getlocator("//locators/" + application + "/OrderContactNumberPresentSID_Text"));
		sa.assertTrue(OrderContactNumberPresentSID_Text.isDisplayed(),"OrderContactNumberPresentSID_Text  is not displayed");
		sa.assertTrue(OrderContactNumberPresentSID_Text.isEnabled(), "OrderContactNumberPresentSID_Text is not disabled");
		Log.info("=== OrderContactNumberPresentSID_Text is displayed ===");
		
		RFI_RFQ_IPVoiceLineNumber_Text = getwebelement(xml.getlocator("//locators/" + application + "/RFI_RFQ_IPVoiceLineNumber_Text"));
		sa.assertTrue(RFI_RFQ_IPVoiceLineNumber_Text.isDisplayed(),"RFI_RFQ_IPVoiceLineNumber_Text  is not displayed");
		sa.assertTrue(RFI_RFQ_IPVoiceLineNumber_Text.isEnabled(), "RFI_RFQ_IPVoiceLineNumber_Text is not disabled");
		Log.info("=== RFI_RFQ_IPVoiceLineNumber_Text is displayed ===");	
		
		Service_Text = getwebelement(xml.getlocator("//locators/" + application + "/Service_Text"));
		sa.assertTrue(Service_Text.isDisplayed(),"Service_Text  is not displayed");
		sa.assertTrue(Service_Text.isEnabled(), "Service_Text is not disabled");
		Log.info("=== Service_Text is displayed ===");
		
		VPN_SiteOrdNo_TrunkGroupOrdNo_Text = getwebelement(xml.getlocator("//locators/" + application + "/VPN_SiteOrdNo_TrunkGroupOrdNo_Text"));
		sa.assertTrue(VPN_SiteOrdNo_TrunkGroupOrdNo_Text.isDisplayed(),"VPN_SiteOrdNo_TrunkGroupOrdNo_Text  is not displayed");
		sa.assertTrue(VPN_SiteOrdNo_TrunkGroupOrdNo_Text.isEnabled(), "VPN_SiteOrdNo_TrunkGroupOrdNo_Text is not disabled");
		Log.info("=== VPN_SiteOrdNo_TrunkGroupOrdNo_Text is displayed ===");
		
		DeviceName_Text = getwebelement(xml.getlocator("//locators/" + application + "/DeviceName_Text"));
		sa.assertTrue(DeviceName_Text.isDisplayed(),"DeviceName_Text  is not displayed");
		sa.assertTrue(DeviceName_Text.isEnabled(), "DeviceName_Text is not disabled");
		Log.info("=== DeviceName_Text is displayed ===");
		
		InterfaceName_Text = getwebelement(xml.getlocator("//locators/" + application + "/InterfaceName_Text"));
		sa.assertTrue(InterfaceName_Text.isDisplayed(),"InterfaceName_Text  is not displayed");
		sa.assertTrue(InterfaceName_Text.isEnabled(), "InterfaceName_Text is not disabled");
		Log.info("=== InterfaceName_Text is displayed ===");
		
		ServiceType_Text = getwebelement(xml.getlocator("//locators/" + application + "/ServiceType_Text"));
		sa.assertTrue(ServiceType_Text.isDisplayed(),"ServiceType_Text  is not displayed");
		sa.assertTrue(ServiceType_Text.isEnabled(), "ServiceType_Text is not disabled");
		Log.info("=== ServiceType_Text is displayed ===");
		
		ServiceSubType_Text = getwebelement(xml.getlocator("//locators/" + application + "/ServiceSubType_Text"));
		sa.assertTrue(ServiceSubType_Text.isDisplayed(),"ServiceSubType_Text  is not displayed");
		sa.assertTrue(ServiceSubType_Text.isEnabled(), "ServiceSubType_Text is not disabled");
		Log.info("=== ServiceSubType_Text is displayed ===");
		
		Country_Text = getwebelement(xml.getlocator("//locators/" + application + "/Country_Text"));
		sa.assertTrue(Country_Text.isDisplayed(),"Country_Text  is not displayed");
		sa.assertTrue(Country_Text.isEnabled(), "Country_Text is not disabled");
		Log.info("=== Country_Text is displayed ===");
		
		City_Text = getwebelement(xml.getlocator("//locators/" + application + "/City_Text"));
		sa.assertTrue(City_Text.isDisplayed(),"City_Text  is not displayed");
		sa.assertTrue(City_Text.isEnabled(), "City_Text is not disabled");
		Log.info("=== City_Text is displayed ===");
		
		TrunkName_Text = getwebelement(xml.getlocator("//locators/" + application + "/TrunkName_Text"));
		sa.assertTrue(TrunkName_Text.isDisplayed(),"TrunkName_Text  is not displayed");
		sa.assertTrue(TrunkName_Text.isEnabled(), "TrunkName_Text is not disabled");
		Log.info("=== TrunkName_Text is displayed ===");
		
		DomainName_Text = getwebelement(xml.getlocator("//locators/" + application + "/DomainName_Text"));
		sa.assertTrue(DomainName_Text.isDisplayed(),"DomainName_Text  is not displayed");
		sa.assertTrue(DomainName_Text.isEnabled(), "DomainName_Text is not disabled");
		Log.info("=== DomainName_Text is displayed ===");
		
		VPN_PropositionID_Text = getwebelement(xml.getlocator("//locators/" + application + "/VPN_PropositionID_Text"));
		sa.assertTrue(VPN_PropositionID_Text.isDisplayed(),"VPNPropositionID_Text  is not displayed");
		sa.assertTrue(VPN_PropositionID_Text.isEnabled(), "VPNPropositionID_Text is not disabled");
		Log.info("=== VPN_PropositionID_Text is displayed ===");
		
		IP_Address_Text = getwebelement(xml.getlocator("//locators/" + application + "/IP_Address_Text"));
		sa.assertTrue(IP_Address_Text.isDisplayed(),"IP_Address_Text  is not displayed");
		sa.assertTrue(IP_Address_Text.isEnabled(), "IP_Address_Text is not disabled");
		Log.info("=== IP_Address_Text is displayed ===");	
		
		VoiceLineReference_Text = getwebelement(xml.getlocator("//locators/" + application + "/VoiceLineReference_Text"));
		sa.assertTrue(VoiceLineReference_Text.isDisplayed(),"VoiceLineReference_Text  is not displayed");
		sa.assertTrue(VoiceLineReference_Text.isEnabled(), "VoiceLineReference_Text is not disabled");
		Log.info("=== VoiceLineReference_Text is displayed ===");	
		
		Remark_Text = getwebelement(xml.getlocator("//locators/" + application + "/Remark_Text"));
		sa.assertTrue(Remark_Text.isDisplayed(),"Remark_Text  is not displayed");
		sa.assertTrue(Remark_Text.isEnabled(), "Remark_Text is not disabled");
		Log.info("=== Remark_Text is displayed ===");	
		
		ListTestCircuits_Text = getwebelement(xml.getlocator("//locators/" + application + "/ListTestCircuits_Text"));
		sa.assertTrue(ListTestCircuits_Text.isDisplayed(),"ListTestCircuits_Text  is not displayed");
		sa.assertTrue(ListTestCircuits_Text.isEnabled(), "ListTestCircuits_Text is not disabled");
		Log.info("=== ListTestCircuits_Text is displayed ===");	
		
		ListTestCircuits_Checkbox = getwebelement(xml.getlocator("//locators/" + application + "/ListTestCircuits_Checkbox"));
		sa.assertTrue(ListTestCircuits_Checkbox.isDisplayed(),"ListTestCircuits_Checkbox  is not displayed");
		sa.assertTrue(ListTestCircuits_Checkbox.isEnabled(), "ListTestCircuits_Checkbox is not disabled");
		Log.info("=== ListTestCircuits_Checkbox is displayed ===");	
		
		
		Search_Button = getwebelement(xml.getlocator("//locators/" + application + "/Search_Button"));
		sa.assertTrue(Search_Button.isDisplayed(),"Search_Button  is not displayed");
		sa.assertTrue(Search_Button.isEnabled(), "Search_Button is not disabled");
		Log.info("=== Search_Button is displayed ===");	
		
		
		Log.info("=== Search Order/Service all fields Verified ===");
		sa.assertAll();
	}

	public void verifySearchOrderServiceFunctionality(String application, String OrderContactNumberPresentSID, String RFI_RFQ_IPVoiceLineNumber, String Service,String VPN_SiteOrdNo_TrunkGroupOrdNo, String DeviceName, String InterfaceName, String ServiceTypeToBeSelected, String ServiceSubTypeToBeSelected, String CountryToBeSelected, String CityToBeSelected, String TrunkName,String DomainName, String VPN_PropositionID, String IP_Address, String VoiceLineReference, String Remark) throws InterruptedException, DocumentException, IOException {

		navigateToSearchOrderServicePage("SearchOrderService");	
		
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+ "/OrderContactNumberPresentSID_Textfield")), OrderContactNumberPresentSID);				Thread.sleep(1000);
		Log.info("=== OrderContactNumberPresentSID Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+ "/RFI_RFQ_IPVoiceLineNumber_Textfield")), RFI_RFQ_IPVoiceLineNumber);						Thread.sleep(1000);
		Log.info("=== RFI_RFQ_IPVoiceLineNumber Entered ===");  
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/Service_Textfield")), Service);															Thread.sleep(1000);
		Log.info("===Service Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/VPN_SiteOrdNo_TrunkGroupOrdNo_Textfield")), VPN_SiteOrdNo_TrunkGroupOrdNo);				Thread.sleep(1000);
		Log.info("=== VPN_SiteOrdNo_TrunkGroupOrdNo Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/DeviceName_Textfield")), DeviceName);														Thread.sleep(1000);
		Log.info("=== DeviceName Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/InterfaceName_Textfield")), InterfaceName);												Thread.sleep(1000);
		Log.info("===InterfaceName Entered ===");
		
			
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/ServiceType_Select")));								Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/TypeAnything_Textfield")));							Thread.sleep(1000);
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/TypeAnything_Textfield")), ServiceTypeToBeSelected);
		WebElement el1 = driver.findElement(By.xpath("//div[div[contains(text(),'"+ServiceTypeToBeSelected+"')]]/input"));
		el1.click();						
		Log.info("=== ServiceType selected===");
		
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/ServiceSubType_Select")));								Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/TypeAnything_Textfield")));							Thread.sleep(1000);
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/TypeAnything_Textfield")), ServiceSubTypeToBeSelected);
		WebElement e2 = driver.findElement(By.xpath("//div[div[contains(text(),'"+ServiceSubTypeToBeSelected+"')]]/input"));
		e2.click();						
		Log.info("=== ServiceSubType selected===");
		
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/Country_Select")));									Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/TypeAnything_Textfield")));							Thread.sleep(1000);
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/TypeAnything_Textfield")), CountryToBeSelected);
		WebElement el3 = driver.findElement(By.xpath("//div[div[contains(text(),'"+CountryToBeSelected+"')]]/input"));
		el3.click();						
		Log.info("=== Country selected===");
		
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/City_Select")));										Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/TypeAnything_Textfield")));							Thread.sleep(1000);
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/TypeAnything_Textfield")), CityToBeSelected);
		WebElement el4 = driver.findElement(By.xpath("//div[div[contains(text(),'"+CityToBeSelected+"')]]/input"));
		el4.click();						
		Log.info("=== City selected===");
				
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/TrunkName_Textfield")), TrunkName);														Thread.sleep(1000);
		Log.info("=== TrunkName Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/DomainName_Textfield")), DomainName);														Thread.sleep(1000);
		Log.info("=== DomainName Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/VPN_PropositionID_Textfield")), VPN_PropositionID);										Thread.sleep(1000);
		Log.info("=== VPN_PropositionID Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/IP_Address_Textfield")), IP_Address);														Thread.sleep(1000);
		Log.info("=== IP_Address Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/VoiceLineReference_Textfield")), VoiceLineReference);										Thread.sleep(1000);
		Log.info("=== VoiceLineReference Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/"+application+"/Remark_Textfield")), Remark);																Thread.sleep(1000);
		Log.info("=== Remark Entered ===");
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/Search_Button")));																			Thread.sleep(2000);
		Log.info("=== Search button clicked ===");	
		
		Thread.sleep(2000);
		VerifyText("Search For Order");
		VerifyText2("Search For Order", "Search For Order", "actual and expected both are unmatched and Search Order/Service Functionality not validated");		
	}
	
	
	
	public void verifydownloadSearchResultFunctionality(String application) throws IOException {
		VerifyText("Search For Order");
		VerifyText2("Search For Order", "Search For Order", "actual and expected both are unmatched and Search For Order not displayed");
		
		VerifyText("Download Search Result");
		VerifyText2("Download Search Result", "Download Search Result", "actual and expected both are unmatched and Download Search Result not displayed");
		
		
		
		
		
		
		
		
		
	}
	
	
}
