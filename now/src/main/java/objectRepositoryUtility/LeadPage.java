package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm_generic_WebdriverUtility.JavaUtility;
import crm_generic_WebdriverUtility.WebDriverUtility;

public class LeadPage {
//	WebDriver driver;
	public LeadPage(WebDriver driver) {
//		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "lastname")
	private WebElement leadName;
	
	@FindBy(name = "company")
	private WebElement companyName;
	
	@FindBy(id = "phone")
	private WebElement phoneText;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
//	@FindBy(name="Save")
//	private WebElement save;
	
	@FindBy(linkText = "Convert Lead")
	private WebElement convertLeadlink;
	
	@FindBy(id = "select_potential")
	private WebElement potentialLink;
	
	@FindBy(id = "jscal_field_closedate")
	private WebElement closeDatetext;
	
	@FindBy(name = "Save")
	private WebElement saveLead;
	
	@FindBy(className = "dvHeaderText")
	private WebElement leadHeaderText;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addLeadButton;

	public WebElement getAddLeadButton() {
		return addLeadButton;
	}

	public WebElement getLeadName() {
		return leadName;
	}

	public WebElement getCompanyName() {
		return companyName;
	}

	public WebElement getPhoneText() {
		return phoneText;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getConvertLeadlink() {
		return convertLeadlink;
	}

	public WebElement getPotentialLink() {
		return potentialLink;
	}

	public WebElement getCloseDatetext() {
		return closeDatetext;
	}

	public WebElement getSaveLead() {
		return saveLead;
	}

	public WebElement getLeadHeaderText() {
		return leadHeaderText;
	}
	public void leadName(String leadname) {
		getLeadName().sendKeys(leadname);
	}
	public void companyName(String company) {
		getCompanyName().sendKeys(company);
	}
	public void phoneNo(String phno) {
		getPhoneText().sendKeys(phno);
	}
	public void save() {
		saveLead.click();
	}
	public void convertLead(WebDriver driver, WebDriverUtility wu) {
		getConvertLeadlink().click();
		wu.toSwitchWindow(driver, "Convert lead");
		getPotentialLink().click();
	}
	public void toAddLeadLink(WebDriver driver, WebDriverUtility wu, JavaUtility ju, HomePage hp) {
		String pId = driver.getWindowHandle();
		getConvertLeadlink().click();
		wu.toSwitchWindow(driver, "Convert lead");
		getPotentialLink().click();
		endDate(ju);
		save();
		hp.switchToParentId(pId, driver);
	}
	public void endDate(JavaUtility ju) {
		String endDate = ju.getReqDate(30);
		closeDatetext.sendKeys(endDate);
	}
	public String leadHeaderText() {
		return getLeadHeaderText().getText();
	}
	public void savelead() {
		saveButton.click();
	}
	public void createLead(String lead, String company, String phno) {
		leadName(lead);
		companyName(company);
		phoneNo(phno);
		savelead();
	}
}
