package com.mercury.tours;

import org.testng.annotations.DataProvider;

public class ApplicationTestData {

	@DataProvider(name = "Login")
	public Object[][] getDataFromDataprovider() {

		return new Object[][] {

				{ "testing", "testing" }, { "dixit", "dixit" }, { "testabhi", "testabhi" } };
	}



//-------------------------This is to read XLS Data-------------------------------

@DataProvider(name = "LoginDataXls")
public Object[][] ExcelXLS() throws Exception{
	ReadExcel_XLS excel = new ReadExcel_XLS();
	Object[][] testObjArray = excel.getExcelData("C:\\Selenium_Training\\Workspace\\Mercury_Tours_Maven\\Mercury_Tours.xls", "Sign_On");
	System.out.println(testObjArray);
	return testObjArray;
}



//--------------------------This is to read XLSX Data-----------------------------------


@DataProvider(name = "LoginDataXlsx")
public Object[][] ExcelXLSX() throws Exception{
	ReadExcel_XLSX excel = new ReadExcel_XLSX();
	Object[][] testObjArray = excel.getExcelData("C:\\Selenium_Training\\Workspace\\Mercury_Tours_Maven\\Mercury_Tours.xlsx", "Sign_On");
	System.out.println(testObjArray);
	return testObjArray;
}
}