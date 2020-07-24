package tests;

import org.testng.annotations.Test;

import com.google.errorprone.annotations.Var;

import dbmodel.Provider;
import utilities.TestBase;
import pages.device.*;

public class Ana_Ekran extends TestBase {
	Provider provider = new Provider();
	pageAnaEkran ana_Ekran;
	pageYuklemeEkrani yukleme_Ekrani;
	String methodName;
	String param_1;
	String param_2;
	String param_3;
	String param_4;
	String param_5;

// *********Constructor*********
	public Ana_Ekran() {

	}

// ******************************************************* TEST ***********************************************************

	@Test(priority = 16)
	public void TC_016_Surus_Baslat() {
		// *******************SET PARAMETERS************************
		param_1 = ride_app_test_parameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		// ***********PAGE METHODS**************
		ana_Ekran.Surus_Baslat(param_1);
	}

	@Test(priority = 17)
	public void TC_017_Tckn_Gecersiz() {
		// *******************SET PARAMETERS************************
		param_1 = ride_app_test_parameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		// ***********PAGE METHODS**************
		ana_Ekran.Tckn_Gecersiz(param_1);
	}

	@Test(priority = 18)
	public void TC_018_Odeme_Yontemi_Yok() {
		// *******************SET PARAMETERS************************
		param_1 = ride_app_test_parameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		// ***********PAGE METHODS**************
		ana_Ekran.Odeme_Yontemi_Yok(param_1);
	}

//	@Test(priority = 19)
//	public void TC_019_Surus_Baslatma_Kamera_Izni_Verilmemis() { kamera ile alakali izni runtime sirasinda kapatabiliyor musun bi kontrol et.
//		// *******************SET PARAMETERS************************
//		param_1 = ride_app_test_parameters[caseId][1];
//		// *******************PAGE INSTANTIATIONS*******************
//		ana_Ekran = new pageAnaEkran(androidDriver);
//		// ***********PAGE METHODS**************
//		ana_Ekran.Surus_Baslatma_Kamera_Izni_Verilmemis(param_1);
//	}

	@Test(priority = 20)
	public void TC_020_Surus_Baslatma_Kod_Girisi() {
		// *******************SET PARAMETERS************************
		param_1 = ride_app_test_parameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		// ***********PAGE METHODS**************
		ana_Ekran.Surus_Baslatma_Kod_Girisi(param_1);
	}

	@Test(priority = 21)
	public void TC_021_Surus_Baslat_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = ride_app_test_parameters[caseId][1];
		param_2 = ride_app_test_parameters[caseId][2];
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		// ***********PAGE METHODS**************
		ana_Ekran.Surus_Baslat_Basarili(param_1, param_2);
	}

	@Test(priority = 22)
	public void TC_022_Surus_Baslat_Basarisiz_Martiya_Uzak() {
		// *******************SET PARAMETERS************************
		param_1 = ride_app_test_parameters[caseId][1];
		param_2 = ride_app_test_parameters[caseId][2];
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		// ***********PAGE METHODS**************
		ana_Ekran.Surus_Baslat_Basarisiz_Martiya_Uzak(param_1, param_2);
	}

	@Test(priority = 23)
	public void TC_023_Daha_Cok_Marti() {
		// *******************SET PARAMETERS************************
		param_1 = ride_app_test_parameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		// ***********PAGE METHODS**************
		ana_Ekran.Daha_Cok_Marti(param_1);
	}

	@Test(priority = 24)
	public void TC_024_Bize_Ulasin_Kilit_Problemi_Bildirme() {
		// *******************SET PARAMETERS************************
		param_1 = ride_app_test_parameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		// ***********PAGE METHODS**************
		ana_Ekran.Bize_Ulasin_Kilit_Problemi_Bildirme(param_1);
	}

	@Test(priority = 25)
	public void TC_025_Bize_Ulasin_Hasarli_Sorunlu_Marti_Bildirme() {
		// *******************SET PARAMETERS************************
		param_1 = ride_app_test_parameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		// ***********PAGE METHODS**************
		ana_Ekran.Bize_Ulasin_Hasarli_Sorunlu_Marti_Bildirme(param_1);
	}

	@Test(priority = 26)
	public void TC_026_Bize_Ulasin_Yanlis_Park() {
		// *******************SET PARAMETERS************************
		param_1 = ride_app_test_parameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		// ***********PAGE METHODS**************
		ana_Ekran.Bize_Ulasin_Yanlis_Park(param_1);
	}

	@Test(priority = 27)
	public void TC_027_Bize_Ulasin_Acil_Durum_Paylas() {
		// *******************SET PARAMETERS************************
		param_1 = ride_app_test_parameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		// ***********PAGE METHODS**************
		ana_Ekran.Bize_Ulasin_Acil_Durum_Paylas(param_1);
	}

	@Test(priority = 28)
	public void TC_028_Bildirimleri_Kontrol_Etme() {
		// *******************SET PARAMETERS************************
		param_1 = ride_app_test_parameters[caseId][1];
		// *******************PAGE INSTANTIATIONS*******************
		ana_Ekran = new pageAnaEkran(androidDriver);
		// ***********PAGE METHODS**************
		ana_Ekran.Bildirimleri_Kontrol_Etme(param_1);
	}

}
