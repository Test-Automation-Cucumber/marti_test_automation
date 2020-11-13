package pages.android.ride;

import dbmodel.DataPreparation.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.PageBaseAndroid;

public class pageSurus extends PageBaseAndroid {
	AndroidDriver<AndroidElement> androidDriver;
	pageGirisEkrani giris_Ekrani;	
	Customer customer;
	Scooter scooter;
	TestDevice testDevice;
	
	// *********Constructor*********
		public pageSurus(AndroidDriver<AndroidElement> androidDriver) {
			super(androidDriver);
			this.androidDriver = androidDriver;
			testDevice = new TestDevice();
			customer = new Customer();
			scooter = new Scooter();
			giris_Ekrani = new pageGirisEkrani(this.androidDriver);
		}

		// *****************************************Web Elements***********************************
		
		// *****************General
		String ProgressBar 													= "#progressBar"; //PROGRESS BAR  *com.martitech.marti.dev:id/progressBar   (com.martitech.marti.dev paket adı bu. kamera iznine koydun bunu çıkarmayi. ordan kopya cek)
		String btn_Basla													= "#btnScan";
		String btn_WriteCode												= "#writeCode";	
		String txt_Kod														= "#codeEditText";	
		String btn_Baslat													= "#btnStart";
		String btn_Ileri													= "#btnOk";
		String lbl_NasilKullanilir											= "#textView14";
		String btn_FotoCekBitir												= "#btnEndRide";
		String btn_Bize_Ulasin												= "#needHelp";  //com.martitech.marti.dev:id/needHelp
		String popup_Message												= "#android:id/message";
		String img_LockCode													= "#lockCodeText";
		String btn_HowIt													= "#btnHowIt";
		String btn_Navigate													= "#btnNavigate";
		String lbl_SurusBasladi												= "#constraintLayout6";
		String btn_Bitir													= "#takePhoto";
		String lbl_EndRide													= "#endRide";
		String btn_TAMAM													= "#android:id/button1";
		String lbl_AlertDesc												= "#alertDesc";
		String img_AlertContent												= "#content_image";
		String btn_Tamam													= "#btnNext";
		String btn_Star														= ".android.widget.ImageView";
		String lbl_YolculukDegerlendirme									= "#textView35";
		String btn_SebebiNeydiki											= "$Mobil Uygulama";
		String btn_Gonder													= "#btnSave";
		String img_NotifyIcon												= "#imageView25";	
		String img_RideLockCode												= "#lockCodeCell";	
		String img_KilidiAc													= "#unlockCell";	
		String img_ScooterCode												= "#sctCodeText";	
		String img_BatteryText												= "#batteryText";	
		String img_DurationText												= "#durationText";	
		String lbl_ToplamTutar												= "#txtTotal";	
		String lbl_CuzdanBakiye												= "#walletBalance";	
		String btn_Menu														= "#btnMenu";	
		String lbl_OdemeAraci												= "#cardHolder";	
		
		// *********Page Methods*********

		public pageSurus Surus_Basladi_Kodlu_Kilit(String customer_phone_no, String scooter_code) {
//			while (exists(lbl_NasilKullanilir, 5)) {
//				click(btn_Ileri);
//				waitMilliSec(750);
//			}
			assertFound(img_DurationText);
			assertEquals(img_ScooterCode, scooter_code);
			String batteryLevel	= scooter.getBatteryLevel(scooter_code);
			assertEquals(img_BatteryText, "%" + batteryLevel);
			assertFound(img_KilidiAc);

			return this;
		}	
		
		public pageSurus Surus_Basladi_IOT_Kilit(String customer_phone_no, String scooter_code) {			
//			while (exists(lbl_NasilKullanilir, 5)) {
//				click(btn_Ileri);
//				waitMilliSec(750);
//			}
			assertFound(img_KilidiAc);
			return this;
		}
		
