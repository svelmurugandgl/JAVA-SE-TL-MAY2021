package week2.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkButton {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver onlineDriver = new ChromeDriver();        
		        
		
		        //Load URL
				onlineDriver.get("http://leafground.com/pages/Button.html");
				
				//To maximize the window
				onlineDriver.manage().window().maximize();
				
				//Click Home by Id Locator
				onlineDriver.findElementById("home").click();
				
				//Click Button by navigate
				onlineDriver.navigate().back();
				
				
				//Get Position(x,y) by Id Locator
			    WebElement pos = onlineDriver.findElementById("position");
			    Point locate = pos.getLocation();
			    int x=locate.getX();
			    int y=locate.getY(); 
			    System.out.println("X Location="+x+"\r\n"+"Y Location="+y+"\r\n");
			    
			    //Get Button Color by Id Locator and Attribute by color
			    System.out.println("What Color am i?  \r\n"+onlineDriver.findElementById("color").getAttribute("style")+"\r\n");
			    
			    
			   //Get height and width by Id Locator
			    WebElement dimen = onlineDriver.findElementById("size");
			    Dimension measure = dimen.getSize();
			    int w=measure.height;
			    int h=measure.width;
			    System.out.println("What is my Size?"+"\r\n"+"Widhth="+w+"\r\n"+"Height="+h+"\r\n");
			   

				//To close browser
				onlineDriver.close();

	}

}
