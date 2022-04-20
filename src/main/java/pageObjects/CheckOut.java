package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOut {
	
	public WebDriver driver;
	public CheckOut(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By itemAvailablity= By.xpath("//span[contains(text(),'In stock')]"); 
	By ProceedCheckOut= By.linkText("Proceed to checkout"); 
	By orderComment=By.cssSelector("textarea[name='message']");
	By terms=By.xpath("//input[@id='cgv']");
	By continueShopping= By.xpath("//i[@class='icon-chevron-left left']");
	By lastCheckup=By.cssSelector("button.button:nth-child(4)");
	By SignOut= By.cssSelector("a[class='logout']");
	public WebElement getInstock()
	{
		return driver.findElement(itemAvailablity);
	}
	
	public WebElement getCountineCheckOut()
	{
		return driver.findElement(ProceedCheckOut);
	}
	
	public WebElement getOrderComment()
	{
		return driver.findElement(orderComment);
	}
	
	public WebElement getTerms()
	{
		return driver.findElement(terms);
	}
	public WebElement getContinueShopping()
	{
		return driver.findElement(continueShopping);
	}
	public WebElement getLastCheckup()
	{
		return driver.findElement(lastCheckup);
	}
	public WebElement getSignOut()
	{
		return driver.findElement(SignOut);
	}

}
