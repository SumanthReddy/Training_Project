package com.mercury.tours;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class UploadFile_RobotClass {
	ChromeDriver driver;
  @Test
  public void testUpload() throws InterruptedException {
	  String absolutepath = System.getProperty("user.dir");
	  String filepath = absolutepath+"\\Images\\christmas-feature_759.jpg";
	  System.out.println(filepath);
	  driver.findElementById("btnChooseFiles").click();
	  uploadFile(filepath);
	  Thread.sleep(10);
  }
	  public static void uploadFile(String fileLocation){
		  try{
			  //upload file through Robot API
			  StringSelection ss = new StringSelection(fileLocation);
			  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			  //native Key strokes for CTRL, V and ENTER keys
			  Robot robot = new Robot();
			  robot.delay(1000);
			  //Press CTRL+V
			  robot.keyPress(KeyEvent.VK_CONTROL);
			  robot.keyPress(KeyEvent.VK_V);
			  //Release CTRL+V
			  robot.keyRelease(KeyEvent.VK_CONTROL);
			  robot.keyRelease(KeyEvent.VK_V);
			  //Press ENTER
			  robot.delay(1000);
			  robot.keyPress(KeyEvent.VK_ENTER);
			  robot.keyRelease(KeyEvent.VK_ENTER);
			  robot.delay(1000);
		  } catch (Exception exp) {
			  exp.printStackTrace();
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
		driver.get("https://gofile.io/?t=uploadFiles");
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
