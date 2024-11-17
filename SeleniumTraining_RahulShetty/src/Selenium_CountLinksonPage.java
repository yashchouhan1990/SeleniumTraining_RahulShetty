import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_CountLinksonPage {

	public static void main(String[] args) throws InterruptedException {
		// Firefox
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver = new FirefoxDriver();		
		//Implicity Wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1. Count of Links on entire page
		int linksonEntirePage=driver.findElements(By.tagName("a")).size();
		System.out.println("Count of links on Entire Page: "+linksonEntirePage);
		
		//2. Count of links on Fotter Section
		
		//Limiting the scope of driver to fotter section
		WebElement fotterDriver= driver.findElement(By.id("gf-BIG"));
		
		int linksonFotterSection=fotterDriver.findElements(By.tagName("a")).size();
		System.out.println("Count of links on Fotter Page: "+linksonFotterSection);
		
		//3. Count of links on 1st Column of Fotter Section
		
		//Again limiting the scope of fotter driver to column
		WebElement columnDriver=fotterDriver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul"));
		
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		
		//4. Now click on each links of 1st Column inn Fotter Section and check if page is opening/working
		
		for(int i=1; i<columnDriver.findElements(By.tagName("a")).size(); i++)
		{
			
		  System.out.println(columnDriver.findElements(By.tagName("a")).get(i));
		  String clinkonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
		  columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clinkonlinkTab);
		  Thread.sleep(5000L);
		  /*
			columnDriver.findElements(By.tagName("a")).get(i).click();
			Thread.sleep(5000L);
			driver.navigate().back();
		  */
		  
		}
		//5. Open all the tabs and print the title of the page
		Set<String> abc=driver.getWindowHandles();
		Iterator<String> it=abc.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		driver.quit();

	}

}
