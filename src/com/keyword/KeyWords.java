package com.keyword;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyWords {
static WebDriver driver;
public Properties OR;
public FileInputStream fn;
public WebDriverWait wait ;
public KeyWords (WebDriver driver) {
KeyWords.driver=driver;
 
OR = new Properties();
try {
fn = new FileInputStream(System.getProperty("user.dir")+"//src//AppConfig.properties");
OR.load(fn);
} catch (Exception e) {
e.printStackTrace();
}
}
	
	/*public void open_Browser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//Browser_Driver//chromedriver.exe"); 
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("IE")) {				
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//Browser_Driver//IEDriverServer.exe"); 
				driver = new InternetExplorerDriver();
			}
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}*/

	//public boolean enter_URL() {
		//boolean bStatus=false;
		//String URL="sadf";
		//driver.navigate().to(URL);
		//driver.manage().window().maximize();
		//bStatus=true;
		//return bStatus;
		
	//}

	public void Wait(WebElement element) {
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	
	public By locatorValue(String locatorTpye, String value) {
		By by;
		switch (locatorTpye) {
		case "id":
			by = By.id(value);
			break;
		case "name":
			by = By.name(value);
			break;
		case "xpath":
			by = By.xpath(value);
			break;
		case "css":
			by = By.cssSelector(value);
			break;
		case "linkText":
			by = By.linkText(value);
			break;
		case "partialLinkText":
			by = By.partialLinkText(value);
			break;
		default:
			by = null;
			break;
		}
		return by;
	}
	//================================================================================================================================================================
    // <summary>
    //Function_Name : invokeBrowser
    //Description : This function is use to set text in edit box.
    //Created Date : 
    //Created by : EMIDS
    //Modified Date : ..
    //Modified By : ..
    // </summary>
    //================================================================================================================================================================
		public boolean invokeBrowser() {
			boolean bStatus=false;
			String URL="Https://qa.onlifehealth.com";
			driver.navigate().to(URL);
			bStatus=true;
			return bStatus;
			 
			}
//================================================================================================================================================================
    // <summary>
    //Function_Name : CloseBrowser
    //Description : This function is use to set text in edit box.
    //Created Date : 
    //Created by : EMIDS
    //Modified Date : ..
    //Modified By : ..
    // </summary>
    //================================================================================================================================================================
		public boolean CloseBrowser() {
		boolean bStatus=false;
		driver.close();
		bStatus=true;
		return bStatus;
		 
		}
	
	//================================================================================================================================================================
    // <summary>
    //Function_Name		: EditSetText
    //Description		: This function is use to set text in edit box.
    //Created Date		: 
    //Created by		: EMIDS
    //Modified Date	: ..
    //Modified By		: ..
    // </summary>
    //================================================================================================================================================================
	
	public boolean enter_Text(String locatorType, String value, String text) {
		boolean bStatus=false;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			Wait(element);
			element.clear();
			
			element.sendKeys(text);
			String strEdit_Text = element.getAttribute("value");
			 if (strEdit_Text.replace("-", "").contains(text))
             {            	 
				 bStatus = true;                             
             }
			
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);			
                              
         }
		return bStatus;
	}

	//================================================================================================================================================================
    // <summary>
    //Function_Name		: enter_TextInNewWindow
    //Description		: This function is use to set text in edit box of new window.
    //Created Date		: 
    //Created by		: EMIDS
    //Modified Date	: ..
    //Modified By		: ..
    // </summary>
    //================================================================================================================================================================
	
	public boolean enter_TextInNewWindow(String locatorType, String value, String text) {
		boolean bStatus=false;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			Wait(element);
			element.clear();
			
			element.sendKeys(text);
			String strEdit_Text = element.getAttribute("value");
			 if (strEdit_Text.replace("-", "").contains(text))
             {            	 
				 bStatus = true;                             
             }
			
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);			
                              
         }
		return bStatus;
	}
	
	//================================================================================================================================================================
    // <summary>
    //Function_Name		: enter_Text_Randomdigit
    //Description		: This function is use to set random digit text in edit box.
    //Created Date		: 
    //Created by		: EMIDS
    //Modified Date	: ..
    //Modified By		: ..
    // </summary>
    //================================================================================================================================================================
	
	public boolean enter_Text_Randomdigit(String locatorType, String value, String text) {
		boolean bStatus=false;
		try {
			String RandomDigit =RandomStringUtils.randomNumeric(Integer.parseInt(text));
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			Wait(element);
			element.clear();
			element.sendKeys(RandomDigit);
			String strEdit_Text = element.getAttribute("value");
			 if (strEdit_Text.contains(RandomDigit))
             {            	 
				 bStatus = true;
                             
             }
			
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);			
                              
         }
		return bStatus;
	}

	
	//================================================================================================================================================================
    // <summary>
    //Function_Name		: enter_Text_Randomstring
    //Description		: This function is use to set random string text in edit box.
    //Created Date		: 
    //Created by		: EMIDS
    //Modified Date	: ..
    //Modified By		: ..
    // </summary>
    //================================================================================================================================================================
	
	public boolean enter_Text_Randomstring(String locatorType, String value, String text) {
		boolean bStatus=false;
		try {
			String RadomString=RandomStringUtils.randomAlphabetic(Integer.parseInt(text));
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			Wait(element);
			element.clear();
			element.sendKeys(RadomString);
			String strEdit_Text = element.getAttribute("value");
			 if (strEdit_Text.contains(RadomString))
             {            	 
				 bStatus = true;
                             
             }
			
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);			
                              
         }
		return bStatus;
	}
	
	 //================================================================================================================================================================
    // <summary>
    //Function_Name		: VerifyTextInParagraph
    //Description		: This function is use to verify paragraph text 
    //Created Date		: 
    //Created by		: EMIDS
    //Modified Date	: ..
    //Modified By		: ..
    // </summary>
    //================================================================================================================================================================
 
 public boolean verifyTextInParagraph(String locatorType, String value, String text)
 {	
		boolean bStatus=false;	
		String strText = String.valueOf("");
		  try
		     {
		     	By locator;
				locator = locatorValue(locatorType, value);
				WebElement element = driver.findElement(locator);
				Wait(element);
				strText = element.getText().trim();
				if (strText.toLowerCase().indexOf(text.toLowerCase().trim()) > -1 )
					 {
					bStatus = true;
					 }
		     }
		     catch(Exception ex)
		     {
		     }
		     return bStatus;
 }
 
