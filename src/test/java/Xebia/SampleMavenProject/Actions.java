package Xebia.SampleMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions 
{
	WebDriver driver;
	
	WebDriverWait waitvar=new WebDriverWait(driver, 20);
	String attributetype;
	String attribute;
	
	public By byLocator(String AttributeType, String Attribute) throws Exception {
		String attr = AttributeType.toLowerCase();
		By by = null;

		try {
		    switch (attr) {
		    default:
			throw new Exception("Incorrect Attribute type mentioned");
		    case "css":
			by = By.cssSelector(Attribute);
			break;
		    case "xpath":
			by = By.xpath(Attribute);
			break;
		    case "class":
			by = By.className(Attribute);
			break;
		    case "id":
			by = By.id(Attribute);
			break;
		    case "name":
			by = By.name(Attribute);
			break;
		    case "text":
			by = By.linkText(Attribute);
			break;
		    case "tag":
			by = By.tagName(Attribute);
			break;
		    }
		} catch (Exception e) 
		{
		    e.printStackTrace();
		}
		return by;		
	}
	
	
	public boolean explicitwait(String waitcondition,String input) throws Exception
	{
		String wcond="waitcondition.toLowerCase()";
		
		try{
		switch(wcond)
		{
		case "elementvisible":
		waitvar.until(ExpectedConditions.visibilityOf(driver.findElement(byLocator(attributetype, attribute))));
		break;
		
		case "elementclickable":
			waitvar.until(ExpectedConditions.elementToBeClickable(byLocator(attributetype, attribute)));
			break;
		}
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

}
