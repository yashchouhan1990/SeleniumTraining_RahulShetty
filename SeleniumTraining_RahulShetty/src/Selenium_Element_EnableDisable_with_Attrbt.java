import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Selenium_Element_EnableDisable_with_Attrbt {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Firefox
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver= new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//driver.get("https://rahulshettyacademy.com/");
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Checking enable disable of element
		
		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());  //Expected output-> False but getting true
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("It's Enabled");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		
		Thread.sleep(3000);
		driver.quit();

	}

}
