package Xebia.SampleMavenProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.bcel.generic.SWITCH;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SampleFramework 
{
	WebDriver driver;
	List<String[]> allcsvdata=new ArrayList<String[]>();
	List<String> testcaseids=new ArrayList<>();
	HashMap<String, String[]> hm=new HashMap<String,String[]>();
	
 @Test
 public void execute() throws IOException{
	 readcsv();
	 gettestcaseidsforexecution(allcsvdata);
	 printlistelements(testcaseids);
	 gettestdetails();
	 System.out.println(getelementdetails(globalhashmap,"Flipkart_Home_search","how"));
 }
	
  public List<String[]> readcsv() throws FileNotFoundException{
	  	File file=new File("C:\\Users\\ngoyal\\Desktop\\flipkart.csv");
		
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line="";
		
		try
		{
			while((line=br.readLine())!=null)
			{
				String[] rowsasarray=line.split("\t");
				for(int i=0;i<rowsasarray.length;i++)
				{
					rowsasarray[i]=rowsasarray[i].trim();
				}
				allcsvdata.add(rowsasarray);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		/*String[] header=allcsvdata.get(0);
		for(String s:header)
		{
			System.out.println(s);
		}*/
		return allcsvdata;	
  }
  
  	public String getcellvalue(List<String[]> sheet,int row,String colheader){

  		int colnumber=0;
  		String[] header=sheet.get(0);
  		for(int i=0;i<header.length;i++){
  			if(header[i].equalsIgnoreCase(colheader)){
  				colnumber=i;
  				break;
  			}
  		}
  		String[] specificrow=sheet.get(row);
  		return specificrow[colnumber];
  	}
  	
  
  	public List<String> gettestcaseidsforexecution(List<String[]> sheet){
  		int row=1;
  		int totalrows=sheet.size();
  		while(row<totalrows){
  			String testcaseid=getcellvalue(sheet,row,"testcase_id");
  			if(!(testcaseid==null)){
  				testcaseids.add(testcaseid);
  				row++;
  			}
  		}
  		return testcaseids;
  	}
  	
  	public void printlistelements(List<String> list){
  		for(String s:list){
  			if(!s.equals(""))
  			System.out.println(s);
  		}
  	}
  	
  	
  	
  	
  	HashMap<String,HashMap<String,String>> globalhashmap=new HashMap<>();
  
  	public HashMap<String,HashMap<String,String>> gettestdetails() throws IOException{
  		String[] header=allcsvdata.get(0);
		for(int i=1;i<allcsvdata.size();i++){
			HashMap<String,String> hminternal=new HashMap<String,String>();
			String[] rowsasarray=allcsvdata.get(i);
			for(int j=0;j<rowsasarray.length;j++)
			{
				hminternal.put(header[j].trim(),(getcellvalue(allcsvdata, i, header[j].trim())).trim());
			}
			String keyglobalmap=(getcellvalue(allcsvdata, i, "Page_module")).trim();
			
			globalhashmap.put(keyglobalmap,hminternal);
			
		}
		/*Set<String> keys= globalhashmap.keySet();
		for(String k:keys){
			System.out.println("Key is " + "-------" + k + "-------" + "Value is " + "-------" + globalhashmap.get(k));
		}*/
		return globalhashmap;
  	}
  	
  	public String getelementdetails(HashMap<String,HashMap<String,String>> hashmap, String globalkey, String internalkey){
  		
   			HashMap<String,String> keyvalueasmap = hashmap.get(globalkey);
  			String value = keyvalueasmap.get(internalkey);
  			return value;
  	}
  	
  	public WebElement getelement(String how,String value){
  		WebElement element=null;
  		how=how.toLowerCase();
  		
  		try{
  		switch (how) {
  		
		case "xpath":
		element = driver.findElement(By.xpath(value));
		break;
		
		case "name":	
		element =driver.findElement(By.name(value));
		break;
		
		case "linktext":	
		element = driver.findElement(By.linkText(value));
		break;
			
		case "id":	
		element = driver.findElement(By.id(value));
		break;
			
		case "css":	
		element = driver.findElement(By.cssSelector(value));
		break;
			
		case "partiallinktext":	
		element = driver.findElement(By.partialLinkText(value));
		break;
		
		default:
		throw new Exception("Incorrect attribute type");
		}
  		}
  		catch(Exception e){
  			e.printStackTrace();
  		}
  		return element;
  	}
}
		

