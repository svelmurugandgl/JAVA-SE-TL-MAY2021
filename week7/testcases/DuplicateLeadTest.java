package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class DuplicateLeadTest extends ProjectSpecificMethods{
	@BeforeClass
	public void setFilename() {
		testFilename = "CreateLead";
	}

	@Test(dataProvider = "exceldata",dependsOnGroups="sanity")
	public void runVerifyDuplicateLeadTitleAndFirstName(String company, String firstName, String lastName, String email) throws InterruptedException
			 {
        try
        {
        	new LoginPage(driver,prop).
        	enterUsername().
        	enterPassword().
        	clickLoginButton().
        	clickCrmsfa().
        	clickLeads().
        	clickFindLeadsLink().
        	clickFindLeadEmail().
        	enterFindLeadEmail(email).
        	clickFindLeadsButton().
        	getAndClickFirstEmployeeName().
        	clickDuplicateLeadButton().
        	verifyDuplicateLeadPageTitle().
        	clickDuplicateCreateLeadButton().
        	verifyDuplicateLeadFirstName();
        	        	
        }catch (Exception e)
        {
        	e.printStackTrace();
        }
        
}
}