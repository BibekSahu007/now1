package helpingPackageWithPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetProductInfo {
	@Test
	(dataProviderClass = to_UseDataProvider.class, dataProvider = "getdata")
	public void getProductInfo(String bname, String pname) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(bname);
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		String x = "(//span[contains(text(),'"+pname+"')])[1]/../../../..//span[@class='a-price-whole']";
		String p = driver.findElement(By.xpath(x)).getText();
		System.out.println(p);
		
		Thread.sleep(2000);
		driver.quit();
	}
	
}
