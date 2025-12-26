package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm_generic_WebdriverUtility.WebDriverUtility;


public class OrgPage {
//	WebDriver driver;
	public OrgPage(WebDriver driver) {
//		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrg;
	
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgName;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
	@FindBy(id = "search_txt")
	private WebElement searchTextfield;
	
	@FindBy(name = "search")
	private WebElement searchButton;
	
	@FindBy(xpath = "//a[text()='\"+orgName+\"']")
	private WebElement dynamicOrgName;
	
	@FindBy (xpath = "//select[@name='industry']")
	private WebElement industryDD;
	
	@FindBy (xpath = "//select[@name='accounttype']")
	private WebElement accountTypeDD;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement actIndustry;
	
	@FindBy(id = "dtlview_Type")
	private WebElement actType;
	
	@FindBy(id = "phone")
	private WebElement phoneTextField;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement actPhoneText;
	
	public WebElement getPhoneTextField() {
		return phoneTextField;
	}

	public WebElement getActPhoneText() {
		return actPhoneText;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getAccountTypeDD() {
		return accountTypeDD;
	}

	public WebElement getActIndustry() {
		return actIndustry;
	}

	public WebElement getActType() {
		return actType;
	}

	public WebElement getCreateOrg() {
		return createOrg;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getSearchTextfield() {
		return searchTextfield;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getDynamicOrgName() {
		return dynamicOrgName;
	}
	public void toSendOrgName(String orgName) {
		getCreateOrg().click();
		getOrgName().sendKeys(orgName);
		getSaveButton().click();
	}
	public void save() {
		saveButton.click();
	}
	public void toSendOrgNameOnly(String orgName) {
		getCreateOrg().click();
		getOrgName().sendKeys(orgName);
	}
	public void indDropdown(WebDriverUtility wu, String Industry) {
		wu.toHandleDropdown(industryDD, Industry);
	}
	public void typeDropdown(WebDriverUtility wu, String type) {
		wu.toHandleDropdown(accountTypeDD, type);
	}
	public String actIndustry() {
		return actIndustry.getText();
	}
	public String actTypee() {
		return actType.getText();
	}
	public void toSendPhoneNo(String phn) {
		phoneTextField.sendKeys(phn);
	}
	public String phoneText() {
		return actPhoneText.getText();
	}
	public void sendNameAndDropdowns(String orgName, WebDriverUtility wu, String Industry, String type) {
		getCreateOrg().click();
		getOrgName().sendKeys(orgName);
		indDropdown(wu, Industry);
		typeDropdown(wu, type);
		save();
	}
	public void sendOrgPhoneAndSave(String orgName, String phn) {
		getCreateOrg().click();
		getOrgName().sendKeys(orgName);
		phoneTextField.sendKeys(phn);
		save();
	}
}
