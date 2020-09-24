package tests.web.marti;

import org.testng.annotations.Test;

import dbmodel.Provider;
import pages.ios.ride.pageYuklemeEkrani;
import utilities.TestBase;

public class Test_Marti_001 extends TestBase {
	Provider provider = new Provider();
	pageYuklemeEkrani yukleme_Ekrani;
	String methodName;
	String param_1;
	String param_2;

// *********Constructor*********
	public Test_Marti_001() {
		queryGetParameters = "select * from ride_app_test_parameters order by tc_id;";
		System.setProperty("platformName", "web");
		System.setProperty("appName", "marti");
	}

// ******************************************************* TEST ***********************************************************

	@Test(priority = 0)
	public void TC_001_Surus_Kontrolu() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(iosDriver);
		// ***********PAGE METHODS**************
		yukleme_Ekrani.Surus_Kontrolu(param_1, param_2);
	}

}
