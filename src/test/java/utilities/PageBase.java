package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PageBase {

	private WebDriver driver;
	private WebDriverWait wait;
	private Configuration configuration;
	private JavascriptExecutor js;

	public PageBase(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, 60);
		this.js = (JavascriptExecutor) driver;
		this.configuration = Configuration.getInstance();
	}

	private void ajaxComplete() {
		js.executeScript("var callback = arguments[arguments.length - 1];" + "var xhr = new XMLHttpRequest();"
				+ "xhr.open('GET', '/Ajax_call', true);" + "xhr.onreadystatechange = function() {"
				+ "  if (xhr.readyState == 4) {" + "    callback(xhr.responseText);" + "  }" + "};" + "xhr.send();");
	}

	private void waitForJQueryLoad() {
		try {
			ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) this.driver)
					.executeScript("return jQuery.active") == 0);

			boolean jqueryReady = (Boolean) js.executeScript("return jQuery.active==0");

			if (!jqueryReady) {
				wait.until(jQueryLoad);
			}
		} catch (WebDriverException ignored) {
		}
	}

	private void waitForAngularLoad() {
		String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";
		angularLoads(angularReadyScript);
	}

	private void waitUntilJSReady() {
		try {
			ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) this.driver)
					.executeScript("return document.readyState").toString().equals("complete");

			boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

			if (!jsReady) {
				wait.until(jsLoad);
			}
		} catch (WebDriverException ignored) {
		}
	}

	private void waitUntilJQueryReady() {
		Boolean jQueryDefined = (Boolean) js.executeScript("return typeof jQuery != 'undefined'");
		if (jQueryDefined) {
			poll(20);

			waitForJQueryLoad();

			poll(20);
		}
	}

	private void waitUntilAngularReady() {
		try {
			Boolean angularUnDefined = (Boolean) js.executeScript("return window.angular === undefined");
			if (!angularUnDefined) {
				Boolean angularInjectorUnDefined = (Boolean) js
						.executeScript("return angular.element(document).injector() === undefined");
				if (!angularInjectorUnDefined) {
					poll(20);

					waitForAngularLoad();

					poll(20);
				}
			}
		} catch (WebDriverException ignored) {
		}
	}

	private void waitUntilAngular5Ready() {
		try {
			Object angular5Check = js.executeScript("return getAllAngularRootElements()[0].attributes['ng-version']");
			if (angular5Check != null) {
				Boolean angularPageLoaded = (Boolean) js
						.executeScript("return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1");
				if (!angularPageLoaded) {
					poll(20);

					waitForAngular5Load();

					poll(20);
				}
			}
		} catch (WebDriverException ignored) {
		}
	}

	private void waitForAngular5Load() {
		String angularReadyScript = "return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1";
		angularLoads(angularReadyScript);
	}

	private void angularLoads(String angularReadyScript) {
		try {
			ExpectedCondition<Boolean> angularLoad = driver -> Boolean
					.valueOf(((JavascriptExecutor) driver).executeScript(angularReadyScript).toString());

			boolean angularReady = Boolean.valueOf(js.executeScript(angularReadyScript).toString());

			if (!angularReady) {
				wait.until(angularLoad);
			}
		} catch (WebDriverException ignored) {
		}
	}

	public void waitAllRequest() {
		waitUntilJSReady();
		ajaxComplete();
		waitUntilJQueryReady();
		waitUntilAngularReady();
		waitUntilAngular5Ready();
	}

	/**
	 * Method to make sure a specific element has loaded on the page
	 *
	 * @param by
	 * @param expected
	 */
	public void waitForElementAreComplete(By by, int expected) {
		ExpectedCondition<Boolean> angularLoad = driver -> {
			int loadingElements = this.driver.findElements(by).size();
			return loadingElements >= expected;
		};
		wait.until(angularLoad);
	}

	/**
	 * Waits for the elements animation to be completed
	 * 
	 * @param css
	 */
	public void waitForAnimationToComplete(String css) {
		ExpectedCondition<Boolean> angularLoad = driver -> {
			int loadingElements = this.driver.findElements(By.cssSelector(css)).size();
			return loadingElements == 0;
		};
		wait.until(angularLoad);
	}

	private void poll(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Wait Wrapper Method
	protected void waitVisibility(WebElement element) {
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOf(element));
	}// Wait Wrapper Method

	protected void waitVisibility(By elementBy) {
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
	}

	// Wait Wrapper Method
	protected void waitClickable(By elementBy) {
		highlightElement(driver.findElement(elementBy));
		wait.until(ExpectedConditions.elementToBeClickable(elementBy));
	}

	protected void waitClickable(WebElement element) {
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		highlightElement(element);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected void waitForAjax() {
		new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				JavascriptExecutor js = (JavascriptExecutor) d;
				return (Boolean) js.executeScript("return jQuery.active == 0");
			}
		});
	}
	
	protected void wait(int second) {
		try {
			TimeUnit.SECONDS.sleep(second);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
				"color: red; border: 1px dashed red;");
	}

	protected void navigateToURL(String URL) {
		driver.navigate().to(URL);
	}
	
	protected void back() {
		driver.navigate().back();
	}

	// Click Method
	protected void click(By elementBy) {
		waitAllRequest();
		waitClickable(elementBy);
		driver.findElement(elementBy).click();
	}

	// Click Method
	protected void click(WebElement element) {
		waitAllRequest();
		waitClickable(element);
		element.click();
	}

	// Click Method
	protected void click(WebElement element, String tagname, int index) {
		waitAllRequest();
		List<WebElement> tableElements = element.findElements(By.tagName(tagname));
		element = tableElements.get(index);
		waitClickable(element);
		element.click();
	}

	// Click Index Element
	/**
	 * @param elementBy
	 * @param index     -- aynı elementten başka varsa index değerini gönder.
	 */
	protected void click(By elementBy, int index) {
		waitAllRequest();
		List<WebElement> list = driver.findElements(elementBy);
		WebElement element = list.get(index);
		waitClickable(element);
		element.click();
	}

	// Click Method
	protected void clickToAction(By elementBy) {
		waitAllRequest();
		waitClickable(elementBy);
		WebElement element = driver.findElement(elementBy);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}

	// Click Method
	protected void clickToAction(By elementBy, int index) {
		waitAllRequest();
		List<WebElement> list = driver.findElements(elementBy);
		WebElement element = list.get(index);
		waitClickable(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}

	// Click Method
	protected void clickToAction(WebElement element) {
		waitAllRequest();
		waitClickable(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}

//	protected void selectOption(By elementBy) {
//		waitAllRequest();
//		List<WebElement> list = driver.findElements(elementBy);
//		//WebElement element = list.get(0);
//		waitClickable(elementBy);
//		Select select = new Select(driver.findElement(elementBy));
//		select.by
//	}


	///////////////////////////////////////////////////// emre////////////////////////////////////////

	protected void sendHotKey(String text) {
		Actions keyAction = new Actions(driver);
		keyAction.sendKeys(text).perform();
	}

	// Send Key
	protected void sendHotKeyToElement(By elementBy, String text) {
		WebElement element = driver.findElement(elementBy);
		waitClickable(element);
		element.sendKeys(text);
	}

	// Write Text
	protected void writeText(By elementBy, String text) {
		waitClickable(elementBy);
		driver.findElement(elementBy).clear();
		driver.findElement(elementBy).sendKeys(text);
	}
	
	// Write Text
	protected void writeText(WebElement element, String text) {
		waitClickable(element);
	//	driver.findElement(elementBy).clear();
		element.sendKeys(text);
	}

	// Write Text Element
	/**
	 * @param elementBy
	 * @param index     -- aynı elementten başka varsa index değerini gönder.
	 */
	protected void writeText(By elementBy, int index, String text) {
		List<WebElement> list = driver.findElements(elementBy);
		WebElement element = list.get(index);
		waitClickable(element);
		element.clear();
		element.sendKeys(text);
	}
	
	protected void writeTextThenEnter(By elementBy, String text) {
		List<WebElement> list = driver.findElements(elementBy);
		WebElement element = list.get(0);
		waitClickable(element);
		element.clear();
		element.sendKeys(text);
		element.sendKeys(Keys.RETURN);
	}
	
	protected void writeTextThenEnter(By elementBy, int index, String text) {
		List<WebElement> list = driver.findElements(elementBy);
		WebElement element = list.get(index);
		waitClickable(element);
		element.clear();
		element.sendKeys(text);
		element.sendKeys(Keys.RETURN);
	}

	// Read Text
	/**
	 * @param elementBy
	 * @param index     -- aynı elementten başka varsa index değerini gönder.
	 */
	// Read Text
	protected String readText(By elementBy, int index) {
		List<WebElement> list = driver.findElements(elementBy);
		WebElement element = list.get(index);
		waitClickable(element);
		return element.getText();
	}

	// Read Text
	protected String readText(By elementBy) {
		waitClickable(elementBy);
		return driver.findElement(elementBy).getText();
	}

	// Read Text
	protected String readText(WebElement element) {
		waitClickable(element);
		return element.getText();
	}

	// Mouse Over
	protected void mouseOver(By elementBy) {
		waitClickable(elementBy);
		Actions myAction = new Actions(driver);
		myAction.moveToElement(driver.findElement(elementBy)).build().perform();
	}

	// Assert
	protected void assertEquals(By elementBy, String expected_text) {
		waitClickable(elementBy);
		Assert.assertEquals(readText(elementBy).trim(), expected_text);
	}
	
	// Assert
	protected void assertEquals(WebElement element, String expected_text) {
		waitClickable(element);
		Assert.assertEquals(readText(element), expected_text);
	}
	
	// Assert True
	protected void assertTrue(boolean bool) {
		Assert.assertTrue(bool);
	}

	// Assert True -- bu kisa süreli ariyor elementi.. 1 sn
	protected void assertTrue(By elementBy) {
		Assert.assertTrue(exists(elementBy, 1));
	}

	// Assert Found -- bu uzun süreli ariyor elementi..
	protected void assertFound(By elementBy) {
		Assert.assertTrue(exists(elementBy, 60));
	}

	// Assert Not Found
	protected void assertNotFound(By elementBy) {
		try {
			if (driver.findElements(elementBy).size() != 0) {
				throw new Exception();
			}
		} catch (Exception ex) {
		}
	}
	
	// Verify Element
	protected void verifyElement(By elementBy) {
		Assert.assertEquals(true, driver.findElement(elementBy).isDisplayed());
	}
	
	// Get Element Size
	protected int getSize(By elementBy) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			List<WebElement> elements = driver.findElements(elementBy);
			return elements.size();
		} catch (Exception ex) {
			return 0;
		} finally {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
	}
	
//	protected boolean elementExists(By elementBy, int second) {
//		try {
//			List<WebElement> elements;
//			for (int i = 0; i < second; i++) {
//				Thread.sleep(1000);
//				elements = driver.findElements(elementBy);
//				if (elements.get(0).isDisplayed()) {
//					return true;
//				}
//			}
//			return false;
//
//		} catch (Exception e) {
//			return false;
//		}
//	}
	
	
	// exists
	/**
	 * @param elementBy
	 * @param second    -- set seconds to wait element in page
	 * @return returns true or false regarding to element existing
	 */
	protected boolean exists(By elementBy, int second) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			List<WebElement> elements = null;
			for (int i = 0; i < second; i++) {
				Thread.sleep(1000);
				try {
					elements = driver.findElements(elementBy);
					if (elements.get(0).isDisplayed()) {
						return true;
					}
				} catch (Exception ex) {
					continue;
				}
			}
			return false;

		} catch (Exception e) {
			return false;
		} finally {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
	}

	protected void goToEndOfPage() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	protected void goToTopOfPage() {
		js.executeScript("window.scrollTo(0, 0)");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected String executeJS(String txt) {
		wait(1);
		return (String) js.executeScript(txt);
	}

	// getRowCountOfList
	protected int getCountOfList(By elementBy, String children_tag_name) {
		WebElement baseList = driver.findElement(elementBy);
		List<WebElement> tableRows = baseList.findElements(By.tagName(children_tag_name));
		return tableRows.size();
	}

	// getRowCountOfList
	protected int getCountOfList(WebElement element, String children_tag_name) {
		List<WebElement> tableRows = element.findElements(By.tagName(children_tag_name));
		return tableRows.size();
	}

	// Go to Homepage
	protected void goToWebPage(String base_url) {
		driver.get(base_url);
	}

	// checked Method
	protected void checked(By elementBy) {
		waitClickable(elementBy);
		if (!driver.findElement(elementBy).isSelected()) {
			driver.findElement(elementBy).click();
		}
	}

	// checked Method
	protected void checked(By elementBy, int index) {
		List<WebElement> list = driver.findElements(elementBy);
		WebElement element = list.get(index);
		if (!element.isSelected()) {
			highlightElement(element);
			element.click();
		}
	}

	// UNchecked Method
	protected void unchecked(By elementBy, int index) {
		List<WebElement> list = driver.findElements(elementBy);
		WebElement element = list.get(index);
		if (element.isSelected()) {
			highlightElement(element);
			element.click();
		}
	}

	// UNchecked Method
	protected void unchecked(By elementBy) {
		waitClickable(elementBy);
		if (driver.findElement(elementBy).isSelected()) {
			driver.findElement(elementBy).click();
		}
	}

	// Wait Loading Image
//	protected void waitLoadingImg(By elementBy) {
//		try {
//			waitForPageToLoad();
//			Thread.sleep(1500);
//
//			for (int i = 0; i < 60; i++) {
//				// if
//				// (!driver.findElement(loadingImageBy).getCssValue("visibility").equals("hidden"))
//				if (!driver.findElement(elementBy).getAttribute("display").equals("none")) {
//					Thread.sleep(1500);
//				} else {
//					break;
//				}
//			}
//		}catch (Exception ex) {
//			}
//			
//		}

	// Wait Loading Image
	protected void waitLoadingTableImg() {
		try {
			Thread.sleep(1500);

			for (int i = 0; i < 60; i++) {
				// if
				// if(!driver.findElement(elementBy).getCssValue("opacity").equals("1"))
				if (driver.findElement(By.cssSelector("div.dx-loadpanel-content-wrapper")).isDisplayed()) {
					Thread.sleep(1000);
				} else {
					break;
				}
			}
		} catch (Exception ex) {
		}
	}

	protected void waitVolatileElement(By elementBy, int second) {

		wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
//		try {
//			List<WebElement> elements;
//			for (int i = 0; i < second; i++) {
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				elements = driver.findElements(elementBy);
//				if (elements.size() < 1)
//					return;
//				else if (i == second - 1) {
//					try {
//						throw new Exception("kaybolması beklenen element ekranda görünmeye devam ediyor.");
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					return;
//				}
//			}
//		} catch (Exception ex) {
//
//		}
	}

	// Select html <li> Item
	protected List<WebElement> selectiItem(WebElement ItemsUL, String tagname) {
		List<WebElement> ItemsList = ItemsUL.findElements(By.tagName(tagname));
		return ItemsList;
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
	
	protected WebElement getIndexedElement(By elementBy, int index) {
		WebElement element = driver.findElements(elementBy).get(index);
		return element;
	}

	// Get Child Element
	/**
	 * @param elementBy -- By of main element
	 * @param tagName   -- main elementin 1. seviye altında aranacak child tag adı
	 *                  örnek : li tagı.
	 * @param index     -- gidilecek olan child tagın sırasını giriniz. örnek :
	 *                  (elementBy= XYZ, tagName=li, index=5) = XYZ elementinin
	 *                  altındaki 5. li tagının By değerini döndürür.
	 */
	protected WebElement getChild(By elementBy, String tagName, int index) {
		WebElement element = driver.findElement(elementBy);
		List<WebElement> tableRows = element.findElements(By.tagName(tagName));
		return tableRows.get(index);
	}
	
	

	// Get Child Element
	/**
	 * @param elementBy -- main element
	 * @param tagName   -- main elementin 1. seviye altında aranacak child tag adı
	 *                  örnek : li tagı.
	 * @param index     -- gidilecek olan child tagın sırasını giriniz. örnek :
	 *                  (elementBy= XYZ, tagName=li, index=5) = XYZ elementinin
	 *                  altındaki 5. li tagının By değerini döndürür.
	 */
	protected WebElement getChild(WebElement element, String tagName, int index) {
		List<WebElement> tableRows = element.findElements(By.tagName(tagName));
		return tableRows.get(index);
	}

	protected void removeElementJs(String type, String value) {
		wait(1);
		if (type == "id")
			js.executeScript("return document.getElementById('" + value + "').remove();");
		else if (type == "class")
			js.executeScript("return document.getElementsByClassName('" + value + "')[0].remove();");
	}
	
	protected void clickElementJs(String type, String value) {
		wait(1);
		if (type == "id")
			js.executeScript("return document.getElementById('" + value + "').click();");
		else if (type == "class")
			js.executeScript("return document.getElementsByClassName('" + value + "')[0].click();");
		else if (type == "name")
			js.executeScript("return document.getElementsByName('" + value + "')[0].click();");
		
	}
	
	protected void waitSweetAlert() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.swal2-header")));
	}
	
	// Get Attiribute 
	protected String getAttiribute(By elementBy) {
		waitAllRequest();
		return driver.findElement(elementBy).getAttribute("value");
		}
	
	
	// Switch Tab Page
	protected void switchToNewTab(boolean kill_old_tab) {
		waitAllRequest();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		waitAllRequest();
		if (kill_old_tab) {
			driver.switchTo().window(tabs.get(0));
			driver.close();
			driver.switchTo().window(tabs.get(1));
		}


		}
	
	
	//////////
	protected void clickElementJs(String element_attribute, int index) {
		waitAllRequest();
		wait(1);
		js.executeScript("return document.querySelectorAll('" + element_attribute + "')[" + index + "].click();");
	}
	
	protected void writeElementJs(String element_attribute, int index, String value) {
		waitAllRequest();
		wait(1);
		js.executeScript("return document.querySelectorAll('" + element_attribute + "')[" + index + "].value ='" + value + "';");

	}
	
	protected void readElementJs(String type, String element_attribute , int index) {
		waitAllRequest();
		wait(1);
		js.executeScript("return document.querySelectorAll('" + element_attribute + "')[" + index + "].value;");
		
	}
	//////////////
	
	
	
}
