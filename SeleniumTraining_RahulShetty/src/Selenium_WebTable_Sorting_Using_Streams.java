import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class Selenium_WebTable_Sorting_Using_Streams {

	public static void main(String[] args) throws InterruptedException {

		// Firefox browser
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		/*
		 * Check items in web table are sorted or not Sudo code-
		 * 
		 * Click on column capture all webElements into list capture text of all
		 * webelements into new(Original) list sort on the original list of step-3 -->
		 * Sorted list Compare original list vs sorted list
		 * 
		 */

		Thread.sleep(3000);
		// Click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();

		// capture all webElements into list
		List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));

		// capture text of all webelements into new(Original) list
		List<String> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());

		// sort on the original list of step-3 --> Sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		// Compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));

	}
}
