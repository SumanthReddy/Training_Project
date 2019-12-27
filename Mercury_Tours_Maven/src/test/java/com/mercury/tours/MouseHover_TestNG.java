package com.mercury.tours;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MouseHover_TestNG {
	ChromeDriver driver;
  @Test
  public void SignOn() throws InterruptedException {
	  WebElement element = driver.findElementByXPath("//a[contains(text(),'My Account')]");
	  Actions action = new Actions(driver);
	  action.moveToElement(element).build().perform();
	  driver.findElementById("signInBtn").click();
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
		driver.get("https://www.yatra.com/");
  }

  @AfterTest
  public void CloseBrowser() {
	driver.quit();
 }

}
