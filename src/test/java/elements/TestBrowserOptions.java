package elements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.sql.Driver;
import java.util.List;

import javax.swing.text.TableView.TableRow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestBrowserOptions {
	ChromeDriver driver;

	@BeforeTest
	public void beforeTest() {
		String chromepath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		driver=new ChromeDriver();
		driver.navigate().to("https://google.com");






	}
	@Test(priority = 0 , enabled = true , alwaysRun = true)
	public void GetLinks() 
	
	{
		driver.navigate().to("https://google.com/images");
		driver.manage().window().maximize();
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().forward();
		

	}




	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
