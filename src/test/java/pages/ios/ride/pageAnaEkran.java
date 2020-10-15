package pages.ios.ride;


import dbmodel.DataPreparation.*;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import utilities.PageBaseIos;

public class pageAnaEkran extends PageBaseIos {
	IOSDriver<IOSElement> iosDriver;
	TestDevice testDevice;
	pageGirisEkrani giris_Ekrani;	
	Customer customer;
	Scooter scooter;
	
	// *********Constructor*********
		public pageAnaEkran(IOSDriver<IOSElement> iosDriver) {
 			super(iosDriver);
			this.iosDriver = iosDriver;
			testDevice = new TestDevice();
			customer = new Customer();
			scooter = new Scooter();
			giris_Ekrani = new pageGirisEkrani(this.iosDriver);
			
		}
		
		// *****************************************Web Elements***********************************
		String btn_OkudumAnladim											= "#OKUDUM, ANLADIM";
		String btn_Basla													= "#BAŞLA";
		String btn_Light													= "#qr light";	
		String img_NotifyIcon												= "#notificationIcon";
		String btn_KrediKartiEkle											= "#Kredi Kartı Ekle";	
		String btn_WriteCode												= "#qrtext";	
		String txt_CVCNumber												= "#CVC";
		String txt_Kod														= "#KOD";
		String btn_Baslat													= "#Tamam";
		String popup_LutfenMartininYakininaGidin							= "#Lütfen MARTI'nın yakınına git.";
		String popup_BulundugunBolgedeDahaCok								= "#Bulunduğun bölgede daha çok MARTI görmek ister misin?🛴🤔";
		String btn_DahaCokMarti												= "#notfound";
		String btn_BizeUlasin												= "#Bize Ulaşın";
		String btn_KilitProblemi											= "#Kilit Problemi";
		String btn_Gonder													= "#Gönder";	
		String popup_BosAlanlariDoldurmalisin								= "#Boş alanları doldurmalısın.";	
		String txt_KonumTarifi												= "#Konum Tarifi";	
		String list_Notify													= "#Bildirimler";
		String btn_Geri														= "#Geri";
		String ProgressBar 													= "#progressBar";
		String btn_TAMAM													= "#Tamam";	
		String btn_Ileri													= "#İleri";	
		String popup_Tamam													= "#android:id/button2";	
		String popup_BorcOde												= "#android:id/button1";	
		String popup_IzinVer												= "#com.android.packageinstaller:id/permission_allow_button";	
		String lbl_DescriptionText											= "#descriptionText";	
		String popup_Message												= "#android:id/message";	
		String txt_SeriNo													= "#MARTI Kodu";
		String txt_SorunDetay												= "#Sorunun detaylarını yaz";
		String btn_ParkImage												= "#cameraAsset";
		String btn_TakeFoto													= "#buttonCapture";	
		String btn_HasarliSorunluMarti										= "#damageScooter";	
		String chb_SarjiBitmis												= "#outOfBattery";	
		String chb_FrenCalismiyor											= "#brakeNotWork";	
		String chb_GazCalismiyor											= "#gasNotWork";	
		String chb_MartiHasarAlmis											= "#damageScooter";	
		String chb_QrCodeOkunmuyor											= "#qrNotWork";	
		String btn_YanlisPark												= "#wrongParking";	
		String btn_AcilDurumPaylas											= "#otherIssue";	
		String popup_Campaign												= "#Burada senin için indirimimiz var!";	
		
		
		
		// *********Page Methods*********
		public pageAnaEkran Surus_Baslat(String customer_phone_no) {
			assertFound(btn_Basla);
			wait(4);
			click(btn_Basla);
			waitLoadingImage();
			assertFound(btn_Light);
			return this;
		}	
		public pageAnaEkran Tckn_Gecersiz(String phone_number) {
			giris_Ekrani
			.Login(phone_number);
			assertFound(btn_Basla);
			wait(4);
			click(btn_Basla);
			waitLoadingImage();
			click(btn_TAMAM);
			assertFound(btn_Ileri);
			customer.addTcknAndKvkkValidation(phone_number);
			return this;
		}	
		public pageAnaEkran Odeme_Yontemi_Yok(String customer_phone_no) {
			assertFound(btn_Basla);
			wait(4);
			click(btn_Basla);
			waitLoadingImage();
			click(btn_KrediKartiEkle);
			assertFound(txt_CVCNumber);
			return this;
		}	
		public pageAnaEkran Surus_Baslatma_Kamera_Izni_Verilmemis(String customer_phone_no) {	
			customer
				.addTcknAndKvkkValidation(customer_phone_no)
				.deleteCreditCards(customer_phone_no)
				.addCreditCard(customer_phone_no);
				customer.deleteCustomerDebt(customer_phone_no);
			giris_Ekrani
			.Giris_Basarili(customer_phone_no);			
			assertFound(btn_Basla);
			wait(4);
			click(btn_Basla);
			waitLoadingImage();
			assertFound(popup_IzinVer);
			click(popup_IzinVer);
			return this;
		}		
		
