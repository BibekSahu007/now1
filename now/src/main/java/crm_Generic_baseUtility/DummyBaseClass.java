package crm_Generic_baseUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class DummyBaseClass {
//@BeforeSuite
//public void bs1() {
//	System.out.println("=======Before Suite=========");
//}
//@BeforeClass
//public void bc1() {
//	System.out.println("=======Befor Class=========");
//}
//@BeforeMethod
//public void bm1() {
//	System.out.println("=======Before Method=========");
//}
@BeforeSuite
public void bs() {
	System.out.println("=======Before Suite=========");
}
@BeforeClass
public void bc() {
	System.out.println("=======Befor Class=========");
}
@BeforeMethod
public void bm() {
	System.out.println("=======Befor Method=========");
}
@BeforeTest
public void bt() {
	System.out.println("=======Befor Test=========");
}
@AfterMethod
public void am() {
	System.out.println("=======After Method=========");
}
@AfterClass
public void ac() {
	System.out.println("=======After Class=========");
}
@AfterTest
public void at() {
	System.out.println("=======After Test=========");
}
@AfterSuite
public void as() {
	System.out.println("=======After Suite=========");
}
}
