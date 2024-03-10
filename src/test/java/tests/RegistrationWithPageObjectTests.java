package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

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
                .setDateOfBirth("17", "July", "1990")
                .setSubject("Maths")
                .setHobbies("Music")
                .setPicture("262.jpg")
                .setAddress("Some address")
                .setState("NCR", "Noida")
                .clickToSubmit();

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
        registrationPage.clickToClose();
    }
}