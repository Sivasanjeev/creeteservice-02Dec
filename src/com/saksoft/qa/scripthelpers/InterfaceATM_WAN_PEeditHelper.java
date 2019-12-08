package com.saksoft.qa.scripthelpers;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;

import com.saksoft.qa.driverlibrary.DriverHelper;
import com.saksoft.qa.driverlibrary.Log;
import com.saksoft.qa.driverlibrary.XMLReader;

public class InterfaceATM_WAN_PEeditHelper extends DriverHelper {
	
	
	XMLReader xml = new XMLReader("src\\com\\saksoft\\qa\\pagerepository\\InterfaceATM_WAN_PEeditPage.xml");

	public InterfaceATM_WAN_PEeditHelper(WebDriver dr) {
	
		super(dr);
		
	}

	public void leftPaneOperations(String Application) throws DocumentException, InterruptedException {
		// Navigation for Managed customer service from left pane


		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/ManageCustomerServices")));
		Log.info("Managed Cutomer's Service in Left pane got selected");

		// Navigation link in the left pane
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceWANedit")));
		 Log.info("Interface WAN PE Edit page has got selected in left pane");

	}
	
	
	
	public void EnterValuesInsideTheFields(String Application, String ValueForInterfaceName,
			String NetworkDropdownValueToBeSelected, String ValueForInterfaceAddressRange1) throws InterruptedException, DocumentException, IOException {
		
		
		//Configure Interface on Device
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/ConfigureInterfaceOnDevice_checkbox")));
		Log.info("Check box has been selected");

		// Interface Name field
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceName")));
//		SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceName")),
//				ValueForInterfaceName);
		Log.info("Interface name has been entered");

		 //Network dropdown for Ipv4
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/NetworkDropdown")),
				NetworkDropdownValueToBeSelected);
		Log.info("Network dropdownn has got selected");
		
		
		//Get Address Button
//		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/GetAddress")));
		Log.info("Get Address button got clicked");
		
		
		//EIP Allocation Button
//		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/EIPAllocation")));
		Log.info("EIP Allocation button got clicked");
		
		// Interface Address Range
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRange")));
		SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRange")),
				ValueForInterfaceAddressRange1);
		Log.info("Interface adress range for 1 has been Entered");
		
		
		//Arrow button Placed between Address Range 
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/ArrowbuttonBetweenInterfaceAdressRange")));
		Log.info("Arrow >> button has been clicked");
		
		
		
		//LinkDropdown
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/LinkDropdown")),
				NetworkDropdownValueToBeSelected);
		Log.info("Link dropdownn has got selected");
		
		//Select Bearer Type
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/BearerTypeDropdown")),
				NetworkDropdownValueToBeSelected);
		Log.info("Network dropdownn has got selected");
		
		
		//EncapsulationDropdown
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/EncapsulationDropdown")),
				NetworkDropdownValueToBeSelected);
		Log.info("Encapsulation dropdownn has got selected");
		
		
		//PPPEncapsulateDropdown
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/PPPEncapsulateDropdown")),
				NetworkDropdownValueToBeSelected);
		Log.info("PPP Encapsulation dropdownn has got selected");
		
		
		//DSLUpstreamDropdown
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/DSLUpstreamDropdown")),
				NetworkDropdownValueToBeSelected);
		Log.info("DSL Upstream dropdownn has got selected");
		
		
		//DSLDownstreamDropdown
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/DSLDownstreamDropdown")),
				NetworkDropdownValueToBeSelected);
		Log.info("DSL downstream dropdownn has got selected");
		
		
		//MBSDropdown
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/MBSDropdown")),
				NetworkDropdownValueToBeSelected);
		Log.info("DSL downstream dropdownn has got selected");
		
		
		//SlotDropdown
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/SlotDropdown")),
				NetworkDropdownValueToBeSelected);
		Log.info("DSL downstream dropdownn has got selected");
		
		
		//PortDropdown
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/PortDropdown")),
				NetworkDropdownValueToBeSelected);
		Log.info("DSL downstream dropdownn has got selected");
		
		
		//VPI
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/VPI")));
//		SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/VPI")),
//				ValueForInterfaceName);
		Log.info("VPI name has been entered");
	

		//VCI
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/VCI")));
//		SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/VCI")),
//				ValueForInterfaceName);
		Log.info("VCI name has been entered");
	
	}
	
	
	
	public void GenerateConfiguration(String Application) throws InterruptedException, DocumentException {
		
		Moveon(getwebelement(xml.getlocator("//locators/" + Application + "/GenerateConfigurationHyperlink")));
		
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/GenerateConfigurationHyperlink")));
		Log.info("Generate configuration link has been selected");
		
	}
	
	
	public void SaveConfigurationToFile(String Application) throws InterruptedException, DocumentException {
		
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/SaveConfigurationtoFileHyperlink")));
		
	}
	

	public void EnterConfiguration(String Application, String ConfigurationToBeEntered) throws InterruptedException, DocumentException, IOException {
		
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/EnterConfiguration")));
		SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/EnterConfiguration")),
				ConfigurationToBeEntered);
		
	}
}
