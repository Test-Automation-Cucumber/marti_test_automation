package tests.android.security;

import org.testng.annotations.Test;

import dbmodel.Provider;
import pages.android.security.pageYuklemeEkrani;
import utilities.TestBase;

public class Yukleme_Ekrani extends TestBase {
	Provider provider = new Provider();
	pageYuklemeEkrani yukleme_Ekrani;
	String methodName;
	String param_1;
	String param_2;
	String param_3;
	String param_4;
	String param_5;

// *********Constructor*********
	public Yukleme_Ekrani() {
		queryGetParameters = "select * from security_app_test_parameters order by tc_id;";
	}

// ******************************************************* TEST ***********************************************************

//	//ekran cok hizli yuklendigi icin splash screen ekrani yakalamiyor.
//	@Test(priority = 0)   SLACK ICIN YAPTIN
//	public void TC_001_Yukleme_Ekrani_Basarili() {
//// ***********PAGE INSTANTIATIONS*******
//		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
//		
//		// ***********PAGE METHODS**************
//		yukleme_Ekrani
//		.Yukleme_Ekrani_Basarili();
//	}
//	
//	@Test(priority = 1) // ,dependsOnMethods="method1"
//	public void TC_001_Yukleme_Ekrani_Kamera_Izni() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		// *******************PAGE INSTANTIATIONS*******************
//		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
//		// ***********PAGE METHODS**************
//		yukleme_Ekrani.Yukleme_Ekrani_Basarisiz(param_1);
//	}
//
//	@Test(priority = 2)
//	public void TC_002_Uygulama_Baslangici_Basarili() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		// *******************PAGE INSTANTIATIONS*******************
//		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
//		// ***********PAGE METHODS**************
//		yukleme_Ekrani.Uygulama_Baslangici_Basarili();
//	}
}
