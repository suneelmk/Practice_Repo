package practice.hometest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BasicReporting_Reporter {

	// we get execution steps in olny html report and not in eclipse console
//	@Test
//	public void homePageTest(Method mtd) {
//		Reporter.log(mtd.getName() + "Test start");
//		SoftAssert s = new SoftAssert();
//		Reporter.log("s1");
//		Reporter.log("s2");
//		Reporter.log("s3");
//		Reporter.log("s4");
//		Reporter.log(mtd.getName() + "Test end");
//	}
//
//	@Test
//	public void verifyHomePagetest(Method mtd) {
//		Reporter.log(mtd.getName() + "Test start");
//		Reporter.log("s1");
//		Reporter.log("s2");
//		Reporter.log("s3");
//		Reporter.log("s4");
//		Reporter.log(mtd.getName() + "Test end");
//
//	}
	
	//execution statement print in both html report and eclipse console
	@Test
	public void homePageTest(Method mtd) {
		Reporter.log(mtd.getName() + "Test start");
		SoftAssert s = new SoftAssert();
		Reporter.log("s1",true);
		Reporter.log("s2",true);
		Reporter.log("s3",true);
		Reporter.log("s4",true);
		Reporter.log(mtd.getName() + "Test end");
	}

	@Test
	public void verifyHomePagetest(Method mtd) {
		Reporter.log(mtd.getName() + "Test start");
		Reporter.log("s1",true);
		Reporter.log("s2",true);
		Reporter.log("s3",true);
		Reporter.log("s4",true);
		Reporter.log(mtd.getName() + "Test end");

	}

}
