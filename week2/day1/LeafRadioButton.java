package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafRadioButton {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Select Radio Button
		driver.findElement(By.id("yes")).click();
		//Default Selected Radio Button
		String xpath="";
		for(int i=1;i<=2;i++)
		{
		 xpath="(//label[text()='Find default selected radio button']/following-sibling::label/input)"+"["+i+"]";
		 if(driver.findElement(By.xpath(xpath)).isSelected())
		 {
			 System.out.println("Default value is \""+driver.findElement(By.xpath("(//label[text()='Find default selected radio button']/following-sibling::label)"+"["+i+"]")).getAttribute("for")+"\"");
		 }

	    }
		//Select if Choice NOT selected
		String xpath1="";
		int count=0;
		for(int j=1;j<=3;j++)
		{
		 xpath1="(//input[@name='age'])"+"["+j+"]";
		 if(driver.findElement(By.xpath(xpath1)).isSelected())
		 {
			 System.out.println("Already Choices are Selected");
		     count++;
		 }
		 
	    }
		if(count==0)
		{
			driver.findElement(By.xpath(xpath1)).click();
		}
		
		driver.close();
		
		
	}
}
