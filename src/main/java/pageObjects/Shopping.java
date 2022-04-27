package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Shopping {

	public  WebDriver driver;

	private By HomePage= By.linkText("Home");
	private By addCart= By.cssSelector("a[title='Add to cart'] span");
	private By shoppingItem= By.xpath("//a[@title='Blouse']");
	private By continueShopping= By.xpath("//i[@class='icon-chevron-left left']");
	private By checkOut= By.linkText("Proceed to checkout"); 
//	private By products=By.cssSelector("div[class*='product-container'] h5");
	private By products=By.cssSelector("div[class='right-block'] h5");
	//private By featuredItem=By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[1]/div/a[*]");
	private By featuredItem=By.cssSelector("a[class='product_img_link'] img[title*='Blouse']");
    private By proceedCheckOut= By.cssSelector("body.order.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 p.cart_navigation.clearfix:nth-child(8) a.button.btn.btn-default.standard-checkout.button-medium > span:nth-child(1)");
    private By productPrice= By.cssSelector("span[class='price product-price']");
    private By shoppingItems= By.cssSelector("div[class='right-block'] h5");
	public Shopping(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public List<WebElement> getProductLists()
	{
		return driver.findElements(products);
	}
	public List<WebElement> getProductPrice()
	{
		return driver.findElements(productPrice);
	}
	
	public WebElement getfeaturedItem()
	{
		return driver.findElement(featuredItem);
	}
	public WebElement getHomepage()
	{
		return driver.findElement(HomePage);
	}
	public WebElement getItem()
	{
		return driver.findElement(shoppingItem);
	}
	public  List<WebElement> getAddItem()
	{
		return  driver.findElements(addCart);
	}
	public WebElement getContinueShopping()
	{
		return driver.findElement(continueShopping);
	}
	public WebElement getProceedToCheckOut()
	{
		return driver.findElement(proceedCheckOut);
	}

	public CheckOut getCheckOut()
	{
		CheckOut checkout= new CheckOut(driver);
		driver.findElement(checkOut).click();
		return checkout;
	}

}
