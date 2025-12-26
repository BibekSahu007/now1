package crm_OrganizationTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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

public class CreateOrgWithIndustryAndType_Test {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
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
		String Industry =eu.getExcelFile("Organization", 1, 1).toString();
		String type =eu.getExcelFile("Organization", 1, 2).toString();
		
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
		op.sendNameAndDropdowns(orgName, wu, Industry, type);
		
		String actind = op.actIndustry();
		String acttype = op.actTypee();
		if(actind.equals(Industry) && acttype.equals(type) ) {
			System.out.println(actind+" and "+acttype+" Both the Dropdowns are verified");
		}
		else System.out.println("not verifed");
		
		hp.logOut(driver, wu);
		driver.quit();
	}
}
