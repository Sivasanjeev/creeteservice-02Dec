package com.saksoft.qa.scripthelpers;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;

import com.saksoft.qa.driverlibrary.DriverHelper;
import com.saksoft.qa.driverlibrary.Log;
import com.saksoft.qa.driverlibrary.XMLReader;

public class VOIP_StatisticsHelper extends DriverHelper {

	public VOIP_StatisticsHelper(WebDriver dr) {
		
		super(dr);
	}
	
	XMLReader xml = new XMLReader("src\\com\\saksoft\\qa\\pagerepository\\VOIPstatisticsPage.xml");
	
	public void leftPaneOperations(String Application) throws DocumentException, InterruptedException {
		
		
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/ManageCustomerServices")));				Thread.sleep(2000);
		Log.info("Managed Cutomer's Service in Left pane got selected");

		// Navigation link in the left pane
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/Statistics")));
		Log.info("Statistics link has got selected in left pane");
		 
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/voipStatistics")));
		Log.info("Statistics link has got selected in left pane");

	}
	
	
	public void VOIPenablingdate(String Application) throws InterruptedException, DocumentException {
		
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/EnablingStartDate")));
		Log.info("Start date has been clicked");
		
		
		NextMonth(Application);
		
	}
	
	
	public void NextMonth(String Application) throws InterruptedException, DocumentException {
		
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/NextMonth")));
		Log.info("Moved to next month");
		
	}
	
	
public void PreviousMonth(String Application) throws InterruptedException, DocumentException {
		
		Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/PreviousMonth")));
		Log.info("Moved to previous month");
		
	}

}
