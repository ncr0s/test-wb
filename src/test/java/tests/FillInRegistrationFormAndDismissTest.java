package tests;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.AccountWizardPage;

import static com.codeborne.selenide.Selenide.sleep;

public class FillInRegistrationFormAndDismissTest extends TestBase {

    @Test
    public void fillInRegistrationFormAndDismiss() {
        Faker faker = new Faker();

        AccountWizardPage wizardPage = mainPage.openPage()
            .setUserName(String.format("%s%s", faker.name().firstName(), faker.number().numberBetween(1000, 9999)))
            .setEmail( faker.internet().emailAddress())
            .setPassword(String.format("%s%s", faker.name().lastName(), faker.number().numberBetween(600, 742)))
            .getStarted();

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
            .uploadPassportSecondPage("pic.jpg")
            .uploadCommercialRegisterExtract("pic.jpg")
            .uploadCertificateOfIncorporation("pic.jpg")
            .accept()
            .cancel();


    }
}
