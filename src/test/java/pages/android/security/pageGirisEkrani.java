package pages.android.security;

import dbmodel.Provider;
import dbmodel.DataPreparation.Customer;
import dbmodel.DataPreparation.Scooter;
import dbmodel.DataPreparation.TestDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.PageBaseAndroid;

public class pageGirisEkrani extends PageBaseAndroid {
	AndroidDriver<AndroidElement> androidDriver;
	Customer customer;
	Scooter scooter;
	TestDevice testDevice;
	
	// *********Constructor*********
		public pageGirisEkrani(AndroidDriver<AndroidElement> androidDriver) {
			super(androidDriver);
			this.androidDriver = androidDriver;
			customer = new Customer();
			scooter = new Scooter();
			testDevice = new TestDevice();
		}

		// *****************************************Web Elements***********************************
		
		// *****************General
		private	String popup_Message												= "#android:id/message";
		private String txt_PhoneNumber												= "#phoneNumber"; 
		private String btn_GirisYap													= "#com.martitech.security.dev:id/btnLogin";
		private String btn_Tamam													= "#android:id/button1";
		private String txt_Otp														= "#verifyCodeField";
		private String btn_DevamEt													= "#btnNext";
		private String btn_TekrarGonder												= "#btnResend";
		private String img_MartiLogo												= "#appLogo";
		
		
		//spinLoader  dursun burda
		
		// *********Page Methods*********
	
		public void skipOneSignalId() {
		for (int i = 0; i < 5; i++) {
			if (!exists(popup_Message, 1)) {
				return;
			}
			if (readText(popup_Message).equals("One Signal id boş.")) {
				click(btn_Tamam);
				click(btn_GirisYap);
			}
			else
				break;
		}
	}
		public pageGirisEkrani Giris_Basarisiz_Baglanti_Yok() {
			testDevice
			.setWIFIServiceStatus(androidDriver, false)
			.setDataServiceStatus(androidDriver, false);
			
			
			testDevice
			.setWIFIServiceStatus(androidDriver, true)
			.setDataServiceStatus(androidDriver, true);
			return this;
		}		
		public pageGirisEkrani Giris_Basarisiz_Telefon_No_Yok() {
			testDevice
			.setWIFIServiceStatus(androidDriver, true)
			.setDataServiceStatus(androidDriver, true);
			
			click(btn_GirisYap);
			skipOneSignalId();
			assertEquals(popup_Message, "Telefon numarası geçersiz.");
			click(btn_Tamam);
			
			return this;
		}		
		public pageGirisEkrani Giris_Basarisiz_Telefon_No_Eksik() {
			writeText(txt_PhoneNumber, "530111");
			click(btn_GirisYap);
			skipOneSignalId();
			assertEquals(popup_Message, "Telefon numarası geçersiz.");
			click(btn_Tamam);
			
			return this;
		}		
		public pageGirisEkrani Giris_Basarisiz_Hatali_Kullanici() {
			writeText(txt_PhoneNumber, "5301110076");
			wait(5);
			click(btn_GirisYap);
			skipOneSignalId();
			assertEquals(popup_Message, "Kullanıcı bulunamadı, telefonunu doğru girdiğine emin ol.");
			click(btn_Tamam);
			
			return this;
		}		
		public pageGirisEkrani Giris_Basarisiz_Yanlis_Rol() {
			writeText(txt_PhoneNumber, "5307778899");
			click(btn_GirisYap);
			skipOneSignalId();
			assertEquals(popup_Message, "Rolün geçersiz, bir hata olduğunu düşünüyorsan Vardiya Amiri’ne bildir.");
			click(btn_Tamam);
			
			return this;
		}		
		public pageGirisEkrani Giris_Basarili(String phone_number) {
			writeText(txt_PhoneNumber, phone_number);
			click(btn_GirisYap);
			skipOneSignalId();
			assertFound(txt_Otp);
			return this;
		}		
		public pageGirisEkrani Hatali_Otp(String phone_number) {
			writeText(txt_Otp, "0000");
			click(btn_DevamEt);
			assertEquals(popup_Message, "Doğrulama kodunu hatalı girdin.");
			click(btn_Tamam);
			return this;
		}
		public pageGirisEkrani Eksik_Otp(String phone_number) {
			writeText(txt_Otp, "000");
			click(btn_DevamEt);
			assertEquals(popup_Message, "Doğrulama kodunu hatalı girdin.");
			click(btn_Tamam);
			return this;
		}
		public pageGirisEkrani Bos_Otp(String phone_number) {
			click(btn_DevamEt);
			assertEquals(popup_Message, "SMS kodunu girin.");
			click(btn_Tamam);
			return this;
		}
		public pageGirisEkrani Tekrar_Otp_Gonder(String phone_number) {
			Provider provider = new Provider();
			String otp1 = null;
			String otp2 = null;
			try {
				otp1 = provider.ExecuteScalar("select otp_token from users where mobile_phone = '90" + phone_number + "';",
						"martiDB");
			} catch (Exception e) {
				e.printStackTrace();
			}
			click(btn_TekrarGonder);
			wait(5);
			try {
				otp2 = provider.ExecuteScalar("select otp_token from users where mobile_phone = '90" + phone_number + "';",
						"martiDB");
			} catch (Exception e) {
				e.printStackTrace();
			}
			assertNotContent(otp1, otp2);	//tekrar gonder dendikten sonra gelen otp ile ilk gelen otp yi karsilastirir.	
			
			writeText(txt_Otp, otp2);
			click(btn_DevamEt);
			
			assertFound(img_MartiLogo);
			return this;
		}
		public pageGirisEkrani Otp_Dogrulama_Basarili(String phone_number) {
			Provider provider = new Provider();
			String otp1 = null;
			otp1 = provider.ExecuteScalar("select otp_token from users where mobile_phone = '90" + phone_number + "';",
						"martiDB");
			writeText(txt_Otp, otp1);
			click(btn_DevamEt);
			assertFound(img_MartiLogo);
			return this;
		}
		
		
}