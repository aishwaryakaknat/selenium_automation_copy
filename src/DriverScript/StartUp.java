//package DriverScript;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.safari.SafariDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//
//
//
//
//
//
//
//
//
//
//import com.keyword.KeywordExecution;
//
//import UtilityLibrary.UtilityLibrary;
//
//
//public class StartUp {
//	
//	public static WebDriver driver;
//	
//	@Parameters({"strBrowserType","strApplicationUrl"})
//	@BeforeTest
//	public void setup(String strBrowserType, String strApplicationUrl) throws Exception{
//		if (strBrowserType.equals("firefox")){
//			driver = new FirefoxDriver();
//			//driver.get(strApplicationUrl);
//			//driver.manage().window().maximize();
//		} else if (strBrowserType.equals("ie")){	
//			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//Browser_Driver//IEDriverServer.exe"); 
//			driver = new InternetExplorerDriver();
//			//driver.get(strApplicationUrl);			
//			//driver.manage().window().maximize();
//			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			
//		}else if (strBrowserType.equals("chrome"))
//		{
//			System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir")+"//Browser_Driver//chromedriver.exe");
//			driver = new ChromeDriver();
//			//driver.get(strApplicationUrl);
//			//driver.manage().window().maximize();
//		}else if (strBrowserType.equals("safari"))
//		{
//			driver = new SafariDriver();
//			//driver.get(strApplicationUrl);
//			//driver.manage().window().maximize();
//		}
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		
//	}
//	
//	
//	
//	@AfterTest
//	public void teardown() throws Exception{
//		driver.quit();
//	}
//	
//	
//	
//	@Parameters({"strBrowserType","strApplicationUrl","strBrowserName"})
//	@Test(threadPoolSize = 1, invocationCount = 1, timeOut = 100000)
//	public void test(String strBrowserType,String strApplicationUrl,String strBrowserName)
//	{
//		
//		try{
//			
//			long startTime = System.currentTimeMillis();			
//			com.keyword.KeyWords key= new com.keyword.KeyWords(driver); 		
//			UtilityLibrary objUtil=new UtilityLibrary();
//			String projectPath = System.getProperty("user.dir");
//			Properties prop=objUtil.ReadDataFromPropertiesFile(projectPath + "/src/AppConfig.properties");	
//			
//			String strSanitySuit=prop.getProperty("strSanitySuit");	
//			String strSuitToExecute=null;
//			
//			String strWriteDetailLogHtmlFilePath = String.valueOf("");
//			String strWriteMainLogFilePath =String.valueOf("");
//			// User can choose either sanity or regression suit to execute, not both.
//				if(strSanitySuit.contains("Yes"))
//				{
//					strSuitToExecute="Sanity";
//				}
//				else
//				{
//					strSuitToExecute="Regression";
//				}
//				List<String> objMylist = new ArrayList<String>(); // using this object to read test step pass status to store
//		
//				int intTestStepPassCount = 0;                                                                   // used to store step pass count
//				int intTestStepFailCount = 0;   
//				int intTCPassCount = 0;
//		        int intTCFailCount = 0;
//		        int intTCNotRunCount = 0;
//		        String strScenarioResultsStatus = String.valueOf(" ");  
//		      
//	        if (strSuitToExecute != null && !strSuitToExecute.isEmpty())
//	        {
//	            String strTestResultFolderPath1 = objUtil.CreateFolderWithUserDefineNameAndTime(projectPath + "//src//TestResultsUserDefine//"+(System.getProperty("user.name")));
//	        	
//	        	String strTestResultFolderPath = objUtil.CreateFolderWithUserDefineNameAndTime(strTestResultFolderPath1+"//"+strBrowserName);
//	        	
//	        	String strModuleFolderPath = projectPath + "//src//MODULES//";
//				
//	        	String strModuleDataContent = objUtil.ReadFileData(strModuleFolderPath,"ModuleList");
//				
//	        	String[] strArrayModuleCollection = strModuleDataContent.split(",");
//	        	
//	        	
//	        	
//	        	String strModuleWiseResultPath= String.valueOf("");
//	           for (int intModulesFileCount=2; intModulesFileCount<=strArrayModuleCollection.length; intModulesFileCount+=3)// user need to provide loop count based on no of columns created in Module file(.csv file)
//	            {
//	        		String strProjectName=      strArrayModuleCollection[intModulesFileCount];  
//	                String ModuleName =         strArrayModuleCollection[intModulesFileCount + 1];              
//	                String ExecutionCondition = strArrayModuleCollection[intModulesFileCount + 2];       
//	                if (ExecutionCondition.toLowerCase().contains("yes"))
//	                {
//	                	int strTestcaseCount= 0;
//	                	strModuleWiseResultPath=objUtil.InitializeModuleWiseHtmlresult(strProjectName, strApplicationUrl, strSuitToExecute, strTestResultFolderPath, strBrowserName);
//	                	String strSnapFolderPath = objUtil.CreateFolderWithUserDefineNameAndTime(projectPath + "//src//SnapShot//"+ModuleName );
//	                	String strModuleNameResultFolderPath = objUtil.CreateFolderWithUserDefineNameAndTime(strTestResultFolderPath + "//"+ModuleName);
//	                	strWriteDetailLogHtmlFilePath = objUtil.Initializehtml(strProjectName, strApplicationUrl, ModuleName, strSuitToExecute, strModuleNameResultFolderPath,"Detailed",strBrowserName);
//	                	strWriteMainLogFilePath = objUtil.InitializeMainresult(strProjectName, strApplicationUrl, ModuleName, strSuitToExecute, strModuleNameResultFolderPath,"TestCase Wise",strBrowserName);
//	                	String strScenarioDataContent = objUtil.ReadFileData(projectPath + "//src//TESTSCENARIO//TestScenario_" +strSuitToExecute+"_" , ModuleName );
//	                	String[] strArrayScenarioCollection = strScenarioDataContent.split(",");
//	                    for (int intTestScenarioFileCount = 1; intTestScenarioFileCount < strArrayScenarioCollection.length ; intTestScenarioFileCount += 3)// user need to provide loop count based on no of columns created in TestScenario file(in .csv file)
//	                     {
//	                    	
//	                    	 String TSID = strArrayScenarioCollection[intTestScenarioFileCount];
//	                         String ScenarioName= strArrayScenarioCollection[intTestScenarioFileCount + 1];                      
//	                         String TSExecutionCondition = strArrayScenarioCollection[intTestScenarioFileCount + 2];
//	                         if (TSExecutionCondition.toLowerCase().contains("yes"))
//	                         { 
//	                        	 startTime = System.currentTimeMillis();
//	                        	 String TCID = String.valueOf("");
//	                        	 String strTestCaseStepDataContent = objUtil.ReadFileData(projectPath + "//src//InputFile//InputFile_" + strSuitToExecute + "_", ModuleName );
//	                        	 
//	                             String[] strArrayStepCollection = strTestCaseStepDataContent.split(",");
//	                             for (int intInputFileCount = 1; intInputFileCount < strArrayStepCollection.length; intInputFileCount += 9) // user need to provide loop count based on no of columns created in InputFile( in .csv file).
//	                             { 
//	                            	 String TCScenarioName = String.valueOf("");	
//	                            	 String TCSteps = String.valueOf("");	
//	                            	 String TCKeyFunction =String.valueOf("");	
//	                            	 String TCExecutionCondition = String.valueOf("");	                            	 
//	                            	 String ObjectProperty_Name =String.valueOf("");	
//	                            	 String ObjectProperty_Value = String.valueOf("");	
//	                            	 String Object_TestData = String.valueOf("");	
//	                            	 
//	                            	 String strTestStepResultStatus = String.valueOf("");	
//	                            	 boolean strTestStepResult = false;
//	                            	 
//	                            	 TCID = strArrayStepCollection[intInputFileCount];
//	                                 if (TSID.contains(TCID))
//	                                 {                                	 
//	                                	 TCScenarioName = strArrayStepCollection[intInputFileCount + 1];                                     
//	                                     TCSteps = strArrayStepCollection[intInputFileCount + 2]; 
//	                                     TCKeyFunction = strArrayStepCollection[intInputFileCount + 3];
//	                                     TCExecutionCondition = strArrayStepCollection[intInputFileCount + 4];  
//	                                     if (intInputFileCount + 6 < strArrayStepCollection.length) 
//	                                     {
//	                                    	 ObjectProperty_Name = strArrayStepCollection[intInputFileCount + 6];
//	                                    	 
//	                                     }
//	                                     if (intInputFileCount + 7 < strArrayStepCollection.length) 
//	                                     {
//	                                    	 ObjectProperty_Value = strArrayStepCollection[intInputFileCount + 7];
//	                                     }
//	                                     if ( intInputFileCount + 8 < strArrayStepCollection.length & !strArrayStepCollection[intInputFileCount + 8].isEmpty() ) 
//	                                     {
//	                                    	 Object_TestData = strArrayStepCollection[intInputFileCount + 8];
//	                                     }
//	                                     if (TCExecutionCondition.toLowerCase().contains("yes"))
//	                                     {
//	                                    	 KeywordExecution exeKey=new KeywordExecution();
//	                                    	
//	                                    	 List<Object> myParamList = new ArrayList<Object>();
//
//	                                    	 String methodName = TCKeyFunction;
//	                                    		
//	                                    	 if (!strArrayStepCollection[intInputFileCount + 6].isEmpty())
//                                    		 {
//	                                    	 	myParamList.add(ObjectProperty_Name);
//                                    		 }
//	                                    	 if (!strArrayStepCollection[intInputFileCount + 7].isEmpty())
//                                    		 {
//	                                    		 myParamList.add(ObjectProperty_Value);
//                                    		 }
//	                                    	 if (!strArrayStepCollection[intInputFileCount + 8].isEmpty())
//                                    		 {  
//	                                    		myParamList.add(Object_TestData);
//                                    		 }	                                    	 
//	                                    	 			
//	                                    	 Object[] paramListObject = new String[myParamList.size()];
//	                                    	 paramListObject = myParamList.toArray(paramListObject);
//	                                    	 strTestStepResult= exeKey.runReflectionMethod(key,"com.keyword.KeyWords",	methodName, paramListObject);
//	                                    	 
//	                                    	 if (String.valueOf(strTestStepResult).equals("true"))
//	                                    	 {
//	                                    		 strTestStepResultStatus = "Pass";
//	                                    		 objUtil.addrow(strWriteDetailLogHtmlFilePath,  TCID, TCScenarioName, TCSteps,TCKeyFunction,Object_TestData,strTestStepResultStatus,"","");
//		                                   	 }
//	                                    	 else
//	                                    	 {
//	                                    		 strTestStepResultStatus = "Fail";
//	                                    		 String strSnapPath= key.SnapShot(strSnapFolderPath, ModuleName, TCKeyFunction,strBrowserName);
//	                                    		 objUtil.addrow(strWriteDetailLogHtmlFilePath,  TCID, TCScenarioName, TCSteps,TCKeyFunction,Object_TestData,strTestStepResultStatus,strSnapPath,"");
//		                                	 }
//	                                       	
//	                                     }
//	                                   
//	                                     if (strTestStepResultStatus.contains("Pass"))
//	                                     {
//	                                         intTestStepPassCount = intTestStepPassCount + 1;
//	                                     }
//	                                     else if (strTestStepResultStatus.contains("Fail"))
//	                                     {
//	                                         intTestStepFailCount = intTestStepFailCount + 1;
//	                                     }
//	                                 }
//	                             }
//	                             if ( !TSID.equals(TCID))
//	                             {  
//	                                 if (intTestStepFailCount > 0)
//	                                 {                                	
//	                                     strScenarioResultsStatus = "Fail";
//	                                 }
//	                                 else if (intTestStepPassCount > 0)
//	                                 {                                	 
//	                                     strScenarioResultsStatus = "Pass";
//	                                 }
//	                                 objMylist.add(strScenarioResultsStatus); 
//	                                 intTestStepFailCount = 0;
//	                                 intTestStepPassCount = 0;                                 
//	                             }
//	                         }
//	                        if (TSExecutionCondition.toLowerCase().contains("no"))
//			                {
//			                   	 strScenarioResultsStatus = "No Run";
//			                }
//	                        if (strScenarioResultsStatus.equals("Pass"))
//	                        {
//	                        	intTCPassCount = intTCPassCount+1;
//	                        }
//	                        else if (strScenarioResultsStatus.equals("Fail"))
//	                        {
//	                        	intTCFailCount = intTCFailCount +1;
//	                        }
//	                        else if (strScenarioResultsStatus.equals("No Run"))
//	                        {
//	                        	intTCNotRunCount = intTCNotRunCount +1;
//	                        }
//	                        
//	                        long endTime = System.currentTimeMillis(); 
//	            			float seconds = (endTime - startTime) / 1000F; 
//	            			
//	            			if (strScenarioResultsStatus.equals("No Run"))
//	                        {
//	            				seconds = 0;
//	                        }
//	            			
//	            			if (!ScenarioName.isEmpty())
//	            			{
//	            				strTestcaseCount= strTestcaseCount+1;
//	            			}
//	                        objUtil.addrowMainresult(strWriteMainLogFilePath,TSID, ScenarioName, strScenarioResultsStatus,String.valueOf(seconds));
//	                        
//	                   	 	
//	                     }
//	                
//	                objUtil.addrowModuleWisehtmlresult(strModuleWiseResultPath, ModuleName,Integer.toString(strTestcaseCount), Integer.toString(intTCPassCount), Integer.toString(intTCFailCount), Integer.toString(intTCNotRunCount));
//	                }
//	               
//	            }
//	           objUtil.SendMail(strModuleWiseResultPath,"Module wise Results of "+strBrowserName+ "_Browser");
//	           
//	        }
//		
//
//
//	}
//	catch(Exception e)
//	{
//		
//	}
//	}
//	
//	
//}
//
//
//
package DriverScript;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




