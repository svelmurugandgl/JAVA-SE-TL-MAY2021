package pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificMethods;

public class DuplicateLeadsPage extends ProjectSpecificMethods {
	// Variable
	private SoftAssert softassert = new SoftAssert();

	// Constructor
	public DuplicateLeadsPage(ChromeDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	// Action Methods
	public DuplicateLeadsPage verifyDuplicateLeadPageTitle() {
		try {
			System.out.println("Duplicate Lead Title is " + driver.getTitle());
			softassert.assertTrue(driver.getTitle().contains(prop.getProperty("DuplicateLeadsPage.TitleText")));
			softassert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public ViewLeadsPage clickDuplicateCreateLeadButton() {
		try {
			WebElement duplicateCreateLeadButton = driver
					.findElementByXPath(prop.getProperty("DuplicateLeadsPage.CreateLeadButton.Xpath"));
			duplicateCreateLeadButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ViewLeadsPage(driver, prop);
	}

}
