package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		// wait 30sec to load elements
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
		// enter First Name
		driver.findElementByXPath("(//div[@class='x-form-item x-tab-item']//input)[2]").sendKeys("VELMURUGAN");
		// Click Find Leads
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		// Click 1st record
		Thread.sleep(30000);
		driver.findElementByXPath(
				"(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a)[1]").click();
		// Verify Page Title
		if (driver.getTitle().contains("View Lead")) {
			System.out.println("Verifed Page Title is Correct - PASS");
		} else {
			System.out.println("Verifed Page Title is NOT Correct - FAIL");
		}
		// Click Edit
		driver.findElementByXPath("//a[text()='Edit']").click();
		// change Company Name
		WebElement cmpName = driver.findElementByXPath("//input[@id='updateLeadForm_companyName']");
		cmpName.clear();
		String newCmpName="GOOGLE";
		cmpName.sendKeys(newCmpName);
		// Click Update
		driver.findElementByXPath("//input[@value='Update']").click();
		// verify changed company name
		WebElement currentCmpName = driver.findElementById("viewLead_companyName_sp");
		String getCmpName = currentCmpName.getText();
		String actualCmpName = getCmpName.replaceAll("[^A-Za-z]", "");
		System.out.println(actualCmpName+" "+newCmpName);
		if (actualCmpName.equals(newCmpName)) {
			System.out.println("New Company Name is appeard - PASS");
		} else {
			System.out.println("New Company Name is NOT appeard - FAIL");
		}
		driver.close();

	}

}
