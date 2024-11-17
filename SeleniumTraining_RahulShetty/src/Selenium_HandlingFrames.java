import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Selenium_HandlingFrames {

	public static void main(String[] args) {
		// Firefox
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver = new FirefoxDriver();		
		//Implicity Wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
		driver.get("https://jqueryui.com/droppable/");
		
		/*
		
		WebElement :
		
		<iframe src="/resources/demos/droppable/default.html" class="demo-frame" xpath="1"></iframe>
		
		*/
		

		//To check how many frames are present-
		int count=driver.findElements(By.tagName("iframes")).size();
		System.out.println("No of frames present"+count);
		
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
	//OR
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
	//OR
		//driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
	//OR
		//driver.switchTo().frame(0); //By index
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		Actions action = new Actions(driver);
		System.out.println(driver.findElement(By.id("draggable")).isDisplayed());
		
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droppable"));
		
		action.dragAndDrop(source, target).build().perform();
	
		//To switch back to normal window(Out of Frame)
		driver.switchTo().defaultContent();  
		
		

	}

}
