package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart_Summary_Page extends BasicPage {

	public Cart_Summary_Page(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		// TODO Auto-generated constructor stub
	}

	public WebElement getClearAll() {
		return driver.findElement(By.linkText("Clear All"));
	}

	public void clearAll() {
		this.getClearAll().click();
	}
}
