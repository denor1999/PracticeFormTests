package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testdata.FormTestData.*;


public class StudentRegistrationFormTests extends TestBase {

    @Test
    void endToEndPositiveTest(){
        open("/automation-practice-form");
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(correctUserEmail);
        $("[id=genterWrapper]").find(byText("Male")).click();
        $("[id=userNumber]").setValue(userNumber);
        $("[id=dateOfBirthInput]").setValue("05 Jul 2026").pressEnter();

        //<div class="subjects-auto-complete__input-container css-19bb58m" data-value=""><input class="subjects-auto-complete__input" autocapitalize="none" autocomplete="off" autocorrect="off" id="subjectsInput" spellcheck="false" tabindex="0" aria-autocomplete="list" aria-expanded="false" aria-haspopup="true" role="combobox" aria-activedescendant="" aria-describedby="react-select-2-placeholder" type="text" value="" style="color: inherit; background: 0px center; opacity: 1; width: 100%; grid-area: 1 / 2; font: inherit; min-width: 2px; border: 0px; margin: 0px; outline: 0px; padding: 0px;"></div>
        $("[id=subjectsInput]").press(subjects[0]).pressEnter();
        $("[id=subjectsInput]").press(subjects[1]).pressEnter();

        $$("[id=hobbiesWrapper]").find(text("Sports")).click();
        $$("[id=hobbiesWrapper]").find(text("Music")).click();

        //<input label="Select picture" lang="en" id="uploadPicture" class="form-control" type="file">
        $("[id=uploadPicture]").uploadFromClasspath(picture);

        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=react-select-3-input]").setValue(state).pressEnter();
        $("[id=react-select-4-input]").setValue(city).pressEnter();

        //button "Submit"
        $("[id=submit]").click();

        $("table").shouldHave(text(firstName + " " + lastName));
        $("table").shouldHave(text(correctUserEmail));
        $("table").shouldHave(text("Male"));
        $("table").shouldHave(text(userNumber));
        $("table").shouldHave(text("05 July,2026"));
        $("table").shouldHave(text("Maths, English"));
        $("table").shouldHave(text("Sports, Music"));
        $("table").shouldHave(text(picture));
        $("table").shouldHave(text(currentAddress));
        $("table").shouldHave(text(state + city));

    }

}
