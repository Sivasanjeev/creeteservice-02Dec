package com.saksoft.qa.scripthelpers;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;

import com.saksoft.qa.driverlibrary.DriverHelper;
import com.saksoft.qa.driverlibrary.XMLReader;

public class APT_ManageCustomerServiceHelper extends DriverHelper{

	public APT_ManageCustomerServiceHelper(WebDriver dr) {
		super(dr);
	}

	XMLReader xml=new XMLReader("src\\com\\saksoft\\qa\\pagerepository\\APT_MCS_CreateCustomer.xml");
	
	public void navigateMCS() throws InterruptedException, DocumentException {
		Clickon(getwebelement(xml.getlocator("//APT_MCS/ManageCustomerServiceLink")));
		System.out.println("=== MCN page navigated ===");
	}
	
	
	public void navigateToCreateCustomer() throws InterruptedException, DocumentException {
		Clickon(getwebelement(xml.getlocator("//APT_MCS/ManageCustomerServiceLink")));
	}
	
	
}
