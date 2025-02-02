package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement
        landingMainTitle = $(".landing-main__title"),
        usernameInput = $("[name=username]"),
        emailInput = $("[name=email]"),
        passwordInput = $("[name=password]");

    public MainPage openPage() {
        open("");
        return this;
    }

    @Step("Set user name: {value}")
    public MainPage setUserName(String value) {
        usernameInput.setValue(value);
        return this;
    }

    @Step("Set email: {value}")
    public MainPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Set password: {value}")
    public MainPage setPassword(String value) {
        passwordInput.setValue(value);
        return this;
    }

    @Step("Click on 'Get started' button")
    public AccountWizardPage getStarted() {
        $$(".fh-button__stretch").get(0).click();
        return page(AccountWizardPage.class);
    }

    @Step("Check main page title")
    public void mainPageTitleShouldBeEqual(String title) {
        landingMainTitle.shouldBe(visible);
        landingMainTitle.shouldHave(text(title));
    }
}
