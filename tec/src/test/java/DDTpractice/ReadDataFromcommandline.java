package DDTpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ReadDataFromcommandline {
	@Test
	public void runTest()
	{
		//read data from cmd line
		String browser=System.getProperty("browser");
		String url=System.getProperty("url");
		String username=System.getProperty("username");
		String Password=System.getProperty("password");
		
		
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
	@Test
	public void run()
	{
		System.out.println("passed");
	}

}
