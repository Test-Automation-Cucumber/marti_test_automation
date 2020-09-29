package tests.android.security;

import org.testng.annotations.Test;

import utilities.TestBase;
import dbmodel.*;
import dbmodel.DataPreparation.User;
import pages.android.security.pageAnaEkran;
import pages.android.security.pageGirisEkrani;

public class Ana_Ekran extends TestBase {
	Provider provider = new Provider();
	pageGirisEkrani giris_Ekrani;
	pageAnaEkran ana_Ekran;
	User user;
	
	String param_1;
	String param_2;
	String param_3;
	String param_4;
	String param_5;

// *********Constructor*********
	public Ana_Ekran() {
		queryGetParameters = "select * from security_app_test_parameters order by tc_id;";
		
	}

// ******************************************************* TEST ***********************************************************
	
//	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 18)
//	public void TC_018_Arac_Teslim_Al() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_3 = testParameters[caseId][3];
//
//		// *******************PAGE INSTANTIATIONS*******************
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		ana_Ekran = new pageAnaEkran(androidDriver);
//		user = new User();
//		
//		// ***********CASE DEPENDENCIES**************
//		user
//		.addVehicleToUser(param_1, param_3)
//		.addUserShift(param_1, param_3)
//		.deleteVehicleFromUser(param_1);
//		
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Giris_Basarili(param_1)
//		.Otp_Dogrulama_Basarili(param_1);
//		
//		ana_Ekran
//		.Arac_Teslim_Al_Kontrol();
//	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 19)
	public void TC_019_Giris_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		ana_Ekran = new pageAnaEkran(androidDriver);
		user = new User();
		
		// ***********CASE DEPENDENCIES**************
		user
		.addVehicleToUser(param_1, param_3)
		.addUserShift(param_1, param_3);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		ana_Ekran
		.Arac_Teslim_Et_Kontrol();
	}
}

