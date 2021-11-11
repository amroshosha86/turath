package elements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.tagName("button")).submit();
	
	
		
		

	}
	@Test(priority = 0 , enabled = true , alwaysRun = true)
	public void UserCanLogin() {
		System.out.println(driver.findElement(By.xpath("//div[@id='flash']")).getText());
		WebElement successmessage=driver.findElement(By.xpath("//div[@id='flash']"));
		String message=successmessage.getText();
		Assert.assertTrue(message.contains("logged"));

	}



	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
