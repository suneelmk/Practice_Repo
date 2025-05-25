package DDTpractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingMultipleDatawithConditionWithFlag {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		String condition="sunil";
		FileInputStream fis=new FileInputStream("C:\\Users\\HP\\Desktop\\ddt\\FacebookCredentials.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
         Sheet sh=wb.getSheet("Sheet1");
         boolean flag=false;
       int n= sh.getLastRowNum();
       String d1="";
       String d2="";
       String d3="";
       for(int i=1;i<=n;i++)
       {
    	  try {
    		  String d = sh.getRow(i).getCell(0).toString();
       	   if(d.equals(condition))
       	   {
       		   flag=true;
       		    d1 = sh.getRow(i).getCell(0).toString();
       		    d2 = sh.getRow(i).getCell(1).toString();
       		 d3 = sh.getRow(i).getCell(2).toString();
       	   }
    	  }
    	  catch(Exception e)
    	  {
    		  
    	  }
    	   
       }
       if(flag==true)
       {
       System.out.println(d1);
       System.out.println(d2);
       System.out.println(d3);
       }
       wb.close();

	}

}
