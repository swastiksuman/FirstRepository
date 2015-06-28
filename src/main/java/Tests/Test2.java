package Tests;


import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FlipKart.FlipKart.App;
import PageObjects.Login;



public class Test2 extends App{
	
	public WebDriver driver;
	
	@BeforeTest
	public void preTest(){
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void afterTestCleanUp(){
		driver.close();
		driver.quit();
	}
	
	@Test
	public void test1(){
		Login.navigateToLogin(driver);
		Login.loginToApp(driver, "swastiksuman@gmail.com", "elnino", "Swastik");
	}
	
	
}