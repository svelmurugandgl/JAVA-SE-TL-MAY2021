package week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDuplicateTeamXpath {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		// Login
		driver.findElementByXPath("//input[@id='username']").sendKeys("demosalesmanager");
		driver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa");
		driver.findElementByXPath("//input[@value='Login']").click();

		// Title Check
		String title = driver.getTitle();
		if (title.equals("Leaftaps - TestLeaf Automation Platform")) {
			System.out.println("Title is matching - PASS");
		}

		// Click CRM to Create Lead
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		driver.findElementByXPath("//a[text()='Leads']").click();
		driver.findElementByXPath("//a[text()='Create Lead']").click();

		// Create Lead Form Input by sendKeys()
		// Mandatory Field
		String orgName = "HCLT";
		driver.findElementByXPath("//input[@id='createLeadForm_companyName']").sendKeys(orgName);
		driver.findElementByXPath("//input[@id='createLeadForm_firstName']").sendKeys("VELMURUGAN");
		driver.findElementByXPath("//input[@id='createLeadForm_lastName']").sendKeys("SUBRAMANIAN");

		// Optional Field Input by sendKeys()
		driver.findElementByXPath("//input[@id='createLeadForm_firstNameLocal']").sendKeys("VEL");
		driver.findElementByXPath("//input[@id='createLeadForm_lastNameLocal']").sendKeys("SUBRAMA");
		driver.findElementByXPath("//input[@id='createLeadForm_personalTitle']").sendKeys("AI");
		driver.findElementByXPath("//input[@id='createLeadForm_birthDate']").sendKeys("05/15/2021");
		driver.findElementByXPath("//input[@id='createLeadForm_generalProfTitle']").sendKeys("DL");
		driver.findElementByXPath("//input[@id='createLeadForm_departmentName']").sendKeys("AI LAB");
		driver.findElementByXPath("//input[@id='createLeadForm_annualRevenue']").sendKeys("100000");
		driver.findElementByXPath("//input[@id='createLeadForm_numberEmployees']").sendKeys("10");
		driver.findElementByXPath("//input[@id='createLeadForm_sicCode']").sendKeys("121");
		driver.findElementByXPath("//input[@id='createLeadForm_tickerSymbol']").sendKeys("LIST");
		driver.findElementByXPath("//textarea[@id='createLeadForm_description']").sendKeys("HELLO");
		driver.findElementByXPath("//textarea[@id='createLeadForm_importantNote']").sendKeys("WELCOME");

		WebElement phoneCode = driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneCountryCode']");
		phoneCode.clear();
		phoneCode.sendKeys("91");

		driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneAreaCode']").sendKeys("044");
		driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneNumber']").sendKeys("4567778901");
		driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneExtension']").sendKeys("010");
		driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneAskForName']").sendKeys("VEL");
		driver.findElementByXPath("//input[@id='createLeadForm_primaryEmail']").sendKeys("svel@gmail.com");
		driver.findElementByXPath("//input[@id='createLeadForm_primaryWebUrl']").sendKeys("www.google.com");
		driver.findElementByXPath("//input[@id='createLeadForm_generalToName']").sendKeys("VEL");
		driver.findElementByXPath("//input[@id='createLeadForm_generalAttnName']").sendKeys("Harish");
		driver.findElementByXPath("//input[@id='createLeadForm_generalAddress1']").sendKeys("Medavakkam");
		driver.findElementByXPath("//input[@id='createLeadForm_generalAddress2']").sendKeys("Medavakkam");
		driver.findElementByXPath("//input[@id='createLeadForm_generalCity']").sendKeys("Chennai");
		driver.findElementByXPath("//input[@id='createLeadForm_generalPostalCode']").sendKeys("600112");
		driver.findElementByXPath("//input[@id='createLeadForm_generalPostalCodeExt']").sendKeys("112");

		// Create Lead Form Drop Down Selection
		WebElement sourceDropBox = driver.findElementByXPath("//select[@id='createLeadForm_dataSourceId']");
		Select sourceDropDown = new Select(sourceDropBox);
		sourceDropDown.selectByVisibleText("Conference");

		WebElement marketingDropBox = driver.findElementByXPath("//select[@id='createLeadForm_marketingCampaignId']");
		Select marketingDropDown = new Select(marketingDropBox);
		marketingDropDown.selectByIndex(2);

		WebElement currencyDropBox = driver.findElementByXPath("//select[@id='createLeadForm_currencyUomId']");
		Select currencyDropDown = new Select(currencyDropBox);
		currencyDropDown.selectByValue("INR");

		WebElement industryDropBox = driver.findElementByXPath("//select[@id='createLeadForm_industryEnumId']");
		Select industryDropDown = new Select(industryDropBox);
		industryDropDown.selectByValue("IND_AEROSPACE");

		WebElement ownerDropBox = driver.findElementByXPath("//select[@id='createLeadForm_ownershipEnumId']");
		Select ownerDropDown = new Select(ownerDropBox);
		ownerDropDown.selectByVisibleText("Corporation");

		WebElement geoDropBox = driver.findElementByXPath("//select[@id='createLeadForm_generalCountryGeoId']");
		Select geoDropDown = new Select(geoDropBox);
		geoDropDown.selectByValue("IND");

		// wait 10sec
		Thread.sleep(10000);

		WebElement stateDropBox = driver.findElementByXPath("//select[@id='createLeadForm_generalStateProvinceGeoId']");
		Select stateDropDown = new Select(stateDropBox);
		stateDropDown.selectByValue("IN-TN");

		// Create Lead Submitted
		driver.findElementByXPath("//input[@class='smallSubmit']").click();
        
		// Duplicate Lead form
		driver.findElementByXPath("//a[text()='Duplicate Lead']").click();

		WebElement compName = driver.findElementByXPath("//input[@id='createLeadForm_companyName']");
		compName.clear();
		compName.sendKeys("CTS");

		// Create Lead Submitted
		driver.findElementByXPath("//input[@class='smallSubmit']").click();

		// Verify Duplicate Company Name
		WebElement dupCmpName = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']");
		String newCmpName = dupCmpName.getText();
		System.out.println(newCmpName);
		String cmpName = newCmpName.replaceAll("[^A-Za-z]", "");
		System.out.println(cmpName);
		if (!cmpName.equalsIgnoreCase("HCLT")) {
			System.out.println(cmpName + " Company Name is Different from " + orgName + "- PASS");
		}

		driver.close();

	}

}
