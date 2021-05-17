package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		//wait 30sec to load elements
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Login page
		driver.findElementByXPath("//input[@id='username']").sendKeys("demosalesmanager");
		driver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa");
		driver.findElementByXPath("//input[@value='Login']").click();
		// CRM SFA page
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		// Click Lead
		driver.findElementByXPath("//a[text()='Leads']").click();
		// Click Find Leads
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		//Click Email
		driver.findElementByXPath("//span[text()='Email']").click();
		//Enter Email
		driver.findElementByXPath("//input[@name='emailAddress']").sendKeys("svel@gmail.com");
		//Find Leads
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		//Get 1st EMP First Name
		WebElement empName=driver.findElementByXPath("(//div[@unselectable='on']//a[text()='VELMURUGAN'])[1]");
		String firstName=empName.getText();
		empName.click();
		//Click Duplicate Lead
		driver.findElementByXPath("//a[text()='Duplicate Lead']").click();
		//Verify Page Title
		if(driver.getTitle().contains("Duplicate Lead"))
		{
			System.out.println("Verifed Page Title is Correct - PASS");
		}
		else
		{
			System.out.println("Verifed Page Title is NOT Correct - FAIL");
		}
		//Click Create Lead
		driver.findElementByXPath("//input[@value='Create Lead']").click();
		//First Name Validation with Duplicate Name
		WebElement curName=driver.findElementByXPath("//span[@id='viewLead_firstName_sp']");
		if(firstName.equals(curName.getText()))
		{
			System.out.println("Duplicate Name is Matched - PASS");
		}
		else
		{
			System.out.println("Duplicate Name is NOT Matched - FAIL");
		}
		
		driver.close();
		
	}

}
