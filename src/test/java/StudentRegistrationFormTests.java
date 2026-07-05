import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class StudentRegistrationFormTests {

    @BeforeAll
    static void setup(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void endToEndPositiveTest(){
        Selenide.open("/automation-practice-form");
        $("[id=firstName]").setValue("Ivan");
        $("[id=lastName]").setValue("Ozhgikhin");
        $("[id=userEmail]").setValue("aweoif@aioevn.erg");
        $("[value=Male]").click();
        $("input[id=userNumber]").setValue("1234567890");
        $("#dateOfBirthInput").setValue("05 Jul 2026").pressEnter();

        //<div class="subjects-auto-complete__input-container css-19bb58m" data-value=""><input class="subjects-auto-complete__input" autocapitalize="none" autocomplete="off" autocorrect="off" id="subjectsInput" spellcheck="false" tabindex="0" aria-autocomplete="list" aria-expanded="false" aria-haspopup="true" role="combobox" aria-activedescendant="" aria-describedby="react-select-2-placeholder" type="text" value="" style="color: inherit; background: 0px center; opacity: 1; width: 100%; grid-area: 1 / 2; font: inherit; min-width: 2px; border: 0px; margin: 0px; outline: 0px; padding: 0px;"></div>
        $("#subjectsInput").press("m").pressEnter();
        $("#subjectsInput").press("s").pressEnter();

        $("[id=hobbiesWrapper]").find(byText("Sports")).click();
        $("[id=hobbiesWrapper]").find(byText("Music")).click();

        //<input label="Select picture" lang="en" id="uploadPicture" class="form-control" type="file">
        $("#uploadPicture").uploadFromClasspath("picture.jpg");

        $("[id=currentAddress]").setValue("ehujimkpkjihuygtf");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        //button "Submit"
        $("[id=submit]").click();
        $("table").shouldHave(text("Ivan Ozhgikhin"));
        $("table").shouldHave(text("aweoif@aioevn.erg"));
        $("table").shouldHave(text("Male"));
        $("table").shouldHave(text("1234567890"));
        $("table").shouldHave(text("05 July,2026"));
        $("table").shouldHave(text("Maths, English"));
        $("table").shouldHave(text("Sports, Music"));
        $("table").shouldHave(text("picture.jpg"));
        $("table").shouldHave(text("ehujimkpkjihuygtf"));
        $("table").shouldHave(text("NCR Delhi"));

    }

}
