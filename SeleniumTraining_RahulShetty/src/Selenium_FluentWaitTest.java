
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium_FluentWaitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Firefox
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		// driver.get("https://rahulshettyacademy.com/");
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		//Implicity Wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Explicity Wait- WebDrvierWait
		// Explicit Wait- Applied to specific elements only
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='start'] button")));
		driver.findElement(By.cssSelector("[id='start'] button")).click();
		
		// FluentWait
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30L))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
					return driver.findElement(By.cssSelector("[id='finish'] h4"));
				}

				else
					return null;
			}
		});
		System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
		
		driver.quit();
	}

}
