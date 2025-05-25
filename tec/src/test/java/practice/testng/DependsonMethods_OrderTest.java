package practice.testng;

import org.testng.annotations.Test;

public class DependsonMethods_OrderTest {

	
	@Test
	public void createOrderTest()
	{
		System.out.println("execute createOrderTest");
	}
	 
	
	@Test(dependsOnMethods = "createOrderTest")
	public void billingAnOrderTest()
	{
		System.out.println("execute billingAnOrderTest");
	}
	
}
