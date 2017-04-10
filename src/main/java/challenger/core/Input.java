package challenger.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Input extends BaseElement{

	public Input(By by) {
		super(by);
	}

	public void SendKeys(String text)
	{
		WebElement element = FindElement();
		if(element != null)
		{
			element.clear();
			element.sendKeys(text);
		}
	}
}
