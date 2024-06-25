import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class loginScenario_demo {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://login.salesforce.com");

		
		//valid user-name and incorrect password
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hpotter5@test.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("devorg1234");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		
//		String homePageTextExpected = driver.findElement(By.xpath("//span[contains(normalize-space(), \"Good evening, Harry Potter. Let's get selling!\")]")).getText();
//		String homePageTextActual = "Good evening, Harry Potter. Let's get selling!";
//		Assert.assertEquals(homePageTextActual, homePageTextExpected);
//
//		WebElement viewProfileButton = driver.findElement(By.xpath("//span[text()='View profile']"));
//        js.executeScript("arguments[0].click();", viewProfileButton);
//
//		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
//
//
//		//invalid user-name and incorrect password
//		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hpotter@test.com");
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("devorg123");
//		driver.findElement(By.xpath("//input[@value='Log In']")).click();
//		
//		String invlaidCredErrorExpected = driver.findElement(By.xpath("//form//div[contains(normalize-space(), \"Please check your username and password. If you still can't log in, contact your Salesforce administrator.\")]")).getText();
//		String invlaidCredErrorActual = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
//		Assert.assertEquals(invlaidCredErrorActual, invlaidCredErrorExpected);	
//		
//		System.out.println("successfully executed");
//		
//		driver.quit();

   		

	}
}











