package Xebia.SampleMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.List;


public class DeepakAssignment {
	WebDriver driver;
	
	
	@Test
	public void samplemethod() throws InterruptedException{
	
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("file:///C:/Users/ngoyal/Downloads/login_page.html");
	driver.findElement(By.xpath("//input[@name='email']")).sendKeys("user@example.com");
	driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("eW5PEXgz");
	driver.findElement(By.xpath("//input[@value='Continue']")).click();
	
	List<WebElement> allelements = driver.findElements(By.xpath("//input[starts-with(@name,'sp')]"));
	
	String secondaryPassword = "JcdmAB677B";
	char[] arr = secondaryPassword.toCharArray();
	for(int i=0;i<allelements.size();i++){
		if(allelements.get(i).isEnabled()){
			allelements.get(i).sendKeys(Character.toString(secondaryPassword.charAt(i)));
		}
	}
	//Thread.sleep(5000L);
	driver.findElement(By.xpath("//input[@type='button']")).click();
	
	}

}
