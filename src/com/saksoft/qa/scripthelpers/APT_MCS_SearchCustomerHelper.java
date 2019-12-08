package com.saksoft.qa.scripthelpers;

import java.io.IOException;
import java.util.List;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.saksoft.qa.driverlibrary.DriverHelper;
import com.saksoft.qa.driverlibrary.Log;
import com.saksoft.qa.driverlibrary.XMLReader;

public class APT_MCS_SearchCustomerHelper extends DriverHelper {
	WebDriver driver;

	public APT_MCS_SearchCustomerHelper(WebDriver dr) {
		super(dr);
		driver = dr;
	}

	WebElement Name_Textfield, OCN_Textfield, MainDomain_Textfield, Reference_Textfield, Country_Text, Type_Text,
			Search_Button, DownloadToExcelLink;
	SoftAssert sa = new SoftAssert();
	XMLReader xml = new XMLReader("src\\com\\saksoft\\qa\\pagerepository\\APT_MCS_SearchCustomer.xml");

	public void navigateToManageCustomerServicePage() throws InterruptedException, DocumentException {
		Clickon(getwebelement(xml.getlocator("//locators/ManageCustomerServiceLink")));
		Log.info("=== MCS page navigated ===");
		Thread.sleep(2000);
	}

	public void navigateToSearchCustomerPage(String application) throws InterruptedException, DocumentException {
		Clickon(getwebelement(xml.getlocator("//locators/ManageCustomerServiceLink")));
		Thread.sleep(2000);
		Log.info("=== MCS page navigated ===");

		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/SearchCustomerLink")));
		Thread.sleep(2000);
		Log.info("=== Search customer navigated ===");
	}

	public void verifySearchCustomerFields(String application)
			throws InterruptedException, DocumentException, IOException {
		navigateToSearchCustomerPage("SearchCustomer");

		Name_Textfield = getwebelement(xml.getlocator("//locators/" + application + "/Name_Textfield"));
		sa.assertTrue(Name_Textfield.isDisplayed(), "name field is not displayed");
//		sa.assertTrue(Name_Textfield.isEnabled(), "name field is not disabled");

		OCN_Textfield = getwebelement(xml.getlocator("//locators/" + application + "/OCN_Textfield"));
		sa.assertTrue(OCN_Textfield.isDisplayed(), "OCN_Textfield is not displayed");
//		sa.assertTrue(OCN_Textfield.isEnabled(), "OCN_Textfield is not disabled");

		MainDomain_Textfield = getwebelement(xml.getlocator("//locators/" + application + "/MainDomain_Textfield"));
		sa.assertTrue(MainDomain_Textfield.isDisplayed(), "MainDomain_Textfield is not displayed");
//		sa.assertTrue(MainDomain_Textfield.isEnabled(), "MainDomain_Textfield is not disabled");

		Reference_Textfield = getwebelement(xml.getlocator("//locators/" + application + "/Reference_Textfield"));
		sa.assertTrue(Reference_Textfield.isDisplayed(), "Reference_Textfield is not displayed");
//		sa.assertTrue(Reference_Textfield.isEnabled(), "Reference_Textfield is not disabled");

		Country_Text = getwebelement(xml.getlocator("//locators/" + application + "/Country_Text"));
		sa.assertTrue(Country_Text.isDisplayed(), "Country_Text  is not displayed");
//		sa.assertTrue(Country_Text.isEnabled(), "Country_Text is not disabled");

		Type_Text = getwebelement(xml.getlocator("//locators/" + application + "/Type_Text"));
		sa.assertTrue(Type_Text.isDisplayed(), "Type_Text is not displayed");
//		sa.assertTrue(Type_Text.isEnabled(), "Type_Text is not disabled");

		Search_Button = getwebelement(xml.getlocator("//locators/" + application + "/Search_Button"));
		sa.assertTrue(Search_Button.isDisplayed(), "Search_Button is not displayed");
//		sa.assertTrue(Search_Button.isEnabled(), "Search_Button is not disabled");

		DownloadToExcelLink = getwebelement(xml.getlocator("//locators/" + application + "/DownloadToExcelLink"));
		sa.assertTrue(DownloadToExcelLink.isDisplayed(), "DownloadToExcelLink is not displayed");
//		sa.assertTrue(DownloadToExcelLink.isEnabled(), "DownloadToExcelLink is not disabled");

		Log.info("=== Search customer all fields Verified ===");
		sa.assertAll();
	}

