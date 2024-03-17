package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomData;

public class RegistrationWithPageObjectTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomData randomData = new RandomData();
    @Test
    void studentRegistrationForm() {
        registrationPage.openPage()
                .setFirstName(randomData.firstName)
                .setLastName(randomData.lastName)
                .setEmail(randomData.userEmail)
                .setGender(randomData.userGender)
                .setUserNumber(randomData.userPhone)
                .setDateOfBirth(randomData.monthOfBirth, randomData.dayOfBirth, randomData.yearOfBirth)
                .setSubject(randomData.subject)
                .setHobbies(randomData.hobbies)
                .setPicture(randomData.picture)
                .setAddress(randomData.userAddress)
                .setState(randomData.state, randomData.city)
                .clickToSubmit();

        registrationPage.checkResult("Student Name", randomData.firstName + " " + randomData.lastName)
                .checkResult("Student Email", randomData.userEmail)
                .checkResult("Gender", randomData.userGender)
                .checkResult("Mobile", randomData.userPhone)
                .checkResult("Date of Birth", randomData.dayOfBirth + " " + randomData.monthOfBirth + "," + randomData.yearOfBirth)
                .checkResult("Subjects", randomData.subject)
                .checkResult("Hobbies", randomData.hobbies)
                .checkResult("Picture", randomData.picture)
                .checkResult("Address", randomData.userAddress)
                .checkResult("State and City", randomData.state + " " + randomData.city);
        registrationPage.clickToClose();
    }
    @Test
    void studentRegistrationFormNegativeTest() {
        registrationPage.openPage()
                .setFirstName(randomData.firstName)
                .setLastName(randomData.lastName)
                .setEmail(randomData.userEmail)
                .setGender(randomData.userGender)
                .setUserNumber(randomData.userWrongPhone)
                .setDateOfBirth(randomData.monthOfBirth, randomData.dayOfBirth, randomData.yearOfBirth)
                .setSubject(randomData.subject)
                .setHobbies(randomData.hobbies)
                .setPicture(randomData.picture)
                .setAddress(randomData.userAddress)
                .setState(randomData.state, randomData.city)
                .clickToSubmit();
        registrationPage.dataTableNotVisible();
    }
    @Test
    void studentRegistrationFormMinimalDataTest() {
        registrationPage.openPage()
                .setFirstName(randomData.firstName)
                .setLastName(randomData.lastName)
                .setEmail(randomData.userEmail)
                .setGender(randomData.userGender)
                .setUserNumber(randomData.userPhone)
                .clickToSubmit();

        registrationPage.checkResult("Student Name", randomData.firstName + " " + randomData.lastName)
                .checkResult("Student Email", randomData.userEmail)
                .checkResult("Gender", randomData.userGender)
                .checkResult("Mobile", randomData.userPhone);
    }
}