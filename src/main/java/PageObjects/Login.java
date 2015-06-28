package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Login{
	
	
	
	public static WebDriver navigateToLogin(WebDriver driver){
		
		driver.get("http://www.flipkart.com");
		driver.findElement(By.linkText("Login")).click();
		return driver;
	}
	
	public static WebDriver loginToApp(WebDriver driver, String user, String pass, String userFirstName){
		/*List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
		
		for(WebElement everyFrame : frameList){
			System.out.println(everyFrame.getText());
		}*/
		
		//driver.switchTo().frame(0);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.cssSelector(".fk-input.login-form-input.user-email")).sendKeys(user);
		driver.findElement(By.cssSelector(".fk-input.login-form-input.user-pwd")).sendKeys(pass);		
		driver.findElement(By.cssSelector(".submit-btn.login-btn.btn")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='fk-mainhead-id']/div[1]/div/div[2]/div[1]/ul/li[7]/a")).getText(), "Hi "+userFirstName+ "!");
		/*
		if (driver.findElement(By.xpath("//*[@id='fk-mainhead-id']/div[1]/div/div[2]/div[1]/ul/li[7]/a"))){
			System.out.println("Login Successful");
		}*/
		return driver;
	}
	
	
}