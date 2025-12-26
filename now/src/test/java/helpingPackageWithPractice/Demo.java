package helpingPackageWithPractice;

import java.util.Date;

import org.openqa.selenium.WebDriver;

public class Demo {

	public static void main(String[] args) {
		String time= new Date().toString().replace(" ", "_").replace(":", "_");
		System.out.println(time);
		WebDriver driver;
	}

}
