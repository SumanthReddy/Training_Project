package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Mercury_Sign_On_getText_TestNG {
	ChromeDriver driver;
  @Test
  public void SignOn() throws InterruptedException {
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		WebElement element = driver.findElementByLinkText("SIGN-OFF");
		String ActValue = element.getText();
		String ExpValue = "SIGN-OFF";
		System.out.println(ActValue);
		Assert.assertEquals(ActValue, ExpValue);
		
		String ActTitle = driver.getTitle();
		String ExpTitle = "Find a Flight: Mercury Tours:"; 
		System.out.println(ActTitle);
		Assert.assertEquals(ActTitle, ExpTitle);
		
		String ActUrl = driver.getCurrentUrl();
		String ExpUrl = "http://newtours.demoaut.com/mercuryreservation.php";
		System.out.println(ActUrl);
		Assert.assertEquals(ActUrl, ExpUrl);
		
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
