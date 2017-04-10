package challenger.core;

import org.openqa.selenium.By;

public class Image extends BaseElement{

	public Image(By by) {
		super(by);
	}
	
	// TODO: Implement an image verification algorithm which downloads the Image page element then compares each pixel against the baselineImage
	public void ValidateImage(String baselineImage)
	{
		return;
	}
}
