package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import dbmodel.Provider;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Metin.
 */
public class TestBase {
	protected WebDriver driver;
	protected AndroidDriver<AndroidElement> androidDriver;  // bu staticti neden bilmiyorum. bi ara bakarsin.
	protected IOSDriver<IOSElement> iosDriver;
    protected String[][] testParameters;
    protected String queryGetParameters;
    Provider provider = new Provider();
	protected int caseId = 0;
	static ExtentReports extent;
	ExtentHtmlReporter reporter;
	ExtentTest logger;
	protected static Configuration configurationGet;
	public String baseUrl;
	
	public TestBase() {

////		//WEB
//		System.setProperty("platformName", "web");
//		System.setProperty("browserName", "chrome");
//		System.setProperty("appName", "controlcenter");
	
//	Android
//		System.setProperty("platformName", "android");
//		System.setProperty("deviceName", "Emulator_1");
//		System.setProperty("appName", "ride");
//		System.setProperty("startLogin", "no");
		
//		IOS
//		System.setProperty("platformName", "ios");
//		System.setProperty("deviceName", "iPhone5S");
//		System.setProperty("appName", "ride");
//		System.setProperty("startLogin", "no");
		
		//API
//		System.setProperty("platformName", "api");
//		System.setProperty("appName", "operator"); //ride, operator

	}

