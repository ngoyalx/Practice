package Xebia.SampleMavenProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;



public class IELaunch {
	WebDriver driver;
	
	@Test
	public void launchIE(){
		/*System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\drivers\\IEDriverServer.exe");
	    DesiredCapabilities iecapabilities = DesiredCapabilities.internetExplorer();
	    iecapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	    iecapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
	    driver = new InternetExplorerDriver(iecapabilities);*/
	    
	    System.setProperty("webdriver.safari.noinstall", "true");
	    driver = new SafariDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://www.tronc.com");
	    WebElement button = driver.findElement(By.xpath("//div[@class='carousel-caption-content-fullstory']"));
	    /*for(WebElement e : links){
	    	System.out.println(e.toString());
	    }*/
	}
	
	

}
