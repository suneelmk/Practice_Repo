package practice.testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
   
	
	public ExtentReports report;
	@BeforeSuite
	public void configBS()
	{
		ExtentSparkReporter spark=new ExtentSparkReporter("./advanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM");
		spark.config().setTheme(Theme.DARK);
		
		
		//add environment info and create test
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}
	
	@AfterSuite
	public void configAS()
	{
		report.flush();
	}
	
	
	@Test
	public void createContactTest() {
		//spark report config
		
		ExtentTest test = report.createTest("createContactTest");
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact created");
		} else {
			test.log(Status.FAIL,"contact is not created");
		}
		
		report.flush();
		
	}
	@Test
	public void createContactWithORGTest() {
		//spark report config
		
		ExtentTest test = report.createTest("createContactWithORGTest");
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact created");
		} else {
			test.log(Status.FAIL,"contact is not created");
		}
		
	
		
	}
	@Test
	public void createContactWithPhoneNumberTest() {
		//spark report config
		
		ExtentTest test = report.createTest("createContactWithPhoneNumberTest");
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact created");
		} else {
			test.log(Status.FAIL,"contact is not created");
		}
		
		
		
	}
}
