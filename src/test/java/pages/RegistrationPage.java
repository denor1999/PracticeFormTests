package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    TableComponent tableOfResults = new TableComponent();

    private final SelenideElement firstNameInput = $("[id=firstName]");
    private final SelenideElement lastNameInput = $("[id=lastName]");
    private final SelenideElement userEmailInput = $("[id=userEmail]");
    private final SelenideElement genderContainer = $("[id=genterWrapper]");
    private final SelenideElement userNumberInput = $("[id=userNumber]");
    private final SelenideElement dateOfBirthInput = $("[id=dateOfBirthInput]");
    private final SelenideElement stateSelect = $("[id=react-select-3-input]");
    private final SelenideElement citySelect = $("[id=react-select-4-input]");
    private final SelenideElement subjectsInput = $("[id=subjectsInput]");
    private final SelenideElement hobbiesInput = $("[id=hobbiesWrapper");
    private final SelenideElement pictureResource = $("[id=uploadPicture]");
    private final SelenideElement userAddress = $("[id=currentAddress]");
    private final SelenideElement submitButton = $("[id=submit]");

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

    public RegistrationPage setDateOfBirth(String[] values) {
        dateOfBirthInput.click();
        calendar.setDateOfBirth(values[0], values[1], values[2]);
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
        submitButton.scrollTo().click();
    }

    public RegistrationPage checkResults(String value) {
        tableOfResults.checkResults(value);
        return this;
    }

    public RegistrationPage checkErrorFieldCondition(String value) {
        SelenideElement fieldCondition = $("[id=" + value + "]");
        fieldCondition.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

}
