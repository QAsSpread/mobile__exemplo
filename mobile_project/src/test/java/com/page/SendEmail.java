package com.page;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SendEmail extends BasePage {
    public SendEmail(AppiumDriver driver) {
        super(driver);
    }

    private By new_email = By.id("com.google.android.gm:id/compose_button");
    private By para = By.id("com.google.android.gm:id/to");
    private By assunto = By.id("com.google.android.gm:id/subject");
    private By texto = By.className("android.view.View");
    private By btnSend = By.id("com.google.android.gm:id/send");
    private By btnAnexo = By.id("com.google.android.gm:id/add_attachment");
    private By menuAnexo = By.className("android.widget.TextView");
    private By firstFile = By.id("android:id/title");
    private By TextView = By.className( "android.widget.TextView" );

    // Page Enviados
    private By menu_base = By.id("com.google.android.gm:id/mail_toolbar");
    private By imag_menu = By.className("android.widget.ImageButton");


    @Step("Enviar um Email com Anexo.")
    public void sendEmail() throws InterruptedException {

        click(new_email);
        sendKeys(para, "reinaldo.rossetti@spread.com.br");
        assertText(para, "reinaldo.rossetti@spread.com.br");
        enter();

        WebElement element_text = textClick(texto, "Escrever e-mail");
        sendKeysElement(element_text, "Testando....");
        assertTextElement(element_text, "Testando....");

        sendKeys(assunto, "Teste Enviando e-mail via Appium");
        assertText(assunto, "Teste Enviando e-mail via Appium");

        click(btnAnexo);
        textClick(menuAnexo, "Anexar arquivo");
        sendKeys(firstFile, "Screenshot");
        textClick(TextView, "ABRIR");
        click(btnSend);

        openMenu();
        String string = "Teste Enviando e-mail via Appium!";
        By validacao = By.xpath("//android.view.View[contains(@content-desc,'" + string + "\')]");

        boolean result = clickFirstBoolean(validacao);

        if (result==false) {
            openMenu();
            clickFirst(validacao);
        }
    }

    public void openMenu() throws InterruptedException {
        clickSubElem(menu_base, imag_menu);
        textClick( TextView, "Enviados" );
    }
}
