package tests.android.security;

import org.testng.annotations.Test;

import dbmodel.Provider;
import dbmodel.DataPreparation.User;
import pages.android.security.pageAracTeslim;
import pages.android.security.pageGirisEkrani;
import pages.android.security.pageHaritaDetay;
import pages.android.security.pageTumIslerim;
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

	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 32)
	public void TC_032_Isleme_Basla_Buton_Kontrolu() {
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
		.addSecurityAllTasks(param_1, param_2, param_4);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		harita_Detay
		.Isleme_Basla_Buton_Kontrolu();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 33)
	public void TC_033_Baska_Bir_Gorev_Yapacagim_Kontrolu() {
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
		.addSecurityAllTasks(param_1, param_2, param_4);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		harita_Detay
		.Baska_Bir_Gorev_Yapacagim_Kontrolu();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 34)
	public void TC_034_Calinti_Is_Emri_Detay() {
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
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 35)
	public void TC_035_Supheli_Is_Emri_Detay() {
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
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 36)
	public void TC_036_Bulunamadi_Is_Emri_Detay() {
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
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 37)
	public void TC_037_Musteri_Is_Emri_Detay() {
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
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 38)
	public void TC_038_Kilit_Kontrol_Is_Emri_Detay() {
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
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 39)
	public void TC_039_Calinmis_Basarili() {
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
		.Calinmis_Basarili(param_1, param_2);
	}
}
