package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static TestData.FormTestData.*;

public class SuccessfulEnterFormTests extends TestBase {

    @Test
    void successEnterFormTest(){
        open("/automation-practice-form");
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[value=Male]").click();
        $("input[id=userNumber]").setValue(userNumber);
        $("#submit").scrollTo().click();

        $("table").shouldHave(text("Ivan Ozhgikhin"));
        $("table").shouldHave(text("Male"));
        $("table").shouldHave(text("1234567890"));
    }
}
