package tests.android.security;

import org.testng.annotations.Test;

import utilities.TestBase;
import dbmodel.*;
import dbmodel.DataPreparation.User;
import pages.android.security.pageAnaEkran;
import pages.android.security.pageAracTeslim;
import pages.android.security.pageGirisEkrani;

public class Arac_Teslim extends TestBase {
	Provider provider = new Provider();
	pageGirisEkrani giris_Ekrani;
	pageAracTeslim arac_Teslim;
	User user;
	
	String param_1;
	String param_2;
	String param_3;
	String param_4;
	String param_5;

// *********Constructor*********
	public Arac_Teslim() {
		queryGetParameters = "select * from security_app_test_parameters order by tc_id;";
		
	}

// ******************************************************* TEST ***********************************************************
	
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 26)
	public void TC_026_Arac_Teslim_Al_Basarili_Sorun_Yok() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		arac_Teslim = new pageAracTeslim(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser(param_1, param_3)
		.addSecurityUserShift(param_1, param_3)
		.deleteVehicleFromUser(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		arac_Teslim
		.Arac_Teslim_Al_Sorun_Yok();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 27)
	public void TC_027_Arac_Teslim_Al_Basarili_Sorun_Var() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		arac_Teslim = new pageAracTeslim(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser(param_1, param_3)
		.addSecurityUserShift(param_1, param_3)
		.deleteVehicleFromUser(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		arac_Teslim
		.Arac_Teslim_Al_Sorun_Var();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 28)
	public void TC_028_Arac_Teslim_Al_Basarili_Yanci() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		arac_Teslim = new pageAracTeslim(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser("5309945452", param_3)
		.addSecurityUserShift("5309945452", param_3)
		.addSecurityUserShift(param_1, param_3)
		.deleteVehicleFromUser(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		arac_Teslim
		.Arac_Teslim_Al_Basarili_Yanci();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 31)
	public void TC_031_Arac_Teslim_Al_Basarisiz_Hatali_KM() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		arac_Teslim = new pageAracTeslim(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser(param_1, param_3)
		.addSecurityUserShift(param_1, param_3)
		.deleteVehicleFromUser(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		arac_Teslim
		.Arac_Teslim_Al_Basarisiz_Hatali_KM();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 32)
	public void TC_032_Arac_Teslim_Al_Basarisiz_Eksik_Foto() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		arac_Teslim = new pageAracTeslim(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser(param_1, param_3)
		.addSecurityUserShift(param_1, param_3)
		.deleteVehicleFromUser(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		arac_Teslim
		.Arac_Teslim_Al_Basarisiz_Eksik_Foto();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 33)
	public void TC_033_Arac_Teslim_Al_Basarisiz_Eksik_Detay() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		arac_Teslim = new pageAracTeslim(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser(param_1, param_3)
		.addSecurityUserShift(param_1, param_3)
		.deleteVehicleFromUser(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		arac_Teslim
		.Arac_Teslim_Al_Basarisiz_Eksik_Detay();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 34)
	public void TC_034_Arac_Teslim_Et_Basarili_Sorun_Yok() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		arac_Teslim = new pageAracTeslim(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser(param_1, param_3)
		.addSecurityUserShift(param_1, param_3);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		arac_Teslim
		.Arac_Teslim_Et_Basarili_Sorun_Yok();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 35)
	public void TC_035_Arac_Teslim_Et_Basarili_Sorun_Var() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		arac_Teslim = new pageAracTeslim(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser(param_1, param_3)
		.addSecurityUserShift(param_1, param_3);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		arac_Teslim
		.Arac_Teslim_Et_Basarili_Sorun_Var();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 39)
	public void TC_039_Arac_Teslim_Et_Basarisiz_Hatali_KM() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		arac_Teslim = new pageAracTeslim(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser(param_1, param_3)
		.addSecurityUserShift(param_1, param_3);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		arac_Teslim
		.Arac_Teslim_Et_Basarisiz_Hatali_KM();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 40)
	public void TC_040_Arac_Teslim_Et_Basarisiz_Eksik_Foto() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		arac_Teslim = new pageAracTeslim(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser(param_1, param_3)
		.addSecurityUserShift(param_1, param_3);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		arac_Teslim
		.Arac_Teslim_Et_Basarisiz_Eksik_Foto();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 41)
	public void TC_041_Arac_Teslim_Et_Basarisiz_Eksik_Detay() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		arac_Teslim = new pageAracTeslim(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser(param_1, param_3)
		.addSecurityUserShift(param_1, param_3);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		arac_Teslim
		.Arac_Teslim_Et_Basarisiz_Eksik_Detay();
	}
}

