package elements;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class TestScreenShoots 	 {
	ChromeDriver driver;
	String path=System.getProperty("user.dir");

	

	@BeforeTest
	public void beforeTest() throws Exception{
		String chromepath = path +"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		driver=new ChromeDriver();
		


	}
	@Test(priority = 0 , enabled = true , alwaysRun = true)
	public void testcase1() throws IOException 

	{
		driver.navigate().to("https://www.msn.com");
		driver.findElement(By.name("xxxxxxxxxx")).click();

	}

	@AfterMethod 
	public void takescreenshot(ITestResult result) throws IOException
	{
		if (ITestResult.FAILURE==result.getStatus()) 
		{
			//add the Ashot dependency
			//https://mvnrepository.com/artifact/ru.yandex.qatools.ashot/ashot/1.5.4
			Screenshot screen = new AShot().takeScreenshot(driver);
			ImageIO.write(screen.getImage(), "PNG", new File(path+"\\images\\testcase12.png"));

			
		}
	}

	


	@AfterTest
	public void afterTest() {
		//driver.quit();
	}

}
