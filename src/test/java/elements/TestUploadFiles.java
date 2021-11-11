package elements;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestUploadFiles 	 {
	ChromeDriver driver;
	String path=System.getProperty("user.dir");
	String Uploadedimagepath=path +"\\images\\testcase1.png";
	String Url="https://the-internet.herokuapp.com/upload";

	@BeforeTest
	public void beforeTest() throws Exception{
		String chromepath = path +"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		driver=new ChromeDriver();
		driver.get(Url);
	

	}
	@Test(priority = 0 , enabled = true , alwaysRun = true)
	public void UploadFiles() throws IOException 

	{
		//Upload via send keys
		//https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload
		WebElement uploadBtn=driver.findElement(By.cssSelector("#file-upload"));
		uploadBtn.sendKeys(Uploadedimagepath);
	

	}


	


	@AfterTest
	public void afterTest() {
		//driver.quit();
	}

}
