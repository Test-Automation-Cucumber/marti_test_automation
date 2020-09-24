package tests.web.marti;

import dbmodel.Provider;
import pages.ios.pageYuklemeEkrani;
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

//	//ekran cok hizli yuklendigi icin splash screen ekrani yakalamiyor.
//	@Test(priority = 0)
//	public void Yukleme_Ekrani_Basarili() {
//// ***********PAGE INSTANTIATIONS*******
//		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
//		
//		// ***********PAGE METHODS**************
//		yukleme_Ekrani
//		.Yukleme_Ekrani_Basarili();
//	}

}
