package Xebia.SampleMavenProject;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

public class FirefoxProfile {
	WebDriver driver;
  @Test
  public void f() {
	  
	  
	  //org.openqa.selenium.firefox.FirefoxProfile profile = new org.openqa.selenium.firefox.FirefoxProfile(new File("C:\\Users\\ngoyal\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\5s8ytyqe.Opentab"));
	  //profile.setPreference("browser.link.open_newwindow",3);
	  //profile.setPreference("browser.link.open_newwindow.restriction",0);
	  //profile.setPreference("services.sync.prefs.sync.browser.link.open_newwindow;true",false);
	  //profile.setPreference("browser.link.open_newwindow.disabled_in_fullscreen",false);
	  //profile.setPreference("browser.block.target_new_window",true);
	  
	 /* System.out.println("Opening default firefox");
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");*/
	 /* 
	  System.out.println("Opening firefox with profile");
	  driver = new FirefoxDriver(profile);
	  driver.manage().window().maximize();
	  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");*/
	  


	  	ProfilesIni profile = new ProfilesIni();
 
	  	org.openqa.selenium.firefox.FirefoxProfile myprofile = profile.getProfile("Opentab"); 
 
	  	WebDriver driver = new FirefoxDriver(myprofile);
	  	driver.manage().window().maximize();
	  
	  
  }
}
