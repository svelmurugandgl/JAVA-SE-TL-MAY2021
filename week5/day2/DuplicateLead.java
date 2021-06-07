package week5.day1;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import week5.day2.ReadExcelData;

public class DuplicateLead extends TestBaseClass {
	@Test(dataProvider = "DuplicateLead", description = "TC is for Duplicate Lead")
	public void runDuplicateLead(String company, String firstName, String lastName, String email) {
		// Click Leads
		driver.findElementByXPath("//a[text()='Leads']").click();
		// Click Find Leads
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		// Click Email
		driver.findElementByXPath("//span[text()='Email']").click();
		// Enter Email
		driver.findElementByXPath("//input[@name='emailAddress']").sendKeys(email);
		// Find Leads
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		// Get 1st EMP First Name
		WebElement empName = driver.findElementByXPath("(//div[@unselectable='on']//a[text()='VELMURUGAN'])[1]");
		String name = empName.getText();
		empName.click();
		// Click Duplicate Lead
		driver.findElementByXPath("//a[text()='Duplicate Lead']").click();
		// Verify Page Title
		if (driver.getTitle().contains("Duplicate Lead")) {
			System.out.println("Verifed Page Title is Correct - PASS");
		} else {
			System.out.println("Verifed Page Title is NOT Correct - FAIL");
		}
		// Click Create Lead
		driver.findElementByXPath("//input[@value='Create Lead']").click();
		// First Name Validation with Duplicate Name
		WebElement curName = driver.findElementByXPath("//span[@id='viewLead_firstName_sp']");
		if (name.equals(curName.getText())) {
			System.out.println("Duplicate Name is Matched - PASS");
		} else {
			System.out.println("Duplicate Name is NOT Matched - FAIL");
		}

	}

	@DataProvider(name = "DuplicateLead", indices = 0)
	String[][] inputData() throws IOException {
		ReadExcelData read = new ReadExcelData();
		String[][] data = read.getExcelData("contact", 6);
		return data;

	}

}
