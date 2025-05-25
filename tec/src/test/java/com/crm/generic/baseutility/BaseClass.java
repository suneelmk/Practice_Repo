package com.crm.generic.baseutility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	@BeforeSuite
	public void configBS() {
		System.out.println("===connect to db, report config===");
	}

	@BeforeClass
	public void configBC() {
		System.out.println("launch browser");
	}

	@BeforeMethod
	public void configBM() {
		System.out.println("login to app");
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("logout to app");
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
