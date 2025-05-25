package DDTpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReaddataFromTextNgxmlTest {
	@Test
	public void sampleTest(XmlTest test)
	{

		String browser=test.getParameter("browser");
		String url=test.getParameter("url");
		String username=test.getParameter("username");
		String Password=test.getParameter("password");
		
		
		 WebDriver driver=null;
		 if(browser.equals("firefox"))
		 {
			 driver=new FirefoxDriver();
		 }
		 else if(browser.equals("chrome"))
		 {
			 driver=new ChromeDriver();
		 }
		 driver.get(url);
		
		 driver.findElement(By.name("user_name")).sendKeys(username);
		 driver.findElement(By.name("user_password")).sendKeys(Password);
		 driver.findElement(By.id("submitButton")).click();
	}

}
