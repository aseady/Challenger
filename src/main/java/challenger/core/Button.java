package challenger.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Button extends BaseElement{

	public Button(By by) {
		super(by);
	}
	
	public void Click()
	{
		WebElement element = FindElement();
		if(element != null)
		{
			element.click();
		}
	}
}
