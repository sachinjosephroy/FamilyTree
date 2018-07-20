package com.familytreenow.qa.util;

import java.io.File;
import java.io.FileInputStream;

/*import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;*/

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	public static String Test_Data = "C:\\Users\\Sachin Roy\\eclipse-workspace\\Familytreenow\\src\\main\\java\\com\\familytreenow\\qa\\testdata\\TestData.xlsx";
	/*static Workbook book;
	static Sheet sheet;*/
	static XSSFWorkbook book;
	static XSSFSheet sheet;
	
	public static Object[][] testData(String sheetname) {
		try {
			File src = new File(Test_Data);
			FileInputStream fis = null;
			fis = new FileInputStream(src);
			//book = WorkbookFactory.create(fis);
			book = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}

}
