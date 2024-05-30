import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class tam_demo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//implicitWait() sets default wait time before every element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


		driver.get("https://login.salesforce.com/");
		
		
		
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='password']"));

		
		//explicitWait() tells the WebDriver to wait for certain conditions before maximum time exceeds
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//multiple conditions
		wait.until(ExpectedConditions.visibilityOf(usernameElement));

		System.out.println(passwordElement.getAttribute("name"));

		//Thread.sleep pauses the execution for mentioned duration even if the element is found on the web page
		Thread.sleep(10000);
		driver.quit();
	    
		

	}
}











