package com.andoorathodi.MavenAugust2023.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExcel {
	DataFormatter  formatter = new DataFormatter();

	@Test(dataProvider = "driveTest")
	public void sample(String name, String testcasename, String username, String password) {

		System.out.println(name + " : " + testcasename + " : " + username + " : " + password);

	}
	
	@DataProvider(name="driveTest")
	public Object[][] getData() throws IOException {
		
		
		
		FileInputStream fis = new FileInputStream("/Users/Nabeel/Documents/Boy Names.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		System.out.println(sheet.getSheetName());
		
 
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Row count is  "+rowCount);
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		
		Object data[][] = new Object[rowCount-1][colCount];
		System.out.println("Col count is "+colCount);
		
		for(int i=0; i<rowCount-1;i++) {
		
			row=sheet.getRow(i+1);
	 
			for(int j=0; j<colCount; j++) {
				XSSFCell cell =row.getCell(j);
			data[i][j]=	formatter.formatCellValue(cell);
		 
			}
			 

		}
		
		return data;
	}

}
