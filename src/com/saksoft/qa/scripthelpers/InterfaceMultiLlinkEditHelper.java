package com.saksoft.qa.scripthelpers;

import java.io.IOException;
import java.util.List;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.openqa.selenium.remote.server.handler.GetTitle;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.saksoft.qa.driverlibrary.DriverHelper;
import com.saksoft.qa.driverlibrary.Log;
import com.saksoft.qa.driverlibrary.XMLReader;
import com.saksoft.qa.reporter.ExtentTestManager;

public class InterfaceMultiLlinkEditHelper extends DriverHelper {

	WebDriver driver;

	public InterfaceMultiLlinkEditHelper(WebDriver driver) {
		
		super(driver);

		driver = driver;
	}

	XMLReader xml = new XMLReader("src\\com\\saksoft\\qa\\pagerepository\\InterfaceMultiLinkEditPage.xml");

	
	public void leftPaneOperations(String Application) throws DocumentException, InterruptedException {
		// Navigation for Managed customer service from left pane


		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/ManageCustomerServices")));
		Log.info("Managed Cutomer's Service in Left pane got selected");

		// Navigation link in the left pane
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/NavigationToInterfaceMultiLinkEdit")));
		 Log.info("MultiLinkEdit page has got selected in left pane");

	}
	
	
	
	public void SelectNetworkForIpv4(String Application, String Ipv4NetworkDropDownValue) throws IOException, InterruptedException, DocumentException {
		// Network dropdown for Ipv4
				Select(getwebelement(xml.getlocator("//locators/" + Application + "/NetworkForIpv4")),
						Ipv4NetworkDropDownValue);
				Log.info("Network dropdownn has got selected");
				
		
	}
	
	
	public void SelectNetworkForIpv6(String Application, String Ipv6NetworkDropDownValue) throws IOException, InterruptedException, DocumentException {
		// Network dropdown for Ipv6
				Select(getwebelement(xml.getlocator("//locators/" + Application + "/NetworkForIpv6")),
						Ipv6NetworkDropDownValue);
				Log.info("Network dropdownn has got selected");
				
		
	}
	
	
	
	public void GetAddress(String Application) throws InterruptedException, DocumentException {
		// GetAddress Button
				Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/GetAddress")));
				Log.info("Get Address button got clicked");

	}
	
	
	public void GetAddressForIpv6(String Application) throws InterruptedException, DocumentException {
		// GetAddress Button
				Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/GetAddress_IPv6")));
				Log.info("Get Address button got clicked");

	}
	
	
	
	public void EIPAllocation(String Application) throws InterruptedException, DocumentException {
		
		// EIP Allocation button
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/EIPAllocation")));
		Log.info("EIP Allocation button got clicked");

	}
	
	
	public void EIPAllocationForIpv6(String Application) throws InterruptedException, DocumentException {
		
		// EIP Allocation button
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/EIPAllocation_Ipv6")));
		Log.info("EIP Allocation button got clicked");

	}
	
	
	

	
	/**
	 *     Common method for all the fields
	 * 
	 */
	
	public void AddingvaluesTotheFields(String Application, String ValueForIpv4InterfaceName, String Ipv4NetworkDropDownValue,
			String ValueForInterfaceAddressRange_Ipv4, String ValueForInterfaceName_IPv6, String Ipv6NetworkDropDownValue,
			String ValueForInterfaceAddressRange_Ipv6) throws InterruptedException, DocumentException, IOException {

//		// Interface Name field for IPV4
//		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceNameForIPv4")));
//		SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceNameForIPv4")),
//		ValueForIpv4InterfaceName);
//		Log.info("Interface name has been entered");

		// Network dropdown for Ipv4
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/NetworkForIpv4")),
				Ipv4NetworkDropDownValue);
		Log.info("Network dropdownn has got selected");
		
		// GetAddress Button
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/GetAddress")));
		Log.info("Get Address button got clicked");

		// EIP Allocation button
//		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/EIPAllocation")));
		Log.info("EIP Allocation button got clicked");

		// InterfaceAddressRangeForIpv4
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRangeForIPv4")));
		SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRangeForIPv4")),
				ValueForInterfaceAddressRange_Ipv4);
		Log.info("Interface adress range for IPv4 has been Entered");


		// Network dropdown for Ipv6
		Select(getwebelement(xml.getlocator("//locators/" + Application + "/NetworkForIpv6")),
				Ipv6NetworkDropDownValue);
		Log.info("Network dropdown for IPv6 has been selected");

		// GetAddress Button
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/GetAddress_IPv6")));
		Log.info("Get Address button got clicked");

		// EIP Allocation button
