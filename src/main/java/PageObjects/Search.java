package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Exception.FilloException;
import Fillo.Connection;
import Fillo.Fillo;
import Fillo.Recordset;
import FlipKart.FlipKart.App;

public class Search extends App {
	public static WebDriver textSearch(WebDriver driver, String testCaseID){
		
		
		String textSearch = null;
		
		Fillo fillo = new Fillo();
		try {	
			Connection connection = fillo.getConnection("V://GitRepository//FlipKart//src//main//java//Resources//Datasheets.xls");
			String strQuery="Select * from Search where TC_ID='"+testCaseID+"'";
			Recordset recordset=connection.executeQuery(strQuery);
			System.out.println(recordset.getCount());
			List<String> rs = recordset.getFieldNames();
			for(String str:rs){
				System.out.println(str.toString());
			}
			
			recordset.moveFirst();
			textSearch = recordset.getField("textSearch").toString();
			
			
		} catch (FilloException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		driver.findElement(By.cssSelector("#fk-top-search-box")).sendKeys(textSearch);
		driver.findElement(By.cssSelector(".search-bar-submit.fk-font-13.fk-font-bold")).click();
		Assert.assertEquals(textSearch, driver.findElement(By.cssSelector(".cross.rmargin10")).getText());

		return driver;
	}
}
