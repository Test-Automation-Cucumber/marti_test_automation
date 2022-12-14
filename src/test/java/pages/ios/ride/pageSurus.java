package pages.ios.ride;

import dbmodel.DataPreparation.*;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import utilities.PageBaseIos;

public class pageSurus extends PageBaseIos {
	IOSDriver<IOSElement> iosDriver;
	pageGirisEkrani giris_Ekrani;	
	Customer customer;
	Scooter scooter;
	TestDevice testDevice;
	
	// *********Constructor*********
		public pageSurus(IOSDriver<IOSElement> androidDriver) {
			super(androidDriver);
			this.iosDriver = androidDriver;
			testDevice = new TestDevice();
			customer = new Customer();
			scooter = new Scooter();
			giris_Ekrani = new pageGirisEkrani(this.iosDriver);
		}

		// *****************************************Web Elements***********************************
		String img_KilidiAc													= "#Kilidi Aç";	
		String img_RideLockCode												= "#1234";	
		String btn_Basla													= "#BAŞLA";
		String btn_WriteCode												= "#qrtext";
		String btn_OkudumAnladim											= "#OKUDUM, ANLADIM";
		String btn_Light													= "#qr light";	
		String btn_KrediKartiEkle											= "#Kredi Kartı Ekle";	
		String txt_Kod														= "#KOD";
		String btn_Baslat													= "#Tamam";
		String txt_CVCNumber												= "#CVC";
		String popup_LutfenMartininYakininaGidin							= "#Lütfen MARTI'nın yakınına git.";
		String popup_BulundugunBolgedeDahaCok								= "#Bulunduğun bölgede daha çok MARTI görmek ister misin?🛴🤔";
		String btn_DahaCokMarti												= "#notfound";
		String btn_BizeUlasin												= "#Bize Ulaşın";
		String btn_KilitProblemi											= "#Kilit Problemi";
		String popup_BosAlanlariDoldurmalisin								= "#Boş alanları doldurmalısın.";	
		String txt_KonumTarifi												= "#Konum Tarifi";	
		String list_Notify													= "#Bildirimler";
		String btn_Geri														= "#Geri";
		String btn_Ileri													= "#İleri";
		String btn_Bize_Ulasin												= "#Bize Ulaşın";
		String popup_TeknikEkibinSanaUlasmasiniIstermisin					= "#Teknik ekibin sana ulaşmasını ister misin?";
		String lbl_QrCodeOkut												= "#QR KODU OKUT";
		String btn_HowIt													= "#?";
		String lbl_SurusBasladi												= "#SÜRÜŞ BAŞLADI";
		String btn_Navigate													= "#locationAsset";
		String btn_FotoCekBitir												= "#FOTO ÇEK & BİTİR";
		String btn_Bitir													= "#BİTİR";
		String btn_Tamam													= "#Tamam";
		String popup_MartiyiBirakmakIstediginYer							= "#MARTI'yı bırakmak istediğin yer yasaklı park alanıdır. Haritada kırmızı olarak gösterilen alanlara park edemezsin.";
		String popup_MartiyiDogruKitlemediginden							= "#MARTI’yı doğru kilitlemediğin için sürüşünü bitiremiyoruz. Lütfen kilidi kontrol edip tekrar dene.";
		String popup_BirHataOlustu											= "#Bir hata oluştu";
		String lbl_AlertDesc												= "#İ";
		String btn_X														= "#close";
		String popup_OdemeniGerceklestirmekIcin								= "#Ödemeni gerçekleştirmek için kart limitin yetersiz. Dilersen yeni bir kart ekleyerek ödemeni tamamlayabilirsin.";
		String btn_Gonder													= "#Gönder";
		String ProgressBar 													= "#progressBar";
		String lbl_NasilKullanilir											= "#textView14";
		String popup_Message												= "#android:id/message";
		String img_LockCode													= "#lockCodeText";
		String lbl_EndRide													= "#endRide";
		String btn_TAMAM													= "#android:id/button1";
		String img_AlertContent												= "#photoRules_tr";
		String btn_Star														= "#unstarredAsset";
		String lbl_YolculukDegerlendirme									= "#Martı Yolculuğunu Değerlendir";
		String btn_SebebiNeydiki											= "#Mobil Uygulama";
		String img_NotifyIcon												= "#notificationIcon";	
		String img_ScooterCode												= "#C049";	
		String btn_Menu														= "#menu";
		String lblb_OdemeYontemi											= "#cardHolder";	
		
		
		
		
		// *********Page Methods*********
		public pageSurus Surus_Basladi_Kodlu_Kilit(String customer_phone_no, String scooter_code) {
			assertEquals(img_ScooterCode, scooter_code);
			String batteryLevel	= scooter.getBatteryLevel(scooter_code);
			assertFound("#% " + batteryLevel);
			assertFound(img_KilidiAc);
			return this;
		}	
		
