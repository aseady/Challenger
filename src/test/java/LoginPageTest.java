import challenger.core.*;
import herokuapp.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class LoginPageTest {
	LoginPage loginPage = new LoginPage();
	SecurePage securePage = new SecurePage();

  @BeforeTest(alwaysRun=true)
  public void beforeTest() {
	  loginPage.Open();
  }
  @AfterTest
  public void afterTest() {
  }
  @BeforeSuite(alwaysRun=true)
  public void beforeSuite() {
	  WebDriverController.StartDriver();
  }
  @AfterSuite(alwaysRun=true)
  public void afterSuite() {
	  WebDriverController.StopDriver();
  }
  @Test(description="Navigates to the login page")
  public void NavigateToPage() {
	  loginPage.ValidateOpen();
  }
  @Test(description="Validates the element formatting on the page")
  public void PageFormatting() {
	  loginPage.HeaderTitleLabel().ValidateInnerText("Login Page");
	  loginPage.HeaderTitleLabel().ValidateDisplayed(true);
	  loginPage.PageDescriptionLabel().ValidateInnerText("This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.");
	  loginPage.PageDescriptionLabel().ValidateDisplayed(true);
	  loginPage.UsernameLabel().ValidateInnerText("Username");
	  loginPage.UsernameLabel().ValidateDisplayed(true);
	  loginPage.UsernameInput().ValidateAttributeText("value", "");
	  loginPage.UsernameInput().ValidateEnabled(true);
	  loginPage.PasswordLabel().ValidateInnerText("Password");
	  loginPage.PasswordLabel().ValidateDisplayed(true);
	  loginPage.PasswordInput().ValidateAttributeText("value", "");
	  loginPage.PasswordInput().ValidateEnabled(true);
	  loginPage.LoginButton().ValidateInnerText("Login");
	  loginPage.LoginButton().ValidateEnabled(true);
  }
  @Test(description="Performs a valid login")
  public void LoginValid() {
	  loginPage.UsernameInput().SendKeys("tomsmith");
	  loginPage.PasswordInput().SendKeys("SuperSecretPassword!");
	  loginPage.LoginButton().Click();
	  securePage.ValidateOpen();
	  securePage.FlashMessageLabel().ValidateInnerText("You logged into a secure area!\n×");
	  securePage.FlashMessageLabel().ValidateDisplayed(true);
	  securePage.LogoutButton().Click();
  }
  @Test(description="Performs a login using an invalid username")
  public void LoginInvalidUserName() {
	  loginPage.UsernameInput().SendKeys("wrongsmith");
	  loginPage.PasswordInput().SendKeys("SuperSecretPassword!");
	  loginPage.LoginButton().Click();
	  loginPage.ValidateOpen();
	  loginPage.FlashMessageLabel().ValidateInnerText("Your username is invalid!\n×");
	  loginPage.FlashMessageLabel().ValidateDisplayed(true);
	  loginPage.UsernameInput().ValidateAttributeText("value", "");
	  loginPage.UsernameInput().ValidateEnabled(true);
	  loginPage.PasswordInput().ValidateAttributeText("value", "");
	  loginPage.PasswordInput().ValidateEnabled(true);
  }
  @Test(description="Performs a login using an invalid username")
  public void LoginInvalidPassword() {
	  loginPage.UsernameInput().SendKeys("tomsmith");
	  loginPage.PasswordInput().SendKeys("wrongPassword!");
	  loginPage.LoginButton().Click();
	  loginPage.ValidateOpen();
	  loginPage.FlashMessageLabel().ValidateInnerText("Your password is invalid!\n×");
	  loginPage.FlashMessageLabel().ValidateDisplayed(true);
	  loginPage.UsernameInput().ValidateAttributeText("value", "");
	  loginPage.UsernameInput().ValidateEnabled(true);
	  loginPage.PasswordInput().ValidateAttributeText("value", "");
	  loginPage.PasswordInput().ValidateEnabled(true);
  }
  @Test(description="Performs a login using an empty username")
  public void LoginEmptyUserName() {
	  loginPage.UsernameInput().SendKeys("");
	  loginPage.PasswordInput().SendKeys("SuperSecretPassword!");
	  loginPage.LoginButton().Click();
	  loginPage.ValidateOpen();
	  loginPage.FlashMessageLabel().ValidateInnerText("Your username is invalid!\n×");
	  loginPage.FlashMessageLabel().ValidateDisplayed(true);
	  loginPage.UsernameInput().ValidateAttributeText("value", "");
	  loginPage.UsernameInput().ValidateEnabled(true);
	  loginPage.PasswordInput().ValidateAttributeText("value", "");
	  loginPage.PasswordInput().ValidateEnabled(true);
  }
  @Test(description="Performs a login using an empty username")
  public void LoginEmptyPassword() {
	  loginPage.UsernameInput().SendKeys("tomsmith");
	  loginPage.PasswordInput().SendKeys("");
	  loginPage.LoginButton().Click();
	  loginPage.ValidateOpen();
	  loginPage.FlashMessageLabel().ValidateInnerText("Your password is invalid!\n×");
	  loginPage.FlashMessageLabel().ValidateDisplayed(true);
	  loginPage.UsernameInput().ValidateAttributeText("value", "");
	  loginPage.UsernameInput().ValidateEnabled(true);
	  loginPage.PasswordInput().ValidateAttributeText("value", "");
	  loginPage.PasswordInput().ValidateEnabled(true);
  }
  @Test(description="Click the login button with no data in the input fields")
  public void LoginButtonEmptyFields() {
	  loginPage.UsernameInput().SendKeys("");
	  loginPage.PasswordInput().SendKeys("");
	  loginPage.LoginButton().Click();
	  loginPage.ValidateOpen();
	  loginPage.FlashMessageLabel().ValidateInnerText("Your username is invalid!\n×");
	  loginPage.FlashMessageLabel().ValidateDisplayed(true);
	  loginPage.UsernameInput().ValidateAttributeText("value", "");
	  loginPage.UsernameInput().ValidateEnabled(true);
	  loginPage.PasswordInput().ValidateAttributeText("value", "");
	  loginPage.PasswordInput().ValidateEnabled(true);
  }
  @Test(description="Test the possibility of account locking")
  public void LoginAccountLock() {
	  loginPage.UsernameInput().SendKeys("tomsmith");
	  loginPage.PasswordInput().SendKeys("wrongPassword!");
	  loginPage.LoginButton().Click();
	  loginPage.UsernameInput().SendKeys("tomsmith");
	  loginPage.PasswordInput().SendKeys("wrongPassword!");
	  loginPage.LoginButton().Click();
	  loginPage.UsernameInput().SendKeys("tomsmith");
	  loginPage.PasswordInput().SendKeys("wrongPassword!");
	  loginPage.LoginButton().Click();
	  loginPage.UsernameInput().SendKeys("tomsmith");
	  loginPage.PasswordInput().SendKeys("wrongPassword!");
	  loginPage.LoginButton().Click();
	  loginPage.UsernameInput().SendKeys("tomsmith");
	  loginPage.PasswordInput().SendKeys("wrongPassword!");
	  loginPage.LoginButton().Click();
	  loginPage.UsernameInput().SendKeys("tomsmith");
	  loginPage.PasswordInput().SendKeys("SuperSecretPassword!");
	  loginPage.LoginButton().Click();
	  securePage.ValidateOpen();
	  securePage.FlashMessageLabel().ValidateInnerText("You logged into a secure area!\n×");
	  securePage.FlashMessageLabel().ValidateDisplayed(true);
	  securePage.LogoutButton().Click();
  }
}
