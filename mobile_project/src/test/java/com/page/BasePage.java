package com.page;

import io.appium.java_client.*;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidKeyCode;



class BasePage {

    public AppiumDriver driver;
    public WebDriverWait wait;
    public io.appium.java_client.TouchAction touchAction;

    //Constructor
    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,30);
    }

    void click(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    void clickSubElem(By element01, By element02) {
        wait.until(ExpectedConditions.elementToBeClickable(element01));
        WebElement elem = driver.findElement(element01);
        elem.findElement(element02).click();
    }

//    void tap(By element) {
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//        action.tap( (PointOption) element);
//        action.perform();
//    }

    void scroll(WebElement element) {
        TouchAction action = new TouchAction( driver );
        action.moveTo( (PointOption) element );
        action.perform();
    }

    void clickFirst(By element) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        List<WebElement> li = driver.findElements(element);
        li.get(1).click();
    }

    void sendKeys(By element, String text) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        WebElement elem = driver.findElement(element);
        elem.sendKeys(text);
    }

    public Boolean textClick(By locator, String text) {

        System.out.println( locator );
        wait.until( ExpectedConditions.presenceOfAllElementsLocatedBy( locator ) );
        List<MobileElement> AllSearchResults = (List<MobileElement>) driver.findElements( locator );

        for (WebElement eachResult : AllSearchResults) {
            try {
                System.out.println( eachResult.getText() );
                if (eachResult.getText().equalsIgnoreCase( text )) {
                    eachResult.click();
                    Thread.sleep( 2000 );
                    break;
                }

            } catch (Exception e) {
                System.out.println( e.getMessage() );
                return false;
            }
        }
        return true;
    }

    public void enter(By locator) {

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        WebElement elem = driver.findElement(locator);
        elem.sendKeys(Keys.ENTER);
    }
    public void tab(By locator) {

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        WebElement elem = driver.findElement(locator);
        elem.sendKeys(Keys.TAB);
    }

    String getText(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        return driver.findElement(element).getText();
    }

    boolean isEnableElement(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        Assert.assertTrue(driver.findElement(element).isEnabled());
        return true;
    }

    void assertText(By element, String text) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        Thread.sleep( 2000 ); // Espera o texto do elemento.
        String elem_text = driver.findElement( element ).getText();
        Assert.assertEquals(elem_text, text);
        System.out.println(elem_text + "=" + text);
    }
}
