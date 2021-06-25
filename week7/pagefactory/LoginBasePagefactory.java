package pagefactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginBasePagefactory {
	public ChromeDriver driver;
	public Properties prop;
	@BeforeMethod
    public void beforeRun() throws IOException
    {
    	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//To read property file
		FileInputStream fis=new FileInputStream("./src/main/resources/config.properties");
		//Object for properties
	    prop = new Properties();
		//To read Property 
		prop.load(fis);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
	@AfterMethod
    public void afterRun() throws IOException
    {
		driver.close();
    }
    
}
