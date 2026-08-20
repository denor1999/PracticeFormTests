package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import testdata.FormTestData;

import static testdata.FormTestData.*;

public class NegativeTests extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();
    FormTestData userTest = new FormTestData();

    @Test
    void emptyMobileNumberTest(){
        registrationPage.openPage()
                .typeUserFirstName(userTest.firstName)
                .typeUserLastName(userTest.lastName)
                .setGenderContainer(userTest.setRandomGender())
                .submitForm();

        registrationPage.checkErrorFieldCondition(userNumberLocator);

    }

    @Test
    void emptyFirstNameAndLastNameTest(){
        registrationPage.openPage()
                .setGenderContainer(userTest.setRandomGender())
                .typeUserNumber(userTest.userNumber)
                .submitForm();

        registrationPage.checkErrorFieldCondition(firstNameLocator)
                .checkErrorFieldCondition(lastNameLocator);

    }

    @Test
    void invalidEmailTest(){
        registrationPage.openPage()
                .typeUserFirstName(userTest.firstName)
                .typeUserLastName(userTest.lastName)
                .typeUserEmail(userTest.invalidUserEmail)
                .setGenderContainer(userTest.setRandomGender())
                .typeUserNumber(userTest.userNumber)
                .submitForm();

        registrationPage.checkErrorFieldCondition(userEmailLocator);

    }
}
