package tests;

import org.testng.annotations.Test;

import dbmodel.Provider;
import utilities.TestBase;
import pages.device.*;

public class Borclar extends TestBase {
	Provider provider = new Provider();
	pageBorclar borclar;
	pageGirisEkrani giris_Ekrani;
	String methodName;
	String param_1;
	String param_2;
	String param_3;
	String param_4;
	String param_5;
	
	
// *********Constructor*********
	public Borclar() {

	}

// ******************************************************* TEST ***********************************************************
	
	@Test(priority = 29)
	public void TC_029_Borclu_Kullanici() {
		// *******************SET PARAMETERS************************
		param_1 = ride_app_test_parameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		borclar = new pageBorclar(androidDriver);
		// ***********PAGE METHODS**************
		borclar.Borclu_Kullanici(param_1);
			}
	@Test(priority = 30)
	public void TC_030_Borclu_Kullanici_Plus_15() {
		// *******************SET PARAMETERS************************
		param_1 = ride_app_test_parameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		borclar = new pageBorclar(androidDriver);
		// ***********PAGE METHODS**************
		borclar.Borclu_Kullanici_Plus_15(param_1);
			}
	@Test(priority = 31)
	public void TC_031_Borc_Odeme() {
		// *******************SET PARAMETERS************************
		param_1 = ride_app_test_parameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		borclar = new pageBorclar(androidDriver);
		// ***********PAGE METHODS**************
		borclar.Borc_Odeme(param_1);
			}
	@Test(priority = 32)
	public void TC_032_Borc_Odeme_Islemi_Basarili() {
		// *******************PAGE INSTANTIATIONS*******************
		borclar = new pageBorclar(androidDriver);

		// ***********PAGE METHODS**************
		borclar.Borc_Odeme_Islemi_Basarili(param_1);
			}
	@Test(priority = 33)
	public void TC_033_Borc_Odeme_Islemi_Basarisiz() {
		// *******************SET PARAMETERS************************
		param_1 = ride_app_test_parameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		borclar = new pageBorclar(androidDriver);
		// ***********PAGE METHODS**************
		borclar.Borc_Odeme_Islemi_Basarisiz(param_1);
	}

}
