package tests.android.ride;

import org.testng.annotations.Test;

import dbmodel.Provider;
import pages.android.ride.pageAnaEkran;
import pages.android.ride.pageSurus;
import utilities.TestBase;

public class Surus extends TestBase {
	Provider provider = new Provider();
	pageSurus surus;
	pageAnaEkran ana_Ekran;
	String methodName;
	String param_1;
	String param_2;
	String param_3;
	String param_4;
	String param_5;

// *********Constructor*********
	public Surus() {
		queryGetParameters = "select * from ride_app_test_parameters order by tc_id;";
	}

// ******************************************************* TEST ***********************************************************

//	@Test(priority = 34)
//	public void TC_034_Surus_Basladi_Kodlu_Kilit() {
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		// ***********PAGE METHODS**************
//		surus.Surus_Basladi_Kodlu_Kilit(param_1, param_2);
//	}
//
	@Test(priority = 35)
	public void TC_035_Surus_Baslat() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		// *******************PAGE INSTANTIATIONS*******************
		surus = new pageSurus(androidDriver);
		// ***********PAGE METHODS**************
		surus.Surus_Basladi_IOT_Kilit(param_1, param_2);
	}

	@Test(priority = 36)
	public void TC_036_Nasil_Surulur_Gecilmemis() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		// *******************PAGE INSTANTIATIONS*******************
		surus = new pageSurus(androidDriver);
		// ***********PAGE METHODS**************
		surus.Nasil_Surulur_Gecilmemis(param_1, param_2);
	}

	@Test(priority = 37)
	public void TC_037_Acil_Mudahale() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		// *******************PAGE INSTANTIATIONS*******************
		surus = new pageSurus(androidDriver);
		// ***********PAGE METHODS**************
		surus.Acil_Mudahale(param_1, param_2);
	}

	@Test(priority = 38)
	public void TC_038_Nasil_Surulur() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		// *******************PAGE INSTANTIATIONS*******************
		surus = new pageSurus(androidDriver);
		// ***********PAGE METHODS**************
		surus.Nasil_Surulur(param_1, param_2);
	}

	@Test(priority = 39)
	public void TC_039_Ortalama() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		// *******************PAGE INSTANTIATIONS*******************
		surus = new pageSurus(androidDriver);
		// ***********PAGE METHODS**************
		surus.Ortalama(param_1, param_2);
	}

	@Test(priority = 40)
	public void TC_040_Surus_Bitirme() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		// *******************PAGE INSTANTIATIONS*******************
		surus = new pageSurus(androidDriver);
		// ***********PAGE METHODS**************
		surus.Surus_Bitirme(param_1, param_2);
	}

	@Test(priority = 41)
	public void TC_041_Park_Edilemez_Alan() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		// *******************PAGE INSTANTIATIONS*******************
		surus = new pageSurus(androidDriver);
		// ***********PAGE METHODS**************
		surus.Park_Edilemez_Alan(param_1, param_2);
	}

	@Test(priority = 42)
	public void TC_042_Kilit_Takilmadi() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		// *******************PAGE INSTANTIATIONS*******************
		surus = new pageSurus(androidDriver);
		// ***********PAGE METHODS**************
		surus.Kilit_Takilmadi(param_1, param_2);
	}

//	@Test(priority = 43)
//	public void TC_043_Kamera_Izni_Verilmemis() {  app çalışırken izinleri işleyen case'lere sonra bak.
//		// *******************SET PARAMETERS************************
//		param_1 = testParameters[caseId][1];
//		param_2 = testParameters[caseId][2];
//		// *******************PAGE INSTANTIATIONS*******************
//		surus = new pageSurus(androidDriver);
//		// ***********PAGE METHODS**************
//		surus.Kamera_Izni_Verilmemis();
//	}

	@Test(priority = 44)
	public void TC_044_Surus_Bitir_Internet_Kapali() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		// *******************PAGE INSTANTIATIONS*******************
		surus = new pageSurus(androidDriver);
		// ***********PAGE METHODS**************
		surus.Surus_Bitir_Internet_Kapali(param_1, param_2);
	}

	@Test(priority = 45)
	public void TC_045_Ceza_Kurallarina_Erisim() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		// *******************PAGE INSTANTIATIONS*******************
		surus = new pageSurus(androidDriver);
		// ***********PAGE METHODS**************
		surus.Ceza_Kurallarina_Erisim(param_1, param_2);
	}

	@Test(priority = 46)
	public void TC_046_Odeme_Hatasi() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		// *******************PAGE INSTANTIATIONS*******************
		surus = new pageSurus(androidDriver);
		// ***********PAGE METHODS**************
		surus.Odeme_Hatasi(param_1, param_2);
	}

	@Test(priority = 47)
	public void TC_047_Surus_Bitirme_Basarili() {
		// *******************SET PARAMETERS************************
		param_1 = testParameters[caseId][1];
		param_2 = testParameters[caseId][2];
		// *******************PAGE INSTANTIATIONS*******************
		surus = new pageSurus(androidDriver);
		// ***********PAGE METHODS**************
		surus.Surus_Bitirme_Basarili(param_1, param_2)
		.Yolculugu_Degerlendirme(param_1);
	}
}
