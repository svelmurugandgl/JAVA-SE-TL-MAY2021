package week2.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkEditFields {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		//enter email
		driver.findElementById("email").sendKeys("vel@yahoo.com");
		
		//Apppend Text in text box
		WebElement appendName=driver.findElementByXPath("//input[@value='Append ']");
	    String txtName=appendName.getText();
	    appendName.sendKeys(txtName.replaceAll(" ", txtName)+"Appended");
	    
	    //Clear Text in Text Box
		driver.findElementByXPath("//input[@value='Clear me!!']").clear();
		
		//default text name in text box
		String txt = driver.findElementByXPath("//input[@value='TestLeaf']").getAttribute("value");
	    System.out.println("Default Text is "+txt);
		
	    //Is Text Box Enabled
	    System.out.println("Is Edit Field Enabled "+driver.findElementByXPath("//input[@disabled='true']").isEnabled());
		driver.close();
		

	}
}
