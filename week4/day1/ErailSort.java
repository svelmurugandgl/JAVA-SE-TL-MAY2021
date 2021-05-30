package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// From Station
		WebElement fromStation = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		fromStation.clear();
		fromStation.sendKeys("ms");
		fromStation.sendKeys(Keys.TAB);
		// To Station
		WebElement toStation = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		toStation.clear();
		toStation.sendKeys("mdu");
		toStation.sendKeys(Keys.TAB);

		// uncheck Sort on Date
		if (driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).isSelected()) {
			driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		}

		List<WebElement> trainNameElement = driver
				.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr//td[2]"));
		/*
		 * Using Set to remove duplicate and sort the Train Name 
		 * TreeSet <String> sortTrainNameList=new TreeSet<String>(); 
		 * for(WebElement tmp:trainNameElement)
		 * { sortTrainNameList.add(tmp.getText()); }
		 * System.out.println(sortTrainNameList);
		 */
		// Empty String List
		List<String> trainNameList = new ArrayList<String>();
		// Store WebElement text to List
		for (WebElement getName : trainNameElement) {
			trainNameList.add(getName.getText());
		}
		
		// Sort the List Using Collections
		Collections.sort(trainNameList);
		
		/* Set <String> set=new LinkedHashSet<String>(trainNameList); to remove
		duplicate train name from list*/
		
		System.out.println("Sorted Train Name List ");
		// Print the Sorted Train Name with duplicates
		
		for (String trainName : trainNameList) {
			System.out.println(trainName);
		}
	}

}
