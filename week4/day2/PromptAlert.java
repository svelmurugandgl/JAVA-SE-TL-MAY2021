package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PromptAlert {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		//Switch to frame
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		//Switch to Alert
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("VEL");
		alert.accept();
		//Get below Try It text name
		String name=driver.findElement(By.id("demo")).getText();
		System.out.println("Below Try It available text is "+name);
		if(name.contains("VEL"))
		{
		    System.out.println("VEL is available");
		}
		else
		{
			System.out.println("VEL is NOT available");
		}
		driver.switchTo().defaultContent();
		driver.close();
	}

}
