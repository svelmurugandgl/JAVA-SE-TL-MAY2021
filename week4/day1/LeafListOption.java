package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafListOption {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Select Multi-List box options
		WebElement selenium = driver.findElement(By.xpath("(//option[@value='1']/parent::select)[6]/option[2]"));
		WebElement loadrunner = driver.findElement(By.xpath("(//option[@value='1']/parent::select)[6]/option[5]"));
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).moveToElement(selenium).click().moveToElement(loadrunner).click()
				.keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(30000);

		driver.close();

	}

}
