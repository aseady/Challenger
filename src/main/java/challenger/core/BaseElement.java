package challenger.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Objects;

import static org.testng.Assert.assertTrue;

public abstract class BaseElement {
	protected By sourceBy;
	
	public BaseElement(By by)
	{
		sourceBy = by;
	}
	
	protected WebElement FindElement()
	{
		return WebDriverController.GetWebElement(sourceBy);
	}
	
	
	public String GetInnerText()
	{
		String result = "";
		WebElement element = FindElement();
		if(element != null)
		{
			result = element.getText();
		}
		return result;
	}
	
	public String GetAttributeText(String attribute)
	{
		String result = "";
		WebElement element = FindElement();
		if(element != null)
		{
			result = element.getAttribute(attribute);
		}
		return result;
	}
	
	public Boolean GetEnabled()
	{
		WebElement element = FindElement();
		if(element != null)
		{
			return element.isEnabled();
		}
		return false;
	}
	
	public Boolean GetDisplayed()
	{
		WebElement element = FindElement();
		if(element != null)
		{
			return element.isDisplayed();
		}
		return false;
	}
	
	public void ValidateInnerText(String expectedValue)
	{
		String actualValue = GetInnerText();
		assertTrue(Objects.equals(actualValue,expectedValue), String.format("ValidateInnerText() Error: Expected value '%s' does not match actual value '%s'",expectedValue, actualValue));
	}
	
	public void ValidateAttributeText(String attribute, String expectedValue)
	{
		String actualValue = GetAttributeText(attribute);
		assertTrue(Objects.equals(actualValue,expectedValue), String.format("ValidateAttributeText() Error: Expected value '%s' does not match actual value '%s' for attribute '%s'",expectedValue, actualValue, attribute));
	}
	
	public void ValidateEnabled(Boolean expectedValue)
	{
		Boolean result = GetEnabled();
		assertTrue(Objects.equals(expectedValue,result), String.format("ValidateEnabled() Error: Expected value '%b' does not match actual value '%b'",expectedValue, result));
	}
	
	public void ValidateDisplayed(Boolean expectedValue)
	{
		Boolean result = GetDisplayed();
		assertTrue(Objects.equals(expectedValue,result), String.format("ValidateDisplayed() Error: Expected value '%b' does not match actual value '%b'",expectedValue, result));
	}
	
}
