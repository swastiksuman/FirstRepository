package FlipKart.FlipKart;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	int retryCount =0;
	int maxRetryCount = 1;
	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retryCount < maxRetryCount){
				System.out.println("Retrying test with "+result.getName()+" with status "+
						getResultStatusName(result.getStatus()));
				retryCount++;
				return true;
		}
		return false;
	}
	
	public String getResultStatusName(int status){
		String resultName = null;
		if(status==1)
			resultName ="SUCCESS";
		if(status==2)
			resultName = "FAILURE";
		if(status==3)
			resultName = "SKIP";
		return resultName;
	}
	
	

}
