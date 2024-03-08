package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void studentRegistrationForm() {
        registrationPage.openPage()
                .setFirstName("Anton")
                .setLastName("LaVey")
                .setEmail("charlie@gmail.com")
                .setGender("Male")
                .setUserNumber("8800555353")
                .setDateOfBirth("17", "July", "1990");
//                .setSubject("Maths");


        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("262.jpg");
        $("#currentAddress").setValue("Some address");
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Noida")).click();

        $("#submit").click();
        registrationPage.checkResult("Student Name", "Anton LaVey")
                .checkResult("Student Email", "charlie@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8800555353")
                .checkResult("Date of Birth", "17 July,1990")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "262.jpg")
                .checkResult("Address", "Some address")
                .checkResult("State and City", "NCR Noida");

        $(".modal-footer").$(byText("Close")).click();

    }
}