package com.crm.genericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Surendra
 *
 */
public class CommonUtils {
	static String excelPath="./src/test/resources/testData.xlsx";
	static String propertyPath="./src/test/resources/commonData.properties";
	
/**
 * 
 * @param sheetName, rowNum, cellNum
 * @return return data from excel sheet
 * @throws Throwable
 * used to read the data from excel 
 */
	public static String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis=new FileInputStream(excelPath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		String data=row.getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}

/**
 * 
 * @param sheetName, rowNum, cellNum, result
 * @throws Throwable
 * used to write the data to excel
 */
	public static void setExcelData(String sheetName,int rowNum,int cellNum,String result) throws Throwable
	{
		FileInputStream fis=new FileInputStream(excelPath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet st=wb.getSheet(sheetName);
		Row row=st.getRow(rowNum);
		Cell cell=row.createCell(cellNum);
		cell.setCellValue(result);
		
		FileOutputStream fos=new FileOutputStream(excelPath);
		wb.write(fos);
		wb.close();
	}
	
/**
 * 
 * @return return properties object
 * @throws Throwable
 * used to get the data from properties file
 */
	public static Properties getPropertiesObj() throws Throwable
	{
		FileInputStream fis=new FileInputStream(propertyPath);
		Properties pObj=new Properties();
		pObj.load(fis);
		return pObj;
	}
}
