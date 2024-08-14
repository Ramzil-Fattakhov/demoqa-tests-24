package pages.components;

import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

    }
}
