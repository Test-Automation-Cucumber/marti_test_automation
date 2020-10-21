package pages.android.ride;


import dbmodel.DataPreparation.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.PageBaseAndroid;

public class pageAnaEkran extends PageBaseAndroid {
	AndroidDriver<AndroidElement> androidDriver;
	TestDevice testDevice;
	pageGirisEkrani giris_Ekrani;	
	Customer customer;
	Scooter scooter;
	
	
	// *********Constructor*********
		public pageAnaEkran(AndroidDriver<AndroidElement> androidDriver) {
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
		String img_NotifyIcon												= "#imageView25";	
		String btn_Light													= "#light";	
		String btn_TAMAM													= "#android:id/button1";	
		String btn_Ileri													= "#btnNext";	
		String btn_KrediKartiEkle											= "#btnPayDebt";	
		String txt_KartNumarasi												= "#cardNumber";	
		String popup_Tamam													= "#android:id/button2";	
		String popup_BorcOde												= "#android:id/button1";	
		String popup_IzinVer												= "#com.android.packageinstaller:id/permission_allow_button";	
		String txt_Kod														= "#codeEditText";	
		String btn_WriteCode												= "#writeCode";	
		String lbl_DescriptionText											= "#descriptionText";	
		String popup_Message												= "#android:id/message";	
		String btn_Baslat													= "#btnStart";	
		String btn_DahaCokMarti												= "#btnRequestScooter";	
		String btn_BizeUlasin												= "#issueReport";	
		String btn_KilitProblemi											= "#lockIssue";	
		String btn_Kaydet													= "#btnSave";	
		String txt_SeriNo													= "#seriNo";	
		String txt_SorunDetay												= "#comment";	
		String btn_ParkImage												= "#parkImage";	
		String btn_TakeFoto													= "#fab_take_photo";	
		String list_Notify													= "#notifyList";	
		String btn_Geri														= "#backText";	
		String btn_HasarliSorunluMarti										= "#damageScooter";	
		String chb_SarjiBitmis												= "#outOfBattery";	
		String chb_FrenCalismiyor											= "#brakeNotWork";	
		String chb_GazCalismiyor											= "#gasNotWork";	
		String chb_MartiHasarAlmis											= "#damageScooter";	
		String chb_QrCodeOkunmuyor											= "#qrNotWork";	
		String btn_YanlisPark												= "#wrongParking";	
		String btn_AcilDurumPaylas											= "#otherIssue";	
		String btn_OkudumOnayliyorum  							        	= "#btnAccept";
		
		
		// *********Page Methods*********

		public pageAnaEkran Surus_Baslat(String customer_phone_no) {
			assertFound(btn_Basla);
			wait(4);
			click(btn_Basla);
			waitLoadingImage2();
			assertFound(btn_Light);
			return this;
		}	
		public pageAnaEkran Tckn_Gecersiz(String phone_number) {			
			assertFound(img_NotifyIcon);
			assertFound(btn_Basla);
			wait(4);
			click(btn_Basla);
			waitLoadingImage2();
			click(btn_TAMAM);
			assertFound(btn_Ileri);
			customer
			.addTcknAndKvkkValidation(phone_number);
			return this;
		}	
		
		public pageAnaEkran Odeme_Yontemi_Yok(String customer_phone_no) {
			assertFound(btn_Basla);
			wait(4);
			click(btn_Basla);
			waitLoadingImage2();
			click(btn_KrediKartiEkle);
			assertFound(txt_KartNumarasi);
			return this;
		}	
		
		public pageAnaEkran Surus_Baslatma_Kamera_Izni_Verilmemis(String customer_phone_no) {
				
			customer
				.addTcknAndKvkkValidation(customer_phone_no)
				.deleteCreditCards(customer_phone_no)
				.addCreditCard(customer_phone_no);
				customer.deleteCustomerDebt(customer_phone_no);

			String appPackageName=androidDriver.getCurrentPackage();
			testDevice.setAndroidCamPermissionStatus(androidDriver, false);
			androidDriver.closeApp();
			androidDriver.activateApp(appPackageName);
			
			giris_Ekrani
			.Giris_Basarili(customer_phone_no);
			
			assertFound(btn_Basla);
			wait(4);
			click(btn_Basla);
			waitLoadingImage2();
			assertFound(popup_IzinVer);
			click(popup_IzinVer);
			return this;
		}		
		public pageAnaEkran Surus_Baslatma_Kod_Girisi(String customer_phone_no) {
			assertFound(btn_Basla);
			wait(4);
			click(btn_Basla);
			waitLoadingImage2();
			click(btn_WriteCode);
			assertFound(txt_Kod);
			
			return this;
		}
		public pageAnaEkran Surus_Baslat_Basarili(String customer_phone_no, String scooter_code) {
			giris_Ekrani
			.Giris_Basarili(customer_phone_no);
				
			assertFound(btn_Basla);
			wait(4);
			click(btn_Basla);
			waitLoadingImage2();
			click(btn_WriteCode);
			writeText(txt_Kod, "AUT1");
			assertFound(lbl_DescriptionText);
			return this;
		}
		public pageAnaEkran Surus_Baslat_Basarisiz_Martiya_Uzak(String customer_phone_no, String scooter_code) {
//			String appPackageName=androidDriver.getCurrentPackage();
//			androidDriver.closeApp();
//			androidDriver.activateApp(appPackageName);
			
			assertFound(btn_Basla);
			wait(4);
			click(btn_Basla);
			waitLoadingImage2();
			click(btn_WriteCode);
			writeText(txt_Kod, scooter_code);
			click(btn_Baslat);
			assertEquals(popup_Message, "Lütfen Martı'nın yakınına gidin.");
			click(btn_TAMAM);
			return this;
		}
		
		public pageAnaEkran Daha_Cok_Marti() {
			assertFound(btn_Basla);
			click(btn_DahaCokMarti);
			assertEquals(popup_Message, "Bulunduğun bölgede daha çok MARTI görmek ister misin?");
			return this;
		}
		
		public pageAnaEkran Bize_Ulasin_Kilit_Problemi_Bildirme(String customer_phone_no, String scooter_code) {
			assertFound(img_NotifyIcon);
			click(btn_BizeUlasin);
			click(btn_KilitProblemi);
			click(btn_Kaydet);
			waitLoadingImage();
			assertEquals(popup_Message, "Lütfen boş alanları doldurun");
			click(btn_TAMAM);
			
			writeText(txt_SeriNo, scooter_code);
			click(btn_Kaydet);
			waitLoadingImage();
			assertEquals(popup_Message, "Lütfen boş alanları doldurun");
			click(btn_TAMAM);
			
			writeText(txt_SorunDetay, "test otomasyon");
			
			click(btn_ParkImage);
			click(btn_TakeFoto);
			waitLoadingImage();
			
			click(btn_Kaydet);
			waitLoadingImage();
			assertEquals(popup_Message, "Sorun bildirimin başarıyla gönderildi.");
			click(btn_TAMAM);
			assertFound(img_NotifyIcon);
			
			int count = customer.countCustomerIssue(customer_phone_no);
			assertEquals(count, 1);
			
			return this;
		}
		
		public pageAnaEkran Bize_Ulasin_Hasarli_Sorunlu_Marti_Bildirme(String customer_phone_no, String scooter_code) {
			assertFound(img_NotifyIcon);
			click(btn_BizeUlasin);
			click(btn_HasarliSorunluMarti);
			click(btn_Kaydet);
			waitLoadingImage();
			assertEquals(popup_Message, "Lütfen boş alanları doldurun");
			click(btn_TAMAM);			
			writeText(txt_SeriNo, scooter_code);
			click(btn_Kaydet);
			waitLoadingImage();
			assertEquals(popup_Message, "Lütfen boş alanları doldurun");
			click(btn_TAMAM);		
			click(chb_SarjiBitmis);
			click(chb_FrenCalismiyor);
			click(chb_GazCalismiyor);
			click(chb_MartiHasarAlmis);
			click(chb_QrCodeOkunmuyor);									
			writeText(txt_SorunDetay, "test otomasyon");
			swipe(txt_SorunDetay, 303, 975,346,231, 300);
			click(btn_ParkImage);
			click(btn_TakeFoto);
			waitLoadingImage();			
			click(btn_Kaydet);
			waitLoadingImage();
			assertEquals(popup_Message, "Sorun bildirimin başarıyla gönderildi.");
			click(btn_TAMAM);
			assertFound(img_NotifyIcon);			
			int count = customer.countCustomerIssue(customer_phone_no);
			assertEquals(count, 1);		
			return this;
		}
		
		public pageAnaEkran Bize_Ulasin_Yanlis_Park(String customer_phone_no, String scooter_code) {
			assertFound(img_NotifyIcon);
			click(btn_BizeUlasin);
			click(btn_YanlisPark);
			click(btn_Kaydet);
			waitLoadingImage();
			assertEquals(popup_Message, "Lütfen boş alanları doldurun");
			click(btn_TAMAM);
			
			writeText(txt_SeriNo, scooter_code);
			click(btn_Kaydet);
			waitLoadingImage();
			assertEquals(popup_Message, "Lütfen boş alanları doldurun");
			click(btn_TAMAM);
			
			writeText(txt_SorunDetay, "test otomasyon");
			
			click(btn_ParkImage);
			click(btn_TakeFoto);
			waitLoadingImage();
			
			click(btn_Kaydet);
			waitLoadingImage();
			assertEquals(popup_Message, "Sorun bildirimin başarıyla gönderildi.");
			click(btn_TAMAM);
			assertFound(img_NotifyIcon);
			
			int count = customer.countCustomerIssue(customer_phone_no);
			assertEquals(count, 1);
			
			return this;
		}
		
		public pageAnaEkran Bize_Ulasin_Acil_Durum_Paylas(String customer_phone_no) {
			assertFound(img_NotifyIcon);
			click(btn_BizeUlasin);
			click(btn_AcilDurumPaylas);
			click(btn_Kaydet);
			waitLoadingImage();
			assertEquals(popup_Message, "Lütfen boş alanları doldurun");
			click(btn_TAMAM);	
			writeText(txt_SorunDetay, "test otomasyon");			
			click(btn_Kaydet);
			waitLoadingImage();
			assertEquals(popup_Message, "Acil durum bildirimini aldık, sana en kısa sürede telefonla ulaşacağız.");
			click(btn_TAMAM);
			assertFound(img_NotifyIcon);
			
			int count = customer.countCustomerIssue(customer_phone_no);
			assertEquals(count, 1);
			
			return this;
		}
		
		public pageAnaEkran Bildirimleri_Kontrol_Etme(String customer_phone_no) {
			click(img_NotifyIcon);
			assertFound(list_Notify);
			click(btn_Geri);
			assertFound(img_NotifyIcon);
			return this;
		}	
		
		public pageAnaEkran Dinamik_Popup_Gosterme_Popup_Yok(String customer_phone_no) {
			assertFound(btn_Basla);
			wait(5);
			click(btn_Basla);
			waitLoadingImage2();
			assertFound(btn_WriteCode);
			return this;
		}
		
		public pageAnaEkran Dinamik_Popup_Goster_Popup_Var(String customer_phone_no) {
			assertFound(btn_Basla);
			wait(5);
			click(btn_Basla);
			waitLoadingImage2();
			assertNotFound(btn_WriteCode);
			return this;
		}
		
		public pageAnaEkran Acik_Riza_Metni_Gosterme_Popup_Yok(String customer_phone_no) {
			wait(5);
			assertFound(btn_Basla);
			return this;
		}
		
		public pageAnaEkran Acik_Riza_Metni_Goster_Popup_Var(String customer_phone_no) {
			assertFound(btn_OkudumOnayliyorum);
			return this;
		}
		
}


