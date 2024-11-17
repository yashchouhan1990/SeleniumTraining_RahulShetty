import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Selenium_EndT0End_FlightBookingFlow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Firefox
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver= new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);		
		//driver.get("https://rahulshettyacademy.com/");
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Select One way
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		
	//	Select From and To locations -->Dynamic dropdowns		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[value=\"BLR\"]")).click();      // CSS
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("(//a[@value=\"MAA\"])[2]")).click();    //Xpath Indexes
		Thread.sleep(2000);		
		
		//Select Departure date from Calendar
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			System.out.println("It's Enabled");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		//Select Passenger Checkbox
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();

		//Select Passenger
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());	

		for(int i=1; i<5; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		
		//Select Currency --> Static Dropdown- Dropdown with Select tag
		WebElement staticDropdown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown= new Select(staticDropdown);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByIndex(2);
		System.out.println(dropdown.getFirstSelectedOption().getText());

		//Click on Submit Button
		//driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")); --> CSSS using id--> #id
		driver.findElement(By.cssSelector("input[value='Search']")).click();
		
		Thread.sleep(5000);
		driver.quit();

	}

}
