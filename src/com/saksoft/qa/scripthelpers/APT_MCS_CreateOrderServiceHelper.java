package com.saksoft.qa.scripthelpers;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;
import com.saksoft.qa.driverlibrary.DriverHelper;
import com.saksoft.qa.driverlibrary.DriverTestcase;
import com.saksoft.qa.driverlibrary.Log;
import com.saksoft.qa.driverlibrary.XMLReader;

import sun.util.logging.resources.logging;

public class APT_MCS_CreateOrderServiceHelper extends DriverHelper{
	
		WebElement ChooseCustomer_Select, Next_Button, CreateOrderService_Text;
		XMLReader xml = new XMLReader("src\\com\\saksoft\\qa\\pagerepository\\APT_MCS_CreateOrderService.xml");

		boolean orderdopdown, serviceTypedropdown, modularmspCheckbox, autocreateservicecheckbox, interfacespeeddropdown,
				servicesubtypesdropdown, availablecircuitsdropdown, nextbutton, A_EndTechnolnogy, B_Endtechnolnogy;
		SoftAssert sa = new SoftAssert();

		public APT_MCS_CreateOrderServiceHelper(WebDriver dr) {
			super(dr);

		}

		
		public void navigateToManageCustomerServicePage() throws InterruptedException, DocumentException {
			Clickon(getwebelement(xml.getlocator("//locators/ManageCustomerServiceLink")));
			Thread.sleep(2000);
			Log.info("=== MCS page navigated ===");
			Thread.sleep(2000);
		}

		public void navigateToCreateOrderServicePage(String application) throws InterruptedException, DocumentException {

			navigateToManageCustomerServicePage();

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/CreateOrderServiceLink")));
			Thread.sleep(2000);
			Log.info("=== Create Order/Service navigated ===");
		}

		public void selectCustomertocreateOrder(String application, String ChooseCustomerToBeSelected, String customerName)
				throws InterruptedException, DocumentException, IOException {

			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/ManageCustomerServiceLink")));
			Thread.sleep(2000);
			Log.info("=== MCS page navigated ===");
			Thread.sleep(2000);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/CreateOrderServiceLink")));
			Thread.sleep(2000);
		
			Log.info("=== Create Order/Service navigated ===");

//			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/entercustomernamefield")), customerName);
//			Thread.sleep(15000);
			
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/entercustomernamefield")), "n");
			Thread.sleep(2000);
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/entercustomernamefield")), "h");
			Thread.sleep(2000);
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/entercustomernamefield")), "1");
			Thread.sleep(2000);
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/entercustomernamefield")), "1");
			Thread.sleep(5000);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/chooseCustomerdropdown")));
			Thread.sleep(3000);
			System.out.println("-----HAve clciked as expected-----");
			WebElement el1 = driver
					.findElement(By.xpath("//span[contains(text(),'" + ChooseCustomerToBeSelected + "')][1]"));
			el1.click();
			Log.info("=== Choose Customer selected===");
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Next_Button")));
			Thread.sleep(1000);

		}
		
		
		public void selectCustomertocreateOrderfromleftpane(String application, String ChooseCustomerToBeSelected, String customerName)
				throws InterruptedException, DocumentException, IOException {

			Thread.sleep(5000);
//			Clickon(getwebelement(xml.getlocator("//locators/ManageCustomerServiceLink")));
//			Thread.sleep(2000);
//			Log.info("=== MCS page navigated ===");
//			Thread.sleep(2000);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/CreateOrderServiceLink")));
			Thread.sleep(2000);
			Log.info("=== Create Order/Service navigated ===");

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/entercustomernamefield")), "n");
			Thread.sleep(2000);
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/entercustomernamefield")), "h");
			Thread.sleep(2000);
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/entercustomernamefield")), "1");
			Thread.sleep(2000);
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/entercustomernamefield")), "1");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/chooseCustomerdropdown")));
			Thread.sleep(000);
			System.out.println("-----HAve clciked as expected-----");
			WebElement el1 = driver
					.findElement(By.xpath("//span[contains(text(),'" + ChooseCustomerToBeSelected + "')][1]"));
			el1.click();
			Log.info("=== Choose Customer selected===");

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Next_Button")));
			Thread.sleep(1000);

		}


		public void verifyCreateOrderServiceFields(String application)
				throws InterruptedException, DocumentException, IOException {
			navigateToCreateOrderServicePage("CreateOrderService");

			CreateOrderService_Text = getwebelement(
					xml.getlocator("//locators/" + application + "/CreateOrderService_Text"));
			sa.assertTrue(CreateOrderService_Text.isDisplayed(), "CreateOrderService_Text  is not displayed");
//			sa.assertTrue(CreateOrderService_Text.isEnabled(), "CreateOrderService_Text is not disabled");
			Log.info("=== Create Order Service Text is displayed ===");

			ChooseCustomer_Select = getwebelement(xml.getlocator("//locators/" + application + "/ChooseCustomer_Select"));
			sa.assertTrue(ChooseCustomer_Select.isDisplayed(), "ChooseCustomer_Select dropdown is not displayed");
//			sa.assertTrue(ChooseCustomer_Select.isEnabled(), "ChooseCustomer_Select dropdown is not disabled");
			Log.info("=== Choose Customer dropdown is displayed ===");

			Next_Button = getwebelement(xml.getlocator("//locators/" + application + "/Next_Button"));
			sa.assertTrue(Next_Button.isDisplayed(), "Next_Button  is not displayed");
//			sa.assertTrue(Next_Button.isEnabled(), "Next_Button is not disabled");
			Log.info("=== Next_Button  is displayed ===");

			Log.info("=== Create Order/Service all fields Verified ===");
			sa.assertAll();
		}

		public void verifyCreateOrderDetailsInformation(String application)
				throws InterruptedException, DocumentException, IOException {

			// verify Name information
			String Name_Text = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Name_Text")));
			String Name_Value = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Name_Value")));
			Log.info(Name_Text + " : TextField value is displayed as : " + Name_Value);
			System.out.println(Name_Text + " : " + Name_Value);

			// verify MainDomain information
			String MainDomain_Text = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/MainDomain_Text")));
			String MainDomain_Value = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/MainDomain_Value")));
			Log.info(MainDomain_Text + " : TextField value is displayed as : " + MainDomain_Value);
			System.out.println(MainDomain_Text + "  " + MainDomain_Value);

			// verify Country information
			String Country_Text = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Country_Text")));
			String Country_Value = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Country_Value")));
			Log.info(Country_Text + " : TextField value is displayed as : " + Country_Value);
			System.out.println(Country_Text + " : " + Country_Value);

			// verify OCN information
			String OCN_Text = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/OCN_Text")));
			String OCN_Value = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/OCN_Value")));
			Log.info(OCN_Text + " : TextField value is displayed as : " + OCN_Value);
			System.out.println(OCN_Text + " : " + OCN_Value);

			// verify Reference information
			String Reference_Text = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Reference_Text")));
			String Reference_Value = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Reference_Value")));
			Log.info(Reference_Text + " : TextField value is displayed as : " + Reference_Value);
			System.out.println(Reference_Text + " : " + Reference_Value);

			// verify Type information
			String Type_Text = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Type_Text")));
			String Type_Value = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Type_Value")));
			Log.info(Type_Text + " : TextField value is displayed as : " + Type_Value);
			System.out.println(Type_Text + " : " + Type_Value);

			// verify Technical Contact Name information
			String TechnicalContactName_Text = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/TechnicalContactName_Text")));
			String TechnicalContactName_Value = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/TechnicalContactName_Value")));
			Log.info(TechnicalContactName_Text + " : TextField value is displayed as : " + TechnicalContactName_Value);
			System.out.println(TechnicalContactName_Text + " : " + TechnicalContactName_Value);

			// verify Name2 information
			String Name2_Text = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Name2_Text")));
			String Name2_Value = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Name2_Value")));
			Log.info(Name2_Text + " : TextField value is displayed as : " + Name2_Value);
			System.out.println(Name2_Text + " : " + Name2_Value);

			// verify Email information
			String Email_Text = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Email_Text")));
			String Email_Value = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Email_Value")));
			Log.info(Email_Text + " : TextField value is displayed as : " + Email_Value);
			System.out.println(Email_Text + " : " + Email_Value);

			// verify Phone information
			String Phone_Text = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Phone_Text")));
			String Phone_Value = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Phone_Value")));
			Log.info(Phone_Text + " : TextField value is displayed as : " + Phone_Value);
			System.out.println(Phone_Text + " : " + Phone_Value);

			// verify Fax information
			String Fax_Text = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Fax_Text")));
			String Fax_Value = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Fax_Value")));
			Log.info(Fax_Text + " : TextField value is displayed as : " + Fax_Value);
			System.out.println(Fax_Text + " : " + Fax_Value);

			Log.info("=== Create Order Detail all fields Verified ===");
			sa.assertAll();
		}

		public void select_ChooseCustomer(String application, String ChooseCustomerToBeSelected)
				throws IOException, InterruptedException, DocumentException {
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ChooseCustomer_Select")));
			Thread.sleep(1000);
			WebElement el1 = driver.findElement(By.xpath("//div[contains(text(),'" + ChooseCustomerToBeSelected + "')]"));
			el1.click();
			Log.info("=== Choose Customer selected===");
		}

		public void select_OrderContractNumber(String application, String OrderContractNumberToBeSelected)
				throws IOException, InterruptedException, DocumentException {
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/OrderContractNumber_Select")));
			Thread.sleep(1000);
			WebElement el1 = driver
					.findElement(By.xpath("(//div[contains(text(),'" + OrderContractNumberToBeSelected + "')])[1]"));
			el1.click();
			Log.info("=== Order Contract Number selected===");
		}

		public void select_ServiceType(String application, String ServiceTypeToBeSelected)
				throws IOException, InterruptedException, DocumentException {
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ServiceType_Select")));
			Thread.sleep(1000);
			WebElement el1 = driver.findElement(By.xpath("(//div[contains(text(),'" + ServiceTypeToBeSelected + "')])[1]"));
			el1.click();
			Log.info("=== Service Type selected===");
		}

		public void select_OrderContractNumberAndServiceType(String application, String OrderContractNumberToBeSelected,
				String ServiceTypeToBeSelected) throws IOException, InterruptedException, DocumentException {

//			int OrderContractNumberToBeSelected=Integer.parseInt(OrderContractNumberToBeSelected1);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/OrderContractNumber_Select_build3")));
			Thread.sleep(1000);
			WebElement el1 = driver
					.findElement(By.xpath("(//span[contains(text(),'" + OrderContractNumberToBeSelected + "')])[1]"));
			el1.click();
			Log.info("=== Order Contract Number selected===");

			Thread.sleep(3000);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ServiceType_Select1_build3")));
			Thread.sleep(1000);
			System.out.println("cluicked on srvice type");

			System.out.println("-----has clicked service type------------");

			WebElement el2 = driver.findElement(By.xpath("//span[contains(text(),'" + ServiceTypeToBeSelected + "')]"));
			el2.click();
			Log.info("=== Service Type selected===");

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Next_Button")));

		}

		public void EnterDataForTheServiceSelected(String application, String ServiceSelected,
				String ServiceIdentificationNumber, String Email, String PhoneContact, String remark,
				String PerformanceReporting, String ProactiveNotification,
				String NotificationManagementValueForTransmissionLink, String Resellercode, String customAdmin,
				String SAnAdmin, String resellerAdmin, String NotifyManageTeam_VOIPAcsess, String selectpackage_VOIPAccess,
				String syslogEventViewcheckbox, String STRM_Ip_tag)
				throws InterruptedException, DocumentException, IOException {

			if (ServiceSelected.equals("Wholesale SIP Trunking")) {
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")));
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
						ServiceIdentificationNumber);

				System.out.println("The values getffjkbfjcbjfsdffh: "
						+ Gettext(getwebelement("//div[contains(text(),'" + ServiceSelected + "')]")));

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Email")));
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")));
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Remark")));
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);

				if (PerformanceReporting.equals("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Performancereporting")));
				}

				else {

					System.out.println("Performance reporting is not selected");
				}

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Next_Button")));

			}

			else if (ServiceSelected.equals("Transmission Link")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")));
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
						ServiceIdentificationNumber);

				Gettext(getwebelement(xml.getlocator("//locators/" + application + "/ServiceType")));

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Email")));
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")));
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Remark")));
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);

				if (ProactiveNotification.equals("yes")) {

					Clickon(getwebelement(
							xml.getlocator("//locators/" + application + "/proActivenotification_TransmissionLink")));
				}

				else {

					System.out.println("Pro active notification is not selected");
				}

				Select(getwebelement(
						xml.getlocator("//locators/" + application + "/NotificationManagementTeam_TransmissionLink")),
						NotificationManagementValueForTransmissionLink);

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Next_Button")));
			}

			else if (ServiceSelected.equals("VOIP Access")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")));
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
						ServiceIdentificationNumber);

				Gettext(getwebelement(xml.getlocator("//locators/" + application + "/serviceType_VOIPaccess")));

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ResellerCode")), Resellercode);

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Email")));
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")));
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Remark")));
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);

				Select(getwebelement(xml.getlocator("//locators/" + application + "/managementOptions_SyslogEventView")),
						selectpackage_VOIPAccess);
				Log.info("VOIP access package has been selected");

				WebElement ManagedServicecheckbox = getwebelement(
						xml.getlocator("//locators/" + application + "/managementOptions_managesservice"));
				if (ManagedServicecheckbox.isEnabled()) {

					Clickon(ManagedServicecheckbox);
					Log.info("ManagedServicecheckbox is selected");

				} else {
					Log.info("It is disable as expected");
				}

				WebElement SysLogEventViewcheckbox = getwebelement(
						xml.getlocator("//locators/" + application + "/managementOptions_SyslogEventView"));
				if (SysLogEventViewcheckbox.isEnabled()) {

					Clickon(getwebelement(
							xml.getlocator("//locators/" + application + "/managementOptions_SyslogEventView")));
					Log.info("syslog event view checkbox is selected");
				} else {
					Log.info("syslog is disabled as expected");
				}

				WebElement ServicestatusViewcheckbox = getwebelement(
						xml.getlocator("//locators/" + application + "/managementOptions_serviceStatusView"));
				if (ServicestatusViewcheckbox.isEnabled()) {
					Clickon(getwebelement(
							xml.getlocator("//locators/" + application + "/managementOptions_serviceStatusView")));
					Log.info("Service status view check box is selected");
				} else {
					Log.info("Service status viwe checkbox is disabled as expected");
				}

				WebElement Routerconfigcheckbox = getwebelement(
						xml.getlocator("//locators/" + application + "/managementOptions_RouterConfigView"));
				if (Routerconfigcheckbox.isEnabled()) {
					Clickon(getwebelement(
							xml.getlocator("//locators/" + application + "/managementOptions_RouterConfigView")));
					Log.info("Router config check box is selected");
				} else {
					Log.info("Router config check box is disabled as expected");
				}

				if (ProactiveNotification.equals("yes")) {

					Clickon(getwebelement(
							xml.getlocator("//locators/" + application + "/managementOptions_ProActiveNotify")));
					Log.info("Pro active notification check box is selected");
				}

				else {

					Log.info("Pro active notification is not selected");
				}

				WebElement Dialuseradmincheckbox = getwebelement(
						xml.getlocator("//locators/" + application + "/managementOptions_PerformnceReport"));
				if (Dialuseradmincheckbox.isEnabled()) {
					Clickon(getwebelement(
							xml.getlocator("//locators/" + application + "/managementOptions_DialsUserAdmin")));
					Log.info("dial user admin check box is selected");
				} else {
					Log.info("dial user check box is disabled as expected");
				}

				if (PerformanceReporting.equals("yes")) {

					Clickon(getwebelement(
							xml.getlocator("//locators/" + application + "/managementOptions_PerformnceReport")));
					Log.info("performance reporting check box is selected");
				}

				else {

					System.out.println("Performance reporting is not selected");
				}

				Select(getwebelement(xml.getlocator("//locators/" + application + "/managementOptions_NotifyManageTeam")),
						NotifyManageTeam_VOIPAcsess);
				Log.info("Notification management dropdown has been selected as expected");

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Next_Button")));

			}

			else if (ServiceSelected.equals("Number Hosting")) {

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
						ServiceIdentificationNumber);

//	    	Gettext(getwebelement(xml.getlocator("//locators/"+application+"/ServiceType")));

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Next_Button")));

			}

			else if (ServiceSelected.equals("NGIN")) {

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
						ServiceIdentificationNumber);

//	    	Gettext(getwebelement(xml.getlocator("//locators/"+application+"/ServiceType")));

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);

				if (customAdmin.equals("yes")) {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/CustomAdmin")));
					Log.info("Custom admin check box is selected");
				} else {
					Log.info("Custom Admin check box is not selected");
				}

				if (SAnAdmin.equals("yes")) {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/SANadmin")));
					Log.info("SAN admin check box is selected");
				} else {
					Log.info("SAN Admin check box is not selected");
				}

				if (SAnAdmin.equals("yes")) {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ResellerAdmin")));
					Log.info("Reseller admin check box is selected");
				} else {
					Log.info("Reseller Admin check box is not selected");
				}

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Next_Button")));

			}

			else if (ServiceSelected.equals("MDF/MVF/DI")) {

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
						ServiceIdentificationNumber);

				Gettext(getwebelement(xml.getlocator("//locators/" + application + "/ServiceType")));

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/STRM_IP_tag")), STRM_Ip_tag);

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);

				if (ProactiveNotification.equals("yes")) {

					Clickon(getwebelement(
							xml.getlocator("//locators/" + application + "/managementOptions_ProActiveNotify")));
					Log.info("Pro active notification check box is selected");
				}

				else {

					Log.info("Pro active notification is not selected");
				}

				if (PerformanceReporting.equals("yes")) {

					Clickon(getwebelement(
							xml.getlocator("//locators/" + application + "/managementOptions_PerformnceReport")));
					Log.info("performance reporting check box is selected");
				}

				else {

					System.out.println("Performance reporting is not selected");
				}

				if (syslogEventViewcheckbox.equalsIgnoreCase("yes")) {

					Clickon(getwebelement(
							xml.getlocator("//locators/" + application + "/managementOptions_SyslogEventView")));

					Log.info("syslog event view checkbox is selected");
				} else {
					Log.info("syslog event view is not selected");
				}

			}

		}

		public void VerifyTheValuesForTheServiceSelected(String application, String ServiceSelected,
				String ServiceIdentificationNumber, String Email, String PhoneContact, String remark,
				String PerformanceReporting, String ProactiveNotification,
				String NotificationManagementValueForTransmissionLink) {

			if (ServiceSelected.equals("Transmission Link")) {

				WebElement ForServiceIdentification = driver
						.findElement(By.xpath("//div[contains(text(),'" + ServiceIdentificationNumber + "')]"));
				sa.assertTrue(ForServiceIdentification.isDisplayed());

//	    		  WebElement ForServicetype = driver.findElement(By.xpath("//div[contains(text(),'"+ServiceIdentificationNumber+"')]"));
//	    		  sa.assertTrue(ForServicetype.isDisplayed());

				WebElement ForEmail = driver.findElement(By.xpath("//div[contains(text(),'" + Email + "')]"));
				sa.assertTrue(ForEmail.isDisplayed());

				WebElement ForRemark = driver.findElement(By.xpath("//div[contains(text(),'" + remark + "')]"));
				sa.assertTrue(ForEmail.isDisplayed());

				WebElement ForPhoneContact = driver.findElement(By.xpath("//div[contains(text(),'" + PhoneContact + "')]"));
				sa.assertTrue(ForPhoneContact.isDisplayed());

				WebElement ForProactiveNotification = driver
						.findElement(By.xpath("//div[contains(text(),'" + ProactiveNotification + "')]"));
				sa.assertTrue(ForProactiveNotification.isDisplayed());

				WebElement ForNotificationManagementValue = driver.findElement(
						By.xpath("//div[contains(text(),'" + NotificationManagementValueForTransmissionLink + "')]"));
				sa.assertTrue(ForProactiveNotification.isDisplayed());

				// div[contains(text(),'Test Service')]
			}

		}

		public void AddPEDevice(String application, String IMSlocation, String selectOrclicktogglebutttontocreateDevice,
				String name, String VendorModel, String ManagementAddress, String Snmpro, String Country, String City,
				String Site, String Premise) throws InterruptedException, DocumentException, IOException {

			System.out.println("----- Going to perform add PE device actions------------");

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddMASdevice")));

			if (selectOrclicktogglebutttontocreateDevice.equalsIgnoreCase("create")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/selectdevice_ToggleButton")));

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Name")), name);

//				Select(getwebelement(xml.getlocator("//locators/"+application+"/VenderModel")), VendorModel);

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/managementaddress")),
						ManagementAddress);

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Snmpro")), Snmpro);

//				Select(getwebelement(xml.getlocator("//locators/"+application+"/country")), Country);
//				
//				Select(getwebelement(xml.getlocator("//locators/"+application+"/city")), City);
//				
//				Select(getwebelement(xml.getlocator("//locators/"+application+"/site")), Site);
//				
//				Select(getwebelement(xml.getlocator("//locators/"+application+"/premise")), Premise);
//				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Next_Button")));

			}

			else {

				Select(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")), IMSlocation);

			}

		}

		public void MASdevice(String application, String IMSlocation, String selectOrclicktogglebutttontocreateDevice,
				String name, String VendorModel, String ManagementAddress, String Snmpro, String Country, String City,
				String Site, String Premise) throws IOException, InterruptedException, DocumentException {

			System.out.println("----- Going to perform add MAS device actions------------");

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddMASdevice")));

			if (selectOrclicktogglebutttontocreateDevice.equalsIgnoreCase("create")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/selectdevice_ToggleButton")));

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Name")), name);

//				Select(getwebelement(xml.getlocator("//locators/"+application+"/VenderModel")), VendorModel);

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/managementaddress")),
						ManagementAddress);

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Snmpro")), Snmpro);

//				Select(getwebelement(xml.getlocator("//locators/"+application+"/country")), Country);
//				
//				Select(getwebelement(xml.getlocator("//locators/"+application+"/city")), City);
//				
//				Select(getwebelement(xml.getlocator("//locators/"+application+"/site")), Site);
//				
//				Select(getwebelement(xml.getlocator("//locators/"+application+"/premise")), Premise);
//				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Next_Button")));

			}

			else {

				Select(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")), IMSlocation);

			}

			Thread.sleep(3000);
		}

		public void SelectServiceType(String application, String OrderNumber, String ServiceTypeToBeSelected,
				String ordertype, String valuetobeselectedinorderdropdown)
				throws InterruptedException, DocumentException, IOException {

			// driver.navigate().refresh();

			Thread.sleep(3000);
			if (ordertype.equalsIgnoreCase("new")) {
				DriverTestcase.logger.log(LogStatus.INFO, "For new order");
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/OrderContractNumbertoggleButton")));

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/OrderName")), OrderNumber);
				Log.info("Order name has been entered");
				DriverTestcase.logger.log(LogStatus.PASS, "Order number has been entered for New order");

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/createButton")));

			} else {
				DriverTestcase.logger.log(LogStatus.INFO, "For existing order");
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ordercontractNumberdropdown")));
				Clickon(getwebelement("//span[text()='" + valuetobeselectedinorderdropdown + "']"));
				DriverTestcase.logger.log(LogStatus.PASS, "Existing order has been selected");

			}

			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/servicetypedropdowntoclick")));
			Thread.sleep(1000);
			System.out.println("clicked on service type");

			System.out.println("-----has clicked service type dropdown------------");

			WebElement el2 = driver.findElement(By.xpath("//span[contains(text(),'" + ServiceTypeToBeSelected + "')]"));
			el2.click();
			Log.info("=== Service Type selected===");

			DriverTestcase.logger.log(LogStatus.INFO, "The service selected is: "+ServiceTypeToBeSelected);

		}

		public void  selectsubtypeunderServiceTypeSelected(String application, String SelectSubService, String Interfacespeed,
				String modularmsp, String autoCreateService, String A_Endtechnologydropdown, String B_Endtechnologydropdown)
				throws InterruptedException, DocumentException, IOException {
			
			
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(3000);


			if (modularmsp.equalsIgnoreCase("no") && autoCreateService.equalsIgnoreCase("no")) {
				
				
				DriverTestcase.logger.log(LogStatus.PASS,"  'Interface speed' value and 'Service subtype' value should be selected as mandatory when'Modular msp' and 'Autocreate service' are not selected as input provided");

				// Select interface speed
		try {
			 if(Interfacespeed.equalsIgnoreCase("null")) {
				 Clickon(getwebelement(xml.getlocator("//locators/" + application + "/InterfaceSpeed")));
				 System.out.println("interface speed dropdown button is clicked");
				 DriverTestcase.logger.log(LogStatus.PASS, " 'Interface speed' dropdown has been selected");
				
			 }else {
				 
				 Clickon(getwebelement(xml.getlocator("//locators/" + application + "/InterfaceSpeed")));
				 System.out.println("interface spedd dropdown button is clicked");
				 DriverTestcase.logger.log(LogStatus.PASS, " 'Interface speed' dropdown has been selected");
				 
			 }
		}catch(Exception e) {
			e.printStackTrace();
			DriverTestcase.logger.log(LogStatus.FAIL, "Failure on selecting 'Interface speed' dropdown under service type");
		}
				
		
		try {
			 if(Interfacespeed.equalsIgnoreCase("null")) {
				 
				 DriverTestcase.logger.log(LogStatus.FAIL, " 'Interface speed' is a mandatory field but No value has been passed as input to 'Interface speed' ");
					
			 }else {
		
				WebElement interfacesped = driver
						.findElement(By.xpath("//span[contains(text(),'" + Interfacespeed + "')]"));
				interfacesped.click();
				Log.info("=== Interface speed has got selected===");
				DriverTestcase.logger.log(LogStatus.PASS,Interfacespeed +" speed has been selected");
				
			 }
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, " 'Interface speed'dropdown under service type is not selected");
			}

		
		
	// select service sub type
		try {
		    if(SelectSubService.equalsIgnoreCase("null")) {
		    	
		    	Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ServiceSubtype")));
				Thread.sleep(1000);
				System.out.println("clicked on service type");
				DriverTestcase.logger.log(LogStatus.PASS, " 'Service subtype' dropdown has been selected");
		    	
		    }else {
		    	
		    	Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ServiceSubtype")));
				Thread.sleep(1000);
				System.out.println("clicked on service type");
				DriverTestcase.logger.log(LogStatus.PASS, " 'Service subtype' dropdown has been selected");
		    }
		}catch(Exception e) {
			e.printStackTrace();
			DriverTestcase.logger.log(LogStatus.FAIL, "Failure on selecting 'service subtype' dropdown field");
		}
		    
				
				try {
				WebElement el2 = driver.findElement(By.xpath("//span[contains(text(),'" + SelectSubService + "')]"));
				el2.click();
				Log.info("=== Service sub Type selected===");
				DriverTestcase.logger.log(LogStatus.PASS, "Service sub type "+ SelectSubService+ " has been selected under LANLINK");
				}catch(Exception e) {
					Log.info("Service sub type is not available");
					DriverTestcase.logger.log(LogStatus.FAIL, "Service sub type is not selected");
				}
				
//				 clickon(getwebelement(xml.getlocator("//locators/"+application+"/AvailableCircuits")));

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Next")));
				Thread.sleep(3000);

				Log.info("Page has to be selected based on service and its subtype selected");

			}

			else if (modularmsp.equalsIgnoreCase("yes") && autoCreateService.equalsIgnoreCase("no")) {
				
				DriverTestcase.logger.log(LogStatus.INFO," 'Service subtype' should be selected as mandatory when 'Modular msp' is selected , 'Autocreateservice' is not selected");
				
              try {
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/modularmspcheckbox")));
				DriverTestcase.logger.log(LogStatus.PASS, "Modular msp checkbox has been selected");
              }catch(Exception e) {
            	  e.printStackTrace();
            	  DriverTestcase.logger.log(LogStatus.FAIL, "Failure at modular msp check box");
            	  
              }

				// select service sub type
              try {
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ServiceSubtype")));
				DriverTestcase.logger.log(LogStatus.PASS," 'Service subtype' field is selected");
              }catch(Exception e) {
            	  e.printStackTrace();
            	  DriverTestcase.logger.log(LogStatus.FAIL, "Service sub type field sis not selected");
              }
				Thread.sleep(1000);
				System.out.println("clicked on srvice type");

				System.out.println("-----has clicked service type------------");
				
			try {
				if(SelectSubService.equals("LANLink International") || SelectSubService.equals("LANLink Metro") || SelectSubService.equals("LANLink National") ||
				         SelectSubService.equals("OLO - (GCR/EU)")){	
				WebElement el2 = driver.findElement(By.xpath("//span[contains(text(),'" + SelectSubService + "')]"));
				el2.click();
				DriverTestcase.logger.log(LogStatus.PASS, "Service sub type "+SelectSubService+ " has been selected");
				Log.info("=== Service sub Type selected===");
						
				}else {
					
//					DriverTestcase.logger.log(LogStatus.FAIL,SelectSubService+ " is not available under Service subtype dropdown when Modular msp is selected");
					DriverTestcase.logger.log(LogStatus.FAIL,SelectSubService+ " is not available when Modular msp is selected."
							+ "                      The list of sub services types under LANLINK when moduler msp is selected are:"
							+ "    1) LANLink International"
							+ "    2) LANLink Metro"
							+ "    3) LANLink National"
							+ "    4) OLO - (GCR/EU)");
					
					driver.close();
				}
				
			}catch(Exception e) {
				Log.info("Service sub type is not available");
				DriverTestcase.logger.log(LogStatus.FAIL, "Service subtype is not selected");
			}


//				 SendKeys(getwebelement(xml.getlocator("//locators/"+Application+"/AvailableCircuits")),
//				 Availablecircuits);

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Next")));
				Thread.sleep(3000);

				Log.info("Page has to be selected based on service and its subtype selected");

			}

			if (modularmsp.equalsIgnoreCase("no") && autoCreateService.equalsIgnoreCase("yes")) {
				
				
				DriverTestcase.logger.log(LogStatus.INFO, " 'Service subtype' should be selected as mandatory when 'AutocreateService' is selected, 'Modular msp' is not selected as per input provided");
				
				System.out.println("Only auto creta check box is selected");
				
				try {
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AutocreateServicecheckbox")));
				DriverTestcase.logger.log(LogStatus.PASS, " 'Autocreateservice' checkbox is selected ");
				}catch(Exception e) {
					e.printStackTrace();
					DriverTestcase.logger.log(LogStatus.FAIL, " 'Auto create service' checkbox is not selected ");
				}

		//A end technology		
			try {	
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/A_Endtechnology")));
				DriverTestcase.logger.log(LogStatus.PASS, " 'A_End technology' dropdown is selected");
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, " 'A_End technology' dropdwon is not avaialble");
			}
			
			
			
			try {
				Clickon(getwebelement("//span[contains(text(),'" + A_Endtechnologydropdown + "')]"));
				DriverTestcase.logger.log(LogStatus.PASS, " 'A_End technology' value has been selected ");
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "FAilure on selecting value inside 'A_end technology' dropdown");
			}

			
		//B end technology	
			
			try {	
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/B_Endtechnology")));
				DriverTestcase.logger.log(LogStatus.PASS, " 'B_End technology' dropdown is selected");
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, " 'B_End technology' dropdwon is not avaialble");
			}
			
			

			try {
				Clickon(getwebelement("//span[contains(text(),'" + B_Endtechnologydropdown + "')]"));
				DriverTestcase.logger.log(LogStatus.PASS, " 'B_End technology' value has been selected ");
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "FAilure on selecting value inside 'A_end technology' dropdown");
			}
			
		//Interface speed	
			try {
				 if(Interfacespeed.equalsIgnoreCase("null")) {
					 Clickon(getwebelement(xml.getlocator("//locators/" + application + "/InterfaceSpeed")));
					 System.out.println("interface speed dropdown button is clicked");
					 DriverTestcase.logger.log(LogStatus.PASS, " 'Interface speed' dropdown has been selected");
					
				 }else {
					 
					 Clickon(getwebelement(xml.getlocator("//locators/" + application + "/InterfaceSpeed")));
					 System.out.println("interface spedd dropdown button is clicked");
					 DriverTestcase.logger.log(LogStatus.PASS, " 'Interface speed' dropdown has been selected");
					 
				 }
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "Failure on selecting 'Interface speed' dropdown under service type");
			}
					
			
			try {
				 if(Interfacespeed.equalsIgnoreCase("null")) {
					 
					 DriverTestcase.logger.log(LogStatus.FAIL, " 'Interface speed' is a mandatory field but No value has been passed as input to 'Interface speed' ");
						
				 }else {
			
					WebElement interfacesped = driver
							.findElement(By.xpath("//span[contains(text(),'" + Interfacespeed + "')]"));
					interfacesped.click();
					Log.info("=== Interface speed has got selected===");
					DriverTestcase.logger.log(LogStatus.PASS, Interfacespeed+ " speed has been selected");
				 }
				}catch(Exception e) {
					e.printStackTrace();
					DriverTestcase.logger.log(LogStatus.FAIL, " 'Interface speed' value under service type is not selected");
				}

			
			
			


		// select service sub type
			
			try {
			    if(SelectSubService.equalsIgnoreCase("null")) {
			    	
			    	Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ServiceSubtype")));
					Thread.sleep(1000);
					System.out.println("clicked on service type");
					DriverTestcase.logger.log(LogStatus.PASS, " 'Service subtype' dropdown has been selected");
			    	
			    }else {
			    	
			    	Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ServiceSubtype")));
					Thread.sleep(1000);
					System.out.println("clicked on service type");
					DriverTestcase.logger.log(LogStatus.PASS, " 'Service subtype' dropdown has been selected");
			    }
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "Failure on selecting 'service subtype' dropdown field");
			}
			    
					
					try {
					WebElement el2 = driver.findElement(By.xpath("//span[contains(text(),'" + SelectSubService + "')]"));
					el2.click();
					Log.info("=== Service sub Type selected===");
					DriverTestcase.logger.log(LogStatus.PASS, "Service sub type "+ SelectSubService+ " has been selected under LANLINK");
					}catch(Exception e) {
						Log.info("Service sub type is not available");
						DriverTestcase.logger.log(LogStatus.FAIL, "Service sub type is not selected");
					}

			
				// SendKeys(getwebelement(xml.getlocator("//locators/"+Application+"/AvailableCircuits")),
				// Availablecircuits);

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Autocreatebutton")));
				Thread.sleep(3000);

				Log.info("Page has to be selected based on service and its subtype selected");

			}

			if (modularmsp.equalsIgnoreCase("yes") && autoCreateService.equalsIgnoreCase("yes")) {
				
				DriverTestcase.logger.log(LogStatus.INFO, " 'Service subtype' is mandatory when 'modular msp' and 'Autocreateservices' are selected");

				
			//modular msp	
				 try {
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/modularmspcheckbox")));
						DriverTestcase.logger.log(LogStatus.PASS, "Modular msp checkbox has been selected");
		              }catch(Exception e) {
		            	  e.printStackTrace();
		            	  DriverTestcase.logger.log(LogStatus.FAIL, "Failure at modular msp check box");
		            	  
		              }

			//Auto create service	 
				 try {
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AutocreateServicecheckbox")));
						DriverTestcase.logger.log(LogStatus.PASS, " 'Autocreateservice' checkbox is selected ");
						}catch(Exception e) {
							e.printStackTrace();
							DriverTestcase.logger.log(LogStatus.FAIL, " 'Auto create service' checkbox is not selected ");
						}

				//A end technology		
					try {	
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/A_Endtechnology")));
						DriverTestcase.logger.log(LogStatus.PASS, " 'A_End technology' dropdown is selected");
					}catch(Exception e) {
						e.printStackTrace();
						DriverTestcase.logger.log(LogStatus.FAIL, " 'A_End technology' dropdwon is not avaialble");
					}
					
					
					
					try {
						Clickon(getwebelement("//span[contains(text(),'" + A_Endtechnologydropdown + "')]"));
						DriverTestcase.logger.log(LogStatus.PASS, " 'A_End technology' value has been selected ");
					}catch(Exception e) {
						e.printStackTrace();
						DriverTestcase.logger.log(LogStatus.FAIL, "FAilure on selecting value inside 'A_end technology' dropdown");
					}

					
				//B end technology	
					
					try {	
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/B_Endtechnology")));
						DriverTestcase.logger.log(LogStatus.PASS, " 'B_End technology' dropdown is selected");
					}catch(Exception e) {
						e.printStackTrace();
						DriverTestcase.logger.log(LogStatus.FAIL, " 'B_End technology' dropdwon is not avaialble");
					}
					
//						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/B_Endtechnology")));
					

					try {
						Clickon(getwebelement("//span[contains(text(),'" + B_Endtechnologydropdown + "')]"));
						DriverTestcase.logger.log(LogStatus.PASS, " 'B_End technology' value has been selected ");
					}catch(Exception e) {
						e.printStackTrace();
						DriverTestcase.logger.log(LogStatus.FAIL, "FAilure on selecting value inside 'A_end technology' dropdown");
					}


				
			// select service sub type
					
			try {
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ServiceSubtype")));
				Thread.sleep(1000);
				System.out.println("clicked on srvice type");
				DriverTestcase.logger.log(LogStatus.PASS, "Service subtype dropdown has been selected");
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "Service subtype dropdown is not selected");
			}


			try {	
				if(SelectSubService.equals("LANLink International") || SelectSubService.equals("LANLink Metro") || SelectSubService.equals("LANLink National") ||
				         SelectSubService.equals("OLO - (GCR/EU)")){

				WebElement el2 = driver.findElement(By.xpath("//span[contains(text(),'" + SelectSubService + "')]"));
				el2.click();
				Log.info("=== Service sub Type selected===");
				DriverTestcase.logger.log(LogStatus.PASS, "Service sub type" +SelectSubService +" has been selected");
				}
				else{
					Log.info(SelectSubService+ " is not available under Service subtype dropdown when Modular msp is selected");
					
					DriverTestcase.logger.log(LogStatus.FAIL,SelectSubService+ " is not available when Modular msp is selected."
							+ "                      The list of sub services types under LANLINK when moduler msp is selected are:"
							+ "    1) LANLink International"
							+ "    2) LANLink Metro"
							+ "    3) LANLink National"
							+ "    4) OLO - (GCR/EU)");
					driver.close();
				}
			}catch(Exception e) {
				Log.info("Service sub type is not available");
				DriverTestcase.logger.log(LogStatus.FAIL, "Service sub type is not available");
			}


//				 SendKeys(getwebelement(xml.getlocator("//locators/"+Application+"/AvailableCircuits")),
//				 Availablecircuits);

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Autocreatebutton")));
				Thread.sleep(3000);

				Log.info("Page has to be selected based on service and its subtype selected");

			}


		}

		public void VerifyFieldsForServiceSubTypeSelected(String application, String serviceType, String SelectSubService,
				String Interfacespeed, String proActivemonitoring, String vpntopology, String aggregateTraffic, String modularmsp) throws InterruptedException, DocumentException, IOException {

					Thread.sleep(3000);
			
		if(modularmsp.equalsIgnoreCase("no"))	{		
			if (SelectSubService.equalsIgnoreCase("Direct Fiber")) {

				Fieldvalidation_DirectFibre(application, serviceType, SelectSubService, Interfacespeed,proActivemonitoring, vpntopology);

			}

		else if (SelectSubService.equalsIgnoreCase("LANLink International")) {

				Fieldvalidation_LANlinkInternational(application, serviceType, SelectSubService, Interfacespeed, proActivemonitoring,vpntopology,aggregateTraffic);

			}

		else if (SelectSubService.equalsIgnoreCase("LANLink Metro")) {

				Fieldvalidation_LANlinkMetro(application, serviceType, SelectSubService, Interfacespeed, proActivemonitoring,vpntopology);

			}

		else if (SelectSubService.equalsIgnoreCase("LANLink National")) {

				Fieldvalidation_LANlinkNational(application, serviceType, SelectSubService, Interfacespeed, proActivemonitoring,vpntopology, aggregateTraffic);

			}

		else if (SelectSubService.equalsIgnoreCase("LANLink Outband Management")) {

				Fieldvalidation_LANlinkoutbandmanagement(application, serviceType, SelectSubService, Interfacespeed, proActivemonitoring,vpntopology);

			}

		else if (SelectSubService.equalsIgnoreCase("OLO - (GCR/EU)")) {

				Fieldvalidation_OLO(application, serviceType, SelectSubService, Interfacespeed,proActivemonitoring,vpntopology);

			}

		}	
		
		
		else if(modularmsp.equalsIgnoreCase("yes"))	{	
			

		 if (SelectSubService.equalsIgnoreCase("LANLink International")) {

				Fieldvalidation_LANlinkInternationalwithoutinterfacespeed(application, serviceType, SelectSubService, Interfacespeed, proActivemonitoring,vpntopology,aggregateTraffic);

			}

		else if (SelectSubService.equalsIgnoreCase("LANLink Metro")) {

				Fieldvalidation_LANlinkMetrowithoutinterfacespeed(application, serviceType, SelectSubService, Interfacespeed, proActivemonitoring,vpntopology);

			}

		else if (SelectSubService.equalsIgnoreCase("LANLink National")) {

				Fieldvalidation_LANlinkNationalwithoutinterfacespeed(application, serviceType, SelectSubService, Interfacespeed, proActivemonitoring,vpntopology, aggregateTraffic);

			}

		else if (SelectSubService.equalsIgnoreCase("OLO - (GCR/EU)")) {

				Fieldvalidation_OLOwithoutinterfacespeed(application, serviceType, SelectSubService, Interfacespeed,proActivemonitoring,vpntopology);

			}
		}	
		
			
	}

		public void verifyDataEntered(String ServiceSelected, String SelectSubService, String Interfacespeed,
				String ServiceIdentificationNumber, String EndpointCPE, String Email, String PhoneContact, String remark,
				String PerformanceMonitoring, String ProactiveMonitoring, String deliveryChannel, String ManagementOrder,
				String vpnTopology, String intermediateTechnology, String CircuitReference, String CircuitType) {

			if (SelectSubService.equals("Direct Fiber")) {

				// Service Idenification
				try {
					Boolean flag = getwebelement("//div[contains(text(),'" + ServiceIdentificationNumber + "')]")
							.isDisplayed();

					String ServiceNumber = Gettext(
							getwebelement("//div[contains(text(),'" + ServiceIdentificationNumber + "')]"));

					if (ServiceNumber.isEmpty()) {
						System.out.println("service Identification is present");
						Log.info("Service Identification is not null and the values entered is: " + ServiceNumber);
					} else {

						Log.info("No values displaying under service Identification");
					}

				} catch (Exception e) {

					Log.info("No values displaying under service Identification");
				}

				// Service type
				try {

					Boolean flag = getwebelement("//div[contains(text(),'" + ServiceSelected + "')]").isDisplayed();

					String serviceType = Gettext(getwebelement("//div[contains(text(),'" + ServiceSelected + "')]"));

					if (serviceType.isEmpty()) {
						System.out.println("service Type is present");
						Log.info("Service Type is not null and the values entered is: " + serviceType);
					} else {

						Log.info("No values displaying under service Type");
					}

				} catch (Exception e) {

					Log.info("No values displaying under service type");
				}

				// Service subtype
				try {
					Boolean flag = getwebelement("//div[contains(text(),'" + SelectSubService + "')]").isDisplayed();

					String Subservice = Gettext(getwebelement("//div[contains(text(),'" + SelectSubService + "')]"));

					if (Subservice.isEmpty()) {
						System.out.println("Subservice value is present");
						Log.info("Subservice value is not null and the values entered is: " + Subservice);
					} else {

						Log.info("No values displaying under SubserviceType");
					}

				} catch (Exception e) {

					Log.info("No values displaying under service sub type");
				}

				// Interface Speed
				try {

					Boolean flag = getwebelement("//div[contains(text(),'" + Interfacespeed + "')]").isDisplayed();

					String interfacespeed = Gettext(getwebelement("//div[contains(text(),'" + Interfacespeed + "')]"));

					if (interfacespeed.isEmpty()) {
						System.out.println("interfaceSpeed is present");
						Log.info("interfaceSpeed value is not null and the values entered is: " + interfacespeed);
					} else {

						Log.info("No values displaying under interfaceSpeed");
					}

				} catch (Exception e) {

					Log.info("No values displaying under Interface Speed");
				}

				// Single Endpoint CPE
				try {

					Boolean flag = getwebelement("//div[contains(text(),'" + EndpointCPE + "')]").isDisplayed();

					String cpe = Gettext(getwebelement("//div[contains(text(),'" + EndpointCPE + "')]"));

					if (cpe.isEmpty()) {
						System.out.println("Single Endpoint CPE is present");
						Log.info("Single Endpoint CPE is not null and the values entered is: " + cpe);
					} else {

						Log.info("No values displaying under Single Endpoint CPE");
					}
				} catch (Exception e) {

					Log.info("No values displaying under Single End point CPE");
				}

				// Email
				try {

					Boolean flag = getwebelement("//div[contains(text(),'" + Email + "')]").isDisplayed();

					String email = Gettext(getwebelement("//div[contains(text(),'" + Email + "')]"));

					if (email.isEmpty()) {
						System.out.println("Email is present");
						Log.info("Email is not null and the values entered is: " + email);
					} else {

						Log.info("No values displaying under Email");
					}
				} catch (Exception e) {

					Log.info("No values displaying under Email");
				}

				try {

					Boolean flag = getwebelement("//div[contains(text(),'" + PhoneContact + "')]").isDisplayed();

					String contact = Gettext(getwebelement("//div[contains(text(),'" + PhoneContact + "')]"));

					if (contact.isEmpty()) {
						System.out.println("Contact is present");
						Log.info("Email is not null and the values entered is: " + contact);
					} else {

						Log.info("No values displaying under Phone contact");
					}
				} catch (Exception e) {

					Log.info("No values displaying under Phone Contact");
				}

				try {

					Boolean flag = getwebelement("//div[contains(text(),'" + remark + "')]").isDisplayed();

					String Remark = Gettext(getwebelement("//div[contains(text(),'" + remark + "')]"));

					if (Remark.isEmpty()) {
						System.out.println("Contact is present");
						Log.info("remark is not null and the values entered is: " + Remark);
					} else {

						Log.info("No values displaying under remark");
					}
				} catch (Exception e) {

					Log.info("No values displaying under remark");
				}

				// Performance reporting
				try {

					Boolean flag = getwebelement("//div[contains(text(),'" + PerformanceMonitoring + "')]").isDisplayed();

					String perFormance = Gettext(getwebelement("//div[contains(text(),'" + PerformanceMonitoring + "')]"));

					if (perFormance.isEmpty()) {
						System.out.println("Performance reporting is present");
						Log.info("Performance reporting is not null and the values entered is: " + perFormance);
					} else {

						Log.info("No values displaying under Performance Reporting");
					}
				} catch (Exception e) {

					Log.info("No values displaying under Performance Reporting");
				}

				// ProactiveMonitoring
				try {

					Boolean flag = getwebelement("//div[contains(text(),'" + ProactiveMonitoring + "')]").isDisplayed();

					String proactive = Gettext(getwebelement("//div[contains(text(),'" + ProactiveMonitoring + "')]"));

					if (proactive.isEmpty()) {
						System.out.println("PRo active Montoring is present");
						Log.info("Pro active Monitoring is not null and the values entered is: " + proactive);
					} else {

						Log.info("No values displaying under Pro active Monitoring");
					}
				} catch (Exception e) {

					Log.info("No values displaying under Pro active monitoring");
				}

				// DeliveryChannel
				try {

					Boolean flag = getwebelement("//div[contains(text(),'" + deliveryChannel + "')]").isDisplayed();

					String delivery = Gettext(getwebelement("//div[contains(text(),'" + deliveryChannel + "')]"));

					if (delivery.isEmpty()) {
						System.out.println("Delivery channel value is present");
						Log.info("Delivery channel value is not null and the values entered is: " + delivery);
					} else {

						Log.info("No values displaying under delivery channel");
					}
				} catch (Exception e) {

					Log.info("No values displaying under delivery channel");
				}

				// ManagementOrder
				try {

					Boolean flag = getwebelement("//div[contains(text(),'" + ManagementOrder + "')]").isDisplayed();

					String order = Gettext(getwebelement("//div[contains(text(),'" + ManagementOrder + "')]"));

					if (order.isEmpty()) {
						System.out.println("management order value is present");
						Log.info("management Order value is not null and the values entered is: " + order);
					} else {

						Log.info("No values displaying under management Order");
					}
				} catch (Exception e) {

					Log.info("No values displaying under management Order");
				}

				// vpnTopology
				try {

					Boolean flag = getwebelement("//div[contains(text(),'" + vpnTopology + "')]").isDisplayed();

					String vpn = Gettext(getwebelement("//div[contains(text(),'" + vpnTopology + "')]"));

					if (vpn.isEmpty()) {
						System.out.println("VPN Topology value is present");
						Log.info("VPN Topology value is not null and the values entered is: " + vpn);
					} else {

						Log.info("No values displaying under VPN Topology");
					}
				} catch (Exception e) {

					Log.info("No values displaying under VPN Topology");
				}

				// CircuitReference
				try {

					Boolean flag = getwebelement("//div[contains(text(),'" + CircuitReference + "')]").isDisplayed();

					String circuitref = Gettext(getwebelement("//div[contains(text(),'" + CircuitReference + "')]"));

					if (circuitref.isEmpty()) {
						System.out.println("Circuit reference value is present");
						Log.info("circuit reference is not null and the values entered is: " + circuitref);
					} else {

						Log.info("No values displaying under Circuit reference");
					}
				} catch (Exception e) {

					Log.info("No values displaying under Circuit reference");
				}

				// CircuitType
				try {

					Boolean flag = getwebelement("//div[contains(text(),'" + CircuitType + "')]").isDisplayed();

					String circuitype = Gettext(getwebelement("//div[contains(text(),'" + CircuitType + "')]"));

					if (circuitype.isEmpty()) {
						System.out.println("Circuit Type value is present");
						Log.info("circuit Type is not null and the values entered is: " + circuitype);
					} else {

						Log.info("No values displaying under Circuit Type");
					}
				} catch (Exception e) {

					Log.info("No values displaying under Circuit type");
				}

			}

		}

		public void Verifyfields(String application, String ServiceTypeToBeSelected, String modularMSP,
				String autoCreateService) throws InterruptedException, DocumentException {


	
				
			String[] Servicetypelists = { "BM (Broadcast Media)", "Domain Management", "DSL", "FAX to Mail", "HSS",
					"IP Access (On-net/Offnet/EoS)", "IP Access Bundle", "IP Transit", "IP VPN", "IP Web/Mail", "LANLink",
					"MDF/MVF/DI", "NGIN", "Number Hosting", "Transmission Link", "Voice Line (V)", "VOIP Access",
					"Wholesale SIP Trunking" };

			
			orderdopdown = getwebelement(xml.getlocator("//locators/" + application + "/orderdropdown")).isDisplayed();
			sa.assertTrue(orderdopdown, "Order/Contract Number dropdown is not displayed");
			
			serviceTypedropdown = getwebelement(xml.getlocator("//locators/" + application + "/servicetypedropdowntoclick"))
					.isDisplayed();
			sa.assertTrue(serviceTypedropdown, "service type dropdown is not displayed");

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/servicetypedropdowntoclick")));
			Thread.sleep(2000);

			// verifying list of service types
			try {
			List<WebElement> listofservicetypes = driver.findElements(By.xpath("//div/span[@role='option']"));
			for (WebElement servicetype : listofservicetypes) {

				boolean match = false;
				for (int i = 0; i < Servicetypelists.length; i++) {
					if (servicetype.getText().equals(Servicetypelists[i])) {
						match = true;
						Log.info("service type name : " + servicetype.getText());
						DriverTestcase.logger.log(LogStatus.PASS, "service type names are : " + servicetype.getText());
					}
				}
				sa.assertTrue(match);

			}
			}catch(Exception e) {
				Log.info("service type lists got mismatched");
				DriverTestcase.logger.log(LogStatus.FAIL, "Service type lists are mismatching");
			}
			// select lanlink service type

			WebElement el2 = driver.findElement(By.xpath("//span[contains(text(),'" + ServiceTypeToBeSelected + "')]"));
			el2.click();
			Log.info("=== Service Type selected===");

			modularmspCheckbox = getwebelement(xml.getlocator("//locators/" + application + "/modularmspcheckbox"))
					.isDisplayed();
			sa.assertTrue(modularmspCheckbox, "modularmsp checkbox is displayed");

			autocreateservicecheckbox = getwebelement(
					xml.getlocator("//locators/" + application + "/AutocreateServicecheckbox")).isDisplayed();
			sa.assertTrue(autocreateservicecheckbox, "Auto create check box is not displayed");
			
		
		for(int i=0; i<4; i++) {
			
			if(i==0) {
				
//				if (modularMSP.equalsIgnoreCase("no") && autoCreateService.equalsIgnoreCase("no")) {
				
				DriverTestcase.logger.log(LogStatus.INFO, "When btoh Modular msp and Autocreate Service is not selected, list of fields should occur:"
						+ "1) Interface speed dropdown"
						+ "2) Service Subtype dropdown"
						+ "3) Available circuit dropdown");
					
					verifyinterfaceSpeeddropdown(application);

					verifyservicesubtypesdropdownwhenMSPandAutoCreatenotslected(application);

					verifyavailablecircuitdropdown(application);

//				}
			}
		
			
			else if(i==1) {
				
				DriverTestcase.logger.log(LogStatus.INFO, "When 'Modular msp' is selected but 'Autocreate Service' is not selected, list of fields should occur:"
						+ "1) Service Subtype dropdown"
						+ "2) Available circuit dropdown");

//				else if (modularMSP.equalsIgnoreCase("yes") && autoCreateService.equalsIgnoreCase("no")) {
				
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/modularmspcheckbox")));

					verifyservicesubtypesdropdownwhenMSPaloneselected(application);

					verifyavailablecircuitdropdown(application);

//				}
				
			}


			else if(i==2) {
				

//				else if (modularMSP.equalsIgnoreCase("no") && autoCreateService.equalsIgnoreCase("yes")) {
				
				DriverTestcase.logger.log(LogStatus.INFO, "When 'Modular msp' is not selected but 'Autocreate Service' is selected, list of fields should occur: "
						+ "1) A_End technology dropdown"
						+ "2) B_End technology dropdown"
						+ "3) Interface speeed dropdown"
						+ "4) Service Subtype dropdown"
						+ "5) Available circuit dropdown");
					
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/modularmspcheckbox")));
					Thread.sleep(2000);
					
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AutocreateServicecheckbox")));
					Thread.sleep(1000);

					verifyA_Endtechnologydropdown(application);

					verifyB_Endtechnologydropdowb(application);

					verifyinterfaceSpeeddropdown(application);

					verifyservicesubtypesdropdownwgenAutoCreatealoneselected(application);

					verifyavailablecircuitdropdown(application);

//				}
				
			}
			
			
			else if(i==3) {
				
				
				DriverTestcase.logger.log(LogStatus.INFO, "When both 'Modular msp' and 'Autocreate Service' is selected, list of fields should occur: "
						+ "1) Service Subtype dropdown"
						+ "2) Available circuit dropdown");
				
//				else if (modularMSP.equalsIgnoreCase("yes") && autoCreateService.equalsIgnoreCase("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/modularmspcheckbox")));

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AutocreateServicecheckbox")));

					verifyservicesubtypesdropdownwhenMSPandAutoCreateselected(application);

					verifyavailablecircuitdropdown(application);

//				}
				
				
			}
			
		}
			

			
			
		
			
		}

		public void verifyinterfaceSpeeddropdown(String application) throws InterruptedException, DocumentException {
			// verify the list of interfaceSpeed
			try {

			String[] interfacelist = { "1GigE", "10GigE" };

			interfacespeeddropdown = getwebelement(xml.getlocator("//locators/" + application + "/InterfaceSpeed"))
					.isDisplayed();
			sa.assertTrue(interfacespeeddropdown, "Interface speed dropdown is not displayed");

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/InterfaceSpeed")));

			List<WebElement> listofinterfacespeed = driver
					.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement interfacespeed : listofinterfacespeed) {

				boolean match = false;
				for (int i = 0; i < interfacelist.length; i++) {
					if (interfacespeed.getText().equals(interfacelist[i])) {
						match = true;
						Log.info("interface speeds : " + interfacespeed.getText());
						DriverTestcase.logger.log(LogStatus.PASS,"interface speeds : " + interfacespeed.getText());
						sa.assertTrue(match);
					}
				}
				
			}
			
			} catch (AssertionError error) {
	           
				error.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, " validation failure for Interface speed dropdown under Create order detail page");
				
	        }catch(Exception e) {
				Log.info("dropdowns values in Interface speed are mismiatching under service type");
				System.out.println("dropdowns values in Interface speed are mismiatching under service type");
				DriverTestcase.logger.log(LogStatus.FAIL, " Interface speed dropdown values are not displaying as expected ");
			}

		}

		public void verifyservicesubtypesdropdownwhenMSPandAutoCreatenotslected(String application) throws InterruptedException, DocumentException {

			String[] servicesubtypelist = { "Direct Fiber", "LANLink International", "LANLink Metro", "LANLink National","LANLink Outband Management", "OLO - (GCR/EU)" };

			try {
			servicesubtypesdropdown = getwebelement(xml.getlocator("//locators/" + application + "/ServiceSubtype"))
					.isDisplayed();
			sa.assertTrue(servicesubtypesdropdown, "Service sub type dropdown is not displayed");
			
			// verify the list of service sub types
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ServiceSubtype")));
			
			List<WebElement> listofServicesubtypes = driver
					.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement servicesubtypes : listofServicesubtypes) {

				boolean match = false;
				for (int i = 0; i < servicesubtypelist.length; i++) {
					if (servicesubtypes.getText().equals(servicesubtypelist[i])) {
						match = true;
						Log.info("service sub types : " + servicesubtypes.getText());
						DriverTestcase.logger.log(LogStatus.PASS,"service sub types : " + servicesubtypes.getText());
						sa.assertTrue(match);
					}
				}
				

			}
			
			} catch (AssertionError error) {

				error.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL,"validation failure for Service subtypes dropdown under create order detail page");
				
	        }catch(Exception e) {
				Log.info("Dropdown values in Service subtypes are mismatching");
				System.out.println("Dropdown values in Service subtypes are mismatching");
				DriverTestcase.logger.log(LogStatus.FAIL,"Dropdown values in Service subtypes are mismatching");
			}

		}

		

		public void verifyservicesubtypesdropdownwhenMSPaloneselected(String application) throws InterruptedException, DocumentException {

			try {
			String[] servicesubtypelist = { "LANLink International", "LANLink Metro", "LANLink National", "OLO - (GCR/EU)" };

			servicesubtypesdropdown = getwebelement(xml.getlocator("//locators/" + application + "/ServiceSubtype"))
					.isDisplayed();
			sa.assertTrue(servicesubtypesdropdown, "Service sub type dropdown is not displayed");
			
			// verify the list of service sub types
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ServiceSubtype")));
			
			List<WebElement> listofServicesubtypes = driver
					.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement servicesubtypes : listofServicesubtypes) {

				boolean match = false;
				for (int i = 0; i < servicesubtypelist.length; i++) {
					if (servicesubtypes.getText().equals(servicesubtypelist[i])) {
						match = true;
						Log.info("service sub types : " + servicesubtypes.getText());
						DriverTestcase.logger.log(LogStatus.PASS,"service sub types : " + servicesubtypes.getText());
						sa.assertTrue(match);
					}
				}
				

			}
			} catch (AssertionError error) {
	           
				error.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL,"validation failure for  service subtypes under create order detail page");
				
			}catch (Exception e) {

			Log.info("Dropdown values inside service subtypes are mismatching");
			System.out.println("Dropdown values inside service subtypes are mismatching");
			DriverTestcase.logger.log(LogStatus.FAIL,"Dropdown values inside service subtypes are mismatching");
			}

		}
		
		
		public void verifyservicesubtypesdropdownwgenAutoCreatealoneselected(String application) throws InterruptedException, DocumentException {

			try {
			String[] servicesubtypelist = { "Direct Fiber", "LANLink International", "LANLink Metro", "LANLink National","LANLink Outband Management", "OLO - (GCR/EU)" };

			servicesubtypesdropdown = getwebelement(xml.getlocator("//locators/" + application + "/ServiceSubtype"))
					.isDisplayed();
			sa.assertTrue(servicesubtypesdropdown, "Service sub type dropdown is not displayed");

			// verify the list of service sub types
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ServiceSubtype")));

			List<WebElement> listofServicesubtypes = driver
					.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement servicesubtypes : listofServicesubtypes) {

				boolean match = false;
				for (int i = 0; i < servicesubtypelist.length; i++) {
					if (servicesubtypes.getText().equals(servicesubtypelist[i])) {
						match = true;
						Log.info("service sub types : " + servicesubtypes.getText());
						DriverTestcase.logger.log(LogStatus.PASS,"service sub types : " + servicesubtypes.getText());
						sa.assertTrue(match);
					}
				}
				

			}
			} catch (AssertionError error) {

				  error.printStackTrace();
				  DriverTestcase.logger.log(LogStatus.FAIL,"validation failure for Service subtype under create order detail page");
				
			}catch(Exception e) {
				Log.info("Dropdwon values inside service subtypes are mismatching");
				System.out.println("Dropdwon values inside service subtypes are mismatching");
				DriverTestcase.logger.log(LogStatus.FAIL,"Dropdwon values inside service subtypes are mismatching");
			}

		}
		
		
		
		public void verifyservicesubtypesdropdownwhenMSPandAutoCreateselected(String application) throws InterruptedException, DocumentException {

			try {
			String[] servicesubtypelist = { "LANLink International", "LANLink Metro", "LANLink National", "OLO - (GCR/EU)" };

			servicesubtypesdropdown = getwebelement(xml.getlocator("//locators/" + application + "/ServiceSubtype"))
					.isDisplayed();
			sa.assertTrue(servicesubtypesdropdown, "Service sub type dropdown is not displayed");
 
			
			// verify the list of service sub types
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ServiceSubtype")));
			

			List<WebElement> listofServicesubtypes = driver
					.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement servicesubtypes : listofServicesubtypes) {

				boolean match = false;
				for (int i = 0; i < servicesubtypelist.length; i++) {
					if (servicesubtypes.getText().equals(servicesubtypelist[i])) {
						match = true;
						Log.info("service sub types : " + servicesubtypes.getText());
						DriverTestcase.logger.log(LogStatus.PASS,"service sub types are : " + servicesubtypes.getText());
						sa.assertTrue(match);
					}
				}
				

			}
			
		} catch (AssertionError error) {

			  error.printStackTrace();
			  DriverTestcase.logger.log(LogStatus.FAIL,"validation failure for Service subtypes under create order detail page");
			  
		}catch(Exception e){
	    	 Log.info("Dropdwon values inside Service subtypes are mismatching");
	    	 System.out.println("Dropdwon values inside Service subtypes are mismatching");
	    	 DriverTestcase.logger.log(LogStatus.FAIL,"Dropdwon values inside Service subtypes are mismatching");
	     }

		}



		
		
		public void verifyavailablecircuitdropdown(String application) throws InterruptedException, DocumentException {
	try {
			availablecircuitsdropdown = getwebelement(xml.getlocator("//locators/" + application + "/AvailableCircuits"))
					.isDisplayed();
			
			sa.assertTrue(availablecircuitsdropdown, "available circuit dropdown is not displayed");
			DriverTestcase.logger.log(LogStatus.PASS, "Available circuit dropdown is displayed");
			
	}catch(AssertionError e) {
		Log.info("Available circuit dropdown under servicetype got failed");
		System.out.println("Available circuit dropdown under servicetype got failed");
		DriverTestcase.logger.log(LogStatus.FAIL, "Available circuit dropdown is not displaying, field validation failue under create order detail page");
	}
}

		public void verifyA_Endtechnologydropdown(String application) throws InterruptedException, DocumentException {

			try {
			String[] A_endTechnolnogylist = { "Atrica", "MMSP", "Ethernet over Fibre" };

			A_EndTechnolnogy = getwebelement(xml.getlocator("//locators/" + application + "/A_Endtechnology"))
					.isDisplayed();
			sa.assertTrue(A_EndTechnolnogy, "A-End technolnogy dropdown is not displayed");

			// verify the list of A-End technolnogies
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/A_Endtechnology")));

			List<WebElement> listofA_endTechnologies = driver
					.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement A_endTechnolnogies : listofA_endTechnologies) {

				boolean match = false;
				for (int i = 0; i < A_endTechnolnogylist.length; i++) {
					if (A_endTechnolnogies.getText().equals(A_endTechnolnogylist[i])) {
						match = true;
						Log.info("A end technology values : " + A_endTechnolnogies.getText());
						DriverTestcase.logger.log(LogStatus.PASS,"A end technology are : " + A_endTechnolnogies.getText());
						sa.assertTrue(match);
					}
				}
				

			}
			} catch (AssertionError error) {

			  error.printStackTrace();
			  DriverTestcase.logger.log(LogStatus.FAIL,"validation failure for A-end technology under create order detail page");
			
			}catch(Exception e) {
				Log.info("Dropdwon values inside A-end technology are mismatching");
				System.out.println("Dropdwon values inside A-end technology are mismatching");
				DriverTestcase.logger.log(LogStatus.FAIL,"Dropdwon values inside A-end technology are mismatching");
			}

		}

		public void verifyB_Endtechnologydropdowb(String application) throws InterruptedException, DocumentException {

			try {
			String[] B_endTechnolnogylist = { "Atrica", "MMSP", "Ethernet over Fibre" };

			B_Endtechnolnogy = getwebelement(xml.getlocator("//locators/" + application + "/B_Endtechnology"))
					.isDisplayed();
			sa.assertTrue(B_Endtechnolnogy, "B-End technolnogy dropdown is not displayed");

			// verify the list of A-End technolnogies
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/B_Endtechnology")));

			List<WebElement> listofB_endTechnologies = driver
					.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement B_endTechnolnogies : listofB_endTechnologies) {

				boolean match = false;
				for (int i = 0; i < B_endTechnolnogylist.length; i++) {
					if (B_endTechnolnogies.getText().equals(B_endTechnolnogylist[i])) {
						match = true;
						Log.info("B end technology values : " + B_endTechnolnogies.getText());
						DriverTestcase.logger.log(LogStatus.PASS, "B end technologies are : " + B_endTechnolnogies.getText());
						sa.assertTrue(match);
					}
				}
				

			}
			} catch (AssertionError error) {

				  error.printStackTrace();
				  DriverTestcase.logger.log(LogStatus.FAIL,"validation failure for B-end technology under create order detail page");
				
			}catch(Exception e) {
				Log.info("Dropdwon values inside B-end technology are mismatching");
				System.out.println("Dropdwon values inside B-end technology are mismatching");
				DriverTestcase.logger.log(LogStatus.FAIL,"Dropdwon values inside B-end technology are mismatching");
			}
		}

		public void DirectFibre(String application, String ServiceIdentificationNumber, String SelectSubService,
				String Interfacespeed, String EndpointCPE, String Email, String PhoneContact, String remark,
				String PerformanceMonitoring, String ProactiveMonitoring, String deliveryChannel, String ManagementOrder,
				String vpnTopology, String intermediateTechnology, String CircuitReference, String CircuitType, String notificationManagement)
				throws InterruptedException, IOException, DocumentException {
			


			
			
			if(!ServiceIdentificationNumber.equalsIgnoreCase("null")) {
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
						ServiceIdentificationNumber);
				
			}else {
				DriverTestcase.logger.log(LogStatus.FAIL,"It is a mandatory field but service identification value is not entered as per input provided"); 
			}
			
			
			
			if(!EndpointCPE.equalsIgnoreCase("null")) {
				
				
				if (EndpointCPE.equals("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
					Log.info("End point CPE check box is selected");
					
				}

				else {

					Log.info("Sing Endpoint CPE is not selected");
					DriverTestcase.logger.log(LogStatus.INFO,"Sing Endpoint CPE is not selected as per input provided"); 
				}

			}
			
			
			if(!Email.equalsIgnoreCase("null")) {
				
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);
				

			}else {
				DriverTestcase.logger.log(LogStatus.INFO,"Input for Email field is not provided"); 
			}
			
			
			if(!PhoneContact.equalsIgnoreCase("null")) {
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);
			}else {
				DriverTestcase.logger.log(LogStatus.INFO,"Input for phone conatct field is not provided");
			}
			
			
			if(!remark.equalsIgnoreCase("null")) {
				
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);
				
			}else {
				
				DriverTestcase.logger.log(LogStatus.INFO,"Input for remark field is not provided");
			}
			
			
			
			if(!PerformanceMonitoring.equalsIgnoreCase("null")) {
				
				if (PerformanceMonitoring.equalsIgnoreCase("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")));
					Log.info("performance monitoring check box is selected");
					
				}

				else {

					System.out.println("Performance monitoring is not selected");
					DriverTestcase.logger.log(LogStatus.INFO,"performance monitoring checkbox as per input");
					
				}

				
			}



			if (!ProactiveMonitoring.equalsIgnoreCase("null")) {


				if (ProactiveMonitoring.equalsIgnoreCase("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
					Log.info("Pro active monitoring check box is selected");

					if (!notificationManagement.equalsIgnoreCase("null")) {
					Log.info("Notificationan Management dropdown displays when pro active monitoring is selected");
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
					Clickon(getwebelement("//span[contains(text(),'" + notificationManagement + "')]"));
					
					}else {
						DriverTestcase.logger.log(LogStatus.INFO,"Input for Notification management dropdown is not provided"); 
						
					}
					
				} else {

					Log.info("Pro active monitoring is not selected");
					System.out.println("pro active monitoring is not selected");
					DriverTestcase.logger.log(LogStatus.INFO,"performance monitor checkbox is not selected as per input provided"); 
				}

			}

		
			if (!deliveryChannel.equalsIgnoreCase("null")) {


				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/deliverychannel_withclasskey")));
				Clickon(getwebelement("//span[contains(text(),'" + deliveryChannel + "')]"));

			}else {
				DriverTestcase.logger.log(LogStatus.INFO,"Delivery channel dropdown is not selected as per input provided"); 
			}

			
			
			if (!ManagementOrder.equalsIgnoreCase("null")) {


				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/managementOrder")), ManagementOrder);
			}else {
				DriverTestcase.logger.log(LogStatus.INFO,"management Order value is not Entered as per input provided");
			}

			if (!vpnTopology.equalsIgnoreCase("null")) {


				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
				Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
				
				if(vpnTopology.equals("Point-to-Point")) {
					
				
					if (!intermediateTechnology.equalsIgnoreCase("null")) {
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")),
							intermediateTechnology);
					}else {
						DriverTestcase.logger.log(LogStatus.INFO,"Intermediate  Technology value is not Entered as per input provided");
					}
					
					if (!CircuitReference.equalsIgnoreCase("null")) {
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
					}else {
						DriverTestcase.logger.log(LogStatus.FAIL,"Circuit reference field is mandatory, but no inputs has been provided");
					}

					if (!CircuitType.equalsIgnoreCase("null")) {
					Clickon(getwebelement("//div[span[contains(text(),'" + CircuitType + "')]]//input"));
					}else {
						DriverTestcase.logger.log(LogStatus.INFO,"Circuit Type value is not Entered as per input provided");
					}
				

					
					
				}
				
				else if(vpnTopology.equals("Hub&Spoke") || vpnTopology.equals("E-PN (Any-to-Any)")) {

					if (!CircuitReference.equalsIgnoreCase("null")) {
						SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
						}else {
							DriverTestcase.logger.log(LogStatus.FAIL,"Circuit reference field is mandatory, but no inputs has been provided");
						}
					
				}
				
				else {
					
					System.out.println(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
					Log.info(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
					DriverTestcase.logger.log(LogStatus.INFO,vpnTopology+ " is not available inside the VPNtopoloy dropdown");

				}


			}

		
			

			
			
		
		
		
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

		
		
		}
		
		
		
		
		
		
		
		

		public void LanlinkInternationalwhenMSPisselected(String application, String ServiceIdentificationNumber, String SelectSubService,
				String Interfacespeed, String EndpointCPE, String Email, String PhoneContact, String remark,
				String PerformanceMonitoring, String ProactiveMonitoring, String deliveryChannel, String AggregateTraffic,
				String vpnTopology, String intermediateTechnology, String CircuitReference, String CircuitType, String notificationManagement)
				throws InterruptedException, IOException, DocumentException {

		SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
				ServiceIdentificationNumber);

		
		if (EndpointCPE.equals("yes")) {

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
			Log.info("End point CPE check box is selected");
		}

		else {

			Log.info("Sing Endpoint CPE is not selected");
		}

		SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);

		SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);

		SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);

		if (PerformanceMonitoring.equals("yes")) {

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")));
			Log.info("performance monitoring check box is selected");
		}

		else {

			System.out.println("Performance monitoring is not selected");
		}

		if (ProactiveMonitoring.equals("yes")) {

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
			Log.info("Pro active monitoring check box is selected");
			
			Log.info("Notificationan Management dropdown displays when pro active monitoring is selected");
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
			Clickon(getwebelement("//span[contains(text(),'" + notificationManagement + "')]"));

			
		}

		else {

			Log.info("Pro active monitoring is not selected");
		}
		
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
		Clickon(getwebelement("//span[contains(text(),'" + deliveryChannel + "')]"));

		

		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
		Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
		
		if(vpnTopology.equals("Point-to-Point")) {
			
			if (!intermediateTechnology.equalsIgnoreCase("null")) {
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")),
						intermediateTechnology);
				}else {
					DriverTestcase.logger.log(LogStatus.INFO,"Intermediate  Technology value is not Entered as per input provided");
				}
				
				if (!CircuitReference.equalsIgnoreCase("null")) {
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
				}else {
					DriverTestcase.logger.log(LogStatus.FAIL,"Circuit reference field is mandatory, but no inputs has been provided");
				}

				if (!CircuitType.equalsIgnoreCase("null")) {
				Clickon(getwebelement("//div[span[contains(text(),'" + CircuitType + "')]]//input"));
				}else {
					DriverTestcase.logger.log(LogStatus.INFO,"Circuit Type value is not Entered as per input provided");
				}

			
			
		}
		
		else if(vpnTopology.equals("E-PN (Any-to-Any)")) {

			
				
				if (!CircuitReference.equalsIgnoreCase("null")) {
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
				}else {
					DriverTestcase.logger.log(LogStatus.FAIL,"Circuit reference field is mandatory, but no inputs has been provided");
				}

				
			
		}
		
		
		else if(vpnTopology.equals("Hub&Spoke")) {

			Log.info("Circuit ref, circuit type and Intermediate tech fields are not available to enter value");
			System.out.println("circuit ref dropdowns is not available");
			
		}

		
	else {
			
			System.out.println(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
			Log.info(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
		}
	
		
		
			
		
	Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));


			
		}			


		public void LanlinkInternational(String application, String ServiceIdentificationNumber, String SelectSubService,
				String Interfacespeed, String EndpointCPE, String Email, String PhoneContact, String remark,
				String PerformanceMonitoring, String ProactiveMonitoring, String deliveryChannel, String AggregateTraffic,
				String vpnTopology, String intermediateTechnology, String CircuitReference, String CircuitType, String notificationManagement)
				throws InterruptedException, IOException, DocumentException {

			
			String[] interfaceSpd=Interfacespeed.split(" ");
			
			
	if(!ServiceIdentificationNumber.equalsIgnoreCase("null")) {
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
						ServiceIdentificationNumber);
				
			}else {
				DriverTestcase.logger.log(LogStatus.FAIL,"Input for Service Identification number dropdown is not provided and it is a manadatory field"); 
			}
			
			
			
			if(!EndpointCPE.equalsIgnoreCase("null")) {
				
				
				if (EndpointCPE.equals("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
					Log.info("End point CPE check box is selected");
					
				}

				else {

					Log.info("Single Endpoint CPE is not selected");
					DriverTestcase.logger.log(LogStatus.INFO,"Single Endpoint CPE is not selected as per input provided");   
					
				}

			}
			
			
			if(!Email.equalsIgnoreCase("null")) {
				
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);
				

			}else {
				DriverTestcase.logger.log(LogStatus.INFO,"Input for Email field is not provided"); 
			}
			
			
			if(!PhoneContact.equalsIgnoreCase("null")) {
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);
			}else {
				DriverTestcase.logger.log(LogStatus.INFO,"Input for phone contact field is not provided"); 
			}
			
			
			if(!remark.equalsIgnoreCase("null")) {
				
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);
				
			}else {
				
				DriverTestcase.logger.log(LogStatus.INFO,"Input for remark field is not provided");
				}
			
			
			
			if(!PerformanceMonitoring.equalsIgnoreCase("null")) {
				
				if (PerformanceMonitoring.equalsIgnoreCase("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")));
					Log.info("performance monitoring check box is selected");
					
				}

				else {

					System.out.println("Performance monitoring is not selected");
					DriverTestcase.logger.log(LogStatus.INFO,"performance monitor checkbox is not selected as per input provided");
					
				}

				
			}



			if (!ProactiveMonitoring.equalsIgnoreCase("null")) {


				if (ProactiveMonitoring.equalsIgnoreCase("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
					Log.info("Pro active monitoring check box is selected");

					if (!notificationManagement.equalsIgnoreCase("null")) {
					Log.info("Notificationan Management dropdown displays when pro active monitoring is selected");
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
					Clickon(getwebelement("//span[contains(text(),'" + notificationManagement + "')]"));
					}else {
						DriverTestcase.logger.log(LogStatus.INFO,"Notification management dropdown value is not selected as per input provided");  
						
					}
					
				} else {

					Log.info("Pro active monitoring is not selected");
					System.out.println("pro active monitoring is not selected");
					DriverTestcase.logger.log(LogStatus.INFO,"performance monitor checkbox is not selected as per input provided");  
				}

			}

		
			if (!deliveryChannel.equalsIgnoreCase("null")) {


				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
				Clickon(getwebelement("//span[contains(text(),'" + deliveryChannel + "')]"));

			}else {
				DriverTestcase.logger.log(LogStatus.INFO,"Delivery channel dropdown value is not selected as per input provided"); 
			}
			
		if(interfaceSpd[0].equals("10")) {
			
			if (AggregateTraffic.equals("yes")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Aggregate_10Gig_1Gig_Traffic")));
				Log.info("Aggregate Traffic check box is selected");
				Thread.sleep(3000);
				
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
				Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
				Thread.sleep(2000);
				
				if(vpnTopology.equals("Hub&Spoke") || vpnTopology.equals("E-PN (Any-to-Any)")) {

					
						
						if (!CircuitReference.equalsIgnoreCase("null")) {
						SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
						}else {
							DriverTestcase.logger.log(LogStatus.FAIL,"Circuit reference field is mandatory, but no inputs has been provided");
						}

						
				}
				
				else {
					
					System.out.println("If aggregate traffic is selected,The available options under VPN topologies are: 'Hub&Spoke' and 'E-PN (Any-to-Any)' ");
				}
			}

			else if(!AggregateTraffic.equals("yes")) {

				Log.info("Aggregate Traffic check box is not selected");
			

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
			Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
			
			if(vpnTopology.equals("Point-to-Point")) {
				
				if (!intermediateTechnology.equalsIgnoreCase("null")) {
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")),
							intermediateTechnology);
					}else {
						DriverTestcase.logger.log(LogStatus.INFO,"Intermediate  Technology value is not Entered as per input provided");
					}
					
					if (!CircuitReference.equalsIgnoreCase("null")) {
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
					}else {
						DriverTestcase.logger.log(LogStatus.FAIL,"Circuit reference field is mandatory, but no inputs has been provided");
					}

					if (!CircuitType.equalsIgnoreCase("null")) {
					Clickon(getwebelement("//div[span[contains(text(),'" + CircuitType + "')]]//input"));
					}else {
						DriverTestcase.logger.log(LogStatus.INFO,"Circuit Type value is not Entered as per input provided");
					}

				
				
			}
			
			else if(vpnTopology.equals("E-PN (Any-to-Any)")) {

			
					
					if (!CircuitReference.equalsIgnoreCase("null")) {
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
					}else {
						DriverTestcase.logger.log(LogStatus.FAIL,"Circuit reference field is mandatory, but no inputs has been provided");
					}

					
				
			}
			
			
			else if(vpnTopology.equals("Hub&Spoke")) {

				Log.info("Circuit ref, circuit type and Intermediate tech fields are not available to enter value");
				System.out.println("circuit ref dropdowns is not available");
				
			}

			
	else {
				
				System.out.println(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
				Log.info(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
			}
			
			}
		}	
		
		
		
		if(interfaceSpd[0].equals("1")) {
			

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
			Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
			
			if(vpnTopology.equals("Point-to-Point")) {
				
				
				if (!intermediateTechnology.equalsIgnoreCase("null")) {
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")),
							intermediateTechnology);
					}else {
						DriverTestcase.logger.log(LogStatus.INFO,"Intermediate  Technology value is not Entered as per input provided");
					}
					
					if (!CircuitReference.equalsIgnoreCase("null")) {
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
					}else {
						DriverTestcase.logger.log(LogStatus.FAIL,"Circuit reference field is mandatory, but no inputs has been provided");
					}

					if (!CircuitType.equalsIgnoreCase("null")) {
					Clickon(getwebelement("//div[span[contains(text(),'" + CircuitType + "')]]//input"));
					}else {
						DriverTestcase.logger.log(LogStatus.INFO,"Circuit Type value is not Entered as per input provided");
					}

				
				
			}
			
			else if(vpnTopology.equals("E-PN (Any-to-Any)")) {

				
					
					if (!CircuitReference.equalsIgnoreCase("null")) {
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
					}else {
						DriverTestcase.logger.log(LogStatus.FAIL,"Circuit reference field is mandatory, but no inputs has been provided");
					}

					
				
			}
			
			
			else if(vpnTopology.equals("Hub&Spoke")) {

				Log.info("Circuit ref, circuit type and Intermediate tech fields are not available to enter value");
				System.out.println("circuit ref dropdowns is not available");
				
			}

			
	else {
				
				System.out.println(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
				Log.info(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
			}
	
		}
	
			
			
		
			
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

		}

		public void verifydataEnteredforDirectFibre(String application, String serviceype,
				String ServiceIdentificationNumber, String SelectSubService, String Interfacespeed, String EndpointCPE,
				String Email, String PhoneContact, String remark, String PerformanceMonitoring, String ProactiveMonitoring,
				String deliveryChannel, String ManagementOrder, String vpnTopology, String intermediateTechnology,
				String CircuitReference, String CircuitType) throws InterruptedException, IOException, DocumentException {

			String serviceidentify = Gettext(getwebelement(
					xml.getlocator("//locators/" + application + "/Viewcreatedservice_serviceIdentification")));
			sa.assertEquals(serviceidentify, ServiceIdentificationNumber,
					"serviceidentification number is displayed as expected");

			String servicetype = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_Servicetype")));
			sa.assertEquals(servicetype, serviceype, "servicetype is not displayed as expected");

			String servicesubType = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_servicesubtype")));
			sa.assertEquals(servicesubType, SelectSubService, "servicesubType is not displayed as expected");

			String interfaceSpeed = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_interfacespeed")));
			sa.assertEquals(interfaceSpeed, Interfacespeed, "interfaceSpeed is not displayed as expected");

			String cpe = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_SinplepointCPE")));
			sa.assertEquals(cpe, EndpointCPE, "cpe is not displayed as expected");

			String mail = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_email")));
			sa.assertEquals(mail, Email, "mail is displayed as expected");

			String Phone = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_phone")));
			sa.assertEquals(Phone, PhoneContact, "phone conatct is not displayed as expected");

			String Remark = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_remark")));
			sa.assertEquals(Remark, remark, " Remark is not displayed as expected");

			String perfoemreport = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_performReport")));
			sa.assertEquals(perfoemreport, PerformanceMonitoring, " Performance reporting is not displayed as expected");

			String promonitor = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_proactivemonitor")));
			sa.assertEquals(promonitor, ProactiveMonitoring, " pro active monitoring is not displayed as expected");

			String Deliverychanel = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_deliverychanel")));
			sa.assertEquals(Deliverychanel, deliveryChannel, "Deliverychanel is not displayed as expected");

//	        String NotifyManagement=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_notificationManagement")));
//	        sa.assertEquals(actual, expected, " is displayed not as expected");

			String manageOrder = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_managementorder")));
			sa.assertEquals(manageOrder, ManagementOrder, "ManagementOrder is not displayed as expected");

			String Vpntopology = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_vpnTopology")));
			sa.assertEquals(Vpntopology, vpnTopology, "vpnTopology is not displayed as expected");

			String circuitReferenceS = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_circuitreference")));
			sa.assertEquals(Vpntopology, CircuitReference, "CircuitReference is not displayed as expected");

			String circuittype = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_circuittype")));
			sa.assertEquals(circuittype, CircuitType, "CircuitType is not displayed as expected");

		}

		public void verifyDataenteredForLanlinkInternational(String application, String serviceType,
				String ServiceIdentificationNumber, String SelectSubService, String Interfacespeed, String EndpointCPE,
				String Email, String PhoneContact, String remark, String PerformanceMonitoring, String ProactiveMonitoring,
				String deliveryChannel, String AggregateTraffic, String vpnTopology, String intermediateTechnology,
				String CircuitReference, String CircuitType) throws InterruptedException, IOException, DocumentException {

			String serviceidentify = Gettext(getwebelement(
					xml.getlocator("//locators/" + application + "/Viewcreatedservice_serviceIdentification")));
			sa.assertEquals(serviceidentify, ServiceIdentificationNumber,
					"serviceidentification number is not displayed as expected");

			String servicetype = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_Servicetype")));
			sa.assertEquals(servicetype, serviceType, "servicetype is not displayed as expected");

			String servicesubType = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_servicesubtype")));
			sa.assertEquals(servicesubType, SelectSubService, "servicesubType is not displayed as expected");

			String interfaceSpeed = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_interfacespeed")));
			sa.assertEquals(interfaceSpeed, Interfacespeed, "interfaceSpeed is not displayed as expected");

			String cpe = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_SinplepointCPE")));
			sa.assertEquals(cpe, EndpointCPE, "cpe is not displayed as expected");

			String mail = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_email")));
			sa.assertEquals(mail, Email, "mail is not displayed as expected");

			String Phone = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_phone")));
			sa.assertEquals(Phone, PhoneContact, "phone conatct is not displayed as expected");

			String Remark = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_remark")));
			sa.assertEquals(Remark, remark, " Remark is not displayed as expected");

			String perfoemreport = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_performReport")));
			sa.assertEquals(perfoemreport, PerformanceMonitoring, " Performance reporting is not displayed as expected");

			String promonitor = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_proactivemonitor")));
			sa.assertEquals(promonitor, ProactiveMonitoring, " pro active monitoring is not displayed as expected");

			String Deliverychanel = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_deliverychanel")));
			sa.assertEquals(Deliverychanel, deliveryChannel, "Deliverychanel is not displayed as expected");

			String Vpntopology = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_vpnTopology")));
			sa.assertEquals(Vpntopology, vpnTopology, "vpnTopology is not displayed as expected");

			String circuitReferenceS = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_circuitreference")));
			sa.assertEquals(Vpntopology, CircuitReference, "CircuitReference is not displayed as expected");

			String circuittype = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_circuittype")));
			sa.assertEquals(circuittype, CircuitType, "CircuitType is not displayed as expected");

		}

		public void VerifyDataEnteredForLanlinkMetro(String application, String serviceType,
				String ServiceIdentificationNumber, String SelectSubService, String Interfacespeed, String EndpointCPE,
				String Email, String PhoneContact, String remark, String PerformanceMonitoring, String ProactiveMonitoring,
				String DeliveryChannelForselecttag, String vpnTopology, String intermediateTechnology,
				String CircuitReference, String CircuitType) throws InterruptedException, IOException, DocumentException {

			String serviceidentify = Gettext(getwebelement(
					xml.getlocator("//locators/" + application + "/Viewcreatedservice_serviceIdentification")));
			sa.assertEquals(serviceidentify, ServiceIdentificationNumber,
					"serviceidentification number is not displayed as expected");

			String servicetype = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_Servicetype")));
			sa.assertEquals(servicetype, serviceType, "servicetype is not displayed as expected");

			String servicesubType = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_servicesubtype")));
			sa.assertEquals(servicesubType, SelectSubService, "servicesubType is not displayed as expected");

			String interfaceSpeed = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_interfacespeed")));
			sa.assertEquals(interfaceSpeed, Interfacespeed, "interfaceSpeed is not displayed as expected");

			String cpe = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_SinplepointCPE")));
			sa.assertEquals(cpe, EndpointCPE, "cpe is not displayed as expected");

			String mail = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_email")));
			sa.assertEquals(mail, Email, "mail is not displayed as expected");

			String Phone = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_phone")));
			sa.assertEquals(Phone, PhoneContact, "phone conatct is not displayed as expected");

			String Remark = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_remark")));
			sa.assertEquals(Remark, remark, " Remark not displayed as expected");

			String perfoemreport = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_performReport")));
			sa.assertEquals(perfoemreport, PerformanceMonitoring, " Performance reporting is not displayed as expected");

			String promonitor = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_proactivemonitor")));
			sa.assertEquals(promonitor, ProactiveMonitoring, " pro active monitoring not displayed as expected");

			String Deliverychanel = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_deliverychanel")));
			sa.assertEquals(Deliverychanel, DeliveryChannelForselecttag, "Deliverychanel not displayed as expected");

			String Vpntopology = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_vpnTopology")));
			sa.assertEquals(Vpntopology, vpnTopology, "vpnTopology is not displayed as expected");

			String circuitReferenceS = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_circuitreference")));
			sa.assertEquals(Vpntopology, CircuitReference, "CircuitReference not displayed as expected");

			String circuittype = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_circuittype")));
			sa.assertEquals(circuittype, CircuitType, "CircuitType not displayed as expected");

		}

		public void verifydataEnteredForlanlinkNational(String application, String serviceType,
				String ServiceIdentificationNumber, String SelectSubService, String Interfacespeed, String EndpointCPE,
				String Email, String PhoneContact, String remark, String PerformanceMonitoring, String ProactiveMonitoring,
				String DeliveryChannelForselecttag, String AggregateTraffic, String vpnTopology,
				String intermediateTechnology, String CircuitReference, String CircuitType)
				throws InterruptedException, IOException, DocumentException {

			String serviceidentify = Gettext(getwebelement(
					xml.getlocator("//locators/" + application + "/Viewcreatedservice_serviceIdentification")));
			sa.assertEquals(serviceidentify, ServiceIdentificationNumber,
					"serviceidentification number is displayed as expected");

			String servicetype = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_Servicetype")));
			sa.assertEquals(servicetype, serviceType, "servicetype is not displayed as expected");

			String servicesubType = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_servicesubtype")));
			sa.assertEquals(servicesubType, SelectSubService, "servicesubType is not displayed as expected");

			String interfaceSpeed = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_interfacespeed")));
			sa.assertEquals(interfaceSpeed, Interfacespeed, "interfaceSpeed is not displayed as expected");

			String cpe = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_SinplepointCPE")));
			sa.assertEquals(cpe, EndpointCPE, "cpe is not displayed as expected");

			String mail = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_email")));
			sa.assertEquals(mail, Email, "mail is not displayed as expected");

			String Phone = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_phone")));
			sa.assertEquals(Phone, PhoneContact, "phone conatct is not displayed as expected");

			String Remark = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_remark")));
			sa.assertEquals(Remark, remark, " Remark is not displayed as expected");

			String perfoemreport = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_performReport")));
			sa.assertEquals(perfoemreport, PerformanceMonitoring, " Performance reporting is not displayed as expected");

			String promonitor = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_proactivemonitor")));
			sa.assertEquals(promonitor, ProactiveMonitoring, " pro active monitoring is not displayed as expected");

			String Deliverychanel = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_deliverychanel")));
			sa.assertEquals(Deliverychanel, DeliveryChannelForselecttag, "Deliverychanel is not displayed as expected");

			String Vpntopology = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_vpnTopology")));
			sa.assertEquals(Vpntopology, vpnTopology, "vpnTopology is not displayed as expected");

			String circuitReferenceS = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_circuitreference")));
			sa.assertEquals(Vpntopology, CircuitReference, "CircuitReference is not displayed as expected");

			String circuittype = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_circuittype")));
			sa.assertEquals(circuittype, CircuitType, "CircuitType is not displayed as expected");

		}

		public void verifydateForLanlink_outbandmanagement(String application, String serviceType,
				String ServiceIdentificationNumber, String SelectSubService, String Interfacespeed, String EndpointCPE,
				String Email, String PhoneContact, String remark, String Performancereporting, String ProactiveMonitoring,
				String ENNIcheckBox, String DeliveryChannelForselecttag, String Manageconnectiondropdown)
				throws InterruptedException, IOException, DocumentException {

			String serviceidentify = Gettext(getwebelement(
					xml.getlocator("//locators/" + application + "/Viewcreatedservice_serviceIdentification")));
			sa.assertEquals(serviceidentify, ServiceIdentificationNumber,
					"serviceidentification number is not displayed as expected");

			String servicetype = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_Servicetype")));
			sa.assertEquals(servicetype, serviceType, "servicetype is not displayed as expected");

			String servicesubType = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_servicesubtype")));
			sa.assertEquals(servicesubType, SelectSubService, "servicesubType is not displayed as expected");

			String interfaceSpeed = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_interfacespeed")));
			sa.assertEquals(interfaceSpeed, Interfacespeed, "interfaceSpeed is not displayed as expected");

			String cpe = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_SinplepointCPE")));
			sa.assertEquals(cpe, EndpointCPE, "cpe is not displayed as expected");

			String mail = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_email")));
			sa.assertEquals(mail, Email, "mail is not displayed as expected");

			String Phone = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_phone")));
			sa.assertEquals(Phone, PhoneContact, "phone conatct is not displayed as expected");

			String Remark = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_remark")));
			sa.assertEquals(Remark, remark, " Remark is not displayed as expected");

			String perfoemreport = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_performReport")));
			sa.assertEquals(perfoemreport, Performancereporting, " Performance reporting is not displayed as expected");

			String promonitor = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_proactivemonitor")));
			sa.assertEquals(promonitor, ProactiveMonitoring, " pro active monitoring is not displayed as expected");

			String Deliverychanel = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_deliverychanel")));
			sa.assertEquals(Deliverychanel, DeliveryChannelForselecttag, "Deliverychanel is not displayed as expected");

			String managementConnection = Gettext(getwebelement(
					xml.getlocator("//locators/" + application + "/viewcreatedservice_ManagementConnection")));
			sa.assertEquals(managementConnection, Manageconnectiondropdown, "Manageconnection is not displayed as expected");

			String enni = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/viewcreatedservice_ENNI")));
			sa.assertEquals(enni, ENNIcheckBox, "ENNI is not displayed as expected");

		}

		public void verifyDataEnteredForLanlink_OLO(String application, String serviceType,
				String ServiceIdentificationNumber, String SelectSubService, String Interfacespeed, String EndpointCPE,
				String Email, String PhoneContact, String remark, String PerformanceMonitoring, String ProactiveMonitoring,
				String ENNIcheckBox, String deliveryChannel, String ManagementOrder, String vpnTopology,
				String intermediateTechnology, String CircuitReference, String CircuitType)
				throws InterruptedException, IOException, DocumentException {

			String serviceidentify = Gettext(getwebelement(
					xml.getlocator("//locators/" + application + "/Viewcreatedservice_serviceIdentification")));
			sa.assertEquals(serviceidentify, ServiceIdentificationNumber,
					"serviceidentification number is not displayed as expected");

			String servicetype = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_Servicetype")));
			sa.assertEquals(servicetype, serviceType, "servicetype is not displayed as expected");

			String servicesubType = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_servicesubtype")));
			sa.assertEquals(servicesubType, SelectSubService, "servicesubType is not displayed as expected");

			String interfaceSpeed = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_interfacespeed")));
			sa.assertEquals(interfaceSpeed, Interfacespeed, "interfaceSpeed is not displayed as expected");

			String cpe = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_SinplepointCPE")));
			sa.assertEquals(cpe, EndpointCPE, "cpe is not displayed as expected");

			String mail = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_email")));
			sa.assertEquals(mail, Email, "mail is not displayed as expected");

			String Phone = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_phone")));
			sa.assertEquals(Phone, PhoneContact, "phone conatct is not displayed as expected");

			String Remark = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_remark")));
			sa.assertEquals(Remark, remark, " Remark is not displayed as expected");

			String perfoemreport = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_performReport")));
			sa.assertEquals(perfoemreport, PerformanceMonitoring, " Performance reporting is not displayed as expected");

			String promonitor = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_proactivemonitor")));
			sa.assertEquals(promonitor, ProactiveMonitoring, " pro active monitoring is not displayed as expected");

			String enni = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/viewcreatedservice_ENNI")));
			sa.assertEquals(enni, ENNIcheckBox, "ENNI is not displayed as expected");

			String Deliverychanel = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_deliverychanel")));
			sa.assertEquals(Deliverychanel, deliveryChannel, "Deliverychanel is not displayed as expected");

			String manageOrder = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_managementorder")));
			sa.assertEquals(manageOrder, ManagementOrder, "ManagementOrder is not displayed as expected");

			String Vpntopology = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_vpnTopology")));
			sa.assertEquals(Vpntopology, vpnTopology, "vpnTopology is not displayed as expected");

			String circuitReferenceS = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_circuitreference")));
			sa.assertEquals(Vpntopology, CircuitReference, "CircuitReference is not displayed as expected");

			String circuittype = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Viewcreatedservice_circuittype")));
			sa.assertEquals(circuittype, CircuitType, "CircuitType is not displayed as expected");

		}

		public void LanlinkMetro(String application, String ServiceIdentificationNumber, String SelectSubService,
				String Interfacespeed, String EndpointCPE, String Email, String PhoneContact, String remark,
				String PerformanceMonitoring, String ProactiveMonitoring, String deliveryChannel,
				String vpnTopology, String intermediateTechnology, String CircuitReference, String CircuitType, String notificationManagement)
				throws InterruptedException, IOException, DocumentException {
			 
			
	if(!ServiceIdentificationNumber.equalsIgnoreCase("null")) {
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
						ServiceIdentificationNumber);
				
			}else {
				DriverTestcase.logger.log(LogStatus.FAIL,"service identification value is a mandatory field and the input was not provided"); 
			
			}
			
			
			
			if(!EndpointCPE.equalsIgnoreCase("null")) {
				
				
				if (EndpointCPE.equals("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
					Log.info("End point CPE check box is selected");
					
				}

				else {

					Log.info("Sing Endpoint CPE is not selected");
					DriverTestcase.logger.log(LogStatus.INFO,"SingleEndPoint CPE is not selected as per input provided"); 
					
				}

			}
			
			
			if(!Email.equalsIgnoreCase("null")) {
				
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);
				

			}else {
				DriverTestcase.logger.log(LogStatus.INFO,"Email value is not entered as per input provided");
			}
			
			
			if(!PhoneContact.equalsIgnoreCase("null")) {
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);
			}else {
				DriverTestcase.logger.log(LogStatus.INFO,"phone contact value is not entered as per injput provided");
			}
			
			
			if(!remark.equalsIgnoreCase("null")) {
				
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);
				
			}else {
				
				DriverTestcase.logger.log(LogStatus.INFO,"remark field value is not entered as per input provided"); 
			}
			
			
			
			if(!PerformanceMonitoring.equalsIgnoreCase("null")) {
				
				if (PerformanceMonitoring.equalsIgnoreCase("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")));
					Log.info("performance monitoring check box is selected");
					
				}

				else {

					System.out.println("Performance monitoring is not selected");
					DriverTestcase.logger.log(LogStatus.INFO,"performance monitor checkbox is not selected as per input provided"); 
					
				}

				
			}



			if (!ProactiveMonitoring.equalsIgnoreCase("null")) {


				if (ProactiveMonitoring.equalsIgnoreCase("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
					Log.info("Pro active monitoring check box is selected");

					if (!notificationManagement.equalsIgnoreCase("null")) {
					Log.info("Notificationan Management dropdown displays when pro active monitoring is selected");
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
					Clickon(getwebelement("//span[contains(text(),'" + notificationManagement + "')]"));
					}else {
						DriverTestcase.logger.log(LogStatus.INFO,"Notification management dropdown value is not selected as per input provided");
						
					}
					
				} else {

					Log.info("Pro active monitoring is not selected");
					System.out.println("pro active monitoring is not selected");
					DriverTestcase.logger.log(LogStatus.INFO,"performance monitor checkbox is not selected as per input provided"); 
				}

			}

		
			if (!deliveryChannel.equalsIgnoreCase("null")) {


				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
				Clickon(getwebelement("//span[contains(text(),'" + deliveryChannel + "')]"));

			}else {
				DriverTestcase.logger.log(LogStatus.INFO,"Delivery channel dropdown value is not selected as per input"); 
			}

				if (!vpnTopology.equalsIgnoreCase("null")) {


					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
					Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
					
					if(vpnTopology.equals("Point-to-Point")) {
						
					
						SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")),
								intermediateTechnology);
						
						SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);


						Clickon(getwebelement("//div[span[contains(text(),'" + CircuitType + "')]]//input"));

						
						
					}
					
					else if(vpnTopology.equals("Hub&Spoke") || vpnTopology.equals("E-PN (Any-to-Any)")) {

						SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);

						
					}
					
					else {
						
						System.out.println(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
						Log.info(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
					}


				}

			
				

				
				
			
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

			
			
		 }

		
		
		
		public void LanlinkMetrowhenMSPisselected(String application, String ServiceIdentificationNumber, String SelectSubService,
				String Interfacespeed, String EndpointCPE, String Email, String PhoneContact, String remark,
				String PerformanceMonitoring, String ProactiveMonitoring, String deliveryChannel,
				String vpnTopology, String intermediateTechnology, String CircuitReference, String CircuitType, String notificationManagement)
				throws InterruptedException, IOException, DocumentException {
			

			 
			if(!ServiceIdentificationNumber.equalsIgnoreCase("null")) {
							
							SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
									ServiceIdentificationNumber);
							
						}
						
						
						
						if(!EndpointCPE.equalsIgnoreCase("null")) {
							
							
							if (EndpointCPE.equals("yes")) {

								Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
								Log.info("End point CPE check box is selected");
							}

							else {

								Log.info("Sing Endpoint CPE is not selected");
							}

						}
						
						
						if(!Email.equalsIgnoreCase("null")) {
							
							SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);

						}
						
						
						if(!PhoneContact.equalsIgnoreCase("null")) {
							
							SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);

							
						}
						
						
						if(!remark.equalsIgnoreCase("null")) {
								
							SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);

							
						}
						
						
						
				if(!PerformanceMonitoring.equalsIgnoreCase("null")) {
							
							if (PerformanceMonitoring.equalsIgnoreCase("yes")) {

								Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")));
								Log.info("performance monitoring check box is selected");
							}

							else {

								System.out.println("Performance monitoring is not selected");
							}

							
						}



						if (!ProactiveMonitoring.equalsIgnoreCase("null")) {

		
							if (ProactiveMonitoring.equalsIgnoreCase("yes")) {

								Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
								Log.info("Pro active monitoring check box is selected");

								Log.info("Notificationan Management dropdown displays when pro active monitoring is selected");
								Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
								Clickon(getwebelement("//span[contains(text(),'" + notificationManagement + "')]"));

							} else {

								Log.info("Pro active monitoring is not selected");
								System.out.println("pro active monitoring is not selected");
							}

						}

					
						if (!deliveryChannel.equalsIgnoreCase("null")) {

							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
							Clickon(getwebelement("//span[contains(text(),'" + deliveryChannel + "')]"));


						}

						if (!vpnTopology.equalsIgnoreCase("null")) {


							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
							Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
							
							if(vpnTopology.equals("Point-to-Point")) {
								
							
								SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")),
										intermediateTechnology);
								
								SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);


								Clickon(getwebelement("//div[span[contains(text(),'" + CircuitType + "')]]//input"));

								
								
							}
							
							else if(vpnTopology.equals("Hub&Spoke") || vpnTopology.equals("E-PN (Any-to-Any)")) {

								SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);

								
							}
							
							else {
								
								System.out.println(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
								Log.info(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
							}


						}

					
						

						
						
					
					
					
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

					
				 
		}

		
		
		public void lanlinkNational(String application, String ServiceIdentificationNumber, String SelectSubService,
				String Interfacespeed, String EndpointCPE, String Email, String PhoneContact, String remark,
				String PerformanceMonitoring, String ProactiveMonitoring, String deliveryChannel,
				String AggregateTraffic, String vpnTopology, String intermediateTechnology, String CircuitReference,
				String CircuitType, String notificationManagement) throws InterruptedException, IOException, DocumentException {

			String[] interfaceSpd=Interfacespeed.split(" ");
			
	if(!ServiceIdentificationNumber.equalsIgnoreCase("null")) {
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
						ServiceIdentificationNumber);
				
			}else {
				DriverTestcase.logger.log(LogStatus.INFO,"service identification value is not entered as per input provided");
			}
			
			
			
			if(!EndpointCPE.equalsIgnoreCase("null")) {
				
				
				if (EndpointCPE.equals("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
					Log.info("End point CPE check box is selected");
					
				}

				else {

					Log.info("Sing Endpoint CPE is not selected");
					DriverTestcase.logger.log(LogStatus.INFO,"SingleEndPoint CPE is not selected as per input"); 
					
				}

			}
			
			
			if(!Email.equalsIgnoreCase("null")) {
				
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);
				

			}else {
				DriverTestcase.logger.log(LogStatus.INFO,"Email value is not entered as per input provided"); 
			}
			
			
			if(!PhoneContact.equalsIgnoreCase("null")) {
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);
			}else {
//				DriverTestcase.logger.log(LogStatus.INFO,"phone contact value is not e 
			}
			
			
			if(!remark.equalsIgnoreCase("null")) {
				
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);
				
			}else {
				
//				DriverTestcase.logger.log(LogStatus.INFO,"remark field value is not e 
			}
			
			
			
			if(!PerformanceMonitoring.equalsIgnoreCase("null")) {
				
				if (PerformanceMonitoring.equalsIgnoreCase("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")));
					Log.info("performance monitoring check box is selected");
					
				}

				else {

					System.out.println("Performance monitoring is not selected");
//					DriverTestcase.logger.log(LogStatus.INFO,"performance monitor checkbox is not  
					
				}

				
			}



			if (!ProactiveMonitoring.equalsIgnoreCase("null")) {


				if (ProactiveMonitoring.equalsIgnoreCase("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
					Log.info("Pro active monitoring check box is selected");

					if (!notificationManagement.equalsIgnoreCase("null")) {
					Log.info("Notificationan Management dropdown displays when pro active monitoring is selected");
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
					Clickon(getwebelement("//span[contains(text(),'" + notificationManagement + "')]"));
					}else {
						DriverTestcase.logger.log(LogStatus.INFO,"Notification management dropdown value is not selected as per input");  
						
					}
					
				} else {

					Log.info("Pro active monitoring is not selected");
					System.out.println("pro active monitoring is not selected");
				}

			}

		
			if (!deliveryChannel.equalsIgnoreCase("null")) {


				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
				Clickon(getwebelement("//span[contains(text(),'" + deliveryChannel + "')]"));

			}else {
				DriverTestcase.logger.log(LogStatus.INFO,"Delivery channel dropdown value is not selected as per inoput provided"); 
			}
			
			if(interfaceSpd[0].equals("10")) {
				
				if (AggregateTraffic.equals("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Aggregate_10Gig_1Gig_Traffic")));
					Log.info("Aggregate Traffic check box is selected");
					Thread.sleep(3000);
					
					
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
					Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
					Thread.sleep(2000);
					
					if(vpnTopology.equals("Hub&Spoke") || vpnTopology.equals("E-PN (Any-to-Any)")) {

						SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);

						
					}
					
					else {
						
						System.out.println("If aggregate traffic is selected,The available options under VPN topologies are: 'Hub&Spoke' and 'E-PN (Any-to-Any)' ");
					}
				}

				else if(!AggregateTraffic.equals("yes")) {

					Log.info("Aggregate Traffic check box is not selected");
				

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
				Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
				
				if(vpnTopology.equals("Point-to-Point")) {
					
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")),
							intermediateTechnology);
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);


					Clickon(getwebelement("//div[span[contains(text(),'" + CircuitType + "')]]//input"));

					
					
				}
				
				else if(vpnTopology.equals("E-PN (Any-to-Any)")) {

					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);

					
				}
				
				
				else if(vpnTopology.equals("Hub&Spoke")) {

					Log.info("Circuit ref, circuit type and Intermediate tech fields are not available to enter value");
					System.out.println("circuit ref dropdowns is not available");
					
				}

				
		else {
					
					System.out.println(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
					Log.info(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
				}
				
				}
			}	
			
			
			
			if(interfaceSpd[0].equals("1")) {
				

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
				Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
				
				if(vpnTopology.equals("Point-to-Point")) {
					
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")),
							intermediateTechnology);
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);


					Clickon(getwebelement("//div[span[contains(text(),'" + CircuitType + "')]]//input"));

					
					
				}
				
				else if(vpnTopology.equals("E-PN (Any-to-Any)")) {

					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);

					
				}
				
				
				else if(vpnTopology.equals("Hub&Spoke")) {

					Log.info("Circuit ref, circuit type and Intermediate tech fields are not available to enter value");
					System.out.println("circuit ref dropdowns is not available");
					
				}

				
		else {
					
					System.out.println(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
					Log.info(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
				}
		
			}

			
			
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

		}
		
		
		
		
		public void lanlinkNationalwhenMSpisselected(String application, String ServiceIdentificationNumber, String SelectSubService,
				String Interfacespeed, String EndpointCPE, String Email, String PhoneContact, String remark,
				String PerformanceMonitoring, String ProactiveMonitoring, String deliveryChannel,
				String AggregateTraffic, String vpnTopology, String intermediateTechnology, String CircuitReference,
				String CircuitType, String notificationManagement) throws InterruptedException, IOException, DocumentException {

				
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
					ServiceIdentificationNumber);

			if (EndpointCPE.equals("yes")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
				Log.info("End point CPE check box is selected");
			}

			else {

				Log.info("Sing Endpoint CPE is not selected");
			}

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);

			if (PerformanceMonitoring.equals("yes")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")));
				Log.info("performance reporting check box is selected");
			}

			else {

				System.out.println("Performance reporting is not selected");
			}

			if (ProactiveMonitoring.equals("yes")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
				Log.info("Pro active monitoring check box is selected");
				
				Log.info("Notificationan Management dropdown displays when pro active monitoring is selected");
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
				Clickon(getwebelement("//span[contains(text(),'" + notificationManagement + "')]"));

				
			}

			else {

				Log.info("Pro active monitoring is not selected");
			}

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
			Clickon(getwebelement("//span[contains(text(),'" + deliveryChannel + "')]"));

		

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
			Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
			
			if(vpnTopology.equals("Point-to-Point")) {
				
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")),
						intermediateTechnology);
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);


				Clickon(getwebelement("//div[span[contains(text(),'" + CircuitType + "')]]//input"));

				
				
			}
			
			else if(vpnTopology.equals("E-PN (Any-to-Any)")) {

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);

				
			}
			
			
			else if(vpnTopology.equals("Hub&Spoke")) {

	            Log.info("when Modular msp checkbox is selected and hub&spoke gets selected under VPN topology dropdown"
	            		+ "ciruit type, circuit reference, Intermediate Technology fields will not be displayed");
				
			}
			
	else {
				
				System.out.println(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
				Log.info(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
			}
			
			
			
						
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

		}

		
		public void EditlanlinkNationalwhenMSpisselected(String application, String ServiceIdentificationNumber, String SelectSubService,
				String Interfacespeed, String EndpointCPE, String Email, String PhoneContact, String remark,
				String PerformanceMonitoring, String ProactiveMonitoring, String deliveryChannel,
				String AggregateTraffic, String vpnTopology, String intermediateTechnology, String CircuitReference,
				String CircuitType, String notificationManagement) throws InterruptedException, IOException, DocumentException {
			
			
			
			
		}

		
		public void Lanlink_outbandmanagement(String application, String ServiceIdentificationNumber,
				String SelectSubService, String Interfacespeed, String EndpointCPE, String Email, String PhoneContact,
				String remark, String PerformanceReporting, String ProactiveMonitoring, String ENNIcheckBox,
				String deliveryChannel, String Manageconnectiondropdown, String notificationManagement)
				throws InterruptedException, IOException, DocumentException {
			

			
			
			
if(!ServiceIdentificationNumber.equalsIgnoreCase("null")) {
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
						ServiceIdentificationNumber);
				
			}else {
//				DriverTestcase.logger.log(LogStatus.INFO,"service identification value is not e 
			}
			
			
			
			if(!EndpointCPE.equalsIgnoreCase("null")) {
				
				
				if (EndpointCPE.equals("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
					Log.info("End point CPE check box is selected");
					
				}

				else {

					Log.info("Sing Endpoint CPE is not selected");
//					DriverTestcase.logger.log(LogStatus.INFO,"SingleEndPoint CPE is not  
					
				}

			}
			
			
			if(!Email.equalsIgnoreCase("null")) {
				
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);
				

			}else {
//				DriverTestcase.logger.log(LogStatus.INFO,"Email value is not e 
			}
			
			
			if(!PhoneContact.equalsIgnoreCase("null")) {
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);
			}else {
//				DriverTestcase.logger.log(LogStatus.INFO,"phone contact value is not e 
			}
			
			
			if(!remark.equalsIgnoreCase("null")) {
				
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);
				
			}else {
				
//				DriverTestcase.logger.log(LogStatus.INFO,"remark field value is not e 
			}
			
			
			
			if(!PerformanceReporting.equalsIgnoreCase("null")) {
				

				if (PerformanceReporting.equals("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performanceReportingcheckbox")));
					Log.info("performance reporting check box is selected");

				}

				else {

					System.out.println("Performance reporting is not selected");
//					DriverTestcase.logger.log(LogStatus.INFO,"performance monitor checkbox is not  

				}

				
			}
			
			

		if (!ProactiveMonitoring.equalsIgnoreCase("null")) {


			if (ProactiveMonitoring.equalsIgnoreCase("yes")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
				Log.info("Pro active monitoring check box is selected");

				if (!notificationManagement.equalsIgnoreCase("null")) {
				Log.info("Notificationan Management dropdown displays when pro active monitoring is selected");
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
				Clickon(getwebelement("//span[contains(text(),'" + notificationManagement + "')]"));
				}else {
//					DriverTestcase.logger.log(LogStatus.INFO,"Notification management dropdown value is not  
					
				}
				
			} else {

				Log.info("Pro active monitoring is not selected");
				System.out.println("pro active monitoring is not selected");
//				DriverTestcase.logger.log(LogStatus.INFO,"performance monitor checkbox is not selected as per inout provided"); 
			}

		}
	
		
			
			if(!ENNIcheckBox.equalsIgnoreCase("null")) {
				

				if (ENNIcheckBox.equals("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ENNIcheckbox")));
					Log.info("ENNI check box is selected");

				} else {

					Log.info("ENNI check box is not selected");
//					DriverTestcase.logger.log(LogStatus.INFO,"ENNI checkbox is not  

				}
				
			}
			

			if (!deliveryChannel.equalsIgnoreCase("null")) {


				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
				Clickon(getwebelement("//span[contains(text(),'" + deliveryChannel + "')]"));

			}else {
//				DriverTestcase.logger.log(LogStatus.INFO,"Delivery channel dropdown value is not  
			}

			
			if (!Manageconnectiondropdown.equalsIgnoreCase("null")) {


				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/managementconnection")));
				Clickon(getwebelement("//div[contains(text(),'" + Manageconnectiondropdown + "')]"));
				
			}else {
//				DriverTestcase.logger.log(LogStatus.INFO,"Management connection dropdown value is  
			}

			

			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

		
		}

		public void Lanlink_OLO(String application, String ServiceIdentificationNumber, String SelectSubService,
				String Interfacespeed, String EndpointCPE, String Email, String PhoneContact, String remark,
				String PerformanceMonitoring, String ProactiveMonitoring, String ENNIcheckBox, String deliveryChannel,
				String ManagementOrder, String vpnTopology, String intermediateTechnology, String CircuitReference,
				String CircuitType, String notificationManagement) throws InterruptedException, IOException, DocumentException {

			
			
			if(!ServiceIdentificationNumber.equalsIgnoreCase("null")) {
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
						ServiceIdentificationNumber);
				
			}
			
			
			
			if(!EndpointCPE.equalsIgnoreCase("null")) {
				
				if (EndpointCPE.equals("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
					Log.info("End point CPE check box is selected");
				}

				else {

					Log.info("Sing Endpoint CPE is not selected");
				}

			}
			
			
			if(!Email.equalsIgnoreCase("null")) {
				
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);

			}
			
			
			if(!PhoneContact.equalsIgnoreCase("null")) {
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);

				
			}
			
			
			if(!remark.equalsIgnoreCase("null")) {
				
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);

				
			}
			
			
			
			if(!PerformanceMonitoring.equalsIgnoreCase("null")) {
				
				if (PerformanceMonitoring.equalsIgnoreCase("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")));
					Log.info("performance monitoring check box is selected");
				}

				else {

					System.out.println("Performance monitoring is not selected");
				}

				
			}
			
			

		if(!ENNIcheckBox.equalsIgnoreCase("null")) {
				
				
			if (ENNIcheckBox.equals("yes")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ENNIcheckbox")));
				Log.info("ENNI check box is selected");
			} else {

				Log.info("ENNI check box is not selected");
			}


				
		}



			if (!ProactiveMonitoring.equalsIgnoreCase("null")) {


				if (ProactiveMonitoring.equalsIgnoreCase("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
					Log.info("Pro active monitoring check box is selected");

					Log.info("Notificationan Management dropdown displays when pro active monitoring is selected");
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
					Clickon(getwebelement("//span[contains(text(),'" + notificationManagement + "')]"));

				} else {

					Log.info("Pro active monitoring is not selected");
					System.out.println("pro active monitoring is not selected");
				}

			}

		
			if (!deliveryChannel.equalsIgnoreCase("null")) {


				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
				Clickon(getwebelement("//span[contains(text(),'" + deliveryChannel + "')]"));


			}

			if (!ManagementOrder.equalsIgnoreCase("null")) {


				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/managementOrder")), ManagementOrder);

			}

			if (!vpnTopology.equalsIgnoreCase("null")) {


				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
				Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
				
				if(vpnTopology.equals("Point-to-Point")) {
					
				
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")),
							intermediateTechnology);
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);


					Clickon(getwebelement("//div[span[contains(text(),'" + CircuitType + "')]]//input"));

					
					
				}
				
				else if(vpnTopology.equals("Hub&Spoke") || vpnTopology.equals("E-PN (Any-to-Any)")) {

					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);

					
				}
				
				else {
					
					System.out.println(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
					Log.info(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
				}


			}

		
			

		 
		
		
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

		}
		
		
		
		public void Lanlink_OLOwhenMSPisselected(String application, String ServiceIdentificationNumber, String SelectSubService,
				String Interfacespeed, String EndpointCPE, String Email, String PhoneContact, String remark,
				String PerformanceMonitoring, String ProactiveMonitoring, String ENNIcheckBox, String deliveryChannel,
				String ManagementOrder, String vpnTopology, String intermediateTechnology, String CircuitReference,
				String CircuitType, String notificationManagement) throws InterruptedException, IOException, DocumentException {
			


			
			
			if(!ServiceIdentificationNumber.equalsIgnoreCase("null")) {
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
						ServiceIdentificationNumber);
				
			}
			
			
			
			if(!EndpointCPE.equalsIgnoreCase("null")) {
				
				if (EndpointCPE.equals("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
					Log.info("End point CPE check box is selected");
				}

				else {

					Log.info("Sing Endpoint CPE is not selected");
				}

			}
			
			
			if(!Email.equalsIgnoreCase("null")) {
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);

			}
			
			
			if(!PhoneContact.equalsIgnoreCase("null")) {
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);

				
			}
			
			
			if(!remark.equalsIgnoreCase("null")) {
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);

				
			}
			
			
			
			if(!PerformanceMonitoring.equalsIgnoreCase("null")) {
				
				if (PerformanceMonitoring.equalsIgnoreCase("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")));
					Log.info("performance monitoring check box is selected");
				}

				else {

					System.out.println("Performance monitoring is not selected");
				}

				
			}
			
			

		if(!ENNIcheckBox.equalsIgnoreCase("null")) {
				
				
			if (ENNIcheckBox.equals("yes")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ENNIcheckbox")));
				Log.info("ENNI check box is selected");
			} else {

				Log.info("ENNI check box is not selected");
			}


				
		}



			if (!ProactiveMonitoring.equalsIgnoreCase("null")) {


				if (ProactiveMonitoring.equalsIgnoreCase("yes")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
					Log.info("Pro active monitoring check box is selected");

					Log.info("Notificationan Management dropdown displays when pro active monitoring is selected");
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
					Clickon(getwebelement("//span[contains(text(),'" + notificationManagement + "')]"));

				} else {

					Log.info("Pro active monitoring is not selected");
					System.out.println("pro active monitoring is not selected");
				}

			}

		
			if (!deliveryChannel.equalsIgnoreCase("null")) {


				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
				Clickon(getwebelement("//span[contains(text(),'" + deliveryChannel + "')]"));


			}

			if (!ManagementOrder.equalsIgnoreCase("null")) {


				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/managementOrder")), ManagementOrder);

			}

			if (!vpnTopology.equalsIgnoreCase("null")) {


				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
				Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
				
				if(vpnTopology.equals("Point-to-Point")) {
					
				
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")),
							intermediateTechnology);
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);


					Clickon(getwebelement("//div[span[contains(text(),'" + CircuitType + "')]]//input"));

					
					
				}
				
				else if(vpnTopology.equals("Hub&Spoke") || vpnTopology.equals("E-PN (Any-to-Any)")) {

					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);

					
				}
				
				else {
					
					System.out.println(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
					Log.info(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
				}


			}

		
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

		
		}


		public void Fieldvalidation_DirectFibre(String application, String serviceType, String SelectSubService,
				String Interfacespeed,String proActivemonitoring, String vpntopology) throws InterruptedException, DocumentException, IOException {

			
			String[] deliverychannel = { "--", "Retail", "Reseller" };

			String[] VPNtopology = { "Point-to-Point", "Hub&Spoke", "E-PN (Any-to-Any)" };

			String[] Circuittype = { "Default", "Composite Circuit", "Extended Circuit" };
			
			String[] notifyManagement= {"--", "Retail", "Reseller"}; 
			 

			boolean serviceIdentificationField, ServiceType, ServiceSubtype, interfacespeed, singleendpointCPE, email,
					phone, remark, performanceMonitor, deliveryChanel, proactiveMonitor, Managementorder, vpnTopology,
					intermediateTechnology, circuitref, circuitType, okButton, cancelButton, AggregateTraffic;
      
			try {	
			
		//service Identification	
			
			serviceIdentificationField = getwebelement(
					xml.getlocator("//locators/" + application + "/ServiceIdentification")).isDisplayed();
			sa.assertTrue(serviceIdentificationField, "Service identification field is displayed");
//			sa.assertAll();
//			DriverTestcase.logger.log(LogStatus.PASS, "Service Identification field is displaying under Create service page");
//           }catch(AssertionError e) {
//        	 e.printStackTrace();
//        	 DriverTestcase.logger.log(LogStatus.FAIL, "Service Identification field is not displaying under Create service page");
//           }
        	   
	
         //Service type  
//			try {
			ServiceType = (getwebelement("//div[contains(text(),'" + application + "')]")).isDisplayed();
			sa.assertTrue(ServiceType, "Service type is displayed as expected");
//			sa.assertAll();
//			DriverTestcase.logger.log(LogStatus.PASS, "Service Type field is displaying under Create service page");
//           }catch(AssertionError e) {
//        	 e.printStackTrace();
//        	 DriverTestcase.logger.log(LogStatus.FAIL, "Service Type field is not displaying under Create service page");
//           }
			
		
		//Service subtype	
//			try {
			ServiceSubtype = getwebelement("//div[contains(text(),'" + SelectSubService + "')]").isDisplayed();
			sa.assertTrue(ServiceSubtype, "Service subtype is displayed as expected");
//			sa.assertAll();
//			DriverTestcase.logger.log(LogStatus.PASS, "Service subtype field is displaying under Create service page");
//           }catch(AssertionError e) {
//        	 e.printStackTrace();
//        	 DriverTestcase.logger.log(LogStatus.FAIL, "Service subtype field is not displaying under Create service page");
//           }
			
		
		//Interface speed 	
//			try {
			String interfacespeedautopopulatedvalue=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/interfacespeedvaluepopulated")));
			sa.assertEquals(interfacespeedautopopulatedvalue, Interfacespeed, "Interface speed dropdown is not displaying as expected");
//			sa.assertAll();
//			DriverTestcase.logger.log(LogStatus.PASS, "Interface speed dropdown is displaying under Create service page");
//           }catch(AssertionError e) {
//        	 e.printStackTrace();
//        	 DriverTestcase.logger.log(LogStatus.FAIL, "Interface speed dropdown is not displaying under Create service page");
//           }
			
		
		//Single endpoint cpe	
//			try {
			singleendpointCPE = getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")).isDisplayed();
			sa.assertTrue(singleendpointCPE, "single End point CPE checkbox is disabled by default as expected");
//			sa.assertAll();
//			DriverTestcase.logger.log(LogStatus.PASS, "Single Endpoint CPE checkbox is displaying under Create service page");
//           }catch(AssertionError e) {
//        	 e.printStackTrace();
//        	 DriverTestcase.logger.log(LogStatus.FAIL, "Single Endpoint CPE checkbox is not displaying under Create service page");
//           }
		
			
		//Email	
//			try {
			email = getwebelement(xml.getlocator("//locators/" + application + "/Email")).isDisplayed();
			sa.assertTrue(email, "email field is displayed");
//			sa.assertAll();
//			DriverTestcase.logger.log(LogStatus.PASS, "Email field is displaying under Create service page");
//           }catch(AssertionError e) {
//        	 e.printStackTrace();
//        	 DriverTestcase.logger.log(LogStatus.FAIL, "Email field is not displaying under Create service page");
//           }
			
		//phone	
//			try {
			phone = getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")).isDisplayed();
			sa.assertTrue(phone, "phone contact field is displayed as expected");
//			sa.assertAll();
//			DriverTestcase.logger.log(LogStatus.PASS, "phone contact field is displaying under Create service page");
//           }catch(AssertionError e) {
//        	 e.printStackTrace();
//        	 DriverTestcase.logger.log(LogStatus.FAIL, "phone conatct field is not displaying under Create service page");
//           }
			
	  //remark
//			try {
			remark = getwebelement(xml.getlocator("//locators/" + application + "/Remark")).isDisplayed();
			sa.assertTrue(remark, "remark field si displayed as expected");
//			sa.assertAll();
//			DriverTestcase.logger.log(LogStatus.PASS,"remark field is displaying under Create service page");
//           }catch(AssertionError e) {
//        	 e.printStackTrace();
//        	 DriverTestcase.logger.log(LogStatus.FAIL, "remark field is not displaying under Create service page");
//           }
			
		//performance monitoring			
//			try {
			performanceMonitor = getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring"))
					.isDisplayed();
			sa.assertTrue(performanceMonitor,
					"performance monitoring checbox is displayed and by default not selected as expected");
//			sa.assertAll();
//			DriverTestcase.logger.log(LogStatus.PASS, "performance monitor is displaying under Create service page");
//           }catch(AssertionError e) {
//        	 e.printStackTrace();
//        	 DriverTestcase.logger.log(LogStatus.FAIL, "performance monitor is not displaying under Create service page");
//           }
			
			//proactive monitoring			
//			try {
			proactiveMonitor = getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring"))
					.isDisplayed();
			sa.assertTrue(proactiveMonitor,
					"pro active monitoring checkbox is displayed and by default not selected as expected");
//			sa.assertAll();
//			DriverTestcase.logger.log(LogStatus.PASS, "proactive monitor checkbox is displaying under Create service page");
//           }catch(AssertionError e) {
//        	 e.printStackTrace();
//        	 DriverTestcase.logger.log(LogStatus.FAIL, "proactive monitor is not displaying under Create service page");
//           }
			
		
		if(proActivemonitoring.equalsIgnoreCase("yes")) {
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
			Log.info("Pro active monitoring check box is selected");
		
		boolean notificationManagement=getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement"))
		.isDisplayed();
		sa.assertTrue(notificationManagement, "Notification management dropdown gets displayed when proactive monitoring is selected");
		Log.info("Notification management dropdown gets displayed when proactive monitoring is selected");
		
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
		try {
			List<WebElement> listofnotificationmanagement = driver
					.findElements(By.xpath("//span[@role='list']//span[@role='option']"));
			for (WebElement notificationmanagementtypes : listofnotificationmanagement) {

				boolean match = false;
				for (int i = 0; i < notifyManagement.length; i++) {
					if (notificationmanagementtypes.getText().equals(notifyManagement[i])) {
						match = true;
						Log.info("list of notification management are : " + notificationmanagementtypes.getText());
						DriverTestcase.logger.log(LogStatus.PASS,"list of notification management are : " + notificationmanagementtypes.getText());
					}
				}
				sa.assertTrue(match);
				
			}
	      }catch(Exception e) {
	    	  Log.info("Notification Management dropdown values are mismatching");
	    	  e.printStackTrace();
	    	  DriverTestcase.logger.log(LogStatus.FAIL,"  values in Notification management dropdown under Direct Fiber service subtype is not displaying as expected");
	      }
		}else {
		
		Log.info("Notification management dropdown is not available as proactive monitoring is not selected");
		DriverTestcase.logger.log(LogStatus.INFO,"Notification management dropdown is not available as proactive monitoring is not selected");
		}
		
		
// delivery channel
//		try {
		deliveryChanel = getwebelement(xml.getlocator("//locators/" + application + "/deliverychannel_withclasskey")).isDisplayed();
			sa.assertTrue(deliveryChanel, "delivery channel dropdown is displayed");
//				sa.assertAll();
//				DriverTestcase.logger.log(LogStatus.PASS, "Delivery channel dropdown is displaying under Create service page");
//	           }catch(AssertionError e) {
//	        	 e.printStackTrace();
//	        	 DriverTestcase.logger.log(LogStatus.FAIL, "Delivery channel dropdown is not displaying under Create service page");
//	           }
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/deliverychannel_withclasskey")));
	    try {
			List<WebElement> listofdeliverychannel = driver
					.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement deliverychanneltypes : listofdeliverychannel) {

				boolean match = false;
				for (int i = 0; i < deliverychannel.length; i++) {
					if (deliverychanneltypes.getText().equals(deliverychannel[i])) {
						match = true;
						Log.info("list of delivery channel are : " + deliverychanneltypes.getText());
						DriverTestcase.logger.log(LogStatus.INFO," List of Delivery channel dropdown values under Direct Fiber service subtype are: "+deliverychanneltypes.getText());	
						
					}
				}
				sa.assertTrue(match);
			}
//			sa.assertAll();
//	    }catch(AssertionError error) {
//	    	
//	    	error.printStackTrace();
//	    	DriverTestcase.logger.log(LogStatus.FAIL, "delivery channel dropdown values are mismatching");
//	    
		}catch(Exception e) {
	    	e.printStackTrace();
	    	Log.info("delivery channel dropdown values are mismatching");
	    	DriverTestcase.logger.log(LogStatus.FAIL,"  values in delivery channel dropdowns under Direct Fiber service subtype are not displaying as expected");
	    }

//	    try {
			Managementorder = getwebelement(xml.getlocator("//locators/" + application + "/managementOrder")).isDisplayed();
			sa.assertTrue(Managementorder, "management order field is displayed");
//			sa.assertAll();
//			DriverTestcase.logger.log(LogStatus.PASS, "management order field is displaying under Create service page");
//           }catch(AssertionError e) {
//        	 e.printStackTrace();
//        	 DriverTestcase.logger.log(LogStatus.FAIL, "management order field is not displaying under Create service page");
//           }
			
	    
//	    try {
			vpnTopology = getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")).isDisplayed();
			sa.assertTrue(vpnTopology, "vpn topology dropdown is displayed");
//			sa.assertAll();
//			DriverTestcase.logger.log(LogStatus.PASS, "vpn topology dropdown is displaying under Create service page");
//           }catch(AssertionError e) {
//        	 e.printStackTrace();
//        	 DriverTestcase.logger.log(LogStatus.FAIL, "vpn topology dropdown is not displaying under Create service page");
//           }
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
			
			try {
			List<WebElement> listofvpntopology = driver.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement vpntopologytyeps : listofvpntopology) {

				boolean match = false;
				for (int i = 0; i < VPNtopology.length; i++) {
					if (vpntopologytyeps.getText().equals(VPNtopology[i])) {
						match = true;
						Log.info("list of vpn topologies are : " + vpntopologytyeps.getText());
						System.out.println("list of vpn topologies: "+vpntopologytyeps.getText());
						DriverTestcase.logger.log(LogStatus.INFO,"list of vpn topologies: "+vpntopologytyeps.getText());
						
					}
				}
				sa.assertTrue(match);
			}
			}catch(Exception e) {
				e.printStackTrace();
				Log.info("vpn topology dropdown values are mismatching");
			}
			
			
			Clickon(getwebelement("//span[contains(text(),'"+vpntopology +"')]"));
			Thread.sleep(3000);
			
			
			if(vpntopology.equals("Hub&Spoke") || vpntopology.equals("E-PN (Any-to-Any)")) {
				

				
				Log.info("Under 'VPN Topology', When 'Hub&Spoke' or 'E-PN (Any-to-Any)' are selected, 'Circuit type' and 'Intermediate technology' should get disapper"
						+ "only Circuit reference field should occur ");
				
				DriverTestcase.logger.log(LogStatus.INFO,"Under 'VPN Topology', When 'Hub&Spoke' or 'E-PN (Any-to-Any)' are selected, 'Circuit type' and 'Intermediate technology' should get disapper"
						+ "Only circuit reference should display ");
				
//				try {
				circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).isDisplayed();
				sa.assertTrue(circuitref, "circuit reference field is displayed");
//				sa.assertAll();
//				DriverTestcase.logger.log(LogStatus.PASS, "Circuit reference field is displaying under Create service page");
//	           }catch(AssertionError e) {
//	        	 e.printStackTrace();
//	        	 DriverTestcase.logger.log(LogStatus.FAIL, "Circuit reference field is not displaying under Create service page");
//	           }
				
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));
				
				boolean CircuitReferencepopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")).isDisplayed();
				
			    while(CircuitReferencepopupalertmsg)	{
				String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
				System.out.println("The alert popup when circuit reference field is clicked is: " + text);
				DriverTestcase.logger.log(LogStatus.INFO,"on clicking circuit reference, alert popup message displays as: "+text);
				
				CircuitReferencepopupalertmsg=false;
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
				Thread.sleep(3000);
			    }	 
					    
			
			}
		else if(vpntopology.equals("Point-to-Point")) {
			 
			DriverTestcase.logger.log(LogStatus.INFO,"under VPN topology dropdown for Direct Fiber service subtype"
						+ " When'Point-to-Point' is selected,'Circuit type' , 'Intermediate technology', 'Circuit Reference' should get displayed");

			Moveon(getwebelement(xml.getlocator("//locators/" + application + "/intermediateTechErrorMessage")));
			
			boolean intermediateTechnologypopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")).isDisplayed();
			
			while(intermediateTechnologypopupalertmsg)	{
				String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")));
				System.out.println("the alert popup for intermediate technology is: " + text);
				DriverTestcase.logger.log(LogStatus.INFO,"Intermediate Technology info message is: "+text);
				
				intermediateTechnologypopupalertmsg=false;
			}
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")));
				intermediateTechnology = getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology"))
						.isDisplayed();
				sa.assertTrue(intermediateTechnology, "intermediate technology field is displayed");
				
//				try {
				circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).isDisplayed();
				sa.assertTrue(circuitref, "circuit reference field is displayed");
//				sa.assertAll();
//				DriverTestcase.logger.log(LogStatus.PASS, "circuit reference field is displaying under Create service page");
//	           }catch(AssertionError e) {
//	        	 e.printStackTrace();
//	        	 DriverTestcase.logger.log(LogStatus.FAIL, "circuit reference field is not displaying under Create service page");
//	           }
				
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));
				
				boolean CircuitReferencepopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")).isDisplayed();
				
				
			    while(CircuitReferencepopupalertmsg)	{
				String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
				System.out.println("The alert popup on clicking circuit reference field is : " + text);
				DriverTestcase.logger.log(LogStatus.INFO," on clicking 'Circuit reference' , alert emssage popup as : "+ text);
				
				CircuitReferencepopupalertmsg=false;
			    }
			    
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
				Thread.sleep(3000);
						
				
				Moveon(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferenceIalert")));
				
				boolean CircuitReferencepopupalerterrmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")).isDisplayed();
				
				
			while(CircuitReferencepopupalerterrmsg)	{
				String text1=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")));
				System.out.println("The alert popup message when mouse hover on circuit reference(i) is: " + text1);
				DriverTestcase.logger.log(LogStatus.INFO," info message for 'Circuit reference' field is; "+text1);
				
				
				CircuitReferencepopupalerterrmsg=false;
			}

			try {
			List<WebElement> listofcircuittypes = driver
					.findElements(By.xpath("//div[@class='div-border div-margin container']//div[@class='row'][3]//span"));
			
			for (WebElement CircuitTypes : listofcircuittypes) {
				int i = 0;
				boolean match = false;
				if (CircuitTypes.getText().equals(Circuittype[i])) {
					match = true;
					Log.info("list of circuit types are : " + CircuitTypes.getText());
					DriverTestcase.logger.log(LogStatus.INFO,"list of circuit ytpes are:  "+CircuitTypes.getText());
					

				} else {

					Log.info("list of circuit types inside dropdowns are : " + CircuitTypes.getText());
					
				}

				sa.assertTrue(match);
				i++;
			}
//			sa.assertAll();
//			}catch(AssertionError error) {
//			   error.printStackTrace();
//			   DriverTestcase.logger.log(LogStatus.FAIL,"list of circuit type values are mismatching");
			}catch(Exception e) {
				e.printStackTrace();
				Log.info("Circuit type values are mismatching");
				DriverTestcase.logger.log(LogStatus.FAIL,"list of circuit type values are mismatching");
				
			}
			
		 
		
			
		}
			
			
		else {
			
			System.out.println(vpntopology+ " is not available inside the VPNtopoloy dropdown");
			Log.info(vpntopology+ " is not available inside the VPNtopoloy dropdown");
			DriverTestcase.logger.log(LogStatus.INFO,vpntopology+ " is not available inside the VPNtopoloy dropdown");
			
		}
			
//		try {	
			okButton = getwebelement(xml.getlocator("//locators/" + application + "/okbutton")).isDisplayed();
			sa.assertTrue(okButton, "OK button is displayed");
//			sa.assertAll();
//			DriverTestcase.logger.log(LogStatus.PASS, "ok button is displaying under Create service page");
//           }catch(AssertionError e) {
//        	 e.printStackTrace();
//        	 DriverTestcase.logger.log(LogStatus.FAIL, "ok button is not displaying under Create service page");
//           }
			
			
//		try {
			cancelButton = getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")).isDisplayed();
			sa.assertTrue(cancelButton, "Cancel button is displayed");
//			sa.assertAll();
//			DriverTestcase.logger.log(LogStatus.PASS, "cancel button is displaying under Create service page");
//           }catch(AssertionError e) {
//        	 e.printStackTrace();
//        	 DriverTestcase.logger.log(LogStatus.FAIL, "cancel button is not displaying under Create service page");
//           }
			

			
			sa.assertAll();
			DriverTestcase.logger.log(LogStatus.PASS," Fields under Direct Fiber service subtype is verified");
           }catch(AssertionError e) {
        	 e.printStackTrace();
        	 DriverTestcase.logger.log(LogStatus.FAIL, "validation failure for Direct Fiber service subtype");
           }	
			
			
		

	
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));
		Thread.sleep(3000);
		
		}
		
		
		
		public void Fieldvalidation_LANlinkInternational(String application, String serviceType, String SelectSubService,
				String Interfacespeed, String proActivemonitoring ,String vpntopology, String aggregateTraffic) throws InterruptedException, DocumentException, IOException {

		try {	
			String[] deliverychannel = { "--", "Retail", "Reseller" };

			String[] VPNtopology = { "Point-to-Point", "Hub&Spoke", "E-PN (Any-to-Any)" };

			String[] Circuittype = { "Default", "Composite Circuit", "Extended Circuit" };
			
			String[] notifyManagement= {"--", "Retail", "Reseller"}; 
			

			boolean serviceIdentificationField, ServiceType, ServiceSubtype, interfacespeed, singleendpointCPE, email,
					phone, remark, performanceMonitor, deliveryChanel, proactiveMonitor, Managementorder, vpnTopology,
					intermediateTechnology, circuitref, circuitType, nextButton, cancelButton, AggregateTraffic, okButton;

			serviceIdentificationField = (getwebelement(
					xml.getlocator("//locators/" + application + "/ServiceIdentification")).getSize()) != null;
			sa.assertTrue(serviceIdentificationField, "Service identification field is displayed");
			System.out.println("the size of service identification is: " + serviceIdentificationField);
			
			ServiceType = (getwebelement("//div[contains(text(),'" + application + "')]")).isDisplayed();
			sa.assertTrue(ServiceType, "Service type is displayed as expected");
			
			ServiceSubtype = getwebelement("//div[contains(text(),'" + SelectSubService + "')]").isDisplayed();
			sa.assertTrue(ServiceSubtype, "Service subtype is displayed as expected");
			
			String interfacespeedautopopulatedvalue=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/interfacespeedvaluepopulated")));
			sa.assertEquals(interfacespeedautopopulatedvalue, Interfacespeed, "Interface speed is autopopulated as expected");
			
			singleendpointCPE = getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")).isDisplayed();
			sa.assertTrue(singleendpointCPE, "single End point CPE checkbox is disabled by default as expected");
			email = getwebelement("//div[label[contains(text(),'Email')]]//input").isDisplayed();
			sa.assertTrue(email, "email field is displayed");
			
			phone = getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")).isDisplayed();
			sa.assertTrue(phone, "phone contact field is displayed as expected");
		
			remark = getwebelement(xml.getlocator("//locators/" + application + "/Remark")).isDisplayed();
			sa.assertTrue(remark, "remark field si displayed as expected");
			performanceMonitor = getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring"))
					.isDisplayed();
			sa.assertTrue(performanceMonitor,
					"performance monitoring checbox is displayed and by default not selected as expected");

			proactiveMonitor = getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring"))
					.isDisplayed();
			sa.assertTrue(proactiveMonitor,
					"pro active monitoring checkbox is displayed and by default not selected as expected");
 
			
			
			if(proActivemonitoring.equalsIgnoreCase("yes")) {
				DriverTestcase.logger.log(LogStatus.INFO,"If proactive Monitor checkbox is selected under Lanlink Internation service subtype, Notification management dropdown should occur");

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
				Log.info("Pro active monitoring check box is selected");
				Thread.sleep(2000);
				
				
				boolean notificationManagement=getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement"))
				.isDisplayed();
				sa.assertTrue(notificationManagement, "Notification management dropdown gets displayed when proactive monitoring is selected");
				Log.info("Notification management dropdown gets displayed when proactive monitoring is selected");

				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
				try {
					List<WebElement> listofnotificationmanagement = driver
							.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
					for (WebElement notificationmanagementtypes : listofnotificationmanagement) {

						boolean match = false;
						for (int i = 0; i < notifyManagement.length; i++) {
							if (notificationmanagementtypes.getText().equals(notifyManagement[i])) {
								match = true;
								Log.info("list of notification management are : " + notificationmanagementtypes.getText());
								DriverTestcase.logger.log(LogStatus.PASS,"list of Notification mnagement dropdown values under Lanlink Internation service subtype are: "+notificationmanagementtypes.getText());
							}
						}
						sa.assertTrue(match);
					}
			      }catch(AssertionError e) {
			    	  Log.info("Notification Management dropdown values are mismatching");
			    	  e.printStackTrace();
			    	  DriverTestcase.logger.log(LogStatus.FAIL,"Notification mnagement dropdown values under Lanlink Internation service subtype is not displaying as expected");
			      }
				
				}else {
				
				Log.info("Notification management dropdown is available as proactive monitoring is not selected");
				DriverTestcase.logger.log(LogStatus.INFO,"Notification mnagement dropdown under Lanlink Internation service subtype is not available as proactive monitoring is not selected");
				}


			deliveryChanel = getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")).isDisplayed();
			sa.assertTrue(deliveryChanel, "delivery channel dropdown is displayed");
			DriverTestcase.logger.log(LogStatus.FAIL,"Delivery channel dropdown under Lanlink Internation service subtype is not getting displayed");

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
	      try {
			List<WebElement> listofdeliverychannel = driver
					.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement deliverychanneltypes : listofdeliverychannel) {

				boolean match = false;
				for (int i = 0; i < deliverychannel.length; i++) {
					if (deliverychanneltypes.getText().equals(deliverychannel[i])) {
						match = true;
						Log.info("list of delivery channel are : " + deliverychanneltypes.getText());
						DriverTestcase.logger.log(LogStatus.PASS,"list of delivery channel dropdown values under Lanlink Internation service subtype are: "+deliverychanneltypes.getText());
					}
				}
				sa.assertTrue(match);


			}
	      }catch(Exception e) {
	    	  e.printStackTrace();
	    	  Log.info("delivery channel dropdown values are mismatching");
	    	  DriverTestcase.logger.log(LogStatus.FAIL,"Delivery channel dropdown values under Lanlink Internation service subtype is not getting dispalyed as expected");

	      }
	      
	      DriverTestcase.logger.log(LogStatus.INFO,"When modular msp is not selected under Lanlink Internation service subtype "
	      		+ " Interface speed dropdown should display ");
      
	      
	if(Interfacespeed.equals("10Gige")) {
	      
		DriverTestcase.logger.log(LogStatus.INFO,"When Interfacespeed is '10GigE' under Lanlink Internation service subtype "
				+ "we should get 'Aggregate traffic checkbox' ");

	      
			AggregateTraffic = getwebelement(xml.getlocator("//locators/" + application + "/Aggregate_10Gig_1Gig_Traffic"))
					.isDisplayed();
			sa.assertTrue(AggregateTraffic,
					"Aggregate 10Gig-1Gig Traffic is displayed and by default not selected as expected");
			System.out.println("aggreegate traffic check box is displayed");

			
			vpnTopology = getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")).isDisplayed();
			sa.assertTrue(vpnTopology, "vpn topology dropdown is displayed");


			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
//			,"when 'Aggregate Traffic' is selected under Lanlink Internation service subtype is verified");

			
			try {
			List<WebElement> listofvpntopology = driver.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement vpntopologytyeps : listofvpntopology) {

				boolean match = false;
				for (int i = 0; i < VPNtopology.length; i++) {
					if (vpntopologytyeps.getText().equals(VPNtopology[i])) {
						match = true;
						Log.info("list of vpn topologies are : " + vpntopologytyeps.getText());
						DriverTestcase.logger.log(LogStatus.PASS,"VPN topology dropdown default values for 10Gige under lanlink International service subtype are: "+vpntopologytyeps.getText());

					}
				}
				sa.assertTrue(match);

			}
			}catch(Exception e) {
				e.printStackTrace();
				Log.info("vpn topology dropdown values are mismatching");
				DriverTestcase.logger.log(LogStatus.FAIL,"Default dropdown values in VPN topology dropdown for 10Gige under Lanlink Internation service subtype is not getting displayed");

			}
			
		
			if(!aggregateTraffic.equalsIgnoreCase("yes")) {
				
				
					
			Clickon(getwebelement("//span[contains(text(),'"+vpntopology +"')]"));
			Thread.sleep(3000);
			
			DriverTestcase.logger.log(LogStatus.INFO,"when 'Aggregate traffic'  is not selected, then"
					+ "VPN topology dropdown should have 'Point-to-point', 'E-PN(Any-to-Any)' and 'Hub&spoke'");

		
		if(vpntopology.equals("E-PN (Any-to-Any)") ) {
				
				Log.info("Under 'VPN Topology', When 'E-PN (Any-to-Any)' is selected,'Circuit type' and 'Intermediate technology' should get disapper ");
				DriverTestcase.logger.log(LogStatus.INFO,"under VPN topology dropdown for Lanlink International service subtype"
						+ " When'E-PN (Any-to-Any)' is selected,'Circuit type' and 'Intermediate technology' should get disapper , only 'circuit reference' field should appear");

				
				circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).isDisplayed();
				sa.assertTrue(circuitref, "circuit reference field is displayed");
				
				
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));
				
				boolean CircuitReferencepopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")).isDisplayed();
				
			    while(CircuitReferencepopupalertmsg)	{
				String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
				System.out.println("The alert popup when circuit reference field is clicked is: " + text);
				CircuitReferencepopupalertmsg=false;
				DriverTestcase.logger.log(LogStatus.PASS,"circuit reference alert popu message is: "+text);

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
				Thread.sleep(3000);
				
			    }
			     
			    
		}
		
		
		else if(vpntopology.equals("Hub&Spoke") ) {
			
			Log.info("Under 'VPN Topology', When Aggregate traffic is not selected and 'Hub&Spoke' is selected,'Circuit type', 'Cicuit Reference' and 'Intermediate technology' should get disapper ");
		
			System.out.println("Under 'VPN Topology', When Aggregate traffic is not selected and 'Hub&Spoke' is selected,"
					+ "'Circuit type', 'Cicuit Reference' and 'Intermediate technology' should get disapper ");

			DriverTestcase.logger.log(LogStatus.INFO,"under VPN topology dropdown for Lanlink International service subtype"
					+ " When'Hub&Spoke' is selected,'Circuit type' , 'Intermediate technology', 'Circuit Reference' should get disapper");

		}
	    		    
		 else if(vpntopology.equals("Point-to-Point")) {
			 
			DriverTestcase.logger.log(LogStatus.INFO,"under VPN topology dropdown for Lanlink International service subtype"
						+ " When'Point-to-Point' is selected,'Circuit type' , 'Intermediate technology', 'Circuit Reference' should get displayed");

			Moveon(getwebelement(xml.getlocator("//locators/" + application + "/intermediateTechErrorMessage")));
			
			boolean intermediateTechnologypopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")).isDisplayed();
			DriverTestcase.logger.log(LogStatus.FAIL,"Intermediate Technology info message is not getting displayed");
			
			while(intermediateTechnologypopupalertmsg)	{
				String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")));
				System.out.println("the alert popup for intermediate technology is: " + text);
				DriverTestcase.logger.log(LogStatus.PASS,"Intermediate Technology info message is: "+text);
				
				intermediateTechnologypopupalertmsg=false;
			}
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")));
				intermediateTechnology = getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology"))
						.isDisplayed();
				sa.assertTrue(intermediateTechnology, "intermediate technology field is displayed");
				
				
				circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).isDisplayed();
				sa.assertTrue(circuitref, "circuit reference field is displayed");
				
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));
				
				boolean CircuitReferencepopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")).isDisplayed();
				DriverTestcase.logger.log(LogStatus.FAIL," alert message on clicking 'circuit reference' field is not getting displayed");
				
				
			    while(CircuitReferencepopupalertmsg)	{
				String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
				System.out.println("The alert popup on clicking circuit reference field is : " + text);
				DriverTestcase.logger.log(LogStatus.PASS," on clicking 'Circuit reference' , alert emssage popup as : "+ text);
				
				CircuitReferencepopupalertmsg=false;
			    }
			    
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
				Thread.sleep(3000);
						
				
				Moveon(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferenceIalert")));
				
				boolean CircuitReferencepopupalerterrmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")).isDisplayed();
				
				
			while(CircuitReferencepopupalerterrmsg)	{
				String text1=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")));
				System.out.println("The alert popup message when mouse hover on circuit reference(i) is: " + text1);
				DriverTestcase.logger.log(LogStatus.PASS," info message for 'Circuit reference' field is; "+text1);
				
				
				CircuitReferencepopupalerterrmsg=false;
			}

			try {
			List<WebElement> listofcircuittypes = driver
					.findElements(By.xpath("//div[@class='div-border div-margin container']//div[@class='row'][3]//span"));
			
			for (WebElement CircuitTypes : listofcircuittypes) {
				int i = 0;
				boolean match = false;
				if (CircuitTypes.getText().equals(Circuittype[i])) {
					match = true;
					Log.info("list of circuit types are : " + CircuitTypes.getText());
					DriverTestcase.logger.log(LogStatus.PASS,"list of circuit ytpes are:  "+CircuitTypes.getText());
					

				} else {

					Log.info("list of circuit types are : " + CircuitTypes.getText());
					
				}

				sa.assertTrue(match);
				i++;
			}
			}catch(Exception e) {
				e.printStackTrace();
				Log.info("Circuit type values are mismatching");
				DriverTestcase.logger.log(LogStatus.FAIL," Circuit type values are mismatching");
				
			}
			
		 }
		
		 else {
				
				System.out.println(vpntopology+ " is not available inside the VPNtopoloy dropdown");
				Log.info(vpntopology+ " is not available inside the VPNtopoloy dropdown");
				DriverTestcase.logger.log(LogStatus.INFO,vpntopology+" is not available inside vpn topology dropdown");
				
			}
		
		}

			else if(aggregateTraffic.equalsIgnoreCase("yes")) {
				
				 Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Aggregate_10Gig_1Gig_Traffic")));
					
				 DriverTestcase.logger.log(LogStatus.INFO,"when 'Aggregate traffic'  is selected, then"
							+ "VPN topology dropdown should have 'E-PN(Any-to-Any)' and 'Hub&spoke' ");

				 
				 Clickon(getwebelement("//span[contains(text(),'"+vpntopology +"')]"));
					Thread.sleep(3000);
					
				
				
				if(vpntopology.equals("E-PN (Any-to-Any)") || vpntopology.equals("Hub&Spoke") ) {
					
					Log.info("Under 'VPN Topology', When Aggregare traffic is selected "
							+ " And when 'Hub&Spoke' or 'E-PN (Any-to-Any)' is selected,'Circuit type' and 'Intermediate technology' should get disapper, circuit reference field will be available ");
					
					DriverTestcase.logger.log(LogStatus.INFO,"under VPN topology dropdown for Lanlink International service subtype"
							+ " When'E-PN (Any-to-Any)' or 'hub & spoke'  is selected,'Circuit type' and 'Intermediate technology' should get disapper , only 'circuit reference' field should appear");

					
					circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).isDisplayed();
					sa.assertTrue(circuitref, "circuit reference field is displayed");
					
					
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));
					
					boolean CircuitReferencepopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")).isDisplayed();
					
				    while(CircuitReferencepopupalertmsg)	{
					String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
					System.out.println("The alert popup when circuit reference field is clicked is: " + text);
					DriverTestcase.logger.log(LogStatus.PASS,"on clicking circuit reference, alert popup message displays as: "+text);
					
					CircuitReferencepopupalertmsg=false;
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
					Thread.sleep(3000);
				    }	
					
			}
				
		      else {
					
					System.out.println(vpntopology+ " is not available inside the VPNtopoloy dropdown");
					Log.info(vpntopology+ " is not available inside the VPNtopoloy dropdown");
					DriverTestcase.logger.log(LogStatus.FAIL,vpntopology+ " is not available inside the VPNtopoloy dropdown");
				}
			
				
			}
	     }


			else if(Interfacespeed.equals("1Gige")) {
				
				DriverTestcase.logger.log(LogStatus.INFO,"When Interfacespeed is '1GigE' under Lanlink Internation service subtype "
						+ "we shouldn not get 'Aggregate traffic checkbox' ");

				
				vpnTopology = getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")).isDisplayed();
				sa.assertTrue(vpnTopology, "vpn topology dropdown is displayed");
		

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
				try {
				List<WebElement> listofvpntopology = driver.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
				for (WebElement vpntopologytyeps : listofvpntopology) {

					boolean match = false;
					for (int i = 0; i < VPNtopology.length; i++) {
						if (vpntopologytyeps.getText().equals(VPNtopology[i])) {
							match = true;
							Log.info("list of vpn topologies are : " + vpntopologytyeps.getText());
							System.out.println("list of vpn topologies: "+vpntopologytyeps.getText());
							DriverTestcase.logger.log(LogStatus.PASS,"By default VPN topology dropdown  value under Lanlink International are: "+vpntopologytyeps.getText());

						}
					}
					sa.assertTrue(match);
					DriverTestcase.logger.log(LogStatus.PASS,"VPN topology dropdown values under Lanlink International are verified");

				}
			}catch(Exception e) {
				Log.info("vpn topology dropdown values are mismatching");
				DriverTestcase.logger.log(LogStatus.FAIL,"VPN topology dropdown values under Lanlink International are not getting displayed as expected ");

			}
				
				
				if(vpntopology.equals("Hub&Spoke") || vpntopology.equals("E-PN (Any-to-Any)")) {
					
					Log.info("Under 'VPN Topology', When 'Hub&Spoke' or 'E-PN (Any-to-Any)' are selected, 'Circuit type' and 'Intermediate technology' should get disapper ");
					
					DriverTestcase.logger.log(LogStatus.INFO,"Under 'VPN Topology' for '1GigE' interface speed, When 'Hub&Spoke' or 'E-PN (Any-to-Any)' are selected, 'Circuit type' and 'Intermediate technology' should get disapper ");
					
					
					circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).isDisplayed();
					sa.assertTrue(circuitref, "circuit reference field is displayed");
					
					
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));
					
					boolean CircuitReferencepopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")).isDisplayed();
					
				    while(CircuitReferencepopupalertmsg)	{
					String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
					System.out.println("The alert popup when circuit reference field is clicked is: " + text);
					DriverTestcase.logger.log(LogStatus.PASS,"on clicking circuit reference, alert popup message displays as: "+text);
					
					CircuitReferencepopupalertmsg=false;
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
					Thread.sleep(3000);
				    }	
				    
				}
				
			else if(vpntopology.equals("Point-to-Point")) {
				

				 
				DriverTestcase.logger.log(LogStatus.INFO,"under VPN topology dropdown for Lanlink International service subtype"
							+ " When'Point-to-Point' is selected,'Circuit type' , 'Intermediate technology', 'Circuit Reference' should get displayed");

				Moveon(getwebelement(xml.getlocator("//locators/" + application + "/intermediateTechErrorMessage")));
				
				boolean intermediateTechnologypopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")).isDisplayed();
				
				while(intermediateTechnologypopupalertmsg)	{
					String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")));
					System.out.println("the alert popup for intermediate technology is: " + text);
					DriverTestcase.logger.log(LogStatus.PASS,"Intermediate Technology info message is: "+text);
					
					intermediateTechnologypopupalertmsg=false;
				}
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")));
					intermediateTechnology = getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology"))
							.isDisplayed();
					sa.assertTrue(intermediateTechnology, "intermediate technology field is displayed");
					
					
					circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).isDisplayed();
					sa.assertTrue(circuitref, "circuit reference field is displayed");
					
					
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));
					
					boolean CircuitReferencepopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")).isDisplayed();
					
					
				    while(CircuitReferencepopupalertmsg)	{
					String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
					System.out.println("The alert popup on clicking circuit reference field is : " + text);
					DriverTestcase.logger.log(LogStatus.PASS," on clicking 'Circuit reference' , alert emssage popup as : "+ text);
					
					CircuitReferencepopupalertmsg=false;
				    }
				    
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
					Thread.sleep(3000);
							
					
					Moveon(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferenceIalert")));
					
					boolean CircuitReferencepopupalerterrmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")).isDisplayed();
					
					
				while(CircuitReferencepopupalerterrmsg)	{
					String text1=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")));
					System.out.println("The alert popup message when mouse hover on circuit reference(i) is: " + text1);
					DriverTestcase.logger.log(LogStatus.PASS," info message for 'Circuit reference' field is; "+text1);
					
					
					CircuitReferencepopupalerterrmsg=false;
				}

				try {
				List<WebElement> listofcircuittypes = driver
						.findElements(By.xpath("//div[@class='div-border div-margin container']//div[@class='row'][3]//span"));
				
				for (WebElement CircuitTypes : listofcircuittypes) {
					int i = 0;
					boolean match = false;
					if (CircuitTypes.getText().equals(Circuittype[i])) {
						match = true;
						Log.info("list of circuit types are : " + CircuitTypes.getText());
						DriverTestcase.logger.log(LogStatus.PASS,"list of circuit types are:  "+CircuitTypes.getText());
						

					} else {

						Log.info("list of circuit types are : " + CircuitTypes.getText());
						
					}

					sa.assertTrue(match);
					i++;
				}
				}catch(Exception e) {
					e.printStackTrace();
					Log.info("Circuit type values are mismatching");
					DriverTestcase.logger.log(LogStatus.FAIL,"Circuit type values are mismatching");
					
				}
				
			 
			}
				
				
		else {
				
				System.out.println(vpntopology+ " is not available inside the VPNtopoloy dropdown");
				Log.info(vpntopology+ " is not available inside the VPNtopoloy dropdown");
				DriverTestcase.logger.log(LogStatus.INFO,vpntopology+ " is not available inside the VPNtopoloy dropdown");
				
			}

		
			}


			else {
				System.out.println("The selected Interface speed is not available");
				DriverTestcase.logger.log(LogStatus.INFO,"The select interface speed is not avaiable");
				
				
			}
	   
		
		
			okButton = getwebelement(xml.getlocator("//locators/" + application + "/okbutton")).isDisplayed();
			sa.assertTrue(okButton, "OK button is displayed");
			

			cancelButton = getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")).isDisplayed();
			sa.assertTrue(cancelButton, "Cancel button is not diaplayed");
			

			
			sa.assertAll();
			
			DriverTestcase.logger.log(LogStatus.PASS," fields under 'Lanlink International' service subtype is verified");
			

	}catch(AssertionError e) {
				
				Log.info("Field validation failure under Lanlink International service type");
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL,"Fields under 'Lanlink International' service subtype is not displaying as expected");
			}
			
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));
		Thread.sleep(3000);
			

		}
		
		
		public void Fieldvalidation_LANlinkInternationalwithoutinterfacespeed(String application, String serviceType, String SelectSubService,
				String Interfacespeed, String proActivemonitoring ,String vpntopology, String aggregateTraffic) throws InterruptedException, DocumentException, IOException {

		try {	
			String[] deliverychannel = { "--", "Retail", "Reseller" };

			String[] VPNtopology = { "Point-to-Point", "Hub&Spoke", "E-PN (Any-to-Any)" };

			String[] Circuittype = { "Default", "Composite Circuit", "Extended Circuit" };

			String[] notifyManagement = { "--", "Retail", "Reseller" };
			
			boolean serviceIdentificationField, ServiceType, ServiceSubtype, interfacespeed, singleendpointCPE, email,
					phone, remark, performanceMonitor, deliveryChanel, proactiveMonitor, Managementorder, vpnTopology,
					intermediateTechnology, circuitref, circuitType, nextButton, cancelButton, AggregateTraffic, okButton;

			
			serviceIdentificationField = (getwebelement(
					xml.getlocator("//locators/" + application + "/ServiceIdentification")).getSize()) != null;
			sa.assertTrue(serviceIdentificationField, "Service identification field is displayed");
			System.out.println("the size of service identification is: " + serviceIdentificationField);
			
			
			
			ServiceType = (getwebelement("//div[contains(text(),'" + application + "')]")).isDisplayed();
			sa.assertTrue(ServiceType, "Service type is displayed as expected");
			
			ServiceSubtype = getwebelement("//div[contains(text(),'" + SelectSubService + "')]").isDisplayed();
			sa.assertTrue(ServiceSubtype, "Service subtype is displayed as expected");
			
			String interfacespeedautopopulatedvalue=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/interfacespeedvaluepopulated")));
			sa.assertEquals(interfacespeedautopopulatedvalue, Interfacespeed, "Interface speed is autopopulated as expected");

			singleendpointCPE = getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")).isDisplayed();
			sa.assertTrue(singleendpointCPE, "single End point CPE checkbox is disabled by default as expected");
			
			email = getwebelement("//div[label[contains(text(),'Email')]]//input").isDisplayed();
			sa.assertTrue(email, "email field is displayed");
			
			phone = getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")).isDisplayed();
			sa.assertTrue(phone, "phone contact field is displayed as expected");
			
			remark = getwebelement(xml.getlocator("//locators/" + application + "/Remark")).isDisplayed();
			sa.assertTrue(remark, "remark field si displayed as expected");
			
			performanceMonitor = getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring"))
					.isDisplayed();
			sa.assertTrue(performanceMonitor,
					"performance monitoring checbox is displayed and by default not selected as expected");
			
			proactiveMonitor = getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring"))
					.isDisplayed();
			sa.assertTrue(proactiveMonitor,
					"pro active monitoring checkbox is displayed and by default not selected as expected");
			
			
			if(proActivemonitoring.equalsIgnoreCase("yes")) {
				DriverTestcase.logger.log(LogStatus.INFO,"If proactive Monitor checkbox is selected under Lanlink Internation service subtype, Notification management dropdown should occur");

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
				Log.info("Pro active monitoring check box is selected");
				Thread.sleep(2000);
				
				
				boolean notificationManagement=getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement"))
				.isDisplayed();
				sa.assertTrue(notificationManagement, "Notification management dropdown gets displayed when proactive monitoring is selected");
				Log.info("Notification management dropdown gets displayed when proactive monitoring is selected");
				
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
				try {
					List<WebElement> listofnotificationmanagement = driver
							.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
					for (WebElement notificationmanagementtypes : listofnotificationmanagement) {

						boolean match = false;
						for (int i = 0; i < notifyManagement.length; i++) {
							if (notificationmanagementtypes.getText().equals(notifyManagement[i])) {
								match = true;
								Log.info("list of notification management are : " + notificationmanagementtypes.getText());
								DriverTestcase.logger.log(LogStatus.PASS,"list of Notification mnagement dropdown values under Lanlink Internation service subtype are: "+notificationmanagementtypes.getText());
							}
						}
						sa.assertTrue(match);
						DriverTestcase.logger.log(LogStatus.PASS,"Notification mnagement dropdown values under Lanlink Internation service subtype is verified");
					}
			      }catch(AssertionError e) {
			    	  Log.info("Notification Management dropdown values are mismatching");
			    	  e.printStackTrace();
			    	  DriverTestcase.logger.log(LogStatus.FAIL,"Notification mnagement dropdown values under Lanlink Internation service subtype is not displaying as expected");
			      }
				
				}else {
				
				Log.info("Notification management dropdown is not available as proactive monitoring is not selected");
				DriverTestcase.logger.log(LogStatus.PASS,"Notification mnagement dropdown under Lanlink Internation service subtype is not available as proactive monitoring is not selected");
				}


			deliveryChanel = getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")).isDisplayed();
			sa.assertTrue(deliveryChanel, "delivery channel dropdown is displayed");
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
	      try {
			List<WebElement> listofdeliverychannel = driver
					.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement deliverychanneltypes : listofdeliverychannel) {

				boolean match = false;
				for (int i = 0; i < deliverychannel.length; i++) {
					if (deliverychanneltypes.getText().equals(deliverychannel[i])) {
						match = true;
						Log.info("list of delivery channel are : " + deliverychanneltypes.getText());
						DriverTestcase.logger.log(LogStatus.PASS,"list of delivery channel dropdown values under Lanlink Internation service subtype are: "+deliverychanneltypes.getText());
					}
				}
				sa.assertTrue(match);
				DriverTestcase.logger.log(LogStatus.PASS,"Delivery channel dropdown values under Lanlink Internation service subtype is verified");


			}
	      }catch(Exception e) {
	    	  e.printStackTrace();
	    	  Log.info("delivery channel dropdown values are mismatching");
	    	  DriverTestcase.logger.log(LogStatus.FAIL,"Delivery channel dropdown values under Lanlink Internation service subtype is not getting dispalyed as expected");

	      }
	      
	      			
			
			vpnTopology = getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")).isDisplayed();
			sa.assertTrue(vpnTopology, "vpn topology dropdown is displayed");

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
			
			try {
			List<WebElement> listofvpntopology = driver.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement vpntopologytyeps : listofvpntopology) {

				boolean match = false;
				for (int i = 0; i < VPNtopology.length; i++) {
					if (vpntopologytyeps.getText().equals(VPNtopology[i])) {
						match = true;
						Log.info("list of vpn topologies are : " + vpntopologytyeps.getText());

					}
				}
				sa.assertTrue(match);

			}
			}catch(Exception e) {
				e.printStackTrace();
				Log.info("vpn topology dropdown values are mismatching");
			}
			

			
	Clickon(getwebelement("//span[contains(text(),'"+vpntopology +"')]"));
	Thread.sleep(3000);
	
	DriverTestcase.logger.log(LogStatus.INFO,"VPN topology dropdown should have 'Point-to-point', 'E-PN(Any-to-Any)' and 'Hub&spoke'");


if(vpntopology.equals("E-PN (Any-to-Any)") ) {
		
		Log.info("Under 'VPN Topology', When 'E-PN (Any-to-Any)' is selected,'Circuit type' and 'Intermediate technology' should get disapper ");
		DriverTestcase.logger.log(LogStatus.INFO,"under VPN topology dropdown for Lanlink International service subtype"
				+ " When'E-PN (Any-to-Any)' is selected,'Circuit type' and 'Intermediate technology' should get disapper , only 'circuit reference' field should appear");

		
		circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).isDisplayed();
		sa.assertTrue(circuitref, "circuit reference field is displayed");

		
		
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));
		
		boolean CircuitReferencepopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")).isDisplayed();
		
	    while(CircuitReferencepopupalertmsg)	{
		String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
		System.out.println("The alert popup when circuit reference field is clicked is: " + text);
		CircuitReferencepopupalertmsg=false;
		DriverTestcase.logger.log(LogStatus.PASS,"circuit reference alert popu message is: "+text);

		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
		Thread.sleep(3000);
		
	    }
	     
	    
}


else if(vpntopology.equals("Hub&Spoke") ) {
	
	Log.info("Under 'VPN Topology', When 'Hub&Spoke' is selected, 'Circuit type', 'Cicuit Reference' and 'Intermediate technology' should get disapper ");

	System.out.println("Under 'VPN Topology', when'Hub&Spoke' is selected,"
			+ "'Circuit type', 'Cicuit Reference' and 'Intermediate technology' should get disapper ");

	DriverTestcase.logger.log(LogStatus.INFO,"under VPN topology dropdown for Lanlink International service subtype"
			+ " When'Hub&Spoke' is selected,'Circuit type' , 'Intermediate technology', 'Circuit Reference' should get disapper");

}
		    
 else if(vpntopology.equals("Point-to-Point")) {
	 
	DriverTestcase.logger.log(LogStatus.INFO,"under VPN topology dropdown for Lanlink International service subtype"
				+ " When'Point-to-Point' is selected,'Circuit type' , 'Intermediate technology', 'Circuit Reference' should get displayed");

	Moveon(getwebelement(xml.getlocator("//locators/" + application + "/intermediateTechErrorMessage")));
	
	boolean intermediateTechnologypopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")).isDisplayed();
	
	while(intermediateTechnologypopupalertmsg)	{
		String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")));
		System.out.println("the alert popup for intermediate technology is: " + text);
		DriverTestcase.logger.log(LogStatus.INFO,"Intermediate Technology info message is: "+text);
		
		intermediateTechnologypopupalertmsg=false;
	}
	
	Clickon(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")));
		intermediateTechnology = getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology"))
				.isDisplayed();
		sa.assertTrue(intermediateTechnology, "intermediate technology field is displayed");
		
		
		circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).isDisplayed();
		sa.assertTrue(circuitref, "circuit reference field is displayed");
		
		
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));
		
		boolean CircuitReferencepopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")).isDisplayed();
		
		
	    while(CircuitReferencepopupalertmsg)	{
		String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
		System.out.println("The alert popup on clicking circuit reference field is : " + text);
		DriverTestcase.logger.log(LogStatus.INFO," on clicking 'Circuit reference' , alert emssage popup as : "+ text);
		
		CircuitReferencepopupalertmsg=false;
	    }
	    
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
		Thread.sleep(3000);
				
		
		Moveon(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferenceIalert")));
		
		boolean CircuitReferencepopupalerterrmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")).isDisplayed();
		
		
	while(CircuitReferencepopupalerterrmsg)	{
		String text1=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")));
		System.out.println("The alert popup message when mouse hover on circuit reference(i) is: " + text1);
		DriverTestcase.logger.log(LogStatus.INFO," info message for 'Circuit reference' field is; "+text1);
		
		
		CircuitReferencepopupalerterrmsg=false;
	}

	try {
	List<WebElement> listofcircuittypes = driver
			.findElements(By.xpath("//div[@class='div-border div-margin container']//div[@class='row'][3]//span"));
	
	for (WebElement CircuitTypes : listofcircuittypes) {
		int i = 0;
		boolean match = false;
		if (CircuitTypes.getText().equals(Circuittype[i])) {
			match = true;
			Log.info("list of circuit types are : " + CircuitTypes.getText());
			DriverTestcase.logger.log(LogStatus.PASS,"list of circuit ytpes are:  "+CircuitTypes.getText());
			

		} else {

			Log.info("list of circuit types are : " + CircuitTypes.getText());
			
		}

		sa.assertTrue(match);
		i++;
	}
	}catch(Exception e) {
		e.printStackTrace();
		Log.info("Circuit type values are mismatching");
		DriverTestcase.logger.log(LogStatus.FAIL," Circuit type values are mismatching");
		
	}
	
 }

 else {
		
		System.out.println(vpntopology+ " is not available inside the VPNtopoloy dropdown");
		Log.info(vpntopology+ " is not available inside the VPNtopoloy dropdown");
		DriverTestcase.logger.log(LogStatus.INFO,vpntopology+" is not available inside vpn topology dropdown");
		
	}
		
		
okButton = getwebelement(xml.getlocator("//locators/" + application + "/okbutton")).isDisplayed();
sa.assertTrue(okButton, "OK button is displayed");


cancelButton = getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")).isDisplayed();
sa.assertTrue(cancelButton, "Cancel button is diaplayed");

			sa.assertAll();
			DriverTestcase.logger.log(LogStatus.PASS,"Fields under 'Lanlink International' service subtype is verified");

			

	}catch(AssertionError e) {
				
				Log.info("Field validation failure under Lanlink International service type");
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL,"Fields under 'Lanlink International' service subtype is verified");
				
			}
			
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));
		Thread.sleep(3000);
			

		}


		public void Fieldvalidation_LANlinkMetro(String application, String serviceType, String SelectSubService,
				String Interfacespeed,String proActivemonitoring, String vpntopology) throws InterruptedException, DocumentException, IOException {

			try {
			String[] deliverychannel = { "--", "Retail", "Reseller" };

			String[] VPNtopology = { "Point-to-Point", "Hub&Spoke", "E-PN (Any-to-Any)" };

			String[] Circuittype = { "Default", "Composite Circuit", "Extended Circuit" };
			
			String[] notifyManagement= {"--", "Retail", "Reseller"}; 
			

			boolean serviceIdentificationField, ServiceType, ServiceSubtype, interfacespeed, singleendpointCPE, email,
					phone, remark, performanceMonitor, deliveryChanel, proactiveMonitor, Managementorder, vpnTopology,
					intermediateTechnology, circuitref, circuitType, nextButton, cancelButton, AggregateTraffic, okButton;

			
			serviceIdentificationField = getwebelement(
					xml.getlocator("//locators/" + application + "/ServiceIdentification")).isDisplayed();
			sa.assertTrue(serviceIdentificationField, "Service identification field is displayed");
			
			
			ServiceType = (getwebelement("//div[contains(text(),'" + application + "')]")).isDisplayed();
			sa.assertTrue(ServiceType, "Service type is displayed as expected");
						
			ServiceSubtype = getwebelement("//div[contains(text(),'" + SelectSubService + "')]").isDisplayed();
			sa.assertTrue(ServiceSubtype, "Service subtype is displayed as expected");
			
			String interfacespeedautopopulatedvalue=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/interfacespeedvaluepopulated")));
			sa.assertEquals(interfacespeedautopopulatedvalue, Interfacespeed, "Interface speed dropdown is not displaying as expected");
			
			singleendpointCPE = getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")).isDisplayed();
			sa.assertTrue(singleendpointCPE, "single End point CPE checkbox is disabled by default as expected");
			
			email = getwebelement(xml.getlocator("//locators/" + application + "/Email")).isDisplayed();
			sa.assertTrue(email, "email field is displayed");
			
			phone = getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")).isDisplayed();
			sa.assertTrue(phone, "phone contact field is displayed as expected");
			

			remark = getwebelement(xml.getlocator("//locators/" + application + "/Remark")).isDisplayed();
			sa.assertTrue(remark, "remark field si displayed as expected");
			
			
			performanceMonitor = getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring"))
					.isDisplayed();
			sa.assertTrue(performanceMonitor,
					"performance monitoring checbox is displayed and by default not selected as expected");
			
			proactiveMonitor = getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring"))
					.isDisplayed();
			sa.assertTrue(proactiveMonitor,
					"pro active monitoring checkbox is displayed and by default not selected as expected");
			
			
		if(proActivemonitoring.equalsIgnoreCase("yes")) {
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
			Log.info("Pro active monitoring check box is selected");
		
		boolean notificationManagement=getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement"))
		.isDisplayed();
		sa.assertTrue(notificationManagement, "Notification management dropdown gets displayed when proactive monitoring is selected");
		Log.info("Notification management dropdown gets displayed when proactive monitoring is selected");
		DriverTestcase.logger.log(LogStatus.INFO,"Notification management dropdown gets displayed when proactive monitoring is selected");
		
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
		try {
			List<WebElement> listofnotificationmanagement = driver
					.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement notificationmanagementtypes : listofnotificationmanagement) {

				boolean match = false;
				for (int i = 0; i < notifyManagement.length; i++) {
					if (notificationmanagementtypes.getText().equals(notifyManagement[i])) {
						match = true;
						Log.info("list of notification management are : " + notificationmanagementtypes.getText());
						DriverTestcase.logger.log(LogStatus.PASS, "list of notification management are : " + notificationmanagementtypes.getText());
					}
				}
				sa.assertTrue(match);
				
			}
	      }catch(AssertionError e) {
	    	  Log.info("Notification Management dropdown values are mismatching");
	    	  e.printStackTrace();
	    	  DriverTestcase.logger.log(LogStatus.FAIL,"  values in Notification management dropdown under Lanlink Metro service subtype is not displaying as expected");
	      }
		}else {
		
		Log.info("Notification management dropdown is not available as proactive monitoring is not selected");
		}

		deliveryChanel = getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")).isDisplayed();
			sa.assertTrue(deliveryChanel, "delivery channel dropdown is displayed");
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
	    try {
			List<WebElement> listofdeliverychannel = driver
					.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement deliverychanneltypes : listofdeliverychannel) {

				boolean match = false;
				for (int i = 0; i < deliverychannel.length; i++) {
					if (deliverychanneltypes.getText().equals(deliverychannel[i])) {
						match = true;
						Log.info("list of delivery channel are : " + deliverychanneltypes.getText());
						DriverTestcase.logger.log(LogStatus.PASS," List of Delivery channel dropdown values under Lanlink Metro service subtype are: "+deliverychanneltypes.getText());	
						
					}
				}
				sa.assertTrue(match);
			}
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	Log.info("delivery channel dropdown values are mismatching");
	    	DriverTestcase.logger.log(LogStatus.FAIL,"  values in delivery channel dropdowns under Lanlink Metro service subtype are not displaying as expected");
	    }

	    
			
	    vpnTopology = getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")).isDisplayed();
		sa.assertTrue(vpnTopology, "vpn topology dropdown is displayed");
		
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
		
		try {
		List<WebElement> listofvpntopology = driver.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
		for (WebElement vpntopologytyeps : listofvpntopology) {

			boolean match = false;
			for (int i = 0; i < VPNtopology.length; i++) {
				if (vpntopologytyeps.getText().equals(VPNtopology[i])) {
					match = true;
					Log.info("list of vpn topologies are : " + vpntopologytyeps.getText());
					System.out.println("list of vpn topologies: "+vpntopologytyeps.getText());
					DriverTestcase.logger.log(LogStatus.PASS,"list of vpn topologies: "+vpntopologytyeps.getText());
					
				}
			}
			sa.assertTrue(match);
		}
		}catch(Exception e) {
			e.printStackTrace();
			Log.info("vpn topology dropdown values are mismatching");
			DriverTestcase.logger.log(LogStatus.FAIL,"values in VPN topology dropdown under Lanlink Metro service subtype is not displaying as expected");
		}
		
		
		Clickon(getwebelement("//span[contains(text(),'"+vpntopology +"')]"));
		Thread.sleep(3000);
		
		
		if(vpntopology.equals("Hub&Spoke") || vpntopology.equals("E-PN (Any-to-Any)")) {
			

			
			Log.info("Under 'VPN Topology', When 'Hub&Spoke' or 'E-PN (Any-to-Any)' are selected, 'Circuit type' and 'Intermediate technology' should get disapper"
					+ "only Circuit reference field should occur ");
			
			DriverTestcase.logger.log(LogStatus.INFO,"Under 'VPN Topology', When 'Hub&Spoke' or 'E-PN (Any-to-Any)' are selected, 'Circuit type' and 'Intermediate technology' should get disapper"
					+ "Only circuit reference should display ");
			
			
			circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).isDisplayed();
			sa.assertTrue(circuitref, "circuit reference field is displayed");
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));
			
			boolean CircuitReferencepopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")).isDisplayed();
			
		    while(CircuitReferencepopupalertmsg)	{
			String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
			System.out.println("The alert popup when circuit reference field is clicked is: " + text);
			DriverTestcase.logger.log(LogStatus.PASS,"on clicking circuit reference, alert popup message displays as: "+text);
			
			CircuitReferencepopupalertmsg=false;
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
			Thread.sleep(3000);
		    }	
		
		}
	else if(vpntopology.equals("Point-to-Point")) {
		 
		DriverTestcase.logger.log(LogStatus.INFO,"under VPN topology dropdown for Lanlink Metro service subtype"
					+ " When'Point-to-Point' is selected,'Circuit type' , 'Intermediate technology', 'Circuit Reference' should get displayed");

		
		boolean infoForIntrTech=getwebelement(xml.getlocator("//locators/" + application + "/intermediateTechErrorMessage")).isDisplayed();
		
		System.out.println("intermediate tech popup: "+infoForIntrTech);
		
		Moveon(getwebelement(xml.getlocator("//locators/" + application + "/intermediateTechErrorMessage")));
		
		boolean intermediateTechnologypopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")).isDisplayed();
	
		System.out.println("Boolean check for intermediate popup: "+intermediateTechnologypopupalertmsg);
		sa.assertTrue(intermediateTechnologypopupalertmsg, "Intermediate Technology info message is not getting displayed");
		
//		
//		while(intermediateTechnologypopupalertmsg)	{
//			String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")));
//			System.out.println("the alert popup for intermediate technology is: " + text);
////			DriverTestcase.logger.log(LogStatus.PASS,"Intermediate Technology info message is: "+text);
//			
//			intermediateTechnologypopupalertmsg=false;
//		}
//		
//		infoForIntrTech=false;
//		
//		}
		
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")));
			intermediateTechnology = getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology"))
					.isDisplayed();
			sa.assertTrue(intermediateTechnology, "intermediate technology field is displayed");
			
			
			circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).isDisplayed();
			sa.assertTrue(circuitref, "circuit reference field is displayed");
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));
			
			boolean CircuitReferencepopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")).isDisplayed();
			
			
		    while(CircuitReferencepopupalertmsg)	{
			String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
			System.out.println("The alert popup on clicking circuit reference field is : " + text);
			DriverTestcase.logger.log(LogStatus.PASS," on clicking 'Circuit reference' , alert emssage popup as : "+ text);
			
			CircuitReferencepopupalertmsg=false;
		    }
		    
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
			Thread.sleep(3000);
					
			
			Moveon(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferenceIalert")));
			
			boolean CircuitReferencepopupalerterrmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")).isDisplayed();
			
			
		while(CircuitReferencepopupalerterrmsg)	{
			String text1=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")));
			System.out.println("The alert popup message when mouse hover on circuit reference(i) is: " + text1);
			DriverTestcase.logger.log(LogStatus.INFO," info message for 'Circuit reference' field is; "+text1);
			
			
			CircuitReferencepopupalerterrmsg=false;
		}

		try {
		List<WebElement> listofcircuittypes = driver
				.findElements(By.xpath("//div[@class='div-border div-margin container']//div[@class='row'][3]//span"));
		
		for (WebElement CircuitTypes : listofcircuittypes) {
			int i = 0;
			boolean match = false;
			if (CircuitTypes.getText().equals(Circuittype[i])) {
				match = true;
				Log.info("list of circuit types are : " + CircuitTypes.getText());
				DriverTestcase.logger.log(LogStatus.INFO,"list of circuit ytpes are:  "+CircuitTypes.getText());
				

			} else {

				Log.info("list of circuit types are : " + CircuitTypes.getText());
				
			}

			sa.assertTrue(match);
			i++;
		}
		}catch(Exception e) {
			e.printStackTrace();
			Log.info("Circuit type values are mismatching");
			DriverTestcase.logger.log(LogStatus.FAIL,"list of circuit type values are mismatching");
			
		}	
	}
		
		
	else {
		
		System.out.println(vpntopology+ " is not available inside the VPNtopoloy dropdown");
		Log.info(vpntopology+ " is not available inside the VPNtopoloy dropdown");
		DriverTestcase.logger.log(LogStatus.INFO,vpntopology+ " is not available inside the VPNtopoloy dropdown");
		
	}
		okButton = getwebelement(xml.getlocator("//locators/" + application + "/okbutton")).isDisplayed();
		sa.assertTrue(okButton, "OK button is displayed");
		
		
		cancelButton = getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")).isDisplayed();
		sa.assertTrue(cancelButton, "Cancel button is displayed");
		
			
			
			sa.assertAll();
			DriverTestcase.logger.log(LogStatus.PASS,"Fields under 'lanlink Metro' service subtype is verified");
			
			}catch(AssertionError e) {
				Log.info("Field validation failure for lanlink Metro service");
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL,"Fields under 'lanlink Metro' service subtype is not displaying as expected");
				
			}
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));
			Thread.sleep(3000);
			

		}

		
		
		public void Fieldvalidation_LANlinkMetrowithoutinterfacespeed(String application, String serviceType, String SelectSubService,
				String Interfacespeed,String proActivemonitoring, String vpntopology) throws InterruptedException, DocumentException, IOException {

			try {
			String[] deliverychannel = { "--", "Retail", "Reseller" };

			String[] VPNtopology = { "Point-to-Point", "Hub&Spoke", "E-PN (Any-to-Any)" };

			String[] Circuittype = { "Default", "Composite Circuit", "Extended Circuit" };
			
			String[] notifyManagement= {"--", "Retail", "Reseller"};

			boolean serviceIdentificationField, ServiceType, ServiceSubtype, interfacespeed, singleendpointCPE, email,
					phone, remark, performanceMonitor, deliveryChanel, proactiveMonitor, Managementorder, vpnTopology,
					intermediateTechnology, circuitref, circuitType, nextButton, cancelButton, AggregateTraffic, okButton;

			serviceIdentificationField = getwebelement(
					xml.getlocator("//locators/" + application + "/ServiceIdentification")).isDisplayed();
			sa.assertTrue(serviceIdentificationField, "Service identification field is displayed");
			
			
			ServiceType = (getwebelement("//div[contains(text(),'" + application + "')]")).isDisplayed();
			sa.assertTrue(ServiceType, "Service type is displayed as expected");
						
			ServiceSubtype = getwebelement("//div[contains(text(),'" + SelectSubService + "')]").isDisplayed();
			sa.assertTrue(ServiceSubtype, "Service subtype is displayed as expected");
			
			String interfacespeedautopopulatedvalue=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/interfacespeedvaluepopulated")));
			sa.assertEquals(interfacespeedautopopulatedvalue, Interfacespeed, "Interface speed dropdown is not displaying as expected");
			
			singleendpointCPE = getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")).isDisplayed();
			sa.assertTrue(singleendpointCPE, "single End point CPE checkbox is disabled by default as expected");
			
			email = getwebelement(xml.getlocator("//locators/" + application + "/Email")).isDisplayed();
			sa.assertTrue(email, "email field is displayed");
			
			phone = getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")).isDisplayed();
			sa.assertTrue(phone, "phone contact field is displayed as expected");
			

			remark = getwebelement(xml.getlocator("//locators/" + application + "/Remark")).isDisplayed();
			sa.assertTrue(remark, "remark field si displayed as expected");
			
			performanceMonitor = getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring"))
					.isDisplayed();
			sa.assertTrue(performanceMonitor,
					"performance monitoring checbox is displayed and by default not selected as expected");
			
			proactiveMonitor = getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring"))
					.isDisplayed();
			sa.assertTrue(proactiveMonitor,
					"pro active monitoring checkbox is displayed and by default not selected as expected");
			
			
		if(proActivemonitoring.equalsIgnoreCase("yes")) {
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
			Log.info("Pro active monitoring check box is selected");
		
		boolean notificationManagement=getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement"))
		.isDisplayed();
		sa.assertTrue(notificationManagement, "Notification management dropdown gets displayed when proactive monitoring is selected");
		Log.info("Notification management dropdown gets displayed when proactive monitoring is selected");
		
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
		try {
			List<WebElement> listofnotificationmanagement = driver
					.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement notificationmanagementtypes : listofnotificationmanagement) {

				boolean match = false;
				for (int i = 0; i < notifyManagement.length; i++) {
					if (notificationmanagementtypes.getText().equals(notifyManagement[i])) {
						match = true;
						Log.info("list of notification management are : " + notificationmanagementtypes.getText());
						DriverTestcase.logger.log(LogStatus.PASS,"list of notification management are : " + notificationmanagementtypes.getText());
					}
				}
				sa.assertTrue(match);
				
			}
	      }catch(AssertionError e) {
	    	  Log.info("Notification Management dropdown values are mismatching");
	    	  e.printStackTrace();
	    	  DriverTestcase.logger.log(LogStatus.FAIL,"  values in Notification management dropdown under Lanlink Metro service subtype is not displaying as expected");
	      }
		}else {
		
		Log.info("Notification management dropdown is not available as proactive monitoring is not selected");
		}

		deliveryChanel = getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")).isDisplayed();
			sa.assertTrue(deliveryChanel, "delivery channel dropdown is displayed");
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
	    try {
			List<WebElement> listofdeliverychannel = driver
					.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement deliverychanneltypes : listofdeliverychannel) {

				boolean match = false;
				for (int i = 0; i < deliverychannel.length; i++) {
					if (deliverychanneltypes.getText().equals(deliverychannel[i])) {
						match = true;
						Log.info("list of delivery channel are : " + deliverychanneltypes.getText());
						DriverTestcase.logger.log(LogStatus.PASS," List of Delivery channel dropdown values under Lanlink Metro service subtype are: "+deliverychanneltypes.getText());	
						
					}
				}
				sa.assertTrue(match);
			}
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	Log.info("delivery channel dropdown values are mismatching");
	    	DriverTestcase.logger.log(LogStatus.FAIL,"  values in delivery channel dropdowns under Lanlink Metro service subtype are not displaying as expected");
	    }

	    
	    
	    vpnTopology = getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")).isDisplayed();
		sa.assertTrue(vpnTopology, "vpn topology dropdown is displayed");
		
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
		
		try {
		List<WebElement> listofvpntopology = driver.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
		for (WebElement vpntopologytyeps : listofvpntopology) {

			boolean match = false;
			for (int i = 0; i < VPNtopology.length; i++) {
				if (vpntopologytyeps.getText().equals(VPNtopology[i])) {
					match = true;
					Log.info("list of vpn topologies are : " + vpntopologytyeps.getText());
					System.out.println("list of vpn topologies: "+vpntopologytyeps.getText());
					DriverTestcase.logger.log(LogStatus.PASS,"list of vpn topologies: "+vpntopologytyeps.getText());
					
				}
			}
			sa.assertTrue(match);
		}
		}catch(Exception e) {
			e.printStackTrace();
			Log.info("vpn topology dropdown values are mismatching");
			DriverTestcase.logger.log(LogStatus.FAIL,"values in VPN topology dropdown under Lanlink Metro service subtype is not displaying as expected");
		}
		
		
		Clickon(getwebelement("//span[contains(text(),'"+vpntopology +"')]"));
		Thread.sleep(3000);
		
		
			if(vpntopology.equals("E-PN (Any-to-Any)")) {
				
				Log.info("Under 'VPN Topology', When 'E-PN (Any-to-Any)' is selected,'Circuit type' and 'Intermediate technology' should get disapper"
						+ "only circuit reference should should appear ");
				
				DriverTestcase.logger.log(LogStatus.INFO,"Under 'VPN Topology', When 'E-PN (Any-to-Any)' is selected,'Circuit type' and 'Intermediate technology' should get disapper"
						+ "only circuit reference should should appear ");
						
				circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).isDisplayed();
				sa.assertTrue(circuitref, "circuit reference field is displayed");
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));
				
				boolean CircuitReferencepopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")).isDisplayed();
				
			    while(CircuitReferencepopupalertmsg)	{
				String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
				DriverTestcase.logger.log(LogStatus.PASS, "On clicking circuit reference field alert popup displays as: "+text);
				
				CircuitReferencepopupalertmsg=false;
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
				
			}
			    
		}	    
			  else if(vpntopology.equals("Hub&Spoke") ) {
				

					Log.info("Under 'VPN Topology', When modular msp is selected and 'Hub&Spoke' is selected,"
							+ "'Circuit type', 'circuit reference' and 'Intermediate technology' should get disapper");
			    
					DriverTestcase.logger.log(LogStatus.INFO,"Under 'VPN Topology', When modular msp is selected and 'Hub&Spoke' is selected,\"\n" + 
							"							+ \"'Circuit type', 'circuit reference' and 'Intermediate technology' should get disapper");
		      }
			
		else if(vpntopology.equals("Point-to-Point")) {
			 
			DriverTestcase.logger.log(LogStatus.INFO,"under VPN topology dropdown for Lanlink Metro service subtype"
						+ " When'Point-to-Point' is selected,'Circuit type' , 'Intermediate technology', 'Circuit Reference' should get displayed");

			Moveon(getwebelement(xml.getlocator("//locators/" + application + "/intermediateTechErrorMessage")));
			
			boolean intermediateTechnologypopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")).isDisplayed();
			
			while(intermediateTechnologypopupalertmsg)	{
				String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")));
				System.out.println("the alert popup for intermediate technology is: " + text);
				DriverTestcase.logger.log(LogStatus.PASS,"Intermediate Technology info message is: "+text);
				
				intermediateTechnologypopupalertmsg=false;
			}
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")));
				intermediateTechnology = getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology"))
						.isDisplayed();
				sa.assertTrue(intermediateTechnology, "intermediate technology field is displayed");
				
				
				circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).isDisplayed();
				sa.assertTrue(circuitref, "circuit reference field is displayed");
				
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));
				
				boolean CircuitReferencepopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")).isDisplayed();
				
				
			    while(CircuitReferencepopupalertmsg)	{
				String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
				System.out.println("The alert popup on clicking circuit reference field is : " + text);
				DriverTestcase.logger.log(LogStatus.PASS," on clicking 'Circuit reference' , alert emssage popup as : "+ text);
				
				CircuitReferencepopupalertmsg=false;
			    }
			    
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
				Thread.sleep(3000);
						
				
				Moveon(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferenceIalert")));
				
				boolean CircuitReferencepopupalerterrmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")).isDisplayed();
				
				
			while(CircuitReferencepopupalerterrmsg)	{
				String text1=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")));
				System.out.println("The alert popup message when mouse hover on circuit reference(i) is: " + text1);
				DriverTestcase.logger.log(LogStatus.PASS," info message for 'Circuit reference' field is; "+text1);
				
				
				CircuitReferencepopupalerterrmsg=false;
			}

			try {
			List<WebElement> listofcircuittypes = driver
					.findElements(By.xpath("//div[@class='div-border div-margin container']//div[@class='row'][3]//span"));
			
			for (WebElement CircuitTypes : listofcircuittypes) {
				int i = 0;
				boolean match = false;
				if (CircuitTypes.getText().equals(Circuittype[i])) {
					match = true;
					Log.info("list of circuit types are : " + CircuitTypes.getText());
					DriverTestcase.logger.log(LogStatus.PASS,"list of circuit ytpes are:  "+CircuitTypes.getText());
					

				} else {

					Log.info("list of circuit types are : " + CircuitTypes.getText());
					
				}

				sa.assertTrue(match);
				
				i++;
			}
			}catch(Exception e) {
				e.printStackTrace();
				Log.info("Circuit type values are mismatching");
				DriverTestcase.logger.log(LogStatus.FAIL,"list of circuit type values are mismatching");
				
			}	
		}
			
			
	else {
			
			System.out.println(vpntopology+ " is not available inside the VPNtopoloy dropdown");
			Log.info(vpntopology+ " is not available inside the VPNtopoloy dropdown");
			DriverTestcase.logger.log(LogStatus.FAIL,vpntopology+ " is not available inside the VPNtopoloy dropdown");
		}

			okButton = getwebelement(xml.getlocator("//locators/" + application + "/okbutton")).isDisplayed();
			sa.assertTrue(okButton, "OK button is displayed");
			
			
			cancelButton = getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")).isDisplayed();
			sa.assertTrue(cancelButton, "Cancel button is displayed");
			
			
			sa.assertAll();
			DriverTestcase.logger.log(LogStatus.PASS,"Fields under 'Lanlink Metro' service subtype is verified");
			
			}catch(AssertionError e) {
				Log.info("Field validation failure for lanlink Metro service");
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL,"Fields under 'lanlink Metro' service subtype is not displaying as expected");
				
			}
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));
			Thread.sleep(3000);
			

		}

		
		
		
		public void Fieldvalidation_LANlinkNational(String application, String serviceType, String SelectSubService,
				String Interfacespeed,String proActivemonitoring, String vpntopology, String aggregateTraffic) throws InterruptedException, DocumentException, IOException {

		try {
			String[] deliverychannel = { "--", "Retail", "Reseller" };

			String[] VPNtopology = { "Point-to-Point", "Hub&Spoke", "E-PN (Any-to-Any)" };

			String[] Circuittype = { "Default", "Composite Circuit", "Extended Circuit" };

			String[] notifyManagement = { "--", "Retail", "Reseller" };

			boolean serviceIdentificationField, ServiceType, ServiceSubtype, interfacespeed, singleendpointCPE, email,
					phone, remark, performanceMonitor, deliveryChanel, proactiveMonitor, Managementorder, vpnTopology,
					intermediateTechnology, circuitref, circuitType, nextButton, cancelButton, AggregateTraffic,
					okButton;

			serviceIdentificationField = (getwebelement(
					xml.getlocator("//locators/" + application + "/ServiceIdentification")).getSize()) != null;
			sa.assertTrue(serviceIdentificationField, "Service identification field is displayed");
			System.out.println("the size of service identification is: " + serviceIdentificationField);
			
			ServiceType = (getwebelement("//div[contains(text(),'" + application + "')]")).isDisplayed();
			sa.assertTrue(ServiceType, "Service type is displayed as expected");
			
			ServiceSubtype = getwebelement("//div[contains(text(),'" + SelectSubService + "')]").isDisplayed();
			sa.assertTrue(ServiceSubtype, "Service subtype is displayed as expected");
			
			String interfacespeedautopopulatedvalue = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/interfacespeedvaluepopulated")));
			sa.assertEquals(interfacespeedautopopulatedvalue, Interfacespeed,
					"Interface speed is autopopulated as expected");
			
			singleendpointCPE = getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE"))
					.isDisplayed();
			sa.assertTrue(singleendpointCPE, "single End point CPE checkbox is disabled by default as expected");
			
			email = getwebelement("//div[label[contains(text(),'Email')]]//input").isDisplayed();
			sa.assertTrue(email, "email field is displayed");
			
			phone = getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")).isDisplayed();
			sa.assertTrue(phone, "phone contact field is displayed as expected");
			
			remark = getwebelement(xml.getlocator("//locators/" + application + "/Remark")).isDisplayed();
			sa.assertTrue(remark, "remark field si displayed as expected");
			
			performanceMonitor = getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring"))
					.isDisplayed();
			sa.assertTrue(performanceMonitor,
					"performance monitoring checbox is displayed and by default not selected as expected");
		
			proactiveMonitor = getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring"))
					.isDisplayed();
			sa.assertTrue(proactiveMonitor,
					"pro active monitoring checkbox is displayed and by default not selected as expected");
		
			if (proActivemonitoring.equalsIgnoreCase("yes")) {
				DriverTestcase.logger.log(LogStatus.INFO,
						"If proactive Monitor checkbox is selected under Lanlink National service subtype, Notification management dropdown should occur");

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
				Log.info("Pro active monitoring check box is selected");
				Thread.sleep(2000);

				boolean notificationManagement = getwebelement(
						xml.getlocator("//locators/" + application + "/notificationmanagement")).isDisplayed();
				sa.assertTrue(notificationManagement,
						"Notification management dropdown gets displayed when proactive monitoring is selected");
				Log.info("Notification management dropdown gets displayed when proactive monitoring is selected");

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
				try {
					List<WebElement> listofnotificationmanagement = driver
							.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
					for (WebElement notificationmanagementtypes : listofnotificationmanagement) {

						boolean match = false;
						for (int i = 0; i < notifyManagement.length; i++) {
							if (notificationmanagementtypes.getText().equals(notifyManagement[i])) {
								match = true;
								Log.info("list of notification management are : "
										+ notificationmanagementtypes.getText());
								DriverTestcase.logger.log(LogStatus.PASS,"list of Notification mnagement dropdown values under Lanlink National service subtype are: "
												+ notificationmanagementtypes.getText());
							}
						}
						sa.assertTrue(match);
					}
				} catch (AssertionError e) {
					Log.info("Notification Management dropdown values are mismatching");
					e.printStackTrace();
					DriverTestcase.logger.log(LogStatus.FAIL,
							"Notification mnagement dropdown values under Lanlink National service subtype is not displaying as expected");
				}

			} else {

				Log.info("Notification management dropdown is available as proactive monitoring is not selected");
				DriverTestcase.logger.log(LogStatus.INFO,
						"Notification mnagement dropdown under Lanlink National service subtype is not available as proactive monitoring is not selected");
			}

			deliveryChanel = getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel"))
					.isDisplayed();
			sa.assertTrue(deliveryChanel, "delivery channel dropdown is displayed");
		
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
			try {
				List<WebElement> listofdeliverychannel = driver
						.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
				for (WebElement deliverychanneltypes : listofdeliverychannel) {

					boolean match = false;
					for (int i = 0; i < deliverychannel.length; i++) {
						if (deliverychanneltypes.getText().equals(deliverychannel[i])) {
							match = true;
							Log.info("list of delivery channel are : " + deliverychanneltypes.getText());
							DriverTestcase.logger.log(LogStatus.PASS,"list of delivery channel dropdown values under Lanlink National service subtype are: "
											+ deliverychanneltypes.getText());
						}
					}
					sa.assertTrue(match);
				
				}
			} catch (Exception e) {
				e.printStackTrace();
				Log.info("delivery channel dropdown values are mismatching");
				DriverTestcase.logger.log(LogStatus.FAIL,
						"Delivery channel dropdown values under Lanlink National service subtype is not getting dispalyed as expected");

			}

			DriverTestcase.logger.log(LogStatus.INFO,"When modular msp is not selected under Lanlink National service subtype "
							+ " Interface speed dropdown should display ");

			if (Interfacespeed.equals("10Gige")) {

				DriverTestcase.logger.log(LogStatus.INFO,"When Interfacespeed is '10GigE' under Lanlink National service subtype "
								+ "we should get 'Aggregate traffic checkbox' ");

				AggregateTraffic = getwebelement(
						xml.getlocator("//locators/" + application + "/Aggregate_10Gig_1Gig_Traffic")).isDisplayed();
				sa.assertTrue(AggregateTraffic,
						"Aggregate 10Gig-1Gig Traffic is displayed and by default not selected as expected");
				System.out.println("aggreegate traffic check box is displayed");
			
				vpnTopology = getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")).isDisplayed();
				sa.assertTrue(vpnTopology, "vpn topology dropdown is displayed");
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));

				try {
					List<WebElement> listofvpntopology = driver
							.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
					for (WebElement vpntopologytyeps : listofvpntopology) {

						boolean match = false;
						for (int i = 0; i < VPNtopology.length; i++) {
							if (vpntopologytyeps.getText().equals(VPNtopology[i])) {
								match = true;
								Log.info("list of vpn topologies are : " + vpntopologytyeps.getText());
								DriverTestcase.logger.log(LogStatus.PASS,"VPN topology dropdown default values for 10Gige under lanlink National service subtype are: "
												+ vpntopologytyeps.getText());

							}
						}
						sa.assertTrue(match);
					
					}
				} catch (Exception e) {
					e.printStackTrace();
					Log.info("vpn topology dropdown values are mismatching");
					DriverTestcase.logger.log(LogStatus.FAIL,
							"Default dropdown values in VPN topology dropdown for 10Gige under Lanlink National service subtype is not getting displayed");

				}

				if (!aggregateTraffic.equalsIgnoreCase("yes")) {

					Clickon(getwebelement("//span[contains(text(),'" + vpntopology + "')]"));
					Thread.sleep(3000);

					DriverTestcase.logger.log(LogStatus.INFO, "when 'Aggregate traffic'  is not selected, then"
							+ "VPN topology dropdown should have 'Point-to-point', 'E-PN(Any-to-Any)' and 'Hub&spoke'");

					if (vpntopology.equals("E-PN (Any-to-Any)")) {

						Log.info(
								"Under 'VPN Topology', When 'E-PN (Any-to-Any)' is selected,'Circuit type' and 'Intermediate technology' should get disapper ");
						DriverTestcase.logger.log(LogStatus.INFO,
								"under VPN topology dropdown for Lanlink National service subtype"
										+ " When'E-PN (Any-to-Any)' is selected,'Circuit type' and 'Intermediate technology' should get disapper , only 'circuit reference' field should appear");

						circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference"))
								.isDisplayed();
						sa.assertTrue(circuitref, "circuit reference field is displayed");
						
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));

						boolean CircuitReferencepopupalertmsg = getwebelement(
								xml.getlocator("//locators/" + application + "/circuitreferencealertmessage"))
										.isDisplayed();
						
						while (CircuitReferencepopupalertmsg) {
							String text = Gettext(getwebelement(
									xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
							System.out.println("The alert popup when circuit reference field is clicked is: " + text);
							CircuitReferencepopupalertmsg = false;
							DriverTestcase.logger.log(LogStatus.PASS,
									"circuit reference alert popu message is: " + text);

							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
							Thread.sleep(3000);

						}

					}

					else if (vpntopology.equals("Hub&Spoke")) {

						Log.info(
								"Under 'VPN Topology', When Aggregate traffic is not selected and 'Hub&Spoke' is selected,'Circuit type', 'Cicuit Reference' and 'Intermediate technology' should get disapper ");

						System.out.println(
								"Under 'VPN Topology', When Aggregate traffic is not selected and 'Hub&Spoke' is selected,"
										+ "'Circuit type', 'Cicuit Reference' and 'Intermediate technology' should get disapper ");

						DriverTestcase.logger.log(LogStatus.INFO,
								"under VPN topology dropdown for Lanlink National service subtype"
										+ " When'Hub&Spoke' is selected,'Circuit type' , 'Intermediate technology', 'Circuit Reference' should get disapper");

					}

					else if (vpntopology.equals("Point-to-Point")) {

						DriverTestcase.logger.log(LogStatus.INFO,
								"under VPN topology dropdown for Lanlink National service subtype"
										+ " When'Point-to-Point' is selected,'Circuit type' , 'Intermediate technology', 'Circuit Reference' should get displayed");

						Moveon(getwebelement(
								xml.getlocator("//locators/" + application + "/intermediateTechErrorMessage")));

						boolean intermediateTechnologypopupalertmsg = getwebelement(
								xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup"))
										.isDisplayed();
						
						while (intermediateTechnologypopupalertmsg) {
							String text = Gettext(getwebelement(
									xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")));
							System.out.println("the alert popup for intermediate technology is: " + text);
							DriverTestcase.logger.log(LogStatus.PASS,
									"Intermediate Technology info message is: " + text);

							intermediateTechnologypopupalertmsg = false;
						}

						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")));
						intermediateTechnology = getwebelement(
								xml.getlocator("//locators/" + application + "/IntermediateTechnology")).isDisplayed();
						sa.assertTrue(intermediateTechnology, "intermediate technology field is displayed");
						
						circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference"))
								.isDisplayed();
						sa.assertTrue(circuitref, "circuit reference field is displayed");
						
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));

						boolean CircuitReferencepopupalertmsg = getwebelement(
								xml.getlocator("//locators/" + application + "/circuitreferencealertmessage"))
										.isDisplayed();
					
						while (CircuitReferencepopupalertmsg) {
							String text = Gettext(getwebelement(
									xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
							System.out.println("The alert popup on clicking circuit reference field is : " + text);
							DriverTestcase.logger.log(LogStatus.PASS,
									" on clicking 'Circuit reference' , alert emssage popup as : " + text);

							CircuitReferencepopupalertmsg = false;
						}

						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
						Thread.sleep(3000);

						Moveon(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferenceIalert")));

						boolean CircuitReferencepopupalerterrmsg = getwebelement(
								xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg"))
										.isDisplayed();
						
						while (CircuitReferencepopupalerterrmsg) {
							String text1 = Gettext(getwebelement(
									xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")));
							System.out.println(
									"The alert popup message when mouse hover on circuit reference(i) is: " + text1);
							DriverTestcase.logger.log(LogStatus.PASS,
									" info message for 'Circuit reference' field is; " + text1);

							CircuitReferencepopupalerterrmsg = false;
						}

						try {
							List<WebElement> listofcircuittypes = driver.findElements(By.xpath(
									"//div[@class='div-border div-margin container']//div[@class='row'][3]//span"));

							for (WebElement CircuitTypes : listofcircuittypes) {
								int i = 0;
								boolean match = false;
								if (CircuitTypes.getText().equals(Circuittype[i])) {
									match = true;
									Log.info("list of circuit types are : " + CircuitTypes.getText());
									
									DriverTestcase.logger.log(LogStatus.PASS,"list of circuit ytpes are:  " + CircuitTypes.getText());

								} else {

									Log.info("list of circuit types are : " + CircuitTypes.getText());

								}

								sa.assertTrue(match);
								i++;
							}
						} catch (Exception e) {
							e.printStackTrace();
							Log.info("Circuit type values are mismatching");
							DriverTestcase.logger.log(LogStatus.FAIL,"circuit types values are mismstaching");
						}

					}

					else {

						System.out.println(vpntopology + " is not available inside the VPNtopoloy dropdown");
						Log.info(vpntopology + " is not available inside the VPNtopoloy dropdown");
						DriverTestcase.logger.log(LogStatus.FAIL,
								vpntopology + " is not available inside vpn topology dropdown");

					}

				}

				else if (aggregateTraffic.equalsIgnoreCase("yes")) {

					Clickon(getwebelement(
							xml.getlocator("//locators/" + application + "/Aggregate_10Gig_1Gig_Traffic")));

					DriverTestcase.logger.log(LogStatus.INFO, "when 'Aggregate traffic'  is selected, then"
							+ "VPN topology dropdown should have 'E-PN(Any-to-Any)' and 'Hub&spoke' ");

					Clickon(getwebelement("//span[contains(text(),'" + vpntopology + "')]"));
					Thread.sleep(3000);

					if (vpntopology.equals("E-PN (Any-to-Any)") || vpntopology.equals("Hub&Spoke")) {

						Log.info("Under 'VPN Topology', When Aggregare traffic is selected "
								+ " And when 'Hub&Spoke' or 'E-PN (Any-to-Any)' is selected,'Circuit type' and 'Intermediate technology' should get disapper, circuit reference field will be available ");

						DriverTestcase.logger.log(LogStatus.INFO,
								"under VPN topology dropdown for Lanlink International service subtype"
										+ " When'E-PN (Any-to-Any)' or 'hub & spoke'  is selected,'Circuit type' and 'Intermediate technology' should get disapper , only 'circuit reference' field should appear");

						circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference"))
								.isDisplayed();
						sa.assertTrue(circuitref, "circuit reference field is displayed");
						
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));

						boolean CircuitReferencepopupalertmsg = getwebelement(
								xml.getlocator("//locators/" + application + "/circuitreferencealertmessage"))
										.isDisplayed();
						
						while (CircuitReferencepopupalertmsg) {
							String text = Gettext(getwebelement(
									xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
							System.out.println("The alert popup when circuit reference field is clicked is: " + text);
							DriverTestcase.logger.log(LogStatus.PASS,
									"on clicking circuit reference, alert popup message displays as: " + text);

							CircuitReferencepopupalertmsg = false;
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
							Thread.sleep(3000);
						}

						Moveon(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferenceIalert")));

						boolean CircuitReferencepopupalerterrmsg = getwebelement(
								xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg"))
										.isDisplayed();
						
						while (CircuitReferencepopupalerterrmsg) {
							String text1 = Gettext(getwebelement(
									xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")));
							System.out.println(
									"The alert popup message when mouse hover on circuit reference(i) is: " + text1);
							DriverTestcase.logger.log(LogStatus.PASS,
									"The alert popup message when mouse hover on circuit reference(i) is: " + text1);

							CircuitReferencepopupalerterrmsg = false;
						}

					}

					else {

						System.out.println(vpntopology + " is not available inside the VPNtopoloy dropdown");
						Log.info(vpntopology + " is not available inside the VPNtopoloy dropdown");
						DriverTestcase.logger.log(LogStatus.FAIL,
								vpntopology + " is not available inside the VPNtopoloy dropdown");
					}

				}
			}

			else if (Interfacespeed.equals("1Gige")) {

				DriverTestcase.logger.log(LogStatus.INFO,"When Interfacespeed is '1GigE' under Lanlink National service subtype "
								+ "we shouldn not get 'Aggregate traffic checkbox' ");

				vpnTopology = getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")).isDisplayed();
				sa.assertTrue(vpnTopology, "vpn topology dropdown is displayed");
			
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
				try {
					List<WebElement> listofvpntopology = driver
							.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
					for (WebElement vpntopologytyeps : listofvpntopology) {

						boolean match = false;
						for (int i = 0; i < VPNtopology.length; i++) {
							if (vpntopologytyeps.getText().equals(VPNtopology[i])) {
								match = true;
								Log.info("list of vpn topologies are : " + vpntopologytyeps.getText());
								System.out.println("list of vpn topologies: " + vpntopologytyeps.getText());
								DriverTestcase.logger.log(LogStatus.PASS,
										"By default VPN topology dropdown  value under Lanlink National are: "
												+ vpntopologytyeps.getText());

							}
						}
						sa.assertTrue(match);
					
					}
				} catch (Exception e) {
					Log.info("vpn topology dropdown values are mismatching");
					DriverTestcase.logger.log(LogStatus.FAIL,
							"VPN topology dropdown values under Lanlink National are not getting displayed as expected ");

				}

				if (vpntopology.equals("Hub&Spoke") || vpntopology.equals("E-PN (Any-to-Any)")) {

					Log.info(
							"Under 'VPN Topology', When 'Hub&Spoke' or 'E-PN (Any-to-Any)' are selected, 'Circuit type' and 'Intermediate technology' should get disapper ");

					DriverTestcase.logger.log(LogStatus.INFO,
							"Under 'VPN Topology' for '1GigE' interface speed, When 'Hub&Spoke' or 'E-PN (Any-to-Any)' are selected, 'Circuit type' and 'Intermediate technology' should get disapper "
							+ " 'Circuit reference' field should display");

					circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference"))
							.isDisplayed();
					sa.assertTrue(circuitref, "circuit reference field is displayed");
					
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));

					boolean CircuitReferencepopupalertmsg = getwebelement(
							xml.getlocator("//locators/" + application + "/circuitreferencealertmessage"))
									.isDisplayed();
				
					while (CircuitReferencepopupalertmsg) {
						String text = Gettext(getwebelement(
								xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
						System.out.println("The alert popup when circuit reference field is clicked is: " + text);
						DriverTestcase.logger.log(LogStatus.PASS,
								"on clicking circuit reference, alert popup message displays as: " + text);

						CircuitReferencepopupalertmsg = false;
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
						Thread.sleep(3000);
					}
				}

				else if (vpntopology.equals("Point-to-Point")) {

					DriverTestcase.logger.log(LogStatus.INFO,
							"under VPN topology dropdown for Lanlink National service subtype"
									+ " When'Point-to-Point' is selected,'Circuit type' , 'Intermediate technology', 'Circuit Reference' should get displayed");

					Moveon(getwebelement(
							xml.getlocator("//locators/" + application + "/intermediateTechErrorMessage")));

					boolean intermediateTechnologypopupalertmsg = getwebelement(
							xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")).isDisplayed();
				
					while (intermediateTechnologypopupalertmsg) {
						String text = Gettext(getwebelement(
								xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")));
						System.out.println("the alert popup for intermediate technology is: " + text);
						DriverTestcase.logger.log(LogStatus.PASS, "Intermediate Technology info message is: " + text);

						intermediateTechnologypopupalertmsg = false;
					}

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")));
					intermediateTechnology = getwebelement(
							xml.getlocator("//locators/" + application + "/IntermediateTechnology")).isDisplayed();
					sa.assertTrue(intermediateTechnology, "intermediate technology field is displayed");
					
					circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference"))
							.isDisplayed();
					sa.assertTrue(circuitref, "circuit reference field is displayed");
					
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));

					boolean CircuitReferencepopupalertmsg = getwebelement(
							xml.getlocator("//locators/" + application + "/circuitreferencealertmessage"))
									.isDisplayed();
				
					while (CircuitReferencepopupalertmsg) {
						String text = Gettext(getwebelement(
								xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
						System.out.println("The alert popup on clicking circuit reference field is : " + text);
						DriverTestcase.logger.log(LogStatus.PASS,
								" on clicking 'Circuit reference' , alert emssage popup as : " + text);

						CircuitReferencepopupalertmsg = false;
					}

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
					Thread.sleep(3000);

					Moveon(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferenceIalert")));

					boolean CircuitReferencepopupalerterrmsg = getwebelement(
							xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")).isDisplayed();
					
					while (CircuitReferencepopupalerterrmsg) {
						String text1 = Gettext(getwebelement(
								xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")));
						System.out.println(
								"The alert popup message when mouse hover on circuit reference(i) is: " + text1);
						DriverTestcase.logger.log(LogStatus.PASS,
								" info message for 'Circuit reference' field is; " + text1);

						CircuitReferencepopupalerterrmsg = false;
					}

					try {
						List<WebElement> listofcircuittypes = driver.findElements(By
								.xpath("//div[@class='div-border div-margin container']//div[@class='row'][3]//span"));

						for (WebElement CircuitTypes : listofcircuittypes) {
							int i = 0;
							boolean match = false;
							if (CircuitTypes.getText().equals(Circuittype[i])) {
								match = true;
								Log.info("list of circuit types are : " + CircuitTypes.getText());
								DriverTestcase.logger.log(LogStatus.PASS,"list of circuit ytpes are:  " + CircuitTypes.getText());

							} else {

								Log.info("list of circuit types are : " + CircuitTypes.getText());

							}

							sa.assertTrue(match);
							i++;
						}
					} catch (Exception e) {
						e.printStackTrace();
						Log.info("Circuit type values are mismatching");
						DriverTestcase.logger.log(LogStatus.FAIL,"Circuit type values are mismatching");
					}

				}

				else {

					System.out.println(vpntopology + " is not available inside the VPNtopoloy dropdown");
					Log.info(vpntopology + " is not available inside the VPNtopoloy dropdown");
					DriverTestcase.logger.log(LogStatus.FAIL,
							vpntopology + " is not available inside the VPNtopoloy dropdown");

				}

			}

			else {
				System.out.println("The selected Interface speed"+Interfacespeed+" is not available");
				DriverTestcase.logger.log(LogStatus.FAIL, "The select interface speed is not avaiable");

			}

			okButton = getwebelement(xml.getlocator("//locators/" + application + "/okbutton")).isDisplayed();
			sa.assertTrue(okButton, "OK button is displayed");
			
			cancelButton = getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")).isDisplayed();
			sa.assertTrue(cancelButton, "Cancel button is diaplayed");
			
			sa.assertAll();

		}catch(AssertionError e) {
				Log.info("Field validation failure under Lanlink National service");
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL,"Fields under 'lanlink National' service subtype is not displaying as expected");
				
			}
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));
			Thread.sleep(3000);

			
		}

		
		
		public void Fieldvalidation_LANlinkNationalwithoutinterfacespeed(String application, String serviceType, String SelectSubService,
				String Interfacespeed,String proActivemonitoring, String vpntopology, String aggregateTraffic) throws InterruptedException, DocumentException, IOException {

			try {
			String[] deliverychannel = { "--", "Retail", "Reseller" };

			String[] VPNtopology = { "Point-to-Point", "Hub&Spoke", "E-PN (Any-to-Any)" };

			String[] Circuittype = { "Default", "Composite Circuit", "Extended Circuit" };
			
			String[] notifyManagement= {"--", "Retail", "Reseller"}; 
			

			boolean serviceIdentificationField, ServiceType, ServiceSubtype, interfacespeed, singleendpointCPE, email,
					phone, remark, performanceMonitor, deliveryChanel, proactiveMonitor, Managementorder, vpnTopology,
					intermediateTechnology, circuitref, circuitType, nextButton, cancelButton, AggregateTraffic, okButton;

			serviceIdentificationField = (getwebelement(
					xml.getlocator("//locators/" + application + "/ServiceIdentification")).getSize()) != null;
			sa.assertTrue(serviceIdentificationField, "Service identification field is displayed");
						ServiceType = (getwebelement("//div[contains(text(),'" + application + "')]")).isDisplayed();
			sa.assertTrue(ServiceType, "Service type is displayed as expected");
						ServiceSubtype = getwebelement("//div[contains(text(),'" + SelectSubService + "')]").isDisplayed();
			sa.assertTrue(ServiceSubtype, "Service subtype is displayed as expected");
			
			String interfacespeedautopopulatedvalue = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/interfacespeedvaluepopulated")));
			sa.assertEquals(interfacespeedautopopulatedvalue, Interfacespeed,
					"Interface speed is autopopulated as expected");
			
			singleendpointCPE = getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE"))
					.isDisplayed();
			sa.assertTrue(singleendpointCPE, "single End point CPE checkbox is disabled by default as expected");
			
			email = getwebelement("//div[label[contains(text(),'Email')]]//input").isDisplayed();
			sa.assertTrue(email, "email field is displayed");
			
			phone = getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")).isDisplayed();
			sa.assertTrue(phone, "phone contact field is displayed as expected");
			
			remark = getwebelement(xml.getlocator("//locators/" + application + "/Remark")).isDisplayed();
			sa.assertTrue(remark, "remark field si displayed as expected");
			
			performanceMonitor = getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring"))
					.isDisplayed();
			sa.assertTrue(performanceMonitor,
					"performance monitoring checbox is displayed and by default not selected as expected");
			
			proactiveMonitor = getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring"))
					.isDisplayed();
			sa.assertTrue(proactiveMonitor,
					"pro active monitoring checkbox is displayed and by default not selected as expected");
			
			if (proActivemonitoring.equalsIgnoreCase("yes")) {
				DriverTestcase.logger.log(LogStatus.INFO,
						"If proactive Monitor checkbox is selected under Lanlink National service subtype, Notification management dropdown should occur");

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
				Log.info("Pro active monitoring check box is selected");
				Thread.sleep(2000);

				boolean notificationManagement = getwebelement(
						xml.getlocator("//locators/" + application + "/notificationmanagement")).isDisplayed();
				sa.assertTrue(notificationManagement,
						"Notification management dropdown gets displayed when proactive monitoring is selected");
				Log.info("Notification management dropdown gets displayed when proactive monitoring is selected");
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
				try {
					List<WebElement> listofnotificationmanagement = driver
							.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
					for (WebElement notificationmanagementtypes : listofnotificationmanagement) {

						boolean match = false;
						for (int i = 0; i < notifyManagement.length; i++) {
							if (notificationmanagementtypes.getText().equals(notifyManagement[i])) {
								match = true;
								Log.info("list of notification management are : "
										+ notificationmanagementtypes.getText());
								DriverTestcase.logger.log(LogStatus.PASS,"list of Notification mnagement dropdown values under Lanlink National service subtype are: "
												+ notificationmanagementtypes.getText());
							}
						}
						sa.assertTrue(match);
						
					}
				} catch (AssertionError e) {
					Log.info("Notification Management dropdown values are mismatching");
					e.printStackTrace();
					DriverTestcase.logger.log(LogStatus.FAIL,
							"Notification mnagement dropdown values under Lanlink National service subtype is not displaying as expected");
				}

			} else {

				Log.info("Notification management dropdown is available as proactive monitoring is not selected");
				DriverTestcase.logger.log(LogStatus.INFO,
						"Notification mnagement dropdown under Lanlink National service subtype is not available as proactive monitoring is not selected");
			}

			deliveryChanel = getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel"))
					.isDisplayed();
			sa.assertTrue(deliveryChanel, "delivery channel dropdown is displayed");
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
			try {
				List<WebElement> listofdeliverychannel = driver
						.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
				for (WebElement deliverychanneltypes : listofdeliverychannel) {

					boolean match = false;
					for (int i = 0; i < deliverychannel.length; i++) {
						if (deliverychanneltypes.getText().equals(deliverychannel[i])) {
							match = true;
							Log.info("list of delivery channel are : " + deliverychanneltypes.getText());
							DriverTestcase.logger.log(LogStatus.PASS,"list of delivery channel dropdown values under Lanlink National service subtype are: "
											+ deliverychanneltypes.getText());
						}
					}
					sa.assertTrue(match);
								}
			} catch (Exception e) {
				e.printStackTrace();
				Log.info("delivery channel dropdown values are mismatching");
				DriverTestcase.logger.log(LogStatus.FAIL,
						"Delivery channel dropdown values under Lanlink National service subtype is not getting dispalyed as expected");

			}

	     
	     vpnTopology = getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")).isDisplayed();
			sa.assertTrue(vpnTopology, "vpn topology dropdown is displayed");
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
			try {
			List<WebElement> listofvpntopology = driver.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement vpntopologytyeps : listofvpntopology) {

				boolean match = false;
				for (int i = 0; i < VPNtopology.length; i++) {
					if (vpntopologytyeps.getText().equals(VPNtopology[i])) {
						match = true;
						Log.info("list of vpn topologies are : " + vpntopologytyeps.getText());
						System.out.println("list of vpn topologies: "+vpntopologytyeps.getText());
						DriverTestcase.logger.log(LogStatus.PASS, " list of vpn topology values are: "+vpntopologytyeps.getText());
								
					}
				}
				sa.assertTrue(match);

			}
		}catch(Exception e) {
			Log.info("vpn topology dropdown values are mismatching");
			DriverTestcase.logger.log(LogStatus.FAIL,"VPN topology values are mismatching"); 
		}
			
			Clickon(getwebelement("//span[contains(text(),'"+vpntopology +"')]"));
			Thread.sleep(3000);
			
	if(vpntopology.equals("E-PN (Any-to-Any)")) {
				
				Log.info("Under 'VPN Topology', When modular msp is selected and 'E-PN (Any-to-Any)' is selected,"
						+ "'Circuit type' and 'Intermediate technology' should get disapper"
						+ "only circuit reference should should appear ");
				
				DriverTestcase.logger.log(LogStatus.INFO, "Under 'VPN Topology', When modular msp is selected and 'E-PN (Any-to-Any)' is selected,"
						+ "'Circuit type' and 'Intermediate technology' should get disapper"
						+ "only circuit reference should should appear ");
				
				circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).isDisplayed();
				sa.assertTrue(circuitref, "circuit reference field is displayed");
								
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));
				
				boolean CircuitReferencepopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")).isDisplayed();
								
			    while(CircuitReferencepopupalertmsg)	{
				String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
				System.out.println("The alert popup when circuit reference field is clicked is: " + text);
				DriverTestcase.logger.log(LogStatus.PASS,"The alert popup when circuit reference field is clicked is: " + text);
				CircuitReferencepopupalertmsg=false;
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
				
			}
			    
		}	    
			  else if(vpntopology.equals("Hub&Spoke") ) {
					

					Log.info("Under 'VPN Topology', When modular msp is selected and'Hub&Spoke' is selected,"
							+ "'Circuit type', 'circuit reference' and 'Intermediate technology' should get disapper");
					
					DriverTestcase.logger.log(LogStatus.INFO,"Under 'VPN Topology', When modular msp is selected and'Hub&Spoke' is selected,"
							+ "'Circuit type', 'circuit reference' and 'Intermediate technology' should get disapper");
			    
		      }
			
		else if(vpntopology.equals("Point-to-Point")) {
			


			DriverTestcase.logger.log(LogStatus.INFO,
					"under VPN topology dropdown for Lanlink National service subtype"
							+ " When'Point-to-Point' is selected,'Circuit type' , 'Intermediate technology', 'Circuit Reference' should get displayed");

			Moveon(getwebelement(
					xml.getlocator("//locators/" + application + "/intermediateTechErrorMessage")));

			boolean intermediateTechnologypopupalertmsg = getwebelement(
					xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup"))
							.isDisplayed();
			
			while (intermediateTechnologypopupalertmsg) {
				String text = Gettext(getwebelement(
						xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")));
				System.out.println("the alert popup for intermediate technology is: " + text);
				DriverTestcase.logger.log(LogStatus.PASS,
						"Intermediate Technology info message is: " + text);

				intermediateTechnologypopupalertmsg = false;
			}

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")));
			intermediateTechnology = getwebelement(
					xml.getlocator("//locators/" + application + "/IntermediateTechnology")).isDisplayed();
			sa.assertTrue(intermediateTechnology, "intermediate technology field is displayed");
			
			circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference"))
					.isDisplayed();
			sa.assertTrue(circuitref, "circuit reference field is displayed");
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));

			boolean CircuitReferencepopupalertmsg = getwebelement(
					xml.getlocator("//locators/" + application + "/circuitreferencealertmessage"))
							.isDisplayed();
			
			while (CircuitReferencepopupalertmsg) {
				String text = Gettext(getwebelement(
						xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
				System.out.println("The alert popup on clicking circuit reference field is : " + text);
				DriverTestcase.logger.log(LogStatus.PASS,
						" on clicking 'Circuit reference' , alert emssage popup as : " + text);

				CircuitReferencepopupalertmsg = false;
			}

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
			Thread.sleep(3000);

			Moveon(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferenceIalert")));

			boolean CircuitReferencepopupalerterrmsg = getwebelement(
					xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg"))
							.isDisplayed();
		
			while (CircuitReferencepopupalerterrmsg) {
				String text1 = Gettext(getwebelement(
						xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")));
				System.out.println(
						"The alert popup message when mouse hover on circuit reference(i) is: " + text1);
				DriverTestcase.logger.log(LogStatus.PASS,
						" info message for 'Circuit reference' field is; " + text1);

				CircuitReferencepopupalerterrmsg = false;
			}

			try {
				List<WebElement> listofcircuittypes = driver.findElements(By.xpath(
						"//div[@class='div-border div-margin container']//div[@class='row'][3]//span"));

				for (WebElement CircuitTypes : listofcircuittypes) {
					int i = 0;
					boolean match = false;
					if (CircuitTypes.getText().equals(Circuittype[i])) {
						match = true;
						Log.info("list of circuit types are : " + CircuitTypes.getText());
						DriverTestcase.logger.log(LogStatus.PASS,"list of circuit ytpes are:  " + CircuitTypes.getText());

					} else {

						Log.info("list of circuit types are : " + CircuitTypes.getText());

					}

					sa.assertTrue(match);
					i++;
				}
			} catch (Exception e) {
				e.printStackTrace();
				Log.info("Circuit type values are mismatching");
				DriverTestcase.logger.log(LogStatus.FAIL,"circuit types values are mismstaching");
			}

		
		}
			
			
	else {
			
			System.out.println(vpntopology+ " is not available inside the VPNtopoloy dropdown");
			Log.info(vpntopology+ " is not available inside the VPNtopoloy dropdown");
			DriverTestcase.logger.log(LogStatus.FAIL,vpntopology+ " is not available inside the VPNtopoloy dropdown");
		}
			
	    

	okButton = getwebelement(xml.getlocator("//locators/" + application + "/okbutton")).isDisplayed();
	sa.assertTrue(okButton, "OK button is displayed");
	
	cancelButton = getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")).isDisplayed();
	sa.assertTrue(cancelButton, "Cancel button is diaplayed");

			Thread.sleep(2000);
			
			
			sa.assertAll();
			DriverTestcase.logger.log(LogStatus.PASS,"Fields under 'Lanlink National' service subtype is verified");
			
			}catch(AssertionError e) {
				Log.info("Field validation failure under Lanlink National service");
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL,"Fields under 'lanlink National' service subtype is not displaying as expected");
				
			}
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));
			Thread.sleep(3000);

			
		}

		
		
		
		public void Fieldvalidation_LANlinkoutbandmanagement(String application, String serviceType,
				String SelectSubService, String Interfacespeed,String proActivemonitoring, String vpntopology)
				throws InterruptedException, DocumentException, IOException {

			try {
			String[] deliverychannel = { "--", "Retail", "Reseller" };

			String[] ManagementConnection= {"IPCBased", "Onnet-Offnet" };
			
			String[]notifyManagement= {"--", "Retail", "Reseller"}; 
 
			boolean serviceIdentificationField, ServiceType, ServiceSubtype, interfacespeed, singleendpointCPE, email,
					phone, remark, performanceReport, deliveryChanel, proactiveMonitor, Managementorder, managaneconnection,
					nextButton, cancelButton, AggregateTraffic, enni, okButton;

			
serviceIdentificationField = getwebelement(
		xml.getlocator("//locators/" + application + "/ServiceIdentification")).isDisplayed();
sa.assertTrue(serviceIdentificationField, "Service identification field is displayed");


ServiceType = (getwebelement("//div[contains(text(),'" + application + "')]")).isDisplayed();
sa.assertTrue(ServiceType, "Service type is displayed as expected");
			
ServiceSubtype = getwebelement("//div[contains(text(),'" + SelectSubService + "')]").isDisplayed();
sa.assertTrue(ServiceSubtype, "Service subtype is displayed as expected");

String interfacespeedautopopulatedvalue=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/interfacespeedvaluepopulated")));
sa.assertEquals(interfacespeedautopopulatedvalue, Interfacespeed, "Interface speed dropdown is not displaying as expected");

singleendpointCPE = getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")).isDisplayed();
sa.assertTrue(singleendpointCPE, "single End point CPE checkbox is disabled by default as expected");

email = getwebelement(xml.getlocator("//locators/" + application + "/Email")).isDisplayed();
sa.assertTrue(email, "email field is displayed");

phone = getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")).isDisplayed();
sa.assertTrue(phone, "phone contact field is displayed as expected");


remark = getwebelement(xml.getlocator("//locators/" + application + "/Remark")).isDisplayed();
sa.assertTrue(remark, "remark field si displayed as expected");


			performanceReport = getwebelement(xml.getlocator("//locators/" + application + "/performanceReportingcheckbox"))
					.isDisplayed();
			sa.assertTrue(performanceReport,
					"performance Reporting checbox is displayed and by default not selected as expected");
			
			proactiveMonitor = getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring"))
					.isDisplayed();
			sa.assertTrue(proactiveMonitor,
					"pro active monitoring checkbox is displayed and by default not selected as expected");
			
			
			if(proActivemonitoring.equalsIgnoreCase("yes")) {
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
				Log.info("Pro active monitoring check box is selected");
			
			boolean notificationManagement=getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement"))
			.isDisplayed();
			sa.assertTrue(notificationManagement, "Notification management dropdown gets displayed when proactive monitoring is selected");
			Log.info("Notification management dropdown gets displayed when proactive monitoring is selected");
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
			try {
				List<WebElement> listofnotificationmanagement = driver
						.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
				for (WebElement notificationmanagementtypes : listofnotificationmanagement) {

					boolean match = false;
					for (int i = 0; i < notifyManagement.length; i++) {
						if (notificationmanagementtypes.getText().equals(notifyManagement[i])) {
							match = true;
							Log.info("list of notification management are : " + notificationmanagementtypes.getText());
							DriverTestcase.logger.log(LogStatus.PASS,"list of notification management are : " + notificationmanagementtypes.getText());
						}
					}
					sa.assertTrue(match);
					
				}
		      }catch(AssertionError e) {
		    	  Log.info("Notification Management dropdown values are mismatching");
		    	  e.printStackTrace();
		    	  DriverTestcase.logger.log(LogStatus.FAIL,"  values in Notification management dropdown under Lanlink outbandmanagement service subtype is not displaying as expected");
		      }
			}else {
			
			Log.info("Notification management dropdown is not available as proactive monitoring is not selected");
			DriverTestcase.logger.log(LogStatus.PASS,"Notification management dropdown is not available as proactive monitoring is not selected");
			}

			deliveryChanel = getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")).isDisplayed();
				sa.assertTrue(deliveryChanel, "delivery channel dropdown is displayed");
				
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
		    try {
				List<WebElement> listofdeliverychannel = driver
						.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
				for (WebElement deliverychanneltypes : listofdeliverychannel) {

					boolean match = false;
					for (int i = 0; i < deliverychannel.length; i++) {
						if (deliverychanneltypes.getText().equals(deliverychannel[i])) {
							match = true;
							Log.info("list of delivery channel are : " + deliverychanneltypes.getText());
							DriverTestcase.logger.log(LogStatus.PASS," List of Delivery channel dropdown values under Lanlink outbandmanagement service subtype are: "+deliverychanneltypes.getText());	
							
						}
					}
					sa.assertTrue(match);
				}
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	Log.info("delivery channel dropdown values are mismatching");
		    	DriverTestcase.logger.log(LogStatus.FAIL,"  values in delivery channel dropdowns under Lanlink outbandmanagement service subtype are not displaying as expected");
		    }
			
			enni = getwebelement(xml.getlocator("//locators/" + application + "/ENNIcheckbox")).isDisplayed();
			sa.assertTrue(enni, "ENNI checbox is displayed and by default not selected as expected");
			
			managaneconnection = getwebelement(
					xml.getlocator("//locators/" + application + "/managementconnection")).isDisplayed();
			sa.assertTrue(managaneconnection, "management connection dropdown is displayed");
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/managementconnection")));
			try {
				List<WebElement> listofmanagementconnections = driver
						.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
				for (WebElement Managementconnectiontypes : listofmanagementconnections) {

					boolean match = false;
					for (int i = 0; i < ManagementConnection.length; i++) {
						if (Managementconnectiontypes.getText().equals(ManagementConnection[i])) {
							match = true;
							Log.info("list of management connections are : " + Managementconnectiontypes.getText());
							DriverTestcase.logger.log(LogStatus.PASS," List of Manageconnection dropdown values are: "+Managementconnectiontypes.getText());
							
						}
					}
					sa.assertTrue(match);
					
				}
		      }catch(AssertionError e) {
		    	  Log.info("management connection dropdown values are mismatching");
		    	  e.printStackTrace();
		    	  DriverTestcase.logger.log(LogStatus.FAIL," Values for Manageconnection dropdown under Lanlink outbandmanagement service subtype is not matching");
					
		      }


			okButton = getwebelement(xml.getlocator("//locators/" + application + "/okbutton")).isDisplayed();
			sa.assertTrue(okButton, "OK button is displayed");
			
			
			cancelButton = getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")).isDisplayed();
			sa.assertTrue(cancelButton, "Cancel button is displayed");
			

			
			
			sa.assertAll();
			DriverTestcase.logger.log(LogStatus.PASS,"Fields under 'lanlink outbandmanagement' service subtype is verified");
			
			}catch(AssertionError e) {
				Log.info("Field validation failure in lanlink outbandmanagement service");
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL,"Fields under 'lanlink outbandmanagement' service subtype is not displating as expected");
				
			}
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));
			Thread.sleep(3000);
				

		}
		
		
		
		public void Fieldvalidation_OLO(String application, String serviceType, String SelectSubService,
				String Interfacespeed,String proActivemonitoring, String vpntopology) throws InterruptedException, DocumentException, IOException {

			try {
			String[] deliverychannel = { "--", "Retail", "Reseller" };
			
			String[] VPNtopology = { "Point-to-Point", "Hub&Spoke", "E-PN (Any-to-Any)" };

			String[] Circuittype = { "Default", "Composite Circuit", "Extended Circuit" };
			
			String[] notifyManagement= {"--", "Retail", "Reseller"}; 
			

			boolean serviceIdentificationField, ServiceType, ServiceSubtype, interfacespeed, singleendpointCPE, email,
					phone, remark, performancemonitor, deliveryChanel, proactiveMonitor, Managementorder,
					managaneconnection, nextButton, cancelButton, enni, vpnTopology, intermediateTechnology, circuitref,
					circuitType, okButton;

			
			
			serviceIdentificationField = getwebelement(
					xml.getlocator("//locators/" + application + "/ServiceIdentification")).isDisplayed();
			sa.assertTrue(serviceIdentificationField, "Service identification field is displayed");
			
			
			ServiceType = (getwebelement("//div[contains(text(),'" + application + "')]")).isDisplayed();
			sa.assertTrue(ServiceType, "Service type is displayed as expected");
						
			ServiceSubtype = getwebelement("//div[contains(text(),'" + SelectSubService + "')]").isDisplayed();
			sa.assertTrue(ServiceSubtype, "Service subtype is displayed as expected");
			
			String interfacespeedautopopulatedvalue=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/interfacespeedvaluepopulated")));
			sa.assertEquals(interfacespeedautopopulatedvalue, Interfacespeed, "Interface speed dropdown is not displaying as expected");
			
			singleendpointCPE = getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")).isDisplayed();
			sa.assertTrue(singleendpointCPE, "single End point CPE checkbox is disabled by default as expected");
			
			email = getwebelement(xml.getlocator("//locators/" + application + "/Email")).isDisplayed();
			sa.assertTrue(email, "email field is displayed");
			
			phone = getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")).isDisplayed();
			sa.assertTrue(phone, "phone contact field is displayed as expected");
			

			remark = getwebelement(xml.getlocator("//locators/" + application + "/Remark")).isDisplayed();
			sa.assertTrue(remark, "remark field si displayed as expected");
			
			
			performancemonitor = getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring"))
					.isDisplayed();
			sa.assertTrue(performancemonitor,
					"performance monitoring checbox is displayed and by default not selected as expected");
			
			proactiveMonitor = getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring"))
					.isDisplayed();
			sa.assertTrue(proactiveMonitor,
					"pro active monitoring checkbox is displayed and by default not selected as expected");
			
			
		if(proActivemonitoring.equalsIgnoreCase("yes")) {
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
			Log.info("Pro active monitoring check box is selected");
		
		boolean notificationManagement=getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement"))
		.isDisplayed();
		sa.assertTrue(notificationManagement, "Notification management dropdown gets displayed when proactive monitoring is selected");
		Log.info("Notification management dropdown gets displayed when proactive monitoring is selected");
		
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
		try {
			List<WebElement> listofnotificationmanagement = driver
					.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement notificationmanagementtypes : listofnotificationmanagement) {

				boolean match = false;
				for (int i = 0; i < notifyManagement.length; i++) {
					if (notificationmanagementtypes.getText().equals(notifyManagement[i])) {
						match = true;
						Log.info("list of notification management are : " + notificationmanagementtypes.getText());
						DriverTestcase.logger.log(LogStatus.PASS,"list of notification management are : " + notificationmanagementtypes.getText());
					}
				}
				sa.assertTrue(match);
				
			}
	      }catch(AssertionError e) {
	    	  Log.info("Notification Management dropdown values are mismatching");
	    	  e.printStackTrace();
	    	  DriverTestcase.logger.log(LogStatus.FAIL,"  values in Notification management dropdown under OLO - (GCR/EU) service subtype is not displaying as expected");
	      }
		}else {
		
		Log.info("Notification management dropdown is not available as proactive monitoring is not selected");
		}

		deliveryChanel = getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")).isDisplayed();
			sa.assertTrue(deliveryChanel, "delivery channel dropdown is displayed");
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
	    try {
			List<WebElement> listofdeliverychannel = driver
					.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement deliverychanneltypes : listofdeliverychannel) {

				boolean match = false;
				for (int i = 0; i < deliverychannel.length; i++) {
					if (deliverychanneltypes.getText().equals(deliverychannel[i])) {
						match = true;
						Log.info("list of delivery channel are : " + deliverychanneltypes.getText());
						DriverTestcase.logger.log(LogStatus.PASS," List of Delivery channel dropdown values under OLO - (GCR/EU) service subtype are: "+deliverychanneltypes.getText());	
						
					}
				}
				sa.assertTrue(match);
			}
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	Log.info("delivery channel dropdown values are mismatching");
	    	DriverTestcase.logger.log(LogStatus.FAIL,"  values in delivery channel dropdowns under OLO - (GCR/EU) service subtype are not displaying as expected");
	    }

			enni = getwebelement(xml.getlocator("//locators/" + application + "/ENNIcheckbox")).isDisplayed();
			sa.assertTrue(enni, "ENNI checbox is displayed and by default not selected as expected");		
			
			

			Managementorder = getwebelement(xml.getlocator("//locators/" + application + "/managementOrder")).isDisplayed();
			sa.assertTrue(Managementorder, "management order field is displayed");
			
			
			vpnTopology = getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")).isDisplayed();
			sa.assertTrue(vpnTopology, "vpn topology dropdown is displayed");
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
			
			try {
			List<WebElement> listofvpntopology = driver.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement vpntopologytyeps : listofvpntopology) {

				boolean match = false;
				for (int i = 0; i < VPNtopology.length; i++) {
					if (vpntopologytyeps.getText().equals(VPNtopology[i])) {
						match = true;
						Log.info("list of vpn topologies are : " + vpntopologytyeps.getText());
						System.out.println("list of vpn topologies: "+vpntopologytyeps.getText());
						DriverTestcase.logger.log(LogStatus.PASS,"list of vpn topologies: "+vpntopologytyeps.getText());
						
					}
				}
				sa.assertTrue(match);
			}
			}catch(Exception e) {
				e.printStackTrace();
				Log.info("vpn topology dropdown values are mismatching");
				DriverTestcase.logger.log(LogStatus.FAIL,"values in VPN topology dropdown under OLO - (GCR/EU) service subtype is not displaying as expected");
			}
			
			
			Clickon(getwebelement("//span[contains(text(),'"+vpntopology +"')]"));
			Thread.sleep(3000);
			
			
			if(vpntopology.equals("Hub&Spoke") || vpntopology.equals("E-PN (Any-to-Any)")) {
				

				
				Log.info("Under 'VPN Topology', When 'Hub&Spoke' or 'E-PN (Any-to-Any)' are selected, 'Circuit type' and 'Intermediate technology' should get disapper"
						+ "only Circuit reference field should occur ");
				
				DriverTestcase.logger.log(LogStatus.INFO,"Under 'VPN Topology', When 'Hub&Spoke' or 'E-PN (Any-to-Any)' are selected, 'Circuit type' and 'Intermediate technology' should get disapper"
						+ "Only circuit reference should display ");
				
				
				circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).isDisplayed();
				sa.assertTrue(circuitref, "circuit reference field is displayed");
				
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));
				
				boolean CircuitReferencepopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")).isDisplayed();
				
			    while(CircuitReferencepopupalertmsg)	{
				String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
				System.out.println("The alert popup when circuit reference field is clicked is: " + text);
				DriverTestcase.logger.log(LogStatus.PASS,"on clicking circuit reference, alert popup message displays as: "+text);
				
				CircuitReferencepopupalertmsg=false;
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
				Thread.sleep(3000);
			    }	 
					    
			
			}
		else if(vpntopology.equals("Point-to-Point")) {
			 
			DriverTestcase.logger.log(LogStatus.INFO,"under VPN topology dropdown for OLO - (GCR/EU) service subtype"
						+ " When'Point-to-Point' is selected,'Circuit type' , 'Intermediate technology', 'Circuit Reference' should get displayed");

			Moveon(getwebelement(xml.getlocator("//locators/" + application + "/intermediateTechErrorMessage")));
			
			boolean intermediateTechnologypopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")).isDisplayed();
			
			while(intermediateTechnologypopupalertmsg)	{
				String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")));
				System.out.println("the alert popup for intermediate technology is: " + text);
				DriverTestcase.logger.log(LogStatus.PASS,"Intermediate Technology info message is: "+text);
				
				intermediateTechnologypopupalertmsg=false;
			}
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")));
				intermediateTechnology = getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology"))
						.isDisplayed();
				sa.assertTrue(intermediateTechnology, "intermediate technology field is displayed");
				
				
				circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).isDisplayed();
				sa.assertTrue(circuitref, "circuit reference field is displayed");
				
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));
				
				boolean CircuitReferencepopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")).isDisplayed();
				
				
			    while(CircuitReferencepopupalertmsg)	{
				String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
				System.out.println("The alert popup on clicking circuit reference field is : " + text);
				DriverTestcase.logger.log(LogStatus.PASS," on clicking 'Circuit reference' , alert emssage popup as : "+ text);
				
				CircuitReferencepopupalertmsg=false;
			    }
			    
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
				Thread.sleep(3000);
						
				
				Moveon(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferenceIalert")));
				
				boolean CircuitReferencepopupalerterrmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")).isDisplayed();
				
				
			while(CircuitReferencepopupalerterrmsg)	{
				String text1=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")));
				System.out.println("The alert popup message when mouse hover on circuit reference(i) is: " + text1);
				DriverTestcase.logger.log(LogStatus.PASS," info message for 'Circuit reference' field is; "+text1);
				
				
				CircuitReferencepopupalerterrmsg=false;
			}

			try {
			List<WebElement> listofcircuittypes = driver
					.findElements(By.xpath("//div[@class='div-border div-margin container']//div[@class='row'][3]//span"));
			
			for (WebElement CircuitTypes : listofcircuittypes) {
				int i = 0;
				boolean match = false;
				if (CircuitTypes.getText().equals(Circuittype[i])) {
					match = true;
					Log.info("list of circuit types are : " + CircuitTypes.getText());
					DriverTestcase.logger.log(LogStatus.PASS,"list of circuit ytpes are:  "+CircuitTypes.getText());
					

				} else {

					Log.info("list of circuit types are : " + CircuitTypes.getText());
					
				}

				sa.assertTrue(match);
				i++;
			}
			}catch(Exception e) {
				e.printStackTrace();
				Log.info("Circuit type values are mismatching");
				DriverTestcase.logger.log(LogStatus.FAIL,"list of circuit type values are mismatching");
				
			}
		
		}
		
		else {
			
			System.out.println(vpntopology+ " is not available inside the VPNtopoloy dropdown");
			Log.info(vpntopology+ " is not available inside the VPNtopoloy dropdown");
			DriverTestcase.logger.log(LogStatus.FAIL,vpntopology+ " is not available inside the VPNtopoloy dropdown");
			
		}

			okButton = getwebelement(xml.getlocator("//locators/" + application + "/okbutton")).isDisplayed();
			sa.assertTrue(okButton, "OK button is displayed");
			
			cancelButton = getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")).isDisplayed();
			sa.assertTrue(cancelButton, "Cancel button is diaplayed");
			
			
			
			sa.assertAll();
			DriverTestcase.logger.log(LogStatus.PASS,"Fields under 'OLO - (GCR/EU)' service subtype is verified");
			
			}catch(AssertionError e) {
				Log.info("Field validation failure under OLO - (GCR/EU)  Service");
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL,"Fields under 'OLO - (GCR/EU)' service subtype is not displaying as expected");
				
			}
		
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));
			Thread.sleep(3000);

		}

		
		
		public void Fieldvalidation_OLOwithoutinterfacespeed(String application, String serviceType, String SelectSubService,
				String Interfacespeed,String proActivemonitoring, String vpntopology) throws InterruptedException, DocumentException, IOException {

			try {
			String[] deliverychannel = { "--", "Retail", "Reseller" };
			
			String[] VPNtopology = { "Point-to-Point", "Hub&Spoke", "E-PN (Any-to-Any)" };

			String[] Circuittype = { "Default", "Composite Circuit", "Extended Circuit" };
			
			String[] notifyManagement= {"--", "Retail", "Reseller"}; 

			boolean serviceIdentificationField, ServiceType, ServiceSubtype, interfacespeed, singleendpointCPE, email,
					phone, remark, performancemonitor, deliveryChanel, proactiveMonitor, Managementorder,
					managaneconnection, nextButton, cancelButton, enni, vpnTopology, intermediateTechnology, circuitref,
					circuitType, okButton;

			
			serviceIdentificationField = getwebelement(
					xml.getlocator("//locators/" + application + "/ServiceIdentification")).isDisplayed();
			sa.assertTrue(serviceIdentificationField, "Service identification field is displayed");
			
			
			ServiceType = (getwebelement("//div[contains(text(),'" + application + "')]")).isDisplayed();
			sa.assertTrue(ServiceType, "Service type is displayed as expected");
						
			ServiceSubtype = getwebelement("//div[contains(text(),'" + SelectSubService + "')]").isDisplayed();
			sa.assertTrue(ServiceSubtype, "Service subtype is displayed as expected");
			
			String interfacespeedautopopulatedvalue=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/interfacespeedvaluepopulated")));
			sa.assertEquals(interfacespeedautopopulatedvalue, Interfacespeed, "Interface speed dropdown is not displaying as expected");
			
			singleendpointCPE = getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")).isDisplayed();
			sa.assertTrue(singleendpointCPE, "single End point CPE checkbox is disabled by default as expected");
			
			email = getwebelement(xml.getlocator("//locators/" + application + "/Email")).isDisplayed();
			sa.assertTrue(email, "email field is displayed");
			
			phone = getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")).isDisplayed();
			sa.assertTrue(phone, "phone contact field is displayed as expected");
			

			remark = getwebelement(xml.getlocator("//locators/" + application + "/Remark")).isDisplayed();
			sa.assertTrue(remark, "remark field si displayed as expected");
			
			
			performancemonitor = getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring"))
					.isDisplayed();
			sa.assertTrue(performancemonitor,
					"performance monitoring checbox is displayed and by default not selected as expected");
			
			proactiveMonitor = getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring"))
					.isDisplayed();
			sa.assertTrue(proactiveMonitor,
					"pro active monitoring checkbox is displayed and by default not selected as expected");
			
			
		if(proActivemonitoring.equalsIgnoreCase("yes")) {
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
			Log.info("Pro active monitoring check box is selected");
		
		boolean notificationManagement=getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement"))
		.isDisplayed();
		sa.assertTrue(notificationManagement, "Notification management dropdown gets displayed when proactive monitoring is selected");
		Log.info("Notification management dropdown gets displayed when proactive monitoring is selected");
		
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
		try {
			List<WebElement> listofnotificationmanagement = driver
					.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement notificationmanagementtypes : listofnotificationmanagement) {

				boolean match = false;
				for (int i = 0; i < notifyManagement.length; i++) {
					if (notificationmanagementtypes.getText().equals(notifyManagement[i])) {
						match = true;
						Log.info("list of notification management are : " + notificationmanagementtypes.getText());
						DriverTestcase.logger.log(LogStatus.PASS,"list of notification management are : " + notificationmanagementtypes.getText());
					}
				}
				sa.assertTrue(match);
				
			}
	      }catch(AssertionError e) {
	    	  Log.info("Notification Management dropdown values are mismatching");
	    	  e.printStackTrace();
	    	  DriverTestcase.logger.log(LogStatus.FAIL,"  values in Notification management dropdown under OLO - (GCR/EU) service subtype is not displaying as expected");
	      }
		}else {
		
		Log.info("Notification management dropdown is not available as proactive monitoring is not selected");
		DriverTestcase.logger.log(LogStatus.PASS,"Notification management dropdown is not available as proactive monitoring is not selected");
		}

		deliveryChanel = getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")).isDisplayed();
			sa.assertTrue(deliveryChanel, "delivery channel dropdown is displayed");
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
	    try {
			List<WebElement> listofdeliverychannel = driver
					.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement deliverychanneltypes : listofdeliverychannel) {

				boolean match = false;
				for (int i = 0; i < deliverychannel.length; i++) {
					if (deliverychanneltypes.getText().equals(deliverychannel[i])) {
						match = true;
						Log.info("list of delivery channel are : " + deliverychanneltypes.getText());
						DriverTestcase.logger.log(LogStatus.PASS," List of Delivery channel dropdown values under OLO - (GCR/EU) service subtype are: "+deliverychanneltypes.getText());	
						
					}
				}
				sa.assertTrue(match);
			}
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	Log.info("delivery channel dropdown values are mismatching");
	    	DriverTestcase.logger.log(LogStatus.FAIL,"  values in delivery channel dropdowns under OLO - (GCR/EU) service subtype are not displaying as expected");
	    }

			enni = getwebelement(xml.getlocator("//locators/" + application + "/ENNIcheckbox")).isDisplayed();
			sa.assertTrue(enni, "ENNI checbox is displayed and by default not selected as expected");		
			
			

			Managementorder = getwebelement(xml.getlocator("//locators/" + application + "/managementOrder")).isDisplayed();
			sa.assertTrue(Managementorder, "management order field is displayed");
			
			
			vpnTopology = getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")).isDisplayed();
			sa.assertTrue(vpnTopology, "vpn topology dropdown is displayed");
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
			
			
	     try {
			List<WebElement> listofvpntopology = driver.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
			for (WebElement vpntopologytyeps : listofvpntopology) {

				boolean match = false;
				for (int i = 0; i < VPNtopology.length; i++) {
					if (vpntopologytyeps.getText().equals(VPNtopology[i])) {
						match = true;
						Log.info("list of vpn topologies are : " + vpntopologytyeps.getText());
						DriverTestcase.logger.log(LogStatus.PASS,"list of vpn topologies are : " + vpntopologytyeps.getText());
					}
				}
				sa.assertTrue(match);

			}
	     }catch(Exception e) {
	    	 Log.info("VPN topology dropdown values are mismatching");
	    	 DriverTestcase.logger.log(LogStatus.INFO,"  Vpn topology values are mismatching under OLO - (GCR/EU) service subtype");	
				
	     }
	     
	     
	 	Clickon(getwebelement("//span[contains(text(),'"+vpntopology +"')]"));
		Thread.sleep(3000);

			
		if(vpntopology.equals("E-PN (Any-to-Any)")) {
			
			Log.info("Under 'VPN Topology', When 'E-PN (Any-to-Any)' is selected,'Circuit type' and 'Intermediate technology' should get disapper"
					+ "only circuit reference should should appear ");
			
			DriverTestcase.logger.log(LogStatus.INFO,"Under 'VPN Topology', When 'E-PN (Any-to-Any)' is selected,'Circuit type' and 'Intermediate technology' should get disapper"
					+ "only circuit reference should should appear ");
			
			circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).isDisplayed();
			sa.assertTrue(circuitref, "circuit reference field is displayed");
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));
			
			boolean CircuitReferencepopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")).isDisplayed();
			
		    while(CircuitReferencepopupalertmsg)	{
			String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
			DriverTestcase.logger.log(LogStatus.PASS,"The alert popup when circuit reference field is clicked is: " + text);
			CircuitReferencepopupalertmsg=false;
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
			
		}
		    
	}	    
		  else if(vpntopology.equals("Hub&Spoke") ) {
				

				Log.info("Under 'VPN Topology', When 'modular msp' is selected and 'Hub&Spoke' is selected,"
						+ "'Circuit type', 'circuit reference' and 'Intermediate technology' should get disapper");
		    
				
				DriverTestcase.logger.log(LogStatus.INFO,"Under 'VPN Topology', When 'modular msp' is selected and 'Hub&Spoke' is selected,"
						+ "'Circuit type', 'circuit reference' and 'Intermediate technology' should get disapper");
	      }
		
		else if(vpntopology.equals("Point-to-Point")){
			 
			DriverTestcase.logger.log(LogStatus.INFO,"under VPN topology dropdown for OLO - (GCR/EU) service subtype"
						+ " When'Point-to-Point' is selected,'Circuit type' , 'Intermediate technology', 'Circuit Reference' should get displayed");

			Moveon(getwebelement(xml.getlocator("//locators/" + application + "/intermediateTechErrorMessage")));
			
			boolean intermediateTechnologypopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")).isDisplayed();
			
			while(intermediateTechnologypopupalertmsg)	{
				String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/IntermediaTechnologypopup")));
				System.out.println("the alert popup for intermediate technology is: " + text);
				DriverTestcase.logger.log(LogStatus.PASS,"Intermediate Technology info message is: "+text);
				
				intermediateTechnologypopupalertmsg=false;
			}
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")));
				intermediateTechnology = getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology"))
						.isDisplayed();
				sa.assertTrue(intermediateTechnology, "intermediate technology field is displayed");
				
				
				circuitref = getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).isDisplayed();
				sa.assertTrue(circuitref, "circuit reference field is displayed");
				
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")));
				
				boolean CircuitReferencepopupalertmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")).isDisplayed();
				
				
			    while(CircuitReferencepopupalertmsg)	{
				String text=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealertmessage")));
				System.out.println("The alert popup on clicking circuit reference field is : " + text);
				DriverTestcase.logger.log(LogStatus.PASS," on clicking 'Circuit reference' , alert emssage popup as : "+ text);
				
				CircuitReferencepopupalertmsg=false;
			    }
			    
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xButton")));
				Thread.sleep(3000);
						
				
				Moveon(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferenceIalert")));
				
				boolean CircuitReferencepopupalerterrmsg=getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")).isDisplayed();
				
				
			while(CircuitReferencepopupalerterrmsg)	{
				String text1=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/circuitreferencealerterrmsg")));
				System.out.println("The alert popup message when mouse hover on circuit reference(i) is: " + text1);
				DriverTestcase.logger.log(LogStatus.PASS," info message for 'Circuit reference' field is; "+text1);
				
				
				CircuitReferencepopupalerterrmsg=false;
			}

			try {
			List<WebElement> listofcircuittypes = driver
					.findElements(By.xpath("//div[@class='div-border div-margin container']//div[@class='row'][3]//span"));
			
			for (WebElement CircuitTypes : listofcircuittypes) {
				int i = 0;
				boolean match = false;
				if (CircuitTypes.getText().equals(Circuittype[i])) {
					match = true;
					Log.info("list of circuit types are : " + CircuitTypes.getText());
					DriverTestcase.logger.log(LogStatus.PASS,"list of circuit ytpes are:  "+CircuitTypes.getText());
					

				} else {

					Log.info("list of circuit types are : " + CircuitTypes.getText());
					
				}

				sa.assertTrue(match);
				i++;
			}
			}catch(Exception e) {
				e.printStackTrace();
				Log.info("Circuit type values are mismatching");
				DriverTestcase.logger.log(LogStatus.FAIL,"list of circuit type values are mismatching");
				
			}
		}
			
			
		else {
			
			System.out.println(vpntopology+ " is not available inside the VPNtopoloy dropdown");
			Log.info(vpntopology+ " is not available inside the VPNtopoloy dropdown");
			DriverTestcase.logger.log(LogStatus.FAIL,vpntopology+ " is not available inside the VPNtopoloy dropdown");
			
		}

			okButton = getwebelement(xml.getlocator("//locators/" + application + "/okbutton")).isDisplayed();
			sa.assertTrue(okButton, "OK button is displayed");
			
			cancelButton = getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")).isDisplayed();
			sa.assertTrue(cancelButton, "Cancel button is diaplayed");
			
			sa.assertAll();
			DriverTestcase.logger.log(LogStatus.PASS,"Fields under 'OLO - (GCR/EU)' service subtype is verified");
			
			}catch(AssertionError e) {
				Log.info("Field validation failure under OLO - (GCR/EU)  Service");
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL,"Fields under 'OLO - (GCR/EU)' service subtype is not displaying as expected");
				
			}
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));
			Thread.sleep(3000);

		}

		
		public void dataToBeEnteredOncesubservicesselected(String application, String SelectSubService, String Interfacespeed,
				String ServiceIdentificationNumber, String EndpointCPE, String Email, String PhoneContact, String remark,
				String PerformanceMonitoring, String ProactiveMonitoring, String deliveryChannel, String ManagementOrder,
				String vpnTopology, String intermediateTechnology, String CircuitReference, String CircuitType,
				String AggregateTraffic, String DeliveryChannelForselecttag, String modularmsp, String autoCreateService,
				String ENNIcheckBox, String Manageconnectiondropdown, String A_Endtechnologydropdown,
				String B_Endtechnologydropdown, String notificationManagement, String Performancereporting) throws InterruptedException, IOException, DocumentException {

			Thread.sleep(5000);

		if(modularmsp.equalsIgnoreCase("no")) {	
			
			if (SelectSubService.equalsIgnoreCase("Direct Fiber")) {

				DirectFibre(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed, EndpointCPE, Email,
						PhoneContact, remark, PerformanceMonitoring, ProactiveMonitoring, deliveryChannel, ManagementOrder,
						vpnTopology, intermediateTechnology, CircuitReference, CircuitType,notificationManagement);

			}

			if (SelectSubService.equalsIgnoreCase("LANLink International")) {

				LanlinkInternational(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed,
						EndpointCPE, Email, PhoneContact, remark, PerformanceMonitoring, ProactiveMonitoring,
						deliveryChannel, AggregateTraffic, vpnTopology, intermediateTechnology, CircuitReference,
						CircuitType, notificationManagement);
			}

			if (SelectSubService.equalsIgnoreCase("LANLink Metro")) {

				LanlinkMetro(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed, EndpointCPE, Email,
						PhoneContact, remark, PerformanceMonitoring, ProactiveMonitoring, deliveryChannel,
						vpnTopology, intermediateTechnology, CircuitReference, CircuitType, notificationManagement);
			}

			if (SelectSubService.equalsIgnoreCase("LANLink National")) {

				lanlinkNational(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed, EndpointCPE,
						Email, PhoneContact, remark, PerformanceMonitoring, ProactiveMonitoring,
						deliveryChannel, AggregateTraffic, vpnTopology, intermediateTechnology,
						CircuitReference, CircuitType, notificationManagement);
			}

			if (SelectSubService.equalsIgnoreCase("LANLink Outband Management")) {

				Lanlink_outbandmanagement(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed,
						EndpointCPE, Email, PhoneContact, remark, Performancereporting, ProactiveMonitoring, ENNIcheckBox,
						deliveryChannel, Manageconnectiondropdown, notificationManagement);

			}

			if (SelectSubService.equalsIgnoreCase("OLO - (GCR/EU)")) {

				Lanlink_OLO(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed, EndpointCPE, Email,
						PhoneContact, remark, PerformanceMonitoring, ProactiveMonitoring, ENNIcheckBox, deliveryChannel,
						ManagementOrder, vpnTopology, intermediateTechnology, CircuitReference, CircuitType, notificationManagement);

			}
		}
		
		

		else if(modularmsp.equalsIgnoreCase("yes")) {	
			
			
			if (SelectSubService.equalsIgnoreCase("LANLink International")) {

				LanlinkInternationalwhenMSPisselected(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed,
						EndpointCPE, Email, PhoneContact, remark, PerformanceMonitoring, ProactiveMonitoring,
						deliveryChannel, AggregateTraffic, vpnTopology, intermediateTechnology, CircuitReference,
						CircuitType, notificationManagement);
			}

			if (SelectSubService.equalsIgnoreCase("LANLink Metro")) {
				
				LanlinkMetrowhenMSPisselected(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed, EndpointCPE, Email,
						PhoneContact, remark, PerformanceMonitoring, ProactiveMonitoring, deliveryChannel,
						vpnTopology, intermediateTechnology, CircuitReference, CircuitType, notificationManagement);
			}

			if (SelectSubService.equalsIgnoreCase("LANLink National")) {

				lanlinkNationalwhenMSpisselected(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed, EndpointCPE,
						Email, PhoneContact, remark, PerformanceMonitoring, ProactiveMonitoring,
						deliveryChannel, AggregateTraffic, vpnTopology, intermediateTechnology,
						CircuitReference, CircuitType, notificationManagement);
			}

			if (SelectSubService.equalsIgnoreCase("OLO - (GCR/EU)")) {

				Lanlink_OLOwhenMSPisselected(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed, EndpointCPE, Email,
						PhoneContact, remark, PerformanceMonitoring, ProactiveMonitoring, ENNIcheckBox, deliveryChannel,
						ManagementOrder, vpnTopology, intermediateTechnology, CircuitReference, CircuitType, notificationManagement);

			}
		}
		

		 DriverTestcase.logger.log(LogStatus.INFO, "Input data has been entered to create Service");
			Thread.sleep(3000);
		
			
		}
		
		
		
		
		public void EditTheservicesselected(String application, String SelectSubService, String Interfacespeed,
				String ServiceIdentificationNumber, String EndpointCPE, String Email, String PhoneContact, String remark,
				String PerformanceMonitoring, String ProactiveMonitoring, String deliveryChannel, String ManagementOrder,
				String vpnTopology, String intermediateTechnology, String CircuitReference, String CircuitType,
				String AggregateTraffic, String DeliveryChannelForselecttag, String modularmsp, String autoCreateService,
				String ENNIcheckBox, String Manageconnectiondropdown, String A_Endtechnologydropdown,
				String B_Endtechnologydropdown, String notificationManagement, String Performancereporting ) throws InterruptedException, IOException, DocumentException {


		
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Editservice_actiondropdownalternate")));
		System.out.println("Action dropdown is working");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Editservice_Editlink")));
		
		

	if(modularmsp.equalsIgnoreCase("no")) {	
		
		if (SelectSubService.equalsIgnoreCase("Direct Fiber")) {

			EditDirectFibre(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed, EndpointCPE, Email,
					PhoneContact, remark, PerformanceMonitoring, ProactiveMonitoring, deliveryChannel, ManagementOrder,
					vpnTopology, intermediateTechnology, CircuitReference, CircuitType,notificationManagement);

		}

		if (SelectSubService.equalsIgnoreCase("LANLink International")) {

			editLanlinkInternational(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed,
					EndpointCPE, Email, PhoneContact, remark, PerformanceMonitoring, ProactiveMonitoring,
					deliveryChannel, AggregateTraffic, vpnTopology, intermediateTechnology, CircuitReference,
					CircuitType, notificationManagement);
		}

		if (SelectSubService.equalsIgnoreCase("LANLink Metro")) {

			EditLanlinkMetro(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed, EndpointCPE, Email,
					PhoneContact, remark, PerformanceMonitoring, ProactiveMonitoring, deliveryChannel,
					vpnTopology, intermediateTechnology, CircuitReference, CircuitType, notificationManagement);
		}

		if (SelectSubService.equalsIgnoreCase("LANLink National")) {

			lanlinkNational(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed, EndpointCPE,
					Email, PhoneContact, remark, PerformanceMonitoring, ProactiveMonitoring,
					deliveryChannel, AggregateTraffic, vpnTopology, intermediateTechnology,
					CircuitReference, CircuitType, notificationManagement);
		}

		if (SelectSubService.equalsIgnoreCase("LANLink Outband Management")) {

			EditLanlink_outbandmanagement(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed,
					EndpointCPE, Email, PhoneContact, remark, Performancereporting, ProactiveMonitoring, ENNIcheckBox,
					deliveryChannel, Manageconnectiondropdown, notificationManagement);

		}

		if (SelectSubService.equalsIgnoreCase("OLO - (GCR/EU)")) {

			EditLanlink_OLO(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed, EndpointCPE, Email,
					PhoneContact, remark, PerformanceMonitoring, ProactiveMonitoring, ENNIcheckBox, deliveryChannel,
					ManagementOrder, vpnTopology, intermediateTechnology, CircuitReference, CircuitType, notificationManagement);

		}
	}
	
	

	else if(modularmsp.equalsIgnoreCase("yes")) {	
		
		
		if (SelectSubService.equalsIgnoreCase("LANLink International")) {

			LanlinkInternationalwhenMSPisselected(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed,
					EndpointCPE, Email, PhoneContact, remark, PerformanceMonitoring, ProactiveMonitoring,
					deliveryChannel, AggregateTraffic, vpnTopology, intermediateTechnology, CircuitReference,
					CircuitType, notificationManagement);
		}

		if (SelectSubService.equalsIgnoreCase("LANLink Metro")) {
			
			editLanlinkMetrowhenMSPisselected(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed, EndpointCPE, Email,
					PhoneContact, remark, PerformanceMonitoring, ProactiveMonitoring, deliveryChannel,
					vpnTopology, intermediateTechnology, CircuitReference, CircuitType, notificationManagement);
		}

		if (SelectSubService.equalsIgnoreCase("LANLink National")) {

			lanlinkNationalwhenMSpisselected(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed, EndpointCPE,
					Email, PhoneContact, remark, PerformanceMonitoring, ProactiveMonitoring,
					deliveryChannel, AggregateTraffic, vpnTopology, intermediateTechnology,
					CircuitReference, CircuitType, notificationManagement);
		}

		if (SelectSubService.equalsIgnoreCase("OLO - (GCR/EU)")) {

			editLanlink_OLOwhenMSPisselected(application, ServiceIdentificationNumber, SelectSubService, Interfacespeed, EndpointCPE, Email,
					PhoneContact, remark, PerformanceMonitoring, ProactiveMonitoring, ENNIcheckBox, deliveryChannel,
					ManagementOrder, vpnTopology, intermediateTechnology, CircuitReference, CircuitType, notificationManagement);

		}
	}
	

		Thread.sleep(3000);
	
	}
		
		


		public void verifysuccessmessageforCreateService() throws InterruptedException {
			
		try {	
			boolean alertmessage = getwebelement("//div[text()='Service  successfully created.']").isDisplayed();
			Log.info("Service has been created successfully");
			DriverTestcase.logger.log(LogStatus.PASS," 'service successfully created' message is verified");
			System.out.println("Success message displayed");
			
		}catch(Exception e) {
			Log.info("failure in fetching success message - 'Service created Successfully'  ");
			DriverTestcase.logger.log(LogStatus.FAIL, " 'service successfully created' message is not displaying after creating service");
			System.out.println("Success message is not getting dislpayed");
		}

		
		}
		
		
		
		public void verifysuccessmessageforSiteOrder() throws InterruptedException {
			
			try {	
				boolean alertmessage = getwebelement("//span[text()='Site order created successfully']").isDisplayed();
				Log.info("Site order has been created successfully");
				DriverTestcase.logger.log(LogStatus.PASS," 'Site order created successfully' message is verified");
				System.out.println("Success message displayed");
				
			}catch(Exception e) {
				Log.info("failure in fetching success message - 'Site order created successfully'  ");
				DriverTestcase.logger.log(LogStatus.FAIL, " 'site order created successfully' message is not displaying after creating service");
				System.out.println("Success message is not getting dislpayed");
			}

			
			}
		

		public void VerifydatenteredForServiceSubTypeSelected(String application, String serviceType,
				String SelectSubService, String Interfacespeed, String ServiceIdentificationNumber, String EndpointCPE,
				String Email, String PhoneContact, String remark, String PerformanceMonitoring, String ProactiveMonitoring,
				String deliveryChannel, String ManagementOrder, String vpnTopology, String intermediateTechnology,
				String CircuitReference, String CircuitType, String AggregateTraffic, String DeliveryChannelForselecttag,
				String modularmsp, String autoCreateService, String ENNIcheckBox, String Manageconnectiondropdown,
				String A_Endtechnologydropdown, String B_Endtechnologydropdown, String Performancereporting)
				throws InterruptedException, IOException, DocumentException {

			Thread.sleep(2000);
			
			try {

			if (SelectSubService.equalsIgnoreCase("Direct Fiber")) {

				verifydataEnteredforDirectFibre(application, serviceType, ServiceIdentificationNumber, SelectSubService,
						Interfacespeed, EndpointCPE, Email, PhoneContact, remark, PerformanceMonitoring,
						ProactiveMonitoring, deliveryChannel, ManagementOrder, vpnTopology, intermediateTechnology,
						CircuitReference, CircuitType);

			}

			if (SelectSubService.equalsIgnoreCase("LANLink International")) {

				verifyDataenteredForLanlinkInternational(application, serviceType, ServiceIdentificationNumber,
						SelectSubService, Interfacespeed, EndpointCPE, Email, PhoneContact, remark, PerformanceMonitoring,
						ProactiveMonitoring, deliveryChannel, AggregateTraffic, vpnTopology, intermediateTechnology,
						CircuitReference, CircuitType);
			}

			if (SelectSubService.equalsIgnoreCase("LANLink Metro")) {

				VerifyDataEnteredForLanlinkMetro(application, serviceType, ServiceIdentificationNumber, SelectSubService,
						Interfacespeed, EndpointCPE, Email, PhoneContact, remark, PerformanceMonitoring,
						ProactiveMonitoring, DeliveryChannelForselecttag, vpnTopology, intermediateTechnology,
						CircuitReference, CircuitType);
			}

			if (SelectSubService.equalsIgnoreCase("LANLink National")) {

				verifydataEnteredForlanlinkNational(application, serviceType, ServiceIdentificationNumber, SelectSubService,
						Interfacespeed, EndpointCPE, Email, PhoneContact, remark, PerformanceMonitoring,
						ProactiveMonitoring, DeliveryChannelForselecttag, AggregateTraffic, vpnTopology,
						intermediateTechnology, CircuitReference, CircuitType);
			}

			if (SelectSubService.equalsIgnoreCase("LANLink Outband Management")) {

				verifydateForLanlink_outbandmanagement(application, serviceType, ServiceIdentificationNumber,
						SelectSubService, Interfacespeed, EndpointCPE, Email, PhoneContact, remark, Performancereporting,
						ProactiveMonitoring, ENNIcheckBox, DeliveryChannelForselecttag, Manageconnectiondropdown);

			}

			if (SelectSubService.equalsIgnoreCase("OLO - (GCR/EU)")) {

				verifyDataEnteredForLanlink_OLO(application, serviceType, ServiceIdentificationNumber, SelectSubService,
						Interfacespeed, EndpointCPE, Email, PhoneContact, remark, PerformanceMonitoring,
						ProactiveMonitoring, ENNIcheckBox, deliveryChannel, ManagementOrder, vpnTopology,
						intermediateTechnology, CircuitReference, CircuitType);

			}

			sa.assertAll();
			
			}catch(AssertionError e) {
				Log.info("validation failed for verify service subtype page ");
				e.printStackTrace();
			}
		}

		public void addsiteorder(String application, String country, String city, String CSR_Name, String site,
				String performReport, String ProactiveMonitor, String smartmonitor, String technology, String siteallias,
				String VLANid, String DCAenabledsite, String cloudserviceprovider, String sitevalue, String remark,
				String xngcityname, String xngcitycode,String devicename, String nonterminatepoinr, String Protected)
				throws InterruptedException, DocumentException, IOException {



			// Under add site page
			  Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Country")));
			  Clickon(getwebelement("//span[text()='"+ country +"']"));

//			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_City")));
//			Clickon(getwebelement("//span[text()='" + city + "']"));
			  
			 Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Citytogglebutton")));
			 Thread.sleep(3000);
			 SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_xngcityname")), xngcityname);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_XNGcitycode")), xngcitycode);
	
			if (site.equalsIgnoreCase("yes")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Sitetogglebutton")));
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_sitedropdown")));
				Clickon(getwebelement("//span[text()='" + sitevalue + "']"));

			} else {

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_CSRname")), CSR_Name);

			}

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_performancereporting")));
			Clickon(getwebelement("//span[text()='" + performReport + "']"));

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_proactivemonitoring")));
			Clickon(getwebelement("//span[text()='" + ProactiveMonitor + "']"));

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_smartmonitoring")));
			Clickon(getwebelement("//span[text()='" + smartmonitor + "']"));
		

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Technology")));
			Clickon(getwebelement("//span[text()='" + technology + "']"));
			
			
		if(technology.equals("Actelis")) {	

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_sitealias")), siteallias);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Vlanid")), VLANid);

			if (DCAenabledsite.equalsIgnoreCase("yes")) {

				Clickon(getwebelement(
						xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")));

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_cloudserviceProvider")));
				Clickon(getwebelement("//span[text()='" + cloudserviceprovider + "']"));

			} else {
				Log.info("DCA site is not selected");

			}
			
			
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_remark")), remark);

		}
		
	
		else if(technology.equals("Atrica")) {	

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_sitealias")), siteallias);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Vlanid")), VLANid);

			if (DCAenabledsite.equalsIgnoreCase("yes")) {

				Clickon(getwebelement(
						xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")));

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_cloudserviceProvider")));
				Clickon(getwebelement("//span[text()='" + cloudserviceprovider + "']"));

			} else {
				Log.info("DCA site is not selected");

			}
			
			
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Devicenamefield")), devicename);
		
			if(nonterminatepoinr.equalsIgnoreCase("yes")) {
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_nonterminationpoint")));
			}else {
				System.out.println("Non termination point checkbox is not selected as expected");
			}
			
			if(Protected.equalsIgnoreCase("yes")) {
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_protected")));
			}else {
				System.out.println("Protected checkbox is not selecetd as expected");
			}
			
			
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_remark")), remark);

		}
		
		

		else if(technology.equals("Overture") || technology.equals("Accedian")) {	

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_sitealias")), siteallias);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Vlanid")), VLANid);

			if (DCAenabledsite.equalsIgnoreCase("yes")) {

				Clickon(getwebelement(
						xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")));

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_cloudserviceProvider")));
				Clickon(getwebelement("//span[text()='" + cloudserviceprovider + "']"));

			} else {
				Log.info("DCA site is not selected");

			}
					
			if(nonterminatepoinr.equalsIgnoreCase("yes")) {
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_nonterminationpoint")));
			}else {
				System.out.println("Non termination point checkbox is not selected as expected");
			}
			
			if(Protected.equalsIgnoreCase("yes")) {
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_protected")));
			}else {
				System.out.println("Protected checkbox is not selecetd as expected");
			}
			
			
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_remark")), remark);

		}
		
	
		else if(technology.equals("Cyan")) {	

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_sitealias")), siteallias);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Vlanid")), VLANid);

			if (DCAenabledsite.equalsIgnoreCase("yes")) {

				Clickon(getwebelement(
						xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")));

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_cloudserviceProvider")));
				Clickon(getwebelement("//span[text()='" + cloudserviceprovider + "']"));

			} else {
				Log.info("DCA site is not selected");

			}
			
		
			if(nonterminatepoinr.equalsIgnoreCase("yes")) {
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_nonterminationpoint")));
			}else {
				System.out.println("Non termination point checkbox is not selected as expected");
			}
			
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_remark")), remark);

		}
		
		DriverTestcase.logger.log(LogStatus.PASS, "Data has been entered for add site order");
		
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

		}

		public void editSiteOrder(String application, String performReport, String ProactiveMonitor, String smartmonitor,
				String siteallias, String VLANid, String DCAenabledsite, String cloudserviceprovider)
				throws InterruptedException, DocumentException, IOException {


			  Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EditsideOrderlink")));
			  Thread.sleep(3000);

			// Under add site page

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_performancereporting")));
			Clickon(getwebelement("//span[text()='" + performReport + "']"));
			System.out.println("perform reporting selected");

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_proactivemonitoring")));
			Clickon(getwebelement("//span[text()='" + ProactiveMonitor + "']"));
			System.out.println("proa ctive monitorin selecrted");

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_smartmonitoring")));
			Clickon(getwebelement("//span[text()='" + smartmonitor + "']"));
			System.out.println("smarts monitoring is selected");

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_sitealias")), siteallias);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Vlanid")), VLANid);

			if (DCAenabledsite.equalsIgnoreCase("yes")) {

				Clickon(getwebelement(
						xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")));

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_cloudserviceProvider")));
				Clickon(getwebelement("//span[text()='" + cloudserviceprovider + "']"));

			} else {
				Log.info("DCA site is not selected");

			}

			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

		}

		public void Enteraddsiteorder(String application) throws InterruptedException, DocumentException {

			Thread.sleep(5000);

			  JavascriptExecutor js = ((JavascriptExecutor) driver);
			  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			  Thread.sleep(3000);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Actiondropdown_siteorder")));
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorderlink")));
		}

		public void clickonEditwithoutselectingrow(String application)
				throws InterruptedException, DocumentException, IOException {

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(3000);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Actiondropdown_siteorder")));
			Thread.sleep(2000);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EditsideOrderlink")));
			Thread.sleep(2000);

			String popupmessage = Gettext(getwebelement("//div[text()='Please select a row to edit']"));
			System.out.println("Edit popup message before selecting row: " + popupmessage);
			Log.info("Edit popup message before selecting row: \"+popupmessage");

			Clickon(getwebelement("//div[@class='modal-header']//span[contains(text(),'×')]"));

		}

		public void clickondeletewithoutselectingrow(String application)
				throws InterruptedException, DocumentException, IOException {

			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Backbutton")));
			Thread.sleep(5000);

			

			Log.info("Deleting site order without selecting row");
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(3000);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Actiondropdown_siteorder")));
			Thread.sleep(2000);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/deletesiteorderlink")));
			Thread.sleep(2000);

			String popupmessage = Gettext(getwebelement("//div[text()='Please select a row to delete']"));
			System.out.println("Delete popup message before selecting row: " + popupmessage);
			Log.info("Delete popup message before selecting row: \"+popupmessage");

			Clickon(getwebelement("//div[@class='modal-header']//span[contains(text(),'×')]"));

		}

		public void deletesiteorderdetails(String application) throws InterruptedException, DocumentException, IOException {

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/deletesiteorderlink")));
			Thread.sleep(2000);

			String deletemessage = Gettext(
					getwebelement("//div[text()='Are you sure that you want to delete this item?']"));
			System.out.println("delete popup displays message as : " + deletemessage);
			Log.info("delete popup displays message as : \"+deletemessage");

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Deletesiteorderrbutton")));
			Thread.sleep(2000);

		}

		public void clickonviewewithoutselectingrow(String application)
				throws InterruptedException, DocumentException, IOException {

//			System.out.println("have to navigate back");
//			driver.navigate().back();
//			Thread.sleep(3000);
//			System.out.println("got navigated back");

			Log.info("View site order without selecting row");
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(3000);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Actiondropdown_siteorder")));
			Thread.sleep(2000);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/viewsiteorderlink")));
			Thread.sleep(2000);

			String popupmessage = Gettext(getwebelement("//div[text()='Please select a row to view']"));
			System.out.println("popup message before selecting row for viewing occurs as: " + popupmessage);
			Log.info(" popup message before selecting row for viewing occcurs as: " + popupmessage);

			Clickon(getwebelement("//div[@class='modal-header']//span[contains(text(),'×')]"));

		}

		public void viewsiteorderdetails(String application) throws InterruptedException, DocumentException, IOException {

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/viewsiteorderlink")));
			Thread.sleep(2000);
			Log.info("Entered View site order page");
			
			DriverTestcase.logger.log(LogStatus.PASS, "Entered view site order page");

		}

		public void verifyEditSiteOrder(String application, String country, String city, String CSR_Name, String site,
				String performReport, String ProactiveMonitor, String smartmonitor, String technology, String siteallias,
				String VLANid, String DCAenabledsite, String cloudserviceprovider, String sitevalue)
				throws InterruptedException, DocumentException, IOException {
	    try {

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EditsideOrderlink")));
			Thread.sleep(3000);

			Log.info("Entered edit siteorder page");

			String fetchedvalue_country = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Editsiteorder_country")));
			sa.assertEquals(fetchedvalue_country, country, "Country field is not displaying same Entered value while creating");

			System.out.println("country value is: " + fetchedvalue_country);

			String fetchedvalue_city = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Editsiteorder_city")));
			sa.assertEquals(fetchedvalue_city, city, "City field is not displaying same Entered value while creating");

			System.out.println("city value is: " + fetchedvalue_city);

			String fetchedvalue_csrname = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Editsiteorder_CSRname")));
			sa.assertEquals(fetchedvalue_csrname, CSR_Name,
					"CSR name field isnot  displaying same Entered value while creating");

//			  String fetchedvalue_proactivemonitorin=Gettext(getwebelement("//div[label[contains(text(),'Procative Monitoring')]]//span[contains(text(),'"+ ProactiveMonitor +"')]"));

			String fetchedvalue_proactivemonitorin = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Editsiteorder_proactivemonitor")));
			sa.assertEquals(fetchedvalue_proactivemonitorin, ProactiveMonitor,
					"Pro active monitoring dropdowmn is not displaying same Entered value while creating");

			System.out.println("proactive monitroing value is: " + fetchedvalue_proactivemonitorin);

//			  String fetchedvalue_performreporting=Gettext(getwebelement("//div[label[contains(text(),'Performance Reporting')]]//span[contains(text(),'"+ performReport +"')]"));

			String fetchedvalue_performreporting = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Editsiteorder_performreport")));
			sa.assertEquals(fetchedvalue_performreporting, performReport,
					"Perormance reporting dropdown is not displaying same Entered value while creating");

//			  String fetchedvalue_smartsmonitor=Gettext(getwebelement("//div[label[contains(text(),'Smarts Monitoring')]]//span[contains(text(),'"+ smartmonitor +"')]"));

			String fetchedvalue_smartsmonitor = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Editsiteorder_smartmonitor")));
			sa.assertEquals(fetchedvalue_smartsmonitor, smartmonitor,
					"smarts monitoring dropdown is not displaying same Entered value while creating");

			String fetchedvalue_technology = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/Editsiteorder_technology")));
			sa.assertEquals(fetchedvalue_technology, technology,
					"Technology field is not displaying same Entered value while creating");
			System.out.println("technology is: " + fetchedvalue_technology);

			String fetchedvalue_sitealias = Getattribute(
					getwebelement(xml.getlocator("//locators/" + application + "/Editsiteorder_sitealias")), "value");
			sa.assertEquals(fetchedvalue_sitealias, siteallias,
					"Site alias field is not displaying same Entered value while creating");

			System.out.println("site alias value: " + fetchedvalue_sitealias);

			String fetchedvalue_vlanid = Getattribute(
					getwebelement(xml.getlocator("//locators/" + application + "/Editsiteorder_VLANid")), "value");
			sa.assertEquals(fetchedvalue_vlanid, VLANid, "VLAN id field is not displaying same Entered value while creating");

			boolean fetchedvalue_DCAenabledsite = getwebelement(
					xml.getlocator("//locators/" + application + "/Editsiteorder_DCAenabledsite")).isSelected();
			sa.assertFalse(fetchedvalue_DCAenabledsite, "DCA enabled is not selected as expected");
			System.out.println("DCA enables is: " + fetchedvalue_DCAenabledsite);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));
			Thread.sleep(3000);
			
			sa.assertAll();
	    }catch(AssertionError e) {
	    	e.printStackTrace();
	    }

		}

		public void verifyaddsiteorderfields(String application) throws InterruptedException, DocumentException {

			try {
					
					String[] Country = { "AE (United Arab Emirates)", "AL (Albania)", "AO (Angola)" };

					String[] City = { "Primary", "Access" };

					String[] Site = { "Primary", "Access" };

					String[] Performancereporting = { "Follow Service", "no" };

					String[] Proactivemonitoring = { "Follow Service", "no" };

					String[] Smartmonitoring = { "Follow Service", "no" };

					String[] Technology = { "Actelis", "Atrica", "Overture", "Accedian", "Cyan" };

					String[] cloudServiceprovider = { "Amazon Web Service", "Microsoft Azure" };

					boolean country, city, site, performancereport, proactivemonitoring, csr_name, sitetogglebutton, selectcitytoggle,
							smartmonitoring, technology, sitealias, vlanid, DCAenabledsite, cloudservice, next, cancel,remark,
							xngcityname, xngcitycode, ok, devicename, Nonterminationpointcheckbox, portectedcheckbox;

					// Country dropdown

					country = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Country")).isDisplayed();
					sa.assertTrue(country, "Country dropdown is not displayed");

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Country")));
					List<WebElement> listofcountry = driver.findElements(By.xpath("//div[@role='list']//span[@role='option']"));

					if(listofcountry.size()>=1) {
					for (WebElement countrytypes : listofcountry) {

						boolean match = false;
						for (int i = 0; i < Country.length; i++) {
							if (countrytypes.getText().equals(Country[i])) {
								match = true;
								Log.info("list of countries are : " + countrytypes.getText());
								DriverTestcase.logger.log(LogStatus.PASS,"The list of country inside dropdown is: "+countrytypes.getText());
								
								sa.assertTrue(match);

							}
							}
						
						
					}
				}else {
					System.out.println("no values are available inside Country dropdown for Add site order");
					DriverTestcase.logger.log(LogStatus.FAIL,"no values are available inside Country dropdown for Add site order");
				}
					
					
					


					// City dropdown
					city = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_City")).isDisplayed();
					sa.assertTrue(city, "City dropdown is not displayed");

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_City")));
					List<WebElement> listofcity = driver.findElements(By.xpath("//div[@role='list']//span[@role='option']"));

					if(listofcity.size()>=1) {
					for (WebElement citytypes : listofcity) {

						boolean match = false;
						for (int i = 0; i < City.length; i++) {
							if (citytypes.getText().equals(City[i])) {
								match = true;
								Log.info("list of Cities are : " + citytypes.getText());
								DriverTestcase.logger.log(LogStatus.PASS,"The list of cities while  adding site order is: "+citytypes.getText());
								sa.assertTrue(match);

							}
						}
						

					}
						
				}else {
					System.out.println("no values are available inside City dropdown for Add site order");
					DriverTestcase.logger.log(LogStatus.FAIL,"no values are available inside City dropdown for Add site order");
				}

					
					//select city toggle button
				selectcitytoggle=getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Citytogglebutton")).isDisplayed();
				sa.assertTrue(selectcitytoggle, "Select city toggle button for Add Site is not available");
				
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Citytogglebutton")));
				Thread.sleep(2000);
				
				//xng city name
				xngcityname=getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_xngcityname")).isDisplayed();
				sa.assertTrue(xngcityname, "XNG city name field for Add Site is not available");
		 
				//xng city code
				xngcitycode=getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_XNGcitycode")).isDisplayed();
				sa.assertTrue(xngcitycode, "XNG city code field for Add Site is not available");
					
					// CSR name field
					csr_name = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_CSRname")).isDisplayed();
					sa.assertTrue(csr_name, "CSR_Name field is not displayed");

					// click on site toggle button to check Physical site dropdown
					sitetogglebutton = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Sitetogglebutton"))
							.isDisplayed();
					sa.assertTrue(sitetogglebutton, "select Site toggle button is not displayed");

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Sitetogglebutton")));

					// Site dropdown
					site = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_sitedropdown")).isDisplayed();
					sa.assertTrue(site, "PhysicalSite dropdown is not displayed");

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_sitedropdown")));
					List<WebElement> listofsite = driver.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
					
				if(listofsite.size()>=1) {	
					for (WebElement sitetypes : listofsite) {

						boolean match = false;
						for (int i = 0; i < Site.length; i++) {
							if (sitetypes.getText().equals(Site[i])) {
								match = true;
								Log.info("list of Sites : " + sitetypes.getText());
								sa.assertTrue(match);
								DriverTestcase.logger.log(LogStatus.PASS,"list of Physicalsites for AddSite order are: "+sitetypes.getText());
							}
//							
						}
						

					}
							
				}else {
					System.out.println("no values are available inside PhysicalSite dropdown for Add site order");
					DriverTestcase.logger.log(LogStatus.FAIL,"no values are available inside PhysicalSite dropdown for Add site order");
				}

					// Performance reporting dropdown
					performancereport = getwebelement(
							xml.getlocator("//locators/" + application + "/Addsiteorder_performancereporting")).isDisplayed();
					sa.assertTrue(performancereport, "performance reporting dropdown is not displayed");

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_performancereporting")));
					List<WebElement> listofperformancereporting = driver
							.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
					
				if(listofperformancereporting.size()>=1) {	
					for (WebElement perfoemancereportingtypes : listofperformancereporting) {
						boolean match = false;
						for (int i = 0; i < Performancereporting.length; i++) {
							if (perfoemancereportingtypes.getText().equals(Performancereporting[i])) {
								match = true;
								Log.info("list of performance reporting : " + perfoemancereportingtypes.getText());
								sa.assertTrue(match);
								DriverTestcase.logger.log(LogStatus.PASS,"list of performance reporting for AddSite order : " + perfoemancereportingtypes.getText());
							}
							
						}
						

					}
				}else {
					System.out.println("no values are available inside performance reporting dropdown for Add site order");
					DriverTestcase.logger.log(LogStatus.FAIL,"no values are available inside performance reporting dropdown for Add site order");
				}
					// pro active monitoring
					proactivemonitoring = getwebelement(
							xml.getlocator("//locators/" + application + "/Addsiteorder_proactivemonitoring")).isDisplayed();
					sa.assertTrue(proactivemonitoring, "pro active monitoring dropdown is not displayed");

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_proactivemonitoring")));
					List<WebElement> listofproactivemonitoring = driver
							.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
					
				if(listofproactivemonitoring.size()>=1) {	
					for (WebElement proactivemonitoringtypes : listofproactivemonitoring) {

						boolean match = false;
						for (int i = 0; i < Proactivemonitoring.length; i++) {
							if (proactivemonitoringtypes.getText().equals(Proactivemonitoring[i])) {
								match = true;
								Log.info("list of pro active monitoring : " + proactivemonitoringtypes.getText());
								sa.assertTrue(match);
								DriverTestcase.logger.log(LogStatus.PASS,"The list of proactive monitoring inside dropdown while  adding site order is: "+proactivemonitoringtypes.getText());
							}
					}
						

					}
				}else {
					
					System.out.println("no values are available inside pro active monitoring dropdown for Add site order");
					DriverTestcase.logger.log(LogStatus.FAIL,"no values are available inside pro active monitoring dropdown for Add site order");
				}

					// smart monitoring
					smartmonitoring = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_smartmonitoring"))
							.isDisplayed();
					sa.assertTrue(smartmonitoring, "Smart monitoring dropdown is not displayed");

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_smartmonitoring")));
					List<WebElement> listofsmartmonitoring = driver
							.findElements(By.xpath("//div[@role='list']//span[@role='option']"));

				if(listofsmartmonitoring.size()>=1) {	
					for (WebElement smartmonitoringtypes : listofsmartmonitoring) {

						boolean match = false;
						for (int i = 0; i < Smartmonitoring.length; i++) {
							if (smartmonitoringtypes.getText().equals(Smartmonitoring[i])) {
								match = true;
								Log.info("list of smart monitoring are : " + smartmonitoringtypes.getText());
								sa.assertTrue(match);
								DriverTestcase.logger.log(LogStatus.PASS,"The list of smart monitoring  inside dropdown while  adding site order is: "+smartmonitoringtypes.getText());
							}
						}
						

					}
				}else {

					System.out.println("no values are available inside smart monitoring dropdown for Add site order");
					DriverTestcase.logger.log(LogStatus.FAIL,"no values are available inside smart monitoring dropdown for Add site order");
				}
					// Technology dropdown
					technology = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Technology"))
							.isDisplayed();
					sa.assertTrue(technology, "Technology dropdown is not displayed");

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Technology")));
					List<WebElement> listoftechnology = driver.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
					
				if(listoftechnology.size()>=1) {	
					for (WebElement technologytypes : listoftechnology) {

						boolean match = false;
						for (int i = 0; i < Technology.length; i++) {
							if (technologytypes.getText().equals(Technology[i])) {
								match = true;
								Log.info("list of technology are : " + technologytypes.getText());
								sa.assertTrue(match);
								DriverTestcase.logger.log(LogStatus.PASS,"The list of technology  inside dropdown while  adding site order is: "+technologytypes.getText());
							}
						}
						

					}
				}else {
					
					System.out.println("no values are available inside technology dropdown for Add site order");
					DriverTestcase.logger.log(LogStatus.FAIL,"no values are available inside technology dropdown for Add site order");
				}
				
			
				for(int k=0;k<Technology.length;k++) {
					
					if(Technology[k].equals("Actelis")) {
						DriverTestcase.logger.log(LogStatus.INFO, "when technology 'Actelis' is selected under Technology"
								+ "list of fields should occur: "
								+ "Site Alias field"
								+ "Vlan Id field"
								+ "DCA enabled site checkbox"
								+ "Remark field");
						
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Technology")));
						Clickon(getwebelement("//span[text()='" + Technology[k] + "']"));
							
						// Site alias Field
						sitealias = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_sitealias"))
								.isDisplayed();
						sa.assertTrue(sitealias, "Site alias field is not displayed");

						// VLAN id
						vlanid = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Vlanid")).isDisplayed();
						sa.assertTrue(sitealias, "VLAN id field is not displayed");

						// DCA Enabled site
						DCAenabledsite = getwebelement(
								xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")).isDisplayed();
						sa.assertTrue(DCAenabledsite, "DCA enabled site is not displayed ");
						sa.assertTrue(getwebelement(
								xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")).isSelected(),"DCA checkbox under Addsite order is selected by default");

						
						DriverTestcase.logger.log(LogStatus.INFO,"when DCA Enabled site checkbox is enabled, Cloud service provider dropdown should occur"
								+ "Cloud service provider should have values: "
								+ " 1) Amazon Web Service "
								+ " 2) Microsoft Azure");	
						
						// For Cloud service provider
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")));
						Log.info("DCA site is enabled to add cloud service provider details");
						DriverTestcase.logger.log(LogStatus.PASS,"DCA site is enabled to add cloud service provider details");

						cloudservice = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_cloudserviceProvider"))
								.isDisplayed();
						sa.assertTrue(cloudservice, "cloud service provider dropdown is not displayed");

						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_cloudserviceProvider")));
						List<WebElement> listofcloudservices = driver
								.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
						
					if(listofcloudservices.size()>0) {	
						for (WebElement cloudserviceprovidertypes : listofcloudservices) {

							boolean match = false;
							for (int i = 0; i < cloudServiceprovider.length; i++) {
								if (cloudserviceprovidertypes.getText().equals(cloudServiceprovider[i])) {
									match = true;
									Log.info("list of cloud service providers are : " + cloudserviceprovidertypes.getText());
									sa.assertTrue(match);
									DriverTestcase.logger.log(LogStatus.PASS,"The list of cloudservice provider inside dropdown while  adding site order is: "+cloudserviceprovidertypes.getText());
								}
							}
							

						}
					}else {
						System.out.println("no values are available inside cloudservice provider dropdown for Add site order");
						DriverTestcase.logger.log(LogStatus.FAIL,"no values are available inside cloudservice provider dropdown for Add site order");
						
					}
					
					
					remark = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_remark"))
					.isDisplayed();
					sa.assertTrue(remark, " Remark field is not displayed");
						
					}
					
					else if(Technology[k].equals("Atrica")) {
						
						DriverTestcase.logger.log(LogStatus.INFO, "when technology 'Atrica' is selected under Technology"
								+ "list of fields should occur: "
								+ "Site Alias field"
								+ "Vlan Id field"
								+ "DCA enabled site checkbox"
								+ "Device name - Mandatory field"
								+ "Non Termination point checkbox"
								+ "Protected checkbox"
								+ "Remark field");
						
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Technology")));
						Clickon(getwebelement("//span[text()='" + Technology[k] + "']"));
						
						// Site alias Field
						sitealias = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_sitealias"))
								.isDisplayed();
						sa.assertTrue(sitealias, "Site alias field is not displayed");
						

						// VLAN id
						vlanid = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Vlanid")).isDisplayed();
						sa.assertTrue(sitealias, "VLAN id field is not displayed");

						// DCA Enabled site
						DCAenabledsite = getwebelement(
								xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")).isDisplayed();
						DriverTestcase.logger.log(LogStatus.INFO, "By default DCA Enabled checkbox is disabled");
						sa.assertTrue(DCAenabledsite, "DCA enabled site is not displayed ");
						sa.assertTrue(getwebelement(
								xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")).isSelected(),"DCA checkbox under Add site order is selected by default");

						
						DriverTestcase.logger.log(LogStatus.INFO,"when DCA Enabled site checkbox is enabled, Cloud service provider dropdown should occur"
								+ "Cloud service provider should have values: "
								+ " 1) Amazon Web Service "
								+ " 2) Microsoft Azure");	
						
						// For Cloud service provider
						boolean dcaenable=getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")).isSelected();
						if(dcaenable) {
							System.out.println("DCA is selected");
						}else {
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")));
						}
						
						
						Log.info("DCA site is enabled to add cloud service provider details");
						DriverTestcase.logger.log(LogStatus.PASS,"DCA site is enabled to add cloud service provider details");

						cloudservice = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_cloudserviceProvider"))
								.isDisplayed();
						sa.assertTrue(cloudservice, "cloud service provider dropdown is not displayed");

						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_cloudserviceProvider")));
						List<WebElement> listofcloudservices = driver
								.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
						
					if(listofcloudservices.size()>0) {	
						for (WebElement cloudserviceprovidertypes : listofcloudservices) {

							boolean match = false;
							for (int i = 0; i < cloudServiceprovider.length; i++) {
								if (cloudserviceprovidertypes.getText().equals(cloudServiceprovider[i])) {
									match = true;
									Log.info("list of cloud service providers are : " + cloudserviceprovidertypes.getText());
									sa.assertTrue(match);
									DriverTestcase.logger.log(LogStatus.PASS,"The list of cloudservice provider inside dropdown while  adding site order is: "+cloudserviceprovidertypes.getText());
								}
							}
							

						}
					}else {
						System.out.println("no values are available inside cloudservice provider dropdown for Add site order");
						DriverTestcase.logger.log(LogStatus.FAIL,"no values are available inside cloudservice provider dropdown for Add site order");
						
					}

					devicename=	getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Devicenamefield")).isDisplayed();
					sa.assertTrue(devicename, "On selecting Atrica under Technology, Device name is not available");
					
					Nonterminationpointcheckbox=getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_nonterminationpoint")).isDisplayed();
					sa.assertTrue(Nonterminationpointcheckbox, "On selecting Atrica under Technology, Non termination point checkbox is not available");
					sa.assertTrue(getwebelement(
							xml.getlocator("//locators/" + application + "/Addsiteorder_nonterminationpoint")).isSelected(),"Non-termination point checbox under Add site is selected by default");

					
					portectedcheckbox=getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_protected")).isDisplayed();
					sa.assertTrue(portectedcheckbox, "On selecting Atrica under Technology, protected checkbox is not available");
					sa.assertTrue(getwebelement(
							xml.getlocator("//locators/" + application + "/Addsiteorder_protected")).isSelected(),"Protected checbox under Add site is selected by default");

					remark = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_remark"))
							.isDisplayed();
					sa.assertTrue(remark, " Remark field is not displayed");
							
					
					}
					
					else if(Technology[k].equals("Overture")) {
						
						DriverTestcase.logger.log(LogStatus.INFO, "when technology 'Overture' is selected under Technology"
								+ "list of fields should occur: "
								+ "Site Alias field"
								+ "Vlan Id field"
								+ "DCA enabled site checkbox"
								+ "Non Termination point checkbox"
								+ "Protected checkbox"
								+ "Remark field");
						
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Technology")));
						Clickon(getwebelement("//span[text()='" + Technology[k] + "']"));
						
						// Site alias Field
						sitealias = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_sitealias"))
								.isDisplayed();
						sa.assertTrue(sitealias, "Site alias field is not displayed");
						

						// VLAN id
						vlanid = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Vlanid")).isDisplayed();
						sa.assertTrue(sitealias, "VLAN id field is not displayed");

						// DCA Enabled site
						DCAenabledsite = getwebelement(
								xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")).isDisplayed();
						DriverTestcase.logger.log(LogStatus.INFO, "By default DCA Enabled checkbox is disabled");
						sa.assertTrue(DCAenabledsite, "DCA enabled site is not displayed ");
						sa.assertTrue(getwebelement(
								xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")).isSelected(),"DCA checkbox under Add site order is selected by default");

						
						DriverTestcase.logger.log(LogStatus.INFO,"when DCA Enabled site checkbox is enabled, Cloud service provider dropdown should occur"
								+ "Cloud service provider should have values: "
								+ " 1) Amazon Web Service "
								+ " 2) Microsoft Azure");	
						
						// For Cloud service provider
						boolean dcaenable=getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")).isSelected();
						if(dcaenable) {
							System.out.println("DCA is already selected");
						}else {
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")));
						}
						Log.info("DCA site is enabled to add cloud service provider details");
						DriverTestcase.logger.log(LogStatus.PASS,"DCA site is enabled to add cloud service provider details");

						cloudservice = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_cloudserviceProvider"))
								.isDisplayed();
						sa.assertTrue(cloudservice, "cloud service provider dropdown is not displayed");

						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_cloudserviceProvider")));
						List<WebElement> listofcloudservices = driver
								.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
						
					if(listofcloudservices.size()>0) {	
						for (WebElement cloudserviceprovidertypes : listofcloudservices) {

							boolean match = false;
							for (int i = 0; i < cloudServiceprovider.length; i++) {
								if (cloudserviceprovidertypes.getText().equals(cloudServiceprovider[i])) {
									match = true;
									Log.info("list of cloud service providers are : " + cloudserviceprovidertypes.getText());
									sa.assertTrue(match);
									DriverTestcase.logger.log(LogStatus.PASS,"The list of cloudservice provider inside dropdown while  adding site order is: "+cloudserviceprovidertypes.getText());
								}
							}
							

						}
					}else {
						System.out.println("no values are available inside cloudservice provider dropdown for Add site order");
						DriverTestcase.logger.log(LogStatus.FAIL,"no values are available inside cloudservice provider dropdown for Add site order");
						
					}

					Nonterminationpointcheckbox=getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_nonterminationpoint")).isDisplayed();
					sa.assertTrue(Nonterminationpointcheckbox, "On selecting Atrica under Technology, Non termination point checkbox is not available");
					sa.assertTrue(getwebelement(
							xml.getlocator("//locators/" + application + "/Addsiteorder_nonterminationpoint")).isSelected(),"Non-termination point checbox under Add site is selected by default");

					
					portectedcheckbox=getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_protected")).isDisplayed();
					sa.assertTrue(portectedcheckbox, "On selecting Atrica under Technology, protected checkbox is not available");
					sa.assertTrue(getwebelement(
							xml.getlocator("//locators/" + application + "/Addsiteorder_protected")).isSelected(),"Protected checbox under Add site is selected by default");

					remark = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_remark"))
							.isDisplayed();
					sa.assertTrue(remark, " Remark field is not displayed");
							
					}	
					
					
					else if(Technology[k].equals("Accedian")) {
						
						DriverTestcase.logger.log(LogStatus.INFO, "when technology 'Accedian' is selected under Technology"
								+ "list of fields should occur: "
								+ "Site Alias field"
								+ "Vlan Id field"
								+ "DCA enabled site checkbox"
								+ "Non Termination point checkbox"
								+ "Protected checkbox"
								+ "Remark field");
						
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Technology")));
						Clickon(getwebelement("//span[text()='" + Technology[k] + "']"));
						
						// Site alias Field
						sitealias = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_sitealias"))
								.isDisplayed();
						sa.assertTrue(sitealias, "Site alias field is not displayed");
						

						// VLAN id
						vlanid = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Vlanid")).isDisplayed();
						sa.assertTrue(sitealias, "VLAN id field is not displayed");

						// DCA Enabled site
						DCAenabledsite = getwebelement(
								xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")).isDisplayed();
						DriverTestcase.logger.log(LogStatus.INFO, "By default DCA Enabled checkbox is disabled");
						sa.assertTrue(DCAenabledsite, "DCA enabled site is not displayed ");
						sa.assertTrue(getwebelement(
								xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")).isSelected(),"DCA checkbox under Add site order is selected by default");

						
						DriverTestcase.logger.log(LogStatus.INFO,"when DCA Enabled site checkbox is enabled, Cloud service provider dropdown should occur"
								+ "Cloud service provider should have values: "
								+ " 1) Amazon Web Service "
								+ " 2) Microsoft Azure");	
						
						// For Cloud service provider
						
						boolean dcaenable=getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")).isSelected();
						if(dcaenable) {
							System.out.println("DCA is already selected");
						}else {
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")));
						}
						
						Log.info("DCA site is enabled to add cloud service provider details");
						DriverTestcase.logger.log(LogStatus.PASS,"DCA site is enabled to add cloud service provider details");

						cloudservice = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_cloudserviceProvider"))
								.isDisplayed();
						sa.assertTrue(cloudservice, "cloud service provider dropdown is not displayed");

						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_cloudserviceProvider")));
						List<WebElement> listofcloudservices = driver
								.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
						
					if(listofcloudservices.size()>0) {	
						for (WebElement cloudserviceprovidertypes : listofcloudservices) {

							boolean match = false;
							for (int i = 0; i < cloudServiceprovider.length; i++) {
								if (cloudserviceprovidertypes.getText().equals(cloudServiceprovider[i])) {
									match = true;
									Log.info("list of cloud service providers are : " + cloudserviceprovidertypes.getText());
									sa.assertTrue(match);
									DriverTestcase.logger.log(LogStatus.PASS,"The list of cloudservice provider inside dropdown while  adding site order is: "+cloudserviceprovidertypes.getText());
								}
							}
							

						}
					}else {
						System.out.println("no values are available inside cloudservice provider dropdown for Add site order");
						DriverTestcase.logger.log(LogStatus.FAIL,"no values are available inside cloudservice provider dropdown for Add site order");
						
					}

					Nonterminationpointcheckbox=getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_nonterminationpoint")).isDisplayed();
					sa.assertTrue(Nonterminationpointcheckbox, "On selecting Atrica under Technology, Non termination point checkbox is not available");
					sa.assertTrue(getwebelement(
							xml.getlocator("//locators/" + application + "/Addsiteorder_nonterminationpoint")).isSelected(),"Non-termination point checbox under Add site is selected by default");

					
					portectedcheckbox=getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_protected")).isDisplayed();
					sa.assertTrue(portectedcheckbox, "On selecting Atrica under Technology, protected checkbox is not available");
					sa.assertTrue(getwebelement(
							xml.getlocator("//locators/" + application + "/Addsiteorder_protected")).isSelected(),"Protected checbox under Add site is selected by default");

					remark = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_remark"))
							.isDisplayed();
					sa.assertTrue(remark, " Remark field is not displayed");
							
					}	
					
					
					
					else if(Technology[k].equals("Cyan")) {
						
						DriverTestcase.logger.log(LogStatus.INFO, "when technology 'Cyan' is selected under Technology"
								+ "list of fields should occur: "
								+ "Site Alias field"
								+ "Vlan Id field"
								+ "DCA enabled site checkbox"
								+ "Non Termination point checkbox"
								+ "Remark field");
						
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Technology")));
						Clickon(getwebelement("//span[text()='" + Technology[k] + "']"));
						
						// Site alias Field
						sitealias = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_sitealias"))
								.isDisplayed();
						sa.assertTrue(sitealias, "Site alias field is not displayed");
						

						// VLAN id
						vlanid = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_Vlanid")).isDisplayed();
						sa.assertTrue(sitealias, "VLAN id field is not displayed");

						// DCA Enabled site
						DCAenabledsite = getwebelement(
								xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")).isDisplayed();
						DriverTestcase.logger.log(LogStatus.INFO, "By default DCA Enabled checkbox is disabled");
						sa.assertTrue(DCAenabledsite, "DCA enabled site is not displayed ");
						sa.assertTrue(getwebelement(
								xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")).isSelected(),"DCA checkbox under Add site order is selected by default");

						
						DriverTestcase.logger.log(LogStatus.INFO,"when DCA Enabled site checkbox is enabled, Cloud service provider dropdown should occur"
								+ "Cloud service provider should have values: "
								+ " 1) Amazon Web Service "
								+ " 2) Microsoft Azure");	
						
						// For Cloud service provider
						boolean dcaenable=getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")).isSelected();
						if(dcaenable) {
							System.out.println("DCA is already selected");
						}else {
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_DCAenabledsitecheckbox")));
						}
						Log.info("DCA site is enabled to add cloud service provider details");
						DriverTestcase.logger.log(LogStatus.PASS,"DCA site is enabled to add cloud service provider details");

						cloudservice = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_cloudserviceProvider"))
								.isDisplayed();
						sa.assertTrue(cloudservice, "cloud service provider dropdown is not displayed");

						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_cloudserviceProvider")));
						List<WebElement> listofcloudservices = driver
								.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
						
					if(listofcloudservices.size()>0) {	
						for (WebElement cloudserviceprovidertypes : listofcloudservices) {

							boolean match = false;
							for (int i = 0; i < cloudServiceprovider.length; i++) {
								if (cloudserviceprovidertypes.getText().equals(cloudServiceprovider[i])) {
									match = true;
									Log.info("list of cloud service providers are : " + cloudserviceprovidertypes.getText());
									sa.assertTrue(match);
									DriverTestcase.logger.log(LogStatus.PASS,"The list of cloudservice provider inside dropdown while  adding site order is: "+cloudserviceprovidertypes.getText());
								}
							}
							

						}
					}else {
						System.out.println("no values are available inside cloudservice provider dropdown for Add site order");
						DriverTestcase.logger.log(LogStatus.FAIL,"no values are available inside cloudservice provider dropdown for Add site order");
						
					}

					Nonterminationpointcheckbox=getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_nonterminationpoint")).isDisplayed();
					sa.assertTrue(Nonterminationpointcheckbox, "On selecting Atrica under Technology, Non termination point checkbox is not available");
					sa.assertTrue(getwebelement(
							xml.getlocator("//locators/" + application + "/Addsiteorder_nonterminationpoint")).isSelected(),"Non-termination point checbox under Add site is selected by default");

					remark = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_remark"))
							.isDisplayed();
					sa.assertTrue(remark, " Remark field is not displayed");
							
					}	
					
				}
				
							
				
				
				
					// Next button
					ok = getwebelement(xml.getlocator("//locators/" + application + "/okbutton")).isDisplayed();
					sa.assertTrue(ok, "OK button is not displayed");

					// Cancel button
					cancel = getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_cancel")).isDisplayed();
					sa.assertTrue(cancel, "Cancel button is not "
							+ "displayed");
					
					

					sa.assertAll();
					
				}catch(AssertionError e) {
				   e.printStackTrace();
					}
			Thread.sleep(3000);
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addsiteorder_cancel")));
			

				
		}

		public void selectRowForsiteorder(String Application, String siteordernumber)
				throws InterruptedException, DocumentException, IOException {

			int TotalPages;

			// scroll down the page
//			  JavascriptExecutor js = ((JavascriptExecutor) driver);
//			  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//			  Thread.sleep(3000);

			String TextKeyword = Gettext(
					getwebelement(xml.getlocator("//locators/" + Application + "/TotalPagesforsiteorder")));

			TotalPages = Integer.parseInt(TextKeyword);

			System.out.println("Total number of pages in table is: " + TotalPages);

			ab:

			for (int k = 1; k <= TotalPages; k++) {

				// Current page
				String CurrentPage = Gettext(
						getwebelement(xml.getlocator("//locators/" + Application + "/Currentpageforsiteorderfunc")));
				int Current_page = Integer.parseInt(CurrentPage);
				System.out.println("The current page is: " + Current_page);

				assertEquals(k, Current_page);

				System.out.println("Currently we are in page number: " + Current_page);

				List<WebElement> results = driver
						.findElements(By.xpath("//div[div[contains(text(),'" + siteordernumber + "')]]//input"));

				int numofrows = results.size();
				System.out.println("no of results: " + numofrows);
				boolean resultflag;

				if (numofrows == 0) {

//					PageNavigation_NextPage(Application);
					Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/pagenavigationfornextpage_underviewserviceforsiteorder")));
					

				}

				else {

					for (int i = 0; i < numofrows; i++) {

						try {

							resultflag = results.get(i).isDisplayed();
							System.out.println("status of result: " + resultflag);
							if (resultflag) {
								System.out.println(results.get(i).getText());
								results.get(i).click();
								Thread.sleep(8000);
								Clickon(getwebelement(
										xml.getlocator("//locators/" + Application + "/Actiondropdown_siteorder")));

								Thread.sleep(5000);

							}

						} catch (StaleElementReferenceException e) {
							// TODO Auto-generated catch block
							// e.printStackTrace();
							results = driver.findElements(
									By.xpath("//div[div[contains(text(),'" + siteordernumber + "')]]//input"));
							numofrows = results.size();
							// results.get(i).click();
							Log.info("selected row is : " + i);

						}

					}

					break ab;

				}

			}

		}

		public void PageNavigation_NextPage(String Application) throws InterruptedException, DocumentException {

			Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/Pagenavigationfornextpage")));
			Thread.sleep(3000);

		}

		public void AddCPEdevice(String application, String cpename, String vender, String snmpro, String managementAddress,
				String Mepid, String poweralarm, String Mediaselection, String Macaddress, String serialNumber,
				String hexaSerialnumber, String linkLostForwarding)
				throws InterruptedException, DocumentException, IOException {

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/CPEdevice_adddevicelink")));
			Thread.sleep(3000);

//				 driver.navigate().to("http://172.30.246.170:4400/#/addLanLinkDirectFiberSiteDevice");
			Thread.sleep(3000);

			System.out.println("enter details to add CPE device");

			Log.info("Adding details to the fields to create a CPE device");

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_Name")), cpename);

//	      	Select(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_vender")), vender);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_snmpro")), snmpro);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_manageaddress")),
					managementAddress);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_mepid")), Mepid);

//	      	Select(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_poweralarm")), poweralarm);

//	      	Select(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_mediaselection")), Mediaselection);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_macaddress")), Macaddress);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_serialnumber")),
					serialNumber);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_hexaserialnumber")),
					hexaSerialnumber);

			if (linkLostForwarding.equalsIgnoreCase("yes")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_linklostforowarding")));
			}

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Next_Button")));

			Thread.sleep(3000);

		}

		public void viewCPEdevice(String application, String cpename, String vender, String snmpro,
				String managementAddress, String Mepid, String poweralarm, String Mediaselection, String Macaddress,
				String serialNumber, String hexaSerialnumber, String linkLostForwarding)
				throws InterruptedException, DocumentException, IOException {

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevicelink")));
			Thread.sleep(3000);

			String name = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_name")));
			sa.assertEquals(name, cpename, "name is displaying as expected");

			String vendor_model = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_vendor")));
			sa.assertEquals(vendor_model, vender, "Vendor name is displaying as expected");

			String snmPro = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_snmpro")));
			sa.assertEquals(snmPro, snmpro, "SNM pro name is displaying as expected");

			String manageaddress = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_managementAddress")));
			sa.assertEquals(manageaddress, managementAddress, "management address is displaying as expected");

			String mEPid = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_mepid")));
			sa.assertEquals(mEPid, Mepid, "MEP Id is displaying as expected");

			String powerAlarm = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_poweralarm")));
			sa.assertEquals(powerAlarm, poweralarm, "power alarm is displaying as expected");

			String mediaSelection = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_mediaselection")));
			sa.assertEquals(mediaSelection, Mediaselection, "Media selection is displaying as expected");

			String linkLostforwarding = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_linklostforwarding")));
			sa.assertEquals(linkLostforwarding, linkLostForwarding, "link lost forwarding is displaying as expected");

			String macAddress = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_macaddress")));
			sa.assertEquals(macAddress, Macaddress, "mac address is displaying as expected");

			String Serialnumber = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_serialnumber")));
			sa.assertEquals(Serialnumber, serialNumber, "Serial number is displaying as expected");

			String hexaSerialNumber = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_hexaserialnumber")));
			sa.assertEquals(hexaSerialNumber, hexaSerialnumber, "Hexa serial number is displaying as expected");

			sa.assertAll();

		}

		public void eDITCPEdevice(String application, String cpename, String vender, String snmpro,
				String managementAddress, String Mepid, String poweralarm, String Mediaselection, String Macaddress,
				String serialNumber, String hexaSerialnumber, String linkLostForwarding)
				throws InterruptedException, DocumentException, IOException {

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/viewPCEdevice_Actiondropdown")));
			Thread.sleep(3000);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EditCPEdevicelink")));
			Thread.sleep(3000);

//			  Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EditCPEdevlielink_underEquipment")));
//		     Thread.sleep(3000);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_Name")), cpename);

//	      	Select(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_vender")), vender);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_snmpro")), snmpro);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_manageaddress")),
					managementAddress);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_mepid")), Mepid);

//	      	Select(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_poweralarm")), poweralarm);

//	      	Select(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_mediaselection")), Mediaselection);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_macaddress")), Macaddress);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_serialnumber")),
					serialNumber);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_hexaserialnumber")),
					hexaSerialnumber);

			if (linkLostForwarding.equalsIgnoreCase("yes")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_linklostforowarding")));
			}

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Next_Button")));
			Thread.sleep(2000);

			System.out.println("Next buttton is not working under Add cpe device...... so gonnah select CAncel button");
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));

		}

		public void addCPEdeviceforIntermediateequipment(String application, String cpename, String vender, String snmpro,
				String managementAddress, String Mepid, String poweralarm, String Mediaselection, String Macaddress,
				String serialNumber, String hexaSerialnumber, String linkLostForwarding)
				throws InterruptedException, DocumentException, IOException {

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/CPEdevice_adddevicelink")));
			Thread.sleep(3000);

			System.out.println("enter details to add CPE device for intermediate equipment");

			Log.info("Adding details to the fields to create a CPE device");

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_Name")), cpename);

//	    	Select(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_vender")), vender);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_snmpro")), snmpro);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_manageaddress")),
					managementAddress);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_mepid")), Mepid);

//	    	Select(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_poweralarm")), poweralarm);

//	    	Select(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_mediaselection")), Mediaselection);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_macaddress")), Macaddress);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_serialnumber")),
					serialNumber);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_hexaserialnumber")),
					hexaSerialnumber);

			if (linkLostForwarding.equalsIgnoreCase("yes")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_linklostforowarding")));
			}

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Next_Button")));

			System.out.println("Next buttton is not working under Add cpe device...... so gonnah select CAncel button");
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));

			Thread.sleep(3000);

		}
		public void verifyFieldsforAddCPEdevicefortheserviceselected(String application)
				throws InterruptedException, DocumentException, IOException {
			
			
			DriverTestcase.logger.log(LogStatus.INFO, "Verifying fields for CPE device under Equipment");
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/CPEdevice_adddevicelink")));
			Thread.sleep(3000);
			try {
			
			String[] Vender= {"AC", "DC"};
			
			String[] powerAlarm= {"AC", "DC"};
			
			String[] Mediaselection= {"Type A","Type B","Type C"};	
			
//			try {
			boolean name=getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_Name")).isDisplayed();
			sa.assertTrue(name, "name field is not available under create device for Equipment");
//			sa.assertAll();
//			DriverTestcase.logger.log(LogStatus.PASS,"name field is available under create device for Equipment" );
//			
//			}catch(AssertionError e) {
//				e.printStackTrace();
//				DriverTestcase.logger.log(LogStatus.FAIL,"name field is not available under create device for Equipment" );
//			}
			
//			try {
			boolean vender=getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_vender")).isDisplayed();
			sa.assertTrue(vender, "Vender/Model dropdown is not available");
//			sa.assertAll();
//			DriverTestcase.logger.log(LogStatus.PASS,"Vender/Model dropdown is available under create device for Equipment" );
//		}catch(AssertionError e) {
//			e.printStackTrace();
//			DriverTestcase.logger.log(LogStatus.FAIL,"Vender/Model dropdown is not available under create device for Equipment" );
//		}
				
		
		  try {
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_vender")));
		  }catch (Exception e) {
			  e.printStackTrace();
			  DriverTestcase.logger.log(LogStatus.FAIL, "AddCPE device not available");  
		}
				
		  try {
		  List<WebElement> listofvender = driver.findElements(By.xpath("//div[@role='list']//span[@role='option']"));
				
				if(listofvender.size()>0) {
		
				for (WebElement vendertypes : listofvender) {

					boolean match = false;
					for (int i = 0; i < Vender.length; i++) {
						if (vendertypes.getText().equals(Vender[i])) {
							match = true;
							Log.info("list of vendor under add devices are : " + vendertypes.getText());
							DriverTestcase.logger.log(LogStatus.PASS,"The list of vender/Model under Add device are: "+vendertypes.getText());
							System.out.println("list of vendor under add devices are : " + vendertypes.getText());
							

						}
						}
					sa.assertTrue(match);
//					sa.assertAll();
					}
					
				}else {
					System.out.println("dropdown value inside Vender/Model is empty");
					DriverTestcase.logger.log(LogStatus.FAIL, "No values available inside Vender/Model dropdown for adding devices");
				}
				
		  }catch(Exception e) {
			  
			  e.printStackTrace();
			  DriverTestcase.logger.log(LogStatus.FAIL, "Failure at vendor dropdown");
			  
		  }
	      
				
//				try {
				boolean snmpro=getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_snmpro")).isDisplayed();
				sa.assertTrue(snmpro, "Snmpro field under add device is not available");
//				sa.assertAll();
//				DriverTestcase.logger.log(LogStatus.PASS,"Snmpro field is available under create device for Equipment" );
//				}catch(AssertionError e) {
//					e.printStackTrace();
//					DriverTestcase.logger.log(LogStatus.FAIL,"Snmpro field is not available under create device for Equipment" );
//				}
				
//				try {
				boolean managementaddres=getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_manageaddress")).isDisplayed();
				sa.assertTrue(managementaddres, "Management Address field under add device is not available");
//				sa.assertAll();
//				DriverTestcase.logger.log(LogStatus.PASS,"management Address field is available under create device for Equipment" );
//				}catch(AssertionError e) {
//					e.printStackTrace();
//					DriverTestcase.logger.log(LogStatus.FAIL,"management Address field is not available under create device for Equipment" );
//				}
				
//				try {
				boolean mepid=getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_mepid")).isDisplayed();
				sa.assertTrue(mepid, "Mepid field under add device is not available");
//				sa.assertAll();
//				DriverTestcase.logger.log(LogStatus.PASS,"mepid field is available under create device for Equipment" );
//				}catch(AssertionError e) {
//					e.printStackTrace();
//					DriverTestcase.logger.log(LogStatus.FAIL,"mepid field is not available under create device for Equipment" );
//				}
				
//				try {
				boolean powralrm=getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_poweralarm")).isDisplayed();
				sa.assertTrue(powralrm, "The poweralarm dropdown under add device is not available");
//				sa.assertAll();
//				DriverTestcase.logger.log(LogStatus.PASS,"power alarm dropdown is available under create device for Equipment" );
//			}catch(AssertionError e) {
//				e.printStackTrace();
//				DriverTestcase.logger.log(LogStatus.FAIL,"power alarm dropdown is not available under create device for Equipment" );
//			}
				
				
			try {	
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_poweralarm")));
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "Poweralarm dropdown field is not available");
			}
				
			try {
			List<WebElement> listofalarm = driver.findElements(By.xpath("//div[@role='list']//span[@role='option']"));

			if(listofalarm.size()>0) {	
				for (WebElement alarmtypes : listofalarm) {

					boolean match = false;
					for (int i = 0; i < powerAlarm.length; i++) {
						if (alarmtypes.getText().equals(powerAlarm[i])) {
							match = true;
							Log.info("list of power alarm under add devices are : " + alarmtypes.getText());
							DriverTestcase.logger.log(LogStatus.PASS,"The list of powerAlarm under Add device are: "+alarmtypes.getText());
							
							

						}
						}
					 sa.assertTrue(match);
//					 sa.assertAll();
					}
				   
				}else {
					System.out.println("dropdown value inside Vender/Model is empty");
					DriverTestcase.logger.log(LogStatus.FAIL, "No values available inside power alarm dropdown for adding devices");
				}
			}catch(Exception e) {
				  
				  e.printStackTrace();
				  DriverTestcase.logger.log(LogStatus.FAIL, "value mismatch for poweralarm dropdown");
				  
			  }
				
//			try {
				boolean media=getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_mediaselection")).isDisplayed();
				sa.assertTrue(media, "Media selection dropdwon under add devices is not available");
//				sa.assertAll();
//				DriverTestcase.logger.log(LogStatus.PASS,"media selection dropdown is available under create device for Equipment" );
//			}catch(AssertionError e) {
//				e.printStackTrace();
//				DriverTestcase.logger.log(LogStatus.FAIL,"media selection dropdown is not available under create device for Equipment" );
//			}
				
			try {
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_mediaselection")));
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "Mediaselection dropdown is not available");
			}
			try {	
			List<WebElement> listofmedia = driver.findElements(By.xpath("//div[@role='list']//span[@role='option']"));

			if(listofmedia.size()>0) {
				for (WebElement mediatypes : listofmedia) {

					boolean match = false;
					for (int i = 0; i < Mediaselection.length; i++) {
						if (mediatypes.getText().equals(Mediaselection[i])) {
							match = true;
							Log.info("list of Media selection under add devices are : " + mediatypes.getText());
							DriverTestcase.logger.log(LogStatus.PASS,"The list of media selection under Add device are: "+mediatypes.getText());
						}
						}
					sa.assertTrue(match);
					}
//				sa.assertAll();
					
				}else {
					System.out.println("dropdown value inside Vender/Model is empty");
					DriverTestcase.logger.log(LogStatus.FAIL, "No values available inside Media selection dropdown for adding devices");
				}
			}catch(Exception e) {
					e.printStackTrace();
					DriverTestcase.logger.log(LogStatus.FAIL, "FAilure at Media selection dropdown");
				}
				
				
//			try {
				boolean masAddrss=getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_macaddress")).isDisplayed();
				sa.assertTrue(masAddrss, "MAC Address field under add device is not available");
//				sa.assertAll();
//				DriverTestcase.logger.log(LogStatus.PASS,"mac address field is available under create device for Equipment" );
//			}catch(AssertionError e) {
//				e.printStackTrace();
//				DriverTestcase.logger.log(LogStatus.FAIL,"mac address field is not available under create device for Equipment" );
//			}
				
//			try {
				boolean serial=getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_serialnumber")).isDisplayed();
				sa.assertTrue(serial, "Serial number field is not available");
//				sa.assertAll();
//				DriverTestcase.logger.log(LogStatus.PASS,"serial number field is available under create device for Equipment" );
//			}catch(AssertionError e) {
//				e.printStackTrace();
//				DriverTestcase.logger.log(LogStatus.FAIL,"serial number field is not available under create device for Equipment" );
//			}
				
//			    try {
				boolean lanlink=getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_linklostforowarding")).isDisplayed();
				sa.assertTrue(lanlink, "Lanlink forwarding chckbox under add device is not available");
//				sa.assertAll();
//				DriverTestcase.logger.log(LogStatus.PASS,"link lost forwarding checkbox is available under create device for Equipment" );
//				}catch(AssertionError e) {
//					e.printStackTrace();
//					DriverTestcase.logger.log(LogStatus.FAIL,"link lost forwarding checkbox is not available under create device for Equipment" );
//				}
				
//			    try {
				boolean Ok=getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_OKbutton")).isDisplayed();
				sa.assertTrue(Ok, "OK button under add device is not available");
//				sa.assertAll();
//				DriverTestcase.logger.log(LogStatus.PASS,"ok button is available under create device for Equipment" );
//				}catch(AssertionError e) {
//					e.printStackTrace();
//					DriverTestcase.logger.log(LogStatus.FAIL,"ok button is not available under create device for Equipment" );
//				}
				
//				try {
				boolean cancel=getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_cancelbutton")).isDisplayed();
				sa.assertTrue(cancel, "cancel button under add device is not available");
//				sa.assertAll();
//				DriverTestcase.logger.log(LogStatus.PASS,"cancel button is available under create device for Equipment" );
//				}catch(AssertionError e) {
//					e.printStackTrace();
//					DriverTestcase.logger.log(LogStatus.FAIL,"cancel button is not available under create device for Equipment" );
//				}
		
			
			sa.assertAll();
			}catch(AssertionError e) {
				
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "FAiled while verify the fields for Add CPE device");
				
			}
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_cancelbutton")));
				 
			}
		
		public void AddCPEdevicefortheserviceselected(String application, String cpename, String vender, String snmpro,
				String managementAddress, String Mepid, String poweralarm, String Mediaselection, String Macaddress,
				String serialNumber, String hexaSerialnumber, String linkLostForwarding)
				throws InterruptedException, DocumentException, IOException {

			DriverTestcase.logger.log(LogStatus.INFO, "Adding device for equipment");
			
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/CPEdevice_adddevicelink")));
			
			Thread.sleep(3000);

			Log.info("Adding details to the fields to create a CPE device");

		//name	
			try {	
				if(cpename.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.FAIL, "No values has been passed for Mandatory 'Name' field for adding device under Equipment");
					
				}
			
				else {
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_Name")), cpename);
					DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for Mandatory 'Name' field for adding device under Equipment");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "FAilure at cpedevice Name field while entering input, as field is not available");
			}

		//vender/model	
			try {
				if(vender.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.FAIL, "No values has been passed for Mandatory 'Vendor/Model' dropdown for adding device under Equipment");
					
				}
			
				else {	
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_vender")));
					
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "add cpe device  vender/model dropdown field not avaialble");
			}
			
			
			try {
				if(vender.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.FAIL, "No values has been passed for Mandatory 'Vendor/Model' dropdown for adding device under Equipment");
					
				}
			
				else {	
			Clickon(getwebelement("//div[label[text()='Vender/Model']]//span[text()='"+vender +"']"));
			DriverTestcase.logger.log(LogStatus.PASS, "Values has been passed for Mandatory 'Vendor/Model' dropdown for adding device under Equipment");
				}
				}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "FAilure at Vender/model dropdown. It does not have the value provided as input");
			}
		
		
		//snmpro	
			try {
			if(snmpro.equalsIgnoreCase("null"))	{
				
				DriverTestcase.logger.log(LogStatus.FAIL, "No values has been passed for Mandatory field 'snmpro' for adding device under Equipment");
				
			}else {
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_snmpro")), snmpro);
				DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for Mandatory field 'snmpro' for adding device under Equipment");
			}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "FAilure at Snmpro name field while entering input, as field is not available ");
			}

			
		//manage address	
			try {
				if(managementAddress.equalsIgnoreCase("null")) {
					DriverTestcase.logger.log(LogStatus.FAIL, "No values has been passed for Mandatory field 'Manage Address' for adding device under Equipment");
				}else {
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_manageaddress")),
					managementAddress);
			DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for Mandatory field 'Manage Address' for adding device under Equipment");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "FAilure at cpedevice Management address text field while entering input , as field is not available");
			}

		//mepid	
			try {
				
				if(Mepid.equalsIgnoreCase("null")) {
					DriverTestcase.logger.log(LogStatus.INFO, "No values has been passed for 'mepid' field for adding device under Equipment");
					
				}else {
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_mepid")), Mepid);
					DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for 'Mepid' field for adding device under Equipment");
					
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "FAilure at cpedevice Mepid text field while entering input, as field is not available ");
			}
			
		
		//Power alarm	
			try {
				
				if(poweralarm.equalsIgnoreCase("null")) {
					DriverTestcase.logger.log(LogStatus.FAIL, "No values has been passed for Mandatory dropdown 'Power alarm' for adding device under Equipment");
				}else {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_poweralarm")));
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "Failure at Power alarm dropdown,as field is not available ");
			}
			
			
			try {
				
				if(poweralarm.equalsIgnoreCase("null")) {
					
					System.out.println("power alarm dropdown selected");
				}else {
					Clickon(getwebelement("//div[label[text()='Power Alarm']]//span[text()='"+poweralarm +"']"));
					DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for 'Power alarm' dropdwon field for adding device under Equipment");
					
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "FAilure at power alarm dropdown. It does not have the value provided as input ");
			}
			

		//Media selection	
			try {
				
				if(Mediaselection.equalsIgnoreCase("null")) {
					DriverTestcase.logger.log(LogStatus.FAIL, "No values has been passed for 'Media Selection' mandatory dropdwon field for adding device under Equipment");
				}else {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_mediaselection")));
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "media selection dropdown is not available ");
			}
			
			try {
				
				if(Mediaselection.equalsIgnoreCase("null")) {
					System.out.println("Media selection dropdown selected");
					
				}else {
					Clickon(getwebelement("//div[label[text()='Media Selection']]//span[text()='"+Mediaselection +"']"));
					DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for 'Media selection' dropdwon field for adding device under Equipment");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "FAilure at Media selection dropdown. It does not have the value provided as input");
			}
					

		//mac address	
			try {
				
				if(Macaddress.equalsIgnoreCase("null")) {
					DriverTestcase.logger.log(LogStatus.FAIL, " No values has been passed for 'mac address' mandatory field for adding device under Equipment");
				}else {
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_macaddress")), Macaddress);
					DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for 'mac address' text field for adding device under Equipment");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "Failure at 'mac address' text field while entering input,as field is not available");
			}

			
			
			
		//serial number	
			try {
				
				if(serialNumber.equalsIgnoreCase("null")) {
					DriverTestcase.logger.log(LogStatus.INFO, " No values has been passed for 'Serial number' field for adding device under Equipment");
				}else {
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_serialnumber")), serialNumber);
					DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for 'mac address' text field for adding device under Equipment");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "Failure at 'mac address' text field while entering input,as field is not available");
			}
			
	//
//			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_hexaserialnumber")),
//					hexaSerialnumber);

			if (linkLostForwarding.equalsIgnoreCase("yes")) {
			
				try {
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_linklostforowarding")));
				DriverTestcase.logger.log(LogStatus.PASS, "Link lost forwarding checkbox is selected for adding device under Equipment");
				}catch(Exception e) {
					e.printStackTrace();
					DriverTestcase.logger.log(LogStatus.FAIL, "Link  lost forwarding checkbox is not avaialble");
				}
				
			} else {
				
				System.out.println("link lost forwarding is not selected");
				DriverTestcase.logger.log(LogStatus.PASS, "Link lost forwarding checkbox is not selected for adding device under Equipment");
				
				
			}

			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

			Thread.sleep(3000);

		}

		public void verifydetailsenteredforCPEdevice(String application, String cpename, String vender, String snmpro,
				String managementAddress, String Mepid, String poweralarm, String Mediaselection, String Macaddress,
				String serialNumber, String hexaSerialnumber, String linkLostForwarding)
				throws InterruptedException, DocumentException, IOException {
			
			DriverTestcase.logger.log(LogStatus.INFO, "verify the details entered for creating device");
			
	  try {
			String name = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_name")));
			System.out.println("Actual name: "+name);
			System.out.println("Expected name: "+cpename);
			sa.assertEquals(name, cpename, "name is not displaying as expected");

			String vendor_model = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_vendor")));
			sa.assertEquals(vendor_model, vender, "Vendor name is not displaying as expected");

			String snmPro = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_snmpro")));
			sa.assertEquals(snmPro, snmpro, "SNM pro name is not displaying as expected");

			String manageaddress = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_managementAddress")));
			System.out.println("the manage address is L: "+manageaddress);
			sa.assertEquals(manageaddress, managementAddress, "management address is not displaying as expected");

			String mEPid = Gettext(getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_mepid")));
			sa.assertEquals(mEPid, Mepid, "MEP Id is displaying as expected");

			String powerAlarm = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_poweralarm")));
			sa.assertEquals(powerAlarm, poweralarm, "power alarm is not displaying as expected");

			String mediaSelection = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_mediaselection")));
			sa.assertEquals(mediaSelection, Mediaselection, "Media selection is not displaying as expected");

			String linkLostforwarding = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_linklostforwarding")));
			System.out.println("link lost is : "+linkLostforwarding);
			sa.assertEquals(linkLostforwarding, linkLostForwarding, "link lost forwarding is not displaying as expected");

			String macAddress = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_macaddress")));
			sa.assertEquals(macAddress, Macaddress, "mac address is not displaying as expected");

			String Serialnumber = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_serialnumber")));
			sa.assertEquals(Serialnumber, serialNumber, "Serial number is not displaying as expected");

//			String hexaSerialNumber = Gettext(
//					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEdevice_hexaserialnumber")));
//			sa.assertEquals(hexaSerialNumber, hexaSerialnumber, "Hexa serial number is displaying as expected");

			sa.assertAll();
			
	  }catch(AssertionError e) {
		  e.printStackTrace();
		  
	  }

		}

		public void eDITCPEdevicedetailsentered(String application, String cpename, String vender, String snmpro,
				String managementAddress, String Mepid, String poweralarm, String Mediaselection, String Macaddress,
				String serialNumber, String hexaSerialnumber, String linkLostForwarding)
				throws InterruptedException, DocumentException, IOException {
			
			DriverTestcase.logger.log(LogStatus.INFO, "edit CPE device");
			
			System.out.println("Entered edit functionalitty");

			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/viewPCEdevice_Actiondropdown")));
			
			Thread.sleep(3000);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EditCPEdevicelinkunderviewpage")));
			Thread.sleep(3000);
			System.out.println("edit functionality worked");

//			  Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EditCPEdevlielink_underEquipment")));
//		     Thread.sleep(3000);

		//name field
			try {
				
			if(cpename.equalsIgnoreCase("null")) {
				
				DriverTestcase.logger.log(LogStatus.INFO, "No changes made for 'Name' field while editing cpe device under Equipment");
				
			}else {
				
			
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_Name")), cpename);
			DriverTestcase.logger.log(LogStatus.PASS, "changes made for 'Name' field while editing cpe device under Equipment");
			}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "Failure at mandatory field CPE Name while editing device");
			}
			Thread.sleep(3000);
			
		//vendor/model	
			try {	
				
				if(vender.equalsIgnoreCase("null")) {
					DriverTestcase.logger.log(LogStatus.INFO, "No changes made for 'Vender/Model' dropdown while editing cpe device under Equipment");
					
				}else {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_vender")));
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "Failure while trying to click on 'Vender/Model' dropdown while editing CPE device under Equipment");
			}
			Thread.sleep(3000);
			
		
			try {
				
				if(vender.equalsIgnoreCase("null")) {
					System.out.println("vender/model dropdown is selecetd fro creating device");
					
				}else {
			Clickon(getwebelement("//div[label[text()='Vender/Model']]//span[text()='"+vender +"']"));
			DriverTestcase.logger.log(LogStatus.PASS, "changes made for 'Vender/model' dropdown value while editing cpe device under Equipment");
			}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "Failuer while trying to select values from 'Vendor/Model' dropdown");
			}
			Thread.sleep(5000);

			
		//snmpro	
			try {
			  if(snmpro.equalsIgnoreCase("null")){
				  
				  DriverTestcase.logger.log(LogStatus.INFO, "No changes made for 'snmpro' field while editing cpe device under Equipment");
				  
			  }else {
				
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_snmpro")), snmpro);
			DriverTestcase.logger.log(LogStatus.PASS, "changes made for 'Snmpro' field while editing cpe device under Equipment");
			  }
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "Failure at 'Snmpro' mandatory field while editing Cpe device under Equipment");
			}
			Thread.sleep(3000);

		//manage address	
			try {
				if(managementAddress.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.INFO, "No changes made for 'Manage address' field while editing cpe device under Equipment");
					
				}else {
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_manageaddress")),
					managementAddress);
			DriverTestcase.logger.log(LogStatus.PASS, "changes made for 'manage address' field while editing cpe device under Equipment");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "FAilure at 'management address'' mandatory field while editing cpe device under Equipment");
			}
			Thread.sleep(3000);

		//mepid	
			try {
				if(Mepid.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.INFO, "No changes made for 'mepid' field while editing cpe device under Equipment");
					
				}else {
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_mepid")), Mepid);
			DriverTestcase.logger.log(LogStatus.PASS, "changes made for 'Mepid' field while editing cpe device under Equipment");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "Failure at 'MepId' field while editing Cpe device under Equipment");
			}
			Thread.sleep(3000);
			
		//power alarm	
			try {
				if(poweralarm.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.INFO, "No changes made for 'Power alarm' dropdown while editing cpe device under Equipment");
					
				}else {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_poweralarm")));
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "FAilure on clicking 'power alarm' mandatory dropdown while editing Cpe device under Equipment");
			}
			Thread.sleep(3000);
		    
			try {
				if(poweralarm.equalsIgnoreCase("null")) {
					System.out.println("POwer alarm dropdown is selected ");
					
				}else {
					Clickon(getwebelement("//div[label[text()='Power Alarm']]//span[text()='"+poweralarm +"']"));
					DriverTestcase.logger.log(LogStatus.PASS, "changes made for 'Power alarm' dropdown value while editing cpe device under Equipment");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "Failure on selecting values from 'power alarm' dropdwon while editing cpe device under Equipment");
			}
			Thread.sleep(3000);
		    
		//media selection   
			try {
				if(Mediaselection.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.INFO, "No changes made for 'Media selection' dropdown while editing cpe device under Equipment");
					
				}else {
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_mediaselection")));
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "Failure on 'Media selection' mandatory dropdown while editing cpe device under Equipment");
			}
			Thread.sleep(20000);
			
			
			try {
			if(Mediaselection.equalsIgnoreCase("null")) {
				System.out.println("Media selection dropdown is selected for creating cpe device");
				
				}else {
					Clickon(getwebelement("//div[label[text()='Media Selection']]//span[text()='"+Mediaselection +"']"));
					DriverTestcase.logger.log(LogStatus.PASS, "changes made for 'Media selection' dropdown while editing cpe device under Equipment");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "Failure while trying to select values inside the 'Media selection' dropdown for editing cpe device under Equipment");
			}

		    Thread.sleep(6000);
		    
		//Mac address    
		    try {
		    	if(Macaddress.equalsIgnoreCase("null")) {
		    		DriverTestcase.logger.log(LogStatus.INFO, "No changes made for 'Mac address' field while editing cpe device under Equipment");
				}else {
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_macaddress")), Macaddress);
					DriverTestcase.logger.log(LogStatus.PASS, "changes made for 'mac address' field while editing cpe device under Equipment");
				}
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	DriverTestcase.logger.log(LogStatus.FAIL, "Failure on 'mac adreess' mandatory field while editing cpe device under Equipment");
		    }

		   //serial number
		    try {
		    	if(serialNumber.equalsIgnoreCase("null")) {
					
		    		DriverTestcase.logger.log(LogStatus.INFO, "No changes made for 'serial' number field while editing cpe device under Equipment");
			
		    	}else {

		    		SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_serialnumber")),
		    				serialNumber);
		    		DriverTestcase.logger.log(LogStatus.PASS, "changes made for 'Serial number' field while editing cpe device under Equipment");
				}
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	DriverTestcase.logger.log(LogStatus.FAIL, "Failure at serial number field while editing cpe device under Equipment");
		    }
	
//			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_hexaserialnumber")),
//					hexaSerialnumber);

	//linklost forwarding	    
		    try { 
		    	
		    	if (linkLostForwarding.equalsIgnoreCase("null")) {
		    		
		    		DriverTestcase.logger.log(LogStatus.INFO, "No changes made for linklost forwarding while editing cpe device under equipment");
		    	}else {
		    
		    		boolean linklost=getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_linklostforowarding")).isSelected();
		    		
		    		if (linkLostForwarding.equalsIgnoreCase("yes")) {
				
		    			if(linklost) {
		    				DriverTestcase.logger.log(LogStatus.PASS, "linklost forwarding has been edited for cpe device under Equipment");
		    				
		    			}else {
		    				
		    				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_linklostforowarding")));
		    				DriverTestcase.logger.log(LogStatus.PASS, "linklost forwarding has been edited for cpe device under Equipment");
		    			}
		    			
				
		    		}else if(linkLostForwarding.equalsIgnoreCase("no")) {
		    			
		    			if(linklost) {
		    				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_linklostforowarding")));
		    				DriverTestcase.logger.log(LogStatus.PASS, "linklost forwarding has been edited for cpe device under Equipment");
		    				
		    			}else {
		    				
		    				DriverTestcase.logger.log(LogStatus.PASS, "linklost forwarding has been edited for cpe device under Equipment");
		    			}
		    			
		    		}
		    	}	

				}catch (Exception e) {
	
				    e.printStackTrace();
				    DriverTestcase.logger.log(LogStatus.FAIL, "Failure at 'linklost forwarding'  checkbox while editing cpe device under Equipment");
				}

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));
			Thread.sleep(2000);

		
			
		}
		
		
		public void AddCPEdevicefortheLAnlinkNationalservice(String application, String cpename, String vender, String snmpro,
				String managementAddress, String Mepid, String poweralarm, String Mediaselection, String Macaddress,
				String serialNumber, String hexaSerialnumber, String linkLostForwarding)
				throws InterruptedException, DocumentException, IOException {

			
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/CPEdevice_adddevicelink")));
			Thread.sleep(3000);

			Log.info("Adding details to the fields to create a CPE device");

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_Name")), cpename);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_vender")));
			Clickon(getwebelement("//div[label[text()='Vender/Model']]//span[text()='"+vender +"']"));
		
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_snmpro")), snmpro);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_manageaddress")),
					managementAddress);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_mepid")), Mepid);
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_poweralarm")));
		    Clickon(getwebelement("//div[label[text()='Power Alarm']]//span[text()='"+poweralarm +"']"));
			

			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_mediaselection")));
			Clickon(getwebelement("//div[label[text()='Media Selection']]//span[text()='"+Mediaselection +"']"));
					

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_macaddress")), Macaddress);

//			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_serialnumber")),
//					serialNumber);
	//
//			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_hexaserialnumber")),
//					hexaSerialnumber);

			if (linkLostForwarding.equalsIgnoreCase("yes")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEdevice_linklostforowarding")));
			} else {
				
			}

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

			Thread.sleep(3000);

		}

		
		public void addCPEdeviceforIntermediateequipment(String application, String cpename, String vender, String snmpro,
				String managementAddress, String Mepid, String poweralarm, String Mediaselection, String Macaddress,
				String serialNumber, String hexaSerialnumber, String linkLostForwarding, String country, String City,
				String Site, String Premise) throws InterruptedException, DocumentException, IOException {

			Thread.sleep(3000);
			
			Clickon(getwebelement(
					xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_adddevicelink")));
			Thread.sleep(3000);

			System.out.println("enter details to add CPE device for intermediate equipment");

			Log.info("Adding details to the fields to create a CPE device");
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateEquipment_OKbuttonforpopup")));
			Thread.sleep(3000);
			

			try {	
				if(cpename.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.FAIL, "No values has been passed for Mandatory 'Name' field for adding device under Intermediate Equipment");
					
				}
			
				else {
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_Name")),
							cpename);
					DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for Mandatory 'Name' field for adding device under Intermediate Equipment");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "FAilure at cpedevice Name field while entering input, as field is not available");
			}

			
			//vender/model	
			try {
				if(vender.equalsIgnoreCase("null")) {
					
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_vender")));
					DriverTestcase.logger.log(LogStatus.PASS, "'Vendor/Model' dropdown has been selected");
				}
			
				else {	
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_vender")));
					DriverTestcase.logger.log(LogStatus.PASS, "'Vendor/Model' dropdown has been selected");
					
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "add cpe device  vender/model dropdown field not avaialble");
			}
			
			
			try {
				if(vender.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.FAIL, "No values has been passed for Mandatory 'Vendor/Model' dropdown for adding device under Equipment");
					
				}
			
				else {	
					Clickon(getwebelement("//div[label[text()='Vender/Model']]//span[text()='"+vender +"']"));
			DriverTestcase.logger.log(LogStatus.PASS, "No such element present inside Vendor/Model dropdown in Add Intermediate equipment page");
				}
				}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "FAilure at Vender/model dropdown. It does not have the value provided as input");
			}
		
		
			
	//snmpro	
	try {
	if(snmpro.equalsIgnoreCase("null"))	{
		
		DriverTestcase.logger.log(LogStatus.FAIL, "No values has been passed for Mandatory field 'snmpro' for adding device under Intermediate Equipment");
		
	}else {
		SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_snmpro")),
				snmpro);
		DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for Mandatory field 'snmpro' for adding device under Intermediate Equipment");
	}
	}catch(Exception e) {
		e.printStackTrace();
		DriverTestcase.logger.log(LogStatus.FAIL, "FAilure at Snmpro name field while entering input, as field is not available ");
	}

		
		
		//manage address	
		try {
			if(managementAddress.equalsIgnoreCase("null")) {
				DriverTestcase.logger.log(LogStatus.FAIL, "No values has been passed for Mandatory field 'Manage Address' for adding device under Intermediate Equipment");
			}else {
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_manageaddress")),
						managementAddress);

		DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for Mandatory field 'Manage Address' for adding device under Intermediate Equipment");
			}
		}catch(Exception e) {
			e.printStackTrace();
			DriverTestcase.logger.log(LogStatus.FAIL, "FAilure at cpedevice Management address text field while entering input , as field is not available");
		}
		
		
		//mepid	
		try {
			
			if(Mepid.equalsIgnoreCase("null")) {
				DriverTestcase.logger.log(LogStatus.INFO, "No values has been passed for 'mepid' field for adding device under Intermediate Equipment");
				
			}else {
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_mepid")),
						Mepid);
				DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for 'Mepid' field for adding device under Intermediate Equipment");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			DriverTestcase.logger.log(LogStatus.FAIL, "FAilure at cpedevice Mepid text field while entering input, as field is not available ");
		}
		
		

		//Power alarm	
			try {
				
				if(poweralarm.equalsIgnoreCase("null")) {
					DriverTestcase.logger.log(LogStatus.FAIL, "No values has been passed for Mandatory dropdown 'Power alarm' for adding device under Intermediate Equipment");
				}else {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_poweralarm")));
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "Failure at Power alarm dropdown,as field is not available ");
			}
			
			
			try {
				
				if(poweralarm.equalsIgnoreCase("null")) {
					
					System.out.println("power alarm dropdown selected");
				}else {
					Clickon(getwebelement("//div[label[text()='Power Alarm']]//span[text()='"+poweralarm +"']"));
					DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for 'Power alarm' dropdwon field for adding device under Intermediate Equipment");
					
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "No such element present in Power alarm dropdown in Intermediate equipment pages");
			}
			
			//Media selection	
			try {
				
				if(Mediaselection.equalsIgnoreCase("null")) {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_mediaselection")));
					DriverTestcase.logger.log(LogStatus.PASS, "Media selection dropdown is selected");
				}else {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_mediaselection")));
					DriverTestcase.logger.log(LogStatus.PASS, "Media selection dropdown is selected");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "media selection dropdown is not available ");
			}
			
			try {
				
				if(Mediaselection.equalsIgnoreCase("null")) {
					System.out.println("Media selection dropdown selected");
					DriverTestcase.logger.log(LogStatus.FAIL, "No values has been passed for Mandatory dropdown 'Media selection' for adding device under Intermediate Equipment");
					
				}else {
					Clickon(getwebelement("//div[label[text()='Media Selection']]//span[text()='"+Mediaselection +"']"));
					DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for 'Media selection' dropdwon field for adding device under Intermediate Equipment");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "No such element present inside Media selection dropdown inn Intermediate equipment page");
			}
		
			

			//mac address	
				try {
					
					if(Macaddress.equalsIgnoreCase("null")) {
						DriverTestcase.logger.log(LogStatus.FAIL, " No values has been passed for 'mac address' mandatory field for adding device under Intermediate Equipment");
					}else {
						SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_macaddress")),
								Macaddress);
						DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for 'mac address' text field for adding device under Intermediate Equipment");
					}
				}catch(Exception e) {
					e.printStackTrace();
					DriverTestcase.logger.log(LogStatus.FAIL, "Failure at 'mac address' text field while entering input,as field is not available");
				}

				
				//serial number	
				try {
					
					if(serialNumber.equalsIgnoreCase("null")) {
						DriverTestcase.logger.log(LogStatus.INFO, " No values has been passed for 'Serial number' field for adding device under Intermediate Equipment");
					}else {
						SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_serialnumber")),
								serialNumber);
						DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for 'mac address' text field for adding device under Intermediate Equipment");
					}
				}catch(Exception e) {
					e.printStackTrace();
					DriverTestcase.logger.log(LogStatus.FAIL, "Failure at 'serial number' text field while entering input,as field is not available");
				}
						
	//
//			SendKeys(
//					getwebelement(
//							xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_hexaserialnumber")),
//					hexaSerialnumber);
				
				if (linkLostForwarding.equalsIgnoreCase("yes")) {
					
					try {
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_linklostforowarding")));
					DriverTestcase.logger.log(LogStatus.PASS, "Link lost forwarding checkbox is selected for adding device under Intermediate Equipment");
					}catch(Exception e) {
						e.printStackTrace();
						DriverTestcase.logger.log(LogStatus.FAIL, "Link  lost forwarding checkbox is not avaialble");
					}
					
				} else {
					
					System.out.println("link lost forwarding is not selected");
					DriverTestcase.logger.log(LogStatus.PASS, "Link lost forwarding checkbox is not selected for adding device under Intermediate Equipment");
					
					
				}
				
				
				
			
		//Country
				try {
				
				if(country.equalsIgnoreCase("null")) {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_countrydiv")));
					DriverTestcase.logger.log(LogStatus.PASS, "Country dropdown is selected");
				}else {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_countrydiv")));
					DriverTestcase.logger.log(LogStatus.PASS, "Country dropdown is selected");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "country dropdown is not available ");
			}
			
			try {
				
				if(Mediaselection.equalsIgnoreCase("null")) {
					System.out.println("Country dropdown selected");
					
				}else {
					Clickon(getwebelement("//div[label[text()='Country']]//span[text()='"+country +"']"));
					DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for 'Country' dropdwon field for adding device under Intermediate Equipment");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "No such element present inside Country dropdown inn Intermediate equipment page");
			}
		

			
			
		//City
			try {
				
				if(City.equalsIgnoreCase("null")) {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip__citydiv")));
					DriverTestcase.logger.log(LogStatus.PASS, "City dropdown is selected");
				}else {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip__citydiv")));
					DriverTestcase.logger.log(LogStatus.PASS, "City dropdown is selected");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "City dropdown is not available ");
			}
			
			try {
				
				if(Mediaselection.equalsIgnoreCase("null")) {
					System.out.println("City dropdown selected");
					
				}else {
					Clickon(getwebelement("//div[label[text()='City']]//span[text()='"+City +"']"));
					DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for 'City' dropdwon field for adding device under Intermediate Equipment");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "No such element present inside City dropdown inn Intermediate equipment page");
			}
		

		
		//site
			try {
				
				if(country.equalsIgnoreCase("null")) {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_sitediv")));
					DriverTestcase.logger.log(LogStatus.PASS, "Site dropdown is selected");
				}else {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_sitediv")));
					DriverTestcase.logger.log(LogStatus.PASS, "Site dropdown is selected");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "Site dropdown is not available ");
			}
			
			try {
				
				if(Mediaselection.equalsIgnoreCase("null")) {
					System.out.println("Site dropdown selected");
					
				}else {
					Clickon(getwebelement("//div[label[text()='Site']]//span[text()='"+Site +"']"));
					DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for 'Site' dropdwon field for adding device under Intermediate Equipment");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "No such element present inside Site dropdown inn Intermediate equipment page");
			}

			
			
		//Premise
			try {
				
				if(City.equalsIgnoreCase("null")) {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_premisediv")));
					DriverTestcase.logger.log(LogStatus.PASS, "premise dropdown is selected");
				}else {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_premisediv")));
					DriverTestcase.logger.log(LogStatus.PASS, "premise dropdown is selected");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "premise dropdown is not available ");
			}
			
			try {
				
				if(Mediaselection.equalsIgnoreCase("null")) {
					System.out.println("City dropdown selected");
					
				}else {
					Clickon(getwebelement("//div[label[text()='Premise']]//span[text()='"+Premise +"']"));
					DriverTestcase.logger.log(LogStatus.PASS, "values has been passed for 'Premise' dropdwon field for adding device under Intermediate Equipment");
				}
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "No such element present inside Premise dropdown inn Intermediate equipment page");
			}
		
			
			DriverTestcase.logger.log(LogStatus.INFO, "Input data has been passed for creating device");
		
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

		
			Thread.sleep(3000);

		}

		public void verifyCPEdevicedataenteredForIntermediateEquipment(String application, String cpename, String vender,
				String snmpro, String managementAddress, String Mepid, String poweralarm, String Mediaselection,
				String Macaddress, String serialNumber, String hexaSerialnumber, String linkLostForwarding, String country,
				String city, String site, String premise) throws InterruptedException, DocumentException, IOException {
			
			try {
	//
//			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/viewCPEforIntermediateEquiplink")));
//			Thread.sleep(3000);

			String name = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEforIntermediateEquip_name")));
			sa.assertEquals(name, cpename, "name is not displaying as expected");

			String vendor_model = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEforIntermediateEquip_vendor")));
			sa.assertEquals(vendor_model, vender, "Vendor name is not displaying as expected");

			String snmPro = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEforIntermediateEquip_snmpro")));
			sa.assertEquals(snmPro, snmpro, "SNM pro name is not displaying as expected");

			String manageaddress = Gettext(getwebelement(
					xml.getlocator("//locators/" + application + "/viewCPEforIntermediateEquip_managementAddress")));
			sa.assertEquals(manageaddress, managementAddress, "management address is not displaying as expected");

			String mEPid = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEforIntermediateEquip_mepid")));
			sa.assertEquals(mEPid, Mepid, "MEP Id is not displaying as expected");

			String powerAlarm = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEforIntermediateEquip_poweralarm")));
			sa.assertEquals(powerAlarm, poweralarm, "power alarm is not displaying as expected");

			String mediaSelection = Gettext(getwebelement(
					xml.getlocator("//locators/" + application + "/viewCPEforIntermediateEquip_mediaselection")));
			sa.assertEquals(mediaSelection, Mediaselection, "Media selection is not displaying as expected");

			String linkLostforwarding = Gettext(getwebelement(
					xml.getlocator("//locators/" + application + "/viewCPEforIntermediateEquip_linklostforwarding")));
			sa.assertEquals(linkLostforwarding, linkLostForwarding, "link lost forwarding is not displaying as expected");
			System.out.println("lan link expected va;ue: "+linkLostForwarding);
			System.out.println("lan link atualis: "+linkLostforwarding);

			String macAddress = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/viewCPEforIntermediateEquip_macaddress")));
			sa.assertEquals(macAddress, Macaddress, "mac address is not displaying as expected");

			String Serialnumber = Gettext(getwebelement(
					xml.getlocator("//locators/" + application + "/viewCPEforIntermediateEquip_serialnumber")));
			sa.assertEquals(Serialnumber, serialNumber, "Serial number is not displaying as expected");

//			String hexaSerialNumber = Gettext(getwebelement(
//					xml.getlocator("//locators/" + application + "/viewCPEforIntermediateEquip_hexaserialnumber")));
//			sa.assertEquals(hexaSerialNumber, hexaSerialnumber, "Hexa serial number is displaying as expected");

//			String Country = Gettext(getwebelement(
//					xml.getlocator("//locators/" + application + "/viewCPEforIntermediateEquip_country")));
//			sa.assertEquals(Country, country, "Country is not displaying as expected");
	//
//			String City = Gettext(getwebelement(
//					xml.getlocator("//locators/" + application + "/viewCPEforIntermediateEquip_city")));
//			sa.assertEquals(City, city, "City is not displaying as expected");
	//
//			String Site = Gettext(getwebelement(
//					xml.getlocator("//locators/" + application + "/viewCPEforIntermediateEquip_site")));
//			sa.assertEquals(Site, hexaSerialnumber, "Site is not displaying as expected");
	//
//			String Premise = Gettext(getwebelement(
//					xml.getlocator("//locators/" + application + "/viewCPEforIntermediateEquip_premise")));
//			sa.assertEquals(Premise, Premise, "Premise is not displaying as expected");


			sa.assertAll();
			
			DriverTestcase.logger.log(LogStatus.PASS, "data entered for creating device got verified");
			}catch(AssertionError  e) {
				
				System.out.println("assertions are captured");
				DriverTestcase.logger.log(LogStatus.FAIL, "verification failed for data entered while creating device ");

				e.printStackTrace();
					}
		}

		public void EDITCPEdevicedforIntermediateEquipment(String application, String Cpename, String vender, String snmpro,
				String managementAddress, String Mepid, String poweralarm, String Mediaselection, String Macaddress,
				String serialNumber, String hexaSerialnumber, String linkLostForwarding, String Country, String City,
				String Site, String Premise) throws InterruptedException, DocumentException, IOException {

			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ActiondropdownforEditLink_IntermediateEquipmentforcpedeviec")));
			Thread.sleep(3000);

			Clickon(getwebelement(
					xml.getlocator("//locators/" + application + "/EditCPEdeviceforIntermediateEquipmentlinkunderviewpage")));
			Thread.sleep(3000);
			System.out.println("edit functionality worked");

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_Name")),
					Cpename);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_vender")));
			try {
			Clickon(getwebelement("//div[label[text()='Vender/Model']]//span[text()='"+vender +"']"));
			}catch(Exception e) {
				System.out.println("No such element present inside Vendor/Model dropdown in Edit Intermediate equipment page");
			}
			
			
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_snmpro")),
					snmpro);

			SendKeys(
					getwebelement(
							xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_manageaddress")),
					managementAddress);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_mepid")),
					Mepid);



			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_poweralarm")));
			try {
		    Clickon(getwebelement("//div[label[text()='Power Alarm']]//span[text()='"+poweralarm +"']"));
			}catch(Exception e){
				System.out.println("No such element present in Power alarm dropdown in edit Intermediate equipment pages");
			}
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_mediaselection")));
			try {
			Clickon(getwebelement("//div[label[text()='Media Selection']]//span[text()='"+Mediaselection +"']"));
			}catch(Exception e) {
				System.out.println("No such element present inside Media selection dropdown in Edit Intermediate equipment page");
			}
			

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_macaddress")),
					Macaddress);

			SendKeys(
					getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_serialnumber")),
					serialNumber);

			SendKeys(
					getwebelement(
							xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_hexaserialnumber")),
					hexaSerialnumber);

			if (linkLostForwarding.equalsIgnoreCase("yes")) {

				Clickon(getwebelement(
						xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_linklostforowarding")));
			} else {
				System.out.println("link lost forwarding is not selected");
			}

//			Select(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_country")),
//					Country);
	//
//			Select(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip__city")), City);
	//
//			Select(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_site")), Site);
	//
//			Select(getwebelement(xml.getlocator("//locators/" + application + "/AddCPEforIntermediateEquip_premise")),
//					Premise);

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

		
		}
		
		public void deleteDeviceFromServiceForequipment(String application, String deleteDevice) throws InterruptedException, DocumentException {
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeletfromserviceforcpeDevice_Equipment")));
			Thread.sleep(3000);

			boolean deletemessage=getwebelement(xml.getlocator("//locators/" + application + "/deleteMessage_equipment")).isDisplayed();
			while(deletemessage) {
				Log.info("Are you sure want to delete - message is getting displayed on clicking DeletefromService link");
				Log.info("Delete popup message is getting displayed");
				DriverTestcase.logger.log(LogStatus.PASS, "  'Are you sure want to delete' - message is getting displayed on clicking DeletefromService link");
				break;
			}
			
			
			if(deleteDevice.equalsIgnoreCase("yes")) {
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/deletebutton_deletefromsrviceforequipment")));
				Thread.sleep(3000);
				DriverTestcase.logger.log(LogStatus.PASS, "Device has got deleted from service as expected");
				Log.info("Device got deleted from service as expected");

			}else {
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xbuttonfordeletefromservicepopup_Equipment")));
				Thread.sleep(3000);
				DriverTestcase.logger.log(LogStatus.PASS," Device is not deleted from service as expected");
				Log.info("Device is not deleted from service as expected");

			}
			
		}


		
	public void deleteDeviceFromServiceForIntermediateequipment(String application, String deleteDevice) throws InterruptedException, DocumentException {
			
			driver.navigate().to("http://localhost:4400/#/viewLanLinkDirectFiberSiteOrder");
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/deletefromservicelink_IntermediateEquipment")));
			Thread.sleep(3000);

			boolean deletemessage=getwebelement(xml.getlocator("//locators/" + application + "/deleteMessage_equipment")).isDisplayed();
			while(deletemessage) {
				Log.info("Are you sure want to delete - message is getting displayed on clicking DeletefromService link");
				Log.info("Delete popup message is getting displayed");
				break;
			}
			
			
			if(deleteDevice.equalsIgnoreCase("yes")) {
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/deletebutton_deletefromsrviceforequipment")));
				Thread.sleep(3000);
				
				Log.info("Device got deleted from service as expected");

			}else {
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/xbuttonfordeletefromservicepopup_Equipment")));
				Thread.sleep(3000);
				
				Log.info("Device is not deleted from service as expected");

			}
			
		}


	   public void VerifythefieldsforProviderEquipment(String application) throws InterruptedException, DocumentException {
		 
		try {
			   
		  boolean IMSlocation= getwebelement(xml.getlocator("//locators/" + application + "/AddPElink_LANlinkoutband")).isDisplayed();
		  sa.assertTrue(IMSlocation," IMS location dropdown is not displaying under Provider Equipment ");
		  
		  
		 boolean togglebutton= getwebelement(xml.getlocator("//locators/" + application + "/selectdevice_ToggleButton")).isDisplayed();
		 sa.assertTrue(togglebutton, "Toggle button is not disaplaying under Provider Equipment");
		  
		 boolean name= getwebelement(xml.getlocator("//locators/" + application + "/Name")).isDisplayed();
		 sa.assertTrue(name, "NAme field is not displaying under Provider Equipment");
		 
		 boolean vendor= getwebelement(xml.getlocator("//locators/" + application + "/VenderModel")).isDisplayed();
		 sa.assertTrue(vendor, "Vendor/Model dropdown ");
		 
		  
		 boolean address= getwebelement(xml.getlocator("//locators/" + application + "/managementaddress")).isDisplayed();
		 sa.assertTrue(address, "Management Address field ");
		  
		  boolean snmpro=getwebelement(xml.getlocator("//locators/" + application + "/Snmpro")).isDisplayed();
		  sa.assertTrue(snmpro, "SNM pro field");
		  
		  boolean Country=getwebelement(xml.getlocator("//locators/" + application + "/country")).isDisplayed();
		  sa.assertTrue(Country, "Country dropdown");
		  
		  boolean city=getwebelement(xml.getlocator("//locators/" + application + "/city")).isDisplayed();
		  sa.assertTrue(city, "City dropdown");
		  
		  boolean Site=getwebelement(xml.getlocator("//locators/" + application + "/site")).isDisplayed();
		  sa.assertTrue(Site, "Sitedropdown");
		  
		  boolean Premise=getwebelement(xml.getlocator("//locators/" + application + "/premise")).isDisplayed();
		  sa.assertTrue(Premise, "Premise dropdown");
		  
		  boolean Nextbutton= getwebelement(xml.getlocator("//locators/" + application + "/Next_Button")).isDisplayed();
		  sa.assertTrue(Nextbutton, "Next button");
		  
		  boolean cancelbutton= getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")).isDisplayed();
		  sa.assertTrue(cancelbutton, "Cancel button");
		  
		  
		  sa.assertAll();
		   
		   }catch(AssertionError e) {
			   e.printStackTrace();
		   }
		   
	   }

	 	

		public void providerEquipment(String application, String IMSlocation,
				String selectOrclicktogglebutttontocreateDevice, String name, String VendorModel, String ManagementAddress,
				String Snmpro, String Country, String City, String Site, String Premise)
				throws InterruptedException, DocumentException, IOException {

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddPElink_LANlinkoutband")));

			System.out.println("----- Going to perform add PE device actions------------");

			if (selectOrclicktogglebutttontocreateDevice.equalsIgnoreCase("create")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/selectdevice_ToggleButton")));

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Name")), name);

//						Select(getwebelement(xml.getlocator("//locators/"+application+"/VenderModel")), VendorModel);

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/managementaddress")),
						ManagementAddress);

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Snmpro")), Snmpro);

//						Select(getwebelement(xml.getlocator("//locators/"+application+"/country")), Country);
//						
//						Select(getwebelement(xml.getlocator("//locators/"+application+"/city")), City);
//						
//						Select(getwebelement(xml.getlocator("//locators/"+application+"/site")), Site);
//						
//						Select(getwebelement(xml.getlocator("//locators/"+application+"/premise")), Premise);
//						
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Next_Button")));

			}

			else {

				Select(getwebelement(xml.getlocator("//locators/" + application + "/SelectIMSlocation")), IMSlocation);

			}

		}

		public void CustomerPremiseEquipment(String application, String IMSlocation,
				String selectOrclicktogglebutttontocreateDevice, String name, String VendorModel, String ManagementAddress,
				String Snmpro, String Country, String City, String Site, String Premise)
				throws InterruptedException, DocumentException, IOException {

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddCPElink_LANlinkoutband")));

			System.out.println("----- Going to perform add PE device actions------------");

			if (selectOrclicktogglebutttontocreateDevice.equalsIgnoreCase("create")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/selectdevice_ToggleButton")));

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Name")), name);

//						Select(getwebelement(xml.getlocator("//locators/"+application+"/VenderModel")), VendorModel);

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/managementaddress")),
						ManagementAddress);

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Snmpro")), Snmpro);

//						Select(getwebelement(xml.getlocator("//locators/"+application+"/country")), Country);
//						
//						Select(getwebelement(xml.getlocator("//locators/"+application+"/city")), City);
//						
//						Select(getwebelement(xml.getlocator("//locators/"+application+"/site")), Site);
//						
//						Select(getwebelement(xml.getlocator("//locators/"+application+"/premise")), Premise);
//						
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Next_Button")));

			}

			else {

				Select(getwebelement(xml.getlocator("//locators/" + application + "/SelectIMSlocation")), IMSlocation);

			}

		}

		public void verifyPEdeviceEnteredvalue(String application, String name, String VendorModel, String ManagementAddress,
				String Snmpro, String Country, String City, String Site, String Premise)
				throws IOException, InterruptedException, DocumentException {

			try {
			String nAME = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/verifyPEname_lanlinkoutband")));
			sa.assertEquals(nAME, name, "provider equipment Name is displaying as expected");

			String vendor = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/verifyPEvendor_lanlinkoutband")));
			sa.assertEquals(vendor, VendorModel, "VendorModel is displaying as expectd");

			String address = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/verifyPEaddress_lanlinkoutband")));
			sa.assertEquals(address, ManagementAddress, "ManagementAddress is displaying as expectd");

			String snmpro = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/verifyPEsnmpro_lanlinkoutband")));
			sa.assertEquals(snmpro, Snmpro, "Snmpro is displaying as expectd");

			String country = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/verifyPEcountry_lanlinkoutband")));
			sa.assertEquals(country, Country, "Country is displaying as expectd");

			String city = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/verifyPECity_lanlinkoutband")));
			sa.assertEquals(city, City, "City is displaying as expectd");

			String sity = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/verifyPESite_lanlinkoutband")));
			sa.assertEquals(sity, Site, "Site is displaying as expectd");

			String premise = Gettext(
					getwebelement(xml.getlocator("//locators/" + application + "/verifyPEPremise_lanlinkoutband")));
			sa.assertEquals(premise, Premise, "Premise is displaying as expectd");
			
			sa.assertAll();
			
			}catch(AssertionError e) {
				e.printStackTrace();
			}

		}
		
		public void EditProviderEquipment(String application, String IMSlocation,
				String selectOrclicktogglebutttontocreateDevice, String name, String VendorModel, String ManagementAddress,
				String Snmpro, String Country, String City, String Site, String Premise) throws InterruptedException, DocumentException, IOException {
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/providerEquipment_actiondropdownfromviewpage")));
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/providerEquipment_Editlinkunderviewdevicepage")));
			
			

			System.out.println("----- Going to perform Edit PE device actions------------");

			if (selectOrclicktogglebutttontocreateDevice.equalsIgnoreCase("create")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/selectdevice_ToggleButton")));

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Name")), name);

//						Select(getwebelement(xml.getlocator("//locators/"+application+"/VenderModel")), VendorModel);

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/managementaddress")),
						ManagementAddress);

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Snmpro")), Snmpro);

//						Select(getwebelement(xml.getlocator("//locators/"+application+"/country")), Country);
//						
//						Select(getwebelement(xml.getlocator("//locators/"+application+"/city")), City);
//						
//						Select(getwebelement(xml.getlocator("//locators/"+application+"/site")), Site);
//						
//						Select(getwebelement(xml.getlocator("//locators/"+application+"/premise")), Premise);
//						
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Next_Button")));

			}

			else {

				Select(getwebelement(xml.getlocator("//locators/" + application + "/SelectIMSlocation")), IMSlocation);

			}
			
			
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Backbutton")));


		}

		
		public void AddDSLAMandHSL(String application, String DSLMdevice) throws InterruptedException, DocumentException {

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Actelisconfig_addDSLAM")));

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DSLM_Device_Select")));

			Clickon(getwebelement("//span[contains(text(),'" + DSLMdevice + "')]"));

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/List_HSL_Link")));
		}


		
		public void selectInterfacelinkforEqipment(String Application) throws InterruptedException, DocumentException {
			Thread.sleep(5000);

			DriverTestcase.logger.log(LogStatus.INFO, "check Select Interface link");
			
			try {
			Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/Equipment_selectInterfaceslink")));
			System.out.println("SelectInterface link for provider Equipment is selected");
			Log.info("Select an inertface to add with the service under equipment");
			DriverTestcase.logger.log(LogStatus.PASS, "Select Interface link has been clicked for cpe device under Equipment");
			}catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "Select Interface link is not available under Equipment");
			}
		}
		

		
		public void selectInterfacelinkforProviderEqipment(String Application) throws InterruptedException, DocumentException {
			Thread.sleep(5000);

			Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/Providerequipment_selectinterface")));
			System.out.println("SelectInterface link for Equipment is selected");
			Log.info("Select an inertface to add with the service under equipment");

		}

		public void selectInterfacelinkforIntermediateEqipment(String Application)
				throws InterruptedException, DocumentException {

			Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceToselect_backbutton")));
			try {
			Clickon(getwebelement(
					xml.getlocator("//locators/" + Application + "/IntermediateEquipment_selectInterfaceslink")));
			System.out.println("SelectInterface link for Intermediate Equipment is selected");
			Log.info("Select an inertface to add with the service under Intermediate equipment");
			DriverTestcase.logger.log(LogStatus.PASS, "Select Interface link has been clicked for cpe device under Intermediate Equipment");
		}catch(Exception e) {
			e.printStackTrace();
			DriverTestcase.logger.log(LogStatus.FAIL, "Select Interface link is not available under Intermediate Equipment");
		}

		}

		public void SelectInterfacetoaddwithservcie(String Application, String interfacenumber)
				throws InterruptedException, DocumentException, IOException {

			selectrowforInterfaceToselecttable(Application, interfacenumber);

			
		}

		public void SelectInterfacetoremovefromservice(String Application, String interfacename)
				throws IOException, InterruptedException, DocumentException {

			selectRowforInterfaceInService(Application, interfacename);

		
		}

		public void verifyInterfaceaddedToService(String application, String interfacenumber) {

			try {
			boolean result = driver
					.findElement(By.xpath("(//div[@class='row'])[7]//div[div[contains(text(),'" + interfacenumber + "')]]"))
					.isDisplayed();
			
			if(result) {
				
				DriverTestcase.logger.log(LogStatus.PASS, "Verified: Interface has been added to service");
				
			}else {
				DriverTestcase.logger.log(LogStatus.FAIL, "Verified: Interface not added to service");
			}
			} catch(Exception e) {
				e.printStackTrace();
				DriverTestcase.logger.log(LogStatus.FAIL, "FAilure while verifying whether interface got added to service");
			}

		}

		public void verifyInterfaceremovedFromService(String application, String interfacenumber)
				throws InterruptedException, DocumentException {

			try {
			boolean result = driver
					.findElement(By.xpath("(//div[@class='row'])[8]//div[div[contains(text(),'" + interfacenumber + "')]]"))
					.isDisplayed();
			
			if(result) {
				
				DriverTestcase.logger.log(LogStatus.PASS, "Verified: Interface has been removed from the service service");
				
			}else {
				
				DriverTestcase.logger.log(LogStatus.FAIL, "The selected interface is not removed from the service");
				
			}
			
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Failure while verifying the removed interface from the service");
			}

		}

		public void selectrowforInterfaceToselecttable(String Application, String interfacenumber)
				throws IOException, InterruptedException, DocumentException {

			int TotalPages;

			String TextKeyword = Gettext(
					getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceToselect_totalpage")));

			TotalPages = Integer.parseInt(TextKeyword);

			System.out.println("Total number of pages in Interface to select table is: " + TotalPages);

			ab:

			if (TotalPages != 0) {
				for (int k = 1; k <= TotalPages; k++) {

					// Current page
					String CurrentPage = Gettext(
							getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceToselect_currentpage")));
					int Current_page = Integer.parseInt(CurrentPage);

					assertEquals(k, Current_page);

					System.out.println("Currently we are in page number: " + Current_page);

					List<WebElement> results = driver.findElements(By.xpath(
							"(//div[@class='row'])[8]//div[div[contains(text(),'" + interfacenumber + "')]]//input"));

					String path = "//div[@class='row'])[8]//div[div[contains(text(),'" + interfacenumber + "')]]//input";

					System.out.println("the xpath is :" + path);

					int numofrows = results.size();
					System.out.println("no of results: " + numofrows);
					boolean resultflag;

					if (numofrows == 0) {

						PageNavigation_NextPageForInterfaceToselect(Application);

					}

					else {

						for (int i = 0; i < numofrows; i++) {

							try {

								resultflag = results.get(i).isDisplayed();
								System.out.println("status of result: " + resultflag);
								if (resultflag) {
									System.out.println(results.get(i).getText());
									results.get(i).click();
									Thread.sleep(8000);
									Clickon(getwebelement(xml.getlocator(
											"//locators/" + Application + "/InterfaceToselect_Actiondropdown")));

									Thread.sleep(5000);
									
									Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceToselect_addbuton")));
									DriverTestcase.logger.log(LogStatus.PASS, " clicked on 'Interface to select' link , after seleting an interface");


								}

							} catch (StaleElementReferenceException e) {
								// TODO Auto-generated catch block
								// e.printStackTrace();
								results = driver.findElements(By.xpath("(//div[@class='row'])[8]//div[div[contains(text(),'"
										+ interfacenumber + "')]]//input"));
								numofrows = results.size();
								// results.get(i).click();
								Log.info("selected row is : " + i);
								DriverTestcase.logger.log(LogStatus.FAIL, " Failure on selecting an Interface to ad with service ");


							}

						}

						break ab;

					}

				}

			} else {

				System.out.println("No values found inside the table");
				Log.info("No values available inside the Interfacetoselect table");
			}

		}

		public void selectRowforInterfaceInService(String Application, String interfacenumber)
				throws IOException, InterruptedException, DocumentException {

			int TotalPages;

			String TextKeyword = Gettext(
					getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceInselect_totalpage")));

			TotalPages = Integer.parseInt(TextKeyword);

			System.out.println("Total number of pages in table is: " + TotalPages);

			ab:

			if (TotalPages != 0) {
				for (int k = 1; k <= TotalPages; k++) {

					// Current page
					String CurrentPage = Gettext(
							getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceInselect_currentpage")));
					int Current_page = Integer.parseInt(CurrentPage);

					assertEquals(k, Current_page);

					System.out.println("Currently we are in page number: " + Current_page);

					List<WebElement> results = driver.findElements(By.xpath(
							"(//div[@class='row'])[7]//div[div[contains(text(),'" + interfacenumber + "')]]//input"));

					int numofrows = results.size();
					System.out.println("no of results: " + numofrows);
					boolean resultflag;

					if (numofrows == 0) {

						PageNavigation_NextPageForInterfaceToselect(Application);

					}

					else {

						for (int i = 0; i < numofrows; i++) {

							try {

								resultflag = results.get(i).isDisplayed();
								System.out.println("status of result: " + resultflag);
								if (resultflag) {
									System.out.println(results.get(i).getText());
									results.get(i).click();
									Thread.sleep(8000);
									Clickon(getwebelement(xml.getlocator(
											"//locators/" + Application + "/InterfaceInselect_Actiondropdown")));

									Thread.sleep(5000);
									
									Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceToselect_removebuton")));
									DriverTestcase.logger.log(LogStatus.PASS, "Inteface has been selected to get removed from service");

								}

							} catch (StaleElementReferenceException e) {
								// TODO Auto-generated catch block
								// e.printStackTrace();
								results = driver.findElements(By.xpath("(//div[@class='row'])[8]//div[div[contains(text(),'"
										+ interfacenumber + "')]]//input"));
								numofrows = results.size();
								// results.get(i).click();
								Log.info("selected row is : " + i);
								DriverTestcase.logger.log(LogStatus.FAIL, "failure while selecting interface to remove from service");

							}

						}

						break ab;

					}

				}

			} else {

				System.out.println("No values available in table");
				Log.info("No values available inside the InterfaceInService table");
			}

		}

		public void PageNavigation_NextPageForInterfaceToselect(String Application)
				throws InterruptedException, DocumentException {

			Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceToselect_nextpage")));
			Thread.sleep(3000);

		}

		public void PageNavigation_NextPageForInterfaceInService(String Application)
				throws InterruptedException, DocumentException {

			Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceInselect_nextpage")));
			Thread.sleep(3000);

		}

		
		

		public void selectconfigurelinkAndverifyEditInterfacefield(String application, String interfacename) throws InterruptedException, DocumentException, IOException {
			
			try {
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configurelink")));
			Thread.sleep(3000);
			
			selectRowForconfiglinkunderEquipmentconfig(application, interfacename);
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureActiondropdown")));
	        Thread.sleep(1000);	 	
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureEditlink")));
			Thread.sleep(3000);		
			
		    
			boolean XNGcircuitID=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureXNGCircuitID")).isDisplayed();
			sa.assertTrue(XNGcircuitID, "Circuit id is not displaying");
			
			System.out.println("Entering bearer type dropdown");
			boolean BearerTypedropdown=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerType")).isDisplayed();
			sa.assertTrue(BearerTypedropdown, "Circuit bearer type dropdown is not displaying");
			
			boolean Bearerspeed=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerSpeed")).isDisplayed();
			sa.assertTrue(Bearerspeed, "Circut bearer speed dropdown is not displaying");
			
			boolean bandwidth=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureTotalcircuitbandwidth")).isDisplayed();
			sa.assertTrue(bandwidth, "Total circuit bandwidth dropdown is not displaying");
			
			boolean vlan=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVLANid")).isDisplayed();
			sa.assertTrue(vlan, "VLAN ID field is not displaying");
			
			boolean vlantype=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVlanType")).isDisplayed();
			sa.assertTrue(vlantype, "VLANtype dropdown is not displaying");
			System.out.println("vlan type failed");
			
			boolean ok=getwebelement(xml.getlocator("//locators/" + application + "/okbutton")).isDisplayed();
			sa.assertTrue(ok, "Ok Button is not displaying");
			
			boolean CANCEL=getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")).isDisplayed();
			sa.assertTrue(CANCEL, "Cancel Button is not displaying");
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));
			Thread.sleep(3000);
			
			sa.assertAll();
			
			}catch(AssertionError e) {
				e.printStackTrace();
			}
			
		}
		
	public void selectconfigurelinkunderIntermediateEquipmentAndverifyEditInterfacefield(String application, String interfacename) throws InterruptedException, DocumentException, IOException {
			
		try {	
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateEquipment_Configurelink")));
			Thread.sleep(3000);
			
			selectRowForconfiglinkunderIntermediateEquipment(application, interfacename);
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureActiondropdown")));
	        Thread.sleep(1000);		
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureEditlink")));
			Thread.sleep(3000);		
			
		    
			boolean XNGcircuitID=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureXNGCircuitID")).isDisplayed();
			sa.assertTrue(XNGcircuitID, "Circuit id is not displaying");
			
			System.out.println("Entering bearer type dropdown");
			boolean BearerTypedropdown=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerType")).isDisplayed();
			sa.assertTrue(BearerTypedropdown, "Circuit bearer type dropdown is not displaying");
			
			boolean Bearerspeed=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerSpeed")).isDisplayed();
			sa.assertTrue(Bearerspeed, "Circut bearer speed dropdown is not displaying");
			
			boolean bandwidth=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureTotalcircuitbandwidth")).isDisplayed();
			sa.assertTrue(bandwidth, "Total circuit bandwidth dropdown is not displaying");
			
			boolean vlan=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVLANid")).isDisplayed();
			sa.assertTrue(vlan, "VLAN ID field is not displaying");
			
			boolean vlantype=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVlanType")).isDisplayed();
			sa.assertTrue(vlantype, "VLANtype dropdown is not displaying");
			System.out.println("vlan type failed");
			
			boolean ok=getwebelement(xml.getlocator("//locators/" + application + "/okbutton")).isDisplayed();
			sa.assertTrue(ok, "Ok Button is not displaying");
			
			boolean CANCEL=getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")).isDisplayed();
			sa.assertTrue(CANCEL, "Cancel Button is not displaying");
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));
			Thread.sleep(3000);
			
			sa.assertAll();
			DriverTestcase.logger.log(LogStatus.FAIL," Edit Interface fields are verified");
		}catch(AssertionError e) {
			e.printStackTrace();
			DriverTestcase.logger.log(LogStatus.FAIL, "Field validation failure for Edit Interface");
		}
			
		}
		
		
		
		
		public void SelectShowInterfacelinkAndVerifyEditInterfacePage(String application, String interfacename) throws InterruptedException, DocumentException, IOException {
			
		try {
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/CPEdevice_showinterfaceslink")));
			Thread.sleep(3000);
			
			selectRowForEditingInterface(application, interfacename);
			
			
//			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_showInterfaceActiondropdown")));
//			Thread.sleep(3000);		
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureEditlink")));
			Thread.sleep(3000);		
			
			
			boolean XNGcircuitID=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureXNGCircuitID")).isDisplayed();
			sa.assertTrue(XNGcircuitID, "Circuit id is not displaying");
			System.out.println("circuit id is fetched");
			
			System.out.println("Entering bearer type dropdown");
			boolean BearerTypedropdown=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerType")).isDisplayed();
			sa.assertTrue(BearerTypedropdown, "Circuit bearer type dropdown is not displaying");
			System.out.println("bearer type dropdown is fetchecd");
			
			boolean Bearerspeed=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerSpeed")).isDisplayed();
			sa.assertTrue(Bearerspeed, "Circut bearer speed dropdown is not displaying");
			
			
			boolean bandwidth=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureTotalcircuitbandwidth")).isDisplayed();
			sa.assertTrue(bandwidth, "Total circuit bandwidth dropdown is not displaying");
			
			boolean vlan=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVLANid")).isDisplayed();
			sa.assertTrue(vlan, "VLAN ID field is not displaying");
			
			boolean vlantype=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVlanType")).isDisplayed();
			sa.assertTrue(vlantype, "VLANtype dropdown is not displaying");
			
			
			boolean ok=getwebelement(xml.getlocator("//locators/" + application + "/okbutton")).isDisplayed();
			sa.assertTrue(ok, "Ok Button is not displaying");
			
			boolean CANCEL=getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")).isDisplayed();
			sa.assertTrue(CANCEL, "Cancel Button is not displaying");
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));
			Thread.sleep(3000);
			
			sa.assertAll();
			
		}catch(AssertionError e) {
			e.printStackTrace();
			DriverTestcase.logger.log(LogStatus.FAIL, "Field validation failure in 'Edit interface' popup page");
		}
			
		}
		
		
		public void SelectShowInterfacelink_IntermediateequipmentAndVerifyEditInterfacePage(String application, String interfacename) throws InterruptedException, DocumentException, IOException {
			
			try {
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/showInterface_ForIntermediateEquipment")));
			Thread.sleep(3000);
			
			selectRowUnderIntermediateEquipment(application, interfacename);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateEquipment_Actiondropdown")));
			Thread.sleep(3000);		
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateEquipment_Editlink")));
			Thread.sleep(3000);		
			
			
			boolean XNGcircuitID=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureXNGCircuitID")).isDisplayed();
			sa.assertTrue(XNGcircuitID, "Circuit id is not displaying");
			System.out.println("circuit id is fetched");
			
			System.out.println("Entering bearer type dropdown");
			boolean BearerTypedropdown=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerType")).isDisplayed();
			sa.assertTrue(BearerTypedropdown, "Circuit bearer type dropdown is not displaying");
			System.out.println("bearer type dropdown is fetchecd");
			
			boolean Bearerspeed=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerSpeed")).isDisplayed();
			sa.assertTrue(Bearerspeed, "Circut bearer speed dropdown is not displaying");
			
			
			boolean bandwidth=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureTotalcircuitbandwidth")).isDisplayed();
			sa.assertTrue(bandwidth, "Total circuit bandwidth dropdown is not displaying");
			
			boolean vlan=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVLANid")).isDisplayed();
			sa.assertTrue(vlan, "VLAN ID field is not displaying");
			
			boolean vlantype=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVlanType")).isDisplayed();
			sa.assertTrue(vlantype, "VLANtype dropdown is not displaying");
			
			
			boolean ok=getwebelement(xml.getlocator("//locators/" + application + "/okbutton")).isDisplayed();
			sa.assertTrue(ok, "Ok Button is not displaying");
			
			boolean CANCEL=getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")).isDisplayed();
			sa.assertTrue(CANCEL, "Cancel Button is not displaying");
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));
			Thread.sleep(3000);
			
			
			sa.assertAll();
			
			DriverTestcase.logger.log(LogStatus.FAIL," fields has been verified successfully for Edit interface on selecting show interface link under Intermediate Equipment");
			}catch(AssertionError e) {
				e.printStackTrace();
				
				DriverTestcase.logger.log(LogStatus.FAIL," field validation failure for Edit interface on selecting show interface link under Intermediate Equipment");
			}
			
		}
		
		
	public void SelectShowInterfacelink_CustomerPremiseeequipmentAndVerifyEditInterfacePage(String application, String interfacename) throws InterruptedException, DocumentException, IOException {
			
			try {
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/showInterface_ForIntermediateEquipment")));
			Thread.sleep(3000);
			
			selectRowUnderIntermediateEquipment(application, interfacename);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateEquipment_Actiondropdown")));
			Thread.sleep(3000);		
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateEquipment_Editlink")));
			Thread.sleep(3000);		
			
			
			boolean XNGcircuitID=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureXNGCircuitID")).isDisplayed();
			sa.assertTrue(XNGcircuitID, "Circuit id is not displaying");
			System.out.println("circuit id is fetched");
			
			System.out.println("Entering bearer type dropdown");
			boolean BearerTypedropdown=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerType")).isDisplayed();
			sa.assertTrue(BearerTypedropdown, "Circuit bearer type dropdown is not displaying");
			System.out.println("bearer type dropdown is fetchecd");
			
			boolean Bearerspeed=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerSpeed")).isDisplayed();
			sa.assertTrue(Bearerspeed, "Circut bearer speed dropdown is not displaying");
			
			
			boolean bandwidth=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureTotalcircuitbandwidth")).isDisplayed();
			sa.assertTrue(bandwidth, "Total circuit bandwidth dropdown is not displaying");
			
			boolean vlan=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVLANid")).isDisplayed();
			sa.assertTrue(vlan, "VLAN ID field is not displaying");
			
			boolean vlantype=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVlanType")).isDisplayed();
			sa.assertTrue(vlantype, "VLANtype dropdown is not displaying");
			
			
			boolean ok=getwebelement(xml.getlocator("//locators/" + application + "/okbutton")).isDisplayed();
			sa.assertTrue(ok, "Ok Button is not displaying");
			
			boolean CANCEL=getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")).isDisplayed();
			sa.assertTrue(CANCEL, "Cancel Button is not displaying");
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));
			Thread.sleep(3000);
			
			
			sa.assertAll();
			}catch(AssertionError e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		public void enterdataInsideEditInterfacepage(String application) {
			
		}



	public void selectRowForEditingInterface(String Application, String interfacename) throws InterruptedException, DocumentException, IOException {


		int TotalPages;

		// scroll down the page
//		  JavascriptExecutor js = ((JavascriptExecutor) driver);
//		  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		  Thread.sleep(3000);

		String TextKeyword = Gettext(
				getwebelement(xml.getlocator("//locators/" + Application + "/TotalPagesforsiteorder")));

		TotalPages = Integer.parseInt(TextKeyword);

		System.out.println("Total number of pages in table is: " + TotalPages);

		ab:

		for (int k = 1; k <= TotalPages; k++) {

			// Current page
			String CurrentPage = Gettext(
					getwebelement(xml.getlocator("//locators/" + Application + "/Currentpageforsiteorder")));
			int Current_page = Integer.parseInt(CurrentPage);
			System.out.println("The current page is: " + Current_page);

			assertEquals(k, Current_page);

			System.out.println("Currently we are in page number: " + Current_page);

			List<WebElement> results = driver
					.findElements(By.xpath("(//div[@class='ag-root-wrapper ag-layout-auto-height ag-ltr'])[2]//div[text()='"+interfacename +"']"));
			
			
				
			int numofrows = results.size();
			System.out.println("no of results: " + numofrows);
			boolean resultflag;

			if (numofrows == 0) {
				
				Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/pagenavigateforshowinterface")));
				Thread.sleep(3000);

				
				

			}

			else {

				for (int i = 0; i < numofrows; i++) {

					try {

						resultflag = results.get(i).isDisplayed();
						System.out.println("status of result: " + resultflag);
						if (resultflag) {
							System.out.println(results.get(i).getText());
							results.get(i).click();
							Thread.sleep(8000);
							Clickon(getwebelement(
									xml.getlocator("//locators/" + Application + "/ActiondropdownforshowInterfaceunderEquipment")));

											

						}

					} catch (StaleElementReferenceException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						results = driver.findElements(
								By.xpath("(//div[@class='ag-root-wrapper ag-layout-auto-height ag-ltr'])[2]//div[text()='"+interfacename +"']"));
						numofrows = results.size();
						// results.get(i).click();
						Log.info("selected row is : " + i);

					}

				}


			}

		}
	}


	public void selectRowForshowInterfaceunderProviderEquipment(String Application, String interfacename) throws IOException, InterruptedException, DocumentException {



		int TotalPages;

		// scroll down the page
//		  JavascriptExecutor js = ((JavascriptExecutor) driver);
//		  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		  Thread.sleep(3000);

		String TextKeyword = Gettext(
				getwebelement(xml.getlocator("//locators/" + Application + "/providerEquipment_showinterfaceTatoalpage")));

		TotalPages = Integer.parseInt(TextKeyword);

		System.out.println("Total number of pages in table is: " + TotalPages);

		ab:

		for (int k = 1; k <= TotalPages; k++) {

			// Current page
			String CurrentPage = Gettext(
					getwebelement(xml.getlocator("//locators/" + Application + "/providerEquipment_showinterfaceCurrentpage")));
			int Current_page = Integer.parseInt(CurrentPage);
			System.out.println("The current page is: " + Current_page);

			assertEquals(k, Current_page);

			System.out.println("Currently we are in page number: " + Current_page);

			List<WebElement> results = driver
					.findElements(By.xpath("(//div[@class='ag-body-viewport ag-layout-normal'])[1]//div[div[text()='"+interfacename +"']]//input"));
			
			
				
			int numofrows = results.size();
			System.out.println("no of results: " + numofrows);
			boolean resultflag;

			if (numofrows == 0) {

				Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/providerEquipment_showinterfaceNextpage")));
				

			}

			else {

				for (int i = 0; i < numofrows; i++) {

					try {

						resultflag = results.get(i).isDisplayed();
						System.out.println("status of result: " + resultflag);
						if (resultflag) {
							System.out.println(results.get(i).getText());
							results.get(i).click();
							Thread.sleep(8000);									

						}

					} catch (StaleElementReferenceException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						results = driver.findElements(
								By.xpath("(//div[@class='ag-body-viewport ag-layout-normal'])[1]//div[div[text()='"+interfacename +"']]//input"));
						numofrows = results.size();
						// results.get(i).click();
						Log.info("selected row is : " + i);

					}

				}


			}

		}

	}



	public void selectRowForshowInterfaceunderCustomerPremiseEquipment(String Application, String interfacename) throws IOException, InterruptedException, DocumentException {



		int TotalPages;

		// scroll down the page
//		  JavascriptExecutor js = ((JavascriptExecutor) driver);
//		  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		  Thread.sleep(3000);

		String TextKeyword = Gettext(
				getwebelement(xml.getlocator("//locators/" + Application + "/providerEquipment_showinterfaceTatoalpage")));

		TotalPages = Integer.parseInt(TextKeyword);

		System.out.println("Total number of pages in table is: " + TotalPages);

		ab:

		for (int k = 1; k <= TotalPages; k++) {

			// Current page
			String CurrentPage = Gettext(
					getwebelement(xml.getlocator("//locators/" + Application + "/providerEquipment_showinterfaceCurrentpage")));
			int Current_page = Integer.parseInt(CurrentPage);
			System.out.println("The current page is: " + Current_page);

			assertEquals(k, Current_page);

			System.out.println("Currently we are in page number: " + Current_page);

			List<WebElement> results = driver
					.findElements(By.xpath("(//div[@class='ag-body-viewport ag-layout-normal'])[1]//div[div[text()='"+interfacename +"']]//input"));
			
			
				
			int numofrows = results.size();
			System.out.println("no of results: " + numofrows);
			boolean resultflag;

			if (numofrows == 0) {

				Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/providerEquipment_showinterfaceNextpage")));
				

			}

			else {

				for (int i = 0; i < numofrows; i++) {

					try {

						resultflag = results.get(i).isDisplayed();
						System.out.println("status of result: " + resultflag);
						if (resultflag) {
							System.out.println(results.get(i).getText());
							results.get(i).click();
							Thread.sleep(8000);									

						}

					} catch (StaleElementReferenceException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						results = driver.findElements(
								By.xpath("(//div[@class='ag-body-viewport ag-layout-normal'])[1]//div[div[text()='"+interfacename +"']]//input"));
						numofrows = results.size();
						// results.get(i).click();
						Log.info("selected row is : " + i);

					}

				}


			}

		}

	}



	public void selectRowForconfiglinkunderEquipmentconfig(String Application, String interfacename) throws InterruptedException, DocumentException, IOException {


		int TotalPages;

		// scroll down the page
//		  JavascriptExecutor js = ((JavascriptExecutor) driver);
//		  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		  Thread.sleep(3000);

		String TextKeyword = Gettext(
				getwebelement(xml.getlocator("//locators/" + Application + "/Equipmentconfig_Totalpage")));

		TotalPages = Integer.parseInt(TextKeyword);

		System.out.println("Total number of pages in table is: " + TotalPages);

		ab:

		for (int k = 1; k <= TotalPages; k++) {

			// Current page
			String CurrentPage = Gettext(
					getwebelement(xml.getlocator("//locators/" + Application + "/Equipmentconfig_Currentpage")));
			int Current_page = Integer.parseInt(CurrentPage);
			System.out.println("The current page is: " + Current_page);

			assertEquals(k, Current_page);

			System.out.println("Currently we are in page number: " + Current_page);

			List<WebElement> results = driver
					.findElements(By.xpath("//div[div[contains(text(),'"+ interfacename +"')]]//input"));
			
			
				
			int numofrows = results.size();
			System.out.println("no of results: " + numofrows);
			boolean resultflag;

			if (numofrows == 0) {

	            Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/Equipmentconfig_nextpage")));		
	            Thread.sleep(3000);
				

			}

			else {

				for (int i = 0; i < numofrows; i++) {

					try {

						resultflag = results.get(i).isDisplayed();
						System.out.println("status of result: " + resultflag);
						if (resultflag) {
							System.out.println(results.get(i).getText());
							results.get(i).click();
							Thread.sleep(8000);										

						}

					} catch (StaleElementReferenceException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						results = driver.findElements(
								By.xpath("(//div[@class='ag-body-container ag-layout-normal'])[2]//div[div[contains(text(),'"+ interfacename+"')]]//input"));
						numofrows = results.size();
						// results.get(i).click();
						Log.info("selected row is : " + i);

					}

				}


			}

		}
	}


	public void selectRowForconfiglinkunderIntermediateEquipment(String Application, String interfacename) throws InterruptedException, DocumentException, IOException {


		int TotalPages;

		// scroll down the page
//		  JavascriptExecutor js = ((JavascriptExecutor) driver);
//		  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		  Thread.sleep(3000);

		String TextKeyword = Gettext(
				getwebelement(xml.getlocator("//locators/" + Application + "/intermediateEquip_Totalpage")));

		TotalPages = Integer.parseInt(TextKeyword);

		System.out.println("Total number of pages in table is: " + TotalPages);

		ab:

		for (int k = 1; k <= TotalPages; k++) {

			// Current page
			String CurrentPage = Gettext(
					getwebelement(xml.getlocator("//locators/" + Application + "/intermediateequip_currentpage")));
			int Current_page = Integer.parseInt(CurrentPage);
			System.out.println("The current page is: " + Current_page);

			assertEquals(k, Current_page);

			System.out.println("Currently we are in page number: " + Current_page);

			List<WebElement> results = driver
					.findElements(By.xpath("(//div[@class='ag-body-container ag-layout-normal'])[2]//div[div[contains(text(),'"+ interfacename+"')]]//input"));
			
			
				
			int numofrows = results.size();
			System.out.println("no of results: " + numofrows);
			boolean resultflag;

			if (numofrows == 0) {

				Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/intermediateequip_nextpage")));

			}

			else {

				for (int i = 0; i < numofrows; i++) {

					try {

						resultflag = results.get(i).isDisplayed();
						System.out.println("status of result: " + resultflag);
						if (resultflag) {
							System.out.println(results.get(i).getText());
							results.get(i).click();
							Thread.sleep(8000);
					
											

						}

					} catch (StaleElementReferenceException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						results = driver.findElements(
								By.xpath("(//div[@class='ag-body-container ag-layout-normal'])[2]//div[div[contains(text(),'"+ interfacename+"')]]//input"));
						numofrows = results.size();
						// results.get(i).click();
						Log.info("selected row is : " + i);

					}

				}


			}

		}
	}



	public void selectRowUnderIntermediateEquipment(String Application, String interfacename) throws InterruptedException, DocumentException, IOException {



		int TotalPages;
			

		String TextKeyword = Gettext(
				getwebelement(xml.getlocator("//locators/" + Application + "/totalpage_intermeiateshowinterfacelink")));

		TotalPages = Integer.parseInt(TextKeyword);

		System.out.println("Total number of pages in table is: " + TotalPages);

		ab:

		for (int k = 1; k <= TotalPages; k++) {

			// Current page
			String CurrentPage = Gettext(
					getwebelement(xml.getlocator("//locators/" + Application + "/currentpage_intermeduateshowinterfacelink")));
			int Current_page = Integer.parseInt(CurrentPage);
			System.out.println("The current page is: " + Current_page);

			assertEquals(k, Current_page);

			System.out.println("Currently we are in page number: " + Current_page);

			List<WebElement> results = driver
					.findElements(By.xpath("(//div[@class='ag-root-wrapper ag-layout-auto-height ag-ltr'])[8]//div[text()='"+ interfacename+"']"));

			int numofrows = results.size();
			System.out.println("no of results: " + numofrows);
			boolean resultflag;

			if (numofrows == 0) {

				Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/pagenavigateforIntermediate")));

			}

			else {

				for (int i = 0; i < numofrows; i++) {

					try {

						resultflag = results.get(i).isDisplayed();
						System.out.println("status of result: " + resultflag);
						if (resultflag) {
							System.out.println(results.get(i).getText());
							results.get(i).click();
							Thread.sleep(8000);
						
							Thread.sleep(5000);

						}

					} catch (StaleElementReferenceException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						results = driver.findElements(
								By.xpath(""));
						numofrows = results.size();
						// results.get(i).click();
						Log.info("selected row is : " + i);

					}

				}


			}


		}
	
	}


	    public void VerifyDataEnteredForSiteOrder(String application, String country, String city, String CSR_Name, String site,
				String performReport, String ProactiveMonitor, String smartmonitor, String technology, String siteallias,
				String VLANid, String DCAenabledsite, String cloudserviceprovider, String sitevalue, String remark)
				throws InterruptedException, DocumentException, IOException{
	    	
	    	try {
	    	
	    	String DeviceCountry =Gettext(getwebelement(xml.getlocator("//locators/" + application + "/verifysiteOrder_Devicecountry")));
	    	sa.assertEquals(DeviceCountry, country, "Under View site order page, DeviceCountry is not displayig as expected");
//	    	sa.assertAll();
//	    	}catch(AssertionError e) {
//	    		e.printStackTrace();
//	    		DriverTestcase.logger.log(LogStatus.FAIL, "Devicecountry value is not displaying as entered while creating site order");
//	    		
//	    	}
//	    	
//	    	try {
	    	String DevicexngCity=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/verifysiteOrder_DeviceCity")));
	    	sa.assertEquals(DevicexngCity, city, "Under View site order page, DevicexngCity is displayig as expected");
//	    	sa.assertAll();
//	    	}catch(AssertionError e) {
//	    		e.printStackTrace();
//	    		DriverTestcase.logger.log(LogStatus.FAIL, "Devicecity value is not displaying as entered while creating site order");
//	    		
//	    	}
//	    	
//	    	try {
	    	String csrname=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/verifysiteOrder_CSRname")));
	    	sa.assertEquals(csrname, CSR_Name, "Under View site order page, CSR_Name is displayig as expected");
	 
	    	String PerformanceReporting=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/verifysiteOrder_performReport")));
	    	sa.assertEquals(PerformanceReporting, performReport, "Under View site order page,PerformanceReporting is displayig as expected");
	    
	    	String proactivemonitor=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/verifysiteOrder_proactivemonitor")));
	    	sa.assertEquals(proactivemonitor, ProactiveMonitor, "Under View site order page, ProactiveMonitoring is displayig as expected");
	    
	    	String smartMonitoring=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/verifysiteOrder_smartmonitor")));
	    	sa.assertEquals(smartMonitoring, smartmonitor, "Under View site order page,smartMonitoring is displayig as expected");
	    	
	    	String deviceTechnology=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/verifysiteOrder_Technology")));
	    	sa.assertEquals(deviceTechnology, technology, "Under View site order page,DeviceTechnology is displayig as expected");
	    	
	    	String DCAsite=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/verifysiteOrder_DCAenabledsite")));
	    	sa.assertEquals(DCAsite, DCAenabledsite, "Under View site order page, DCAenabledsite is displayig as expected");
	    	
	    	
	    	String vlan=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/verifysiteOrder_VLAnid")));
	    	sa.assertEquals(vlan, VLANid, "Under View site order page, VLANid is displayig as expected");
	    
	    	String siteAlias=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/verifysiteOrder_sitealias")));
	    	sa.assertEquals(siteAlias, siteallias, "Under View site order page, Site Alias is displayig as expected");
	    
	    	String reMark=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/verifysiteOrder_remark")));
	    	sa.assertEquals(reMark, remark, "Under View site order page, Remark is displayig as expected");
	    
	    	
	    	
	    	sa.assertAll();
	    	
	    	DriverTestcase.logger.log(LogStatus.PASS, "data entered for adding site order got verified");
    		
	    	
	    	}catch(AssertionError e) {
	    		e.printStackTrace();
	    		DriverTestcase.logger.log(LogStatus.FAIL, "verification failed: data entered for adding site order gettting mismatches");
	    		
	    	}
	    	
	    	
	    	
	    	Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Backbutton")));
	    	Thread.sleep(3000);
	    }
	    
	    
	    
	    public void VerifySiteOrderdetailsInTable(String Application, String siteordernumber) throws InterruptedException, DocumentException, IOException {

	    	Thread.sleep(5000);
	    	
	    	
	    	System.out.println("Entererd inside the table");
	    	
			int TotalPages;

			// scroll down the page
//			  JavascriptExecutor js = ((JavascriptExecutor) driver);
//			  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//			  Thread.sleep(3000);

			String TextKeyword = Gettext(
					getwebelement(xml.getlocator("//locators/" + Application + "/TotalPagesforsiteorder")));

			TotalPages = Integer.parseInt(TextKeyword);

			System.out.println("Total number of pages in table is: " + TotalPages);

			ab:

	  if(TotalPages>=1) {			
			for (int k = 1; k <= TotalPages; k++) {

				// Current page
				String CurrentPage = Gettext(
						getwebelement(xml.getlocator("//locators/" + Application + "/Currentpageforsiteorder")));
				int Current_page = Integer.parseInt(CurrentPage);

				
				System.out.println("Checking whether next page button is disabled or not");
		
					
					boolean nextpage= getwebelement(xml.getlocator("//locators/" + Application + "/Pagenavigationfornextpage")).isEnabled();
		
					System.out.println("Entered while loop");
	  while(nextpage)
	  {
		  System.out.println("its enabled");
		  break;
	  }
				
			
				assertEquals(k, Current_page);


				List<WebElement> results = driver
						.findElements(By.xpath("//div[div[contains(text(),'" + siteordernumber + "')]]"));

				int numofrows = results.size();
				System.out.println("no of results: " + numofrows);
				boolean resultflag;

				if (numofrows == 0) {

					PageNavigation_NextPage(Application);

				}

				else {

					for (int i = 0; i < numofrows; i++) {

						try {

							resultflag = results.get(i).isDisplayed();
							System.out.println("status of result: " + resultflag);
							if (resultflag) {
								System.out.println("The field values are: "+results.get(i).getText());
								Log.info("The values stored in the table for adding site order are: "+results.get(i).getText());
								
							}

						} catch (StaleElementReferenceException e) {
							// TODO Auto-generated catch block
							// e.printStackTrace();
							results = driver.findElements(
									By.xpath("//div[div[contains(text(),'" + siteordernumber + "')]]"));
							numofrows = results.size();
							// results.get(i).click();
							Log.info("selected row is : " + i);

						}

					}

					break ab;

				}

			}
			
	      }else {
	    	  Log.info("The data entered for adding site order is not getting displyed inside the site order table.");
	    	  System.out.println("No values inside the site order table");
	      }

		}
	    
	    public void returnbacktoviewsiteorderpage(String application) throws InterruptedException, DocumentException {
	    	
	    	
	    	Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Backbutton")));
	    	Thread.sleep(5000);
	    }
	    
	    
	    public void EnterdataForEditInterfaceforShowInterfacelinkunderEquipment(String application, String interfacename, String circuitID, String bearertype, String bearerspeed, String totalbandwidth,
	    		String vlanid, String vlantype) throws InterruptedException, DocumentException, IOException {
	    	

	    	Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_showInterfaceActiondropdown")));
			Thread.sleep(3000);		
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureEditlink")));
			Thread.sleep(3000);		
			
		//Circuit ID	
		 try {	
			if(circuitID.equalsIgnoreCase("null")) {
				
				DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Circuit ID' ");
				
			}else {
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureXNGCircuitID")), circuitID);
			DriverTestcase.logger.log(LogStatus.PASS, "Value has been passed for 'Circuit ID' field");
			}
		 }catch(Exception e) {
			 e.printStackTrace();
			 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for  'circuit Id' field under 'Edit Interface' page  ");
		 }Thread.sleep(3000);
		
		//Bearer type	
		 
		 try {
			if(bearertype.equalsIgnoreCase("null")) {
				
//				DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Bearer type' ");
				
				System.out.println("Bearer type dropdown is selected");
				
			}else {
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerType")));
				DriverTestcase.logger.log(LogStatus.PASS, " 'Bearer type' dropdown has been selected");
				
			}
		 }catch(Exception e) {
			 e.printStackTrace();
			 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Bearer type' dropdown under 'Edit Interface' page  ");
		 }Thread.sleep(3000);
			
			
		 try {
			if(bearertype.equalsIgnoreCase("null")) {
				
				DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Bearer type' ");
				
			}else {
				
				Clickon(getwebelement("//span[text()='"+bearertype +"']"));
				DriverTestcase.logger.log(LogStatus.PASS, "Value has been selected for 'Bearer type' dropdown field");
			}
		 }catch(Exception e) {
			 e.printStackTrace();
			 DriverTestcase.logger.log(LogStatus.FAIL, "Failure while selecting value for 'Bearer type' dropdown under 'Edit Interface' page  ");
		 }Thread.sleep(3000);
			
	//Bearerspeed
		try {
			if(bearerspeed.equalsIgnoreCase("null")) {
				
				System.out.println("Bearer speed dropdown is selected");
			}else {
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerSpeed")));
			DriverTestcase.logger.log(LogStatus.PASS, " 'Bearer Speed' dropdown has been selected");
			}
		}catch(Exception e) {
			 e.printStackTrace();
			 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Bearer speed' dropdown under 'Edit Interface' page  ");
		 }Thread.sleep(3000);
			
			
		 try {
			if(bearerspeed.equalsIgnoreCase("null")) {
				
				DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Bearer speed' ");
				
			}else {
			Clickon(getwebelement("//span[text()='"+bearerspeed +"']"));
			DriverTestcase.logger.log(LogStatus.PASS, "Value has been selected for 'Bearer speed' dropdown field");
			}
		 }catch(Exception e) {
			 e.printStackTrace();
			 DriverTestcase.logger.log(LogStatus.FAIL, "Failure while selecting value for 'Bearer speed' under 'Edit Interface' page  ");
		 }Thread.sleep(3000);
			
			
		//Circuit bandwidth	
		 try {
			if(totalbandwidth.equalsIgnoreCase("null")) {
				
				 System.out.println("tatoal circuit bandwidth has been selected");
			}else {
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureTotalcircuitbandwidth")));
				DriverTestcase.logger.log(LogStatus.PASS, " 'Total circuit bandwidth' dropdown has been selected");
			}
		 }catch(Exception e) {
			 e.printStackTrace();
			 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Total circuit bandwidth' dropdown under 'Edit Interface' page  ");
		 }Thread.sleep(3000);
			
		 
		 try {
			if(totalbandwidth.equalsIgnoreCase("null")) {
				DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Total bandwidth' ");
				
			}else {
			Clickon(getwebelement("//span[text()='"+totalbandwidth +"']"));
			DriverTestcase.logger.log(LogStatus.PASS, "Value has been selected for 'Total bandwidth' dropdown field");
			}
		 }catch(Exception e) {
			 e.printStackTrace();
			 DriverTestcase.logger.log(LogStatus.FAIL, "Failure while selecting value under 'Total circuit bandwidth' dropdown under 'Edit Interface' page  ");
		 }Thread.sleep(3000);
			
		
		//vlan	
		 try {
			if(vlanid.equalsIgnoreCase("null")) {
				
				DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Vlan id'");
				
			}else {
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVLANid")), vlanid);
			DriverTestcase.logger.log(LogStatus.PASS, "Value has been passed for 'Vlan ID' field");
			}
			
		 }catch(Exception e) {
			 e.printStackTrace();
			 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Vlan id' dropdown under 'Edit Interface' page  ");
		 }Thread.sleep(3000);
			
			
			
		//vlantype
		 
		 try {
			if(vlantype.equalsIgnoreCase("null")) {
				
				System.out.println("Vlantype is selected");
			}else {
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVlanType")));
			DriverTestcase.logger.log(LogStatus.PASS, " 'Vlan type' dropdown has been selected");
			}
		 }catch(Exception e) {
			 e.printStackTrace();
			 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Vlan type' dropdown under 'Edit Interface' page  ");
		 }Thread.sleep(3000);
				
			
		 try {
			if(vlantype.equalsIgnoreCase("null")) {
				
				DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Vlan type' ");
				
			}else {
			
				Clickon(getwebelement("//span[text()='"+vlantype +"']"));
				DriverTestcase.logger.log(LogStatus.PASS, "Value has been selected for 'Vlan type' dropdown field");
			}
		 }catch(Exception e) {
			 e.printStackTrace();
			 DriverTestcase.logger.log(LogStatus.FAIL, "Failure while selecting value under 'Vlantype' dropdown under 'Edit Interface' page  ");
		 }Thread.sleep(3000);
			
			
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/CPEdevice_hideinterfaceslinkforequipment")));
			Thread.sleep(3000);
			   
	    }


	    public void EnterdataForEditInterfaceforShowInterfacelinkunderProviderEquipment(String application, String interfacename, String circuitID, String bearertype, String bearerspeed, String totalbandwidth,
	    		String vlanid, String vlantype) throws InterruptedException, DocumentException, IOException {
	    	

	    	
	    	Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_showInterfaceActiondropdown")));
			Thread.sleep(3000);		
			
	    	
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureEditlink")));
			Thread.sleep(3000);		
			
			
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureXNGCircuitID")), circuitID);
			

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerType")));
			Clickon(getwebelement("//span[text()='"+bearertype +"']"));
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerSpeed")));
			Clickon(getwebelement("//span[text()='"+bearerspeed +"']"));
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureTotalcircuitbandwidth")));
			Clickon(getwebelement("//span[text()='"+totalbandwidth +"']"));
			
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVLANid")), vlanid);
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVlanType")));
			Clickon(getwebelement("//span[text()='"+vlantype +"']"));
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));
			Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/CPEdevice_hideinterfaceslinkforequipment")));
			Thread.sleep(3000);
			   
	    }


	    public void EnterdataForEditInterfaceforShowInterfacelinkunderIntermediateEquipment(String application, String interfacename, String circuitID, String bearertype, String bearerspeed, String totalbandwidth,
	    		String vlanid, String vlantype) throws InterruptedException, DocumentException, IOException {
	    	
			
	    	Clickon(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateEquipment_Actiondropdown")));
			Thread.sleep(3000);		
			
	    	
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateEquipment_Editlink")));
			Thread.sleep(3000);		
			
			
			//Circuit ID	
			 try {	
				if(circuitID.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Circuit ID' ");
					
				}else {
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureXNGCircuitID")), circuitID);
				DriverTestcase.logger.log(LogStatus.PASS, "Value has been passed for 'Circuit ID' field");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for  'circuit Id' field under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
			
			//Bearer type	
			 
			 try {
				if(bearertype.equalsIgnoreCase("null")) {
					
//					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Bearer type' ");
					
					System.out.println("Bearer type dropdown is selected");
					
				}else {
					
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerType")));
					DriverTestcase.logger.log(LogStatus.PASS, " 'Bearer type' dropdown has been selected");
					
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Bearer type' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
				
			 try {
				if(bearertype.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Bearer type' ");
					
				}else {
					
					Clickon(getwebelement("//span[text()='"+bearertype +"']"));
					DriverTestcase.logger.log(LogStatus.PASS, "Value has been selected for 'Bearer type' dropdown field");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure while selecting value for 'Bearer type' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
		//Bearerspeed
			try {
				if(bearerspeed.equalsIgnoreCase("null")) {
					
					System.out.println("Bearer speed dropdown is selected");
				}else {
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerSpeed")));
				DriverTestcase.logger.log(LogStatus.PASS, " 'Bearer Speed' dropdown has been selected");
				}
			}catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Bearer speed' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
				
			 try {
				if(bearerspeed.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Bearer speed' ");
					
				}else {
				Clickon(getwebelement("//span[text()='"+bearerspeed +"']"));
				DriverTestcase.logger.log(LogStatus.PASS, "Value has been selected for 'Bearer speed' dropdown field");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure while selecting value for 'Bearer speed' under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
				
			//Circuit bandwidth	
			 try {
				if(totalbandwidth.equalsIgnoreCase("null")) {
					
					 System.out.println("tatoal circuit bandwidth has been selected");
				}else {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureTotalcircuitbandwidth")));
					DriverTestcase.logger.log(LogStatus.PASS, " 'Total circuit bandwidth' dropdown has been selected");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Total circuit bandwidth' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
			 
			 try {
				if(totalbandwidth.equalsIgnoreCase("null")) {
					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Total bandwidth' ");
					
				}else {
				Clickon(getwebelement("//span[text()='"+totalbandwidth +"']"));
				DriverTestcase.logger.log(LogStatus.PASS, "Value has been selected for 'Total bandwidth' dropdown field");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure while selecting value under 'Total circuit bandwidth' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
			
			//vlan	
			 try {
				if(vlanid.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Vlan id'");
					
				}else {
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVLANid")), vlanid);
				DriverTestcase.logger.log(LogStatus.PASS, "Value has been passed for 'Vlan ID' field");
				}
				
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Vlan id' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
				
				
			//vlantype
			 
			 try {
				if(vlantype.equalsIgnoreCase("null")) {
					
					System.out.println("Vlantype is selected");
				}else {
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVlanType")));
				DriverTestcase.logger.log(LogStatus.PASS, " 'Vlan type' dropdown has been selected");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Vlan type' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
					
				
			 try {
				if(vlantype.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Vlan type' ");
					
				}else {
				
					Clickon(getwebelement("//span[text()='"+vlantype +"']"));
					DriverTestcase.logger.log(LogStatus.PASS, "Value has been selected for 'Vlan type' dropdown field");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure while selecting value under 'Vlantype' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
				
				
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));
				Thread.sleep(5000);
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/HideInterface_ForIntermediateEquipment")));
			Thread.sleep(3000);
			   
	    }

	    
	    public void EnterdataForEditInterfaceforConfigurelinkunderEquipment(String application, String interfacename, String circuitID, String bearertype, String bearerspeed, String totalbandwidth,
	    		String vlanid, String vlantype) throws InterruptedException, DocumentException, IOException {
	    	

			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureActiondropdown")));
	        Thread.sleep(1000);		
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureEditlink")));
			Thread.sleep(3000);		
			
		    
//	        SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureXNGCircuitID")), circuitID);
//			
//
//			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerType")));
//			Clickon(getwebelement("//span[text()='"+bearertype +"']"));
//			
//			
//			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerSpeed")));
//			Clickon(getwebelement("//span[text()='"+bearerspeed +"']"));
//			
//			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureTotalcircuitbandwidth")));
//			Clickon(getwebelement("//span[text()='"+totalbandwidth +"']"));
//			
//			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVLANid")), vlanid);
//			
//			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVlanType")));
//			Clickon(getwebelement("//span[text()='"+vlantype +"']"));
			
			
			//Circuit ID	
			 try {	
				if(circuitID.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Circuit ID' ");
					
				}else {
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureXNGCircuitID")), circuitID);
				DriverTestcase.logger.log(LogStatus.PASS, "Value has been passed for 'Circuit ID' field");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for  'circuit Id' field under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
			
			//Bearer type	
			 
			 try {
				if(bearertype.equalsIgnoreCase("null")) {
					
//					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Bearer type' ");
					
					System.out.println("Bearer type dropdown is selected");
					
				}else {
					
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerType")));
					DriverTestcase.logger.log(LogStatus.PASS, " 'Bearer type' dropdown has been selected");
					
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Bearer type' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
				
			 try {
				if(bearertype.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Bearer type' ");
					
				}else {
					
					Clickon(getwebelement("//span[text()='"+bearertype +"']"));
					DriverTestcase.logger.log(LogStatus.PASS, "Value has been selected for 'Bearer type' dropdown field");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure while selecting value for 'Bearer type' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
		//Bearerspeed
			try {
				if(bearerspeed.equalsIgnoreCase("null")) {
					
					System.out.println("Bearer speed dropdown is selected");
				}else {
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerSpeed")));
				DriverTestcase.logger.log(LogStatus.PASS, " 'Bearer Speed' dropdown has been selected");
				}
			}catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Bearer speed' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
				
			 try {
				if(bearerspeed.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Bearer speed' ");
					
				}else {
				Clickon(getwebelement("//span[text()='"+bearerspeed +"']"));
				DriverTestcase.logger.log(LogStatus.PASS, "Value has been selected for 'Bearer speed' dropdown field");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure while selecting value for 'Bearer speed' under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
				
			//Circuit bandwidth	
			 try {
				if(totalbandwidth.equalsIgnoreCase("null")) {
					
					 System.out.println("tatoal circuit bandwidth has been selected");
				}else {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureTotalcircuitbandwidth")));
					DriverTestcase.logger.log(LogStatus.PASS, " 'Total circuit bandwidth' dropdown has been selected");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Total circuit bandwidth' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
			 
			 try {
				if(totalbandwidth.equalsIgnoreCase("null")) {
					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Total bandwidth' ");
					
				}else {
				Clickon(getwebelement("//span[text()='"+totalbandwidth +"']"));
				DriverTestcase.logger.log(LogStatus.PASS, "Value has been selected for 'Total bandwidth' dropdown field");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure while selecting value under 'Total circuit bandwidth' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
			
			//vlan	
			 try {
				if(vlanid.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Vlan id'");
					
				}else {
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVLANid")), vlanid);
				DriverTestcase.logger.log(LogStatus.PASS, "Value has been passed for 'Vlan ID' field");
				}
				
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Vlan id' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
				
				
			//vlantype
			 
			 try {
				if(vlantype.equalsIgnoreCase("null")) {
					
					System.out.println("Vlantype is selected");
				}else {
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVlanType")));
				DriverTestcase.logger.log(LogStatus.PASS, " 'Vlan type' dropdown has been selected");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Vlan type' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
					
				
			 try {
				if(vlantype.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Vlan type' ");
					
				}else {
				
					Clickon(getwebelement("//span[text()='"+vlantype +"']"));
					DriverTestcase.logger.log(LogStatus.PASS, "Value has been selected for 'Vlan type' dropdown field");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure while selecting value under 'Vlantype' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);

			
			
			
			DriverTestcase.logger.log(LogStatus.PASS, "Data has been entered inside Edit Interfaec page by selecting configure link under Equipment");
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));
			Thread.sleep(3000);
		
			   
	    }
	    
	    
	    public void EnterdataForEditInterfaceforConfigurelinkunderIntermediateEquipment(String application, String interfacename, String circuitID, String bearertype, String bearerspeed, String totalbandwidth,
	    		String vlanid, String vlantype) throws InterruptedException, DocumentException, IOException {
	    	

			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureActiondropdown")));
	        Thread.sleep(1000);		
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureEditlink")));
			Thread.sleep(3000);		
			
		    
//	        SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureXNGCircuitID")), circuitID);
//			
//
//			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerType")));
//			Clickon(getwebelement("//span[text()='"+bearertype +"']"));
//			
//			
//			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerSpeed")));
//			Clickon(getwebelement("//span[text()='"+bearerspeed +"']"));
//			
//			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureTotalcircuitbandwidth")));
//			Clickon(getwebelement("//span[text()='"+totalbandwidth +"']"));
//			
//			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVLANid")), vlanid);
//			
//			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVlanType")));
//			Clickon(getwebelement("//span[text()='"+vlantype +"']"));
			
			
			//Circuit ID	
			 try {	
				if(circuitID.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Circuit ID' ");
					
				}else {
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureXNGCircuitID")), circuitID);
				DriverTestcase.logger.log(LogStatus.PASS, "Value has been passed for 'Circuit ID' field");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for  'circuit Id' field under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
			
			//Bearer type	
			 
			 try {
				if(bearertype.equalsIgnoreCase("null")) {
					
//					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Bearer type' ");
					
					System.out.println("Bearer type dropdown is selected");
					
				}else {
					
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerType")));
					DriverTestcase.logger.log(LogStatus.PASS, " 'Bearer type' dropdown has been selected");
					
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Bearer type' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
				
			 try {
				if(bearertype.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Bearer type' ");
					
				}else {
					
					Clickon(getwebelement("//span[text()='"+bearertype +"']"));
					DriverTestcase.logger.log(LogStatus.PASS, "Value has been selected for 'Bearer type' dropdown field");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure while selecting value for 'Bearer type' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
		//Bearerspeed
			try {
				if(bearerspeed.equalsIgnoreCase("null")) {
					
					System.out.println("Bearer speed dropdown is selected");
				}else {
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerSpeed")));
				DriverTestcase.logger.log(LogStatus.PASS, " 'Bearer Speed' dropdown has been selected");
				}
			}catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Bearer speed' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
				
			 try {
				if(bearerspeed.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Bearer speed' ");
					
				}else {
				Clickon(getwebelement("//span[text()='"+bearerspeed +"']"));
				DriverTestcase.logger.log(LogStatus.PASS, "Value has been selected for 'Bearer speed' dropdown field");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure while selecting value for 'Bearer speed' under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
				
			//Circuit bandwidth	
			 try {
				if(totalbandwidth.equalsIgnoreCase("null")) {
					
					 System.out.println("tatoal circuit bandwidth has been selected");
				}else {
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureTotalcircuitbandwidth")));
					DriverTestcase.logger.log(LogStatus.PASS, " 'Total circuit bandwidth' dropdown has been selected");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Total circuit bandwidth' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
			 
			 try {
				if(totalbandwidth.equalsIgnoreCase("null")) {
					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Total bandwidth' ");
					
				}else {
				Clickon(getwebelement("//span[text()='"+totalbandwidth +"']"));
				DriverTestcase.logger.log(LogStatus.PASS, "Value has been selected for 'Total bandwidth' dropdown field");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure while selecting value under 'Total circuit bandwidth' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
			
			//vlan	
			 try {
				if(vlanid.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Vlan id'");
					
				}else {
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVLANid")), vlanid);
				DriverTestcase.logger.log(LogStatus.PASS, "Value has been passed for 'Vlan ID' field");
				}
				
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Vlan id' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
				
				
				
			//vlantype
			 
			 try {
				if(vlantype.equalsIgnoreCase("null")) {
					
					System.out.println("Vlantype is selected");
				}else {
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVlanType")));
				DriverTestcase.logger.log(LogStatus.PASS, " 'Vlan type' dropdown has been selected");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure for 'Vlan type' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);
					
				
			 try {
				if(vlantype.equalsIgnoreCase("null")) {
					
					DriverTestcase.logger.log(LogStatus.PASS, " No input provided for 'Vlan type' ");
					
				}else {
				
					Clickon(getwebelement("//span[text()='"+vlantype +"']"));
					DriverTestcase.logger.log(LogStatus.PASS, "Value has been selected for 'Vlan type' dropdown field");
				}
			 }catch(Exception e) {
				 e.printStackTrace();
				 DriverTestcase.logger.log(LogStatus.FAIL, "Failure while selecting value under 'Vlantype' dropdown under 'Edit Interface' page  ");
			 }Thread.sleep(3000);

			
			
			
		DriverTestcase.logger.log(LogStatus.PASS, "Data has been entered inside Edit Interface page by selecting configure link under Intermediate Equipment");	
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));
			Thread.sleep(3000);
		
			   
	    }
	    
	    
	    
	    
	    public void AddInterfaceToserviceforProviderEquipment(String Application, String interfacenumber) throws IOException, InterruptedException, DocumentException {
	    	
	    	int TotalPages;

			String TextKeyword = Gettext(
					getwebelement(xml.getlocator("//locators/" + Application + "/providerEquipment_InterfaceToselectTotalpage")));

			TotalPages = Integer.parseInt(TextKeyword);

			System.out.println("Total number of pages in Interface to select table is: " + TotalPages);

			ab:

			if (TotalPages != 0) {
				for (int k = 1; k <= TotalPages; k++) {

					// Current page
					String CurrentPage = Gettext(
							getwebelement(xml.getlocator("//locators/" + Application + "/providerEquipment_currentpageInterfaceToselect")));
					int Current_page = Integer.parseInt(CurrentPage);

					assertEquals(k, Current_page);

					System.out.println("Currently we are in page number: " + Current_page);

					List<WebElement> results = driver.findElements(By.xpath("(//div[@class='row'][2]//div[div[contains(text(),'"+interfacenumber +"')]])//input"));
					
					int numofrows = results.size();
					System.out.println("no of results: " + numofrows);
					boolean resultflag;

					if (numofrows == 0) {

						Clickon(getwebelement(xml.getlocator(
								"//locators/" + Application + "/providerEquipment_InterfaceToselectnextpage")));


					}
					
					else {

						for (int i = 0; i < numofrows; i++) {

							try {

								resultflag = results.get(i).isDisplayed();
								System.out.println("status of result: " + resultflag);
								if (resultflag) {
									System.out.println(results.get(i).getText());
									results.get(i).click();
									Thread.sleep(8000);
									Clickon(getwebelement(xml.getlocator(
											"//locators/" + Application + "/providerEquipment_InterfaceToselectActiondropdown")));

									Thread.sleep(5000);
									
									Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/providerEquipment_InterfaceToselectAddbutton")));


								}

							} catch (StaleElementReferenceException e) {
								// TODO Auto-generated catch block
								// e.printStackTrace();
								results = driver.findElements(By.xpath("(//div[@class='row'][2]//div[div[contains(text(),'"+interfacenumber +"')]])//input"));
								numofrows = results.size();
								// results.get(i).click();
								Log.info("selected row is : " + i);

							}

						}

						break ab;

					}

				}

			} else {

				System.out.println("No values found inside the table");
				Log.info("No values available inside the Interfacetoselect table");
			}

	    }

	    
	    public void verifyInterfaceaddedToServiceForProviderEquipment(String application, String interfacenumber) {

			try {
			boolean result = driver
					.findElement(By.xpath("(//div[@class='row'][1]//div[div[contains(text(),'"+interfacenumber +"')]])"))
					.isDisplayed();
			sa.assertTrue(result, "Verified: Interface got added to service");
			} catch(Exception e) {
				System.out.println("No values available inside the table");
			}

		}
	    
	    
	    public void ProviderEquipmentInterfaceInService(String Application, String interfacenumber) throws IOException, InterruptedException, DocumentException {
	    	


			int TotalPages;

			String TextKeyword = Gettext(
					getwebelement(xml.getlocator("//locators/" + Application + "/providerEquipment_InterfaceInselectTotalpage")));

			TotalPages = Integer.parseInt(TextKeyword);

			System.out.println("Total number of pages in table is: " + TotalPages);

			ab:

			if (TotalPages != 0) {
				for (int k = 1; k <= TotalPages; k++) {

					// Current page
					String CurrentPage = Gettext(
							getwebelement(xml.getlocator("//locators/" + Application + "/providerEquipment_currentpageInterfaceInselect")));
					int Current_page = Integer.parseInt(CurrentPage);

					assertEquals(k, Current_page);

					System.out.println("Currently we are in page number: " + Current_page);

					List<WebElement> results = driver.findElements(By.xpath("(//div[@class='row'][1]//div[div[contains(text(),'"+interfacenumber +"')]])//input"));

					int numofrows = results.size();
					System.out.println("no of results: " + numofrows);
					boolean resultflag;

					if (numofrows == 0) {

						getwebelement(xml.getlocator("//locators/" + Application + "/providerEquipment_InterfaceInselectnextpage"));
					}

					else {

						for (int i = 0; i < numofrows; i++) {

							try {

								resultflag = results.get(i).isDisplayed();
								System.out.println("status of result: " + resultflag);
								if (resultflag) {
									System.out.println(results.get(i).getText());
									results.get(i).click();
									Thread.sleep(8000);
									Clickon(getwebelement(xml.getlocator(
											"//locators/" + Application + "/InterfaceInselect_Actiondropdown")));

									Thread.sleep(5000);
									
									Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/InterfaceToselect_removebuton")));


								}

							} catch (StaleElementReferenceException e) {
								// TODO Auto-generated catch block
								// e.printStackTrace();
								results = driver.findElements(By.xpath("(//div[@class='row'][1]//div[div[contains(text(),'\"+interfacenumber +\"')]])//input"));
								numofrows = results.size();
								// results.get(i).click();
								Log.info("selected row is : " + i);

							}

						}

						break ab;

					}

				}

			} else {

				System.out.println("No values available in table");
				Log.info("No values available inside the InterfaceInService table");
			}

		
	    }
	    
	    
	    public void verifyInterfaceremovedFromServiceforProviderEquipment(String application, String interfacenumber)
				throws InterruptedException, DocumentException {

			try {
			boolean result = driver
					.findElement(By.xpath("(//div[@class='row'][2]//div[div[contains(text(),'"+interfacenumber +"')]])//input"))
					.isDisplayed();
			sa.assertTrue(result, "Verified: Interface got removed from the service");
			sa.assertAll();
			}catch(Exception e) {
				System.out.println("No values found inside the table");
			}

		}
	    
	    
	    public void SelectShowInterfacelinkAndVerifyEditInterfacePageforProviderEquipment(String application, String interfacename) throws InterruptedException, DocumentException, IOException {
			
	    	try {
	    		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ProviderEquipment_showInterfacelink")));
	    		Thread.sleep(3000);
	    		     		
	    		selectRowForshowInterfaceunderProviderEquipment(application, interfacename);
	    		
	    	
	    		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_showInterfaceActiondropdown")));
	    		Thread.sleep(3000);		
	    		
	    		
	    		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureEditlink")));
	    		Thread.sleep(3000);		
	    		
	    		
	    		boolean XNGcircuitID=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureXNGCircuitID")).isDisplayed();
	    		sa.assertTrue(XNGcircuitID, "Circuit id is not displaying");
	    		System.out.println("circuit id is fetched");
	    		
	    		System.out.println("Entering bearer type dropdown");
	    		boolean BearerTypedropdown=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerType")).isDisplayed();
	    		sa.assertTrue(BearerTypedropdown, "Circuit bearer type dropdown is not displaying");
	    		System.out.println("bearer type dropdown is fetchecd");
	    		
	    		boolean Bearerspeed=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerSpeed")).isDisplayed();
	    		sa.assertTrue(Bearerspeed, "Circut bearer speed dropdown is not displaying");
	    		
	    		
	    		boolean bandwidth=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureTotalcircuitbandwidth")).isDisplayed();
	    		sa.assertTrue(bandwidth, "Total circuit bandwidth dropdown is not displaying");
	    		
	    		boolean vlan=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVLANid")).isDisplayed();
	    		sa.assertTrue(vlan, "VLAN ID field is not displaying");
	    		
	    		boolean vlantype=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVlanType")).isDisplayed();
	    		sa.assertTrue(vlantype, "VLANtype dropdown is not displaying");
	    		
	    		
	    		boolean ok=getwebelement(xml.getlocator("//locators/" + application + "/okbutton")).isDisplayed();
	    		sa.assertTrue(ok, "Ok Button is not displaying");
	    		
	    		boolean CANCEL=getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")).isDisplayed();
	    		sa.assertTrue(CANCEL, "Cancel Button is not displaying");
	    		
	    		
	    		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));
	    		Thread.sleep(3000);
	    		
	    		sa.assertAll();
	    		
	    	}catch(AssertionError e) {
	    		e.printStackTrace();
	    	}
	    		
	    	}
	    
	    
	 public void SelectShowInterfacelinkAndVerifyEditInterfacePageforCustomerPremiseEquipment(String application, String interfacename) throws InterruptedException, DocumentException, IOException {
			
	    	try {
	    		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/customerpremiseEQuipment_showinetrfacelink")));
	    		Thread.sleep(3000);
	    		     		
	    		selectRowForshowInterfaceunderCustomerPremiseEquipment(application, interfacename);
	    		
	    		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_showInterfaceActiondropdown")));
	    		Thread.sleep(3000);		
	    		
	    		
	    		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureEditlink")));
	    		Thread.sleep(3000);		
	    		
	    		
	    		boolean XNGcircuitID=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureXNGCircuitID")).isDisplayed();
	    		sa.assertTrue(XNGcircuitID, "Circuit id is not displaying");
	    		System.out.println("circuit id is fetched");
	    		
	    		System.out.println("Entering bearer type dropdown");
	    		boolean BearerTypedropdown=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerType")).isDisplayed();
	    		sa.assertTrue(BearerTypedropdown, "Circuit bearer type dropdown is not displaying");
	    		System.out.println("bearer type dropdown is fetchecd");
	    		
	    		boolean Bearerspeed=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureBearerSpeed")).isDisplayed();
	    		sa.assertTrue(Bearerspeed, "Circut bearer speed dropdown is not displaying");
	    		
	    		
	    		boolean bandwidth=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureTotalcircuitbandwidth")).isDisplayed();
	    		sa.assertTrue(bandwidth, "Total circuit bandwidth dropdown is not displaying");
	    		
	    		boolean vlan=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVLANid")).isDisplayed();
	    		sa.assertTrue(vlan, "VLAN ID field is not displaying");
	    		
	    		boolean vlantype=getwebelement(xml.getlocator("//locators/" + application + "/Equipment_configureVlanType")).isDisplayed();
	    		sa.assertTrue(vlantype, "VLANtype dropdown is not displaying");
	    		
	    		
	    		boolean ok=getwebelement(xml.getlocator("//locators/" + application + "/okbutton")).isDisplayed();
	    		sa.assertTrue(ok, "Ok Button is not displaying");
	    		
	    		boolean CANCEL=getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")).isDisplayed();
	    		sa.assertTrue(CANCEL, "Cancel Button is not displaying");
	    		
	    		
	    		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));
	    		Thread.sleep(3000);
	    		
	    		sa.assertAll();
	    		
	    	}catch(AssertionError e) {
	    		e.printStackTrace();
	    	}
	    		
	    	}

	    
	    
	public void selectconfigurelinkAndverifyForProviderEquipment(String application, String interfacename) throws InterruptedException, DocumentException, IOException {
			
			try {
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Providerequipment_configurelink")));
			Thread.sleep(3000);
			
			
			boolean GenerateConfigForStaticRoutes=getwebelement(xml.getlocator("//locators/" + application + "/ProviderEquipment_Generateconfigforstaticlink")).isDisplayed();
			sa.assertTrue(GenerateConfigForStaticRoutes, "generate configuration for static routes link is not displayed");
			
			boolean SaveConfigurationlink=getwebelement(xml.getlocator("//locators/" + application + "/providerEquipment_saveconfigurationlink")).isDisplayed();
			sa.assertTrue(SaveConfigurationlink, "Save configuration link is not displayed");
			
			boolean ExecuteconfigOndevice=getwebelement(xml.getlocator("//locators/" + application + "/providerEquipment_ExecuteconfigurationOndevicelink")).isDisplayed();
			sa.assertTrue(ExecuteconfigOndevice, "Execute configuration on device link is not displayed");
			
			sa.assertAll();
			
			}catch(AssertionError e) {
				e.printStackTrace();
			}
			
		}


		public void deleteDeviceFromServiceForProviderequipment(String application, String deleteDevice)
				throws InterruptedException, DocumentException {

			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Providerequipment_deletefromservice")));
			Thread.sleep(3000);

			boolean deletemessage = getwebelement(xml.getlocator("//locators/" + application + "/deleteMessage_equipment"))
					.isDisplayed();
			while (deletemessage) {
				Log.info(
						"Are you sure want to delete ? - message is getting displayed on clicking DeletefromService link");
				Log.info("Delete popup message is getting displayed");
				break;
			}

			if (deleteDevice.equalsIgnoreCase("yes")) {

				Clickon(getwebelement(
						xml.getlocator("//locators/" + application + "/deletebutton_deletefromsrviceforequipment")));
				Thread.sleep(3000);

				Log.info("Device got deleted from service as expected");

			} else {

				Clickon(getwebelement(
						xml.getlocator("//locators/" + application + "/xbuttonfordeletefromservicepopup_Equipment")));
				Thread.sleep(3000);

				Log.info("Device is not deleted from service as expected");

			}

		}
		
		
		public void verifyAddnewlinkunderPE2CPEtable(String application) throws InterruptedException, DocumentException, IOException {
		
			
			String HeaderNameExpected="Add New Link";
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Actionbutton_PE2CPE")));
			Thread.sleep(3000);
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addnewlink_Pe2CPE")));
			Thread.sleep(3000);
		
			String headername=Gettext(getwebelement(xml.getlocator("//locators/" + application + "/Headername_PE2CPElink")));
			sa.assertEquals(headername, HeaderNameExpected, "Header name is not displaying as expected");
			
			boolean CircuitId=getwebelement(xml.getlocator("//locators/" + application + "/AddnewlinkPe2CPE_LinkorCircuitId")).isDisplayed();
			sa.assertTrue(CircuitId, "circuit id is not displaying");
			
			
			boolean sourceDevice=getwebelement(xml.getlocator("//locators/" + application + "/AddnewlinkPe2CPE_SourceDevice")).isDisplayed();
			sa.assertTrue(sourceDevice, "Source Device dropdown is not displaying");
			
			
			boolean Sourceinterface=getwebelement(xml.getlocator("//locators/" + application + "/AddnewlinkPe2CPE_SourceInterface")).isDisplayed();
			sa.assertTrue(Sourceinterface, "Source Interface dropdown is not displaying");
			
			boolean targetdevice=getwebelement(xml.getlocator("//locators/" + application + "/AddnewlinkPe2CPE_TargetDevice")).isDisplayed();
			sa.assertTrue(targetdevice, "Target device dropdown is not displaying");
			
			boolean targetInterface=getwebelement(xml.getlocator("//locators/" + application + "/AddnewlinkPe2CPE_TargetInterface")).isDisplayed();
			sa.assertTrue(targetInterface, "Target Interface dropdown is not displaying");
			
			boolean next=getwebelement(xml.getlocator("//locators/" + application + "/AddnewlinkPe2CPE_Nextbutton")).isDisplayed();
			sa.assertTrue(next, "Next button is not displaying");
			
			boolean cancel=getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")).isDisplayed();
			sa.assertTrue(cancel, "CAncel button is not displaying");
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cancelButton")));
			Thread.sleep(3000);
		
			
			
		}

		public void enterdataforAddNewlinkunderPEtoCPEtable(String application, String CircuitId, String sourcedevice, String sourceinterfacce, String targetDevice,String targetInterface, String interfacename) throws InterruptedException, DocumentException, IOException {
			
		
			
			selecttherowforPEtoCPElinktable(application, interfacename);
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Addnewlink_Pe2CPE")));

			
	        SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/AddnewlinkPe2CPE_LinkorCircuitId")), CircuitId);
	        
	        Select(getwebelement(xml.getlocator("//locators/" + application + "/AddnewlinkPe2CPE_SourceDevice")), sourcedevice);
	        
	        Select(getwebelement(xml.getlocator("//locators/" + application + "/AddnewlinkPe2CPE_SourceInterface")), sourceinterfacce);
	        
	        Select(getwebelement(xml.getlocator("//locators/" + application + "/AddnewlinkPe2CPE_TargetDevice")), targetDevice);
	        
	        Select(getwebelement(xml.getlocator("//locators/" + application + "/AddnewlinkPe2CPE_TargetInterface")), targetInterface);
	        
	        Clickon(getwebelement(xml.getlocator("//locators/" + application + "/AddnewlinkPe2CPE_Nextbutton")));
			Thread.sleep(3000);
		

			
		}
		
		
		
		public void enterdataforeditNewlinkunderPEtoCPEtable(String application) {
			
		}

		
		
		 public void selecttherowforPEtoCPElinktable(String Application, String interfacename) throws IOException, InterruptedException, DocumentException {
			 

				int TotalPages;

				String TextKeyword = Gettext(
						getwebelement(xml.getlocator("//locators/" + Application + "/Pe2CPElinktable_totalpage")));

				TotalPages = Integer.parseInt(TextKeyword);

				System.out.println("Total number of pages in table is: " + TotalPages);

				ab:

				if (TotalPages != 0) {
					for (int k = 1; k <= TotalPages; k++) {

						// Current page
						String CurrentPage = Gettext(
								getwebelement(xml.getlocator("//locators/" + Application + "/Pe2CPElinktable_currentpage")));
						int Current_page = Integer.parseInt(CurrentPage);

						assertEquals(k, Current_page);

						System.out.println("Currently we are in page number: " + Current_page);

						List<WebElement> results = driver.findElements(By.xpath("(//div[@class='ag-div-margin row']//div[div[contains(text(),'"+interfacename +"')]])//input"));

						int numofrows = results.size();
						System.out.println("no of results: " + numofrows);
						boolean resultflag;

						if (numofrows == 0) {

							getwebelement(xml.getlocator("//locators/" + Application + "/Pe2CPElinktable_nextpage"));
						}

						else {

							for (int i = 0; i < numofrows; i++) {

								try {

									resultflag = results.get(i).isDisplayed();
									System.out.println("status of result: " + resultflag);
									if (resultflag) {
										System.out.println(results.get(i).getText());
										results.get(i).click();
										Thread.sleep(8000);
										Clickon(getwebelement(xml.getlocator(
												"//locators/" + Application + "/Actionbutton_PE2CPE")));

										Thread.sleep(5000);
										
										

									}

								} catch (StaleElementReferenceException e) {
									// TODO Auto-generated catch block
									// e.printStackTrace();
									results = driver.findElements(By.xpath("(//div[@class='ag-div-margin row']//div[div[contains(text(),'"+interfacename +"')]])//input"));
									numofrows = results.size();
									// results.get(i).click();
									Log.info("selected row is : " + i);

								}

							}

							break ab;

						}

					}

				} else {

					System.out.println("No values available in table");
					Log.info("No values available inside the PEtoCPElink table");
				}
			 
		 }
		 
		 
		 
		 public void selectInterfacelinkforCustomerpremiseequipment(String application) throws InterruptedException, DocumentException {
			 
					Thread.sleep(5000);

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/cusomerpremiseequipment_SelectInertafeceslink")));
					System.out.println("SelectInterface link for Customer premise Equipment is selected");
					Log.info("Select an inertface to add with the service under customer premise equipment");

				}
		 
		 
		 public void AddInterfacetoserviceforcustomerpremiseEquipment(String Application, String interfacenumber) throws IOException, InterruptedException, DocumentException {
			 
	 	    	
		    	int TotalPages;

				String TextKeyword = Gettext(
						getwebelement(xml.getlocator("//locators/" + Application + "/providerEquipment_InterfaceToselectTotalpage")));

				TotalPages = Integer.parseInt(TextKeyword);

				System.out.println("Total number of pages in Interface to select table is: " + TotalPages);

				ab:

				if (TotalPages != 0) {
					for (int k = 1; k <= TotalPages; k++) {

						// Current page
						String CurrentPage = Gettext(
								getwebelement(xml.getlocator("//locators/" + Application + "/providerEquipment_currentpageInterfaceToselect")));
						int Current_page = Integer.parseInt(CurrentPage);

						assertEquals(k, Current_page);

						System.out.println("Currently we are in page number: " + Current_page);

						List<WebElement> results = driver.findElements(By.xpath("(//div[@class='row'][2]//div[div[contains(text(),'"+interfacenumber +"')]])//input"));
						
						int numofrows = results.size();
						System.out.println("no of results: " + numofrows);
						boolean resultflag;

						if (numofrows == 0) {

							Clickon(getwebelement(xml.getlocator(
									"//locators/" + Application + "/providerEquipment_InterfaceToselectnextpage")));


						}
						
						else {

							for (int i = 0; i < numofrows; i++) {

								try {

									resultflag = results.get(i).isDisplayed();
									System.out.println("status of result: " + resultflag);
									if (resultflag) {
										System.out.println(results.get(i).getText());
										results.get(i).click();
										Thread.sleep(8000);
										Clickon(getwebelement(xml.getlocator(
												"//locators/" + Application + "/providerEquipment_InterfaceToselectActiondropdown")));

										Thread.sleep(5000);
										
										Clickon(getwebelement(xml.getlocator("//locators/" + Application + "/providerEquipment_InterfaceToselectAddbutton")));


									}

								} catch (StaleElementReferenceException e) {
									// TODO Auto-generated catch block
									// e.printStackTrace();
									results = driver.findElements(By.xpath("(//div[@class='row'][2]//div[div[contains(text(),'"+interfacenumber +"')]])//input"));
									numofrows = results.size();
									// results.get(i).click();
									Log.info("selected row is : " + i);

								}

							}

							break ab;

						}

					}

				} else {

					System.out.println("No values found inside the table");
					Log.info("No values available inside the Interfacetoselect table");
				}

		    
		 }

		 
		 public void pageRefresh() throws InterruptedException {
			 
			 Pagerefresh();
		 }
		 
		 
		 
		 /**
		  * 
		  * 04-Dec
		  * 
		  */
		 
		 
		 
		 public void EditDirectFibre(String application, String ServiceIdentificationNumber, String SelectSubService,
					String Interfacespeed, String EndpointCPE, String Email, String PhoneContact, String remark,
					String PerformanceMonitoring, String ProactiveMonitoring, String deliveryChannel, String ManagementOrder,
					String vpnTopology, String intermediateTechnology, String CircuitReference, String CircuitType, String notificationManagement)
					throws InterruptedException, IOException, DocumentException {

			
		//Service Identification		
			if(!ServiceIdentificationNumber.equalsIgnoreCase("null")) {
				
				getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")).clear();
				Thread.sleep(2000);
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
						ServiceIdentificationNumber);
				DriverTestcase.logger.log(LogStatus.PASS, "Service Identification has been edited as expected");
				
			}else {
				DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Service Identification field");
			}
			
			
		//Endpoint CPE	
			if(!EndpointCPE.equalsIgnoreCase("null")) {
				
				boolean endpoint=getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")).isSelected();
				Thread.sleep(2000);
				
				if (EndpointCPE.equalsIgnoreCase("yes")) {

					if(endpoint) {
						
						DriverTestcase.logger.log(LogStatus.PASS, "Endpoint CPE is already Selected while creating");
						
					}else {
						
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
						Log.info("End point CPE check box is selected");
						DriverTestcase.logger.log(LogStatus.PASS,"Endpoint CE is selected as Expected");
					}
					
					
				}

				else if (EndpointCPE.equalsIgnoreCase("no")) {
					
					if(endpoint) {
						
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
						Log.info("End point CPE check box is unselected");
						DriverTestcase.logger.log(LogStatus.PASS,"Endpoint CE is unselected as Expected");
						
					}else {
						DriverTestcase.logger.log(LogStatus.PASS, "Endpoint CPE was not selected during service creation and it remains unselected as expected");
					}
					
				}
			}else {
				DriverTestcase.logger.log(LogStatus.PASS,"No changes made for EndPoint CPE chekbox as expected");
			}
			
		//Email	
			if(!Email.equalsIgnoreCase("null")) {
				
				getwebelement(xml.getlocator("//locators/" + application + "/Email")).clear();
				Thread.sleep(2000);
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);

			}else {
				DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Email field");
			}
			
		
		//Phone contact	
			if(!PhoneContact.equalsIgnoreCase("null")) {
				
				getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")).clear();
				Thread.sleep(2000);
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);
			}else {
				DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Phone contact field");
			}
			
			
		//Reamrk	
			if(!remark.equalsIgnoreCase("null")) {
				
				getwebelement(xml.getlocator("//locators/" + application + "/Remark")).clear();
				Thread.sleep(2000);
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);
				
		}else {
			DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Remark field");
		}
			
			
		//Performance Monitoring	
			if(!PerformanceMonitoring.equalsIgnoreCase("null")) {
				
				boolean perfmmonitr=getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")).isSelected();
				Thread.sleep(2000);
				
				if (PerformanceMonitoring.equalsIgnoreCase("yes")) {

					if(perfmmonitr) {
						
						DriverTestcase.logger.log(LogStatus.PASS, "Performance Monitor checkbox is already Selected while creating");
						
					}else {
						
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")));
						Log.info("Performance monitor check box is selected");
						DriverTestcase.logger.log(LogStatus.PASS,"Performance monitor is selected as Expected");
					}
					
					
				}

				else if (PerformanceMonitoring.equalsIgnoreCase("no")) {
					
					if(perfmmonitr) {
						
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")));
						Log.info("Performance Monitor check box is unselected");
						DriverTestcase.logger.log(LogStatus.PASS,"Performance Monitor is unselected as Expected");
						
					}else {
						DriverTestcase.logger.log(LogStatus.PASS, "Performance Monitor was not selected during service creation and it remains unselected as expected");
					}
					
				}
			}else {
				DriverTestcase.logger.log(LogStatus.PASS,"No changes made for Performance Monitor chekbox as expected");
			}



		//Proactive monitoring
			if(!ProactiveMonitoring.equalsIgnoreCase("null")) {
				
				boolean proactivemonitor=getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")).isSelected();
				Thread.sleep(2000);
				
				if (ProactiveMonitoring.equalsIgnoreCase("yes")) {

					if(proactivemonitor) {
						
						DriverTestcase.logger.log(LogStatus.PASS, "Proactive monitoring is already Selected while creating");
						

						if(notificationManagement.equalsIgnoreCase("null")) {
							
							DriverTestcase.logger.log(LogStatus.PASS,"No changes made to notification management");
							
						}else {
							
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notigymanagement_xbutton")));
							Thread.sleep(2000);
							
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
							Clickon(getwebelement("//span[contains(text(),'" + notificationManagement + "')]"));
							DriverTestcase.logger.log(LogStatus.PASS,"Notification management has been edited");
						}
						
					}else {
						
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
						Log.info("proactive monitoring check box is selected");
						DriverTestcase.logger.log(LogStatus.PASS,"proactive monitoring is selected as Expected");
						
						
						if(notificationManagement.equalsIgnoreCase("null")) {
							
							DriverTestcase.logger.log(LogStatus.PASS,"No changes made to notification management");
							
						}else {
							
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notigymanagement_xbutton")));
							Thread.sleep(2000);
							
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
							Clickon(getwebelement("//span[contains(text(),'" + notificationManagement + "')]"));
							DriverTestcase.logger.log(LogStatus.PASS,"Notification management has been edited");
						}
					}
					
					
				}

				else if (ProactiveMonitoring.equalsIgnoreCase("no")) {
					
					if(proactivemonitor) {
						
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
						Log.info("Proactive monitoring check box is unselected");
						DriverTestcase.logger.log(LogStatus.PASS,"proactive monitoring is unselected as Expected");
						
					}else {
						DriverTestcase.logger.log(LogStatus.PASS, "proactive monitoring was not selected during service creation and it remains unselected as expected");
					}
					
				}
			}else {
				DriverTestcase.logger.log(LogStatus.PASS,"No changes made for proactive monitoring chekbox as expected");
			}
			
			
			
		
		//Delivery channel
			if (!deliveryChannel.equalsIgnoreCase("null")) {

				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/deliverychannel_xbutton")));
				Thread.sleep(2000);

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/deliverychannel_withclasskey")));
				Clickon(getwebelement("//span[contains(text(),'" + deliveryChannel + "')]"));
				
				DriverTestcase.logger.log(LogStatus.PASS, "Delivery channel dropdown value is edited as expected");

			}else {
				
				DriverTestcase.logger.log(LogStatus.PASS, "No changes made to delivery channel as expected");
			}

		System.out.println("delivery channel dropdown is done");
		
		//management order	
			if (!ManagementOrder.equalsIgnoreCase("null")) {

				getwebelement(xml.getlocator("//locators/" + application + "/managementOrder")).clear();
				Thread.sleep(2000);

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/managementOrder")), ManagementOrder);
				
				DriverTestcase.logger.log(LogStatus.PASS, "management order field has been edited as expected");
				
			}else {
				
				DriverTestcase.logger.log(LogStatus.PASS, "No changes has been made to Management order field as expected ");
			}

			
		//VPN topology	
			if (!vpnTopology.equalsIgnoreCase("null")) {

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/vpntopoloty_xbutton")));
				Thread.sleep(2000);

				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
				Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
				
				if(vpnTopology.equals("Point-to-Point")) {
					
					if(intermediateTechnology.equalsIgnoreCase("null")) {
						
						DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Intermediate Technology field as expected");
						
					}else {
						
						getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")).clear();
						Thread.sleep(3000);
						
						SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")),
								intermediateTechnology);
						
						DriverTestcase.logger.log(LogStatus.PASS,"Intermediate Technology has been edited");
						
					}
				
					if(CircuitReference.equalsIgnoreCase("null")) {
						
						DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Circuit reference field as expected");
						
					}else {
						
						getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).clear();
						Thread.sleep(3000);

						SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
						
						DriverTestcase.logger.log(LogStatus.PASS,"Circuit Reference has been edited");
					}
					
					

					if(CircuitType.equalsIgnoreCase("null")) {
						
						DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Circuit Type field as expected");
						
					}else {
						
						Clickon(getwebelement("//div[span[contains(text(),'" + CircuitType + "')]]//input"));
						
						DriverTestcase.logger.log(LogStatus.PASS,"Circuit Type has been edited");
						
					}
					

					
					
				}
				
				else if(vpnTopology.equals("Hub&Spoke") || vpnTopology.equals("E-PN (Any-to-Any)")) {

					
					if(CircuitReference.equalsIgnoreCase("null")) {
						
						DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Circuit reference field as expected");
						
					}else {
						
						getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).clear();
						Thread.sleep(3000);

						SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
						
						DriverTestcase.logger.log(LogStatus.PASS,"Circuit Reference has been edited");
					}
					

					
				}
				
				else {
					
					System.out.println(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
					Log.info(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
					DriverTestcase.logger.log(LogStatus.PASS,vpnTopology+ " is not available inside the VPNtopoloy dropdown");
					
				}


			}else {
				
				DriverTestcase.logger.log(LogStatus.PASS, "No changes made to vpn topology dropdown");
			}

		
			

			
		DriverTestcase.logger.log(LogStatus.PASS,"Values has been Edited for Direct Fiber subtype under lanlink Service");
			
		
		
		
		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

		
		}
		 
		 
		 
		 public void EditLanlinkMetro(String application, String ServiceIdentificationNumber, String SelectSubService,
					String Interfacespeed, String EndpointCPE, String Email, String PhoneContact, String remark,
					String PerformanceMonitoring, String ProactiveMonitoring, String deliveryChannel,
					String vpnTopology, String intermediateTechnology, String CircuitReference, String CircuitType, String notificationManagement)
					throws InterruptedException, IOException, DocumentException {
			 


			//Service Identification		
				if(!ServiceIdentificationNumber.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")).clear();
					Thread.sleep(2000);
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
							ServiceIdentificationNumber);
					DriverTestcase.logger.log(LogStatus.PASS, "Service Identification has been edited as expected");
					
				}else {
					DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Service Identification field");
				}
				
				
			//Endpoint CPE	
				if(!EndpointCPE.equalsIgnoreCase("null")) {
					
					boolean endpoint=getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")).isSelected();
					Thread.sleep(2000);
					
					if (EndpointCPE.equalsIgnoreCase("yes")) {

						if(endpoint) {
							
							DriverTestcase.logger.log(LogStatus.PASS, "Endpoint CPE is already Selected while creating");
							
						}else {
							
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
							Log.info("End point CPE check box is selected");
							DriverTestcase.logger.log(LogStatus.PASS,"Endpoint CE is selected as Expected");
						}
						
						
					}

					else if (EndpointCPE.equalsIgnoreCase("no")) {
						
						if(endpoint) {
							
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
							Log.info("End point CPE check box is unselected");
							DriverTestcase.logger.log(LogStatus.PASS,"Endpoint CE is unselected as Expected");
							
						}else {
							DriverTestcase.logger.log(LogStatus.PASS, "Endpoint CPE was not selected during service creation and it remains unselected as expected");
						}
						
					}
				}else {
					DriverTestcase.logger.log(LogStatus.PASS,"No changes made for EndPoint CPE chekbox as expected");
				}
				
			//Email	
				if(!Email.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/Email")).clear();
					Thread.sleep(2000);
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);

				}else {
					DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Email field");
				}
				
			
			//Phone contact	
				if(!PhoneContact.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")).clear();
					Thread.sleep(2000);
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);
				}else {
					DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Phone contact field");
				}
				
				
			//Reamrk	
				if(!remark.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/Remark")).clear();
					Thread.sleep(2000);
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);
					
			}else {
				DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Remark field");
			}
				
				
			//Performance Monitoring	
				if(!PerformanceMonitoring.equalsIgnoreCase("null")) {
					
					boolean perfmmonitr=getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")).isSelected();
					Thread.sleep(2000);
					
					if (PerformanceMonitoring.equalsIgnoreCase("yes")) {

						if(perfmmonitr) {
							
							DriverTestcase.logger.log(LogStatus.PASS, "Performance Monitor checkbox is already Selected while creating");
							
						}else {
							
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")));
							Log.info("Performance monitor check box is selected");
							DriverTestcase.logger.log(LogStatus.PASS,"Performance monitor is selected as Expected");
						}
						
						
					}

					else if (PerformanceMonitoring.equalsIgnoreCase("no")) {
						
						if(perfmmonitr) {
							
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")));
							Log.info("Performance Monitor check box is unselected");
							DriverTestcase.logger.log(LogStatus.PASS,"Performance Monitor is unselected as Expected");
							
						}else {
							DriverTestcase.logger.log(LogStatus.PASS, "Performance Monitor was not selected during service creation and it remains unselected as expected");
						}
						
					}
				}else {
					DriverTestcase.logger.log(LogStatus.PASS,"No changes made for Performance Monitor chekbox as expected");
				}



			//Proactive monitoring
				if(!ProactiveMonitoring.equalsIgnoreCase("null")) {
					
					boolean proactivemonitor=getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")).isSelected();
					Thread.sleep(2000);
					
					if (ProactiveMonitoring.equalsIgnoreCase("yes")) {

						if(proactivemonitor) {
							
							DriverTestcase.logger.log(LogStatus.PASS, "Proactive monitoring is already Selected while creating");
							

							if(notificationManagement.equalsIgnoreCase("null")) {
								
								DriverTestcase.logger.log(LogStatus.PASS,"No changes made to notification management");
								
							}else {
								
								Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notigymanagement_xbutton")));
								Thread.sleep(2000);
								
								Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
								Clickon(getwebelement("//span[contains(text(),'" + notificationManagement + "')]"));
								DriverTestcase.logger.log(LogStatus.PASS,"Notification management has been edited");
							}
							
						}else {
							
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
							Log.info("proactive monitoring check box is selected");
							DriverTestcase.logger.log(LogStatus.PASS,"proactive monitoring is selected as Expected");
							
							
							if(notificationManagement.equalsIgnoreCase("null")) {
								
								DriverTestcase.logger.log(LogStatus.PASS,"No changes made to notification management");
								
							}else {
								
								Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notigymanagement_xbutton")));
								Thread.sleep(2000);
								
								Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
								Clickon(getwebelement("//span[contains(text(),'" + notificationManagement + "')]"));
								DriverTestcase.logger.log(LogStatus.PASS,"Notification management has been edited");
							}
						}
						
						
					}

					else if (ProactiveMonitoring.equalsIgnoreCase("no")) {
						
						if(proactivemonitor) {
							
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
							Log.info("Proactive monitoring check box is unselected");
							DriverTestcase.logger.log(LogStatus.PASS,"proactive monitoring is unselected as Expected");
							
						}else {
							DriverTestcase.logger.log(LogStatus.PASS, "proactive monitoring was not selected during service creation and it remains unselected as expected");
						}
						
					}
				}else {
					DriverTestcase.logger.log(LogStatus.PASS,"No changes made for proactive monitoring chekbox as expected");
				}
				
				
				
			
			//Delivery channel
				if (!deliveryChannel.equalsIgnoreCase("null")) {

					
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/deliverychannel_xbutton")));
					Thread.sleep(2000);

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/deliverychannel_withclasskey")));
					Clickon(getwebelement("//span[contains(text(),'" + deliveryChannel + "')]"));
					
					DriverTestcase.logger.log(LogStatus.PASS, "Delivery channel dropdown value is edited as expected");

				}else {
					
					DriverTestcase.logger.log(LogStatus.PASS, "No changes made to delivery channel as expected");
				}


				
				
				//VPN topology	
				if (!vpnTopology.equalsIgnoreCase("null")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/vpntopoloty_xbutton")));
					Thread.sleep(2000);

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
					Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
					
					if(vpnTopology.equals("Point-to-Point")) {
						
						if(intermediateTechnology.equalsIgnoreCase("null")) {
							
							DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Intermediate Technology field as expected");
							
						}else {
							
							getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")).clear();
							Thread.sleep(3000);
							
							SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")),
									intermediateTechnology);
							
							DriverTestcase.logger.log(LogStatus.PASS,"Intermediate Technology has been edited");
							
						}
					
						if(CircuitReference.equalsIgnoreCase("null")) {
							
							DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Circuit reference field as expected");
							
						}else {
							
							getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).clear();
							Thread.sleep(3000);

							SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
							
							DriverTestcase.logger.log(LogStatus.PASS,"Circuit Reference has been edited");
						}
						
						

						if(CircuitType.equalsIgnoreCase("null")) {
							
							DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Circuit Type field as expected");
							
						}else {
							
							Clickon(getwebelement("//div[span[contains(text(),'" + CircuitType + "')]]//input"));
							
							DriverTestcase.logger.log(LogStatus.PASS,"Circuit Type has been edited");
							
						}
						

						
						
					}
					
					else if(vpnTopology.equals("Hub&Spoke") || vpnTopology.equals("E-PN (Any-to-Any)")) {

						
						if(CircuitReference.equalsIgnoreCase("null")) {
							
							DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Circuit reference field as expected");
							
						}else {
							
							getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).clear();
							Thread.sleep(3000);

							SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
							
							DriverTestcase.logger.log(LogStatus.PASS,"Circuit Reference has been edited");
						}
						

						
					}
					
					else {
						
						System.out.println(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
						Log.info(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
						DriverTestcase.logger.log(LogStatus.PASS,vpnTopology+ " is not available inside the VPNtopoloy dropdown");
						
					}


				}else {
					
					DriverTestcase.logger.log(LogStatus.PASS, "No changes made to vpn topology dropdown");
				}

			
			
				

				
				DriverTestcase.logger.log(LogStatus.PASS,"Values has been Edited under Lanlink Metro subtype under Lanlink service");
				
			
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

			
			
		 }
		 
		 
		 public void EditLanlink_outbandmanagement(String application, String ServiceIdentificationNumber,
					String SelectSubService, String Interfacespeed, String EndpointCPE, String Email, String PhoneContact,
					String remark, String Performancereporting, String ProactiveMonitoring, String ENNIcheckBox,
					String deliveryChannel, String Manageconnectiondropdown, String notificationManagement)
					throws InterruptedException, IOException, DocumentException {
				
				
			//Service Identification		
				if(!ServiceIdentificationNumber.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")).clear();
					Thread.sleep(2000);
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
							ServiceIdentificationNumber);
					DriverTestcase.logger.log(LogStatus.PASS, "Service Identification has been edited as expected");
					
				}else {
					DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Service Identification field");
				}
				
				
			//Endpoint CPE	
				if(!EndpointCPE.equalsIgnoreCase("null")) {
					
					boolean endpoint=getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")).isSelected();
					Thread.sleep(2000);
					
					if (EndpointCPE.equalsIgnoreCase("yes")) {

						if(endpoint) {
							
							DriverTestcase.logger.log(LogStatus.PASS, "Endpoint CPE is already Selected while creating");
							
						}else {
							
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
							Log.info("End point CPE check box is selected");
							DriverTestcase.logger.log(LogStatus.PASS,"Endpoint CE is selected as Expected");
						}
						
						
					}

					else if (EndpointCPE.equalsIgnoreCase("no")) {
						
						if(endpoint) {
							
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
							Log.info("End point CPE check box is unselected");
							DriverTestcase.logger.log(LogStatus.PASS,"Endpoint CE is unselected as Expected");
							
						}else {
							DriverTestcase.logger.log(LogStatus.PASS, "Endpoint CPE was not selected during service creation and it remains unselected as expected");
						}
						
					}
				}else {
					DriverTestcase.logger.log(LogStatus.PASS,"No changes made for EndPoint CPE chekbox as expected");
				}
				
			//Email	
				if(!Email.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/Email")).clear();
					Thread.sleep(2000);
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);

				}else {
					DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Email field");
				}
				
			
			//Phone contact	
				if(!PhoneContact.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")).clear();
					Thread.sleep(2000);
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);
				}else {
					DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Phone contact field");
				}
				
				
			//Reamrk	
				if(!remark.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/Remark")).clear();
					Thread.sleep(2000);
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);
					
			}else {
				DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Remark field");
			}	
			 
				
				
				if(!Performancereporting.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/performanceReportingcheckbox")).clear();
					Thread.sleep(2000);
					

					if (Performancereporting.equals("yes")) {

						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performanceReportingcheckbox")));
						Log.info("performance reporting check box is selected");
					}

					else {

						System.out.println("Performance reporting is not selected");
					}

					
				}
				
				

				if(!ProactiveMonitoring.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")).clear();
					Thread.sleep(2000);
					

					if (ProactiveMonitoring.equals("yes")) {

						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
						Log.info("Pro active monitoring check box is selected");
						
						Log.info("Notificationan Management dropdown displays when pro active monitoring is selected");
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
						Clickon(getwebelement("//div[contains(text(),'" + notificationManagement + "')]"));

						
					}

					else {

						Log.info("Pro active monitoring is not selected");
					}
					
				}
				
				if(!ENNIcheckBox.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/ENNIcheckbox")).clear();
					Thread.sleep(2000);
					

					if (ENNIcheckBox.equals("yes")) {

						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ENNIcheckbox")));
						Log.info("ENNI check box is selected");
					} else {

						Log.info("ENNI check box is not selected");
					}
					
				}
				

				if (!deliveryChannel.equalsIgnoreCase("null")) {

					getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")).clear();
					Thread.sleep(2000);

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
					Clickon(getwebelement("//span[contains(text(),'" + deliveryChannel + "')]"));


				}

				if (!Manageconnectiondropdown.equalsIgnoreCase("null")) {

					getwebelement(xml.getlocator("//locators/" + application + "/managementconnection")).clear();
					Thread.sleep(2000);

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/managementconnection")));
					Clickon(getwebelement("//div[contains(text(),'" + Manageconnectiondropdown + "')]"));

				}

				

				DriverTestcase.logger.log(LogStatus.PASS,"Values has been Edited under lanlink outbandmanagement service subtype");
				
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

			}
		 
		 
		 
		 public void EditLanlink_OLO(String application, String ServiceIdentificationNumber, String SelectSubService,
					String Interfacespeed, String EndpointCPE, String Email, String PhoneContact, String remark,
					String PerformanceMonitoring, String ProactiveMonitoring, String ENNIcheckBox, String deliveryChannel,
					String ManagementOrder, String vpnTopology, String intermediateTechnology, String CircuitReference,
					String CircuitType, String notificationManagement) throws InterruptedException, IOException, DocumentException {

			
				
			//Service Identification		
				if(!ServiceIdentificationNumber.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")).clear();
					Thread.sleep(2000);
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
							ServiceIdentificationNumber);
					DriverTestcase.logger.log(LogStatus.PASS, "Service Identification has been edited as expected");
					
				}else {
					DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Service Identification field");
				}
				
				
			//Endpoint CPE	
				if(!EndpointCPE.equalsIgnoreCase("null")) {
					
					boolean endpoint=getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")).isSelected();
					Thread.sleep(2000);
					
					if (EndpointCPE.equalsIgnoreCase("yes")) {

						if(endpoint) {
							
							DriverTestcase.logger.log(LogStatus.PASS, "Endpoint CPE is already Selected while creating");
							
						}else {
							
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
							Log.info("End point CPE check box is selected");
							DriverTestcase.logger.log(LogStatus.PASS,"Endpoint CE is selected as Expected");
						}
						
						
					}

					else if (EndpointCPE.equalsIgnoreCase("no")) {
						
						if(endpoint) {
							
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
							Log.info("End point CPE check box is unselected");
							DriverTestcase.logger.log(LogStatus.PASS,"Endpoint CE is unselected as Expected");
							
						}else {
							DriverTestcase.logger.log(LogStatus.PASS, "Endpoint CPE was not selected during service creation and it remains unselected as expected");
						}
						
					}
				}else {
					DriverTestcase.logger.log(LogStatus.PASS,"No changes made for EndPoint CPE chekbox as expected");
				}
				
			//Email	
				if(!Email.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/Email")).clear();
					Thread.sleep(2000);
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);

				}else {
					DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Email field");
				}
				
			
			//Phone contact	
				if(!PhoneContact.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")).clear();
					Thread.sleep(2000);
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);
				}else {
					DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Phone contact field");
				}
				
				
			//Reamrk	
				if(!remark.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/Remark")).clear();
					Thread.sleep(2000);
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);
					
			}else {
				DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Remark field");
			}
				
				
			//Performance Monitoring	
				if(!PerformanceMonitoring.equalsIgnoreCase("null")) {
					
					boolean perfmmonitr=getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")).isSelected();
					Thread.sleep(2000);
					
					if (PerformanceMonitoring.equalsIgnoreCase("yes")) {

						if(perfmmonitr) {
							
							DriverTestcase.logger.log(LogStatus.PASS, "Performance Monitor checkbox is already Selected while creating");
							
						}else {
							
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")));
							Log.info("Performance monitor check box is selected");
							DriverTestcase.logger.log(LogStatus.PASS,"Performance monitor is selected as Expected");
						}
						
						
					}

					else if (PerformanceMonitoring.equalsIgnoreCase("no")) {
						
						if(perfmmonitr) {
							
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")));
							Log.info("Performance Monitor check box is unselected");
							DriverTestcase.logger.log(LogStatus.PASS,"Performance Monitor is unselected as Expected");
							
						}else {
							DriverTestcase.logger.log(LogStatus.PASS, "Performance Monitor was not selected during service creation and it remains unselected as expected");
						}
						
					}
				}else {
					DriverTestcase.logger.log(LogStatus.PASS,"No changes made for Performance Monitor chekbox as expected");
				}



			//Proactive monitoring
				if(!ProactiveMonitoring.equalsIgnoreCase("null")) {
					
					boolean proactivemonitor=getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")).isSelected();
					Thread.sleep(2000);
					
					if (ProactiveMonitoring.equalsIgnoreCase("yes")) {

						if(proactivemonitor) {
							
							DriverTestcase.logger.log(LogStatus.PASS, "Proactive monitoring is already Selected while creating");
							

							if(notificationManagement.equalsIgnoreCase("null")) {
								
								DriverTestcase.logger.log(LogStatus.PASS,"No changes made to notification management");
								
							}else {
								
								Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notigymanagement_xbutton")));
								Thread.sleep(2000);
								
								Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
								Clickon(getwebelement("//span[contains(text(),'" + notificationManagement + "')]"));
								DriverTestcase.logger.log(LogStatus.PASS,"Notification management has been edited");
							}
							
						}else {
							
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
							Log.info("proactive monitoring check box is selected");
							DriverTestcase.logger.log(LogStatus.PASS,"proactive monitoring is selected as Expected");
							
							
							if(notificationManagement.equalsIgnoreCase("null")) {
								
								DriverTestcase.logger.log(LogStatus.PASS,"No changes made to notification management");
								
							}else {
								
								Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notigymanagement_xbutton")));
								Thread.sleep(2000);
								
								Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
								Clickon(getwebelement("//span[contains(text(),'" + notificationManagement + "')]"));
								DriverTestcase.logger.log(LogStatus.PASS,"Notification management has been edited");
							}
						}
						
						
					}

					else if (ProactiveMonitoring.equalsIgnoreCase("no")) {
						
						if(proactivemonitor) {
							
							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
							Log.info("Proactive monitoring check box is unselected");
							DriverTestcase.logger.log(LogStatus.PASS,"proactive monitoring is unselected as Expected");
							
						}else {
							DriverTestcase.logger.log(LogStatus.PASS, "proactive monitoring was not selected during service creation and it remains unselected as expected");
						}
						
					}
				}else {
					DriverTestcase.logger.log(LogStatus.PASS,"No changes made for proactive monitoring chekbox as expected");
				}
				
				
				
			
			//Delivery channel
				if (!deliveryChannel.equalsIgnoreCase("null")) {

					
					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/deliverychannel_xbutton")));
					Thread.sleep(2000);

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/deliverychannel_withclasskey")));
					Clickon(getwebelement("//span[contains(text(),'" + deliveryChannel + "')]"));
					
					DriverTestcase.logger.log(LogStatus.PASS, "Delivery channel dropdown value is edited as expected");

				}else {
					
					DriverTestcase.logger.log(LogStatus.PASS, "No changes made to delivery channel as expected");
				}


				
				




if(!ENNIcheckBox.equalsIgnoreCase("null")) {
	
	boolean eni=getwebelement(xml.getlocator("//locators/" + application + "/ENNIcheckbox")).isSelected();
	Thread.sleep(2000);
	
	if (ENNIcheckBox.equalsIgnoreCase("yes")) {

		if(eni) {
			
			DriverTestcase.logger.log(LogStatus.PASS, "ENNI checkbox is already Selected while creating");
			
		}else {
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ENNIcheckbox")));
			Log.info("ENNI check box is selected");
			DriverTestcase.logger.log(LogStatus.PASS,"ENNI checkbox is selected as Expected");
		}
		
		
	}

	else if (ENNIcheckBox.equalsIgnoreCase("no")) {
		
		if(eni) {
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ENNIcheckbox")));
			Log.info("ENNI check box is unselected");
			DriverTestcase.logger.log(LogStatus.PASS,"ENNI checkbox is unselected as Expected");
			
		}else {
			DriverTestcase.logger.log(LogStatus.PASS, "ENNI checkbox was not selected during service creation and it remains unselected as expected");
		}
		
	}
}else {
	DriverTestcase.logger.log(LogStatus.PASS,"No changes made for ENNI chekbox as expected");
}

				

//management order	
if (!ManagementOrder.equalsIgnoreCase("null")) {

	getwebelement(xml.getlocator("//locators/" + application + "/managementOrder")).clear();
	Thread.sleep(2000);

	SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/managementOrder")), ManagementOrder);
	
	DriverTestcase.logger.log(LogStatus.PASS, "management order field has been edited as expected");
	
}else {
	
	DriverTestcase.logger.log(LogStatus.PASS, "No changes has been made to Management order field as expected ");
}


//VPN topology	
if (!vpnTopology.equalsIgnoreCase("null")) {

	Clickon(getwebelement(xml.getlocator("//locators/" + application + "/vpntopoloty_xbutton")));
	Thread.sleep(2000);

	Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
	Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
	
	if(vpnTopology.equals("Point-to-Point")) {
		
		if(intermediateTechnology.equalsIgnoreCase("null")) {
			
			DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Intermediate Technology field as expected");
			
		}else {
			
			getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")).clear();
			Thread.sleep(3000);
			
			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")),
					intermediateTechnology);
			
			DriverTestcase.logger.log(LogStatus.PASS,"Intermediate Technology has been edited");
			
		}
	
		if(CircuitReference.equalsIgnoreCase("null")) {
			
			DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Circuit reference field as expected");
			
		}else {
			
			getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).clear();
			Thread.sleep(3000);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
			
			DriverTestcase.logger.log(LogStatus.PASS,"Circuit Reference has been edited");
		}
		
		

		if(CircuitType.equalsIgnoreCase("null")) {
			
			DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Circuit Type field as expected");
			
		}else {
			
			Clickon(getwebelement("//div[span[contains(text(),'" + CircuitType + "')]]//input"));
			
			DriverTestcase.logger.log(LogStatus.PASS,"Circuit Type has been edited");
			
		}
		

		
		
	}
	
	else if(vpnTopology.equals("Hub&Spoke") || vpnTopology.equals("E-PN (Any-to-Any)")) {

		
		if(CircuitReference.equalsIgnoreCase("null")) {
			
			DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Circuit reference field as expected");
			
		}else {
			
			getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).clear();
			Thread.sleep(3000);

			SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
			
			DriverTestcase.logger.log(LogStatus.PASS,"Circuit Reference has been edited");
		}
		

		
	}
	
	else {
		
		System.out.println(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
		Log.info(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
		DriverTestcase.logger.log(LogStatus.PASS,vpnTopology+ " is not available inside the VPNtopoloy dropdown");
		
	}


}else {
	
	DriverTestcase.logger.log(LogStatus.PASS, "No changes made to vpn topology dropdown");
}

			
				

			 
			
				DriverTestcase.logger.log(LogStatus.PASS,"Values has been Edited for 'OLO - (GCR/EU)' subtype under LALINK Service");
			
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

			}

		 
		 public void editLanlinkMetrowhenMSPisselected(String application, String ServiceIdentificationNumber, String SelectSubService,
					String Interfacespeed, String EndpointCPE, String Email, String PhoneContact, String remark,
					String PerformanceMonitoring, String ProactiveMonitoring, String deliveryChannel,
					String vpnTopology, String intermediateTechnology, String CircuitReference, String CircuitType, String notificationManagement)
					throws InterruptedException, IOException, DocumentException {
			 
	if(!ServiceIdentificationNumber.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")).clear();
					Thread.sleep(2000);
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
							ServiceIdentificationNumber);
					
				}
				
				
				
				if(!EndpointCPE.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")).clear();
					Thread.sleep(2000);
					
					if (EndpointCPE.equals("yes")) {

						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
						Log.info("End point CPE check box is selected");
					}

					else {

						Log.info("Sing Endpoint CPE is not selected");
					}

				}
				
				
				if(!Email.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/Email")).clear();
					Thread.sleep(2000);
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);

				}
				
				
				if(!PhoneContact.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")).clear();
					Thread.sleep(2000);
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);

					
				}
				
				
				if(!remark.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/Remark")).clear();
					Thread.sleep(2000);
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);

					
				}
				
				
				
		if(!PerformanceMonitoring.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")).clear();
					Thread.sleep(2000);
					
					if (PerformanceMonitoring.equalsIgnoreCase("yes")) {

						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")));
						Log.info("performance monitoring check box is selected");
					}

					else {

						System.out.println("Performance monitoring is not selected");
					}

					
				}



				if (!ProactiveMonitoring.equalsIgnoreCase("null")) {

					getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")).clear();
					Thread.sleep(2000);

					if (ProactiveMonitoring.equalsIgnoreCase("yes")) {

						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
						Log.info("Pro active monitoring check box is selected");

						Log.info("Notificationan Management dropdown displays when pro active monitoring is selected");
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
						Clickon(getwebelement("//div[contains(text(),'" + notificationManagement + "')]"));

					} else {

						Log.info("Pro active monitoring is not selected");
						System.out.println("pro active monitoring is not selected");
					}

				}

			
				if (!deliveryChannel.equalsIgnoreCase("null")) {

					getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")).clear();
					Thread.sleep(2000);

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
					Clickon(getwebelement("//span[contains(text(),'" + deliveryChannel + "')]"));


				}

				
				//VPN topology	
				if (!vpnTopology.equalsIgnoreCase("null")) {

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/vpntopoloty_xbutton")));
					Thread.sleep(2000);

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
					Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
					
					if(vpnTopology.equals("Point-to-Point")) {
						
						if(intermediateTechnology.equalsIgnoreCase("null")) {
							
							DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Intermediate Technology field as expected");
							
						}else {
							
							getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")).clear();
							Thread.sleep(3000);
							
							SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")),
									intermediateTechnology);
							
							DriverTestcase.logger.log(LogStatus.PASS,"Intermediate Technology has been edited");
							
						}
					
						if(CircuitReference.equalsIgnoreCase("null")) {
							
							DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Circuit reference field as expected");
							
						}else {
							
							getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).clear();
							Thread.sleep(3000);

							SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
							
							DriverTestcase.logger.log(LogStatus.PASS,"Circuit Reference has been edited");
						}
						
						

						if(CircuitType.equalsIgnoreCase("null")) {
							
							DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Circuit Type field as expected");
							
						}else {
							
							Clickon(getwebelement("//div[span[contains(text(),'" + CircuitType + "')]]//input"));
							
							DriverTestcase.logger.log(LogStatus.PASS,"Circuit Type has been edited");
							
						}
						

						
						
					}
					
					else if(vpnTopology.equals("E-PN (Any-to-Any)")) {

						
						if(CircuitReference.equalsIgnoreCase("null")) {
							
							DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Circuit reference field as expected");
							
						}else {
							
							getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).clear();
							Thread.sleep(3000);

							SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
							
							DriverTestcase.logger.log(LogStatus.PASS,"Circuit Reference has been edited");
						}
						

						
					}
					
				
				
				else if(vpnTopology.equals("Hub&Spoke")) {

					DriverTestcase.logger.log(LogStatus.PASS,"Circuit ref, circuit type and Intermediate tech fields are not available to enter value, when msp is selected and 'hub&spoke' selected under 'VPntopology' ");
					System.out.println("hub and spoke selecte under vpn topology");
					
				}
					
					else {
						
						System.out.println(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
						Log.info(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
						DriverTestcase.logger.log(LogStatus.PASS,vpnTopology+ " is not available inside the VPNtopoloy dropdown");
						
					}


				}else {
					
					DriverTestcase.logger.log(LogStatus.PASS, "No changes made to vpn topology dropdown");
				}

			
				

				
				DriverTestcase.logger.log(LogStatus.PASS,"Values has been Edited for Lanlink Metro subtype under Lanlink service");
				
			
			
			
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

			
		 }

			
		 public void editLanlink_OLOwhenMSPisselected(String application, String ServiceIdentificationNumber, String SelectSubService,
					String Interfacespeed, String EndpointCPE, String Email, String PhoneContact, String remark,
					String PerformanceMonitoring, String ProactiveMonitoring, String ENNIcheckBox, String deliveryChannel,
					String ManagementOrder, String vpnTopology, String intermediateTechnology, String CircuitReference,
					String CircuitType, String notificationManagement) throws InterruptedException, IOException, DocumentException {

			
				


				
				
				//Service Identification		
					if(!ServiceIdentificationNumber.equalsIgnoreCase("null")) {
						
						getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")).clear();
						Thread.sleep(2000);
						SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
								ServiceIdentificationNumber);
						DriverTestcase.logger.log(LogStatus.PASS, "Service Identification has been edited as expected");
						
					}else {
						DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Service Identification field");
					}
					
					
				//Endpoint CPE	
					if(!EndpointCPE.equalsIgnoreCase("null")) {
						
						boolean endpoint=getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")).isSelected();
						Thread.sleep(2000);
						
						if (EndpointCPE.equalsIgnoreCase("yes")) {

							if(endpoint) {
								
								DriverTestcase.logger.log(LogStatus.PASS, "Endpoint CPE is already Selected while creating");
								
							}else {
								
								Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
								Log.info("End point CPE check box is selected");
								DriverTestcase.logger.log(LogStatus.PASS,"Endpoint CE is selected as Expected");
							}
							
							
						}

						else if (EndpointCPE.equalsIgnoreCase("no")) {
							
							if(endpoint) {
								
								Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
								Log.info("End point CPE check box is unselected");
								DriverTestcase.logger.log(LogStatus.PASS,"Endpoint CE is unselected as Expected");
								
							}else {
								DriverTestcase.logger.log(LogStatus.PASS, "Endpoint CPE was not selected during service creation and it remains unselected as expected");
							}
							
						}
					}else {
						DriverTestcase.logger.log(LogStatus.PASS,"No changes made for EndPoint CPE chekbox as expected");
					}
					
				//Email	
					if(!Email.equalsIgnoreCase("null")) {
						
						getwebelement(xml.getlocator("//locators/" + application + "/Email")).clear();
						Thread.sleep(2000);
						
						SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);

					}else {
						DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Email field");
					}
					
				
				//Phone contact	
					if(!PhoneContact.equalsIgnoreCase("null")) {
						
						getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")).clear();
						Thread.sleep(2000);
						
						SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);
					}else {
						DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Phone contact field");
					}
					
					
				//Reamrk	
					if(!remark.equalsIgnoreCase("null")) {
						
						getwebelement(xml.getlocator("//locators/" + application + "/Remark")).clear();
						Thread.sleep(2000);
						
						SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);
						
				}else {
					DriverTestcase.logger.log(LogStatus.PASS, "No changes made for Remark field");
				}
					
					
				//Performance Monitoring	
					if(!PerformanceMonitoring.equalsIgnoreCase("null")) {
						
						boolean perfmmonitr=getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")).isSelected();
						Thread.sleep(2000);
						
						if (PerformanceMonitoring.equalsIgnoreCase("yes")) {

							if(perfmmonitr) {
								
								DriverTestcase.logger.log(LogStatus.PASS, "Performance Monitor checkbox is already Selected while creating");
								
							}else {
								
								Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")));
								Log.info("Performance monitor check box is selected");
								DriverTestcase.logger.log(LogStatus.PASS,"Performance monitor is selected as Expected");
							}
							
							
						}

						else if (PerformanceMonitoring.equalsIgnoreCase("no")) {
							
							if(perfmmonitr) {
								
								Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")));
								Log.info("Performance Monitor check box is unselected");
								DriverTestcase.logger.log(LogStatus.PASS,"Performance Monitor is unselected as Expected");
								
							}else {
								DriverTestcase.logger.log(LogStatus.PASS, "Performance Monitor was not selected during service creation and it remains unselected as expected");
							}
							
						}
					}else {
						DriverTestcase.logger.log(LogStatus.PASS,"No changes made for Performance Monitor chekbox as expected");
					}



				//Proactive monitoring
					if(!ProactiveMonitoring.equalsIgnoreCase("null")) {
						
						boolean proactivemonitor=getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")).isSelected();
						Thread.sleep(2000);
						
						if (ProactiveMonitoring.equalsIgnoreCase("yes")) {

							if(proactivemonitor) {
								
								DriverTestcase.logger.log(LogStatus.PASS, "Proactive monitoring is already Selected while creating");
								

								if(notificationManagement.equalsIgnoreCase("null")) {
									
									DriverTestcase.logger.log(LogStatus.PASS,"No changes made to notification management");
									
								}else {
									
									Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notigymanagement_xbutton")));
									Thread.sleep(2000);
									
									Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
									Clickon(getwebelement("//span[contains(text(),'" + notificationManagement + "')]"));
									DriverTestcase.logger.log(LogStatus.PASS,"Notification management has been edited");
								}
								
							}else {
								
								Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
								Log.info("proactive monitoring check box is selected");
								DriverTestcase.logger.log(LogStatus.PASS,"proactive monitoring is selected as Expected");
								
								
								if(notificationManagement.equalsIgnoreCase("null")) {
									
									DriverTestcase.logger.log(LogStatus.PASS,"No changes made to notification management");
									
								}else {
									
									Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notigymanagement_xbutton")));
									Thread.sleep(2000);
									
									Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
									Clickon(getwebelement("//span[contains(text(),'" + notificationManagement + "')]"));
									DriverTestcase.logger.log(LogStatus.PASS,"Notification management has been edited");
								}
							}
							
							
						}

						else if (ProactiveMonitoring.equalsIgnoreCase("no")) {
							
							if(proactivemonitor) {
								
								Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
								Log.info("Proactive monitoring check box is unselected");
								DriverTestcase.logger.log(LogStatus.PASS,"proactive monitoring is unselected as Expected");
								
							}else {
								DriverTestcase.logger.log(LogStatus.PASS, "proactive monitoring was not selected during service creation and it remains unselected as expected");
							}
							
						}
					}else {
						DriverTestcase.logger.log(LogStatus.PASS,"No changes made for proactive monitoring chekbox as expected");
					}
					
					
					
				
				//Delivery channel
					if (!deliveryChannel.equalsIgnoreCase("null")) {

						
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/deliverychannel_xbutton")));
						Thread.sleep(2000);

						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/deliverychannel_withclasskey")));
						Clickon(getwebelement("//span[contains(text(),'" + deliveryChannel + "')]"));
						
						DriverTestcase.logger.log(LogStatus.PASS, "Delivery channel dropdown value is edited as expected");

					}else {
						
						DriverTestcase.logger.log(LogStatus.PASS, "No changes made to delivery channel as expected");
					}


					
					





	if(!ENNIcheckBox.equalsIgnoreCase("null")) {
		
		boolean eni=getwebelement(xml.getlocator("//locators/" + application + "/ENNIcheckbox")).isSelected();
		Thread.sleep(2000);
		
		if (ENNIcheckBox.equalsIgnoreCase("yes")) {

			if(eni) {
				
				DriverTestcase.logger.log(LogStatus.PASS, "ENNI checkbox is already Selected while creating");
				
			}else {
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ENNIcheckbox")));
				Log.info("ENNI check box is selected");
				DriverTestcase.logger.log(LogStatus.PASS,"ENNI checkbox is selected as Expected");
			}
			
			
		}

		else if (ENNIcheckBox.equalsIgnoreCase("no")) {
			
			if(eni) {
				
				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/ENNIcheckbox")));
				Log.info("ENNI check box is unselected");
				DriverTestcase.logger.log(LogStatus.PASS,"ENNI checkbox is unselected as Expected");
				
			}else {
				DriverTestcase.logger.log(LogStatus.PASS, "ENNI checkbox was not selected during service creation and it remains unselected as expected");
			}
			
		}
	}else {
		DriverTestcase.logger.log(LogStatus.PASS,"No changes made for ENNI chekbox as expected");
	}

					

	//management order	
	if (!ManagementOrder.equalsIgnoreCase("null")) {

		getwebelement(xml.getlocator("//locators/" + application + "/managementOrder")).clear();
		Thread.sleep(2000);

		SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/managementOrder")), ManagementOrder);
		
		DriverTestcase.logger.log(LogStatus.PASS, "management order field has been edited as expected");
		
	}else {
		
		DriverTestcase.logger.log(LogStatus.PASS, "No changes has been made to Management order field as expected ");
	}


	//VPN topology	
	if (!vpnTopology.equalsIgnoreCase("null")) {

		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/vpntopoloty_xbutton")));
		Thread.sleep(2000);

		Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
		Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
		
		if(vpnTopology.equals("Point-to-Point")) {
			
			if(intermediateTechnology.equalsIgnoreCase("null")) {
				
				DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Intermediate Technology field as expected");
				
			}else {
				
				getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")).clear();
				Thread.sleep(3000);
				
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")),
						intermediateTechnology);
				
				DriverTestcase.logger.log(LogStatus.PASS,"Intermediate Technology has been edited");
				
			}
		
			if(CircuitReference.equalsIgnoreCase("null")) {
				
				DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Circuit reference field as expected");
				
			}else {
				
				getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).clear();
				Thread.sleep(3000);

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
				
				DriverTestcase.logger.log(LogStatus.PASS,"Circuit Reference has been edited");
			}
			
			

			if(CircuitType.equalsIgnoreCase("null")) {
				
				DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Circuit Type field as expected");
				
			}else {
				
				Clickon(getwebelement("//div[span[contains(text(),'" + CircuitType + "')]]//input"));
				
				DriverTestcase.logger.log(LogStatus.PASS,"Circuit Type has been edited");
				
			}
			

			
			
		}
		
		else if(vpnTopology.equals("E-PN (Any-to-Any)")) {

			
			if(CircuitReference.equalsIgnoreCase("null")) {
				
				DriverTestcase.logger.log(LogStatus.PASS, "No changes has made for Circuit reference field as expected");
				
			}else {
				
				getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")).clear();
				Thread.sleep(3000);

				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
				
				DriverTestcase.logger.log(LogStatus.PASS,"Circuit Reference has been edited");
			}
			

			
		}
		
	
	
	else if(vpnTopology.equals("Hub&Spoke")) {

		DriverTestcase.logger.log(LogStatus.PASS,"Circuit ref, circuit type and Intermediate tech fields are not available to enter value, when msp is selected and 'hub&spoke' selected under 'VPntopology' ");
		System.out.println("hub and spoke selecte under vpn topology");
		
	}
		
		else {
			
			System.out.println(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
			Log.info(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
			DriverTestcase.logger.log(LogStatus.PASS,vpnTopology+ " is not available inside the VPNtopoloy dropdown");
			
		}


	}else {
		
		DriverTestcase.logger.log(LogStatus.PASS, "No changes made to vpn topology dropdown");
	}

				
					

	
				DriverTestcase.logger.log(LogStatus.PASS,"Values has been Edited for 'OLO - (GCR/EU)' subtype under LALINK Service");
			
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

			}
		 
		 
		 
		 public void editLanlinkInternational(String application, String ServiceIdentificationNumber, String SelectSubService,
					String Interfacespeed, String EndpointCPE, String Email, String PhoneContact, String remark,
					String PerformanceMonitoring, String ProactiveMonitoring, String deliveryChannel, String AggregateTraffic,
					String vpnTopology, String intermediateTechnology, String CircuitReference, String CircuitType, String notificationManagement)
					throws InterruptedException, IOException, DocumentException {

				
				String[] interfaceSpd=Interfacespeed.split(" ");
				SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
						ServiceIdentificationNumber);

				
				if(!ServiceIdentificationNumber.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")).clear();
					Thread.sleep(2000);
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/ServiceIdentification")),
							ServiceIdentificationNumber);
					
				}
				
				
				
				if(!EndpointCPE.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")).clear();
					Thread.sleep(2000);
					
					if (EndpointCPE.equals("yes")) {

						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/EndpointCPE")));
						Log.info("End point CPE check box is selected");
					}

					else {

						Log.info("Sing Endpoint CPE is not selected");
					}

				}
				
				
				if(!Email.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/Email")).clear();
					Thread.sleep(2000);
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Email")), Email);

				}
				
				
				if(!PhoneContact.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")).clear();
					Thread.sleep(2000);
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")), PhoneContact);

					
				}
				
				
				if(!remark.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/Remark")).clear();
					Thread.sleep(2000);
					
					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/Remark")), remark);

					
				}
				
				
				
				if(!PerformanceMonitoring.equalsIgnoreCase("null")) {
					
					getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")).clear();
					Thread.sleep(2000);
					
					if (PerformanceMonitoring.equalsIgnoreCase("yes")) {

						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/performancemonitoring")));
						Log.info("performance monitoring check box is selected");
					}

					else {

						System.out.println("Performance monitoring is not selected");
					}

					
				}



				if (!ProactiveMonitoring.equalsIgnoreCase("null")) {

					getwebelement(xml.getlocator("//locators/" + application + "/PhoneContact")).clear();
					Thread.sleep(2000);

					if (ProactiveMonitoring.equalsIgnoreCase("yes")) {

						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/proactiveMonitoring")));
						Log.info("Pro active monitoring check box is selected");

						Log.info("Notificationan Management dropdown displays when pro active monitoring is selected");
						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/notificationmanagement")));
						Clickon(getwebelement("//div[contains(text(),'" + notificationManagement + "')]"));

					} else {

						Log.info("Pro active monitoring is not selected");
						System.out.println("pro active monitoring is not selected");
					}

				}

			
				if (!deliveryChannel.equalsIgnoreCase("null")) {

					getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")).clear();
					Thread.sleep(2000);

					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/DeliveryChannel")));
					Clickon(getwebelement("//span[contains(text(),'" + deliveryChannel + "')]"));


				}

		
				
//			if(interfaceSpd[0].equals("10")) {
//				
//				
//				if(!AggregateTraffic.equalsIgnoreCase("null")) {
//					
//					getwebelement(xml.getlocator("//locators/" + application + "/Aggregate_10Gig_1Gig_Traffic")).clear();
//					Thread.sleep(2000);
//					
//					if (AggregateTraffic.equals("yes")) {
//
//						Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Aggregate_10Gig_1Gig_Traffic")));
//						Log.info("Aggregate Traffic check box is selected");
//						Thread.sleep(3000);
//						
//						
//						if(!vpnTopology.equalsIgnoreCase("null")) {
//							
//							Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
//							Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
//							Thread.sleep(2000);
//							
//							if(vpnTopology.equals("Hub&Spoke") || vpnTopology.equals("E-PN (Any-to-Any)")) {
//
//								SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
//
//								
//							}
//							
//							else {
//								
//								System.out.println("If aggregate traffic is selected,The available options under VPN topologies are: 'Hub&Spoke' and 'E-PN (Any-to-Any)' ");
//							}
//						}
//					}
//						
//					
//					else if(!AggregateTraffic.equals("yes")) {
//
//						Log.info("Aggregate Traffic check box is not selected");
//					
//
//					Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
//					Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
//					
//					if(vpnTopology.equals("Point-to-Point")) {
//						
//						
//						SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")),
//								intermediateTechnology);
//						
//						SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
//
//
//						Clickon(getwebelement("//div[span[contains(text(),'" + CircuitType + "')]]//input"));
//
//						
//						
//					}
//					
//					else if(vpnTopology.equals("E-PN (Any-to-Any)")) {
//
//						SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
//
//						
//					}
//					
//					
//					else if(vpnTopology.equals("Hub&Spoke")) {
//
//						Log.info("Circuit ref, circuit type and Intermediate tech fields are not available to enter value");
//						System.out.println("circuit ref dropdowns is not available");
//						
//					}
//
//					
//			else {
//						
//						System.out.println(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
//						Log.info(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
//					}
//					
//					}
//
//				}
//				
//			
//			}	
//			
//			
//			
//			if(interfaceSpd[0].equals("1")) {
//				
//
//				Clickon(getwebelement(xml.getlocator("//locators/" + application + "/VPNtopology")));
//				Clickon(getwebelement("//span[contains(text(),'" + vpnTopology + "')]"));
//				
//				if(vpnTopology.equals("Point-to-Point")) {
//					
//					
//					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/IntermediateTechnology")),
//							intermediateTechnology);
//					
//					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
//
//
//					Clickon(getwebelement("//div[span[contains(text(),'" + CircuitType + "')]]//input"));
//
//					
//					
//				}
//				
//				else if(vpnTopology.equals("E-PN (Any-to-Any)")) {
//
//					SendKeys(getwebelement(xml.getlocator("//locators/" + application + "/circuitReference")), CircuitReference);
//
//					
//				}
//				
//				
//				else if(vpnTopology.equals("Hub&Spoke")) {
//
//					Log.info("Circuit ref, circuit type and Intermediate tech fields are not available to enter value");
//					System.out.println("circuit ref dropdowns is not available");
//					
//				}
//
//				
//		else {
//					
//					System.out.println(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
//					Log.info(vpnTopology+ " is not available inside the VPNtopoloy dropdown");
//				}
//		
//			}
//		
				DriverTestcase.logger.log(LogStatus.PASS,"Values has been entered under lanlink International service subtype");
				
				
			
				
			Clickon(getwebelement(xml.getlocator("//locators/" + application + "/okbutton")));

			}
		 
		 
	   public void syncservices(String application) throws InterruptedException, DocumentException {
		   
		   Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Editservice_actiondropdown")));
		   Thread.sleep(3000);
		   Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Editservice_sysnchronizelink")));
		   Thread.sleep(3000);
		   
		   
	   }
	   
	   
	   	public void shownewInfovista(String application) throws InterruptedException, DocumentException {
		   
		   Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Editservice_actiondropdown")));
		   Thread.sleep(3000);
		   Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Editservice_infovistareport")));
		   Thread.sleep(3000);
		   
	   }
	   	
	   	
	   
		public void manageService(String application) throws InterruptedException, DocumentException {
			   
			   Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Editservice_actiondropdown")));
			   Thread.sleep(3000);
			   Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Editservice_managelink")));
			   Thread.sleep(3000);
			   
			   Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Backbutton")));
			   Thread.sleep(3000);
			   
		   }
		
		

		public void manageSubnets(String application) throws InterruptedException, DocumentException {
			   
			   Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Editservice_actiondropdown")));
			   Thread.sleep(3000);
			   Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Editservice_managesubnets")));
			   Thread.sleep(3000);
			   
			   Clickon(getwebelement(xml.getlocator("//locators/" + application + "/Backbutton")));
			   Thread.sleep(3000);
			   
		   }
		   	

	}
