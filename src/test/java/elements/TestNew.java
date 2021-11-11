package elements;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestNew {
	ChromeDriver driver;
	Faker faker = new Faker();
	SoftAssert ass= new SoftAssert();
	String firstName = faker.name().firstName();
	String LastName = faker.name().lastName();
	String Password = faker.phoneNumber().cellPhone();


	@BeforeTest
	public void beforeTest() {
		String chromepath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		driver=new ChromeDriver();
		driver.get("http://cookbook.seleniumacademy.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
	
		







	}
	@Test(priority = 0 , enabled = true , alwaysRun = true)
	public void GetLinks() throws InterruptedException 

	{

		WebElement opendemopage=driver.findElement(By.partialLinkText("AJAX Examp"));
		opendemopage.click();
		WebElement openpage4=driver.findElement(By.xpath("//a[contains(text(),'Page 4')]"));
		openpage4.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement page4message=driver.findElement(By.cssSelector("#page4"));
		Assert.assertTrue(page4message.getText().contains("ligula felis vitae felis."));
		
		
		
		
		
		
		
		

	}




	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
