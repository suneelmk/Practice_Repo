package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreatingContact_Dp_Test {

	@Test(dataProvider="getData")
	public void createContactTest(String firstname ,String lastname,long phone)
	{
	System.out.println(firstname+lastname+phone);
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="van";
		objArr[0][1]="dijk";
		objArr[0][2]=9876543148l;
		
		objArr[1][0]="trent";
		objArr[1][1]="taa";
		objArr[1][2]=9876543194l;
		
		objArr[2][0]="joe";
		objArr[2][1]="gomez";
		objArr[2][2]=9876543704l;
		
		return objArr;
	}
	
	
	
}

