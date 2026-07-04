import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class SimlpeFormTests {

    @BeforeAll
    static void startup(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void minimumFieldsEnterTest(){
        Selenide.open("https://demoqa.com/text-box");
        $("[id=userName]").setValue("Ivan");
        $("#submit").click();
    }

    @Test
    void invalidEmailTest(){
        Selenide.open("https://demoqa.com/text-box");
        $("[id=userEmail]").setValue("QA.GURU");
        $("#submit").click();
    }
}
