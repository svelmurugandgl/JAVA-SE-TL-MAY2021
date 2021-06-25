package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class CreateLeadsPage extends ProjectSpecificMethods {
	// Class Variable
	static String validatefirstName;

	// Constructor
	public CreateLeadsPage(ChromeDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	// Action Methods
	public CreateLeadsPage enterCreateLeadFirstName(String firstname) {
		try {
			validatefirstName = firstname;
			WebElement createLeadFirstName = driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']"));
			createLeadFirstName.sendKeys(firstname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public CreateLeadsPage enterCreateLeadLastName(String lastname) {
		try {
			WebElement createLeadLastName = driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']"));
			createLeadLastName.sendKeys(lastname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public CreateLeadsPage enterCreateLeadCompanyname(String company) {
		try {
			WebElement createLeadCompany = driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']"));
			createLeadCompany.sendKeys(company);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	public CreateLeadsPage enterCreateLeadEmail(String email) {
		try {
			WebElement primaryEmail = driver.findElement(By.id("createLeadForm_primaryEmail"));
			primaryEmail.sendKeys(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public ViewLeadsPage clickCreateLeadButton()

	{
		try {
			WebElement createLeadButton = driver.findElement(By.xpath("//input[@class='smallSubmit']"));
			createLeadButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ViewLeadsPage(driver, prop);
	}

}
