package practice.hometest;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;






public class HomePageverificationTest {
	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName() + "Test start");
		String expected = "Home Page";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		String actTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
//		if (actTitle.trim().equals(expected)) {
//			System.out.println("verified");
//		} else {
//			System.out.println("not verified");
//		}
		//Hard assert
        Assert.assertEquals(actTitle, expected);
		driver.close();

		System.out.println(mtd.getName()+ "Test end");
	}

	@Test
	public void verifyHomePagetest(Method mtd) {
		System.out.println(mtd.getName()+ "Test start");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
//		if (status) {
//			System.out.println("verified");
//		} else {
//			System.out.println("not verified");
//		}
		//Hard assert
		Assert.assertTrue(status);
		driver.close();
		System.out.println(mtd.getName() + "Test end");

	}
}
