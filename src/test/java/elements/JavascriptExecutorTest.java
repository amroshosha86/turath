package elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class JavascriptExecutorTest {
	ChromeDriver driver;

	@BeforeTest
	public void beforeTest() throws InterruptedException 
	{
		String chromepath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();

		//driver.get("http://admin-demo.moosocial.com/admin/home/login");
		driver.get("https://yallakora.com");

	}

	@Test(priority = 0 , enabled = true , alwaysRun = true)
	public void ChildWindows() throws InterruptedException 

	{
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		
		//get WebSite title
		String titlename=(String) js.executeScript("return document.title");
		//get WebSite URL
		String urlname=(String) js.executeScript("return document.URL");
		System.out.println(titlename);
		System.out.println(urlname);
		 //Vertical scroll down by 600  pixels
		js.executeScript("window.scrollBy(0,600)");
		
		//Hit the login button
		 WebElement button =driver.findElement(By.xpath("//button[contains(text(),'تسجيل الدخول')]"));
		js.executeScript("arguments[0].click();", button);





	}




	@AfterTest
	public void afterTest() {
		//driver.quit();
	}

}
