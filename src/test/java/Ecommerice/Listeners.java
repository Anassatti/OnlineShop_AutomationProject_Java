package Ecommerice;
import java.io.File;
import java.io.IOException;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Resources.Base;
import Resources.ExtentReport;
import Resources.JiraPolicy;
import Resources.JiraServiceProvider;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraException;



public class Listeners extends Base implements ITestListener {
	ExtentTest test;
	ExtentReports extent=ExtentReport.getReport();
	//To run test in parallel and report all of them in the extent report
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	
	}


	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS,"Test Passed");
		
	}
	
	

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		  extentTest.get().fail(result.getThrowable());
			//WebDriver driver =null;
			String testMethodName =result.getMethod().getMethodName();

			try {
				driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch(Exception e)
			{
				
			}
			try {
				extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
				
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Jira Integration
		JiraPolicy jirapolicy=	result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class);
		boolean isTicketReady=jirapolicy.logTicketReady();
		if(isTicketReady)
		{
			System.out.println("Is ticket ready for Jira:"+isTicketReady);
			JiraServiceProvider jira= new JiraServiceProvider("https://auto82.atlassian.net","anasssattis@gmail.com","geZVtjjaiuZWpXNhbJlG27D0","AUT");
			String issueSummary= result.getMethod().getConstructorOrMethod().getMethod().getName()+" got failed due to some assertion and exception";
			//String issueDescription=result.getThrowable().getMessage()+"\n";
			//issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
			try {
				//Create Jira ticket
				 File screen=getScreenShotJira(testMethodName, driver);
			   Issue jiraID=jira.createJiraTicket("Bug", issueSummary, issueSummary);
			   //Attach screenshot for the bug
			   String issue=jiraID.toString();
			    jira.Attachment(issue,screen);
			    
			} catch (JiraException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
		
			
		}

		
	}




	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}


}
