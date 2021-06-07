package week5.day1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {

	public ChromeDriver driver;

	@BeforeMethod
	@Parameters({ "url", "username", "password" })
	public void preCondition(String url, String username, String password) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Enter User Name
		driver.findElementById("username").sendKeys(username);
		// Enter Password
		driver.findElementById("password").sendKeys(password);
		// Click Login
		driver.findElementByClassName("decorativeSubmit").click();
		// Click CRM Link
		driver.findElementByPartialLinkText("SFA").click();
	}

	@AfterMethod
	public void postCondition() throws InterruptedException {
		Thread.sleep(1000);
		// Close Driver
		driver.close();
	}
}
