package tests.ride.ios;

import org.testng.annotations.Test;

import dbmodel.Provider;
import utilities.TestBase;
import pages.device.ios.pageBorclar;
import pages.device.ios.pageGirisEkrani;

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
		queryGetParameters = "select * from ride_app_test_parameters order by tc_id;";
		System.setProperty("platformName", "ios");
		System.setProperty("appName", "ride");
	}

// ******************************************************* TEST ***********************************************************
	
	@Test(priority = 29)
	public void TC_029_Borclu_Kullanici() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		// *******************PAGE INSTANTIATIONS*******************
		borclar = new pageBorclar(iosDriver);
		// ***********PAGE METHODS**************
		borclar.Borclu_Kullanici(param_1, param_2);
			}
	@Test(priority = 30)
	public void TC_030_Borclu_Kullanici_Plus_15() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		borclar = new pageBorclar(iosDriver);
		// ***********PAGE METHODS**************
		borclar.Borclu_Kullanici_Plus_15(param_1);
			}
	@Test(priority = 31)
	public void TC_031_Borc_Odeme() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		borclar = new pageBorclar(iosDriver);
		// ***********PAGE METHODS**************
		borclar.Borc_Odeme(param_1);
			}
	@Test(priority = 32)
	public void TC_032_Borc_Odeme_Islemi_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		borclar = new pageBorclar(iosDriver);

		// ***********PAGE METHODS**************
		borclar.Borc_Odeme_Islemi_Basarili(param_1);
			}
	@Test(priority = 33)
	public void TC_033_Borc_Odeme_Islemi_Basarisiz() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		borclar = new pageBorclar(iosDriver);
		// ***********PAGE METHODS**************
		borclar.Borc_Odeme_Islemi_Basarisiz(param_1);
	}

}
