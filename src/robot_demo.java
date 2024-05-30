import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class robot_demo {

	public static void main(String[] args) throws InterruptedException, AWTException {

		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.navigate().to("https://blueimp.github.io/jQuery-File-Upload/");
		  Thread.sleep(5000);
		  driver.findElement(By.cssSelector(".btn.btn-success.fileinput-button")).click();
		  
		  Thread.sleep(2000);
		  //Create object for Robot class
		  Robot robot=new Robot();
		 
		  //Store the path of the file to be uploaded using StringSelection Class Object
		  StringSelection filepath=new StringSelection("D:\\profile.jpg");
		 
		  //Copy above path to Clipboard
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath,null);
		  
		  //Press Control&V to paste the above path
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  Thread.sleep(1000);
		  
		  //Release Control & V buttons
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  
		  //Press Enter
		  robot.keyPress(KeyEvent.VK_ENTER);
		  //Release Enter
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  
		  //wait for the file to get uploaded
		  robot.delay(2000);
		  System.out.println("File Uploaded Successfully");
		  //driver.close();

	}
}











