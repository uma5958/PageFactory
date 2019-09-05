package Tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class HomePageTests extends BaseTest {
	
	@Test
	public void verify_homePage_title_Test() throws Exception {
		page.getInstance(LoginPage.class).login_with_valid_credentials("demo", "vcD3v123");
		String  title = page.getInstance(HomePage.class).verify_homePage_title();
		Reporter.log("Home page title is: "+title, true);
	}
	
	@Test(dependsOnMethods="verify_homePage_title_Test")
	public void verify_current_url_Test() throws Exception {
		page.getInstance(LoginPage.class).login_with_valid_credentials("demo", "vcD3v123");
		String  url = page.getInstance(HomePage.class).verify_current_url();
		Reporter.log("Home url is: "+url, true);
	}
	
	@Test
	public void verify_Home_TC3() {
		Reporter.log("Login TC3", true);
	}
	
	@Test
	public void verify_Home_TC4() {
		Reporter.log("Login TC4", true);
	}
	
	
}