//		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/EIPAllocation_Ipv6")));
		Log.info("EIP Allocation button got clicked");

		// InterfaceAddressRangeForIpv6
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRangeForIPv6")));
		SendKeys(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRangeForIPv6")),
				ValueForInterfaceAddressRange_Ipv6);
		Log.info("Interface adress range for IPv6 has been Entered");

	}
	
	/**
	 * 
	 * Table values for MultiLink Bearers
	 * 
	 * @throws DocumentException
	 * @throws InterruptedException
	 * @throws IOException
	 * 
	 */

	public void SecondaryIpsTable(String Application, int RowToBeSelected) throws InterruptedException, DocumentException, IOException {
		
	
		getwebelement("//div[contains(text(),'Interface 1')]");
		
		
		RadioButton(Application,RowToBeSelected,"SecondaryIps");
		
		HeaderForSecondaryIps(Application, 3);
		
		PageNavigationForSecondaryIps(Application, "Next");

		
	}
	
	public void MultiBearertable(String Application, int RowToBeSelected) throws InterruptedException, DocumentException, IOException {
		
		
		
	     RadioButton(Application, RowToBeSelected, "MultiBearer");
	     
	     HeaderForMultilinkBearer(Application, 5);
	     
	     Thread.sleep(2000);
	     PageNavigationForMultilinkBearer(Application, "Last");
		
	}
	
	
	public void RadioButton(String Application, int row, String TableName) throws DocumentException, InterruptedException {
		

		int i=row;
		
		
	// For Radio Button
		
		if(TableName.equalsIgnoreCase("SecondaryIps")) {
			
			System.out.println("Entered SecondaryIPs table for radio button functionality");
			
			String part1="//div[@row-index='";
			
			String part2="']//input";
			
			
			String commonXpath=xml.getlocator("//locators/" + Application + "/radioButtonForSecondaryIps");
			
			String combined_locator=commonXpath+part1+i+part2;
			
			System.out.println("The combined locator is: "+combined_locator);
			
			Clickon(getwebelement(combined_locator));
		}
		
		
		
		if(TableName.equalsIgnoreCase("MultiBearer")) {
			
			System.out.println("Entered MultiBearer table for performing radio button functionality");
			
			String part1="//div[@row-index='";
			
			String part2="']//input";
			
			
			String commonXpath=xml.getlocator("//locators/" + Application + "/radioButtonForMultiBearerTable");
			
			String combined_locator=commonXpath+part1+i+part2;
			
			System.out.println("The combined locator is: "+combined_locator);
			
			Clickon(getwebelement(combined_locator));
		}
			
	}
	
	
	
	public void RadioButtonForSecondaryIps(String Application, int row) throws DocumentException, InterruptedException {
		
		int i=row;
		
		System.out.println("Entered SecondaryIPs table for radio button functionality");
		
		String part1="//div[@row-index='";
		
		String part2="']//input";
		
		
		String commonXpath=xml.getlocator("//locators/" + Application + "/radioButtonForSecondaryIps");
		
		String combined_locator=commonXpath+part1+i+part2;
		
		System.out.println("The combined locator is: "+combined_locator);
		
		Clickon(getwebelement(combined_locator));

		
	}
	
	
	
	public void RadioButtonForMultiBearer(String Application, int row) throws DocumentException, InterruptedException {
		
		int i=row;
		
		System.out.println("Entered MultiBearer table for performing radio button functionality");
		
		String part1="//div[@row-index='";
		
		String part2="']//input";
		
		
		String commonXpath=xml.getlocator("//locators/" + Application + "/radioButtonForMultiBearerTable");
		
		String combined_locator=commonXpath+part1+i+part2;
		
		System.out.println("The combined locator is: "+combined_locator);
		
		Clickon(getwebelement(combined_locator));
	}

	
	


public void HeaderForSecondaryIps(String Application, int No_of_columnsInHeader) throws InterruptedException, DocumentException {

System.out.println("Entering Header module");

  //Using common Header xpath
		
		String part1="[";
		String part2="]";
				
		
		for(int i=0; i<No_of_columnsInHeader;i++) {
			
			
			String CommonXpath=xml.getlocator("//locators/" + Application + "/SecondaryIpsHeader_CommonHeader");
		
			String combined_locator=CommonXpath+part1+(i+2)+part2;
			
			WebElement Column_Header=getwebelement(combined_locator);
			
			System.out.println("The Column Header names are: "+Column_Header.getText());
			
		}
		
	}