		public pageAnaEkran Surus_Baslatma_Kod_Girisi(String customer_phone_no) {
			assertFound(btn_Basla);
			wait(4);
			click(btn_Basla);
			waitLoadingImage();
			click(btn_WriteCode);
			assertFound(txt_Kod);
			return this;
		}
		public pageAnaEkran Surus_Baslat_Basarili(String customer_phone_no, String scooter_code) {
			assertFound(btn_Basla);
			wait(4);
			click(btn_Basla);
			waitLoadingImage();
			click(btn_WriteCode);
			writeText(txt_Kod, scooter_code);
			return this;
		}
		public pageAnaEkran Surus_Baslat_Basarisiz_Martiya_Uzak(String customer_phone_no, String scooter_code) {
			assertFound(btn_Basla);
			wait(4);
			click(btn_Basla);
			waitLoadingImage();
			click(btn_WriteCode);
			writeText(txt_Kod, scooter_code);
			click(btn_Baslat);
			wait(6);
			assertEquals(popup_LutfenMartininYakininaGidin, "Lütfen MARTI'nın yakınına git.");
			click(btn_TAMAM);
			return this;
		}
		public pageAnaEkran Daha_Cok_Marti(String customer_phone_no) {
			assertFound(btn_Basla);
			click(btn_DahaCokMarti);
			assertEquals(popup_BulundugunBolgedeDahaCok, "Bulunduğun bölgede daha çok MARTI görmek ister misin?\\u1F6F4\\u1F914");
			return this;
		}
		
		public pageAnaEkran Bize_Ulasin_Kilit_Problemi_Bildirme(String customer_phone_no) {
			customer
			.deleteCustomerIssues(customer_phone_no);
			giris_Ekrani
			.Giris_Basarili(customer_phone_no);
			assertFound(img_NotifyIcon);
			click(btn_BizeUlasin);
			click(btn_KilitProblemi);
			click(btn_Gonder);
			assertEquals(popup_BosAlanlariDoldurmalisin, "Boş alanları doldurmalısın.");
			click(btn_TAMAM);
			writeText(txt_SeriNo, "AUT1");
			click(btn_Gonder);
			waitLoadingImage();
			assertEquals(popup_BosAlanlariDoldurmalisin, "Boş alanları doldurmalısın.");
			click(btn_TAMAM);			
			writeText(txt_SorunDetay, "test otomasyon");
			click(btn_TAMAM);			
			click(btn_ParkImage);
			click(btn_TakeFoto);
			waitLoadingImage();
			writeText(txt_KonumTarifi, "hq zone");
			click(btn_TAMAM);			
			click(btn_Gonder);
			waitLoadingImage();
			assertEquals(popup_BosAlanlariDoldurmalisin, "Sorun bildirimin başarıyla gönderildi.");
			click(btn_TAMAM);
			assertFound(img_NotifyIcon);		
			int count = customer.countCustomerIssue(customer_phone_no);
			assertEquals(count, 1);			
			return this;
		}
		
		public pageAnaEkran Bize_Ulasin_Hasarli_Sorunlu_Marti_Bildirme(String customer_phone_no) {
			customer
			.deleteCustomerIssues(customer_phone_no);		
			giris_Ekrani
			.Giris_Basarili(customer_phone_no);
			assertFound(img_NotifyIcon);			
			click(btn_BizeUlasin);
			click(btn_HasarliSorunluMarti);
			click(btn_Gonder);
			waitLoadingImage();
			assertEquals(popup_Message, "Lütfen boş alanları doldurun");
			click(btn_TAMAM);			
			writeText(txt_SeriNo, "AUT1");
			click(btn_Gonder);
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
			click(btn_Gonder);
			waitLoadingImage();
			assertEquals(popup_Message, "Sorun bildirimin başarıyla gönderildi.");
			click(btn_TAMAM);
			assertFound(img_NotifyIcon);			
			int count = customer.countCustomerIssue(customer_phone_no);
			assertEquals(count, 1);			
			return this;
		}
		
		public pageAnaEkran Bize_Ulasin_Yanlis_Park(String customer_phone_no) {
			customer
			.deleteCustomerIssues(customer_phone_no);			
			giris_Ekrani
			.Giris_Basarili(customer_phone_no);
			assertFound(img_NotifyIcon);			
			click(btn_BizeUlasin);
			click(btn_YanlisPark);
			click(btn_Gonder);
			waitLoadingImage();
			assertEquals(popup_Message, "Lütfen boş alanları doldurun");
			click(btn_TAMAM);		
			writeText(txt_SeriNo, "AUT1");
			click(btn_Gonder);
			waitLoadingImage();
			assertEquals(popup_Message, "Lütfen boş alanları doldurun");
			click(btn_TAMAM);		
			writeText(txt_SorunDetay, "test otomasyon");			
			click(btn_ParkImage);
			click(btn_TakeFoto);
			waitLoadingImage();			
			click(btn_Gonder);
			waitLoadingImage();
			assertEquals(popup_Message, "Sorun bildirimin başarıyla gönderildi.");
			click(btn_TAMAM);
			assertFound(img_NotifyIcon);			
			int count = customer.countCustomerIssue(customer_phone_no);
			assertEquals(count, 1);			
			return this;
		}
		
		public pageAnaEkran Bize_Ulasin_Acil_Durum_Paylas(String customer_phone_no) {
			customer
			.deleteCustomerIssues(customer_phone_no);			
			giris_Ekrani
			.Giris_Basarili(customer_phone_no);			
			assertFound(img_NotifyIcon);
			click(btn_BizeUlasin);
			click(btn_AcilDurumPaylas);
			click(btn_Gonder);
			waitLoadingImage();
			assertEquals(popup_Message, "Lütfen boş alanları doldurun");
			click(btn_TAMAM);	
			writeText(txt_SorunDetay, "test otomasyon");			
			click(btn_Gonder);
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
			assertNotFound(popup_Campaign);
			return this;
		}
		
		public pageAnaEkran Dinamik_Popup_Goster_Popup_Var(String customer_phone_no) {
			assertFound(popup_Campaign);
			return this;
		}
}


