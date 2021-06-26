package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class LoginTest extends ProjectSpecificMethods
{
		
	@Test(groups="sanity")
	public void runVerifyHomePage()
	{
	 
	  new LoginPage(driver,prop).
	  enterUsername().
	  enterPassword().
	  clickLoginButton().
	  clickCrmsfa().
	  verifyMyHomepage();
	  
	  
	}
	
	
}
