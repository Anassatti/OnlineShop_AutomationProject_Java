package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	private By signin= By.xpath("//a[@class='login']");
	private By forgetPassword= By.xpath("//a[@title='Recover your forgotten password']");
	private By title = By.tagName("title");

	
	  public LandingPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			  this.driver=driver;
		}
	  
	  public WebElement getSignin()
		{
			return driver.findElement(signin);
		}
	  
	  public ForgetPassword forGotPassword()
	  {
		  driver.findElement(forgetPassword).click();
		return new ForgetPassword(driver);
	  }
	  public WebElement gettitle()
	  {
	  	  return driver.findElement(title);
	  }
	  public LoginPage getLogin()
	  {
		  LoginPage login=new LoginPage(driver);
		   driver.findElement(signin).click();
		  return login;
	  }
}
