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

public class TestLinks {
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
		WebElement dev=driver.findElement(By.xpath("//body/div[2]/div[1]/ul[1]"));
		List<WebElement>hyprelinks=dev.findElements(By.tagName("a"));
		System.out.println(hyprelinks.size());
		System.out.println(hyprelinks.get(5).getText());
		Assert.assertEquals("Checkboxes", hyprelinks.get(5).getText());
		

	}




	@AfterTest
	public void afterTest() {
		//driver.quit();
	}

}
