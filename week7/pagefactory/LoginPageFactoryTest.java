package pagefactory;
import org.testng.annotations.Test;

public class LoginPageFactoryTest extends LoginBasePagefactory {
	
	@Test
	public void runLoginFactory()
	{
	new LoginPageFactory(driver,prop).enterUsername().enterPassword().clickLogin();

    }
}