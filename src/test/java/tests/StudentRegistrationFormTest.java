package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void studentRegistrationForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Artem");
        $("#lastName").setValue("Safin");
        $("#userEmail").setValue("charlie@gmail.com");

        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8800555353");

        $("#dateOfBirth-wrapper").click();
        $("#dateOfBirth-wrapper").shouldBe(Condition.visible).$(byText("July")).click();
        $("#dateOfBirth-wrapper").shouldBe(Condition.visible).$(byText("1990")).click();
        $("#dateOfBirth-wrapper").shouldBe(Condition.visible).$(byText("17")).click();

        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("262.jpg");

        $("#currentAddress").setValue("Some address");
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#stateCity-wrapper").shouldHave(Condition.visible).$(byText("NCR")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").shouldHave(Condition.visible).$(byText("Noida")).click();

        $("#submit").click();
        $(".table-responsive").shouldHave(text("Artem Safin"),
                (text("charlie@gmail.com")),
                (text("Male")),
                (text("8800555353")),
                (text("17 July,1990")),
                (text("Maths")),
                (text("Music")),
                (text("262.jpg")),
                (text("Some address")),
                (text("NCR Noida")));

        $(".modal-footer").$(byText("Close")).click();

    }
}