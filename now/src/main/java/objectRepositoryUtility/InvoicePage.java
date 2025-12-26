package objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm_generic_WebdriverUtility.WebDriverUtility;

public class InvoicePage {
	WebDriver driver;
	public InvoicePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addInvoiceButton;
	
	@FindBy(name = "subject")
	private WebElement subjectTextField;
	
	@FindBy(id = "qty1")
	private WebElement qty1;
	
	public WebElement getQty() {
		return qty1;
	}
	@FindBy(id = "listPrice1")
	private WebElement listPrice;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
	@FindBy(className = "lvtHeaderText")
	private WebElement InvHeaderText;
	
	public WebElement getProHeaderText() {
		return InvHeaderText;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getListPrice() {
		return listPrice;
	}
	
	public WebElement getSubjectTextField() {
		return subjectTextField;
	}
	
	public WebElement getAddInvoiceButton() {
		return addInvoiceButton;
	}
	public void sendIncoiceSubject() {
		addInvoiceButton.click();
	}
	public void sendInvoiceSub(String InvSub) {
		addInvoiceButton.click();
		subjectTextField.sendKeys(InvSub);
	}
	public void selectOrg(ProductPage pp, WebDriverUtility wu, String orgName) {
		String pId = driver.getWindowHandle();
		pp.getAddOrgButton().click();
		wu.toSwitchWindow(driver, "Organization");
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		wu.toHandleAlertAccept(driver);
		driver.switchTo().window(pId);
	}
	public void selectOneProduct(ProductPage pp, WebDriverUtility wu, String ProName) {
		String pId = driver.getWindowHandle();
		pp.getProductIcon().click();
		wu.toSwitchWindow(driver, "Product");
		driver.findElement(By.xpath("//a[text()='"+ProName+"']")).click();
		driver.switchTo().window(pId);
	}
	public void selectQtyAndPrice(String qty, String price) {
		qty1.sendKeys(qty);
		listPrice.clear();
		listPrice.sendKeys(price);
		saveButton.click();
	}
	public String headerText() {
		return InvHeaderText.getText();
	}
	public void sendSubAndSelectOrg(String InvSub, ProductPage pp, WebDriverUtility wu, String orgName) {
		addInvoiceButton.click();
		subjectTextField.sendKeys(InvSub);
		String pId = driver.getWindowHandle();
		pp.getAddOrgButton().click();
		wu.toSwitchWindow(driver, "Organization");
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		wu.toHandleAlertAccept(driver);
		driver.switchTo().window(pId);
	}
	public void selectProQtyPrice(ProductPage pp, WebDriverUtility wu, String ProName, String qty, String price) {
		String pId = driver.getWindowHandle();
		pp.getProductIcon().click();
		wu.toSwitchWindow(driver, "Product");
		driver.findElement(By.xpath("//a[text()='"+ProName+"']")).click();
		driver.switchTo().window(pId);
		qty1.sendKeys(qty);
		listPrice.clear();
		listPrice.sendKeys(price);
		saveButton.click();
	}
}
