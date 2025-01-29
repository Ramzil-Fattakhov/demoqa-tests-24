package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.FormResultComponent;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),

                            lastNameInput = $("#lastName"),

                            userEmailInput = $("#userEmail"),

                            genderWrapper = $("#genterWrapper"),

                            userNumberInput = $("#userNumber"),

                            calendarInput = $("#dateOfBirthInput"),

                            userSubject = $("#subjectsInput"),

                            hobbiesWrapper = $("#hobbiesWrapper"),

                            pictureUploader = $("#uploadPicture"),

                            currentAddressInput = $("#currentAddress"),

                            stateSelect = $("#react-select-3-input"),

                            citySelect = $("#react-select-4-input"),

                            submitButton = $("#submit"),

                            modalTitle = $("#example-modal-sizes-title-lg"),

                            closeButton = $("#closeLargeModal");

    CalendarComponent calendarComponent = new CalendarComponent();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().
                shouldHave(text(value));

        return this;
    }

    public RegistrationPage setUserSubject(String value) {
        userSubject.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        pictureUploader.uploadFromClasspath(value);

        return this;
    }
    public RegistrationPage setUserCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserStateAndCity(String state, String city) {
        stateSelect.setValue(state).pressEnter();
        citySelect.setValue(city).pressEnter();

        return this;
    }

    public RegistrationPage submitRegistrationForm() {
        submitButton.click();

        return this;
    }

    public RegistrationPage checkModalTitle(String value) {
        modalTitle.shouldHave(text(value));

        return this;
    }

    public RegistrationPage closeModalForm() {
        closeButton.click();

        return this;
    }

    public RegistrationPage checkModalFormIsClosed() {
        closeButton.shouldNotBe(visible);

        return this;
    }

    public RegistrationPage checkMobileInputHasWrongType() {
        userNumberInput.shouldHave(cssValue("border-color","rgb(220, 53, 69)"));

        return this;
    }

}
