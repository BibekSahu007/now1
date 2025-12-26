package crm_Vendor_Test;

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
import objectRepositoryUtility.ProductPage;
import objectRepositoryUtility.VendorPage;

public class Create_VendorAndAdd_Product_03Test {

	public static void main(String[] args) throws IOException {
		FileUtility fu= new FileUtility();
		ExcelUtility eu= new ExcelUtility();
		JavaUtility ju= new JavaUtility();
		WebDriverUtility wu=new WebDriverUtility();

		String URL = fu.getPropertyFile("url");
		String Browser = fu.getPropertyFile("browser");
		String Username = fu.getPropertyFile("username");
		String Password = fu.getPropertyFile("password");
		
		int randomNo = ju.getRandomNumber();
		String VName = eu.getExcelFile("Product", 1, 5);
		String ProName = eu.getExcelFile("Product", 2, 0)+randomNo;
		String email = eu.getExcelFile("Product", 1, 6);
		String pNo = eu.getExcelFile("Product", 1, 3);
		
		WebDriver driver=null;
		if(Browser.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else if (Browser.equals("Chrome")) {
			driver= new ChromeDriver();
		}

		LoginPage lp=new LoginPage(driver);
		lp.login(Username, Password, URL, wu);
		
		VendorPage vp=new VendorPage(driver);
		vp.toAddVendor(driver, wu, VName, email, pNo);
		
		HomePage hp=new HomePage(driver);
		hp.clickOnProductLink(driver, wu);
		
		ProductPage pp= new ProductPage(driver);
		pp.addProduct(ProName);
		
		vp.toSelectOneVendor(driver, VName);
		pp.save();
		
		String proInfo = pp.proHeaderText();
		if(proInfo.contains(ProName)) {
			System.out.println(ProName+" Is attached to a Vendor");
		}
		else System.out.println(ProName+" Is Not attached to a Vendor");
		
		hp.logOut(driver, wu);
		driver.quit();
	}

}
