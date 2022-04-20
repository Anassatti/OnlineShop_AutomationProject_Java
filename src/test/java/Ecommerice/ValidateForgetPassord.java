package Ecommerice;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Resources.Base;
import Resources.JiraPolicy;
import pageObjects.ForgetPassword;


public class ValidateForgetPassord extends Base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initilize() throws IOException
	{
		driver=	intilializeDriver();
		 driver.get(prop.getProperty("url"));
	}
	@JiraPolicy(logTicketReady=true)
	@Test
	public void ForgetPasswordRetrieve() 
	{
   ForgetPassword forget= new ForgetPassword(driver);
  
   forget.getSignin();
   forget.getForgetPassword().click();
  //forget.AdduserEmail().sendKeys("anasssattis@gmail.com");
   forget.Retrieve().click();
   //String successMessage=forget.ConfirmationMesage().getText();
	//Is menu displayed
  //   Assert.assertTrue(forget.ConfirmationMesage().isDisplayed());
     log.info("Successfully retrieve password");
	   
	}
@AfterTest
public void teardown()
{
	driver.close();
}
}
