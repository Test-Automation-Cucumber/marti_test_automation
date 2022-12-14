package pages.android.security;


import org.openqa.selenium.html5.Location;

import dbmodel.Provider;
//import ch.hsr.geohash.GeoHash;
import dbmodel.DataPreparation.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.PageBaseAndroid;

public class pageHaritaDetay extends PageBaseAndroid {
	AndroidDriver<AndroidElement> androidDriver;
	Customer customer;
	Scooter scooter;
	TestDevice testDevice;
	pageHaritaDetay saha_Ekrani;	
	Provider provider;
	
	// *********Constructor*********
		public pageHaritaDetay(AndroidDriver<AndroidElement> androidDriver) {
			super(androidDriver);
			this.androidDriver = androidDriver;
			customer = new Customer();
			scooter = new Scooter();
			testDevice = new TestDevice();
			provider = new Provider();
		}

		// *****************************************Web Elements***********************************
		
		// *****************General
		String btn_SahayaGit 											= "#goToTasks";
		String btn_ArizaBildir 											= "#btnReportIssue";
		String li_TumIslerim 											= "#txtWorkOrderList";
		String lbl_VeriBulunamadi										= "#txtDataNotFound";
		String btn_GoreveBasla											= "#btnMultiTask";
		String popup_Message											= "#android:id/message";
		String popup_Tamam												= "#android:id/button1";
		String btn_MartiKilitli											= "#inSecure";
		String btn_MartiyiBagla											= "#inSecure";
		String btn_Geri													= "#btnBack";
		String lbl_Title												= "#appTitle";
		String btn_BaskaBirGorevYapacagim								= "#btnReportIssue";
		String btn_GoreviTamamlayamadimDiger							= "*com.martitech.security.dev:id/reason";
		String btn_GosterilenYerdeyim									= "#btnMultiTask";
		String lbl_GecenSure											= "#durationText";
		String btn_Calinmis												= "#btnStolen";
		String btn_Guvende												= "#inSecure";
		String btn_ZiliCaldir											= "#ringBell";
		String btn_FarAcKapat											= "#headLight";
		String btn_FotoYaBak											= "#showLatestPhoto";
		String btn_NavigasyonAl											= "#gotoNavigation";
		String btn_TumKonumlar											= "#showLatestLocations";
		String btn_GoreviTamamlayamadim									= "#btnCancel";
		String btn_ABC1													= "#icCode";
		String txt_ScooterCode											= "#editText2";
		String btn_QrTamam												= "#btnOk";
		String btn_FotoCek												= "#capture_button";
		String btn_GoreviTamamla										= "#completeTask";
		String popup_Iptal												= "#android:id/button2";
		String btn_X													= "#btnClose";
		String btn_Konumum												= "@Konumum";
		String chb_TumKonumlariGoster									= "#allLocations";
		
		
		
				// *********Page Methods*********
		public pageHaritaDetay Isleme_Basla_Buton_Kontrolu() {
			click(btn_SahayaGit);
			swipe(btn_ArizaBildir, 238, 1683, 196, 316, 612);
			click(li_TumIslerim);
			click("$Kilit Kontrol");
			click(btn_GoreveBasla);
			click(popup_Tamam);
			return this;
		}	
		
		public pageHaritaDetay Baska_Bir_Gorev_Yapacagim_Kontrolu() {
			click(btn_SahayaGit);
			swipe(btn_ArizaBildir, 238, 1683, 196, 316, 612);
			click(li_TumIslerim);
			click("$??al??nt??");
			click(btn_GoreveBasla);
			click(popup_Tamam);
			click(btn_BaskaBirGorevYapacagim);
			assertEquals(popup_Message, "Art??k ba??ka bir g??reve ba??layabilirsin");
			click(popup_Tamam);
			click("$??al??nt??");
			assertFound(btn_GoreveBasla);
			return this;
		}
		
