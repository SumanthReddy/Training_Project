package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Sign_On_ReadXLS extends ApplicationTestData {
	ChromeDriver driver;
	
  @Test(dataProvider = "LoginDataXls")
  public void SignOn(String Username, String  Userpass) throws InterruptedException {
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys(Username);
		driver.findElement(By.name("password")).sendKeys(Userpass);
		driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("SIGN-OFF")).click();
		
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
