import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SuccessfulEnterFormTests {

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successEnterFormTest(){
        Selenide.open("/automation-practice-form");
        $("[id=firstName]").setValue("Ivan");
        $("[id=lastName]").setValue("Ozhgikhin");
        $("[value=Male]").click();
        $("input[id=userNumber]").setValue("1234567890");
        $("#submit").scrollTo().click();

        switchTo().activeElement();
        $("table").shouldHave(text("Ivan Ozhgikhin"));
        $("table").shouldHave(text("Male"));
        $("table").shouldHave(text("1234567890"));
    }
}
