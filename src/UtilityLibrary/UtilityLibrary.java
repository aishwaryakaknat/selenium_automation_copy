package UtilityLibrary;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Properties;
//
//import javax.activation.DataHandler;
//import javax.activation.DataSource;
//import javax.activation.FileDataSource;
//import javax.mail.BodyPart;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Multipart;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//
//
//
//
//
//
//public class UtilityLibrary {
//
//	String strSnapPath =String.valueOf(" ");
//	//public static Generic objGeneric=new Generic();
//	
//	
//	
//	public Properties ReadDataFromPropertiesFile(String filePath)
//	{ 	
//		File file = new File(filePath);		  
//		FileInputStream fileInput = null;
//		try 
//		{
//			fileInput = new FileInputStream(file);
//		} 
//		catch (FileNotFoundException e) 
//		{
//			e.getMessage();
//		}
//		Properties prop = new Properties();			
//		//load properties file
//		try
//		{
//			prop.load(fileInput);
//		} 
//		catch (IOException e) 
//		{
//			e.getMessage();
//		}
//		return prop;
//	}
//	
//	// public String CreateFolderWithUserDefineNameAndTime(String strAutomationFolderPath,String strBrowserName)
//	public String CreateFolderWithUserDefineNameAndTime(String strAutomationFolderPath)
//     
//	{
//		 
//		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
//		Date dateobj = new Date();
//		String strMainString=df.format(dateobj).replace("/","").replace(":", "").replace(" ","");
//        //String strPathToCreateSubFolder = strAutomationFolderPath +"_"+strBrowserName  + "_"+strMainString.trim();
//        
//		String strPathToCreateSubFolder = strAutomationFolderPath +"_"+strMainString.trim();
//		File file=new File(strPathToCreateSubFolder);
//        file.mkdir();       
//        return strPathToCreateSubFolder;
//     }
//	 
//	 
//	 
//	 
//	
//		 
//	 public String ReadFileData(String strFilePath, String strFileName)
//     {
//		 String strReadLineDataContent = String.valueOf(" ");
//			BufferedReader bufferedReader = null;
//			    try { 
//				       String csvFile = strFilePath+strFileName +".csv";
//				       
//				       //create BufferedReader to read csv file
//				       bufferedReader = new BufferedReader(new FileReader(csvFile));
//				       String line = "";
//				       bufferedReader.readLine(); //skips the first row				      
//				   
//				      while ((line = bufferedReader.readLine()) != null) {	
//				    	  strReadLineDataContent = strReadLineDataContent + ","+line.replace("\"","");	
//				       }
//				      bufferedReader.close();
//				     
//				       } catch (Exception e) {
//				       System.err.println("CSV file cannot be read : " + e);
//				     }
//         
//			    return strReadLineDataContent;
//         
//     }
//     
//	
//	
//	 
//	 public String CreateWriteLog(String strProjectName, String strURL, String strModuleName, String strSuitToExecute, String strTestResultFolderPath,String strBrowserName)
//     { 
//		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
//		Date dateobj = new Date();
//		String strMainString=df.format(dateobj);
//		String strDateString=strMainString.replace("/","_").replace(":", "_");
//        String strFilePath = strTestResultFolderPath + "//" + strModuleName + "_" + strSuitToExecute + "Result"+strDateString+".csv";
//        FileWriter writer;
//		try 
//		{		
//			
//			
//			writer = new FileWriter(strFilePath,true);
//			writer.append(',');
//		    writer.append(strProjectName +"- TestRunResults -"+" - "+strBrowserName + strMainString);
//		    writer.append('\n');
//	        writer.append('\n');
//	        writer.append("Automation Tool Name :");
//	        writer.append(',');
//	        writer.append("Selenium");
//	        writer.append('\n');
//	        writer.append("OS Version :");
//	        writer.append(',');
//	        writer.append(System.getProperty("os.version"));
//	        writer.append('\n');
//	        writer.append("UserName :");
//	        writer.append(',');
//	        writer.append(System.getProperty("user.name"));
//	        writer.append('\n');
//	        writer.append("ModuleName :");
//	        writer.append(',');
//	        writer.append(strModuleName);
//	        writer.append('\n');
//	        writer.append("Build URL :");
//	        writer.append(',');
//	        writer.append(strURL);
//	        writer.append('\n');
//	        writer.append('\n');
//	        writer.append('\n');
//	        writer.append('\n');
//	        writer.append("TCID");
//	        writer.append(',');
//	        writer.append("TestScenario");
//	        writer.append(',');
//	        writer.append("TestStep");
//	        writer.append(',');
//	        writer.append("KeyMethod");
//	        writer.append(',');     
//	        writer.append("TestData");
//	        writer.append(',');
//	        writer.append("Result");
//	        writer.append(',');
//	        writer.append("ExecutionTime");
//	        writer.append(',');
//	        writer.append("ErrorSanpFilePath(for failed Testcase)");
//	        writer.append(',');
//	        writer.append("ErrorMessage");
//	        writer.append(',');
//	        writer.flush();
//	        writer.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//         return strFilePath;
//     }
//     
//	 							
//	 public String ResultWriteToFile(String strFilePath, String strTCID, String strScenarioName, String strStep, String strKeyFunction, String strTestData,String strResult,String strSnapFolderPath,String strModuleName,String strErrorMessage)
//     {
//		 String strSnapPath =String.valueOf(" ");   
//         String strResult_Status =String.valueOf(" ");         
//         FileWriter writer;
//        
//         DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
// 	     Date dateobj = new Date();
// 		 String strMainString=df.format(dateobj);
// 		 
// 		try 
// 		{	
// 			if (strResult.contains("Pass"))
// 			{
// 				strResult_Status = "Pass"; 				
// 			}
// 			else if (strResult.contains("Fail"))
// 			{
// 				strResult_Status = "Fail"; 
// 				//strSnapPath =Generic.SnapShot(strSnapFolderPath,strModuleName,strKeyFunction);
// 			}
// 			writer = new FileWriter(strFilePath,true);
// 			writer.append('\n');
// 			writer.append(strTCID);
// 			writer.append(','); 		
// 			writer.append(strScenarioName);
// 			writer.append(',');
// 			writer.append(strStep);
// 			writer.append(',');
// 			writer.append(strKeyFunction);
// 			writer.append(',');
// 			writer.append(strTestData);
// 			writer.append(',');
// 			writer.append(strResult_Status);
// 			writer.append(',');
// 			writer.append(strMainString);
// 			writer.append(',');
// 			writer.append(strSnapPath); 
// 			writer.append(',');
// 			writer.append(strErrorMessage);
// 			writer.flush();
// 			writer.close();
// 			
//     } catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}    
// 		return strSnapPath;
// 		
//                   
//     }
//	 
//	 public String Initializehtml(String strProjectName, String strURL, String strModuleName, String strSuitToExecute, String strTestResultFolderPath,String strReportType,String strBrowserName)
//     {
//		 String htmlfilepath = String.valueOf(" ");
//		 try
//		 {
//		 		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
//		 		Date dateobj = new Date();
//		 		String strMainString=df.format(dateobj);
//		 		htmlfilepath = strTestResultFolderPath + "//" + strModuleName + "_" + strSuitToExecute + strReportType + "_Result"+System.nanoTime()+".html";
//			    FileWriter f = new FileWriter(htmlfilepath, true);
//			    BufferedWriter br = new BufferedWriter(f);
//			    
//			    br.write("<html>");
//	            br.write("<head>");
//	            br.write(" <style type=text/css>");
//	            br.write("body {color: #003366;background-color: #FFFFFF;font-family: Verdana, Tahoma, sans-serif;font-size: 10px;}");
//	            br.write("table {line-height: 10pt;width: 100%;}tr {background-color: #ccccff;}.header_table{border: 1pt inset #00008b;}td {padding: 0.1cm 0.2cm;vertical-align: top;}");
//	            br.write(".h1center {font-size: 10pt;font-weight: bold;text-align: left;width: 80%;}.header_table{border: 1pt inset #00008b;}");
//	            br.write(".header_table{border: 1pt inset #00008b;}.narr_table {width: 100%;}.narr_tr {background-color: #ADD8E6;border: 1pt inset #00008b}.narr_th {background-color: #ADD8E6;}");
//	            br.write(".fontforStyling{FONT-WEIGHT: normal! important; FONT-SIZE: 11px! important; LINE-HEIGHT: normal! important; FONT-STYLE: normal! important; FONT-VARIANT: normal! important;font-weight: bold;text-align: left}");
//	            br.write("</style>");
//	            br.write("<title>");
//	            br.write("Test Run Results");
//	            br.write("</title>");
//	            br.write("</head>");
//	          //  br.write("<body bgcolor=#FFFFFF align=center><center><b><i><font size=3 color=#6E6E6E> <u><font color=#8A0808> ONLIFE HEALTH</font>  <font color=#8A0808>A</font>utomation <font color=#8A0808>F</font>ramework <font color=#8A0808></u></font></i></b> </center><font size=2><p>");
//	            br.write("<table class=narr_table");
//	            br.write("style='border: solid 2px'>");
//	            br.write("<th class=narr_th align='center' valign='bottom'  bgColor='#ADD8E6' ><b><font color=#C11B17><br></br>");
//	            br.write(strProjectName +" - Automation Test Scripts Execution Results (" + strBrowserName +")");
//	            br.write("<br></br></th>");
//	            br.write("</style>");
//	            br.write("</table>");
//	            //---------------------------
//	            
//	         
//	            br.write("<table border: solid 2px width='100%' bgColor='#ffd700'> ");
//	            br.write("<tr class=narr_tr><font-size: 12px><b>");
//	            br.write("Project Name:" + strProjectName);
//	            br.write("</tr>");
//
//	            br.write("<tr class=narr_tr >");
//	            br.write("ModuleName:" + "  " + strModuleName);
//	            br.write("</tr>");
//	          
//	            br.write("<tr class=narr_tr >");	            
//	            br.write("Build URL:" + "  " + strURL);
//	        
//	            br.write("<tr class=narr_tr >");
//	            br.write("Run Started on : "+ strMainString);
//	            br.write("</tr>");
//	            br.write("</b>");
//	            br.write("</table>");
//	            //---------------------------
//	            
//	            
//	            br.write("<table border:1px solid ; width=100% style='table-layout: fixed'; font-size: 12px>");
//	            
//	            //Create Header Row
//	            br.write("<tr align='left' valign='top'; style='font-size: 12px';>");	          
//	           
//	            
//	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
//	                br.write("TCID");
//	                br.write("</td>");
//	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
//	                br.write("TestScenario");
//	                br.write("</td>");
//	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
//	                br.write("TestStep");
//	                br.write("</td>");
//	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
//	                br.write("KeyMethod");
//	                br.write("</td>");
//	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
//	                br.write("TestData");
//	                br.write("</td>");
//	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
//	                br.write("Result");
//	                br.write("</td>");
//	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
//	                br.write("ExecutionTime");
//	                br.write("</td>");
//	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
//	                br.write("SanpFilePath");
//	                br.write("</td>");
//	               
//	                
//	            br.write("</tr>");
// 			    br.close();
//			   
//		 }
//		 catch(Exception ex)
//		 {
//			 
//		 }
//		 return htmlfilepath;
//}
//	 
//
//	 public String InitializeMainresult(String strProjectName, String strURL, String strModuleName, String strSuitToExecute, String strTestResultFolderPath,String strReportType,String strBrowserName)
//     {
//		 String htmlfilepath = String.valueOf(" ");
//		 try
//		 {
//			 	htmlfilepath = strTestResultFolderPath + "//" + strModuleName + "_" + strSuitToExecute + strReportType + "_Result"+System.nanoTime()+".html";
//				FileWriter f = new FileWriter(htmlfilepath, true);
//			    BufferedWriter br = new BufferedWriter(f);
//			    
//			    br.write("<html>");
//	            br.write("<head>");
//	            br.write(" <style type=text/css>");
//	            br.write("body {color: #003366;background-color: #FFFFFF;font-family: Verdana, Tahoma, sans-serif;font-size: 10px;}");
//	            br.write("table {line-height: 10pt;width: 100%;}tr {background-color: #ccccff;}.header_table{border: 1pt inset #00008b;}td {padding: 0.1cm 0.2cm;vertical-align: top;}");
//	            br.write(".h1center {font-size: 10pt;font-weight: bold;text-align: left;width: 80%;}.header_table{border: 1pt inset #00008b;}");
//	            br.write(".header_table{border: 1pt inset #00008b;}.narr_table {width: 100%;}.narr_tr {background-color: #ADD8E6;border: 1pt inset #00008b}.narr_th {background-color: #ADD8E6;}");
//	            br.write(".fontforStyling{FONT-WEIGHT: normal! important; FONT-SIZE: 11px! important; LINE-HEIGHT: normal! important; FONT-STYLE: normal! important; FONT-VARIANT: normal! important;font-weight: bold;text-align: left}");
//	            br.write("</style>");
//	            br.write("<title>");
//	            br.write("Test Run Results");
//	            br.write("</title>");
//	            br.write("</head>");
//	          //  br.write("<body bgcolor=#FFFFFF align=center><center><b><i><font size=3 color=#6E6E6E> <u><font color=#8A0808> ONLIFE HEALTH</font>  <font color=#8A0808>A</font>utomation <font color=#8A0808>F</font>ramework <font color=#8A0808></u></font></i></b> </center><font size=2><p>");
//	            br.write("<table class=narr_table");
//	            br.write("style='border: solid 2px'>");
//	            br.write("<th class=narr_th align='center' valign='bottom'  bgColor='#ADD8E6' ><b><font color=#C11B17><br></br>");
//	            br.write(strProjectName +" - Automation Test Scripts Execution Results (" + strBrowserName +")");
//	            br.write("<br></br></th>");
//	            br.write("</style>");
//	            br.write("</table>");
//	            //---------------------------
//	            
//	         
//	            br.write("<table border: solid 2px width='100%' bgColor='#ffd700'> ");
//	            br.write("<tr class=narr_tr><font-size: 12px><b>");
//	            br.write("Project Name:" + strProjectName);
//	            br.write("</tr>");
//	            br.write("<tr class=narr_tr >");
//	            br.write("ModuleName:" + "  " + strModuleName);
//	            br.write("</tr>");	          
//	            br.write("<tr class=narr_tr >");	            
//	            br.write("Build URL:" + "  " + strURL);	        
//	            br.write("</tr>");
//	            br.write("</b>");
//	            br.write("</table>");
//	            //---------------------------
//	            
//	            
//	            br.write("<table border:1px solid ; width=100% style='table-layout: fixed'; font-size: 12px>");
//	            
//	            //Create Header Row
//	            br.write("<tr align='left' valign='top'; style='font-size: 12px';>");	          
//	            
//	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
//	                br.write("TCID");
//	                br.write("</td>");
//	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
//	                br.write("TestScenario");
//	                br.write("</td>");
//	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
//	                br.write("Result");
//	                br.write("</td>");
//	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
//	                br.write("Execution Time ( In Seconds )");
//	                br.write("</td>");
//	                               
//	            br.write("</tr>");
// 			    br.close();
//			   
//		 }
//		 catch(Exception ex)
//		 {
//			 
//		 }
//		 return htmlfilepath;
//}
//	 
//	 public String InitializeModuleWiseHtmlresult(String strProjectName, String strURL, String strSuitToExecute, String strTestResultFolderPath,String strBrowserName)
//     {
//		 String htmlfilepath = String.valueOf(" ");
//		 try
//		 {
//			 	htmlfilepath = strTestResultFolderPath + "//" + strProjectName+"_ModuleWiseResults"+System.nanoTime()+".html";
//				FileWriter f = new FileWriter(htmlfilepath, true);
//			    BufferedWriter br = new BufferedWriter(f);
//			    
//			    br.write("<html>");
//	            br.write("<head>");
//	            br.write(" <style type=text/css>");
//	            br.write("body {color: #003366;background-color: #FFFFFF;font-family: Verdana, Tahoma, sans-serif;font-size: 10px;}");
//	            br.write("table {line-height: 10pt;width: 100%;}tr {background-color: #ccccff;}.header_table{border: 1pt inset #00008b;}td {padding: 0.1cm 0.2cm;vertical-align: top;}");
//	            br.write(".h1center {font-size: 10pt;font-weight: bold;text-align: left;width: 80%;}.header_table{border: 1pt inset #00008b;}");
//	            br.write(".header_table{border: 1pt inset #00008b;}.narr_table {width: 100%;}.narr_tr {background-color: #ADD8E6;border: 1pt inset #00008b}.narr_th {background-color: #ADD8E6;}");
//	            br.write(".fontforStyling{FONT-WEIGHT: normal! important; FONT-SIZE: 11px! important; LINE-HEIGHT: normal! important; FONT-STYLE: normal! important; FONT-VARIANT: normal! important;font-weight: bold;text-align: left}");
//	            br.write("</style>");
//	            br.write("<title>");
//	            br.write("Test Run Results");
//	            br.write("</title>");
//	            br.write("</head>");
//	          //  br.write("<body bgcolor=#FFFFFF align=center><center><b><i><font size=3 color=#6E6E6E> <u><font color=#8A0808> ONLIFE HEALTH</font>  <font color=#8A0808>A</font>utomation <font color=#8A0808>F</font>ramework <font color=#8A0808></u></font></i></b> </center><font size=2><p>");
//	            br.write("<table class=narr_table");
//	            br.write("style='border: solid 2px'>");
//	            br.write("<th class=narr_th align='center' valign='bottom'  bgColor='#ADD8E6' ><b><font color=#C11B17><br></br>");
//	            br.write(strProjectName +" - Automation Test Scripts Execution Results (" + strBrowserName +")");
//	            br.write("<br></br></th>");
//	            br.write("</style>");
//	            br.write("</table>");
//	            //---------------------------
//	            
//	         
//	            br.write("<table border: solid 2px width='100%' bgColor='#ffd700'> ");
//	            br.write("<tr class=narr_tr><font-size: 12px><b>");
//	            br.write("Project Name:" + strProjectName);
//	            br.write("</tr>");	                   
//	            br.write("<tr class=narr_tr >");	            
//	            br.write("Build URL:" + "  " + strURL);	        
//	            br.write("</tr>");
//	            br.write("<tr class=narr_tr >");	            
//	            br.write("Suit Name:" + "  " + strSuitToExecute);	        
//	            br.write("</tr>");
//	            br.write("<tr class=narr_tr >");	            
//	            br.write("Browser Name:" + "  " + strBrowserName);	        
//	            br.write("</tr>");
//	            br.write("</b>");
//	            br.write("</table>");
//	            //---------------------------
//	               
//	            br.write("<table border:1px solid ; width=100% style='table-layout: fixed'; font-size: 12px>");
//	            
//	            //Create Header Row
//	            br.write("<tr align='left' valign='top'; style='font-size: 12px';>");	          
//	            
//	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
//	                br.write("Module Name");
//	                br.write("</td>");
//	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
//	                br.write("Total Test Case Count");
//	                br.write("</td>");
//	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
//	                br.write("PassResult");
//	                br.write("</td>");
//	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
//	                br.write("FailResult");
//	                br.write("</td>");
//	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
//	                br.write("NotRun");
//	                br.write("</td>");
//	                               
//	            br.write("</tr>");
// 			    br.close();
//			   
//		 }
//		 catch(Exception ex)
//		 {
//			 
//		 }
//		 return htmlfilepath;
//}
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
//	 
//	 
//	 
//	 
//	 public void addrow(String htmlfilepath,String strTCID, String strScenarioName, String strStep, String strKeyFunction, String strTestData, String strTestResults,String strSnapPath, String strErrorMessage)
//			    
//			  {
//		 try
//		 {
//			 
//			 String strSnapFileLink = null;
//			 DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
//	 		 Date dateobj = new Date();
//	 		 String strMainString=df.format(dateobj);
//			   
//			    FileWriter f1 = new FileWriter(htmlfilepath, true);
//			    BufferedWriter br1 = new BufferedWriter(f1);
//			    
//			    
//			    br1.write("<tr bgcolor=#F0F8FF><td width=3%><font size=2>" + strTCID + "</font></td>");			   
//			    br1.write("<td width=10%><font size=2>" + strScenarioName + "</font></td>");
//			    br1.write("<td width=20%><font size=2>" + strStep + "</font></td>");
//			    br1.write("<td width=5%><font size=2><style='word-wrap: break-word'>" + strKeyFunction + "</font></td>");			    
//			    br1.write("<td width=7%><font size=2>" + strTestData + "</font></td>");
//			    br1.write("<td width=7%><font size=2>" + strTestResults + "</font></td>");
//			    br1.write("<td width=2%align=center><font size=2>" + strMainString + "</font> </td>");
//			    if (strTestResults == "Fail")
//			    {
//			    strSnapFileLink = "<a href=file:///"+ strSnapPath+"> SnapShot</a>";
//			    }
//			    else 
//			    {
//			    	strSnapFileLink = "";
//			    }
//			    
//			    br1.write("<td width=20%><font  size=2><b>" + strSnapFileLink + "</b></font></td>");			    
//			     br1.close();
//			    strTCID = null;
//			    strScenarioName= null;
//			    strStep= null;
//			    strKeyFunction= null;
//			    strTestData= null;
//			    strTestResults= null;
//			    strMainString= null;
//			    strSnapPath= null;
//			    strErrorMessage= null;
//		 }
//		 catch(Exception ex)
//		 {
//		 
//		 }
//			  }
//
//	 public void addrowMainresult(String htmlfilepath,String strTCID, String strScenarioName,  String strTestResults, String strTimeInSeconds)
//	    
//	 {
//	try
//	{
//	    FileWriter f1 = new FileWriter(htmlfilepath, true);
//	    BufferedWriter br1 = new BufferedWriter(f1);
//	    br1.write("<tr bgcolor=#F0F8FF><td width=3%><font size=2>" + strTCID + "</font></td>");			   
//	    br1.write("<td width=10%><font size=2>" + strScenarioName + "</font></td>");	    
//	    br1.write("<td width=7%><font size=2>" + strTestResults + "</font></td>");
//	    br1.write("<td width=2%align=center><font size=2>" + strTimeInSeconds + "</font> </td>");
//	    br1.close();
//	    strTCID = null;
//	    strScenarioName= null;	    
//	    strTestResults= null;
//	    strTimeInSeconds= null;	  
//	}
//	catch(Exception ex)
//	{
//	
//	}
//}
//
//	 
//	 
//	 
//	 public void addrowModuleWisehtmlresult(String htmlfilepath,String strModuleName,String strTestCaseCount, String strPassCount,  String strFailcount, String strNotRunCount)
//	    
//	 {
//	try
//	{
//	    FileWriter f1 = new FileWriter(htmlfilepath, true);
//	    BufferedWriter br1 = new BufferedWriter(f1);
//	    br1.write("<tr bgcolor=#F0F8FF><td width=3%><font size=2>" + strModuleName + "</font></td>");
//	    br1.write("<td width=10%><font size=2>" + strTestCaseCount + "</font></td>");	
//	    br1.write("<td width=10%><font size=2>" + strPassCount + "</font></td>");	    
//	    br1.write("<td width=7%><font size=2>" + strFailcount + "</font></td>");
//	    br1.write("<td width=2%align=center><font size=2>" + strNotRunCount + "</font> </td>");
//	    br1.close();
//	    strModuleName = null;
//	    strPassCount= null;	    
//	    strFailcount= null;
//	    strNotRunCount= null;	  
//	}
//	catch(Exception ex)
//	{
//	
//	}
//}
//	 
///*	 
//
//public static void main(String[] args) {
//
//    final String username = "your.mail.id@gmail.com";
//    final String password = "your.password";
//
//    Properties props = new Properties();
//    props.put("mail.smtp.auth", true);
//    props.put("mail.smtp.starttls.enable", true);
//    props.put("mail.smtp.host", "smtp.gmail.com");
//    props.put("mail.smtp.port", "587");
//
//    Session session = Session.getInstance(props,
//            new javax.mail.Authenticator() {
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(username, password);
//                }
//            });
//
//    try {
//
//        Message message = new MimeMessage(session);
//        message.setFrom(new InternetAddress("from.mail.id@gmail.com"));
//        message.setRecipients(Message.RecipientType.TO,
//                InternetAddress.parse("to.mail.id@gmail.com"));
//        message.setSubject("Testing Subject");
//        message.setText("PFA");
//
//        MimeBodyPart messageBodyPart = new MimeBodyPart();
//
//        Multipart multipart = new MimeMultipart();
//
//        messageBodyPart = new MimeBodyPart();
//        String file = "path of file to be attached";
//        String fileName = "attachmentName"
//        DataSource source = new FileDataSource(file);
//        messageBodyPart.setDataHandler(new DataHandler(source));
//        messageBodyPart.setFileName(fileName);
//        multipart.addBodyPart(messageBodyPart);
//
//        message.setContent(multipart);
//
//        System.out.println("Sending");
//
//        Transport.send(message);
//
//        System.out.println("Done");
//
//    } catch (MessagingException e) {
//        e.printStackTrace();
//    }
//  }
//  
//  */
//	 public void SendMail(String file, String fileName )
//	   { 
//		 	final String username = "automationemids";
//		 	final String password = "Emids123";
//		    Properties props = new Properties();
//		    props.put("mail.smtp.auth", true);
//		    props.put("mail.smtp.starttls.enable", true);
//		    props.put("mail.smtp.host", "smtp.gmail.com");
//		    props.put("mail.smtp.port", "587");
//		    String to = "Sudhakar.Pujari@emids.com";
//		    String from = "automationemids@gmail.com";
//		    Session session = Session.getInstance(props,new javax.mail.Authenticator() {
//		                  @Override
//						protected PasswordAuthentication getPasswordAuthentication() {
//		                      return new PasswordAuthentication(username, password);
//		                  }
//		              });
//		      
//	      try{
//	         // Create a default MimeMessage object.
//	         MimeMessage message = new MimeMessage(session);
//	         MimeBodyPart messageBodyPart = new MimeBodyPart();
//	         // Set From: header field of the header.
//	         message.setFrom(new InternetAddress(from));
//	         // Set To: header field of the header.
//	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
//	         // Set Subject: header field
//	         message.setSubject("Automation Execution Results Reports"); 
//	         BodyPart messageBodyPart1 = new MimeBodyPart();  
//	         messageBodyPart1.setText("Hi, Please find the Automation Execution Results in the attachment.");
//	         Multipart multipart = new MimeMultipart();
//	         messageBodyPart = new MimeBodyPart();	 
//	         DataSource source = new FileDataSource(file);
//	         messageBodyPart.setDataHandler(new DataHandler(source));
//	         messageBodyPart.setFileName(fileName);
//	         multipart.addBodyPart(messageBodyPart);
//	         multipart.addBodyPart(messageBodyPart1);
//	         message.setContent(multipart);
//	         // Send message
//	         Transport.send(message);	       
//	      }catch (MessagingException mex) {
//	         mex.printStackTrace();
//	      }
//	   }
//	
//	 
//	 
//	 package UtilityLibrary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import datable.Xls_Reader;






