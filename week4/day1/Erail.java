package week4.day1;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//From Station
		WebElement fromStation=driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
	    fromStation.clear();
	    fromStation.sendKeys("ms");
	    fromStation.sendKeys(Keys.TAB);
	    //To Station
	    WebElement toStation=driver.findElement(By.xpath("//input[@id='txtStationTo']"));
	    toStation.clear();
	    toStation.sendKeys("mdu");
	    toStation.sendKeys(Keys.TAB);
	    
	    //uncheck Sort on Date
	    if(driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).isSelected())
		{
			driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		}
	    
	    List<WebElement> trainlist=driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr//td[2]"));
	    int dataDuplicate=trainlist.size();
	    LinkedHashSet<String> set=new LinkedHashSet<String>();
	    System.out.println("Duplicate Train Names are");
	    for(WebElement temp:trainlist)
	    {
	    	if(!set.add(temp.getText()))
	    			{
	    		      System.out.println(temp.getText());
	    			}
	    		
	    }
	    
	    int noDuplicate=set.size();
	    System.out.println("Original List "+dataDuplicate);
	    System.out.println("Final List "+noDuplicate);
	    if(dataDuplicate==noDuplicate)
	    {
	    	System.out.println("No Duplcate Train Name Present");
	    }
	    else
	    {
	    	System.out.println("Duplciate Train Name Present");
	    	
	    }
	    
	    
		
		
        
	}

}
