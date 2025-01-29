package pages.components;

import com.codeborne.selenide.SelenideElement;
import pages.RegistrationPage;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FormResultComponent {

    private final static SelenideElement resultsTable = $(".table-responsive");

    public void checkRegistrationResults(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
    }
}
