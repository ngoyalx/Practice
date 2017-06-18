package Xebia.SampleMavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Readexcel 
{
	WebDriver driver;
	
	private static HSSFWorkbook wb;
	private static HSSFSheet sh;
	private static HSSFRow row;
	private static HSSFCell cell;
	static String path="Z:\\Nitin goyal\\";
	static String filename="test.xls";
	String nodeurl="http://192.168.1.4:5566/wd/hub";
	
	@Test(enabled=false)
	public static void readexcel(String path, String filename) throws IOException
	{
		File file=new File(path+filename);
		FileInputStream fs=new FileInputStream(file);
		wb=new HSSFWorkbook(fs);
		sh=wb.getSheet("Sheet1");
		int Rows=sh.getLastRowNum();
		for(int i=0;i<=Rows;i++)
		{
			row=sh.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				DataFormatter formatter = new DataFormatter();
				cell=sh.getRow(i).getCell(j);
				System.out.print(formatter.formatCellValue(cell)+"---");
			}
			System.out.println();
		}	
	}
	
	@BeforeTest
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities caps=DesiredCapabilities.chrome();
		caps.setBrowserName("chrome");
		caps.setPlatform(Platform.VISTA);
		driver=new RemoteWebDriver(new URL(nodeurl), caps);
	}
	
	@Test
	public void simpletest()
	{
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Test run successfully");
	}
}
