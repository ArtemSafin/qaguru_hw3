package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableDataComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirth-wrapper"),
            subjectElement = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateSelect = $("#react-select-3-input"),
            citySelect = $("#react-select-4-input"),
            submitElement = $("#submit"),
            closeElement = $("#closeLargeModal"),
            checkResultNegative = $("#example-modal-sizes-title-lg");

    CalendarComponent calendarComponent = new CalendarComponent();
    TableDataComponent tableDataComponent = new TableDataComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubject(String value) {
        subjectElement.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies(String hobbies) {
        hobbiesWrapper.$(byText(hobbies)).click();
        return this;
    }
    public RegistrationPage setPicture(String filename) {
        uploadPicture.uploadFromClasspath(filename);
        return this;
    }
    public RegistrationPage setAddress(String value) {
    currentAddress.setValue(value);
    return this;
    }
    public RegistrationPage setState(String state, String city) {
        stateSelect.setValue(state).pressEnter();
        citySelect.setValue(city).pressEnter();
        return this;
    }
    public void clickToSubmit() {
        submitElement.click();
    }
    public RegistrationPage checkResult(String key, String value) {
        tableDataComponent.getResultTable(key, value);
        return this;
    }
    public void dataTableNotVisible() {
        checkResultNegative.shouldNotBe(visible);

    }
    public void clickToClose() {
        closeElement.click();
    }
}