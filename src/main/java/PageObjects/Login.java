package PageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Exception.FilloException;
import Fillo.Connection;
import Fillo.Fillo;
import Fillo.Recordset;

public class Login{
	
	
	
	public static WebDriver navigateToLogin(WebDriver driver){
		
		driver.get("http://www.flipkart.com");
		driver.findElement(By.linkText("Login")).click();
		return driver;
	}
	
	public static boolean loginToApp(WebDriver driver, String TCID) throws Exception{
		/*List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
		
		for(WebElement everyFrame : frameList){
			System.out.println(everyFrame.getText());
		}*/
		
		//driver.switchTo().frame(0);
		String userName = null;
		String passWord = null;
		
		Fillo fillo = new Fillo();
		try {	
			Connection connection = fillo.getConnection("V://GitRepository//FlipKart//src//main//java//Resources//Datasheets.xls");
			String strQuery="Select * from Login where TC_ID='"+TCID+"'";
			Recordset recordset=connection.executeQuery(strQuery);
			System.out.println(recordset.getCount());
			List<String> rs = recordset.getFieldNames();
			for(String str:rs){
				System.out.println(str.toString());
			}
			
			recordset.moveFirst();
			userName = recordset.getField("USER").toString();
			passWord = recordset.getField("PASS").toString();
			
			
		} catch (FilloException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		driver.findElement(By.cssSelector(".fk-input.login-form-input.user-email")).sendKeys(userName);
		driver.findElement(By.cssSelector(".fk-input.login-form-input.user-pwd")).sendKeys(passWord);		
		driver.findElement(By.cssSelector(".submit-btn.login-btn.btn")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(driver.findElement(By.xpath("//*[@id='fk-mainhead-id']/div[1]/div/div[2]/div[1]/ul/li[7]/a")).getText().equals("Hi "+userName+ "!")){
			return true;	
		}	
		else{	
			return false;
		}
	}	
}
	
	
