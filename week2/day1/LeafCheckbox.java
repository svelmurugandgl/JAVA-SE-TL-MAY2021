package week2.day1;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafCheckbox {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Select Java
		driver.findElementByXPath(
				"(//label[text()='Select the languages that you know?']/following-sibling::div/input)[1]").click();
		// is Selected
		if (driver.findElementByXPath("(//label[text()='Confirm Selenium is checked']/following-sibling::div/input)[1]")
				.isSelected()) {
			System.out.println("Selenium is Selected");
		} else {
			System.out.println("Selenium is NOT Selected");
		}

		// Deselect Checkbox
		for (int i = 1; i <= 2; i++) {
			if (driver
					.findElementByXPath(
							"(//label[text()='DeSelect only checked']/following-sibling::div/input)" + "[" + i + "]")
					.isSelected()) {
				driver.findElementByXPath(
						"(//label[text()='DeSelect only checked']/following-sibling::div/input)" + "[" + i + "]")
						.click();
			}
		}

		// Select all Check Box
		for (int j = 1; j <= 5; j++) {
			driver.findElementByXPath(
					"(//label[contains(text(),'Select all below checkboxes')]/following-sibling::div/input)" + "[" + j
							+ "]")
					.click();
		}
		Thread.sleep(10000);
		driver.close();
	}

}