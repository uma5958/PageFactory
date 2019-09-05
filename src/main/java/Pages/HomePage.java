package Pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String verify_homePage_title() {
		return getPageTitle();
	}
	
	public String verify_current_url() {
		return driver.getCurrentUrl();
	}
	
	
	
}
