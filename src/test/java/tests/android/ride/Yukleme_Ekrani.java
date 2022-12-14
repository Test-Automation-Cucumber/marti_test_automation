package tests.android.ride;

import org.testng.annotations.Test;

import dbmodel.Provider;
import dbmodel.DataPreparation.Customer;
import dbmodel.DataPreparation.Scooter;
import dbmodel.DataPreparation.TestDevice;
import pages.android.ride.pageGirisEkrani;
import pages.android.ride.pageYuklemeEkrani;
import utilities.TestBase;

public class Yukleme_Ekrani extends TestBase {
	Provider provider = new Provider();
	pageYuklemeEkrani yukleme_Ekrani;
	pageGirisEkrani giris_Ekrani;
	Customer customer;
	Scooter scooter;
	TestDevice testDevice;
	String param_1;
	String param_2;
	String param_3;
	String param_4;
	String param_5;

// *********Constructor*********
	public Yukleme_Ekrani() {
		queryGetParameters = "select * from ride_app_test_parameters order by tc_id;";
		System.setProperty("appName", "ride");
		System.setProperty("platformName", "android");
		System.setProperty("deviceName", "Emulator_1");
		System.setProperty("startLogin", "no");
	}

// ******************************************************* TEST ***********************************************************

//	//ekran cok hizli yuklendigi icin splash screen ekrani yakalamiyor.
//	@Test(priority = 0)   SLACK ICIN YAPTIN
//	public void TC_001_Yukleme_Ekrani_Basarili() {
//// ***********PAGE INSTANTIATIONS*******
//		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
//		
//		// ***********PAGE METHODS**************
//		yukleme_Ekrani
//		.Yukleme_Ekrani_Basarili();
//	}
//	
	@Test(priority = 1) // ,dependsOnMethods="method1"
	public void TC_001_Yukleme_Ekrani_Basarisiz() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
		customer = new Customer();
		
		// ***********PAGE METHODS**************
		customer
		.addTcknAndKvkkValidation(param_1);
		
		yukleme_Ekrani
		.Yukleme_Ekrani_Basarisiz(param_1);
	}
	@Test(priority = 2)
	public void TC_002_Uygulama_Baslangici_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
		// ***********PAGE METHODS**************
		yukleme_Ekrani
		.Uygulama_Baslangici_Basarili();
	}
//	@Test(priority = 3)
//	public void TC_003_Konum_Izni_Kontrolu() {  konumla alakali caseler sikinti cikariyor
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		// *******************PAGE INSTANTIATIONS*******************
//		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
//		// ***********PAGE METHODS**************
//		yukleme_Ekrani
//		.Konum_Izni_Kontrolu(param_1);
//	}
	@Test(priority = 4)
	public void TC_004_Bildirim_Izin_Kontrolu() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************

		// ***********PAGE METHODS**************

	}
	@Test(priority = 5)
	public void TC_005_Oturum_Kontrolu_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
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
		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************

		// ***********PAGE METHODS**************

	}
	@Test(priority = 7)
	public void TC_007_Surus_Kontrolu() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		param_3 = testParameters[caseId][3];
		
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		scooter = new Scooter();
		testDevice = new TestDevice();
		
		// ***********CASE DEPENDENCIES**************
		scooter
		.addScooter(param_2, param_3);
				
		customer
		.deleteCustomerRides(param_1)
		.addCustomerContinuesRide(param_1, param_2);
		
		testDevice
		.resetApp(androidDriver);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		yukleme_Ekrani
		.Surus_Kontrolu(param_1, param_2);
		
		customer
		.deleteCustomerRides(param_1);
		
	}
	@Test(priority = 8)
	public void TC_008_Rezervasyon_Kontrolu() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************

		// ***********PAGE METHODS**************
////	yukleme_Ekrani.Rezervasyon_Kontrolu(param_1);
	}
	@Test(priority = 9)
	public void TC_009_Tckn_Kontrolu() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************
		customer
		.deleteTcknValidation(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		yukleme_Ekrani
		.Tckn_Kontrolu(param_1);
		
		customer
		.addTcknAndKvkkValidation(param_1);
	}
//	@Test(priority =10)
//	public void TC_010_Kvkk_Kontrolu() { yeri de??i??ti
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		// *******************PAGE INSTANTIATIONS*******************
//		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
//		// ***********PAGE METHODS**************
//		yukleme_Ekrani.Kvkk_Kontrolu(param_1);
//	}
//	@Test(priority = 11)
//	public void Dinamik_Bildirim_Kontrolu() {bu  ekranda yakalanm??yor
//// *******************PAGE INSTANTIATIONS*******************
//		yukleme_Ekrani = new pageYuklemeEkrani(androidDriver);
//
//		// ***********PAGE METHODS**************
//		yukleme_Ekrani
//		.Dinamik_Bildirim_Kontrolu(customerPhoneNumber);
//	}
}
