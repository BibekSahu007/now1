package crm_ContactTest;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import crm_Generic_FileUtility.ExcelUtility;
import crm_Generic_FileUtility.FileUtility;
import crm_generic_WebdriverUtility.JavaUtility;
import crm_generic_WebdriverUtility.WebDriverUtility;
import objectRepositoryUtility.ContactPage;
import objectRepositoryUtility.CreateConPage;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.LoginPage;
import objectRepositoryUtility.OrgPage;

public class Create_ContactWithOrg_06Test {

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

		String lastName = eu.getExcelFile("Contact", 1, 0)+randomNo;
		String orgName =eu.getExcelFile("Organization", 1, 0).toString()+randomNo;

		WebDriver driver=null;
		if(Browser.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else if (Browser.equals("Chrome")) {
			driver= new ChromeDriver();
		}

		LoginPage lp=new LoginPage(driver);
		lp.login(Username, Password, URL, wu);
		
		//create Organization
		HomePage hp= new HomePage(driver);
		hp.clickOnOrgLink(driver, wu);
		
		OrgPage op=new OrgPage(driver);
		op.toSendOrgName(orgName);
		Thread.sleep(2000);
		ContactPage cp=new ContactPage(driver);
		cp.toClickOnAddContact(driver, hp, wu);
		
		CreateConPage ccp=new CreateConPage(driver);
		ccp.toSendLastName(lastName);

		ccp.toSwitchToOrgPage(driver, wu, op, orgName, hp);
		op.save();

		String orgText = ccp.getSavedOrgName().getText();
		if(orgText.trim().contains(orgName)) {
			System.out.println(orgName+" Is verified After Creating Contact");
		}
		else System.out.println(orgName+" Is Not Verified");

		hp.logOut(driver, wu);
		driver.quit();
	}

}
