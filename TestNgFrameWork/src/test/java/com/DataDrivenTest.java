package com;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dv.DataSource;

public class DataDrivenTest {
	
	
	 @Test(dataProviderClass = DataSource.class, dataProvider = "xmlData")
	  public void f(String n, String s) {
		 
		 System.out.println(n);
		 System.out.println(s);
		 
	  }
	 
	 
}
