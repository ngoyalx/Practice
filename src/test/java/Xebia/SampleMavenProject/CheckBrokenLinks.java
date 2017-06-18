package Xebia.SampleMavenProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBrokenLinks 
{
	WebDriver driver;
	
	List<String> alllinks=new ArrayList<String>();
	List<String> brokenLinkList = new ArrayList<String>();
	List<WebElement> anchrolinks=new ArrayList<WebElement>();
	String url="";
	int brokenlinkcount=0;

	
	public static void main(String[] args)
	{
		CheckBrokenLinks chkbl=new CheckBrokenLinks();
		chkbl.CheckBrokenLinks();
		
	}
	
	public boolean CheckBrokenLinks() 
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cheapoair.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		anchrolinks=driver.findElements(By.tagName("a"));
		for(WebElement e:anchrolinks)
		{
			if(e!=null)
			url=e.getAttribute("href");
			if(!(url==null))
			{
				checkforduplicatesandadd(alllinks, url);
			}
			
		}
		
		for(int i=0;i<alllinks.size();i++)
		{
			String currenturl=alllinks.get(i);
			if(currenturl!=null&&!currenturl.contains("javascript"))
			{
				CloseableHttpClient client = HttpClientBuilder.create().build();
				HttpGet request = new HttpGet(currenturl);
				HttpResponse response = null;
				try 
				{
				    response = client.execute(request);
				} 
				catch (IOException e) 
				{
				    e.printStackTrace();
				}

				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode != 200) 
				{
				    System.out.println("Broken URL: " + currenturl);
				    brokenLinkList.add(currenturl);
				    brokenlinkcount++;
				}
				
				else
				{
					System.out.println("Link is fine" + currenturl);
				}
			}
		}
		return true;
		
	}
	
	public Boolean checkforduplicatesandadd(List<String> list,String str)
	{
		if(!list.contains(str))
		{
			list.add(str);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	

}