		public pageSurus Surus_Basladi_IOT_Kilit(String customer_phone_no, String scooter_code) {
			assertFound(img_RideLockCode);
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
			waitLoadingImage();
			click(btn_WriteCode);
			writeText(txt_Kod, scooter_code);
			click(btn_Baslat);
			waitLoadingImage();
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
//			while (exists(lbl_NasilKullanilir, 5)) {
//				click(btn_Ileri);
//				waitMilliSec(750);
//			}
			click(btn_Bize_Ulasin);
			assertEquals(popup_TeknikEkibinSanaUlasmasiniIstermisin, "Teknik ekibin sana ulaşmasını ister misin?");

			return this;
		}
		public pageSurus Nasil_Surulur(String customer_phone_no, String scooter_code) {
			click(btn_HowIt);
			assertFound(lbl_QrCodeOkut);	
			return this;
		}
		public pageSurus Ortalama(String customer_phone_no, String scooter_code) {
			assertFound(btn_HowIt);
			swipe(btn_HowIt, 316, 624, 316, 701, 172);
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
			assertFound(btn_Bitir);
			click(btn_Bitir);
			waitLoadingImage();
			assertFound(btn_Tamam);				
			return this;
		}
		public pageSurus Park_Edilemez_Alan(String customer_phone_no, String scooter_code) {	
			assertFound(btn_HowIt);
			click(btn_FotoCekBitir);
			waitLoadingImage();			
			scooter
			.setLastKnowPointToScooter(scooter_code, "sxk9k3xm1");  // bu fence'i park yasakli alan olarak isaretledin
			wait(3);
			click(btn_Bitir);
			waitLoadingImage();
			assertEquals(popup_MartiyiBirakmakIstediginYer, "MARTI'yı bırakmak istediğin yer yasaklı park alanıdır. Haritada kırmızı olarak gösterilen alanlara park edemezsin.");
			click(btn_Tamam);			
			scooter
			.setLastKnowPointToScooter(scooter_code, "sxk9m8gz8");  // ofis fence						
			return this;
		}	
		
		public pageSurus Kilit_Takilmadi(String customer_phone_no, String scooter_code) {		
			scooter
			.setLastKnowPointToScooter(scooter_code, "sxk9m8gz8")  // ofis fence
			.unlockScooter(scooter_code);			
			click(btn_FotoCekBitir);
			waitLoadingImage();
			click(btn_Bitir);
			waitLoadingImage();
			assertEquals(popup_MartiyiDogruKitlemediginden, "MARTI’yı doğru kilitlemediğin için sürüşünü bitiremiyoruz. Lütfen kilidi kontrol edip tekrar dene.");
			click(btn_Tamam);					
			return this;
		}
		
//		public pageSurus Kamera_Izni_Verilmemis() {
//			String appPackageName=androidDriver.getCurrentPackage();
//			testDevice.setCamPermissionStatus(androidDriver, false);
//			androidDriver.closeApp();
//			androidDriver.activateApp(appPackageName);
//			
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
//			testDevice.setCamPermissionStatus(androidDriver, true);
//			return this;
//		}
		
		
		public pageSurus Surus_Bitir_Basarisiz_Wallet_Yetersiz() {
//			click(btn_FotoCekBitir);
//			assertNotEquals(readText(lblb_OdemeYontemi), "Martı Cüzdan");
			return this;
		}
		
		
	public pageSurus Surus_Bitir_Internet_Kapali(String customer_phone_no, String scooter_code) {
		while (exists(lbl_NasilKullanilir, 5)) {
			click(btn_Ileri);
			waitMilliSec(750);
		}		
		assertFound(btn_FotoCekBitir);		
		testDevice
//		.setAirPlaneServiceStatus(iosDriver, true)
		.setIOSWIFIServiceStatus(iosDriver, false);		
		click(btn_FotoCekBitir);
		waitLoadingImage();
		click(btn_Bitir);
		assertFound(popup_BirHataOlustu);	
//		testDevice.setAirPlaneServiceStatus(iosDriver, false);
		testDevice
		.setIOSWIFIServiceStatus(iosDriver, true);		
		return this;
	}
		
		public pageSurus Ceza_Kurallarina_Erisim(String customer_phone_no, String scooter_code) {					
			click(btn_FotoCekBitir);
			waitLoadingImage();
			click(lbl_AlertDesc);
			assertFound(img_AlertContent);
			click(btn_X);
			assertFound(btn_Bitir);				
			return this;
		}
		public pageSurus Odeme_Hatasi(String customer_phone_no, String scooter_code) {				
			click(btn_FotoCekBitir);
			waitLoadingImage();
			click(btn_Bitir);
			waitLoadingImage();
			assertEquals(popup_OdemeniGerceklestirmekIcin, "Ödemeni gerçekleştirmek için kart limitin yetersiz. Dilersen yeni bir kart ekleyerek ödemeni tamamlayabilirsin.");
			click(btn_Tamam);		
			return this;
		}
		public pageSurus Surus_Bitirme_Basarili() {
			click(btn_FotoCekBitir);
			waitLoadingImage();
			click(btn_Bitir);
			waitLoadingImage();
			return this;
		}	
		public pageSurus Surus_Bitirme_Basarili_Wallet() {
			click(btn_FotoCekBitir);
			waitLoadingImage();
			assertFound("$Martı Cüzdan");
			click(btn_Bitir);
			waitLoadingImage();
			return this;
		}		
		public pageSurus Yolculuk_Ozeti_Kontrol(String customer_phone_no, String scooter_code) {
			String chargedPrice = customer.getChargedRidePrice(customer_phone_no);
			assertFound("₺" + chargedPrice.replace(".", ","));
			return this;
		}	
		public pageSurus Yolculugu_Degerlendirme() {
			click(btn_Tamam);
			assertEquals(lbl_YolculukDegerlendirme, "Martı Yolculuğunu Değerlendir");
			click(btn_Star, 2);
			swipe(lbl_YolculukDegerlendirme, 303, 975,346,231, 300);
			click(btn_SebebiNeydiki);		
			click(btn_Gonder);
			waitLoadingImage();
			assertFound(img_NotifyIcon);					
			return this;
		}
		public pageSurus CuzdanBakiyeKontrol(String cuzdan_bakiye) {
			click(btn_Menu);
			assertNotFound("#₺ 20,0");
			return this;
		}
}


