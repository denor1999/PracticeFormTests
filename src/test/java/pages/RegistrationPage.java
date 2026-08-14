package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();

    public SelenideElement firstNameInput = $("[id=firstName]");
    public SelenideElement lastNameInput = $("[id=lastName]");
    public SelenideElement userEmailInput = $("[id=userEmail]");
    public SelenideElement genderContainer = $("[id=genterWrapper]");
    public SelenideElement userNumberInput = $("[id=userNumber]");
    public SelenideElement stateSelect = $("[id=react-select-3-input]");
    public SelenideElement citySelect = $("[id=react-select-4-input]");
    public SelenideElement subjectsInput = $("[id=subjectsInput]");
    public SelenideElement hobbiesInput = $("[id=hobbiesWrapper]");
    public SelenideElement pictureResource = $("[id=uploadPicture]");
    public SelenideElement userAddress = $("[id=currentAddress]");
    public SelenideElement submitButton = $("[id=submit]");
    public ElementsCollection tableOfResults = $$("table");

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage typeUserFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeUserLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeUserEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGenderContainer(String value){
        genderContainer.find(byText(value)).click();
        return this;
    }

    public RegistrationPage typeUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("[id=dateOfBirthInput]").click();
        calendar.setDateOfBirth(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.press(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesInput.find(byText(value)).click();
        return this;
    }

    public RegistrationPage setPicture(String value) {
        pictureResource.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage typeUserAddress (String value) {
        userAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateSelect.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String value) {
        citySelect.setValue(value).pressEnter();
        return this;
    }

    public void submitForm() {
        submitButton.click();
    }

    public RegistrationPage checkResults(String value) {
        tableOfResults.shouldHave(texts(value));
        return this;
    }

}
