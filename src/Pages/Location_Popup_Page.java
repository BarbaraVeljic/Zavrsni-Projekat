package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Location_Popup_Page extends BasicPage {

	public Location_Popup_Page(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		// TODO Auto-generated constructor stub
	}

	public WebElement getSelectLocation() {
		return driver.findElement(By.linkText("Select Location"));
	}

	public WebElement getCloseElement() {
		return driver.findElement(By.linkText("Close"));
	}

	public WebElement getKeyword() {
		return driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}

	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '"+locationName+"')]/.."));
	}

	public WebElement getLocationInput() {
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	}

	public WebElement getSubmit() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}

	public void openPopupLocation() {
		this.getSelectLocation().click();
	}

	public void setLocation(String locationName) {
		this.getKeyword().click();
		String value = this.getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value=arguments[1];", this.getLocationInput(), value);
		//waiter.until(ExpectedConditions.elementToBeClickable(this.getSubmit()));
		js.executeScript("arguments[0].click();", this.getSubmit());

	}
	//*[@id="location-popup"]/div/div/div/div/a
	public void closePopupLocation() {
		this.getCloseElement().click();
	}
}
