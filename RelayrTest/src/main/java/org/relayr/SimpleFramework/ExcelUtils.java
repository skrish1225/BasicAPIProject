package org.relayr.SimpleFramework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	
	/**
	 * Gets the entire column
	 * Example:
	 *  ArrayList<String> ar = new ArrayList<String>();
       ar = ex.GetExcelColumn("C:\\Users\\4984356\\Desktop\\TestExcelFile.xlsx", "Sheet1", "Add");
      
	 * @param filePath
	 * @param sheetName
	 * @param columnName
	 * @return
	 * @throws IOException
	 */
	public ArrayList<String> GetExcelColumn(String filePath, String sheetName, String columnName) throws IOException {

		FileInputStream inputstream = new FileInputStream(filePath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		
		int columns = sheet.getRow(0).getLastCellNum();
		
		ArrayList<String> columnValues = new ArrayList<String>();
		
		for(int i=0;i<columns;i++) {
			if(sheet.getRow(0).getCell(i).getStringCellValue().contentEquals(columnName)) {
				
				for(int j=1;j<=rows;j++) {
					
					try {
					columnValues.add(sheet.getRow(j).getCell(i).getStringCellValue());
					}catch (Exception e) {
						String dblCnvrtdToStr = Double.toString(sheet.getRow(j).getCell(i).getNumericCellValue());
						columnValues.add(dblCnvrtdToStr);
					}
										
				}
			}
		}
		workbook.close();
		return columnValues;
		
	}

	

}
