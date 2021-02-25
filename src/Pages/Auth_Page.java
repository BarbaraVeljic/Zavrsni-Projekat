package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Auth_Page extends BasicPage {

	public Auth_Page(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		// TODO Auto-generated constructor stub
	}

	public WebElement getPersonalInfo() {
		return driver.findElement(By.className("after-arrow"));
	}

	public WebElement getMyAccount() {
		return driver.findElement(By.linkText("My Account"));
	}

	public WebElement getLogoutBtn() {
		return driver.findElement(By.linkText("Logout"));
	}

	public void logout() {
		this.getPersonalInfo().click();
		this.getLogoutBtn().click();
	}
}
