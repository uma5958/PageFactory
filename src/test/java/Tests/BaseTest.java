package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.PageGenerator;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public PageGenerator page;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");	
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		driver.get("https://test.valuechain.com/Login");
		page = new PageGenerator(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
