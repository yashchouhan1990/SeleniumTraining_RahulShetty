import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_Java_Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String text = "Yash";

		// Firefox
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// driver.get("https://rahulshettyacademy.com/");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// ALRET-1
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		Thread.sleep(2000);

		// ALERT-2
		// driver.findElement(By.id("confirmbtn")).click();
		driver.findElement(By.cssSelector("[id='confirmbtn']")).click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();

		Thread.sleep(4000);
		driver.quit();
	}

}
