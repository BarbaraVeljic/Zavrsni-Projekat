package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page extends BasicPage {

	public Login_Page(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		// TODO Auto-generated constructor stub
	}

	public WebElement getLogin() {
		return driver.findElement(By.linkText("Login"));
	}

	public WebElement getUsername() {
		return driver.findElement(By.name("username"));
	}

	public WebElement getPassword() {
		return driver.findElement(By.name("password"));
	}

	public WebElement getLoginBtn() {
		return driver.findElement(By.name("btn_submit"));
	}

	public void loginCustomer(String username, String password) {
		this.getLogin().click();
		this.getUsername().clear();
		this.getUsername().sendKeys(username);
		this.getPassword().clear();
		this.getPassword().sendKeys(password);
		this.getLoginBtn().click();
	}
}
