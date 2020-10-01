package tests.android.security;

import org.testng.annotations.Test;

import utilities.TestBase;
import dbmodel.*;
import pages.android.security.pageGirisEkrani;

public class Giris_Ekrani extends TestBase {
	Provider provider = new Provider();
	pageGirisEkrani giris_Ekrani;

	String param_1;
	String param_2;
	String param_3;
	String param_4;
	String param_5;

// *********Constructor*********
	public Giris_Ekrani() {
		queryGetParameters = "select * from security_app_test_parameters order by tc_id;";
	}

// ******************************************************* TEST ***********************************************************
	
//	@Test(priority = 5)
//	public void TC_005_Giris_Basarisiz_Baglanti_Yok() { loading simgesi dönüp duruyor sadece.
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		// *******************PAGE INSTANTIATIONS*******************
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		// ***********PAGE METHODS**************
//		giris_Ekrani.Giris_Basarisiz_Baglanti_Yok();
//	}
	@Test(priority = 6)
	public void TC_006_Giris_Basarisiz_Telefon_No_Yok() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarisiz_Telefon_No_Yok();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 7)
	public void TC_007_Giris_Basarisiz_Telefon_No_Eksik() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarisiz_Telefon_No_Eksik();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 8)
	public void TC_008_Giris_Basarisiz_Hatali_Kullanici() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarisiz_Hatali_Kullanici();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 9)
	public void TC_009_Giris_Basarisiz_Yanlis_Rol() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarisiz_Yanlis_Rol();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 10)
	public void TC_010_Giris_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarili(param_1);
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 11)
	public void TC_011_Giris_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarili(param_1);
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 12)
	public void TC_012_Hatali_Otp() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarili(param_1)
		.Hatali_Otp(param_1);
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 13)
	public void TC_013_Eksik_Otp() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarili(param_1)
		.Eksik_Otp(param_1);
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 14)
	public void TC_014_Bos_Otp() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarili(param_1)
		.Bos_Otp(param_1);
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 15)
	public void TC_015_Tekrar_Otp_Gonder() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarili(param_1)
		.Tekrar_Otp_Gonder(param_1);
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 16)
	public void TC_016_Otp_Dogrulama_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
	}
}

