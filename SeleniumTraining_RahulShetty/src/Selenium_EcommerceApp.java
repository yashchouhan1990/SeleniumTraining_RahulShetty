import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium_EcommerceApp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// driver.get("https://rahulshettyacademy.com/");
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		// Implicit Wait- Global Wait- Applied to all elements
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Explicit Wait- Applied to specific elements only
		WebDriverWait wait = new WebDriverWait(driver, 5);

		// Expected Array for list of items to be ordered
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };

		additems(driver, itemsNeeded);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();

		// driver.findElement(By.xpath("//button[text()='PROCEED TO
		// CHECKOUT']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

		// explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

		driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");

		driver.findElement(By.cssSelector("button.promobtn")).click();
		// explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoinfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoinfo")).getText());

		// driver.findElement(By.xpath("//button[contains(text(),'Place
		// Order')]")).click();

//		driver.quit();
	}

	public static void additems(WebDriver driver, String[] itemsNeeded) {
		int j = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formattedname = name[0].trim();

			// check whether name you extracted is present in array or not
			// convert array into arraylist for easy search
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			if (itemsNeededList.contains(formattedname)) {
				j++;
				// driver.findElements(By.xpath("//button[text()='ADD TO CART']")).c;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length) {
					break;
				}

			}
		}

	}

}