		public pageHaritaDetay Calinti_Is_Emri_Detay(String scooter_code) {
			click(btn_SahayaGit);
			swipe(btn_ArizaBildir, 238, 1683, 196, 316, 612);
			click(li_TumIslerim);
			click("$??al??nt??");
			click(btn_GoreveBasla);
			click(popup_Tamam);
			androidDriver.setLocation(new Location(41.0100247, 29.0389191, 1)); //uzaklaaaar
			wait(3);
			click(btn_GosterilenYerdeyim);
			assertEquals(popup_Message, "Do??ru konumda de??ilsin, harita ??zerinde g??sterilen konuma gitmelisin.");
			click(popup_Tamam);
			androidDriver.setLocation(new Location(41.006405, 29.074996, 1)); //ofis
			wait(3);
			
			click(btn_GosterilenYerdeyim);
			assertFound(lbl_GecenSure);
			swipe(btn_Calinmis, 238, 1683, 196, 316, 612);
			assertFound(btn_ZiliCaldir);
			assertFound(btn_FarAcKapat);
			assertFound(btn_FotoYaBak);
			
			click(btn_NavigasyonAl);
			click(btn_Konumum);
			back();
			
			assertFound(btn_TumKonumlar);
			assertFound(btn_GoreviTamamlayamadim);
			
			click(btn_Guvende);
			click(btn_ABC1);
			writeText(txt_ScooterCode, "UK7P");
			click(btn_QrTamam);
			click(btn_FotoCek); 
			assertEquals(popup_Message, "Bu g??rev bulunamad??.");
			click(popup_Tamam);

			click(btn_Guvende);
			click(btn_ABC1);
			writeText(txt_ScooterCode, scooter_code);
			click(btn_QrTamam);
			click(btn_FotoCek); 
			click(btn_GoreviTamamla);
			click(popup_Iptal);
			
			click(btn_GoreviTamamla);
			click(popup_Tamam);
			assertEquals(popup_Message, "G??rev tamamland?? olarak i??aretlendi");
			click(popup_Tamam);
			assertFound(btn_ArizaBildir);
			return this;
		}
		
		public pageHaritaDetay Supheli_Is_Emri_Detay() {
			click(btn_SahayaGit);
			swipe(btn_ArizaBildir, 238, 1683, 196, 316, 612);
			click(li_TumIslerim);
			click("$????pheli");
			click(btn_GoreveBasla);
			click(popup_Tamam);
			swipe(btn_Calinmis, 238, 1683, 196, 316, 612);
			assertFound(btn_ZiliCaldir);
			assertFound(btn_FarAcKapat);
			assertFound(btn_FotoYaBak);
			assertFound(btn_NavigasyonAl);
			assertFound(btn_TumKonumlar);
			assertFound(btn_GoreviTamamlayamadim);
			return this;
		}
		
		public pageHaritaDetay Bulunamadi_Is_Emri_Detay() {
			click(btn_SahayaGit);
			swipe(btn_ArizaBildir, 238, 1683, 196, 316, 612);
			click(li_TumIslerim);
			click("$Kay??p");
			click(btn_GoreveBasla);
			click(popup_Tamam);
			wait(1);
			swipe(btn_Calinmis, 238, 1683, 196, 316, 612);
			
			click(btn_ZiliCaldir);
			assertContains(popup_Message, "15 sn sonra tekrar ??ald??rabilirsin.");
											
			click(popup_Tamam);
			wait(1);
			click(btn_ZiliCaldir);
			assertNotFound(popup_Message);
			
			click(btn_FarAcKapat);
			click(btn_FotoYaBak);
			click(btn_X);
			click(btn_NavigasyonAl);
			wait(3);
			back();
			click(chb_TumKonumlariGoster);
			wait(1);
			click(chb_TumKonumlariGoster);
			click(btn_GoreviTamamlayamadim);
			click(btn_GoreviTamamlayamadimDiger);
			assertEquals(popup_Message, "G??rev tamamlanamad?? olarak i??aretlendi");
			click(popup_Tamam);
			return this;
		}
		
