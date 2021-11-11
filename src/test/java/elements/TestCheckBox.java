package elements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import javax.swing.text.TableView.TableRow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestCheckBox {
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
		WebElement Checkboxes=driver.findElement(By.linkText("Checkboxes"));
		Checkboxes.click();

		WebElement checkfirstbox=
		driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		checkfirstbox.click();
		Assert.assertTrue(checkfirstbox.isSelected());
		








	}




	@AfterTest
	public void afterTest() {
		//driver.quit();
	}

}
