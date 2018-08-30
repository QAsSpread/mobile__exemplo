package com.page;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SendEmail extends BasePage {
    public SendEmail(AppiumDriver driver) {
        super(driver);
    }

    private By new_email = By.id("com.google.android.gm:id/compose_button");
    private By para = By.id("com.google.android.gm:id/to");
    private By assunto = By.id("com.google.android.gm:id/subject");
    private By texto = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View");
    private By btnSend = By.id("com.google.android.gm:id/send");
    private By btnAnexo = By.id("com.google.android.gm:id/add_attachment");
    private By menuAnexo = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
    private By firstFile = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");

    // Page Enviados
    private By menu_base = By.id("com.google.android.gm:id/mail_toolbar");
    private By imag_menu = By.className("android.widget.ImageButton");
    private By enviados = By.className("android.widget.TextView");

    @Step("Enviar um Email com Anexo.")
    public void sendEmail() throws InterruptedException {
        click(new_email);
        sendKeys(para, "reinaldo.rossetti@spread.com.br");
        assertText(para, "reinaldo.rossetti@spread.com.br");
        sendKeys(texto, "Testando....");
        sendKeys(assunto, "Teste Enviando email via Appium!");
        click(btnAnexo);
        click(menuAnexo);
        click(firstFile);
        click(btnSend);
        clickSubElem(menu_base, imag_menu);
        textClick( enviados, "Enviados" );
        String string = "Teste Enviando email via Appium!";
        By validacao = By.xpath("//android.view.View[contains(text()," + string + "\")]");
        assertText(validacao, string);
        Thread.sleep( 15000 );
    }
}
