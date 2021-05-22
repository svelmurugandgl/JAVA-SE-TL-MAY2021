package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//DropDown1 Box Select By Index
		WebElement selectIndex = driver.findElementById("dropdown1");
		Select dropDown1 = new Select(selectIndex);
		//select Last Value in the drop down box by Index
		dropDown1.selectByIndex(dropDown1.getOptions().size() - 1);
		//DropDown2 Box Select By Visible Text
		WebElement selectText = driver.findElementByName("dropdown2");
		Select dropDown2 = new Select(selectText);
		dropDown2.selectByVisibleText("Selenium");
		//DropDown2 Box Select By Visible Text - Appium
		WebElement selectValue = driver.findElementById("dropdown3");
		Select dropDown3 = new Select(selectValue);
		dropDown3.selectByValue("2");
		//Count Drop Down Options
		WebElement countOption = driver.findElementByClassName("dropdown");
		Select count = new Select(countOption);
		int cnt=count.getOptions().size()-1;
		System.out.println("counted option is "+" "+cnt);
		//Select using Sendkey
		WebElement keySelect=driver.findElementByXPath("//option[text()='You can also use sendKeys to select']/parent::select");
	    keySelect.sendKeys("UFT");
	    keySelect.click();
	    //Select Multiple List Box - Last Value
	    WebElement list = driver.findElementByXPath("(//option[@value='1']/parent::select)[6]");
	    Select listValue = new Select(list);
		listValue.selectByIndex(listValue.getOptions().size()-1);
		Thread.sleep(10000);
		driver.close();

	}

}
