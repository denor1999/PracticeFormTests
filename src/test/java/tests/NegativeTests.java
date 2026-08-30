package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import testdata.FormTestData;

import static io.qameta.allure.Allure.step;
import static testdata.FormTestData.*;

@Feature("Registration form tests")
public class NegativeTests extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();
    FormTestData userTest = new FormTestData();

    @Test
    @Story("Empty mobile number")
    @Owner("denor1999")
    void emptyMobileNumberTest(){
        step("Open registration page", () -> {
            registrationPage.openPage();
        });

        step("Filling registration page", () -> {
            registrationPage.typeUserFirstName(userTest.firstName)
                    .typeUserLastName(userTest.lastName)
                    .setGenderContainer(userTest.setRandomGender());
        });

        step("Submit form", () -> {
                    registrationPage.submitForm();
        });

        step("Check field condition", () -> {
            registrationPage.checkErrorFieldCondition(userNumberLocator);
        });

    }

    @Test
    @Story("Empty user first name and last name")
    @Owner("denor1999")
    void emptyFirstNameAndLastNameTest(){
        step("Open registration page", () -> {
            registrationPage.openPage();
        });
        step("Filling registration form", () -> {
        registrationPage.setGenderContainer(userTest.setRandomGender())
                .typeUserNumber(userTest.userNumber);
        });

        step("Submit form", () -> {
            registrationPage.submitForm();
        });

        step("Check field condition", () -> {
            registrationPage.checkErrorFieldCondition(firstNameLocator)
                    .checkErrorFieldCondition(lastNameLocator);
        });

    }

    @Test
    @Story("Enter invalid user email")
    @Owner("denor1999")
    void invalidEmailTest(){
        step("Open registration page", () -> {
            registrationPage.openPage();
        });
        step("Filling registration form", () -> {
            registrationPage.typeUserFirstName(userTest.firstName)
                    .typeUserLastName(userTest.lastName)
                    .typeUserEmail(userTest.invalidUserEmail)
                    .setGenderContainer(userTest.setRandomGender())
                    .typeUserNumber(userTest.userNumber);
        });

        step("Submit form", () -> {
            registrationPage.submitForm();
        });

        step("Check field condition", () -> {
            registrationPage.checkErrorEmailCondition(userEmailLocator);
        });
    }
}
