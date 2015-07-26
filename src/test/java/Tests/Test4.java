package Tests;

import org.testng.annotations.Test;

import FlipKart.FlipKart.App;
import PageObjects.Login;
import PageObjects.ProductPage;
import PageObjects.Search;

public class Test4 extends App{

	private String testCaseID = "TC_004";
	
/*	@BeforeTest
	public void preTest(){

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
*/
	@Test
	public void test4(){
		reports.startTest("Search again","Search text");
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
		Search.textSearch(driver, testCaseID);
		ProductPage.addToCart(driver, testCaseID);
	}

}
