package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import testutils.GetExcelData;

public class ProjectSpecificMethods {
	public ChromeDriver driver;
	public String testFilename;
	public Properties prop;
	public Select select;

	@Parameters("language")
	@BeforeMethod
	public void preconditon(String language) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream("./src/main/resources/" + language + ".properties");
		prop = new Properties();
		prop.load(fis);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void postconditon() throws InterruptedException {
		driver.quit();
	}

	@DataProvider(name = "exceldata")
	public Object[][] readExcelData() throws IOException {
		return GetExcelData.getExcelItems(testFilename);
	}

}
