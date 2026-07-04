import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class NegativeTests {

    @BeforeAll
    static void startup(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1240";
    }

    @Test
    void emptyEmailTest(){
        Selenide.open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Ivan");
        $("[id=lastName]").setValue("Ozhgikhin");
        $("input[id=userNumber]").setValue("1234567890");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("[id=submit]").shouldBe(visible).click();
    }

    @Test
    void emptyMobileNumberTest(){
        Selenide.open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Ivan");
        $("[id=lastName]").setValue("Ozhgikhin");
        $("input[id=gender-radio-1]").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("[id=submit]").shouldBe(visible).click();
    }

    @Test
    void emptyFirstNameAndLastNameTest(){
        Selenide.open("https://demoqa.com/automation-practice-form");
        $("input[id=gender-radio-1]").click();
        $("input[id=userNumber]").setValue("1234567890");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("[id=submit]").shouldBe(visible).click();
    }

    @Test
    void invalidEmailTest(){
        Selenide.open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Ivan");
        $("[id=lastName]").setValue("Ozhgikhin");
        $("[id=userEmail]").setValue("aweoif");
        $("input[id=gender-radio-1]").click();
        $("input[id=userNumber]").setValue("1234567890");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("[id=submit]").shouldBe(visible).click();
    }
}
