package com.setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

/**
 * Created by ahmetbaltaci on 22.12.2017.
 */
public class BaseTest {


    public static AppiumDriver driver;
    protected WebDriverWait wait;
    private String testCaseName;
    private long testStartTime;
    private long testFinishTime;
    private long testDurationTime;
    private String testFailedMsg;

    public WebDriver getDriver() {
        return driver;
    }

    protected long getTestStartTime() {
        return testStartTime;
    }

    protected void setTestStartTime(long testStartTime) {
        this.testStartTime = testStartTime;
    }

    protected long getTestFinishTime() {
        return testFinishTime;
    }

    protected void setTestFinishTime(long testFinishTime) {
        this.testFinishTime = testFinishTime;
    }

    protected long getTestDurationTime() {
        return testDurationTime;
    }

    protected void setTestDurationTime(long testDurationTime) {
        this.testDurationTime = testDurationTime;
    }

    protected String getTestCaseName() {
        return testCaseName;
    }

    protected void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getTestFailedMsg() {
        return testFailedMsg;
    }

    public void setTestFailedMsg(String testFailedMsg) {
        this.testFailedMsg = testFailedMsg;
    }


    @BeforeSuite()
    public void setUp() throws MalformedURLException, InterruptedException, FileNotFoundException {
        //String test = "A8";
        String test = System.getProperty("device");
        switch (test) {
            case "A8":
                System.out.println( "A8" );
                DeviceSetup.prepareGalaxyA8();
                break;
            case "Asus":
                System.out.println( "Asus" );
                DeviceSetup.prepareAsus();
                break;
            case "J1":
                System.out.println( "J1" );
                DeviceSetup.prepareGalaxyJ1();
                break;
            case "G5":
                System.out.println( "Moto G5" );
                DeviceSetup.prepareMotoG5();
                break;
            case "TabletSamsung":
                System.out.println( "Tablet Samsung" );
                DeviceSetup.prepareTabletSamsung();
                break;
        }
        wait = new WebDriverWait(driver,30);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
