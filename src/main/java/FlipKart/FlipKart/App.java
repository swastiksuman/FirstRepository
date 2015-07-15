package FlipKart.FlipKart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;


	

	public class App {

		public ExtentReports reports = ExtentReports.get(App.class);
		public WebDriver driver;
		
		
		@BeforeSuite
		public void beforeSuite(){
			System.out.println("BeforeSuite");
			reports.init("V:\\GitRepository\\FlipKart\\reports.html", true);
		}
		
		@AfterSuite
		public void afterSuite(){
			System.out.println("AfterSuite");
			reports.endTest();
		}
		
			
		@BeforeTest
		@Parameters("browser")
		public void initEverything(String browser){
			System.out.println("BeforeClass");
			if(browser.equalsIgnoreCase("firefox")){
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("ie")){
				System.setProperty("webdriver.ie.driver","V:\\Jars\\IEdriverServer.exe");
				driver = new InternetExplorerDriver();
				
			}
			else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver","V:\\Jars\\chromedriver.exe");
				driver = new ChromeDriver();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(browser.equalsIgnoreCase("PhantomJS")){
			}
			
		}
		
		@AfterTest
		public void reportThings(){
			System.out.println("AfterClass");
			driver.close();
			driver.quit();
			
		}

}