package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName, int rownum, int celnum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./testdata/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rownum).getCell(celnum).getStringCellValue();
		return data;	
	}
	
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./testdata/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetName).getLastRowNum();
		return rowcount;
	}
	
	public void setDataIntoExcel(String sheetName, int rownum, int celnum, String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./testdata/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rownum).createCell(celnum);
		
		FileOutputStream fos = new FileOutputStream("./testdata/TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}
	
	
	
}