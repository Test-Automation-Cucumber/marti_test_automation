package pages.android.security;

import dbmodel.DataPreparation.Customer;
import dbmodel.DataPreparation.Scooter;
import dbmodel.DataPreparation.TestDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.PageBaseAndroid;

public class pageAracTeslim extends PageBaseAndroid {
	AndroidDriver<AndroidElement> androidDriver;
	Customer customer;
	Scooter scooter;
	TestDevice testDevice;
	
	// *********Constructor*********
		public pageAracTeslim(AndroidDriver<AndroidElement> androidDriver) {
			super(androidDriver);
			this.androidDriver = androidDriver;
			customer = new Customer();
			scooter = new Scooter();
			testDevice = new TestDevice();
		}

		// *****************************************Web Elements***********************************
		
		// *****************General
		private	String popup_Message												= "#android:id/message";
		private	String btn_AracTeslimAl												= "#btnTakeCar";
		private	String btn_AracTeslimEt												= "#deliverVehicle";
		private	String txt_AracKmGir												= "#kmCycle";
		private	String img_AracFoto_1												= "#imv1";
		private	String img_AracFoto_2												= "#imv2";
		private	String img_AracFoto_3												= "#imv3";
		private	String img_AracFoto_4												= "#imv4";
		private	String img_AracFoto_5												= "#imv5";
		private	String btn_FotoCek													= "#capture_button";
		private	String rdb_SorunYok													= "#radioNo";
		private	String rdb_SorunVar													= "#radioYes";
		private	String txt_SorunDetay												= "#issue";		
		private	String btn_DevamEt													= "#btnNext";
		private String img_MartiLogo												= "#appLogo";
		private String btn_Tamam													= "#android:id/button1";
		
		// *********Page Methods*********
		public pageAracTeslim Arac_Teslim_Al_Sorun_Yok() {
			click(btn_AracTeslimAl);
			writeText(txt_AracKmGir, "10");
			
			click(img_AracFoto_1);
			click(btn_FotoCek);			
			
			click(img_AracFoto_2);
			click(btn_FotoCek);
			
			click(img_AracFoto_3);
			click(btn_FotoCek);
			
			click(img_AracFoto_4);
			click(btn_FotoCek);
			
			swipe(txt_AracKmGir, 303, 975,346,231, 300);
			
			click(img_AracFoto_5);
			click(btn_FotoCek);
			
			click(rdb_SorunYok);
			click(btn_DevamEt);
			
			assertFound(img_MartiLogo);
						
			return this;
			
		}
		
		public pageAracTeslim Arac_Teslim_Al_Sorun_Var() {
			click(btn_AracTeslimAl);
			writeText(txt_AracKmGir, "10");
			
			click(img_AracFoto_1);
			click(btn_FotoCek);			
			
			click(img_AracFoto_2);
			click(btn_FotoCek);
			
			click(img_AracFoto_3);
			click(btn_FotoCek);
			
			click(img_AracFoto_4);
			click(btn_FotoCek);
			
			swipe(txt_AracKmGir, 303, 975,346,231, 300);
			
			click(img_AracFoto_5);
			click(btn_FotoCek);
			
			click(rdb_SorunVar);
			writeText(txt_SorunDetay, "otomasyon");
			click(btn_DevamEt);
			
			assertFound(img_MartiLogo);
						
			return this;
		}
		
		public pageAracTeslim Arac_Teslim_Al_Basarili_Yanci() {
			click(btn_AracTeslimAl);
			click(btn_DevamEt);
			
			assertFound(img_MartiLogo);
						
			return this;
		}
		
		public pageAracTeslim Arac_Teslim_Al_Basarisiz_Hatali_KM() {
			click(btn_AracTeslimAl);
			writeText(txt_AracKmGir, "0");
			
			click(img_AracFoto_1);
			click(btn_FotoCek);			
			
			click(img_AracFoto_2);
			click(btn_FotoCek);
			
			click(img_AracFoto_3);
			click(btn_FotoCek);
			
			click(img_AracFoto_4);
			click(btn_FotoCek);
			
			swipe(txt_AracKmGir, 303, 975,346,231, 300);
			
			click(img_AracFoto_5);
			click(btn_FotoCek);
			click(btn_DevamEt);
			
			assertEquals(popup_Message, "Geçerli bir KM değeri girin.");
			click(btn_Tamam);

			return this;
		}
		
		public pageAracTeslim Arac_Teslim_Al_Basarisiz_Eksik_Foto() {
			click(btn_AracTeslimAl);
			writeText(txt_AracKmGir, "5");
			
			click(img_AracFoto_1);
			click(btn_FotoCek);
						
			swipe(txt_AracKmGir, 303, 975,346,231, 300);

			click(btn_DevamEt);
			
			assertEquals(popup_Message, "Araç fotoğrafı eksik olamaz.");
			click(btn_Tamam);

			return this;
		}
		
