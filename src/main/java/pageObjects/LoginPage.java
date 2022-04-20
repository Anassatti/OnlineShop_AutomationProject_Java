package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	By signin= By.xpath("//a[@class='login']");
	By email= By.id("email");
	By password=By.cssSelector("input[id='passwd']");
	By login= By.xpath("//button[@name='SubmitLogin']");

	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getSignin()
	{
		return driver.findElement(signin);
	}
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
}
