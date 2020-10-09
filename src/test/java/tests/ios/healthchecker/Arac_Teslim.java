package tests.ios.healthchecker;

import org.testng.annotations.Test;

import utilities.TestBase;
import dbmodel.*;
import dbmodel.DataPreparation.User;
import pages.ios.healthchecker.pageAracTeslim;
import pages.ios.healthchecker.pageGirisEkrani;

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
		queryGetParameters = "select * from health_checker_app_test_parameters order by tc_id;";
	}

// ******************************************************* TEST ***********************************************************
	
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 13)
	public void TC_013_Arac_Teslim_Al_Basarili_Sorun_Yok() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		arac_Teslim = new pageAracTeslim(iosDriver);
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
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 14)
	public void TC_027_Arac_Teslim_Al_Basarili_Sorun_Var() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		arac_Teslim = new pageAracTeslim(iosDriver);
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
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 15)
	public void TC_028_Arac_Teslim_Al_Basarili_Yanci() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		arac_Teslim = new pageAracTeslim(iosDriver);
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
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 16)
	public void TC_031_Arac_Teslim_Al_Basarisiz_Hatali_KM() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		arac_Teslim = new pageAracTeslim(iosDriver);
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
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 17)
	public void TC_032_Arac_Teslim_Al_Basarisiz_Eksik_Foto() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		arac_Teslim = new pageAracTeslim(iosDriver);
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
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 18)
	public void TC_033_Arac_Teslim_Al_Basarisiz_Eksik_Detay() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		arac_Teslim = new pageAracTeslim(iosDriver);
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
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 19)
	public void TC_034_Arac_Teslim_Et_Basarili_Sorun_Yok() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		arac_Teslim = new pageAracTeslim(iosDriver);
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
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 20)
	public void TC_035_Arac_Teslim_Et_Basarili_Sorun_Var() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		arac_Teslim = new pageAracTeslim(iosDriver);
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
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 22)
	public void TC_039_Arac_Teslim_Et_Basarisiz_Hatali_KM() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		arac_Teslim = new pageAracTeslim(iosDriver);
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
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 23)
	public void TC_040_Arac_Teslim_Et_Basarisiz_Eksik_Foto() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		arac_Teslim = new pageAracTeslim(iosDriver);
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
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 24)
	public void TC_041_Arac_Teslim_Et_Basarisiz_Eksik_Detay() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		arac_Teslim = new pageAracTeslim(iosDriver);
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

