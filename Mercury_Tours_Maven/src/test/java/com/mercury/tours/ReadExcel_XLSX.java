package com.mercury.tours;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel_XLSX {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	
	//This method is to read the test data from excel
	public String[][] getExcelData(String fileName, String sheetName) throws EncryptedDocumentException, IOException{
	String[][] arrayExcelData = null;
	FileInputStream ExcelFile = new FileInputStream(fileName);
	ExcelWBook = new XSSFWorkbook(ExcelFile);
	ExcelWSheet = ExcelWBook.getSheet(sheetName);
	//System.out.println(ExcelWSheet);
	int totalNoOfRows = ExcelWSheet.getLastRowNum();
	int totalNoOfCols_0 = ExcelWSheet.getRow(0).getLastCellNum();
	arrayExcelData = new String [totalNoOfRows][totalNoOfCols_0];
	for(int i=0; i<totalNoOfRows; i++){
		int totalNoOfCols = ExcelWSheet.getRow(0).getLastCellNum();
		//arrayExcelData = newString [totalNoOfRows][totalNoOfCols];
		for (int j=0; j<totalNoOfCols; j++){
			arrayExcelData[i][j] = ExcelWSheet.getRow(i+1).getCell(j).getStringCellValue();
			//System.out.println(arrayExcelData[i][j]);
			
		}
	}
	System.out.println(arrayExcelData);
	return arrayExcelData;

}
}