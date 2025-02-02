package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverProvider;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.MainPage;

import static com.codeborne.selenide.Configuration.remote;

public class TestBase {

    protected MainPage mainPage = new MainPage();

    @BeforeAll
    static void setUp() {
        WebDriverProvider.setupConfig();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("Last screen");
        Attachments.pageSource();
        if(remote != null) {
            Attachments.addVideo();
        }
    }
}
