package turath.net.Turath;

import org.openqa.selenium.chrome.ChromeDriver;

public class testdriver {

	public static void main(String[] args) {
		
		//System.out.println(System.getProperty("user.dir"));
		String chromepath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath);
		ChromeDriver driver=new ChromeDriver();
		driver.navigate().to("https://mvnrepository.com");

	}

}
