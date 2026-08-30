package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static testdata.TextBoxTestData.userEmailLocator;

@Feature("Text box tests")
public class SimpleFormTests extends TestBase{

    @Test
    @Story("Enter form with minimum number of fields")
    @Owner("denor1999")
    void minimumFieldsEnterTest(){
        step("Open text box page", () -> {
            textBoxPage.openPage();
        });

        step("Filling form", () -> {
                textBoxPage.typeUserName(textBoxUserTest.userName);
        });

        step("Submit form", () -> {
                textBoxPage.submitForm();
        });

        step("Check registration results", () -> {
            textBoxPage.checkResults(textBoxUserTest.userName);
        });
    }

    @Test
    @Story("Enter form with invalid email")
    @Owner("denor1999")
    void invalidEmailTest(){
        step("Open text box page", () -> {
            textBoxPage.openPage();
        });

        step("Filling form", () -> {
            textBoxPage.typeUserEmail(textBoxUserTest.invalidUserEmail);
        });

        step("Submit form", () -> {
            textBoxPage.submitForm();
        });

        step("Check email field condition", () -> {
            textBoxPage.checkErrorFieldCondition(userEmailLocator);
        });
    }

}
