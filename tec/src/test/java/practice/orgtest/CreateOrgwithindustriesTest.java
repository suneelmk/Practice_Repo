package practice.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgwithindustriesTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//read common data from properties file
		FileInputStream fis=new FileInputStream("C:\\Users\\HP\\Desktop\\propertiesfile\\commondatas.properties");
		Properties p=new Properties();
		p.load(fis);
		String BROWSER=p.getProperty("browser");
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		
		
		//generate the random Number
		Random random =new Random();
		int randomInt=random.nextInt(1000);
		
		//read testscript data from excel file
		FileInputStream fis1=new FileInputStream("C:\\Users\\HP\\Desktop\\testscriptdata\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		      Sheet sh = wb.getSheet("org");
		         Row rw = sh.getRow(4);
		        String orgname= rw.getCell(2).toString()+randomInt;
		        String industry= rw.getCell(3).toString();
		        String type= rw.getCell(4).toString();
		        wb.close();
		        
		        
		        WebDriver driver=null;
		        if(BROWSER.equals("chrome"))
		        {
		        	driver=new ChromeDriver();     
		        }	
		        else if(BROWSER.equals("firefox"))
		        {
		        	driver=new FirefoxDriver();
		        }
		        else if(BROWSER.equals("edge"))
		        {
		        	driver=new EdgeDriver();
		        }
		        else
		        {
		        	driver=new ChromeDriver();
		        }
		        
		        
		 //Step 1:  login to app
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		        driver.get(URL);
		        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		        driver.findElement(By.id("submitButton")).click();
		       
		   //step 2:navigate to organization module
		        driver.findElement(By.linkText("Organizations")).click();
		        
		     //step 3 :click on "create Organization" Button
		        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		        
		        //step 4: enter all details and create new organization
		        driver.findElement(By.name("accountname")).sendKeys(orgname);
		       WebElement ele1 = driver.findElement(By.xpath("//select[@name='industry']"));
		       Select s=new Select(ele1);
		       s.selectByVisibleText(industry);
		       
		       WebElement ele2 = driver.findElement(By.xpath("//select[@name='accounttype']"));
		       Select s1=new Select(ele2);
		      s1.selectByVisibleText(type);
		       
		       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		        
		        //verify industry and type info
		       String actualindustry = driver.findElement(By.id("dtlview_Industry")).getText();
		       if(actualindustry.equals(industry))
		       {
		    	   System.out.println(industry+" information is verified===PASS");
		       }else
		       {
		    	   System.out.println(industry+" information is not verified===FAIL");
		       }
		       String actualText = driver.findElement(By.id("dtlview_Type")).getText();
		       if(actualText.equals(type))
		       {
		    	   System.out.println(type+" information is verified===PASS");
		       }else
		       {
		    	   System.out.println(type+" information is not verified===FAIL");
		       } 
		       
		       
		       
		        //Step 5: logout
		        WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		        Actions a=new Actions(driver);
		        a.moveToElement(ele).perform();
		        driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		        
		      driver.quit();
		        

	}

}
