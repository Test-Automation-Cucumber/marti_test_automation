package tests.android.ride;

import org.testng.annotations.Test;

import dbmodel.Provider;
import dbmodel.DataPreparation.Customer;
import dbmodel.DataPreparation.Scooter;
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
	String param_1;
	String param_2;
	String param_3;
	String param_4;
	String param_5;

// *********Constructor*********
	public Ana_Ekran() {
		queryGetParameters = "select * from ride_app_test_parameters order by tc_id;";
	}

// ******************************************************* TEST ***********************************************************

	@Test(priority = 16)
	public void TC_016_Surus_Baslat() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCustomerDebt(param_1)
		.addCreditCard(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1);
		
		ana_Ekran
		.Surus_Baslat(param_1);
	}

	@Test(priority = 17)
	public void TC_017_Tckn_Gecersiz() {
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
		.Giris_Basarili(param_1);
		
		ana_Ekran
		.Tckn_Gecersiz(param_1);
	}

	@Test(priority = 18)
	public void TC_018_Odeme_Yontemi_Yok() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************
		customer.
		deleteCreditCards(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1);
		
		ana_Ekran
		.Odeme_Yontemi_Yok(param_1);
	}

//	@Test(priority = 19)
//	public void TC_019_Surus_Baslatma_Kamera_Izni_Verilmemis() { kamera ile alakali izni runtime sirasinda kapatabiliyor musun bi kontrol et.
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		// *******************PAGE INSTANTIATIONS*******************
//		ana_Ekran = new pageAnaEkran(androidDriver);
//		// ***********PAGE METHODS**************
//		ana_Ekran.Surus_Baslatma_Kamera_Izni_Verilmemis(param_1);
//	}

	@Test(priority = 20)
	public void TC_020_Surus_Baslatma_Kod_Girisi() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************
		customer
		.addTcknAndKvkkValidation(param_1)
		.deleteCreditCards(param_1)
		.addCreditCard(param_1);
		customer.deleteCustomerDebt(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1);
					
		ana_Ekran
		.Surus_Baslatma_Kod_Girisi(param_1);
	}

	@Test(priority = 21)
	public void TC_021_Surus_Baslat_Basarili() {
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
		ana_Ekran.Surus_Baslat_Basarili(param_1, param_2);
	}

	@Test(priority = 22)
	public void TC_022_Surus_Baslat_Basarisiz_Martiya_Uzak() {
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
		.Giris_Basarili(param_1);
		
		ana_Ekran
		.Surus_Baslat_Basarisiz_Martiya_Uzak(param_1, param_2);
	}

	@Test(priority = 23)
	public void TC_023_Daha_Cok_Marti() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		
		// ***********CASE DEPENDENCIES**************
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1);
		
		ana_Ekran
		.Daha_Cok_Marti();
	}

	@Test(priority = 24)
	public void TC_024_Bize_Ulasin_Kilit_Problemi_Bildirme() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCustomerIssues(param_1);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1);		
		ana_Ekran
		.Bize_Ulasin_Kilit_Problemi_Bildirme(param_1);
	}

	@Test(priority = 25)
	public void TC_025_Bize_Ulasin_Hasarli_Sorunlu_Marti_Bildirme() {
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
		.Giris_Basarili(param_1);
		
		ana_Ekran
		.Bize_Ulasin_Hasarli_Sorunlu_Marti_Bildirme(param_1);
	}

	@Test(priority = 26)
	public void TC_026_Bize_Ulasin_Yanlis_Park() {
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
		.Giris_Basarili(param_1);
		
		ana_Ekran
		.Bize_Ulasin_Yanlis_Park(param_1);
	}

	@Test(priority = 27)
	public void TC_027_Bize_Ulasin_Acil_Durum_Paylas() {
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
		.Giris_Basarili(param_1);
				
		ana_Ekran
		.Bize_Ulasin_Acil_Durum_Paylas(param_1);
	}
	@Test(priority = 28)
	public void TC_028_Bildirimleri_Kontrol_Etme() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		 
		// ***********CASE DEPENDENCIES**************
		
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1);
		
		ana_Ekran
		.Bildirimleri_Kontrol_Etme(param_1);
	}
}
