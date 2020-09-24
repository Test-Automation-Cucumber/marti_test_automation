package pages.ios.ride;


import dbmodel.DataPreparation.*;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import utilities.PageBaseIos;

public class pageBorclar extends PageBaseIos {
	IOSDriver<IOSElement> iosDriver;
	TestDevice testDevice;
	Customer customer;
	Scooter scooter;
	pageGirisEkrani giris_Ekrani;	

	
	// *********Constructor*********
		public pageBorclar(IOSDriver<IOSElement> iosDriver) {
			super(iosDriver);
			this.iosDriver = iosDriver;
			testDevice = new TestDevice();
			customer = new Customer();
			scooter = new Scooter();
			giris_Ekrani = new pageGirisEkrani(this.iosDriver);
			
		}

		// *****************************************Web Elements***********************************
		
		// *****************General
		
		String img_NotifyIcon												= "#notificationIcon";
		String btn_Basla													= "#BAŞLA";
		String popup_Tamam													= "#Tamam";
		String btn_Light													= "#qr light";	
		String popup_OnceliSurusBorc										= "#Önceki sürüşlerinden kalan 16.00 ₺ bakiyen bulunduğu için yeni bir sürüş başlatamazsın. Şimdi ödeme yaparak devam etmek ister misin?";	
		String popup_BorcOde												= "#Borç Öde";
		String popup_BakiyeBasariylaOdendi									= "#Borç Öde";
		String popup_BakiyeBasariylaOdendiText								= "#Bakiye başarıyla ödendi.";
		String popup_OdemeniGerceklestirmekIcin								= "#Ödemeni gerçekleştirmek için kart limitin yetersiz. Dilersen yeni bir kart ekleyerek ödemeni tamamlayabilirsin.";
		
		
		
		String ProgressBar 													= "#progressBar"; //PROGRESS BAR  *com.martitech.marti.dev:id/progressBar   (com.martitech.marti.dev paket adı bu. kamera iznine koydun bunu çıkarmayi. ordan kopya cek)

		String btn_Ileri													= "#btnNext";	
		String btn_KrediKartiEkle											= "#btnPayDebt";	
		String txt_KartNumarasi												= "#cardNumber";
			
		// *********Page Methods*********

		public pageBorclar Borclu_Kullanici(String customer_phone_no, String scooter_code) {
			
			customer.deleteCreditCards(customer_phone_no)
			.addCreditCard(customer_phone_no);
			customer.deleteCustomerDebt(customer_phone_no)
			.addCustomerDebt(customer_phone_no, 14);
	
			scooter
			.deleteScooterReservations(scooter_code)
			.deleteScooterRides(scooter_code);

			giris_Ekrani
			.Login(customer_phone_no);
			
			assertFound(img_NotifyIcon);
			
			wait(4);
			click(btn_Basla);
//assert koymamışın
			click(popup_Tamam);

			assertFound(btn_Light);
			
			customer.deleteCustomerDebt(customer_phone_no);
			return this;
		}	
		
		public pageBorclar Borclu_Kullanici_Plus_15(String customer_phone_no) {
				customer
				.deleteCustomerDebt(customer_phone_no)
				.addCustomerDebt(customer_phone_no, 16);

				giris_Ekrani
				.Login(customer_phone_no);
			assertFound(img_NotifyIcon);
			
			wait(4);
			click(btn_Basla);
			waitLoadingImage();
			assertEquals(popup_OnceliSurusBorc, "Önceki sürüşlerinden kalan 16.00 ₺ bakiyen bulunduğu için yeni bir sürüş başlatamazsın. Şimdi ödeme yaparak devam etmek ister misin?");
			
			click(popup_Tamam);
			waitLoadingImage();
			assertFound(img_NotifyIcon);
			customer.deleteCustomerDebt(customer_phone_no);
			return this;
		}

		public pageBorclar Borc_Odeme(String customer_phone_no) {
				customer.deleteCreditCards(customer_phone_no)
				.addCreditCard(customer_phone_no);
				customer.deleteCustomerDebt(customer_phone_no)
				.addCustomerDebt(customer_phone_no, 11);

				giris_Ekrani
				.Login(customer_phone_no);
				
			assertFound(img_NotifyIcon);
			
			wait(4);
			click(btn_Basla);
			waitLoadingImage();

			click(popup_BorcOde);
			waitLoadingImage();
			assertFound(popup_BorcOde);
			waitLoadingImage();
			customer.deleteCustomerDebt(customer_phone_no);
			return this;
		}
		public pageBorclar Borc_Odeme_Islemi_Basarili(String customer_phone_no) {
			
			customer.deleteCreditCards(customer_phone_no)
			.addCreditCard(customer_phone_no);
			customer.deleteCustomerDebt(customer_phone_no)
			.addCustomerDebt(customer_phone_no, 11);
	
			giris_Ekrani
			.Login(customer_phone_no);
			
			assertFound(img_NotifyIcon);
			wait(4);
			click(btn_Basla);
			waitLoadingImage();

			click(popup_BorcOde);
			waitLoadingImage();
			
			click(popup_BorcOde);
			waitLoadingImage();
			
			assertEquals(popup_BakiyeBasariylaOdendiText, "Bakiye başarıyla ödendi.");
			click(popup_Tamam);
			waitLoadingImage();
			return this;
		}
		public pageBorclar Borc_Odeme_Islemi_Basarisiz(String customer_phone_no) {

			customer
			.deleteCreditCards(customer_phone_no)
			.addErrorCreditCard(customer_phone_no)
			.deleteCustomerDebt(customer_phone_no)
			.addCustomerDebt(customer_phone_no, 11);
			
			giris_Ekrani
			.Login(customer_phone_no);
			
			assertFound(img_NotifyIcon);
			wait(4);
			click(btn_Basla);
			waitLoadingImage();

			click(popup_BorcOde);
			waitLoadingImage();
			click(popup_BorcOde);
			waitLoadingImage();
			assertEquals(popup_OdemeniGerceklestirmekIcin, "Ödemeni gerçekleştirmek için kart limitin yetersiz. Dilersen yeni bir kart ekleyerek ödemeni tamamlayabilirsin."); 
			click(popup_Tamam);
			wait(1);
			assertFound(popup_BorcOde);
			return this;
		}
		
		
}