package practice.testng;

import org.testng.annotations.Test;

public class PriorityContactsTest {
//testng always executes based on alphabetical order if no parameters are used
	
	
	@Test(priority=1)
	public void createContactsTest()
	{
		System.out.println("execute CreateContactsTest");
	}
	
	@Test(priority=2)
	public void modifyContactsTest()
	{
		System.out.println("execute modifyContactsTest");
	}
	
	@Test(priority=3)
	public void deleteContactTest()
	{
		System.out.println("execute deleteContactTest");
	}
}
