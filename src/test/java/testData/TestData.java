package testData;
import com.github.javafaker.Faker;
import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("us"));
    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            year =String.format("%s", faker.number().numberBetween(1925, 2007)),
            month = faker.options().option("January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December"),
            day =  String.format("%s", faker.number().numberBetween(10, 28)),
            subject = faker.options().option("Maths", "Hindi", "History", "Biology", "Accounting", "Chemistry"),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            image = faker.options().option("imagefortest.png", "image_2.png"),
            currentAddress = faker.address().streetAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Rajasthan", "Haryana"),
            city = getCityFromState(state);

    private String getCityFromState(String state) {

        if (this.state.equals("NCR")) {
            return faker.options().option("Delhi", "Gurgagon", "Noida");
        } else if (this.state.equals("Uttar Pradesh")) {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        } else if (this.state.equals("Rajasthan")) {
            return faker.options().option("Jaipur", "Jaiselmer");
        }
        return faker.options().option("Karnal", "Panipat");
    }
}
