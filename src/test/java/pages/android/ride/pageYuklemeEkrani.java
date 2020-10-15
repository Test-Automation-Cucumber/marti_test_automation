package pages.android.ride;



//import ch.hsr.geohash.GeoHash;
import dbmodel.DataPreparation.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import okhttp3.Connection;
import utilities.PageBaseAndroid;

public class pageYuklemeEkrani extends PageBaseAndroid {
	AndroidDriver<AndroidElement> androidDriver;
	Customer customer;
	Scooter scooter;
	TestDevice testDevice;
	pageGirisEkrani giris_Ekrani;	
	pageSurus surus_Ekrani;
	
	// *********Constructor*********
		public pageYuklemeEkrani(AndroidDriver<AndroidElement> androidDriver) {
			super(androidDriver);
			this.androidDriver = androidDriver;
			customer = new Customer();
			scooter = new Scooter();
			testDevice = new TestDevice();
			
			giris_Ekrani = new pageGirisEkrani(this.androidDriver);
			surus_Ekrani = new pageSurus(this.androidDriver);
		}

		// *****************************************Web Elements***********************************
		
		// *****************General
		String ProgressBar 											= "#progressBar"; //PROGRESS BAR
		String btn_Kapat											= "#snackbar_action";
		String txt_TelNo											= "#phoneNumber";
		String btn_KonumErisimIzni									= "#btnEnableLoc";
		String btn_Tamam											= "#android:id/button1";
		String btn_HayirTesekkurler									= "#android:id/button2";
		String popup_Message										= "#android:id/message";
		String btn_FotoCekBitir										= "#btnEndRide";
		String img_NotifyIcon										= "#imageView25";
		String lbl_Reservasyon										= "#textView3";
		String btn_Ileri											= "#btnOk";
		String lbl_NasilKullanilir									= "#textView14";
		String txt_Tckn												= "#tckn";
		String btn_Kvkk												= "#btnReadKvvk";
		String img_DynamicPopup										= "#android:id/popupTitle";
		String btn_ReserveEt										= "#btnReserve";
		String btn_ReserveEt2										= "#btnReserveButton";
		String btn_ReserveIptalEt									= "#btnCancelReserve";
		String btn_Basla											= "#btnScan";

		
		//SLACK
		String slack_name										= "$Metin Emre Şen";
		String sign_in_button									= "#sign_in_button";
		String sign_in_manually_button							= "#sign_in_manually_button";
		String team_url_edit_text								= "#team_url_edit_text";
		String next_button_url_entry							= "#next_button_url_entry";
		String email_edit_text									= "#email_edit_text";
		String next_button										= "#next_button";
		String password_edit_text								= "#password_edit_text";
		String next_button_password								= "#next_button_password";
		String slack_action_item_label							= "$Delete Message";
		String ok_button										= "#ok_button";
		String messages_list									= "#messages_list";
			
		
		// *********Page Methods*********

		public pageYuklemeEkrani Yukleme_Ekrani_Basarili() {
			click(sign_in_button);
			click(sign_in_manually_button);
			writeText(team_url_edit_text, "martitech");
			click(next_button_url_entry);
			writeText(email_edit_text, "metin@marti.tech");
			click(next_button);
																																																										writeText(password_edit_text, "315321ASd+");
			click(next_button_password);

			for (int i = 0; i < 99000; i++) {

			if (exists(slack_name,1)) {
				longClick(slack_name, 0);
				click(slack_action_item_label);
				click(ok_button);
			}
			else
				swipe(messages_list, 491, 711,619,1727, 533);
			}
			
			return this;
		}
		
	public pageYuklemeEkrani Yukleme_Ekrani_Basarisiz(String customer_phone_no) {
		customer
		.addTcknAndKvkkValidation(customer_phone_no);
		
		testDevice
		.setAndroidWIFIServiceStatus(androidDriver, false)
		.setAndroidDataServiceStatus(androidDriver, false);

		androidDriver.resetApp();
		
		click(btn_Kapat);
		
		testDevice
		.setAndroidWIFIServiceStatus(androidDriver, true)
		.setAndroidDataServiceStatus(androidDriver, true);
		
		return this;
	}
	public pageYuklemeEkrani Uygulama_Baslangici_Basarili() {
		androidDriver.resetApp();
		assertFound(txt_TelNo);
		return this;
	}
//	public pageYuklemeEkrani Konum_Izni_Kontrolu(String customerPhoneNumber) {
//		giris_Ekrani
//		.Giris_Basarili(customerPhoneNumber);	
//		
//		wait(5);
//		androidDriver.toggleLocationServices(); //konum kapanir
//		wait(5);
//		String appPackageName=androidDriver.getCurrentPackage();
//		androidDriver.closeApp();
//		androidDriver.activateApp(appPackageName);
//	
//		if (exists(btn_HayirTesekkurler, 10)) {
//			click(btn_HayirTesekkurler);
//		}	
//		assertFound(btn_KonumErisimIzni);
//		wait(5);
//		androidDriver.toggleLocationServices(); //konum acilir
//		wait(5);
//		return this;
//	}