import com.keyword.KeywordExecution;

import UtilityLibrary.UtilityLibrary;


public class StartUp{
	
	public static WebDriver driver;
	
	@Parameters({"strBrowserType","strApplicationUrl"})
	@BeforeTest
	public void setup(String strBrowserType, String strApplicationUrl) throws Exception{
		if (strBrowserType.equals("firefox")){
			driver = new FirefoxDriver();
			//driver.get(strApplicationUrl);
			//driver.manage().window().maximize();
		} else if (strBrowserType.equals("ie")){	
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//Browser_Driver//IEDriverServer.exe"); 
			driver = new InternetExplorerDriver();
//			driver.get(strApplicationUrl);			
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}else if (strBrowserType.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir")+"//Browser_Driver//chromedriver.exe");
			driver = new ChromeDriver();
//			driver.get(strApplicationUrl);
//			driver.manage().window().maximize();
		}else if (strBrowserType.equals("safari"))
		{
			driver = new SafariDriver();
//			driver.get(strApplicationUrl);
//			driver.manage().window().maximize();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	
	@AfterTest
	public void teardown() throws Exception{
		driver.quit();
	}
	
	
	@Parameters({"strPlatform","strApplicationUrl","strBrowserName"})
	@Test(threadPoolSize = 1, invocationCount = 1, timeOut = 100000)
	public void test(String strPlatform,String strApplicationUrl,String strBrowserName)
	{
		
		try{
			Properties OR = null;
			long startTime = System.currentTimeMillis();			
			com.keyword.KeyWords key= new com.keyword.KeyWords(driver); 		
			UtilityLibrary objUtil=new UtilityLibrary();
			String projectPath = System.getProperty("user.dir");
			Properties prop=objUtil.ReadDataFromPropertiesFile(projectPath + "/src/AppConfig.properties");	
			if(strPlatform.equalsIgnoreCase("RoR")){
				 OR = objUtil.ReadDataFromPropertiesFile(projectPath + "/src/Repositories/OR_RoR.properties");
			}else if(strPlatform.equalsIgnoreCase("DotNet")){
				 OR = objUtil.ReadDataFromPropertiesFile(projectPath + "/src/Repositories/OR_DotNet.properties");
			}
			
			
			String strSanitySuit=prop.getProperty("strSanitySuit");	
			String strSuitToExecute=null;
			
			String strWriteDetailLogHtmlFilePath = String.valueOf("");
			String strWriteMainLogFilePath =String.valueOf("");
			// User can choose either sanity or regression suit to execute, not both.
				if(strSanitySuit.contains("Yes"))
				{
					strSuitToExecute="Sanity";
				}
				else
				{
					strSuitToExecute="Regression";
				}
				List<String> objMylist = new ArrayList<String>(); // using this object to read test step pass status to store
		
				int intTestStepPassCount = 0;                                                                   // used to store step pass count
				int intTestStepFailCount = 0;   
				int intTCPassCount = 0;
		        int intTCFailCount = 0;
		        int intTCNotRunCount = 0;
		        String strScenarioResultsStatus = String.valueOf(" ");  
		      
	        if (strSuitToExecute != null && !strSuitToExecute.isEmpty())
	        {
	            String strTestResultFolderPath1 = objUtil.CreateFolderWithUserDefineNameAndTime(projectPath + "//src//TestResultsUserDefine//"+(System.getProperty("user.name")));
	        	String strTestResultFolderPath = objUtil.CreateFolderWithUserDefineNameAndTime(strTestResultFolderPath1+"//"+strBrowserName);
	        	
	        	Object [][] arrModulelistdata = UtilityLibrary.getData("Modules");

	        	String strModuleWiseResultPath= String.valueOf("");
	            for (int intModulesFileCount=1; intModulesFileCount<arrModulelistdata.length; intModulesFileCount++)
	            {		
	        		String strProjectName=      (String) arrModulelistdata[intModulesFileCount][1];  
	                String ModuleName =         (String) arrModulelistdata[intModulesFileCount][2];              
	                String ExecutionCondition = (String) arrModulelistdata[intModulesFileCount][3];       
	                
	                if (ExecutionCondition.toLowerCase().contains("yes"))
	                {
	                	int strTestcaseCount= 0;
	                	strModuleWiseResultPath=objUtil.InitializeModuleWiseHtmlresult(strProjectName, strApplicationUrl, strSuitToExecute, strTestResultFolderPath, strBrowserName);
	                	String strSnapFolderPath = objUtil.CreateFolderWithUserDefineNameAndTime(projectPath + "//src//SnapShot//"+ModuleName );
	                	String strModuleNameResultFolderPath = objUtil.CreateFolderWithUserDefineNameAndTime(strTestResultFolderPath + "//"+ModuleName);
	                	strWriteDetailLogHtmlFilePath = objUtil.Initializehtml(strProjectName, strApplicationUrl, ModuleName, strSuitToExecute, strModuleNameResultFolderPath,"Detailed",strBrowserName);
	                	strWriteMainLogFilePath = objUtil.InitializeMainresult(strProjectName, strApplicationUrl, ModuleName, strSuitToExecute, strModuleNameResultFolderPath,"TestCase Wise",strBrowserName);
	                	
	                	Object [][] arrScenariolistdata = UtilityLibrary.getData("Scenarios_"+ ModuleName);

	                	int intTestScenarioFileCount;
	                	for (intTestScenarioFileCount = 1; intTestScenarioFileCount < arrScenariolistdata.length ; intTestScenarioFileCount++)// user need to provide loop count based on no of columns created in TestScenario file(in .csv file)
	                     {
	                    	 String TSID = 					(String) arrScenariolistdata[intTestScenarioFileCount][0];
	                         String ScenarioName= 			(String) arrScenariolistdata[intTestScenarioFileCount][1];                      
	                         String TSExecutionCondition = 	(String) arrScenariolistdata[intTestScenarioFileCount][2];
	                         
	                         if (TSExecutionCondition.toLowerCase().contains("yes"))
	                         { 
	                        	startTime = System.currentTimeMillis();
	                        	String TCID = String.valueOf("");

	                        	Object [][] arrStepslistdata = UtilityLibrary.getData("Steps_"+ ModuleName);
	     	    	        	
	                        	 int intInputFileCount;
	                             for (intInputFileCount = 1; intInputFileCount < arrStepslistdata.length; intInputFileCount++) // user need to provide loop count based on no of columns created in InputFile( in .csv file).
	                             { 
	                            	 String TCScenarioName = String.valueOf("");	
	                            	 String TCSteps = String.valueOf("");	
	                            	 String TCKeyFunction =String.valueOf("");	
	                            	 String TCExecutionCondition = String.valueOf("");	                            	 
	                            	 String ObjectProperty_Name =String.valueOf("");	
	                            	 String ObjectProperty_Value = String.valueOf("");	
	                            	 String Object_TestData = String.valueOf("");
	                            	 
	                            	 String Object_Name = (String) arrStepslistdata[intInputFileCount][5];
	                            	 String strTestStepResultStatus = String.valueOf("");	
	                            	 boolean strTestStepResult = false;
	                            	 TCID = (String) arrStepslistdata[intInputFileCount][0];
	                                 if (TSID.contains(TCID))
	                                 {                                	 
	                                	 TCScenarioName = 			(String) arrStepslistdata[intInputFileCount][1];                                     
	                                     TCSteps = 					(String) arrStepslistdata[intInputFileCount][2]; 
	                                     TCKeyFunction = 			(String) arrStepslistdata[intInputFileCount][3];
	                                     TCExecutionCondition = 	(String) arrStepslistdata[intInputFileCount][4];  
	                                     
	                                     if(!arrStepslistdata[intInputFileCount][5].toString().isEmpty())
	                                     {
	                                    	 String[] Identifiers = Object_Name.split("_");
	                                    	 ObjectProperty_Name = Identifiers[1];
	                                    	 ObjectProperty_Value = OR.getProperty(Object_Name);
	                                     }
	                                     if (!arrStepslistdata[intInputFileCount][6].toString().isEmpty()) 
	                                     {
	                                    	 Object_TestData = (String) arrStepslistdata[intInputFileCount][6];
	                                     }
	                                     if (TCExecutionCondition.toLowerCase().contains("yes"))
	                                     {
	                                    	 KeywordExecution exeKey=new KeywordExecution();
	                                    	
	                                    	 List<Object> myParamList = new ArrayList<Object>();

	                                    	 String methodName = TCKeyFunction;
	                                    	 
	                                    	 if(!arrStepslistdata[intInputFileCount][5].toString().isEmpty())
                                    		 {
	                                    	 	myParamList.add(ObjectProperty_Name);
	                                    	 	myParamList.add(ObjectProperty_Value);
                                    		 }
	                                    	 if(!arrStepslistdata[intInputFileCount][6].toString().isEmpty())
                                    		 {  
	                                    		myParamList.add(Object_TestData);
                                    		 }	                                    	 
	                                    	 			
	                                    	 Object[] paramListObject = new String[myParamList.size()];
	                                    	 paramListObject = myParamList.toArray(paramListObject);
	                                    	 strTestStepResult= exeKey.runReflectionMethod(key,"com.keyword.KeyWords",	methodName, paramListObject);

	                                    	 if (String.valueOf(strTestStepResult).equals("true"))
	                                    	 {
	                                    		 strTestStepResultStatus = "Pass";
	                                    		 objUtil.addrow(strWriteDetailLogHtmlFilePath,  TCID, TCScenarioName, TCSteps,TCKeyFunction,Object_TestData,strTestStepResultStatus,"","");
		                                   	 }
	                                    	 else
	                                    	 {
	                                    		 strTestStepResultStatus = "Fail";
	                                    		 String strSnapPath= key.SnapShot(strSnapFolderPath, ModuleName, TCKeyFunction,strBrowserName);
	                                    		 objUtil.addrow(strWriteDetailLogHtmlFilePath,  TCID, TCScenarioName, TCSteps,TCKeyFunction,Object_TestData,strTestStepResultStatus,strSnapPath,"");
		                                	 }
	                                       	
	                                     }
	                                   
	                                     if (strTestStepResultStatus.contains("Pass"))
	                                     {
	                                         intTestStepPassCount = intTestStepPassCount + 1;
	                                     }
	                                     else if (strTestStepResultStatus.contains("Fail"))
	                                     {
	                                         intTestStepFailCount = intTestStepFailCount + 1;
	                                     }
	                                 }
	                             }
	                             if(intInputFileCount==arrStepslistdata.length)
	                             //if ( !TSID.equals(TCID))
	                             {  
	                                 if (intTestStepFailCount > 0)
	                                 {                                	
	                                     strScenarioResultsStatus = "Fail";
	                                 }
	                                 else if (intTestStepPassCount > 0)
	                                 {                                	 
	                                     strScenarioResultsStatus = "Pass";
	                                 }
	                                 objMylist.add(strScenarioResultsStatus); 
	                                 intTestStepFailCount = 0;
	                                 intTestStepPassCount = 0;                                 
	                             }
	                         }
	                        if (TSExecutionCondition.toLowerCase().contains("no"))
			                {
			                   	 strScenarioResultsStatus = "No Run";
			                }
	                        if (strScenarioResultsStatus.equals("Pass"))
	                        {
	                        	intTCPassCount = intTCPassCount+1;
	                        }
	                        else if (strScenarioResultsStatus.equals("Fail"))
	                        {
	                        	intTCFailCount = intTCFailCount +1;
	                        }
	                        else if (strScenarioResultsStatus.equals("No Run"))
	                        {
	                        	intTCNotRunCount = intTCNotRunCount +1;
	                        }
	                        
	                        long endTime = System.currentTimeMillis(); 
	            			float seconds = (endTime - startTime) / 1000F; 
	            			
	            			if (strScenarioResultsStatus.equals("No Run"))
	                        {
	            				seconds = 0;
	                        }
	            			
	            			if (!ScenarioName.isEmpty())
	            			{
	            				strTestcaseCount= strTestcaseCount+1;
	            			}
	                        objUtil.addrowMainresult(strWriteMainLogFilePath,TSID, ScenarioName, strScenarioResultsStatus,String.valueOf(seconds));
	                        
	                   	 	
	                     }
	                
	                objUtil.addrowModuleWisehtmlresult(strModuleWiseResultPath, ModuleName,Integer.toString(strTestcaseCount), Integer.toString(intTCPassCount), Integer.toString(intTCFailCount), Integer.toString(intTCNotRunCount));
	                }
	               
	            }
	           //objUtil.SendMail(strModuleWiseResultPath,"Module wise Results of "+strBrowserName+ "_Browser");
	           System.out.println("Done");
	        }
		


	}
	catch(Exception e)
	{
		System.out.println("Fail");
	}
		
	}
	
	
}



