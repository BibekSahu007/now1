package crm_ContactTest;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import crm_Generic_baseUtility.BaseClass;
import crm_generic_WebdriverUtility.UtilityClassObject;
import objectRepositoryUtility.ContactInfoPage;
import objectRepositoryUtility.ContactPage;
import objectRepositoryUtility.CreateConPage;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.OrgPage;
import objectRepositoryUtility.Trouble_ticketPage;

@Listeners(crm_listernerUtility.ListenerImplementations.class)
public class All_Contact_testNG_Test extends BaseClass {
	@Test(groups = "smoke")
	public void createContact() throws Exception, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "Login And navigating to contact page");
		int randomNo = ju.getRandomNumber();
		String lastName = eu.getExcelFile("Contact", 1, 0) + randomNo;
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink(driver, wu);
		
		UtilityClassObject.getTest().log(Status.INFO, "Clicking on Add New Contact ");
		ContactPage cp = new ContactPage(driver);
		cp.toClickOnAddContact(driver, hp, wu);
		
		UtilityClassObject.getTest().log(Status.INFO, "Giving Contact Details");
		CreateConPage ccp = new CreateConPage(driver);
		ccp.toSendLastName(lastName);
		UtilityClassObject.getTest().log(Status.INFO, "Clicked on Save Button");
		ccp.toclickOnSaveButton();

		ContactInfoPage cip = new ContactInfoPage(driver);
		String conText = cip.toGetTextOfHeader();
		boolean status = conText.contains(lastName);
		UtilityClassObject.getTest().log(Status.INFO, "Verify Contact Details");
		Assert.assertEquals(status, true);
	}

	@Test(groups = "regression")
	public void createContactWithDate() throws EncryptedDocumentException, IOException {
		int randomNo = ju.getRandomNumber();
		String lastName = eu.getExcelFile("Contact", 1, 0) + randomNo;

		HomePage hp = new HomePage(driver);
		ContactPage cp = new ContactPage(driver);
		cp.toClickOnAddContact(driver, hp, wu);

		CreateConPage ccp = new CreateConPage(driver);
		ccp.sendLastNameDateSave(lastName, ju);

		ContactInfoPage cip = new ContactInfoPage(driver);
		String actSDate = cip.actualsDate();
		String actEDate = cip.actualeDate();
		boolean status = actSDate.trim().contains(ju.getSystemDate());
		Assert.assertEquals(status, true);
		boolean status1 = actEDate.trim().contains(ju.getReqDate(30));
		Assert.assertEquals(status1, true);
	}

	@Test(groups = "smoke")
	public void contactWithOrg() throws Throwable, IOException {
		int randomNo = ju.getRandomNumber();
		String lastName = eu.getExcelFile("Contact", 1, 0) + randomNo;
		String orgName = eu.getExcelFile("Organization", 1, 0).toString() + randomNo;
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink(driver, wu);

		OrgPage op = new OrgPage(driver);
		op.toSendOrgName(orgName);
		Thread.sleep(2000);
		ContactPage cp = new ContactPage(driver);
		cp.toClickOnAddContact(driver, hp, wu);

		CreateConPage ccp = new CreateConPage(driver);
		ccp.toSendLastName(lastName);

		ccp.toSwitchToOrgPage(driver, wu, op, orgName, hp);
		op.save();

		String orgText = ccp.getSavedOrgName().getText();
		boolean status = orgText.trim().contains(orgName);
		Assert.assertEquals(status, true);
	}

	@Test(groups = "regression")
	public void createContactAndAddTroubleTicket_Test() throws EncryptedDocumentException, IOException {
		int randomNo = ju.getRandomNumber();
		String lastName = eu.getExcelFile("Contact", 1, 0) + randomNo;
		String TroTic = eu.getExcelFile("Contact", 1, 1) + randomNo;
		String TroDec = eu.getExcelFile("Contact", 1, 2) + randomNo;

		HomePage hp = new HomePage(driver);
		ContactPage cp = new ContactPage(driver);
		cp.toClickOnAddContact(driver, hp, wu);

		CreateConPage ccp = new CreateConPage(driver);
		ccp.toSendLastName(lastName);

		ccp.toclickOnSaveButton();

		Trouble_ticketPage ttp = new Trouble_ticketPage(driver);
		ttp.toAddTroubleTickect(hp, wu, TroTic, TroDec);

		String actTroTic = ttp.troubleHeaderText();
		boolean status = actTroTic.contains(TroTic);
		Assert.assertEquals(status, true);
	}
}
