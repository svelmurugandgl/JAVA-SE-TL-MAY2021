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

		WebElement loginUsername = driver.findElement(By.id("username"));
		loginUsername.sendKeys(prop.getProperty("username"));

		return this;
	}

	public LoginPage enterPassword() {

		WebElement loginPassword = driver.findElement(By.id("password"));
		loginPassword.sendKeys(prop.getProperty("password"));

		return this;
	}

	public HomePage clickLoginButton() {

		WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));
		loginButton.click();

		return new HomePage(driver, prop);
	}

}
