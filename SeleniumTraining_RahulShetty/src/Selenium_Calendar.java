import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_Calendar {

	public static void main(String[] args) throws InterruptedException {
		// Firefox
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver = new FirefoxDriver();
		// Implicity Wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();

		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		driver.findElement(By.name("form_fields[travel_from]")).sendKeys("India");
		driver.findElement(By.name("form_fields[travel_to]")).sendKeys("New York");
		
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(5000L);
		// driver.findElement(By.cssSelector("input#form-field-travel_to")).click();
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
		
		//Grab the common attribute-> Put into list and iterate
		//Select Month- July
		
		while(!driver.findElement(By.cssSelector("[class='cur-month']")).getText().contains("July"))
		{
			driver.findElement(By.cssSelector("[class='flatpickr-next-month']")).click();
			System.out.println("Insider while loop");
		}
		
		//Grab the common attribute-> Put into list and iterate
		//Select date 30th Jan
		List<WebElement> dates = driver.findElements(By.className("flatpickr-day"));
		int count = driver.findElements(By.className("flatpickr-day")).size();
		System.out.println("Total Days in month"+count);
		
		for (int i = 0; i < count; i++) {
			String date = driver.findElements(By.cssSelector(".flatpickr-day")).get(i).getText();
			if (date.equalsIgnoreCase("31"))
			{
				driver.findElements(By.cssSelector(".flatpickr-day")).get(i).click();
				break;
			}
		}
		// driver.quit();

		// dayContainer

	}

}
