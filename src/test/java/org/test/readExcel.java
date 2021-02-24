package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcel {
	
	public static void main(String[] args) throws IOException {
		
		File f = new File("C:\\Users\\I2376\\Documents\\Eclips Learning\\Sample Programs\\ReadExcelData\\TestData\\Registration Details.xlsx");
		
		FileInputStream file = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(file);
		
		Sheet s = w.getSheet("TestData");
		
		int count = s.getPhysicalNumberOfRows();
//		System.out.println(count);
		
		for (int i = 0; i < count; i++) {
			
			Row row = s.getRow(i);
			
			int physicalNumberOfCells = row.getPhysicalNumberOfCells();
//			System.out.println(physicalNumberOfCells);
			
			for (int j = 0; j < physicalNumberOfCells; j++) {
				
				Cell cell = row.getCell(j);
				int cellType = cell.getCellType();
				
				if (cellType==1) {
					
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
				}
				if (cellType==0) {
					if (DateUtil.isCellDateFormatted(cell)) {
						String name = new SimpleDateFormat("dd-MMM-yy").format(cell.getDateCellValue());
						System.out.println(name);
						
						}
					else {
						String name = String.valueOf((long)cell.getNumericCellValue());
						System.out.println(name);
					}
				}
				
				
			}
		}
		
	}

}
