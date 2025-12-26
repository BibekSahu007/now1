package crm_Lead_Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import crm_Generic_baseUtility.BaseClass;
import objectRepositoryUtility.ContactPage;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.LeadPage;

@Listeners(crm_listernerUtility.ListenerImplementations.class)
public class Lead_To_Contact_testNG_Test extends BaseClass {
	@Test(groups = "smoke")
	public void leadConvertToContact_Test() throws Exception, IOException {
		String lead = eu.getExcelFile("Lead", 1, 0);
		String company = eu.getExcelFile("Organization", 1, 0);
		String phno = eu.getExcelFile("Organization", 1, 3);

		HomePage hp = new HomePage(driver);
		hp.toAddLead(wu, driver);

		LeadPage lep = new LeadPage(driver);
		lep.createLead(lead, company, phno);

		lep.toAddLeadLink(driver, wu, ju, hp);
		hp.clickOnContactLink(driver, wu);

		ContactPage cp = new ContactPage(driver);
		cp.leadAdvSearch(wu, "lastname", lead);
		driver.findElement(By.xpath("//a[text()='" + lead + "']")).click();

		String leadName = lep.leadHeaderText();
		boolean status = leadName.contains(lead);
		Assert.assertEquals(status, true);
	}
}
