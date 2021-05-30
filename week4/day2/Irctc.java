package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Irctc {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		// Pass Argument to Chrome Driver to disable Notification
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//button[@type='submit']"));
		//To Scroll till to view element
		js.executeScript("arguments[0].scrollIntoView()", element);
		// Click Non-Model Alert
		element.click();
		// JS Method to scroll down to end
		// js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// Click Flight
		driver.findElement(By.xpath("//a[contains(text(),'FLIGHT')]")).click();
		// Get Window Handles
		Set<String> setHandle = driver.getWindowHandles();
		List<String> listHandle = new ArrayList<String>(setHandle);
		// Move to Window(2)
		driver.switchTo().window(listHandle.get(1));
		// Optional to get screen shot without Non-Model Alert
		// driver.findElement(By.xpath("//button[text()='Ok']")).click();
		// Take Screenshot - Flights Page
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File target = new File("./irctc/FLIGHTS.jpeg");
		FileUtils.copyFile(source, target);
		// Close Window(2)
		driver.close();
		// Move to Window(1)
		driver.switchTo().window(listHandle.get(0));
		// To Ensure Windows Control transfer to Window(1)
		System.out.println("you are currently at \r\n" + driver.getTitle());

	}

}
