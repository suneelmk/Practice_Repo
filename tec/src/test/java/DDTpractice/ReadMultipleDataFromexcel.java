package DDTpractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromexcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\HP\\Desktop\\ddt\\FacebookCredentials.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
         Sheet sh=wb.getSheet("Sheet1");
       int n= sh.getLastRowNum();
       try {
       for(int i=1;i<=n;i++)
       {
    	   Row rw = sh.getRow(i);
    	        int x=rw.getLastCellNum();
    	        for(int k=0;k<x;k++)
    	        {
    	        	
    	        	System.out.println(rw.getCell(k).getStringCellValue());
    	        	
    	        }
       }
       }
       catch(Exception e)
       {
    	   
       }
       wb.close();
	}

}
