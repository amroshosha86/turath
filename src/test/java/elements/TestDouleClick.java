package elements;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.awt.*;


public class TestDouleClick {
	ChromeDriver driver;

	@BeforeTest
	public void beforeTest() 
	{
		String chromepath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		driver=new ChromeDriver();
		driver.navigate().to("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.findElement(By.tagName("button")).click();
		//driver.get("https://admin-demo.nopcommerce.com/Admin/Category/Create");
		driver.get("https://admin-demo.nopcommerce.com/Admin/Category");


	}

	@Test(priority = 0 , enabled = true , alwaysRun = true)
	public void ChildWindows() throws InterruptedException 

	{
		//WebElement catname=driver.findElement(By.cssSelector("#Name"));
		//catname.sendKeys("Lg1");
		
		
		//WebElement save=driver.findElement(By.cssSelector("button[name='save']"));
		//Actions twoclick=new Actions(driver);
		//twoclick.click(save).click(save).build().perform();
		
		WebElement serarchbox=driver.findElement(By.cssSelector("#SearchCategoryName"));
		serarchbox.sendKeys("Lg1");
		WebElement serarchbutton=driver.findElement(By.cssSelector("#search-categories"));
		serarchbutton.click();
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement searchresult=driver.findElement(By.xpath("//tbody/tr[2]/td[2]"));
		String reslut=searchresult.getText();
		Assert.assertFalse(searchresult.getText().contains("amro"));
		
		

		
		
		
		
		
		

		
		
	
	}




	@AfterTest
	public void afterTest() {
		//driver.quit();
	}

}
