
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_4_Feature_TakingWebelement_PartialScreenshot {

	public static void main(String[] args) throws IOException {
		// Firefox browser
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebElement name=driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys("Selenium Practice");
		
		File file=name.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("logo.png"));
		
	}

}
