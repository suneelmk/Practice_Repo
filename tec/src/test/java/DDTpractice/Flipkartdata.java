package DDTpractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Flipkartdata {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
	WebDriver driver=new FirefoxDriver();
	driver.get("https://www.flipkart.com/search?q=iphone+15+pro&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off&as-pos=1&as-type=HISTORY");
     List<WebElement> ele = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
//     for(WebElement ele1:ele)
//     {
//    	 System.out.println(ele1.getText());
//    }
     List<WebElement> ele3 = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
//     for(WebElement ele5:ele3)
//     {
//    	 System.out.println(ele5.getText());
//    }
     int n=ele.size();
//     for(int i=0;i<n;i++)
//     {
//    	 System.out.println(ele.get(i).getText()+" "+ele3.get(i).getText());
//     }
     
     FileInputStream fis= new FileInputStream("C:\\Users\\HP\\Desktop\\Flipkart.xlsx");
     Workbook wb=WorkbookFactory.create(fis);
    Sheet sh = wb.createSheet("Flip1");
    for(int i=0;i<n;i++)
    {
    	Row rw = sh.createRow(i);
    	rw.createCell(0).setCellValue(ele.get(i).getText());
    	rw.createCell(1).setCellValue(ele3.get(i).getText());
    }
    FileOutputStream fos= new FileOutputStream("C:\\Users\\HP\\Desktop\\Flipkart.xlsx");
    wb.write(fos);
    wb.close();
}
}

