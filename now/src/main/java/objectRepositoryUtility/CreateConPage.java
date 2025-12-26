package objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm_generic_WebdriverUtility.JavaUtility;
import crm_generic_WebdriverUtility.WebDriverUtility;

public class CreateConPage {
//	WebDriver driver;
	public CreateConPage(WebDriver driver) {
//		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "lastname")
	private WebElement lastNAme;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")//"(//input[@title='Save [Alt+S]'])[1]"
	private WebElement saveButton;
	
	@FindBy(id = "jscal_field_support_start_date")
	private WebElement sdateText;
	
	@FindBy(id = "jscal_field_support_end_date")
	private WebElement edateText;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement addOrgName;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement savedOrgName;
	
	public WebElement getAddOrgName() {
		return addOrgName;
	}

	public WebElement getSavedOrgName() {
		return savedOrgName;
	}

	public WebElement getEdateText() {
		return edateText;
	}
	
	public WebElement getSdateText() {
		return sdateText;
	}

	public WebElement getLastNAme() {
		return lastNAme;
	}

	public WebElement getSaveButton() {
		return saveButton;
	} 
	public void toSendLastName(String lastName) {
		lastNAme.sendKeys(lastName);
	}
	public void toclickOnSaveButton() {
		saveButton.click();
	}
	public void sendStartDate(JavaUtility ju) {
		sdateText.clear();
		String today = ju.getSystemDate();
		sdateText.sendKeys(today);
	}
	public void sendEndDate(JavaUtility ju, int req) {
		sdateText.clear();
		String reqDate = ju.getReqDate(req);
		edateText.sendKeys(reqDate);
	}
	public void toSwitchToOrgPage(WebDriver driver,WebDriverUtility wu, OrgPage op, String orgName, HomePage hp) {
		String pId = driver.getWindowHandle();
		addOrgName.click();
		wu.toSwitchWindow(driver, "Organization");
		op.getSearchTextfield().sendKeys(orgName);
		op.getSearchButton().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		hp.switchToParentId(pId, driver);
		
	}
	public void giveStartDateAndEndDate(JavaUtility ju) {
		WebElement sDate = getSdateText();
		sDate.clear();
		String today = ju.getSystemDate();
		sDate.sendKeys(today);
		String reqDate = ju.getReqDate(30);
		WebElement eDate = getEdateText();
		eDate.clear();
		eDate.sendKeys(reqDate);
	}
	public void toSwitchToOrgPageQ(WebDriver driver,WebDriverUtility wu, OrgPage op, String orgName, HomePage hp) {
		String pId = driver.getWindowHandle();
		addOrgName.click();
		wu.toSwitchWindow(driver, "Organization");
		op.getSearchTextfield().sendKeys(orgName);
		op.getSearchButton().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		wu.toHandleAlertByDismiss(driver);
		hp.switchToParentId(pId, driver);
	}
	public void sendLastNameDateSave(String lastName, JavaUtility ju) {
		lastNAme.sendKeys(lastName);
		WebElement sDate = getSdateText();
		sDate.clear();
		String today = ju.getSystemDate();
		sDate.sendKeys(today);
		String reqDate = ju.getReqDate(30);
		WebElement eDate = getEdateText();
		eDate.clear();
		eDate.sendKeys(reqDate);
		saveButton.click();
	}
}
