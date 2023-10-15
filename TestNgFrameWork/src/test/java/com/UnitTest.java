package com;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UnitTest extends BaseTest {

	@Test(groups = "smoke", priority = 1)
	public void logIn() {

		System.out.println("test2");
	}

	@Test(groups = "backend", priority = 2, dependsOnGroups = "login")
	public void logout() {

		System.out.println("test3");
	}

	@Test
	public void softTest() {

		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(3 > 5);
		System.out.println("continue");
		// softassert.assertFalse(5<3);

		softassert.assertAll();

		
	}
}