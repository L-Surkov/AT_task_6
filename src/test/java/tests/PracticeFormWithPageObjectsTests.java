package tests;

import org.junit.jupiter.api.Test;
import components.CheckComponent;
import pages.PracticeFormPage;
import testData.TestData;

public class PracticeFormWithPageObjectsTests extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    CheckComponent checkComponent = new CheckComponent();
    TestData testData = new TestData();
    @Test
    void positiveAllFormTest() {
        practiceFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubject (testData.subject)
                .setHobby (testData.hobby)
                .uploadPicture(testData.image)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .sendForm();

        checkComponent.checkModalIsOpen()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobby)
                .checkResult("Picture", testData.image)
                .checkResult("State and City", testData.state + " " + testData.city);
    }

    @Test
    void positiveMinimalFormTest() {
        practiceFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .sendForm();
        checkComponent.checkModalIsOpen()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber);
    }
    @Test
    void NegativeFormTest() {
        practiceFormPage.openPage()
                .sendForm();
        checkComponent.checkModalIsNotOpen();
    }
}