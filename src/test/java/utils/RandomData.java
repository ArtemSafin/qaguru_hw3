package utils;

import com.github.javafaker.Faker;
import java.util.Locale;

public class RandomData {
    Faker faker = new Faker(new Locale("en"));
    public String firstName = getFirstName(),
            lastName = getLastName(),
            userEmail = getEmail(),
            userGender = getGender(),
            userPhone = getPhone(10),
            monthOfBirth = getMonthOfBirth(),
            yearOfBirth = getYearOfBirth(),
            dayOfBirth = getDateOfBirth(),
            subject = getSubject(),
            hobbies = getHobbies(),
            picture = getPicture(),
            userAddress = getAddress(),
            state = getState(),
            city = getCity(),
            userWrongPhone = getPhone(9);

    public String getFirstName() {
        return faker.name().firstName();
    }
    public String getLastName() {
        return faker.name().firstName();
    }
    public String getEmail() {
        return faker.internet().emailAddress();
    }
    public String getGender() {
        return faker.options().option("Male", "Female");
    }
    public String getPhone(int num) {
        return faker.phoneNumber().subscriberNumber(num);
    }
    public String getDateOfBirth() {
        return String.valueOf(faker.number().numberBetween(1, 30));
    }
    public String getMonthOfBirth() {
        return faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }
    public String getYearOfBirth() {
        return String.valueOf(faker.number().numberBetween(1900, 2100));
    }
    public String getSubject() {
        return faker.options().option("Accounting", "Arts", "Biology", "Chemistry",
                "Civics", "Commerce", "Computer Science", "Economics", "English", "Hindi", "History",
                "Maths", "Physics", "Social Studies");
    }
    public String getHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }
    public String getPicture() {
        return faker.options().option("262.jpg");
    }
    public String getAddress() {
        return faker.address().streetAddress();
    }
    public String getState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }
    public String getCity() {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> city;
        };
    }
}