package challenger.core;

import static org.testng.Assert.assertTrue;
import java.util.Objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
	protected String pageUrl;
	protected String xPathValidator;
	
	public void Open()
	{
		WebDriverController.OpenPage(pageUrl);
	}
	
	public Boolean isOpen()
	{
		WebElement element = WebDriverController.GetWebElement(By.xpath(xPathValidator));
		return (element != null && Objects.equals(pageUrl,WebDriverController.GetCurrentPage()));
	}
	
	public void ValidateOpen()
	{
		assertTrue(isOpen(), String.format("ValidateOpen() Error: Expected '%s' to be open but current page is '%s'", pageUrl, WebDriverController.GetCurrentPage()));
	}
}
