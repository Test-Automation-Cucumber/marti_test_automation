package tests.android.ride;

import org.testng.annotations.Test;

import dbmodel.Provider;
import dbmodel.DataPreparation.Customer;
import dbmodel.DataPreparation.Scooter;
import dbmodel.DataPreparation.TestDevice;
import pages.android.ride.pageAnaEkran;
import pages.android.ride.pageGirisEkrani;
import pages.android.ride.pageYuklemeEkrani;
import utilities.TestBase;

public class Ana_Ekran extends TestBase {
	Provider provider = new Provider();
	pageAnaEkran ana_Ekran;
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
	public Ana_Ekran() {
		queryGetParameters = "select * from ride_app_test_parameters order by tc_id;";
		System.setProperty("appName", "ride");
		System.setProperty("platformName", "android");
		System.setProperty("deviceName", "Emulator_1");
		System.setProperty("startLogin", "no");
	}

// ******************************************************* TEST ***********************************************************
	@Test(priority = 20)
	public void TC_020_Konum_Izin_Kontrolu() {
//		 *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		scooter = new Scooter();
		
		// ***********CASE DEPENDENCIES**************

		// ***********PAGE METHODS**************

	}
	@Test(priority = 21)
	public void TC_021_Bildirim_Izin_Kontrolu() {
//		 *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		scooter = new Scooter();
		
		// ***********CASE DEPENDENCIES**************

		// ***********PAGE METHODS**************

	}
	@Test(priority = 22)
	public void TC_022_Dinamik_Popup_Goster() {
//		 *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		scooter = new Scooter();
		
		// ***********CASE DEPENDENCIES**************
		customer
		.setExplicitConsentForm(param_1, true)
		.addLocalCampaign(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1);
		
		ana_Ekran
		.Dinamik_Popup_Goster_Popup_Var(param_1);
	}
	@Test(priority = 23)
	public void TC_023_Dinamik_Popup_Gosterme_Popup_Yok() {
//		 *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		scooter = new Scooter();
		
		// ***********CASE DEPENDENCIES**************
		customer
		.setExplicitConsentForm(param_1, true)
		.deleteLocalCampaign(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1);
		
		ana_Ekran
		.Dinamik_Popup_Gosterme_Popup_Yok(param_1);
	}
	@Test(priority = 24)
	public void TC_024_Dinamik_Popup_Gosterme_Acik_Riza_Yok() {
//		 *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		scooter = new Scooter();
		testDevice = new TestDevice();
		
		// ***********CASE DEPENDENCIES**************
		customer
		.setExplicitConsentForm(param_1, false)
		.minus14DaysForExplicitConsentFormDate(param_1)
		.addLocalCampaign(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		testDevice
		.restartApp(androidDriver);
		
		ana_Ekran
		.Dinamik_Popup_Gosterme_Popup_Yok(param_1);
	}
	@Test(priority = 25)
	public void TC_025_Acik_Riza_Hatirlatma_Gosterme() {
//		 *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		scooter = new Scooter();
		testDevice = new TestDevice();
		
		// ***********CASE DEPENDENCIES**************
		customer
		.setExplicitConsentForm(param_1, false)
		.minus14DaysForExplicitConsentFormDate(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		testDevice
		.restartApp(androidDriver);
		
		ana_Ekran
		.Acik_Riza_Metni_Gosterme_Popup_Yok(param_1);
	}
	@Test(priority = 26)
	public void TC_026_Acik_Riza_Hatirlatma_Goster_Onay() {
//		 *******************SET PARAMETERS**************************
		param_1 = testParameters[caseId][1];

		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		scooter = new Scooter();
		testDevice = new TestDevice();

		// ***********CASE DEPENDENCIES**************
		giris_Ekrani
		.Login(param_1);
		
		customer
		.setExplicitConsentForm(param_1, false)
		.setMinus16DaysForExplicitConsentFormDate(param_1);
		
		testDevice
		.restartApp(androidDriver);

		// ***********PAGE METHODS**************
		ana_Ekran
		.Acik_Riza_Metni_Goster_Popup_Var(param_1);

	}

	@Test(priority = 27)
	public void TC_027_Scooter_Bilgileri_Goster() {
//		 *******************SET PARAMETERS**************************
		param_1 = testParameters[caseId][1];

		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		scooter = new Scooter();
		testDevice = new TestDevice();

		// ***********CASE DEPENDENCIES**************

		// ***********PAGE METHODS**************

	}
	@Test(priority = 28)
	public void TC_028_Surus_Baslat() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];

		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();

		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCustomerDebt(param_1)
		.deleteCreditCards(param_1)
		.addCreditCard(param_1);

		customer
		.addTcknAndKvkkValidation(param_1);

		// ***********PAGE METHODS**************
		giris_Ekrani.Giris_Basarili(param_1);

		ana_Ekran.Surus_Baslat(param_1);
	}

