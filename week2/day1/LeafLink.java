package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafLink {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Go to Home Page
		driver.findElementByLinkText("Go to Home Page").click();
		driver.navigate().back();
		// Without Click go to button.html
		System.out.println("Need to go to URL \r\n"
				+ driver.findElementByPartialLinkText("Find where am supposed").getAttribute("href"));
		// Broken Link Check
		driver.findElementByLinkText("Verify am I broken?").click();
		System.out.println(driver.getTitle());
		if (driver.getTitle().contains("404")) {
			System.out.println("HTML Link is Broken");
		} else {
			System.out.println("HTML Link is NOT Broken");
		}
		driver.navigate().back();
		// Go to Home and Click same Link
		driver.findElementByLinkText("Go to Home Page").click();
		driver.findElementByXPath("//img[@src='images/link.png']").click();
		;
		driver.close();

	}

}
