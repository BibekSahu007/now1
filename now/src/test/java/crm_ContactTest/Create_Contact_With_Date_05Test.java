package crm_ContactTest;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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

public class Create_Contact_With_Date_05Test {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
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
		ContactPage cp= new ContactPage(driver);
		cp.toClickOnAddContact(driver, hp, wu);
		
		CreateConPage ccp=new CreateConPage(driver);
		ccp.sendLastNameDateSave(lastName, ju);
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String actSDate = cip.actualsDate();
		String actEDate = cip.actualeDate();
		
		if(actSDate.trim().contains(ju.getSystemDate())) {
			System.out.println(actSDate+" Date is Verified");
		}
		else System.out.println("Today Date is Not Verified");
		
		if(actEDate.trim().contains(ju.getReqDate(30))) {
			System.out.println(actEDate+" EndDate Is Verified");
		}
		else System.out.println("EndDate Is Not Verified");
		
		hp.logOut(driver, wu);
		Thread.sleep(1000);
		driver.quit();
	}

}
