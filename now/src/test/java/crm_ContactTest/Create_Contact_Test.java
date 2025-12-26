package crm_ContactTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import crm_Generic_FileUtility.ExcelUtility;
import crm_Generic_FileUtility.FileUtility;
import crm_generic_WebdriverUtility.JavaUtility;
import crm_generic_WebdriverUtility.WebDriverUtility;
import objectRepositoryUtility.ContactInfoPage;
import objectRepositoryUtility.ContactPage;
import objectRepositoryUtility.CreateConPage;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.LoginPage;

public class Create_Contact_Test {


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
		String lastName = eu.getExcelFile("Contact", 1, 0)+randomNo;

		WebDriver driver=null;
		if(Browser.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else if (Browser.equals("Chrome")) {
			driver= new ChromeDriver();
		}
		LoginPage lp=new LoginPage(driver);
		lp.login(Username, Password, URL, wu);
		
		HomePage hp=new HomePage(driver);
		hp.clickOnContactLink(driver, wu);

		ContactPage cp= new ContactPage(driver);
		cp.toClickOnAddContact(driver, hp, wu);
		
		CreateConPage ccp=new CreateConPage(driver);
		ccp.toSendLastName(lastName);
		
		ccp.toclickOnSaveButton();

		ContactInfoPage cip=new ContactInfoPage(driver);
		String conText = cip.toGetTextOfHeader();
		if(conText.contains(lastName)) {
			System.out.println(lastName+"Last Name is verified");
		}
		hp.logOut(driver, wu);
		driver.quit();

	}

}
