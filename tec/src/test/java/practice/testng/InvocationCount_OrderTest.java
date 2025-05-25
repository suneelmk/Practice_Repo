package practice.testng;

import org.testng.annotations.Test;

public class InvocationCount_OrderTest {
	
	@Test(invocationCount=10)
	public void createOrderTest()
	{
		System.out.println("execute createOrderTest");
	}
	 
	
	@Test(enabled=false)
	public void billingAnOrderTest()
	{
		System.out.println("execute billingAnOrderTest");
	}

}
