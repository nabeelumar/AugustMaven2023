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

public class DataProviderExcelSample2 {
	
	DataFormatter formatter = new DataFormatter();
	@Test(dataProvider= "getData")
	public void tst(String name, String pwd) {
		
		System.out.println(name+" : "+pwd);
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		FileInputStream fis = new FileInputStream("/Users/Nabeel/Documents/Boy Names.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet  sheet = wb.getSheetAt(0);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i=0;i<rowCount-1;i++) {
			
			
			XSSFRow r =  sheet.getRow(i+1);
			
			for(int j=0; j<colCount;j++) {
				
				XSSFCell c = r.getCell(j);
				data[i][j] = formatter.formatCellValue(c);
			}
		}
		
	return data;	

}
}