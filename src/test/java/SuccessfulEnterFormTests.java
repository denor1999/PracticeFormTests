import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class SuccessfulEnterFormTests {

    @BeforeAll
    static void startup() {
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
    }
}
