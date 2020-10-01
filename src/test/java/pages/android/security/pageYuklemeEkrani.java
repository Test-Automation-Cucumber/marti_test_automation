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

	
	// *********Constructor*********
		public pageYuklemeEkrani(AndroidDriver<AndroidElement> androidDriver) {
			super(androidDriver);
			this.androidDriver = androidDriver;
			customer = new Customer();
			scooter = new Scooter();
			testDevice = new TestDevice();
		}

		// *****************************************Web Elements***********************************
		
		// *****************General
		String btn_SahayaGit 											= "#goToTasks";

		
		// *********Page Methods*********

		public pageYuklemeEkrani Yukleme_Ekrani_Kamera_Izni() {

		return this;
	}
}