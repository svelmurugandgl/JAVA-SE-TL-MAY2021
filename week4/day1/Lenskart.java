package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lenskart {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		// Pass Argument to Chrome Driver to disable Notification
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.lenskart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement compGlass = driver.findElement(By.linkText("Computer Glasses"));
		WebElement men = driver.findElement(By.xpath("(//div[@class='gender_img']//img[@alt='men'])[2]"));
		WebElement premium = driver.findElement(By.xpath("(//span[text()='PREMIUM RANGE'])[1]"));
		Actions builder = new Actions(driver);
		// Select Computer Glass=>men=>premium glass
		builder.moveToElement(compGlass).click(men).click(premium).build().perform();
		// Select Frame Type Round
		driver.findElement(By.xpath("//span[@title='Round']/img")).click();

		/*
		 * Thread.sleep(3000); JavascriptExecutor js = (JavascriptExecutor)driver;
		 * js.executeScript("window.scrollBy(0,400)"); Thread.sleep(3000);
		 */
		driver.findElement(By.xpath("//span[text()='MORE FILTERS']")).click();
		Thread.sleep(3000);
		builder.sendKeys(Keys.END).perform();
		WebElement frameColor = driver.findElement(By.xpath("(//li[@class='list-checkbox']//input)[1]"));
		builder.moveToElement(frameColor).perform();
		// Select highest number Frame Color Filter
		builder.moveToElement(frameColor).click().perform();
		Thread.sleep(10000);
		// get Filter Color Count
		String filterColor = driver.findElement(By.xpath("(//li[@class='list-checkbox']//span)[1]")).getText();
		String filterCount = filterColor.replaceAll("[^0-9]", "");
		// get Search Color Result Count
		String searchResult = driver.findElement(By.xpath("//div[contains(text(),'Showing')]")).getText();
		String searchCount[] = searchResult.split(" ");
		// Compare the count
		if (filterCount.equals(searchCount[searchCount.length - 2])) {
			System.out.println(
					"Frame Color Filter Count and Search Result Count is matched - PASS " + "\r\n Filter Count="
							+ filterCount + "\r\n Search Result Count= " + searchCount[searchCount.length - 2]);
		} else {
			System.out.println(
					"Frame Color Filter Count and Search Result Count is NOT matched - FAIL " + "\r\n Filter Count="
							+ filterCount + "\r\n Search Result Count= " + searchCount[searchCount.length - 2]);
		}
		// Get Size of Frame
		WebElement firstItem = driver.findElement(By.xpath("(//img[@class='img-responsive'])[1]"));
		WebElement frameSize = driver.findElement(By.xpath("(//div//p/span)[1]"));
		builder.moveToElement(firstItem).perform();
		System.out.println("Frame Size of 1st Item is " + frameSize.getText());

		Thread.sleep(10000);
		driver.close();

	}

}
