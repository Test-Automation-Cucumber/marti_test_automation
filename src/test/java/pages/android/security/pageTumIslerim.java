package pages.android.security;


//import ch.hsr.geohash.GeoHash;
import dbmodel.DataPreparation.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.PageBaseAndroid;

public class pageTumIslerim extends PageBaseAndroid {
	AndroidDriver<AndroidElement> androidDriver;
	Customer customer;
	Scooter scooter;
	TestDevice testDevice;
	pageTumIslerim saha_Ekrani;	

	
	// *********Constructor*********
		public pageTumIslerim(AndroidDriver<AndroidElement> androidDriver) {
			super(androidDriver);
			this.androidDriver = androidDriver;
			customer = new Customer();
			scooter = new Scooter();
			testDevice = new TestDevice();
		}

		// *****************************************Web Elements***********************************
		
		// *****************General
		String btn_SahayaGit 											= "#goToTasks";
		String btn_ArizaBildir 											= "#btnReportIssue";
		String li_TumIslerim 											= "#txtWorkOrderList";
		String lbl_VeriBulunamadi										= "#txtDataNotFound";
		String btn_GoreveBasla											= "#btnMultiTask";
		String popup_Message											= "#android:id/message";
		String btn_Tamam												= "#android:id/button1";
		String btn_MartiKilitli											= "#inSecure";
		String btn_Geri													= "#btnBack";
		String lbl_Title												= "#appTitle";
		
		
		// *********Page Methods*********
		public pageTumIslerim Tum_Islerim_Listesi(String scooter_code) {
			click(btn_SahayaGit);
			swipe(btn_ArizaBildir, 238, 1683, 196, 316, 612);
			click(li_TumIslerim);
			
			scooter_code = scooter_code.substring(0, 3).toUpperCase();
			assertFound("$" + scooter_code + "1");
			assertFound("$" + scooter_code + "2");
			assertFound("$" + scooter_code + "3");
			assertFound("$" + scooter_code + "4");
			assertFound("$" + scooter_code + "5");
			
			assertFound("$Çalıntı");
			assertFound("$Şüpheli");
			assertFound("$Kayıp");
			assertFound("$Kilit Kontrol");
			assertFound("$Müşteri");
			
			return this;
		}
		
		public pageTumIslerim Tum_Islerim_Detay_Aktif_Isi_Yok() {
			click(btn_SahayaGit);
			swipe(btn_ArizaBildir, 238, 1683, 196, 316, 612);
			click(li_TumIslerim);
			click("$Kilit Kontrol");
			click(btn_GoreveBasla);
			assertEquals(popup_Message, "İş emrine başlamak istediğine emin misin?");
			click(btn_Tamam);
			assertFound(btn_MartiKilitli);
			return this;
		}
		
		public pageTumIslerim Tum_Islerim_Detay_Aktif_Isi_Var() {
			click(btn_SahayaGit);
			swipe(btn_ArizaBildir, 238, 1683, 196, 316, 612);
			click(li_TumIslerim);
		
			click("$Kilit Kontrol");
			click(btn_GoreveBasla);
			click(btn_Tamam);
			click(btn_Geri);
			
			click("$Kayıp");
			assertEquals(popup_Message, "Öncelikle aktif iş emrini tamamlamalısın. (C055)");
			click(btn_Tamam);
			return this;
		}

		
		
		
}