import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_WIndowHandleConcepts {

	public static void main(String[] args) {
		// Firefox
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver = new FirefoxDriver();		
		//Implicity Wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		Set<String> windows=driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		String parentWindow=it.next();
		String childWindow=it.next();
		
		driver.switchTo().window(childWindow);

		driver.findElement(By.cssSelector(".im-para.red")).getText();
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		
		String emailID=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];	
		System.out.println(emailID);

		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("username")).sendKeys(emailID);
	}

}
