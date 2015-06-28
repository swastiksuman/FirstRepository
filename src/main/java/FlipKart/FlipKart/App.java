package FlipKart.FlipKart;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class App 
{

	@BeforeSuite
	public void beforeSuite(){
		System.out.println("BeforeSuite");
	}
	
	@AfterSuite
	public void afterSuite(){
		System.out.println("AfterSuite");
	}
	
		
	@BeforeClass
	public void initEverything(){
		System.out.println("BeforeClass");
	}
	
	@AfterClass
	public void reportThings(){
		System.out.println("AfterClass");
	}

}