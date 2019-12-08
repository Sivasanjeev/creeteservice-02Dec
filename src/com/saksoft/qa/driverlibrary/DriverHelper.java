package com.saksoft.qa.driverlibrary;

import static org.testng.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

public class DriverHelper {
	
	protected WebDriver driver;
	Wait<WebDriver> wait;
	WebElement el;
	List<WebElement> ellist;
	SoftAssert sa=new SoftAssert();// ByPramod
	public static ThreadLocal<String> NameStatus= new ThreadLocal<>();
	public static ThreadLocal<String> CustomerCreatedStatus= new ThreadLocal<>();
	
	
	public DriverHelper(WebDriver dr)
	{
		driver=dr;
		wait = new FluentWait<WebDriver>(driver) 
				.withTimeout(180, TimeUnit.SECONDS)    
				.pollingEvery(15, TimeUnit.SECONDS)    
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		//workitemcounter.set(1);
		//QuoteID.set("QT-20190604-077427-01");
		//DealClass.set("Bronze");
//		//TotalTCVdisscount.set((float) 0);
//		List Completeset=new ArrayList();
//		for(int i=0;i<2;i++) {
//			Object[] ExploreID=new Object[2];
//		
//			if(i==0) {
//				ExploreID[0]="";
//				ExploreID[1]="";
//			}
//			else {
//				ExploreID[0]="20190526021849";
//				ExploreID[1]="20190526030013";
//			}
//			Completeset.add(ExploreID);
//			System.out.println(Completeset.get(i).toString());
//		}
//		
//		
//		RequestID.set(Completeset);
//		List data=RequestID.get();
//		//data=RequestID.get();
//		for(int i=0;i<data.size();i++)
//		{
//			Object[] newdata=(Object[]) data.get(i);
//			System.out.println("Size For Each line item"+newdata.length);
//			System.out.println("A Site for lineitem"+i+" is "+newdata[0].toString());
//			System.out.println("B Site for lineitem"+i+" is "+newdata[1].toString());
//		}
	}
	 
