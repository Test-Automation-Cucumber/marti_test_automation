package pages.ios.ride;

import dbmodel.Provider;
import dbmodel.DataPreparation.TestDevice;
import io.appium.java_client.AppiumDriver;
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
		String chb_SozlesmeOnayUnChecked									= "#unchecked";
		String chb_SozlesmeOnayChecked										= "#checked";
		String txt_PhoneNumber									        	= ".UIATextField";
		String img_Logo											        	= "#navbar_logo";
		String lbl_TlfDogrula									        	= "#Telefonunu Doğrula";
		String img_NotifyIcon									        	= "#notificationIcon";
		String btn_Tamam										        	= "#Tamam";
		String btn_Geri											        	= "#Geri";
		String btn_TekrarGonder									        	= "#Tekrar Gönder";
		String lbl_KullaniciSozlesmesi							        	= "#Kullanıcı Sözleşmesi’ni";
		String lbl_TitleKullaniciSozlesmesi						        	= "#KULLANICI SÖZLEŞMESİ";
		String txt_PhonePrefix									        	= "#+90";
		String cmb_CountryName									        	= "#Afghanistan";
		String btn_FotoCekBitir									        	= "#FOTO ÇEK & BİTİR";
		String lbl_AydinlatmaMetni								        	= "#Aydınlatma Metni’ni";
		String btn_Okudum										        	= "#OKUDUM";
		String lbl_AcikRizaMetni								        	= "#Açık Rıza Metni'ni okudum ve onaylıyorum.";
		String lbl_KisiselVerilerinKorunmasi					        	= "#KİŞİSEL VERİLERİN KORUNMASI VE İŞLENMESİNE İLİŞKİN AÇIK RIZA METNİ";
		String lbl_AydinlatmaMetniTitle							        	= "#KİŞİSEL VERİLERİN KORUNMASI VE İŞLENMESİNE İLİŞKİN";
		String btn_OkudumOnayliyorum  							        	= "#OKUDUM, ONAYLIYORUM";
		
		
		// *********Page Methods*********
		public pageGirisEkrani Login(String customer_phone_number) {
			if (System.getProperty("startLogin").equals("no")) {
				if (exists(img_Logo, 3)) {
					return this;
				} else {
					Giris_Basarili(customer_phone_number);
				}
			} else if (System.getProperty("startLogin").equals("yes")) {
				Giris_Basarili(customer_phone_number);
			}
			return this;
		}
		
		public pageGirisEkrani Logout() {
			click(btn_Menu);
			swipe(lbl_Ayarlar, 303, 975,346,231, 300);
			click(li_CikisYap);
			click(btn_Evet);
			assertFound(lbl_LoginPageAssert);
			return this;
		}
		
		public pageGirisEkrani Giris_Basarili(String customer_phone_number) {
			testDevice
			.resetCustomerLoginStatus(customer_phone_number)
			.restartApp(iosDriver);
			writeText(txt_UIATextField, customer_phone_number);
			wait(1);
			click(btn_ChangeEnv);
			wait(1);
			click(lbl_Env, 1);	
			click(chb_SozlesmeOnayUnChecked);
			click(btn_Ileri);
			Provider provider = new Provider();
			String otp = null;
			try {
				otp = provider.ExecuteScalar("select sms_code from customers where mobile_phone = '" + customer_phone_number + "';", "martiDB");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			char[] ot_password = otp.toCharArray();
			writeTextWithoutElement(String.valueOf(ot_password[0]));
			wait(1);
			writeTextWithoutElement(String.valueOf(ot_password[1]));
			wait(1);
			writeTextWithoutElement(String.valueOf(ot_password[2]));
			wait(1);
			writeTextWithoutElement(String.valueOf(ot_password[3]));
			return this;
		}

		public pageGirisEkrani Giris_Basarisiz(String customer_phone_number) {
			testDevice
			.resetCustomerLoginStatus(customer_phone_number)
			.restartApp(iosDriver);			
			click(btn_Ileri);
			assertFound(popup_GecersizTelefonNo);
			click(btn_Tamam);
			return this;
		}
		
		public pageGirisEkrani Dogrulama_Basarisiz(String customer_phone_number) {
			testDevice
			.resetCustomerLoginStatus(customer_phone_number)
			.restartApp(iosDriver);
			writeText(txt_PhoneNumber, customer_phone_number);
			click(chb_SozlesmeOnayUnChecked);
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
		testDevice
		.resetCustomerLoginStatus(customer_phone_number)
		.restartApp(iosDriver);                                                         
		writeText(txt_PhoneNumber, customer_phone_number);
		click(chb_SozlesmeOnayUnChecked);
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
		for (int i = 0; i < 6; i++) {
			wait(10);
			click(btn_Ileri);
			click(btn_Tamam);
		}
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
		if(exists(btn_Ileri, 1))
				click(btn_Ileri);		
		if (exists(btn_OkudumAnladim, 5)) {
			click(btn_OkudumAnladim);
		}	
		assertFound(img_NotifyIcon);
		return this;
		}
		
		public pageGirisEkrani Kullanici_Sozlesmesi() {
		click(lbl_KullaniciSozlesmesi);
		assertFound(lbl_TitleKullaniciSozlesmesi);
		click(btn_Geri);
		click(lbl_KullaniciSozlesmesi);
		click(btn_OkudumAnladim);
		try {
			if (getSize(chb_SozlesmeOnayChecked, 1) < 1 && getSize(chb_SozlesmeOnayChecked, 1) > 1) {
				throw new Exception();
			}
		} catch (Exception ex) {
		}
		return this;
		}
		
		
		public pageGirisEkrani Aydinlatma_Metni() {
		click(lbl_AydinlatmaMetni);
		click(btn_Geri);
		click(lbl_AydinlatmaMetni);
		assertFound(lbl_AydinlatmaMetniTitle);
		click(btn_Okudum);
		try {
			if (getSize(chb_SozlesmeOnayChecked, 1) < 1 && getSize(chb_SozlesmeOnayChecked, 1) > 1) {
				throw new Exception();
			}
		} catch (Exception ex) {
		}
		return this;
		}
		
		
		public pageGirisEkrani Acik_Riza_Metni() {
		click(lbl_AcikRizaMetni);
		assertFound(lbl_KisiselVerilerinKorunmasi);
		click(btn_Geri);
		click(lbl_AcikRizaMetni);
		click(btn_OkudumOnayliyorum);
		try {
			if (getSize(chb_SozlesmeOnayChecked, 1) < 1 && getSize(chb_SozlesmeOnayChecked, 1) > 1) {
				throw new Exception();
			}
		} catch (Exception ex) {
		}	
		return this;
		}
		
	public pageGirisEkrani Ulke_Kodu_Degistirme() {
		click(txt_PhonePrefix);
		click(cmb_CountryName);
		assertNotFound(txt_PhonePrefix);

		return this;
	}
}