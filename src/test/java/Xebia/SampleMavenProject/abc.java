package Xebia.SampleMavenProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class abc {
	
	static WebDriver driver;
	 static String url = "http://hansrajcollege.ac.in";
	 // static DesiredCapabilities caps;

	 public static void main(String[] args) throws InterruptedException {

	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ngoyal\\git\\Localtestrepository\\SampleMavenProject\\src\\main\\java\\drivers\\chromedriver.exe");

	  driver = new ChromeDriver();

	  driver.manage().window().maximize();

	  driver.get(url);
	  WebDriverWait wait = new WebDriverWait(driver, 10);

	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  WebElement acadmic = driver.findElement(By.xpath("//ul[@id='MenuBar1']/li[3]/a"));
	  
	  
	  WebElement course = driver.findElement(By.xpath("//*[@id='MenuBar1']/li[3]/ul/li[3]/a"));
	  WebElement science = driver.findElement(By.xpath("//*[@id='MenuBar1']/li[3]/ul/li[3]/ul/li[1]/a"));

	  WebElement anthra = driver.findElement(By.xpath("//*[@id='MenuBar1']/li[3]/ul/li[3]/ul/li[1]/ul/li[1]/a"));
	  Actions act = new Actions(driver);
	  act.moveToElement(acadmic).build().perform();
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@class='MenuBarSubmenuVisible']"))));
	  act.moveToElement(course).build().perform();
	  Thread.sleep(2000);
	  act.moveToElement(science).build().perform();
	  Thread.sleep(2000);
	  act.click(anthra).build().perform();

	 }

}
