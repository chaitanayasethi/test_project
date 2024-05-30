import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class exception_handling {

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
		
		WebElement wbLeadsLink = driver.findElement(By.xpath("//a//span[text()='Leadss']"));
		
		//ElementNotInteractable or JavaScriptExecutorException 
		//wbLeadsLink.click();
		
		//NoSuchElementException (similar to NoSuchFrame/NoSuchWindow Exception)
		js.executeScript("arguments[0].click();", wbLeadsLink);

		
		
		
		driver.quit();	
		
		//NoSuchSession exception
		//driver.get("https://login.salesforce.com");

			
		

		

	}
}











