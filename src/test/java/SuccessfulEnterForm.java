import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class SuccessfulEnterForm {

    @BeforeAll
    static void startup(){
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successEnterFormTest(){
        Selenide.open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Ivan");
        $("[id=lastName]").setValue("Ozhgikhin");
        $("[value=Male]").click();
        $("input[id=userNumber]").setValue("1234567890");
    }
}
