package week4.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		// Pass Argument to Chrome Driver to disable Notification
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Init Actions
		Actions myntra = new Actions(driver);
		// Init JS
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Get Women Element
		WebElement women = driver.findElement(By.xpath("(//a[text()='Women'])[1]/parent::div"));
		// Mouse over women
		myntra.moveToElement(women).perform();
		Thread.sleep(1000);
		// Get Jacket and Coat Element and Click
		driver.findElement(By.linkText("Jackets & Coats")).click();
		// Find Total count - Jacket and Coat
		WebElement getTotalCount = driver.findElement(By.xpath("//span[@class='title-count']"));
		int totalCount = Integer.valueOf(getTotalCount.getText().replaceAll("[^0-9]", ""));
		// Get Category Count
		List<WebElement> category = driver.findElements(By.xpath("//span[@class='categories-num']"));
		// Jacket Count
		int jacketCount = Integer.valueOf(category.get(0).getText().replaceAll("[^0-9]", ""));
		// Coat Count
		int coatCount = Integer.valueOf(category.get(1).getText().replaceAll("[^0-9]", ""));
		// Validate the sum of categories count matches
		if (totalCount == (jacketCount + coatCount)) {
			System.out.println("Total Count matches the sum of categories count - PASS");
			System.out.println("Total Count= " + totalCount + " equal to " + "(" + "Jacket Count= " + jacketCount + ","
					+ " Coat Count= " + coatCount + ")");
		} else {
			System.out.println("Total Count NOT matches the sum of categories count - FAIL");
			System.out.println("Total Count= " + totalCount + " NOT equal to " + "(" + "Jacket Count= " + jacketCount
					+ "," + "Coat Count= " + coatCount + ")");
		}
		// Check Coat
		driver.findElement(By.xpath("(//ul[@class='categories-list']//div)[2]")).click();
		Thread.sleep(5000);
		// Click Brand + More
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		// Enter Brand Name as Mango
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("MANGO");
		Thread.sleep(5000);
		// Enable Mango Check
		myntra.moveToElement(driver.findElement(By.xpath("(//input[@value='MANGO'])[2]"))).click().perform();
		// Click X
		driver.findElement(By.xpath("//div[@class='FilterDirectory-titleBar']//span")).click();
		// Confirm page has Mango brand only
		Thread.sleep(3000);
		List<WebElement> countMango = driver.findElements(By.xpath("//div/h3"));
		int count = 0;
		for (int i = 0; i < countMango.size(); i++) {
			if (!(countMango.get(i).getText().equals("MANGO"))) {
				count++;
			}
		}
		if (count == 0) {
			System.out.println("All the Coats are " + "\"" + "MANGO" + "\"" + " Brand - PASS");
		} else {
			System.out.println("All the Coats are NOT " + "\"" + "MANGO" + "\"" + " Brand - FAIL");
		}
		// Sort By better Discount
		WebElement sort = driver.findElement(By.xpath("//span[text()='Recommended']"));
		WebElement betterDiscount = driver.findElement(By.xpath("(//label[@class='sort-label '])[3]"));
		myntra.moveToElement(sort).click(betterDiscount).build().perform();
		// Scroll to Element to view
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		// Get 1st Item Price
		WebElement findPrice = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]"));
		System.out.println("1st Item Price is " + findPrice.getText());
		// Mouse over size of the 1st item
		WebElement size = driver.findElement(By.xpath("(//span[@class='product-sizeNoInventoryPresent'])[1]"));
		myntra.moveToElement(findPrice).perform();
		myntra.moveToElement(size).perform();
		Thread.sleep(1000);
		// Click WishList
		driver.findElement(By.xpath("(//span//span[starts-with(@class,'myntraweb-sprite')])[1]")).click();
		// Close driver
		driver.quit();

	}

}
