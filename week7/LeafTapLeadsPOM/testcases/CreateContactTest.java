package testcases;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class CreateContactTest extends ProjectSpecificMethods {
	@BeforeClass
	public void setFilename() {
		testFilename = "contact";
	}

	@Test(dataProvider = "exceldata",dependsOnGroups="sanity")
	public void runVerifyContact(String company, String firstName, String lastName, String email,
			String firstLocal, String lastLocal, String dept, String description, String state, String note) throws InterruptedException
			 {
        try
        {
		new LoginPage(driver, prop).
		enterUsername().
		enterPassword().
		clickLoginButton().
		clickCrmsfa().
		clickContacts().
		clickCreateContact().
		enterCreatContactFirstNameField(firstName).
		enterCreatContactLastNameField(lastName).
		enterCreatContactFirstNameLocal(firstLocal).
		enterCreatContactLastNameLocal(lastLocal).
		enterCreatContactDepartmentName(dept).
		enterCreatContactDescriptionName(description).
		enterCreatContactEmail(email).
		selectCreatContactState(state).
		clickCreateContactButton().
		verifyViewContactTitle().
		verifyContactLastName(lastName).
		clickEditContactButton().
		enterNote(note).
		clearDescription().
		clickContactUpdateButton().
		verifyViewContactTitle().
		verifyContactDescriptionCleared().
		verifyContactUpdatedNote(note);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        }

	}

	

}
