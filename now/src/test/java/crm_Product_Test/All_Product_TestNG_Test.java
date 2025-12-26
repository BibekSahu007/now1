package crm_Product_Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import crm_Generic_baseUtility.BaseClass;
import objectRepositoryUtility.CreateConPage;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.InvoicePage;
import objectRepositoryUtility.OrgPage;
import objectRepositoryUtility.ProductPage;

@Listeners(crm_listernerUtility.ListenerImplementations.class)
public class All_Product_TestNG_Test extends BaseClass {
	@Test(groups = "smoke")
	public void covert_product_to_Quote() throws Exception, IOException {
		int randomNo = ju.getRandomNumber();
		String orgName = eu.getExcelFile("Organization", 1, 0).toString() + randomNo;
		String ProName = eu.getExcelFile("Product", 1, 0).toString() + randomNo;
		String SubName = eu.getExcelFile("Product", 1, 1).toString();
		String Baddress = eu.getExcelFile("Product", 1, 2).toString();
		String Ssddress = eu.getExcelFile("Product", 1, 3).toString();

		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink(driver, wu);

		OrgPage op = new OrgPage(driver);
		op.toSendOrgName(orgName);

		Thread.sleep(2000);
		hp.clickOnProductLink(driver, wu);

		ProductPage pp = new ProductPage(driver);
		pp.addProduct(ProName);
		pp.save();

		pp.clickOnQuoteLink();
		pp.sendSubject(SubName);

		CreateConPage ccp = new CreateConPage(driver);
		ccp.toSwitchToOrgPageQ(driver, wu, op, orgName, hp);

		pp.sendBillingAddressAndhippingAddress(wu, Baddress, driver, Ssddress);
		pp.save();

		String proText = pp.proHeaderText();
		boolean status = proText.contains(ProName);
		Assert.assertEquals(status, true);
	}

	@Test(groups = "regression")
	public void createOrgAndProductAddToInvoice() throws Exception, IOException {
		int randomNo = ju.getRandomNumber();
		String orgName = eu.getExcelFile("Organization", 1, 0) + randomNo;
		String ProName = eu.getExcelFile("Product", 1, 1) + randomNo;
		String InvSub = eu.getExcelFile("Product", 1, 8);
		String Baddress = eu.getExcelFile("Product", 1, 2);
		String Ssddress = eu.getExcelFile("Product", 1, 3);
		String qty = eu.getExcelFile("Product", 1, 9);
		String price = eu.getExcelFile("Product", 1, 10);

		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink(driver, wu);

		OrgPage op = new OrgPage(driver);
		op.toSendOrgName(orgName);

		Thread.sleep(2000);
		hp.clickOnProductLink(driver, wu);

		ProductPage pp = new ProductPage(driver);
		pp.addProductAndQtyAndSave(ProName, qty);

		hp.goToInvoicePage(driver, wu);
		InvoicePage ip = new InvoicePage(driver);

		ip.sendSubAndSelectOrg(InvSub, pp, wu, orgName);

		pp.sendBillingAddressAndhippingAddress(wu, Baddress, driver, Ssddress);

		ip.selectProQtyPrice(pp, wu, ProName, qty, price);

		String InText = ip.headerText();
		boolean status = InText.contains(InvSub);
		Assert.assertEquals(status, true);
	}

	@Test(groups = "smoke")
	public void ProductToSalesOrder() throws Exception, IOException {
		int randomNo = ju.getRandomNumber();
		String orgName = eu.getExcelFile("Organization", 1, 0) + randomNo;
		String ProName = eu.getExcelFile("Product", 1, 1);
		String SubName = eu.getExcelFile("Product", 1, 1);
		String Baddress = eu.getExcelFile("Product", 1, 2);
		String Ssddress = eu.getExcelFile("Product", 1, 3);

		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink(driver, wu);

		OrgPage op = new OrgPage(driver);
		op.toSendOrgName(orgName);

		Thread.sleep(2000);
		hp.clickOnProductLink(driver, wu);
		ProductPage pp = new ProductPage(driver);
		pp.addProductAndSave(ProName);

		Thread.sleep(2000);
		hp.Sales_OrderLink();
		pp.selectOrgAndSendAddress(SubName, driver, wu, orgName, Baddress, Ssddress);

		String ProInfo = pp.proHeaderText();
		boolean status = ProInfo.contains(ProName);
		Assert.assertEquals(status, true);
	}
}
