package com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseTest {
	WebDriver dr;
	
	@Parameters({"browser", "url"})
	@BeforeMethod (groups = "ui")
	public void beforeMethod(String b, String u) {

		System.out.println("BM");
		
		if(b.equals("Chreme")) {
			dr = new ChromeDriver();
			
		}else if(b.equals("Firefox")) {
			dr = new FirefoxDriver();
		}
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult r) {
    
		switch (r.getStatus()) {
		case ITestResult.SUCCESS:{
			
			System.out.println(r.getName() + " is Passed");
			
		}
		case ITestResult.FAILURE:{
			System.out.println(r.getName() + " is Failed");
			System.out.println("Took ScreenShoot");
		}
		case ITestResult.SKIP:{
			System.out.println(r.getName() + " is Skiped");
	   Reporter.log(r.getName()) ;
		}

		}
		
		System.out.println("AM");
	}

	@BeforeClass (enabled = false)
	public void beforeClass() {

		System.out.println("BC");
	}

	@AfterClass
	public void afterClass() {

		System.out.println("AC");
	}

	@BeforeTest
	public void beforeTest() {

		System.out.println("BT");
	}

	@AfterTest
	public void afterTest() {

		System.out.println("AT");
	}

	@BeforeSuite
	public void beforeSuite() {

		System.out.println("BS");
	}

	@AfterSuite
	public void afterSuite() {

		System.out.println("AS");
	}

}
