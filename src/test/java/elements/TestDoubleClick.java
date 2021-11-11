package elements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestDoubleClick {
	ChromeDriver driver;

	@BeforeTest
	public void beforeTest() {
		String chromepath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		driver=new ChromeDriver();
		driver.get("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");

	
		
		

	}
	@Test(priority = 0 , enabled = true , alwaysRun = true)
	public void UserCanLogin() 
	{
		
		WebElement area=driver.findElement(By.xpath("//p[@id='message']"));
		Actions builder=new Actions(driver);
		builder.doubleClick(area).build().perform();
		
		
		
	}



	@AfterTest
	public void afterTest() {
		//driver.quit();
	}

}
