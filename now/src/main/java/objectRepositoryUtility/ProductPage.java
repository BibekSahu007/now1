package objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm_generic_WebdriverUtility.WebDriverUtility;

public class ProductPage {
//	WebDriver driver;
	public ProductPage(WebDriver driver) {
//		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addProduct;
	
	@FindBy(name = "productname")
	private WebElement productTextFiled;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
	@FindBy(linkText = "Create Quote")
	private WebElement createQuoteLink;
	
	@FindBy(name = "subject")
	private WebElement subjectTextField;
	
	@FindBy(xpath = "//input[@id='single_accountid']/following-sibling::img")
	private WebElement addOrgButton;
	
	@FindBy(xpath = "//textarea[@name='bill_street']")
	private WebElement billingTextField;
	
	@FindBy(xpath = "//textarea[@name='ship_street']")
	private WebElement sippingTextField;
	
	@FindBy(className = "lvtHeaderText")
	private WebElement proHeaderText;
	
	@FindBy(id = "qtyinstock")
	private WebElement qntyText;
	
	@FindBy(id = "searchIcon1")
	private WebElement productIcon;
	
	public WebElement getProductIcon() {
		return productIcon;
	}

	public WebElement getQntyText() {
		return qntyText;
	}

	public WebElement getAddProduct() {
		return addProduct;
	}

	public WebElement getProductTextFiled() {
		return productTextFiled;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCreateQuoteLink() {
		return createQuoteLink;
	}

	public WebElement getSubjectTextField() {
		return subjectTextField;
	}

	public WebElement getAddOrgButton() {
		return addOrgButton;
	}

	public WebElement getBillingTextField() {
		return billingTextField;
	}

	public WebElement getSippingTextField() {
		return sippingTextField;
	}

	public WebElement getProHeaderText() {
		return proHeaderText;
	}
	public void addProduct(String ProName) {
		addProduct.click();
		productTextFiled.sendKeys(ProName);
	}
	public void save() {
		saveButton.click();
	}
	public void clickOnQuoteLink() {
		createQuoteLink.click();
	}
	public void sendSubject(String SubName) {
		subjectTextField.sendKeys(SubName);
	}
	public void switchToOrg(WebDriverUtility wu, String Organization, WebDriver driver) {
		addOrgButton.click();
		wu.toSwitchWindow(driver, Organization);
	}
	public void sendBillingAddress(WebDriverUtility wu, String Baddress, WebDriver driver) {
		wu.toMouseHover(driver, billingTextField);
		billingTextField.clear();
		billingTextField.sendKeys(Baddress);
		
	}
	public void sendShippingAddress(WebDriverUtility wu, String Ssddress, WebDriver driver) {
		wu.toMouseHover(driver, sippingTextField);
		sippingTextField.clear();
		sippingTextField.sendKeys(Ssddress);
	}
	public String proHeaderText() {
		return proHeaderText.getText();
	}
	public void addProductAndQty(String ProName,String qty) {
		addProduct.click();
		productTextFiled.sendKeys(ProName);
		getQntyText().sendKeys(qty);
	}
	public void selectOrg(String SubName, WebDriver driver, WebDriverUtility wu, String orgName ) {
		getSubjectTextField().sendKeys(SubName);
		String pId = driver.getWindowHandle();
		getAddOrgButton().click();
		wu.toSwitchWindow(driver,"Organizations");
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		wu.toHandleAlertAccept(driver);
		driver.switchTo().window(pId);
	}
	public void sendBillingAddressAndhippingAddress(WebDriverUtility wu, String Baddress, WebDriver driver,String Ssddress) {
		wu.toMouseHover(driver, billingTextField);
		billingTextField.clear();
		billingTextField.sendKeys(Baddress);
		wu.toMouseHover(driver, sippingTextField);
		sippingTextField.clear();
		sippingTextField.sendKeys(Ssddress);
	}
	public void addProductAndQtyAndSave(String ProName,String qty) {
		addProduct.click();
		productTextFiled.sendKeys(ProName);
		getQntyText().sendKeys(qty);
		save();
	}
	public void addProductAndSave(String ProName) {
		addProduct.click();
		productTextFiled.sendKeys(ProName);
		save();
	}
	public void selectOrgAndSendAddress(String SubName, WebDriver driver, WebDriverUtility wu, String orgName, String Baddress, String Ssddress ) {
		getSubjectTextField().sendKeys(SubName);
		String pId = driver.getWindowHandle();
		getAddOrgButton().click();
		wu.toSwitchWindow(driver,"Organizations");
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		wu.toHandleAlertAccept(driver);
		driver.switchTo().window(pId);
		
		wu.toMouseHover(driver, billingTextField);
		billingTextField.clear();
		billingTextField.sendKeys(Baddress);
		wu.toMouseHover(driver, sippingTextField);
		sippingTextField.clear();
		sippingTextField.sendKeys(Ssddress);
		save();
	}
	
	
}
	
