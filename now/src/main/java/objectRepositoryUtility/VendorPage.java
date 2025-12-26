package objectRepositoryUtility;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm_generic_WebdriverUtility.WebDriverUtility;

public class VendorPage {
	public VendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "qccombo")
	private WebElement quickDD;
	
	@FindBy(name = "vendorname")
	private WebElement vendorName;
	
	@FindBy(id = "email")
	private WebElement emailText;
	
	@FindBy(id = "phone")
	private WebElement phoneText;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
	@FindBy(xpath = "//input[@name='vendor_name']/following-sibling::img")
	private WebElement addVendor;
	
	public WebElement getAddVendor() {
		return addVendor;
	}

	public WebElement getQuickDD() {
		return quickDD;
	}

	public WebElement getVendorName() {
		return vendorName;
	}

	public WebElement getEmailText() {
		return emailText;
	}

	public WebElement getPhoneText() {
		return phoneText;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	public void toAddVendor(WebDriver driver, WebDriverUtility wu, String VName, String email, String pNo) {
		String pId = driver.getWindowHandle();
		WebElement quickDD =getQuickDD();
		wu.toHandleDropdown(quickDD, "Vendors");
		wu.toSwitchWindow(driver, "Vendors");
		getVendorName().sendKeys(VName);
		getEmailText().sendKeys(email);
		getPhoneText().sendKeys(pNo);
		getSaveButton().click();
		driver.switchTo().window(pId);
	}
	public void toSelectOneVendor(WebDriver driver,String VName) {
		String pId = driver.getWindowHandle();
		getAddVendor().click();
		Set<String> allIdsP = driver.getWindowHandles();
		for(String id1:allIdsP) {
			driver.switchTo().window(id1);
		}
		driver.findElement(By.xpath("//a[text()='"+VName+"']"));
		driver.switchTo().window(pId);
	}
}
