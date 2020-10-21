package tests.ios.ride;

import org.testng.annotations.Test;

import utilities.TestBase;
import dbmodel.*;
import dbmodel.DataPreparation.TestDevice;
import pages.ios.ride.pageGirisEkrani;

public class Giris_Ekrani extends TestBase {
	Provider provider = new Provider();
	pageGirisEkrani giris_Ekrani;
	TestDevice testDevice;
	String param_1;
	String param_2;
	String param_3;
	String param_4;
	String param_5;

// *********Constructor*********
	public Giris_Ekrani() {
		queryGetParameters = "select * from ride_app_test_parameters order by tc_id;";
		System.setProperty("appName", "ride");
		System.setProperty("platformName", "ios");
		System.setProperty("deviceName", "iPhone5S");
		System.setProperty("startLogin", "no");
	}

// ******************************************************* TEST ***********************************************************
	@Test(priority = 12)
	public void TC_012_Giris_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		
		// ***********CASE DEPENDENCIES**************
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1);
	}
	@Test(priority = 13)
	public void TC_013_Giris_Basarisiz() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		
		// ***********CASE DEPENDENCIES**************
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarisiz(param_1);
	}
	@Test(priority = 14)
	public void TC_014_Dogrulama_Basarisiz() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		
		// ***********CASE DEPENDENCIES**************
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Dogrulama_Basarisiz(param_1);
	}
	@Test(priority = 15)
	public void TC_015_Tekrar_Kod_Gonder() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		
		// ***********CASE DEPENDENCIES**************
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Tekrar_Kod_Gonder(param_1);
	}
	@Test(priority = 16)
	public void TC_016_Kullanici_Sozlesmesi_Goster_Onayla() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		testDevice = new TestDevice();
		
		// ***********CASE DEPENDENCIES**************
		testDevice
		.resetCustomerLoginStatus(param_1)
		.restartApp(iosDriver);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Kullanici_Sozlesmesi();
	}
	@Test(priority = 17)
	public void TC_017_Aydinlatma_Metni_Goster_Onayla() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		testDevice = new TestDevice();
		
		// ***********CASE DEPENDENCIES**************
		testDevice
		.resetCustomerLoginStatus(param_1)
		.restartApp(iosDriver);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Aydinlatma_Metni();
	}
	@Test(priority = 18)
	public void TC_018_Acik_Riza_Metni_Goster_Onayla() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		testDevice = new TestDevice();
		
		// ***********CASE DEPENDENCIES**************
		testDevice
		.resetCustomerLoginStatus(param_1)
		.restartApp(iosDriver);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Acik_Riza_Metni();
	}
	@Test(priority = 19)
	public void TC_019_Ulke_Kodu_Degistirme() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		testDevice = new TestDevice();
		
		// ***********CASE DEPENDENCIES**************
		testDevice
		.resetCustomerLoginStatus(param_1)
		.restartApp(iosDriver);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Ulke_Kodu_Degistirme();
	}
}
