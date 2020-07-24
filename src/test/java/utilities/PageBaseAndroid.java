package utilities;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.mobile.NetworkConnection.ConnectionType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.touch.offset.PointOption;

import java.io.IOException;
import java.time.Duration;
import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class PageBaseAndroid {
	public AndroidDriver<AndroidElement> androidDriver;
	public WebDriverWait wait;
	JavascriptExecutor js;
	Dimension size;

	// Constructor
	public PageBaseAndroid(AndroidDriver androidDriver) {
		this.androidDriver = androidDriver;
		wait = new WebDriverWait(androidDriver, 30);
//		androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

//===========================================================================Waiting..
	protected By findElements(String pure_element, int index) {
		By elementBy = null;
		waitLoadingImage();

		if (pure_element.substring(0, 1).equals("*")) {
			elementBy = MobileBy
					.AndroidUIAutomator("resourceId(\"" + pure_element.substring(1) + "\").instance(" + index + ")"); // instancelari silebilirsin.
		} else if (pure_element.substring(0, 1).equals(".")) {
			elementBy = MobileBy // class ztn var
					.AndroidUIAutomator("className(\"" + pure_element.substring(1) + "\")");
		} else if (pure_element.substring(0, 1).equals("$")) {
			elementBy = MobileBy// linktexti dene
					.AndroidUIAutomator("text(\"" + pure_element.substring(1) + "\").instance(" + index + ")");
		} else if (pure_element.substring(0, 1).equals("@")) {
			elementBy = MobileBy // accessibilityID ile daha hizli olur ama bunla devam et.
					.AndroidUIAutomator("description(\"" + pure_element.substring(1) + "\").instance(" + index + ")");
		} else if (pure_element.substring(0, 1).equals("#")) {
			elementBy = MobileBy.id(pure_element.substring(1));
		}

		return elementBy;
	}

	protected By quickFindElements(String pure_element, int index) {
		By elementBy = null;
		if (pure_element.substring(0, 1).equals("*")) {
			elementBy = MobileBy
					.AndroidUIAutomator("resourceId(\"" + pure_element.substring(1) + "\").instance(" + index + ")");
		} else if (pure_element.substring(0, 1).equals(".")) {
			elementBy = MobileBy
					.AndroidUIAutomator("className(\"" + pure_element.substring(1) + "\").instance(" + index + ")");
		} else if (pure_element.substring(0, 1).equals("$")) {
			elementBy = MobileBy
					.AndroidUIAutomator("text(\"" + pure_element.substring(1) + "\").instance(" + index + ")");
		} else if (pure_element.substring(0, 1).equals("@")) {
			elementBy = MobileBy
					.AndroidUIAutomator("description(\"" + pure_element.substring(1) + "\").instance(" + index + ")");
		} else if (pure_element.substring(0, 1).equals("#")) {
			elementBy = MobileBy.id(pure_element.substring(1));
		}

		return elementBy;
	}

//	protected List<AndroidElement> findElements(String pure_element, int index) {
//		
//		waitLoadingImage();
//		List<AndroidElement> elements = null;
//
//		if (pure_element.substring(0, 1).equals("*")) {
//			elements = driver
//					.findElements(MobileBy.AndroidUIAutomator("resourceId(\"" + pure_element.substring(1) + "\")"));
//			waitClickable(elements, index);
//		} else if (pure_element.substring(0, 1).equals(".")) {
//			elements = driver
//					.findElements(MobileBy.AndroidUIAutomator("className(\"" + pure_element.substring(1) + "\")"));
//			waitClickable(elements, index);
//		} else if (pure_element.substring(0, 1).equals("$")) {
//			elements = driver.findElements(MobileBy.AndroidUIAutomator("text(\"" + pure_element.substring(1) + "\")"));
//			waitClickable(elements, index);
//		} else if (pure_element.substring(0, 1).equals("@")) {
//			elements = driver
//					.findElements(MobileBy.AndroidUIAutomator("description(\"" + pure_element.substring(1) + "\")"));
//			waitClickable(elements, index);
//		} else if (pure_element.substring(0, 1).equals("#")) {
//			elements = driver.findElements(MobileBy.id(pure_element.substring(1)));
//			waitClickable(elements, index);
//		}
//
//		return elements;
//	}

//	protected AndroidElement findElement(String pure_element, int index) {
//		waitLoadingImage();
//		AndroidElement element = null;
//		if (pure_element.substring(0, 1).equals("*")) {
//			element = driver.findElement(MobileBy
//					.AndroidUIAutomator("resourceId(\"" + pure_element.substring(1) + "\").instance(" + index + ")"));
//			wait.until(ExpectedConditions.elementToBeClickable(element));
//		} else if (pure_element.substring(0, 1).equals(".")) {
//			element = driver.findElement(MobileBy
//					.AndroidUIAutomator("className(\"" + pure_element.substring(1) + "\").instance(" + index + ")"));
//			wait.until(ExpectedConditions.elementToBeClickable(element));
//		} else if (pure_element.substring(0, 1).equals("$")) {
//			element = driver.findElement(
//					MobileBy.AndroidUIAutomator("text(\"" + pure_element.substring(1) + "\").instance(" + index + ")"));
//			wait.until(ExpectedConditions.elementToBeClickable(element));
//		} else if (pure_element.substring(0, 1).equals("@")) {
//			element = driver.findElement(MobileBy
//					.AndroidUIAutomator("description(\"" + pure_element.substring(1) + "\").instance(" + index + ")"));
//			wait.until(ExpectedConditions.elementToBeClickable(element));
//		} else if (pure_element.substring(0, 1).equals("#")) {
//			element = driver.findElements(MobileBy.id(pure_element.substring(1))).get(index);
//			wait.until(ExpectedConditions.elementToBeClickable(element));
//		}
//		return element;
//	}

	protected void wait(int second) {
		try {
			TimeUnit.SECONDS.sleep(second);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void waitMilliSec(int milli_second) {
		try {
			TimeUnit.MILLISECONDS.sleep(milli_second);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Wait By Wrapper Method
	protected void waitClickable(By elementBy) {
		wait.until(ExpectedConditions.elementToBeClickable(elementBy));
	}

	// Wait By Wrapper Method
	protected void waitLoadingImage() {
		try {
			androidDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.id("progressBar")));
		} catch (Exception ex) {
		} finally {
			androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	// Wait By Wrapper Method
	protected void waitLoadingImage2() {
		try {
			androidDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.id("progressBar2")));
		} catch (Exception ex) {
		} finally {
			androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}
	
	


//===========================================================================Click
	// Click By Method
	protected void click(String pure_element) {
		By elementBy = findElements(pure_element, 0);
		waitClickable(elementBy);
		androidDriver.findElement(elementBy).click();
	}

	// Click By Method
	protected void quickClick(String pure_element) {
		By elementBy = quickFindElements(pure_element, 0);
		androidDriver.findElement(elementBy).click();

	}

	// Click By Method
	protected void click(String pure_element, int index) {
		By elementBy = findElements(pure_element, index);
		waitClickable(elementBy);

		 if (pure_element.substring(0, 1).equals("."))
		 {
		 androidDriver.findElements(By.className(pure_element.substring(1))).get(index).click();
		return;
		 }
		
		List<AndroidElement> elements = androidDriver.findElements(elementBy);
		elements.get(index).click();
	}

//===========================================================================Write Text
	// Write By Text
	protected void writeText(String pure_element, String text) {
		By elementBy = findElements(pure_element, 0);

		waitClickable(elementBy);
		List<AndroidElement> elements = androidDriver.findElements(elementBy);
		elements.get(0).clear();
		elements.get(0).sendKeys(text);
	}

	// Write By Text
	protected void writeText(String pure_element, String text, int index) {
		By elementBy = findElements(pure_element, index);
		waitClickable(elementBy);

		List<AndroidElement> elements = androidDriver.findElements(elementBy);
		elements.get(index).clear();
		elements.get(index).sendKeys(text);
	}
	
	
	// Write text without element
	protected void writeTextWithoutElement(String text) {
		androidDriver.getKeyboard().sendKeys(text);
	}

//===========================================================================Read Text
	// Read Text
	protected String readText(String pure_element) {
		By elementBy = findElements(pure_element, 0);
		waitClickable(elementBy);

		List<AndroidElement> elements = androidDriver.findElements(elementBy);
		return elements.get(0).getText();
	}

	// Read Text
	protected String readText(String pure_element, int index) {
		By elementBy = findElements(pure_element, index);
		waitClickable(elementBy);

		List<AndroidElement> elements = androidDriver.findElements(elementBy);
		return elements.get(index).getText();
	}

//===========================================================================Assert
	// Assert
	protected void assertEquals(String pure_element, String expected_text) {
		Assert.assertEquals(readText(pure_element), expected_text);
	}
	
	// Assert integer
	protected void assertEquals(int number1, int number2) {
		Assert.assertEquals(number1, number2);
	}
	
	// Assert Not
	protected void assertNotEquals(String pure_element, String expected_text) {
		Assert.assertNotEquals(readText(pure_element), expected_text);
	}
	
	// Assert Content
	protected void assertContent(String text_1, String text_2) {
		Assert.assertEquals(text_1, text_2);
	}
	
	// Assert Not Content
	protected void assertNotContent(String text_1, String text_2) {
		Assert.assertNotEquals(text_1, text_2);
	}

	// Assert True -- bu kisa süreli ariyor elementi.. 1 sn
	protected void assertTrue(String pure_element) {
		Assert.assertTrue(exists(pure_element, 1), "element : "+ pure_element + " ||");
	}

	// Assert Found -- bu uzun süreli ariyor elementi.. mesela 30 sn
	protected void assertFound(String pure_element) {
		Assert.assertTrue(exists(pure_element, 30), "element : "+ pure_element + " ||");
	}

	// Assert Found
	protected void assertFound(String pure_element, int index) {
		try {
			if (androidDriver.findElements(findElements(pure_element, index)).size() == 0) {
				throw new Exception();
			}
		} catch (Exception ex) {
		}
	}

	// Assert Not Found
	protected void assertNotFound(String pure_element) {
		try {
			if (androidDriver.findElements(findElements(pure_element, 0)).size() != 0) {
				throw new Exception();
			}
		} catch (Exception ex) {
		}
	}

	// Assert Not Found
	protected void assertNotFound(String pure_element, int index) {
		try {
			if (androidDriver.findElements(findElements(pure_element, index)).size() != 0) {
				throw new Exception();
			}
		} catch (Exception ex) {
		}
	}

//===========================================================================Special for Elements
	// Exists Element
	/**
	 * @param elementBy
	 * @param second    -- set seconds to wait element in page
	 * @return returns true or false regarding to element existing
	 */
	protected boolean exists(String pure_element, int second) {
		try {
			androidDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			List<AndroidElement> elements = null;
			for (int i = 0; i < second; i++) {
				Thread.sleep(1000);
				try {
					elements = androidDriver.findElements(quickFindElements(pure_element, 0));
					if (elements.get(0).isDisplayed()) {
						return true;
					}
				} catch (Exception ex) {
					continue;
				}
			}
			System.out.println("element bulunamadi : " + pure_element);
			return false;

		} catch (Exception e) {
			System.out.println("element bulunamadi : " + pure_element);
			return false;
		} finally {
			androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	// Get Element Size
	protected int getSize(String pure_element) {
		try {
			androidDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			By elementBy = findElements(pure_element, 0);
			List<AndroidElement> elements = androidDriver.findElements(elementBy);
			return elements.size();
		} catch (Exception ex) {
			return 0;
		} finally {
			androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

//===========================================================================Special Methods

	// Find Scooter
	protected void findScooter(String scooter_name) {

		By gotoMyLocationBy = findElements("#btnMyLocation", 0);
		List<AndroidElement> gotoMyLocation = androidDriver.findElements(gotoMyLocationBy);
		gotoMyLocation.get(0).click();
		wait(3);
		By elementBy = findElements(".android.view.View", 0);
		List<AndroidElement> elements = androidDriver.findElements(elementBy);
		AndroidElement scooterSerial = null;
		AndroidElement closeInfoWindow = null;

		for (int i = 0; i < elements.size(); i++) {
			elements.get(i).click();

			By scooterSerialBy = findElements("#scooterSerial", 0);
			scooterSerial = androidDriver.findElements(scooterSerialBy).get(0);

			if (scooterSerial.getText().equals(scooter_name)) {
				return;
			}
			By closeInfoWindowBy = findElements("#closeInfoWindow", 0);
			closeInfoWindow = androidDriver.findElements(closeInfoWindowBy).get(0);
			closeInfoWindow.click();
		}
	}

	// Back
	protected void back() {
		// driver.pressKeyCode(AndroidKeyCode.BACK);
		androidDriver.navigate().back();
	}

	protected String SetRandomString(int byteLength) {
		String text = "";
		for (int i = 0; i < byteLength; i++) {
			Random rnd = new Random();
			char c = (char) (rnd.nextInt(26) + 'a');
			text = text + c;
		}
		return text;
	}

	/*
	 * Swipe(startx, starty, endx, endy, time) Drag base on coordinates - X1 - First
	 * point X - Y1 - First point Y - X2 - Second point X - Y2 - Second point Y -
	 * time - Drag time (ms)
	 */
	public void swipe(String elementofNextPage, int firstPointX, int firstPointY, int secondPointX, int secondPointY,
			int dragTimeMS) {

		findElements(elementofNextPage, 0);// kaydırma işlemi öncesi ekranda olmasi gereken bir elementi gormesi icin
											// gerekli.

		new TouchAction(androidDriver).press(PointOption.point(firstPointX, firstPointY))
				.waitAction(waitOptions(Duration.ofMillis(dragTimeMS)))
				.moveTo(PointOption.point(secondPointX, secondPointY)).release().perform();
	}
	


	protected void setLocation(String location) {
		if (location.equals("office")) {
			androidDriver.setLocation(new Location(41.006405, 29.074996, 1));
		}
		wait(3);
		 
	}
	// vertical swipe
	protected void verticalSwipe(double startPercentage, double finalPercentage, int duration) {
//		size =driver.manage().window().getSize();
//		int width=(int) (size.width/2);
//		int startPoint=(int) (size.getHeight() * startPercentage);
//		int endPoint=(int) (size.getHeight() * finalPercentage);
//		new TouchAction(driver).press(width, startPoint).waitAction(Duration.ofMillis(duration))
//		.moveTo(width, endPoint).release().perform();
	}

//	public void setLocationServiceStatus(boolean status) {
//		String cmd = "";
//		if (status)
//			cmd = "adb shell settings put secure location_providers_allowed +network & adb shell settings put secure location_providers_allowed +gps";
//		else
//			cmd = "adb shell settings put secure location_providers_allowed -network & adb shell settings put secure location_providers_allowed -gps";
//
//		try {
//			new ProcessBuilder("cmd.exe", "/c", cmd).start();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	protected void setDataAndWIFIServiceStatus(boolean status) {
//		if (status) {
//			androidDriver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
//			androidDriver.setConnection(new ConnectionStateBuilder().withDataEnabled().build());
//		} else {
//			androidDriver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
//			androidDriver.setConnection(new ConnectionStateBuilder().withDataDisabled().build());
//		}
//	}
//	
//	protected void setBatteryLevel(int level) {
//		androidDriver.setPowerCapacity(level);
//	}
//	
//
//	protected void setCamPermissionStatus(boolean status) {
//		String packageName= androidDriver.getCurrentPackage();
//		 String grantCameraPermission= "adb shell pm grant " + packageName +" android.permission.CAMERA";
//		 String revokeCameraPermission= "adb shell pm revoke " + packageName +" android.permission.CAMERA";
//			try {
//				if (status) 
//					Runtime.getRuntime().exec(grantCameraPermission);
//				else
//					Runtime.getRuntime().exec(revokeCameraPermission);	
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
			       
		
//	//calismiyor gibi..
//	protected void setAppLocationStatus(boolean status) {  
//		String packageName= androidDriver.getCurrentPackage();
//		 String grantLocationPermission= "adb shell pm grant " + packageName +" android.permission.ACCESS_FINE_LOCATION";
//		 String revokeLocationPermission= "adb shell pm revoke " + packageName +" android.permission.ACCESS_FINE_LOCATION";
//		try {
//			if (status) 
//				Runtime.getRuntime().exec(grantLocationPermission);
//			else
//				Runtime.getRuntime().exec(revokeLocationPermission);	
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
		
	
//	public void aaaa() {
//		Alert alert = androidDriver.switchTo().alert();
//		 alert.accept();
//	}
	

	public void ExecuteCommandPrompt(String cmd_text) {
		try {
			new ProcessBuilder("cmd.exe", "/c", cmd_text).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
//	public void CmdTest(String anyCommand) throws Throwable {
//
//		ProcessBuilder builder = new ProcessBuilder(
//		            "cmd.exe", "/c", anyCommand);
//		        builder.redirectErrorStream(true);
//		        Process p = builder.start();
//		        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
//		        String line;
//		        while (true) {
//		            line = r.readLine();
//		            if (line == null) { break; }
//		            System.out.println(line);
//		        }
//		    }
	

		
		

