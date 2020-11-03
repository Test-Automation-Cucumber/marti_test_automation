package pages.android.ride;


import dbmodel.DataPreparation.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.PageBaseAndroid;

public class pageBorclar extends PageBaseAndroid {
	AndroidDriver<AndroidElement> androidDriver;

	// *********Constructor*********
		public pageBorclar(AndroidDriver<AndroidElement> androidDriver) {
			super(androidDriver);
			this.androidDriver = androidDriver;
		}

		// *****************************************Web Elements***********************************
		
		// *****************General
		String ProgressBar 													= "#progressBar"; //PROGRESS BAR  *com.martitech.marti.dev:id/progressBar   (com.martitech.marti.dev paket adı bu. kamera iznine koydun bunu çıkarmayi. ordan kopya cek)
		String btn_Basla													= "#btnScan";
		String img_NotifyIcon												= "#imageView25";	
		String btn_Light													= "#light";	
		String btn_TAMAM													= "#android:id/button1";	
		String btn_Ileri													= "#btnNext";	
		String btn_KrediKartiEkle											= "#btnPayDebt";	
		String txt_KartNumarasi												= "#cardNumber";	
		String popup_Tamam													= "#android:id/button2";	
		String popup_BorcOde												= "#android:id/button1";	
		String popup_MessageText											= "#android:id/message";	
		String btn_BorcOde													= "#btnPayDebt";	
		String popup_TAMAM													= "#android:id/button1";	
		String lbl_MartiCuzdan												= "#cardHolder";	
		
		// *********Page Methods*********
		public pageBorclar Borclu_Kullanici(String customer_phone_no) {
			assertFound(img_NotifyIcon);
			wait(4);
			click(btn_Basla);
			waitLoadingImage2();
			click(popup_Tamam);
			waitLoadingImage2();
			assertFound(btn_Light);		
			return this;
		}	
		
		public pageBorclar Borclu_Kullanici_Plus_15(String customer_phone_no) {
			assertFound(img_NotifyIcon);
			wait(4);
			click(btn_Basla);
			waitLoadingImage2();
			assertEquals(popup_MessageText, "Önceki sürüşlerinden kalan ₺16,00 bakiyeniz bulunduğu için yeni bir sürüş başlatamazsın. Şimdi ödeme yaparak devam etmek ister misiniz?");		
			click(popup_Tamam);
			waitLoadingImage2();
			assertFound(img_NotifyIcon);
			return this;
		}

		public pageBorclar Borc_Odeme(String customer_phone_no) {
			assertFound(img_NotifyIcon);
			wait(4);
			click(btn_Basla);
			waitLoadingImage2();
			click(popup_BorcOde);
			waitLoadingImage2();
			waitLoadingImage();
			assertFound(btn_BorcOde);
			return this;
		}
		
		public pageBorclar Borc_Odeme_Cuzdan_Yeterli(String customer_phone_no) {
			assertFound(img_NotifyIcon);
			wait(4);
			click(btn_Basla);
			waitLoadingImage2();
			click(popup_BorcOde);
			waitLoadingImage2();
			waitLoadingImage();
			assertFound(btn_BorcOde);
			assertEquals(lbl_MartiCuzdan, "Martı Cüzdan");
			return this;
		}
		
		
		public pageBorclar Borc_Odeme_Islemi_Basarili(String customer_phone_no) {
			assertFound(img_NotifyIcon);
			wait(4);
			click(btn_Basla);
			waitLoadingImage2();

			click(popup_BorcOde);
			waitLoadingImage2();
			waitLoadingImage();
			click(btn_BorcOde);
			waitLoadingImage();
			
			assertEquals(popup_MessageText, "Bakiye başarıyla ödendi.");
			click(popup_TAMAM);
			waitLoadingImage();
			return this;
		}
		public pageBorclar Borc_Odeme_Islemi_Basarisiz(String customer_phone_no) {
			assertFound(img_NotifyIcon);
			wait(4);
			click(btn_Basla);
			waitLoadingImage2();

			click(popup_BorcOde);
			waitLoadingImage2();
			waitLoadingImage();
			click(btn_BorcOde);
			waitLoadingImage();
			assertEquals(popup_MessageText, "Ödemeni gerçekleştirmek için kart limitin yetersiz. Dilersen yeni bir kart ekleyerek ödemeni tamamlayabilirsin."); 
			click(popup_TAMAM);
			wait(1);
			assertFound(btn_BorcOde);
			return this;
		}
		
		
}