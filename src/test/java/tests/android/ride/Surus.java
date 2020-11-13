package tests.android.ride;

import org.testng.annotations.Test;

import dbmodel.Provider;
import dbmodel.DataPreparation.Customer;
import dbmodel.DataPreparation.Scooter;
import dbmodel.DataPreparation.TestDevice;
import pages.android.ride.pageAnaEkran;
import pages.android.ride.pageGirisEkrani;
import pages.android.ride.pageSurus;
import utilities.TestBase;

public class Surus extends TestBase {
	Provider provider = new Provider();
	pageSurus surus;
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
	public Surus() {
		queryGetParameters = "select * from ride_app_test_parameters order by tc_id;";
		System.setProperty("appName", "ride");
		System.setProperty("platformName", "android");
		System.setProperty("deviceName", "Emulator_1");
		System.setProperty("startLogin", "no");
	}

// ******************************************************* TEST ***********************************************************
//	@Test(priority = 49)
//	public void TC_049_Surus_Basladi_Kodlu_Kilit() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//		
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		customer = new Customer();
//		scooter = new Scooter();
//		
//		// ***********CASE DEPENDENCIES**************
//		customer
//		.deleteCustomerRides(param_1)
//		.deleteCustomerDebt(param_1)
//		.deleteCreditCards(param_1)
//		.deleteCustomerReservations(param_1)
////		.addCustomer(param_1)
//		.addCreditCard(param_1);
//		
//		scooter
//		.addScooter(param_2, param_3)
//		.addScooterFinishedRide(param_1, param_2)
//		.addScooterRide(param_1, param_2)
//		.unlockScooter(param_2);
//		
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Giris_Basarili(param_1);
//		
//		surus
//		.Surus_Basladi_Kodlu_Kilit(param_1, param_2);
//		
//		customer 
//		.deleteCustomerRides(param_1);
//	}
//	@Test(priority = 50)
//	public void TC_050_Surus_Basladi_IOT_Kilit() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//		
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		customer = new Customer();
//		scooter = new Scooter();
//		testDevice = new TestDevice();
//	
//		// ***********CASE DEPENDENCIES**************
//		customer
//		.deleteCustomerRides(param_1)
//		.deleteCustomerDebt(param_1)
//		.deleteCreditCards(param_1)
//		.addCreditCard(param_1);
//		
//		scooter
//		.addScooter(param_2, param_3)
//		.addScooterRide(param_1, param_2)
//		.unlockScooter(param_2);
//		
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Login(param_1);
//		
//		testDevice
//		.restartApp(androidDriver);
//		
//		surus
//		.Surus_Basladi_IOT_Kilit(param_1, param_2);
//	}
//	@Test(priority = 51)
//	public void TC_051_Nasil_Surulur_Gecilmemis() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//		
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		customer = new Customer();
//		scooter = new Scooter();
//		
//		// ***********CASE DEPENDENCIES**************
//		customer
//		.deleteCustomerRides(param_1)
//		.deleteCustomerDebt(param_1)
//		.deleteCreditCards(param_1)
//		.addCreditCard(param_1);
//		
//		scooter
//		.addScooter(param_2, param_3);
//		
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Login(param_1);
//		
//		surus
//		.Nasil_Surulur_Gecilmemis(param_1, param_2);
//		
//		customer 
//		.deleteCustomerRides(param_1);
//	}
//	@Test(priority = 52)
//	public void TC_052_Surus_45sn_Kontrol() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//		
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		customer = new Customer();
//		scooter = new Scooter();
//		testDevice = new TestDevice();
//		
//		// ***********CASE DEPENDENCIES**************
//		customer
//		.deleteCustomerRides(param_1)
//		.deleteCustomerDebt(param_1)
//		.deleteCreditCards(param_1)
//		.addCreditCard(param_1);
//		
//		scooter
//		.addScooter(param_2, param_3)
//		.addScooterRide(param_1, param_2)
//		.setMinus5ForRideTime(param_2);
//		
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Login(param_1);
//		
//		testDevice
//		.restartApp(androidDriver);
//		
//		surus
//		.Surus_45sn_Kontrol();
//	}
//	@Test(priority = 53)
//	public void TC_053_Acil_Mudahale() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		customer = new Customer();
//		scooter = new Scooter();
//		testDevice = new TestDevice();
//		
//		// ***********CASE DEPENDENCIES**************
//		customer.deleteCustomerRides(param_1)
//		.deleteCustomerDebt(param_1)
//		.deleteCreditCards(param_1)
//		.addCreditCard(param_1);
//		
//		customer
//		.addCustomerFinishedRide(param_1, param_2);
//
//		scooter
//		.addScooterRide(param_1, param_2)
//		.lockScooter(param_2);
//
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Login(param_1);
//		
//		testDevice
//		.restartApp(androidDriver);
//
//		surus
//		.Acil_Mudahale(param_1, param_2);
//
//		customer
//		.deleteCustomerRides(param_1);
//	}
//	@Test(priority = 54)
//	public void TC_054_Nasil_Surulur() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		customer = new Customer();
//		scooter = new Scooter();
//		testDevice = new TestDevice();
//
//		// ***********CASE DEPENDENCIES**************
//		customer
//		.deleteCustomerRides(param_1)
//		.deleteCustomerDebt(param_1)
//		.deleteCreditCards(param_1)
//		.addCreditCard(param_1);
//		
//		customer
//		.addCustomerFinishedRide(param_1, param_2);
//
//		scooter
//		.addScooterRide(param_1, param_2)
//		.lockScooter(param_2);
//
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Login(param_1);
//
//		testDevice
//		.restartApp(androidDriver);
//
//		surus
//		.Nasil_Surulur(param_1, param_2);
//
//		customer
//		.deleteCustomerRides(param_1);
//	}
//	@Test(priority = 55)
//	public void TC_055_Ortalama() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		customer = new Customer();
//		scooter = new Scooter();
//		testDevice = new TestDevice();
//
//		// ***********CASE DEPENDENCIES**************
//		customer
//		.deleteCustomerRides(param_1)
//		.deleteCustomerDebt(param_1)
//		.deleteCreditCards(param_1)
//		.addCreditCard(param_1);
//		
//		customer
//		.addCustomerFinishedRide(param_1, param_2);
//
//		scooter
//		.addScooterRide(param_1, param_2)
//		.lockScooter(param_2);
//
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Login(param_1);
//
//		testDevice
//		.restartApp(androidDriver);
//
//		surus
//		.Ortalama(param_1, param_2);
//
//		customer
//		.deleteCustomerRides(param_1);
//	}
//	@Test(priority = 56)
//	public void TC_056_Surus_Bitirme() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		customer = new Customer();
//		scooter = new Scooter();
//		testDevice = new TestDevice();
//
//		// ***********CASE DEPENDENCIES**************
//		customer
//		.deleteCustomerRides(param_1)
//		.deleteCustomerDebt(param_1)
//		.deleteCreditCards(param_1)
//		.addCreditCard(param_1);
//		
//		customer
//		.addCustomerFinishedRide(param_1, param_2);
//
//		scooter
//		.addScooterRide(param_1, param_2)
//		.lockScooter(param_2);
//
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Login(param_1);
//
//		testDevice
//		.restartApp(androidDriver);
//
//		surus
//		.Surus_Bitirme(param_1, param_2);
//
//		customer
//		.deleteCustomerRides(param_1);
//	}
//	@Test(priority = 57)
//	public void TC_057_Park_Edilemez_Alan() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		customer = new Customer();
//		scooter = new Scooter();
//		testDevice = new TestDevice();
//
//		// ***********CASE DEPENDENCIES**************
//		customer.deleteCustomerRides(param_1)
//		.deleteCustomerDebt(param_1)
//		.deleteCreditCards(param_1)
//		.addCreditCard(param_1);
//		
//		customer
//		.addCustomerFinishedRide(param_1, param_2);
//
//		scooter
//		.addScooter(param_2, param_3)
//		.addScooterRide(param_1, param_2)
//		.lockScooter(param_2);
//
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Login(param_1);
//
//		testDevice
//		.restartApp(androidDriver);
//
//		surus
//		.Park_Edilemez_Alan(param_1, param_2);
//
//		scooter
//		.setLastKnowPointToScooter(param_2, "sxk9m8gz8"); // ofis fence
//		
//		customer
//		.deleteCustomerRides(param_1);
//	}
//	@Test(priority = 58)
//	public void TC_058_Kilit_Takilmadi() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		customer = new Customer();
//		scooter = new Scooter();
//		testDevice = new TestDevice();
//
//		// ***********CASE DEPENDENCIES**************
//		customer
//		.deleteCustomerRides(param_1)
//		.deleteCustomerDebt(param_1)
//		.deleteCreditCards(param_1)
//		.addCreditCard(param_1);
//		
//		customer
//		.addCustomerFinishedRide(param_1, param_2);
//
//		scooter
//		.addScooter(param_2, param_3)
//		.addScooterRide(param_1, param_2)
//		.setLastKnowPointToScooter(param_2, "sxk9m8gz8") // ofis fence
//		.unlockScooter(param_2);
//
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Login(param_1);
//
//		testDevice
//		.restartApp(androidDriver);
//
//		surus
//		.Kilit_Takilmadi(param_1, param_2);
//
//		scooter
//		.lockScooter(param_2);
//		
//		customer
//		.deleteCustomerRides(param_1);
//	}
//	@Test(priority = 59)
//	public void TC_059_Kamera_Izni_Verilmemis() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		customer = new Customer();
//		scooter = new Scooter();
//
//		// ***********CASE DEPENDENCIES**************
//		customer
//		.deleteCustomerRides(param_1)
//		.deleteCustomerDebt(param_1)
//		.deleteCreditCards(param_1)
//		.addCreditCard(param_1);
//		
//		customer
//		.addCustomerFinishedRide(param_1, param_2);
//
//		scooter
//		.addScooter(param_2, param_3)
//		.addScooterRide(param_1, param_2)
//		.lockScooter(param_2);
//
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Login(param_1);
//
////		surus
////		.Kamera_Izni_Verilmemis();
//	}
//	@Test(priority = 60)
//	public void TC_060_Surus_Bitir_Internet_Kapali() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		customer = new Customer();
//		scooter = new Scooter();
//		testDevice = new TestDevice();
//
//		// ***********CASE DEPENDENCIES**************
//		customer
//		.deleteCustomerRides(param_1)
//		.deleteCustomerDebt(param_1)
//		.deleteCreditCards(param_1)
//		.addCreditCard(param_1);
//		
//		customer
//		.addCustomerFinishedRide(param_1, param_2);
//
//		scooter
//		.addScooter(param_2, param_3)
//		.addScooterRide(param_1, param_2)
//		.lockScooter(param_2);
//
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Login(param_1);
//
//		testDevice
//		.restartApp(androidDriver);
//
//		surus
//		.Surus_Bitir_Internet_Kapali(param_1, param_2);
//
//		customer
//		.deleteCustomerRides(param_1);
//	}
//	@Test(priority = 61)
//	public void TC_061_Ceza_Kurallarina_Erisim() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		customer = new Customer();
//		scooter = new Scooter();
//		testDevice = new TestDevice();
//
//		// ***********CASE DEPENDENCIES**************
//		customer.deleteCustomerRides(param_1)
//		.deleteCustomerDebt(param_1)
//		.deleteCreditCards(param_1)
//		.addCreditCard(param_1);
//		
//		customer
//		.addCustomerFinishedRide(param_1, param_2);
//
//		scooter
//		.addScooter(param_2, param_3)
//		.addScooterRide(param_1, param_2)
//		.lockScooter(param_2);
//
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Login(param_1);
//
//		testDevice
//		.restartApp(androidDriver);
//
//		surus
//		.Ceza_Kurallarina_Erisim(param_1, param_2);
//
//		customer
//		.deleteCustomerRides(param_1);
//	}
//	@Test(priority = 62)
//	public void TC_062_Odeme_Hatasi() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		customer = new Customer();
//		scooter = new Scooter();
//		testDevice = new TestDevice();
//
//		// ***********CASE DEPENDENCIES**************
//		customer
//		.deleteCustomerRides(param_1)
//		.deleteCustomerDebt(param_1)
//		.deleteCreditCards(param_1)
//		.addErrorCreditCard(param_1)
//		.addCustomerFinishedRide(param_1, param_2);
//
//		scooter
//		.addScooter(param_2, param_3)
//		.addScooterRide(param_1, param_2)
//		.lockScooter(param_2);
//		
//		scooter
//		.setMinus5ForRideTime(param_2)
//		.setLastKnowPointToScooter(param_2, "sxk9jw876");
//
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Login(param_1);
//
//		testDevice
//		.restartApp(androidDriver);
//
//		surus
//		.Odeme_Hatasi();
//
//		customer
//		.deleteCustomerRides(param_1);
//	}
//	@Test(priority = 63)
//	public void TC_063_Odeme_Hatasi_Borc_Ekle() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		customer = new Customer();
//		scooter = new Scooter();
//
//		// ***********CASE DEPENDENCIES**************
//
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Login(param_1);
//
//	}
//	@Test(priority = 64)
//	public void TC_064_Surus_Bitir_Basarili() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		customer = new Customer();
//		scooter = new Scooter();
//		testDevice = new TestDevice();
//
//		// ***********CASE DEPENDENCIES**************
//		customer
//		.deleteCustomerRides(param_1)
//		.deleteCustomerDebt(param_1)
//		.deleteCreditCards(param_1)
//		.addCreditCard(param_1);
//		
//		customer
//		.addCustomerFinishedRide(param_1, param_2);
//
//		scooter
//		.addScooter(param_2, param_3)
//		.addScooterRide(param_1, param_2)
//		.setMinus5ForRideTime(param_2)
//		.lockScooter(param_2);
//
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Login(param_1);
//
//		testDevice
//		.restartApp(androidDriver);
//
//		surus
//		.Surus_Bitirme_Basarili()
//		.Yolculuk_Ozeti_Kontrol(param_1)
//		.Yolculugu_Degerlendirme(param_1);
//
//		customer
//		.deleteCustomerRides(param_1);
//	}
//	@Test(priority = 65)
//	public void TC_065_Surus_Bitir_Basarili_Wallet() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//		param_4 = testParameters[caseId][4]; //wallet balance
//
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		customer = new Customer();
//		scooter = new Scooter();
//
//		// ***********CASE DEPENDENCIES**************
//		customer
//		.addWalletBalance(param_1, param_4)
//		.deleteCustomerRides(param_1)
//		.deleteCustomerDebt(param_1)
//		.deleteCreditCards(param_1)
//		.addCreditCard(param_1);
//		
//		customer
//		.addCustomerFinishedRide(param_1, param_2);
//
//		scooter
//		.addScooter(param_2, param_3)
//		.addScooterRide(param_1, param_2)
//		.setMinus5ForRideTime(param_2)
//		.lockScooter(param_2);
//
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Giris_Basarili(param_1);
//		
//		surus
//		.Surus_Bitirme_Basarili_Wallet()
//		.Yolculugu_Degerlendirme(param_1)
//		.CuzdanBakiyeKontrol(param_4);
//
//	}
//	@Test(priority = 66)
//	public void TC_066_Surus_Bitir_Basarisiz_Wallet_Yetersiz() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		param_3 = testParameters[caseId][3];
//
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		giris_Ekrani = new pageGirisEkrani(androidDriver);
//		customer = new Customer();
//		scooter = new Scooter();
//
//		// ***********CASE DEPENDENCIES**************
//		customer
//		.addWalletBalance(param_1, "2")
//		.deleteCustomerRides(param_1)
//		.deleteCustomerDebt(param_1)
//		.deleteCreditCards(param_1)
//		.addCreditCard(param_1);
//		customer
//		.addCustomerContinuesRide(param_1, param_2);
//
//		scooter
//		.addScooter(param_2, param_3)
//		.addScooterRide(param_1, param_2)
//		.setMinus5ForRideTime(param_2)
//		.lockScooter(param_2);
//
//		// ***********PAGE METHODS**************
//		giris_Ekrani
//		.Giris_Basarili(param_1);
//		
//		surus
//		.Surus_Bitir_Basarisiz_Wallet_Yetersiz();
//
//	}
	@Test(priority = 67)
	public void TC_067_Surus_Bitir_Basarili_Kupon_Kullanildi() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		surus = new pageSurus(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		scooter = new Scooter();

		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCreatorCoupons(param_1)
		.deleteCustomerRides(param_1)
		.deleteCustomerDebt(param_1)
		.deleteCreditCards(param_1)
		.addCreditCard(param_1);

		scooter
		.addScooter(param_2, param_3)
		.addScooterRide(param_1, param_2)
		.setMinus5ForRideTime(param_2)
		.lockScooter(param_2);

		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1);
		
		surus.
		Surus_Bitir_Basarili_Kupon_Kullanildi();

	}
	@Test(priority = 68)
	public void TC_068_Uygulama_Degerlendirme() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		surus = new pageSurus(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		scooter = new Scooter();

		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCustomerRides(param_1)
		.deleteCustomerDebt(param_1)
		.deleteCreditCards(param_1)
		.addCreditCard(param_1);
		
		customer
		.addCustomerFinishedRide(param_1, param_2);

		scooter
		.addScooter(param_2, param_3)
		.addScooterRide(param_1, param_2)
		.lockScooter(param_2);

		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);

		scooter
		.deleteScooterRides(param_2);
		
	}

}
