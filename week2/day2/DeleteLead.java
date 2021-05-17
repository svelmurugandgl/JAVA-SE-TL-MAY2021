package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		//wait 30sec to load elements
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Login page
		driver.findElementByXPath("//input[@id='username']").sendKeys("demosalesmanager");
		driver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa");
		driver.findElementByXPath("//input[@value='Login']").click();
		// CRM SFA page
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		// Click Lead
		driver.findElementByXPath("//a[text()='Leads']").click();
		// Click Find Leads
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		// Get 1st EMP ID and Click same ID
		WebElement emp = driver.findElementByXPath("(//div[@unselectable='on']//a[@class='linktext'])[1]");
		String empID = emp.getText();
		emp.click();
		// Delete Specific Lead ID
		driver.findElementByXPath("//a[text()='Delete']").click();
		// Click Find Leads
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		// Enter stored ID
		driver.findElementByXPath("//div[@id='x-form-el-ext-gen253']//input[1]").sendKeys(empID);
		// Click Find Leads
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		if (driver.findElementByXPath("//div[text()='No records to display']").getText()
				.contains("No records to display")) {
			System.out.println("Confirmed - Record Deleted - PASS");
		} else {
			System.out.println("Confirmed - Record is NOT Deleted - FAIL");
		}

		// Close Driver
		driver.close();
	}

}
