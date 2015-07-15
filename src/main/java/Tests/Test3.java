package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import FlipKart.FlipKart.App;
import PageObjects.Login;
import PageObjects.Search;

public class Test3 extends App{

	private String testCaseID = "TC_003";
	
/*	@BeforeTest
	public void preTest(){

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
*/
	@Test
	public void test3(){
		reports.startTest("Search","Search text");
		Login.navigateToLogin(driver);
		try {
			Login.loginToApp(driver, testCaseID);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Search.textSearch(driver, testCaseID);
		
	}
}
