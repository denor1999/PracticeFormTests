package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Feature("Registration form tests")
public class SuccessfulEnterFormTests extends TestBase {

    @Test
    @Story("Enter form with a minimum number of fields")
    @Owner("denor1999")
    void successEnterFormTest(){

        step("Open registration page", () -> {
            registrationPage.openPage();
        });

        step("Filling registration form", () -> {
            registrationPage.typeUserFirstName(userTest.firstName)
                    .typeUserLastName(userTest.lastName)
                    .setGenderContainer(userTest.gender)
                    .typeUserNumber(userTest.userNumber);
        });

        step("Submit form", () -> {
            registrationPage.submitForm();
        });

        step("Check registration form results", () -> {
            registrationPage.checkResults(userTest.firstName + " " + userTest.lastName)
                    .checkResults(userTest.gender)
                    .checkResults(userTest.userNumber);
        });

    }
}
