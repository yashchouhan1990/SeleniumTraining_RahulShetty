import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Selenium_AjaxHandling_Mouse_Interation {

	public static void main(String[] args) {

		// Firefox
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.amazon.in/");
		
		//Implicity Wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Action Class
		Actions action=new Actions(driver);
		System.out.println(driver.findElement(By.cssSelector("#twotabsearchtextbox")).isDisplayed());
		
		WebElement searchbox=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		//Enter in Capital Letter
		action.moveToElement(searchbox).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
		//Select the Entered Text
		action.moveToElement(searchbox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		//Move to Specific Element
		WebElement ele1=driver.findElement(By.cssSelector("#nav-link-accountList"));
		action.moveToElement(ele1).build().perform();
		
		//Move to Specific Element and do right click
		WebElement ele2=driver.findElement(By.cssSelector("#nav-global-location-popover-link"));
		action.moveToElement(ele2).contextClick().build().perform();
				

	}

}
