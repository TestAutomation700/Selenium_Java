package com.seleniumframework.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	public static FileInputStream fileinput;

	public void browserSetUp() throws IOException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		// ---------------------- customizing the browser launch options ---------------------

		options.addArguments("start-maximized");
		options.addArguments("--disable-notifications");
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); // declaring the wait-time globally

		System.out.println(TestBase.propLoad().getProperty("url"));
		driver.get(TestBase.propLoad().getProperty("url"));

	}

	public void tearDown() {
		driver.quit();
	}

	public static Properties propLoad() throws IOException {

		String path = "C:\\Users\\0035G3744\\eclipse-workspace\\demo\\application.properties";

		fileinput = new FileInputStream(path);

		Properties prop = new Properties();
		prop.load(fileinput);
		return prop;

	}
	
	public static void takeSnapShot(WebDriver webdriver,String filepath) {
		
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(filepath);
		try {
		FileUtils.copyFile(SrcFile, DestFile);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
