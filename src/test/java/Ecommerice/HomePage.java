package Ecommerice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import Resources.JiraPolicy;
import pageObjects.CheckOut;
import pageObjects.CreateAccount;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.Shopping;

public class HomePage extends Base{
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=intilializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("URL is opened");
	}
	@JiraPolicy(logTicketReady=true)
	@Test(dataProvider="getData")

	public void PageNavigation(String email, String password) throws IOException, InterruptedException
	{


		Assert.assertEquals(driver.getTitle(), "My Store");
		log.info("Validate Homepage");
		driver.manage().window().maximize();
		//Invoke landing page
		LandingPage landing= new LandingPage(driver);
		landing.getLogin();
		log.info("Login Successfully");

		//Create Account
		CreateAccount account= new CreateAccount(driver);
		account.getEmail().sendKeys(email);
		account.getSubmit().click();
		Thread.sleep(10000);
		if(account.getErrorMessage().equals("An account using this email address has already been registered. Please enter a valid password or request a new one."))
		{
			//Login
			LoginPage login= new LoginPage(driver);	   
			login.getEmail().sendKeys(email);
			login.getPassword().sendKeys(password);
			//login.getLogin().click();
			log.info("Existed customer");


		}else{
			log.info("Add new Account");
			account.getTitle().click();
			account.getFirstName().sendKeys("Anas");
			account.getLastName().sendKeys("Satti");
			account.getPassword().sendKeys("Anass");
			account.DOB();
			//Client Address
			account.getAddress_lasttName().sendKeys("Anas");
			account.getAddress_firstName().sendKeys("Satti");
			account.getcompany().sendKeys("DeepInsughts");
			account.getAddressOne().sendKeys("Doha, Qatar,00000,DeepInsughts");
			account.getCity().sendKeys("London");
			account.stateSelection();
			account.getpostCode().sendKeys("00000");
			account.getCountry();
			account.getAddressLine2().sendKeys("Apartment 3, second floor");
			account.getAdditionalInformation().sendKeys("Test");
			account.gethomePhone().sendKeys("+974503262");
			account.getMobilephone().sendKeys("97450303262");
			account.getAddressAlias().clear();
			account.getAddressAlias().sendKeys("Doha, Qatar");
			account.RegisterUser().click();
			account.getLogout().click();
			driver.wait(3000);
		}
		//Shopping
		log.info("Shopping Start ");
		Shopping shop=new Shopping(driver);
		shop.getHomepage().click();
		//Scroll Down 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		//Buy Item
		String [] items= {"Blouse","Printed Dress"};
		int size=	shop.getProductLists().size();
		for(int i=0;i<=size;i++)
		{
			if(shop.getProductLists().get(i).getText().equals(items))
			{

				Actions a = new Actions(driver);
				a.moveToElement(shop.getfeaturedItem(), 1, 1).click().perform();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				shop.getAddItem().click();
			}
		}
		//shop.getItem().click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		shop.getCheckOut();


		//CheckOut
		log.info("CheckOut");
		CheckOut check=new CheckOut(driver);
		String inStock= check.getInstock().getText();
		if(inStock.equals("In stock"))
		{
			//check.getCountineCheckOut().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			check.getOrderComment().sendKeys("I am satisfy with way you display your products");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//check.getCountineCheckOut().click();
			driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			check.getTerms().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			check.getLastCheckup().click();
			check.getSignOut().click();
			//  check.getCountineCheckOut().click();
			//   check.getContinueShopping().click();
		}

	}


	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[1][2];
		//0th row

		data[0][0]="anasssattis@gmail.com";
		data[0][1]="Anass";
		return data;
	}		 

}
