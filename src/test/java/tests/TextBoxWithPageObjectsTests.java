package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxWithPageObjectsTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTestWithPageObject() {
        textBoxPage.openPage()

                    .setFullName("Ramzil")
                    .setUserEmail("ramzilf@gmail.com")
                    .setUserCurrentAddress("Street 1")
                    .setUserPermanentAddress("Street 2")
                    .clickSubmitButton()

                    .checkEnteredData("name", "Ramzil")
                    .checkEnteredData("email", "ramzilf@gmail.com")
                    .checkEnteredData("currentAddress", "Street 1")
                    .checkEnteredData("permanentAddress", "Street 2");
    }

}
