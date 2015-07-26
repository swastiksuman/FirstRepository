package FlipKart.FlipKart;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
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
import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;


	

	public class App {

		public static ExtentReports reports = ExtentReports.get(App.class);
		public WebDriver driver;
		public static Logger Log = Logger.getLogger("devpinoyLogger");
		
		
		@BeforeSuite
		public void beforeSuite(){
			System.out.println("BeforeSuite");
			Log.debug("________________Suite Started_____________________");
			reports.init("V:\\GitRepository\\FlipKart\\reports.html", true);
			
		}
		
		@AfterSuite
		public void afterSuite(){
			System.out.println("AfterSuite");
			reports.endTest();
			Log.debug("_________________SuiteEnds_______________");
		}
		
			
		
		@BeforeTest
		@Parameters("browser")
		public void initEverything(String browser){
			System.out.println("BeforeClass");
			if(browser.equalsIgnoreCase("firefox")){
				driver = new FirefoxDriver();
				Log.debug("Firefox Driver initiated");
			}
			else if(browser.equalsIgnoreCase("ie")){
				System.setProperty("webdriver.ie.driver","V:\\Jars\\IEdriverServer.exe");
				driver = new InternetExplorerDriver();
				
			}
			else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver","V:\\Jars\\chromedriver.exe");
				driver = new ChromeDriver();
				
			}
			else if(browser.equalsIgnoreCase("PhantomJS")){
			}
			else if(browser.equalsIgnoreCase("HTMLUnitDriver")){
				driver = new HtmlUnitDriver();
			}
			
			driver.manage().window().maximize();
		}
		
		@AfterTest
		public void reportThings(){
			reports.endTest();
			driver.close();
			driver.quit();
			
		}

}