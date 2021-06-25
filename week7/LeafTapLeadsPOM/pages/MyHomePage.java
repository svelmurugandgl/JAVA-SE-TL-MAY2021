package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificMethods;

public class MyHomePage extends ProjectSpecificMethods {
	// Variables
	private SoftAssert softassert = new SoftAssert();

	// Constructor
	public MyHomePage(ChromeDriver driver, Properties prop) {

		this.driver = driver;
		this.prop = prop;
	}

	// Action Methods
	public MyHomePage verifyMyHomepage() {
		try {
			String actualTitle = driver.getTitle();
			System.out.println("My Home Page is "+actualTitle);
			String expectedTitle = prop.getProperty("MyHomePage.Title");
			softassert.assertEquals(actualTitle, expectedTitle, "Verify My Home Page");
			softassert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public MyLeadsPage clickLeads() {
		try {
			WebElement leads = driver.findElement(By.xpath(prop.getProperty("MyHomePage.Leads.Xpath")));
			leads.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new MyLeadsPage(driver, prop);
	}

	public ContactPage clickContacts() {
		try {
			WebElement contact = driver.findElement(By.linkText("Contacts"));
			contact.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ContactPage(driver, prop);
	}

}