    @BeforeSuite
    public void beforeSuite() {
    	extent = new ExtentReports();
		reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\reports\\extentReport.html");
		System.out.println("extentReport path: " + reporter.getFilePath());
		extent.attachReporter(reporter);
    }
    
    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
    	testParameters = provider.GetDataTable(queryGetParameters, "automationDB");
    }
    
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) throws Exception {
		try {
    	caseId = Integer.parseInt(method.getName().substring(method.getName().lastIndexOf(".") + 4, method.getName().lastIndexOf(".") + 7));
		
    	System.out.println(">>>>>>>>>>>>>>  TEST METHOD STARTING : " + method.getName());

		configurationGet = Configuration.getInstance();
		
		if (System.getProperty("platformName").equals("web")) {
			if (System.getProperty("browserName").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromeDriver//chromedriver.exe");
				driver = new ChromeDriver(chromeOptions());
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.manage().window().maximize();
//                      driver.manage().window().setPosition(new Point(0, 0));
//                      driver.manage().window().setSize(new Dimension(1920, 1080));
//                      System.out.println("Window width: " + driver.manage().window().getSize().getWidth());
//                      System.out.println("Window height: " + driver.manage().window().getSize().getHeight());
			}
			else if (System.getProperty("browserName").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "//drivers//geckoDriver//geckodriver.exe");
				driver = new FirefoxDriver(firefoxOptions());
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.manage().window().maximize();
			}
			else if (System.getProperty("browserName").equals("ie")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "//drivers//ieDriver//IEDriverServer_x32.exe");
				driver = new InternetExplorerDriver(ieCapabilities());
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				driver.manage().window().maximize();
			}
		}
		else if (System.getProperty("platformName").equals("android")) {

        String device_udid = configurationGet.device_udid();
        String device_name = configurationGet.device_name();
        String platform_version = configurationGet.platform_version();
        String appium_server = configurationGet.appium_server();
        String app_package = configurationGet.app_package();
        String app_activity = configurationGet.app_activity();

        DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_version);
		capabilities.setCapability(MobileCapabilityType.UDID, device_udid);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, app_package);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, app_activity);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		
		androidDriver = new AndroidDriver<AndroidElement>(new URL(appium_server), capabilities);
		androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//açılırken telefonu sifirlar (lokasyon)
		androidDriver.setLocation(new Location(41.006405, 29.074996, 1)); //ofis
		
		}
		else if (System.getProperty("platformName").equals("ios")) {
			 String device_udid = configurationGet.device_udid();
		        String device_name = configurationGet.device_name();
		        String platform_version = configurationGet.platform_version();
		        String automation_name = configurationGet.automation_name();
		        String device_bundle_id = configurationGet.ipa_bundle_id();
		        String appium_server = configurationGet.appium_server();
		        String ipa_folder = configurationGet.ipa_folder();
		        String ipa_file = configurationGet.ipa_file();
				
		        DesiredCapabilities capabilities = new DesiredCapabilities();// SIKINTI OLURSA BUNU IFLERIN DISINA AL OYLE DENE..
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_version);
				capabilities.setCapability(MobileCapabilityType.UDID, device_udid);
				capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, device_bundle_id);
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
				capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automation_name);
				capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
				iosDriver = new IOSDriver<IOSElement>(new URL(appium_server), capabilities);
				iosDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//açılırken telefonun lokasyonunu sifirlar
				iosDriver.setLocation(new Location(41.006405, 29.074996, 1)); //ofis    BELKI BUNU BI ARA EKLERSIN CONFIGE
		}
			logger = extent.createTest(method.getName());
			logger.info("Driver has been initialized and the test has started.");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
    }
    
    /**
     * Run After each test method
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
		String temp = null;

		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("*******************************");
			System.out.println("TEST FAILURE || " + result.getInstanceName() + "." + result.getName());
			System.out.println("*******************************");
			System.out.println("Error : " + result.getThrowable().getMessage() + " \n\n");
			
			try {
			if (System.getProperty("platformName").equals("web")) {
				temp = ExtentReportUtilities.getScreenshot(driver);
				logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			} else if (System.getProperty("platformName").equals("android")) {
				temp = ExtentReportUtilities.getScreenshot(androidDriver);
				logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			} else if (System.getProperty("platformName").equals("ios")) {
				temp = ExtentReportUtilities.getScreenshot(iosDriver);
				logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			}else if (System.getProperty("platformName").equals("api")) {
				logger.fail(result.getThrowable().getMessage());
			}			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			extent.flush();
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.info("Test succeeded.");
			System.out.println("*******************************");
			System.out.println("TEST SUCCESS || " + result.getInstanceName() + "." + result.getName());
			System.out.println("******************************* \n\n");
		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("!!!!! ERROR === " + result.getThrowable().getMessage());
			try {
			if (System.getProperty("platformName").equals("web")) {
				temp = ExtentReportUtilities.getScreenshot(driver);
				logger.skip(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			} else if (System.getProperty("platformName").equals("android")) {
				temp = ExtentReportUtilities.getScreenshot(androidDriver);
				logger.skip(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			} else if (System.getProperty("platformName").equals("ios")) {
				temp = ExtentReportUtilities.getScreenshot(iosDriver);
				logger.skip(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			}else if (System.getProperty("platformName").equals("api")) {
				logger.skip(result.getThrowable().getMessage());
			}			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(result.getThrowable().getMessage());
			System.out.println("========================================================================");
			System.out.println("*******************************************");
			System.out.println(">>>>>>>>>>>>>>>>>  Test will be run again..  <<<<<<<<<<<<<<<<<<<<<<");
			System.out.println("*******************************************");
			System.out.println("========================================================================");
		}
		
		if (System.getProperty("platformName").equals("web")) {
			driver.quit();
    	} else if (System.getProperty("platformName").equals("android")) {
			androidDriver.quit();
		} else if (System.getProperty("platformName").equals("ios")) {
			iosDriver.quit();
		}

    }
    
	@AfterSuite
	public void afterSuite() {
		extent.flush();
	}
	
	
	private ChromeOptions chromeOptions() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--test-type");
		chromeOptions.addArguments("--disable-popup-blocking");
		chromeOptions.addArguments("--ignore-certificate-errors");
		chromeOptions.addArguments("--disable-translate");
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--disable-notifications");
		return chromeOptions;
	}

	private FirefoxOptions firefoxOptions() {
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.addArguments("--test-type");
		firefoxOptions.addArguments("--disable-popup-blocking");
		firefoxOptions.addArguments("--ignore-certificate-errors");
		firefoxOptions.addArguments("--disable-translate");
		firefoxOptions.addArguments("--start-maximized");
		firefoxOptions.addArguments("--disable-notifications");
		return firefoxOptions;
	}

	private InternetExplorerOptions ieCapabilities() {
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.setCapability("nativeEvents", false);
		options.setCapability("unexpectedAlertBehaviour", "accept");
		// options.setCapability("ignoreProtectedModeSettings", true);
		options.setCapability("disable-popup-blocking", true);
		options.setCapability("enablePersistentHover", true);
		options.setCapability("ignoreZoomSetting", true);
		return options;
	}
	
	////////////////////////////////////////////////////////////BI ARA BASKA CLASS YAPARSIN
public String get_token(int case_id) throws Exception{
		
		String endPoint = "";
		String accessToken = "";
		String otp = "";
		RestAssured.baseURI = baseUrl;

		if (System.getProperty("appName").equals("ride")) {
			endPoint = "/v"+ testParameters[15][4] +"/dispatch/" + testParameters[15][1];
			otp = provider.ExecuteScalar("select sms_code from customers where mobile_phone ='" + testParameters[case_id][6] + "';", "martiDB");
			Response response = RestAssured
					.given()
					.header("timezone", "3")
					.contentType("application/json")
					.body("{ \"smsCode\": \""+ otp +"\", \"mobilePhoneCountryCode\": \"90\", \"mobilePhone\": \"" + testParameters[case_id][6] + "\" }")
					.when()
					.post(endPoint)
					.then()
					.extract()
					.response();
			accessToken = response.path("data.accessToken");
		}
		else if (System.getProperty("appName").equals("operator")) {
			endPoint = "/v"+ testParameters[59][4] +"/dispatch/" + testParameters[59][1];
			otp = provider.ExecuteScalar("select otp_token from users where mobile_phone = '" + testParameters[case_id][6] + "';", "martiDB");
			Response response = RestAssured
					.given()
					.header("timezone", "3")
					.contentType("application/json")
					.body("{ \"mobilePhoneNumber\": \""+ testParameters[case_id][6] +"\", \"token\": \""+ otp +"\" }")
					.when()
					.post(endPoint)
					.then()
					.extract()
					.response();
				System.out.println(response.getBody().asString());
				accessToken = response.path("data.accessToken");
		}

		
			return accessToken;
	}
	
	// dynamic_parameter alanı "NULL" değilse parametreler dinamik olarak geliyor demektir.
	protected String run_ws(int case_id, String access_token, String dynamic_parameter) {
		
//		String tcId 			= testParameters[case_id][0];
		String endPoint			= testParameters[case_id][1];
//		String type				= testParameters[case_id][2];
		String statusCode 		= testParameters[case_id][3];
		String version 			= testParameters[case_id][4];
		String inputParameters	= testParameters[case_id][5];

		
		//////////set parameters////////////////
		//*
		endPoint = "/v"+ version +"/dispatch/" + endPoint;
		//*
		if (inputParameters == null) {
			inputParameters = "";
		}
		
		if (dynamic_parameter != null) {
			inputParameters = dynamic_parameter;
		}
		
		//////////////////////////--
		
		RestAssured.baseURI = baseUrl;
		Response response = RestAssured
				.given()
				.header("X-ACCESS-TOKEN", access_token)
//				.header("User-Agent", "Marti/1.0 (com.martitech.marti; build:9; iOS 12.1.2) Alamofire/4.8.0")  // silersin
				.header("timezone", "3")
				.contentType("application/json;charset=utf-8")
				.body(inputParameters)
				.when()
				.post(endPoint)
				.then()
				.statusCode(Integer.parseInt(statusCode))
//				.body("isSuccess", equalTo(true))   // e bunu acarsin. bu onemli..
//				.body("message", equalTo("SUCCESS"))
				.extract()
				.response();
			
		//gelen response daki "message" alanını kontrol eder. true = SUCCESS
		assertEquals(response.getBody().asString().substring(response.getBody().asString().indexOf("message") + 9, response.getBody().asString().indexOf(",", response.getBody().asString().indexOf("message"))).replace("\"", ""), "SUCCESS");

		//kapatirsin yayinlamadan once
		System.out.println("STARTING -- EP_NAME: " + endPoint + " --- RESPONSE: " + response.getBody().asString() + "\n--");
		
		// *******************RESPONSE CHECK************************
		for (int i = 8; i < testParameters[case_id].length; i++) {
			if (testParameters[case_id][i] != null) {
				assertTrue(response.getBody().asString().contains(testParameters[case_id][i]));
			}
		}
		
		return response.getBody().asString();
		
	}
}