package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafCalendar {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Calendar.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Click Calendar
		driver.findElement(By.id("datepicker")).click();
		//Go to Next Month
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		//Get all active days into web element list
	    List <WebElement> days=driver.findElements(By.xpath("//tbody//tr/td/a"));
	    //Select 10th day of current month
	    //Using For..Each WebElement Method
	    for(WebElement tmp:days)
	    {
	    	if(tmp.getText().equals("10"))
	    	{
	    		tmp.click();
	    		break;
	    	}
	    }
	    //Using For Loop Method with i
	    /*
	    for(int i=0;i<days.size();i++)
	    {
	    	
	    	if(days.get(i).getText().equals("10"))
	    	{
	    		days.get(i).click();
	    		break;
	     	}
	    }*/
		  
        Thread.sleep(30000);
        driver.close();
	}

}
