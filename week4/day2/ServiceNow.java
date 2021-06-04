package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		// Pass Argument to Chrome Driver to disable Notification
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://dev103117.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		// Enter User Name as admin
		driver.findElement(By.id("user_name")).sendKeys("admin");
		// Enter Password as India@123
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		// Click Login
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(5000);
		// Switch to Main() page
		driver.switchTo().defaultContent();
		// Enter incident into Filter
		driver.findElement(By.id("filter")).sendKeys("incident");
		// Init JS
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement viewAll = driver.findElement(By.xpath("(//div[@class='sn-widget-list-title' and text()='All'])[2]"));
		// Scroll to All
		js.executeScript("arguments[0].scrollIntoView()", viewAll);
		// Click All
		viewAll.click();
		// Switch to gsft frame
		driver.switchTo().frame("gsft_main");
		// Click New Button
		driver.findElement(By.xpath("//button[@title='List controls']/following-sibling::button")).click();
		// Click Caller Search button
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']/span")).click();
		Thread.sleep(5000);
		// Get Window Handles
		Set<String> gethandles = driver.getWindowHandles();
		List<String> listhandles = new ArrayList<String>(gethandles);
		// Move to new window
		driver.switchTo().window(listhandles.get(1));
		Thread.sleep(10000);
		Actions builder = new Actions(driver);
		// Select 1st Caller
		WebElement caller = driver.findElement(By.xpath("//tbody//tr[1]/td[3]/a"));
		builder.moveToElement(caller).click().perform();
		Thread.sleep(5000);
		// Move to main window
		driver.switchTo().window(listhandles.get(0));
		// Switch to gsft frame
		driver.switchTo().frame("gsft_main");
		// Enter Short Description
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("WELCOME");
		// Store Incident Number
		String incidentNum = driver.findElement(By.xpath("//input[@id='sys_original.incident.number']"))
				.getAttribute("value");
		System.out.println(incidentNum);
		// Click Submit button
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
		// Enter saved Incident ID
		driver.findElement(By.xpath("//input[@id='incident_table_header_search_control']")).sendKeys(incidentNum,
				Keys.ENTER);
		// Verify Incident is Created/NOT Created
		if (driver.findElement(By.xpath("//tbody//tr[1]/td[3]")).getText().equals(incidentNum)) {
			System.out.println("Incident Record: " + incidentNum + " is created" + "- PASS");
		} else {
			System.out.println("Incident Record: " + incidentNum + " is NOT created" + "- FAIL");
		}
		driver.switchTo().defaultContent();
		driver.close();
	}

}
