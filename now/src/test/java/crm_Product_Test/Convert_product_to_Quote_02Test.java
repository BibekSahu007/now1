package crm_Product_Test;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import crm_Generic_FileUtility.ExcelUtility;
import crm_Generic_FileUtility.FileUtility;
import crm_generic_WebdriverUtility.JavaUtility;
import crm_generic_WebdriverUtility.WebDriverUtility;
import objectRepositoryUtility.CreateConPage;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.LoginPage;
import objectRepositoryUtility.OrgPage;
import objectRepositoryUtility.ProductPage;

public class Convert_product_to_Quote_02Test {

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
		String orgName =eu.getExcelFile("Organization", 1, 0).toString()+randomNo;
		String ProName =eu.getExcelFile("Product", 1, 0).toString()+randomNo;
		String SubName =eu.getExcelFile("Product", 1, 1).toString();
		String Baddress =eu.getExcelFile("Product", 1, 2).toString();
		String Ssddress =eu.getExcelFile("Product", 1, 3).toString();
		
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
		pp.addProduct(ProName);
		pp.save();
		
		pp.clickOnQuoteLink();
		pp.sendSubject(SubName);
		
		CreateConPage ccp=new CreateConPage(driver);
		ccp.toSwitchToOrgPageQ(driver, wu, op, orgName, hp);
		
		pp.sendBillingAddressAndhippingAddress(wu, Baddress, driver, Ssddress);
		pp.save();
		
		String proText = pp.proHeaderText();
		
		if(proText.contains(ProName)) {
			System.out.println(ProName+" Is ready to Place Order");
		}
		else System.out.println(ProName+" Is not Ready To Order");
		
		hp.logOut(driver, wu);
		driver.quit();
		
		
	}

}
