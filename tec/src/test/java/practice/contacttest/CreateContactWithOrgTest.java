package practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws IOException, InterruptedException {
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
				      Sheet sh = wb.getSheet("contact");
				         Row rw = sh.getRow(7);
				        String orgname= rw.getCell(2).toString()+randomInt;
				        String contactLastname=rw.getCell(3).getStringCellValue();
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
				        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				        
				        //verify Header message  expected result
//				        String headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//				        if(headerinfo.contains(contactLastname))
//				        {
//				        	System.out.println(contactLastname+"header verified ==== PASS");
//				        	
//				        }
//				        else
//				        {
//				        	System.out.println(contactLastname +" header verified===FAIL");
//				        }
				        
				        
				        
						   //step 5:navigate to contact module
						        driver.findElement(By.linkText("Contacts")).click();
						        
						     //step 6 :click on "create contact" Button
						        driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
						        
						        //step 7: enter all details and create new contacts
						        driver.findElement(By.name("lastname")).sendKeys(contactLastname);
						        driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
						        //switch to child window
						           Set<String> set = driver.getWindowHandles();
						           Iterator<String> it=set.iterator();
						           while(it.hasNext())
						           {
						        	   String windowID=it.next();
						        	   driver.switchTo().window(windowID);
						        	   String actUrl=driver.getCurrentUrl();
						        	   if(actUrl.contains("module=Accounts"))
						        	   {
						        		   break;
						        	   }
						           }
						        driver.findElement(By.name("search_text")).sendKeys(orgname);
						        driver.findElement(By.name("search")).click();
						        driver.findElement(By.xpath("//a[.='"+orgname+"']")).click();
						       
						        
						        
						        //switch to parent window
						        Set<String> set1 = driver.getWindowHandles();
						           Iterator<String> it1=set.iterator();
						           while(it.hasNext())
						           {
						        	   String windowID=it.next();
						        	   driver.switchTo().window(windowID);
						        	   String actUrl=driver.getCurrentUrl();
						        	   if(actUrl.contains("Contacts&action"))
						        	   {
						        		   break;
						        	   }
						           }
						           driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
						        //verify Header message  expected result
						          
						         String headerinfo=driver.findElement(By.id("dtlview_Last Name")).getText();
						        if(headerinfo.contains(orgname))
						        {
						        	System.out.println(orgname+" information verified ==== PASS");
						        	
						        }
						        else
						        {
						        	System.out.println(orgname +" information is not  verified===FAIL");
						        }
						        String actOrgname=driver.findElement(By.id("mouseArea_Organization Name")).getText();
						        if(actOrgname.trim().contains(orgname))
						        {
						        	System.out.println(orgname+" information verified ==== PASS");
						        	
						        }
						        else
						        {
						        	System.out.println(orgname +" information is not  verified===FAIL");
						        }
				        
				        
				        
				        
				        //Step 5: logout
				        WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				        Actions a=new Actions(driver);
				        a.moveToElement(ele).perform();
				        driver.findElement(By.xpath("//a[.='Sign Out']")).click();
				        
				      driver.quit();
				        

	}

}
