package pages.android.ride;


import dbmodel.DataPreparation.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.PageBaseAndroid;

public class pageMenu extends PageBaseAndroid {
	AndroidDriver<AndroidElement> androidDriver;
	Customer customer;
	Scooter scooter;
	TestDevice testDevice;
	
	// *********Constructor*********
		public pageMenu(AndroidDriver<AndroidElement> androidDriver) {
			super(androidDriver);
			this.androidDriver = androidDriver;
//			testDevice = new TestDevice();
			customer = new Customer();
			scooter = new Scooter();
//			giris_Ekrani = new pageGirisEkrani(this.androidDriver);
			
		}
		// *****************************************Web Elements***********************************
		// *****************General
		String btn_Geri														= "#backText";	
		String btn_Menu														= "#btnMenu";	
		String lbl_Version													= "#versionText";	
		String img_NotifyIcon												= "#imageView25";
		String btn_Edit														= "#btnEdit";
		String txt_PhoneNumber												= "#phoneNumber";
		String btn_Kaydet													= "#btnSave";
		String popup_Message												= "#android:id/message";
		String popup_TAMAM													= "#android:id/button1";
		String popup_HAYIR													= "#android:id/button2";
		String li_ArkadasiniDavetEt											= "#inviteFriend";
		String btn_ArkadasiniDavetEt										= "#btnInviteFriend";
		String popup_PanoyaKopyala											= "#android:id/copy_button";  //
		String li_Suruslerim												= "#rideHistory";
		String lbl_SuruslerimContent										= "#noDataText";
		String li_SurusDetay												= "#map";
		String btn_FaturaGoruntule											= "#showInvoice";
		String btn_Odeme													= "#payment";
		String chb_ErrorCreditCard											= "$HATALI KART";
		String chb_CreditCard												= "$AUTO AUTOMATION";
		String lbl_KrediKartlariContent										= "#com.martitech.marti.dev:id/noDataText";
		String btn_KrediKartiEkle											= "#com.martitech.marti.dev:id/btnPayDebt";
		String txt_KartUzerindekiIsim										= "#name";
		String txt_KartNumarasi												= "#cardNumber";
		String txt_AyYil													= "#expiryDate";
		String txt_CVC														= "#cvc";
		String txt_18Yas													= "#cbTerms";
		String lbl_NasilKullanilir											= "#textView14";
		String btn_Ileri													= "#btnOk";
		String li_DilDegistir												= "#changeLanguage";
		String chb_Language													= "#langIcon";
		String btn_Basla													= "#btnScan";
		String li_Yardim													= "#help";
		String lbl_Title													= "#appTitle";
		String li_KullaniciSozlesmesi										= "#termsService";
		String li_AydinlatmaMetni											= "#kvvkk";
		String li_Guvenlik													= "#safety";
		String li_NasilKullanilir											= "#howtoride";
		String li_SurusKurallari											= "#rideRules";
		String btn_X														= "#btnClose";
		String li_CikisYap													= "#logout";
		String li_Kampanyalar												= "#campaings";
		String btn_KuponlarimGoruntule										= "#btnShowCoupons";
		String lbl_KuponBulunamadi											= "#title";
		String btn_KuponEkle												= "#btnAddCoupon";
		String txt_KuponKoduGir												= "#couponCode";
		String txt_CouponContent											= "#amontText";
		String lbl_MerhabaFullName											= "#fullName";
		String chb_KrediKarti												= "#com.martitech.marti.dev:id/selectIcon";  //com.martitech.marti.dev:id/selected
		String img_GiftBox													= "#giftBox";
		String li_Sozlesmeler												= "#agreementTitle";
		String txt_MartiNedir												= "$Mart?? Nedir?";
		String lbl_KullaniciAdi												= "#fullName";
		
		
		// *********Page Methods*********

		public pageMenu Versiyon_Kontrol(String phone_number, String version_text) {
			click(btn_Menu);		
			assertEquals(lbl_KullaniciAdi, "Merhaba " + customer.getCustomerName(phone_number));
			assertEquals(lbl_Version, version_text);
			return this;
		}	
		
