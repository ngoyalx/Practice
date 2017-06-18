package Xebia.SampleMavenProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.thoughtworks.selenium.webdriven.commands.GetText;

public class ReadCsvFile 
{
	static List<String[]> allcsvdata=new ArrayList<String[]>() ;
	static List<String> testcaseidsforexecution=new ArrayList<String>();
	static String Testgroup="Tronc, Brokenlinks";
	static List<String> testcasesteps=new ArrayList<String>();
	static String testcaseid="ArticlePublishDatePattern_Home";

	public static void main(String[] args) throws IOException 
	{
		ReadCsvFile rcsv=new ReadCsvFile();
		rcsv.readcsv();
		
		//System.out.println(rcsv.getcellvalue(allcsvdata,1,"test case id"));
		//rcsv.gettestcaseidforexecution();
		//rcsv.readlist(testcaseidsforexecution);
		//rcsv.loadpropertyfile();
		rcsv.getteststepsfortestcase(testcaseid);
		rcsv.readlist(testcasesteps);
	}
	public List<String[]> readcsv() throws FileNotFoundException
	{
		File file=new File("C:\\Users\\ngoyal\\Desktop\\test.csv");
		
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line="";
		
		try
		{
			while((line=br.readLine())!=null)
			{
				String[] rowsasarray=line.split(",");
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
		String[] csvelements=allcsvdata.get(0);
		for(String s:csvelements)
		{
			System.out.println(s);
		}
		System.out.println(allcsvdata.size());
		return allcsvdata;	
	}
	
	public void loadpropertyfile() throws IOException
	{
		Properties prop=new Properties();
		File file=new File("E:\\Nitin\\Workspace\\SampleMavenProject\\test.properties");
		FileInputStream fs=new FileInputStream(file);
		prop.load(fs);
		System.out.println(prop.getProperty("MaximumTimeoutiOS"));
		
		HashMap<Object, Object> hm=new HashMap<Object, Object>();
		Enumeration em=prop.keys();
		Set keyset=prop.keySet();
		Object[] keys=(Object[]) keyset.toArray();
		int i=0;
		while(em.hasMoreElements())
		{
			String element=(String) em.nextElement();
			hm.put(keys[i],prop.getProperty(element));
			i++;
		}
		
		Set allkeys=hm.keySet();
		for(Object key:allkeys)
		{
			System.out.println(key+"-----"+hm.get(key));
		}
		
		
	}
	
	
	
	public String getcellvalue(List<String[]> sheet,int row, String colheader)
	{
		int colnum=0;
		String[] header=sheet.get(0);
		for(int i=0;i<header.length;i++)
		{
			if(header[i].equalsIgnoreCase(colheader))
			{
				colnum=i;
				break;
			}
		}
		String[] specificrow=sheet.get(row);
		return specificrow[colnum];
		
	}
	
	public List<String> gettestcaseidforexecution()
	{
		int row=0;
		int totalrows=allcsvdata.size();
		while(row<totalrows)
		{
			String tid=getcellvalue(allcsvdata, row, "testcase_id");
			if(!(tid==null))
			{
				testcaseidsforexecution.add(tid);
				row++;
			}
		}
		return testcaseidsforexecution;
	}
	
	public List<String> getteststepsfortestcase(String Testcaseid)
	{
		int row=0;
		int totalrows=allcsvdata.size();
		boolean istestcasefound=false;
		while(row<totalrows)
		{
			String tid=getcellvalue(allcsvdata, row, "testcase_id");
			if(!(tid==null)&&tid.equalsIgnoreCase(Testcaseid))
			{
				istestcasefound=true;
			}
			if(istestcasefound)
			{
				if(!tid.equals("")&&!tid.equalsIgnoreCase(Testcaseid))
				{
					istestcasefound=false;
				}
				else
				{
					String teststep=getcellvalue(allcsvdata, row, "Step");
					testcasesteps.add(teststep);
				}
			}
			row++;
			
		}
		return testcasesteps;
	}
	
	
	public static void readlist(List<String> list)
	{
		for(String s:list)
		{
			System.out.println(s);
		}
	}

}
