package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import testdata.FormTestData;

public class SuccessfulEnterFormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    FormTestData userTest = new FormTestData();

    @Test
    void successEnterFormTest(){
        registrationPage.openPage()
                .typeUserFirstName(userTest.firstName)
                .typeUserLastName(userTest.lastName)
                .setGenderContainer(userTest.gender)
                .typeUserNumber(userTest.userNumber)
                .submitForm();

        registrationPage.checkResults(userTest.firstName + " " + userTest.lastName)
                .checkResults(userTest.gender)
                .checkResults(userTest.userNumber);

    }
}
