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
	@Test(priority = 69)
	public void TC_069_Versiyon_Kontrol() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_3 = testParameters[caseId][3];
		
		// *******************PAGE INSTANTIATIONS*******************
		menu = new pageMenu(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		
		// ***********CASE DEPENDENCIES**************
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
		menu
		.Versiyon_Kontrol(param_1, param_3);
	}
	@Test(priority = 70)
	public void TC_070_Profil_Duzenleme() {
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
		.Profil_Duzenleme(param_1);
	}
	@Test(priority = 71)
	public void TC_071_Cuzdana_Bakiye_Yukleme() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
	
		// *******************PAGE INSTANTIATIONS*******************
		menu = new pageMenu(iosDriver);
		giris_Ekrani = new pageGirisEkrani(iosDriver);
		
		// ***********CASE DEPENDENCIES**************
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Login(param_1);
		
	}
	@Test(priority = 72)
	public void TC_072_Arkadasini_Davet_Et() {
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
	@Test(priority = 73)
	public void TC_073_Surusleri_Inceleme() {
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
		.Surusleri_Inceleme(param_1);
		
		customer
		.addCustomerFinishedRide(param_1, param_2);	
		
		menu
		.SurusDetayiInceleme(param_1, param_2, param_3);
	}
	@Test(priority = 74)
	public void TC_074_Dil_Degistirme() {
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
	@Test(priority = 75)
	public void TC_075_Kampanyalari_Goruntule() {
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
		

	}	
	@Test(priority = 76)
	public void TC_076_Davet_Kodu_Girme() {
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
	@Test(priority = 77)
	public void TC_077_Arkadasini_Davet_Etme() {
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
	@Test(priority = 78)
	public void TC_078_Nasil_Kullanilir_Erisim() {
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
	@Test(priority = 79)
	public void TC_079_Guvenlik_Dokumanina_Erisim() {
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
	@Test(priority = 80)
	public void TC_080_Surus_Kurallarina_Erisim() {
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
	@Test(priority = 81)
	public void TC_081_Cikis() {
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
	@Test(priority = 82)
	public void TC_082_Yardim_Dokumanina_Erisim() {
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
	@Test(priority = 83)
	public void TC_083_Kvkk_Aydinlatma_Metnine_Erisim() {
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
	@Test(priority = 84)
	public void TC_084_Kullanici_Sozlesmesine_Erisim() {
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
	
	
	
	@Test(priority = 99)
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
		
		customer
		.deleteCreditCards(param_1)
		.addCreditCard(param_1);
		
	}
	@Test(priority = 100)
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
		
		customer
		.deleteCreditCards(param_1)
		.addCreditCard(param_1);
		
	}
	@Test(priority = 101)
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
		
		customer
		.deleteCreditCards(param_1)
		.addCreditCard(param_1);
	}


	@Test(priority = 102)
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

}

