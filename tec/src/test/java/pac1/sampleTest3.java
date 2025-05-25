package pac1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class sampleTest3 {

	
	@Test
	public void sampleTest() throws InterruptedException, MalformedURLException
	{
		URL ipAdd = new URL("http://localhost:4444/wd/hub");
		ChromeOptions option=new ChromeOptions();
		WebDriver driver=new RemoteWebDriver(ipAdd,option);
		Thread.sleep(10000);
		driver.get("https://www.nike.com/in/");
		System.out.println(driver.getTitle());
		Thread.sleep(10000);
		driver.close();
	}
	
}
