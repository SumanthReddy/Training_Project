package com.mercury.tours;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Mercury_Sign_On_Following_Preceeding_Sibling_TestNG_Class {
	ChromeDriver driver;
  @Test
  public void SignOn() throws InterruptedException {
	  //driver.findElement(By.linkText("SIGN-ON")).click();
		//driver.findElement(By.name("userName")).sendKeys("testing");
		//driver.findElement(By.name("password")).sendKeys("testing");
		//driver.findElement(By.name("login")).click();
	  //Following sibling
	 // driver.findElementByXPath("//td[@width='67']//following-sibling::td[1]/a").click();
	  Thread.sleep(6000);
	  
	  //Preceding sibling
	  driver.findElementByXPath("//td[@height='33']//preceding-sibling::td[2]/a").click();
	  Thread.sleep(6000);
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
