package PageObjects;

import java.util.Collections;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import FlipKart.FlipKart.App;

public class Cart extends PageObject{

	
	public boolean deleteFromCart(WebDriver driver, String testCaseID){
		
		
		
		try{
			driver.findElement(By.cssSelector(".cart-label")).click();
			//Check if cart is empty
			if (driver.findElements(By.cssSelector(".empty-cart-message")).size() > 0){
				System.out.println("Cart is empty");
				return true;
			}		
			else{
				List<WebElement> removeList = driver.findElements(By.cssSelector(".cart-remove-item.fk-inline-block.fk-uppercase"));
				System.out.println(removeList.size());
				
				Collections.reverse(removeList);
				
				for(WebElement removeListIcon:removeList){
					removeListIcon.click();
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}catch(Exception e){
			Log.debug("TestCase: "+testCaseID+" failed "+e.getMessage());
			return false;
		}
		
		return true;
	}
	
	
}
