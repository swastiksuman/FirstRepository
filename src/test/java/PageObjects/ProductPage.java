package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Exception.FilloException;
import Fillo.Connection;
import Fillo.Fillo;
import Fillo.Recordset;

public class ProductPage extends PageObject{

	
	public boolean addToCart(WebDriver driver, String testCaseID){
			
		
		try{
			driver.findElement(By.cssSelector(".btn-buy-now.btn-big.current")).click();
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(driver.findElement(By.id("item_count_in_cart_top_displayed")).getText());
		}catch(Exception e){
			Assert.fail();
			return false;
		}
		
		return true;
		
	}
	
}
