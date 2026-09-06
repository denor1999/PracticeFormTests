package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    private final SelenideElement userName = $("#userName");
    private final SelenideElement userEmail = $("#userEmail");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement result = $("#name");

    @Step("Open text box page")
    public TextBoxPage openPage() {
        open(System.getProperty("text_box_path", "/text-box"));
        return this;
    }

    @Step("Fill user name")
    public TextBoxPage typeUserName(String value) {
        userName.setValue(value);
        return this;
    }

    @Step("Fill user email")
    public TextBoxPage typeUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    @Step("Submit form")
    public void submitForm() {
        submitButton.click();
    }

    @Step("Check form results")
    public TextBoxPage checkResults(String value) {
        result.shouldHave(text(value));
        return this;
    }

    @Step("Check error field condition")
    public TextBoxPage checkErrorFieldCondition(String value) {
        SelenideElement fieldCondition = $("[id=" + value + "]");
        fieldCondition.shouldHave(cssValue("border-color", "rgb(255, 0, 0)"));
        return this;
    }

}
