package com.page;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;


public class DeleteEmail extends BasePage {
    public DeleteEmail(AppiumDriver driver) {
        super(driver);
    }

    // Page Delete, elementos da tela delete.
    private By menu_base = By.id("com.google.android.gm:id/mail_toolbar");
    private By imag_menu = By.className("android.widget.ImageButton");
    private By enviados = By.className("android.widget.TextView");
    private By btn_delete = By.id("com.google.android.gm:id/delete");
    private By texto = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[3]/android.view.View");

    @Step("Deleta o email Criado.")
    public void deleteEmail() throws InterruptedException {

        clickSubElem(menu_base, imag_menu);
        textClick( enviados, "Enviados" );
        String string = "Teste Enviando e-mail via Appium!";
        By validacao = By.xpath("//android.view.View[contains(@content-desc,'" + string + "\')]");
        clickFirst(validacao);
        assertText(texto, "Testando....");
        click(btn_delete);
        boolean result = getTextBollean( validacao );
        assertThat(result, equalTo(false));
    }
}
