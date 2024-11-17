import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_WebTable_Pagination {

	public static void main(String[] args) throws InterruptedException {
		// Firefox browser
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		Thread.sleep(3000);
		/*
		 * Scan the name column with the get text-> Beans-> print the price of the Beans
		 */
		List<String> price;
		do {
			// capture all webElements into list
			List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
			
			price = elementList.stream().filter(s -> s.getText().contains("Carrot"))
					.map(s -> getPriceVeggie(s)).collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));

			if (price.size() < 1) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		} while (price.size() < 1);
	}

	private static String getPriceVeggie(WebElement s) {
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}

}
