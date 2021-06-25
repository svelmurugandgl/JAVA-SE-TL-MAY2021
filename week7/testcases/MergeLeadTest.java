package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class MergeLeadTest extends ProjectSpecificMethods
{

	@Test(dependsOnGroups="sanity")
	public void runVerifyMergedLead() throws InterruptedException
	{
		new LoginPage(driver,prop).
		enterUsername().
		enterPassword().
		clickLoginButton().
		clickCrmsfa().
		clickLeads().
		clickFindLeadsLink().
		getFirstLeadId().
		getSecondEmployeeID().
		clickMergeLeadLink().
		clickFromLeadIcon().
		switchToNewFindLeadsWindow().
		enterFromLeadID().
		clickNewFindLeadsButton().
		clickFirstLead().
		switchToMainWindow().
		clickToLeadIcon().
		switchToNewFindLeadsWindow().
		enterToLeadID().
		clickNewFindLeadsButton(). 
		clickFirstLead().
		switchToMainWindow().
		clickMergeLeadsButton().
		acceptMergeAlert().
		clickFindLeadsLink().
		enterFromLeadID().
		clickFindLeadsButton().
		verifyMergedLead();
		
	}
		
}
