package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm_generic_WebdriverUtility.WebDriverUtility;


public class ContactPage {
	WebDriver driver;
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateCon;
	
	@FindBy(id = "bas_searchfield")
	private WebElement advSearchDD;
	
	@FindBy(name = "search_text")
	private WebElement avdSearchText;
	
	@FindBy(name = "submit")
	private WebElement avdSubmitButton;
	
	
	public WebElement getAvdSearchText() {
		return avdSearchText;
	}

	public WebElement getAvdSubmitButton() {
		return avdSubmitButton;
	}

	public WebElement getAdvSearchDD() {
		return advSearchDD;
	}

	public WebElement getCreateCon() {
		return CreateCon;
	}
	public void toClickOnAddContact(WebDriver driver,HomePage hp, WebDriverUtility wu) {
		hp.clickOnContactLink(driver, wu);
		CreateCon.click();
	}
	public void leadAdvSearch(WebDriverUtility wu, String lastname, String lead) {
//		String pId = driver.getWindowHandle();
		WebElement inDD = getAdvSearchDD();
		wu.toHandleDropdown(inDD, "lastname");
		getAvdSearchText().sendKeys(lead);
		getAvdSubmitButton().click();
	}
	
}
