package week5.day1;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import week5.day2.ReadExcelData;

public class CreateLeadXpath extends TestBaseClass {
	@Test(invocationCount = 3, dataProvider = "CreateLead", description = "Test Case to create Lead")
	public void runCreateLead(String company, String firstName, String lastName) throws InterruptedException {

		// Click Leads
		driver.findElementByXPath("//a[text()='Leads']").click();

		// Click Create Leads Link by Xpath
		driver.findElementByXPath("//a[text()='Create Lead']").click();

		// Enter CompanyName by Xpath
		driver.findElementByXPath("//input[@id='createLeadForm_companyName']").sendKeys(company);

		// Enter FirstName by Xpath
		driver.findElementByXPath("//input[@id='createLeadForm_firstName']").sendKeys(firstName);

		// Enter LastName by Xpath
		driver.findElementByXPath("//input[@id='createLeadForm_lastName']").sendKeys(lastName);

		// Click Create Lead by Xpath
		driver.findElementByXPath("//input[@class='smallSubmit']").click();

	}

	@DataProvider(name = "CreateLead", indices = 2)
	String[][] inputData() throws IOException {
		ReadExcelData read = new ReadExcelData();
		String[][] data = read.getExcelData("contact", 7);
		return data;

	}

}
