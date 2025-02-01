package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AccountWizardPage {

    private final SelenideElement
        individualAccountButton = $(".value-individual"),
        biomaterialConsentCheckBox = $("#field-element-biometriaIsConsented"),
        startVerificationButton = $("#wizard-individual-avs-form-submit-btn"),
        businessAccountButton = $(".value-business"),
        producerName = $("#field-element-producerName"),
        contactFirstName = $("#field-element-contactFirstname"),
        contactLastName = $("#field-element-contactLastname"),
        directorFirstName = $("#field-element-directorFirstname"),
        directorLastName = $("#field-element-directorLastname"),
        companyName = $("#field-element-companyName"),
        registrationNumber = $("#field-element-registrationNumber"),
        addressCountry = $("#field-element-addressCountryCode"),
        addressCity = $("#field-element-addressCity"),
        addressRegion = $("#field-element-addressRegion"),
        addressPostCode = $("#field-element-addressPostCode"),
        addressStreet = $("#field-element-addressStreet"),
        custodianOfRecordsAddress = $("#field-element-custodianOfRecordsAddress"),
        forwardButton = $("#wizard-business-form-submit-btn"),
        contractSignedCheckBox = $("#field-element-contractSigned"),
        acceptButton = $(".button[type=submit]"),
        passportFirstPage = $("#field-element-passport"),
        passportSecondPage = $("#field-element-passportSecondPage"),
        commercialRegisterExtract = $("#field-element-commercialRegisterExtract"),
        certificateOfIncorporation = $("#field-element-certificateOfIncorporation"),
        cancelButton = $("#affidavit-modal__cancel"),
        dismissOkButton = $("#affidavit-dismiss-modal__ok");

    @Step("Switch to business account")
    public AccountWizardPage switchToBusiness() {
        businessAccountButton.click();
        return this;
    }

    @Step("Set producer name: {value}")
    public AccountWizardPage setProducerName(String value) {
        producerName.setValue(value);
        return this;
    }

    @Step("Set contact last name: {value}")
    public AccountWizardPage setContactLastName(String value) {
        contactLastName.setValue(value);
        return this;
    }

    @Step("Set contact first name: {value}")
    public AccountWizardPage setContactFirstName(String value) {
        contactFirstName.setValue(value);
        return this;
    }

    @Step("Set director's first name: {value}")
    public AccountWizardPage setDirectorFirstName(String value) {
        directorFirstName.setValue(value);
        return this;
    }

    @Step("Set director's last name:: {value}")
    public AccountWizardPage setDirectorLastName(String value) {
        directorLastName.setValue(value);
        return this;
    }

    @Step("Set company name: {value}")
    public AccountWizardPage setCompanyName(String value) {
        companyName.setValue(value);
        return this;
    }

    @Step("Set registration number: {value}")
    public AccountWizardPage setRegistrationNumber(String value) {
        registrationNumber.setValue(value);
        return this;
    }

    @Step("Set country: {value}")
    public AccountWizardPage setCountry(String value) {
        addressCountry.click();
        $(byText(value)).click();
        return this;
    }

    @Step("Set city: {value}")
    public AccountWizardPage setAddressCity(String value) {
        addressCity.setValue(value);
        return this;
    }

    @Step("Set region: {value}")
    public AccountWizardPage setAddressRegion(String value) {
        addressRegion.setValue(value);
        return this;
    }

    @Step("Set post code: {value}")
    public AccountWizardPage setAddressPostCode(String value) {
        addressPostCode.setValue(value);
        return this;
    }

    @Step("Set street: {value}")
    public AccountWizardPage setAddressStreet(String value) {
        addressStreet.setValue(value);
        return this;
    }

    @Step("Set custodian of records address: {value}")
    public AccountWizardPage setCustodianAddress(String value) {
        custodianOfRecordsAddress.setValue(value);
        return this;
    }

    @Step("Click on 'Next' button")
    public AccountWizardPage accept() {
        acceptButton.click();
        return this;
    }

    @Step("Sign the agreement")
    public AccountWizardPage contractSignedCheck() {
        contractSignedCheckBox.click();
        return this;
    }

    @Step("Upload document {file} as passport")
    public AccountWizardPage uploadPassport(String file) {
        passportFirstPage.uploadFile(new File("src/test/resources/" + file));
        return this;
    }

    @Step("Upload document {file} as passport second page")
    public AccountWizardPage uploadPassportSecondPage(String file) {
        passportSecondPage.uploadFile(new File("src/test/resources/" + file));
        return this;
    }

    @Step("Upload document {file} as passport")
    public AccountWizardPage uploadCommercialRegisterExtract(String file) {
        commercialRegisterExtract.uploadFile(new File("src/test/resources/" + file));
        return this;
    }

    @Step("Upload document {file} as passport")
    public AccountWizardPage uploadCertificateOfIncorporation(String file) {
        certificateOfIncorporation.uploadFile(new File("src/test/resources/" + file));
        return this;
    }

    @Step("Press 'Dismiss and delete my account' button")
    public MainPage cancel() {
        cancelButton.click();
        dismissOkButton.click();
        return page(MainPage.class);
    }
}
