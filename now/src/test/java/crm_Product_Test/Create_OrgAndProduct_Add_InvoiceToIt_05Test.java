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
import objectRepositoryUtility.InvoicePage;
import objectRepositoryUtility.LoginPage;
import objectRepositoryUtility.OrgPage;
import objectRepositoryUtility.ProductPage;

public class Create_OrgAndProduct_Add_InvoiceToIt_05Test {

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
		String ProName = eu.getExcelFile("Product", 1, 1)+randomNo;
		String InvSub = eu.getExcelFile("Product", 1, 8);
		String Baddress = eu.getExcelFile("Product", 1, 2);
		String Ssddress = eu.getExcelFile("Product", 1, 3);
		String qty = eu.getExcelFile("Product", 1, 9);
		String price = eu.getExcelFile("Product", 1, 10);
		
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
		pp.addProductAndQtyAndSave(ProName, qty);
		
		hp.goToInvoicePage(driver, wu);
		InvoicePage ip= new InvoicePage(driver);
		
		ip.sendSubAndSelectOrg(InvSub, pp, wu, orgName);
		
		pp.sendBillingAddressAndhippingAddress(wu, Baddress, driver, Ssddress);
		
		ip.selectProQtyPrice(pp, wu, ProName, qty, price);
		
		String InText = ip.headerText();
		
		if(InText.contains(InvSub)) {
			System.out.println(InvSub+" Invoice Is Ready");
		}
		else System.out.println(InvSub+" Invoice Is Not Ready");
		
		hp.logOut(driver, wu);
		Thread.sleep(1000);
		driver.quit();
		
		
	}

}
