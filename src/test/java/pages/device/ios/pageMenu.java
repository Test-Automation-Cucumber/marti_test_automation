package pages.device.ios;


import dbmodel.DataPreparation.*;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import utilities.PageBaseIos;

public class pageMenu extends PageBaseIos {
	IOSDriver<IOSElement> iosDriver;
	TestDevice testDevice;
	pageGirisEkrani giris_Ekrani;	
	Customer customer;
	Scooter scooter;
	
	
	// *********Constructor*********
		public pageMenu(IOSDriver<IOSElement> androidDriver) {
			super(androidDriver);
			this.iosDriver = androidDriver;
//			testDevice = new TestDevice();
			customer = new Customer();
			scooter = new Scooter();
			giris_Ekrani = new pageGirisEkrani(this.iosDriver);
			
		}

		// *****************************************Web Elements***********************************
		
		// *****************General
		
		String btn_Geri														= "#Geri";	
		String li_ArkadasiniDavetEt											= "#ARKADAŞINI DAVET ET";
		String btn_ArkadasiniDavetEt										= ".UIAButton";  //sayfada 2. sirada
		String btn_KampanyalarArkadasiniDavetEt								= "#Arkadaşını Davet Et";
		String img_GiftBox													= "#gift2Asset";
		String popup_PanoyaKopyala											= "#Kopyala";
		String li_Suruslerim												= "#SÜRÜŞLERİM";
		String li_DilDegistir												= "#DİL DEĞİŞTİR";
		String li_ChangeLanguage											= "#CHANGE LANGUAGE";
		String li_Odeme														= "#ÖDEME";
		String li_Kampanyalar												= "#KAMPANYALAR";
		String li_NasilSurulur												= "#NASIL SÜRÜLÜR";
		String li_SurusKurallari											= "#SÜRÜŞ KURALLARI";
		String li_KullanimKosullari											= "#KULLANIM KOŞULLARI";
		String li_AydinlatmaMetni											= "#AYDINLATMA METNI";
		String li_Guvenlik													= "#GÜVENLİK";
		String lbl_Guvenlik													= "#Güvenlik";
		String li_Yardim													= "#YARDIM";
		String li_CikisYap													= "#ÇIKIŞ YAP";
		String li_Sozlesmeler												= "#SÖZLEŞMELER";
		String li_SurusDetay												= "#chevronRightAsset";
		String btn_FaturaGoruntule											= "#Fatura Görüntüle";
		String chb_KrediKartiSelected										= "#oval_selected";
		String chb_KrediKartiUnSelected										= "#oval_unselected";
		String lbl_KrediKartlariContent										= "#Herhangi bir ödeme yöntemi eklenmemiş";
		String btn_KrediKartiEkle											= "#Kredi Kartı Ekle";
		String txt_KartUzerindekiIsim										= "*Kartın üzerindeki isim";
		String txt_KartNumarasi												= "*Kart numarası";
		String txt_AyYil													= "*AA/YY";
		String txt_CVC														= "*CVC";
		String btn_Kaydet													= "#Kaydet";
		String btn_Save														= "#Save";
		String popup_Tamam													= "#Tamam";
		String popup_LutfenKrediKarti										= "#Lütfen kredi kartı bilgilerini kontrol et.";
		String chb_English													= "#English";
		String chb_Turkce													= "#Türkçe";
		String btn_Start													= "#START";
		String btn_Basla													= "#BAŞLA";
		String btn_X														= "#close";
		String btn_KuponlarimGoruntule										= "#Kuponlar";
		String btn_KuponEkle												= "#Kupon Ekle";
		String popup_GirdiginKuponKoduGecersiz								= "#Girdiğin kupon kodu geçersiz.";
		String btn_Ileri													= "#İleri";
		String btn_Tamam													= "#Tamam";
		String btn_Evet														= "#Evet";
		String btn_Bitir													= "#Bitir";
		
		
		
		
		String btn_Menu														= "#menu";	
		String lbl_Ayarlar													= "#AYARLAR";	
		String txt_PhoneNumber												= "*Mobil Telefon Numarası";
		String img_NotifyIcon												= "#notificationIcon";
		String lbl_Version													= "#versionText";
		String btn_Duzenle													= "#Düzenle";
		String popup_Eminmisin												= "#Emin Misin?";
		String popup_Hayir													= "#Hayır";
		String chb_ErrorCreditCard											= "$HATALI KART";
		String chb_CreditCard												= "$AUTO AUTOMATION";
		String lbl_NasilKullanilir											= "#textView14";
		String chb_Language													= "#langIcon";
		String lbl_Title													= "#appTitle";
		String li_NasilKullanilir											= "#howtoride";
		String btn_DevamEt													= "#Devam Et";
		String lbl_KisiselVerilerinKorunmasi								= "#Kişisel Verilerin Korunması";
		String lbl_KullaniciSozlesmesi										= "#KULLANICI SÖZLEŞMESİ";
		String lbl_SikcaSorulanSorular										= "#Sıkça Sorulan Sorular";
		
		
		String lbl_KuponBulunamadi											= "#Herhangi bir kupon bulunamadı.";

