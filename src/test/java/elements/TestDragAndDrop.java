package elements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.Robot;
import java.util.List;

import javax.swing.text.TableView.TableRow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestDragAndDrop {
	ChromeDriver driver;

	@BeforeTest
	public void beforeTest() {
		String chromepath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		driver=new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/DragDropDemo.html");
		






	}
	@Test(priority = 0 , enabled = true , alwaysRun = true)
	public void GetTableRows() {
		WebElement Source=driver.findElement(By.xpath("//p[contains(text(),'Drag me to my target')]"));
		WebElement Target=driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions drag=new Actions(driver);
		drag.dragAndDrop(Source,Target).build().perform();
		System.out.println(Target.getText());
		Assert.assertTrue(Target.getText().contains("Dropped!"));
		
		
		
	
		
		

	}




	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
