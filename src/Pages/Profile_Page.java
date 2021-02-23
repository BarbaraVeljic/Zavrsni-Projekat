package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Profile_Page extends BasicPage {

	public Profile_Page(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		// TODO Auto-generated constructor stub
	}

	public WebElement getPersonalInfo() {
		return driver.findElement(By.linkText("Ronald Williams"));
	}

	public WebElement getMyAccount() {
		return driver.findElement(By.linkText("My Account"));
	}

	public WebElement getProfilePage() {
		return driver.findElement(By.linkText("Profile"));
	}

	public WebElement getName() {
		return driver.findElement(By.name("user_first_name"));
	}

	public WebElement getLastName() {
		return driver.findElement(By.name("user_last_name"));
	}

	public WebElement getAddress() {
		return driver.findElement(By.name("user_address"));
	}

	public WebElement getPhoneNo() {
		return driver.findElement(By.name("user_phone"));
	}

	public WebElement getZip() {
		return driver.findElement(By.name("user_zip"));
	}

	public Select getCountry() {
		WebElement country = driver.findElement(By.id("user_country_id"));
		Select cont = new Select(country);
		return cont;
	}

	public Select getState() {
		WebElement state = driver.findElement(By.id("user_state_id"));
		Select stat = new Select(state);
		return stat;
	}

	public Select getCity() {
		WebElement city = driver.findElement(By.id("user_state_id"));
		Select cty = new Select(city);
		return cty;
	}

	public WebElement getSaveInfo() {
		return driver.findElement(By.name("btn_submit"));
	}

	public WebElement getCurrentPass() {
		return driver.findElement(By.name("current_password"));
	}

	public WebElement getNewPass() {
		return driver.findElement(By.name("new_password"));
	}

	public WebElement getConfirmPass() {
		return driver.findElement(By.name("conf_new_password"));
	}

	public void UploadButton() {
		WebElement photoBtn = driver.findElement(By.xpath("//*[@title='Uplaod']"));
		js.executeScript("arguments[0].click();", photoBtn);

	}

	public void uploadPhoto(String photoPath) {

		this.UploadButton();
		driver.findElement(By.xpath("//*[@type='file']")).sendKeys(photoPath);
	}

	public void removePhoto() {
		WebElement remove = driver.findElement(By.xpath("//*[@title='Remove']"));
		js.executeScript("arguments[0].click();", remove);
	}

	public void updateInfo(String name,String lastName,String adress,String zip,String phone,String coutry,String state,String city) {
this.getName().sendKeys(name);
this.getLastName().sendKeys(lastName);
this.
	}