		String txt_KuponKoduGir												= ".UIATextField";
		String txt_CouponContent											= "#Sonraki sürüşünde kullanılacak 10 ₺ indirimin var.";
		String lbl_MerhabaFullName											= "#fullName";
		String lbl_SurusGecmisiContent										= "#Henüz hiç MARTI sürüşün yok, ilk MARTI yolculuğuna çıkmanın tam zamanı!"; //içerik 1. indexte

		
		// *********Page Methods*********

		public pageMenu Versiyon_Kontrol(String phone_number) {
			giris_Ekrani
			.Giris_Basarili(phone_number);
			
			click(btn_Menu);
			swipe(lbl_Title, 303, 975,346,231, 300);
			assertFound(lbl_Version);
			return this;
		}	
		
		public pageMenu Profil_Duzenleme(String customer_phone_number) {
			giris_Ekrani
			.Giris_Basarili(customer_phone_number);
			
			click(btn_Menu);
			click(btn_Duzenle);
			assertEquals(txt_PhoneNumber, customer_phone_number.substring(0,3) + " " + customer_phone_number.substring(3,6)+ " " + customer_phone_number.substring(6,8)+ " " + customer_phone_number.substring(8,10));
			click(btn_Kaydet);
			waitLoadingImage();
			assertFound(btn_Duzenle);
			return this;
		}
		public pageMenu Arkadasini_Davet_Et(String customer_phone_number) {
			customer
			.deleteCustomerCoupons(customer_phone_number);
			
			giris_Ekrani
			.Login(customer_phone_number);
						
			assertFound(img_NotifyIcon);
			click(btn_Menu);
			click(li_ArkadasiniDavetEt);
			return this;
		}
		public pageMenu Kampanyalar_Arkadasini_Davet_Et(String customer_phone_number) {
			customer
			.deleteCustomerCoupons(customer_phone_number);
			
			giris_Ekrani
			.Login(customer_phone_number);
			
			assertFound(img_NotifyIcon);
			click(btn_Menu);
			click(li_Kampanyalar);
			click(btn_KampanyalarArkadasiniDavetEt);
			wait(3);
			click(btn_ArkadasiniDavetEt, 1);
			wait(2);
			click(popup_PanoyaKopyala);
			int count = customer.countCustomerCoupon(customer_phone_number);
			assertEquals(count, 1);		
			click(btn_Geri);
			click(btn_Geri);
			click(btn_X);
			return this;
		}
		public pageMenu Davet_Baglantisi_Gonderme(String customer_phone_number) {		
			assertFound(img_GiftBox);
			
			click(btn_ArkadasiniDavetEt, 1);
			wait(2);
			click(popup_PanoyaKopyala);
			click(btn_Geri);
			if (exists(btn_X, 5)) {
				click(btn_X);
			}
			int count = customer.countCustomerCoupon(customer_phone_number);
			assertEquals(count, 1);
			
			return this;
		}
		public pageMenu Surusleri_Inceleme(String customer_phone_number) {
			customer
			.deleteCustomerRides(customer_phone_number)
			.deleteCustomerReservations(customer_phone_number);
			
			giris_Ekrani
			.Login(customer_phone_number);
			
			click(btn_Menu);
			click(li_Suruslerim);
			assertFound(lbl_SurusGecmisiContent);
			click(btn_Geri);
			return this;
		}
		public pageMenu SurusDetayiInceleme(String customer_phone_number, String scooter_code) {
			scooter
			.addScooter(scooter_code);
			
			customer
			.addCustomerFinishedRide(customer_phone_number, scooter_code);
		
			click(li_Suruslerim);
			click(li_SurusDetay);
			assertFound(btn_FaturaGoruntule);
			return this;
		}	
		
