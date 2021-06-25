package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class LoginTest extends ProjectSpecificMethods
{
		
	@Test(groups="sanity")
	public void runVerifyHomePage()
	{
	  try
	  {
	  new LoginPage(driver,prop).
	  enterUsername().
	  enterPassword().
	  clickLoginButton().
	  clickCrmsfa().
	  verifyMyHomepage();
	  }
	  catch (Exception e)
	  {
		  e.printStackTrace();
	  }
	}
	
	
}
