package Xebia.SampleMavenProject;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class OpenNewTab {
	
 WebDriver driver;
 
  @Test
  public void f() throws AWTException {
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	WebDriverWait mywait = new WebDriverWait(driver, 15);
	driver.get("https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=en");
	driver.findElement(By.xpath("//span[@id='BirthMonth']")).click();
	mywait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='goog-menu goog-menu-vertical']"))));
	List<WebElement> months = driver.findElements(By.xpath("//div[@class='goog-menu goog-menu-vertical']/div/div"));
	for(WebElement e: months){
		if((e.getAttribute("innerText")).equalsIgnoreCase("March")){
			e.click();
		}
	}
	/*//driver.get("https://www.google.com");
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_T);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_T);
	try{
	WebElement body = driver.findElement(By.cssSelector("body"));
	body.sendKeys(Keys.CONTROL + "t");
	}
	catch(Exception e){
		e.printStackTrace();
	}
  }*/
	
	
}
}