		public pageMenu Varsayilan_Kredi_Karti_Degistirme(String customer_phone_number) {
			customer
			.deleteCreditCards(customer_phone_number)
			.addCreditCard(customer_phone_number);
			customer.addErrorCreditCard(customer_phone_number);
			
			giris_Ekrani
			.Login(customer_phone_number);
			
			click(btn_Menu);
			click(li_Odeme);
			
			click(chb_KrediKartiUnSelected);
			wait(1);
			click(chb_KrediKartiSelected);
			 
			customer
			.deleteCreditCards(customer_phone_number)
			.addCreditCard(customer_phone_number);
			
			return this;
		}
		
		public pageMenu Kredi_Karti_Ekleme_Basarili(String customer_phone_number) {
			customer
			.deleteCreditCards(customer_phone_number);
			
			giris_Ekrani
			.Login(customer_phone_number);
			
			click(btn_Menu);
			click(li_Odeme);
			
			assertFound(lbl_KrediKartlariContent);
			
			click(btn_KrediKartiEkle);		
			writeText(txt_KartUzerindekiIsim, "test otomasyon");
			writeText(txt_KartNumarasi, "5890040000000016");	
			writeText(txt_AyYil, "12/21");		
			writeText(txt_CVC, "234");			
			click(btn_Kaydet);
			
			customer
			.deleteCreditCards(customer_phone_number)
			.addCreditCard(customer_phone_number);
			
			return this;
		}
		
		public pageMenu Kredi_Karti_Ekleme_Basarisiz(String customer_phone_number) {
			customer
			.deleteCreditCards(customer_phone_number);
			
			giris_Ekrani
			.Login(customer_phone_number);
			
			click(btn_Menu);
			click(li_Odeme);
			
			assertFound(lbl_KrediKartlariContent);
			
			click(btn_KrediKartiEkle);		
			writeText(txt_KartUzerindekiIsim, "test");
			writeText(txt_KartNumarasi, "5890040000006");	
			writeText(txt_AyYil, "12/2");		
			writeText(txt_CVC, "23");	
			click(btn_Kaydet);
			
			assertEquals(popup_LutfenKrediKarti, "Lütfen kredi kartı bilgilerini kontrol et.");
			click(popup_Tamam);
			customer
			.deleteCreditCards(customer_phone_number)
			.addCreditCard(customer_phone_number);
			
			return this;
		}	
		
		public pageMenu Dil_Degistirme(String customer_phone_number) {
			
			giris_Ekrani
			.Login(customer_phone_number);
			
			click(btn_Menu);
			click(li_DilDegistir);
			click(chb_English);
			click(btn_Kaydet);
			assertFound(btn_Start);
			click(btn_Menu);
			click(li_ChangeLanguage);
			click(chb_Turkce);
			click(btn_Save);
			assertEquals(btn_Basla, "BAŞLA");
			return this;
		}
		
		public pageMenu Yardim_Dokumanina_Erisim(String customer_phone_number) {
			giris_Ekrani
			.Login(customer_phone_number);
			
			click(btn_Menu);
			swipe(lbl_Ayarlar, 303, 975,346,231, 1000);
			swipe(lbl_Ayarlar, 303, 975,346,231, 1000);	
			click(li_Yardim);
			assertEquals(lbl_SikcaSorulanSorular, "Sıkça Sorulan Sorular");
			click(btn_Geri);
			assertFound(li_Yardim);
			return this;
		}
		
		public pageMenu Kullanim_Kosullarina_Erisim(String customer_phone_number) {
			giris_Ekrani
			.Login(customer_phone_number);
			
			click(btn_Menu);
			click(li_Sozlesmeler);
			swipe(lbl_Ayarlar, 303, 975,346,231, 1000);
			swipe(lbl_Ayarlar, 303, 975,346,231, 1000);			
			click(li_KullanimKosullari);
			assertEquals(lbl_KullaniciSozlesmesi, "KULLANICI SÖZLEŞMESİ");
			click(btn_Geri);
			assertFound(li_KullanimKosullari);
			return this;
		}
		
		public pageMenu Kvkk_Aydinlatma_Metnine_Erisim(String customer_phone_number) {
			giris_Ekrani
			.Login(customer_phone_number);
			
			click(btn_Menu);
			click(li_Sozlesmeler);
			swipe(lbl_Ayarlar, 303, 975,346,231, 1000);
			swipe(lbl_Ayarlar, 303, 975,346,231, 1000);			
			click(li_AydinlatmaMetni);
			assertEquals(lbl_KisiselVerilerinKorunmasi, "Kişisel Verilerin Korunması");
			click(btn_Geri);
			assertFound(li_AydinlatmaMetni);
			return this;
		}

