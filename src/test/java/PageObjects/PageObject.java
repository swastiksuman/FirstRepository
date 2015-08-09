package PageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;






import FlipKart.FlipKart.App;

public class PageObject extends App{
	
	
	String filePath = null;
	String testCaseId = null;
	WebDriver driver;
	
	
	public PageObject(WebDriver driver, String testCaseID2) {
		// TODO Auto-generated constructor stub
		this.filePath = "\\Screens\\"+testCaseId+"\\";
		this.driver = driver;
		this.testCaseId = testCaseId;
		
		File file = new File(System.getProperty("user.dir").concat(filePath));
		if(file.exists()){
			file.delete();
			file.mkdir();
		}
		
	}

	public void clickOnWebElement(WebElement element){
		
		try{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("V:\\GitRepository\\Flipkart\\screenshot.png"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

	public void takeScreenshot(WebDriver driver) {
		// TODO Auto-generated method stub
		try{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("V:\\GitRepository\\Flipkart\\screenshot.png"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}


}
