package com.saksoft.qa.scripthelpers;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;

import com.saksoft.qa.driverlibrary.DriverHelper;
import com.saksoft.qa.driverlibrary.Log;
import com.saksoft.qa.driverlibrary.XMLReader;

public class InterfaceMLPPPeditHelper extends DriverHelper {

	XMLReader xml = new XMLReader("src\\com\\saksoft\\qa\\pagerepository\\InterfaceMLPPPeditPage.xml");

	public InterfaceMLPPPeditHelper(WebDriver dr) {

		super(dr);

	}

	public void leftPaneOperations(String Application) throws DocumentException, InterruptedException {
		// Navigation for Managed customer service from left pane

		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/ManageCustomerServices")));
		Log.info("Managed Cutomer's Service in Left pane got selected");

		// Navigation link in the left pane
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceMLPPPEdit")));
		Log.info("Interface MLPPP Edit page has got selected in left pane");

	}

	public void AddingValuesInsideTheFields(String Application, String ValuesToBeSelected) throws IOException, InterruptedException, DocumentException {

		// Configure Interface on Device
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/ConfigureInterfaceOnDevice_checkbox")));
		Log.info("Check box has been selected");
		

		// Interface Name field
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceName")));
//		SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceName")),
//				ValuesToBeSelected);
		Log.info("Interface name has been entered");
		

		// Network dropdown for Ipv4
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/NetworkDropdown")),
				ValuesToBeSelected);
		Log.info("Network dropdownn has got selected");
		

		// Get Address Button
//		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/GetAddress")));
		Log.info("Get Address button got clicked");
		

		// EIP Allocation Button
//		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/EIPAllocation")));
		Log.info("EIP Allocation button got clicked");
		

		// Interface Address Range left
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRangeLeft")));
		SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRangeLeft")),
				ValuesToBeSelected);
		Log.info("Interface adress range for 1 has been Entered");
		

		// Arrow button Placed between Address Range
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/ArrowbuttonBetweenInterfaceAdressRange")));
		Log.info("Arrow >> button has been clicked");
		

		// Interface Address Range Right
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRangeRight")));
		SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRangeRight")),
				ValuesToBeSelected);
		Log.info("Interface adress range for 1 has been Entered");
		

		// EncapsulationDropdown
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/EncapsulationDropdown")),
				ValuesToBeSelected);
		Log.info("Encapsulation dropdownn has got selected");
		

		// DSLDownstreamSpeedDropdown
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/DSLDownstreamSpeedDropdown")),
				ValuesToBeSelected);
		Log.info("DSL downstream dropdownn has got selected");
		

		// DSLUpstreamSpeedDropdown
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/DSLUpstreamSpeedDropdown")),
				ValuesToBeSelected);
		Log.info("DSL Upstream dropdownn has got selected");
		
		
		// SpeedDropdown
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/SpeedDropdown")),
				ValuesToBeSelected);
		Log.info("DSL Upstream dropdownn has got selected");
		
		
		// DuplexDropdown
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/DuplexDropdown")),
				ValuesToBeSelected);
		Log.info("DSL Upstream dropdownn has got selected");
		
		
		// IncapsulationDropdown
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/IncapsulationDropdown")),
				ValuesToBeSelected);
		Log.info("DSL Upstream dropdownn has got selected");
		
		
		//IV management checkbox
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/IVmanagementCheckBox")));
				
	}
	
	
	
	public void RadioButtonForMultiBearer(String Application, int row) throws DocumentException, InterruptedException {
		
		int i=row;
		
		System.out.println("Entered MultiBearer table for performing radio button functionality");
		
		String part1="//div[@row-index='";
		
		String part2="']//input";
		
		
		String commonXpath=xml.getlocator("//locators/" + Application + "/RadioButton");
		
		String combined_locator=commonXpath+part1+i+part2;
		
		System.out.println("The combined locator is: "+combined_locator);
		
		Clickon(getwebelement(combined_locator));
		
	}

	
	public void VerifyHeaderNames(String Application) throws IOException, InterruptedException, DocumentException {
		
		
		//Verify click to add to multilink Header
		String Text=Gettext(getwebelement(xml.getlocator("//locators/" + Application + "/CheckToAddToMultilinkHeader")));
		System.out.println("---------");
		System.out.println(Text);
		
		//Verify Interface Header
		String InterfaceHeader=Gettext(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceHeader")));
		System.out.println(InterfaceHeader);
		
		//Verfity Circuit Header
		String Link_CircuitHeader=Gettext(getwebelement(xml.getlocator("//locators/" + Application + "/Link_circuitHeader")));
		System.out.println(Link_CircuitHeader);
	}
	
	
	public void rowIndex(String Application) throws InterruptedException, DocumentException {
		
		String RowIndexValue=Getattribute(getwebelement(xml.getlocator("//locators/" + Application + "/valueToBeCaught")), "col-id");
		
		System.out.println("The row index value is: "+ RowIndexValue);
		
	}

}
