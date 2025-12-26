package crm_OrganizationTest;

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

public class CreateOrgWithPhoneNo_Test {

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
		String orgName =eu.getExcelFile("Organization", 1, 0).toString()+randomNo;
		String phn =eu.getExcelFile("Organization", 1, 3).toString();
		
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
		op.sendOrgPhoneAndSave(orgName, phn);
		
		String phnText = op.phoneText();
		
		if(phnText.equals(phn)) {
			System.out.println(phn+" is verified");
		}
			else System.out.println(phn+" is not verified");
		
		hp.logOut(driver, wu);
		driver.quit();
	}
}
