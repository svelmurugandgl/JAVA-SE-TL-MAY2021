package pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificMethods;

public class FindLeadsPage extends ProjectSpecificMethods {
	// Variable
	static String firstEmpId, fromLeadId, toLeadId;
	static String firstEmpName;
	SoftAssert softassert = new SoftAssert();

	// Constructor
	public FindLeadsPage(ChromeDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	// Action Methods
	public ViewLeadsPage getAndClickFirstEmployeeId() {
		try {
			// Get 1st EMP ID and Click same ID
			WebElement employeeID = driver
					.findElement(By.xpath("(//div[@unselectable='on']//a[@class='linktext'])[1]"));
			firstEmpId = employeeID.getText();
			System.out.println("Fist Emp ID " + firstEmpId);
			employeeID.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ViewLeadsPage(driver, prop);

	}

	public FindLeadsPage getFirstLeadId() {
		try {
			WebElement leadId = driver.findElement(By.xpath("(//div[@unselectable='on']//a[@class='linktext'])[1]"));
			fromLeadId = leadId.getText();
			System.out.println("From Lead ID is " + fromLeadId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;

	}

	public FindLeadsPage enterFromLeadID() {
		try {
			WebElement enterFromLeadId = driver.findElement(By.xpath("//input[@name='id']"));
			enterFromLeadId.sendKeys(FindLeadsPage.fromLeadId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	public FindLeadsPage getSecondEmployeeID() {
		try {
			List<WebElement> empIdList = driver
					.findElements(By.xpath("(//table[contains(@class,'row-table')]//a[contains(@href,'partyId')])"));
			for (int i = 7; i < empIdList.size(); i += 5) {
				if (!empIdList.get(2).getText().equalsIgnoreCase(empIdList.get(i).getText())) {
					toLeadId = empIdList.get(i - 2).getText();
					break;
				}
			}
			System.out.println("To Lead ID is " + toLeadId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public FindLeadsPage enterLeadId() {
		try {
			System.out.println("1st EMP ID To Delete is " + firstEmpId);
			WebElement leadId = driver.findElementByXPath("//div[@class='x-form-element']/input[@name='id']");
			leadId.sendKeys(firstEmpId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public FindLeadsPage clickFindLeadsButton() {
		try {
			WebElement findLeadButton = driver
					.findElementByXPath(prop.getProperty("FindLeadsPage.FindLeadsButton.Xpath"));
			findLeadButton.click();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return this;

	}

	public FindLeadsPage verifyEmpIDRecordDeleted() {
		try {
			WebElement noRecordText = driver.findElementByXPath("//div[text()='No records to display']");
			System.out.println("FirstEmpID is Deleted as" + firstEmpId);
			softassert.assertTrue(noRecordText.getText().contains("No records to display"), "Verify Record is Deleted");
			softassert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return this;

	}

	public FindLeadsPage enterFindLeadEmail(String getEmail) {
		try {
			WebElement findLeadEnterEmail = driver.findElementByXPath("//input[@name='emailAddress']");
			findLeadEnterEmail.sendKeys(getEmail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public FindLeadsPage clickFindLeadEmail() {
		try {
			WebElement findLeadEmail = driver.findElementByXPath("//span[text()='Email']");
			findLeadEmail.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public ViewLeadsPage getAndClickFirstEmployeeName() {
		try {
			Thread.sleep(1000);
			WebElement employeeName = driver
					.findElement(By.xpath("(//div[@unselectable='on']//a[@class='linktext'])[3]"));
			firstEmpName = employeeName.getText();
			System.out.println("1st EMP Name is " + firstEmpName);
			employeeName.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ViewLeadsPage(driver, prop);

	}
	public MergeLeadsPage clickMergeLeadLink() {
		try {
			WebElement mergeLeadLink = driver.findElement(By.xpath(prop.getProperty("MyLeadsPage.MergeLead.Xpath")));
			mergeLeadLink.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new MergeLeadsPage(driver, prop);
	}
	public FindLeadsPage verifyMergedLead() {
		try {
			Thread.sleep(2000);
			String msg = driver.findElement(By.xpath("//div[@class='x-panel-bbar']//div[@class='x-paging-info']")).getText();
			System.out.println(msg);
			softassert.assertTrue(msg.contains("No records"), "Verify Lead is Merged");
			softassert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

}
