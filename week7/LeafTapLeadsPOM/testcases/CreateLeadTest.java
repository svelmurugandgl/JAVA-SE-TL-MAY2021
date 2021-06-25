package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;


public class CreateLeadTest extends ProjectSpecificMethods {
	@BeforeClass
	public void setFilename()
	{
		testFilename="CreateLead";
	}
	
	@Test(dataProvider="exceldata",dependsOnGroups="sanity")
	public void runVerifyFirstName(String company,String firstname,String lastname,String email)
	{
		try {
		new LoginPage(driver,prop).
		enterUsername().
		enterPassword().
		clickLoginButton().
		clickCrmsfa().
		clickLeads().
		clickCreateLeadslink().
		enterCreateLeadFirstName(firstname).
		enterCreateLeadLastName(lastname).
		enterCreateLeadCompanyname(company).
		enterCreateLeadEmail(email).
		clickCreateLeadButton().
		verifyFirstname();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
