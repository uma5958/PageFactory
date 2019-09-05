package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage extends BasePage {

	// Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Web Elements by using Page Factory
	@FindBy(how = How.ID, using = "txtLoginName")
	WebElement username;

	@FindBy(how = How.NAME, using = "password")
	WebElement password;

	@FindBy(how = How.XPATH, using = "//button[text()='Sign In']")
	WebElement loginButton;

	@FindBy(xpath="//span[text()='Please fill email.']")
	WebElement userNameErrorMsg;

	By passwordErrorMsg = By.xpath("//span[text()='Please fill password.']");


	// Page Methods
	public HomePage login_with_valid_credentials(String un, String pwd) throws Exception {
		writeText(username, un);
		writeText(password, pwd);
		click(loginButton);
		Thread.sleep(5000);
		return getInstance(HomePage.class);
	}

	// Login page title
	public String verify_loginPage_title(){
		return driver.getTitle();
	}

	// verify username error msg
	public void verify_username_error_message(String expMsg) {
		Assert.assertEquals(readText(userNameErrorMsg), expMsg);
	}

	// verify password error msg
	public void verify_password_error_message(String un, String expMsg) {
		writeText(username, un);
		click(loginButton);
		Assert.assertEquals(readText(passwordErrorMsg), expMsg);
	}

	
	
}
