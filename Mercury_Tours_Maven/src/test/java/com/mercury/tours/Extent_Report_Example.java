package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Extent_Report_Example {
	//Builds a New Report using 
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	//helps to generate the logins in test report
	ExtentTest test;
	
	ChromeDriver driver;
  @Test(priority=2)
  public void SignOn() {
	  test=extent.createTest("Test Case 2","Login to Mercury Applications");
	  
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
	
		
  }
  @Test(priority=1)
  public void LaunchBrowser() {
	  test=extent.createTest("Test Case 1","Login to Mercury Applications");
	  String absolutepath = System.getProperty("user.dir");
		//String filepath = absolutepath+"\\chromedriver.exe";
		String filepath = absolutepath+"\\Drivers"+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filepath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercurysignon.php");
  }

  @BeforeTest()
  public void startReport(){
	  //initialize the Html Reporter
	  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/testReport.html");
	  
	  //initialize Extent Reports and attach the Html Reporter
	  extent = new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  
	  //To add system or Environment info by using the set SystemInfo method
	  extent.setSystemInfo("OS","Window 10");
	  extent.setSystemInfo("Browser","Chrome 60+");
	  
	  //Configuration items to change the look and feel
	  //add content, manage tests etc
	  htmlReporter.config().setDocumentTitle("Extent Reprt Demo");
	  htmlReporter.config().setReportName("Test Report");
	  htmlReporter.config().setTheme(Theme.STANDARD);
	  htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy,hh:mm a'('ZZZ')'");;
	  
	  
  }
  
  @AfterMethod
  public void getResult(ITestResult result){
	  if(result.getStatus() == ITestResult.FAILURE){
		  test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED", ExtentColor.RED));
		  test.fail(result.getThrowable());
		  
	  }
	  else if(result.getStatus() == ITestResult.SUCCESS){
		  test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"PASSED", ExtentColor.GREEN));
	  
	  }
	  else{
		  test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"SKIPPED", ExtentColor.ORANGE));
		  test.skip(result.getThrowable());
	  }
  }
  
  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
	  extent.flush();
  }

}
