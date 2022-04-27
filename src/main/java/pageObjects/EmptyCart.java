package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class EmptyCart {
	public WebDriver driver;
	private By deleteItem=By.cssSelector("a[title='Delete'] i");
	private By isItemDeleted=By.xpath("//*[@id='center_column']/p");
	//private By cartPosition=By.xpath("//a[@title='View my shopping cart']");
	
	private By checkOut= By.cssSelector("a[id='button_order_cart']");
	private By checkCart=By.xpath("//b[contains(text(),'Cart')]");
	private By shopping=By.cssSelector("a[class='home']");
	public EmptyCart(WebDriver driver)
	{
		this.driver=driver;
	}

	public LoginPage getlogin()
	{
		LoginPage login=new LoginPage(driver);
		login.getSignin().click();
		return login;
	}
	
	public WebElement getDeleteIem()
	{
		return driver.findElement(deleteItem);
	}
	
   public WebElement deleteVerification()
   {
	     
	   return driver.findElement(isItemDeleted);
   }
   
   public void mouseOver()
   {
	   Actions mouseOverClick= new Actions(driver);
	   WebElement cartPosition=driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
	   mouseOverClick.moveToElement(cartPosition).perform();
	
   }
   public void isCartEmpty()
   {
	   driver.findElement(checkCart).click();
   }
   
   public void checkOutClick()
   {
	    driver.findElement(checkOut).click();
   }
   public void startShopping()
   {
	    driver.findElement(shopping).click();
   }

}
