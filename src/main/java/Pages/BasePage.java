package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BasePage extends PageGenerator {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	// If we need we can use custom wait in BasePage and all page classes
	WebDriverWait wait = new WebDriverWait(this.driver, 30);

	// Click Method by using JAVA Generics (You can use both By or Webelement)
	public <T> void click(T elementAttr) {
		if (elementAttr.getClass().getName().contains("By")) {
			waitForElementPresent((By) elementAttr);
			driver.findElement((By) elementAttr).click();
		} else {
			((WebElement) elementAttr).click();
		}
	}

	// Write Text by using JAVA Generics (You can use both By or Webelement)
	public <T> void writeText(T elementAttr, String text) {
		if (elementAttr.getClass().getName().contains("By")) {
			waitForElementPresent((By) elementAttr);
			driver.findElement((By) elementAttr).sendKeys(text);
		} else {
			((WebElement) elementAttr).sendKeys(text);
		}
	}

	// Read Text by using JAVA Generics (You can use both By or Webelement)
	public <T> String readText(T elementAttr) {
		if (elementAttr.getClass().getName().contains("By")) {
			waitForElementPresent((By) elementAttr);
			return driver.findElement((By) elementAttr).getText();
		} else {
			return ((WebElement) elementAttr).getText();
		}
	}

	// Close popup if exists
	public void handlePopup(By by) throws Exception {
		List<WebElement> popups = driver.findElements(by);
		if (!popups.isEmpty()) {
			popups.get(0).click();
			Thread.sleep(500);
		}
	}

	// Wait for element present
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			Reporter.log("Some exception/error occured while waiting for element: "+locator.toString(), true);
			e.printStackTrace();
		}
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElement(locator);
		} catch (Exception e) {
			Reporter.log("Some exception occured while creating element: "+locator.toString(), true);
			e.printStackTrace();
		}
		return element;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}




}
