package Tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FlipKart.FlipKart.App;
import PageObjects.Login;



public class Test1 extends App{
	
	public WebDriver driver;
	private String testCaseID = "TC_001"; 
	
		
	
	@BeforeMethod
	public void preTest(){
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void afterTestCleanUp(){
		driver.close();
		driver.quit();
	}
	
	@Test(dataProvider = "test1")
	public void test1(String userName, String password, String firstName){
	
		Login.navigateToLogin(driver);
		Login.loginToApp(driver, "swastiksuman@gmail.com", "elnino#09", "Swaswtik");
	}
	
	@DataProvider(name="test1")
	public Object[][] getData(){
		return new Object[][] {{"swastiksuman@gmail.com", "elnino#09", "Swaswtik"},
			{"swastiksuman@gmail.com", "elnino#09", "Swastik"},
		};
	}
}