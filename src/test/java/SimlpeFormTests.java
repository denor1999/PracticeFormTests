import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SimlpeFormTests {

    @BeforeAll
    static void setup(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";Configuration.baseUrl = "https://demoqa.com";

    }

    @Test
    void minimumFieldsEnterTest(){
        Selenide.open("/text-box");
        $("[id=userName]").setValue("Ivan");
        $("#submit").click();
        $("#name").shouldHave(text("Ivan"));
    }

    @Test
    void invalidEmailTest(){
        Selenide.open("/text-box");
        $("[id=userEmail]").setValue("QA.GURU");
        $("#submit").click();
        $(".mr-sm-2.field-error.form-control").shouldBe(visible);
    }
}
