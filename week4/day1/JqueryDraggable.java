package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDraggable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Switch to frame
		driver.switchTo().frame(0);
		// Get Source Element to drag
		WebElement source = driver.findElement(By.id("draggable"));
		// Scroll to Source Element using JS Method
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", source);
		// Init Action Builder
		Actions drag = new Actions(driver);
		// Get Source Element Original Location into Point Class(x,y)
		Point orgLocation = source.getLocation();
		// Drag and Drop the Source Element
		drag.dragAndDropBy(source, (source.getLocation().getX()) + 100, (source.getLocation().getY()) + 100).perform();
		// To Ensure - Element Draggable is Success/Failure
		// 8pixel offset applied to get absolute current location of the source element
		if (source.getLocation().getX() - 8 != orgLocation.x && source.getLocation().getY() - 8 != orgLocation.y) {
			System.out.println(
					"Original Source Element Locations(x,y)= " + "(" + orgLocation.x + "," + orgLocation.y + ")");
			System.out.println("Moved Source Element Locations(x,y)= " + "(" + (source.getLocation().getX() - 8) + ","
					+ (source.getLocation().getY() - 8) + ")");
			System.out.println("Draggable is Success - PASS");
		} else {
			System.out.println(
					"Original Source Element Locations(x,y)= " + "(" + orgLocation.x + "," + orgLocation.y + ")");
			System.out.println("Moved Source Element Locations(x,y)= " + "(" + (source.getLocation().getX() - 8) + ","
					+ (source.getLocation().getY() - 8) + ")");
			System.out.println("Draggable is Failed - FAIL");
		}
		// Move to frame to Main Page
		driver.switchTo().defaultContent();
		// Close Driver
		Thread.sleep(10000);
		driver.close();

	}

}
