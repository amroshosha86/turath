package turath.net.Turath;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest3 {
	ChromeDriver driver;

	@BeforeTest
	public void beforeTest() {
		String chromepath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		driver=new ChromeDriver();
		driver.navigate().to("https://www.bing.com");

	}
	@Test(priority = 0 , enabled = true , alwaysRun = true)
	public void A() {
		System.out.println(driver.getTitle());
		String title=driver.getTitle();
		Assert.assertEquals(title,"Bing");
		Assert.assertTrue(title.contains("Bing"));

	}



	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
