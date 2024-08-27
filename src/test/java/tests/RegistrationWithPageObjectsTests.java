package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static utils.RandomUtils.*;


public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker(new Locale("en-gb"));
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userGender = faker.options().option("Male", "Female", "Other");
    String userNumber = getRandomPhone();
    String[] userDateOfBirth = getRandomDateOfBirth();
    String streetAddress = faker.address().streetAddress();
    String userSubject = getRandomSubject();
    String userHobbies = faker.options().option("Sports", "Reading", "Music");
    String[] userStateAndCity = getRandomStateAndCity();


    @Test
    void successfulRegistrationTestWithFaker() {
        registrationPage.openPage()

                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setUserEmail(userEmail)
                        .setGender(userGender)
                        .setUserNumber(userNumber)
                        .setDateOfBirth(userDateOfBirth[0], userDateOfBirth[1], userDateOfBirth[2])
                        .setUserSubject(userSubject)
                        .setHobbies(userHobbies)
                        .uploadPicture("img/pic.png")
                        .setUserCurrentAddress(streetAddress)
                        .setUserStateAndCity(userStateAndCity[0], userStateAndCity[1])
                        .submitRegistrationForm()
                        .checkModalTitle("Thanks for submitting the form")

                        .checkResult("Student Name", firstName + " " + lastName)
                        .checkResult("Student Email", userEmail)
                        .checkResult("Gender", userGender)
                        .checkResult("Mobile", userNumber)
                        .checkResult("Date of Birth", userDateOfBirth[0] + " " + userDateOfBirth[1] + "," + userDateOfBirth[2])
                        .checkResult("Subjects", userSubject)
                        .checkResult("Hobbies", userHobbies)
                        .checkResult("Address", streetAddress)
                        .checkResult("State and City", userStateAndCity[0] + " " + userStateAndCity[1])
                        .closeModalForm()
                        .checkModalFormIsClosed();

    }

    @Test
    void requiredFieldsIsFilledTest() {
        registrationPage.openPage()

                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(userDateOfBirth[0], userDateOfBirth[1], userDateOfBirth[2])
                .submitRegistrationForm()
                .checkModalTitle("Thanks for submitting the form")

                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", userDateOfBirth[0] + " " + userDateOfBirth[1] + "," + userDateOfBirth[2])
                .closeModalForm()
                .checkModalFormIsClosed();

    }

    @Test
    void checkSymbolsInMobileInput() {
        registrationPage.openPage()

                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber("//////////")
                .submitRegistrationForm()
                .checkMobileInputHasWrongType();

    }

}