package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Pages.Location_Popup_Page;
import Pages.Login_Page;
import Pages.Notification_Sistem_Page;
import Pages.Profile_Page;

public abstract class BasicTest {
	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected JavascriptExecutor js;
	protected Location_Popup_Page locationPopupPage;
	protected Login_Page loginPage;
	protected Notification_Sistem_Page notificationSistemPage;
	protected Profile_Page profilePage;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.waiter = new WebDriverWait(driver, 30);
		this.js = (JavascriptExecutor) driver;
		this.locationPopupPage = new Location_Popup_Page(driver, waiter, js);
		this.loginPage = new Login_Page(driver, waiter, js);
		this.notificationSistemPage=new Notification_Sistem_Page(driver, waiter, js);
		this.profilePage=new Profile_Page(driver, waiter, js);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@AfterClass
	public void close() {
		driver.quit();
	}
}
