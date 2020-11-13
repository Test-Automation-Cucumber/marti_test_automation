package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

public class Configuration {

	private static Configuration instance;
	private Properties configProps = new Properties();

	private String device_udid;
	private String device_name;
	private String platform_version;
	private String apk_folder;
	private String apk_file;
	private String app_package;
	private String app_activity;
	private String appium_server;
    private String automation_name;
    private String ipa_bundle_id;
    private String ipa_folder;
    private String ipa_file;
    private String site_url;

    public static Configuration getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    private static synchronized void createInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
    }

	private Configuration() {

		InputStream is = null;
		try {
			
			if (System.getProperty("platformName").equals("android")) {
			
			//DEVICES
			if (System.getProperty("deviceName").equals("device_vestel_5000_dual")) 
				is = ClassLoader.getSystemResourceAsStream("devices\\android\\device_vestel_5000_dual.property");
			else if (System.getProperty("deviceName").equals("HTC_One_M8s")) 
				is = ClassLoader.getSystemResourceAsStream("devices\\android\\HTC_One_M8s.property");
			else if (System.getProperty("deviceName").equals("RNE-L01")) 
				is = ClassLoader.getSystemResourceAsStream("devices\\android\\RNE-L01.property");
			else if (System.getProperty("deviceName").equals("Emulator_1")) 
				is = ClassLoader.getSystemResourceAsStream("devices\\android\\Emulator_1.property");
			else if (System.getProperty("deviceName").equals("SM-A520F")) 
				is = ClassLoader.getSystemResourceAsStream("devices\\android\\SM-A520F.property");		
			// device properties
			Reader reader = new InputStreamReader(is, "UTF-8");
			configProps.load(reader);
			this.device_udid = configProps.getProperty("device.udid");
			this.device_name = configProps.getProperty("device.name");
			this.platform_version = configProps.getProperty("platform.version");
			this.appium_server = configProps.getProperty("appium.server");
			
			
			//APP
			if (System.getProperty("appName").equals("ride")) {
				is = ClassLoader.getSystemResourceAsStream("apps\\android\\ride.property");}
			else if (System.getProperty("appName").equals("slack")) {
				is = ClassLoader.getSystemResourceAsStream("apps\\android\\slack.property");}
			else if (System.getProperty("appName").equals("security")) {
				is = ClassLoader.getSystemResourceAsStream("apps\\android\\security.property");}
			// app properties
			reader = new InputStreamReader(is, "UTF-8");
			configProps.load(reader);
			this.app_package = configProps.getProperty("app.package");
			this.app_activity = configProps.getProperty("app.activity");
			}
			
			else if(System.getProperty("platformName").equals("ios")) {
				//DEVICES
				if (System.getProperty("deviceName").equals("iPhone5S")) 
					is = ClassLoader.getSystemResourceAsStream("devices\\ios\\iPhone5S.property");
				else if (System.getProperty("deviceName").equals("xsmax"))
					is = ClassLoader.getSystemResourceAsStream("devices\\ios\\xsmax.property");
				else if (System.getProperty("deviceName").equals("iPhone7"))
					is = ClassLoader.getSystemResourceAsStream("devices\\ios\\iPhone7.property");
				
				// device properties
				Reader reader = new InputStreamReader(is, "UTF-8");
				configProps.load(reader);
				this.device_udid = configProps.getProperty("device.udid");
				this.device_name = configProps.getProperty("device.name");
				this.platform_version = configProps.getProperty("platform.version");
				this.automation_name = configProps.getProperty("automation.name");
				this.appium_server = configProps.getProperty("appium.server");
				
				//APP
				if (System.getProperty("appName").equals("ride"))
					is = ClassLoader.getSystemResourceAsStream("apps\\ios\\ride.property");
				else if (System.getProperty("appName").equals("healthchecker"))
					is = ClassLoader.getSystemResourceAsStream("apps\\ios\\healthchecker.property");
				else if (System.getProperty("appName").equals("mobileservice"))
					is = ClassLoader.getSystemResourceAsStream("apps\\ios\\mobileservice.property");
				else if (System.getProperty("appName").equals("rebalancer"))
					is = ClassLoader.getSystemResourceAsStream("apps\\ios\\rebalancer.property");
				else if (System.getProperty("appName").equals("security"))
					is = ClassLoader.getSystemResourceAsStream("apps\\ios\\security.property");
				else if (System.getProperty("appName").equals("healthchecker"))
					is = ClassLoader.getSystemResourceAsStream("apps\\ios\\swapper.property");
				else if (System.getProperty("appName").equals("healthchecker"))
					is = ClassLoader.getSystemResourceAsStream("apps\\ios\\technicalservice.property");
				else if (System.getProperty("appName").equals("healthchecker"))
					is = ClassLoader.getSystemResourceAsStream("apps\\ios\\warehouse.property");
				
				
				// app properties
				reader = new InputStreamReader(is, "UTF-8");
				configProps.load(reader);
				this.ipa_bundle_id = configProps.getProperty("ipa.bundle_id");
				this.ipa_folder = configProps.getProperty("ipa.folder");
				this.ipa_file = configProps.getProperty("ipa.file");
			}
			
			else if (System.getProperty("platformName").equals("web")) {
				if (System.getProperty("appName").equals("controlcenter")) {
					is = ClassLoader.getSystemResourceAsStream("apps\\web\\staging_cc.property");
				}
				// app properties
				Reader reader = new InputStreamReader(is, "UTF-8");
				configProps.load(reader);
				this.site_url = configProps.getProperty("site.url");

			}
			
		}
		
		 catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String device_udid() {
		return device_udid;
	}

	public String device_name() {
		return device_name;
	}

	public String platform_version() {
		return platform_version;
	}

	public String apk_folder() {
		return apk_folder;
	}

	public String apk_file() {
		return apk_file;
	}

	public String app_package() {
		return app_package;
	}

	public String app_activity() {
		return app_activity;
	}

	public String appium_server() {
		return appium_server;
	}
	public String automation_name() {
		return automation_name;
	}
	public String ipa_bundle_id() {
		return ipa_bundle_id;
	}
	public String ipa_folder() {
		return ipa_folder;
	}
	public String ipa_file() {
		return ipa_file;
	}
	public String site_url() {
		return site_url;
	}

	
}