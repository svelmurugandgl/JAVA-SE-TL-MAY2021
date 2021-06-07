package week5.day1;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import week5.day2.ReadExcelData;

public class EditLead extends TestBaseClass {
	@Test(dependsOnMethods = "week5.day1.CreateLeadXpath.runCreateLead", dataProvider = "EditLead", description = "Test Case for Edit Lead")
	public void runEditLead(String company, String firstName) throws InterruptedException {
		// Click Leads
		driver.findElementByXPath("//a[text()='Leads']").click();
		// Click Find Leads
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		// enter First Name
		driver.findElementByXPath("(//div[@class='x-form-item x-tab-item']//input)[2]").sendKeys(firstName);
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
		cmpName.sendKeys(company);
		// Click Update
		driver.findElementByXPath("//input[@value='Update']").click();
		// verify changed company name
		WebElement currentCmpName = driver.findElementById("viewLead_companyName_sp");
		String getCmpName = currentCmpName.getText();
		String actualCmpName = getCmpName.replaceAll("[^A-Za-z]", "");
		System.out.println(actualCmpName + " " + company);
		if (actualCmpName.equals(company)) {
			System.out.println("New Company Name is appeard - PASS");
		} else {
			System.out.println("New Company Name is NOT appeard - FAIL");
		}

	}

	@DataProvider(name = "EditLead", indices = { 1 })
	String[][] inputData() throws IOException {
		ReadExcelData read = new ReadExcelData();
		String[][] data = read.getExcelData("contact", 8);
		return data;

	}

}
