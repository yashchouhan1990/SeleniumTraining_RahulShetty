import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_Locators {

	public static void main(String[] args) throws InterruptedException {
		
				//Firefox
				System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
				WebDriver driver= new FirefoxDriver();
				
				//Implicity wait - 2 seconfs time out
				
			//  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); -- In latest versions of selenium
				
					
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				
				//driver.get("https://rahulshettyacademy.com/");
				driver.get("https://rahulshettyacademy.com/locatorspractice/");
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
				
				driver.findElement(By.id("inputUsername")).sendKeys("rahul");
				driver.findElement(By.name("inputPassword")).sendKeys("Hello123");
				
				driver.findElement(By.className("signInBtn")).click();
				Thread.sleep(2000);
				
				String Errormessage= driver.findElement(By.cssSelector("p.error")).getText();
				System.out.println("Error Message=" + Errormessage);
				
				driver.findElement(By.linkText("Forgot your password?")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Rahul");
				driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Rahul@gmail.com");
				driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9876543210");
				driver.findElement(By.className("reset-pwd-btn")).click();
				
				String ErrorMessage=driver.findElement(By.className("infoMsg")).getText();
				System.out.println("Message "+ErrorMessage);
				String[] SplittedString=ErrorMessage.split("'");
				System.out.println(SplittedString[0]);
				System.out.println(SplittedString[1]);
				System.out.println(SplittedString[2]);
				
				String NewPassword= SplittedString[1];
				driver.findElement(By.className("go-to-login-btn")).click();
				
				driver.findElement(By.id("inputUsername")).sendKeys("rahul");
				driver.findElement(By.name("inputPassword")).sendKeys(NewPassword);
				Thread.sleep(2000);
				driver.findElement(By.className("signInBtn")).click();
				driver.findElement(By.id("chkboxTwo")).click();
				
			//	driver.findElement(By.xoath(""))
				Thread.sleep(2000);
				driver.close();

	}

}
