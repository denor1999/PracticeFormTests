package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    private final SelenideElement userName = $("#userName");
    private final SelenideElement userEmail = $("#userEmail");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement result = $("#name");

    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage typeUserName(String value) {
        userName.setValue(value);
        return this;
    }

    public TextBoxPage typeUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public void submitForm() {
        submitButton.click();
    }

    public TextBoxPage checkResults(String value) {
        result.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkErrorFieldCondition(String value) {
        SelenideElement fieldCondition = $("[id=" + value + "]");
        fieldCondition.shouldHave(cssValue("border-color", "rgb(255, 0, 0)"));
        return this;
    }

}
