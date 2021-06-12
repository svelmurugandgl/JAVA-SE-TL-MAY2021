package stepsleads;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadsTestCases {
	public ChromeDriver driver;
	SoftAssert softassert = new SoftAssert();

	@Given("Open the chrome browser")
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Given("Load the application URL as {string}")
	public void loadUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("Enter the User Name as {string}")
	public void enterUsername(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}

	@Given("Enter the Password as {string}")
	public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@Given("Click the Login Button")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Given("Click CRM Link")
	public void clickCRM() {
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
	}

	@Given("Click Leads")
	public void clickLeads() {
		driver.findElementByXPath("//a[text()='Leads']").click();
	}

	@Given("Click Create Leads")
	public void clickCreateLeads() {
		driver.findElementByXPath("//a[text()='Create Lead']").click();
	}

	@Given("Enter Company Name {string}")
	public void enterCompanyName(String company) {
		driver.findElementByXPath("//input[@id='createLeadForm_companyName']").sendKeys(company);
	}

	@Given("Enter first Name {string}")
	public void enterFirstName(String firstName) {
		driver.findElementByXPath("//input[@id='createLeadForm_firstName']").sendKeys(firstName);
	}

	@Given("Enter last Name {string}")
	public void enterLastName(String lastName) {
		driver.findElementByXPath("//input[@id='createLeadForm_lastName']").sendKeys(lastName);
	}

	@When("Click Create Lead")
	public void clickCreateLead() {
		driver.findElementByXPath("//input[@class='smallSubmit']").click();
	}

	@Then("Verify Lead is created")
	public void verifyLead() {
		String expected = "View Lead";
		String actual = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		softassert.assertEquals(actual, expected, "Verify Lead is Created");
		driver.close();
		softassert.assertAll();
	}

	@But("Veirfy Lead is Not created with Error Message")
	public void verifyNoLead() {
		String expected = "parameter is missing";
		String actual = driver.findElement(By.xpath("(//li[@class='errorMessage'])[1]")).getText();
		softassert.assertTrue(actual.contains(expected), "Verify Lead is NOT Created");
		driver.close();
		softassert.assertAll();

	}

	@Given("Click Find Leads")
	public void clickFindLeads() {
		driver.findElementByXPath("//a[text()='Find Leads']").click();
	}

	String storeEmpId = "";

	@Given("Get and Store 1st Emp ID and Click 1st Emp ID")
	public void storeAndClickEmpId() {
		WebElement empID = driver.findElementByXPath("(//div[@unselectable='on']//a[@class='linktext'])[1]");
		storeEmpId = empID.getText();
		System.out.println("1st Emp ID= " + storeEmpId);
		empID.click();
	}

	@Given("Delete the 1st Emp ID")
	public void deleteEmpId() {
		driver.findElementByXPath("//a[text()='Delete']").click();
	}

	@When("Enter Stored 1st Emp ID and then Click to Find Deleted Lead")
	public void findDeletedLead() {
		driver.findElementByXPath("//div[@class='x-form-element']/input[@name='id']").sendKeys(storeEmpId);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
	}

	@Then("Verify Lead is Deleted")
	public void verifyLeadDeleted() {
		String actual = driver.findElementByXPath("//div[text()='No records to display']").getText();
		String expected = "No records to display";
		softassert.assertTrue(actual.contains(expected), "Verify Lead is NOT Created");
		driver.close();
		softassert.assertAll();

	}

	@Given("Enter the firstName as {string}")
	public void editFirstName(String firstName) {
		driver.findElementByXPath("(//div[@class='x-form-item x-tab-item']//input)[2]").sendKeys(firstName);
	}

	@Given("Click Find Leads List")
	public void clickFindLeadsList() throws InterruptedException {
		driver.findElementByXPath("//button[text()='Find Leads']").click();
	}

	@When("Click 1st Emp ID List")
	public void clickFirstEmpIdList() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElementByXPath("(//td//a[@class='linktext'])[1]").click();
		Thread.sleep(2000);
	}

	@Then("Verify View Lead Title is displayed correctly")
	public void verifyLeadtitle() {
		String expected = "View Lead | opentaps CRM";
		String actual = driver.getTitle();
		softassert.assertEquals(actual, expected, "View Lead Title Check");
		driver.close();
		softassert.assertAll();

	}

	@Given("Click Edit Emp ID")
	public void clickEditEmpId() {
		driver.findElementByXPath("//a[text()='Edit']").click();
	}

	String newCmp = "";

	@Given("Clear and Enter new company name as {string}")
	public void clearAndEnterNewCompnay(String company) {
		WebElement cmpName = driver.findElementByXPath("//input[@id='updateLeadForm_companyName']");
		cmpName.clear();
		cmpName.sendKeys(company);
		newCmp = company;
	}

	@When("Click update the 1st Emp ID record")
	public void clickUpdateRecord() {
		driver.findElementByXPath("//input[@value='Update']").click();
	}

	@Then("Verify new company name is updated")
	public void verifyNewCompany() {
		WebElement currentCmpName = driver.findElementById("viewLead_companyName_sp");
		String getCmpName = currentCmpName.getText();
		String actualCmpName = getCmpName.replaceAll("[^A-Za-z]", "");
		System.out.println(actualCmpName + " " + newCmp);
		softassert.assertEquals(actualCmpName, newCmp, "New Company Name Check");
		driver.close();
		softassert.assertAll();

	}
}