		public pageAracTeslim Arac_Teslim_Al_Basarisiz_Eksik_Detay() {
			click(btn_AracTeslimAl);
			writeText(txt_AracKmGir, "10");
			
			click(img_AracFoto_1);
			click(btn_FotoCek);			
			
			click(img_AracFoto_2);
			click(btn_FotoCek);
			
			click(img_AracFoto_3);
			click(btn_FotoCek);
			
			click(img_AracFoto_4);
			click(btn_FotoCek);
			
			swipe(txt_AracKmGir, 303, 975,346,231, 300);
			
			click(img_AracFoto_5);
			click(btn_FotoCek);
			
			click(rdb_SorunVar);
			writeText(txt_SorunDetay, "oto");
			click(btn_DevamEt);

			assertEquals(popup_Message, "Sorun alanına en az 5 karakter girişi olmalıdır.");
			click(btn_Tamam);

			return this;
		}
		
		public pageAracTeslim Arac_Teslim_Et_Basarili_Sorun_Yok() {
			click(btn_AracTeslimEt);
			writeText(txt_AracKmGir, "10");
			
			click(img_AracFoto_1);
			click(btn_FotoCek);			
			
			click(img_AracFoto_2);
			click(btn_FotoCek);
			
			click(img_AracFoto_3);
			click(btn_FotoCek);
			
			click(img_AracFoto_4);
			click(btn_FotoCek);
			
			swipe(txt_AracKmGir, 303, 975,346,231, 300);
			
			click(img_AracFoto_5);
			click(btn_FotoCek);
			click(btn_DevamEt);
			
			assertFound(img_MartiLogo);

			return this;
		}
		
		public pageAracTeslim Arac_Teslim_Et_Basarili_Sorun_Var() {
			click(btn_AracTeslimEt);
			writeText(txt_AracKmGir, "10");
			
			click(img_AracFoto_1);
			click(btn_FotoCek);			
			
			click(img_AracFoto_2);
			click(btn_FotoCek);
			
			click(img_AracFoto_3);
			click(btn_FotoCek);
			
			click(img_AracFoto_4);
			click(btn_FotoCek);
			
			swipe(txt_AracKmGir, 303, 975,346,231, 300);
			
			click(img_AracFoto_5);
			click(btn_FotoCek);
			
			click(rdb_SorunVar);
			writeText(txt_SorunDetay, "otomasyon");
			click(btn_DevamEt);

			assertFound(img_MartiLogo);

			return this;
		}
		
		public pageAracTeslim Arac_Teslim_Et_Basarisiz_Hatali_KM() {
			click(btn_AracTeslimEt);
			writeText(txt_AracKmGir, "0");
			
			click(img_AracFoto_1);
			click(btn_FotoCek);			
			
			click(img_AracFoto_2);
			click(btn_FotoCek);
			
			click(img_AracFoto_3);
			click(btn_FotoCek);
			
			click(img_AracFoto_4);
			click(btn_FotoCek);
			
			swipe(txt_AracKmGir, 303, 975,346,231, 300);
			
			click(img_AracFoto_5);
			click(btn_FotoCek);
			
			click(rdb_SorunYok);
			click(btn_DevamEt);
			
			assertEquals(popup_Message, "Geçerli bir KM değeri girin.");
			click(btn_Tamam);
			
			return this;
		}
		
		public pageAracTeslim Arac_Teslim_Et_Basarisiz_Eksik_Foto() {
			click(btn_AracTeslimEt);
			writeText(txt_AracKmGir, "5");
			
			click(img_AracFoto_1);
			click(btn_FotoCek);			
			
			click(img_AracFoto_3);
			click(btn_FotoCek);
			
			click(img_AracFoto_4);
			click(btn_FotoCek);
			
			swipe(txt_AracKmGir, 303, 975,346,231, 300);
			
			click(img_AracFoto_5);
			click(btn_FotoCek);
			
			click(rdb_SorunYok);
			click(btn_DevamEt);
			
			assertEquals(popup_Message, "Araç fotoğrafı eksik olamaz.");
			click(btn_Tamam);
			
			return this;
		}
		
		public pageAracTeslim Arac_Teslim_Et_Basarisiz_Eksik_Detay() {
			click(btn_AracTeslimEt);
			writeText(txt_AracKmGir, "10");
			
			click(img_AracFoto_1);
			click(btn_FotoCek);			
			
			click(img_AracFoto_2);
			click(btn_FotoCek);
			
			click(img_AracFoto_3);
			click(btn_FotoCek);
			
			click(img_AracFoto_4);
			click(btn_FotoCek);
			
			swipe(txt_AracKmGir, 303, 975,346,231, 300);
			
			click(img_AracFoto_5);
			click(btn_FotoCek);
			
			click(rdb_SorunVar);
			writeText(txt_SorunDetay, "oto");
			click(btn_DevamEt);

			assertEquals(popup_Message, "Sorun alanına en az 5 karakter girişi olmalıdır.");
			click(btn_Tamam);

			return this;
		}
		
		
		
		
	}