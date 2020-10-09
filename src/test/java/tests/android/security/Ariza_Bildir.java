package tests.android.security;

import org.testng.annotations.Test;

import dbmodel.Provider;
import dbmodel.DataPreparation.Scooter;
import dbmodel.DataPreparation.User;
import pages.android.security.pageArizaBildir;
import pages.android.security.pageGirisEkrani;
import utilities.TestBase;

public class Ariza_Bildir extends TestBase {
	Provider provider = new Provider();
	pageGirisEkrani giris_Ekrani;
	pageArizaBildir ariza_Bildir;
	User user;
	Scooter scooter;
	
	String param_1;
	String param_2;
	String param_3;
	String param_4;
	String param_5;

// *********Constructor*********
	public Ariza_Bildir() {
		queryGetParameters = "select * from security_app_test_parameters order by tc_id;";
	}

// ******************************************************* TEST ***********************************************************

	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 40)
	public void TC_040_Ariza_Bildir() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		param_3 = testParameters[caseId][3];
		param_4 = testParameters[caseId][4];

		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		ariza_Bildir = new pageArizaBildir(androidDriver);
		user = new User();
		scooter = new Scooter();
		// ***********CASE DEPENDENCIES**************
		scooter
		.addScooter(param_2, param_4);
		
		user
		.addVehicleToUser(param_1, param_3)
		.addSecurityUserShift(param_1, param_3);
//		.deleteUserTasks(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1)
		.Otp_Dogrulama_Basarili(param_1);
		
		ariza_Bildir
		.Ariza_Bildir(param_2);
	}
}
