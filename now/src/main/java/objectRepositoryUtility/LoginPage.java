package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm_generic_WebdriverUtility.WebDriverUtility;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement userText;
	
	@FindBy(name="user_password")
	private WebElement user_password;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;

	public WebElement getUserText() {
		return userText;
	}

	public WebElement getUser_password() {
		return user_password;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	public void login(String userName, String Password, String URL, WebDriverUtility wu) {
		driver.get(URL);
		wu.toMaximize(driver);
		wu.waitForElement(driver);
		userText.sendKeys(userName);
		user_password.sendKeys(Password);
		submitButton.click();
	}
	
	
}
