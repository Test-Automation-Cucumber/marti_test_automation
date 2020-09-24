package tests.ios.ride;

import org.testng.annotations.Test;

import utilities.TestBase;
import dbmodel.*;
import pages.ios.pageGirisEkrani;

public class Giris_Ekrani extends TestBase {
	Provider provider = new Provider();
	pageGirisEkrani giris_Ekrani;
	String methodName;
	String param_1;
	String param_2;
	String param_3;
	String param_4;
	String param_5;

// *********Constructor*********
	public Giris_Ekrani() {
		queryGetParameters = "select * from ride_app_test_parameters order by tc_id;";
		System.setProperty("platformName", "ios");
		System.setProperty("appName", "ride");
	}

// ******************************************************* TEST ***********************************************************

//	@Test(priority = 10)
//	public void TC_010_Giris_Basarili() {  bunu zaten yukleme ekraninda kosuyorsun. ilerde genisletilmek istenirse burdan genisletirsin case'i
//// ***********PAGE INSTANTIATIONS*******
//		giris_Ekrani = new pageGirisEkrani(androidDriver); 
//	
//// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Giris_Basarili(customerPhoneNumber);
//	}
	@Test(priority = 11)
	public void TC_011_Giris_Basarisiz() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarisiz(param_1);
	}

	@Test(priority = 12)
	public void TC_012_Dogrulama_Basarisiz() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Dogrulama_Basarisiz(param_1);
	}
	@Test(priority = 13)
	public void TC_013_Tekrar_Kod_Gonder() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Tekrar_Kod_Gonder(param_1);
	}
//	@Test(priority = 14)  kullanıcı sözleşmesinin yeri androidde değişti. bunda da deişicektir. hold
//	public void TC_014_Kullanici_Sozlesmesi() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		// *******************PAGE INSTANTIATIONS*******************
//		giris_Ekrani = new pageGirisEkrani(iosDriver);
//		// ***********PAGE METHODS**************
//		giris_Ekrani.Kullanici_Sozlesmesi(param_1);
//	}
//
//	@Test(priority = 15) ülke kodu değiştirme kalktı anroidde bunda da kalkar heralde.
//	public void TC_015_Ulke_Kodu_Degistirme() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		// *******************PAGE INSTANTIATIONS*******************
//		giris_Ekrani = new pageGirisEkrani(iosDriver);
//		// ***********PAGE METHODS**************
//		giris_Ekrani.Ulke_Kodu_Degistirme();
//	}

}
