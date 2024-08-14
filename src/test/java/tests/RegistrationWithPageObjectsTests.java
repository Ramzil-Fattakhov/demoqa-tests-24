package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()

                        .setFirstName("Ramzil")
                        .setLastName("Fattakhov")
                        .setUserEmail("ramzilf@gmail.com")
                        .setGender("Other")
                        .setUserNumber("1234567890")
                        .setDateOfBirth("30", "July", "2008")
                        .setUserSubject("Math")
                        .setHobbies("Sports")
                        .uploadPicture("img/pic.png")
                        .setUserCurrentAddress("Some address 1")
                        .setUserStateAndCity("NCR", "Delhi")
                        .submitRegistrationForm()
                        .checkModalTitle("Thanks for submitting the form")

                        .checkResult("Student Name", "Ramzil Fattakhov")
                        .checkResult("Student Email", "ramzilf@gmail.com")
                        .checkResult("Gender", "Other")
                        .checkResult("Mobile", "1234567890")
                        .checkResult("Date of Birth", "30 July,2008")
                        .checkResult("Subjects", "Maths")
                        .checkResult("Hobbies", "Sports")
                        .checkResult("Address", "Some address 1")
                        .checkResult("State and City", "NCR Delhi")
                        .closeModalForm()
                        .checkModalFormIsClosed();

    }

    @Test
    void requiredFieldsIsFilledTest() {
        registrationPage.openPage()

                .setFirstName("Ramzil")
                .setLastName("Fattakhov")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("30", "July", "2008")
                .submitRegistrationForm()
                .checkModalTitle("Thanks for submitting the form")

                .checkResult("Student Name", "Ramzil Fattakhov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "30 July,2008")
                .closeModalForm()
                .checkModalFormIsClosed();

    }

    @Test
    void checkSymbolsInMobileInput() {
        registrationPage.openPage()

                .setFirstName("Ramzil")
                .setLastName("Fattakhov")
                .setGender("Male")
                .setUserNumber("//////////")
                .submitRegistrationForm()
                .checkMobileInputHasWrongType();

    }

//    @Test
//    void successfulRegistrationTest2() {
//        open("/automation-practice-form");
//        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
//        executeJavaScript("$('#fixedban').remove()");
//        executeJavaScript("$('footer').remove()");
//
//        $(firstNameLocator).setValue("Alex");
//        $("#lastName").setValue("Egorov");
//        $("#userEmail").setValue("alex@egorov.com");
//        $("#genterWrapper").$(byText("Other")).click();
//        $("#userNumber").setValue("1234567890");
//        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").selectOption("July");
//        $(".react-datepicker__year-select").selectOption("2008");
//        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
//        $("#subjectsInput").setValue("Math").pressEnter();
//        $("#hobbiesWrapper").$(byText("Sports")).click();
//        $("#uploadPicture").uploadFromClasspath("img/1.png");
//        $("#currentAddress").setValue("Some address 1");
//        $("#state").click();
//        $("#stateCity-wrapper").$(byText("NCR")).click();
//        $("#city").click();
//        $("#stateCity-wrapper").$(byText("Delhi")).click();
//        $("#submit").click();
//
//        $(".modal-dialog").should(appear);
//        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//        $(".table-responsive").shouldHave(text("Alex"), text("Egorov"),
//                text("alex@egorov.com"), text("1234567890"));
//    }
}