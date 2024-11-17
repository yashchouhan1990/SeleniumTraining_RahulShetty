import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_Locators_2 {

	public static void main(String[] args) throws InterruptedException {
		
		//Firefox
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		WebDriver driver= new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//driver.get("https://rahulshettyacademy.com/");
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		Selenium_Locators_2 obj= new Selenium_Locators_2();
		String Password=obj.getPassword(driver);
		System.out.println("Print Password "+Password);
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys(Password);
		driver.findElement(By.id("chkboxTwo")).click();
		
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		
		String Welcometext= driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		System.out.println("Welcome "+Welcometext);
		
		driver.findElement(By.xpath("//button[text()='Log Out']"));
		driver.findElement(By.xpath("//p[text()='You are successfully logged in.']"));
		
		driver.quit();
		

	}
	
	public String getPassword(WebDriver driver) throws InterruptedException
	{
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
		
		String Password= SplittedString[1];
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(2000);
		return Password;
		
	}

}
