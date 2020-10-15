package tests.ios.ride;

import org.testng.annotations.Test;

import dbmodel.Provider;
import dbmodel.DataPreparation.Customer;
import pages.ios.ride.pageGirisEkrani;
import pages.ios.ride.pageMenu;
import utilities.TestBase;

public class Menu extends TestBase {
	Provider provider = new Provider();
	pageMenu menu;
	pageGirisEkrani giris_Ekrani;
	Customer customer;
	String param_1;
	String param_2;
	String param_3;
	String param_4;
	String param_5;
	
// *********Constructor*********
	public Menu() {
		queryGetParameters = "select * from ride_app_test_parameters order by tc_id;";
		System.setProperty("appName", "ride");
		System.setProperty("platformName", "ios");
		System.setProperty("deviceName", "iPhone5S");
		System.setProperty("startLogin", "no");
	}

// ******************************************************* TEST ***********************************************************
	
//	@Test(priority = 49)   ios'ta versiyon bilgisini tutan element direk value 'dan yakalniyor. out of scope..
//	public void TC_049_Versiyon_Kontrol() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		// *******************PAGE INSTANTIATIONS*******************
//		menu = new pageMenu(iosDriver);
//		// ***********PAGE METHODS**************
//		menu.Versiyon_Kontrol(param_1);
//	}
	@Test(priority = 50)
	public void TC_050_Profil_Duzenleme() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		menu = new pageMenu(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		
		// ***********CASE DEPENDENCIES**************
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1);
		
		menu
		.Profil_Duzenleme(param_1);
	}
	@Test(priority = 51)
	public void TC_051_Arkadasini_Davet_Et() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		menu = new pageMenu(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCustomerCoupons(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		menu
		.Arkadasini_Davet_Et(param_1)
		.Davet_Baglantisi_Gonderme(param_1);
	}
	@Test(priority = 52)
	public void TC_052_Surusleri_Inceleme() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		param_3 = testParameters[caseId][3];
		
		// *******************PAGE INSTANTIATIONS*******************
		menu = new pageMenu(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCustomerRides(param_1)
		.deleteCustomerReservations(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		menu
		.Surusleri_Inceleme(param_1)
		.SurusDetayiInceleme(param_1, param_2, param_3);
	}
	@Test(priority = 53)
	public void TC_053_Varsayilan_Kredi_Karti_Degistirme() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		menu = new pageMenu(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCreditCards(param_1)
		.addCreditCard(param_1);
		customer
		.addErrorCreditCard(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		menu
		.Varsayilan_Kredi_Karti_Degistirme(param_1);
	}
	@Test(priority = 54)
	public void TC_054_Kredi_Karti_Ekleme_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		menu = new pageMenu(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCreditCards(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		menu
		.Kredi_Karti_Ekleme_Basarili(param_1);
	}
	@Test(priority = 55)
	public void TC_055_Kredi_Karti_Ekleme_Basarisiz() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		menu = new pageMenu(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCreditCards(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		menu
		.Kredi_Karti_Ekleme_Basarisiz(param_1);
	}
	@Test(priority = 56)
	public void TC_056_Dil_Degistirme() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		menu = new pageMenu(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		
		// ***********CASE DEPENDENCIES**************
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		menu
		.Dil_Degistirme(param_1);
	}
//	@Test(priority = 57) henuz yapilmadi
//	public void TC_057_Kampanyalari_Incele() {
//		// *******************PAGE INSTANTIATIONS*******************
//		menu = new pageMenu(iosDriver);
//
//		// ***********PAGE METHODS**************
//		menu
//		.Kampanyalari_Goruntule()
//		.Kampanyalari_Incele();
//	}
//	@Test(priority = 58)
	public void TC_058_Kupon_Ekleme() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		menu = new pageMenu(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		// ***********CASE DEPENDENCIES**************
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		menu
		.Arkadasini_Davet_Et(param_1)
		.Davet_Baglantisi_Gonderme(param_1)
		.Kupon_Ekleme(param_1);
	}
	@Test(priority = 59)
	public void TC_059_Davet_Kodu_Girme() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		menu = new pageMenu(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCustomerCoupons(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		menu
		.Kampanyalar_Arkadasini_Davet_Et(param_1)
		.Kupon_Ekleme(param_1);
	}
	@Test(priority = 60)
	public void TC_060_Arkadasini_Davet_Etme() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		menu = new pageMenu(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCustomerRides(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		menu
		.Kampanyalar_Arkadasini_Davet_Etme(param_1);
	}
	@Test(priority = 61)
	public void TC_061_Guvenlik_Dokumanina_Erisim() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		menu = new pageMenu(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		
		// ***********CASE DEPENDENCIES**************
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		menu
		.Guvenlik_Dokumanina_Erisim(param_1);
	}
	@Test(priority = 62)
	public void TC_062_Nasil_Kullanilir_Erisim() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		menu = new pageMenu(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		
		// ***********CASE DEPENDENCIES**************
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		menu
		.Nasil_Kullanilir(param_1);
	}
	@Test(priority = 63)
	public void TC_063_Surus_Kurallarina_Erisim() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		menu = new pageMenu(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		
		// ***********CASE DEPENDENCIES**************
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		menu
		.Surus_Kurallarina_Erisim(param_1);
	}
	@Test(priority = 64)
	public void TC_064_Kvkk_Aydinlatma_Metnine_Erisim() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		menu = new pageMenu(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		
		// ***********CASE DEPENDENCIES**************
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		menu
		.Kvkk_Aydinlatma_Metnine_Erisim(param_1);
	}
	@Test(priority = 65)
	public void TC_065_Kullanici_Sozlesmesine_Erisim() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		menu = new pageMenu(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		menu
		.Kullanici_Sozlesmesine_Erisim(param_1);
	}
	@Test(priority = 66)
	public void TC_066_Yardim_Dokumanina_Erisim() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		menu = new pageMenu(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		
		// ***********CASE DEPENDENCIES**************
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		menu
		.Yardim_Dokumanina_Erisim(param_1);
	}
	@Test(priority = 67)
	public void TC_067_Cikis() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		menu = new pageMenu(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		
		// ***********CASE DEPENDENCIES**************
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		menu
		.Cikis(param_1);
	}
}

