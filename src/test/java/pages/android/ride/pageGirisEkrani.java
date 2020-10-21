package pages.android.ride;

import dbmodel.Provider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.PageBaseAndroid;

public class pageGirisEkrani extends PageBaseAndroid {
	AndroidDriver<AndroidElement> androidDriver;
	
	// *********Constructor*********
		public pageGirisEkrani(AndroidDriver<AndroidElement> androidDriver) {
			super(androidDriver);
			this.androidDriver = androidDriver;
		}

		// *****************************************Web Elements***********************************
		
		// *****************General
		String ProgressBar 													= "#progressBar"; //PROGRESS BAR  *com.martitech.marti.dev:id/progressBar   (com.martitech.marti.dev paket adı bu. kamera iznine koydun bunu çıkarmayi. ordan kopya cek)
		private	String txt_PhoneNumber										= "#phoneNumber";
		private	String btn_Ileri											= "#btnNext";
		private	String lbl_TlfDogrula										= "#textView4";
		private	String otp_1												= "#p1";
		private	String otp_2												= "#p2";
		private	String otp_3												= "#p3";	
		private	String otp_4												= "#p4";
		private	String img_NotifyIcon										= "#imageView25";
		private	String popup_Message										= "#android:id/message";
		private	String btn_Tamam											= "#android:id/button1";
		private	String btn_Geri												= "#backText";
		private	String btn_TekrarGonder										= "#btnResend";
		private	String txt_KullaniciSozlesmesi								= "#termsText";
		private	String lbl_KullanimKosullari								= "#appTitle";
		private	String txt_PhonePrefix										= "#phonePrefix";
		private	String cmb_CountryName										= "#countryName";
		private String check_KullaniciSozlesmesi							= "#userAgreementConfirm";
		private String img_Logo												= "#appLogo";
		private String lbl_KullaniciSozlesmesiAydinlatmaMetni				= "#userAgreementConfirmText";
		private String chb_KullaniciSozlesmesiAydinlatmaMetni				= "#userAgreementConfirm";
		private String chb_AcikRizaMetni									= "#explicitConsentTextConfirm";
		private String lbl_KullaniciSozlesmesi								= "$KULLANICI SÖZLEŞMESİ";
		private String btn_OkudumOnayliyorum								= "#btnReadTerms";
		private String lbl_AydinlatmaMetniTitle								= "$Kişisel Verilerinizin İşlenme Amacı";
		private String btn_Okudum											= "#btnReadKvvk";
		private String lbl_AcikRizaMetniTitle								= "$KİŞİSEL VERİLERİN KORUNMASI VE İŞLENMESİNE İLİŞKİN AÇIK RIZA METNİ";
		private String btn_OkudumOnayliyorumAcikRizaMetni					= "#btnAccept";
		
		
		
		// *********Page Methods*********
	public pageGirisEkrani Login(String phone_number) {
		if (System.getProperty("startLogin").equals("no")) {
			if (exists(img_Logo, 5)) {
				return this;
			} else {
				Giris_Basarili(phone_number);
			}
		} else if (System.getProperty("startLogin").equals("yes")) {
			Giris_Basarili(phone_number);
		}
		return this;
	}
		
