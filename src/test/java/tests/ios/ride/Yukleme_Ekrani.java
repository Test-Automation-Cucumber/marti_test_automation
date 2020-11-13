package tests.ios.ride;

import org.testng.annotations.Test;

import dbmodel.Provider;
import dbmodel.DataPreparation.Customer;
import dbmodel.DataPreparation.Scooter;
import pages.ios.ride.pageGirisEkrani;
import pages.ios.ride.pageYuklemeEkrani;
import utilities.TestBase;

public class Yukleme_Ekrani extends TestBase {
	Provider provider = new Provider();
	pageYuklemeEkrani yukleme_Ekrani;
	pageGirisEkrani giris_Ekrani;
	Customer customer;
	Scooter scooter;
	String param_1;
	String param_2;
	String param_3;
	String param_4;
	String param_5;

// *********Constructor*********
	public Yukleme_Ekrani() {
		queryGetParameters = "select * from ride_app_test_parameters order by tc_id;";
		System.setProperty("appName", "ride");
		System.setProperty("platformName", "ios");
		System.setProperty("deviceName", "iPhone7");
		System.setProperty("startLogin", "no");
	}

// ******************************************************* TEST ***********************************************************

//	//ekran cok hizli yuklendigi icin splash screen ekrani yakalamiyor.
//	@Test(priority = 0)
//	public void Yukleme_Ekrani_Basarili() {
//// ***********PAGE INSTANTIATIONS*******
//		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
//		
//		// ***********PAGE METHODS**************
//		yukleme_Ekrani
//		.Yukleme_Ekrani_Basarili();
//	}
//	@Test(priority = 1) // ,dependsOnMethods="method1"
//	public void TC_001_Yukleme_Ekrani_Basarisiz() { internet bağlantisi kesince bir aksiyon olmuyor.
//		// *******************SET PARAMETERS************************
//		param_1 = ride_app_test_parameters[caseId][1];
//		// *******************PAGE INSTANTIATIONS*******************
//		yukleme_Ekrani = new pageYuklemeEkrani(iosDriver);
//		// ***********PAGE METHODS**************
//		yukleme_Ekrani.Yukleme_Ekrani_Basarisiz(param_1);
//	}
	@Test(retryAnalyzer = utilities.RetryTest.class, priority = 2)
	public void TC_002_Uygulama_Baslangici_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(iosDriver);
		
		// ***********CASE DEPENDENCIES**************
		
		// ***********PAGE METHODS**************
		yukleme_Ekrani
		.Uygulama_Baslangici_Basarili(param_1);
	}
//	@Test(priority = 3)
//	public void TC_003_Konum_Izni_Kontrolu() {  konumla alakali caseler sikinti cikariyor
//		// *******************SET PARAMETERS************************
//		param_1 = ride_app_test_parameters[caseId][1];
//		// *******************PAGE INSTANTIATIONS*******************
//		yukleme_Ekrani = new pageYuklemeEkrani(iosDriver);
//		// ***********PAGE METHODS**************
//		yukleme_Ekrani.Konum_Izni_Kontrolu(param_1);
//	}
	@Test(priority = 4)
	public void TC_004_Bildirim_Izin_Kontrolu() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************
		
		// ***********PAGE METHODS**************

	}
	@Test(priority = 5)
	public void TC_005_Oturum_Kontrolu_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCustomerRides(param_1)
		.deleteCustomerReservations(param_1)
		.addTcknAndKvkkValidation(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1);	
	}
	@Test(priority = 6)
	public void TC_006_Oturum_Kontrolu_Basarili_Bildirim_Yok() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************

		// ***********PAGE METHODS**************
		
	}
	@Test(priority = 7)
	public void TC_007_Surus_Kontrolu() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		customer = new Customer();
		scooter = new Scooter();
		
		// ***********CASE DEPENDENCIES**************
		scooter
		.addScooter(param_2, param_3);
				
		customer
		.deleteCustomerRides(param_1)
		.addCustomerContinuesRide(param_1, param_2);
		
		scooter.setMinus5ForRideTime(param_2);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1);	
		
		yukleme_Ekrani
		.Surus_Kontrolu(param_1, param_2);
	}
	@Test(priority = 8)
	public void TC_008_Rezervasyon_Kontrolu() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************

		// ***********PAGE METHODS**************
//		yukleme_Ekrani.Rezervasyon_Kontrolu(param_1);
	}
	@Test(priority = 9)
	public void TC_009_Tckn_Kontrolu() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		customer = new Customer();
		scooter = new Scooter();
		
		// ***********CASE DEPENDENCIES**************
		
		customer
		.deleteCustomerRides(param_1)
		.deleteTcknValidation(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		yukleme_Ekrani
		.Tckn_Kontrolu(param_1);
	}
//	@Test(priority = 10)
//	public void TC_010_Kvkk_Kontrolu() {  bu kalkti
//		// *******************SET PARAMETERS************************
//		param_1 = ride_app_test_parameters[caseId][1];
//		// *******************PAGE INSTANTIATIONS*******************
//		yukleme_Ekrani = new pageYuklemeEkrani(iosDriver);
//		// ***********PAGE METHODS**************
//		yukleme_Ekrani.Kvkk_Kontrolu(param_1);
//	}
@Test(retryAnalyzer = utilities.RetryTest.class, priority = 11)
	public void TC_011_Dinamik_Bildirim_Kontrolu() {
//		 *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		customer = new Customer();
		scooter = new Scooter();
		
		// ***********CASE DEPENDENCIES**************
		customer
		.setExplicitConsentForm(param_1, true)
		.addLocalCampaign(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		yukleme_Ekrani
		.Dinamik_Bildirim_Kontrolu(param_1);
	}
}
