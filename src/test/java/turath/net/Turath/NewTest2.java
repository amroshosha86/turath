package turath.net.Turath;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;


public class NewTest2 {
	ChromeDriver driver;


	@BeforeTest
	public void lanuchbrowser()
	{
		String chromepath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		 driver=new ChromeDriver();
		 driver.navigate().to("https://google.com");


	}

	@Test
	public void tests() 
	{
		String myurl=driver.getTitle();
		System.out.println(myurl);
		Assert.assertTrue(myurl.contains("Google"));
		

	}
	@AfterTest
	public void closebrowser()
	{
		driver.quit();

	}

}

