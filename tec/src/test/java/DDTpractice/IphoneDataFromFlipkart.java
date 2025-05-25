package DDTpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IphoneDataFromFlipkart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	(//div[@class='Nx9bqj _4b5DiR'])[number(translate(text(),'₹,',''))<70000]

//	   WebDriver driver=new ChromeDriver();
//	   driver.get("https://www.flipkart.com/search?q=iphone&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
//	   driver.manage().window().maximize();
//	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	List<WebElement> ele = driver.findElements(By.xpath("(//div[@class='Nx9bqj _4b5DiR'])[number(translate(text(),'₹,',''))<70000]")); 
//	  for(WebElement x:ele)
//	  {
//		  System.out.println(x.getText());
//	  }
		
//		String a="hello";
//		String b="bye";
//		System.out.println(a==b);
		String s="hi";
		String s1="hi";		System.out.println(s==s1);
		System.out.println(s.equals(s1));
		
	}

}
