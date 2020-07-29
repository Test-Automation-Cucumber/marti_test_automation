package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import dbmodel.Provider;
import dbmodel.DataPreparation.TestDevice;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Metin.
 */
public class TestBase {
	protected static AndroidDriver<AndroidElement> androidDriver;
    protected String[][] ride_app_test_parameters;
	Provider provider = new Provider();
	protected int caseId = 0;
	TestDevice testDevice = new TestDevice();
//	ExtentReports extent;
//	ExtentHtmlReporter reporter;
//	ExtentTest logger;
	
	public TestBase() {
		ride_app_test_parameters = provider.GetDataTable(
				"select * from ride_app_test_parameters order by tc_id;", "automationDB");
	}

    @BeforeSuite
    public void beforeSuite() {
//		System.out.println("emreeee " + System.getenv("DEVICEFARM_LOG_DIR"));
//    	extent = new ExtentReports();
//		reporter = new ExtentHtmlReporter(System.getenv("DEVICEFARM_LOG_DIR") + "\\extentReport.html");
//		System.out.println("extenrReport path: " + reporter.getFilePath());
//		extent.attachReporter(reporter);
    }
    
    /**
     * Run before each method
     * @throws MalformedURLException
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) throws Exception {
		caseId = Integer.parseInt(method.getName().substring(method.getName().lastIndexOf(".") + 4,method.getName().lastIndexOf(".") + 7));
		
    	System.out.println(">>>>>>>>>>>>>>  TEST METHOD STARTING : " + method.getName());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        URL appiumURL = new URL("http://127.0.0.1:4723/wd/hub");
		capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);       
		
//      device_name:  AOSP_on_IA_Emulator
//      UDID:  emulator-5554
        //--huawei device
//      device_name:  RNE-L01
//      UDID:  2VN5T18607003425
        //--samsung device
//        5210d014508dc3e1
        //name=SM-A520F
        
////      DEBUG
//		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AOSP_on_IA_Emulator");
//		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
//		capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
//		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.martitech.marti.dev");
//		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.martitech.marti.ui.activities.splash.Splash");
//		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
////		DEBUG--
		
		
		androidDriver = new AndroidDriver<AndroidElement>(appiumURL, capabilities);
		androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//açılırken telefonu sifirlar (lokasyon)
		androidDriver.setLocation(new Location(41.006405, 29.074996, 1)); //ofis
    }
    
    /**
     * Run After each test method
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result){
//		String temp = null;

		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("*******************************");
			System.out.println("TEST FAILURE || " + result.getInstanceName() + "." + result.getName());
			System.out.println("******************************* \n\n");
			System.out.println("Error : " + result.getThrowable().getMessage());

//			temp = ExtentReportUtilities.getScreenshot(androidDriver);
			//logger.fail("error : " + result.getThrowable().getMessage());  ////////////////////extendi acicagin zaman bunu acmayi unutmas
//					MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

//			if (ride_app_test_parameters[caseId][1] != "0") {//bunu db de browser falan ekledin onun için koymuştum. tekrar dene
//				temp = ExtentReportUtilities.getScreenshot(driver);
//				logger.fail("error : " + result.getThrowable().getMessage(),
//						MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
//			}
//			extent.flush();  BU NEDEN BURDA VAR? EXTENT RAPORLA ALAKALI SORUN CIKARSA BUNU ACIP DENERSIN
		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			logger.info("Test succeeded.");
			System.out.println("*******************************");
			System.out.println("TEST SUCCESS || " + result.getInstanceName() + "." + result.getName());
			System.out.println("******************************* \n\n");
		}

		androidDriver.quit();
//		if (driver == null)
//			driver.quit();
    }
    
	@AfterSuite
	public void afterSuite() {
//		extent.flush();
	}
	
//    /**
//     * Take Screenshot
//     * @param name file name
//     * @return true if successful
//     */
//    private boolean takeScreenshot(final String name) {
//        String screenshotDirectory = System.getProperty("appium.screenshots.dir");
//        File screenshot = driver.getScreenshotAs(OutputType.FILE);
//        return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
//    }
	
}