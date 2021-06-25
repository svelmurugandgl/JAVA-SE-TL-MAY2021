package pages;

import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class MergeLeadsPage extends ProjectSpecificMethods {
	// Constructor
	public MergeLeadsPage(ChromeDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	// Action Methods

	public FindLeadsNewPage clickFromLeadIcon() {
		try {
			WebElement fromLeadIcon = driver.findElement(By.xpath("//img[@alt='Lookup'][1]"));
			fromLeadIcon.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new FindLeadsNewPage(driver, prop);
	}

	public FindLeadsNewPage clickToLeadIcon() {
		try {

			WebElement toLeadIcon = driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]"));
			toLeadIcon.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new FindLeadsNewPage(driver, prop);
	}
	public MergeLeadsPage switchToMainWindow() {
		try {
			// Switch to Main Window
			driver.switchTo().window(FindLeadsNewPage.mainWindow);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	public MergeLeadsPage clickMergeLeadsButton() {
		try {
			WebElement mergeLeadButton = driver.findElement(By.className("buttonDangerous"));
			mergeLeadButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public MyLeadsPage acceptMergeAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new MyLeadsPage(driver, prop);
	}

}
