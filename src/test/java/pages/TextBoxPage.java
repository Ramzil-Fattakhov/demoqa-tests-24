package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    private SelenideElement fullNameInput = $("#userName"),
                            userEmailInput = $("#userEmail"),
                            userCurrentAddressInput = $("#currentAddress"),
                            userPermanentAddressInput = $("#permanentAddress"),
                            submitButton = $("#submit"),
                            output = $("#output");

    public TextBoxPage openPage() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));

        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    public TextBoxPage setUserCurrentAddress(String value) {
        userCurrentAddressInput.setValue(value);

        return this;
    }
    public TextBoxPage setUserPermanentAddress(String value) {
        userPermanentAddressInput.setValue(value);

        return this;
    }
    public TextBoxPage clickSubmitButton() {
        submitButton.click();

        return this;
    }

    public TextBoxPage checkEnteredData(String key, String value) {
        output.$("#" + (key)).shouldHave(text(value));

        return this;
    }

}
