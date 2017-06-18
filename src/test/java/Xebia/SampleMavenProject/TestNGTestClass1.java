package Xebia.SampleMavenProject;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomeListner.class)
public class TestNGTestClass1 {
  
	
  @Test(retryAnalyzer=Retry.class)
  public void testcase1() 
  {
	 Assert.assertTrue(true);
	 System.out.println("Test case 1 should pass");
  }
  
  @Test(retryAnalyzer=Retry.class,enabled=false)
  public void testcase2() 
  {
	 Assert.assertTrue(false);
	 System.out.println("Test case 2 should fail");
  }

}
