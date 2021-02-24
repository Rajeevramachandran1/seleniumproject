package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateNewExcel {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		WebElement txtSearch = driver.findElement(By.id("twotabsearchtextbox"));
		txtSearch.sendKeys("iphone", Keys.ENTER);
		
		Thread.sleep(5000);
		
		File f = new File("C:\\Users\\I2376\\Documents\\Eclips Learning\\Sample Programs\\ExcelData\\TestData\\Data.xlsx");
		
		Workbook workbook = new XSSFWorkbook();
		Sheet newSheet = workbook.createSheet("Amazon");
		Row headingRow = newSheet.createRow(0);
		Cell headingCell = headingRow.createCell(0);
		headingCell.setCellValue("Product List");
		
		List<WebElement> lnkTexts = driver.findElements(By.xpath("//div[contains(@class,'s-result-item s-asin')]//span[@class='a-size-medium a-color-base a-text-normal']"));
		
			for (int i = 0; i < lnkTexts.size(); i++) {
			String text = lnkTexts.get(i).getText();
			Row newRow = newSheet.createRow(i+1);
			Cell newCell = newRow.createCell(0);
			newCell.setCellValue(text);
			System.out.println(text);
		}
			
			FileOutputStream file = new FileOutputStream(f);
			
			workbook.write(file);
			
			System.out.println("Completed..!!");
		
//		FileInputStream fileInput = new FileInputStream(f);
//		Workbook editWorkbook = new XSSFWorkbook(fileInput);
//		Sheet sheet = editWorkbook.getSheet("Amazon Data");
//		Row row = sheet.getRow(1);
//		Cell cell = row.getCell(0);
//		String stringCellValue = cell.getStringCellValue();
//		if(stringCellValue.equals("iphone")) {
//			cell.setCellValue("iphone 12");
//		}
//		FileOutputStream editFile = new FileOutputStream(f);
//		editWorkbook.write(editFile);
//		System.out.println("Completed..!!");
	}
}
