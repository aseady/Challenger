package challenger.core;

import challenger.core.Constants.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import static org.testng.Assert.assertTrue;

public final class WebDriverController {

	private static WebDriver driver;
	

	public static void StartDriver()
	{
		StartDriver(Constants.DEFAULT_DRIVERTYPE);
	}

	public static void StartDriver(String url)
	{
		StartDriver(url, Constants.DEFAULT_DRIVERTYPE);
	}

	public static void StartDriver(DriverType type)
	{
		if(driver != null)
		{
			driver.quit();
		}
		switch(type)
		{
			case CHROME:
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/webdrivers/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			default:
			case IE:
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/webdrivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
		}
	}

	public static void StartDriver(String url, DriverType type)
	{
		assertTrue(!url.isEmpty(), "WebDriverFactory.StartDriver() Error: No URL provided.");
		StartDriver(Constants.DEFAULT_DRIVERTYPE);
		driver.get(url);
	}	

	public static void StopDriver()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}

	public static void OpenPage(String url)
	{
		assertTrue(!url.isEmpty(), "WebDriverFactory.StartDriver() Error: No URL provided.");
		
		if(driver == null)
		{
			StartDriver();
		}
		driver.navigate().to(url);
	}
	
	public static String GetCurrentPage()
	{
		return driver.getCurrentUrl();
	}
	
	public static WebElement GetWebElement(By sourceBy)
	{
		// Try to find element until timeout
		WebElement element = null;
		long startTime = System.currentTimeMillis();
		while(element == null && (System.currentTimeMillis()-startTime) < Constants.FIND_ELEMENT_TIMEOUT)
		{
			element = driver.findElement(sourceBy);
		}
		return element;
	}
}