public class UtilityLibrary {

	String strSnapPath =String.valueOf(" ");
	//public static Generic objGeneric=new Generic();
	public static Xls_Reader datatable = null;
	
	
	
	public Properties ReadDataFromPropertiesFile(String filePath)
	{ 	
		File file = new File(filePath);		  
		FileInputStream fileInput = null;
		try 
		{
			fileInput = new FileInputStream(file);
		} 
		catch (FileNotFoundException e) 
		{
			e.getMessage();
		}
		Properties prop = new Properties();			
		//load properties file
		try
		{
			prop.load(fileInput);
		} 
		catch (IOException e) 
		{
			e.getMessage();
		}
		return prop;
	}
	
	// public String CreateFolderWithUserDefineNameAndTime(String strAutomationFolderPath,String strBrowserName)
	public String CreateFolderWithUserDefineNameAndTime(String strAutomationFolderPath)
     
	{
		 
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		String strMainString=df.format(dateobj).replace("/","").replace(":", "").replace(" ","");
        //String strPathToCreateSubFolder = strAutomationFolderPath +"_"+strBrowserName  + "_"+strMainString.trim();
        
		String strPathToCreateSubFolder = strAutomationFolderPath +"_"+strMainString.trim();
		File file=new File(strPathToCreateSubFolder);
        file.mkdir();       
        return strPathToCreateSubFolder;
     }
	 
	 
	 
	 


