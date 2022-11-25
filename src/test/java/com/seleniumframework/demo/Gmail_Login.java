package com.seleniumframework.demo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;

public class Gmail_Login extends TestBase {

	
	LoginPage lp;

	@BeforeTest
	public void launchBrowser() throws IOException {
		browserSetUp();
	}

	@Test
	public void login() throws Exception {
		lp = new LoginPage(driver);
		lp.entercred();

	}

	@AfterTest
	public void logout() {
		tearDown();
	}
}
