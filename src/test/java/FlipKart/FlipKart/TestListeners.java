package FlipKart.FlipKart;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListeners extends TestListenerAdapter{

	public void onTestFailure(ITestResult tr){
		System.out.println("Failing the Test -"+tr.getName());
	}
	
	public void onTestSkipped(ITestResult tr){
		System.out.println("Skipping the Test -"+tr.getName());
	}
	
	public void onTestSuccess(ITestResult tr){
		System.out.println("Passing the Test -"+tr.getName());
	}
}
