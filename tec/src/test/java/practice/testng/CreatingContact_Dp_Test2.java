package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreatingContact_Dp_Test2 {

	@Test(dataProvider="getData")
	public void createContactTest(String firstname ,String lastname)
	{
		System.out.println("Firstname :"+firstname+",Lastname :"+lastname);
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr=new Object[3][2];
		objArr[0][0]="van";
		objArr[0][1]="dijk";
		
		objArr[1][0]="trent";
		objArr[1][1]="taa";
		
		objArr[2][0]="joe";
		objArr[2][1]="gomez";
		
		return objArr;
	}
	
	
	
}

