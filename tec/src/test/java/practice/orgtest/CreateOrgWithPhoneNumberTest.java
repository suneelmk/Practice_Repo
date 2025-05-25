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

public class CreateOrgWithPhoneNumberTest {

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
		         Row rw = sh.getRow(7);
		        String orgname= rw.getCell(2).toString()+randomInt;
		        String phonenumber=rw.getCell(3).getStringCellValue();
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
		        driver.findElement(By.id("phone")).sendKeys(phonenumber);
		        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		        
		        //verify phonenumber  expected result
		       String actualPhone=driver.findElement(By.id("dtlview_Phone")).getText();
		        if(actualPhone.equals(phonenumber))
		        {
		        	System.out.println(phonenumber+" information is created==PASS");
		        }
		        else
		        {
		        	System.out.println(phonenumber+" information is not created==PASS");
		        }
		        //Step 5: logout
		        WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		        Actions a=new Actions(driver);
		        a.moveToElement(ele).perform();
		        driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		        
		      driver.quit();
		        

	}

}
