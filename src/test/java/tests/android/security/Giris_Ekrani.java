package tests.android.security;

import org.testng.annotations.Test;

import utilities.TestBase;
import dbmodel.*;
import dbmodel.DataPreparation.User;
import pages.android.security.pageGirisEkrani;

public class Giris_Ekrani extends TestBase {
	Provider provider = new Provider();
	pageGirisEkrani giris_Ekrani;
	User user;

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
	
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 1)
	public void TC_001_Giris_Basarisiz_Telefon_No_Yok() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarisiz_Telefon_No_Yok();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 2)
	public void TC_002_Giris_Basarisiz_Telefon_No_Eksik() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarisiz_Telefon_No_Eksik();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 3)
	public void TC_003_Giris_Basarisiz_Hatali_Kullanici() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarisiz_Hatali_Kullanici();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 4)
	public void TC_004_Giris_Basarisiz_Yanlis_Rol() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarisiz_Yanlis_Rol();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 5)
	public void TC_005_Giris_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarili(param_1);
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 6)
	public void TC_006_Tanimlanmamis_Vardiya() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		user = new User();
	
		// ***********CASE DEPENDENCIES**************
		user
		.deleteUserShift(param_1)
		.deleteVehicleFromUser(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1)
		.Tanimlanmamis_Vardiya(param_1);
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 7)
	public void TC_007_Hatali_Otp() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Hatali_Otp(param_1);
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 8)
	public void TC_008_Eksik_Otp() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarili(param_1)
		.Eksik_Otp(param_1);
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 9)
	public void TC_009_Bos_Otp() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Bos_Otp(param_1);
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 10)
	public void TC_010_Tekrar_Otp_Gonder() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];
		
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser(param_1, param_3)
		.addSecurityUserShift(param_1, param_3);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Tekrar_Otp_Gonder(param_1);
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 11)
	public void TC_011_Otp_Dogrulama_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);

		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 12)
	public void TC_012_Vardiyasiz_Giris_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];
		
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		user = new User();
	
		// ***********CASE DEPENDENCIES**************
		user
		.deleteUserShift(param_1)
		.addVehicleToUser(param_1, param_3);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1)
		.Tanimlanmamis_Vardiyali_Giris(param_1);
	}	
}