		public pageGirisEkrani Giris_Basarili(String phone_number) {
		
		androidDriver.resetApp();
		writeText(txt_PhoneNumber, phone_number);
		
		if(!getCheckedValue(check_KullaniciSozlesmesi, "checked"))
			click(check_KullaniciSozlesmesi);
		
		click(btn_Ileri);
		assertFound(lbl_TlfDogrula);
		Provider provider = new Provider();
		String otp = null;
		try {
			otp = provider.ExecuteScalar("select sms_code from customers where mobile_phone = '" + phone_number + "';",
					"martiDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
		char[] ot_password = otp.toCharArray();
		writeText(otp_1, String.valueOf(ot_password[0]));
		writeText(otp_2, String.valueOf(ot_password[1]));
		writeText(otp_3, String.valueOf(ot_password[2]));
		writeText(otp_4, String.valueOf(ot_password[3]));
		click(btn_Ileri);
		waitLoadingImage();
		return this;
	}
		
		public pageGirisEkrani Giris_Basarisiz() {
			androidDriver.resetApp();
			click(btn_Ileri);
			assertEquals(popup_Message, "Lütfen telefon numaranı gir.");
			click(btn_Tamam);
			return this;
		}
		
		public pageGirisEkrani Dogrulama_Basarisiz(String phone_number) {
			writeText(txt_PhoneNumber, phone_number);
			if(!getCheckedValue(check_KullaniciSozlesmesi, "checked"))
				click(check_KullaniciSozlesmesi);
			click(btn_Ileri);
			assertFound(lbl_TlfDogrula);
			writeText(otp_1, "0");
			writeText(otp_2, "0");
			writeText(otp_3, "0");
			writeText(otp_4, "0");
			click(btn_Ileri);
			assertEquals(popup_Message, "SMS kodu hatalı");  // TEXTLER DAHA SONRA DB'DEN GELECEK. SIMDILIK BURDAN GIRIYORUZ..
			click(btn_Tamam);
			click(btn_Geri);
			return this;
		}
		
		public pageGirisEkrani Tekrar_Kod_Gonder(String phone_number) {
			
			androidDriver.resetApp();
			writeText(txt_PhoneNumber, phone_number);
			if(!getCheckedValue(check_KullaniciSozlesmesi, "checked"))
				click(check_KullaniciSozlesmesi);
			click(btn_Ileri);
			assertFound(lbl_TlfDogrula);
			
			Provider provider = new Provider();
			String otp1 = null;
			String otp2 = null;
			try {
				otp1 = provider.ExecuteScalar("select sms_code from customers where mobile_phone = '" + phone_number + "';",
						"martiDB");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			for (int i = 0; i < 6; i++) {
				wait(10);
				click(btn_Ileri);
				click(btn_Tamam);
			}
			click(btn_TekrarGonder);
			wait(5);
			
			try {
				otp2 = provider.ExecuteScalar("select sms_code from customers where mobile_phone = '" + phone_number + "';",
						"martiDB");
			} catch (Exception e) {
				e.printStackTrace();
			}
			assertNotContent(otp1, otp2);	//tekrar gonder dendikten sonra gelen otp ile ilk gelen otp yi karsilastirir.	
			
			char[] ot_password = otp2.toCharArray();
			writeText(otp_1, String.valueOf(ot_password[0]));
			writeText(otp_2, String.valueOf(ot_password[1]));
			writeText(otp_3, String.valueOf(ot_password[2]));
			writeText(otp_4, String.valueOf(ot_password[3]));
			click(btn_Ileri);
			//burda patlarsa nasil gelir ekle
			assertFound(img_NotifyIcon);
			return this;
		}
		
		public pageGirisEkrani Kullanici_Sozlesmesi() {
			clickToCoordinateOfElement(chb_KullaniciSozlesmesiAydinlatmaMetni, 80, -60);  // kullanıcı sözlesmesi
			assertFound(lbl_KullaniciSozlesmesi);
			click(btn_Geri);
			clickToCoordinateOfElement(chb_KullaniciSozlesmesiAydinlatmaMetni, 80, -60);  // kullanıcı sözlesmesi
			click(btn_OkudumOnayliyorum);
			try {
			if (!getCheckedValue(chb_KullaniciSozlesmesiAydinlatmaMetni, "checked")) {
				throw new Exception();
			}
			} catch (Exception ex) {
			}
			try {
				if (!getCheckedValue(chb_AcikRizaMetni, "unchecked")) {
					throw new Exception();
				}
			} catch (Exception ex) {
			}
			
			return this;
		}
		
		public pageGirisEkrani Aydinlatma_Metni() {
			clickToCoordinateOfElement(chb_KullaniciSozlesmesiAydinlatmaMetni, 80, 0);  // aydınlatma metni
			assertFound(lbl_AydinlatmaMetniTitle);
			click(btn_Geri);
			clickToCoordinateOfElement(chb_KullaniciSozlesmesiAydinlatmaMetni, 80, 0);  // aydınlatma metni
			click(btn_Okudum);
			try {
				if (!getCheckedValue(chb_KullaniciSozlesmesiAydinlatmaMetni, "checked")) {
					throw new Exception();
				}
			} catch (Exception ex) {
			}
			try {
				if (!getCheckedValue(chb_AcikRizaMetni, "unchecked")) {
					throw new Exception();
				}
			} catch (Exception ex) {
			}
			return this;
		}
		
		public pageGirisEkrani Acik_Riza_Metni() {
			//Açık Rıza Metni Başlıyor.
			clickToCoordinateOfElement(chb_AcikRizaMetni, 80, 0);  // açık rıza metni
			assertFound(lbl_AcikRizaMetniTitle);
			click(btn_Geri);
			clickToCoordinateOfElement(chb_AcikRizaMetni, 80, 0);  // açık rıza metni
			click(btn_OkudumOnayliyorumAcikRizaMetni);
			try {
				if (!getCheckedValue(chb_AcikRizaMetni, "checked")) {
					throw new Exception();
				}
			} catch (Exception ex) {
			}
			try {
				if (!getCheckedValue(chb_KullaniciSozlesmesiAydinlatmaMetni, "unchecked")) {
					throw new Exception();
				}
			} catch (Exception ex) {
			}

			return this;
		}
		
	public pageGirisEkrani Ulke_Kodu_Degistirme() {
		click(txt_PhonePrefix);
		click(cmb_CountryName, 1);
		assertNotEquals(txt_PhonePrefix, "+90");
		return this;
	}
}