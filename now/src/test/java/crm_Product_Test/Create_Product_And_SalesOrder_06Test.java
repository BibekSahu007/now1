package crm_Product_Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import crm_Generic_FileUtility.ExcelUtility;
import crm_Generic_FileUtility.FileUtility;
import crm_generic_WebdriverUtility.JavaUtility;
import crm_generic_WebdriverUtility.WebDriverUtility;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.LoginPage;
import objectRepositoryUtility.OrgPage;
import objectRepositoryUtility.ProductPage;

public class Create_Product_And_SalesOrder_06Test {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility fu= new FileUtility();
		ExcelUtility eu= new ExcelUtility();
		JavaUtility ju= new JavaUtility();
		WebDriverUtility wu=new WebDriverUtility();

		String URL = fu.getPropertyFile("url");
		String Browser = fu.getPropertyFile("browser");
		String Username = fu.getPropertyFile("username");
		String Password = fu.getPropertyFile("password");
		
		int randomNo = ju.getRandomNumber();
		String orgName = eu.getExcelFile("Organization", 1, 0)+randomNo;
		String ProName = eu.getExcelFile("Product", 1, 1);
		String SubName = eu.getExcelFile("Product", 1, 1);
		String Baddress = eu.getExcelFile("Product", 1, 2);
		String Ssddress = eu.getExcelFile("Product", 1, 3);
		
		WebDriver driver=null;
		if(Browser.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else if (Browser.equals("Chrome")) {
			driver= new ChromeDriver();
		}

		LoginPage lp=new LoginPage(driver);
		lp.login(Username, Password, URL, wu);

		HomePage hp= new HomePage(driver);
		hp.clickOnOrgLink(driver, wu);
		
		OrgPage op=new OrgPage(driver);
		op.toSendOrgName(orgName);
		
		Thread.sleep(2000);
		hp.clickOnProductLink(driver, wu);
		ProductPage pp= new ProductPage(driver);
		pp.addProductAndSave(ProName);
		
		Thread.sleep(2000);
		hp.Sales_OrderLink();
		pp.selectOrgAndSendAddress(SubName, driver, wu, orgName, Baddress, Ssddress);
		
		String ProInfo =pp.proHeaderText();
		if(ProInfo.contains(ProName)) {
			System.out.println(ProName+" SalesOrder Is Ready");
		}
		else System.out.println(ProName+" SalesOrder Is Not Ready");
		
		hp.logOut(driver, wu);
		driver.quit();
		
	}

}
