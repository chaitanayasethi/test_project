import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class global_actions_demo {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://login.salesforce.com");

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hpotter5@test.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("devorg1234");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		Thread.sleep(3000);
		
		//new event creation
		driver.findElement(By.xpath("(//a//lightning-icon//span//lightning-primitive-icon)[1]")).click();
		driver.findElement(By.xpath("//a[@title='New Event']")).click();
		driver.findElement(By.xpath("//*[text()='Subject']//ancestor::lightning-grouped-combobox//div//input")).sendKeys("EventTechAndMoreSubject");
		driver.findElement(By.xpath("(//button//span[text()='Save'])[last()]")).click();
		driver.findElement(By.xpath("//a//div[contains(text(), 'EventTechAndMoreSubject')]")).click();
		String eventTitleTextExpected = driver.findElement(By.xpath("(//h1//div[text()='Event']//following::div//span)[1]")).getText();
		Assert.assertEquals("EventTechAndMoreSubject",eventTitleTextExpected);
		
		System.out.println("event creation successful");

		//navigate to the home page
		driver.get("https://hogwards-dev-ed.develop.lightning.force.com/lightning/page/home");
		Thread.sleep(3000);
		
		//new task creation
		driver.findElement(By.xpath("(//a//lightning-icon//span//lightning-primitive-icon)[1]")).click();
		driver.findElement(By.xpath("//a[@title='New Task']")).click();
		driver.findElement(By.xpath("//*[text()='Subject']//ancestor::lightning-grouped-combobox//div//input")).sendKeys("TaskTechAndMoreSubject");
		driver.findElement(By.xpath("(//a[text()='Not Started'])[1]")).click();
		driver.findElement(By.xpath("(//a[text()='In Progress'])[1]")).click();
		driver.findElement(By.xpath("(//button//span[text()='Save'])[last()]")).click();
		driver.findElement(By.xpath("//a//div[contains(text(), 'TaskTechAndMoreSubject')]")).click();

		String taskTitleTextExpected = driver.findElement(By.xpath("(//h1//div[text()='Task']//following::div//span)[1]")).getText();
		Assert.assertEquals("TaskTechAndMoreSubject",taskTitleTextExpected);
		
		System.out.println("task creation successful");
		
		//editing the newly created task
		driver.findElement(By.xpath("//span[text()='Subject']//following::button[@title='Edit Subject']//lightning-primitive-icon")).click();
		WebElement subjectInput = driver.findElement(By.xpath("(//label[text()='Subject']//following::lightning-base-combobox//input)[1]"));
		
		Actions ac = new Actions(driver);
		ac.click(subjectInput);
		ac.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE);
		ac.build().perform();
		
		driver.findElement(By.xpath("(//label[text()='Subject']//following::lightning-base-combobox//input)[1]")).sendKeys("Edit TaskTechAndMoreSubject");
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		
		driver.findElement(By.xpath("//span[text()='Subject']//following::button[@title='Edit Subject']//lightning-primitive-icon")).click();
		String editedTaskSubject = driver.findElement(By.xpath("(//label[text()='Subject']//following::lightning-base-combobox//input)[1]")).getText();
		Assert.assertEquals("Edit TaskTechAndMoreSubject",editedTaskSubject);

		System.out.println("task update successful");


		
		
	}
}












