package elements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class TestWaits {
	ChromeDriver driver;



	@BeforeTest
	public void beforeTest() {
		String chromepath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		driver=new ChromeDriver();
		driver.get("https://www.google.com");





	}
	@Test(priority = 0 , enabled = true , alwaysRun = true)
	public void GetLinks() 

	{

		WebElement Checkboxes=driver.findElement(By.name("q"));
		Actions hitenter=new Actions(driver);
		hitenter.sendKeys(Checkboxes, "ZAmalek").build().perform();
		hitenter.sendKeys(Keys.ENTER).build().perform();
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlContains("ZAmalek"));
		Assert.assertTrue(driver.getTitle().contains("ZAmalek"));

	}

	@Test(priority = 1 , dependsOnMethods = "GetLinks")
	public void GetLinks2()
	{
		WebElement Checkboxes2=driver.findElement(By.name("q"));
		Checkboxes2.clear();
		Actions HitEnter=new Actions(driver);	
		HitEnter.sendKeys(Checkboxes2, "Amr Diab").build().perform();
		HitEnter.sendKeys(Keys.ENTER).build().perform();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("Amr Diab"));
		Assert.assertTrue(driver.getTitle().contains("Amr Dia"));


	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
