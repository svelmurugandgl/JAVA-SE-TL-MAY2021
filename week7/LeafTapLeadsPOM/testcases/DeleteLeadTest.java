package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class DeleteLeadTest extends ProjectSpecificMethods{
	
	@Test(dependsOnGroups="sanity")
	public void runVerifyLeadDeleted()
	{
		new LoginPage(driver,prop).
		enterUsername().
		enterPassword().
		clickLoginButton().
		clickCrmsfa().
		clickLeads().
		clickFindLeadsLink().
		getAndClickFirstEmployeeId().
		clickDeleteLeadButton().
		clickFindLeadsLink().
		enterLeadId().
		clickFindLeadsButton().
		verifyEmpIDRecordDeleted();
	}

}
