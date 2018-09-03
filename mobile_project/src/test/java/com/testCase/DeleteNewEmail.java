package com.testCase;

import com.page.LogIn;
import com.page.DeleteEmail;
import com.setup.BaseTest;
import io.qameta.allure.*;
import listener.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("CRUD email")
public class DeleteNewEmail extends BaseTest {

        @Test
        @Severity(SeverityLevel.BLOCKER)
        @Description("Test Description: Escrever um Email e Seleciona o Mesmo validando os dados enviados.")
        @Story("Create email")
        public void chargerTest() throws InterruptedException {

            DeleteEmail delete_page = new DeleteEmail( driver );
            delete_page.deleteEmail();

        }
}
