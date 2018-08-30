package com.testCase;

import com.page.LogIn;
import com.page.SendEmail;
import com.setup.BaseTest;
import io.qameta.allure.*;
import listener.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Create email")
public class SendNewEmail extends BaseTest {

        @Test
        @Severity(SeverityLevel.BLOCKER)
        @Description("Test Description: Escrever um Email")
        @Story("Create email")
        public void chargerTest() throws InterruptedException {
            LogIn page = new LogIn(driver);
            SendEmail send_page = new SendEmail( driver );
            page.openGmail();
            send_page.sendEmail();
        }

}
