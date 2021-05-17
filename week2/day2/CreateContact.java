package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Login
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		// Click CRM Link
		driver.findElementByPartialLinkText("SFA").click();
		
		//Click and Create Contact Input
		driver.findElementByLinkText("Contacts").click();
		driver.findElementByLinkText("Create Contact").click();
		driver.findElementById("firstNameField").sendKeys("Harish");
		driver.findElementById("lastNameField").sendKeys("Vel");
		driver.findElementById("createContactForm_firstNameLocal").sendKeys("Hari");
		driver.findElementById("createContactForm_lastNameLocal").sendKeys("Velu");
		driver.findElementById("createContactForm_departmentName").sendKeys("AI");
		driver.findElementById("createContactForm_description").sendKeys("HELLO");
		driver.findElementById("createContactForm_primaryEmail").sendKeys("svel@gmail.com");
		
		//Create Contact State Drop Down box Selection
		WebElement stateDropBox =driver.findElementById("createContactForm_generalStateProvinceGeoId");
		Select stateSelect =new Select(stateDropBox);
		stateSelect.selectByVisibleText("New York");
		
		//Click Create Contact
		driver.findElementByXPath("//input[@value='Create Contact']").click();
		
		//Click Edit Contact
		driver.findElementByXPath("//a[text()='Edit']").click();
		
		//id use and clear text
		driver.findElementById("updateContactForm_description").clear();
		
		//id use and fill text
		driver.findElementById("updateContactForm_importantNote").sendKeys("Note");
		
		//Click Update
		driver.findElementByXPath("//input[@value='Update']").click();
		
		//Get title contains View Contact say title is correct
		System.out.println("Page Title is "+driver.getTitle());
		
		//Verify Page Title
		if(driver.getTitle().contains("View Contact"))
		{
			System.out.println("Verifed Page Title is Correct - PASS");
		}
		else
		{
			System.out.println("Verifed Page Title is NOT Correct - FAIL");
		}
		
		driver.close();

	}

}
