package com.andoorathodi.MavenAugust2023.TestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetExcelData {

	public ArrayList<String> getExcelSheetData(String sheetName, String testCaseName) throws IOException {

		ArrayList<String> al = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("/Users/Nabeel/Documents/Boy Names.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheetCount = workbook.getNumberOfSheets();

		for (int i = 0; i < sheetCount; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {

				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();

				Iterator<Cell> cells = firstRow.cellIterator();

				int k = 0;
				int col = 0;

				while (cells.hasNext()) {

					Cell cellValue = cells.next();
					if (cellValue.getStringCellValue().equalsIgnoreCase("TestCaseName")) {

						col = k;
						break;
					}
					k++;
				}

				while (rows.hasNext()) {

					Row r = rows.next();

					if (r.getCell(col).getStringCellValue().equalsIgnoreCase(testCaseName)) {

						Iterator<Cell> cell = r.cellIterator();
						while (cell.hasNext()) {

							Cell Value = cell.next();
							if (Value.getCellType() == CellType.STRING) {

								al.add(Value.getStringCellValue());
							} else {

								String text = NumberToTextConverter.toText(Value.getNumericCellValue());
								al.add(text);
							}
						}

					}
				}
			}
		}

		return al;
	}

}
