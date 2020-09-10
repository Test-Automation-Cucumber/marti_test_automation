package pages.device.ios;

import dbmodel.Provider;
import dbmodel.DataPreparation.TestDevice;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import utilities.PageBaseIos;

public class pageGirisEkrani extends PageBaseIos {
	IOSDriver<IOSElement> iosDriver;
	TestDevice testDevice;
	
	// *********Constructor*********
		public pageGirisEkrani(IOSDriver<IOSElement> iosDriver) {
			super(iosDriver);
			this.iosDriver = iosDriver;
			testDevice = new TestDevice();
		}

		// *****************************************Web Elements***********************************
		String txt_UIATextField												= ".UIATextField";
		String btn_Menu 													= "#menu";
		String lbl_Ayarlar 													= "$AYARLAR"; 
		String li_CikisYap 													= "$ÇIKIŞ YAP";
		String btn_Evet 													= "$Evet";
		String lbl_LoginPageAssert											= "#Telefonunu doğrulamak için sana bir SMS kodu göndereceğiz.";	
		String btn_ChangeEnv												= "#Ortamı Değiştir";
		String lbl_Env														= "#Geliştirme";
		String btn_OkudumAnladim											= "#OKUDUM, ANLADIM";
		String btn_Basla													= "#BAŞLA";
		String popup_GecersizTelefonNo										= "#Girmiş olduğun telefon numarası geçersiz. Kontrol edip tekrar denemelisin";
		String popup_SmsKodunuHataliGirdin									= "#SMS kodunu hatalı girdin, tekrar deneyebilir misin?";
		String btn_Bitir													= "#Bitir";
		String txt_otp														= ".UIAView";
		String btn_Ileri													= "#İleri";
		String chb_SozlesmeOnay												= "#unchecked";
		
		

		private String ProgressBar 											= "#progressBar"; //PROGRESS BAR  *com.martitech.marti.dev:id/progressBar   (com.martitech.marti.dev paket adı bu. kamera iznine koydun bunu çıkarmayi. ordan kopya cek)
		private	String txt_PhoneNumber										= ".UIATextField";

		private	String lbl_TlfDogrula										= "#Telefonunu Doğrula";
		private	String img_NotifyIcon										= "#notificationIcon";
		private	String btn_Tamam											= "#Tamam";
		private	String btn_Geri												= "#Geri";
		private	String btn_TekrarGonder										= "#Tekrar Gönder";
		private	String txt_KullaniciSozlesmesi								= "#termsText";
		private	String lbl_KullanimKosullari								= "#appTitle";
		private	String txt_PhonePrefix										= "#phonePrefix";
		private	String cmb_CountryName										= "#countryName";
		private String btn_FotoCekBitir										= "#FOTO ÇEK & BİTİR";
		
		// *********Page Methods*********
		
		public pageGirisEkrani Logout() {
			click(btn_Menu);
			swipe(lbl_Ayarlar, 303, 975,346,231, 300);
			click(li_CikisYap);
			click(btn_Evet);
			assertFound(lbl_LoginPageAssert);
			return this;
		}
		
