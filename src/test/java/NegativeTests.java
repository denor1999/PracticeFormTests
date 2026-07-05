import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NegativeTests {

    @BeforeAll
    static void setup(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1240";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void emptyMobileNumberTest(){
        Selenide.open("/automation-practice-form");
        $("[id=firstName]").setValue("Ivan");
        $("[id=lastName]").setValue("Ozhgikhin");
        $("input[value=Male]").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("[id=submit]").shouldBe(visible).click();

        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }

    @Test
    void emptyFirstNameAndLastNameTest(){
        Selenide.open("/automation-practice-form");
        $("[value=Male]").click();
        $("input[id=userNumber]").setValue("1234567890");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("[id=submit]").shouldBe(visible).click();

        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void invalidEmailTest(){
        Selenide.open("/automation-practice-form");
        $("[id=firstName]").setValue("Ivan");
        $("[id=lastName]").setValue("Ozhgikhin");
        $("[id=userEmail]").setValue("aweoif");
        $("[value=Male]").click();
        $("input[id=userNumber]").setValue("1234567890");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("[id=submit]").shouldBe(visible).click();

        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }
}
