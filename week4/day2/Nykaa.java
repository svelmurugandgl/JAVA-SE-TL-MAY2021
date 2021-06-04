package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		// Pass Argument to Chrome Driver to disable Notification
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Init Action Builder
		Actions nykaa = new Actions(driver);
		WebElement brand = driver.findElement(By.xpath("//li/a[text()='brands']"));
		// Mouse Over Brand
		nykaa.moveToElement(brand).perform();
		Thread.sleep(1000);
		WebElement popular = driver.findElement(By.xpath("//div/a[text()='Popular']"));
		WebElement loreal = driver.findElement(By.xpath("(//li/a[contains(@href,'loreal-paris')])[1]"));
		// Mouse Over Popular and then Click L'Oreal Paris
		nykaa.moveToElement(popular).click(loreal).build().perform();
		// Store window Handles - Main Window(0) and L'Oreal window(1)
		Set<String> storeHandle = driver.getWindowHandles();
		// Get window Handles into List
		List<String> getHandle = new ArrayList<String>(storeHandle);
		// Switch To L'Oreal window(1)
		driver.switchTo().window(getHandle.get(1));
		Thread.sleep(2000);
		// Check L'Oreal Title
		if (driver.getTitle().contains("L'Oreal Paris")) {
			System.out.println("Window Title has L'Oreal Paris - PASS");
		} else {
			System.out.println("Window Title does NOT have L'Oreal Paris - FAIL");
		}
		Thread.sleep(1000);
		// Page Down to View Sort Element
		nykaa.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		// Click Sort By
		driver.findElement(By.xpath("//span[contains(text(),'Sort By')]")).click();
		Thread.sleep(1000);
		// Click Customer Top Rated element
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(1000);
		// Page Down to View Category Element
		nykaa.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_UP).perform();
		Thread.sleep(1000);
		// Click Category
		driver.findElement(By.xpath("//div[text()='Category']")).click();
		// Click Hair
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		// Click Hair Care
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		// Click Shampoo
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		Thread.sleep(3000);
		// Check Shampoo filter is applied
		String filterText = driver.findElement(By.xpath("//li[contains(text(),'Shampoo')]")).getText()
				.replaceAll("close", "");
		if (filterText.equals("Shampoo")) {
			System.out.println("Shampoo Filter is applied - PASS");
		} else {
			System.out.println("Shampoo Filter is NOT applied - FAIL");
		}
		// Click L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("(//div/h2[contains(@title,'Colour Protect Shampoo')])[1]")).click();
		// Save window handles
		Set<String> saveHandle = driver.getWindowHandles();
		// Get Window handles Main Window(0), L'Oreal window(1), L'Oreal Shampoo
		// window(2)
		List<String> getNewHandle = new ArrayList<String>(saveHandle);
		// Switch to L'Oreal Shampoo window(2)
		driver.switchTo().window(getNewHandle.get(2));
		Thread.sleep(2000);
		// Get Size WebElement to Select
		WebElement size = driver.findElement(By.tagName("select"));
		Select selectSize = new Select(size);
		// Select 175ml
		selectSize.selectByVisibleText("175ml");
		// Print MRP of the Product
		System.out.println("Product MRP is "
				+ driver.findElement(By.xpath("(//div//span[contains(@class,'content-price-offer')])[1]")).getText()
						.replaceAll("[^0-9]", ""));
		// Click Add To Bag
		driver.findElement(By.xpath("(//button[contains(@class,'combo-add-to-btn')])[1]")).click();
		Thread.sleep(3000);
		// Click Shopping Bag icon
		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		Thread.sleep(5000);
		// Get, Store and Print Grand Total
		String grandTotal = driver.findElement(By.xpath("(//div[contains(@class,'value')])[5]")).getText()
				.replaceAll("[^0-9]", "");
		System.out.println("\r\nGrand Total is " + grandTotal);
		Thread.sleep(5000);
		// Click Proceed
		driver.findElement(By.xpath("//div[@class='second-col']/button")).click();
		Thread.sleep(3000);
		// Click Continue as Guest
		driver.findElement(By.xpath("//button[@type='button' and contains(@class,'full big')]")).click();
		Thread.sleep(3000);
		// Get final grand total
		String finalGrandTotal = driver.findElement(By.xpath("(//div[@class='value']/span)[2]")).getText();
		System.out.println("Final Grand Total is " + finalGrandTotal);
		// Check grand total is same
		if (finalGrandTotal.equals(grandTotal)) {
			System.out.println("Grand Totals are same - PASS");
		} else {
			System.out.println("Grand Totals are NOT same - FAIL");
		}
		Thread.sleep(5000);
		driver.quit();

	}

}
