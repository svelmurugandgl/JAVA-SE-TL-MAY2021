package week5.day1;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteLead extends TestBaseClass{
    @Test(enabled=false)
	public void runDeleteLead()  {
    	// Click Leads
    	driver.findElementByXPath("//a[text()='Leads']").click();
    	// Click Find Leads
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		// Get 1st EMP ID and Click same ID
		WebElement emp = driver.findElementByXPath("(//div[@unselectable='on']//a[@class='linktext'])[1]");
		String empID = emp.getText();
		System.out.println("EMP ID= "+empID);
		emp.click();
		// Delete Specific Lead ID
		driver.findElementByXPath("//a[text()='Delete']").click();
		// Click Find Leads
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		// Enter stored ID
		driver.findElementByXPath("//div[@class='x-form-element']/input[@name='id']").sendKeys(empID);
		// Click Find Leads
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		if (driver.findElementByXPath("//div[text()='No records to display']").getText()
				.contains("No records to display")) {
			System.out.println("Confirmed - Record Deleted - PASS");
		} else {
			System.out.println("Confirmed - Record is NOT Deleted - FAIL");
		}

	}

}