		//giris yap
	public pageGirisEkrani Login(String customer_phone_number) {
		if (exists(img_NotifyIcon, 3))
			return this;

		else if (exists(btn_FotoCekBitir, 1)) {
			testDevice.resetLoginStatus(customer_phone_number);
			click(btn_FotoCekBitir);
			click(btn_Tamam);
		}
			writeText(txt_UIATextField, customer_phone_number);
			wait(1);
			click(btn_ChangeEnv);
			wait(1);
			click(lbl_Env, 1);

			click(chb_SozlesmeOnay);

			click(btn_Ileri);
			Provider provider = new Provider();
			String otp = null;
			try {
				otp = provider.ExecuteScalar(
						"select sms_code from customers where mobile_phone = '" + customer_phone_number + "';",
						"martiDB");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//		 if (!exists(btn_DevamEt, 15))
//			 click(btn_Ileri);

			char[] ot_password = otp.toCharArray();

			writeTextWithoutElement(String.valueOf(ot_password[0]));
			wait(1);
			writeTextWithoutElement(String.valueOf(ot_password[1]));
			wait(1);
			writeTextWithoutElement(String.valueOf(ot_password[2]));
			wait(1);
			writeTextWithoutElement(String.valueOf(ot_password[3]));
			wait(1);
			click(btn_Ileri);

//			patlarsa bunu patlayan methoda ekle.
//			if (exists(btn_OkudumAnladim, 5)) {
//				click(btn_OkudumAnladim);
//			}

		
		return this;
	}
		
		//giris yap
		public pageGirisEkrani Giris_Basarili(String customer_phone_number) {
		if (!exists(btn_ChangeEnv, 5)) {
			testDevice.resetLoginStatus(customer_phone_number);
			if (exists(img_NotifyIcon, 1)) {
				click(img_NotifyIcon);
			} else {
				click(btn_FotoCekBitir);
			}
		}
			
			writeText(txt_UIATextField, customer_phone_number);
			wait(1);
			click(btn_ChangeEnv);
			wait(1);
			click(lbl_Env, 1);	
			
			click(chb_SozlesmeOnay);

			click(btn_Ileri);
			Provider provider = new Provider();
			String otp = null;
			try {
				otp = provider.ExecuteScalar("select sms_code from customers where mobile_phone = '" + customer_phone_number + "';", "martiDB");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//		 if (!exists(btn_DevamEt, 15))
//			 click(btn_Ileri);
			
			char[] ot_password = otp.toCharArray();
			
			writeTextWithoutElement(String.valueOf(ot_password[0]));
			wait(1);
			writeTextWithoutElement(String.valueOf(ot_password[1]));
			wait(1);
			writeTextWithoutElement(String.valueOf(ot_password[2]));
			wait(1);
			writeTextWithoutElement(String.valueOf(ot_password[3]));
			wait(1);
			click(btn_Ileri);
		
//			patlarsa bunu patlayan methoda ekle.
//			if (exists(btn_OkudumAnladim, 5)) {
//				click(btn_OkudumAnladim);
//			}
			return this;
		}

		public pageGirisEkrani Giris_Basarisiz(String customer_phone_number) {
			
			//login durumdami kontrol eder, login ise logoff olur.
			if (exists(img_NotifyIcon, 3)) {
				testDevice
				.resetLoginStatus(customer_phone_number);
				click(img_NotifyIcon);
			}
			
			click(btn_Ileri);
			assertFound(popup_GecersizTelefonNo);
			click(btn_Tamam);
			return this;
		}
		
		public pageGirisEkrani Dogrulama_Basarisiz(String customer_phone_number) {
			//login durumdami kontrol eder, login ise logoff olur.
			if (exists(img_NotifyIcon, 3)) {
				testDevice
				.resetLoginStatus(customer_phone_number);
				click(img_NotifyIcon);
			}			
			
			writeText(txt_PhoneNumber, customer_phone_number);
			click(chb_SozlesmeOnay);
			click(btn_Ileri);
			assertFound(lbl_TlfDogrula);
				
			writeTextWithoutElement(String.valueOf(0));
			wait(1);
			writeTextWithoutElement(String.valueOf(0));
			wait(1);
			writeTextWithoutElement(String.valueOf(0));
			wait(1);
			writeTextWithoutElement(String.valueOf(0));
			wait(1);
			click(btn_Ileri);
			assertEquals(popup_SmsKodunuHataliGirdin, "SMS kodunu hatalı girdin, tekrar deneyebilir misin?");  // TEXTLER DAHA SONRA DB'DEN GELECEK. SIMDILIK BURDAN GIRIYORUZ..
			click(btn_Tamam);
			click(btn_Geri);
			return this;
		}
		
		
		public pageGirisEkrani Tekrar_Kod_Gonder(String customer_phone_number) {
			//login durumdami kontrol eder, login ise logoff olur.
			if (exists(img_NotifyIcon, 3)) {
				testDevice
				.resetLoginStatus(customer_phone_number);
				click(img_NotifyIcon);
			}	                                                                        
			
			writeText(txt_PhoneNumber, customer_phone_number);
			click(chb_SozlesmeOnay);
			click(btn_Ileri);
			assertFound(lbl_TlfDogrula);
			
			Provider provider = new Provider();
			String otp1 = null;
			String otp2 = null;
			try {
				otp1 = provider.ExecuteScalar("select sms_code from customers where mobile_phone = '" + customer_phone_number + "';",
						"martiDB");
			} catch (Exception e) {
				e.printStackTrace();
			}
			click(btn_Bitir);
			click(btn_TekrarGonder);
			wait(5);
			try {
				otp2 = provider.ExecuteScalar("select sms_code from customers where mobile_phone = '" + customer_phone_number + "';",
						"martiDB");
			} catch (Exception e) {
				e.printStackTrace();
			}
			assertNotContent(otp1, otp2);	//tekrar gonder dendikten sonra gelen otp ile ilk gelen otp yi karsilastirir.	
			click(txt_otp,1);
			
			char[] ot_password = otp2.toCharArray();
			writeTextWithoutElement(String.valueOf(ot_password[0]));
			wait(1);
			writeTextWithoutElement(String.valueOf(ot_password[1]));
			wait(1);
			writeTextWithoutElement(String.valueOf(ot_password[2]));
			wait(1);
			writeTextWithoutElement(String.valueOf(ot_password[3]));
			wait(1);
			click(btn_Ileri);
			if (exists(btn_OkudumAnladim, 5)) {
				click(btn_OkudumAnladim);
			}
			
			assertFound(img_NotifyIcon);
			return this;
		}
		
		public pageGirisEkrani Kullanici_Sozlesmesi(String customer_phone_number) {
			//login durumdami kontrol eder, login ise logoff olur.
			if (exists(img_NotifyIcon, 3)) {
				testDevice
				.resetLoginStatus(customer_phone_number);
				click(img_NotifyIcon);
			}	 
			
			click(txt_KullaniciSozlesmesi);
			assertFound(lbl_KullanimKosullari);
			click(btn_Geri);
			return this;
		}
		
	public pageGirisEkrani Ulke_Kodu_Degistirme() {
		click(txt_PhonePrefix);
		click(cmb_CountryName, 1);
//		assertNotEquals(txt_PhonePrefix, "+90");
		return this;
	}
}