package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search_Results_Page extends BasicPage {

	public Search_Results_Page(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		// TODO Auto-generated constructor stub
	}

	public List<WebElement> getAllResults() {
		List<WebElement> results = driver.findElements(By.xpath("//*[@class='product-name']/a"));
		return results;
	}

	public ArrayList<String> getResultsNames() {
		ArrayList<String> names = new ArrayList<String>();
		for (int i = 0; i < this.getAllResults().size(); i++) {
			names.add(this.getAllResults().get(i).getText());
		}
		return names;
	}

	public int getNumberOfResults() {
		int number = this.getAllResults().size();
		return number;
	}
}
