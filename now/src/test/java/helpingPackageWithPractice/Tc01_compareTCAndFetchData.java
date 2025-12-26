package helpingPackageWithPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Tc01_compareTCAndFetchData {
	@Test
	public void toFetchDataFromExcel() throws IOException {
	    String expectedTc = "tc01", data1 = "", data2 = "";
	    boolean flag = false;

	    FileInputStream fis = new FileInputStream("./TestData/Tek_data.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet("example");

	    int rowCount = sh.getLastRowNum();

	    for (int i = 1; i < rowCount; i++) {
	        String data = sh.getRow(i).getCell(0).toString();

	        if (data.equalsIgnoreCase(expectedTc)) {
	            flag = true;
	            data1 = sh.getRow(i).getCell(1).toString();
	            data2 = sh.getRow(i).getCell(2).toString();
	            break; 
	        }
	    }
	    wb.close();

	    if (flag) {
	        System.out.println(data1);
	        System.out.println(data2);
	    } else {
	        System.out.println("TC NOT FOUND");
	    }
	}
}
