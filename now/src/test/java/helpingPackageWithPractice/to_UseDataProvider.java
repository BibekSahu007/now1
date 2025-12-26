package helpingPackageWithPractice;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import crm_Generic_FileUtility.ExcelUtility;

public class to_UseDataProvider {
@DataProvider
public Object[][] getdata() throws IOException, Throwable{
	ExcelUtility eu=new ExcelUtility();
	int rowCount = eu.getRowCount("DataPro");
	Object[][] ob=new Object[rowCount][2];
	for(int i=0; i<rowCount;i++) {
		ob[i][0]=eu.getExcelFile("DataPro", i+1, 0);
		ob[i][1]=eu.getExcelFile("DataPro", i+1, 1);

	}
	return ob;
}
}