	public void javascriptexecutor(WebElement el) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", el);
		//js.executeScript("window.scrollBy(0, 350)");
		//window.scrollTo(0, 0);
	}
	
	
	public void Expandthesection(WebElement Section, WebElement ClickableElement) throws Exception {
		Thread.sleep(5000);	
		String classvalue=Getattribute(Section,"class");
			System.out.println(classvalue);
		if(!classvalue.contains("green")){
			System.out.println("In IF class");
			//Clickon(ClickableElement);
			safeJavaScriptClick(ClickableElement);
			((JavascriptExecutor)

					driver).executeScript("arguments[0].scrollIntoView(window.innerHeight/2);", ClickableElement);
		}
		else {
			System.out.println("Already expanded");
		}
		}
	
	
	public void Clickonoutofviewport(WebElement locator) throws Exception {
		((JavascriptExecutor)
				driver).executeScript("arguments[0].scrollIntoView(window.innerHeight/2);", locator);
		safeJavaScriptClick(locator);
	}
	
	
	public void Clickonoutofviewportwithstring(String locator) throws Exception {
		((JavascriptExecutor)
				driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[text()='Show Groups']")));
		safeJavaScriptClick(driver.findElement(By.xpath(locator)));
	}
	
	
	
	@DataProvider
	public static Map<String, String> getTestData(String sheetName){
		Map<String, String> returnMap = new HashMap<String, String>();
		try {
			FileInputStream fis = new FileInputStream(new File("src\\com\\saksoft\\qa\\datalibrary\\APT_MCS_TESTDATA.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			switch (sheetName) {
			case "Sheet1":
				Iterator<Row> rowIterator = sheet.iterator();
				
				while(rowIterator.hasNext())
				{
					Row row = rowIterator.next();
					if(row.getRowNum() != 0) {
						/*
						 * Iterator<Cell> cellIterator = row.cellIterator();
						 * while(cellIterator.hasNext()) { Cell cell = cellIterator.next();
						 * System.out.println(cell.getStringCellValue() + "\t"); }
						 */
						returnMap.put("Name", row.getCell(0).getStringCellValue());
						returnMap.put("Device Type", row.getCell(1).getStringCellValue());
						returnMap.put("Vender Model", row.getCell(2).getStringCellValue());
						
						returnMap.put("Router Id", row.getCell(4).getStringCellValue());
						returnMap.put("Country", row.getCell(5).getStringCellValue());
						returnMap.put("Management Address", row.getCell(6).getStringCellValue());
						
						
						
						
					}
					
				}
							
							break;
			case "Sheet2":
				
							
							
							break;

			default:
				break;
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
		return returnMap;
	}
	
	
	public void WaitforElementtobeclickable(final String locator) throws InterruptedException
	{
		waitForpageload();
		if(locator.startsWith("//") || locator.startsWith("(")) {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator))); 
		//getwebelement(xml.getlocator("//locators/StandrdQuote"));
		System.out.println("Code for Loading");
		Thread.sleep(2000);
		}
		else if(locator.startsWith("name"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.name(locator.split("=")[1]))); 
			//getwebelement(xml.getlocator("//locators/StandrdQuote"));
			System.out.println("Code for Loading");
			Thread.sleep(2000);
			
		}
		else if(locator.startsWith("id"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.id(locator.split("=")[1]))); 
			//getwebelement(xml.getlocator("//locators/StandrdQuote"));
			System.out.println("Code for Loading");
			Thread.sleep(2000);
			
		}
	}
	public void Getloadingcomplete(final String locator) throws InterruptedException
	{
		wait.until(ExpectedConditions.attributeToBe(By.xpath(locator), "style", "display: none;")); 
		//getwebelement(xml.getlocator("//locators/StandrdQuote"));
		System.out.println("Code for Loading");
		Thread.sleep(2000);
		
	}
	
	public void CloseProposalwindow() throws InterruptedException
	{   String parentWinHandle = driver.getWindowHandle();
		Set<String> totalopenwindow=driver.getWindowHandles();
		if(totalopenwindow.size()>1) {
		for(String handle: totalopenwindow)
		{
            if(!handle.equals(parentWinHandle))
            {
            driver.switchTo().window(handle);
            
            }
		}
		driver.close();
		driver.switchTo().window(parentWinHandle);
		}
		else {
			System.out.println("Something went wrong. Proposal has not be generated");
		}
	}
	public void Switchtotabandsignthequote() throws Exception
	{   String parentWinHandle = driver.getWindowHandle();
		Set<String> totalopenwindow=driver.getWindowHandles();
		for(String handle: totalopenwindow)
		{
            if(!handle.equals(parentWinHandle))
            {
            driver.switchTo().window(handle);
            Thread.sleep(12000);
            try {
            safeJavaScriptClick(getwebelement("//*[@id='disclosureAccepted']"));
            }
            catch(Exception e) {
            Clickon(getwebelement("//*[text()='Required']"));
            }
            Clickon(getwebelement("//button[text()='Continue']"));
    		Clickon(getwebelement("//button[@data-qa='SignHere']"));
    		Clickon(getwebelement("//div[@class='page-tabs']"));
    		//create object 'action' of Actions class
    		//Dragedrop(getwebelement("//button[@data-qa='SignHere']"),getwebelement("//div[@class='page-tabs']"));
    		Thread.sleep(10000);
    		Clickon(getwebelement("//button[text()='Adopt and Sign']"));
//    		Thread.sleep(10000);
//    		Clickon(getwebelement("//button[text()='Ok']"));
    		Thread.sleep(10000);
    		WaitforElementtobeclickable("//button[text()='Finish']");
    		Clickon(getwebelement("//button[text()='Finish']"));
    		WaitforElementtobeclickable("(//button[text()='Continue'])[2]");
    		Clickon(getwebelement("(//button[text()='Continue'])[2]"));
    		Thread.sleep(10000);
            }
		}
		driver.close();
		driver.switchTo().window(parentWinHandle);
	}
	public void Switchtotab() throws Exception
	{   String parentWinHandle = driver.getWindowHandle();
		Set<String> totalopenwindow=driver.getWindowHandles();
		for(String handle: totalopenwindow)
		{
            if(!handle.equals(parentWinHandle))
            {
            driver.switchTo().window(handle);
            Thread.sleep(4000);
           
            }
		}
		//driver.close();
		//driver.switchTo().window(parentWinHandle);
	}
	public void Getmaploaded(final String framlocator, final String messagelocator) throws InterruptedException
	{
		
		System.out.println("Code for Map Loading");
		Thread.sleep(3000);
		String[] finalval=framlocator.split("=");
		//Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.id(finalval[1])));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(messagelocator))); 
		System.out.println(driver.findElement(By.xpath(messagelocator)).getText().toString());
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		System.out.println("Code for Map Loading");
		
	}
	public WebElement getwebelement(final String locator) throws InterruptedException
	{   //Log.info("Indriverhelper"+driver);
	 //WebElement el;
	final String[] finalval;
		if(locator.startsWith("name"))
		{
			finalval=locator.split("=");
			//Log.info(finalval[1]);
			//Log.info("Indriverhelper"+driver);
			//wait.until();
			
			wait.until(new Function<WebDriver, WebElement>() {       
				public WebElement apply(WebDriver driver) { 
					el= driver.findElement(By.name(finalval[1]));
					//RemoteWebDriver dr;
					
					wait.until(ExpectedConditions.elementToBeClickable(el)).isEnabled();
					return el;     
				 }  
				}); 
			//wait.until(ExpectedConditions.stalenessOf(element))
		}
		else if(locator.startsWith("id"))
		{
			finalval=locator.split("=");
			//Log.info(finalval[1]);
			//Log.info("Indriverhelper"+driver);
			wait.until(new Function<WebDriver, WebElement>() {       
				public WebElement apply(WebDriver driver) { 
					el=driver.findElement(By.id(finalval[1]));
					wait.until(ExpectedConditions.elementToBeClickable(el)).isEnabled();
					//wait.until(el.isEnabled());
					return el;   
				 }  
				});
			 //el= driver.findElement(By.id(finalval[1]));
		}
		else if (locator.startsWith("//")|| locator.startsWith("(//")||locator.startsWith("("))
		{
			try {
				
			wait.until(new Function<WebDriver, WebElement>() {       
				public WebElement apply(WebDriver driver) {
					
						el=driver.findElement(By.xpath(locator)); 
						wait.until(ExpectedConditions.elementToBeClickable(el)).isEnabled();
						return el;
						 }  
				});
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("the webelement not found and the locator is:  "+locator);
//				DriverTestcase.logger.log(LogStatus.FAIL,"Webelement is not available and the unavailable webelement is: "+locator);
			}
			
		}
		//Thread.sleep(1000);
		
		return el;
	}
	public String gettitle() {
		return driver.getTitle();
	}
	
	
	public WebElement getwebelement2(final String locator) throws InterruptedException
	{   
		if (locator.startsWith("//")|| locator.startsWith("(//"))
		{	
					el=(WebElement) driver.findElement(By.xpath(locator)); 
					return driver.findElement(By.xpath(locator));     	
		}
		Thread.sleep(1000);
		return el;
	}
	public void openurl(String environment) throws Exception {
		String URL=null;
		PropertyReader pr=new PropertyReader();
		Log.info(environment+"_URL");
		URL=pr.readproperty(environment+"_URL");
		
		driver.get(URL);
		
	}
	public void Geturl(String URL) throws Exception {
	
		driver.get(URL);
		
	}
	public void Clickon(WebElement el) throws InterruptedException {
		//Thread.sleep(3000);
		
		try {
			
			
		el.click();
		
		}
		catch(WebDriverException e)
		//Thread.sleep(3000);
		{
			//Thread.sleep(3000);
			if(e.getMessage().contains("Element is not clickable at point"))
			{
				Thread.sleep(3000);
				el.click();
			}
		}
	}
	public void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				Log.info("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				Log.info("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			Log.info("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			Log.info("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			Log.info("Unable to click on element "+ e.getStackTrace());
		}
	}
	public void switchtofram(WebElement el){
		driver.switchTo().frame(el);
		
	}
	public void switchtodefault(){
		driver.switchTo().defaultContent();
		
	}
			public String Getattribute(WebElement el,String attributename) {
			Log.info(el.getAttribute(attributename));
			return el.getAttribute(attributename);
	  }
