package week3.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		// Setup Disable Notification
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		// Pass Argument to Chrome Driver to disable Notification
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Enter C in FROM text box
		WebElement from = driver.findElement(By.xpath("//input[@data-message='Please enter a source city']"));
		from.sendKeys("C");
		// Click 2nd Option
		driver.findElement(By.xpath("(//ul[@class='autoFill']//following-sibling::li)[1]")).click();
		// Press Enter
		from.sendKeys(Keys.ENTER);
		// Enter D in TO text box
		WebElement to = driver.findElement(By.xpath("//input[@data-message='Please enter a destination city']"));
		to.sendKeys("B");
		// Click 1st Option
		driver.findElement(By.xpath("(//ul[@class='autoFill']/li)[1]")).click();
		// Press TAB key
		to.sendKeys(Keys.TAB);
		// Navigate to June
		driver.findElement(By.xpath("//button[text()='>']")).click();
		// Select 20th June Day
		driver.findElement(By.xpath("//tbody/tr[5]//td[7]")).click();
		// Click Search Bus
		driver.findElement(By.id("search_btn")).click();
		// Print the Number of Search by BUS on Date
		String search1 = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		String finalSearch1 = search1.replaceAll("[^0-9]", "");
		System.out.println("Number of Search by Bus on Date is " + finalSearch1);
		// Select Sleeper Class Filter Checkbox
		driver.findElement(By.xpath("//div[@class='close']")).click();
		driver.findElement(By.xpath("//label[@for='bt_SLEEPER'][1]")).click();
		// Print the Number of Sleeper Bus by filter Sleeper Bus
		String search2 = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		String finalSearch2 = search2.replaceAll("[^0-9]", "");
		System.out.println("Number of Search by Sleeper Bus is " + finalSearch2);
		// Select AC Bus Filter Checkbox
		driver.findElement(By.xpath("//label[@for='bt_AC'][1]")).click();
		// Print the Number of Sleeper Bus with AC by filter AC & Sleeper
		String search3 = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		String finalSearch3 = search3.replaceAll("[^0-9]", "");
		System.out.println("Number of Search by Sleeper Bus with AC is " + finalSearch3);
		driver.close();

	}

}
