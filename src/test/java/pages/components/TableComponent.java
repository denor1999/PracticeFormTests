package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TableComponent {
    private final SelenideElement table = $(".table");

    public void checkResults(String value) {
        table.shouldHave(text(value));
    }
}
