import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium_Static_Dropdowns {

	public static void main(String[] args) throws InterruptedException {
		
		//Firefox
				System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
				WebDriver driver= new FirefoxDriver();
				
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				
				//driver.get("https://rahulshettyacademy.com/");
				driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
				
				//Static Dropdown- Dropdown with Select tag
				WebElement staticDropdown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
				Select dropdown= new Select(staticDropdown);
				System.out.println(dropdown.getFirstSelectedOption().getText());
				dropdown.selectByIndex(2);
				System.out.println(dropdown.getFirstSelectedOption().getText());
				dropdown.selectByValue("INR");
				System.out.println(dropdown.getFirstSelectedOption().getText());
				Thread.sleep(1000);
				dropdown.selectByVisibleText("USD");
				System.out.println(dropdown.getFirstSelectedOption().getText());
				Thread.sleep(1000);
				driver.quit();
				
				
	

	}

}
