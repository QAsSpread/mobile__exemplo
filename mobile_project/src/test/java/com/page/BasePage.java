package com.page;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;
import org.openqa.selenium.*;
import io.appium.java_client.AppiumDriver;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;


class BasePage {

    public AppiumDriver driver;
    public WebDriverWait wait;
    public io.appium.java_client.TouchAction touchAction;


    //Constructor
    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,70);
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

    void scroll(WebElement element) {
        TouchAction action = new TouchAction( driver );
        action.moveTo( (PointOption) element );
        action.perform();
    }

    @SuppressWarnings("unchecked")
    void clickFirst(By element) {
        try {

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        List<MobileElement> li = (List<MobileElement>) driver.findElements(element);

        li.get(0).click();

        } catch (Exception e) {
            System.out.println( "Tentando uma Segunda Vez..." );
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
            List<MobileElement> li = (List<MobileElement>)driver.findElements(element);
            li.get(0).click();
        }
    }

    @SuppressWarnings("unchecked")
    Boolean clickFirstBoolean(By element) {

        boolean result = true;

        try {

            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
            List<MobileElement> li = driver.findElements(element);
            li.get(0).click();

        } catch (Exception e) {
            System.out.println( e );
            result = false;

        }
        return result;
    }

    void sendKeys(By element, String text) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        WebElement elem = driver.findElement(element);
        elem.sendKeys(text);
    }

    void sendKeysElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    @SuppressWarnings("unchecked")
    public WebElement textClick(By locator, String text) throws InterruptedException {

        System.out.println( locator );
        Thread.sleep( 1000 );
        wait.until( ExpectedConditions.presenceOfAllElementsLocatedBy( locator ) );
        List<MobileElement> AllSearchResults = (List<MobileElement>) driver.findElements( locator );
        WebElement element = null;
        for (WebElement eachResult : AllSearchResults) {
            element = eachResult;
            try {
                System.out.println( eachResult.getText() );
                if (eachResult.getText().equalsIgnoreCase( text )) {
                    eachResult.click();
                    Thread.sleep( 2000 );
                    break;
                }

            } catch (Exception e) {
                System.out.println( e.getMessage() );
            }
        }

        return element;
    }

    @SuppressWarnings("unchecked")
    public WebElement textContainsClick(By locator, String text) throws InterruptedException {

        System.out.println( locator );
        Thread.sleep( 2000 );
        wait.until( ExpectedConditions.presenceOfAllElementsLocatedBy( locator ) );
        List<MobileElement> AllSearchResults = (List<MobileElement>) driver.findElements( locator );
        WebElement element = null;
        for (WebElement eachResult : AllSearchResults) {
            element = eachResult;
            try {
                System.out.println( eachResult.getText() );
                String textx = text.toLowerCase();
                String app_text = eachResult.getText().toLowerCase();
                if (app_text.contains( textx )) {
                    eachResult.click();
                    Thread.sleep( 2000 );
                    break;
                }

            } catch (Exception e) {
                Thread.sleep( 2000 );
                element.click();
                System.out.println( e.getMessage() );
            }
        }

        return element;
    }

    // Enter in current element.
    public void enter() {

         ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.ENTER) );

    }

    // Tab in current element.
    public void tab() {

        ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.TAB) );

    }

    String getText(By element) {
        String text = "";
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        text = driver.findElement(element).getText();
        System.out.println(text);
        return text;
    }

    Boolean getTextBollean(By element) throws InterruptedException {
        boolean result = true;
        Thread.sleep( 3000 );
        try{
            String text = driver.findElement(element).getText();
            System.out.println(text);
        } catch (Exception e) {
            System.out.println( e.getMessage() );
            result = false;
        }
        return result;
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
        String allRemoved = elem_text.replaceAll("^\\s+|\\s+$", "").trim();
        System.out.println(allRemoved.toLowerCase() + "=" + text.toLowerCase());
        assertThat(allRemoved.toLowerCase(), containsString(text.toLowerCase()));
    }
    void assertTextElement(WebElement element, String text) throws InterruptedException {
        Thread.sleep( 2000 ); // Espera o texto do elemento.
        String elem_text = element.getText();
        String allRemoved = elem_text.replaceAll("^\\s+|\\s+$", "").trim();
        System.out.println(allRemoved.toLowerCase() + "=" + text.toLowerCase());
        assertThat(allRemoved.toLowerCase(), containsString(text.toLowerCase()));
    }
}
