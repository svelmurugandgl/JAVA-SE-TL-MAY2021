package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificMethods;

public class ViewContactPage extends ProjectSpecificMethods {
	// Variables
	private SoftAssert softassert = new SoftAssert();

	// Constructor
	public ViewContactPage(ChromeDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	// Action Methods
	public ViewContactPage verifyViewContactTitle() {
		try {
			System.out.println("Actual Contact Title is " + driver.getTitle());
			softassert.assertTrue(driver.getTitle().contains(prop.getProperty("ViewContactPage.Title")),
					"View Contact Title");
			softassert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public ViewContactPage verifyContactLastName(String expectedLastName) {
		try {
			WebElement viewContactLastName = driver.findElement(By.id("viewContact_lastName_sp"));
			String actalLastName = viewContactLastName.getText();
			System.out.println("Actual Last Name is " + actalLastName);
			softassert.assertEquals(actalLastName, expectedLastName, "Verify Created Contact Last Name");
			softassert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public ViewContactPage verifyContactDescriptionCleared() {
		try {
			WebElement viewContactDescription = driver.findElement(By.id("viewContact_description_sp"));
			String actualDescription=viewContactDescription.getText().replaceAll("\u00a0", "").trim();
			System.out.println("Actual Description is " + actualDescription);
			softassert.assertTrue(actualDescription.isEmpty(), "Verify Updated Contact Description is Cleared");
			softassert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public ViewContactPage verifyContactUpdatedNote(String expectedNote) {
		try {
			WebElement viewContactNote = driver.findElement(By.id("viewContact_importantNote_sp"));
			String actualNote = viewContactNote.getText();
			System.out.println("Actual Note is " + actualNote);
			softassert.assertEquals(actualNote, expectedNote, "Verify Updated Contact Note");
			softassert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public EditContactPage clickEditContactButton() {
		try {
			WebElement editContactButton = driver
					.findElement(By.xpath(prop.getProperty("ViewContactPage.EditContact.Xpath")));
			editContactButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new EditContactPage(driver, prop);
	}
}
