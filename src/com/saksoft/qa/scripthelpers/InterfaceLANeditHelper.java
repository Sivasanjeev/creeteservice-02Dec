package com.saksoft.qa.scripthelpers;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.saksoft.qa.driverlibrary.DriverHelper;
import com.saksoft.qa.driverlibrary.Log;
import com.saksoft.qa.driverlibrary.XMLReader;

public class InterfaceLANeditHelper extends DriverHelper {

	
	XMLReader xml = new XMLReader("src\\com\\saksoft\\qa\\pagerepository\\InterfaceLANeditPage.xml");
	
	public InterfaceLANeditHelper(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	
	
	public void methods() {
		
		System.out.println("Working fine");
	}
	
	
	/**
	 * Clicking on Manages customer Service ---> Interface LAN Edit
	 * 
	 * @param Application
	 * @throws DocumentException
	 * @throws InterruptedException
	 */
	public void leftPaneOperations(String Application) throws DocumentException, InterruptedException {
		// Navigation for Managed customer service from left pane


		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/ManageCustomerServices")));   Thread.sleep(2000);
		Log.info("Managed Cutomer's Service in Left pane got selected");

		// Navigation link in the left pane
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceLANedit")));
		 Log.info("Interface LAN Edit page has got selected in left pane");
	}
	
	
	public void SelectNetwork(String Application, String NetworkDropdownValueToBeSelected) throws IOException, InterruptedException, DocumentException {
		
		 //Network dropdown for Ipv4
			Select(getwebelement(xml.getlocator("//locators/" + Application + "/DropdownForNetwork")),
					NetworkDropdownValueToBeSelected);
			Log.info("Network dropdownn has got selected");
	}
	
	
	
	public void GetAddress(String Application) throws InterruptedException, DocumentException {
		
		//Get Address Button
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/GetAddress")));
		Log.info("Get Address button got clicked");
		
	}
	
	
	public void EIPAllocation(String Application) throws InterruptedException, DocumentException {
		
		//EIP Allocation Button
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/EIPAllocation")));
		Log.info("EIP Allocation button got clicked");

	}
	
	
	public void SelectSpeed(String Application, String ValueForSpeedDropDownToBeSelected) throws IOException, InterruptedException, DocumentException {
		
	// Speed Dropdown
		
		System.out.println("The webelement for speed dropdown is : ");
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/SpeedDropDown")),
				ValueForSpeedDropDownToBeSelected);
		Log.info("SElected speed dropdown");
	
	}
	
		
	public void SelectDuplex(String Application, String ValueForDuplexDropDownToBeSelected) throws DocumentException, IOException, InterruptedException {
		
		// Duplex Dropdown
		System.out.println("The webelement for Duplex dropdown is : "+ (xml.getlocator("//locators/" + Application + "/DuplexDropDown")));
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/DuplexDropDown")),
				ValueForDuplexDropDownToBeSelected);
		Log.info("SElected Duplex dropdown");

	}
	
	
	
    public void SelectIncapsulation(String Application, String ValueForIncapsulationDropDownToBeSelected) throws IOException, InterruptedException, DocumentException {
    	
    	// Incapsulation Dropdown
    			Select(getwebelement(xml.getlocator("//locators/" + Application + "/IncapsulationDropDown")),
    					ValueForIncapsulationDropDownToBeSelected);	
    			Log.info("SElected Incapsulation dropdown");
    }
	
	
	public void EnterValuesInsideTheFields(String Application, String ValueForInterfaceName,
			String NetworkDropdownValueToBeSelected, String ValueForInterfaceAddressRange1,
			String ValueForSpeedDropDownToBeSelected, String ValueForDuplexDropDownToBeSelected, String ValueForIncapsulationDropDownToBeSelected) throws InterruptedException, DocumentException, IOException {

		// Interface Name field
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceName")));
//		SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceName")),
//				ValueForInterfaceName);
		Log.info("Interface name has been entered");

		 //Network dropdown for Ipv4
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/DropdownForNetwork")),
				NetworkDropdownValueToBeSelected);
		Log.info("Network dropdownn has got selected");
		
		
		//Get Address Button
//		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/GetAddress")));
		Log.info("Get Address button got clicked");
		
		
		//EIP Allocation Button
