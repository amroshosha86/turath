package elements;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestWindowHnadel2 {
	ChromeDriver driver;

	@BeforeTest
	public void beforeTest() 
	{
		String chromepath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		driver=new ChromeDriver();
		driver.navigate().to("http://demo.guru99.com/popup.php");

	}

	@Test(priority = 0 , enabled = true , alwaysRun = true)
	public void ChildWindows() 

	{
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		
		Set <String> windows = driver.getWindowHandles();
		Iterator <String> it = windows.iterator();
		String ParentWindow = it.next();
		String childWindow= it.next();
		
		driver.switchTo().window(childWindow);
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals("http://demo.guru99.com/articles_popup.php", driver.getCurrentUrl());
		
		WebElement emailfield =driver.findElement(By.name("emailid"));
		emailfield.sendKeys("Amro.mohamed1952@gmailcom");
		emailfield.submit();
		WebElement mailmessage= driver.findElement(By.xpath("//*[@id=\"message9\"]"));
		System.out.println("The message is " + mailmessage.getText());
		driver.close();
		
		driver.switchTo().window(ParentWindow);
		System.out.println(driver.getCurrentUrl());

	}




	@AfterTest
	public void afterTest() {
		//driver.quit();
	}

}
