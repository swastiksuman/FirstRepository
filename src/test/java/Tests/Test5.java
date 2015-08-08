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
		reports.startTest("Search and add to cart","Search text");
		
		try {
			Login login = new Login();
			login.navigateToLogin(driver);
			login.loginToApp(driver, testCaseID);
			Cart cart = new Cart();
			cart.deleteFromCart(driver, testCaseID);
			Search search = new Search();
			search.textSearch(driver, testCaseID);
			ProductPage prodPage = new ProductPage();
			prodPage.addToCart(driver, testCaseID);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
