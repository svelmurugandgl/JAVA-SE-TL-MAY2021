package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificMethods;

public class CreateContactPage extends ProjectSpecificMethods {

	// Constructor
	public CreateContactPage(ChromeDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	// Action Methods
	public CreateContactPage enterCreatContactFirstNameField(String firstName) {
		try {
			WebElement firstNameField = driver.findElement(By.id("firstNameField"));
			firstNameField.sendKeys(firstName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public CreateContactPage enterCreatContactLastNameField(String lastName) {
		try {
			WebElement lastNameField = driver.findElement(By.id("lastNameField"));
			lastNameField.sendKeys(lastName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public CreateContactPage enterCreatContactFirstNameLocal(String firstLocal) {
		try {
			WebElement firstNameLocal = driver.findElement(By.id("createContactForm_firstNameLocal"));
			firstNameLocal.sendKeys(firstLocal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public CreateContactPage enterCreatContactLastNameLocal(String lastLocal) {
		try {
			WebElement lastNameLocal = driver.findElement(By.id("createContactForm_lastNameLocal"));
			lastNameLocal.sendKeys(lastLocal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public CreateContactPage enterCreatContactDepartmentName(String dept) {
		try {
			WebElement departmentName = driver.findElement(By.id("createContactForm_departmentName"));
			departmentName.sendKeys(dept);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public CreateContactPage enterCreatContactDescriptionName(String description) {
		try {
			WebElement formDescription = driver.findElement(By.id("createContactForm_description"));
			formDescription.sendKeys(description);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public CreateContactPage enterCreatContactEmail(String email) {
		try {
			WebElement primaryEmail = driver.findElement(By.id("createContactForm_primaryEmail"));
			primaryEmail.sendKeys(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public CreateContactPage selectCreatContactState(String state) {
		try {
			WebElement generalState = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
			select = new Select(generalState);
			select.selectByVisibleText(state);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public ViewContactPage clickCreateContactButton() throws InterruptedException {
		try {
			WebElement createLeadButton = driver
					.findElement(By.xpath("//input[@value='" + prop.getProperty("ContactPage.CreateContact") + "']"));
			createLeadButton.click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ViewContactPage(driver, prop);
	}

}
