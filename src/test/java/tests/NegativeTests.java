package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static testdata.FormTestData.*;

public class NegativeTests extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();

        @Test
    void emptyMobileNumberTest(){
        registrationPage.openPage()
                .typeUserFirstName(firstName)
                .typeUserLastName(lastName)
                .setGenderContainer(gender)
                .submitForm();

        registrationPage.checkErrorFieldCondition(userNumberLocator);

    }

    @Test
    void emptyFirstNameAndLastNameTest(){
        registrationPage.openPage()
                .setGenderContainer(gender)
                .typeUserNumber(userNumber)
                .submitForm();

        registrationPage.checkErrorFieldCondition(firstNameLocator)
                .checkErrorFieldCondition(lastNameLocator);

    }

    @Test
    void invalidEmailTest(){
        registrationPage.openPage()
                .typeUserFirstName(firstName)
                .typeUserLastName(lastName)
                .typeUserEmail(invalidUserEmail)
                .setGenderContainer(gender)
                .typeUserNumber(userNumber)
                .submitForm();

        registrationPage.checkErrorFieldCondition(userEmailLocator);

    }
}
