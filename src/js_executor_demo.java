import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class js_executor_demo {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Launching the Site.
        driver.get("https://moneyboats.com/");

 
        //Maximize window
        driver.manage().window().maximize();
        	
        Thread.sleep(3000);
        
 
        //Get page title and Domain using JavascriptExecutor
        String titleText =  js.executeScript("return document.title;").toString();
        System.out.println("Page Title is: "+ titleText);
 
        String domainName=  js.executeScript("return document.domain;").toString();
        System.out.println("Domain is: "+domainName);
 
        //To generate an Alert window using JavascriptExecutor. Display the alert message
        //js.executeScript("alert('Successfully Logged In');");
        
        //verticalScrollBy1000px
        js.executeScript("window.scrollBy(0,1000)");
        
        //Perform Click on LOGIN button using JavascriptExecutor
        WebElement button =driver.findElement(By.xpath("//*[text()='Designer Templates']"));
        js.executeScript("arguments[0].click();", button);

        Thread.sleep(2000);
        //driver.quit();
	    
		

	}
}











