package pages.android.security;


//import ch.hsr.geohash.GeoHash;
import dbmodel.DataPreparation.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.PageBaseAndroid;

public class pageYuklemeEkrani extends PageBaseAndroid {
	AndroidDriver<AndroidElement> androidDriver;
	Customer customer;
	Scooter scooter;
	TestDevice testDevice;
	pageGirisEkrani giris_Ekrani;	

	
	// *********Constructor*********
		public pageYuklemeEkrani(AndroidDriver<AndroidElement> androidDriver) {
			super(androidDriver);
			this.androidDriver = androidDriver;
			customer = new Customer();
			scooter = new Scooter();
			testDevice = new TestDevice();
			
			giris_Ekrani = new pageGirisEkrani(this.androidDriver);
		}

		// *****************************************Web Elements***********************************
		
		// *****************General
		String ProgressBar 											= "#progressBar"; //PROGRESS BAR

		
		// *********Page Methods*********

		public pageYuklemeEkrani TC_001_Yukleme_Ekrani_Kamera_Izni() {
			
		return this;
	}
}