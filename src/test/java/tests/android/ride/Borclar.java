package tests.android.ride;

import org.testng.annotations.Test;

import dbmodel.Provider;
import dbmodel.DataPreparation.Customer;
import pages.android.ride.pageBorclar;
import pages.android.ride.pageGirisEkrani;
import utilities.TestBase;

public class Borclar extends TestBase {
	Provider provider = new Provider();
	pageBorclar borclar;
	pageGirisEkrani giris_Ekrani;
	Customer customer;
	String param_1;
	String param_2;
	String param_3;
	String param_4;
	String param_5;
	
// *********Constructor*********
	public Borclar() {
		queryGetParameters = "select * from ride_app_test_parameters order by tc_id;";		
	}

// ******************************************************* TEST ***********************************************************
	
	@Test(priority = 29)
	public void TC_029_Borclu_Kullanici() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		borclar = new pageBorclar(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
			
		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCreditCards(param_1)
		.addCreditCard(param_1);
		customer
		.deleteCustomerDebt(param_1)
		.addCustomerDebt(param_1, 14);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1);
		
		borclar
		.Borclu_Kullanici(param_1);
			
	}
	@Test(priority = 30)
	public void TC_030_Borclu_Kullanici_Plus_15() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		borclar = new pageBorclar(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCustomerDebt(param_1)
		.addCustomerDebt(param_1, 16);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1);
		
		borclar
		.Borclu_Kullanici_Plus_15(param_1);
		}
	@Test(priority = 31)
	public void TC_031_Borc_Odeme() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		borclar = new pageBorclar(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************
		customer.deleteCreditCards(param_1)
		.addCreditCard(param_1);
		customer.deleteCustomerDebt(param_1)
		.addCustomerDebt(param_1, 11);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1);
		
		borclar
		.Borc_Odeme(param_1);
		
	}
	@Test(priority = 32)
	public void TC_032_Borc_Odeme_Islemi_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		borclar = new pageBorclar(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************
		customer.deleteCreditCards(param_1)
		.addCreditCard(param_1);
		customer.deleteCustomerDebt(param_1)
		.addCustomerDebt(param_1, 11);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1);
		
		borclar
		.Borc_Odeme_Islemi_Basarili(param_1);
		
	}
	@Test(priority = 33)
	public void TC_033_Borc_Odeme_Islemi_Basarisiz() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		
		// *******************PAGE INSTANTIATIONS*******************
		borclar = new pageBorclar(androidDriver);
		giris_Ekrani = new pageGirisEkrani(androidDriver);
		customer = new Customer();
		
		// ***********CASE DEPENDENCIES**************
		customer
		.deleteCreditCards(param_1)
		.addErrorCreditCard(param_1)
		.deleteCustomerDebt(param_1)
		.addCustomerDebt(param_1, 11);
		
		// ***********PAGE METHODS**************
		giris_Ekrani
		.Giris_Basarili(param_1);
		
		borclar
		.Borc_Odeme_Islemi_Basarisiz(param_1);
	}

}
