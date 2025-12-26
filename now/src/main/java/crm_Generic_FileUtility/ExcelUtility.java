package crm_Generic_FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getExcelFile(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fisExcel = new FileInputStream("./TestData/Tek_data.xlsx");
	Workbook wb = WorkbookFactory.create(fisExcel);
	String data = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
	wb.close();
	return data;
}
	public int getRowCount(String sheetName) throws Throwable, IOException {
		FileInputStream fisExcel = new FileInputStream("./TestData/Tek_data.xlsx");
		Workbook wb = WorkbookFactory.create(fisExcel);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	public void setDataIntoExcel(String sheetName, int rownum, int celNum, String data) throws Throwable, IOException {
		FileInputStream fisExcel = new FileInputStream("./TestData/Tek_data.xlsx");
		Workbook wb = WorkbookFactory.create(fisExcel);
		wb.getSheet(sheetName).getRow(rownum).createCell(celNum);
		
		FileOutputStream fos = new FileOutputStream("./TestData/Tek_data.xlsx");
		wb.write(fos);
		wb.close();
	}
}