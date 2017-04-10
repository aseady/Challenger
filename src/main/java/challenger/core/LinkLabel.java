package challenger.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LinkLabel extends BaseElement{

	public LinkLabel(By by) {
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
