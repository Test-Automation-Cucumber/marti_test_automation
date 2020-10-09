package pages.ios.healthchecker;


import dbmodel.Provider;
import dbmodel.DataPreparation.*;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pages.ios.healthchecker.pageGirisEkrani;
import utilities.PageBaseIos;

public class pageGirisEkrani extends PageBaseIos {
	IOSDriver<IOSElement> iosDriver;
	TestDevice testDevice;
	Customer customer;
	Scooter scooter;
	User user;
	
	// *********Constructor*********
		public pageGirisEkrani(IOSDriver<IOSElement> iosDriver) {
			super(iosDriver);
			this.iosDriver = iosDriver;
			testDevice = new TestDevice();
			customer = new Customer();
			scooter = new Scooter();
			user = new User();
		}

		// *****************************************Web Elements***********************************
		// *****************General
		private	String popup_Message												= "#android:id/message";
		private String btn_GirisYap													= "#Giriş Yap";
		private String btn_Tamam													= "#android:id/button1";
		private String txt_Otp														= "#verifyCodeField";
		private String btn_DevamEt													= "#btnNext";
		private String btn_TekrarGonder												= "#btnResend";
		private String img_MartiLogo												= "#appLogo";
		private	String btn_AracTeslimAl												= "#btnTakeCar";
	////
		private String btn_Logout													= "#mLogoutAsset";
		private String popup_Onayla													= "#Onayla";
		private String lbl_Env														= "#Geliştirme";   //popup 1. indexte
		private String btn_ChangeEnv												= "#Ortam değiştir";
		private String txt_PhoneNumber												= ".UIATextField";
		
		// *********Page Methods*********	
		
		public pageGirisEkrani returnLoginScreen() {
			if(exists(btn_Logout, 1))
			{
				click(btn_Logout);
				click(popup_Onayla);
			}

//				bunlar login caseinde olacak
//				click(btn_ChangeEnv);
//				click(lbl_Env, 1);

			
			return this;
		}
		public pageGirisEkrani Giris_Basarisiz_Telefon_No_Yok() {
			returnLoginScreen();
			
			writeText(txt_PhoneNumber, "", 1);
			click(btn_GirisYap);
			assertEquals(popup_Message, "Telefon numarası geçersiz.");
			click(btn_Tamam);
			
			return this;
		}		
		public pageGirisEkrani Giris_Basarisiz_Telefon_No_Eksik() {
			writeText(txt_PhoneNumber, "530111");
			click(btn_GirisYap);
			assertEquals(popup_Message, "Telefon numarası geçersiz.");
			click(btn_Tamam);
			
			return this;
		}		
		public pageGirisEkrani Giris_Basarisiz_Hatali_Kullanici() {
			writeText(txt_PhoneNumber, "5301110076");
			wait(5);
			click(btn_GirisYap);
			assertEquals(popup_Message, "Kullanıcı bulunamadı, telefonunu doğru girdiğine emin ol.");
			click(btn_Tamam);
			return this;
		}		
		public pageGirisEkrani Giris_Basarisiz_Yanlis_Rol() {
			writeText(txt_PhoneNumber, "5307778899");
			click(btn_GirisYap);
			assertEquals(popup_Message, "Rolün geçersiz, bir hata olduğunu düşünüyorsan Vardiya Amiri’ne bildir.");
			click(btn_Tamam);
			return this;
		}		
		public pageGirisEkrani Giris_Basarili(String phone_number) {
			writeText(txt_PhoneNumber, phone_number);
			click(btn_GirisYap);
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
			return this;
		}
		public pageGirisEkrani Tanimlanmamis_Vardiya(String userPhoneNumber) {
			click(btn_AracTeslimAl);
			assertEquals(popup_Message, "Vardiyan henüz başlamadı, vardiyanda bir hata olduğunu düşünüyorsan Vardiya Amiri’ne bildir.");
			click(btn_Tamam);
			assertFound(txt_PhoneNumber);
			return this;
		}
		public pageGirisEkrani Tanimlanmamis_Vardiyali_Giris(String userPhoneNumber) {
			assertFound(img_MartiLogo);
			return this;
		}
}