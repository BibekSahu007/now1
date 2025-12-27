package crm_Generic_baseUtility;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import crm_GenericDatabaseUtility.DatabaseUtility;
import crm_Generic_FileUtility.ExcelUtility;
import crm_Generic_FileUtility.FileUtility;
import crm_generic_WebdriverUtility.JavaUtility;
import crm_generic_WebdriverUtility.UtilityClassObject;
import crm_generic_WebdriverUtility.WebDriverUtility;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public DatabaseUtility du=new DatabaseUtility();
	public FileUtility fu= new FileUtility();
	public ExcelUtility eu= new ExcelUtility();
	public JavaUtility ju= new JavaUtility();
	public WebDriverUtility wu=new WebDriverUtility();
	public static WebDriver sDriver;
	
	@BeforeSuite(groups={"regression","smoke"})
	public void beforeSuite() {
		System.out.println("======Connect to Data Base======");
		du.getDatabaseconnection();
	}
	@BeforeClass(groups={"regression","smoke"})
	public void beforeClass() throws IOException {
		System.out.println("======Open Browser======");
		String Browser = System.getProperty("browser",fu.getPropertyFile("browser"));
		if(Browser.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else if (Browser.equals("Chrome")) {
			driver= new ChromeDriver();
		}
		sDriver=driver;
		UtilityClassObject.setDriver(driver);
	}
	@BeforeMethod(groups={"regression","smoke"})
	public void beforeMethod() throws IOException {
		System.out.println("======Log In======");
		String URL = System.getProperty("url",fu.getPropertyFile("url"));
		String Username = System.getProperty("username",fu.getPropertyFile("username"));
		String Password = System.getProperty("password",fu.getPropertyFile("password"));
		LoginPage lp=new LoginPage(driver);
		lp.login(Username, Password, URL, wu);
		
	}
	@AfterMethod(groups={"regression","smoke"})
	public void afterMethod() {
		System.out.println("======Log Out======");
		HomePage hp=new HomePage(driver);
		hp.logOut(driver, wu);
	}
	@AfterClass(groups={"regression","smoke"})
	public void afterClass() {
		System.out.println("======Close Browser======");
		driver.quit();
	}
	@AfterSuite(groups={"regression","smoke"})
	public void afterSuite() {
		System.out.println("======Disconnect to Data Base======");
		du.closeDbConnection();
	}
}
