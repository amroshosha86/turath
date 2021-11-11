package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Test9999999999999 	 {
	ChromeDriver driver;
	String path=System.getProperty("user.dir");


	@BeforeTest
	public void beforeTest() throws Exception{
		String chromepath = path +"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		driver=new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/upload");
	}
	@Test
	public void testFileUpload() throws InterruptedException 

	{
		String imageName = "avatar-blank.jpg";
		String imagePath = System.getProperty("user.dir")+"/Uploads/"+imageName;	
		WebElement fileUploader = driver.findElement(By.id("file-upload")); 
		fileUploader.sendKeys(imagePath);
		WebElement fileSubmit = driver.findElement(By.id("file-submit")); 
		fileSubmit.click();
		WebElement uploadedFiles = driver.findElement(By.id("uploaded-files")); 
		System.out.println(uploadedFiles.getText());
		Thread.sleep(3000);

	}



	@AfterTest
	public void afterTest() {
		//driver.quit();
	}

}
