import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntroduction {

	public static void main(String[] args) {
		
		// Invoking Chrome Browser
		//Chrome-- ChromeDriver extends > Methods close get
		//Firefox-- FirefoxDriver extends > Methods close get
		//Safari-- SafariDriver extends > Methods close get
		//WebDriver close get
		//WebDriver methods + class methods
		
		//ChromeDriver.exe --> Chrome browser Selenium Manager
		
		//Step to invoke chrome driver
		
	//	System.setProperty("webdriver.chrome.driver", "/Users/yashchouhan/Downloaded_Jars/chromedriver");
	//	WebDriver driver= new ChromeDriver();
	
		//Chrome
	//	System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
	//	WebDriver driver= new FirefoxDriver();
		
		//Microsoft Edge
	//	System.setProperty("webdriver.edge.driver", "/Users/yashchouhan/Downloaded_Jars/msedgedriver");
	//	WebDriver driver= new FirefoxDriver();
		
		//Firefox
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver= new FirefoxDriver();
		
		
		//driver.get("https://rahulshettyacademy.com/");
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.quit();
	}

}
