package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Meal_Page extends BasicPage {

	public Meal_Page(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		// TODO Auto-generated constructor stub
	}

	public WebElement getMealsLink() {
		return driver.findElement(By.linkText("Meals"));
	}

	public WebElement getSearchBtn() {
		return driver.findElement(By.name("btn_submit"));
	}

	public WebElement getMealSearch() {
		return driver.findElement(By.xpath("//input[@class='js-search-keywords']"));

	}

	public Select getSortBy() {
		WebElement sort = driver.findElement(By.linkText("Latest Products"));
		Select products = new Select(sort);
		return products;
	}

	public WebElement getFilters() {
		return driver.findElement(By.className("js-filter-text"));
	}

	public WebElement getResetAllFilters() {
		return driver.findElement(By.linkText("Reset All"));
	}

	public WebElement getChef() {
		WebElement chef = driver.findElement(By.linkText("Chef"));
		chef.click();
		return driver.findElement(By.name("multiple_chefs"));
	}

	public WebElement getResetChef() {
		return driver.findElement(By.linkText("Reset Chef"));
	}

	public WebElement getPrice() {
		return driver.findElement(By.linkText("Price $"));
	}

	public WebElement getMinPriceValue() {
		return driver.findElement(By.name("priceFilterMinValue"));
	}

	public WebElement getMaxPriceValue() {
		return driver.findElement(By.name("priceFilterMaxValue"));
	}

	public WebElement getResetPrice() {
		return driver.findElement(By.linkText("Reset Price"));
	}

	public WebElement getType(String type) {
		WebElement foodType = driver.findElement(By.xpath("//*[@veg-name='" + type + "']"));
		return foodType;
	}

	public WebElement resetType() {
		return driver.findElement(By.linkText("Reset Type"));
	}

	public WebElement getMealType(String mealType) {
		WebElement meal = driver.findElement(By.xpath("//*[@meal-name='" + mealType + "']"));
		return meal;
	}

	public WebElement resetMealType() {
		return driver.findElement(By.linkText("Reset Meal Type"));
	}

	public WebElement getCouisineType(String cuisineType) {
		WebElement typeCuisine = driver.findElement(By.xpath("//*[@cuisine-name='" + cuisineType + "']"));
		return typeCuisine;
	}

	public WebElement resetCuisineType() {
		return driver.findElement(By.linkText("Resest Cuisine Type"));
	}

	public WebElement getProduct() {
		return driver.findElement(By.linkText("Baked Caldereta..."));
	}

	public WebElement getFavourite() {
		return driver.findElement(By.xpath("//*[@title='Favorite']"));
	}
	public void addMeal(String quantity) throws InterruptedException {
		WebElement quan=driver.findElement(By.name("product_qty"));
		quan.clear();
		quan.sendKeys(quantity);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Add To Cart")).click();
	}
	public void addMealToFavourite() {
		waiter.until(ExpectedConditions.elementToBeClickable(this.getFavourite()));
		this.getFavourite().click();
	}

}