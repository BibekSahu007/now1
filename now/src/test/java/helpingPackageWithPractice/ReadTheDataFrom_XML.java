package helpingPackageWithPractice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadTheDataFrom_XML {
@Test
	public void toReadData(XmlTest test) {
	System.out.println(test.getParameter("name"));
	System.out.println(test.getParameter("company"));
	}
}
