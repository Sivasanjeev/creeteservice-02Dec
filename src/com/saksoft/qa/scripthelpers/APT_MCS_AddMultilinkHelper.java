package com.saksoft.qa.scripthelpers;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.saksoft.qa.driverlibrary.DriverHelper;
import com.saksoft.qa.driverlibrary.Log;
import com.saksoft.qa.driverlibrary.XMLReader;

public class APT_MCS_AddMultilinkHelper extends DriverHelper {
	
	WebDriver driver;
	public APT_MCS_AddMultilinkHelper(WebDriver dr) {
	super(dr);
	driver=dr;
	}
	
	SoftAssert sa=new SoftAssert();
	XMLReader xml=new XMLReader("src\\com\\saksoft\\qa\\pagerepository\\APT_MCS_AddMultilink.xml");
	
	
	public void navigateToManageCustomerServicePage() throws InterruptedException, DocumentException {
		Clickon(getwebelement(xml.getlocator("//locators/ManageCustomerServiceLink")));
		Log.info("=== MCS page navigated ===");
		Thread.sleep(2000);
	}
	
	
	public void navigateToAddMultilinkPage(String application) throws InterruptedException, DocumentException {
		Clickon(getwebelement(xml.getlocator("//locators/ManageCustomerServiceLink")));
		Log.info("=== MCS page navigated ===");
		Thread.sleep(2000);
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/AddMultilink_Link")));
		Log.info("=== AddMultilink navigated ===");	
	}
	
