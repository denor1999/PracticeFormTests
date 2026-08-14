package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static testdata.FormTestData.*;


public class StudentRegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void endToEndPositiveTest(){
        registrationPage.openPage()
                .typeUserFirstName(firstName)
                .typeUserLastName(lastName)
                .typeUserEmail(correctUserEmail)
                .setGenderContainer(gender)
                .typeUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects[0])
                .setSubjects(subjects[1])
                .setHobbies(hobbies[0])
                .setHobbies(hobbies[1])
                .setPicture(picture)
                .typeUserAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submitForm();

        registrationPage.checkResults(firstName + " " + lastName)
                .checkResults(correctUserEmail)
                .checkResults(gender)
                .checkResults(userNumber)
                .checkResults(dateOfBirth)
                .checkResults(subjects[0] + ", " + subjects[1])
                .checkResults(hobbies[0] + ", " + hobbies[1])
                .checkResults(picture)
                .checkResults(currentAddress)
                .checkResults(state + " " + city);
    }

}
