package tests.android.security;

import org.testng.annotations.Test;

import dbmodel.Provider;
import dbmodel.DataPreparation.User;
import pages.android.security.pageAracTeslim;
import pages.android.security.pageGirisEkrani;
import pages.android.security.pageHaritaDetay;
import pages.android.security.pageTumIslerim;
import pages.android.security.pageYuklemeEkrani;
import utilities.TestBase;

public class Harita_Detay extends TestBase {
	Provider provider = new Provider();
	pageGirisEkrani giris_Ekrani;
	pageHaritaDetay harita_Detay;
	User user;
	String param_1;
	String param_2;
	String param_3;
	String param_4;
	String param_5;

// *********Constructor*********
	public Harita_Detay() {
		queryGetParameters = "select * from security_app_test_parameters order by tc_id;";
	}

// ******************************************************* TEST ***********************************************************

//	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 58)
//	public void TC_058_Isleme_Basla_Buton_Kontrolu() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//		param_4 = testParameters[caseId][4];
//
//		// *******************PAGE INSTANTIATIONS*******************
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		harita_Detay = new pageHaritaDetay(androidDriver);
//		user = new User();
//		
//		// ***********CASE DEPENDENCIES**************
//		user
//		.addVehicleToUser(param_1, param_3)
//		.addSecurityUserShift(param_1, param_3)
//		.addSecurityAllTasks(param_1, param_2, param_4);
//		
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Giris_Basarili(param_1)
//		.Otp_Dogrulama_Basarili(param_1);
//		
//		harita_Detay
//		.Isleme_Basla_Buton_Kontrolu();
//	}
//	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 59)
//	public void TC_059_Baska_Bir_Gorev_Yapacagim_Kontrolu() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//		param_4 = testParameters[caseId][4];
//
//		// *******************PAGE INSTANTIATIONS*******************
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		harita_Detay = new pageHaritaDetay(androidDriver);
//		user = new User();
//		
//		// ***********CASE DEPENDENCIES**************
//		user
//		.addVehicleToUser(param_1, param_3)
//		.addSecurityUserShift(param_1, param_3)
//		.addSecurityAllTasks(param_1, param_2, param_4);
//		
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Giris_Basarili(param_1)
//		.Otp_Dogrulama_Basarili(param_1);
//		
//		harita_Detay
//		.Baska_Bir_Gorev_Yapacagim_Kontrolu();
//	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 60)
	public void TC_060_Calinti_Is_Emri_Detay() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		param_3 = testParameters[caseId][3];
		param_4 = testParameters[caseId][4];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		harita_Detay = new pageHaritaDetay(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser(param_1, param_3)
		.addSecurityUserShift(param_1, param_3)
		.addSecurityStolenTask(param_1, param_2, param_4);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		harita_Detay
		.Calinti_Is_Emri_Detay(param_2);
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 61)
	public void TC_061_Supheli_Is_Emri_Detay() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		param_3 = testParameters[caseId][3];
		param_4 = testParameters[caseId][4];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		harita_Detay = new pageHaritaDetay(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser(param_1, param_3)
		.addSecurityUserShift(param_1, param_3)
		.addSecuritySuspectTask(param_1, param_2, param_4);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		harita_Detay
		.Supheli_Is_Emri_Detay();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 62)
	public void TC_062_Bulunamadi_Is_Emri_Detay() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		param_3 = testParameters[caseId][3];
		param_4 = testParameters[caseId][4];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		harita_Detay = new pageHaritaDetay(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser(param_1, param_3)
		.addSecurityUserShift(param_1, param_3)
		.addSecurityNotFoundTask(param_1, param_2, param_4);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		harita_Detay
		.Bulunamadi_Is_Emri_Detay();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 63)
	public void TC_063_Musteri_Is_Emri_Detay() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		param_3 = testParameters[caseId][3];
		param_4 = testParameters[caseId][4];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		harita_Detay = new pageHaritaDetay(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser(param_1, param_3)
		.addSecurityUserShift(param_1, param_3)
		.addSecurityCustomerTask(param_1, param_2, param_4);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		harita_Detay
		.Musteri_Is_Emri_Detay(param_2);
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 64)
	public void TC_064_Kilit_Kontrol_Is_Emri_Detay() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		param_3 = testParameters[caseId][3];
		param_4 = testParameters[caseId][4];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		harita_Detay = new pageHaritaDetay(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser(param_1, param_3)
		.addSecurityUserShift(param_1, param_3)
		.addSecurityLockControlTask(param_1, param_2, param_4);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		harita_Detay
		.Kilit_Kontrol_Is_Emri_Detay(param_2);
	}
}
