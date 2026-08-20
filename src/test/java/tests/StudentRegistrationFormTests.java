package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import testdata.FormTestData;

public class StudentRegistrationFormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    FormTestData userTest = new FormTestData();

    @Test
    void endToEndPositiveTest(){
        registrationPage.openPage()
                .typeUserFirstName(userTest.firstName)
                .typeUserLastName(userTest.lastName)
                .typeUserEmail(userTest.correctUserEmail)
                .setGenderContainer(userTest.gender)
                .typeUserNumber(userTest.userNumber)
//                .setDateOfBirth(userTest.setRandomDateOfBirth())
                .setSubjects(userTest.randomSubject)
                .setSubjects(userTest.randomSubject)
                .setHobbies(userTest.randomHobby)
                .setPicture(userTest.picture)
                .typeUserAddress(userTest.currentAddress)
                .setState(userTest.setRandomState())
                .setCity(userTest.setRandomCity())
                .submitForm();

        registrationPage.checkResults(userTest.firstName + " " + userTest.lastName)
                .checkResults(userTest.correctUserEmail)
                .checkResults(userTest.gender)
                .checkResults(userTest.userNumber)
//                .checkResults(userTest.dateOfBirth[0] + " " + userTest.dateOfBirth[1] + "," + userTest.dateOfBirth[2])
                .checkResults(userTest.randomSubject)
                .checkResults(userTest.randomHobby)
                .checkResults(userTest.picture)
                .checkResults(userTest.currentAddress)
                .checkResults(userTest.state + " " + userTest.city);
    }

}
