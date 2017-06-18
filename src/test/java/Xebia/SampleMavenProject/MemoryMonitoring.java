package Xebia.SampleMavenProject;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class MemoryMonitoring {
	
	
  @Test(priority=1)
  public void performanceMonitor_Firefox() {
	  WebDriver driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.get("https://www.seleniumbycharan.wordpress.com");
	  WebElement caption = driver.findElement(By.xpath("//h1[@class='site-title']"));
	  System.out.println("=====================Firefox Browser=====================");
	  System.out.println("Caption of the blog : " + caption.getText().toUpperCase());
	  getSystemUsage();
	  driver.close();
	  System.out.println("=====================*******************=====================");
  }
  
  @Test(priority=2)
  public void performanceMonitor_htmlunitdriver() {
	  HtmlUnitDriver fd= new HtmlUnitDriver();
	  fd.manage().window().maximize();
	  fd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  fd.get("https://www.seleniumbycharan.wordpress.com");
	  WebElement caption = fd.findElement(By.xpath("//h1[@class='site-title']"));
	  System.out.println("=====================HTMLUNITDRIVER Browser=====================");
	  System.out.println("Caption of the blog : " + caption.getText().toUpperCase());
	  getSystemUsage();
	  fd.close();
	  System.out.println("=====================*******************=====================");
  }
  
  private static void getSystemUsage() {
	  OperatingSystemMXBean operatingSystemMXBean = ManagementFactory
	  .getOperatingSystemMXBean();
	  for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()){
	  method.setAccessible(true);
	  if (method.getName().startsWith("get")&& Modifier.isPublic(method.getModifiers())) {
	  Object value;
	  try {
	  value = method.invoke(operatingSystemMXBean);
	  } catch (Exception e) {
	  value = e;
	  }
	  System.out.println(method.getName() + "=" + value);
	  }
	  }
	  }
}
