package crm_generic_WebdriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Bibek Sahu
 * This class is used to handle all Webdriver method such as maximize, minimize, Implicit Wait, explicit Wait, to handle dropdown, 
 * to handle frame, to handle mouse and keyboard action, to handle popup, to switch between widows and to take screenshot.
 */
public class WebDriverUtility {
	/**
	 * 
	 * @param driver
	 * This method is used to maximize the browser, provided driver
	 */
	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method is use to minimize the browser, provided driver
	 * @param driver
	 */
	public void toMinimize(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method is used to wait until the element get loaded(Implicit Wait)
	 * @param driver
	 */

	public void waitForElement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}
	/**
	 * This method is used to wait until the element to be clickable provided driver and element
	 * @param driver
	 */
	public void elementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used to wait until the element to be visible provided driver and element
	 * @param driver
	 * @param element
	 */
	public void visiblityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to handle DropDown By using Index
	 * @param element
	 * @param index
	 */
	public void toHandleDropdown(WebElement element, int index) {
		Select sc= new Select(element);
		sc.selectByIndex(index);
	}
	/**
	 * This method is used to hansle Dropdown By using value
	 * @param element
	 * @param value
	 */
	public void toHandleDropdown(WebElement element, String value) {
		Select sc = new Select(element);
		sc.selectByValue(value);
	}
	/**
	 * This method is used to handle Dropdown by using Visible Text
	 * @param element
	 * @param text
	 */
	public void toHandleDropdown(String text, WebElement element ) {
		Select sc=new Select(element);
		sc.selectByVisibleText(text);
	}
	/**
	 * This method is used to handle frame by using Index
	 * @param driver
	 * @param value
	 */
	public void toHandleFrame(WebDriver driver, String value) {
		driver.switchTo().frame(value);
	}
	/**
	 * This method is used to handle frame by using Id Or Name
	 * @param driver
	 * @param name_id
	 */
	public void tohandleFrame(WebDriver driver, String name_id) {
		driver.switchTo().frame(name_id);
	}
	/**
	 * This method is used to handle frame by using WebElement
	 * @param driver
	 * @param element
	 */
	public void toHandleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to go back to main Frame
	 * @param driver
	 */
	public void toGoBackToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to Double Clik on element
	 * provided driver and webElement
	 * @param driver
	 * @param element
	 */
	public void toDoubleClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method is used to Mouse Hover to an Element
	 * provide driver and Webelement
	 * @param driver
	 * @param element
	 */
	public void toMouseHover(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	/**
	 * This method is used to perform Right Click on Element
	 * Provided driver and Element
	 * @param driver
	 * @param element
	 */
	public void toRightClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method is used to Drag and Drop 
	 * Provided driver and target, src
	 * @param driver
	 * @param target
	 * @param src
	 */
	public void toDragAndDrop(WebDriver driver, WebElement target, WebElement src) {
		Actions act=new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}
	/**
	 * This method is used to handle alert popup by accepting it provided driver
	 * @param driver
	 */
	public void toHandleAlertAccept(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	/**
	 * This method is used to handle the popup by Dismissimg it provided driver
	 * @param driver
	 */
	public void toHandleAlertByDismiss(WebDriver driver) {
		Alert alrtDis=driver.switchTo().alert();
		alrtDis.dismiss();
	}
	/**
	 * This method is used Capture the text from the alert Provided driver
	 * @param driver
	 * @return 
	 */
	public String toHandleAlertAndDetText(WebDriver driver) {
		Alert alertText=driver.switchTo().alert();
		String alrtMsg = alertText.getText();
		alertText.accept();
		return alrtMsg;
	}
	/**
	 * This method is used to Take Screenshot of Entire Webpage Provided driver and screenshotname
	 * @param driver
	 * @param screenshotname
	 * @return 
	 * @throws IOException
	 */
	public String toTakeScreenshot(WebDriver driver,String screenshotname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src=new File("./errorShots/"+screenshotname+".png");
		FileHandler.copy(temp, src);
		String pathOfScreenshot = src.getAbsolutePath();
		return pathOfScreenshot;
	}
	/**
	 * This method is used to switch to window which we need provided driver and particulartitle
	 * @param driver
	 * @param particulartitle
	 */
	public void toSwitchWindow(WebDriver driver,String particulartitle) {
		Set<String> allids = driver.getWindowHandles();
		for(String id:allids) {
			String title = driver.switchTo().window(id).getTitle();
			if(title.contains(particulartitle)) {
				break;
			}
		}
	}
	/**
	 * This method is used to scroll window
	 * @param driver
	 */
	public void toScroll(WebDriver driver) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	
	public void toScrollToElement(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
	}
}

