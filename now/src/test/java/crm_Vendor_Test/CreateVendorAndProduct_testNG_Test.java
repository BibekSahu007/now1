package crm_Vendor_Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import crm_Generic_baseUtility.BaseClass;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.ProductPage;
import objectRepositoryUtility.VendorPage;

//@Listeners(crm_listernerUtility.ListenerImplementations.class)
public class CreateVendorAndProduct_testNG_Test extends BaseClass {
	@Test(groups = "smoke")
//	@Test(retryAnalyzer = crm_listernerUtility.RetryImplementation.class)
	public void vendoeAndProduct() throws Exception, IOException {
		int randomNo = ju.getRandomNumber();
		String VName = eu.getExcelFile("Product", 1, 5);
		String ProName = eu.getExcelFile("Product", 2, 0) + randomNo;
		String email = eu.getExcelFile("Product", 1, 6);
		String pNo = eu.getExcelFile("Product", 1, 3);

		VendorPage vp = new VendorPage(driver);
		vp.toAddVendor(driver, wu, VName, email, pNo);

		HomePage hp = new HomePage(driver);
		hp.clickOnProductLink(driver, wu);

		ProductPage pp = new ProductPage(driver);
		pp.addProduct(ProName);

		vp.toSelectOneVendor(driver, VName);
		pp.save();

		String proInfo = pp.proHeaderText();
		boolean status = proInfo.contains(ProName);
		Assert.assertEquals(status, true);
	}
}
