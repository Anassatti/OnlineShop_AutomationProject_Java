package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Base {
	public static WebDriver driver;
	public  Properties prop;
	
	public WebDriver intilializeDriver()throws IOException
	{
		
		 prop= new Properties();
		FileInputStream fi= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		
		prop.load(fi);
		
		String browserName= prop.getProperty("browser");
	//	String browserName= System.getProperty("browser");
		if(browserName.equals("chrome"))
		{
		
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe");
			// driver= new ChromeDriver();
			 //headless chrome driver
			 ChromeOptions options= new ChromeOptions();
			 if(browserName.contains("headless"))
			 {
				 options.addArguments("headless");
			 }
			 
			 driver= new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		else if (browserName.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\geckodriver.exe");
			 driver= new FirefoxDriver();
			 driver.manage().window().maximize();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\msedgedriver.exe");
			 driver= new EdgeDriver();
			 driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
			
	
		
	}
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot tk=(TakesScreenshot) driver;
		File source=tk.getScreenshotAs(OutputType.FILE);
		String destentionFile= System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destentionFile));
		return destentionFile;
	}
	
	public File getScreenShotJira(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot tk=(TakesScreenshot) driver;
		File source=tk.getScreenshotAs(OutputType.FILE);
		return source;
	}
	

	
	}

	


