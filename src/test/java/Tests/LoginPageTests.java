package Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginPageTests extends BaseTest {
	
	@Test
	public void verify_loginpage_title () {
		String title = page.getInstance(LoginPage.class).verify_loginPage_title();
		System.out.println("login page title is: "+ title);
		Assert.assertEquals(title, "login");
	}
	
	@Test//(dependsOnMethods="verify_loginpage_title")
	public void verify_valid_login() throws Exception {
		page.getInstance(LoginPage.class).login_with_valid_credentials("demo", "vcD3v123");
		Reporter.log("Login success", true);
	}
	
	@Test
	public void verify_Login_TC3() {
		Reporter.log("Login TC3", true);
	}
	
	@Test
	public void verify_Login_TC4() {
		Reporter.log("Login TC4", true);
	}
	
}