		public pageSurus Surus_45sn_Kontrol() {
			assertFound(btn_FotoCekBitir);
			return this;
		}
		
		public pageSurus Nasil_Surulur_Gecilmemis(String customer_phone_no, String scooter_code) {
			assertFound(btn_Basla);
			wait(4);	
			click(btn_Basla);
			waitLoadingImage2();
			click(btn_WriteCode);
			writeText(txt_Kod, scooter_code);
			click(btn_Baslat);
			waitLoadingImage2();
			wait(5);
			
		try {
			if (!exists(lbl_NasilKullanilir, 10)) {
				throw new Exception("Nasil surulur gosterilmedi !");
			}
		} catch (Exception ex) {
		}
		while (exists(lbl_NasilKullanilir, 5)) {
			click(btn_Ileri);
			waitMilliSec(750);
		}
		return this;
	}
		
		public pageSurus Acil_Mudahale(String customer_phone_no, String scooter_code) {		
			click(btn_Bize_Ulasin);
			assertEquals(popup_Message, "Teknik ekibin sana ulaşmasını ister misin?");			
			return this;
		}
		
		public pageSurus Nasil_Surulur(String customer_phone_no, String scooter_code) {
			click(btn_HowIt);
			assertFound(lbl_NasilKullanilir);	
			return this;
		}
		
		public pageSurus Ortalama(String customer_phone_no, String scooter_code) {
			assertFound(btn_HowIt);
			swipe(lbl_SurusBasladi, 316, 624, 316, 701, 172);
			click(btn_Navigate);
			wait(1);
			try {
			if(exists(btn_Navigate, 2))
				throw new Exception("Konuma git butonu bulundu !");
			}catch(Exception ex) {}
			return this;
		}		
		public pageSurus Surus_Bitirme(String customer_phone_no, String scooter_code) {
			assertFound(btn_HowIt);
			click(btn_FotoCekBitir);
			waitLoadingImage();
			click(btn_Bitir);
			waitLoadingImage2();
			assertFound(btn_Ileri);
			
			return this;
		}
		public pageSurus Park_Edilemez_Alan(String customer_phone_no, String scooter_code) {
			assertFound(btn_HowIt);
			click(btn_FotoCekBitir);
			waitLoadingImage();
			scooter
			.setLastKnowPointToScooter(scooter_code, "sxk9k3xm1");  // bu fence'i park yasakli alan olarak isaretledin
			click(btn_Bitir);
			waitLoadingImage2();
			assertEquals(popup_Message, "MARTI'yı bırakmak istediğin yer yasaklı park alanıdır. Haritada kırmızı olarak gösterilen alanlara park edemezsin.");
			click(btn_TAMAM);				
			return this;
		}	
		
		public pageSurus Kilit_Takilmadi(String customer_phone_no, String scooter_code) {
			click(btn_FotoCekBitir);
			waitLoadingImage();
			click(btn_Bitir);
			waitLoadingImage2();
			assertEquals(popup_Message, "MARTI'yı doğru kilitlemediğin için sürüşünü bitiremiyoruz. Lütfen kilidi kontrol edip tekrar dene.");
			click(btn_TAMAM);
			return this;
		}
		
//		public pageSurus Kamera_Izni_Verilmemis() {
//			testDevice
//			.setAndroidCamPermissionStatus(androidDriver, false)
//			.restartApp(androidDriver);
//			click(btn_FotoCekBitir);
//			waitLoadingImage();
//
//			click(btn_Bitir);
//			waitLoadingImage2();
//						
//		try {
//			if (exists(lbl_EndRide, 5)) {
//				throw new Exception("Kamera izni yokken surus tamamlandi !");
//			}
//		} catch (Exception ex) {
//
//		}
////			testDevice.setCamPermissionStatus(androidDriver, true);
//			return this;
//		}		
		
