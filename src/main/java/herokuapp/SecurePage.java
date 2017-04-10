package herokuapp;

import org.openqa.selenium.By;
import challenger.core.*;

public class SecurePage extends BasePage {

	private Label flashMessageLabel = null;
	private Image forkMeImage = null;
	private Label headerTitleLabel = null;
	private Label pageDescriptionLabel = null;
	private Button logoutButton = null;
	private Label poweredByLabel = null;
	private LinkLabel elementalSeleniumLink = null;
	
	public SecurePage()
	{
		pageUrl = "https://the-internet.herokuapp.com/secure";
		xPathValidator = "//*[@id='content']/div/a/i";
	}
	
	public Label FlashMessageLabel()
	{
		return (this.flashMessageLabel != null) ? flashMessageLabel : new Label(By.id("flash"));
	}

	public Image ForkMeImage()
	{
		return (this.forkMeImage != null) ? forkMeImage : new Image(By.xpath("/html/body/div[2]/a/img"));
	}

	public Label HeaderTitleLabel()
	{
		return (this.headerTitleLabel != null) ? headerTitleLabel : new Label(By.xpath("//*[@id='content']/div/h2"));
	}

	public Label PageDescriptionLabel()
	{
		return (this.pageDescriptionLabel != null) ? pageDescriptionLabel : new Label(By.xpath("//*[@id='content']/div/h4"));
	}

	public Button LogoutButton()
	{
		return (this.logoutButton != null) ? logoutButton : new Button(By.xpath("//*[@id='content']/div/a/i"));
	}

	public Label PoweredByLabel()
	{
		return (this.poweredByLabel != null) ? poweredByLabel : new Label(By.xpath("//*[@id='page-footer']/div/div"));
	}
	
	public LinkLabel ElementalSeleniumLink()
	{
		return (this.elementalSeleniumLink != null) ? elementalSeleniumLink : new LinkLabel(By.xpath("//*[@id='page-footer']/div/div/a"));
	}
}
