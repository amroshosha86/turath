package elements;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestUploadFilesRobotClass 	 {
	ChromeDriver driver;
	String path=System.getProperty("user.dir");
	String Uploadedimagepath=path +"\\images\\testcase1.png";
	String Url="http://demo.guru99.com/selenium/upload";

	@BeforeTest
	public void beforeTest() throws Exception{
		String chromepath = path +"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		driver=new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();


	}
	@Test()
	public void UploadFiles() throws IOException, AWTException 

	{

		//open upload window
		driver.findElement(By.name("uploadfile_0")).click();
		 Robot robot = new Robot();
		//put path to your image in a clipboard
		StringSelection  ss=new StringSelection("D:\\auto\\new\\Turath\\resources\\uploads\\1.png");
		Clipboard clipboard =Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(ss, null);
		
	    //imitate mouse events like ENTER, CTRL+C, CTRL+V
	    
	    // robot.delay(250);
	     
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     robot.delay(250);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.delay(90);
	     robot.keyRelease(KeyEvent.VK_ENTER);


	}


	@AfterTest
	public void afterTest() {
		//driver.quit();
	}

}
