import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class Selenium_ScrollingInTable_And_In_Window {

	public static void main(String[] args) throws InterruptedException {
		// Firefox
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver = new FirefoxDriver();
		// Implicity Wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		// Scroll on Page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		Thread.sleep(4000);
		// Scroll on Component like inside a table
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		// Sum up all rows number present in table and validate the total given there

		/*
		 * Webelement
		 * 
		 * <td xpath="1">28</td>
		 * 
		 */
		// xpath- //td[4]
		// css- td:nth-child(4)
		// More preceise css- .tableFixHead td:nth-child(4)

		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(int i=0; i<values.size(); i++)
		{
			sum= sum + Integer.parseInt(values.get(i).getText());
		}
		System.out.println("Sum="+sum);
		
		int total=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		System.out.println("Total="+total);
		Assert.assertEquals(sum, total);
		driver.quit();
	}

}
