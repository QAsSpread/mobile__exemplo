package com.page;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class LogIn extends BasePage {
    public LogIn(AppiumDriver driver) {
        super(driver);
    }

    private By newBtn = By.id("com.google.android.gm:id/welcome_tour_got_it");
    private By emails = By.id("com.google.android.gm:id/account_address");
    private By acessar = By.id("com.google.android.gm:id/action_done");
    private By title = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView");

    @Step("Entrar no Aplicativo do Google Gmail.")
    public void openGmail() throws InterruptedException {

        click(newBtn);
        menu_account();
        boolean result = getTextBollean( title );

        if (result==false) {
            TimeUnit.SECONDS.sleep(5);
            menu_account();
        }

        assertText(title, "Principal");
    }

    public void menu_account() throws InterruptedException {
        textClick(emails, "reiload@gmail.com");
        click(acessar);
    }

}
