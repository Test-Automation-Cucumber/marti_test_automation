package pages.android.security;


//import ch.hsr.geohash.GeoHash;
import dbmodel.DataPreparation.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.PageBaseAndroid;

public class pageSahaEkrani extends PageBaseAndroid {
	AndroidDriver<AndroidElement> androidDriver;
	Customer customer;
	Scooter scooter;
	TestDevice testDevice;
	pageSahaEkrani saha_Ekrani;	

	
	// *********Constructor*********
		public pageSahaEkrani(AndroidDriver<AndroidElement> androidDriver) {
			super(androidDriver);
			this.androidDriver = androidDriver;
			customer = new Customer();
			scooter = new Scooter();
			testDevice = new TestDevice();
		}

		// *****************************************Web Elements***********************************
		
		// *****************General
		String btn_SahayaGit 											= "#goToTasks";
		String btn_ArizaBildir 											= "btnReportIssue";
		String li_TumIslerim 											= "#txtWorkOrderList";
		String lbl_VeriBulunamadi										= "#txtDataNotFound";
		String li_DepoyaGit												= "#txtWareHouse";
		String img_MartiLogo											= "#appLogo";
		
		// *********Page Methods*********

		public pageSahaEkrani Herhangi_Bir_Gorev_Yok() {
			click(btn_SahayaGit);
			swipe(btn_ArizaBildir, 238, 1683, 196, 316, 612);
			click(li_TumIslerim);
			assertFound(lbl_VeriBulunamadi);
			return this;
		}
		
		public pageSahaEkrani Gorev_Gosterimi(String scooter_code) {
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
		
		public pageSahaEkrani Depoya_Git_Secenegi() {
			click(btn_SahayaGit);
			swipe(btn_ArizaBildir, 238, 1683, 196, 316, 612);
			click(li_DepoyaGit);
			assertFound(img_MartiLogo);
			
			return this;
		}
		
		public pageSahaEkrani Ariza_Bildir() {
			click(btn_SahayaGit);
			click(btn_ArizaBildir);
			
			return this;
		}
		
		
}