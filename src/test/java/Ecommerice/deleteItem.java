package Ecommerice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import Resources.Base;
import Resources.JiraPolicy;
import Resources.TestData;
import pageObjects.EmptyCart;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.Shopping;

public class deleteItem extends Base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	 private By SUTIssue=By.xpath("/html/body/h1");
	@BeforeTest()
	public void initialize() throws IOException
	{
		driver=intilializeDriver();
		driver.get(prop.getProperty("url"));
		//Error recovery feature in case there is an issue in SUT or in  TAS(Test automation solution)

		//In case SUT faced loading issue, should be  refreshed and load again

		
	}
	
	@JiraPolicy(logTicketReady=true)
	@Test(dataProvider="InputData", dataProviderClass=TestData.class)
	public void deleteShoppingItem(String email, String password)
	{
		EmptyCart cart=new EmptyCart(driver);
		//Login
		LoginPage login= new LoginPage(driver);	
		cart.getlogin();
		login.getEmail().sendKeys(email);
		login.getPassword().sendKeys(password);
		login.getLogin().click();
		cart.isCartEmpty();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if( cart.deleteVerification().getText().equals("Your shopping cart is empty."))
		{
			log.info("Shopping Start ");
			Shopping shop=new Shopping(driver);
			cart.startShopping();
			//Scroll Down 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,700)", "");
			//Buy Item
			shop.getItem().click();
			WebElement featuredItem = driver.findElement(By.cssSelector("ul#homefeatured>li:nth-of-type(1) a.product_img_link"));
			Actions a = new Actions(driver);
			a.moveToElement(featuredItem, 1, 1).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			shop.getAddItem().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			shop.getCheckOut();
			log.info("Delete Item");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			cart.getDeleteIem().click();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Assert.assertEquals(,);
			String text=cart.deleteVerification().getText();
			String expectedText="Your shopping cart is empty.";
			Assert.assertEquals(text,text );
			
			log.info("Item is Deleted");
			// Assert.assertEquals(land.gettitle().getText(), "FEATURED COURSES123");
		}else {

			log.info("Delete Item started");

			//cart.getlogin();
			////login.getEmail().sendKeys(email);
			//login.getPassword().sendKeys(password);
		//	login.getLogin().click();
			cart.mouseOver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			cart.checkOutClick();
			cart.getDeleteIem();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Verify item is deleted
			String text=cart.deleteVerification().getText();
			String expectedText="Your shopping cart is empty.";
			Assert.assertEquals(expectedText,text );
			log.info("Item is Deleted");
		}




	}
	@AfterTest
	public void tearDown()
	{
	   driver.close();
	}

}
