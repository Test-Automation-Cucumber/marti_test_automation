package dbmodel.DataPreparation;

import java.io.IOException;

import dbmodel.Provider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;

public class TestDevice {
	Provider provider = new Provider();

	// *********Constructor*********
	public TestDevice() {

	}
	
	public TestDevice setLocationServiceStatus(boolean status) {
		String cmd = "";
		if (status)
			cmd = "adb shell settings put secure location_providers_allowed +network & adb shell settings put secure location_providers_allowed +gps";
		else
			cmd = "adb shell settings put secure location_providers_allowed -network & adb shell settings put secure location_providers_allowed -gps";

		try {
			new ProcessBuilder("cmd.exe", "/c", cmd).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public TestDevice resetLoginStatus(String phone_number) {
		try {
			provider.ExecuteCommand(
					"update customers set access_token = NULL where mobile_phone = '" + phone_number + "';",
					"martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public TestDevice setWIFIServiceStatus(AndroidDriver<AndroidElement> androidDriver, boolean status) {
		ConnectionState conStatus = androidDriver.getConnection();
		
		if (status) {
			if (!conStatus.isWiFiEnabled()) {
				androidDriver.toggleWifi();
			}
		} else {
			if (conStatus.isWiFiEnabled()) {
				androidDriver.toggleWifi();
			}
		}
		return this;
	}
	
	public TestDevice setDataServiceStatus(AndroidDriver<AndroidElement> androidDriver, boolean status) {
		ConnectionState conStatus = androidDriver.getConnection();
		
		if (status) {
			if (!conStatus.isDataEnabled()) {
				androidDriver.toggleData();
			}
		} else {
			if (conStatus.isDataEnabled()) {
				androidDriver.toggleData();
			}
		}
		return this;
	}
	
	public TestDevice setAirPlaneStatus(AndroidDriver<AndroidElement> androidDriver, boolean status) {
		ConnectionState conStatus = androidDriver.getConnection();
		
		if (status) {
			if (!conStatus.isAirplaneModeEnabled()) {
				androidDriver.toggleAirplaneMode();
			}
		} else {
			if (conStatus.isAirplaneModeEnabled()) {
				androidDriver.toggleAirplaneMode();
			}
		}
		return this;
	}
	
	protected TestDevice setBatteryLevel(AndroidDriver<AndroidElement> androidDriver, int level) {
		androidDriver.setPowerCapacity(level);
		return this;
	}
	
	public TestDevice setCamPermissionStatus(AndroidDriver<AndroidElement> androidDriver, boolean status) {
		String packageName= androidDriver.getCurrentPackage();
		 String grantCameraPermission= "adb shell pm grant " + packageName +" android.permission.CAMERA";
		 String revokeCameraPermission= "adb shell pm revoke " + packageName +" android.permission.CAMERA";
			try {
				if (status) 
					Runtime.getRuntime().exec(grantCameraPermission);
				else
					Runtime.getRuntime().exec(revokeCameraPermission);	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return this;
		}
	


	
	
	
}