		public pageHaritaDetay Musteri_Is_Emri_Detay(String scooter_code) {
			click(btn_SahayaGit);
			swipe(btn_ArizaBildir, 238, 1683, 196, 316, 612);
			click(li_TumIslerim);
			click("$M????teri");
			click(btn_GoreveBasla);
			click(popup_Tamam);
			swipe(btn_MartiyiBagla, 238, 1683, 196, 316, 612);
			assertFound(btn_ZiliCaldir);
			assertFound(btn_FarAcKapat);
			assertFound(btn_FotoYaBak);
			assertFound(btn_NavigasyonAl);
			assertFound(btn_TumKonumlar);
			assertFound(btn_GoreviTamamlayamadim);

			click(btn_MartiyiBagla);
			click(btn_ABC1);
			writeText(txt_ScooterCode, "UK7P");
			click(btn_QrTamam);
			click(btn_FotoCek);
			assertEquals(popup_Message, "Bu g??rev bulunamad??.");
			click(popup_Tamam);
			
			click(btn_MartiyiBagla);
			click(btn_ABC1);
			writeText(txt_ScooterCode, scooter_code);
			click(btn_QrTamam);
			click(btn_FotoCek);
			click(btn_GoreviTamamla);
			click(popup_Iptal);
			
			click(btn_GoreviTamamla);
			assertEquals(popup_Message, "G??revi tamamlad??????na emin misin ?");
			click(popup_Tamam);
			assertEquals(popup_Message, "G??rev tamamland?? olarak i??aretlendi");
			click(popup_Tamam);
			assertFound(btn_ArizaBildir);
			return this;
		}
		
		public pageHaritaDetay Kilit_Kontrol_Is_Emri_Detay(String scooter_code) {
			click(btn_SahayaGit);
			swipe(btn_ArizaBildir, 238, 1683, 196, 316, 612);
			click(li_TumIslerim);
			click("$Kilit Kontrol");
			click(btn_GoreveBasla);
			click(popup_Tamam);
			swipe(btn_MartiKilitli, 238, 1683, 196, 316, 612);
			assertFound(btn_ZiliCaldir);
			assertFound(btn_FarAcKapat);
			assertFound(btn_FotoYaBak);
			assertFound(btn_NavigasyonAl);
			assertFound(btn_TumKonumlar);
			assertFound(btn_GoreviTamamlayamadim);
			
			click(btn_MartiKilitli);
			click(btn_ABC1);
			writeText(txt_ScooterCode, "UK7P");
			click(btn_QrTamam);
			click(btn_FotoCek);
			assertEquals(popup_Message, "Bu g??rev bulunamad??.");
			click(popup_Tamam);
			
			click(btn_MartiKilitli);
			click(btn_ABC1);
			writeText(txt_ScooterCode, scooter_code);
			click(btn_QrTamam);
			click(btn_FotoCek);
			click(btn_GoreviTamamla);
			click(popup_Iptal);
			
			click(btn_GoreviTamamla);
			assertEquals(popup_Message, "G??revi tamamlad??????na emin misin ?");
			click(popup_Tamam);
			assertEquals(popup_Message, "G??rev tamamland?? olarak i??aretlendi");
			click(popup_Tamam);
			assertFound(btn_ArizaBildir);
			
			return this;
		}
		
		public pageHaritaDetay Calinmis_Basarili(String userPhoneNumber, String scooter_code) {
			click(btn_SahayaGit);
			swipe(btn_ArizaBildir, 238, 1683, 196, 316, 612);
			click(li_TumIslerim);
			click("$??al??nt??");
			click(btn_GoreveBasla);
			click(popup_Tamam);
			click(btn_GosterilenYerdeyim);
			try {
				provider.ExecuteCommand("update security_action_logs set action_time = (now() - interval '15 minute') where user_id = (select id from users where mobile_phone = '90" + userPhoneNumber + "');"
						, "martiDB");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			click(btn_Calinmis);
			assertEquals(popup_Message, "Scooter ??al??nt?? olarak i??aretlendi.");
			click(popup_Tamam);
			return this;
		}
		
		
		
}