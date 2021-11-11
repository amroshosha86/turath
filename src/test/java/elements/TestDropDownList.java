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

public class TestDropDownList {
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
		WebElement dropdownLink=driver.findElement(By.linkText("Dropdown"));
		dropdownLink.click();
		
		WebElement options=driver.findElement(By.id("dropdown"));
		Select selectoptions=new Select(options);
		selectoptions.selectByValue("2");
		System.out.println(selectoptions.getOptions().size());
		System.out.println(selectoptions.getFirstSelectedOption().getText());
		String selectedvalue=selectoptions.getFirstSelectedOption().getText();
		Assert.assertTrue(selectedvalue.contains("Option 2"));
		
		
		
		
		

	}




	@AfterTest
	public void afterTest() {
		//driver.quit();
	}

}
