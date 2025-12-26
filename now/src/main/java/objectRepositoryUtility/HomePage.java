package objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm_generic_WebdriverUtility.WebDriverUtility;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Leads")
	private WebElement LeadsLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLink;

	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText = "Products")
	private WebElement ProductsLink;
	
	@FindBy(linkText = "Trouble Tickets")
	private WebElement Trouble_TicketsLink;
	
	@FindBy(linkText = "More")
	private WebElement MoreLink;
	
	@FindBy(linkText = "Invoice")
	private WebElement InvoiceLink;
	
	@FindBy(linkText = "Create Sales Order")
	private WebElement Sales_OrderLink;

	@FindBy(linkText = "Quotes")
	private WebElement QuotesrLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutButton;
	
	public WebElement getAdminLink() {
		return AdminLink;
	}
	public WebElement getSignoutButton() {
		return signoutButton;
	}

	public WebElement getLeadsLink() {
		return LeadsLink;
	}

	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getTrouble_TicketsLink() {
		return Trouble_TicketsLink;
	}

	public WebElement getMoreLink() {
		return MoreLink;
	}

	public WebElement getInvoiceLink() {
		return InvoiceLink;
	}

	public WebElement getSales_OrderLink() {
		return Sales_OrderLink;
	}

	public WebElement getQuotesrLink() {
		return QuotesrLink;
	}
	public void logOut(WebDriver driver , WebDriverUtility wu) {
		wu.toMouseHover(driver, AdminLink);
		signoutButton.click();
	}
	public void clickOnContactLink(WebDriver driver, WebDriverUtility wu) {
		wu.toMouseHover(driver, ContactsLink);
	}
	public void clickOnOrgLink(WebDriver driver, WebDriverUtility wu) {
		wu.toMouseHover(driver, OrganizationsLink);
	}
	public void clickOnProductLink(WebDriver driver, WebDriverUtility wu) {
		wu.toMouseHover(driver, ProductsLink);
	}
	public void toAddLead(WebDriverUtility wu, WebDriver driver) {
		WebElement leadsLink = getLeadsLink();
		wu.toMouseHover(driver, leadsLink);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	}
	public void switchToParentId(String pId, WebDriver driver) {
		driver.switchTo().window(pId);
	}
	public void goToInvoicePage(WebDriver driver, WebDriverUtility wu) {
		wu.toMouseHover(driver, MoreLink);
		wu.toMouseHover(driver, InvoiceLink);
	}
	public void Sales_OrderLink() {
		Sales_OrderLink.click();
	}
}
