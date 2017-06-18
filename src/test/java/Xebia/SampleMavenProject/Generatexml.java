package Xebia.SampleMavenProject;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XMLParser;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Generatexml 
{
	@Test
	public void setxml() {
		
	  
		XmlSuite createsuite=new XmlSuite();
		createsuite.setName("Suite");
		createsuite.setVerbose(3);
		
		createsuite.addListener("Xebia.SampleMavenProject.RetryListner");
		
		
		XmlTest createtest=new XmlTest(createsuite);
		createsuite.setName("Test");

		XmlClass createclass=new XmlClass(TestNGTestClass1.class);
		
		List<XmlClass> list=new ArrayList<>();
		list.add(createclass);
		
		createtest.setXmlClasses(list);
		
		List<XmlSuite> suitelist=new ArrayList<>();
		suitelist.add(createsuite);
		
		TestNG tng=new TestNG();
		tng.setXmlSuites(suitelist);
		tng.run();
		
		
  }
}
