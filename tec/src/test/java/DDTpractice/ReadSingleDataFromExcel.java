package DDTpractice;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ReadSingleDataFromExcel {
	public static void main(String[] args) throws Throwable
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\HP\\Desktop\\ddt\\FacebookCredentials.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		  Sheet sh=wb.getSheet("Sheet1");
		  Row rw=sh.getRow(1);
		 Cell cel= rw.getCell(0);
		 String val=cel.getStringCellValue();
		 System.out.println(val);
		 wb.close();
		
	}

}
