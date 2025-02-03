package tests;


import com.github.javafaker.Faker;
import helpers.LocalisationHelper;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.AccountWizardPage;

public class FillInRegistrationFormAndDismissTest extends TestBase {

    Faker faker = new Faker();

    @Test
    @Tags({@Tag("UI"), @Tag("Positive")})
    @Feature("studio.faphouse.com")
    @Story("Registration form")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Positive: Fill in the business account registration form and dismiss")
    public void fillInRegistrationFormAndDismiss() {

        AccountWizardPage wizardPage = mainPage.openPage()
            .setUserName(String.format("%s%s", faker.name().firstName(), faker.number().numberBetween(10000, 99999)))
            .setEmail(String.format("%s@test-domain.com", faker.name().username()))
            .setPassword(String.format("%s%s", faker.name().lastName(), faker.number().numberBetween(600, 742)))
            .getStarted();

        wizardPage
            .wizardPageTitleShouldBeVisible()
            .wizardPageButtonsShouldBeVisible();

        mainPage = wizardPage.switchToBusiness()
            .setProducerName(faker.name().fullName())
            .setContactFirstName(faker.name().firstName())
            .setContactLastName(faker.name().lastName())
            .setDirectorFirstName(faker.name().firstName())
            .setDirectorLastName(faker.name().lastName())
            .setCompanyName(faker.company().name())
            .setRegistrationNumber(String.valueOf(faker.number().randomNumber(5, true)))
            .setCountry(faker.country().name())
            .setAddressCity(faker.country().capital())
            .setAddressRegion(faker.address().city())
            .setAddressPostCode(faker.address().zipCode())
            .setAddressStreet(faker.address().streetAddress())
            .setCustodianAddress(faker.address().fullAddress())
            .accept()
            .contractSignedCheck()
            .accept()
            .uploadPassport("pic.jpg")
            .uploadPassportSecondPage("sample.pdf")
            .uploadCommercialRegisterExtract("sample_big.jpeg")
            .uploadCertificateOfIncorporation("pic.jpg")
            .accept()
            .cancel();

        mainPage
            .mainPageRegistrationFieldsShouldBeVisible()
            .mainPageTitleShouldBeEqual(LocalisationHelper.getMainPageTitle(mainPage.getLanguage()));
    }
}
