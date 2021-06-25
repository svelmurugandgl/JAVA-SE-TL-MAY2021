package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificMethods;

public class ViewLeadsPage extends ProjectSpecificMethods {
	// Variables
	private SoftAssert softassert = new SoftAssert();

	// Constructor
	public ViewLeadsPage(ChromeDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	// Action Methods
	public ViewLeadsPage verifyFirstname() {
		try {
			WebElement viewLeadFirstName = driver.findElement(By.id("viewLead_firstName_sp"));
			String actualname = viewLeadFirstName.getText();
			System.out.println("Actual First Name is " + actualname);
			softassert.assertEquals(actualname, CreateLeadsPage.validatefirstName, "First Name is Verified");
			softassert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public MyLeadsPage clickDeleteLeadButton() {
		try {
			WebElement deleteButton = driver.findElementByXPath("//a[@class='subMenuButtonDangerous']");
			deleteButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new MyLeadsPage(driver, prop);
	}

	public DuplicateLeadsPage clickDuplicateLeadButton() {
		try {
			WebElement duplicateLeadButton = driver
					.findElementByXPath(prop.getProperty("ViewLeadsPage.DuplicateButton.Xpath"));
			duplicateLeadButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new DuplicateLeadsPage(driver, prop);

	}
	
	public ViewLeadsPage verifyDuplicateLeadFirstName()
	{
		try {
		WebElement actualName = driver.findElementByXPath("//span[@id='viewLead_firstName_sp']");
		System.out.println("Actual Duplicate Lead First Name is "+actualName.getText());
		softassert.assertEquals(actualName.getText(), FindLeadsPage.firstEmpName);
		softassert.assertAll();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return this; 
		
	}
	

}