//================================================================================================================================================================
 // <summary>
 //Function_Name : invokeLiveOnBrowser
 //Description : This function is use to invoke LiveOn Browser.
 //Created Date : 
 //Created by : EMIDS
 //Modified Date : ..
 //Modified By : ..
 // </summary>
 //================================================================================================================================================================
public boolean invokeLiveOnBrowser() {

boolean bStatus=false;
String liveOnUrl=OR.getProperty("strLiveonURL");
System.out.println(liveOnUrl);
driver.get(liveOnUrl);
bStatus=true;
return bStatus;

}
//================================================================================================================================================================
 // <summary>
 //Function_Name : invokeCoachOnBrowser
 //Description : This function is use to invoke CoachOn Browser.
 //Created Date : 
 //Created by : EMIDS
 //Modified Date : ..
 //Modified By : ..
 // </summary>
 //================================================================================================================================================================
public boolean invokeCoachOnBrowser() {
boolean bStatus=false;
String coachOnUrl=OR.getProperty("strCoachonURL");
driver.navigate().to(coachOnUrl);
bStatus=true;
return bStatus;

}
 //================================================================================================================================================================
 // <summary>
 //Function_Name	: VerifyPartialTextInParagraph
 //Description		: This function is use to verify paragraph text 
 //Created Date		: 
 //Created by		: EMIDS
 //Modified Date	: ..
 //Modified By		: ..
 // </summary>
 //================================================================================================================================================================

