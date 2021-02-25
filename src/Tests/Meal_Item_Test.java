package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Meal_Item_Test extends BasicTest {
	@Test(priority = 5)
	public void addMealToCart() throws InterruptedException {
		driver.navigate().to(this.baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPopupPage.closePopupLocation();
		mealPage.addMeal("2");
		String message = "The Following Errors Occurred:" + "\n" + "Please Select Location";
		Assert.assertTrue(notificationSistemPage.getMessageText().contains(message),
				"[ERROR] Unexpected Error message");
		notificationSistemPage.notificationDisappear();
		locationPopupPage.setLocation("City Center - Albany");
		mealPage.addMeal("2");
		Assert.assertEquals(notificationSistemPage.getMessageText(), "Meal Added To Cart",
				"[ERROR] Unexpected Add To Cart Message");
	}

	@Test(priority = 10)
	public void addMealToFavorite() throws InterruptedException {
		driver.navigate().to(this.baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPopupPage.closePopupLocation();
		Thread.sleep(5000);
		mealPage.addMealToFavourite();
		Assert.assertEquals(notificationSistemPage.getMessageText(), "Please login first!",
				"[ERROR] Unexpected Add To Favorite Message");
		driver.navigate().to(this.baseUrl + "/guest-user/login-form");
		loginPage.loginCustomer(this.ussername, this.password);
		driver.navigate().to(this.baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		Thread.sleep(3000);
		mealPage.addMealToFavourite();
		Assert.assertTrue(notificationSistemPage.getMessageText().contains
				("Product has been added to your favorites."),
				"[ERROR] Unexpected Add To Favorite Message");
	}

	@Test(priority = 15)
	public void clearCart() throws IOException, InterruptedException {
		driver.navigate().to(this.baseUrl + "/meals");
		locationPopupPage.closePopupLocation();
		locationPopupPage.setLocation("City Center - Albany");
		File file = new File("data/Data (2).xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("Meals");
		DataFormatter format = new DataFormatter();
		for (int i = 1; i < 6; i++) {
			String url = sheet.getRow(i).getCell(0).getStringCellValue();
			String quantity = format.formatCellValue(sheet.getRow(i).getCell(1));
			driver.navigate().to(url);
			mealPage.addMeal(quantity);
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(notificationSistemPage.getMessageText(), "Meal Added To Cart",
					"[ERROR] Unexpected Add To Cart Message");
			wb.close();
			fis.close();
		}
		cartSummaryPage.clearAll();
		Assert.assertEquals(notificationSistemPage.getMessageText(), "All meals removed from Cart successfully",
				"[ERROR] Unexpected Add To Favorite Message");

	}

}