	WebElement ConfigureInterfaceonDevice_Text,ConfigureInterfaceonDevice_Checkbox,Network_Text,GetAddress_Link,EIP_Allocation_Link,InterfaceAddressRange_Text,ForwardArrow_Button,Address1_Text, Address2_Text, Link_Text, Encapsulation_Text, UnitID_Text, Slot_Text, Pic_Text, Port_Text, STM1Number_Text, Interface_Text, IVmanagement_Text, IVmanagement_Checkbox,AtricaConnected_Text, AtricaConnected_Checkbox, BGP_Text, BGP_Checkbox, MultilinkBearers_Text ;
	public void verifyAddMultilinkPageFields(String application) throws InterruptedException, DocumentException, IOException {
		Clickon(getwebelement(xml.getlocator("//locators/ManageCustomerServiceLink")));
		Thread.sleep(2000);
		Log.info("=== MCS page navigated ===");
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/AddMultilink_Link")));					Thread.sleep(2000);
		Log.info("=== AddMultilink navigated ===");
		
		
		ConfigureInterfaceonDevice_Text = getwebelement(xml.getlocator("//locators/" + application + "/ConfigureInterfaceonDevice_Text"));
		sa.assertTrue(ConfigureInterfaceonDevice_Text.isDisplayed(),"ConfigureInterfaceonDevice_Text  is not displayed");
		sa.assertTrue(ConfigureInterfaceonDevice_Text.isEnabled(), "ConfigureInterfaceonDevice_Text is not disabled");
		Log.info("=== ConfigureInterfaceonDevice_Text is displayed ===");	
		
		ConfigureInterfaceonDevice_Checkbox = getwebelement(xml.getlocator("//locators/" + application + "/ConfigureInterfaceonDevice_Checkbox"));
		sa.assertTrue(ConfigureInterfaceonDevice_Checkbox.isDisplayed(),"ConfigureInterfaceonDevice_Checkbox  is not displayed");
		sa.assertTrue(ConfigureInterfaceonDevice_Checkbox.isEnabled(), "ConfigureInterfaceonDevice_Checkbox is not disabled");
		Log.info("=== ConfigureInterfaceonDevice_Checkbox is displayed ===");
		
		Network_Text = getwebelement(xml.getlocator("//locators/" + application + "/Network_Text"));
		sa.assertTrue(Network_Text.isDisplayed(),"SearchForOrder_Text  is not displayed");
		sa.assertTrue(Network_Text.isEnabled(), "SearchForOrder_Text is not disabled");
		Log.info("=== Network_Text is displayed ===");
		
		GetAddress_Link = getwebelement(xml.getlocator("//locators/" + application + "/GetAddress_Link"));
		sa.assertTrue(GetAddress_Link.isDisplayed(),"GetAddress_Link  is not displayed");
		sa.assertTrue(GetAddress_Link.isEnabled(), "GetAddress_Link is not disabled");
		Log.info("=== GetAddress_Link is displayed ===");
		
		EIP_Allocation_Link = getwebelement(xml.getlocator("//locators/" + application + "/EIP_Allocation_Link"));
		sa.assertTrue(EIP_Allocation_Link.isDisplayed(),"EIP_Allocation_Link  is not displayed");
		sa.assertTrue(EIP_Allocation_Link.isEnabled(), "EIP_Allocation_Link is not disabled");
		Log.info("=== EIP_Allocation_Link is displayed ===");
		
		InterfaceAddressRange_Text = getwebelement(xml.getlocator("//locators/" + application + "/InterfaceAddressRange_Text"));
		sa.assertTrue(InterfaceAddressRange_Text.isDisplayed(),"InterfaceAddressRange_Text  is not displayed");
		sa.assertTrue(InterfaceAddressRange_Text.isEnabled(), "InterfaceAddressRange_Text is not disabled");
		Log.info("=== InterfaceAddressRange_Text is displayed ===");
		
		ForwardArrow_Button = getwebelement(xml.getlocator("//locators/" + application + "/ForwardArrow_Button"));
		sa.assertTrue(ForwardArrow_Button.isDisplayed(),"ForwardArrow_Button  is not displayed");
		sa.assertTrue(ForwardArrow_Button.isEnabled(), "ForwardArrow_Button is not disabled");
		Log.info("=== ForwardArrow_Button is displayed ===");
		
		Address1_Text = getwebelement(xml.getlocator("//locators/" + application + "/Address1_Text"));
		sa.assertTrue(Address1_Text.isDisplayed(),"Address1_Text  is not displayed");
		sa.assertTrue(Address1_Text.isEnabled(), "Address1_Text is not disabled");
		Log.info("=== Address1_Text is displayed ===");
		
		Address2_Text = getwebelement(xml.getlocator("//locators/" + application + "/Address2_Text"));
		sa.assertTrue(Address2_Text.isDisplayed(),"Address2_Text  is not displayed");
		sa.assertTrue(Address2_Text.isEnabled(), "Address2_Text is not disabled");
		Log.info("=== Address2_Text is displayed ===");
		
		Link_Text = getwebelement(xml.getlocator("//locators/" + application + "/Link_Text"));
		sa.assertTrue(Link_Text.isDisplayed(),"Link_Text  is not displayed");
		sa.assertTrue(Link_Text.isEnabled(), "Link_Text is not disabled");
		Log.info("=== Link_Text is displayed ===");
				
		Encapsulation_Text = getwebelement(xml.getlocator("//locators/" + application + "/Encapsulation_Text"));
		sa.assertTrue(Encapsulation_Text.isDisplayed(),"Encapsulation_Text  is not displayed");
		sa.assertTrue(Encapsulation_Text.isEnabled(), "Encapsulation_Text is not disabled");
		Log.info("=== Encapsulation_Text is displayed ===");
		
		UnitID_Text = getwebelement(xml.getlocator("//locators/" + application + "/UnitID_Text"));
		sa.assertTrue(UnitID_Text.isDisplayed(),"UnitID_Text  is not displayed");
		sa.assertTrue(UnitID_Text.isEnabled(), "UnitID_Text is not disabled");
		Log.info("=== UnitID_Text is displayed ===");
		
		Slot_Text = getwebelement(xml.getlocator("//locators/" + application + "/Slot_Text"));
		sa.assertTrue(Slot_Text.isDisplayed(),"Slot_Text  is not displayed");
		sa.assertTrue(Slot_Text.isEnabled(), "Slot_Text is not disabled");
		Log.info("=== Slot_Text is displayed ===");
		
		Pic_Text = getwebelement(xml.getlocator("//locators/" + application + "/Pic_Text"));
		sa.assertTrue(Pic_Text.isDisplayed(),"Pic_Text  is not displayed");
		sa.assertTrue(Pic_Text.isEnabled(), "Pic_Text is not disabled");
		Log.info("=== Pic_Text is displayed ===");
		
		Port_Text = getwebelement(xml.getlocator("//locators/" + application + "/Port_Text"));
		sa.assertTrue(Port_Text.isDisplayed(),"Port_Text  is not displayed");
		sa.assertTrue(Port_Text.isEnabled(), "Port_Text is not disabled");
		Log.info("=== Port_Text is displayed ===");
		
		STM1Number_Text = getwebelement(xml.getlocator("//locators/" + application + "/STM1Number_Text"));
		sa.assertTrue(STM1Number_Text.isDisplayed(),"STM1Number_Text  is not displayed");
		sa.assertTrue(STM1Number_Text.isEnabled(), "STM1Number_Text is not disabled");
		Log.info("=== STM1Number_Text is displayed ===");
		
		Interface_Text = getwebelement(xml.getlocator("//locators/" + application + "/Interface_Text"));
		sa.assertTrue(Interface_Text.isDisplayed(),"Interface_Text  is not displayed");
		sa.assertTrue(Interface_Text.isEnabled(), "Interface_Text is not disabled");
		Log.info("=== Interface_Text is displayed ===");
		
		IVmanagement_Text = getwebelement(xml.getlocator("//locators/" + application + "/IVmanagement_Text"));
		sa.assertTrue(IVmanagement_Text.isDisplayed(),"IVmanagement_Text  is not displayed");
		sa.assertTrue(IVmanagement_Text.isEnabled(), "IVmanagement_Text is not disabled");
		Log.info("=== IVmanagement_Text is displayed ===");
		
		IVmanagement_Checkbox = getwebelement(xml.getlocator("//locators/" + application + "/IVmanagement_Checkbox"));
		sa.assertTrue(IVmanagement_Checkbox.isDisplayed(),"IVmanagement_Checkbox  is not displayed");
		sa.assertTrue(IVmanagement_Checkbox.isEnabled(), "IVmanagement_Checkbox is not disabled");
		Log.info("=== IVmanagement_Checkbox is displayed ===");
		
		AtricaConnected_Text = getwebelement(xml.getlocator("//locators/" + application + "/AtricaConnected_Text"));
		sa.assertTrue(AtricaConnected_Text.isDisplayed(),"AtricaConnected_Text  is not displayed");
		sa.assertTrue(AtricaConnected_Text.isEnabled(), "AtricaConnected_Text is not disabled");
		Log.info("=== AtricaConnected_Text is displayed ===");
		
		AtricaConnected_Checkbox = getwebelement(xml.getlocator("//locators/" + application + "/AtricaConnected_Checkbox"));
		sa.assertTrue(AtricaConnected_Checkbox.isDisplayed(),"AtricaConnected_Checkbox  is not displayed");
		sa.assertTrue(AtricaConnected_Checkbox.isEnabled(), "AtricaConnected_Checkbox is not disabled");
		Log.info("=== AtricaConnected_Checkbox is displayed ===");
		
		BGP_Text = getwebelement(xml.getlocator("//locators/" + application + "/BGP_Text"));
		sa.assertTrue(BGP_Text.isDisplayed(),"BGP_Text  is not displayed");
		sa.assertTrue(BGP_Text.isEnabled(), "BGP_Text is not disabled");
		Log.info("=== BGP_Text is displayed ===");
		
		BGP_Checkbox = getwebelement(xml.getlocator("//locators/" + application + "/BGP_Checkbox"));
		sa.assertTrue(Network_Text.isDisplayed(),"BGP_Checkbox  is not displayed");
		sa.assertTrue(Network_Text.isEnabled(), "BGP_Checkbox is not disabled");
		Log.info("=== BGP_Checkbox is displayed ===");
		
		MultilinkBearers_Text = getwebelement(xml.getlocator("//locators/" + application + "/MultilinkBearers_Text"));
		sa.assertTrue(MultilinkBearers_Text.isDisplayed(),"MultilinkBearers_Text  is not displayed");
		sa.assertTrue(MultilinkBearers_Text.isEnabled(), "MultilinkBearers_Text is not disabled");
		Log.info("=== MultilinkBearers_Text is displayed ===");
		
		
		Log.info("=== Add Multilink all fields Verified ===");
		sa.assertAll();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
