package practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
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

public class CreateContactWithSupportDateTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
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
		      Sheet sh = wb.getSheet("contact");
		         Row rw = sh.getRow(1);
		        String lastname= rw.getCell(2).toString()+randomInt;
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
		        driver.findElement(By.linkText("Contacts")).click();
		        
		     //step 3 :click on "create Organization" Button
		        driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		        
		        //step 4: enter all details and create new organization
		        Date d=new Date();
		        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		        String startdate=sim.format(d);
		        Calendar cal=sim.getCalendar();
		        cal.add(Calendar.DAY_OF_MONTH, 30);
		        String enddate=sim.format(cal.getTime());
		        
		        
		        driver.findElement(By.name("lastname")).sendKeys(lastname);
		        driver.findElement(By.name("support_start_date")).clear();
		        driver.findElement(By.name("support_start_date")).sendKeys(startdate);
		        
		        driver.findElement(By.name("support_end_date")).clear();
		        driver.findElement(By.name("support_end_date")).sendKeys(enddate);
		        

		        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		        
		        //verify Header message  expected result
		        String actualstartdate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
		        if(actualstartdate.contains(startdate))
		        {
		        	System.out.println(startdate+" information verified ==== PASS");
		        	
		        }
		        else
		        {
		        	System.out.println(startdate +" information is not  verified===FAIL");
		        }
		        String actualEnddate=driver.findElement(By.id("dtlview_Support End Date")).getText();
		        if(actualEnddate.contains(enddate))
		        {
		        	System.out.println(enddate+" information verified ==== PASS");
		        	
		        }
		        else
		        {
		        	System.out.println(enddate +" information is not  verified===FAIL");
		        }
		       
		        
		        //Step 5: logout
		        WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		        Actions a=new Actions(driver);
		        a.moveToElement(ele).perform();
		        driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		        
		      driver.quit();

	}

}
