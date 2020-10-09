package pages.android.security;

//import ch.hsr.geohash.GeoHash;
import dbmodel.DataPreparation.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.PageBaseAndroid;

public class pageArizaBildir extends PageBaseAndroid {
	AndroidDriver<AndroidElement> androidDriver;
	Customer customer;
	Scooter scooter;
	TestDevice testDevice;

	
	// *********Constructor*********
		public pageArizaBildir(AndroidDriver<AndroidElement> androidDriver) {
			super(androidDriver);
			this.androidDriver = androidDriver;
			customer = new Customer();
			scooter = new Scooter();
			testDevice = new TestDevice();
		}

		// *****************************************Web Elements***********************************
		
		// *****************General
		String btn_SahayaGit 											= "#goToTasks";
		String btn_ArizaBildir 											= "#btnReportIssue";
		String li_TumIslerim 											= "#txtWorkOrderList";
		String lbl_VeriBulunamadi										= "#txtDataNotFound";
		String li_DepoyaGit												= "#txtWareHouse";
		String img_MartiLogo											= "#appLogo";
		String btn_GoreveBasla											= "#btnMultiTask";
		String popup_Tamam												= "#android:id/button1";
		String btn_Geri													= "#backText";
		String popup_Message											= "#android:id/message";
		String btn_ABC1													= "#icCode";
		String txt_ScooterCode											= "#editText2";
		String btn_QrTamam												= "#btnOk";
		String btn_FotoCek												= "#capture_button";
		String chb_Gaz													= "#checkBox2";
		String txt_ArizaDetayi											= "#editText";
		String btn_TakeFoto												= "#cvTakePhoto";
		String btn_DevamEt												= "#button7";
		
		
		// *********Page Methods*********
		public pageArizaBildir Ariza_Bildir(String scooter_code) {
			click(btn_SahayaGit);
			click(btn_ArizaBildir);
			click(btn_ABC1);
			writeText(txt_ScooterCode, scooter_code);
			click(btn_QrTamam);
			click("$DEVAM ET");
			assertEquals(popup_Message, "Lütfen bilgileri eksiksiz doldurun.");
			click(popup_Tamam);
			click(chb_Gaz);
			click("$DEVAM ET");
			writeText(txt_ArizaDetayi, "otomasyon");
			click(btn_DevamEt);
			assertEquals(popup_Message, "Fotoğraf eksik, kontrol edin.");
			click(popup_Tamam);
			click(btn_TakeFoto);
			click(btn_FotoCek);
			waitLoadingImage();
			click(btn_DevamEt);
			assertEquals(popup_Message, "Scooter arıza kaydı oluşturuldu.");
			click(popup_Tamam);
			assertFound(btn_ArizaBildir);
			return this;
		}
}