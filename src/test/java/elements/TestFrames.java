package elements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestFrames {
	ChromeDriver driver;

	@BeforeTest
	public void beforeTest() {
		String chromepath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		driver=new ChromeDriver();
		driver.get("http://cookbook.seleniumacademy.com/Frames.html");

	
		
		

	}
	@Test(priority = 0 , enabled = true , alwaysRun = true)
	public void UserCanLogin() 
	{
		
		driver.switchTo().frame(1);
		WebElement message=driver.findElement(By.tagName("p"));
		System.out.println(message.getText());
		
		
		
		
		
	}



	@AfterTest
	public void afterTest() {
		//driver.quit();
	}

}
