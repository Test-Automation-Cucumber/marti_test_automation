package pages.android;

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
		private String btn_NasilKullanilirIleri								= "#btnOk";
		private String check_KullaniciSozlesmesi							= "#userAgreementConfirm";
		
		
		
		// *********Page Methods*********
		public pageGirisEkrani Giris_Basarili(String phone_number) {
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
			click(txt_KullaniciSozlesmesi);
			assertFound(lbl_KullanimKosullari);
			click(btn_Geri);
			return this;
		}
		
	public pageGirisEkrani Ulke_Kodu_Degistirme() {
		click(txt_PhonePrefix);
		click(cmb_CountryName, 1);
		assertNotEquals(txt_PhonePrefix, "+90");
		return this;
	}
}