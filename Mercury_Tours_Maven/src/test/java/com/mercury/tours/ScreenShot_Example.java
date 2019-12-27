package com.mercury.tours;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ScreenShot_Example {
	ChromeDriver driver;
	String absolutepath = System.getProperty("user.dir");
	String filepath = absolutepath+"\\ScreenShots";
  @Test
  public void SignOn() throws InterruptedException {
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("loginss")).click();	
  }
  
  @AfterMethod
  public void ScreenShot(ITestResult result) throws IOException
  {
	  if(ITestResult.FAILURE==result.getStatus())
	  {
		  File Browerscreenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  //FileUtils.copyFile(Browerscreenshot, new File("C:\\Selenium_Training\\Workspace\\Mercury_Tours_Maven\\ScreenShots\\login.png"));
	 FileUtils.copyFile(Browerscreenshot, new File(filepath +"/"+result.getName()+"_"+System.nanoTime()+".png"));
	  }
  }
  
  @BeforeTest
  public void LaunchBrowser() {
	  String absolutepath = System.getProperty("user.dir");
		//String filepath = absolutepath+"\\chromedriver.exe";
		String filepath = absolutepath+"\\Drivers"+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filepath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercurysignon.php");
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
