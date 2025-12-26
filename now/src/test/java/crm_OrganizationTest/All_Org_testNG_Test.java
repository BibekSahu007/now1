package crm_OrganizationTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import crm_Generic_baseUtility.BaseClass;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.OrgInfoPage;
import objectRepositoryUtility.OrgPage;

@Listeners(crm_listernerUtility.ListenerImplementations.class)
public class All_Org_testNG_Test extends BaseClass {
	@Test(groups = "regression")
	public void create_org() throws Exception, IOException {
		int randomNo = ju.getRandomNumber();
		String orgName = eu.getExcelFile("Organization", 1, 0).toString() + randomNo;

		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink(driver, wu);

		OrgPage op = new OrgPage(driver);
		op.toSendOrgName(orgName);

		OrgInfoPage oip = new OrgInfoPage(driver);
		String orgNametext = oip.headerText();
		boolean status = orgNametext.contains(orgName);
		Assert.assertEquals(status, true);
	}

	@Test(groups = "smoke")
	public void createOrgWithIndAndType() throws Exception, IOException {
		int randomNo = ju.getRandomNumber();
		String orgName = eu.getExcelFile("Organization", 1, 0).toString() + randomNo;
		String Industry = eu.getExcelFile("Organization", 1, 1).toString();
		String type = eu.getExcelFile("Organization", 1, 2).toString();

		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink(driver, wu);

		OrgPage op = new OrgPage(driver);
		op.sendNameAndDropdowns(orgName, wu, Industry, type);

		String actind = op.actIndustry();
		String acttype = op.actTypee();
		boolean status= (actind.equals(Industry) && acttype.equals(type));
		Assert.assertEquals(status, true);
	}

	@Test(groups = "regression")
	public void createOrgWithPhoneNo() throws Exception, IOException {
		int randomNo = ju.getRandomNumber();
		String orgName = eu.getExcelFile("Organization", 1, 0).toString() + randomNo;
		String phn = eu.getExcelFile("Organization", 1, 3).toString();

		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink(driver, wu);

		OrgPage op = new OrgPage(driver);
		op.sendOrgPhoneAndSave(orgName, phn);

		String phnText = op.phoneText();
		Assert.assertEquals(phnText, phn);
	}
}
