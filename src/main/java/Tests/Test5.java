package Tests;

import org.testng.annotations.Test;

import FlipKart.FlipKart.App;
import PageObjects.Cart;
import PageObjects.Login;
import PageObjects.ProductPage;
import PageObjects.Search;

public class Test5 extends App{


	private String testCaseID = "TC_005";
	
/*	@BeforeTest
	public void preTest(){

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
*/
	@Test
	public void test4(){
		reports.startTest("Search","Search text");
		Login.navigateToLogin(driver);
		try {
			Login.loginToApp(driver, testCaseID);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = Cart.deleteFromCart(driver, testCaseID);
		driver = Search.textSearch(driver, testCaseID);
		driver = ProductPage.addToCart(driver, testCaseID);
	}
	
	
}
