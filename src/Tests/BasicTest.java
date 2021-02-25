package Tests;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import Pages.Auth_Page;
import Pages.Cart_Summary_Page;
import Pages.Location_Popup_Page;
import Pages.Login_Page;
import Pages.Meal_Page;
import Pages.Notification_Sistem_Page;
import Pages.Profile_Page;
import Pages.Search_Results_Page;

public abstract class BasicTest {
	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected JavascriptExecutor js;
	protected Location_Popup_Page locationPopupPage;
	protected Login_Page loginPage;
	protected Notification_Sistem_Page notificationSistemPage;
	protected Profile_Page profilePage;
	protected Auth_Page authPage;
	protected Meal_Page mealPage;
	protected Cart_Summary_Page cartSummaryPage;
	protected Search_Results_Page searchResultsPage;
	protected String baseUrl = "http://demo.yo-meals.com";
	protected String ussername = "customer@dummyid.com";
	protected String password = "12345678a";

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.waiter = new WebDriverWait(driver, 30);
		this.js = (JavascriptExecutor) driver;
		this.locationPopupPage = new Location_Popup_Page(driver, waiter, js);
		this.loginPage = new Login_Page(driver, waiter, js);
		this.notificationSistemPage = new Notification_Sistem_Page(driver, waiter, js);
		this.profilePage = new Profile_Page(driver, waiter, js);
		this.authPage = new Auth_Page(driver, waiter, js);
		this.mealPage = new Meal_Page(driver, waiter, js);
		this.cartSummaryPage = new Cart_Summary_Page(driver, waiter, js);
		this.searchResultsPage = new Search_Results_Page(driver, waiter, js);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void takeScreenshots(ITestResult result) throws HeadlessException, AWTException, IOException {
		String testTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss'.jpg'").format(new Date());
		if (ITestResult.FAILURE == result.getStatus()) {
			BufferedImage screenshoots = new Robot()
					.createScreenCapture((new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())));
			File screenshots = new File("screenshot.jpg");
			ImageIO.write(screenshoots, "jpg", new File("screenshots\\" + testTime));
			
		}
		this.driver.manage().deleteAllCookies();
	}

	@AfterClass
	public void close() {
		driver.quit();
	}
}
