package Xebia.SampleMavenProject;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MahipalHDFCTest {
		
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hdfcbank.com/");
		//Thread.sleep(5000L);
	//driver.findElement(By.id("cee_closeBtn")).click();
	//String win=driver.getWindowHandle();
	driver.findElement(By.id("loginsubmit")).click();
	Thread.sleep(5000L);
			Set<String> win1 = driver.getWindowHandles();
	List<WebElement> elems= driver.findElements(By.xpath("//a[contains(text(),'Continue to NetBanking')]"));
	elems.get(1).click();
	Thread.sleep(5000L);
	driver.findElement(By.xpath("//input[contains(name,'fldLoginUserId')]")).sendKeys("nitingoyalbc");
	
	
	}
	
}
