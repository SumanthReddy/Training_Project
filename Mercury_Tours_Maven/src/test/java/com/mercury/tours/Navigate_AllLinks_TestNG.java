package com.mercury.tours;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Navigate_AllLinks_TestNG {
	ChromeDriver driver;
  @Test
  public void SignOn(){
	  List<WebElement> linksize = driver.findElementsByTagName("a");
	  int linksCount = linksize.size();
	  System.out.println("Total no of links Available:"+ linksCount);
	  String[] links = new String[linksCount];
	  System.out.println("List of Links Available");
	  
	  //print all the links from webpage
	  for(int i=0;i<linksCount;i++){
		  links[i] = linksize.get(i).getAttribute("href");
		  System.out.println(links[i]);
	  }
	  //navigate to eachlink on webpage
	  for(int i=0;i<linksCount;i++){
		  driver.navigate().to(links[i]);
		  System.out.println(driver.getTitle());
		  driver.navigate().back();
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
		driver.get("https://www.google.com/");
  }

  @AfterTest
  public void CloseBrowser() {
	driver.quit();
 }

}
