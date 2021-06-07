package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MergeLeadFinal extends TestBaseClass {
	@Test
	public void runMergeLead() throws InterruptedException {

		// Click Leads
		driver.findElementByXPath("//a[text()='Leads']").click();
		// Click Find Leads
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		// Get 1st EMP ID
		WebElement emp1 = driver.findElementByXPath("(//div[@unselectable='on']//a[@class='linktext'])[1]");
		String fromLeadID = emp1.getText();
		System.out.println("From Lead ID is " + fromLeadID);
		// Get 2nd EMP ID
		WebElement emp2 = driver
				.findElementByXPath("(//table[contains(@class,'row-table')]//a[contains(@href,'partyId')])[6]");
		String toLeadID = emp2.getText();
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
		// To Check Merge is successful/Failed validation
		if (driver.findElement(By.xpath("//div[text()='No records to display']")).getText().contains("No records")) {
			System.out.println(fromLeadID + " Merge Lead is Successful - PASS");
		} else {
			System.out.println(fromLeadID + " Merge Lead is NOT Successful - FAIL");
		}

	}

}
