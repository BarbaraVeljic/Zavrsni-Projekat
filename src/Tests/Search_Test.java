package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Search_Test extends BasicTest {
	@Test
	public void searchResults() throws IOException {
		driver.navigate().to(this.baseUrl + "/meals");
		locationPopupPage.closePopupLocation();
		locationPopupPage.setLocation("City Center - Albany");
		File file = new File("data/Data (2).xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meal Search Results");
		DataFormatter format = new DataFormatter();
		SoftAssert softAssert = new SoftAssert();
		for (int i = 1; i < 7; i++) {
			XSSFRow row = sheet.getRow(i);
			String location = row.getCell(0).getStringCellValue();
			String url = row.getCell(1).getStringCellValue();
			String quantity = format.formatCellValue(row.getCell(2));
			driver.navigate().to(url);
			locationPopupPage.setLocation(location);
			searchResultsPage.getAllResults();
			softAssert.assertEquals(searchResultsPage.getNumberOfResults(), quantity,
					"[ERROR] Unexpected Add To Cart Message");
			for (int x = 3; x < row.getLastCellNum(); x++) {
				String results = row.getCell(x).getStringCellValue();
				softAssert.assertTrue(searchResultsPage.getResultsNames().contains(results),
						"[ERROR] Unexpected The Results are not the same Message");
			}
		}

	}
	
}
