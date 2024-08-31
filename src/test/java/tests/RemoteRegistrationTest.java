package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RemoteRegistrationTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
    }

    @Test
    @Tag("demoqa")
    void studentRegistrationForm() {
        step("Open form", () -> {
            open("/automation-practice-form");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });
        step("Fill form", () -> {
                    $("#firstName").setValue("Anton");
                    $("#lastName").setValue("LaVey");
                    $("#userEmail").setValue("charlie@gmail.com");

                    $("#genterWrapper").$(byText("Male")).click();
                    $("#userNumber").setValue("8800555353");

                    $("#dateOfBirth-wrapper").click();
                    $("#dateOfBirth-wrapper").shouldBe(Condition.visible);

                    $("#dateOfBirth-wrapper").$(byText("July")).click();
                    $("#dateOfBirth-wrapper").$(byText("1990")).click();
                    $("#dateOfBirth-wrapper").$(byText("17")).click();

                    $("#subjectsContainer").click();
                    $("#subjectsInput").setValue("Maths").pressEnter();
                    $("#hobbiesWrapper").$(byText("Music")).click();

                    $("#uploadPicture").uploadFromClasspath("262.jpg");

                    $("#currentAddress").setValue("Some address");
                    $("#stateCity-wrapper").$(byText("Select State")).click();
                    $("#stateCity-wrapper").$(byText("NCR")).click();
                    $("#stateCity-wrapper").$(byText("Select City")).click();
                    $("#stateCity-wrapper").$(byText("Noida")).click();
                });
        step("Verify results", () -> {
                    $("#submit").click();
                    $(".table-responsive")
                            .shouldHave(text("Anton LaVey"))
                            .shouldHave(text("charlie@gmail.com"))
                            .shouldHave(text("Male"))
                            .shouldHave(text("8800555353"))
                            .shouldHave(text("17 July,1990"))
                            .shouldHave(text("Maths"))
                            .shouldHave(text("Music"))
                            .shouldHave(text("262.jpg"))
                            .shouldHave(text("Some address"))
                            .shouldHave(text("NCR Noida"));
            $(".modal-footer").$(byText("Close")).click();
        });
    }
}