		public pageMenu Profil_Duzenleme(String customer_phone_number) {
			click(btn_Menu);
			click(btn_Edit);
			assertEquals(txt_PhoneNumber, customer_phone_number);
			click(btn_Kaydet);
			waitLoadingImage();
			assertEquals(popup_Message, "Profil g??ncellendi.");
			click(popup_TAMAM);
			assertFound(btn_Edit);
			return this;
		}
		public pageMenu Arkadasini_Davet_Et(String customer_phone_number) {			
			assertFound(img_NotifyIcon);
			click(btn_Menu);
			click(li_ArkadasiniDavetEt);
			return this;
		}
		public pageMenu Kampanyalar_Arkadasini_Davet_Et(String customer_phone_number) {
			assertFound(img_NotifyIcon);
			click(btn_Menu);
			click(li_Kampanyalar);
			click(btn_ArkadasiniDavetEt);
			click(btn_ArkadasiniDavetEt);
			wait(2);
			click(popup_PanoyaKopyala);
			int count = customer.countCreatorCoupon(customer_phone_number);
			assertEquals(count, 1);
			click(btn_Geri);		
			click(btn_Geri);
			click(btn_X);
			return this;
		}
		public pageMenu Davet_Baglantisi_Gonderme(String customer_phone_number) {		
			assertFound(img_GiftBox);
			click(btn_ArkadasiniDavetEt);
			wait(2);
//			swipe(lbl_Title, 303, 975,346,231, 300);
			click(popup_PanoyaKopyala);
			click(btn_Geri);
			int count = customer.countCreatorCoupon(customer_phone_number);
			assertEquals(count, 1);
			
			return this;
		}
				
		public pageMenu Surusleri_Inceleme(String customer_phone_number) {
			click(btn_Menu);
			click(li_Suruslerim);
			assertEquals(lbl_SuruslerimContent, "Hen??z hi?? MARTI s??r??????n yok, ilk MARTI yolculu??una ????kman??n tam zaman??!");
			click(btn_Geri);
			return this;
		}
		
		public pageMenu SurusDetayiInceleme(String customer_phone_number, String scooter_code, String scooter_location) {
			customer
			.addCustomerFinishedRide(customer_phone_number, scooter_code);
			click(li_Suruslerim);
			click(li_SurusDetay);
			assertFound(btn_FaturaGoruntule);
			return this;
		}	
		
		public pageMenu Varsayilan_Kredi_Karti_Degistirme(String customer_phone_number) {
			click(btn_Menu);
			click(btn_Odeme);
			click(chb_KrediKarti, 1);
			wait(1);
			click(chb_KrediKarti, 0);		 
			return this;
		}
		
		public pageMenu Kredi_Karti_Ekleme_Basarili(String customer_phone_number) {
			click(btn_Menu);
			click(btn_Odeme);
			assertFound(lbl_KrediKartlariContent);
			click(btn_KrediKartiEkle);		
			writeText(txt_KartUzerindekiIsim, "test otomasyon");
			writeText(txt_KartNumarasi, "5890040000000016");	
			writeText(txt_AyYil, "12/21");		
			writeText(txt_CVC, "234");			
			click(txt_18Yas);
			click(btn_Kaydet);
			waitLoadingImage();
		    assertEquals(getSize(chb_KrediKarti, 0), 1);		
			return this;
		}
		
		public pageMenu Kredi_Karti_Ekleme_Basarisiz(String customer_phone_number) {
			click(btn_Menu);
			click(btn_Odeme);		
			assertFound(lbl_KrediKartlariContent);
			click(btn_KrediKartiEkle);		
			writeText(txt_KartUzerindekiIsim, "test");
			writeText(txt_KartNumarasi, "5890040000006");	
			writeText(txt_AyYil, "12/2");		
			writeText(txt_CVC, "23");			
			click(txt_18Yas);
			click(btn_Kaydet);		
			assertEquals(popup_Message, "L??tfen kredi kart?? bilgilerini kontrol et.");
			click(popup_TAMAM);
			return this;
		}	
		
		public pageMenu Dil_Degistirme(String customer_phone_number) {
			click(btn_Menu);
			click(li_DilDegistir);
			click(chb_Language, 1);
			click(btn_Kaydet);
			assertEquals(btn_Basla, "START");
			click(btn_Menu);
			click(li_DilDegistir);
			click(chb_Language, 0);
			click(btn_Kaydet);
			assertEquals(btn_Basla, "BA??LA");
			return this;
		}
		
		public pageMenu Yardim_Dokumanina_Erisim(String customer_phone_number) {
			click(btn_Menu);
			assertFound(lbl_Title);
			swipe(lbl_Title, 303, 975,346,231, 300);
			click(li_Yardim);
			assertEquals(lbl_Title, "Yard??m");
			assertFound(txt_MartiNedir);
			click(btn_Geri);
			assertFound(li_Yardim);
			return this;
		}
		
		public pageMenu Kullanici_Sozlesmesine_Erisim(String customer_phone_number) {
			click(btn_Menu);
			assertFound(lbl_Title);
			click(li_Sozlesmeler);
			swipe(lbl_Title, 303, 975,346,231, 300);
			click(li_KullaniciSozlesmesi);
			assertEquals(lbl_Title, "Kullan??c?? S??zle??mesi");
			click(btn_Geri);
			assertFound(li_KullaniciSozlesmesi);
			return this;
		}
		
