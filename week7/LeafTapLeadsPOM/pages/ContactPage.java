package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class ContactPage extends ProjectSpecificMethods {

	// Constructor
	public ContactPage(ChromeDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	// Action Methods
	public CreateContactPage clickCreateContact() {
		try {
			WebElement createContact = driver.findElement(By.linkText(prop.getProperty("ContactPage.CreateContact")));
			createContact.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new CreateContactPage(driver,prop);
	}
}
