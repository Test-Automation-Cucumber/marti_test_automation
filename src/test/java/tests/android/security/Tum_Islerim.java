package tests.android.security;

import org.testng.annotations.Test;

import dbmodel.Provider;
import dbmodel.DataPreparation.User;
import pages.android.security.pageGirisEkrani;
import pages.android.security.pageTumIslerim;
import utilities.TestBase;

public class Tum_Islerim extends TestBase {
	Provider provider = new Provider();
	pageGirisEkrani giris_Ekrani;
	pageTumIslerim tum_Islerim;
	User user;
	String param_1;
	String param_2;
	String param_3;
	String param_4;
	String param_5;

// *********Constructor*********
	public Tum_Islerim() {
		queryGetParameters = "select * from security_app_test_parameters order by tc_id;";
	}

// ******************************************************* TEST ***********************************************************

	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 29)
	public void TC_030_Tum_Islerim_Listesi() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		param_3 = testParameters[caseId][3];
		param_4 = testParameters[caseId][4];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		tum_Islerim = new pageTumIslerim(androidDriver);
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
		
		tum_Islerim
		.Tum_Islerim_Listesi(param_2);
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 30)
	public void TC_055_Tum_Islerim_Detay_Aktif_Isi_Yok() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		param_3 = testParameters[caseId][3];
		param_4 = testParameters[caseId][4];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		tum_Islerim = new pageTumIslerim(androidDriver);
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
		
		tum_Islerim
		.Tum_Islerim_Detay_Aktif_Isi_Yok();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 31)
	public void TC_032_Tum_Islerim_Detay_Aktif_Isi_Var() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		param_3 = testParameters[caseId][3];
		param_4 = testParameters[caseId][4];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		tum_Islerim = new pageTumIslerim(androidDriver);
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
		
		tum_Islerim
		.Tum_Islerim_Detay_Aktif_Isi_Var();
	}
	
}
