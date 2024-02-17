package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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
        $("#userNumber").setValue("88005553535");

        $("#dateOfBirth-wrapper").click();
        $("#dateOfBirth-wrapper").shouldBe(Condition.visible).$(byText("July")).click();
        $("#dateOfBirth-wrapper").shouldBe(Condition.visible).$(byText("1990")).click();
        $("#dateOfBirth-wrapper").shouldBe(Condition.visible).$(byText("17")).click();

        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("262.png");

    }

}
