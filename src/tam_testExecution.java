import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class tam_testExecution {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();
		
		driver.get("https://login.salesforce.com");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hpotter5@test.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("devorg1234");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
	
		Thread.sleep(5000);
		
		WebElement wbContactsTab = driver.findElement(By.xpath("//a//span[text()='Accounts']"));
		js.executeScript("arguments[0].click();", wbContactsTab);

		Thread.sleep(4000);
		driver.findElement(By.xpath("//a//div[@title='New']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[text()='Account Name']//ancestor::label//following::div//input[@name='Name']")).sendKeys("Tech and more");
		Thread.sleep(4000);
		WebElement wbContactsSaveBtn = driver.findElement(By.xpath("//lightning-button//button[@name='SaveEdit']"));
		wbContactsSaveBtn.click();
		Thread.sleep(5000);
		String accountNameActual = driver.findElement(By.xpath("//dl//dt//div//span[text()='Account Name']//ancestor::dt//following-sibling::dd//div//span//slot//lightning-formatted-text")).getText();

		Assert.assertEquals("Tech and more", accountNameActual);
		driver.quit();
		System.out.println("execution complete");

   		

	}
}











