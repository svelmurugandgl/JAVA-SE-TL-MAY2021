package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {
	// Constructor
	public LoginPage(ChromeDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	// Action Methods
	public LoginPage enterUsername() {
		try {
			WebElement loginUsername = driver.findElement(By.id("username"));
			loginUsername.sendKeys(prop.getProperty("username"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public LoginPage enterPassword() {
		try {
			WebElement loginPassword = driver.findElement(By.id("password"));
			loginPassword.sendKeys(prop.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public HomePage clickLoginButton() {
		try {
			WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));
			loginButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new HomePage(driver, prop);
	}

}
