import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class tam_demo {

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
		//click() method
		driver.findElement(By.xpath("//input[@value='Log In']")).click();

		driver.get("https://hogwards-dev-ed.develop.lightning.force.com/lightning/r/Lead/00Q2w00000U1CNTEA3/view");
		Thread.sleep(4000);
		//getText() method implementation
		String getTextVaue = driver.findElement(By.xpath("//html//div//h1//slot//lightning-formatted-name")).getText();
		System.out.println("getTextVaue** " + getTextVaue);
		//getAttribute() method implementation
		String getAttributeVaue = driver.findElement(By.xpath("//html//div//h1//slot//lightning-formatted-name")).getAttribute("slot");
		System.out.println("getAttributeVaue** " + getAttributeVaue);
		//isDisplayed() method implementation
		boolean displayFlag = driver.findElement(By.xpath("//p[text()='Title']//following::p//slot//lightning-formatted-text[text()='CFO']")).isDisplayed();
		System.out.println("displayFlag** "+ displayFlag);
		Thread.sleep(2000);
		driver.quit();


		

	}
}