	public static Object[][] getData(String testName){
		
		if(datatable == null){
			
			datatable = new Xls_Reader(System.getProperty("user.dir")+"//src//InputFile//InputFile.xls");
		}
		
		int rows = datatable.getRowCount(testName)-1;
		if (rows<=0){
			Object[][] testdata = new Object[1][0];
			return testdata;
		}
		
		rows = datatable.getRowCount(testName);
		int cols = datatable.getColumnCount(testName);
		Object data[][] = new Object[rows][cols];
		
		for(int rowNum = 1; rowNum <= rows; rowNum++){
			for(int colNum = 0; colNum < cols; colNum++){
				data[rowNum-1][colNum] = datatable.getCellData(testName, colNum, rowNum);
			}
		}
		return data;
	}
		 
	 public String ReadFileData(String strFilePath, String strFileName)
     {
		 String strReadLineDataContent = String.valueOf(" ");
			BufferedReader bufferedReader = null;
			    try { 
				       String csvFile = strFilePath+strFileName +".csv";
				       
				       //create BufferedReader to read csv file
				       bufferedReader = new BufferedReader(new FileReader(csvFile));
				       String line = "";
				       bufferedReader.readLine(); //skips the first row				      
				   
				      while ((line = bufferedReader.readLine()) != null) {	
				    	  strReadLineDataContent = strReadLineDataContent + ","+line.replace("\"","");	
				       }
				      bufferedReader.close();
				     
				       } catch (Exception e) {
				       System.err.println("CSV file cannot be read : " + e);
				     }
         
			    return strReadLineDataContent;
         
     }
     
	
	
	 
	 public String CreateWriteLog(String strProjectName, String strURL, String strModuleName, String strSuitToExecute, String strTestResultFolderPath,String strBrowserName)
     { 
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		String strMainString=df.format(dateobj);
		String strDateString=strMainString.replace("/","_").replace(":", "_");
        String strFilePath = strTestResultFolderPath + "//" + strModuleName + "_" + strSuitToExecute + "Result"+strDateString+".csv";
        FileWriter writer;
		try 
		{		
			
			
			writer = new FileWriter(strFilePath,true);
			writer.append(',');
		    writer.append(strProjectName +"- TestRunResults -"+" - "+strBrowserName + strMainString);
		    writer.append('\n');
	        writer.append('\n');
	        writer.append("Automation Tool Name :");
	        writer.append(',');
	        writer.append("Selenium");
	        writer.append('\n');
	        writer.append("OS Version :");
	        writer.append(',');
	        writer.append(System.getProperty("os.version"));
	        writer.append('\n');
	        writer.append("UserName :");
	        writer.append(',');
	        writer.append(System.getProperty("user.name"));
	        writer.append('\n');
	        writer.append("ModuleName :");
	        writer.append(',');
	        writer.append(strModuleName);
	        writer.append('\n');
	        writer.append("Build URL :");
	        writer.append(',');
	        writer.append(strURL);
	        writer.append('\n');
	        writer.append('\n');
	        writer.append('\n');
	        writer.append('\n');
	        writer.append("TCID");
	        writer.append(',');
	        writer.append("TestScenario");
	        writer.append(',');
	        writer.append("TestStep");
	        writer.append(',');
	        writer.append("KeyMethod");
	        writer.append(',');     
	        writer.append("TestData");
	        writer.append(',');
	        writer.append("Result");
	        writer.append(',');
	        writer.append("ExecutionTime");
	        writer.append(',');
	        writer.append("ErrorSanpFilePath(for failed Testcase)");
	        writer.append(',');
	        writer.append("ErrorMessage");
	        writer.append(',');
	        writer.flush();
	        writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return strFilePath;
     }
     
	 							
	 public String ResultWriteToFile(String strFilePath, String strTCID, String strScenarioName, String strStep, String strKeyFunction, String strTestData,String strResult,String strSnapFolderPath,String strModuleName,String strErrorMessage)
     {
		 String strSnapPath =String.valueOf(" ");   
         String strResult_Status =String.valueOf(" ");         
         FileWriter writer;
        
         DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
 	     Date dateobj = new Date();
 		 String strMainString=df.format(dateobj);
 		 
 		try 
 		{	
 			if (strResult.contains("Pass"))
 			{
 				strResult_Status = "Pass"; 				
 			}
 			else if (strResult.contains("Fail"))
 			{
 				strResult_Status = "Fail"; 
 				//strSnapPath =Generic.SnapShot(strSnapFolderPath,strModuleName,strKeyFunction);
 			}
 			writer = new FileWriter(strFilePath,true);
 			writer.append('\n');
 			writer.append(strTCID);
 			writer.append(','); 		
 			writer.append(strScenarioName);
 			writer.append(',');
 			writer.append(strStep);
 			writer.append(',');
 			writer.append(strKeyFunction);
 			writer.append(',');
 			writer.append(strTestData);
 			writer.append(',');
 			writer.append(strResult_Status);
 			writer.append(',');
 			writer.append(strMainString);
 			writer.append(',');
 			writer.append(strSnapPath); 
 			writer.append(',');
 			writer.append(strErrorMessage);
 			writer.flush();
 			writer.close();
 			
     } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
 		return strSnapPath;
 		
                   
     }
	 
	 public String Initializehtml(String strProjectName, String strURL, String strModuleName, String strSuitToExecute, String strTestResultFolderPath,String strReportType,String strBrowserName)
     {
		 String htmlfilepath = String.valueOf(" ");
		 try
		 {
		 		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		 		Date dateobj = new Date();
		 		String strMainString=df.format(dateobj);
		 		htmlfilepath = strTestResultFolderPath + "//" + strModuleName + "_" + strSuitToExecute + strReportType + "_Result"+System.nanoTime()+".html";
			    FileWriter f = new FileWriter(htmlfilepath, true);
			    BufferedWriter br = new BufferedWriter(f);
			    
			    br.write("<html>");
	            br.write("<head>");
	            br.write(" <style type=text/css>");
	            br.write("body {color: #003366;background-color: #FFFFFF;font-family: Verdana, Tahoma, sans-serif;font-size: 10px;}");
	            br.write("table {line-height: 10pt;width: 100%;}tr {background-color: #ccccff;}.header_table{border: 1pt inset #00008b;}td {padding: 0.1cm 0.2cm;vertical-align: top;}");
	            br.write(".h1center {font-size: 10pt;font-weight: bold;text-align: left;width: 80%;}.header_table{border: 1pt inset #00008b;}");
	            br.write(".header_table{border: 1pt inset #00008b;}.narr_table {width: 100%;}.narr_tr {background-color: #ADD8E6;border: 1pt inset #00008b}.narr_th {background-color: #ADD8E6;}");
	            br.write(".fontforStyling{FONT-WEIGHT: normal! important; FONT-SIZE: 11px! important; LINE-HEIGHT: normal! important; FONT-STYLE: normal! important; FONT-VARIANT: normal! important;font-weight: bold;text-align: left}");
	            br.write("</style>");
	            br.write("<title>");
	            br.write("Test Run Results");
	            br.write("</title>");
	            br.write("</head>");
	          //  br.write("<body bgcolor=#FFFFFF align=center><center><b><i><font size=3 color=#6E6E6E> <u><font color=#8A0808> ONLIFE HEALTH</font>  <font color=#8A0808>A</font>utomation <font color=#8A0808>F</font>ramework <font color=#8A0808></u></font></i></b> </center><font size=2><p>");
	            br.write("<table class=narr_table");
	            br.write("style='border: solid 2px'>");
	            br.write("<th class=narr_th align='center' valign='bottom'  bgColor='#ADD8E6' ><b><font color=#C11B17><br></br>");
	            br.write(strProjectName +" - Automation Test Scripts Execution Results (" + strBrowserName +")");
	            br.write("<br></br></th>");
	            br.write("</style>");
	            br.write("</table>");
	            //---------------------------
	            
	         
	            br.write("<table border: solid 2px width='100%' bgColor='#ffd700'> ");
	            br.write("<tr class=narr_tr><font-size: 12px><b>");
	            br.write("Project Name:" + strProjectName);
	            br.write("</tr>");

	            br.write("<tr class=narr_tr >");
	            br.write("ModuleName:" + "  " + strModuleName);
	            br.write("</tr>");
	          
	            br.write("<tr class=narr_tr >");	            
	            br.write("Build URL:" + "  " + strURL);
	        
	            br.write("<tr class=narr_tr >");
	            br.write("Run Started on : "+ strMainString);
	            br.write("</tr>");
	            br.write("</b>");
	            br.write("</table>");
	            //---------------------------
	            
	            
	            br.write("<table border:1px solid ; width=100% style='table-layout: fixed'; font-size: 12px>");
	            
	            //Create Header Row
	            br.write("<tr align='left' valign='top'; style='font-size: 12px';>");	          
	           
	            
	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
	                br.write("TCID");
	                br.write("</td>");
	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
	                br.write("TestScenario");
	                br.write("</td>");
	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
	                br.write("TestStep");
	                br.write("</td>");
	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
	                br.write("KeyMethod");
	                br.write("</td>");
	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
	                br.write("TestData");
	                br.write("</td>");
	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
	                br.write("Result");
	                br.write("</td>");
	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
	                br.write("ExecutionTime");
	                br.write("</td>");
	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
	                br.write("SanpFilePath");
	                br.write("</td>");
	               
	                
	            br.write("</tr>");
 			    br.close();
			   
		 }
		 catch(Exception ex)
		 {
			 
		 }
		 return htmlfilepath;
}
	 

	 public String InitializeMainresult(String strProjectName, String strURL, String strModuleName, String strSuitToExecute, String strTestResultFolderPath,String strReportType,String strBrowserName)
     {
		 String htmlfilepath = String.valueOf(" ");
		 try
		 {
			 	htmlfilepath = strTestResultFolderPath + "//" + strModuleName + "_" + strSuitToExecute + strReportType + "_Result"+System.nanoTime()+".html";
				FileWriter f = new FileWriter(htmlfilepath, true);
			    BufferedWriter br = new BufferedWriter(f);
			    
			    br.write("<html>");
	            br.write("<head>");
	            br.write(" <style type=text/css>");
	            br.write("body {color: #003366;background-color: #FFFFFF;font-family: Verdana, Tahoma, sans-serif;font-size: 10px;}");
	            br.write("table {line-height: 10pt;width: 100%;}tr {background-color: #ccccff;}.header_table{border: 1pt inset #00008b;}td {padding: 0.1cm 0.2cm;vertical-align: top;}");
	            br.write(".h1center {font-size: 10pt;font-weight: bold;text-align: left;width: 80%;}.header_table{border: 1pt inset #00008b;}");
	            br.write(".header_table{border: 1pt inset #00008b;}.narr_table {width: 100%;}.narr_tr {background-color: #ADD8E6;border: 1pt inset #00008b}.narr_th {background-color: #ADD8E6;}");
	            br.write(".fontforStyling{FONT-WEIGHT: normal! important; FONT-SIZE: 11px! important; LINE-HEIGHT: normal! important; FONT-STYLE: normal! important; FONT-VARIANT: normal! important;font-weight: bold;text-align: left}");
	            br.write("</style>");
	            br.write("<title>");
	            br.write("Test Run Results");
	            br.write("</title>");
	            br.write("</head>");
	          //  br.write("<body bgcolor=#FFFFFF align=center><center><b><i><font size=3 color=#6E6E6E> <u><font color=#8A0808> ONLIFE HEALTH</font>  <font color=#8A0808>A</font>utomation <font color=#8A0808>F</font>ramework <font color=#8A0808></u></font></i></b> </center><font size=2><p>");
	            br.write("<table class=narr_table");
	            br.write("style='border: solid 2px'>");
	            br.write("<th class=narr_th align='center' valign='bottom'  bgColor='#ADD8E6' ><b><font color=#C11B17><br></br>");
	            br.write(strProjectName +" - Automation Test Scripts Execution Results (" + strBrowserName +")");
	            br.write("<br></br></th>");
	            br.write("</style>");
	            br.write("</table>");
	            //---------------------------
	            
	         
	            br.write("<table border: solid 2px width='100%' bgColor='#ffd700'> ");
	            br.write("<tr class=narr_tr><font-size: 12px><b>");
	            br.write("Project Name:" + strProjectName);
	            br.write("</tr>");
	            br.write("<tr class=narr_tr >");
	            br.write("ModuleName:" + "  " + strModuleName);
	            br.write("</tr>");	          
	            br.write("<tr class=narr_tr >");	            
	            br.write("Build URL:" + "  " + strURL);	        
	            br.write("</tr>");
	            br.write("</b>");
	            br.write("</table>");
	            //---------------------------
	            
	            
	            br.write("<table border:1px solid ; width=100% style='table-layout: fixed'; font-size: 12px>");
	            
	            //Create Header Row
	            br.write("<tr align='left' valign='top'; style='font-size: 12px';>");	          
	            
	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
	                br.write("TCID");
	                br.write("</td>");
	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
	                br.write("TestScenario");
	                br.write("</td>");
	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
	                br.write("Result");
	                br.write("</td>");
	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
	                br.write("Execution Time ( In Seconds )");
	                br.write("</td>");
	                               
	            br.write("</tr>");
 			    br.close();
			   
		 }
		 catch(Exception ex)
		 {
			 
		 }
		 return htmlfilepath;
}
	 
	 public String InitializeModuleWiseHtmlresult(String strProjectName, String strURL, String strSuitToExecute, String strTestResultFolderPath,String strBrowserName)
     {
		 String htmlfilepath = String.valueOf(" ");
		 try
		 {
			 	htmlfilepath = strTestResultFolderPath + "//" + strProjectName+"_ModuleWiseResults"+System.nanoTime()+".html";
				FileWriter f = new FileWriter(htmlfilepath, true);
			    BufferedWriter br = new BufferedWriter(f);
			    
			    br.write("<html>");
	            br.write("<head>");
	            br.write(" <style type=text/css>");
	            br.write("body {color: #003366;background-color: #FFFFFF;font-family: Verdana, Tahoma, sans-serif;font-size: 10px;}");
	            br.write("table {line-height: 10pt;width: 100%;}tr {background-color: #ccccff;}.header_table{border: 1pt inset #00008b;}td {padding: 0.1cm 0.2cm;vertical-align: top;}");
	            br.write(".h1center {font-size: 10pt;font-weight: bold;text-align: left;width: 80%;}.header_table{border: 1pt inset #00008b;}");
	            br.write(".header_table{border: 1pt inset #00008b;}.narr_table {width: 100%;}.narr_tr {background-color: #ADD8E6;border: 1pt inset #00008b}.narr_th {background-color: #ADD8E6;}");
	            br.write(".fontforStyling{FONT-WEIGHT: normal! important; FONT-SIZE: 11px! important; LINE-HEIGHT: normal! important; FONT-STYLE: normal! important; FONT-VARIANT: normal! important;font-weight: bold;text-align: left}");
	            br.write("</style>");
	            br.write("<title>");
	            br.write("Test Run Results");
	            br.write("</title>");
	            br.write("</head>");
	          //  br.write("<body bgcolor=#FFFFFF align=center><center><b><i><font size=3 color=#6E6E6E> <u><font color=#8A0808> ONLIFE HEALTH</font>  <font color=#8A0808>A</font>utomation <font color=#8A0808>F</font>ramework <font color=#8A0808></u></font></i></b> </center><font size=2><p>");
	            br.write("<table class=narr_table");
	            br.write("style='border: solid 2px'>");
	            br.write("<th class=narr_th align='center' valign='bottom'  bgColor='#ADD8E6' ><b><font color=#C11B17><br></br>");
	            br.write(strProjectName +" - Automation Test Scripts Execution Results (" + strBrowserName +")");
	            br.write("<br></br></th>");
	            br.write("</style>");
	            br.write("</table>");
	            //---------------------------
	            
	         
	            br.write("<table border: solid 2px width='100%' bgColor='#ffd700'> ");
	            br.write("<tr class=narr_tr><font-size: 12px><b>");
	            br.write("Project Name:" + strProjectName);
	            br.write("</tr>");	                   
	            br.write("<tr class=narr_tr >");	            
	            br.write("Build URL:" + "  " + strURL);	        
	            br.write("</tr>");
	            br.write("<tr class=narr_tr >");	            
	            br.write("Suit Name:" + "  " + strSuitToExecute);	        
	            br.write("</tr>");
	            br.write("<tr class=narr_tr >");	            
	            br.write("Browser Name:" + "  " + strBrowserName);	        
	            br.write("</tr>");
	            br.write("</b>");
	            br.write("</table>");
	            //---------------------------
	               
	            br.write("<table border:1px solid ; width=100% style='table-layout: fixed'; font-size: 12px>");
	            
	            //Create Header Row
	            br.write("<tr align='left' valign='top'; style='font-size: 12px';>");	          
	            
	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
	                br.write("Module Name");
	                br.write("</td>");
	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
	                br.write("Total Test Case Count");
	                br.write("</td>");
	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
	                br.write("PassResult");
	                br.write("</td>");
	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
	                br.write("FailResult");
	                br.write("</td>");
	                br.write("<td align='left' valign='top' bgColor='green' style='word-wrap: break-word' font-size: 12px><b><font color=#ffffff ;font-size: 12px; >");
	                br.write("NotRun");
	                br.write("</td>");
	                               
	            br.write("</tr>");
 			    br.close();
			   
		 }
		 catch(Exception ex)
		 {
			 
		 }
		 return htmlfilepath;
}
	 
 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public void addrow(String htmlfilepath,String strTCID, String strScenarioName, String strStep, String strKeyFunction, String strTestData, String strTestResults,String strSnapPath, String strErrorMessage)
			    
			  {
		 try
		 {
			 
			 String strSnapFileLink = null;
			 DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	 		 Date dateobj = new Date();
	 		 String strMainString=df.format(dateobj);
			   
			    FileWriter f1 = new FileWriter(htmlfilepath, true);
			    BufferedWriter br1 = new BufferedWriter(f1);
			    
			    
			    br1.write("<tr bgcolor=#F0F8FF><td width=3%><font size=2>" + strTCID + "</font></td>");			   
			    br1.write("<td width=10%><font size=2>" + strScenarioName + "</font></td>");
			    br1.write("<td width=20%><font size=2>" + strStep + "</font></td>");
			    br1.write("<td width=5%><font size=2><style='word-wrap: break-word'>" + strKeyFunction + "</font></td>");			    
			    br1.write("<td width=7%><font size=2>" + strTestData + "</font></td>");
			    br1.write("<td width=7%><font size=2>" + strTestResults + "</font></td>");
			    br1.write("<td width=2%align=center><font size=2>" + strMainString + "</font> </td>");
			    if (strTestResults == "Fail")
			    {
			    strSnapFileLink = "<a href=file:///"+ strSnapPath+"> SnapShot</a>";
			    }
			    else 
			    {
			    	strSnapFileLink = "";
			    }
			    
			    br1.write("<td width=20%><font  size=2><b>" + strSnapFileLink + "</b></font></td>");			    
			     br1.close();
			    strTCID = null;
			    strScenarioName= null;
			    strStep= null;
			    strKeyFunction= null;
			    strTestData= null;
			    strTestResults= null;
			    strMainString= null;
			    strSnapPath= null;
			    strErrorMessage= null;
		 }
		 catch(Exception ex)
		 {
		 
		 }
			  }

	 public void addrowMainresult(String htmlfilepath,String strTCID, String strScenarioName,  String strTestResults, String strTimeInSeconds)
	    
	 {
	try
	{
	    FileWriter f1 = new FileWriter(htmlfilepath, true);
	    BufferedWriter br1 = new BufferedWriter(f1);
	    br1.write("<tr bgcolor=#F0F8FF><td width=3%><font size=2>" + strTCID + "</font></td>");			   
	    br1.write("<td width=10%><font size=2>" + strScenarioName + "</font></td>");	    
	    br1.write("<td width=7%><font size=2>" + strTestResults + "</font></td>");
	    br1.write("<td width=2%align=center><font size=2>" + strTimeInSeconds + "</font> </td>");
	    br1.close();
	    strTCID = null;
	    strScenarioName= null;	    
	    strTestResults= null;
	    strTimeInSeconds= null;	  
	}
	catch(Exception ex)
	{
	
	}
}

	 
	 
	 
	 public void addrowModuleWisehtmlresult(String htmlfilepath,String strModuleName,String strTestCaseCount, String strPassCount,  String strFailcount, String strNotRunCount)
	    
	 {
	try
	{
	    FileWriter f1 = new FileWriter(htmlfilepath, true);
	    BufferedWriter br1 = new BufferedWriter(f1);
	    br1.write("<tr bgcolor=#F0F8FF><td width=3%><font size=2>" + strModuleName + "</font></td>");
	    br1.write("<td width=10%><font size=2>" + strTestCaseCount + "</font></td>");	
	    br1.write("<td width=10%><font size=2>" + strPassCount + "</font></td>");	    
	    br1.write("<td width=7%><font size=2>" + strFailcount + "</font></td>");
	    br1.write("<td width=2%align=center><font size=2>" + strNotRunCount + "</font> </td>");
	    br1.close();
	    strModuleName = null;
	    strPassCount= null;	    
	    strFailcount= null;
	    strNotRunCount= null;	  
	}
	catch(Exception ex)
	{
	
	}
}
	 
/*	 

public static void main(String[] args) {

    final String username = "your.mail.id@gmail.com";
    final String password = "your.password";

    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

    try {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("from.mail.id@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("to.mail.id@gmail.com"));
        message.setSubject("Testing Subject");
        message.setText("PFA");

        MimeBodyPart messageBodyPart = new MimeBodyPart();

        Multipart multipart = new MimeMultipart();

        messageBodyPart = new MimeBodyPart();
        String file = "path of file to be attached";
        String fileName = "attachmentName"
        DataSource source = new FileDataSource(file);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(fileName);
        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

        System.out.println("Sending");

        Transport.send(message);

        System.out.println("Done");

    } catch (MessagingException e) {
        e.printStackTrace();
    }
  }
  
  */
//	 public void SendMail(String file, String fileName )
//	   { 
//		 	final String username = "automationemids";
//		 	final String password = "Emids123";
//		    Properties props = new Properties();
//		    props.put("mail.smtp.auth", true);
//		    props.put("mail.smtp.starttls.enable", true);
//		    props.put("mail.smtp.host", "smtp.gmail.com");
//		    props.put("mail.smtp.port", "587");
//		    String to = "Sudhakar.Pujari@emids.com";
//		    String from = "automationemids@gmail.com";
//		    Session session = Session.getInstance(props,new javax.mail.Authenticator() {
//		                  @Override
//						protected PasswordAuthentication getPasswordAuthentication() {
//		                      return new PasswordAuthentication(username, password);
//		                  }
//		              });
//		      
//	      try{
//	         // Create a default MimeMessage object.
//	         MimeMessage message = new MimeMessage(session);
//	         MimeBodyPart messageBodyPart = new MimeBodyPart();
//	         // Set From: header field of the header.
//	         message.setFrom(new InternetAddress(from));
//	         // Set To: header field of the header.
//	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
//	         // Set Subject: header field
//	         message.setSubject("Automation Execution Results Reports"); 
//	         BodyPart messageBodyPart1 = new MimeBodyPart();  
//	         messageBodyPart1.setText("Hi, Please find the Automation Execution Results in the attachment.");
//	         Multipart multipart = new MimeMultipart();
//	         messageBodyPart = new MimeBodyPart();	 
//	         DataSource source = new FileDataSource(file);
//	         messageBodyPart.setDataHandler(new DataHandler(source));
//	         messageBodyPart.setFileName(fileName);
//	         multipart.addBodyPart(messageBodyPart);
//	         multipart.addBodyPart(messageBodyPart1);
//	         message.setContent(multipart);
//	         // Send message
//	         Transport.send(message);	       
//	      }catch (MessagingException mex) {
//	         mex.printStackTrace();
//	      }
//	   }
	
	 
	 
	 
	 
	
	 
	
	 
	 
	 
	 
	 
}

//	 
//	
//	 
//	
//	 
//	 
//	 
//	 
//	 
//}