		public pageMenu Kvkk_Aydinlatma_Metnine_Erisim(String customer_phone_number) {
			click(btn_Menu);
			assertFound(lbl_Title);
			click(li_Sozlesmeler);
			swipe(lbl_Title, 303, 975,346,231, 300);
			click(li_AydinlatmaMetni);
			assertEquals(lbl_Title, "Ayd??nlatma Metni");
			click(btn_Geri);
			assertFound(li_AydinlatmaMetni);
			return this;
		}

		public pageMenu Guvenlik_Dokumanina_Erisim(String customer_phone_number) {
			click(btn_Menu);
			click(li_Sozlesmeler);
			swipe(lbl_Title, 303, 975,346,231, 300);
			click(li_Guvenlik);
			assertEquals(lbl_Title, "G??VENL??K");
			click(btn_Geri);
			click(btn_X);
			assertFound(btn_Basla);
			return this;
		}
		
		public pageMenu Surus_Kurallarina_Erisim(String customer_phone_number) {
			click(btn_Menu);
			click(li_SurusKurallari);
			wait(3);
			while (exists(lbl_NasilKullanilir, 5)) {
			click(btn_Ileri);
			waitMilliSec(750);
			}
			click(btn_X);
			assertFound(btn_Basla);
			return this;
		}
		
		public pageMenu Nasil_Kullanilir(String customer_phone_number) {
			click(btn_Menu);
			click(li_NasilKullanilir);
			wait(2);
			while (exists(lbl_NasilKullanilir, 5)) {
			click(btn_Ileri);
			waitMilliSec(750);
			}
			click(btn_X);
			assertFound(btn_Basla);
			return this;
		}
		
		public pageMenu Kampanyalar_Arkadasini_Davet_Etme(String customer_phone_number) {
			click(btn_Menu);
			click(li_Kampanyalar);
			click(btn_ArkadasiniDavetEt);
			waitLoadingImage();
			Davet_Baglantisi_Gonderme(customer_phone_number);
			return this;
		}	
		
		public pageMenu Cikis(String customer_phone_number) {
			click(btn_Menu);
			wait(2);
			swipe(lbl_Title, 303, 975,346,231, 300);
			click(li_CikisYap);
			assertEquals(popup_Message, "Emin Misin?");
			click(popup_HAYIR);
			click(li_CikisYap);
			click(popup_TAMAM);
			assertFound(txt_PhoneNumber);
			return this;
		}
		
		public pageMenu Kupon_Ekleme(String customer_phone_number) {
			String couponCode = "";			
			couponCode = customer
			.deleteCustomerRides(customer_phone_number)
			.getCreatorCoupon(customer_phone_number);
			click(btn_Menu);
			click(li_Kampanyalar);
			click(btn_KuponlarimGoruntule);
			assertEquals(lbl_KuponBulunamadi, "Kupon bulunamad??.");		
			//hatali kupon kodu ekleme
			click(btn_KuponEkle);
			writeText(txt_KuponKoduGir, "00000000");
			waitLoadingImage();
			click(btn_KuponEkle);
			assertEquals(popup_Message, "Girdi??in kupon kodu ge??ersiz.");
			click(popup_TAMAM);			
			//kupon kodu ekleme
			writeText(txt_KuponKoduGir, couponCode);
			click(btn_KuponEkle);
			waitLoadingImage();
			assertEquals(txt_CouponContent, "Sonraki s??r??????nde kullan??lacak ???10,00 indirimin var.");
			click(btn_Geri);
			return this;
		}
		
//		public pageMenu Davet_Kodu_Girme(String customer_phone_number) {
//			String couponCode = "";
//			
//			couponCode = customer
//			.deleteCustomerRides(customer_phone_number)
//			.getCustomerCoupon(customer_phone_number);
//			
//			click(btn_Menu);
//			click(li_Kampanyalar);
//			click(btn_KuponlarimGoruntule);
//			assertEquals(lbl_KuponBulunamadi, "Kupon bulunamad??.");
//		
//			//hatali kupon kodu ekleme
//			click(btn_KuponEkle);
//			writeText(txt_KuponKoduGir, "00000000");
//			waitLoadingImage();
//			click(btn_KuponEkle);
//			assertEquals(popup_Message, "Girdi??in kupon kodu ge??ersiz.");
//			click(popup_TAMAM);
//			
//			//kupon kodu ekleme
//
//			writeText(txt_KuponKoduGir, couponCode);
//			click(btn_KuponEkle);
//			waitLoadingImage();
//			assertEquals(txt_CouponContent, "Sonraki s??r??????nde kullan??lacak ???10,00 indirimin var.");
//			click(btn_Geri);
//
//			return this;
//		}
		
		
		
}


