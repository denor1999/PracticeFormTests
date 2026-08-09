package tests;

import org.junit.jupiter.api.Test;

import static TestData.FormTestData.*;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NegativeTests extends TestBase{

    @Test
    void emptyMobileNumberTest(){
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("input[value=Male]").click();
        $("#submit").shouldBe(visible).click();

        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }

    @Test
    void emptyFirstNameAndLastNameTest(){
        open("/automation-practice-form");
        $("[value=Male]").click();
        $("input[id=userNumber]").setValue(userNumber);
        $("#submit").shouldBe(visible).click();

        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void invalidEmailTest(){
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(invalidUserEmail);
        $("[value=Male]").click();
        $("input[id=userNumber]").setValue(userNumber);
        $("#submit").shouldBe(visible).click();

        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }
}