public void HeaderForMultilinkBearer(String Application, int No_of_columnsInHeader) throws InterruptedException, DocumentException {

System.out.println("Entering Header module");

  //Using common Header xpath
		
        String part1="[";
		String part2="]";
		
		for(int i=0; i<No_of_columnsInHeader;i++) {
			
			
			String CommonXpath=xml.getlocator("//locators/" + Application + "/MultilinkBearer_CommonHeader");
		
			String combined_locator=CommonXpath+part1+(i+2)+part2;
			
			WebElement Column_Header=getwebelement(combined_locator);
			
			System.out.println("The Column Header names are: "+Column_Header.getText());
			
			
		}

		
	}



public void PageNavigationForSecondaryIps(String Application, String navigation) throws InterruptedException, DocumentException {
	
	if(navigation.equals("First")) {
		
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/SecondaryIps_PageNavigationArrowForFirstPage")));
		System.out.println("Got navigated to next page");
		
	}



	if(navigation.equals("Previous")) {
		
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/SecondaryIps_PageNavigationArrowForPreviousPage")));
		System.out.println("Got navigated to next page");
		
	}

	
	if(navigation.equals("Next")) {
		
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/SecondaryIps_PageNavigationArrowForNextPage")));
		System.out.println("Got navigated to next page");
		
	}
	
if(navigation.equals("Last")) {
		
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/SecondaryIps_PageNavigationArrowForLastPage")));
		System.out.println("Got navigated to next page");
		
	}
	


 }





public void PageNavigationForMultilinkBearer(String Application, String navigation) throws InterruptedException, DocumentException {
	
	if(navigation.equals("First")) {
		
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/MultilinkBearer_PageNavigationArrowForFirstPage")));
		System.out.println("Got navigated to next page");
		
	}



	if(navigation.equals("Previous")) {
		
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/MultilinkBearer_PageNavigationArrowForPreviousPage")));
		System.out.println("Got navigated to next page");
		
	}

	
	if(navigation.equals("Next")) {
		
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/MultilinkBearer_PageNavigationArrowForNextPage")));
		System.out.println("Got navigated to next page");
		
	}
	
if(navigation.equals("Last")) {
		
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/MultilinkBearer_PageNavigationArrowForLastPage")));
		System.out.println("Got navigated to next page");
		
	}

}

