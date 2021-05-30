package week4.day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JquerySortable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Switch to frame
		driver.switchTo().frame(0);
		// Init Action
		Actions dragList = new Actions(driver);
		// Get Viewable Source Element
		WebElement viewSource = driver.findElement(By.xpath("(//ul[@id='sortable']//li)[1]"));
		// Scroll to Source Element using JS Method
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", viewSource);
		// Get entire drag and drop items into WebElement List
		List<WebElement> dragElements = driver.findElements(By.xpath("//ul[@id='sortable']//li"));
		// Iterate and move element(source to target) from Ascendng Order to Descending Order of element
		for (int i = 0, j = dragElements.size(); j > 0; i++, j--) {
			dragList.dragAndDrop(dragElements.get(i),
					driver.findElement(By.xpath("(//ul[@id='sortable']//li)[" + j + "]"))).perform();
		}
		// Switch to Frame to Main Page
		driver.switchTo().defaultContent();
		// Close Window
		Thread.sleep(10000);
		driver.close();
	}

}
