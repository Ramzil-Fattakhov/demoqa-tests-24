package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class practiceForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {

        /// strings
        String firstName = "Alex";
        String lastName = "Grigoriev";
        String userMail = "kupipokemona@gmail.com";
        String userNumber = "9677446981";
        String currentAddress = "Leningrad";

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userMail);
        $(".custom-control-label").shouldHave(text("Male")).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day--005:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("#subjectsInput").setValue("English").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-3']").click();
        $("input#uploadPicture").uploadFile(new File("/Users/user/Downloads/2024-05-16 12.33.05.jpg"));
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Panipat").pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(userMail), text(userNumber), text(currentAddress), text("05 March,1999"), text("History"), text("English"), text("Sports"), text("Music"), text("2024-05-16 12.33.05.jpg"), text("Haryana"), text("Panipat"));
    }
}
