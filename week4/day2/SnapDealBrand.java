package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealBrand {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		// Pass Argument to Chrome Driver to disable Notification
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Init Action Builder
		Actions fashionBuilder = new Actions(driver);
		// Init JS
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Mouse Over on men fashion and then Click Sport Shoe
		WebElement menFashion = driver.findElement(By.xpath("(//li[@class='navlink lnHeight']//span)[1]"));
		WebElement menSportShoe = driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]"));
		fashionBuilder.moveToElement(menFashion).moveToElement(menSportShoe).click().perform();
		// Get the Sport Shoes Count
		String shoeCount = driver.findElement(By.xpath("//span[@class='category-count']")).getText()
				.replaceAll("[^0-9]", "");
		System.out.println("Sport Shoe Count is " + shoeCount);
		// Click Training Shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		// Click Sort Arrow
		driver.findElement(By.xpath("//i[contains(@class,'sort-arrow')]")).click();
		// Click Price Low to High
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		// Scroll to end of the page by Page Down Key
		int i = 1;
		while (i <= 40) {
			fashionBuilder.sendKeys(Keys.PAGE_DOWN).perform();
			Thread.sleep(5000);
			i++;
		}
		// Move to Last Element in the Search Page
		fashionBuilder.moveToElement(driver.findElement(By.xpath("(//span[starts-with(@id,'display-price')])[last()]")))
				.perform();
		Thread.sleep(10000);
		// Compare Sorting low to high happened (or) NOT
		List<WebElement> priceList = driver.findElements(By.xpath("//span[starts-with(@id,'display-price')]"));
		List<String> source = new ArrayList<String>();
		List<Integer> sourcePrice = new ArrayList<Integer>();
		for (int j = 0; j < priceList.size(); j++) {
			source.add(priceList.get(j).getAttribute("display-price").replaceAll("[^0-9]", ""));
			sourcePrice.add(Integer.valueOf(source.get(j)));
		}
		List<Integer> targetPrice = new ArrayList<Integer>(sourcePrice);
		Collections.sort(targetPrice);
		if (sourcePrice.equals(targetPrice)) {
			System.out.println("Source Price " + sourcePrice);
			System.out.println("Target Price " + targetPrice);
			System.out.println("Price Low to High Sort is Success - PASS");
		} else {
			System.out.println("Source Price " + sourcePrice);
			System.out.println("Target Price " + targetPrice);
			System.out.println("Price Low to High Sort is Failure - FAIL");
		}
		Thread.sleep(2000);
		// Get Blue Color Shoes element
		WebElement viewColor = driver.findElement(By.xpath("//label[@for='Color_s-Blue']/a[contains(text(),'Blue')]"));
		// Scroll to Viewable Element using JS Method
		js.executeScript("arguments[0].scrollIntoView()", viewColor);
		// Click Blue Color Filter
		fashionBuilder.moveToElement(viewColor).click().build().perform();
		// Get Red Tape Brand Element
		Thread.sleep(2000);
		WebElement brandElement = driver.findElement(By.xpath("//a[contains(text(),'Red Tape')]"));
		// Scroll to Viewable Element using JS Method
		js.executeScript("arguments[0].scrollIntoView()", brandElement);
		Thread.sleep(2000);
		fashionBuilder.moveToElement(brandElement).click().perform();
		Thread.sleep(2000);
		// Mouse over 1st Blue Shoe and Click Quick View
		WebElement blueShoe = driver.findElement(By.xpath("(//p[starts-with(@title,'Red Tape')])[1]"));
		WebElement quickView = driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]"));
		fashionBuilder.moveToElement(blueShoe).moveToElement(quickView).click().build().perform();
		// Get Price and Discount from Quick View
		Thread.sleep(3000);
		WebElement shoePrice = driver.findElement(By.xpath("//div//span[@class='payBlkBig']"));
		WebElement shoeDiscount = driver.findElement(By.xpath("//div//span[contains(@class,'percent-desc')]"));
		System.out.println("Shoe Price is RS. " + shoePrice.getText().replaceAll("[^0-9]", ""));
		System.out.println("Shoe Discount is " + (shoeDiscount.getText().split(" "))[0]);
		// take Blue Shoe Snap Shot
		WebElement shoeImage = driver.findElement(By.xpath("(//li/img)[1]"));
		File targetElement = ((TakesScreenshot) shoeImage).getScreenshotAs(OutputType.FILE);
		File fileLocation = new File("./snapdeal/BlueShoe.jpeg");
		FileUtils.copyFile(targetElement, fileLocation);
		// Close current window
		driver.findElement(By.xpath("//div[starts-with(@class,'close')]")).click();
		// Close Main Window
		driver.close();
	}

}
