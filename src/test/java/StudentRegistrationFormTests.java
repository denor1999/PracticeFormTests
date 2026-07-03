import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$;


public class StudentRegistrationFormTests {

    @BeforeAll
    static void startup(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void endToEndPositiveTest(){
        Selenide.open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Ivan");
        $("[id=lastName]").setValue("Ozhgikhin");
        $("[id=userEmail]").setValue("aweoif@aioevn.erg");
        $("[value=Male]").click();
        $("input[id=userNumber]").setValue("1234567890");

        //<div class="subjects-auto-complete__input-container css-19bb58m" data-value=""><input class="subjects-auto-complete__input" autocapitalize="none" autocomplete="off" autocorrect="off" id="subjectsInput" spellcheck="false" tabindex="0" aria-autocomplete="list" aria-expanded="false" aria-haspopup="true" role="combobox" aria-activedescendant="" aria-describedby="react-select-2-placeholder" type="text" value="" style="color: inherit; background: 0px center; opacity: 1; width: 100%; grid-area: 1 / 2; font: inherit; min-width: 2px; border: 0px; margin: 0px; outline: 0px; padding: 0px;"></div>
        $("#subjectsInput").setValue("QA automation");

        $("[id=hobbies-checkbox-1]").click();
        $("[id=hobbies-checkbox-3]").click();

        //<input label="Select picture" lang="en" id="uploadPicture" class="form-control" type="file">
        $("[type=file]").setValue("C:/Users/ozhgi/Desktop/Обои и другое Ксюше/Обои 1.jpg");

        $("[id=currentAddress]").setValue("ehujimkpkjihuygtf");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        //button
        $("[id=submit]").click();
    }
}
