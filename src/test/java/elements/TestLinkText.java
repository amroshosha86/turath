package elements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import javax.swing.text.TableView.TableRow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestLinkText {
	ChromeDriver driver;

	@BeforeTest
	public void beforeTest() {
		String chromepath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		driver=new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com");






	}
	@Test(priority = 0 , enabled = true , alwaysRun = true)
	public void GetLinks() 
	
	{
		WebElement links=driver.findElement(By.linkText("Checkboxes"));
		links.click();
		String CurrentUrl=driver.getCurrentUrl();
		System.out.println(CurrentUrl);
		Assert.assertEquals(CurrentUrl,"https://the-internet.herokuapp.com/checkboxes");
		Assert.assertTrue(CurrentUrl.contains("checkboxes"));
		

	}




	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
