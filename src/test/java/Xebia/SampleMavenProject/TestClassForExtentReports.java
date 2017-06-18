package Xebia.SampleMavenProject;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestClassForExtentReports {
  
	
  @Test
  public void testcase1() {
	  Assert.assertTrue(true);
  }
  @Test
  public void testcase2() {
  Assert.assertTrue(false);
  }
  
  @Test
  public void testcase3() throws Exception {
	  throw new SkipException("The method is skipped");
  }
  
  @Test
  public void testcase4() {
  Assert.assertTrue(true);
  }
  
  @Test
  public void testcase5() {
	  Assert.assertTrue(false);
  }






}
