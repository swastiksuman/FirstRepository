package FlipKart.FlipKart;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;



	

	public class App {

		public ExtentReports reports = ExtentReports.get(App.class);
		
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
		
			
		@BeforeClass
		public void initEverything(){
			System.out.println("BeforeClass");
		}
		
		@AfterClass
		public void reportThings(){
			System.out.println("AfterClass");
		}

}