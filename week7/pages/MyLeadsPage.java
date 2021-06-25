package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class MyLeadsPage extends ProjectSpecificMethods {
	// Constructor
	public MyLeadsPage(ChromeDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	// Action Methods
	public CreateLeadsPage clickCreateLeadslink() {
		try {
			WebElement createLeads = driver.findElement(By.xpath(prop.getProperty("MyLeadsPage.CreateLead.Xpath")));
			createLeads.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new CreateLeadsPage(driver, prop);
	}

	public FindLeadsPage clickFindLeadsLink() {
		try {
			WebElement findLeads = driver.findElement(By.xpath(prop.getProperty("MyLeadsPage.FindLead.Xpath")));
			findLeads.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new FindLeadsPage(driver, prop);
	}
	
	
}
