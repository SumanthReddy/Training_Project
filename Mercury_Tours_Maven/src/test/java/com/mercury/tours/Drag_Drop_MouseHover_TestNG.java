package com.mercury.tours;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Drag_Drop_MouseHover_TestNG {
	ChromeDriver driver;
  @Test
  public void SignOn() throws InterruptedException {
	  Actions action = new Actions(driver);
	  WebElement drag = driver.findElementById("draggable");
	  WebElement drop = driver.findElementById("droppable");
	  action.dragAndDrop(drag, drop).build().perform();
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
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
  }

  @AfterTest
  public void CloseBrowser() {
	driver.quit();
 }

}
