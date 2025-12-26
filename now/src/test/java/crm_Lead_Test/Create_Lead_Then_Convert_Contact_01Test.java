package crm_Lead_Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import crm_Generic_FileUtility.ExcelUtility;
import crm_Generic_FileUtility.FileUtility;
import crm_generic_WebdriverUtility.JavaUtility;
import crm_generic_WebdriverUtility.WebDriverUtility;
import objectRepositoryUtility.ContactPage;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.LeadPage;
import objectRepositoryUtility.LoginPage;

public class Create_Lead_Then_Convert_Contact_01Test {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility fu= new FileUtility();
		ExcelUtility eu= new ExcelUtility();
		JavaUtility ju= new JavaUtility();
		WebDriverUtility wu=new WebDriverUtility();

		String URL = fu.getPropertyFile("url");
		String Browser = fu.getPropertyFile("browser");
		String Username = fu.getPropertyFile("username");
		String Password = fu.getPropertyFile("password");
		
		String lead = eu.getExcelFile("Lead", 1, 0);
		String company = eu.getExcelFile("Organization", 1, 0);
		String phno = eu.getExcelFile("Organization", 1, 3);
		
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
		hp.toAddLead(wu, driver);
		
		LeadPage lep= new LeadPage(driver);
		lep.createLead(lead, company, phno);
		
		
		lep.toAddLeadLink(driver, wu, ju, hp);
		hp.clickOnContactLink(driver, wu);
		
		ContactPage cp= new ContactPage(driver);
		cp.leadAdvSearch(wu, "lastname", lead);
		driver.findElement(By.xpath("//a[text()='"+lead+"']")).click();
		
		String leadName = lep.leadHeaderText();
		
		if(leadName.contains(lead)) {
			System.out.println(lead+" This lead is coverted into Contact");
		}
		else System.out.println("Lesad is not verified");
		
		hp.logOut(driver, wu);
		driver.quit();
	}
}
