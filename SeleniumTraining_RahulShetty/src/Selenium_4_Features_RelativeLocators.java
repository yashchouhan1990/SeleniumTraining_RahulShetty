import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//Manually added the static package- Static packages does not get auto-suggested
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Selenium_4_Features_RelativeLocators {

	public static void main(String[] args) throws InterruptedException {
		// Firefox browser
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		
		
		WebElement nameEditBox=driver.findElement(By.cssSelector("[name='name']"));
		
		//Import the static package for relative locators
		//1. above
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		
		//2. below
		WebElement dateofBirth=driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();
		
		//3. LeftOf
		//
		WebElement checkboxlabel=driver.findElement(By.xpath("//label[contains(text(),'Check me out if you Love IceCreams!')]"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkboxlabel)).click();
		
		//4. rightOf
		WebElement radioButton=driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText());
		
		Thread.sleep(5000);
		driver.quit();
	}

}
