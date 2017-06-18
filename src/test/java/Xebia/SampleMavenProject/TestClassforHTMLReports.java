package Xebia.SampleMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClassforHTMLReports {
  
  @Test
  public void f() {
	  
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\drivers\\chromedriver.exe" );
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("http://www.ontestautomation.com/files/report_test.html");
	         
	    for (int i = 1; i <=5; i++) {
	        WebElement el = driver.findElement(By.id("textfield" + Integer.toString(i)));
	        Assert.assertEquals(el.getAttribute("value"), "Text field " + Integer.toString(i));
	    }
	         
	    driver.close(); 
  }
}
