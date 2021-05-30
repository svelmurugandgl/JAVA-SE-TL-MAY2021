package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		// Pass Argument to Chrome Driver to disable Notification
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		Thread.sleep(30000);
		Actions builder = new Actions(driver);

		// Mouse Over on men fashion and then Click Shirts
		WebElement menFashion = driver.findElement(By.xpath("(//li[@class='navlink lnHeight']//span)[1]"));
		WebElement menShirts = driver.findElement(By.xpath("(//span[text()='Shirts'])[2]"));
		builder.moveToElement(menFashion).click(menShirts).perform();

		// Mouse Over on 1st item and then Click Quick View
		WebElement firstItem = driver.findElement(By.xpath("(//div[@class='lfloat marR10']//span)[1]"));
		WebElement quickView = driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]"));
		builder.moveToElement(firstItem).click(quickView).perform();

		Thread.sleep(30000);

		driver.close();
	}

}
