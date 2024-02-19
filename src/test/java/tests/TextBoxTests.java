package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {

        open("/text-box");
        $("#userName").setValue("Max");
        $("#userEmail").setValue("Max@exmpl.com");
        $("#currentAddress").setValue("some address");
        $("#permanentAddress").setValue("another address");
        $("#submit").click();

        $("#output #name").shouldHave(text("Max"));
        $("#output #email").shouldHave(text("Max@exmpl.com"));
        $("#output #currentAddress").shouldHave(text("some address"));
        $("#output #permanentAddress").shouldHave(text("another address"));
    }

}