package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static testdata.FormTestData.*;

public class SuccessfulEnterFormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successEnterFormTest(){
        registrationPage.openPage()
                .typeUserFirstName(firstName)
                .typeUserLastName(lastName)
                .setGenderContainer(gender)
                .typeUserNumber(userNumber)
                .submitForm();

        registrationPage.checkResults(firstName + " " + lastName)
                .checkResults(gender)
                .checkResults(userNumber);

    }
}
