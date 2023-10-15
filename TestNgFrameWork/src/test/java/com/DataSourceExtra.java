package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataSourceExtra {

	
	@DataProvider(name = "xmlData")
	public Object[][] getDataFromExelSheet() {

		FileInputStream file = null;

		XSSFWorkbook book = null;
		try {
			file = new FileInputStream(
					new File("/Users/manhamahdi/Desktop/Eclips documents/TestNgFrameWork/Data.xlsx"));
			book = new XSSFWorkbook(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File Not Found");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (book != null) {
				try {
					book.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}

		XSSFSheet sheet = book.getSheetAt(0);

		int rs = sheet.getLastRowNum();
		int cs = sheet.getRow(0).getLastCellNum();

		Object[][] object = new Object[rs][cs];

		for (int i = 1; i <= rs; i++) {
			for (int j = 1; j < +cs; j++) {

				XSSFCell cell = sheet.getRow(i).getCell(j);
				switch (cell.getCellType()) {
				case XSSFCell.CELL_TYPE_NUMERIC:
					object[i - 1][j] = cell.getNumericCellValue();

				case XSSFCell.CELL_TYPE_STRING:
					object[i - 1][j] = cell.getStringCellValue();
				}
			}
		}

		return object;

	}

}
