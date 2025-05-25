package practice.testng;

import org.testng.annotations.Test;

public class ContactTest {      //class name should end with test 
	                           //class name is preferred to give as module name
	                           //in real time we keep maximum 10 to 15 test case in a class
	@Test 
	public void createContactTest()
	{
		System.out.println("Execute createContactTest");
	}
	
	@Test
	public void createContactWithPhoneNumberTest()  //method name should end with test
	                                                 //as per the rule of automation method name is written same as manual test case name
	                                                 
	{
		System.out.println("Execute createContactWithPhoneNumber");
	}
	
	//this wont get executed as @test is not written .
	//whenever we execute testng class java interpreter looks for @test for execution
//in the below method @test is not mentioned so it is treated as just a method
	//only above 2 methods will get executed
	
	
	//As per the rule @Test method return type should be void and if return type is changed then that method wont get executed 
	//As per the rule @Test method access specifier is advised to use as public
	public void createaccount()
	{
		System.out.println("account created");
	}
	
	//if we have 3000tc instead of writing 3000 class with main method we can devide test case based on modules and scenarios and optimise the classes.
	//because in java main method we can write 1 tc and execute 

}
