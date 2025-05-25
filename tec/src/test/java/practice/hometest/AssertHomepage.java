package practice.hometest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertHomepage {
	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName() + "Test start");
		SoftAssert s=new SoftAssert();
		System.out.println("s1");
		System.out.println("s2");
		Assert.assertEquals("home", "home");
		//Assert.assertEquals("hi", "hi");
		//Assert.assertEquals("hello", "hi");
		//s.assertEquals("hi", "hello");
		System.out.println("s3");
		s.assertEquals("Title", "Title1");
		System.out.println("s4");
       
		s.assertAll();
		System.out.println(mtd.getName()+ "Test end");
	}

	@Test
	public void verifyHomePagetest(Method mtd) {
		System.out.println(mtd.getName()+ "Test start");
		SoftAssert s=new SoftAssert();
		System.out.println("s1");
		System.out.println("s2");
		System.out.println("s3");
		//Assert.assertEquals("hello", "hello");
		s.assertTrue(true);
		System.out.println("s4");
		s.assertAll();;
		System.out.println(mtd.getName() + "Test end");

	}
}