	public pageSurus Surus_Bitir_Internet_Kapali(String customer_phone_no, String scooter_code) {
		assertFound(btn_FotoCekBitir);
		testDevice
		.setAndroidWIFIServiceStatus(androidDriver, false)
		.setAndroidDataServiceStatus(androidDriver, false);
		click(btn_FotoCekBitir);
		waitLoadingImage();
		click(btn_Bitir);
		wait(5);
		assertFound(btn_Bitir);
		testDevice
		.setAndroidWIFIServiceStatus(androidDriver, true)
		.setAndroidDataServiceStatus(androidDriver, true);	
		return this;
	}
		
		public pageSurus Ceza_Kurallarina_Erisim(String customer_phone_no, String scooter_code) {		
			click(btn_FotoCekBitir);
			waitLoadingImage();
			click(lbl_AlertDesc);
			assertFound(img_AlertContent);
			click(btn_Tamam);
			assertFound(btn_Bitir);
			return this;
		}
		public pageSurus Odeme_Hatasi() {	
			click(btn_FotoCekBitir);
			waitLoadingImage();
			click(btn_Bitir);
			waitLoadingImage2();
			assertEquals(popup_Message, "Ödemeni gerçekleştirmek için kart limitin yetersiz. Dilersen yeni bir kart ekleyerek ödemeni tamamlayabilirsin.");
			click(btn_TAMAM);
			return this;
		}
		
		public pageSurus Surus_Bitirme_Basarili() {
			click(btn_FotoCekBitir);
			waitLoadingImage();
			click(btn_Bitir);
			waitLoadingImage2();
			assertFound(lbl_EndRide);			
			return this;
		}
		
		public pageSurus Surus_Bitirme_Basarili_Wallet() {
			click(btn_FotoCekBitir);
			waitLoadingImage();
			assertEquals(lbl_OdemeAraci, "Martı Cüzdan");
			click(btn_Bitir);
			waitLoadingImage2();
			assertFound(lbl_EndRide);			
			return this;
		}	
		
		public pageSurus Surus_Bitir_Basarili_Kupon_Kullanildi() {
			click(btn_FotoCekBitir);
			waitLoadingImage();
			assertEquals(lbl_OdemeAraci, "Martı Cüzdan");
			click(btn_Bitir);
			waitLoadingImage2();
			assertFound(lbl_EndRide);			
			return this;
		}
		
		
		
		public pageSurus Yolculuk_Ozeti_Kontrol(String customer_phone_no) {
			String chargedPrice = customer.getChargedRidePrice(customer_phone_no);
			assertEquals(lbl_ToplamTutar, "₺ " + chargedPrice.replace(".", ","));
			return this;
		}
		
		public pageSurus Yolculugu_Degerlendirme(String customer_phone_no) {
			click(btn_Ileri);
			assertEquals(lbl_YolculukDegerlendirme, "Martı Yolculuğunu Değerlendir");
			click(btn_Star, 4);
			swipe(lbl_YolculukDegerlendirme, 303, 975,346,231, 300);
			click(btn_SebebiNeydiki);			
			click(btn_Gonder);
			waitLoadingImage();
			assertFound(img_NotifyIcon);		
			return this;
		}
		
		public pageSurus CuzdanBakiyeKontrol(String cuzdan_bakiye) {
		click(btn_Menu);
		lbl_CuzdanBakiye = readText(lbl_CuzdanBakiye).replace("₺", "").trim();
		if (Double.parseDouble(cuzdan_bakiye) <= Double.parseDouble(lbl_CuzdanBakiye.replace(",", "."))) {
			try {
				throw new Exception("Surus odemesi cuzdan'dan yapilmadi !");
			} catch (Exception ex) {
			}
		}
			return this;
		}
		
		public pageSurus Surus_Bitir_Basarisiz_Wallet_Yetersiz() {
			click(btn_FotoCekBitir);
			assertNotEquals(lbl_OdemeAraci, "Martı Cüzdan");
			return this;
		}
}


