package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import testdata.FormTestData;

public class StudentRegistrationFormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    FormTestData userTest = new FormTestData();

    @Test
    void endToEndPositiveTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        registrationPage.openPage()
                .typeUserFirstName(userTest.firstName)
                .typeUserLastName(userTest.lastName)
                .typeUserEmail(userTest.correctUserEmail)
                .setGenderContainer(userTest.gender)
                .typeUserNumber(userTest.userNumber)
//                .setDateOfBirth(userTest.setRandomDateOfBirth())
                .setSubjects(userTest.selectedSubject)
                .setHobbies(userTest.selectedHobby)
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
                .checkResults(userTest.selectedSubject)
                .checkResults(userTest.selectedHobby)
                .checkResults(userTest.picture)
                .checkResults(userTest.currentAddress)
                .checkResults(userTest.state + " " + userTest.city);
    }

}
