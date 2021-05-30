package week4.day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafTable {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> tableRow=driver.findElements(By.xpath("//table//tr"));
		int row=tableRow.size();
		System.out.print("Number of Row in Table is "+row+"\r\n");
		
		List<WebElement> tableColumn=driver.findElements(By.xpath("//table//tr[2]/td"));
		int column=tableColumn.size();
		System.out.print("Number of Column in Table is "+column+"\r\n");
		
	    //Get Progress for Learn to Interact with Elements
		for(int i=2;i<=row;i++)
		{
				String Str=driver.findElement(By.xpath("//table//tr["+i+"]/td[1]")).getText();
				if(Str.contains("with Elements"))
				{
					System.out.print("Learn to Interact with Elements progress is ");
					System.out.print(driver.findElement(By.xpath("//table//tr["+i+"]/td[2]")).getText()+"\r\n");
					break;
		     	}			
		}
		//Enable Vital Task Check Box for least Progress item
		for(int i=2;i<=row;i++)
		{
				String getProg=driver.findElement(By.xpath("//table//tr["+i+"]/td[2]")).getText();
				String tempStr=getProg.replaceAll("[^0-9]","");
				Integer realProg=Integer.valueOf(tempStr);
				if(realProg<80)
				{
					driver.findElement(By.xpath("//table//tr["+i+"]/td[3]/input")).click();
			 	}			
		}
		
       Thread.sleep(30000);
       driver.close();
	}

}

