package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {
	public WebDriver driver;
	private By signin= By.xpath("//a[@class='login']");
	private By email= By.id("email_create");
	private By submit= By.xpath("//button[@name='SubmitCreate']");
	private By title= By.cssSelector("input[id='id_gender1']");
	private By firstName= By.id("customer_firstname");
	private By lastName= By.id("customer_lastname");
	private By password= By.id("passwd");
	private By selectDate= By.id("days");
	private By selectMonth= By.id("months");
	private By selectYear= By.id("years");
	
	//Address
	private By firstName_address= By.xpath("//input[@id='firstname']");
	private By lastName_address= By.xpath("//input[@id='lastname']");
	private By comanyName_address= By.xpath("//input[@id='company']");
	private By address1=  By.cssSelector("input[name='address1']");
	private By addressLine2=  By.cssSelector("input[name='address2']");
	private By city= By.cssSelector("input[id='city']");
	private By state= By.cssSelector("select[id='id_state']");
	private By postCode= By.id("postcode");
	private By country= By.cssSelector("select[id='id_country']");
	private By mobilePhone= By.cssSelector("input[id='phone_mobile']");
	private By homePhone= By.cssSelector("input[id='phone']");
	private	By addressAlias= By.cssSelector("input[id='alias']");
	private	By additionalInformation= By.cssSelector("textarea[id='other']");
	private By register= By.cssSelector("button[id='submitAccount']");
	private By logOut= By.xpath("//a[@class='logout']");
	private By existAccount= By.id("create_account_error");
	
	
	public CreateAccount(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public LoginPage getSignin()
	{
		LoginPage SignIn= new LoginPage(driver);
		 driver.findElement(signin).click();
		 return SignIn;
	}
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getSubmit()
	{
		return driver.findElement(submit);
	}
	public String getErrorMessage()
	{
		return driver.findElement(existAccount).getText();
	}
	
	
	
    
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getFirstName()
	{
		return driver.findElement(firstName);
	}
	public WebElement getLastName()
	{
		return driver.findElement(lastName);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public void DOB()
	{
		WebElement Dateoption=driver.findElement(selectDate);
		WebElement Monthoption= driver.findElement(selectMonth);
		WebElement Yearoption= driver.findElement(selectYear);
		Select dateOB= new Select(Dateoption);
		dateOB.selectByValue("9");
		Select monthOB= new Select(Monthoption);
		monthOB.selectByValue("9");
		Select yearOB= new Select(Yearoption);
		yearOB.selectByValue("1992");	
	}
	//Client address
	
	public WebElement getAddress_firstName()
	{
		return driver.findElement(firstName_address);
	}
	
	public WebElement getAddress_lasttName()
	{
		return driver.findElement(lastName_address);
	}
	public WebElement getcompany()
	{
		return driver.findElement(comanyName_address);
	}
	
	
	public WebElement getAddressOne()
	{
		return driver.findElement(address1);
	}
	public WebElement getCity()
	{
		return driver.findElement(city);
	}
	public void stateSelection()
	{
		Select stateName= new Select(driver.findElement(state));
		stateName.selectByVisibleText("Colorado");
			
	}
	public WebElement getpostCode()
	{
		return driver.findElement(postCode);
	}
	public WebElement getCountry()
	{
		return driver.findElement(country);
	}
	public WebElement getMobilephone()
	{
		return driver.findElement(mobilePhone);
	}
	public WebElement gethomePhone()
	{
		return driver.findElement(homePhone);
	}
	public WebElement getAddressAlias()
	{
		return driver.findElement(addressAlias);
	}
	
	public WebElement getAddressLine2()
	{
		return driver.findElement(addressLine2);
	}
	
	public WebElement getAdditionalInformation()
	{
		return driver.findElement(additionalInformation);
	}
	public WebElement RegisterUser()
	{
		return driver.findElement(register);
	}
	public WebElement getLogout()
	{
		return driver.findElement(logOut);
	}
	
	

	

}
