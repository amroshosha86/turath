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

public class Test_Tables {
	ChromeDriver driver;

	@BeforeTest
	public void beforeTest() {
		String chromepath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		driver=new ChromeDriver();
		driver.navigate().to("http://demo.guru99.com/test/web-table-element.php");






	}
	@Test(priority = 0 , enabled = true , alwaysRun = true)
	public void GetTableRows() {
		WebElement tablerows =driver.findElement(By.cssSelector("#leftcontainer > table"));
		List<WebElement>rows=tablerows.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		System.out.println(rows.get(5).getText());
		int numberofrows=rows.size();
		Assert.assertEquals(numberofrows,27);
		//Or
		WebElement testtext=driver.findElement(By.xpath("//a[contains(text(),'DCB Bank')]"));
		System.out.println(testtext.getText());


	}




	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
