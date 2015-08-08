package PageObjects;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Exception.FilloException;
import Fillo.Connection;
import Fillo.Fillo;
import Fillo.Recordset;
import FlipKart.FlipKart.App;

public class Login extends PageObject{
	
	
	
	public WebDriver navigateToLogin(WebDriver driver){
		
		driver.get("http://www.flipkart.com");
		driver.findElement(By.linkText("Login")).click();
		return driver;
	}
	
	public boolean loginToApp(WebDriver driver, String TCID) throws Exception{
		/*List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
		
		for(WebElement everyFrame : frameList){
			System.out.println(everyFrame.getText());
		}*/
		
		//driver.switchTo().frame(0);
		String userName = null;
		String passWord = null;
		
		Fillo fillo = new Fillo();
		try {	
			Connection connection = fillo.getConnection("V://GitRepository//FlipKart//src//test//java//Resources//Datasheets.xls");
			Log.debug("Fillo Connection made");
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
			
			driver.findElement(By.cssSelector(".fk-input.login-form-input.user-email")).sendKeys(userName);
			driver.findElement(By.cssSelector(".fk-input.login-form-input.user-pwd")).sendKeys(passWord);
			reports.log(LogStatus.PASS, "The username and password was applied.");
			driver.findElement(By.cssSelector(".submit-btn.login-btn.btn")).click();

			Thread.sleep(5000);
			
			if(driver.findElements(By.linkText("Login")).size()==0){
				reports.log(LogStatus.PASS, "The user is logged in.");
			}else{
				reports.log(LogStatus.PASS, "The user is logged in.");
				Assert.fail("The user wasn't logged in.");
			}
			
			
			
		} catch (FilloException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Log.debug("TestCase: "+TCID+" error:" +e1.getMessage());
			Assert.fail();
			return false;
		} catch(Exception e){
			e.printStackTrace();
			Assert.fail();
			return false;
		}
		
		return true;
		
/*		
		WebDriverWait wait = new WebDriverWait(driver, 20L);
*/				
		/*Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.withMessage("Timed Out");
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='fk-mainhead-id']/div[1]/div/div[2]/div[1]/ul/li[7]/a")));
				
		if(driver.findElement(By.xpath("//*[@id='fk-mainhead-id']/div[1]/div/div[2]/div[1]/ul/li[7]/a")).getText().equals("Hi "+userName+ "!")){
			return true;	
		}	
		else{	
			return false;
		}*/
	}	
}
