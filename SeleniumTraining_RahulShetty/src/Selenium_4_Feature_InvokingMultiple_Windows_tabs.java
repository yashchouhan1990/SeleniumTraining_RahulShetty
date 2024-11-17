import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_4_Feature_InvokingMultiple_Windows_tabs {

	public static void main(String[] args) throws InterruptedException {
		// Firefox browser
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		/* Invoking Multiple WIndows/ tabs from selenium using one driver instance
		 * 
		 * Scenario-
		 * Navigate to https://rahulshettyacademy.com/angularpractice/
		 * 
		 * Fill the "Name" field with the first course name available 
		 * at https://rahulshettyacademy.com
		 * 
		 */
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(2000);
		//Open new blank tab
		driver.switchTo().newWindow(WindowType.TAB);
		
		//now to enter anything in new window, first we have to switch to that window
		//So first get the handles of all the opened windows , then switch to new window
		
		Set<String> handles=driver.getWindowHandles();
		
		Iterator<String> it= handles.iterator();
		
		String parentWindowId=it.next();
		String childWindowId=it.next();
		
		driver.switchTo().window(childWindowId);
		driver.get("https://rahulshettyacademy.com");
		
		String courseName=driver.findElements(By.cssSelector("a[href *='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		
		System.out.println("Course Name:" +courseName);
		Thread.sleep(2000);
		//Now switch back to parent window and enter the grabed text
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);
		
		Thread.sleep(3000);
		driver.quit();

		
	}

}