	public pageYuklemeEkrani Surus_Kontrolu(String customer_phone_no, String scooter_code) {
		String appPackageName = androidDriver.getCurrentPackage();
		androidDriver.closeApp();
		androidDriver.activateApp(appPackageName);
		
		while (exists(lbl_NasilKullanilir, 5)) {
			click(btn_Ileri);
			waitMilliSec(750);
		}
		assertFound(btn_FotoCekBitir);
		
		customer
		.deleteCustomerRides(customer_phone_no);
		
		return this;
	}	
//	public pageYuklemeEkrani Rezervasyon_Kontrolu(String customer_phone_no, String scooter_code) {
//		customer
//		.deleteCustomerRides(customer_phone_no)
//		.deleteCustomerReservations(customer_phone_no);
//		
//		scooter
//		.addScooter(scooter_code);
//
//		giris_Ekrani
//		.Giris_Basarili(customer_phone_no);
//		
//		findScooter("AUT1");
//				
//		click(btn_ReserveEt);
//		wait(2);
//		click(btn_ReserveEt2);
//		waitLoadingImage();
//		click(btn_ReserveIptalEt);
//		assertEquals(popup_Message, "Rezervasyonunu iptal etmek istediğine emin misin?");
//		click(btn_HayirTesekkurler);
//		click(btn_ReserveIptalEt);
//		click(btn_Tamam);
//		waitLoadingImage();
//		assertFound(btn_Ileri);
//		click(btn_Ileri);
//		assertFound(btn_Basla);
//		customer
//		.deleteCustomerReservations(customer_phone_no);
//		
//		return this;
//	}
	public pageYuklemeEkrani Tckn_Kontrolu(String customer_phone_no) {

//		String appPackageName = androidDriver.getCurrentPackage();
//		androidDriver.closeApp();
//		androidDriver.activateApp(appPackageName);
		
		assertFound(btn_Basla);
		wait(4);
		click(btn_Basla);
		assertEquals(popup_Message, "Profil bilgilerini doğrulayamadık. Bilgileri kimliğinde görüldüğü gibi, eksiksiz bir şekilde doldurmalısın. Profil bilgilerini güncellemezsen sürüşüne başlayamazsın.");
		click(btn_Tamam);
		
		assertFound(txt_Tckn);
		
		customer
		.addTcknAndKvkkValidation(customer_phone_no);
		return this;
	}
//	public pageYuklemeEkrani Kvkk_Kontrolu(String customer_phone_no) {
//		customer
//		.addTcknAndKvkkValidation(customer_phone_no)
//		.deleteKvkkValidation(customer_phone_no);
//		
//		giris_Ekrani
//		.Giris_Basarili(customer_phone_no);
//		
////		String appPackageName = androidDriver.getCurrentPackage();
////		androidDriver.closeApp();
////		androidDriver.activateApp(appPackageName);
////		wait(2);
//		
//		click(btn_Kvkk);
//
//		waitLoadingImage();
//		customer
//		.addTcknAndKvkkValidation(customer_phone_no);
//		return this;
//	}
//	public pageYuklemeEkrani Dinamik_Bildirim_Kontrolu(String customer_phone_no) {
////		String geohash = GeoHash.geoHashStringWithCharacterPrecision(53.244664, -6.140530, 7);
//		customer
//		.activateLocalCampaign(customer_phone_no, true);
//		
//		String appPackageName = androidDriver.getCurrentPackage();
//		androidDriver.closeApp();
//		androidDriver.activateApp(appPackageName);
//
////		androidDriver;
////		String currentContext = appiumDriver.getContext();
////		appiumDriver.context("NATIVE_APP");
//
//		// actions within the alert
////		appiumDriver.findElement(By.xpath("//*[@text='TAMAM']")).click(); // put locator instead of OK_BUTTON_LOCATOR
////		appiumDriver.context(currentContext);
// 
//        assertFound(img_DynamicPopup);
//		
//		return this;
//	}

	
}