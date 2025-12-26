package helpingPackageWithPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Mock_Flipkart_3ProductsTest {
	public static WebDriver driver;
	public static void toTakeSs(String productName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src=new File("./errorShots/"+productName+".png");
		FileHandler.copy(temp, src);
	}

	public static void main(String[] args) throws Exception, Throwable {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.flipkart.com");
		FileInputStream fisExcel = new FileInputStream("./TestData/Tek_data.xlsx");
		Workbook wb = WorkbookFactory.create(fisExcel);
		String pro = wb.getSheet("watch").getRow(1).getCell(0).toString();
		driver.findElement(By.name("q")).sendKeys(pro);


		String pId = driver.getWindowHandle();
		Actions act=new Actions(driver);
		act.keyDown(Keys.ENTER).perform();

		//===============================1st=====================
		
		WebElement w1 = driver.findElement(By.xpath("//a[@title='Chief Series Analog Watch  - For Men DZ4417']"));
		act.moveToElement(w1).click().perform();

		Set<String> allIds = driver.getWindowHandles();
		for(String id:allIds) {
			driver.switchTo().window(id);
		}
		String productName = "";
		for (int i = 0; i < 5; i++) {
			try {
				productName = driver.findElement(By.xpath("//span[contains(text(),'Chief Series Analog Watch')]")).getText();
				break;
			} catch (StaleElementReferenceException e) {
				Thread.sleep(500);
			}
		}
		
		System.out.println(productName);
		toTakeSs(productName);
		Cell proName = wb.getSheet("watch").getRow(1).createCell(1);
		proName.setCellValue(productName);

		String price1 = driver.findElement(By.xpath("//div[text()='₹10,996']")).getText();
		System.out.println(price1);
		Cell priceNo1 = wb.getSheet("watch").getRow(1).createCell(2);
		priceNo1.setCellValue(price1);

		driver.findElement(By.xpath("//div[text()='Product Details']/..//img")).click();
		List<WebElement> pro1Detail = driver.findElements(By.xpath("//div[@class='_Fj5V_ AD0eNr']"));
		for (WebElement w : pro1Detail) {
			String text = w.getText().trim();
			if (!text.isEmpty()) {
				System.out.println(text);

				Cell prodel1 = wb.getSheet("watch").getRow(1).createCell(3);
				prodel1.setCellValue(text);

			}
		}
		driver.close();
		driver.switchTo().window(pId);

		// ===============================2nd===================================

		WebElement w2 = driver.findElement(By.xpath("//a[@title='Caged Analog Watch  - For Men DZ1949']"));
		act.moveToElement(w2).click().perform();

		Set<String> allIds1 = driver.getWindowHandles();
		for(String id:allIds1) {
			driver.switchTo().window(id);
		}
		String productName1 = "";
		for (int i = 0; i < 5; i++) {
			try {
				productName1 = driver.findElement(By.xpath("//span[contains(text(),'Caged Analog Watch')]")).getText();
				break;
			} catch (StaleElementReferenceException e) {
				Thread.sleep(500);
			}
		}
		System.out.println(productName1);
		toTakeSs(productName1);
		Cell proName2 = wb.getSheet("watch").createRow(2).createCell(1);
		proName2.setCellValue(productName1);

		String price2 = driver.findElement(By.xpath("//div[text()='₹10,446']")).getText();
		System.out.println(price2);
		Cell priceNo2 = wb.getSheet("watch").getRow(2).createCell(2);
		priceNo2.setCellValue(price2);
		
		driver.findElement(By.xpath("//div[text()='Product Details']/..//img")).click();

		List<WebElement> pro2Detail = driver.findElements(By.xpath("//div[@class='_Fj5V_ AD0eNr']"));
		for (WebElement w : pro2Detail) {
			String text = w.getText().trim();
			if (!text.isEmpty()) {
				System.out.println(text);
				Cell prodel1 = wb.getSheet("watch").getRow(2).createCell(3);
				prodel1.setCellValue(text);

			}
		}
		driver.close();
		driver.switchTo().window(pId);

		//==================================3rd============================
		
		WebElement w3 = driver.findElement(By.xpath("//a[@title='s Mega Chief - DZ4465 Analog Watch  - For Men DZ4465']"));
		act.moveToElement(w3).click().perform();

		Set<String> allIds2 = driver.getWindowHandles();
		for(String id:allIds2) {
			driver.switchTo().window(id);
		}
		String productName2 = "";
		for (int i = 0; i < 5; i++) {
			try {
				productName2 = driver.findElement(By.xpath("//span[contains(text(),'s Mega Chief - DZ4465 Analog Watch')]")).getText();
				break;
			} catch (StaleElementReferenceException e) {
				Thread.sleep(500);
			}
		}
		System.out.println(productName2);
		toTakeSs(productName2);
		Cell proName3 = wb.getSheet("watch").createRow(3).createCell(1);
		proName3.setCellValue(productName2);

		String price3 = driver.findElement(By.xpath("//div[text()='₹11,271']")).getText();
		System.out.println(price3);
		Cell priceNo3 = wb.getSheet("watch").getRow(3).createCell(2);
		priceNo3.setCellValue(price3);
		
		driver.findElement(By.xpath("//div[text()='Product Details']/..//img")).click();
		List<WebElement> pro3Detail = driver.findElements(By.xpath("//div[@class='_Fj5V_ AD0eNr']"));
		for (WebElement w : pro3Detail) {
			String text = w.getText().trim();
			if (!text.isEmpty()) {
				System.out.println(text);
				Cell prodel1 = wb.getSheet("watch").getRow(3).createCell(3);
				prodel1.setCellValue(text);

				FileOutputStream fos11 = new FileOutputStream("./TestData/Tek_data.xlsx");
				wb.write(fos11);
			}
		}
		driver.close();
		wb.close();
		driver.switchTo().window(pId);
		driver.quit();
	}
}
