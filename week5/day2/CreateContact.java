package week5.day1;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import week5.day2.ReadExcelData;

public class CreateContact extends TestBaseClass {
	@Test(dataProvider = "CreateContact", description = "Test Case for Create Contact")
	public void runCreateContact(String company, String firstName, String lastName, String email, String firstLocal,
			String lastLocal, String dept, String description, String state, String note) {
		// Click and Create Contact Input
		driver.findElementByLinkText("Contacts").click();
		driver.findElementByLinkText("Create Contact").click();
		driver.findElementById("firstNameField").sendKeys(firstName);
		driver.findElementById("lastNameField").sendKeys(lastName);
		driver.findElementById("createContactForm_firstNameLocal").sendKeys(firstLocal);
		driver.findElementById("createContactForm_lastNameLocal").sendKeys(lastLocal);
		driver.findElementById("createContactForm_departmentName").sendKeys(dept);
		driver.findElementById("createContactForm_description").sendKeys(description);
		driver.findElementById("createContactForm_primaryEmail").sendKeys(email);

		// Create Contact State Drop Down box Selection
		WebElement stateDropBox = driver.findElementById("createContactForm_generalStateProvinceGeoId");
		Select stateSelect = new Select(stateDropBox);
		stateSelect.selectByVisibleText(state);

		// Click Create Contact
		driver.findElementByXPath("//input[@value='Create Contact']").click();

		// Click Edit Contact
		driver.findElementByXPath("//a[text()='Edit']").click();

		// id use and clear text
		driver.findElementById("updateContactForm_description").clear();

		// id use and fill text
		driver.findElementById("updateContactForm_importantNote").sendKeys(note);

		// Click Update
		driver.findElementByXPath("//input[@value='Update']").click();

		// Get title contains View Contact say title is correct
		System.out.println("Page Title is " + driver.getTitle());

		// Verify Page Title
		if (driver.getTitle().contains("View Contact")) {
			System.out.println("Verifed Page Title is Correct - PASS");
		} else {
			System.out.println("Verifed Page Title is NOT Correct - FAIL");
		}

	}

	@DataProvider(name = "CreateContact", indices = { 0, 3 })
	String[][] inputData() throws IOException {
		ReadExcelData read = new ReadExcelData();
		String[][] data = read.getExcelData("contact", 0);
		return data;

	}

}
