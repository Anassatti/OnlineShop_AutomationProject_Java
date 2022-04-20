package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPassword {
	
	public WebDriver driver;
	private By signin= By.xpath("//a[@class='login']");
	private By forgetPassword= By.xpath("//a[@title='Recover your forgotten password']");
	private By userEmail= By.cssSelector("input[id='email']");
	private By retrievePassword= By.xpath("//button[@class='btn btn-default button button-medium']");
	private By successMessage= By.xpath("//p[@class='alert alert-success']");
	public ForgetPassword(WebDriver driver)
	{
		this.driver=driver;
	}

	
	
	public LoginPage getSignin()
	{
		LoginPage SignIn= new LoginPage(driver);
		 driver.findElement(signin).click();
		return SignIn;
	}
	
	public WebElement getForgetPassword()
	{
		return driver.findElement(forgetPassword);
	}
	public WebElement AdduserEmail()
	{
		return driver.findElement(userEmail);
	}
	public WebElement Retrieve()
	{
		return driver.findElement(retrievePassword);
	}
	public WebElement ConfirmationMesage()
	{
		return driver.findElement(successMessage);
	}
}