		public pageMenu Guvenlik_Dokumanina_Erisim(String customer_phone_number) {
			giris_Ekrani
			.Login(customer_phone_number);
			click(btn_Menu);
			click(li_Sozlesmeler);
			swipe(lbl_Ayarlar, 303, 975,346,231, 1000);
			swipe(lbl_Ayarlar, 303, 975,346,231, 1000);
			click(li_Guvenlik);
			assertEquals(lbl_Guvenlik, "Güvenlik");
			click(btn_Geri);
			click(btn_X);
			assertFound(btn_Basla);
			return this;
		}
		
		public pageMenu Surus_Kurallarina_Erisim(String customer_phone_number) {
			giris_Ekrani
			.Login(customer_phone_number);
			
			click(btn_Menu);
			click(li_SurusKurallari);
			wait(3);
			while (exists(btn_DevamEt, 5)) {
			click(btn_DevamEt);
			waitMilliSec(750);
			}
			click(btn_Bitir);
			click(btn_X);
			assertFound(btn_Basla);
			return this;
		}
		
		public pageMenu Nasil_Kullanilir(String customer_phone_number) {
			giris_Ekrani
			.Login(customer_phone_number);
			
			click(btn_Menu);
			click(li_NasilSurulur);
			wait(2);
			while (exists(btn_Ileri, 5)) {
			click(btn_Ileri);
			waitMilliSec(750);
			}
			click(btn_Tamam);
			assertFound(btn_Basla);
			return this;
		}
		
		public pageMenu Kampanyalar_Arkadasini_Davet_Etme(String customer_phone_number) {
			customer
			.deleteCustomerRides(customer_phone_number);
			giris_Ekrani
			.Login(customer_phone_number);
			
			click(btn_Menu);
			click(li_Kampanyalar);
			click(btn_KampanyalarArkadasiniDavetEt);
			waitLoadingImage();
			
			Davet_Baglantisi_Gonderme(customer_phone_number);
			return this;
		}	
		
		public pageMenu Cikis(String customer_phone_number) {
			giris_Ekrani
			.Login(customer_phone_number);
			
			click(btn_Menu);
			wait(2);
			swipe(lbl_Ayarlar, 303, 975,346,231, 1000);
			swipe(lbl_Ayarlar, 303, 975,346,231, 1000);
			click(li_CikisYap);
			assertEquals(popup_Eminmisin, "Emin Misin?");
			click(popup_Hayir);
			click(li_CikisYap);
			click(btn_Evet);
			assertFound(txt_PhoneNumber);
			return this;
		}
		
		public pageMenu Kupon_Ekleme(String customer_phone_number) {
			String couponCode = "";
			
			couponCode = customer
			.deleteCustomerRides(customer_phone_number)
			.getCustomerCoupon(customer_phone_number);

			click(btn_Menu);
			click(li_Kampanyalar);
			click(btn_KuponlarimGoruntule);
			assertFound(lbl_KuponBulunamadi);
		
			//hatali kupon kodu ekleme
			click(btn_KuponEkle);
			writeText(txt_KuponKoduGir, "00000000");
			waitLoadingImage();
			click(btn_KuponEkle);
			assertEquals(popup_GirdiginKuponKoduGecersiz, "Girdiğin kupon kodu geçersiz.");
			click(popup_Tamam);
			
			//kupon kodu ekleme

			writeText(txt_KuponKoduGir, couponCode);
			click(btn_KuponEkle);
			waitLoadingImage();
			assertEquals(txt_CouponContent, "Sonraki sürüşünde kullanılacak 10 ₺ indirimin var.");
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
//			assertEquals(lbl_KuponBulunamadi, "Kupon bulunamadı.");
//		
//			//hatali kupon kodu ekleme
//			click(btn_KuponEkle);
//			writeText(txt_KuponKoduGir, "00000000");
//			waitLoadingImage();
//			click(btn_KuponEkle);
//			assertEquals(popup_Message, "Girdiğin kupon kodu geçersiz.");
//			click(popup_TAMAM);
//			
//			//kupon kodu ekleme
//
//			writeText(txt_KuponKoduGir, couponCode);
//			click(btn_KuponEkle);
//			waitLoadingImage();
//			assertEquals(txt_CouponContent, "Sonraki sürüşünde kullanılacak ₺10,00 indirimin var.");
//			click(btn_Geri);
//
//			return this;
//		}
		
		
		
}


