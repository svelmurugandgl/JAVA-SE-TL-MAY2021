package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDroppable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Switch to frame
		driver.switchTo().frame(0);
		// Get Source
		WebElement source = driver.findElement(By.id("draggable"));
		// Scroll to Source Element using JS Method
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", source);
		// Get Target
		WebElement target = driver.findElement(By.id("droppable"));
		// Build Action
		Actions builder = new Actions(driver);
		// Drag and Drop Action Execute
		builder.dragAndDrop(source, target).perform();
		// Check the Drag and Drop is sucess/NOT
		if (driver.findElement(By.xpath("//p[text()='Dropped!']")).getText().contains("Dropped")) {
			System.out.println("Droppable is Successful - PASS");
		} else {
			System.out.println("Droppable is Failed - FAIL");
		}
		// Switch to Frame to Main Page
		driver.switchTo().defaultContent();
		// Close Window
		driver.close();

	}

}
