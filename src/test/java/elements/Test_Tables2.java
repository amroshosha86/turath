package elements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import javax.swing.text.TableView.TableRow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Test_Tables2 {
	ChromeDriver driver;

	@BeforeTest
	public void beforeTest() {
		String chromepath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		driver=new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com");






	}
	@Test(priority = 0 , enabled = true , alwaysRun = true)
	public void GetTableRows() {
		WebElement OpenTablePage=driver.findElement(By.linkText("Sortable Data Tables"));
		OpenTablePage.click();
		
		//GetTableRows
		WebElement table=driver.findElement(By.id("table1"));
		List<WebElement>rows=table.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		System.out.println(rows.get(0).getText());
		System.out.println(table.getText());
		
		
		

	}




	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
