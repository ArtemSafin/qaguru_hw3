package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.TextBoxComponent;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    TextBoxComponent textBoxComponent = new TextBoxComponent();
    private final SelenideElement fullNameInput = $("#userName"),
        emailInput = $("#userEmail"),
        currentAddressInput = $("#currentAddress"),
        permanentAddressInput = $("#permanentAddress"),
        submitButton = $("#submit"),
        outputElement = $("#output");

    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullName(String fullName) {
        fullNameInput.setValue(fullName);
        return this;
    }

    public TextBoxPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddressInput(String permanentAddress) {
        permanentAddressInput.setValue(permanentAddress);
        return this;
    }
    public void clickSubmit() {
        submitButton.click();
    }
    public TextBoxPage checkResult(String key, String value) {
        textBoxComponent.outputElement(key, value);
        return this;
    }
}