public void Moveon(WebElement el) {
			
		Actions action = new Actions(driver);
		 
	    action.moveToElement(el).build().perform();
	    
	}
	public boolean isElementPresent(String locator) {
	    try {
	        driver.findElement(By.xpath(locator));
	        Log.info("Element Found: True");
	        return true;
	    } catch (NoSuchElementException e) {
	    	 Log.info("Element Found: False");
	        return false;
	    }
	}

	public void waitandclickForworkitemsPresent(String locator, int timeout) throws InterruptedException
	{
			for(int i=0;i<=timeout*60/20;i++){
				try {
		            if (isElementPresent(locator)){
		                break;
		            }
		            else{
		            	//Goto Error Tab
		            	// Clickon(getwebelement(xml.getlocator("//locators/Tasks/Errors")));
		            	//if any Error displayed
		            	//if(isElementPresent("Locator for first error"))
		            	//{
		            	//Assert.fail("An Error Occuured on Error Tab");
		            	//break;
		            	//}
		            	//else
		            	//{
		            	//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Workitems")));
		            	//Log.info("Refreshing the Pages");
			        	//driver.navigate().refresh();
			        	//Log.info("Waiting For 20 Sec");
			        	//Thread.sleep(20000);
		            	//}
		            	//Assert False and Break
		            	//else navigate to WorkItems and do the page refresh and weight
		            	Log.info("Refreshing the Pages");
			        	driver.navigate().refresh();
			        	Log.info("Waiting For 20 Sec");
			        	Thread.sleep(20000);
		            }
		            }
		        catch (Exception e) {
		        	Log.info(e.getMessage());
		        }
			}
	}
	
	public void waitandclickForOrderCompleted(String locator, int timeout) throws InterruptedException
	{
			for(int i=0;i<=timeout*60/20;i++){
				try {
		            if (isElementPresent(locator)){
		                break;
		            }
		            else{
		            	Log.info("Refreshing the Pages");
			        	driver.navigate().refresh();
			        	Log.info("Waiting For 20 Sec");
			        	Thread.sleep(20000);
		            }
		            }
		        catch (Exception e) {
		        	Log.info(e.getMessage());
		        }
			}
	}
	
	public void waitandclickForOrderStarted(String locator, int timeout) throws InterruptedException
	{
			for(int i=0;i<=timeout*60/20;i++){
				try {
		            if (isElementPresent(locator)){
		                break;
		            }
		            else{
		            	Log.info("Refreshing the Pages");
			        	driver.navigate().refresh();
			        	Log.info("Waiting For 20 Sec");
			        	Thread.sleep(20000);
		            }
		            }
		        catch (Exception e) {
		        	Log.info(e.getMessage());
		        }
			}
	}
	
	public void waitandForElementDisplay(String locator, int timeout) throws InterruptedException
	{
			for(int i=0;i<=timeout*60/20;i++){
				try {
		            if (isElementPresent(locator)){
		                break;
		            }
		            else{
		            	Log.info("Refreshing the Pages");
			        	//driver.navigate().refresh();
			        	Log.info("Waiting For 20 Sec");
			        	Thread.sleep(20000);
		            }
		            }
		        catch (Exception e) {
		        	Log.info(e.getMessage());
		        }
			}
	}
	public void waitandForElementtobenotDisplay(String locator, int timeout) throws InterruptedException
	{
			for(int i=0;i<=timeout*60/20;i++){
				try {
		            if (isElementPresent(locator)){
		            	Log.info("Refreshing the Pages");
			        	//driver.navigate().refresh();
			        	Log.info("Waiting For 20 Sec");
			        	System.out.println("Waiting......");
			        	Thread.sleep(3000);
		            }
		            else{
		            	break;
		            }
		            }
		        catch (Exception e) {
		        	Log.info(e.getMessage());
		        }
			}
	}
	public void waitandForElementDisplay2(String locator, int timeout) throws InterruptedException
	{
			for(int i=0;i<=timeout*60/20;i++){
				try {
		            if (isElementPresent(locator)){
		                break;
		            }
		            else{
		            	//Log.info("Refreshing the Pages");
			        	//driver.navigate().refresh();
			        	Log.info("Waiting For 20 Sec");
			        	Thread.sleep(3000);
		            }
		            }
		        catch (Exception e) {
		        	Log.info(e.getMessage());
		        }
			}
	}
	public void Pagerefresh() throws InterruptedException
	{
			driver.navigate().refresh();
			
			        	
	}
	
	public int getwebelementscount(final String locator) throws InterruptedException
	{ 
		ellist=driver.findElements(By.xpath(locator));
		return ellist.size();
	}
	
	/*
	 * Pramod
	 */
	public List<WebElement> getwebelements(final String locator) throws InterruptedException{   //Log.info("Indriverhelper"+driver);
		 //WebElement el;
		final String[] finalval;
			if(locator.startsWith("name"))
			{
				finalval=locator.split("=");
				//Log.info(finalval[1]);
				//Log.info("Indriverhelper"+driver);
				//wait.until();
				
				wait.until(new Function<WebDriver, List<WebElement>>() {       
					public List<WebElement> apply(WebDriver driver) { 
						ellist= driver.findElements(By.name(finalval[1]));
						//RemoteWebDriver dr;
						
						//wait.until(ExpectedConditions.elementToBeClickable(ellist)).isEnabled();
						return ellist;     
					 }  
					}); 
				//wait.until(ExpectedConditions.stalenessOf(element))
			}
			else if(locator.startsWith("id"))
			{
				finalval=locator.split("=");
				//Log.info(finalval[1]);
				//Log.info("Indriverhelper"+driver);
				wait.until(new Function<WebDriver, List<WebElement>>() {       
					public List<WebElement> apply(WebDriver driver) { 
						ellist=driver.findElements(By.id(finalval[1]));
						//wait.until(ExpectedConditions.elementToBeClickable(ellist)).isEnabled();
						//wait.until(el.isEnabled());
						return ellist;   
					 }  
					});
				 //el= driver.findElement(By.id(finalval[1]));
			}
			else if (locator.startsWith("//")|| locator.startsWith("(//")||locator.startsWith("("))
			{
				wait.until(new Function<WebDriver, List<WebElement>>() {       
					public List<WebElement> apply(WebDriver driver) { 
						ellist=driver.findElements(By.xpath(locator)); 
						//wait.until(ExpectedConditions.elementToBeClickable(ellist)).isEnabled();
						return ellist;   
					 }  
					});
				
			}
			//Thread.sleep(1000);
			
			return ellist;
		}
	
	///////////////
	
	
	
	public void SendKeys(WebElement el,String value) throws InterruptedException, IOException {
		//Thread.sleep(3000);
		//el.
		//System.out.println(el.getRect().getHeight()+"-"+el.getRect().getWidth()+"-"+el.getRect().x+"-"+el.getRect().x);
		//ExtentTestManager.getTest().log(LogStatus.PASS,ExtentTestManager.getTest().addBase64ScreenShot(capturescreenshotforelement(el)));
		el.sendKeys(value);
		
		//Thread.sleep(3000);
	}
	

	public void SendkeaboardKeys(WebElement el,Keys k) throws InterruptedException {
		//Thread.sleep(3000);
		el.sendKeys(k);
		//Thread.sleep(3000);
	}
	
	public String GetText(WebElement el) {
			String actual=el.getText().toUpperCase().toString();
	//		String actual1=el.getText().toUpperCase().toString();
			return actual;
		}
	
	public String GetInputValue(WebElement el) {
		String actual=el.getAttribute("value");
		return actual;
		}

	public String Getkeyvalue(String Key) throws IOException{ 
			PropertyReader pr=new PropertyReader();
		    String Keyvalue;
			Keyvalue=pr.readproperty(Key);
			return Keyvalue;
		}
	
	public void VerifyTextpresent(String text) throws IOException
		{ 
			Log.info(text);
			Assert.assertFalse(driver.findElement(By.xpath("//*[text()='"+text+"']")).isDisplayed());
		}
	
	public void VerifyText(String text) throws IOException
		{ 
			Log.info(text);
			Assert.assertTrue(driver.findElement(By.xpath("//*[text()='"+text+"']")).isDisplayed());
		}
	
	public void VerifyText2(String text, String expectedText, String message ) throws IOException
	{ 
		Log.info(text);
		sa.assertEquals(driver.findElement(By.xpath("//*[text()='"+text+"']")), expectedText, message);
		
		//sa.assertAll();
	}
	
	public String Gettext(WebElement el) throws IOException
		{ 
			String text=el.getText().toString();
			return text;
		}
	public String GetValueofInput(WebElement el) throws IOException
	{ 
		String text=el.getAttribute("value");
		return text;
	}
	
	public String[] GetText2(WebElement el) throws IOException
		{ 
			String text=el.getText().toString();
			String[] text2=text.split(" \\[");
			Log.info("New Task Name is:"+text2);
			return text2;
		}
	
	public String GetText3(WebElement el, String string) throws IOException
		{ 
			String text=el.getText().toString();
			return text;
		}
	
	
	
	public String GetTheSelectedValueInsideDropdown(WebElement el) throws IOException, InterruptedException
	{ //Thread.sleep(3000);
		Select s1=new Select(el);
		WebElement option = s1.getFirstSelectedOption();
		String defaultItem = option.getText();		
		return defaultItem;
	
	}
	
	
	
	public void Select(WebElement el, String value) throws IOException, InterruptedException
		{ //Thread.sleep(2000);
			Select s1=new Select(el);
			s1.selectByVisibleText(value);
			//Thread.sleep(2000);
		}
	public void Select2(WebElement el, String value) throws IOException, InterruptedException
	{ //Thread.sleep(3000);
		Select s1=new Select(el);
		s1.selectByValue(value);
		//Thread.sleep(3000);
	}
	/*
	 * Pramod
	 */
	public List<String> getAllValuesInsideDropDown(WebElement el) throws IOException, InterruptedException
	{ 
		  Select sel = new Select(el);
		    List<WebElement> we = sel.getOptions();
		    List<String> ls = new ArrayList<String>();
		    for(WebElement a : we)
		    {
		        if(!a.getText().equals("select")){
		            ls.add(a.getText());
		        }
		    }
		    return ls;
	}
	
	
	public List<String> getAllValuesInsideDropDown2(WebElement el) throws IOException, InterruptedException
	{ 
		  Select sel = new Select(el);
		    List<WebElement> we = sel.getOptions();
		    List<String> ls = new ArrayList<String>();
		    for(WebElement a : we)
		    {
		        if(!a.getText().equals("Select")){
		            ls.add(a.getText());
		        }
		    }
		    return ls;
	}
	
	
	
	public void Clear(WebElement el) throws IOException, InterruptedException
		{ //Thread.sleep(3000);
			el.clear();
			//Thread.sleep(3000);
		}
	public void WaitforC4Cloader(String el, int timeout ) throws IOException, InterruptedException
	{ Thread.sleep(3000);
//		for(int i=0;i<=timeout*60/20;i++){
//			try {
//	            if (isElementPresent(el)){
//	            	//Log.info("Refreshing the Pages");
//		        	//driver.navigate().refresh();
//		        	Log.info("Waiting For 20 Sec");
//		        	Thread.sleep(20000);
//	            }
//	            else{
//	            	//Log.info("Refreshing the Pages");
//		        	//driver.navigate().refresh();
//		        	break;
//	            }
//	            }
//	        catch (Exception e) {
//	        	Log.info(e.getMessage());
//	        }
//		}
		//Thread.sleep(3000);
	}
	public void AcceptJavaScriptMethod(){
		
			Alert alert = driver.switchTo().alert();
			alert.accept();
			driver.switchTo().defaultContent();
		}
	public void waitForpageload() throws InterruptedException
	{
		waitandForElementtobenotDisplay("//*[@id='overLayHtml_t-wrapper']",1);
		wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));	
		//Thread.sleep(1000);
	}
	public void Dragedrop(WebElement source,WebElement Destination){
		Actions action = new Actions(driver);
		//use dragAndDrop() method. It accepts two parametes source and target.
		action.dragAndDrop(source, Destination).build().perform();
	}
	
	public void EnterText(String s){
		Actions keyAction = new Actions(driver);     
		keyAction.sendKeys(s).perform();
	}
	public void savePage(){
			Actions keyAction = new Actions(driver);     
			keyAction.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).perform();
		}
	public void KeydownKey(Keys key){
		Actions keyAction = new Actions(driver);     
		keyAction.keyDown(key).perform();
	}
	public void KeyupKey(Keys key){
		Actions keyAction = new Actions(driver);     
		keyAction.keyUp(key).perform();
	}
	public void uploadafile(String  locator,String FileName)
	{
		String str = System.getProperty("user.dir")+"\\src\\Data\\"+FileName;
		String[]  finalval=locator.split("=");
		WebElement el=driver.findElement(By.id(finalval[1])); 
		el.sendKeys(str);
//		// + "\\Lib\\chromedriver.exe"
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		Clipboard clipboard = toolkit.getSystemClipboard();
//		StringSelection strSel = new StringSelection(str);
//		clipboard.setContents(strSel, null);
//		Actions keyAction = new Actions(driver); 
//		keyAction.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
//		keyAction.sendKeys(Keys.ENTER);
		
	}
	public String capturescreenshotforelement(WebElement ele) throws IOException
	{
		String screenshot2;
	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	BufferedImage  fullImg = ImageIO.read(screenshot);

	// Get the location of element on the page
	org.openqa.selenium.Point point = ele.getLocation();

	// Get width and height of the element
	int eleWidth = ele.getSize().getWidth();
	int eleHeight = ele.getSize().getHeight();

	// Crop the entire page screenshot to get only element screenshot
	BufferedImage eleScreenshot= fullImg.getSubimage(point.getX()-20, point.getY()-20,
	    eleWidth+20, eleHeight+20);
	ByteArrayOutputStream bos = new ByteArrayOutputStream();
	ImageIO.write(eleScreenshot, "png", bos);
	byte[] imageBytes = bos.toByteArray();
    screenshot2 = "data:image/png;base64,"+Base64.getMimeEncoder().encodeToString(imageBytes);
    bos.close();
    return screenshot2;
	}
	
	public void clickUsingAction(WebElement el)
	{
		Actions act=new Actions(driver);
		act.moveToElement(el).click().build().perform();
	}
	
	public void waitforPagetobeenable() throws InterruptedException
	 { 
		 WebElement el=driver.findElement(By.xpath("//html"));
		 Thread.sleep(2000);
		 while(el.getAttribute("class").contains("colt-custom-siebui-busy"))
		 {
			 Thread.sleep(1000);
		 }
	 }
	
	
	public static String getCurrentDate() {
		java.util.Date date=java.util.Calendar.getInstance().getTime();  
		String currentDate=String.valueOf(date);
	return currentDate;	
	}
	
	
}
