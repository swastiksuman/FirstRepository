package PageObjects;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {

	
	public static WebDriver deleteFromCart(WebDriver driver, String testCaseID){
		
		driver.findElement(By.cssSelector(".cart-label")).click();
		//Check if cart is empty
		if (driver.findElements(By.cssSelector(".empty-cart-message")).size() > 0){
			System.out.println("Cart is empty");
			return driver;
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
			return driver;
		}
		
	}
	
	
}