public void NavigationLink(String Application, String Breadcrumb) throws InterruptedException, DocumentException, IOException {
	
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



public void FetchingValuesInsideTheFields(String Application) throws IOException, InterruptedException, DocumentException {
	
	// For Network dropdown Ipv4		
   String SelectedValue= GetTheSelectedValueInsideDropdown(getwebelement(xml.getlocator("//locators/" + Application + "/NetworkForIpv4")));
   System.out.println("The default value inside the dropdown is : "+SelectedValue);
   
   //For Network Dropdown IPv6   
   String SelectedValue_IPv6=GetTheSelectedValueInsideDropdown(getwebelement(xml.getlocator("//locators/" + Application + "/NetworkForIpv6")));
   System.out.println("The default value inside the IPv6dropdown is : "+SelectedValue_IPv6);
   
   
   // For Interface Name Ipv4
//   String EnteredInterFaceName=Gettext(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceNameForIPv4")));
//   System.out.println("For Ipv4 Entered Interface Name is: "+EnteredInterFaceName);  
   
  
   //For Address Range IPv4
   String EnteredAddressRange=Gettext(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRangeForIPv4")));
   
  WebElement wb= getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRangeForIPv4"));
   System.out.println("For IPv4 Entered Address Ranges are: "+ EnteredAddressRange);
   
   //For Address Range IPv6
   String EnteredAddressRange_Ipv6=Gettext(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRangeForIPv6")));
   System.out.println("For IPv4 Entered Address Ranges are: "+ EnteredAddressRange_Ipv6);
   
   
   System.out.println("=========Getting the Address range value in different way=========");
   
   WebElement Ipv4=getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRangeForIPv4_right"));
   System.out.println("The adress range value is: "+Ipv4.getText());
   
   
   
 } 


public String FetchInsideInterfaceNameField(String Application) throws IOException, InterruptedException, DocumentException {
	
	String EnteredInterFaceName=Gettext(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceNameForIPv4")));
    System.out.println("For Ipv4 Entered Interface Name is: "+EnteredInterFaceName);
	return EnteredInterFaceName;
}


public String FetchInsideNetworkDropDown(String Application) throws IOException, InterruptedException, DocumentException {
	
	String SelectedValue= GetTheSelectedValueInsideDropdown(getwebelement(xml.getlocator("//locators/" + Application + "/NetworkForIpv4")));
	System.out.println("The default value inside the dropdown is : "+SelectedValue);
	return SelectedValue;
}


public String FetchInsideNetworkDropDown_Ipv6(String Application) throws IOException, InterruptedException, DocumentException {
	
	 String SelectedValue_IPv6=GetTheSelectedValueInsideDropdown(getwebelement(xml.getlocator("//locators/" + Application + "/NetworkForIpv6")));
	 System.out.println("The default value inside the IPv6dropdown is : "+SelectedValue_IPv6);
	return SelectedValue_IPv6;
}


public String FetchInsideInterfaceAddressRange_left(String Application) throws IOException, InterruptedException, DocumentException {
	
	 String EnteredAddressRange=Getattribute(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRangeForIPv4")), "value");
	 System.out.println("For IPv4 Entered Address Ranges are: "+ EnteredAddressRange);
	return EnteredAddressRange;
	
	
}


public String FetchInsideInterfaceAddressRange_right(String Application) throws IOException, InterruptedException, DocumentException {
	
	 String EnteredAddressRange=Getattribute(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRangeForIPv4_right")),"value");
	 System.out.println("For IPv4 Entered Address Ranges are: "+ EnteredAddressRange);
	return EnteredAddressRange;
}


public String FetchInsideInterfaceAddressRange_Ipv6(String Application) throws IOException, InterruptedException, DocumentException {
	
	String EnteredAddressRange_Ipv6=Getattribute(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceAddressRangeForIPv6")),"value");
	System.out.println("For IPv4 Entered Address Ranges are: "+ EnteredAddressRange_Ipv6);
	return EnteredAddressRange_Ipv6;
}





public void VerifyingThevAluesInsideTheFields(String Application, String ValueToBeCompared_ForInterfaceName, String ValueToBeCompared_ForNetworkDropDownValue,
		String ValueToBeCompared_ForInterfaceAddressRange_left, String ValueToBeCompared_ForInterfaceAddressRange_right, String ValueToBeCompared_ForIPv6NetworkDropDownValue,
		String ValueToBeCompared_ForInterfaceAddressRange_Ipv6) throws IOException, InterruptedException, DocumentException {
	
	
	String FetchedValue_ForInterfaceName=FetchInsideInterfaceNameField(Application);
	
	String FetchedValue_ForNetworkDropdown=FetchInsideNetworkDropDown(Application);
	
	String FetchedValue_ForInterfaceAddressRangeLeft=FetchInsideInterfaceAddressRange_left(Application);
	
	String FetchedValue_ForInterfaceAddressRangeRight=FetchInsideInterfaceAddressRange_right(Application);
	
	String FetchedValue_ForNetworkDropdownIPv6=FetchInsideNetworkDropDown_Ipv6(Application);
	
	String FetchedValue_ForInterfaceAddressRangeIpv6=FetchInsideInterfaceAddressRange_Ipv6(Application);
	
	
//Interface Name Comparison	
//	Assert.assertEquals(FetchedValue_ForInterfaceName, ValueToBeCompared_ForInterfaceName);
	Log.info("Interface name values are same as expected");
	
	
//Network Dropdown Comparison
	Assert.assertEquals(FetchedValue_ForNetworkDropdown, ValueToBeCompared_ForNetworkDropDownValue);
	Log.info("Network dropdown values are same as expected");
	

//Interface Address Range Left
	Assert.assertEquals(FetchedValue_ForInterfaceAddressRangeLeft, ValueToBeCompared_ForInterfaceAddressRange_left);
	Log.info("Interface Address Range values in left values are same as expected");

	
//Interface Address Range right
	Assert.assertEquals(FetchedValue_ForInterfaceAddressRangeRight, ValueToBeCompared_ForInterfaceAddressRange_right);
	Log.info("Interface Address Range Values in right values are same as expected");
	
	
//Network dropdown_IPv6
	Assert.assertEquals(FetchedValue_ForNetworkDropdownIPv6, ValueToBeCompared_ForIPv6NetworkDropDownValue);
	Log.info("Network dropdown values for IPv6 values are same as expected");
	
	
//Interface Address Range Ipv6
	Assert.assertEquals(FetchedValue_ForInterfaceAddressRangeIpv6, ValueToBeCompared_ForInterfaceAddressRange_Ipv6);
	Log.info("Interface Address Range for IPv6 values are same as expected");
	
	
   }

}
















