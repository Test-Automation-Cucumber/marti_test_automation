package utilities;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;

import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;
import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class PageBaseIos {
	public IOSDriver<IOSElement> iosDriver;
	public WebDriverWait wait;
	JavascriptExecutor js;
	Dimension size;

	// Constructor
	public PageBaseIos(IOSDriver iosDriver) {
		this.iosDriver = (IOSDriver<IOSElement>) iosDriver;
		wait = new WebDriverWait(iosDriver, 30);
		iosDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

//===========================================================================Waiting..
	protected By findElements(String pure_element, int index) {
		By elementBy = null;
//		waitLoadingImage();
		if (pure_element.substring(0, 1).equals("*")) {
			elementBy = MobileBy.xpath("//*[@placeholder='" + pure_element.substring(1) + "']");
		} else if (pure_element.substring(0, 1).equals(".")) {
			elementBy = MobileBy.className(pure_element.substring(1));
		} else if (pure_element.substring(0, 1).equals("$")) {
			elementBy = MobileBy.linkText(pure_element.substring(1));// linktext i android de de bi dene
		} else if (pure_element.substring(0, 1).equals("#")) {
			elementBy = MobileBy.id(pure_element.substring(1));
		}
		
		return elementBy;
	}

	protected By quickFindElements(String pure_element, int index) {
		By elementBy = null;
		if (pure_element.substring(0, 1).equals("*")) {
			elementBy = MobileBy.name(pure_element.substring(1));
		} else if (pure_element.substring(0, 1).equals(".")) {
			elementBy = MobileBy.className(pure_element.substring(1));
		} else if (pure_element.substring(0, 1).equals("$")) {
			elementBy = MobileBy.linkText(pure_element.substring(1));// linktext i android de de bi dene
		} else if (pure_element.substring(0, 1).equals("#")) {
			elementBy = MobileBy.id(pure_element.substring(1));
		}
		return elementBy;
	}

	protected void wait(int second) {
		try {
			TimeUnit.SECONDS.sleep(second);
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
			iosDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.id("Sürüyor")));
		} catch (Exception ex) {
		} finally {
			iosDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	// Wait By Wrapper Method
	protected void waitLoadingImage2() {
		try {
			iosDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.id("progressBar2")));
		} catch (Exception ex) {
		} finally {
			iosDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

//===========================================================================Click
	// Click By Method
	protected void click(String pure_element) {
		By elementBy = findElements(pure_element, 0);
		waitClickable(elementBy);
		iosDriver.findElement(elementBy).click();
	}

	// Click By Method
	protected void quickClick(String pure_element) {
		By elementBy = quickFindElements(pure_element, 0);
		iosDriver.findElement(elementBy).click();

	}

	// Click By Method
	protected void click(String pure_element, int index) {
		By elementBy = findElements(pure_element, index);
		waitClickable(elementBy);

		List<IOSElement> elements = iosDriver.findElements(elementBy);
		elements.get(index).click();
	}

//===========================================================================Write Text
	// Write By Text
	protected void writeText(String pure_element, String text) {
		By elementBy = findElements(pure_element, 0);

		waitClickable(elementBy);
		List<IOSElement> elements = iosDriver.findElements(elementBy);
		elements.get(0).clear();
		elements.get(0).sendKeys(text);
	}

	// Write By Text
	protected void writeText(String pure_element, String text, int index) {
		By elementBy = findElements(pure_element, index);
		waitClickable(elementBy);

		List<IOSElement> elements = iosDriver.findElements(elementBy);
		elements.get(index).clear();
		elements.get(index).sendKeys(text);
	}
	
	// Write By Text Without Clear
	protected void writeTextWithoutClear(String pure_element, String text) {
		By elementBy = findElements(pure_element, 0);

		waitClickable(elementBy);
		List<IOSElement> elements = iosDriver.findElements(elementBy);
		elements.get(0).sendKeys(text);
	}
	
	// Write text without element
	protected void writeTextWithoutElement(String text) {
		iosDriver.getKeyboard().sendKeys(text);
	}
	
//===========================================================================Read Text
	// Read Text
	protected String readText(String pure_element) {
		By elementBy = findElements(pure_element, 0);
		waitClickable(elementBy);

		List<IOSElement> elements = iosDriver.findElements(elementBy);
		return elements.get(0).getText();
	}

	// Read Text
	protected String readText(String pure_element, int index) {
		By elementBy = findElements(pure_element, index);
		waitClickable(elementBy);

		List<IOSElement> elements = iosDriver.findElements(elementBy);
		return elements.get(index).getText();
	}
	
//===========================================================================Get Value
		// Get Value
		protected String getValue(String pure_element) {
			By elementBy = findElements(pure_element, 0);
			waitClickable(elementBy);

			List<IOSElement> elements = iosDriver.findElements(elementBy);
			return elements.get(0).getAttribute("value");
		}

		// Get Value
		protected String getValue(String pure_element, int index) {
			By elementBy = findElements(pure_element, index);
			waitClickable(elementBy);

			List<IOSElement> elements = iosDriver.findElements(elementBy);
			return elements.get(index).getAttribute("value");
		}


//===========================================================================Assert
	// Assert
	protected void assertEquals(String pure_element, String expected_text) {
		Assert.assertEquals(readText(pure_element), expected_text);
	}
	
	// Assert
	protected void assertEquals(int num_1, int num_2) {
		Assert.assertEquals(num_1, num_2);
	}

	// Assert True
	protected void assertTrue(boolean bool) {
		Assert.assertTrue(bool);
	}

	// Assert True -- bu kisa süreli ariyor elementi.. 1 sn
	protected void assertTrue(String pure_element) {
		Assert.assertTrue(exists(pure_element, 1));
	}

	// Assert Found -- bu uzun süreli ariyor elementi.. mesela 30 sn
	protected void assertFound(String pure_element) {
		Assert.assertTrue(exists(pure_element, 30));
	}
	
	// Assert Not Content
	protected void assertNotContent(String text_1, String text_2) {
		Assert.assertNotEquals(text_1, text_2);
	}

	// Assert Found
	protected void assertFound(String pure_element, int index) {
		try {
			if (iosDriver.findElements(findElements(pure_element, index)).size() == 0) {
				throw new Exception();
			}
		} catch (Exception ex) {
		}
	}

	// Assert Not Found
	protected void assertNotFound(String pure_element) {
		try {
			if (iosDriver.findElements(findElements(pure_element, 0)).size() != 0) {
				throw new Exception();
			}
		} catch (Exception ex) {
		}
	}

	// Assert Not Found
	protected void assertNotFound(String pure_element, int index) {
		try {
			if (iosDriver.findElements(findElements(pure_element, index)).size() != 0) {
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
			iosDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			List<IOSElement> elements = null;
			for (int i = 0; i < second; i++) {
				Thread.sleep(1000);
				try {
					elements = iosDriver.findElements(quickFindElements(pure_element, 0));
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
			iosDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	
	
	// Get Element Size
	protected int getSize(String pure_element, int search_seconds) {
		try {
			iosDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			List<IOSElement> elements = null;
			for (int i = 0; i < search_seconds; i++) {
				Thread.sleep(1000);
				try {
					elements = iosDriver.findElements(quickFindElements(pure_element, 0));
					if (elements.get(0).isDisplayed()) {
						return elements.size();
					}
				} catch (Exception ex) {
					continue;
				}
			}
			System.out.println("element bulunamadi : " + pure_element);
			return 0;

		} catch (Exception e) {
			System.out.println("element bulunamadi : " + pure_element);
			return 0;
		} finally {
			iosDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

//===========================================================================Special Methods



	// Back
	protected void back() {
		// driver.pressKeyCode(AndroidKeyCode.BACK);
		iosDriver.navigate().back();
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

		new TouchAction(iosDriver).press(PointOption.point(firstPointX, firstPointY))
				.waitAction(waitOptions(Duration.ofMillis(dragTimeMS)))
				.moveTo(PointOption.point(secondPointX, secondPointY)).release().perform();
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
	
	protected void waitMilliSec(int milli_second) {
		try {
			TimeUnit.MILLISECONDS.sleep(milli_second);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void setWIFIServiceStatus(boolean status) {
		//bu mantik güzelmis herseyi bunla bulup alabilirsin. guzellll
//		MobileElement element = (MobileElement) driver.findElementByAccessibilityId("SomeAccessibilityID");
//		String tagName = element.getAttribute("content-desc");
		
		swipe(".UIAWindow", 20, iosDriver.manage().window().getSize().height-5, 10, 10, 230);  //Asagidan yukari cekerek paneli acar
		
		if (status) {
			if (getValue("#wifi-button").equals("0")) {
				click("#wifi-button");
			}
		} else {
			if (getValue("#wifi-button").equals("1")) {
				click("#wifi-button");
				if( exists("#Yakınlardaki Wi-Fi Bağlantısı Yarına Kadar Kesiliyor", 2))
					click("#Tamam");
			}
		}
		clickToHomeButton();
	}
	
	protected void setDataServiceStatus(boolean status) {
		//bu mantik güzelmis herseyi bunla bulup alabilirsin. guzellll
//		MobileElement element = (MobileElement) driver.findElementByAccessibilityId("SomeAccessibilityID");
//		String tagName = element.getAttribute("content-desc");
		
		swipe(".UIAWindow", 20, iosDriver.manage().window().getSize().height-5, 10, 10, 230);  //Asagidan yukari cekerek paneli acar
		
		if (status) {
			if (getValue("#cellular-data-button").equals("0")) {
				click("#cellular-data-button");
			}
		} else {
			if (getValue("#cellular-data-button").equals("1")) {
				click("#cellular-data-button");
			}
		}
		clickToHomeButton();
	}
	
	protected void setAirPlaneServiceStatus(boolean status) {
		//bu mantik güzelmis herseyi bunla bulup alabilirsin. guzellll
//		MobileElement element = (MobileElement) driver.findElementByAccessibilityId("SomeAccessibilityID");
//		String tagName = element.getAttribute("content-desc");
		
		swipe(".UIAWindow", 20, iosDriver.manage().window().getSize().height-5, 10, 10, 230);  //Asagidan yukari cekerek paneli acar
		
		if (status) {
			if (getValue("#airplane-mode-button").equals("0")) {
				click("#airplane-mode-button");
			}
		} else {
			if (getValue("#airplane-mode-button").equals("1")) {
				click("#airplane-mode-button");
			}
		}
		clickToHomeButton();
	}
	
	protected void clickToHomeButton() {
//		iosDriver.executeScript("client:client.deviceAction(\"Home\")");
	}
}
