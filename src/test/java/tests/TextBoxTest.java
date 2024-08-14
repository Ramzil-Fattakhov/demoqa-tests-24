package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

        @Test
        void fillFormTest() {
            open("/text-box");
            $("#userName").setValue("Alex");
            $("#userEmail").setValue("Alex@gmail.com");
            $("#currentAddress").setValue("Street 1");
            $("#permanentAddress").setValue("Street 2");
            $("#submit").click();

            $("#output #name").shouldHave(text("Alex"));
            $("#output #email").shouldHave(text("Alex@gmail.com"));
            $("#output #currentAddress").shouldHave(text("Street 1"));
            $("#output #permanentAddress").shouldHave(text("Street 2"));
        }
    }
