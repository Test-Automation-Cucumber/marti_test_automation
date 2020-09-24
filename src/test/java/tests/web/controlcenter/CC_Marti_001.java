package tests.web.controlcenter;

import org.testng.annotations.Test;

import dbmodel.Provider;
import pages.web.controlcenter.*;
import utilities.TestBase;

public class CC_Marti_001 extends TestBase {
	Provider provider = new Provider();
	HomePage homePage;
	String param_1;
	String param_2;

// *********Constructor*********
	public CC_Marti_001() {
		queryGetParameters = "select * from ride_app_test_parameters order by tc_id;";
		System.setProperty("platformName", "web");
		System.setProperty("appName", "controlcenter");
	}

// ******************************************************* TEST ***********************************************************

	@Test(priority = 0)
	public void TC_001_Surus_Kontrolu() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		
		// *******************PAGE INSTANTIATIONS*******************
		homePage = new HomePage(driver);
		
		// ***********PAGE METHODS**************
		homePage
		.goToUrl("https://www.google.com.tr");
	}
}
