package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLeadFinal {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Enter User Name
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		// Enter Password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		// Click CRM Link
		driver.findElement(By.partialLinkText("SFA")).click();
		// Click Leads
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		// Click Find Leads
		((RemoteWebDriver) driver).findElementByXPath("//a[text()='Find Leads']").click();
		// Get 1st EMP ID
		WebElement emp1 = ((RemoteWebDriver) driver)
				.findElementByXPath("(//div[@unselectable='on']//a[@class='linktext'])[1]");
		String fromLeadID = emp1.getText();
		System.out.println("From Lead ID is " + fromLeadID);
		// Get 2nd EMP ID
		List<WebElement> emp2 = ((RemoteWebDriver) driver)
				.findElementsByXPath("(//table[contains(@class,'row-table')]//a[contains(@href,'partyId')])");
		String toLeadID = "";
		for (int i = 7; i < emp2.size(); i += 5) {
			if (!emp2.get(2).getText().equalsIgnoreCase(emp2.get(i).getText())) {
				toLeadID = emp2.get(i - 2).getText();
				break;
			}
		}
		System.out.println("To Lead ID is " + toLeadID);
		// Click Merge Leads
		driver.findElement(By.linkText("Merge Leads")).click();
		// Click From Lead Icon
		driver.findElement(By.xpath("//img[@alt='Lookup'][1]")).click();
		// Get windows handle into Set to access multiple window
		Set<String> getFromWindow = driver.getWindowHandles();
		// Put into List - To access specific window handle
		List<String> listFromWindow = new ArrayList<String>(getFromWindow);
		// Switch from main(0) window to new window(1)
		driver.switchTo().window(listFromWindow.get(1));
		// Enter Lead ID in new window
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(fromLeadID);
		// Click Find Leads in new window
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		// Click 1st Resulting Lead
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//td//a[@class='linktext'])[1]")).click();
		// Switch to Main(0) Window
		driver.switchTo().window(listFromWindow.get(0));
		// Click To Lead Icon
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		// Get windows handle into Set to access multiple window
		Set<String> getToWindow = driver.getWindowHandles();
		// Put into List - To access specific window handle
		List<String> listToWindow = new ArrayList<String>(getToWindow);
		// Switch from main(0) window to new window(1)
		driver.switchTo().window(listToWindow.get(1));
		// Enter Lead ID in new window
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(toLeadID);
		// Click Find Leads in new window
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		// Click 1st Resulting Lead
		driver.findElement(By.xpath("(//td//a[@class='linktext'])[1]")).click();
		// Switch to Main(0) Window
		driver.switchTo().window(listToWindow.get(0));
		// Click Merge Leads
		driver.findElement(By.className("buttonDangerous")).click();
		// Accept Merge Alert
		driver.switchTo().alert().accept();
		// Click Find Leads Link
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		// Enter From Lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(fromLeadID);
		// Click Find Leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		// To Check Merge is successful/Failed validation
		String msg = driver.findElement(By.xpath("//div//div[@class='x-paging-info']")).getText();
		if (msg.contains("No records")) {
			System.out.println(fromLeadID + " Merge Lead is Successful - PASS");
		} else {
			System.out.println(fromLeadID + " Merge Lead is NOT Successful - FAIL");
		}
		Thread.sleep(10000);
		driver.close();
	}

}
