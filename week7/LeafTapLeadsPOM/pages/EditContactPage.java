package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class EditContactPage extends ProjectSpecificMethods {
	// Constructor
	public EditContactPage(ChromeDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	// Action methods
	public EditContactPage clearDescription() {
		try {
			WebElement updateContactDescription = driver.findElement(By.id("updateContactForm_description"));
			updateContactDescription.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public EditContactPage enterNote(String note) {
		try {
			WebElement updateContactNote = driver.findElement(By.id("updateContactForm_importantNote"));
			updateContactNote.sendKeys(note);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public ViewContactPage clickContactUpdateButton() {
		try {
			WebElement viewLeadUpdateButton = driver
					.findElement(By.xpath(prop.getProperty("EditContactPage.UpdateButton.Xpath")));
			viewLeadUpdateButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ViewContactPage(driver, prop);
	}

}
