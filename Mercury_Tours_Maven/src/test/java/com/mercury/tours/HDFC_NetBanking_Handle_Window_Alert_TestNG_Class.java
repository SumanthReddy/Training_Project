package com.mercury.tours;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HDFC_NetBanking_Handle_Window_Alert_TestNG_Class {
	ChromeDriver driver;

	@Test
	public void SignOn() {
		driver.switchTo().frame("login_page");
		// driver.findElementByCssSelector("input[name='fldLoginUserId']").sendKeys("7643");
		driver.findElementByCssSelector("img[alt='continue']").click();
		// driver.switchTo().defaultContent();
		String ActTest = driver.switchTo().alert().getText();
		String ExpTest = "Customer ID  cannot be left blank.";
		Assert.assertEquals(ActTest, ExpTest);
		driver.switchTo().alert().accept();
	}

	@BeforeTest
	public void LaunchBrowser() {
		String absolutepath = System.getProperty("user.dir");
		// String filepath = absolutepath+"\\chromedriver.exe";
		String filepath = absolutepath + "\\Drivers" + "\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filepath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"https://netbanking.hdfcbank.com/netbanking/?_ga=2.196993455.2080416260.1577171521-881767994.1577171521");
	}

	/*
	 * @AfterTest public void CloseBrowser() { driver.quit(); }
	 */

}
