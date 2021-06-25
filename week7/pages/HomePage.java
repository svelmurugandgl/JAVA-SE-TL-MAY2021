package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {

	// Constructor
	public HomePage(ChromeDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	// Action Methods
	public MyHomePage clickCrmsfa() {
		try {
			WebElement crmsfaLink = driver.findElement(By.partialLinkText("SFA"));
			crmsfaLink.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new MyHomePage(driver, prop);
	}

}
