package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import crm_generic_WebdriverUtility.WebDriverUtility;

public class Trouble_ticketPage {
	WebDriver driver;
	public Trouble_ticketPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addTroubleTicket;
	
	@FindBy(name = "ticket_title")
	private WebElement ticketTextField;
	
	@FindBy(name = "ticketpriorities")
	private WebElement ticketDD;
	
	@FindBy(name = "description")
	private WebElement ticketDesc;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ticketHeaderText;
	
	public WebElement getAddTroubleTicket() {
		return addTroubleTicket;
	}

	public WebElement getTicketTextField() {
		return ticketTextField;
	}

	public WebElement getTicketDD() {
		return ticketDD;
	}

	public WebElement getTicketDesc() {
		return ticketDesc;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getTicketHeaderText() {
		return ticketHeaderText;
	}
	public void toAddTroubleTickect(HomePage hp,WebDriverUtility wu, String TroTic,String TroDec) {
		WebElement TroEle = hp.getTrouble_TicketsLink();
		wu.toMouseHover(driver, TroEle);
		getAddTroubleTicket().click();
		getTicketTextField().sendKeys(TroTic);
		WebElement prioDD = getTicketDD();
		wu.toHandleDropdown(prioDD, "High");
		Select s= new Select(prioDD);
		s.selectByValue("High");
		getTicketDesc().sendKeys(TroDec);
		getSaveButton().click();
	}
	public String troubleHeaderText() {
		return ticketHeaderText.getText();
	}
	
}
