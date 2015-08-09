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

import com.relevantcodes.extentreports.LogStatus;

import FlipKart.FlipKart.App;
import PageObjects.Login;
import PageObjects.PageObject;



public class Test1 extends App{
	

	private String testCaseID = "TC_001";
	
	@Test
	public void test1(){	
		try{
		PageObject pgObj = new PageObject(driver, testCaseID);
		Login login = new Login();
		reports.startTest("Login and Logout","Check Login Successful");
		login.navigateToLogin(driver);
		reports.log(LogStatus.PASS, "Navigate to Login", "The user is in Login Page");
		login.loginToApp(driver, testCaseID);
		reports.log(LogStatus.PASS, "Login","Login was successful");
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		
	}
}