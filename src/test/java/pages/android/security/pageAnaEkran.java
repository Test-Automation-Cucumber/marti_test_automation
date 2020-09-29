package pages.android.security;

import dbmodel.Provider;
import dbmodel.DataPreparation.Customer;
import dbmodel.DataPreparation.Scooter;
import dbmodel.DataPreparation.TestDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.PageBaseAndroid;

public class pageAnaEkran extends PageBaseAndroid {
	AndroidDriver<AndroidElement> androidDriver;
	Customer customer;
	Scooter scooter;
	TestDevice testDevice;
	
	// *********Constructor*********
		public pageAnaEkran(AndroidDriver<AndroidElement> androidDriver) {
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
		
		
		// *********Page Methods*********
		public pageAnaEkran Arac_Teslim_Al_Kontrol() {
			assertFound(btn_AracTeslimAl);
			return this;
		}
		public pageAnaEkran Arac_Teslim_Et_Kontrol() {
			assertFound(btn_AracTeslimEt);
			return this;
		}
		
	}