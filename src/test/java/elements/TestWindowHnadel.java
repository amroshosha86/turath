package elements;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestWindowHnadel {
	ChromeDriver driver;

	@BeforeTest
	public void beforeTest() 
	{
		String chromepath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		driver=new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");

	}

	@Test(priority = 0 , enabled = true , alwaysRun = true)
	public void ChildWindows() 

	{
		driver.findElement(By.id("helpbutton")).click();
		Set <String> windows = driver.getWindowHandles();
		Iterator <String> it = windows.iterator();
		String ParentWindow = it.next();
		String childWindow= it.next();
		driver.switchTo().window(childWindow);
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals("Help", driver.getTitle());
		driver.close();
		driver.switchTo().window(ParentWindow);
		System.out.println(driver.getCurrentUrl());

	}




	@AfterTest
	public void afterTest() {
		//driver.quit();
	}

}
