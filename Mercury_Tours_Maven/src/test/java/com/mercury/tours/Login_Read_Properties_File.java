package com.mercury.tours;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Login_Read_Properties_File {
	ChromeDriver driver;
	
	 String absolutepath = System.getProperty("user.dir");
		//String filepath = absolutepath+"\\chromedriver.exe";
		String filepath = absolutepath+"\\Mercury_Tours.properties";
	File file = new File(filepath);
	  Properties prop = new Properties();
  @Test
  public void SignOn() throws IOException {
	   
	  FileInputStream fileinput = new FileInputStream(file);
	  prop.load(fileinput);
	  
	  
	  
	  driver.findElementByLinkText(prop.getProperty("lsignon")).click();
	  driver.findElementByName(prop.getProperty("Iusername")).sendKeys("testing");
	  driver.findElementByName(prop.getProperty("Iuserpass")).sendKeys("testing");
	  driver.findElementByName(prop.getProperty("Isubmit")).click();
		
		
  }
  @BeforeTest
  public void LaunchBrowser() throws IOException {
	  
	  
	  FileInputStream fileinput = new FileInputStream(file);
	  prop.load(fileinput);
	  String absolutepath = System.getProperty("user.dir");
		//String filepath = absolutepath+"\\chromedriver.exe";
		String filepath = absolutepath+"\\Drivers"+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filepath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
