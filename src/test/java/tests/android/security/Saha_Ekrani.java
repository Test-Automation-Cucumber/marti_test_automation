package tests.android.security;

import org.testng.annotations.Test;

import dbmodel.Provider;
import dbmodel.DataPreparation.User;
import pages.android.security.pageGirisEkrani;
import pages.android.security.pageSahaEkrani;
import utilities.TestBase;

public class Saha_Ekrani extends TestBase {
	Provider provider = new Provider();
	pageGirisEkrani giris_Ekrani;
	pageSahaEkrani saha_Ekrani;
	User user;
	String param_1;
	String param_2;
	String param_3;
	String param_4;
	String param_5;

// *********Constructor*********
	public Saha_Ekrani() {
		queryGetParameters = "select * from security_app_test_parameters order by tc_id;";
	}

// ******************************************************* TEST ***********************************************************

	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 25)
	public void TC_025_Herhangi_Bir_Gorev_Yok() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		saha_Ekrani = new pageSahaEkrani(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser(param_1, param_3)
		.addSecurityUserShift(param_1, param_3)
		.deleteUserTasks(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		saha_Ekrani
		.Herhangi_Bir_Gorev_Yok();
	}	
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 26)
	public void TC_026_Atanmamis_Calinti_Gorevi_Kontrolu() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		saha_Ekrani = new pageSahaEkrani(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser(param_1, param_3)
		.addSecurityUserShift(param_1, param_3)
		.deleteUserTasks(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
//		saha_Ekrani
//		.Atanmamis_Calinti_Gorevi_Kontrolu();
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 27)
	public void TC_028_Gorev_Gosterimi() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		param_3 = testParameters[caseId][3];
		param_4 = testParameters[caseId][4];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		saha_Ekrani = new pageSahaEkrani(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
//		.addVehicleToUser(param_1, param_3)
//		.addSecurityUserShift(param_1, param_3)
//		.deleteUserTasks(param_1)
		.addSecurityAllTasks(param_1, param_2, param_4);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		saha_Ekrani
		.Gorev_Gosterimi(param_2);
	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 28)
	public void TC_029_Kapatilmamis_Is_Emri() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		param_3 = testParameters[caseId][3];
		param_4 = testParameters[caseId][4];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		saha_Ekrani = new pageSahaEkrani(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addSecurityAllTasks(param_1, param_2, param_4);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		saha_Ekrani
		.Kapatilmamis_Is_Emri();
	}

	
}
