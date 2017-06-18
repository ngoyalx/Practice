package Xebia.SampleMavenProject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.IParameterizable;
import org.testng.annotations.ITestAnnotation;


public class RetryListner implements IAnnotationTransformer{
  

	@Override
	public void transform(ITestAnnotation testannotation, Class testClass,
						  Constructor testConstructor, Method testMethod)	{
		
		IRetryAnalyzer retry = testannotation.getRetryAnalyzer();
		
		if (retry == null)	{
			testannotation.setRetryAnalyzer(Retry.class);
		}
		
		/*if(testannotation.getEnabled()==false){
			testannotation.setEnabled(true);
		}
		*/

	}
}
