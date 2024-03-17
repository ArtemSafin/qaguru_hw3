package utils;

import com.github.javafaker.Faker;
import java.util.Locale;

public class RandomData {
    Faker faker = new Faker(new Locale("en"));
    public String firstName = getFirstName(),
            lastName = getLastName(),
            userEmail = getEmail(),
            userGender = getGender(),
            userPhone = getPhone(),
            monthOfBirth = getMonthOfBirth(),
            yearOfBirth = getYearOfBirth(),
            dayOfBirth = getDateOfBirth(),
            subject = getSubject(),
            hobbies = getHobbies(),
            picture = getPicture(),
            userAddress = getAddress(),
            state = getState(),
            city = getCity(),
            userWrongPhone = getWrongPhone();

    public String getFirstName() {
        return firstName = faker.name().firstName();
    }
    public String getLastName() {
        return lastName = faker.name().firstName();
    }
    public String getEmail() {
        return userEmail = faker.internet().emailAddress();
    }
    public String getGender() {
        return userGender = faker.options().option("Male", "Female");
    }
    public String getPhone() {
        return userPhone = faker.phoneNumber().subscriberNumber(10);
    }
    public String getDateOfBirth() {
        return dayOfBirth = String.valueOf(faker.number().numberBetween(1, 30));
    }
    public String getMonthOfBirth() {
        return monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }
    public String getYearOfBirth() {
        return yearOfBirth = String.valueOf(faker.number().numberBetween(1900, 2100));
    }
    public String getSubject() {
        return subject = faker.options().option("Accounting", "Arts", "Biology", "Chemistry",
                "Civics", "Commerce", "Computer Science", "Economics", "English", "Hindi", "History",
                "Maths", "Physics", "Social Studies");
    }
    public String getHobbies() {
        return hobbies = faker.options().option("Sports", "Reading", "Music");
    }
    public String getPicture() {
        return picture = faker.options().option("262.jpg");
    }
    public String getAddress() {
        return userAddress = faker.address().streetAddress();
    }
    public String getState() {
        return state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }
    public String getCity() {
        return switch (state) {
            case "NCR" -> city = faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> city = faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> city = faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> city = faker.options().option("Jaipur", "Jaiselmer");
            default -> city;
        };
    }

    public String getWrongPhone() {
        return userWrongPhone = faker.phoneNumber().subscriberNumber(9);
    }
}
