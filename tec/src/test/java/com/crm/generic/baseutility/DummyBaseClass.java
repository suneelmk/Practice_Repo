package com.crm.generic.baseutility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class DummyBaseClass {
	
	@BeforeSuite
	public void configBS() {
		System.out.println("===connect to db, report config===");
	}
 
	@BeforeSuite
	public void configBS1() {
		System.out.println("===connect to db1, report config1===");
	}
	@BeforeClass
	public void configBC() {
		System.out.println("launch browser");
	}
 
	@BeforeClass
	public void configBC1() {
		System.out.println("launch browser1");
	}
	@BeforeMethod
	public void configBM() {
		System.out.println("login to app");
	}
	
	@BeforeMethod
	public void configBM1() {
		System.out.println("login to app1");
	}
	@AfterMethod
	public void configAM() {
		System.out.println("logout to app");
	}
	@AfterMethod
	public void configAM1() {
		System.out.println("logout to app1");
	}
	@AfterClass
	public void configAC() {
		System.out.println("close browser");
	}

	@AfterSuite
	public void configAS() {
		System.out.println("====close db, report backup====");
	}


}
