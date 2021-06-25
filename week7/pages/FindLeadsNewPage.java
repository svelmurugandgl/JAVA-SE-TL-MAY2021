package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class FindLeadsNewPage extends ProjectSpecificMethods {
	// variable
	protected List<String> listWindow;
	static String mainWindow;
	
	// Constructor
	public FindLeadsNewPage(ChromeDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	// Action Methods
	public FindLeadsNewPage switchToNewFindLeadsWindow() {
		try {
			// Get windows handle into Set to access multiple window
			Set<String> getFromWindow = driver.getWindowHandles();
			// Put into List - To access specific window handle
			listWindow = new ArrayList<String>(getFromWindow);
			mainWindow=listWindow.get(0);
			// Switch from main(0) window to Find Leads new window(1)
			driver.switchTo().window(listWindow.get(1));
			listWindow.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public FindLeadsNewPage enterFromLeadID() {
		try {
			WebElement enterFromLeadId = driver.findElement(By.xpath("//input[@name='id']"));
			enterFromLeadId.sendKeys(FindLeadsPage.fromLeadId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public FindLeadsNewPage enterToLeadID() {
		try {
			WebElement enterToLeadId = driver.findElement(By.xpath("//input[@name='id']"));
			enterToLeadId.sendKeys(FindLeadsPage.toLeadId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public MergeLeadsPage clickFirstLead() throws InterruptedException {
		try {
			Thread.sleep(1000);
			WebElement findLeadsFirstLead = driver.findElement(By.xpath("(//td//a[@class='linktext'])[1]"));
			findLeadsFirstLead.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new MergeLeadsPage(driver, prop);

	}

	public FindLeadsNewPage clickNewFindLeadsButton() {
		try {
			WebElement findLeads = driver
					.findElement(By.xpath(prop.getProperty("FindLeadsPage.FindLeadsButton.Xpath")));
			findLeads.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

}
