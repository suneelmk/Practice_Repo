package practice.testng;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class SampleTestForScreenShot {
	@Test
	public void amazonTest() throws IOException
	{
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Date d=new Date();
		String s=d.toString();
		String s1=s.replaceAll(":", "-");
		String p="./photos/";
		
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(p+s1+" fail.jpeg");
		FileHandler.copy(src, dst);
		driver.quit();
		
		
		
	}

}
