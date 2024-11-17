import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_Handling_Calendar_UI {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Firefox
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver= new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//driver.get("https://rahulshettyacademy.com/");
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
	//	Dynamic dropdowns		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[value=\"BLR\"]")).click();      // CSS
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("(//a[@value=\"MAA\"])[2]")).click();    //Xpath Indexes
		Thread.sleep(2000);		
		
		// Handling Calendar
		
// css selector when class--> just give dot before class and if there any multiple classes seperated by space then just put dot.
		//Eg- mentioned below
	// ui-state-default ui-state-highlight --> Actual
		//.ui-state-default.ui-state-highlight --> Updated CSS selector
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		Thread.sleep(5000);
		
		
		
		
		driver.quit();
		

	}

}
