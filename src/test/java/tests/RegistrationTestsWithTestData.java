package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTestsWithTestData extends TestBase {

    @Test
    void studentRegistrationForm() {

                open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("firstName");
        $("#lastName").setValue("lastName");
        $("#userEmail").setValue("userEmail");

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("8800555353");

        $("#dateOfBirth-wrapper").click();
        $("#dateOfBirth-wrapper").$(byText("July")).click();
        $("#dateOfBirth-wrapper").$(byText("1990")).click();
        $("#dateOfBirth-wrapper").$(byText("17")).click();

        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("262.jpg");

        $("#currentAddress").setValue("streetAddress");

        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Noida")).click();

        $("#submit").click();
        $(".table-responsive")
                .shouldHave(text("firstName"), text("lastName"))
                .shouldHave(text("userEmail"))
                .shouldHave(text("Male"))
                .shouldHave(text("8800555353"))
                .shouldHave(text("17 July,1990"))
                .shouldHave(text("Maths"))
                .shouldHave(text("Music"))
                .shouldHave(text("262.jpg"))
                .shouldHave(text("streetAddress"))
                .shouldHave(text("NCR Noida"));

        $(".modal-footer").$(byText("Close")).click();

    }
}