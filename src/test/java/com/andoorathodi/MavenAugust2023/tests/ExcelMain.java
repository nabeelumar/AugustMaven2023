package com.andoorathodi.MavenAugust2023.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.andoorathodi.MavenAugust2023.TestComponents.GetExcelData;

public class ExcelMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		GetExcelData data = new GetExcelData();
		List<String> dataValue = data.getExcelSheetData("TestData", "Green");
		for(int i=0;i<dataValue.size();i++) {
			
			System.out.println(dataValue.get(i));
		}
		
	}

}
