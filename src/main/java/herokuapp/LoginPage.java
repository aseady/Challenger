package herokuapp;

import org.openqa.selenium.By;
import challenger.core.*;

public class LoginPage extends BasePage {

	private Label flashMessageLabel = null;
	private Image forkMeImage = null;
	private Label headerTitleLabel = null;
	private Label pageDescriptionLabel = null;
	private Label usernameLabel = null;
	private Input usernameInput = null;
	private Label passwordLabel = null;
	private Input passwordInput = null;
	private Button loginButton = null;
	private Label poweredByLabel = null;
	private LinkLabel elementalSeleniumLink = null;
	
	public LoginPage()
	{
		pageUrl = "https://the-internet.herokuapp.com/login";
		xPathValidator = "//*[@id='username']";
	}

	public Image ForkMeImage()
	{
		return (this.forkMeImage != null) ? forkMeImage : new Image(By.xpath("/html/body/div[2]/a/img"));
	}
	
	public Label FlashMessageLabel()
	{
		return (this.flashMessageLabel != null) ? flashMessageLabel : new Label(By.id("flash"));
	}	

	public Label HeaderTitleLabel()
	{
		return (this.headerTitleLabel != null) ? headerTitleLabel : new Label(By.xpath("//*[@id='content']/div/h2"));
	}

	public Label PageDescriptionLabel()
	{
		return (this.pageDescriptionLabel != null) ? pageDescriptionLabel : new Label(By.xpath("//*[@id='content']/div/h4"));
	}

	public Label UsernameLabel()
	{
		return (this.usernameLabel != null) ? usernameLabel : new Label(By.xpath("//*[@id='login']/div[1]/div/label"));
	}

	public Input UsernameInput()
	{
		return (this.usernameInput != null) ? usernameInput : new Input(By.id("username"));
	}

	public Label PasswordLabel()
	{
		return (this.passwordLabel != null) ? passwordLabel : new Label(By.xpath("//*[@id='login']/div[2]/div/label"));
	}

	public Input PasswordInput()
	{
		return (this.passwordInput != null) ? passwordInput : new Input(By.id("password"));
	}

	public Button LoginButton()
	{
		return (this.loginButton != null) ? loginButton : new Button(By.xpath("//*[@id='login']/button/i"));
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
