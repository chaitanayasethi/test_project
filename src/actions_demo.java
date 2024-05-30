import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class actions_demo {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://mail.google.com/");
		
		WebElement username = driver.findElement(By.xpath("//input[@type='email']"));
		
	
		Actions ac = new Actions(driver);
		ac.moveToElement(username).click().
		keyDown(username, Keys.SHIFT).
		sendKeys(username, "techandmore").
		doubleClick(username).
		contextClick()
		.build().perform();
		
		Thread.sleep(3000);
		driver.quit();
   		

	}
}