public boolean VerifyPartialTextInParagraph(String locatorType, String value, String text)
{	
		boolean bStatus=false;	
		String strText = String.valueOf("");
		String strsubstring = String.valueOf("");
		  try
		     {
		     	By locator;
				locator = locatorValue(locatorType, value);
				WebElement element = driver.findElement(locator);
				Wait(element);
				strText = element.getText().trim();
				int textcount = text.length();
				strsubstring = strText.substring(0, textcount).trim();
				System.out.println(strsubstring);
				System.out.println((text).trim());
				if(strsubstring.equals((text).trim()))
				{
					
					bStatus = true;
				}
				
		
		     }
		     catch(Exception ex)
		     {
		     }
		     return bStatus;
}
	
	//================================================================================================================================================================
    // <summary>
    //Function_Name		: click_On_link
    //Description		: This function is use to click on link
    //Created Date		: 
    //Created by		: EMIDS
    //Modified Date	: ..
    //Modified By		: ..
    // </summary>
    //================================================================================================================================================================
	
	public boolean click_On_link(String locatorType, String value) {
		boolean bStatus=false;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			
			WebElement element = driver.findElement(locator);
			Wait(element);
			element.click();			
			bStatus = true;
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);
		}
		return bStatus;
	}	

	
	//================================================================================================================================================================
    // <summary>
    //Function_Name		: click_On_Button
    //Description		: This function is use to click on button
    //Created Date		: 
    //Created by		: EMIDS
    //Modified Date	: ..
    //Modified By		: ..
    // </summary>
    //================================================================================================================================================================

	public boolean click_On_Button(String locatorType, String value) {
		boolean bStatus=false;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);	
			Wait(element);
			element.click();
				 bStatus = true;
           
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to perform click" + e);
		}
		return bStatus;
	}
	
	//public void close_Browser() {
	//	driver.quit();
	//}
	
	
	
	//================================================================================================================================================================
    // <summary>
    //Function_Name		: SnapShot
    //Description		: This function is use to take snapshot of failed steps 
    //Created Date		: 
    //Created by		: EMIDS
    //Modified Date	: ..
    //Modified By		: ..
    // </summary>
    //================================================================================================================================================================

	 public String SnapShot(String strSnapFolderPath,String ModuleName,String strKeyFunction,String strBrowserName)
	  {
		 
		 String snappath = String.valueOf(" ");
		 DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		 Date dateobj = new Date();
		 String strMainString=df.format(dateobj);
		 String strDateString=strMainString.replace("/","_").replace(":", "_").replace(" ","");
	 	 String GlobalDataPath = (strSnapFolderPath.replace("//","\\") + "\\");		 
		 
		 try {
			 EventFiringWebDriver edriver = new EventFiringWebDriver(driver);			 
			 File scrFile = ((TakesScreenshot)edriver).getScreenshotAs(OutputType.FILE);
			 // Now you can do whatever you need to do with it, for example copy somewhere
			 snappath =GlobalDataPath+ModuleName+"_"+strKeyFunction+"_"+strBrowserName+"_"+strDateString+".png";
			 FileUtils.copyFile(scrFile, new File(snappath));	
			
			 
		 }
	    catch (IOException localIOException) {
	    }
		 catch (StringIndexOutOfBoundsException ex1){
		 }
		 catch(ArrayIndexOutOfBoundsException ex2){			 
		 }
		 
	    return snappath.replace("//","\\");
	  }
	
	 
	//================================================================================================================================================================
	   // <summary>
	   //Function_Name : verifyWebElementExistance
	   //Description : This function is use to verify webElement existence
	   //Created Date : 
	   //Created by : EMIDS
	   //Modified Date : ..
	   //Modified By : ..
	   // </summary>
	   //================================================================================================================================================================

	public boolean verifyWebElementExistance(String locatorType,String value,String strStatusToCheck) {
	boolean bStatus=false;
	boolean elementVerification=Boolean.parseBoolean(strStatusToCheck);
	try {
	 
	By locator;
	locator = locatorValue(locatorType, value);
	WebElement element = driver.findElement(locator);
	Wait(element);
	 
	if (element.isDisplayed()==elementVerification) {
	bStatus = true;
	}
	 
	}
	catch (NoSuchElementException e) {
	 
	System.err.format("No Element Found" + e);
	}
	return bStatus;
	}
	
	//================================================================================================================================================================
	   // <summary>
	   //Function_Name : VerifyTextInTextBox
	   //Description : This function is use to verify text in TextBox
	   //Created Date : 
	   //Created by : EMIDS
	   //Modified Date : ..
	   //Modified By : ..
	   // </summary>
	   //================================================================================================================================================================
		
	public boolean verifyTextInTextBox(String locatorType, String value, String text)
	 {	
			boolean bStatus=false;	
			
			String strText = String.valueOf("");
			  try
			     {
				  	
			     	By locator;
					locator = locatorValue(locatorType, value);
					WebElement element = driver.findElement(locator);
					Wait(element);
					strText = element.getText().trim(); 
					
					if(strText.length() > -1)
					{
						bStatus = true;
					}
								
					
			     }
			     catch(Exception ex)
			     {
			     }
			     return bStatus;
	 }
		
	 	//================================================================================================================================================================
	    // <summary>
	    //Function_Name		: EditSet_PreviusORFutureDate
	    //Description		: This function is use to set date of present or past or future based on user input 
	    //Created Date		: 
	    //Created by		: EMIDS
	    //Modified Date	: ..
	    //Modified By		: ..
	    // </summary>
	    //================================================================================================================================================================

	 public boolean EditSet_PreviusORFutureDate(String locatorType, String value, String text)
     {	
			boolean bStatus=false;
			int noOfDays=0;
			String strDate=String.valueOf("");
			String strEdit_Text = String.valueOf("");
			try {
				 	SimpleDateFormat pattern = new SimpleDateFormat("MM/dd/yyyy");
					Calendar calender = Calendar.getInstance();
					calender.setTime(new Date());
					noOfDays = Integer.parseInt(text);
					calender.add(Calendar.DATE, noOfDays );   					 
					strDate = pattern.format(calender.getTime());
					
					By locator;
					locator = locatorValue(locatorType, value);
					WebElement element = driver.findElement(locator);
					Wait(element);
					element.sendKeys(strDate);
					strEdit_Text = element.getAttribute("value");
					 if (strEdit_Text.contains(strDate))
		             {            	 
						 bStatus = true;
		                             
		             }
				
			} catch (NoSuchElementException e) {
				System.err.format("No Element Found to enter text" + e);			
	                              
	         }
			return bStatus;
    		     
     }
	 
	 
	 	//================================================================================================================================================================
	    // <summary>
	    //Function_Name		: ComboBoxSelect
	    //Description		: This function is use to select item from combo box
	    //Created Date		: 
	    //Created by		: EMIDS
	    //Modified Date	: ..
	    //Modified By		: ..
	    // </summary>
	    //================================================================================================================================================================

	 public boolean ComboBoxSelect(String locatorType, String value, String text)
     {	
			boolean bStatus=false;
			String strSelectedValue = String.valueOf("");
			
			try {
				 	
					By locator;
					locator = locatorValue(locatorType, value);
					WebElement element = driver.findElement(locator);
					Select option = new Select(element); 
					Wait(element);
   					option.selectByVisibleText(text);
   					strSelectedValue = option.getFirstSelectedOption().getText();
					 if (strSelectedValue.contains(text))
		             {            	 
						 bStatus = true;
		                             
		             }
				
			} catch (NoSuchElementException e) {
				System.err.format("No Element Found to enter text" + e);			
	                              
	         }
			return bStatus;
    		     
     }
	 
	 	//================================================================================================================================================================
	    // <summary>
	    //Function_Name		: verifyComboBoxSelect
	    //Description		: This function is use to select item from combo box
	    //Created Date		: 
	    //Created by		: EMIDS
	    //Modified Date	: ..
	    //Modified By		: ..
	    // </summary>
	    //================================================================================================================================================================

	 public boolean verifyComboBoxSelect(String locatorType, String value, String text)
  {	
			boolean bStatus=false;
			String strSelectedValue = String.valueOf("");
			
			try {
				 	
					By locator;
					locator = locatorValue(locatorType, value);
					WebElement element = driver.findElement(locator);
					Select option = new Select(element); 
					Wait(element);
					//option.selectByVisibleText(text);
					strSelectedValue = option.getFirstSelectedOption().getText();
					 if (option.getFirstSelectedOption().isSelected())
		             {            	 
						 bStatus = true;
		                             
		             }
				
			} catch (NoSuchElementException e) {
				System.err.format("No Element Found to enter text" + e);			
	                              
	         }
			return bStatus;
 		     
  }
	 
	//================================================================================================================================================================
	    // <summary>
	    //Function_Name		: DropdownSelect
	    //Description		: This function is use to select item from dropdown
	    //Created Date		: 
	    //Created by		: EMIDS
	    //Modified Date	: ..
	    //Modified By		: ..
	    // </summary>
	    //================================================================================================================================================================

	 public boolean DropdownSelect(String locatorType, String value, String text)
  {	
			boolean bStatus=false;
			String strSelectedValue = String.valueOf("");
			
			try {
				 	
					By locator;
					locator = locatorValue(locatorType, value);
					WebElement element = driver.findElement(locator);
					Select option = new Select(element); 
					Wait(element);
					option.selectByVisibleText(text);
					strSelectedValue = option.getFirstSelectedOption().getText();
					 if (strSelectedValue.contains(text))
		             {            	 
						 bStatus = true;
		                             
		             }
				
			} catch (NoSuchElementException e) {
				System.err.format("No Element Found to enter text" + e);			
	                              
	         }
			return bStatus;
 		     
  }
	 

	 
	//================================================================================================================================================================
	    // <summary>
	    //Function_Name		: ToolToWaitInMilliSeconds
	    //Description		: This function is use to wait script for milli seconds based on user input
	    //Created Date		: 
	    //Created by		: EMIDS
	    //Modified Date	: ..
	    //Modified By		: ..
	    // </summary>
	    //================================================================================================================================================================

	 public boolean ToolToWaitInMilliSeconds(String text) throws NumberFormatException, InterruptedException
     {	
			boolean bStatus=false;
			try {
					Thread.sleep(Integer.parseInt(text));				
				 bStatus = true;
			}	
			catch (NoSuchElementException e) {
				System.err.format("No Element Found to enter text" + e);			
	                              
	         }
			return bStatus;
    		     
     }
	
	 
	   //================================================================================================================================================================
	    // <summary>
	    //Function_Name		: CheckBox_RadioButtonSe
	    //Description		: This function is use to check or un check of checkbox and radio button based on user input
	    //Created Date		: 
	    //Created by		: EMIDS
	    //Modified Date	: ..
	    //Modified By		: ..
	    // </summary>
	    //================================================================================================================================================================
 
	 public boolean CheckBox_RadioButtonSet(String locatorType, String value, String text)
     {	
			boolean bStatus=false;			
			boolean status = false;
			
			try {
				 	
					By locator;
					locator = locatorValue(locatorType, value);
					WebElement element = driver.findElement(locator);
					Wait(element);
					status = element.isSelected();
					if (text.toLowerCase().equals("true"))
					{
						if ( String.valueOf(status).toLowerCase().equals("false"))
						{
								element.click();
						}
						
						status = element.isSelected();
						 if (String.valueOf(status).toLowerCase().equals("true"))
			             {            	 
							 bStatus = true;
			                             
			             }
					}
					if (text.toLowerCase().equals("false"))
					{
						if ( String.valueOf(status).toLowerCase().equals("true"))
						{
								element.click();
						}
						
						status = element.isSelected();
						 if (String.valueOf(status).toLowerCase().equals("false"))
			             {            	 
							 bStatus = true;
			                             
			             }
					}
				
			} catch (NoSuchElementException e) {
				System.err.format("No Element Found to enter text" + e);			
	                              
	         }
			return bStatus;
    		     
     }
	 
	 
	 //================================================================================================================================================================
	    // <summary>
	    //Function_Name		: ScrollBarDiv
	    //Description		: This function is use to scroll down of div object
	    //Created Date		: 
	    //Created by		: EMIDS
	    //Modified Date	: ..
	    //Modified By		: ..
	    // </summary>
	    //================================================================================================================================================================
	 public boolean ScrollBarDiv(String locatorType, String value, String text)
     
	 {	
			boolean bStatus=false;			
			  try
			     {
			     	Actions dragger = new Actions(driver);
			     	By locator;
					locator = locatorValue("id","member-agreement");
					WebElement element = driver.findElement(locator);
					Wait(element);
					//element.sendKeys(Keys.ARROW_DOWN);
					//dragger.moveToElement(element).clickAndHold().sendKeys(element, Keys.ARROW_DOWN);
				//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					//  Thread.sleep(500);
			 	dragger.moveToElement(element).clickAndHold().moveByOffset(0,Integer.parseInt(text)).release().perform();
			 	Thread.sleep(500);
			 	bStatus=true;		
			     }
			     catch(Exception ex)
			     {
			     }
			     return bStatus;
     }
	 
	//================================================================================================================================================================
	   // <summary>
	   //Function_Name : scrollBar
	   //Description : This function is use to click on button
	   //Created Date : 
	   //Created by : EMIDS
	   //Modified Date : ..
	   //Modified By : ..
	   // </summary>
	   //================================================================================================================================================================

	public boolean scrollBar(String locatorType, String value,String noOfPixel) {
	boolean bStatus=false;
	int Pixel=Integer.parseInt(noOfPixel);
	try {
	By locator;
	locator = locatorValue(locatorType, value);
	WebElement element = driver.findElement(locator);
	Wait(element);
	Actions act= new Actions(driver);
	       act.moveToElement(element).click();
	       for(int i =0;i<=Pixel;i++){
	        element.sendKeys(Keys.ARROW_RIGHT);
	       }
	bStatus = true;
	          
	} catch (NoSuchElementException e) {
	 
	System.err.format("No Element Found to perform scroll" + e);
	}
	return bStatus;
	}

	 
	 //================================================================================================================================================================
	    // <summary>
	    //Function_Name		: ScrollBarDivHorizontally
	    //Description		: This function is use to scroll horizontally of div object
	    //Created Date		: 
	    //Created by		: EMIDS
	    //Modified Date	: ..
	    //Modified By		: ..
	    // </summary>
	    //================================================================================================================================================================
	 public boolean ScrollBarDivHorizontally(String locatorType, String value, String text)
  
	 {	
			boolean bStatus=false;			
			  try
			     {
			     	Actions dragger = new Actions(driver);
			     	By locator;
					locator = locatorValue("id","member-agreement");
					WebElement element = driver.findElement(locator);
					Wait(element);
					//element.sendKeys(Keys.ARROW_DOWN);
					//dragger.moveToElement(element).clickAndHold().sendKeys(element, Keys.ARROW_DOWN);
				//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					//  Thread.sleep(500);
			 	dragger.moveToElement(element).clickAndHold().moveByOffset(Integer.parseInt(text),0).release().perform();
			 	Thread.sleep(500);
			 	bStatus=true;		
			     }
			     catch(Exception ex)
			     {
			     }
			     return bStatus;
  }
	 
}



























