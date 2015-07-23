package FlipKart.FlipKart;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListner implements IAnnotationTransformer{

	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		IRetryAnalyzer analyzer = annotation.getRetryAnalyzer();
		
		if(analyzer ==null){
			annotation.setRetryAnalyzer(Retry.class);
		}
	}
	
	
	
}
