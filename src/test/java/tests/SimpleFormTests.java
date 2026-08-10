package tests;

import org.junit.jupiter.api.Test;

import static testdata.TextBoxTestData.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleFormTests extends TestBase{

    @Test
    void minimumFieldsEnterTest(){
        open("/text-box");
        $("#userName").setValue(userName);
        $("#submit").click();
        $("#name").shouldHave(text("Ivan"));
    }

    @Test
    void invalidEmailTest(){
        open("/text-box");
        $("#userEmail").setValue(invalidUserEmail);
        $("#submit").click();
        $(".mr-sm-2.field-error.form-control").shouldBe(visible);
    }

}
