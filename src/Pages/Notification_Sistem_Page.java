package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Notification_Sistem_Page extends BasicPage {

	public Notification_Sistem_Page(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		// TODO Auto-generated constructor stub
	}
public WebElement getMessageElement() {
	return driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
}
public String getMessageText() {
	return this.getMessageElement().getText();
}
public void notificationDisappear() {
	//čeka se da element //*[contains(@class, 'system_message')]
	//za atribut style dobije vrednost  "display: none;"
waiter.until(ExpectedConditions.attributeContains(By.xpath("//*[contains(@class, 'system_message')]"), "style", "display: none;"));
}

}