	public void verifySearchCustomerFunctionality(String application, String Name, String OCN, String MainDomain,
			String Reference, String CountryToBeSelected, String TypeToBeSelected)
			throws InterruptedException, DocumentException, IOException {
		driver.navigate().refresh();Thread.sleep(2000);		
		//navigateToSearchCustomerPage("SearchCustomer");	  										Thread.sleep(2000);					
		navigateToSearchCustomerPage("SearchCustomer");

		SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Name")), Name);
		Thread.sleep(1000);
		Log.info("===Name Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/OCN")), OCN);
		Thread.sleep(1000);
		Log.info("===OCN Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/MainDomain")), MainDomain);
		Thread.sleep(1000);
		Log.info("===MainDomain Entered ===");
		SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Reference")), Reference);
		Thread.sleep(1000);
		Log.info("===Reference Entered ===");

		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/CountrySelect")));
		Thread.sleep(2000);
		WebElement el1 = driver.findElement(By.xpath("//div[contains(text(),'" + CountryToBeSelected + "')]"));
		el1.click();
		Log.info("=== Country selected===");

		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/TypeSelect")));
		Thread.sleep(2000);
		WebElement el2 = driver.findElement(By.xpath("//div[contains(text(),'" + TypeToBeSelected + "')]"));
		el2.click();
		Log.info("=== Type selected===");

		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Search_Button")));
		Thread.sleep(2000);
		VerifyText("Search Customer");

	}
	
	

//	WebElement resultrow;
//public void selectcustomersearchresultsrow (String application, String OCN) throws InterruptedException, DocumentException, IOException {
//
//
//       String noofpages =driver.findElement(By.xpath("//span[@ref='lbTotal']")).getText();
//
//		int totalpagecount = Integer.valueOf(noofpages);
//
//		System.out.println("Total no. of Pages : " + totalpagecount);
//
//		ab: for (int i = 0; i <= totalpagecount; i++) {
//
//			resultrow = (WebElement) driver.findElements(By.xpath("//div[div[text()='\" + OCN + \"']]//input"));
//
//			System.out.println("printing i value as: " + i);
//			boolean rowpresence = resultrow.get(i).isDisplayed();
//
//			System.out.println("The boolean value is: " + rowpresence);
//
//			if (rowpresence) {
//
//				System.out.println("came inside if loop");
//				resultrow.get(i).click();
//				Thread.sleep(5000);
//				break ab;
//			} else {
//
//				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/nextpagebutton")));
//				Thread.sleep(5000);
//
//			}
//
//		}
//
//		
//
//		String noofsearchresultpages = driver.findElement(By.xpath("//span[@ref='lbTotal']")).getText();
//
//		int totalresultpagecount = Integer.valueOf(noofsearchresultpages);
//
//		System.out.println("Total no. of Pages : " + totalresultpagecount);
//
//		ab: for (int j = 1; j <= totalresultpagecount; j++) {
//
//			List<WebElement> selectrow = driver.findElements(By.xpath("//div[div[contains(@col-id,'numbertotranslate') and contains(text(),'"
//							+ numbertotranslate + "')]]//input"));
//			int listsize = selectrow.size();
//
//			if (listsize == 0) {
//
//				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/nextpagebutton")));
//				Thread.sleep(5000);
//			} else {
//
//				for (int k = 0; k < listsize; k++) {
//
//					System.out.println("printing j value as: " + k);
//					boolean rowpresence = selectrow.get(k).isDisplayed();
//
//					System.out.println("The boolean value is: " + rowpresence);
//
//					if (rowpresence) {
//
//						System.out.println("came inside if loop");
//						selectrow.get(k).click();
//						Thread.sleep(5000);
//						break ab;
//					} else {
//
//						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/nextpagebutton")));
//						Thread.sleep(5000);
//
//					}
//
//				}
//
//			}
//		}
//
//	}

	
	
	
	WebElement searchresultgrid;

	public void verifysearchresults(String application) throws InterruptedException, DocumentException {
		searchresultgrid = getwebelement(xml.getlocator("//locators/" + application + "/searchresultsgrid"));
		sa.assertTrue(searchresultgrid.isDisplayed(), "searchresultgrid  is not displayed");

		List<WebElement> results = getwebelements(xml.getlocator("//locators/" + application + "/searchresultrows"));
		int numofrows = results.size();

		for (int i = 0; i < numofrows; i++) {

			try {
				results.get(i).click();
				Log.info("selected row is : " + i);
				Clickon(getwebelement(
						xml.getlocator("//locators/" + application + "/SearchCustomerResult_Actionmenu")));
				Thread.sleep(3000);
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ViewCustomerLink")));
				Thread.sleep(4000);
			} catch (StaleElementReferenceException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				results = getwebelements(xml.getlocator("//locators/" + application + "/searchresultrows"));
				numofrows = results.size();
				results.get(i).click();
				Log.info("selected row is : " + i);

			}

		}

		sa.assertAll();
	}

}
