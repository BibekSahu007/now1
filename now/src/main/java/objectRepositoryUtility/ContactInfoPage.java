package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
//	WebDriver driver;
	public ContactInfoPage(WebDriver driver) {
//		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className = "dvHeaderText")
	private WebElement contactHeaderText;
	
	@FindBy(id = "mouseArea_Support Start Date")
	private WebElement ActualsDate;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement ActualeDate;
	
	public WebElement getActualsDate() {
		return ActualsDate;
	}

	public WebElement getActualeDate() {
		return ActualeDate;
	}

	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}
	public String toGetTextOfHeader() {
		return contactHeaderText.getText();
		
	}
	public String actualsDate() {
		return ActualsDate.getText();
	}
	public String actualeDate() {
		return ActualeDate.getText();
	}

	
}
