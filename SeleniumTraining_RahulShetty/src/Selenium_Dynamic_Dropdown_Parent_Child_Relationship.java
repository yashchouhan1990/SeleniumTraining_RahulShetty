import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_Dynamic_Dropdown_Parent_Child_Relationship {

	public static void main(String[] args) throws InterruptedException {
		//Xpath- Parent Child relationship:
		//It is different from Parent child traversing where we give //parent/child
		//Parent Child relationship we write like this- //Parent_xath<Space>//Child_xpath 
		
		//Firefox
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver= new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//driver.get("https://rahulshettyacademy.com/");
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
	//	Dynamic dropdowns
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_originStation1_CTNR\"] //a[@value='BHO']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@value='MAA']")).click();    //Xpath Indexes
		Thread.sleep(2000);		
		
		driver.quit();

	}

}


