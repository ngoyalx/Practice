package Xebia.SampleMavenProject;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FramesHandling {
	
	WebDriver driver;
	
	
	@Test
	public void frameHandling(){
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hdfcbank.com");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait mywait = new WebDriverWait(driver, 15);
		WebElement popup = driver.findElement(By.xpath("//div[@class='popup-homePageBanner']"));
		mywait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='popup-homePageBanner']")));
		if(popup.isDisplayed()){
			driver.findElement(By.xpath("//div[@id='cee_closeBtn']")).click();
		}
		WebElement loginButton = driver.findElement(By.xpath("//a[@id='loginsubmit']"));
		mywait.until(ExpectedConditions.visibilityOf((loginButton)));
		loginButton.click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		for(String window: allwindows){
			if(!window.equals(parentWindow)){
				driver.switchTo().window(window);
				System.out.println(driver.getTitle());
				if(driver.getTitle().toLowerCase().contains("netbanking")){
					driver.findElement(By.xpath("(//a[@class='btn btn-default redBtn'])[2]")).click();
					break;
				}
			}
		}
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.switchTo().frame("login_page");
		mywait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='pwd_field']")));
		driver.findElement(By.xpath("//input[@class='input_password']")).sendKeys("45006263");
		
		
	}

}
