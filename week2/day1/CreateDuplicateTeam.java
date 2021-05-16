package week2.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDuplicateTeam {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		//Login
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		//Title Check
		String title = driver.getTitle();
		if(title.equals("Leaftaps - TestLeaf Automation Platform"))
		{
			System.out.println("Title is matching - PASS");
		}
		
		//Click CRM to Create Lead
		driver.findElementByPartialLinkText("SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		
		//Create Lead Form Input by sendKeys()
		//Mandatory Field
		String orgName="HCLT";
		driver.findElementById("createLeadForm_companyName").sendKeys(orgName);
		driver.findElementById("createLeadForm_firstName").sendKeys("VELMURUGAN");
		driver.findElementById("createLeadForm_lastName").sendKeys("SUBRAMANIAN");
		
		//Optional Field Input by sendKeys()
		driver.findElementById("createLeadForm_firstNameLocal").sendKeys("VEL");
		driver.findElementById("createLeadForm_lastNameLocal").sendKeys("SUBRAMA");
		driver.findElementById("createLeadForm_personalTitle").sendKeys("AI");
		driver.findElementById("createLeadForm_birthDate").sendKeys("05/15/2021");
		driver.findElementById("createLeadForm_generalProfTitle").sendKeys("DL");
		driver.findElementById("createLeadForm_departmentName").sendKeys("AI LAB");
		driver.findElementById("createLeadForm_annualRevenue").sendKeys("100000");
		driver.findElementById("createLeadForm_numberEmployees").sendKeys("10");
		driver.findElementById("createLeadForm_sicCode").sendKeys("121");
		driver.findElementById("createLeadForm_tickerSymbol").sendKeys("LIST");
		driver.findElementById("createLeadForm_description").sendKeys("HELLO");
		driver.findElementById("createLeadForm_importantNote").sendKeys("WELCOME");
		
		WebElement phoneCode = driver.findElementById("createLeadForm_primaryPhoneCountryCode");
		phoneCode.clear();
		phoneCode.sendKeys("91");
		
		driver.findElementById("createLeadForm_primaryPhoneAreaCode").sendKeys("044");
		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("4567778901");
		driver.findElementById("createLeadForm_primaryPhoneExtension").sendKeys("010");
		driver.findElementById("createLeadForm_primaryPhoneAskForName").sendKeys("VEL");
		driver.findElementById("createLeadForm_primaryEmail").sendKeys("svel@gmail.com");
		driver.findElementById("createLeadForm_primaryWebUrl").sendKeys("www.google.com");
		driver.findElementById("createLeadForm_generalToName").sendKeys("VEL");
		driver.findElementById("createLeadForm_generalAttnName").sendKeys("Harish");
		driver.findElementById("createLeadForm_generalAddress1").sendKeys("Medavakkam");
		driver.findElementById("createLeadForm_generalAddress2").sendKeys("Medavakkam");
		driver.findElementById("createLeadForm_generalCity").sendKeys("Chennai");
		driver.findElementById("createLeadForm_generalPostalCode").sendKeys("600112");
		driver.findElementById("createLeadForm_generalPostalCodeExt").sendKeys("112");
		
		
		//Create Lead Form Drop Down Selection
		WebElement sourceDropBox = driver.findElementById("createLeadForm_dataSourceId");
		Select sourceDropDown = new Select(sourceDropBox);
		sourceDropDown.selectByVisibleText("Conference");
				
		WebElement marketingDropBox = driver.findElementById("createLeadForm_marketingCampaignId");
		Select marketingDropDown = new Select(marketingDropBox);
		marketingDropDown.selectByIndex(2);
		
		WebElement currencyDropBox = driver.findElementById("createLeadForm_currencyUomId");
		Select currencyDropDown = new Select(currencyDropBox);
		currencyDropDown.selectByValue("INR");
		
		WebElement industryDropBox = driver.findElementById("createLeadForm_industryEnumId");
		Select industryDropDown = new Select(industryDropBox);
		industryDropDown.selectByValue("IND_AEROSPACE");
		
		WebElement ownerDropBox = driver.findElementById("createLeadForm_ownershipEnumId");
		Select ownerDropDown = new Select(ownerDropBox);
		ownerDropDown.selectByVisibleText("Corporation");
		
		WebElement geoDropBox = driver.findElementById("createLeadForm_generalCountryGeoId");
		Select geoDropDown = new Select(geoDropBox);
		geoDropDown.selectByValue("IND");
		
		//wait 10sec
		Thread.sleep(10000);
		
		WebElement stateDropBox = driver.findElementById("createLeadForm_generalStateProvinceGeoId");
		Select stateDropDown = new Select(stateDropBox);
		stateDropDown.selectByValue("IN-TN");
		
		//Create Lead Submitted
		driver.findElementByClassName("smallSubmit").click();
		
		//Duplicate Lead form 
		driver.findElementByLinkText("Duplicate Lead").click();
		
		WebElement compName = driver.findElementById("createLeadForm_companyName");
		compName.clear();
		compName.sendKeys("CTS");
		
		//Create Lead Submitted
	    driver.findElementByClassName("smallSubmit").click();
		
	    //Verify Duplicate Company Name
	    WebElement dupCmpName = driver.findElementById("viewLead_companyName_sp");
		String newCmpName = dupCmpName.getText();
		System.out.println(newCmpName);
		String cmpName=newCmpName.replaceAll("[^A-Za-z]", "");
		System.out.println(cmpName);
		if(!cmpName.equalsIgnoreCase("HCLT"))
		{
			System.out.println(cmpName+" Company Name is Different from "+orgName+"- PASS");
		}
			
		driver.close();

	}

}
