package pagefactory;

import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends LoginBasePagefactory
{
	public LoginPageFactory(ChromeDriver driver,Properties prop)
	{
		this.driver=driver;
		this.prop=prop;
		PageFactory.initElements(driver,this);
	}
    
    @CacheLookup
    @FindBy(id="username") WebElement eleUsername;
    //@FindBy(how=How.ID,using="username") WebElement eleUsername;
	public LoginPageFactory enterUsername() {
    	eleUsername.sendKeys(prop.getProperty("username"));
		return this;
	}
	@CacheLookup
	@FindBy(id="password") WebElement elePassword;
    //@FindBy(how=How.ID,using="password") WebElement elePassword;
	public LoginPageFactory enterPassword() {
		elePassword.sendKeys(prop.getProperty("password"));
		return this;
	}
	@CacheLookup
	@FindBy(className="decorativeSubmit") WebElement eleSubmit;
	//@FindBy(how=How.CLASS_NAME,using="decorativeSubmit") WebElement eleSubmit;
	public LoginPageFactory clickLogin() {
		eleSubmit.click();
		return this;
	}
	
}
