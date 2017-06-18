package Xebia.SampleMavenProject;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CookiesManagement {
	
	WebDriver driver;
	@Test
	public void fetchcookies(){
		 WebDriver driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.get("https://www.google.com");
		  
		  //set cookies
		  Cookie abc = new Cookie("Nitin","TestValue");
		  driver.manage().addCookie(abc);
		  
		  //get cookies
		  Set<Cookie> cookies = driver.manage().getCookies();
		  
		  for(Cookie currentcookie: cookies){
			  System.out.println("Cookie name is --------" + currentcookie.getName());
			  System.out.println("Cookie domain is --------" + currentcookie.getDomain());
			  System.out.println("Cookie value is --------" + currentcookie.getValue());
			  System.out.println("Cookie expiry is --------" + currentcookie.getExpiry());  
		  }
	}

}
