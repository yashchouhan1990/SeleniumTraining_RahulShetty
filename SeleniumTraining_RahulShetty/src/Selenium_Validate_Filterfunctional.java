import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class Selenium_Validate_Filterfunctional {

	public static void main(String[] args) throws InterruptedException {
		// Firefox browser
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		Thread.sleep(3000);

		/*
		 * Enter the item to be search in filter then validate the result displayed
		 */
		//driver.findElement(By.xpath("search-field")).sendKeys("Rice");
		//or
		driver.findElement(By.cssSelector("#search-field")).sendKeys("Rice");
		
		List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));
		
		//1 results displayed
		List<WebElement> filteredList=veggies.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(veggies.size(),filteredList.size());
	}

}
