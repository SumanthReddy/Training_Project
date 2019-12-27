package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class CrossBrowser_Example extends ApplicationTestData {
	WebDriver driver;
  @Test(dataProvider="Login")
  public void SignOn(String uname, String password) throws InterruptedException {
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		Thread.sleep(6000);
		driver.findElement(By.linkText("SIGN-OFF")).click();
}
@BeforeTest
@Parameters("browser")
public void LaunchBrowser(String browser) {
	if(browser.equalsIgnoreCase("Chrome")){
	  String absolutepath = System.getProperty("user.dir");
		//String filepath = absolutepath+"\\chromedriver.exe";
		String filepath = absolutepath+"\\Drivers"+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filepath);
		driver = new ChromeDriver();
	}
	
	else if(browser.equalsIgnoreCase("InternetExplorer")){
		  String absolutepath = System.getProperty("user.dir");
			//String filepath = absolutepath+"\\chromedriver.exe";
			String filepath = absolutepath+"\\Drivers"+"\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", filepath);
			driver = new InternetExplorerDriver();
		}
	else
	{
		System.out.println("Name is not Correct");
	}
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercurysignon.php");
}

@AfterTest
public void CloseBrowser() {
	  driver.quit();
}

}