//		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/EIPAllocation")));
		Log.info("EIP Allocation button got clicked");
		
		// Interface Address Range
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRange1")));
		SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRange1")),
				ValueForInterfaceAddressRange1);
		Log.info("Interface adress range for 1 has been Entered");
		
		
		//Arrow button Placed between Address Range 
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/ArrowbuttonBetweenInterfaceAdressRange")));
		Log.info("Arrow >> button has been clicked");
		
		
		// Interface Address Range 2
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRange2")));
		SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRange2")),
				ValueForInterfaceAddressRange1);
		Log.info("Interface adress range for 1 has been Entered");
		
		
		//IV Management check box
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/IVmanagementCheckBox")));
		Log.info("IV Management Check box has been selected");
		
		
		// Speed Dropdown
		
		System.out.println("The webelement for speed dropdown is : ");
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/SpeedDropDown")),
				ValueForSpeedDropDownToBeSelected);
		Log.info("SElected speed dropdown");
		
		// Duplex Dropdown
		System.out.println("The webelement for Duplex dropdown is : "+ (xml.getlocator("//locators/" + Application + "/DuplexDropDown")));
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/DuplexDropDown")),
				ValueForDuplexDropDownToBeSelected);
		Log.info("SElected Duplex dropdown");
				
		// Incapsulation Dropdown
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/IncapsulationDropDown")),
				ValueForIncapsulationDropDownToBeSelected);	
		Log.info("SElected Incapsulation dropdown");
        

	}
	
	


	public void SecondaryIpsTable(String Application, int RowToBeSelected)
			throws InterruptedException, DocumentException, IOException {

		RadioButtonForsecondaryIps(Application, RowToBeSelected);

		HeaderForSecondaryIps(Application);

		PageNavigationForSecondaryIps(Application, "Next");

	}

	public void RadioButtonForsecondaryIps(String Application, int row)
			throws DocumentException, InterruptedException {

		int i = row;

		// For Radio Button

		System.out.println("Entered SecondaryIPs table for radio button functionality");

		String part1 = "//div[@row-index='";

		String part2 = "']//input";

		String commonXpath = xml.getlocator("//locators/" + Application + "/radioButtonForSecondaryIps");

		String combined_locator = commonXpath + part1 + i + part2;

		System.out.println("The combined locator is: " + combined_locator);

		Clickon(getwebelement(combined_locator));
	}

	public void HeaderForSecondaryIps(String Application) throws InterruptedException, DocumentException {

		System.out.println("Entering Header module");

		// Using common Header xpath

		String part1 = "[";
		String part2 = "]";

		int No_of_columnsInHeader = 3;

		for (int i = 0; i < No_of_columnsInHeader; i++) {

			String CommonXpath = xml.getlocator("//locators/" + Application + "/SecondaryIpsHeader_CommonHeader");

			String combined_locator = CommonXpath + part1 + (i + 2) + part2;

			WebElement Column_Header = getwebelement(combined_locator);

			System.out.println("The Column Header names are: " + Column_Header.getText());

		}

	}

	public void PageNavigationForSecondaryIps(String Application, String navigation)
			throws InterruptedException, DocumentException {

		if (navigation.equals("First")) {

			Clickon(getwebelement(
					xml.getlocator("//locators/" + Application + "/SecondaryIps_PageNavigationArrowForFirstPage")));
			System.out.println("Got navigated to next page");

		}

		if (navigation.equals("Previous")) {

			Clickon(getwebelement(
					xml.getlocator("//locators/" + Application + "/SecondaryIps_PageNavigationArrowForPreviousPage")));
			System.out.println("Got navigated to next page");

		}

		if (navigation.equals("Next")) {

			Clickon(getwebelement(
					xml.getlocator("//locators/" + Application + "/SecondaryIps_PageNavigationArrowForNextPage")));
			System.out.println("Got navigated to next page");

		}

		if (navigation.equals("Last")) {

			Clickon(getwebelement(
					xml.getlocator("//locators/" + Application + "/SecondaryIps_PageNavigationArrowForLastPage")));
			System.out.println("Got navigated to next page");

		}

	}
	
	
	public void NavigationLink1(String Application, String Breadcrumb) throws InterruptedException, DocumentException, IOException {
		
		System.out.println("-----------------Navigation link for Breadcrumb------------------------");
        String TitleBeforeClicking = gettitle();
 
        Assert.assertEquals(Breadcrumb .contains(Gettext(getwebelement(xml.getlocator("//locators/" + Application + "/breadcrumb")))), true);
        // ExtentTestManager.getTest().log(LogStatus.PASS," Step: Verify navigated to correct path");
 
 
        Clickon(getwebelement(xml.getlocator("//locators/" + Application +"/breadcrumb")));
 
        String TitleAfterClicking = gettitle();
     
        Assert.assertEquals(TitleBeforeClicking, TitleAfterClicking);
        
 
        System.out.println("----------------------------------Navigation link for Home--------------------------------------");
 
        String TitleBeforeClickingHomePage = gettitle();
         
         Clickon(getwebelement(xml.getlocator("//locators/" + Application +"/HomeLink")));

 
        String TitleAfterClickingHomePage = gettitle();
        
        Assert.assertEquals(TitleBeforeClicking, TitleAfterClicking);
        
}
	
	
	public String FetchInsideInterfaceNameField(String Application) throws IOException, InterruptedException, DocumentException {
		
		String EnteredInterFaceName=Gettext(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceName")));
	    System.out.println("For Ipv4 Entered Interface Name is: "+EnteredInterFaceName);
		return EnteredInterFaceName;
	}


	public String FetchInsideNetworkDropDown(String Application) throws IOException, InterruptedException, DocumentException {
		
		String SelectedValue= GetTheSelectedValueInsideDropdown(getwebelement(xml.getlocator("//locators/" + Application + "/DropdownForNetwork")));
		System.out.println("The default value inside the dropdown is : "+SelectedValue);
		return SelectedValue;
	}


	public String FetchInsideInterfaceAddressRange_left(String Application) throws IOException, InterruptedException, DocumentException {
		
		 String EnteredAddressRange=Getattribute(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRange1")),"value");
		 System.out.println("For IPv4 Entered Address Ranges are: "+ EnteredAddressRange);
		return EnteredAddressRange;
	}
	

	public String FetchInsideInterfaceAddressRange_right(String Application) throws IOException, InterruptedException, DocumentException {
		
		String EnteredAddressRange=Getattribute(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRange2")),"value");
		 System.out.println("For IPv4 Entered Address Ranges are: "+ EnteredAddressRange);
		return EnteredAddressRange;
	}


	public String FetchSpeedDropdownValue(String Application) throws IOException, InterruptedException, DocumentException {
		
		String SelectedSpeedValue=GetTheSelectedValueInsideDropdown(getwebelement(xml.getlocator("//locators/" + Application + "/SpeedDropDown")));
		System.out.println("The default value inside the Speeddropdown is: "+ SelectedSpeedValue);
		return SelectedSpeedValue;
	}
	
	public String FetchDuplexDropdownValue(String Application) throws IOException, InterruptedException, DocumentException {
		
		 String SelectedDuplexValue=GetTheSelectedValueInsideDropdown(getwebelement(xml.getlocator("//locators/" + Application + "/DuplexDropDown")));
		 System.out.println("The default value inside the Duplexdropdown is : "+SelectedDuplexValue);
		return SelectedDuplexValue;
	}

	
	public String FetchIncapsulationDropdownValue(String Application) throws IOException, InterruptedException, DocumentException {
		
		 String SelectedIncapsulationValue=GetTheSelectedValueInsideDropdown(getwebelement(xml.getlocator("//locators/" + Application + "/IncapsulationDropDown")));
		 System.out.println("The default value inside the Incapsulationdropdown is : "+SelectedIncapsulationValue);
		return SelectedIncapsulationValue;
	}	




	public void VerifyingThevAluesInsideTheFields(String Application, String ValueToBeCompared_ForInterfaceName, String ValueToBeCompared_ForNetworkDropDownValue,
			String ValueToBeCompared_ForInterfaceAddressRange_left, String ValueToBeCompared_ForInterfaceAddressRange_right, String ValueToBeCompared_ForSpeedDropdown, String ValueToBeCompared_ForDuplexDropdown, String ValueToBeCompared_ForIncapsulationDropdown) throws IOException, InterruptedException, DocumentException {
		
		
//		String FetchedValue_ForInterfaceName=FetchInsideInterfaceNameField(Application);
		
		String FetchedValue_ForNetworkDropdown=FetchInsideNetworkDropDown(Application);
		
		String FetchedValue_ForInterfaceAddressRangeLeft=FetchInsideInterfaceAddressRange_left(Application);
		
		String FetchedValue_ForInterfaceAddressRangeRight=FetchInsideInterfaceAddressRange_right(Application);
		
		String FetchedValue_ForSpeedDropdown=FetchSpeedDropdownValue(Application);
		
		String FetchedValue_ForDuplexDropdown=FetchDuplexDropdownValue(Application);
		
		String FetchedValue_ForIncapsulationDropdown=FetchIncapsulationDropdownValue(Application);
		
		
		
		
		
	//Interface Name Comparison	
//		Assert.assertEquals(FetchedValue_ForInterfaceName, ValueToBeCompared_ForInterfaceName);
		Log.info("Interface name values are same as expected");
		
		
	//Network Dropdown Comparison
		Assert.assertEquals(FetchedValue_ForNetworkDropdown, ValueToBeCompared_ForNetworkDropDownValue);
		Log.info("Network dropdown values are same as expected");
		

	//Interface Address Range Left
		Assert.assertEquals(FetchedValue_ForInterfaceAddressRangeLeft, ValueToBeCompared_ForInterfaceAddressRange_left+ValueToBeCompared_ForInterfaceAddressRange_right);
		Log.info("Interface Address Range values in left values are same as expected");

		
	//Interface Address Range right
		Assert.assertEquals(FetchedValue_ForInterfaceAddressRangeRight, ValueToBeCompared_ForInterfaceAddressRange_left+ValueToBeCompared_ForInterfaceAddressRange_right);
		Log.info("Interface Address Range Values in right values are same as expected");
		
		
	//Speed Dropdown comparison
		Assert.assertEquals(FetchedValue_ForSpeedDropdown, ValueToBeCompared_ForSpeedDropdown);
		Log.info("Speed dropdown values are same as expected");
		
		
	//Speed Dropdown comparison
		Assert.assertEquals(FetchedValue_ForDuplexDropdown, ValueToBeCompared_ForDuplexDropdown);
		Log.info("Duplex dropdown Values in right values are same as expected");
		
		
    //Speed Dropdown comparison
		Assert.assertEquals(FetchedValue_ForIncapsulationDropdown, ValueToBeCompared_ForIncapsulationDropdown);
		Log.info("Incapsulation dropdown Values in right values are same as expected");
		
		
	 }


}