	@Test(priority = 29)
	public void TC_029_Tckn_Gecersiz() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];

		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();

		// ***********CASE DEPENDENCIES**************
		customer
		.deleteTcknValidation(param_1);

		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);

		ana_Ekran
		.Tckn_Gecersiz(param_1);
		
		customer
		.addTcknAndKvkkValidation(param_1);
	}
	@Test(priority = 30)
	public void TC_030_Odeme_Yontemi_Yok_Kart_Yok() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];

		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();

		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCreditCards(param_1)
		.addTcknAndKvkkValidation(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);

		ana_Ekran
		.Odeme_Yontemi_Yok(param_1);
	}
	@Test(priority = 31)
	public void TC_031_Odeme_Yontemi_Yok_Bakiye_Yetersiz() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];

		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();

		// ***********CASE DEPENDENCIES**************

		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
	}
	@Test(priority = 32)
	public void TC_032_Surus_Baslatma_Kamera_Izni_Verilmemis() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];

		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();

		// ***********CASE DEPENDENCIES**************

		// ***********PAGE METHODS**************
		giris_Ekrani.Login(param_1);

//		Surus_Baslatma_Kamera_Izni_Verilmemis
	}
	@Test(priority = 33)
	public void TC_033_Surus_Baslat_Kod_Girisi() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];

		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();

		// ***********CASE DEPENDENCIES**************
		customer.addTcknAndKvkkValidation(param_1)
		.deleteCreditCards(param_1)
		.addCreditCard(param_1);
		customer
		.deleteCustomerDebt(param_1);

		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);

		ana_Ekran
		.Surus_Baslatma_Kod_Girisi(param_1);
	}
	@Test(priority = 34)
	public void TC_034_Surus_Baslat_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		scooter = new Scooter();

		// ***********CASE DEPENDENCIES**************
		customer
		.addTcknAndKvkkValidation(param_1)
		.deleteCreditCards(param_1)
		.addCreditCard(param_1);
		customer
		.deleteCustomerDebt(param_1);

		scooter
		.addScooter(param_2, param_3);

		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);

		ana_Ekran
		.Surus_Baslat_Basarili(param_1, param_2);
	}
	@Test(priority = 35)
	public void TC_035_Surus_Baslat_Basarisiz_Martiya_Uzak() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		param_3 = testParameters[caseId][3];

		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		scooter = new Scooter();

		// ***********CASE DEPENDENCIES**************
		customer
		.addTcknAndKvkkValidation(param_1)
		.deleteCreditCards(param_1)
		.addCreditCard(param_1);
		customer
		.deleteCustomerDebt(param_1);

		scooter
		.addScooter(param_2, param_3)
		.setLastKnowPointToScooter(param_2, "sxk9q130z");

		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);

		ana_Ekran
		.Surus_Baslat_Basarisiz_Martiya_Uzak(param_1, param_2);
	}
	@Test(priority = 36)
	public void TC_036_Daha_Cok_Marti() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];

		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);

		// ***********CASE DEPENDENCIES**************

		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);

		ana_Ekran
		.Daha_Cok_Marti();
	}
	@Test(priority = 37)
	public void TC_037_Ortalama() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];

		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);

		// ***********CASE DEPENDENCIES**************

		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);

	}
	@Test(priority = 38)
	public void TC_038_Bize_Ulasin_Kilit_Problemi_Bildirme() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();

		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCustomerIssues(param_1);

		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		ana_Ekran
		.Bize_Ulasin_Kilit_Problemi_Bildirme(param_1, param_2);
	}
	@Test(priority = 39)
	public void TC_039_Bize_Ulasin_Hasarli_Sorunlu_Marti_Bildirme() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);

		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCustomerIssues(param_1);

		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);

		ana_Ekran
		.Bize_Ulasin_Hasarli_Sorunlu_Marti_Bildirme(param_1, param_2);
	}
	@Test(priority = 40)
	public void TC_040_Bize_Ulasin_Yanlis_Park() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);

		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCustomerIssues(param_1);

		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);

		ana_Ekran
		.Bize_Ulasin_Yanlis_Park(param_1, param_2);
	}
	@Test(priority = 41)
	public void TC_041_Bize_Ulasin_Acil_Durum_Paylas() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];

		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);

		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCustomerIssues(param_1);

		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);

		ana_Ekran
		.Bize_Ulasin_Acil_Durum_Paylas(param_1);
	}
	@Test(priority = 42)
	public void TC_042_Bildirimleri_Kontrol_Etme() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];

		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);

		// ***********CASE DEPENDENCIES**************

		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);

		ana_Ekran
		.Bildirimleri_Kontrol_Etme(param_1);
	}
}
