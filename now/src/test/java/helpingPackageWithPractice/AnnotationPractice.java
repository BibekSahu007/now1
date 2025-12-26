package helpingPackageWithPractice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import crm_Generic_baseUtility.DummyBaseClass;
@Listeners(crm_listernerUtility.DummyListeners.class)
public class AnnotationPractice extends DummyBaseClass{
	@Test
	public void anno() {
		System.out.println("++++++++ A1 ++++++++");
	}
	@Test
	public void annoo() {
		System.out.println("++++++++ A2 ++++++++");
	}

}
