package com.setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DeviceSetup extends BaseTest {

    //String device = System.getenv("device");
    //if(device != null && device.equalsIgnoreCase("Android")){

    static AppiumDriver prepareGalaxyA8() throws MalformedURLException {

        File currDir = new File("");
        String path = currDir.getAbsolutePath();
        System.out.println("Project Path: " + path);

        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid","5200a11fee23b461");
        capabilities.setCapability("deviceName","Galaxy A8 (2018)");
        capabilities.setCapability("deviceVersion", "7.7.1");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage", "com.google.android.gm");
        capabilities.setCapability("appActivity","com.google.android.gm.ConversationListActivityGmail"); // This is Launcher activity of your app (you can get it from apk info app)
        File file = new File(path + "\\apk\\gmail-8-8-12-209077217-release.apk");
        capabilities.setCapability("app", file.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout( 10, TimeUnit.SECONDS );
        return driver;
    }

    static AppiumDriver prepareGalaxyJ1() throws MalformedURLException {

        File currDir = new File("");
        String path = currDir.getAbsolutePath();
        System.out.println("Project Path: " + path);

        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","4200ffebc60a73c3");
        capabilities.setCapability("deviceVersion", "5.1.1");
        capabilities.setCapability("platformVersion", "5.1.1");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage", "com.google.android.gm");
        capabilities.setCapability("appActivity","com.google.android.gm.ConversationListActivityGmail"); // This is Launcher activity of your app (you can get it from apk info app)
        File file = new File(path + "\\apk\\gmail-8-8-12-209077217-release.apk");
        capabilities.setCapability("app", file.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout( 10, TimeUnit.SECONDS );
        return driver;
    }

    static AppiumDriver prepareAsus() throws MalformedURLException {

        File currDir = new File("");
        String path = currDir.getAbsolutePath();
        System.out.println("Project Path: " + path);

        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid","H3AZB6017701DCM");
        capabilities.setCapability("deviceName","ASUS_Z012DC");
        capabilities.setCapability("deviceVersion", "8.0.0");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("unicodeKeyboard","true");
        capabilities.setCapability("resetKeyboard","true");
        capabilities.setCapability("appPackage", "com.google.android.gm");
        capabilities.setCapability("appActivity","com.google.android.gm.ConversationListActivityGmail"); // This is Launcher activity of your app (you can get it from apk info app)
        File file = new File(path + "\\apk\\gmail-8-8-12-209077217-release.apk");
        capabilities.setCapability("app", file.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout( 10, TimeUnit.SECONDS );
        return driver;
    }

    // IOS

       static AppiumDriver prepareDeviceIOS() throws MalformedURLException {
            File appDir = new File("/application");
            File app = new File(appDir, "foreksmobile.app");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"ahmet");
            capabilities.setCapability("udid","82e1c906c4d00c16b24198035f0c2035d3d78ddf");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            capabilities.setCapability("appium-version", "1.7.2");
            capabilities.setCapability("autoAcceptAlerts",false);
            capabilities.setCapability("noReset","true");
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30000);
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout( 30, TimeUnit.SECONDS );
            return driver;
       }
}

