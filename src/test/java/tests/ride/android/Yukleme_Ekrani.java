package tests.ride.android;

import org.testng.annotations.Test;

import dbmodel.AES;
import dbmodel.Provider;
import pages.device.android.pageYuklemeEkrani;
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
		queryGetParameters = "select * from ride_app_test_parameters order by tc_id;";
	}

// ******************************************************* TEST ***********************************************************

	//ekran cok hizli yuklendigi icin splash screen ekrani yakalamiyor.
	@Test(priority = 0)   //SLACK ICIN YAPTIN
	public void TC_001_Yukleme_Ekrani_Basarili() {
// ***********PAGE INSTANTIATIONS*******
		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
		
		// ***********PAGE METHODS**************
		yukleme_Ekrani
		.Yukleme_Ekrani_Basarili();
	}
	@Test(priority = 1) // ,dependsOnMethods="method1"
	public void TC_001_Yukleme_Ekrani_Basarisiz() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
		// ***********PAGE METHODS**************
		yukleme_Ekrani.Yukleme_Ekrani_Basarisiz(param_1);
	}

	@Test(priority = 2)
	public void TC_002_Uygulama_Baslangici_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
		// ***********PAGE METHODS**************
		yukleme_Ekrani.Uygulama_Baslangici_Basarili();
	}
//	@Test(priority = 3)
//	public void TC_003_Konum_Izni_Kontrolu() {  konumla alakali caseler sikinti cikariyor
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		// *******************PAGE INSTANTIATIONS*******************
//		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
//		// ***********PAGE METHODS**************
//		yukleme_Ekrani.Konum_Izni_Kontrolu(param_1);
//	}
	@Test(priority = 4)
	public void TC_004_Oturum_Kontrolu_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
		// ***********PAGE METHODS**************
		yukleme_Ekrani.Oturum_Kontrolu_Basarili(param_1);
	}
	@Test(priority = 5)
	public void TC_005_Surus_Kontrolu() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
		// ***********PAGE METHODS**************
		yukleme_Ekrani.Surus_Kontrolu(param_1, param_2);
	}
//	@Test(priority = 6)  bu case'in kosabilmesi icin hq alaninda başka scooter olmamasi gerekiyor
//	public void TC_006_Rezervasyon_Kontrolu() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		// *******************PAGE INSTANTIATIONS*******************
//		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
//		// ***********PAGE METHODS**************
//		yukleme_Ekrani.Rezervasyon_Kontrolu(param_1);
//	}
	@Test(priority = 7)
	public void TC_007_Tckn_Kontrolu() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
		// ***********PAGE METHODS**************
		yukleme_Ekrani.Tckn_Kontrolu(param_1);
	}
////	@Test(priority = 8)
////	public void TC_008_Kvkk_Kontrolu() {
////		// *******************SET PARAMETERS************************
////		param_1 = testParameters[caseId][1];
////		// *******************PAGE INSTANTIATIONS*******************
////		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
////		// ***********PAGE METHODS**************
////		yukleme_Ekrani.Kvkk_Kontrolu(param_1);
////	}
////	@Test(priority = 9)
////	public void Dinamik_Bildirim_Kontrolu() {
////// *******************PAGE INSTANTIATIONS*******************
////		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
////
////		// ***********PAGE METHODS**************
////		yukleme_Ekrani
////		.Dinamik_Bildirim_Kontrolu(customerPhoneNumber);
////	}
}
